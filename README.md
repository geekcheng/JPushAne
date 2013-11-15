JPushAne
========

1.AneNativeLib包括Android层源代码文件以及libs的jar包（ane，jpush）和so文件（jpush）。

2.Aslib 是AS3代码源文件，充当了Flex手机应用与android Native层交互的中间层

3.HelloFlex 是测试的Demo，界面相对简单，三个Button以及两个展示通知消息和自定义消息的Label

4.PackageAneFolder 是用来打包ane的一些配置文件和bat打包脚本，由于ane不支持多个jar包，所以jarpackage有用来合并第三方jar包的bat脚本（jpush的jar包就是第三方jar包）

5.app.xml的配置，修改Your_Package_Name 和 Your_Appkey
	
 (1)

	      <application>
				<service
		            android:name="cn.jpush.android.service.PushService"
		            android:enabled="true"
		            android:exported="false" >
		            <intent-filter>
		                <action android:name="cn.jpush.android.intent.REGISTER" />
		                <action android:name="cn.jpush.android.intent.REPORT" />
		                <action android:name="cn.jpush.android.intent.PushService" />
		                <action android:name="cn.jpush.android.intent.PUSH_TIME" />
		            </intent-filter>
		        </service>
				<receiver
		            android:name="cn.jpush.android.service.PushReceiver"
		            android:enabled="true" >
		          <intent-filter android:priority="1000"> <!--since 1.3.5 -->
		                <action android:name="cn.jpush.android.intent.NOTIFICATION_RECEIVED_PROXY" /> <!--since 1.3.5 -->
		                <category android:name="Your_Package_Name" /> <!--since 1.3.5 -->
		            </intent-filter> <!--since 1.3.5 -->
		            <intent-filter>
		                <action android:name="android.intent.action.USER_PRESENT" />
		                <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
		            </intent-filter>
		            <intent-filter>
		                <action android:name="android.intent.action.PACKAGE_ADDED" />
		                <action android:name="android.intent.action.PACKAGE_REMOVED" />
		                <data android:scheme="package" />
		            </intent-filter>
		        </receiver>
		        <activity
		            android:name="cn.jpush.android.ui.PushActivity"
		            android:theme="@android:style/Theme.Translucent.NoTitleBar"
		            android:configChanges="orientation|keyboardHidden" >
		            <intent-filter>
		                <action android:name="cn.jpush.android.ui.PushActivity" />
		                <category android:name="android.intent.category.DEFAULT" />
		                <category android:name="Your_Package_Name" />
		            </intent-filter>
		        </activity>
		        <service
		            android:name="cn.jpush.android.service.DownloadService"
		            android:enabled="true"
		            android:exported="false" >
		        </service>
		        <receiver android:name="cn.jpush.android.service.AlarmReceiver" />
		        <meta-data android:name="JPUSH_CHANNEL" android:value="developer-default"/>
			    <meta-data android:name="JPUSH_APPKEY" android:value="Your_Appkey"/> 
		</application>

 (2)权限
	
			    <!-- Required -->		
				<permission android:name="Your_Package_Name.permission.JPUSH_MESSAGE" android:protectionLevel="signature" />
				<uses-permission android:name="android.permission.INTERNET"/>
			    <uses-permission android:name="Your_Package_Name.permission.JPUSH_MESSAGE" />
			    <uses-permission android:name="android.permission.RECEIVE_USER_PRESENT" />
			    <uses-permission android:name="android.permission.WAKE_LOCK" />
			    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
			    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
			    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
			    <uses-permission android:name="android.permission.VIBRATE" />
			    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
			    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
			     
			    <!-- Optional. Required for location feature -->
			    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
			    <uses-permission android:name="android.permission.ACCESS_COARSE_UPDATES" />
			    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
			    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
			    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
			    <uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" />
			    <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />