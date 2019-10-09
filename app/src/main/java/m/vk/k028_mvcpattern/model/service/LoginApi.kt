package m.vk.k028_mvcpattern.model.service

import android.os.Handler
import m.vk.k028_mvcpattern.model.UserModel
import m.vk.k028_mvcpattern.model.interfaces.ILoginResult
class LoginApi(private val username: String,private val password: String,private val  iLoginResult: ILoginResult) {
    private var userModel: UserModel = UserModel(username,password)
    private var mHandler: Handler = Handler()

    /*private var userModel: UserModel
    private var mHandler: Handler
    init {
        userModel = UserModel(username,password)
        mHandler = Handler()
    }*/


    fun doLogin(){
        if (userModel.checkUserValidity(username,password)){
            //check your server login
            mHandler.postDelayed({
                iLoginResult.onLoginResult("Login successful.")
            },3000)
        }else{
            iLoginResult.onLoginResult("Login fail check enter username and password.")
        }
    }
}