# MvpRxJavaRetrofitOkHttp

Mvp + RxJava2 + Retrofit2 + OkHttp3，易理解，深度解耦，方便迭代。           

## MVP模式

| 角色 | 说明 |
|:------------- |:------------- |
| Model | 主要做一些数据处理, 网路请求。Presenter 需要通过 Model 层存取、获取数据，Model是封装了数据库 Dao 层或者网络获取数据的角色，或者两种数据获取方式的集合。 |
| Presenter | 交互中间人，核心逻辑，处理 View 的业务逻辑，沟通 View 和 Model 的桥梁，Presenter 持有的 View、Model 引用都是抽象，它从 Model 层检索数据后返回给 View 层，使得 View 和 Model 没有耦合，也将业务逻辑从 View 层抽取出来，经常会执行耗时操作。 |
| View | 用户界面，Activity、Fragment 或者某个 View 控件，含有一个 Presenter 成员变量，通常 View 层需要实现一个逻辑接口，将 View 上的操作通过会转交给 Presenter 进行实现，最后 Presenter 调用 View 逻辑接口将结果返回给 View 元素。 |

可以参考 [http://blog.csdn.net/smartbetter/article/details/70853135](http://blog.csdn.net/smartbetter/article/details/70853135)

## RxJava

RxJava，一个在 Java VM 上使用可观测的序列来组成异步的、基于事件的程序的库。RxJava 的本质可以压缩为异步这一个词，它就是一个实现异步操作的库，而别的定语都是基于这之上的。

可以参考 [http://blog.csdn.net/smartbetter/article/details/68941859](http://blog.csdn.net/smartbetter/article/details/68941859)
[http://gank.io/post/560e15be2dca930e00da1083#toc_1](http://gank.io/post/560e15be2dca930e00da1083#toc_1)

## Retrofit

对OkHttp做了一层封，把网络请求都交给了Okhttp，我们只需要通过简单的配置就能使用Retrofit来进行网络请求了，Retrofit 除了提供了传统的 Callback 形式的 API，还有 RxJava 版本的 Observable 形式 API。

可以参考 [http://blog.csdn.net/bitian123/article/details/51899716](http://blog.csdn.net/bitian123/article/details/51899716)

## OkHttp

一个非常强大的网络请求库。

可以参考 [http://blog.csdn.net/lmj623565791/article/details/47911083](http://blog.csdn.net/lmj623565791/article/details/47911083)

# 包结构如下

- mvp: IView, IModel, IPresenter
- contract: 契约类, 接口定义
- model: LoginModel
- presenter: LoginPresenter
- view: Activity, Fragment, etc.
- base: BaseAcitivity, BasePresenter, etc.
- observer: 观察者(订阅者)
- transformer: 转换器
- http: 网络请求的封装
- exception: 自定义异常
