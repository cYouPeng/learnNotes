#### 使用`Vue.component()`注册全局组件

- 第一个参数是自定义元素名称，也就是将来在别的组件中使用这个组件的标签名称。
- 第二个参数是将要注册的Vue组件。

```
import Vue from 'vue';
// 引入loading组件 
import Loading from './loading.vue';
// 将loading注册为全局组件，在别的组件中通过<loading>标签使用Loading组件
Vue.component('loading', Loading);
```

#### 使用`Vue.use`注册插件

- 这个方法接收一个参数。这个参数必须具有install方法。Vue.use函数内部会调用参数的install方法。
- 如果插件没有被注册过，那么注册成功之后会给插件添加一个installed的属性值为true。Vue.use方法内部会检测插件的installed属性，从而避免重复注册插件。
- 插件的install方法将接收两个参数，第一个是参数是Vue，第二个参数是配置项options。
- 在install方法内部可以添加全局方法或者属性、全局指令、mixin混入、添加实例方法、使用Vue.component()注册组件等。

```
import Vue from 'vue';

// 这个插件必须具有install方法
const plugin = {
  install (Vue, options) {
    // 添加全局方法或者属性
    Vue.myGlobMethod = function () {};
    // 添加全局指令
    Vue.directive();
    // 添加混入
    Vue.mixin();
    // 添加实例方法
    Vue.prototype.$xxx = function () {};
    // 注册全局组件
    Vue.component()
  }
}

// Vue.use内部会调用plugin的install方法
Vue.use(plugin);
```

#### 示例

下面看一下element-ui里面的实现。

在./src/index.js里面第144行定义了一个install方法，后面导出的对象里面就引用了这个方法。然后在我们的项目中引入element-ui，必须要使用`Vue.use()`注册之后，才能使用element-ui的组件。element-ui的按需引入组件功能也是类似的实现方式。

```
// src/index.js
const install = function(Vue, opts = {}) {
  locale.use(opts.locale);
  locale.i18n(opts.i18n);

  components.forEach(component => {
    Vue.component(component.name, component);
  });

  Vue.use(Loading.directive);

  Vue.prototype.$ELEMENT = {
    size: opts.size || '',
    zIndex: opts.zIndex || 2000
  };

  Vue.prototype.$loading = Loading.service;
  Vue.prototype.$msgbox = MessageBox;
  Vue.prototype.$alert = MessageBox.alert;
  Vue.prototype.$confirm = MessageBox.confirm;
  Vue.prototype.$prompt = MessageBox.prompt;
  Vue.prototype.$notify = Notification;
  Vue.prototype.$message = Message;

};

/* istanbul ignore if */
if (typeof window !== 'undefined' && window.Vue) {
  install(window.Vue);
}

module.exports = {
  version: '2.4.11',
  locale: locale.use,
  i18n: locale.i18n,
  install,
  CollapseTransition,
  Loading,
  Pagination
  //...
}
```

