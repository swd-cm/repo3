$(function(){
	$("#d3>div>div a:last").css("color","orange")
	$("#d4>section").eq(0).siblings('section').hide();
})
$("article a").hover(function(){
	$(this).css("color","orange");
},function(){
	$(this).css("color","");
})
$("#d3 img").hover(function(){
	$(this).animate({'top':'-10px'})
},function(){
	$(this).animate({"top":"0"})
})
$("#d4>div").children('button').hover(function(){
	$(this).css({'color':'orange','background-color':'#DCDCDC','border-radius':'10px'})
},function(){
	$(this).css({'color':'','background-color':''})
})
$("#d4>div").children().click(function(){
	var index = $("#d4>div").children().index(this)
	if(index==0){
		if($(this).siblings('span').text().trim()=='1/5'){
			$(this).attr("disabled", true)
		}else{
			var arr = $(this).siblings('span').text().split('/')
			var x = parseInt(arr[0])
			x--;
			$("#d4>section").eq(x-1).show();
			$("#d4>section").eq(x-1).siblings('section').hide();
			var str = x+'/'+'5';
			$(this).siblings('span').text(str)
			
		}
	}
	if(index==2){
		if($(this).siblings('span').text().trim()=='5/5'){
			$(this).attr("disabled", true)
		}else{
			var arr = $(this).siblings('span').text().split('/')
			var x = parseInt(arr[0])
			x++;
			var str = ' '+x+'/'+'5'+' ';
			$(this).siblings('span').text(str)
			$("#d4>section").eq(x-1).show();
			$("#d4>section").eq(x-1).siblings('section').hide();
		}
	}
	$(this).attr("disabled",false)
})