import Vue from 'vue'
import VueRouter from 'vue-router'
import HouseItemView from '@/views/HouseItemView.vue'
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
    path: '/houseitem',
    name: 'houseitem',
    component: HouseItemView,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
