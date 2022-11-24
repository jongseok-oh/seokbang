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
import NoticeBoard from '@/components/notice/NoticeBoard.vue'
import NoticeDetail from '@/components/notice/NoticeDetail.vue'
import NoticeWriteForm from '@/components/notice/NoticeWriteForm.vue'
import NoticeModifyForm from '@/components/notice/NoticeModifyForm.vue'
import UserView from '@/views/UserView.vue'

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
      {
        path: '/notice',
        name: 'notice',
        component: NoticeBoard
      },
      {
        path: '/noticedetail',
        name: 'noticedetail',
        component: NoticeDetail
      },
      {
        path: '/noticewriteform',
        name: 'noticewriteform',
        component: NoticeWriteForm
      },
      {
        path: '/noticemodifyform',
        name: 'noticemodifyform',
        component: NoticeModifyForm
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => {
		if (err.name !== 'NavigationDuplicated') throw err;
	});
};

export default router
