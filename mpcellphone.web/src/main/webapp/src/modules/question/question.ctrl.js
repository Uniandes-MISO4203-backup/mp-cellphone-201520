(function (ng) {
    var mod = ng.module('questionModule');
    mod.controller('questionCtrl', ['CrudCreator', '$scope', 'questionService', 'questionModel', 'authService', '$filter',
        function (CrudCreator, $scope, svc, model, authSvc, $filter) {
            CrudCreator.extendController(this, svc, $scope, model, 'question', 'Questions');
            this.fetchRecords();
            this.loadRefOptions();
            $scope.questionSelected = 0;
            var getAnswers = function (fatherId) {
                svc.finByFatherId(fatherId).then(
                        function (data) {
                            var txt = "";
                            var cont = 0;
                            for (var i = 0; i < data.length; i++) {
                                if (cont !== 0) {
                                    txt += "<hr>";
                                }
                                cont++;
                                txt += cont + ". ";
                                var fecha = $filter('date')(data[i].date, 'dd/MM/yyyy');
                                txt += data[i].question + " - " + fecha + "";
                            }
                            $("#listAnswers").html(cont !== 0 ? txt : "<center><b>No anwers yet.</b></center>");
                        }
                );
            };
            this.answerAction = [{
                    fn: function (record) {
                        if (authSvc.getCurrentUser()) {
                            $scope.questionSelected = record;
                            $("#listAnswers").html("<center><b>Loading...</b></center>");
                            getAnswers($scope.questionSelected.id);
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
                                    product: $scope.questionSelected.product,
                                    client: $scope.questionSelected.client,
                                    provider: authSvc.getCurrentUser(),
                                    father: $scope.questionSelected.id
                                };
                                svc.createAnswer(objEnvia).then(
                                        function () {
                                            alert("Answer has been sent successfully.");
                                            $("#answerTextArea").val("").attr("placeholder", authSvc.getCurrentUser().name + " answers: ");
                                            $('#answerTextArea').focus();
                                            $("#listAnswers").html("<center><b>Loading new answers...</b></center>");
                                            getAnswers($scope.questionSelected.id);
                                        }
                                );

                            }
                        }
                    }
                }];
        }]);
})(window.angular);
