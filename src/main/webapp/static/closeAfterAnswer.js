$(function(){
    TweenMax.from("#answer", .4, { scale: 1, ease:Sine.easeInOut});
    TweenMax.to("#answer", .4, { left:"0px", scale: 0, ease:Sine.easeInOut});
});