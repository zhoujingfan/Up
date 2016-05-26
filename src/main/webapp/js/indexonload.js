var ClickCounterViewModel = function() {
    this.numberOfClicks = ko.observable(0);

    this.agree = ko.observable(1);
    this.disagree = ko.observable(0);

    this.agreeClick = function() {
        this.numberOfClicks(this.numberOfClicks() + 1);
        this.agree(0);
        this.disagree(1);
    };

    this.disagreeClick = function() {
        this.numberOfClicks(this.numberOfClicks() - 1);
        this.agree(1);
        this.disagree(0);
    };
};

function indexonload(){
    ko.applyBindings(new ClickCounterViewModel());
}