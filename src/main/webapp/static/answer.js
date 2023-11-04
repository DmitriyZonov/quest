$('#answer-button').click(function(){
  $('#answer-button').fadeOut("slow",function(){
    $("#answer").fadeIn();
    TweenMax.from("#answer", .4, { scale: 0, ease:Sine.easeInOut});
    TweenMax.to("#answer", .4, { scale: 1, ease:Sine.easeInOut});
  });
});

$(".close-btn").click(function(){
  TweenMax.from("#answer", .4, { scale: 1, ease:Sine.easeInOut});
  TweenMax.to("#answer", .4, { left:"0px", scale: 0, ease:Sine.easeInOut});
  $("#answer").fadeOut(800, function(){
    $("#answer-button").fadeIn(800);
  });
});