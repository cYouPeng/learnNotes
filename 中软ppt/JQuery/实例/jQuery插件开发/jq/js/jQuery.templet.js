//创建一个闭包 
;(function($){
	$.fn.plueName = function(options){
		//设置默认参数
		var defaults = {
			//默认参数
		}
		//参数中如果存在defaults中的值，则覆盖defaults中的值  
		var options = $.extend(defaults,options);
		//遍历所有的元素
		this.each(function(){
			
		});
		//返回当前对象，实现链式调用
		return $(this);
	}
})(jQuery);