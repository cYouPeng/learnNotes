var app = angular.module("app",["SeviceModule"]);
app.controller("FirstCtrl",["$scope","$location","FirstTitleService",function($scope,$location,FirstTitleService){
	
	FirstTitleService.selectFirstTitleAll().success(function(data,status){
		$scope.ftList = data;
	});
	
}]);
