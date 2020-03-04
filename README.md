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
   
## 异常的处理和捕获
#### 自定义异常
1. 在报错时系统会抛出大量的错误，我们可以自定义异常并以json的形式返回至前台，方便阅读
    - json中可以包含 访问路径，报错状态吗，返回的数据，时间以及和前端约定的状态码.