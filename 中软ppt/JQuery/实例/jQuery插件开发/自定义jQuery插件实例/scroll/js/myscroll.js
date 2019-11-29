;(function($){
    $.fn.myscroll = function(options){
        var defaults = {
			"imgWidth":160,
			"imgHeight":160
        }
 
        var options = $.extend(defaults,options);

        this.each(function(){
        		//当前对象
			var myscroll = $(this);
			//图片数组
			var imgArr = myscroll.find("img");
			//图片数量
			var imgNum = imgArr.length;
			//左右两侧按钮宽度
			var buttonWidth = 50;
			//设置父容器样式
			myscroll.css({
				"width":options.imgWidth*imgNum + buttonWidth*2 + "px",
				"height":options.imgHeight + "px",
				"position":"relative"
			});
			
			/*
			myscroll.append("<div></div><div></div><div></div>");
			var leftJiantou = myscroll.find("div").eq(0);
			var scrollBox = myscroll.find("div").eq(1);
			var rightJiantou = myscroll.find("div").eq(2);
			*/
			//左箭头
			var leftJiantou = $("<div>&lt;</div>").appendTo(myscroll);
			//滚动条父容器
			var scrollBox = $("<div></div>").appendTo(myscroll);
			//右箭头
			var rightJiantou = $("<div>&gt;</div>").appendTo(myscroll);
			
			scrollBox.css({
				"width":options.imgWidth*imgNum + "px",
				"height":options.imgHeight + "px",
				"position":"relative",
				"float":"left",
				"overflow":"hidden"
			});
			//滚动长条
			var scrollBoxTiao = $("<div></div>").appendTo(scrollBox);
			scrollBoxTiao.css({
				"width":options.imgWidth*imgNum*2 + "px",
				"height":options.imgHeight + "px",
				"position":"absolute"
			});
			//设置图片尺寸，这样做的话，用户可以放置任何尺寸的图片
			imgArr.css({
				"width":options.imgWidth + "px",
				"height":options.imgHeight + "px",
			});
			//将图片放置在滚动长条中
			scrollBoxTiao.append(imgArr.clone()).append(imgArr);
			
			leftJiantou.css({
				"width":buttonWidth + "px",
				"height":options.imgHeight + "px",
				"background-color":"#DDD",
				"float":"left",
				"text-align":"center",
				"line-height":options.imgHeight + "px",
				"color":"#FFF",
				"font-size":"50px",
				"font-weight":"900"
			});
			
			rightJiantou.css({
				"width":buttonWidth + "px",
				"height":options.imgHeight + "px",
				"background-color":"#DDD",
				"float":"left",
				"text-align":"center",
				"line-height":options.imgHeight + "px",
				"color":"#FFF",
				"font-size":"50px",
				"font-weight":"900"
			});
			
			var myTimer = null;
			//1: 右    －1: 左
			var fangxiang = 1;
			var jgTime = 40;
			var speed = 5;
			
			scrollBoxTiao.css("left",scrollBoxTiao.width()/2*-1 + "px");
			
			myTimer = setInterval(move,jgTime);
			
			function move(){
				if(fangxiang==1){
					if(scrollBoxTiao.position().left>=0){
						scrollBoxTiao.css("left",scrollBoxTiao.width()/2*-1 + "px");
					}
				}else{
					if(scrollBoxTiao.position().left<=scrollBoxTiao.width()/2*-1){
						scrollBoxTiao.css("left",0 + "px");
					}
				}
				scrollBoxTiao.css("left",scrollBoxTiao.position().left + (fangxiang*speed) + "px");
			}
			
			leftJiantou.mouseover(function(){
				fangxiang = -1;
			});
			
			rightJiantou.mouseover(function(){
				fangxiang = 1;
			});
			
			scrollBoxTiao.hover(function(){
				clearInterval(myTimer);
			},function(){
				myTimer = setInterval(move,jgTime);
			});
        });
 
        return $(this);
    }
})(jQuery);
