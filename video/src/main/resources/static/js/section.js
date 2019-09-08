$("#s1 a").hover(function(){
	$(this).css("color","orange");
},function(){
	$(this).css("color","");
})
$("#d6 a").hover(function(){
	$(this).css("color","orange");
},function(){
	$(this).css("color","");
})
$("#d5>div").children('button').hover(function(){
	$(this).css({'color':'orange','background-color':'#DCDCDC','border-radius':'10px'})
},function(){
	$(this).css({'color':'','background-color':''})
})
$("#d5>div").children().click(function(){
	var index = $("#d5>div").children().index(this)
	if(index==0){
		if($(this).siblings('span').text().trim()=='1/7'){
			$(this).attr("disabled", true)
		}else{
			var arr = $(this).siblings('span').text().split('/')
			var x = parseInt(arr[0])
			x--;
			var str = x+'/'+'7';
			$(this).siblings('span').text(str)
		}
	}
	if(index==2){
		if($(this).siblings('span').text().trim()=='7/7'){
			$(this).attr("disabled", true)
		}else{
			var arr = $(this).siblings('span').text().split('/')
			var x = parseInt(arr[0])
			x++;
			var str = ' '+x+'/'+'7'+' ';
			$(this).siblings('span').text(str)
		}
	}
	$(this).attr("disabled",false)
})