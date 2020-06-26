package com.example.iddogs.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.data.repository.AuthorizationRepositoryImpl
import com.example.data.repository.CacheRepositoryImpl
import com.example.domain.interactor.EmailValidator
import com.example.domain.interactor.PostLogin
import com.example.domain.interactor.PutCacheObject
import com.example.iddogs.R
import com.example.iddogs.core.BaseActivity
import com.example.iddogs.core.IDdogsApp
import com.example.iddogs.core.Navigator
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {

    private val presenter = LoginPresenter(Navigator((this)),
                                            PostLogin(AuthorizationRepositoryImpl()),
                                            EmailValidator(),
                                            PutCacheObject(CacheRepositoryImpl(this)))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attachView(this)

        loginBtn.setOnClickListener {
            presenter.logUserIn(email.text.toString())
        }
    }

    override fun showUnauthorizedError() {
        Toast.makeText(this, getString(R.string.login_unauthorized_error), Toast.LENGTH_SHORT).show()
    }

    override fun showInvalidEmailError() {
        Toast.makeText(this, getString(R.string.invalid_email_error), Toast.LENGTH_SHORT).show()
    }

}