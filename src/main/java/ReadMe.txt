用注解方式创建对象
注解方式简化XML配置
-------------IoC------------
现实IoC两种方式：1、xml配置方式，2、注解方式

1、自动扫描（引入common-annotation.jar包），扫描：发现注解，引入容器，免去了xml繁琐的配置
	a.首先在spring主配置文件中添加
	<context:component-scan base-package="要扫描的包名"></context:component-scan>
	b.在class中使用注解，指定那些Bean被纳入容器
		@Component ：标准一个普通的spring Bean类。 ---若不清楚Bean属于哪一层，就使用这个注解
		@Repository：标注一个DAO组件类。 ---数据访问层
		@Service：标注一个业务逻辑组件类。 ---业务逻辑层
		@Controller：标注一个控制器组件类。 ---控制层
	注意：1、扫描的组件默认别名为“类名首字母小写”，这个很关键
		 2、也可以在注解中指定别名，格式为：@Service("别名");
		 
2、注解生命周期的控制：
	@PostConstruct       /*等价于<bean/>元素中的init-method*/
	@PreDestroy          /*等价于<bean/>元素中的destroy-method*/
	@Scope("singleton")	 /* 等价于<bean/>元素中的scope="singleton" 单例模式  scope="prototype" 原型模式 */
	
3、注入
	a. @Autowired: 按类型匹配注入，如果需要按名称可以使用@Qualifier("personDao"); ---Spring提供的注解
	   @Autowired(required=false):required属性表示该属性是否必须注入一个对象  ---Spring提供的注解
	b. @Resource:默认先按名称，再按类型，如果需要按照名称可以使用@Resource(name="personDao")，---JDK提供的注解
	
-------------------------AOP-------------------------
AOP:面向切面编程，是对OOP编程的提升，站在程序结构角度思考问题，改善程序结构。
	主要思想是：将共通处理封装成切面对象(也就是Bean对象)，利用Spring容器将切面对象作用到某一批目标对象上。当执行目标对象方法时，会执行切面对象的功能。
	用到的技术：动态代理
	
1、相关概念
	a.切面：用于封装共通处理(即关注点)，将来用于横切多个目标对象，一个关注点的模块化，共通的处理封装成一个对象。
	b.连接点：程序在执行的时候的某个特定点，比如方法调用或异常处理，连接目标对象。
	c.切入点：连接点的集合就是切入点，一个连接点集合的表达式。
	d.通知：调用方法之前、之后、发生异常调用，比如前置通知、后置通知、异常通知、环绕通知、最终通知。
	e.织入：把切面连接到其它应用程序上或对象上。
	f.目标对象：目标对象，Action，没什么好解释的
	g.AOP代理：Spring容器为每一个目标对象动态创建代理对象，由代理对象执行切面处理方法和目标对象的方法。给目标对象生成代理对象，为每一个目标对象生成代理，动态代理技术。
	
	try {
		执行前置通知方法
		//执行环绕通知前半部分处理
		执行目标对象方法
		//执行环绕通知后半部分处理
		执行后置通知方法
	} catch() {
		执行异常通知方法
	} finally {
		执行最终通知方法
	}
	


-------------------------AOP注解配置-------------------------
1、在spring配置中启用AOP注解
   <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
2、编写切面组件，使用以下注解定义切面、切入点和通知
	@Service:指定组件
    @Aspect:将当前类指定为切面组件
	@Pointcut:定义切入点，是一个方法注解
	//通知的注解
	@Around("切入点引用")
	@Before("切入点引用") 
	@After("切入点引用") 
	@AfterReturning(pointcut="切入点", returning="参数名") 
	@AfterThrowing(pointcut="切入点", returning="参数名")

3、切入点定义常用的表达式
	·execution表达式： 匹配方法执行的连接点，这是你将会用到的Spring的最主要的切入点指示符。
		示例：execution（modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern（param-pattern）
	          throws-pattern?）
   
	·bean表达式：匹配容器中bean对象的id或name属性值
		示例：bean(idOrNameOfBean)
	   		bean(*Service)可以使用通配符，只要以是Service结尾的名字的组件
   		
	·within表达式：匹配特定类型
		示例：within(包名.类名)
	   		within（com.xyz.service.*）在service包下的所有类型
	   		within（com.xyz.service..*）在service包下及其子包下的所有类型
   		
	·this和target表达式：匹配类型实例的任意连接点，this和target区别：this指代理对象，target指目标对象
		示例：this(类型),target(类型)，使用this和target对开发者来说效果是一样的，不一样的是指定的对象不一样，一个指向代理对象 ，一个指向目标对象
			 this("com.xyz.service.AccountService")  实现了AccountService接口的代理对象的任意连接点
			 target("com.xyz.service.AccountService")实现了AccountService接口的目标对象的任意连接点
	
	·args表达式：匹配参数类型的连接点
		示例：args(参数类型或参数名字)
		args(java.io.Serializable)
		
		
		
		

-------------------------spring框架作用-------------------------
1、spring框架提供了一套完整的企业级解决方案，基于该框架整合现有流行的Struts、Hibernate等框架，降低各层组件之间的耦合。






-------------------------spring框架对JDBC的支持-------------------------
1、引入数据库驱动和dbcp连接池的jar包, dbcp:DataBase Connection Pool数据库连接池
	commons-dbcp.jar, commons-pool.jar, commons-collections.jar
2、在spring配置文件中添加datasource的定义
3、编写DAO组件，使用JdbcTemplate工具类





-------------------------整合Hibernate-------------------------
1、引入开发包，Hibernate也是对JDBC的一层封装
	a.spring基本包：spring.jar commons-logging.jar
	b.spring aop包：aspectjrt.jar aspectjweaver.jar cglib-nodep-.jar
	c.数据库驱动包：mysql-connector-jar-5.1.6-bin.jar
	d.连接池dbcp包：commons-dbcp.jar commons-pool.jar commons-collections.jar
	e.Hibernate包：hibernate3.jar hibernate-annotations.jar hibernate-common-annotations.jar hibernate-entitymanager.jar
	f.dom4j开发包：dom4j-1.6.1.jar，解析XML用到的
	g.slf4j开发包：slf4j-api-1.5.0.jar slf4j-log4j12-1.5.0.jar
	h.log4j开发包：log4j-1.2.15.jar
	i.javassist开发包：javassist.jar，修改java字节码的库，修改Class文件，添加方法，删除方法之类的
	

	
