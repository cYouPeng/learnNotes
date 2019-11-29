;
(function($) {
	$.fn.extend({
		"combox": function(optionsParam) {
			var defaults = {
				"fontSize":16,
				"fontColor":"#666",
				"backgroundColor":"#FFF"
			};
			var options = $.extend(defaults,optionsParam);  
			
			var combox = $(this);
			//下拉列表高度
			var boxHeight = options.fontSize * 3 / 2;
			//下拉列表宽度
			var boxWidth = 0;
			//选项中文字的宽度
			var strWidth = 0;
			
			//找最大宽度的选项，作为下拉列表的宽度
			combox.find("a").each(function() {
				var spanObj = $("<span></span>").appendTo("body");
				spanObj.css("font-size", options.fontSize + "px");
				spanObj.text($(this).text());
				if (strWidth < spanObj.width()) {
					strWidth = spanObj.width();
				}
				spanObj.remove();
			});
			//下拉列表宽度为文字最长宽度，再加上向下按钮的宽度，再加上一个高度值的宽度
			boxWidth = strWidth + boxHeight * 2;

			combox.css({
				"width": boxWidth + "px",
				"height": boxHeight + "px",
				"background": options.backgroundColor,
				"font-size": options.fontSize + "px",
				"color": options.fontColor,
				"border": "solid 1px #666",
				"border-radius":"3px",
				"box-shadow":"2px 2px 2px #888",
				"cursor": "default",
				"-webkit-user-select": "none",
				"-moz-user-select": "none"
			});

			combox.find("a").hide();

			//combox.append("<div></div><div></div>");
			//var left = combox.find("div").eq(0);
			//var right = combox.find("div").eq(1);
			var left = $("<div></div>").appendTo(combox);
			var right = $("<div></div>").appendTo(combox);

			left.css({
				"width": boxWidth - boxHeight - 1 + "px",
				"height": "100%",
				"float": "left",
				"border-right": "solid 1px #666",
				"line-height": boxHeight + "px",
				"text-indent": "10px",
				"cursor": "default"
			});

			//初始化，将combox默认值设为第一个
			left.text(combox.children("a").eq(0).text());
			combox.attr("value", left.text());

			right.css({
				"width": boxHeight + "px",
				"height": "100%",
				"float": "right",
				"cursor": "default"
			});

			right.append("<div></div>");
			right.find("div").css({
				"width": "0px",
				"height": "0px",
				"border-top-width": boxHeight / 4 + "px",
				"border-right-width": boxHeight / 4 + "px",
				"border-bottom-width": "0px",
				"border-left-width": boxHeight / 4 + "px",
				"border-color": "#000 transparent transparent transparent",
				"border-style": "solid",
				"margin-top": boxHeight * 3 / 4 / 2 + "px",
				"margin-left": boxHeight / 2 / 2 + "px"
			});

			var comboxList = $("<div></div>").appendTo(combox);
			comboxList.css({
				"position": "absolute",
				"top": $(this).offset().top + boxHeight + 2 + "px",
				"left": $(this).offset().left + "px",
				"z-index": 10,
				"width": boxWidth + "px",
				"border-left": "solid 1px #666",
				"border-right": "solid 1px #666",
				"border-bottom": "solid 1px #666",
				"line-height": boxHeight + "px",
				"text-indent": "10px",
				"font-size": options.fontSize + "px",
				"color": "#000",
				"border-radius":"0px 0px 3px 3px",
				"box-shadow":"2px 2px 2px #888",
				"-webkit-user-select": "none",
				"-moz-user-select": "none",
				"cursor": "default",
				"background": "#FFF"
			});
			comboxList.append(combox.find("a").clone());
			//这里将a转变成块元素，是让每一项都垂直排列
			comboxList.children("a").css("display","block");	
			comboxList.hide();
			
			combox.click(function(event) {
				comboxList.show();
				comboxList.children("a").click(function(event) {
					left.text($(this).text());
					combox.attr("value", left.text());
					comboxList.hide();
					event.stopPropagation();
				});
				comboxList.children("a").hover(function() {
					$(this).css("background", "#DDD");
				}, function() {
					$(this).css("background", "#FFF");
				});
				event.stopPropagation();
			});

			/*
			 * 这里要使用事件捕获。
			 * 当页面上放置多个combox插件时，当将一个combox的下拉列表点开后，再点击其他combox插件时，原先的下拉列表不会隐藏。
			 * 原因在于：点击其他combox时，由于阻止了事件冒泡，所以document的点击事件不能执行，其他下拉列表也就不会隐藏。
			 * 因此，需要将document的点击事件做成捕获，这样，当点击combox时，先触发document的点击事件，然后才是combox本身的点击事件。
			 */
			document.addEventListener("click",function() {
				comboxList.hide();
			},true);

			//$(document).click(function() {
			//	comboxList.hide();
			//});

			return $(this);
		}
	});
})(jQuery);