package net.smartbetter.mvpdemo.presenter;

import net.smartbetter.mvpdemo.activity.LoginActivity;
import net.smartbetter.mvpdemo.base.BasePresenter;
import net.smartbetter.mvpdemo.bean.LoginBean;
import net.smartbetter.mvpdemo.contract.LoginContract;
import net.smartbetter.mvpdemo.model.LoginModel;
import net.smartbetter.mvpdemo.mvp.IModel;

import java.util.HashMap;

/**
 * 登录的Presenter, 交互中间人, 处理View的业务逻辑, 它是沟通View和Model的桥梁
 *
 * @author gc
 * @since 1.0
 */
public class LoginPresenter extends BasePresenter<LoginActivity> implements
        LoginContract.LoginPresenter {
    @Override
    public void login(String name, String pwd) {
        if (!getIView().checkNull()) {
            ((LoginModel) getiModelMap().get("login")).login(name, pwd, new LoginModel
                    .DataListener<LoginBean>() {
                @Override
                public void successInfo(LoginBean result) {
                    getIView().loginSuccess(result);  //成功
                }

                @Override
                public void failInfo(String result) {
                    getIView().loginFail(result);  //失败
                }
            });
        }
    }

    @Override
    public HashMap<String, IModel> getiModelMap() {
        return loadModelMap(new LoginModel());
    }

    @Override
    public HashMap<String, IModel> loadModelMap(IModel... models) {
        HashMap<String, IModel> map = new HashMap<>();
        map.put("login", models[0]);
        return map;
    }
}
