**在官方文档中，我们可以知道el-tree要实现异步加载节点需要用到load、lazy属性。**

- loda: 加载子树数据的方法，仅当 lazy 属性为true 时生效。
- lazy: 是否懒加载子节点，需与 load 方法结合使用。

**在methods中，loadNode方法给我们返回了两个参数：**

- node：返回当前节点的数据
- resolve: b用来获取到节点数据后渲染使用的

```
<el-tree
      ref="tree"
      :props="props"
      :load="loadNode"
      node-key="id"  // node-key 为所有节点之前的唯一标识
      :default-expanded-keys="nodeIdArr"
      // nodeIdArr为异步加载时默认展开时的节点arr,从第一个根节点到最后展开节点的id，例如[1, 2, 12]
      lazy
      :highlight-current="true" // 点击高亮
      @node-click="handleNodeClick" // 点击事件，每次点击节点是都会触发，放回当前节点的node
    >
</el-tree>
```

```
export default {
  data() {
    return {
      props: {
        label: 'nodeName',// 节点渲染时的显示的名字
        children: 'zones', // 节点是否拥有子节点
        isLeaf: 'leaf', // 判断显示节点icon
      },
      resData: [],
      nodeIdArr: [],
      showNodeId: Number,
      nodeId: Number,
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    async init() {
      await this.getUserLocation();
    },
    // 点击选取事件
    handleNodeClick(data, node) {
      console.log('data', data, node);
      this.nodeId = node.data.id;
    },
    // 异步树叶子节点懒加载逻辑
    async loadNode(node, resolve) {
      // 一级节点处理
      if (node.level === 0) {
        await this.requestTree(resolve);
      }
      // 其余节点处理
      if (node.level >= 1) {
        this.getIndex(node, resolve);
      }
    },
    // 异步加载叶子节点数据函数
    async getIndex(node, resolve) {
      const nodeId = node.data.id;
      await this.requestData(nodeId);
      resolve(this.resData);
    },
    // 首次加载一级节点数据函数
    async requestTree(resolve) {
      await this.requestData(0);
      resolve(this.resData);
    },
    // 获取该节点下的字节点
    async requestData(val) {
      const res = await this.$api.org.node.allChildNodeByParent(val, { dismissLoading: true });
      const resDatas = res.data.data;
      _.forEach(resDatas, item => {
      // 赋值节点数据，用于显示节点icon
        if (item.childCount === 0) {
          item.leaf = true; // 不为叶子节点
        } else {
          item.leaf = false; // 为叶子节点
        }
      });
      this.resData = resDatas;
      if (val === this.showNodeId) {
      // 这一步为了懒加载中等节点渲染完毕后点击到我们需要的节点上去
        this.$refs.tree.setCurrentKey(this.showNodeId);
      }
    },
    // 获取到本帐号所对应位置的nodeId数组
    async getUserLocation() {
      const res = await this.$api.org.node.getUserLocation({ dismissLoading: true });
      if (res.data.code === 0) {
        this.nodeIdArr = res.data.data;
        // showNodeId 为了后期节点渲染成功后点击到需要的节点上做准备
        this.showNodeId = res.data.data[res.data.data.length - 1];
      } else {
        this.$message({
          message: res.data.msg,
          type: 'error',
        });
      }
    },
  },
};
</script>
```

```
//设置tree的全部展开和折叠。state参数为bool值
setAllExpand(state){
    var nodes=this.$refs.tree.store.nodesMap
    for(var i in nodes){
    	nodes[i].expanded=state;
    }
}
```

调用方法：

​	this.setAllExpand(true)

​	或：

​	this.setAllExpand(false)