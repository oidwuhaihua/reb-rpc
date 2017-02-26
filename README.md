Dm 是一个集成spring基于netty实现的远程通信框架,并且支持多种报文协议。


<center>
<img src="https://github.com/oidwuhaihua/imagedata/blob/master/Dm.png" width="60%" height="60%" />
</center>
## 通讯模块
通讯模块作为接收TCPIP协议请求入口以及返回响应结果的出口，主要包含TCPIPService、DeCode、EnCode和ActionHander四个部分，该模块式基于Netty架构基础上的封装结果，架构可根据实际需要替换。
- TCPIPService是TCPIP服务器，实现了基于套接字socket的服务端和客户端，是访问的入口和响应出口，支持OIO、NIO等模型。
- DeCode是解析报文模块，对Request发送过来的报文进行解析，解析过程需要调用报文格式模块IFomat。
- EnCode是组装报文模块，对处理的结果数据进行报文组装，然后发送给Response，组装过程需要调用报文格式模块IFomat，与DeCode模块处理的格式对应。
- ActionHandler是功能处理器，接收DeCode接口处理后的数据，然后调用ActionProxy功能代理器进行相应功能处理。
## 报文模块
报文模块是自定义封装模块，主要包含格式接口定义和业务报文格式（如String格式、XML格式），对报文格式进行初始化管理，并提供报文的组包和解包等功能供通讯模块调用。
IFormat是报文格式化接口，定义报文处理接口，后续业务扩展时可基于此接口类扩展相应的报文格式。

## 功能处理模块
功能处理模块采用代理方式实现功能的代理和拦截器处理，包含ActionProxy、ActionInvocation、和Interceptor三个部分。
- ActionProxy是功能代理，位于通讯模块的ActionHandler和ActionInvocation之间，用于代理不同功能对象的方法。
- ActionInvocation是代理处理器，包含业务对象和拦截器绑定动态代理类的处理。
- Interceptor是拦截器接口，是按照反射模式规则来设计的一个接口，用于实现相应的拦截功能。

## 配置管理模块
配置管理模块是用于管理TCPIP设计中的相关配置文件，主要包含ConfigurationManager和TCPIPConfig.xml两部分。
- ConfigurationManager配置管理器，用于加载、管理TCPIPConfig.xml配置文件。
- TCPIPConfig.xml是TCPIP配置文件，对拦截器、TCPIP通讯服务等进行配置。例如：
```java
<?xml version="1.0" encoding="UTF-8"?>
<!—拦截器配置 -->
<handlers>
	<handler id="Interceptor1" sortIdx="1" pattern="/*" class="**"/>
	<handler id=”Interceptor2" sortIdx="2" pattern="/*" class="** "/>
	<handler id="Interceptor" sortIdx="3" pattern="/*" class="**"/>
</handlers>
<!-- TCP/IP通讯服务配置 -->
<module name="TCPIPService">
	<group name="default">
		<configValue key="servers">Servers</configValue><!-- 服务端-->
		<configValue key="clients">Clients </configValue><!-- 客户端端-->
		<configValue key="commProcessor"></configValue><!--协处理器-->
		<configValue key="keepAlive"></configValue><!-- 长短连接标识-->
		<configValue key="timeOut"></configValue><!--通讯超时时长-->
	</group>
</module>
<!-- TCP/IP通讯服务端配置 -->
<module name=" Servers">
	<group name="group1">
		<configValue key="port"></configValue><!-- 服务端端口-->
		<configValue key="maxConnection"></configValue><!--最大连接数-->
		<configValue key="waitTime"></configValue><!--等待时长-->
		<configValue key="bindAddress"></configValue><!-- 服务端IP-->
		<configValue key="bossExecutor"></configValue><!--主线程池类-->
		<configValue key="bossPoolSize"></configValue><!--线程池大小-->
		<configValue key="workerExecutor"></configValue><!--工作线程池类-->
		<configValue key="workerPoolSize"></configValue><!--工作线程池大小-->
		<configValue key="channel"></configValue><!--服务端通讯I/O方式-->
		<configValue key="pipeline"></configValue><!--服务端通讯处理管道-->
	</group>
</module>
<!-- TCP/IP通讯客户端配置 -->
	<module name="Clients">
	<group name="group1">
		<configValue key="hostAddr"></configValue><!--请求主机地址 -->
		<configValue key="port"></configValue><!--请求主机端口 -->
		<configValue key="maxConnection"></configValue><!--最大连接数-->
		<configValue key="connectTimeOut"></configValue><!--连接超时时长-->
		<configValue key="readTimeOut"></configValue><!--读取超时时长-->
		<configValue key="executor"></configValue><!--线程池类-->
		<configValue key="poolSize"></configValue><!--线程池大小-->
		<configValue key="channel"></configValue><!--客户端通讯I/O方式-->
		<configValue key="pipeline"></configValue><!--客户端通讯处理管道-->
	</group>
</module>

```





