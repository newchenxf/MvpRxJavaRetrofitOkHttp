package net.smartbetter.mvpdemo.model;

import android.support.annotation.NonNull;

import net.smartbetter.mvpdemo.ProApplication;
import net.smartbetter.mvpdemo.base.BaseModel;
import net.smartbetter.mvpdemo.bean.LoginBean;
import net.smartbetter.mvpdemo.exception.ApiException;
import net.smartbetter.mvpdemo.observer.CommonObserver;
import net.smartbetter.mvpdemo.transformer.CommonTransformer;

/**
 * 登录的Model, 主要做一些数据处理, 网路请求
 *
 * @author gc
 * @since 1.0
 */
public class LoginModel extends BaseModel {
    private boolean isLogin = false;

    public boolean login(@NonNull String username, @NonNull String pwd, @NonNull final DataListener
            listener) {
        if (listener == null) {
            throw new RuntimeException("InfoHint不能为空");
        }
        httpService.login(username, pwd)
                .compose(new CommonTransformer<LoginBean>())
                .subscribe(new CommonObserver<LoginBean>(ProApplication.getContext()) {

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull LoginBean loginBean) {
                        isLogin = true;
                        listener.successInfo(loginBean);
                    }

                    @Override
                    protected void onError(ApiException e) {
                        super.onError(e);
                        isLogin = false;
                        listener.failInfo(e.message);
                    }
                });
        return isLogin;
    }

    /**
     * 通过接口产生信息回调
     *
     * @param <T>
     */
    public interface DataListener<T> {
        void successInfo(T result);
        void failInfo(String result);
    }
}
