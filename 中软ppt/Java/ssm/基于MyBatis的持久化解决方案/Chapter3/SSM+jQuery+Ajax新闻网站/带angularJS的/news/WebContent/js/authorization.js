/*
 * 注意：在HTML5中使用同步ajax提交，就会出现如下警告：
 * Synchronous XMLHttpRequest on the main thread is deprecated because of its detrimental effects to the end user's experience. For more help, check https://xhr.spec.whatwg.org/.
 * （在主线程同步XMLHttpRequest是不赞成的，因为对最终用户的体验有不利影响。更多帮助，检查HTTP://xhr.spec.whatwg.org/）
 * 这段话应该是针对HTML5说的，因为在HTML5以前，JavaScript是完全的单线程方式，主线程之外不存在其他线程。
 * 但在HTML5中增加了Worker对象，每个Worker运行在一个独立的线程中，Worker线程被阻塞一般是不会影响主线程和浏览器的。
 * 因此，如果非要使用同步的Ajax（这种情况应该很少见），那就放到Worker线程中吧，千万千万不要放到主线程里。
 * 但这里是需要同步的，也就是需要在登陆验证之后才允许继续运行，所以可无视这个警告。
 */
var users = null;
$.ajax({
    type:"get",
    url:"../users/authorization.do",
    async:false,        //验证是否登陆时最好使用同步提交
    success:function(data,stutas,xhr){
        if(data==null||data==""){
        	window.location.href="login.html";
        }else{
        	users = data;
        }
    },
    error:function(xhr,error){
        alert("请求失败！");
    }
});