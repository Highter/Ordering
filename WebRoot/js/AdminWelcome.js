jQuery(function($) {
	$(".Layout_Right_Menu li a").hover(function() {
		$(this).css("color", "blue");
	}, function() {
		$(this).css("color", "");
	});
	$("#register a").click(function() {
		$("#Layout_Left_Msg_CustomRegister").css("display", "block");
		$("#Layout_Left_Msg_RestaurantShow").css("display", "none");
		$("#Layout_Left_Msg_OrderingCustomShow").css("display", "none");
		$("#Layout_Left_Msg_RestaurantCustomShow").css("display", "none");
		$("#custom_menu").css("display", "none");
	});

	$("#restaurant a").click(function() {
		$("#Layout_Left_Msg_CustomRegister").css("display", "none");
		$("#Layout_Left_Msg_RestaurantShow").css("display", "block");
		$("#Layout_Left_Msg_OrderingCustomShow").css("display", "none");
		$("#Layout_Left_Msg_RestaurantCustomShow").css("display", "none");
		$("#custom_menu").css("display", "none");
	/*	$(this)(function(){
			
		});*/
	});

	$("#custom_itemTwo").click(function() {
		$("#custom_menu").css("display", "block");
	});
	
	$("#custom_menu_Order a").click(function() {
		$("#Layout_Left_Msg_CustomRegister").css("display", "none");
		$("#Layout_Left_Msg_RestaurantShow").css("display", "none");
		$("#Layout_Left_Msg_OrderingCustomShow").css("display", "block");
		$("#Layout_Left_Msg_RestaurantCustomShow").css("display", "none");
	});
	$("#custom_menu_Rest a").click(function() {
		$("#Layout_Left_Msg_CustomRegister").css("display", "none");
		$("#Layout_Left_Msg_RestaurantShow").css("display", "none");
		$("#Layout_Left_Msg_OrderingCustomShow").css("display", "none");
		$("#Layout_Left_Msg_RestaurantCustomShow").css("display", "block");
	});
});