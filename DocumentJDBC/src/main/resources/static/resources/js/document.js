var app = angular.module('myApp', []);
		app.controller('myCtrl', function($scope, $http) {
			$scope.documents;
			// Get Documents buton
			$scope.flagDocs = true;
			$scope.hideDocs = false;
			$scope.flag = false;
			// Modal save flag
			$scope.flagModalSave = false;
			$scope.user;
			$scope.errorUser;
			$scope.successUser;
			$scope.clickDocs = function(){
				$scope.successUser = "";
				if($scope.flag){
					$scope.flag = !$scope.flag;
				}
				if($scope.flagDocs){
					$scope.getDocs();
					$scope.flagDocs = !$scope.flagDocs;
					$scope.hideDocs = !$scope.hideDocs;
				} else {
					if($scope.flag){
						$scope.flag = !$scope.flag;
					}
					$scope.hideDocs = !$scope.hideDocs;
					$scope.flagDocs = !$scope.flagDocs;
				}
			}
			$scope.getDocs = function() {
					$http.get("/document").then(function(response) {
						$scope.documents = response.data;
						$scope.groupToPages();
						$scope.user.name = "";
						$scope.user.password = "";
					});
			}
			$scope.selectDocument;
			$scope.update = function(document) {
				$scope.successUser = "";
				$http({
					method : 'POST',
					url : "/document",
					data : document,
					headers : {
						'Content-Type' : 'application/json'
					}
				}).success(function(data) {
					$scope.getDocs();
					$scope.document.name = "";
					$scope.document.createdOn = "";
				}).error(function(status, statusText) {
					alert(statusText);
				})
			}
			
			$scope.form = function(document) {
				$scope.successUser = "";
				$scope.selectDocument = document;
			}
			$scope.update2 = function(document) {
				$scope.successUser = "";
				$http({
					method : 'PUT',
					url : "/document/" + $scope.selectDocument.id,
					data : document,
					headers : {
						'Content-Type' : 'application/json'
					}
				}).success(function(data) {
					$scope.getDocs();
				}).error(function(status, statusText) {
					alert("Error");
				})
			}
			$scope.findDocument;
			$scope.find = function(id) {
				$scope.successUser = "";
				$scope.findDocument = [];
				$scope.flag = !$scope.flag;
				$http.get("/document/" + id).then(function(response) {
					if($scope.flagModalSave === true){
						$scope.flagModalSave =! $scope.flagModalSave;
					}
					$scope.id = "";
					$scope.findDocument = response.data;
				}, function (response) {
					if($scope.flagModalSave === false){
						$scope.flagModalSave = !$scope.flagModalSave;
					}
					$scope.id = "";
				});
			}
			$scope.delete = function(document) {
				$http.delete("/document/" + document.id).then(function(response) {
					$scope.getDocs();
				});
			}
		
			$scope.register = function(user){
				$scope.successUser = "";
				$scope.errorUser = "";
				alert($scope.user);
				$http({
					method : 'post',
					url : "/register",
					data : user,
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(function(response) {
					$scope.getDocs();
					$scope.user.name = "";
					$scope.user.password = "";
					$scope.successUser = response.data.name;
				},function(response) {
					$scope.errorUser = "Incorrect username or password";
				});
			};
			var rangeAge = [];
			for(var i = 18 ; i < 25 ; i++) {
				rangeAge.push(i);
			}
			$scope.rangeAge = rangeAge;
		
		
			// pagination
		    $scope.groupedItems = [];
		    $scope.itemsPerPage = 5;
		    $scope.pagedItems = [];
		    $scope.currentPage = 0;
			
			$scope.groupToPages = function(){
	        	$scope.pagedItems = [];
	        	for (var i = 0; i < $scope.documents.length; i++) {
	            	if (i % $scope.itemsPerPage === 0) {
	                	$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.documents[i] ];
	           		 } else {
	                	$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.documents[i]);
	            	}
	        	}
	    	};
	    	$scope.range = function (start, end) {
	            var ret = [];
	            if (!end) {
	                end = start;
	                start = 0;
	            }
	            for (var i = start; i < end; i++) {
	                ret.push(i);
	            }
	            return ret;
	        };
	        
	        $scope.prevPage = function () {
	            if ($scope.currentPage > 0) {
	                $scope.currentPage--;
	            }
	        };
	        
	        $scope.nextPage = function () {
	            if ($scope.currentPage < $scope.pagedItems.length - 1) {
	                $scope.currentPage++;
	            }
	        };
	        
	        $scope.setPage = function () {
	            $scope.currentPage = this.n;
	        };});