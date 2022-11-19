import Vue from 'vue'
import VueRouter from 'vue-router'
import BoardView from '@/views/BoardView.vue'
import MainView from '@/views/MainView.vue'
import DealInfoView from '@/views/DealInfoView.vue'
import PostList from '@/components/PostList.vue'
import PostWriteForm from '@/components/PostWriteForm.vue'

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

    children: [
      {
        path: '/',
        name: 'postlist',
        component: PostList
      },
      {
        path: '/postwriteform',
        name: 'postwriteform',
        component: PostWriteForm
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
