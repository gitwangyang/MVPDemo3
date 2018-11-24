package com.dotawang.mvpdemo3.view.main;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.dotawang.mvpdemo3.R;
import com.dotawang.mvpdemo3.base.BaseMvpActivity;
import com.dotawang.mvpdemo3.base.BaseMvpPresenter;
import com.dotawang.mvpdemo3.model.login.User;
import com.dotawang.mvpdemo3.presenter.main.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainView {

    @BindView(R.id.webview)
    WebView mWebView;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mWebView.loadUrl("file:////android_asset/index.html");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//打开js支持
        /**
         * 打开js接口給H5调用，参数1为本地类名，参数2为别名；h5用window.别名.类名里的方法名才能调用方法里面的内容，例如：window.android.back();
         * */
        mWebView.addJavascriptInterface(new AndroidAndJSInterface(), "Android");
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());

    }

    @Override
    protected void onPrepare() {
        if (null!= presenter){
        }
    }

    @Override
    public void setContent() {
        Log.i(getClass().getSimpleName(), "Main测试成功");
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @OnClick({R.id.btn})
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn:
                //1、直接访问H5里不带返回值的方法，show()为H5里的方法
//                mWebView.loadUrl("JavaScript:show()");

                //2、传固定字符串可以直接用单引号括起来
                //访问H5里带参数的方法，alertMessage(message)为H5里的方法
//                mWebView.loadUrl("javascript:alertMessage('哈哈')");

                //3、当出入变量名时，需要用转义符隔开
//                String content = "9880";
//                mWebView.loadUrl("javascript:alertMessage(\"" + content + "\")");
//                //Android调用有返回值js方法，安卓4.4以上才能用这个方法
//                mWebView.evaluateJavascript("sum(1,2)", new ValueCallback<String>() {
//                    @Override
//                    public void onReceiveValue(String value) {
//                        Log.d("MainActivity", "js返回的结果为=" + value);
//                        Toast.makeText(MainActivity.this, "js返回的结果为=" + value, Toast.LENGTH_LONG).show();
//                    }
//                });

                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestSuccessData(User data) {

    }

    /**
     * 自己写一个类，里面是提供给H5访问的方法
     */
    public class AndroidAndJSInterface {
        //一定要写，不然H5调不到这个方法
        @JavascriptInterface
        public String back() {
            return "我是java里的方法返回值";
        }
    }
}
