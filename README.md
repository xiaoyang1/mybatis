#  mybatis 
这个项目这只是用来学习和测试基本的mybatis学习：
其中，包括增删改查，以及一些简单的注解，同时，附加上log4j的日志。对于解决字段名和实体类属性名不同的问题。
通常采用别名或者通过resultmap。

10月21号，增加了一对一关联表查询和一对多联表查询。
collection : 做一对多关联查询的
ofType ： 指定集合中的元素对象的类型

动态sql和模糊查询
ConditionUser类是专门用来查询和封装的。

对于数据库操作语句，在bin目录下有个sql.sh文件，里面有相应的数据库语句。

关于mybatis缓存：
和大多数持久层框架一样，mybatis同样提供了一级缓存和二级缓存的支持。
1.一级缓存：基于perpetualCache的hashmap 本地缓存，其存储作用域为session，当session flush或close 之后，该session
 中的所有cache就讲清空。
2.二级缓存和一级缓存机制相同，默认也是采用perpetualCache ，Hashmap存储，不同在于其存储作用域为Mapper [namespace]
，并且可自定义存储源，如Ehcache。
3.对于缓存数据更新机制，当某一个作用域（一级缓存session / 二级缓存 namespaces）的进行了C/U/D操作后，默认该
作用于下的所有select中的缓存将被clear。
注意：一级缓存默认是开启的。1）可以通过session的clearcache方法可以清空缓存。
                            2）在两次查询之间用了增删改的操作。
                            3）session  close。导致连接断开。

 二级缓存：是一个文件级的缓存只需要在mapper文件里面添加<cache/>标签就行了。可以加一些默认的属性值。测试用两个不同的session去查询就可以了。但是
 二级缓存和一级缓存的方式是不一样的，二级缓存需要对对象序列化。
