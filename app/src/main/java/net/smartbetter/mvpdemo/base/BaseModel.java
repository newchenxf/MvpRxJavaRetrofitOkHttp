package net.smartbetter.mvpdemo.base;

import net.smartbetter.mvpdemo.http.Http;
import net.smartbetter.mvpdemo.http.HttpService;
import net.smartbetter.mvpdemo.mvp.IModel;

/**
 * Model基类
 *
 * @author gc
 * @since 1.0
 */
public class BaseModel implements IModel {
    protected static HttpService httpService;
    // 初始化HttpService
    static {
        httpService = Http.getHttpService();
    }
}
