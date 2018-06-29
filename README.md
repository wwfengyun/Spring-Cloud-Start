# Spring-Cloud-Start
本项目是按照spring cloud视频教程搭建的，对学习spring cloud过程进行总结

服务发现组件：

一、服务发现组件的功能：
1. 服务注册表
服务注册表是一个记录当前可用服务实例的网络信息的数据库，是服务发现机制的核心。
服务注册表同时提供查询和管理这些信息的API，如某一个服务可以通过API查询服务实例的信息，也可以通过管理API实现服务信息的注册和注销。
2. 健康检查
通过心跳机制来检查服务的健康状态

二、服务发现的方式（有两种）
1. 客户端发现
如：Eureka，Zookeeper
2. 服务器端发现
如：Consul+Ngnix
具体的客户端发现和服务器端发现的区别，可以看一下下面这篇博客：http://blog.daocloud.io/microservices-4/

三、服务发现组件Eureka
服务发现的架构图如下所示：

Eureka是一个基于RESTful的服务
ApplicationClient:服务消费者
ApplicationService:服务提供者
Make Remote Call：调用Restful接口
us-east-1c,us-east-1d等是属于同一个Region（us-east-1）的不同的zone
