import Vue from 'vue'
import VueRouter from 'vue-router'
import BoardView from '@/views/BoardView.vue'
import MainView from '@/views/MainView.vue'
import DealInfoView from '@/views/DealInfoView.vue'
import PostList from '@/components/board/PostList.vue'
import PostDetail from '@/components/board/PostDetail.vue'
import PostWriteForm from '@/components/board/PostWriteForm.vue'
import LoginForm from '@/components/user/LoginForm.vue'
import SignupForm from '@/components/user/SignupForm.vue'
import PostModifyForm from '@/components/board/PostModifyForm.vue'
import UserModifyForm from '@/components/user/ModifyForm.vue'
import UserView from '@/views/UserView.vue';

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
    path: '/user',
    name: 'user',
    component: UserView,

    children: [
      {
        path: '/loginForm',
        name: 'loginForm',
        component: LoginForm
      },
      {
        path: '/signupform',
        name: 'signupform',
        component: SignupForm
      },
      {
        path: '/usermodifyform',
        name: 'usermodifyform',
        component: UserModifyForm
      },
    ]
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
        path: '/postdetail',
        name: 'postdetail',
        component: PostDetail
      },
      {
        path: '/postwriteform',
        name: 'postwriteform',
        component: PostWriteForm
      },
      {
        path: '/postmodifyform',
        name: 'postmodifyform',
        component: PostModifyForm
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
