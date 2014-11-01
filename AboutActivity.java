package com.anjoyo.lifeassistant.activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author 张可
 *@version 1.0
 */
public class AboutActivity extends Activity{
	private Button mBtn_About;//返回键
	private TextView mTv_Version;//版本号
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homeposter_about);
		mBtn_About=(Button) findViewById(R.id.btn_about_back);
		mTv_Version=(TextView) findViewById(R.id.about_version);
		/**
		 * 返回按钮监听
		 * */
		mBtn_About.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		/**
		 * 绑定版本
		 * */
		try {
			mTv_Version.setText("当前版本："+getVersionName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取版本号
	 * 
	 * */
	 private String getVersionName() throws Exception
	   {
	           // 获取packagemanager的实例
	           PackageManager packageManager = getPackageManager();
	           // getPackageName()是你当前类的包名，0代表是获取版本信息
	           PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),0);
	           String version = packInfo.versionName;
	           return version;
	   }
	 

}
