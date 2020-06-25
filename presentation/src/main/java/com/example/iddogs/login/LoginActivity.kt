package com.example.iddogs.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iddogs.R
import com.example.iddogs.core.BaseActivity
import com.example.iddogs.core.Navigator

class LoginActivity : BaseActivity(), LoginView {

    private val presenter = LoginPresenter(Navigator((this)))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attachView(this)
    }

}