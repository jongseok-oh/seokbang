import Vue from 'vue'
import VueRouter from 'vue-router'
import BoardView from '@/views/BoardView.vue'
import PostView from '@/views/PostView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/board'
  },
  {
    path: '/board',
    name: 'board',
    component: BoardView,
    
  },
  {
    path: '/post',
    name: 'post',
    component: PostView,

    children: [
      {
        path: 'regForm' ,
        component:() => import('@/components/PostForm')
      },
      {
        path: 'detail/:no',
        component:() => import('@/components/PostDetail')
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
