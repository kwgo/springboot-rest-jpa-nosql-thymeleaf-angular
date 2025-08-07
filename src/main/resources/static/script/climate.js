angular
    .module('app', [])
    .controller('ctrl', function ($scope, $http, $window) {
    	$scope.floor = $window.Math.floor;
 		$scope.pageSize = "10";

 		$scope.queryList = function(fromDate=null, toDate=null, pageIndex=0, pageSize=0) {
			$http({
				method: "post",
				params: {"fromDate":fromDate, "toDate":toDate, "pageIndex": pageIndex, "pageSize":pageSize},
				url: "/climate/list"
      		}).then(
      			function successCallback(response) {
					console.log(response.data); 
					$scope.errors = response.data.errors;
					$scope.navigator = response.data.page;
					$scope.climateList = response.data.page.content;
					$scope.listView = true;
				},
				function errorCallback(response) {
				 	console.log(response); 
 				}
 			);
		};
		 		
 		$scope.goDateRange = function(pageIndex=0, pageSize=0) {
			$scope.errorFromDate = false;
			$scope.errorToDate = false;
 			var fromDate = null;
 			var toDate = null;
 			if($scope.fromMonth || $scope.fromDay || $scope.fromYear) {
 				fromDate = $scope.fromMonth + "/" + $scope.fromDay + "/" + $scope.fromYear;
				$scope.errorFromDate = fromDate.length != 10 || !Date.parse(fromDate);
			}
 			if($scope.toMonth || $scope.toDay || $scope.toYear) {
				toDate = $scope.toMonth + "/" + $scope.toDay + "/" + $scope.toYear;
				$scope.errorToDate = toDate.length != 10 || !Date.parse(toDate);
			}
			if($scope.errorFromDate || $scope.errorToDate) {
				return;
			}
			$scope.queryList(fromDate, toDate, pageIndex, pageSize);
		};
		$scope.queryList(null, null, 0, $scope.pageSize);
		
		$scope.getDetail = function(name) {
			$http({
				method: "post",
				params: {"stationName":name},
				url: "/climate/detail"
      		}).then(
      			function successCallback(response) {
					console.log(response.data); 
					$scope.climateDetail = response.data;
					$scope.detailView = true;
					$scope.listView = false;
					$scope.filterView = false;
				},
				function errorCallback(response) {
				 	console.log(response); 
 				}
 			);
		};
		
		$scope.goReset = function() {
 			$scope.fromMonth = "";
 			$scope.fromDay = "";
 			$scope.fromYear = "";
 			$scope.toMonth = "";
 			$scope.toDay = "";
 			$scope.toYear = "";
			$scope.errorFromDate = false;
			$scope.errorToDate = false;
			$scope.errors.errorFromDate = false;
			$scope.errors.errorToDate = false;
			$scope.errors.errorCompareDate = false;
		}

		$scope.goBack = function() {
			$scope.detailView = false;
			$scope.listView = true;
			$scope.filterView = true;
		}

		$scope.goHome = function() {
			$scope.filterView = true;
			$scope.listView = false;
			$scope.detailView = false;
		}
	}	
);
