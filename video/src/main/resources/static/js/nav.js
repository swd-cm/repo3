	$(function() {
			$("img").eq(0).siblings().hide()
			$("li").eq(0).children().css("color", "#CD5C5C")
			$("li").eq(0).siblings().children().children().hide()
		})
		var x = 0;
		function carousel() {
			x++;
			var index = x % 3;
			display(index)
		}
		function display(index){
			$("img").eq(index).show();
			$("img").eq(index).siblings().hide()
			$("li").eq(index).children().children().show()
			$("li").eq(index).siblings().children().children().hide()
			$("li").eq(index).children().css("color", "#CD5C5C")
			$("li").eq(index).siblings().children().css("color", "")
		}
		var interval = setInterval(function() {
			carousel();
		}, 2000)
		$("li").hover(function() {
			var index = $("li").index(this);
			clearInterval(interval)
			display(index)
			x = index;
		},function(){
			$(this).children().css("color", "")
			$(this).children().children().hide()
			interval = setInterval(carousel,2000)
		})
			$("#d1").hover(function() {
			$(this).children('div').show();
		}, function() {
			$(this).children('div').hide();
		})