'use strict';

/* Directives */

var AppDirectives = angular.module('AngularSpringApp.directives', []);

AppDirectives.directive('appVersion', ['version', function (version) {
    return function (scope, elm, attrs) {
        elm.text(version);
    };
}]);


AppDirectives.directive( "fileModel", function( $parse ) {
	return {
		restrict: "A",
		link: function( scope, element, attrs ) {

			var model = $parse( attrs.fileModel );

			element.bind( "change", function() {
				scope.$apply( function() {
					model.assign( scope, element[ 0 ].files[ 0 ] );
				});
			});

		}
	}
});