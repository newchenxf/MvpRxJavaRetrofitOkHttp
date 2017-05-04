package net.smartbetter.mvpdemo.http;

import net.smartbetter.mvpdemo.base.BaseHttpResult;
import net.smartbetter.mvpdemo.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 网络请求的接口都在这里
 *
 * @author gc
 * @since 1.0
 */

public interface HttpService {
    /** 登录接口 */
    @FormUrlEncoded
    @POST("v2/590b00f3290000de0723d9c3")
    Observable<BaseHttpResult<LoginBean>> login(@Field("username") String username,
                                                @Field("password") String pwd);
}
