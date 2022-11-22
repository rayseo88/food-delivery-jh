
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import StoreOrderManager from "./components/listers/StoreOrderCards"
import StoreOrderDetail from "./components/listers/StoreOrderDetail"
import MenuManager from "./components/listers/MenuCards"
import MenuDetail from "./components/listers/MenuDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import NotificationLogManager from "./components/listers/NotificationLogCards"
import NotificationLogDetail from "./components/listers/NotificationLogDetail"
import EvaluationManager from "./components/listers/EvaluationCards"
import EvaluationDetail from "./components/listers/EvaluationDetail"

import OrderStatusView from "./components/OrderStatusView"
import OrderStatusViewDetail from "./components/OrderStatusViewDetail"
import TopFoodView from "./components/TopFoodView"
import TopFoodViewDetail from "./components/TopFoodViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/storeOrders',
                name: 'StoreOrderManager',
                component: StoreOrderManager
            },
            {
                path: '/storeOrders/:id',
                name: 'StoreOrderDetail',
                component: StoreOrderDetail
            },
            {
                path: '/menus',
                name: 'MenuManager',
                component: MenuManager
            },
            {
                path: '/menus/:id',
                name: 'MenuDetail',
                component: MenuDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/notificationLogs',
                name: 'NotificationLogManager',
                component: NotificationLogManager
            },
            {
                path: '/notificationLogs/:id',
                name: 'NotificationLogDetail',
                component: NotificationLogDetail
            },
            {
                path: '/evaluations',
                name: 'EvaluationManager',
                component: EvaluationManager
            },
            {
                path: '/evaluations/:id',
                name: 'EvaluationDetail',
                component: EvaluationDetail
            },

            {
                path: '/orderStatuses',
                name: 'OrderStatusView',
                component: OrderStatusView
            },
            {
                path: '/orderStatuses/:id',
                name: 'OrderStatusViewDetail',
                component: OrderStatusViewDetail
            },
            {
                path: '/topFoods',
                name: 'TopFoodView',
                component: TopFoodView
            },
            {
                path: '/topFoods/:id',
                name: 'TopFoodViewDetail',
                component: TopFoodViewDetail
            },


    ]
})
