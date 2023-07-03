import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/Welcome',
    name: 'Welcome',
    component: () => import(/* webpackChunkName: "Wel", webpackPrefetch:true */ '../views/WelcomeView.vue')
  },
  {
    path: '/databinding/String',
    name: 'DataBinding01',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding01.vue')
  },
  {
    path: '/databinding/HTML',
    name: 'DataBinding02',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding02.vue')
  },
  {
    path: '/databinding/Input',
    name: 'DataBinding03',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding03.vue')
  },
  {
    path: '/databinding/Select',
    name: 'DataBinding04',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding04.vue')
  },
  {
    path: '/databinding/CheckBox',
    name: 'DataBinding05',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding05.vue')
  },
  {
    path: '/databinding/Radio',
    name: 'DataBinding06',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding06.vue')
  },
  {
    path: '/databinding/Attri',
    name: 'DataBinding07',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding07.vue')
  },
  {
    path: '/databinding/List',
    name: 'DataBinding08',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding08.vue')
  },
  {
    path: '/databinding/Class',
    name: 'DataBinding09',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding09.vue')
  },
  {
    path: '/databinding/Style',
    name: 'DataBinding10',
    component: () => import(/* webpackChunkName: "databinding", webpackPrefetch:true */ '../views/1_databinding/DataBinding10.vue')
  },
  {
    path: '/event/Click',
    name: 'EventClick',
    component: () => import(/* webpackChunkName: "Event", webpackPrefetch:true */ '../views/2_event/EventClick.vue')
  },
  {
    path: '/event/Change',
    name: 'EventChange',
    component: () => import(/* webpackChunkName: "Event", webpackPrefetch:true */ '../views/2_event/EventChange.vue')
  },
  {
    path: '/event/Key',
    name: 'EventKey',
    component: () => import(/* webpackChunkName: "Event", webpackPrefetch:true */ '../views/2_event/EventKey.vue')
  },
  {
    path: '/memolist',
    name: 'MemoList',
    component: () => import(/* webpackChunkName: "Memo", webpackPrefetch:true */ '../views/3_memo/MemoList.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
