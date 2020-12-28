## 1  , border-image

border-image CSS3属性允许在元素的边框上绘制图像

border-image 通过指定一张图片来取替 border-style 定义的样式，但 **border-image 生效的前提是： border-style 和 border-width 同时为有效值(即 border-style 不为 none，border-width 不为 0)。**

初始值

- [`border-image-source`](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-image-source): `none`
- [`border-image-slice`](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-image-slice): `100%`
- [`border-image-width`](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-image-width): `1`
- [`border-image-outset`](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-image-outset): `0`
- [`border-image-repeat`](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-image-repeat): `stretch`

是否是继承属性: 否

```html
/* border-image: border-image-source border-image-slice border-image-repeat */
border-image: url('./border.png') 27 fill stretch
```



## 2  ,  border-image-source

用于声明元素的边框图片（border-image）的资源 

```
border-image-source: none;
border-image-source: url('/media/examples/border-stars.png');
border-image-source: linear-gradient(to top, red, yellow);
```



## 3  ,  border-image-slice

通过[`border-image-source`](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-image-source) 引用边框图片后，**`border-image-slice`**属性会将图片分割为9个区域

![border-image-slice](assets/border-image/border-image-slice.png)

* 区域 1-4 为角区域（corner region）。 每一个都用一次来形成最终边界图像的角点

* 区域 5-8 边区域（edge region）。在最终的边框图像中重复，缩放或修改它们以匹配元素的尺寸

* 区域 9 为中心区域（ middle region）。它在默认情况下会被丢弃，但如果设置了关键字`fill`，则会将其用作背景图像

**边框图片被切割成 9 个部分，以一一对应的关系放到div边框的九宫格中，然后再压缩（或拉伸）至边框（border-width 或 border-image-width）的宽度大小**



## 4  ,  border-image-width

指定了边界图像 (border image) 的宽度

上面咱们说了，被slice分割的部分会去适应 border-width 的宽度(拉伸或是压缩)，而指定了 border-image-width ，那么分割的部分就会去适应它的宽度

```
border-image-width: 30px;
border-image-width: 20% 8%;
border-image-width: auto;
```

auto: 将等同于内部对应的 [`border-image-slice`](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-image-slice) 的宽或高（可用的话）。如果图像没有需要的相应的属性，将相对于 `border-width` 进行指定



## 5  ,  border-image-repeat

`border-image-repeat `定义图片如何填充边框。或为单个值，设置所有的边框；或为两个值，分别设置水平与垂直的边框

#### 平铺和重复的区别

>平铺可能会改变原图片显示的大小，重复不会改变原图片显示的大小
>
>您从万科地产买了个99.5m\*99.5m的毛坯房，地面要贴瓷砖，都是1m\*1m的正方形瓷砖。如果是“平铺”，对不起，这1m边长的瓷砖不行，要处理！怎么处理法？很简单，每个瓷砖压成0.995m\*0.995m的，这样就可以了，所以，平铺就是以完整的单元铺满整个区域。如果是重复，就直接把这1m*1m的瓷砖从一个角落一个一个的放置，放到头放不下了怎么办？直接把瓷砖从中间“咔”掉，于是最后会在房子的边角看到很多半截的瓷砖



## 6  ,  border-image-outset

border-image-outset 属性定义边框图像可超出边框盒的大小。

```
border-image-outset: 30%;

/* border-image-outset: 顶 水平 底 */
border-image-outset: 30px 30% 45px;
```







### 实例

```
::v-deep .el-dialog{
  background:none;
  border-width: 86px 24px 23px 22px;
  border-style: solid;
  border-color: transparent;
  border-image-source: url('./../assets/images/dialogBg.png');
  border-image-slice: 86 24 23 22 fill;
  
}
```

