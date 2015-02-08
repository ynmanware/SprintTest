(function(app) {

    function SharedService() {
        this.description = "Master";
    }
    angular.extend(SharedService.prototype, {
        getDescription: function() {
            return this.description;
        },
        setDescription: function(desc) {
            this.description = desc;
        }
    });

    function Controller1(SharedService) {
        this.sharedService = SharedService;
    }

    Object.defineProperty(Controller1.prototype,
        'description', {
            enumerable: true, //indicate that it supports enumerations
            configurable: false, //disable delete operation
            get: function() {
                return this.sharedService.getDescription();
            },
            set: function(val) {
                this.sharedService.setDescription(val);
            }
        });

    function Controller2(SharedService) {
        this.sharedService = SharedService;
    }

    Object.defineProperty(Controller2.prototype,
        'description', { //read only property
            enumerable: true,
            configurable: false,
            get: function() {
                return this.sharedService.getDescription();
            }
        });

    app.service('SharedService', SharedService);
    app.controller('Controller1', Controller1);
    app.controller('Controller2', Controller2);

})(angular.module('myApp', []));