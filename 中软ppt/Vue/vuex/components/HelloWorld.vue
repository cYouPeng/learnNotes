<template>
  <div class="hello">
    {{getName}}--{{age}}--{{addr}}
    <button @click="setName('陈有朋')">add</button>
  </div>
</template>

<script>
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex';
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
  
    }
  },
  computed: {
    ...mapGetters(['getName', 'getAge']),
    ...mapState(['name', 'age', 'addr']),  //两行代码相当于下面的15行代码
    // name(){
    //   return this.$store.state.name
    // },
    // age(){
    //   return this.$store.state.age
    // },
    // addr(){
    //   return this.$store.state.addr
    // }
    // getName(){
    //   return this.$store.getters.getName
    // },
    // getAge(){
    //   return this.$store.getters.getAge
    // }
  },
  methods: {
    // ...mapMutations(['setName', 'setAge']), //相当于下面6行代码
    // setName(newName){
    //   this.$store.commit('setName', newName)
    // },
    // setAge(){
    //   this.$store.commit('setAge')
    // },
    ...mapActions(['setName']),
    // setName(newName){
    //   this.$store.dispatch('setName', newName)
    // },
    hello(){     
      console.log(this.getName)
      console.log(this.getAge)
      // console.log(this.addr)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
