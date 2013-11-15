JPushAne
========

1.AneNativeLib包括Android层源代码文件以及libs的jar包（ane，jpush）和so文件（jpush）。

2.Aslib 是AS3代码源文件，充当了Flex手机应用与android Native层交互的中间层

3.HelloFlex 是测试的Demo，界面相对简单，三个Button以及两个展示通知消息和自定义消息的Label

4.PackageAneFolder 是用来打包ane的一些配置文件和bat打包脚本，由于ane不支持多个jar包，所以jarpackage有用来合并第三方jar包的bat脚本（jpush的jar包就是第三方jar包）