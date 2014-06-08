jQuery(function($) {
	$("#Search_Btn").click(function() {
		alert("123");
	});
	$(".Layout_Right_Menu li a").hover(function() {
		$(this).css("color", "blue");
	}, function() {
		$(this).css("color", "");
	});
	$(".Layout_Right_Menu").hover(function() {
		$("#one").hover(function() {
			$("#styleOne").css("display", "block");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "none");
		}, function() {
			$("#styleOne").hover(function() {

			}, function() {
				$("#styleOne").css("display", "none");
			});
		});
		$("#two").hover(function() {
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "block");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "none");
		}, function() {
			$("#styleTwo").hover(function() {

			}, function() {
				$("#styleTwo").css("display", "none");
			});
		});
		$("#three").hover(function() {
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "block");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "none");
		}, function() {
			$("#styleThree").hover(function() {

			}, function() {
				$("#styleThree").css("display", "none");
			});
		});
		$("#four").hover(function() {
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "block");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "none");
		}, function() {
			$("#styleFour").hover(function() {

			}, function() {
				$("#styleFour").css("display", "none");
			});
		});
		$("#five").hover(function() {
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "block");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "none");
		}, function() {
			$("#styleFive").hover(function() {

			}, function() {
				$("#styleFive").css("display", "none");
			});
		});
		$("#six").hover(function() {
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "block");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "none");
		}, function() {
			$("#styleSix").hover(function() {

			}, function() {
				$("#styleSix").css("display", "none");
			});
		});
		$("#seven").hover(function() {
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "block");
			$("#styleEight").css("display", "none");
		}, function() {
			$("#styleSeven").hover(function() {

			}, function() {
				$("#styleSeven").css("display", "none");
			});
		});
		$("#eight").hover(function() {
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "block");
		}, function() {
			$("#styleEight").hover(function() {

			}, function() {
				$("#styleEight").css("display", "none");
			});
		});
		$("#Head").hover(function(){
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "none");
		},function(){
			
		});
		$("#Layout_Left").hover(function(){
			$("#styleOne").css("display", "none");
			$("#styleTwo").css("display", "none");
			$("#styleThree").css("display", "none");
			$("#styleFour").css("display", "none");
			$("#styleFive").css("display", "none");
			$("#styleSix").css("display", "none");
			$("#styleSeven").css("display", "none");
			$("#styleEight").css("display", "none");
		},function(){
			
		});
	}, function() {
		
	});
});

