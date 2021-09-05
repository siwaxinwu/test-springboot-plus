#实现主要功能

#该项目集成通用mapper  ---看配置application.yml

#在一个bean中通过map注入一个接口的bean，map和list都可以 ---com.roy.controller.UserController

#测试FactoryBean和BanFactory接口的区别 ---com.roy.service.MyFactoryBean

#线程池的配置方法 ---com.roy.configuration.ThreadPoolConfig

#map装载bean，通过注释的方法获取 ---com.roy.service.strategy.StrategyManager

#职责链优化if和else  ---com.roy.service.strategy.chain.StrategyHandlerChain

#自定义两个参数解析器-------------------------------
com.roy.configuration.CurrentUserNameHandlerMethodArgumentResolver
com.roy.configuration.IPAddressArgumentResolver

#自定义参数解析器演示demo      ---com.roy.controller.VOTestController

#演示springboot项目的初始化  ---com.roy.configuration.CommandLineAppStartupRunner

#演示springboot监听事件      ---com.roy.RestSpringbootApplicationTests.testOrderService

#测试自定义starter的功能（统计方法执行时间）---com.roy.controller.TestTimeLogController

#测试自定义starter的功能（序列化对象）---com.roy.controller.TestJsonController

#自定义执行job，采用自定义的线程池 ---com.roy.job.ScheduledTask