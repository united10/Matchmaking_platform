var app = angular.module('add-row', []);
app.controller('mainCtrl', function ($scope) {
    console.log("hello");
    $scope.columns = [{ colId: 'col1', qualification: 'b tech', institute: '', startDate: '', endDate: '' }];
    $scope.addNewColumn = function () {
        console.log("hey");
        var newItemNo = $scope.columns.length + 1;
        $scope.columns.push({ 'colId': 'col' + newItemNo });
    }
});