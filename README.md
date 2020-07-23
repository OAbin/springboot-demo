# springboot-demo
springboot常用技术整合
##1、mybatis
* 注解使用mybatis
* xml使用mybatis


# 刨坑之旅
1、springboot项目的继承与聚合   
2、dependencyManagement和dependencies的区别  
3、springboot的启动类和测试类必须包名相同  
4、配置bean方法名必须与注入时使用属性名相同,否则注入无效  
@Autowired  
    private RedisTemplate jacksonRedisTemplate;  
@Bean  
    public RedisTemplate<String, Object> jacksonRedisTemplate(RedisConnectionFactory factory) 
