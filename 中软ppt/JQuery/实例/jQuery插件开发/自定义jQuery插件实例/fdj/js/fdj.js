;
(function($) {
	$.fn.extend({
		"fdj": function(optionsParam) {
			
			var defaults = {
				//图片尺寸不能依靠图片本身来取得。因为图片有可能会延迟加载
				"width":1000,
				"height":500,
				"times":3,
				"mengbanColor":"yellow",
				"opacity":0.4,
			};
			var options = $.extend(defaults, optionsParam);
			
			var fdj = $(this);
			//获取图片
			var imgObj = fdj.children("img");
			//获取图片地址
			var imgUrl = imgObj.attr("src");
			//大图片除以放大倍数，就是插件的尺寸
			var fdjWidth = options.width/options.times;
			var fdjHeight = options.height/options.times;

			//将图片缩小
			imgObj.css({
				"width": fdjWidth + "px",
				"height": fdjHeight + "px",
			});
			
			fdj.css({
				"width": fdjWidth + "px",
				"height": fdjHeight + "px",
				"position": "relative",
			});

			fdj.append("<div></div><div></div>");

			var box = fdj.children("div").eq(0);
			var bigBox = fdj.children("div").eq(1);
			
			//放大区域
			box.css({
				"width": fdjWidth/options.times + "px",
				"height": fdjHeight/options.times + "px",
				"background": options.mengbanColor,
				"opacity": options.opacity,
				"position": "absolute",
				"cursor": "move",
				"z-index":10
			});
			box.hide();

			bigBox.css({
				"width": fdjWidth + "px",
				"height": fdjHeight + "px",
				"position": "absolute",
				"left": fdjWidth + 10 + "px",
				"top": 0 + "px"
			});
			bigBox.hide();

			fdj.mousemove(function(event) {
				//box.width()/2是让鼠标居于放大区域中心
				var left = event.pageX - $(this).position().left - box.width() / 2;
				var top = event.pageY - $(this).position().top - box.height() / 2;
				if (left < 0) {
					left = 0;
				}
				if (left > $(this).width() - box.width()) {
					left = $(this).width() - box.width();
				}
				if (top < 0) {
					top = 0;
				}
				if (top > $(this).height() - box.height()) {
					top = $(this).height() - box.height();
				}
				box.show();

				box.css({
					"left": left + "px",
					"top": top + "px",
				});
				
				bigBox.css({
					"background": "url(" + imgUrl + ")",
					"background-repeat": "no-repeat",
					"background-position": -left * options.times + "px" + " " + -top * options.times + "px",
				});
				bigBox.show();
			});
			fdj.mouseout(function() {
				box.hide();
				bigBox.hide();
			});
			return $(this);
		}
	});
})(jQuery);