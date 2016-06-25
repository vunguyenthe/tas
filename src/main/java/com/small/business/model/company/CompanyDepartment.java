package com.small.business.model.company;

public class CompanyDepartment {

    protected Long id = 0L;

    private Long companyId = 0L;
    private String name;
    private Long headId = 0L;
    private String headName;
    private Long locationId = 0L;
    private String locationName;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {

        this.companyId = companyId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getHeadId() {

        return headId;
    }

    public void setHeadId(Long headId) {

        this.headId = headId;
    }

    public String getHeadName() {

        return headName;
    }

    public void setHeadName(String headName) {

        this.headName = headName;
    }

    public Long getLocationId() {

        return locationId;
    }

    public void setLocationId(Long locationId) {

        this.locationId = locationId;
    }

    public String getLocationName() {

        return locationName;
    }

    public void setLocationName(String locationName) {

        this.locationName = locationName;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
        result = prime * result + ((headId == null) ? 0 : headId.hashCode());
        result = prime * result + ((headName == null) ? 0 : headName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
        result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CompanyDepartment other = (CompanyDepartment) obj;
        if (companyId == null) {
            if (other.companyId != null)
                return false;
        } else if (!companyId.equals(other.companyId))
            return false;
        if (headId == null) {
            if (other.headId != null)
                return false;
        } else if (!headId.equals(other.headId))
            return false;
        if (headName == null) {
            if (other.headName != null)
                return false;
        } else if (!headName.equals(other.headName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (locationId == null) {
            if (other.locationId != null)
                return false;
        } else if (!locationId.equals(other.locationId))
            return false;
        if (locationName == null) {
            if (other.locationName != null)
                return false;
        } else if (!locationName.equals(other.locationName))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "CompanyDepartment [id=" + id + ", companyId=" + companyId + ", name=" + name + ", headId=" + headId + ", headName=" + headName + ", locationId=" + locationId
                + ", locationName=" + locationName + "]";
    }

}