function MenuLoad(){
	
	MakeSure();
  /* $.ajax({
   url:"/Ordering/MenuListServlet",
   type:"get",
   dataType:"json",
   success:function(jsons_menuList){
   	$("#menuOne").empty();
   	var t = jsons_menuList.length;
   	var m = 0;
    	for(var j=0;j<(t/5);j++){
    			$("#menuOne").append("<tr id='" + jsons_menuList[j].dish_ID +"'></tr>");
    		for(var i=0;i<5;i++){
    			m = m+1;
    			if(m<=t){
	         		$("#"+jsons_menuList[j].dish_ID).append("<td>"+jsons_menuList[m-1].dish_Name+"</td>");
    			}
    		}
    	}
   }
}); 
*/
//显示所有的餐品
$.ajax({
   url:"/Ordering/MenuListServlet",
   type:"get",
   dataType:"json",
   success:function(jsons_menuList){
   	$("#menuOne").empty();
   	//alert(jsons_menuList[0].menuList1[2].dish_Name);某个菜名
   	//alert(jsons_menuList[0].menuList1.length);长度
   	//alert(jsons_menuList[0].menuList1[4].dish_ID);
   	var t1 = jsons_menuList[0].menuList1.length;
   	var t2 = jsons_menuList[0].menuList2.length;
   	var t3 = jsons_menuList[0].menuList3.length;
   	var t4 = jsons_menuList[0].menuList4.length;
   	var t5 = jsons_menuList[0].menuList5.length;
   	var t6 = jsons_menuList[0].menuList6.length;
   	var t7 = jsons_menuList[0].menuList7.length;
   	var t8 = jsons_menuList[0].menuList8.length;
   	var m1 = 0;
   	var m2 = 0;
   	var m3 = 0;
   	var m4 = 0;
   	var m5 = 0;
   	var m6 = 0;
   	var m7 = 0;
   	var m8 = 0;
   		//menuOne
    	for(var j=0;j<(t1/5);j++){//行
    			$("#menuOne").append("<tr id='" + "mm"+jsons_menuList[0].menuList1[j].dish_ID +"'></tr>");
    			
    		for(var i=0;i<5;i++){
    			m1 = m1+1;
    			if(m1<=t1){
	         		$("#"+ "mm"+jsons_menuList[0].menuList1[j].dish_ID).append("<td id ='"+jsons_menuList[0].menuList1[m1-1].dish_ID +"' onclick ='MenuShow(this.id)'>"+jsons_menuList[0].menuList1[m1-1].dish_Name+"</td>");
    			}
    		}
    	}
    	 //menuTwo
    	for(var j=0;j<(t2/5);j++){
    			$("#menuTwo").append("<tr id='" +"mm"+ jsons_menuList[0].menuList2[j].dish_ID +"'></tr>");
    		for(var i=0;i<5;i++){
    			m2 = m2+1;
    			if(m2<=t2){
	         		$("#"+"mm"+jsons_menuList[0].menuList2[j].dish_ID).append("<td id ='"+jsons_menuList[0].menuList2[m2-1].dish_ID +"' onclick ='MenuShow(this.id)'>"+jsons_menuList[0].menuList2[m2-1].dish_Name+"</td>");
    			}
    		}
    	}
    	//menuThree
    	for(var j=0;j<(t3/5);j++){
    			$("#menuThree").append("<tr id='" + "mm"+jsons_menuList[0].menuList3[j].dish_ID +"'></tr>");
    		for(var i=0;i<5;i++){
    			m3 = m3+1;
    			if(m3<=t3){
	         		$("#"+"mm"+jsons_menuList[0].menuList3[j].dish_ID).append("<td id ='"+jsons_menuList[0].menuList3[m3-1].dish_ID +"' onclick ='MenuShow(this.id)'>"+jsons_menuList[0].menuList3[m3-1].dish_Name+"</td>");
    			}
    		}
    	}
    	//menuFour
    	for(var j=0;j<(t4/5);j++){
    			$("#menuFour").append("<tr id='" + "mm"+jsons_menuList[0].menuList4[j].dish_ID +"'></tr>");
    		for(var i=0;i<5;i++){
    			m4 = m4+1;
    			if(m4<=t4){
	         		$("#"+"mm"+jsons_menuList[0].menuList4[j].dish_ID).append("<td id ='"+jsons_menuList[0].menuList4[m4-1].dish_ID +"' onclick ='MenuShow(this.id)'>"+jsons_menuList[0].menuList4[m4-1].dish_Name+"</td>");
    			}
    		}
    	}
    	//menuFive
    	for(var j=0;j<(t5/5);j++){
    			$("#menuFive").append("<tr id='" + "mm"+jsons_menuList[0].menuList5[j].dish_ID +"'></tr>");
    		for(var i=0;i<5;i++){
    			m5 = m5+1;
    			if(m5<=t5){
	         		$("#"+"mm"+jsons_menuList[0].menuList5[j].dish_ID).append("<td id ='"+jsons_menuList[0].menuList5[m5-1].dish_ID +"' onclick ='MenuShow(this.id)'>"+jsons_menuList[0].menuList5[m5-1].dish_Name+"</td>");
    			}
    		}
    	}
    	//menuSix
    	for(var j=0;j<(t6/5);j++){
    			$("#menuSix").append("<tr id='" + "mm"+jsons_menuList[0].menuList6[j].dish_ID +"'></tr>");
    		for(var i=0;i<5;i++){
    			m6 = m6+1;
    			if(m6<=t6){
	         		$("#"+"mm"+jsons_menuList[0].menuList6[j].dish_ID).append("<td id ='"+jsons_menuList[0].menuList6[m6-1].dish_ID +"' onclick ='MenuShow(this.id)'>"+jsons_menuList[0].menuList6[m6-1].dish_Name+"</td>");
    			}
    		}
    	}
    	//menuSeven
    	for(var j=0;j<(t7/5);j++){
    			$("#menuSeven").append("<tr id='" + "mm"+jsons_menuList[0].menuList7[j].dish_ID +"'></tr>");
    		for(var i=0;i<5;i++){
    			m7 = m7+1;
    			if(m7<=t7){
	         		$("#"+"mm"+jsons_menuList[0].menuList7[j].dish_ID).append("<td id ='"+jsons_menuList[0].menuList7[m7-1].dish_ID +"' onclick ='MenuShow(this.id)'>"+jsons_menuList[0].menuList7[m7-1].dish_Name+"</td>");
    			}
    		}
    	}
    	//menuEight
    	for(var j=0;j<(t8/5);j++){
    			$("#menuEight").append("<tr id='" + "mm"+jsons_menuList[0].menuList8[j].dish_ID +"'></tr>");
    		for(var i=0;i<5;i++){
    			m8 = m8+1;
    			if(m8<=t7){
	         		$("#"+"mm"+jsons_menuList[0].menuList8[j].dish_ID).append("<td id ='"+jsons_menuList[0].menuList8[m8-1].dish_ID +"' onclick ='MenuShow(this.id)'>"+jsons_menuList[0].menuList8[m8-1].dish_Name+"</td>");
    			}
    		}
    	}
   }
});

//餐馆
	ShowHotRestaurants();
	ShowHotMenuDish();
}

//查看餐馆和餐品
function restaurantShow(id){
	window.open("/Ordering/CustomShowRestMessage?id="+id);
}
function MenuShow(id){
	window.open("/Ordering/CustomShowMenu?id="+id);
}