var seviceModule = angular.module("SeviceModule",[]);

seviceModule.service("FirstTitleService",["$http",function($http){
	
	var selectFirstTitleAll = function(){
		//alert(123);
		return $http({
            url: "ft/selectFirstTitleAll.do",
            method: "post"
        });
	}
	
	return {
		selectFirstTitleAll:function(){
			return selectFirstTitleAll();
		}
	}
}]);
