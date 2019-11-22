import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Welcome from '@/views/Welcome'
import Login from '@/views/Login'
import Map from '@/views/Map'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome
    },
    {
      path:'/login',
      name:'Login',
      component:Login
    },
    {
      path:'/map',
      name:'Map',
      component:Map
    }
  ]
})
