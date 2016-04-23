#运行方式一 :
###mvn verify -Pit
这个命令会一次执行以下几个主要的动作:
1, 编译
2, 单元测试
3, 启动 tomcat, 并部署 web 应用
4, 运行接口测试
5, 关闭 tomcat

#运行方式二:
打开两个控制台窗口, 分别运行:
###mvn pre-integration-test     
这个命令运行起 tomcat, 并部署应用

###mvn failsafe:integration-test    
这个命令运行 接口测试

