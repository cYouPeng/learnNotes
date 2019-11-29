import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {  //this.$store.state.name
        name: 'Jack',
        age: 18,
        addr: 'newrok'
    },
    getters: {  //this.$store.getters.getName
        getName(state){
            return state.name + 'Bean';
        },
        getAge(state){
            return state.age + 'age'
        }
    },
    mutations: { //this.$store.commit("setName")
        setName(state, newName){
            state.name = newName
        },
        setAge(state, newAge){
            state.age = newAge;
        }
    },
    actions: { //this.$store.dispatch("setName")
        setName(context, newName){
            context.commit('setName', newName);
        }
    }
})

export default store