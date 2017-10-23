# Raymall
> 一个基于SSM搭建的后台系统o(*￣▽￣*)ブ


## 概述
这是一个自己学习后端开发的项目
学到了很多，也为自己的开发带来了很多遍历
有用的话就给star吧

### Raymall
一个商业化的商城后台系统
学习了对后台的搭建和整个业务逻辑的编写
以及正式环境的上线等

- 用户管理系统
- 商品分类模块
- 购物车模块
- 收货地址模块
- 商品模块
- 订单模块

### EasySport
本人练手的一个App项目，功能相当完整的一个篮球信息应用[EasySport](https://github.com/Rayhahah/EasySports)
代码相当工整，技术也是比较新颖的，喜欢的可以star一下

为APP提供的接口服务
- 账号系统
- 崩溃信息收集
- APP版本自动更新
- 腾讯直播
- 用户信息反馈

### Else
工作项目中的一些动态请求参数的接口
方便自己Android开发中的调试

## 收获
列举一下这个后台系统编写过程中学习到的方方面面

### Java后台搭建
基于maven构建项目

#### idea配置
- jdk
- maven
	- 新建java目录，`mark as sources root`
	- 同理resources目录
- tomcat
- git
	- `.gitignore` 文件配置
- idea配置
	- `build - compiler - make project auto` : 开启，可以查看错误信息
	- `Editor - inspections - spring core - autowiring for bean class` : error 改成 warning，以为是通过文件夹扫描，资源实际已经找到了

#### MyBatis
- Generator:
	- 自动生成 DAO 、pojo、和Mapper层
	- `datasource.properties` 、 `generatorConfig` 和 `POM` 文件的配置
	- `Mapper`里面`create_time` 和 `update_time` 配置 `now()` 优化代码
- Plugin:
	- Dap层和SQL Mapper层之间的跳转
- PageHelper:
	- 自动实现分页加载功能
	- 原理是拦截SQL 语句

#### Spring配置
拷贝以下文件~
`resources`文件夹下
- `applicationContext.xml` ：容器整合配置文件
- `applicationContext-datasource.xml` ： 容器整合配置文件
- `rmall.properties` ： 一些属性 常量配置文件

`/webapp/WEB-INF` 文件夹啊下
- `dispatcher-servlet.xml` ： 配置SpringMVC的配置
- `web.xml` ：  容器整体配置

#### logback.xml
 打印日志配置项


### 文件服务器搭建
搭建文件服务器
其实并不难，但是遇到一个问题很棘手[大问题](https://yq.aliyun.com/ziliao/65743)
就是默认使用了内网IP


然后就是在服务器端文件上传的一些操作了


### Linux上线项目
学习了很多

- Linux系统的理解与认识
- Linux中的环境配置
    - git
    - maven
    - jdk
    - tomcat
- Linux的操作    
- 自动化发布
- 也搭建了自己的个人博客
    

### MyBatis的使用

#### MyBatis-PageHelper高效准确地分页以及动态排序
1. startPage
	- `PageHeler.start(pageNum,pageSize);`
2. 插入自己的SQL
	- `List<User> data=iMapper.queryAllUser();`
3. pageHelper收尾
	- `PageInfo pageResult = new PageInfo(productList);` 
	- ` pageResult.setList(productListVoList);`

#### MyBatis 对List的遍历以及where语句的动态拼装
- where拼接，参考ProductMapper 的`selectByNameAndProductId`
	- where标签类似与 `where 1=1` ，就是把where作为开始，以便后面可选条件的拼接
- List的遍历，参考ProductMapper的`selectByNameAndCategoryIds

#### MyBatis自动生成主键、配置和使用
代码如下
`useGeneratedKeys="true" keyProperty="id"`
使用之后插入生成的id就会自动填充到插入的实体类里面了
详情请看shipping的insert

### 第三方服务的接入
- 腾讯直播的接入
- 支付宝的接入


### 一些学习
- 自动化发布

- 横向越权、纵向越权安全漏洞
    - 横向越权：攻击者尝试访问与他拥有相同权限的用户的资源
    - 纵向越权：低级别攻击者尝试访问高级别用户的资源

- MD5明文加密及增加salt值
    - 增加自定义的salt，来增强MD5的复杂度
    	- 否则可以被MD5字典解密

- Guava缓存的使用
    - TokenCache的封装
    - Redius也可以代替其来实现缓存

-  抽取pojo、BO、VO对象之间的转换 
    - 本质就是对该接口业务的关键数据封装和添加，不返回不必要的数据

- 解决浮点型在商业计算丢失精度的问题
 使用BigDecimal的String构造函数，就会自动忽略后面的精度计算

## TODO
- 商城前端页面的实现
- 后台系统的高级应用，集群等。。。。