'use strict';

/**
 * PeopleController
 * @constructor
 */
var PeopleController = function($scope, $http, fileUpload) {
	
    $scope.people = {};
    $scope.editMode = false;

    $scope.fetchpeoplesList = function() {
        $http.get('peoples/peopleList.json').success(function(peopleList){
            $scope.peoples = peopleList;
        });
    };

    $scope.uploadFile = function(){
    	alert('uploadFile -> ' + $scope.myFile);
        var file = $scope.myFile;
        
        console.log('file is ' );
        console.dir(file);
        
        var uploadUrl = "/uploadFile";
        
        alert('uploadFile -> 2' + $scope.myFile);
        
        fileUpload.uploadFileToUrl(file);
        
        alert('uploadFile -> 3' + $scope.myFile);
        
     };
    
    $scope.addNewpeople = function(people) {
    	//alert("add people" + people);
    	$scope.resetError();
        $http.post('peoples/addPeople', people).success(function() {
        	//alert( $scope.people.cv);
            $scope.fetchpeoplesList();
            $scope.people.name = '';
            $scope.people.email = '';
            $scope.people.phone = '';
            $scope.people.address = '';
            $scope.people.skype = '';
            $scope.people.cv = '';
        }).error(function() {
            $scope.setError('Could not add a new people');
        });
    };
    
    $scope.updatePeople = function(people) {
        $scope.resetError();
     	//alert("updatePeople" + people);
        $http.put('peoples/updatePeople', people).success(function() {
        	/*$scope.people.name = '';
            $scope.people.email = '';
            $scope.people.phone = '';
            $scope.people.address = '';
            $scope.people.skype = '';
            $scope.people.cv = '';*/
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the people');
        });
    };

    $scope.editPeople = function(people) {
        $scope.resetError();
        $scope.people = people;
        $scope.editMode = true;
    };

    $scope.resetPeopleForm = function() {
        $scope.resetError();
        $scope.people = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchpeoplesList();

    $scope.predicate = 'id';
};