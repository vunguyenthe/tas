'use strict';

/* Services */

var AppServices = angular.module('AngularSpringApp.services', []);


AppServices.value('version', '0.1');

AppServices.service('fileUpload', function ($http) {
    this.uploadFileToUrl = function(file){
    	alert('uploadFileToUrl -> ' + uploadUrl);
    	var formData = new FormData();

		formData.append( "fileUpload", image );

		return $http.post( "image/upload", formData, {
			transformRequest: angular.identity,
			headers: { "Content-Type": undefined }
		})
    
       .success(function(){
    	   alert('success');
       })
    
       .error(function(){
    	   alert('failed');
       });
    }
 });