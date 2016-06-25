package com.small.business.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.small.business.model.people.CurrentBenefit;
import com.small.business.model.people.CurrentPackage;
import com.small.business.model.people.People;
import com.small.business.model.people.PeopleAssignment;
import com.small.business.model.people.PeopleDetail;
import com.small.business.model.people.PeopleDocument;
import com.small.business.model.people.PeopleEducation;
import com.small.business.model.people.PeopleHistory;
import com.small.business.model.people.PeopleJournal;
import com.small.business.model.people.PeopleNotepad;
import com.small.business.model.people.PeopleTag;
import com.small.business.service.people.CurrentBenefitService;
import com.small.business.service.people.CurrentPackageService;
import com.small.business.service.people.PeopleAssignmentService;
import com.small.business.service.people.PeopleDetailService;
import com.small.business.service.people.PeopleDocumentService;
import com.small.business.service.people.PeopleEducationService;
import com.small.business.service.people.PeopleHistoryService;
import com.small.business.service.people.PeopleJournalService;
import com.small.business.service.people.PeopleNotepadService;
import com.small.business.service.people.PeopleService;
import com.small.business.service.people.PeopleTagService;

@Controller
@RequestMapping("/api")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;
    @Autowired
    private PeopleDocumentService peopleDocumentService;

    @Autowired
    private PeopleAssignmentService peopleAssignmentService;

    @Autowired
    private PeopleHistoryService peopleHistoryService;

    @Autowired
    private PeopleEducationService peopleEducationService;

    @Autowired
    private PeopleJournalService peopleJournalService;

    @Autowired
    private PeopleDetailService peopleDetailService;

    @Autowired
    private CurrentPackageService currentPackageService;

    @Autowired
    private CurrentBenefitService currentBenefitService;

    @Autowired
    private PeopleTagService peopleTagService;

    @Autowired
    private PeopleNotepadService peopleNotepadService;

    @RequestMapping(value = "/people/{peopleId}", method = RequestMethod.GET)
    public @ResponseBody People getPeople(@PathVariable long peopleId) {

        People people = peopleService.getPeopleById(peopleId);
        if (people.getId() > 0) {
            List<PeopleJournal> listPeopleJournal = peopleJournalService.getPeopleJournalByPeopleId(peopleId);
            List<PeopleHistory> listPeopleHistory = peopleHistoryService.getPeopleHistoryByPeopleId(peopleId);
            List<PeopleEducation> listPeopleEducation = peopleEducationService.getPeopleEducationByPeopleId(peopleId);
            List<PeopleAssignment> listPeopleAssignment = peopleAssignmentService.getPeopleAssignmentByPeopleId(peopleId);
            List<PeopleDocument> listPeopleDocument = peopleDocumentService.getPeopleDocumentByPeopleId(peopleId);
            PeopleDetail peopleDetail = peopleDetailService.getPeopleDetailByPeopleId(peopleId);
            PeopleNotepad peopleNotepad = peopleNotepadService.getListPeopleNotepadByPeopleId(peopleId);
            PeopleTag peopleTag = peopleTagService.getPeopleTagByPeopleId(peopleId);
            Long localPeopleId = peopleDetail.getPeopleId();
            if (localPeopleId > 0) {
                List<CurrentPackage> listCurrentPackage = currentPackageService.getCurrentPackageByPeopleId(peopleId);
                List<CurrentBenefit> listCurrentBenefit = currentBenefitService.getCurrentBenefitByPeopleId(peopleId);
                peopleDetail.setCurrentBenefit(listCurrentBenefit);
                peopleDetail.setCurrentPackage(listCurrentPackage);
            }
            people.setJournal(listPeopleJournal);
            people.setHistory(listPeopleHistory);
            people.setEducation(listPeopleEducation);
            people.setAssignment(listPeopleAssignment);
            people.setDocument(listPeopleDocument);
            people.setPeopleDetail(peopleDetail);
            people.setPeopleTag(peopleTag);
            people.setPeopleNotepad(peopleNotepad);
        }
        return people;
    }

    @RequestMapping(value = "/candidate", method = RequestMethod.GET)
    public @ResponseBody List<People> getCandidateList() {

        return peopleService.getAllCandidate();
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public @ResponseBody List<People> getClienList() {

        return peopleService.getAllClient();
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public @ResponseBody List<People> getPeopleList() {

        return peopleService.getAllPeople();
    }

    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @RequestMapping(value = "/uploaddoc", method = RequestMethod.POST)
    public @ResponseBody JSONObject uploaddoc(@RequestParam("file") MultipartFile file, HttpServletRequest request, @RequestParam("peopleId") Long peopleId)
            throws IOException {

        String pathUpDir = request.getSession().getServletContext()
                .getRealPath("/")
                + "resources/docs/";
        String peopleDocId = "";
        if (!file.isEmpty()) {
            if (peopleId == 0) {
                peopleId = peopleService.getNextPeopleId();
            }
            String targetFile = pathUpDir + "doc_" + peopleId + "_" + file.getOriginalFilename();
            boolean ret = peopleService.uploadFilePostMethod(file, targetFile);
            if (ret) {
                peopleDocId = "doc_" + peopleId + "_" + file.getOriginalFilename();
            }
        }
        System.out.println(String.format("receive %s", "resources/docs/" + file.getOriginalFilename()));
        System.out.println("peopleDocId: " + peopleDocId);
        JSONObject obj = new JSONObject();
        obj.put("docId", peopleDocId);
        return obj;

    }

    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody JSONObject upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, @RequestParam("peopleId") Long peopleId)
            throws IOException {

        String pathUpDir = request.getSession().getServletContext()
                .getRealPath("/")
                + "resources/images/";
        String peopleImageId = "";
        if (!file.isEmpty()) {
            if (peopleId == 0) {
                peopleId = peopleService.getNextPeopleId();
            }
            String targetFile = pathUpDir + "people_" + peopleId + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            boolean ret = peopleService.uploadFilePostMethod(file, targetFile);
            if (ret) {
                peopleImageId = "people_" + peopleId + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            }
        }
        System.out.println(String.format("receive %s", "resources/images/" + file.getOriginalFilename()));
        System.out.println("peopleImageId: " + peopleImageId);

        JSONObject obj = new JSONObject();
        obj.put("imageId", peopleImageId);
        return obj;

    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public @ResponseBody boolean addPeople(@RequestBody People people) {

        boolean ret = false;
        if (people.getFullName() == "" || people.getJobTitle() == "" ||
                people.getMobilePhone() == "")
            return ret;

        ret = peopleService.addPeople(people);
        if (ret) {
            Long peopleId = peopleService.getNextPeopleId();

            List<PeopleHistory> listPeopleHistory = people.getHistory();
            if (listPeopleHistory.size() > 0) {
                for (PeopleHistory obj : listPeopleHistory) {
                    if (obj.getId() == 0L || obj.getPeopleId() != peopleId) {
                        if (obj.getCompanyName() != null)
                            obj.setPeopleId(peopleId);
                    }
                }
                ret = peopleHistoryService.addListPeopleHistory(listPeopleHistory);
            }
            List<PeopleEducation> listPeopleEducation = people.getEducation();
            if (listPeopleEducation.size() > 0) {
                for (PeopleEducation obj : listPeopleEducation) {
                    if (obj.getId() == 0L || obj.getPeopleId() != peopleId) {
                        obj.setPeopleId(peopleId);
                    }
                }
                ret &= peopleEducationService.addListPeopleEducation(listPeopleEducation);
            }
            List<PeopleAssignment> listPeopleAssignment = people.getAssignment();
            if (listPeopleAssignment.size() > 0) {
                for (PeopleAssignment obj : listPeopleAssignment) {
                    if (obj.getId() == 0L || obj.getPeopleId() != peopleId) {
                        obj.setPeopleId(peopleId);
                    }
                }
                ret &= peopleAssignmentService.addListPeopleAssignment(listPeopleAssignment);
            }
            List<PeopleJournal> listPeopleJournal = people.getJournal();
            if (listPeopleJournal.size() > 0) {
                for (PeopleJournal obj : listPeopleJournal) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                    }
                }
                ret &= peopleJournalService.addListPeopleJournal(listPeopleJournal);
            }
            List<PeopleDocument> listPeopleDocument = people.getDocument();
            if (listPeopleDocument.size() > 0) {
                for (PeopleDocument obj : listPeopleDocument) {
                    if (obj.getId() == 0L || obj.getPeopleId() != peopleId) {
                        obj.setPeopleId(peopleId);
                    }
                }
                ret &= peopleDocumentService.addListPeopleDocument(listPeopleDocument);
            }

            PeopleDetail peopleDetail = people.getPeopleDetail();

            if (peopleDetail.getId() == 0L || peopleDetail.getPeopleId() != peopleId) {
                peopleDetail.setPeopleId(peopleId);
                peopleDetailService.addPeopleDetail(peopleDetail);
            }

            PeopleTag peopleTag = people.getPeopleTag();

            if (peopleTag.getId() == 0L || peopleTag.getPeopleId() != peopleId) {
                peopleTag.setPeopleId(peopleId);
                peopleTagService.addPeopleTag(peopleTag);
            }

            PeopleNotepad peopleNotepad = people.getPeopleNotepad();

            if (peopleNotepad.getId() == 0L || peopleNotepad.getPeopleId() != peopleId) {
                peopleNotepad.setPeopleId(peopleId);
                peopleNotepadService.addPeopleNotepad(peopleNotepad);
            }

            List<CurrentPackage> listCurrentPackage = peopleDetail.getCurrentPackage();
            if (listCurrentPackage.size() > 0) {
                for (CurrentPackage obj : listCurrentPackage) {
                    if (obj.getId() == 0L || obj.getPeopleId() != peopleId) {
                        if (obj.getPackageName() != null)
                            obj.setPeopleId(peopleId);
                    }
                }
                ret &= currentPackageService.addListCurrentPackage(listCurrentPackage);
            }
            List<CurrentBenefit> listCurrentBenefit = peopleDetail.getCurrentBenefit();
            if (listCurrentBenefit.size() > 0) {
                for (CurrentBenefit obj : listCurrentBenefit) {
                    if (obj.getId() == 0L || obj.getPeopleId() != peopleId) {
                        if (obj.getBenefit() != null)
                            obj.setPeopleId(peopleId);
                    }
                }
                ret &= currentBenefitService.addListCurrentBenefit(listCurrentBenefit);
            }

        }
        return ret;
    }

    @RequestMapping(value = "/people", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePeople(@RequestBody People people) {

        boolean ret = true;
        Long peopleId = people.getId();
        if (peopleId > 0) {
            List<PeopleHistory> listPeopleHistory = people.getHistory();
            if (listPeopleHistory.size() > 0) {
                for (PeopleHistory obj : listPeopleHistory) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret = peopleHistoryService.addPeopleHistory(obj);
                    } else {
                        ret &= peopleHistoryService.updatePeopleHistory(obj);
                    }
                }
            }
            List<PeopleEducation> listPeopleEducation = people.getEducation();
            if (listPeopleEducation.size() > 0) {
                for (PeopleEducation obj : listPeopleEducation) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret &= peopleEducationService.addPeopleEducation(obj);
                    } else {
                        ret &= peopleEducationService.updatePeopleEducation(obj);
                    }
                }
            }
            List<PeopleAssignment> listPeopleAssignment = people.getAssignment();
            if (listPeopleEducation.size() > 0) {
                for (PeopleAssignment obj : listPeopleAssignment) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret &= peopleAssignmentService.updatePeopleAssignment(obj);
                    } else
                        ret &= peopleAssignmentService.addPeopleAssignment(obj);
                }
            }
            List<PeopleJournal> listPeopleJournal = people.getJournal();
            if (listPeopleJournal.size() > 0) {
                for (PeopleJournal obj : listPeopleJournal) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret &= peopleJournalService.addPeopleJournal(obj);
                    } else {
                        ret &= peopleJournalService.updatePeopleJournal(obj);
                    }
                }
            }
            List<PeopleDocument> listPeopleDocument = people.getDocument();
            if (listPeopleDocument.size() > 0) {
                for (PeopleDocument obj : listPeopleDocument) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret &= peopleDocumentService.addPeopleDocument(obj);

                    } else {
                        ret &= peopleDocumentService.updatePeopleDocument(obj);
                    }

                }

            }

            PeopleDetail peopleDetail = people.getPeopleDetail();

            List<CurrentPackage> listCurrentPackage = peopleDetail.getCurrentPackage();
            if (listCurrentPackage.size() > 0) {
                for (CurrentPackage obj : listCurrentPackage) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret &= currentPackageService.addCurrentPackage(obj);

                    } else {
                        ret &= currentPackageService.updateCurrentPackage(obj);
                    }

                }

            }

            List<CurrentBenefit> listCurrentBenefit = peopleDetail.getCurrentBenefit();
            if (listCurrentPackage.size() > 0) {
                for (CurrentBenefit obj : listCurrentBenefit) {
                    if (obj.getId() == 0L) {
                        obj.setPeopleId(peopleId);
                        ret &= currentBenefitService.addCurrentBenefit(obj);

                    } else {
                        ret &= currentBenefitService.updateCurrentBenefit(obj);
                    }

                }

            }

            ret &= peopleDetailService.updatePeopleDetail(peopleDetail);

            PeopleNotepad peopleNotepad = people.getPeopleNotepad();
            ret &= peopleNotepadService.updatePeopleNotepad(peopleNotepad);

            PeopleTag peopleTag = people.getPeopleTag();
            ret &= peopleTagService.updatePeopleTag(peopleTag);

            ret &= peopleService.updatePeople(people);
        }
        return ret;
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePeople(@PathVariable("id") Long id) {

        return peopleService.deletePeopleById(id);
    }

    @RequestMapping(value = "/removeAllPeople", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPeople() {

        return peopleService.deleteAll();
    }
}
