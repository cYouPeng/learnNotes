## 一、常见定位方案

1. 普通流 (normal flow)

   > 在普通流中，元素按照其在 HTML 中的先后位置自上而下布局，在这个过程中，行内元素水平排列，直到当行被占满然后换行，块级元素则会被渲染为完整的一个新行，除非另外指定，否则所有元素默认都是普通流定位，也可以说，普通流中元素的位置由该元素在 HTML 文档中的位置决定。

2. 浮动 (float)

   >在浮动布局中，元素首先按照普通流的位置出现，然后根据浮动的方向尽可能的向左边或右边偏移，其效果与印刷排版中的文本环绕相似。

3. 绝对定位 (absolute positioning)

   > 在绝对定位布局中，元素会整体脱离普通流，因此绝对定位元素不会对其兄弟元素造成影响，而元素具体的位置由绝对定位的坐标决定。

## 二、BFC 概念

​	Formatting context(格式化上下文) 是 W3C CSS2.1 规范中的一个概念。它是页面中的一块渲染区域，并且有一套渲染规则，它决定了其子元素将如何定位，以及和其他元素的关系和相互作用。

​	那么 BFC 是什么呢？

​	BFC 即 Block Formatting Contexts (块级格式化上下文)，它属于上述定位方案的普通流。

​	**具有 BFC 特性的元素可以看作是隔离了的独立容器，容器里面的元素不会在布局上影响到外面的元素，并且 BFC 具有普通容器所没有的一些特性。**

​	通俗一点来讲，可以把 BFC 理解为一个封闭的大箱子，箱子内部的元素如何翻江倒海，都不会影响到外部。

## 三、触发 BFC

​	只要元素满足下面任一条件即可触发 BFC 特性：

- body 根元素

- 浮动元素：float 除 none 以外的值

- 绝对定位元素：position (absolute、fixed)

- display 为 inline-block、table-cells、flex

- overflow 除了 visible 以外的值 (hidden、auto、scroll)

  

## 四、BFC 特性及应用	

**1. 同一个 BFC 下外边距会发生折叠**

```
<style>
    div{
      width: 100px;
      height: 100px;
      background: lightblue;
      margin: 100px;
    }
  </style>
</head>
<body>
  <div></div>
  <div></div>
</body>
```

![Snipaste_2020-11-21_09-41-58](assets/BFC/Snipaste_2020-11-21_09-41-58.png)

​	从效果上看，因为两个 div 元素都处于同一个 BFC 容器下 (这里指 body 元素) 所以第一个 div 的下边距和第二个 div 的上边距发生了重叠，所以两个盒子之间距离只有 100px，而不是 200px。

​	首先这不是 CSS 的 bug，我们可以理解为一种规范，**如果想要避免外边距的重叠，可以将其放在不同的 BFC 容器中。**

```
<style>
    .container {
      overflow: hidden;
    }
    p {
      width: 100px;
      height: 100px;
      background: lightblue;
      margin: 100px;
    }
  </style>
</head>
<body>
  <div class="container">
    <p></p>
  </div>
  <div class="container">
    <p></p>
  </div>
</body>
```

![Snipaste_2020-11-21_09-48-24](assets/BFC/Snipaste_2020-11-21_09-48-24.png)

**2. BFC 可以包含浮动的元素（清除浮动）**

​	我们都知道，浮动的元素会脱离普通文档流，来看下面一个例子

```
<div style="border: 1px solid #000;">
    <div style="width: 100px;height: 100px;background: #eee;float: left;"></div>
</div>
```

![Snipaste_2020-11-21_10-12-39](assets/BFC/Snipaste_2020-11-21_10-12-39.png)

​	由于容器内元素浮动，脱离了文档流，所以容器只剩下 2px 的边距高度。如果触发容器的 BFC，那么容器将会包裹着浮动元素。

```
<div style="border: 1px solid #000;overflow: hidden">
    <div style="width: 100px;height: 100px;background: #eee;float: left;"></div>
</div>
```

![Snipaste_2020-11-21_10-14-42](assets/BFC/Snipaste_2020-11-21_10-14-42.png)

**3. BFC 可以阻止元素被浮动元素覆盖**

​	先来看一个文字环绕效果：

```
<div style="height: 100px;width: 100px;float: left;background: lightblue">我是一个左浮动的元素</div>
<div style="width: 200px; height: 200px;background: #eee">我是一个没有设置浮动, 
也没有触发 BFC 元素, width: 200px; height:200px; background: #eee;</div>
```

![Snipaste_2020-11-21_10-46-11](assets/BFC/Snipaste_2020-11-21_10-46-11.png)

​	这时候其实第二个元素有部分被浮动元素所覆盖，(但是文本信息不会被浮动元素所覆盖) 如果想避免元素被覆盖，可触第二个元素的 BFC 特性，在第二个元素中加入 **overflow: hidden**，就会变成：

![Snipaste_2020-11-21_10-50-34](assets/BFC/Snipaste_2020-11-21_10-50-34.png)

​	这个方法可以用来实现两列自适应布局，效果不错，这时候左边的宽度固定，右边宽度自适应(需去掉上面第二个容器的宽度)。
