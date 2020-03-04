# springboot_study
Springboot and Technology stack

### freemarker的简单使用
#### 了解freemarker的如何传参，以及模版通过incloud的互相引入

### springboot传参
#### 1.通过@Value传参
   - 优点：单个传参，精确获取
   - 缺点：传参少问题不大，如果大量传参则会很繁琐
#### 2.通过@ConfigurationProperties读取并与 bean 绑定
   - 优点：传入多个参数，并创建相应的参数实例，可以通过依赖注入的形式多次使用
   > 注意：使用ConfigurationProperties传参必须注入容器中，且像创建模型类一样要创建对应的get/set方法,且相同的前缀只能导入一次
#### 3. @PropertySource读取指定 properties 文件
   - 优点：可以指定其他的配置文件,且可以匹配多个配置文件
   - 缺点：默认不支持yml的配置的读取，通过继承DefaultPropertySourceFactory,然后对createPropertySource作下微调,可以识别yml或者yaml文件即可。在加载文件是使用自定义的factory就可以完成yml文件的读取
   
### 异常的处理和捕获
#### 自定义异常
1. 在报错时系统会抛出大量的错误，我们可以自定义异常并以json的形式返回至前台，方便阅读
    - json中可以包含 访问路径，报错状态吗，返回的数据，时间以及和前端约定的状态码。
    - 自定义报错时，一般继承于RunTimeException
        - 处理Exception时添加data和ErrorCodeEnum
            - errorCodeEnum中包含code，status，msg
            
    
2. 全局自动捕获异常
   - 通过@ControllerAdvice获取通知，再通过@ExceptionHandler对处理异常的方法进行捕获，如果抛出了此类异常则返回相应的响应。
   
### springboot完成异步任务的执行
1. 创建异步任务的bean(taskExecutor)
    - 配置核心线程谁
    - 最大线程数
    - 超出线程数的任务处理策略
    
2. 使用
    1. 注入ThreadPoolTaskExecutor对象，通过以下三种方法执行,子线程
        - executor.execute(Runnable task)：完美适用于没有返回值的情况。未捕获的异常会抛出
        - executor.submit(Runnable task)：也适用于没返回值的情况，未捕获的异常不会抛出
        - executor.submit(Callable<T> task)：有返回值。

    > 返回值类型：Future<Object> 通过get()方法获取返回值，注意如果调用了get()方法就会导致阻塞,直至返回要返回的对象才会放行
    
   
