(function (ng) {
    var mod = ng.module('questionModule', ['ngCrud']);
    mod.constant('questionContext', 'questions');
    mod.constant('questionModel', {
        fields: [{
                name: 'question',
                displayName: 'Question',
                type: 'String',
                required: true
            }, {
                name: 'date',
                displayName: 'Date',
                type: 'Date',
                required: true
            }]
        });
})(window.angular);
