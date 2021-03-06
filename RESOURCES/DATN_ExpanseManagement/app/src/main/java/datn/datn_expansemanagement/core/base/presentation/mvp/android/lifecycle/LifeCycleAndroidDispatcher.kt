package datn.datn_expansemanagement.core.base.presentation.mvp.android.lifecycle

import datn.datn_expansemanagement.core.base.presentation.mvp.base.lifecycle.LifeCycleDispatcherSetter

class LifeCycleAndroidDispatcher : LifeCycleAndroidMvpView,
    LifeCycleDispatcherSetter<LifeCycleAndroidMvpView> {

    override fun isHandleBackPressed(): Boolean {
        var isHandleBackPressed = false
        lifeCycleSet.forEach { lifeCycle -> isHandleBackPressed = lifeCycle.isHandleBackPressed() }
        return isHandleBackPressed
    }

    private val lifeCycleSet = mutableSetOf<LifeCycleAndroidMvpView>()

    override fun addLifeCycle(lifeCycle: LifeCycleAndroidMvpView) {
        lifeCycleSet.add(lifeCycle)
    }

    override fun initMvpView() {
        lifeCycleSet.forEach { lifeCycle -> lifeCycle.initMvpView() }
    }

    override fun startMvpView() {
        lifeCycleSet.forEach { lifeCycle -> lifeCycle.startMvpView() }
    }

    override fun initData() {
        lifeCycleSet.forEach { lifeCycle -> lifeCycle.initData() }
    }

    override fun stopMvpView() {
        lifeCycleSet.forEach { lifeCycle -> lifeCycle.stopMvpView() }
    }

    override fun onViewResult(viewResult: ViewResult) {
        lifeCycleSet.forEach { lifeCycle -> lifeCycle.onViewResult(viewResult) }
    }

    override fun onRequestPermissionsResult(permissionsResult: PermissionsResult) {
        lifeCycleSet.forEach { lifeCycle -> lifeCycle.onRequestPermissionsResult(permissionsResult) }
    }
}