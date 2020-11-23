exec() 方法就是用来检索字符串中正则表达式的匹配，如果匹配到了那么就返回一个存放有结果的数组，如果没有匹配到就返回一个null

首先说下test()和match()

test()用于检测一个字符串是否匹配某个模式，如果匹配返回true，不匹配返回false

match()方法可在字符串内检索指定的值，或找到一个或多个正则表达式的匹配

match()方法可以进行一次或多次模式匹配，将匹配结果按照一个数组进行返回（使用单次匹配还是多次匹配这取决于在匹配模式中是否含有g）

注：在调用非全局的 RegExp 对象的 exec() 方法时，返回的数组与调用方法 String.match() 返回的数组是相同的

---

exec方法返回的数组的第 0 个元素是与正则表达式相匹配的文本

第 1 个元素是与 RegExpObject 的第 1 个子表达式相匹配的文本（如果有的话）

第 2 个元素是与 RegExpObject 的第 2 个子表达式相匹配的文本（如果有的话）

...

以此类推。

```
let str = '你好abc朋友abc我是abc救世主'
let reg = /(a(b)c)/
console.log(reg.exec(str))
console.log(str.match(reg))
```

![企业微信截图_16061153129670](assets/exec()/企业微信截图_16061153129670.png)

除了数组元素和 length 属性之外，exec() 方法还返回两个属性。

　　index 属性声明的是匹配文本的第一个字符的位置。

　　input 属性则存放的是被检索的字符串 string。

可以看得出：在调用非全局的 RegExp 对象的 exec() 方法时，返回的数组与调用方法 String.match() 返回的数组是相同的。

ES2018 引入了具名组匹配（Named Capture Groups），允许为每一个组匹配指定一个名字，既便于阅读代码，又便于引用。

```
let str = '你好abc朋友ba我是abc救世主'
let reg = /(?<first>a(?<second>b)c)|(?<third>ba)/g
console.log(reg.exec(str))
console.log(reg.exec(str))
```

写在每一个小括号内，格式为 ?\<xxx>

如果具名组没有匹配，那么对应的`groups`对象属性会是`undefined`![企业微信截图_16061174624985](assets/exec()/企业微信截图_16061174624985.png)

##### 解构赋值和替换

有了具名组匹配以后，可以使用解构赋值直接从匹配结果上为变量赋值

```
let str = '你好abc朋友ba我是abc救世主'
let reg = /(?<first>a(?<second>b)c)|(?<third>ba)/g
let { groups: {first,second} } = reg.exec(str)
console.log(first,second)
```

![企业微信截图_16061175985809](assets/exec()/企业微信截图_16061175985809.png)

字符串替换时，使用`$<组名>`引用具名组。

```
let re = /(?<year>\d{4})-(?<month>\d{2})-(?<day>\d{2})/u;

'2015-01-02'.replace(re, '$<day>/$<month>/$<year>')
// '02/01/2015'
```

上面代码中，`replace`方法的第二个参数是一个字符串，而不是正则表达式。

`replace`方法的第二个参数也可以是函数，该函数的参数序列如下。

```
'2015-01-02'.replace(re, (
   matched, // 整个匹配结果 2015-01-02
   capture1, // 第一个组匹配 2015
   capture2, // 第二个组匹配 01
   capture3, // 第三个组匹配 02
   position, // 匹配开始的位置 0
   S, // 原字符串 2015-01-02
   groups // 具名组构成的一个对象 {year, month, day}
 ) => {
 let {day, month, year} = groups;
 return `${day}/${month}/${year}`;
});
```

当有多个组，就会在capture3后增加capture4，cpature5等等

但是，当 RegExpObject 是一个全局正则表达式时，exec() 的行为就稍微复杂一些。它会在 RegExpObject 的 lastIndex 属性指定的字符处开始检索字符串 string。当 exec() 找到了与表达式相匹配的文本时，在匹配后，它将把 RegExpObject 的 lastIndex 属性设置为匹配文本的最后一个字符的下一个位置。这就是说，您可以通过反复调用 exec() 方法来遍历字符串中的所有匹配文本。当 exec() 再也找不到匹配的文本时，它将返回 null，并把 lastIndex 属性重置为 0。

```
let str = '你好abc朋友ba我是abc救世主'
let reg = /abc|ba/g
console.log('--------------------'+reg.lastIndex)
console.log(reg.exec(str))
console.log('--------------------'+reg.lastIndex)
console.log(reg.exec(str))
console.log('--------------------'+reg.lastIndex)
console.log(reg.exec(str))
console.log('--------------------'+reg.lastIndex)
console.log(reg.exec(str))
console.log('--------------------'+reg.lastIndex)
```

![企业微信截图_16061159329103](assets/exec()/企业微信截图_16061159329103.png)

由上图可知，当第4个 console.log(reg.exec(str)) 没有匹配到，所以返回了null,lastIndex 也会重置为0，下一次调用时，又从头开始匹配了。

注意：如果在一个字符串中完成了一次模式匹配之后要开始检索新的字符串，就必须手动地把 lastIndex 属性重置为 0。

```
let str = '你好abc朋友ba我是abc救世主'
let reg = /abc|ba/g
console.log('--------------------'+reg.lastIndex)
console.log(reg.exec(str))
console.log('--------------------'+reg.lastIndex)
console.log(reg.exec(str))
console.log('--------------------'+reg.lastIndex)
reg.lastIndex = 0
console.log(reg.exec(str))
console.log('--------------------'+reg.lastIndex)
console.log(reg.exec(str))
console.log('--------------------'+reg.lastIndex)
```

![企业微信截图_1606116276820](assets/exec()/企业微信截图_1606116276820.png)

在第二次匹配之后，把 reg.lastIndex 重置为0，所以它又重新检索了

提示：请注意，无论 RegExpObject 是否是全局模式，exec() 都会把完整的细节添加到它返回的数组中。这就是 exec() 与 String.match() 的不同之处，后者在全局模式下返回的信息要少得多。因此我们可以这么说，在循环中反复地调用 exec() 方法是唯一一种获得全局模式的完整模式匹配信息的方法。



