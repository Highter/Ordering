jQuery(function($) {
	$(".Layout_Right_Menu li a").hover(function() {
		$(this).css("color", "blue");
	}, function() {
		$(this).css("color", "");
	});
	
	$("#customMsgMng a").click(function() {
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "block");
		$("#CustomMsgMng_show").css("display", "none");
		$("#CustomMsgMng_update").css("display", "none");
		
		$("#Layout_Left_Msg_MenuMsgMng").css("display", "none");
		$("#MenuMsgMng_look").css("display", "none");
		$("#MenuMsgMng_add").css("display", "none");
		
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
	});
	
	//²Ëµ¥
	$("#menuMsgMng a").click(function() {
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "none");
		$("#CustomMsgMng_show").css("display", "none");
		$("#CustomMsgMng_update").css("display", "none");
		
		$("#Layout_Left_Msg_MenuMsgMng").css("display", "block");
		$("#MenuMsgMng_look").css("display", "none");
		$("#MenuMsgMng_add").css("display", "none");
		
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
	});

	$("#menuMng a").click(function() {
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMng").css("display", "block");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
	});

	$("#restMsg a").click(function() {
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "block");
	});
	
	$("#customMsgMng_menu_look a").click(function(){
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "block");
		$("#Layout_Left_Msg_MenuMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
		$("#CustomMsgMng_show").css("display", "block");
		$("#CustomMsgMng_update").css("display", "none");
	});
	$("#customMsgMng_menu_update a").click(function(){
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "block");
		$("#Layout_Left_Msg_MenuMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
		$("#CustomMsgMng_show").css("display", "none");
		$("#CustomMsgMng_update").css("display", "block");
	});
	
	
	$("#menuMsgMng_menu_add a").click(function(){
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMsgMng").css("display", "block");
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
		$("#MenuMsgMng_look").css("display", "block");
		$("#MenuMsgMng_add").css("display", "none");
	});
	
	$("#menuMsgMng_menu_look a").click(function(){
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMsgMng").css("display", "block");
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
		$("#MenuMsgMng_look").css("display", "none");
		$("#MenuMsgMng_add").css("display", "block");
	});
	
	$("#customMsgMng").hover(function() {
		$("#item_menu_custom").css('display','block');
		$("#item_menu_custom").stop().animate({height:'90px'},300);
	}, function() {
//		$("#item_menu_custom").css('display','none');
		$("#item_menu_custom").stop().animate({height:'0px'},300,function(){
		$("#item_menu_custom").css('display','none');
		});
	});
	
	$("#menuMsgMng").hover(function() {
		$("#item_menu").css('display','block');
		$("#item_menu").stop().animate({height:'90px'},300);
	}, function() {
		$("#item_menu").stop().animate({height:'0px'},300,function(){
			$("#item_menu").css('display','none');
		});
	});
});