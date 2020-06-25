package com.example.iddogs.login

import com.example.domain.interactor.EmailValidator
import com.example.domain.interactor.PostLogin
import com.example.domain.interactor.PutCacheObject
import com.example.domain.model.LoginDomain
import com.example.domain.model.UserDomain
import com.example.iddogs.core.BasePresenter
import com.example.iddogs.core.Navigator

class LoginPresenter (
    private val navigator: Navigator,
    private val postLogin: PostLogin,
    private val emailValidator: EmailValidator,
    private val putCacheObject: PutCacheObject) : BasePresenter<LoginView>() {

    fun logUserIn(email : String) {
        view?.showLoading()
        if (isEmailValid(email)) {
            val requestBody = LoginDomain(email)
            postLogin
                .with(requestBody)
                .execute()
                .subscribe({
                    saveUserOnCache(it)
                    view?.hideLoading()
                    navigator.navigateRacesList()
                }, {
                    view?.hideLoading()
                    view?.showUnauthorizedError()
                })
        } else {
            view?.hideLoading()
            view?.showInvalidEmailError()
        }
    }

    fun isEmailValid(email : String) : Boolean {
        return emailValidator
            .with(email)
            .execute()
    }

    fun saveUserOnCache(user : UserDomain) {
        putCacheObject
            .with(user)
            .execute()
    }
}