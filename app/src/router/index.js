import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Manage from "../views/Manage.vue"
import store from "@/store"

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'home',
        component: Home,
        meta: { title: '首页', affix: true, requiresAuth: true },
        redirect: "/paperlist",
        children: [{
                path: '/paperlist',
                component: () =>
                    import ('@/views/student/PaperList.vue')
            },
            {
                path: '/generate/:id',
                component: () =>
                    import ('@/views/student/Generate.vue')
            },
            {
                name: 'stupaperhistory',
                path: '/stu/paperhistory',
                component: () =>
                    import ('@/views/student/PaperHistory.vue')
            },
            {
                name: 'studentpasswd',
                path: '/stu/passwd',
                component: () =>
                    import ('@/views/Profile.vue')
            },
            {
                path: "/stu/profile",
                component: () =>
                    import ('@/views/Profile.vue')
            },
        ]
    },
    {
        path: '/manage',
        component: Manage,
        meta: { title: '首页', affix: true, requiresAuth: true },
        children: [{
                path: '/coursemanage',
                component: () =>
                    import ('@/views/manage/CourseManage.vue')
            },
            {
                path: '/questionmanage/:id',
                component: () =>
                    import ('@/views/manage/QuestionManage.vue')
            },
            {
                path: '/questionscore',
                component: () =>
                    import ('@/views/manage/QuestionScore.vue')
            },
            {
                path: '/papermanage',
                component: () =>
                    import ('@/views/manage/PaperManage.vue')
            },
            {
                path: '/manage/paperhistory',
                component: () =>
                    import ('@/views/manage/PaperHistory.vue')
            },
            // 管理员相关
            {
                path: '/studentmanage',
                component: () =>
                    import ('@/views/manage/StudentManage.vue')
            },
            {
                path: '/teachermanage',
                component: () =>
                    import ('@/views/manage/TeacherManage.vue')
            },
            {
                path: '/adminmanage',
                component: () =>
                    import ('@/views/manage/AdminManage.vue')
            },
            {
                path: "/profile",
                component: () =>
                    import ('@/views/Profile.vue')
            },

        ]

    },
    {
        path: '/login',
        name: 'login',
        component: () =>
            import ('@/views/Login.vue')
    }
]

const router = new VueRouter({
    routes
})
router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        // this route requires auth, check if logged in
        // if not, redirect to login page.
        if (store.getters.user == null) {
            next({
                path: '/login',
                query: { redirect: to.fullPath }
            })
        } else {
            next()
        }
    } else {
        next() // make sure to always call next()!
    }
})
export default router