package br.com.guiarese.calculadoraflex.ui.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.guiarese.calculadoraflex.R
import br.com.guiarese.calculadoraflex.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val NEW_USER_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btSignup.setOnClickListener({
            val criarConta = Intent(this, SignUpActivity::class.java)
            startActivityForResult(criarConta, NEW_USER_REQUEST)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            NEW_USER_REQUEST -> {
                when(resultCode){
                    Activity.RESULT_OK -> {
                        inputLoginEmail
                            .setText(data?.getStringExtra("email"))
                    }
                }
            }
            else -> {}
        }
    }
}
