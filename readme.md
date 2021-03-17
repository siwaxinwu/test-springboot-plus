#实现主要功能
#该项目集成通用mapper  ------看配置application.yml
#在一个bean中通过map注入一个接口的bean，map和list都可以 ------------------com.roy.controller.UserController
#测试FactoryBean和BanFactory接口的区别 ------------------com.roy.service.MyFactoryBean
#线程池的配置方法 -------------------com.roy.configuration.ThreadPoolConfig
#map装载bean，通过注释的方法获取 -------------------com.roy.service.strategy.StrategyManager
#职责链优化if ----else  ---------------------------com.roy.service.strategy.chain.StrategyHandlerChain

#自定义两个参数解析器-------------------------------
com.roy.configuration.CurrentUserNameHandlerMethodArgumentResolver
com.roy.configuration.IPAddressArgumentResolver
自定义参数解析器演示demo---------------------------com.roy.controller.VOTestController