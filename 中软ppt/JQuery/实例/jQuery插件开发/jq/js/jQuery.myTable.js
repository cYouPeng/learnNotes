//创建一个闭包 
;(function($){
	$.fn.myTable = function(options){
		//设置默认参数
		var defaults = {
			evenRowColor:"#DDD",
			oddRowColor:"#EEE"
		}
		//参数中如果存在defaults中的值，则覆盖defaults中的值  
		var options = $.extend(defaults,options);
		//遍历所有的元素
		this.each(function(){
			//偶数行
			$(this).find("tr:even").css("background-color",options.evenRowColor);
			//奇数行
			$(this).find("tr:odd").css("background-color",options.oddRowColor);
		});
		//返回当前对象，实现链式调用
		return $(this);
	}
})(jQuery);

/*
;(function($){
	$.fn.extend({
		myTable:function(options){
			var defaults = {
				evenRowColor:"#DDD",
				oddRowColor:"#EEE"
			}
			var options = $.extend(defaults,options);
			this.each(function(){
				//偶数行
				$(this).find("tr:even").css("background-color",options.evenRowColor);
				//奇数行
				$(this).find("tr:odd").css("background-color",options.oddRowColor);
			});
			return $(this);
		},
		funOther:function(options){
			//
		}
	});
})(jQuery);
*/