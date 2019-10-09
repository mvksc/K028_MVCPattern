package m.vk.k028_mvcpattern.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*
import m.vk.k028_mvcpattern.R
import m.vk.k028_mvcpattern.model.interfaces.ILoginResult
import m.vk.k028_mvcpattern.model.service.LoginApi

class LoginFragment : Fragment(),ILoginResult{
    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment().apply {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvLogin.setOnClickListener{
            onLogin()
        }
    }
    private fun onLogin(){
        pbLogin.visibility = View.VISIBLE
        var username = edUsername.text.toString()
        var password = edPassword.text.toString()
        var loginApi = LoginApi(username,password,this)
        loginApi.doLogin()
    }
    override fun onLoginResult(result: String) {
        pbLogin.visibility = View.GONE
        Toast.makeText(activity,result,Toast.LENGTH_SHORT).show()
    }
}
