import Vue from 'vue'
import VueRouter from 'vue-router'
import BoardView from '@/views/BoardView.vue'
import MainView from '@/views/MainView.vue'
import DealInfoView from '@/views/DealInfoView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name : 'main',
    component: MainView,
  },
  {
    path: '/dealinfo',
    name: 'dealinfo',
    component: DealInfoView,
    
  },
  {
    path: '/board',
    name: 'board',
    component: BoardView,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
