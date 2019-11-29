;
(function($) {
	$.fn.extend({
		"picture": function(optionsParam) {

			var defaults = {
				"boxWidth": 500,
				"boxHeight": 300,
				"animateType":0,
				"interval":5000
			};
			var options = $.extend(defaults, optionsParam);

			var boxWidth = options.boxWidth;
			var boxHeight = options.boxHeight;
			var interval = options.interval;
			
			//当前对象
			var picture = $(this);
			//所有图片
			var imgArr = picture.find("img");
			//图片数量
			var imgNum = imgArr.size();
			//标示颜色
			var flagColor = "#333";
			
			//设置当前对象的宽和高，设置相对定位，以利于标示div定位和图片的横向移动效果。防止图片下部超出3px，所以设置超出部分隐藏
			picture.width(boxWidth);
			picture.height(boxHeight);
			picture.css({
				"overflow":"hidden",
				"position": "relative"
			});
			
			//设置图片宽和高
			imgArr.width(boxWidth);
			imgArr.height(boxHeight);
			
			var itemStr = "";
			for (var i = 0; i < imgNum; i++) {
				itemStr += "<div></div>";
			}
			
			var imgDiv = $(itemStr).appendTo(picture);
			imgDiv.css({
				"width":boxWidth*3 + "px",
				"height": boxHeight + "px",
				"position": "absolute",
				"left": boxWidth*-1 + "px",
				"top":"0px"
			});

			//注意：要用clone的方式添加，否则就是剪切了
			imgDiv.each(function(index){
				if(index==0){
					imgDiv.eq(index).append(imgArr.eq(imgNum-1).clone()).append(imgArr.eq(0).clone()).append(imgArr.eq(1).clone());
				}else if(index==imgNum-1){
					imgDiv.eq(index).append(imgArr.eq(imgNum-2).clone()).append(imgArr.eq(imgNum-1).clone()).append(imgArr.eq(0).clone());
				}else{
					imgDiv.eq(index).append(imgArr.eq(index-1).clone()).append(imgArr.eq(index).clone()).append(imgArr.eq(index+1).clone());
				}
			});
			imgArr.remove();
                        
			//向当前对象中添加标示容器，并在标示容器内添加标示div
			var flagDiv = $("<div></div>").appendTo(picture);
			var flagItemDiv = $(itemStr).appendTo(flagDiv);
			
			//设置标示容器尺寸。每个标示div总宽：6+3+3，有一个右外边距5px，但最后一个不应该有，要减5
			var flagDivWidth = imgNum*(12+5)-5;
			flagDiv.css({
				"width": flagDivWidth + "px",
				"height": "12px",
				"position": "absolute",
				"bottom":"20px",
				"overflow":"hidden",
				"left":(boxWidth-flagDivWidth)/2 + "px",
				"z-index":2
			});
			//设置标示div
			//向右浮动，主要是为了配合图片横向移动的方向。图片向右横向移动，应该被认为是图片序号累加。
			//这时，如果表述div向左浮动，就会出现图片向右横向移动，而标示div向左移动。
			flagItemDiv.css({
				"width": "6px",
				"height": "6px",
				"border": "solid 3px " + flagColor,
				"border-radius":"6px",
				"margin-right":"5px",
				"cursor":"pointer",
				"float":"right"
			});
			//因为是向右浮动，所以是第一个div靠右边，因此第一个标示div不应该有margin-right
			flagItemDiv.first().css("margin-right","0px");
			
			//左右按钮
			var jiantouRight = $("<div><p></p></div>").appendTo(picture);
			var jiantouLeft = $("<div><p></p></div>").appendTo(picture);
			
			jiantouRight.css({
				"width":"40px",
				"height":"100px",
				"position": "absolute",
				"right":"0",
				"top":(boxHeight-100)/2 + "px",
				"background-color":"rgba(0,0,0,0)",
				"cursor":"default",
				"-webkit-user-select": "none",
				"-moz-user-select": "none"
			});
			//按钮中的三角
			jiantouRight.find("p").css({
				"width":"0px",
				"height":"0px",
				"color":"#FFFFFF",
				"border-width":"22px 0px 22px 22px",
    				"border-color":"transparent transparent transparent rgba(255,255,255,0.4) ",
    				"border-style":"solid",
    				"margin-top":"26px",
    				"margin-left":"9px"
			});
			
			jiantouLeft.css({
				"width":"40px",
				"height":"100px",
				"position": "absolute",
				"left":"0",
				"top":(boxHeight-100)/2 + "px",
				"background-color":"rgba(0,0,0,0)",
				"cursor":"default",
				"-webkit-user-select": "none",
				"-moz-user-select": "none"
			});
			//按钮中的三角
			jiantouLeft.find("p").css({
				"width":"0px",
				"height":"0px",
				"color":"#FFFFFF",
				"border-width":"22px 22px 22px 0px",
    				"border-color":"transparent rgba(255,255,255,0.4) transparent transparent  ",
    				"border-style":"solid",
    				"margin-top":"26px",
    				"margin-left":"9px"
			});
			
			//init中做了：1、所有图片div隐藏；2、所有图片div的初始位置为中间图片；3、所有标示div的背景色取消（即不是激活状态）
			init();
			//设置第一个图片div显示
			imgDiv.first().show();
			//设置第一个标示div为激活状态
			flagItemDiv.first().css("background-color", flagColor);
			
			//图片序号
			var index = 0;
			//动画持续时间
			var donghuaTime = 300;
			var timer = null;

			timer = setInterval(intervalMove, interval);
			
			//单击标示div
			flagItemDiv.click(function() {
				//用户单击那个标示div，图片序号就为点击标示div的序号
				index = $(this).index();
				clearInterval(timer);
				init();
				//无动画或横向滑动时，用户点击标示时，立刻切换到用户点击图片
				if(options.animateType==0||options.animateType==2){
					imgDiv.eq(index).show();
				}else{
					imgDiv.eq(index).stop().fadeIn(donghuaTime);
				}
				flagItemDiv.eq(index).css("background-color", flagColor);
				timer = setInterval(intervalMove, interval);
			});
			
			//为向左向右按钮同时添加hover事件
			jiantouLeft.add(jiantouRight).hover(function(){
				$(this).css("background-color","rgba(0,0,0,0.4)");
			},function(){
				$(this).css("background-color","rgba(0,0,0,0)");
			});
			
			jiantouLeft.click(function() {
				clearInterval(timer);
				move(boxWidth*-2,0);
				timer = setInterval(intervalMove, interval);
			});
			
			jiantouRight.click(function() {
				clearInterval(timer);
				move(0,1);
				timer = setInterval(intervalMove, interval);
			});
			
			//定时器用的轮播方法
			function intervalMove() {
				move(boxWidth*-2,0);
			};
			
			function move(donghuaPosition,fangxiang){
				if(options.animateType==2){
					imgDiv.eq(index).animate({					
      						"left":donghuaPosition + "px"							
					},donghuaTime,function(){
						setIndex(fangxiang);
						init();
						imgDiv.eq(index).show();
						flagItemDiv.eq(index).css("background-color", flagColor);
					});
				}else{
					setIndex(fangxiang);
					init();
					if(options.animateType==0){
						imgDiv.eq(index).show();
					}else{
						imgDiv.eq(index).stop().fadeIn(donghuaTime);
					}
					flagItemDiv.eq(index).css("background-color", flagColor);
				}
			}
			
			//设置图片序号(fangxiang: 0:向左；  1:向右)
			function setIndex(fangxiang){
				if(fangxiang==0){
					if (index == imgNum - 1) {
						index = 0;
					} else {
						index++;
					}
				}else{
					if (index == 0) {
						index = imgNum - 1;
					} else {
						index--;
					}
				}
			}

			function init() {
				imgDiv.hide();
				imgDiv.css("left",boxWidth*-1);
				flagItemDiv.css("background-color", "");
			}
			
			return $(this);
		}
	});
})(jQuery);