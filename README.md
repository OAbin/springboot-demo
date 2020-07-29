# springboot-demo
springboot常用技术整合  
## 1、mybatis
* 注解使用mybatis
* xml使用mybatis  
## 2、redis
* redistemplate的配置使用
* redistemplate的多种序列化方案，默认jdk序列化，redisManger查看会不友好。  
## 3、mq  
* rocketmqTemplate的使用
* 多种方式发送的消息：同步、异步、顺序、延迟、一次  
## 4、多数据源之读写分离  
* 基于 Spring AbstractRoutingDataSource 做拓展--baomidou实现多数据源  
  * baomidou-demo:  
    通过DS，注解来实现，参数为数据源名称。  
    读写分离从库通过下划线分割，默认分割首部为一个数据源组，列如slave_1,slave_2为两个从库，则slave为一个数据源组。  
    从库默认轮训来做负载均衡。
* 不同操作类，固定数据源--mybatis实现多数据源、Spring Data JPA 多数据源、 JdbcTemplate 多数据源  
  * mybatis-demo:  
    通过配置不同的sqlSessionTemplate来实现。  
    读写分离:如果从库比较多，配置类会比较多，不利于生产实施。相对而言，第一种方案比较优。  
  * jpa-demo  
    jpa的使用，model需要和DataSource关联。要不@Table和@Column注解会报错  
  * jdbctemplate-demo  
     model需要实现Serializable接口。  
     
    
      
* 分库分表中间件  

# 刨坑之旅
1、springboot项目的继承与聚合   
2、dependencyManagement和dependencies的区别  
3、springboot的启动类和测试类必须包名相同  
4、配置bean方法名必须与注入时使用属性名相同,否则注入无效  
@Autowired  
    private RedisTemplate jacksonRedisTemplate;  
@Bean  
    public RedisTemplate<String, Object> jacksonRedisTemplate(RedisConnectionFactory factory)  
5、jpa要配置表名、dao层接口方法命名要规范。列如根据id查询只能是findById，不能是userById.