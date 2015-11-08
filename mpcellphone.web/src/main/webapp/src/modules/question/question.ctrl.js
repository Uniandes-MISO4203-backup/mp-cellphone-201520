(function (ng) {
    var mod = ng.module('questionModule');
    mod.controller('questionCtrl', ['CrudCreator', '$scope', 'questionService', 'questionModel', 'authService',
        function (CrudCreator, $scope, svc, model,authSvc){
            CrudCreator.extendController(this, svc, $scope, model, 'question', 'Questions');
            this.fetchRecords();
            this.loadRefOptions();
            $scope.questionSelected = 0;
            this.answerAction = [{
                fn: function (record) {
                    tmp = authSvc;
                    if (authSvc.getCurrentUser()) {
                        $scope.questionSelected = record;
                        $('#titleQuestion').html("Answers: " + record.question);
                        $("#answerTextArea").val("").attr("placeholder", authSvc.getCurrentUser().name + " answers: ");
                        $('#questionInfo').modal('show').on('shown.bs.modal', function () {
                            $('#answerTextArea').focus();
                        });
                    } else {
                        $location.path('/login');
                    }
                },
                show: function () {
                    return true;
                }
            }];
            this.saveAnswer = [{
                fn: function () {
                    if (authSvc.getCurrentUser()) {
                        if ($("#answerTextArea").val().length !== 0) {
                            var objEnvia = {
                                question: $("#answerTextArea").val(),
                                product: $scope.questionSelected.product ,
                                client: $scope.questionSelected.client,
                                provider: authSvc.getCurrentUser(),
                                father: $scope.questionSelected.id
                            };
                            svc.saveAnswer(objEnvia).then(function () {
                                alert("La respuesta ha sido enviada satisfactoriamente");
                            });
                        }
                    }
                }
            }];
         }]);
})(window.angular);
