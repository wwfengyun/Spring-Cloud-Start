# Spring-Cloud-Start
本项目是按照spring cloud视频教程搭建的，对学习spring cloud过程进行总结

##服务发现组件：

###一、服务发现组件的功能：
1. 服务注册表
服务注册表是一个记录当前可用服务实例的网络信息的数据库，是服务发现机制的核心。
服务注册表同时提供查询和管理这些信息的API，如某一个服务可以通过API查询服务实例的信息，也可以通过管理API实现服务信息的注册和注销。

2. 健康检查
通过心跳机制来检查服务的健康状态

###二、服务发现的方式（有两种）
**1. 客户端发现**

如：Eureka，Zookeeper

**2. 服务器端发现**

如：Consul+Ngnix
具体的客户端发现和服务器端发现的区别，可以看一下下面这篇博客：http://blog.daocloud.io/microservices-4/

###三、服务发现组件Eureka
服务发现的架构图如下所示：

	Eureka是一个基于RESTful的服务
	ApplicationClient:服务消费者
	ApplicationService:服务提供者
	Make Remote Call：调用Restful接口
	us-east-1c,us-east-1d等是属于同一个Region（us-east-1）的不同的zone

服务提供者和服务消费者的注册流程：

1. 服务提供者和服务消费者在启动时，都会通过Eureka Client向Eureka Server进行注册(将服务的IP以及端口写入到Eureka Server的服务注册表中).

2. 服务启动好以后，服务实例与Eureka Server之间有一个心跳机制，30秒发送一次心跳，如果3个心跳周期，Eureka Server没有接收到心跳，Eureka Server会将该服务节点从服务注册表中删除掉。

3. 由于服务注册表中的信息很重要，为了实现服务注册的高可用，Eureka Server会有多个实例，每个实例中都会保存最新的服务注册信息，所以多个Eureka Server实例之间要进行注册信息数据的同步。

4. 客户端缓存。服务实例中会有一个客户端缓存，保存着其它服务的IP和端口等信息，即使Eureka Server不能工作了，服务实例也可以在自己的客户端缓存中获取服务提供者的信息，然后进行调用。