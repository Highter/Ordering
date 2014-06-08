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
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
	});

	$("#menuMng a").click(function() {
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMng").css("display", "block");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
	});

	$("#restMsg a").click(function() {
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "none");
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "block");
	});
	$("#customMsgMng_menu_look a").click(function(){
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "block");
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
		$("#CustomMsgMng_show").css("display", "block");
		$("#CustomMsgMng_update").css("display", "none");
	});
	$("#customMsgMng_menu_update a").click(function(){
		$("#Layout_Left_Msg_CustomMsgMng").css("display", "block");
		$("#Layout_Left_Msg_MenuMng").css("display", "none");
		$("#Layout_Left_Msg_RestMsg").css("display", "none");
		$("#CustomMsgMng_show").css("display", "none");
		$("#CustomMsgMng_update").css("display", "block");
	});
	$("#customMsgMng").hover(function() {
		$("#customMsgMng_menu").fadeIn(500);
	}, function() {
		$("#customMsgMng_menu").fadeOut(500);
	});
});