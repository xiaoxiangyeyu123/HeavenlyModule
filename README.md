# BaseMoudle
basemoudle是一个兼容rxjava+retrofit2+mvp的框架。集合了当前常用技术。  
包含了各种实用的BaseActivtiy,本人也会逐渐完善让他越来越完美。[https://github.com/sang84020325/BaseMoudle](https://github.com/sang84020325/BaseMoudle)  
框架分为
base baserx dialog mannager security utils view weight包  
     
![](https://raw.githubusercontent.com/sang84020325/BaseMoudle/master/demo/1.png)

导入方法   

	dependencies {
		   compile 'com.github.sang84020325:BaseMoudle:v1.0'
	} 
base包对对activty fragment application和(mvp中的presenter)做了封装  
rxbase包对rxjava  rxbus以及调度器进行了处理  
security包对常用加密 例如MD5 AES进行封装   
utils包对常用的方法进行封装
view包中实现常用自定义控件
