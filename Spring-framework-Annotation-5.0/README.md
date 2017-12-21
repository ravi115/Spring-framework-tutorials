## Spring configuration using Annotation.


**In this tutorials we will be configuring our spring setup using annotation as well as XML.**
- As we have seen all the setup  requirement for [XML in the spring-XML-configuration](https://github.com/ravi115/Spring-framework-tutorials/blob/master/Spring-framework-XML-5.0/readme.md).

- so if we are using annotation to specifying **_bean classes_**, **_dependency injection_** then we need to add only ```<component-scan>``` element in our XML configuration.
- see the complete XML configuration. 

                  <?xml version = "1.0" encoding = "UTF-8"?>

                  <beans 
                    xmlns="http://www.springframework.org/schema/beans"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
                    xmlns:context="http://www.springframework.org/schema/context"
                    xsi:schemaLocation="http://www.springframework.org/schema/beans
                    http://www.springframework.org/schema/beans/spring-beans.xsd
                    http://www.springframework.org/schema/context
                    http://www.springframework.org/schema/context/spring-context.xsd">

                    <!-- location to load properties file -->
                    <context:property-placeholder location="classpath:sport.properties"/>

                    <!-- 
                      if we are using annotation based spring framework then we should scan all the bean classes and 
                      load into spring container.
                      we can add all bean entry by comma separated. 
                      remember! we have to only specify the package name containing bean class.
                      if we need to specify more than one package we can use comma to separate then bean package name. 
                    -->
                    <context:component-scan base-package="mypackage.Myclass-1,
                                                          mypackage.Myclass-2,
                                                          mypackage.Myclass-3">
                    </context:component-scan>
                  </beans>
              
 
 ### we require some basic annotation defined below: -
 
 - **_@Component_** || **_@Component("beanId")_**
  - Available in the **org.springframework.stereotype.Component**
  - class level annotation used to define a bean class.
  - if we won't use any bean id then spring container by default uses class name with first letter in lower case to identify a bean.
  - e.g. if we have class called _Student_ then spring container will expect _student_ {noticed first letter in lower case} as a beanId.
  
- **_@Autowired_** || **_@Autowired(required=true)_**
  - Available in the **org.springframework.beans.factory.annotation.Autowired**.
  - this is used for **_dependency-injection_**.
  - we will use this annotation on fields, _constructor_ or _setter_.
  
- **_@Qualifier("class-name")_**
  - Available in **org.springframework.beans.factory.annotation.Qualifier**.
  - used with **@Autowired** annotation.
  - this is used to tell that depency of which class is being used here.
  - this is used when we are refering for dependency injection to a packages which contains more than one classes.

- **_@Value("${key_from_properties_file}")_**
  - Available in the **org.springframework.beans.factory.annotation.Value**.
  - used on _fields_ only.
  - used to set a value for field read from properties file.
  
- **_@PostConstruct_**
  - Available in **javax.annotation.PostConstruct**.
  - used to define _life cycle_ method for bean.
  - this is the very first method and only once will be invoked by spring container once the bean is created.

- **_@PreDestroy_**
  - Available in **javax.annotation.PreDestroy**.
  - used to define _life cycle_ method for bean.
  - this is the last method will be invoked by spring container at the time of bean distruction.
  
- **_@Scope("default/singleton || prototype || request || ")_**
  - Available in the **org.springframework.context.annotation.Scope**.
  - used on the class only same as _componenet_ annotation.
  - used to define the scope of bean.

- **_@Bean_**
  - Available in the **org.springframework.context.annotation.Bean**.
  - @Bean annotation is used to actually crate the bean [class object] of desired class.
  - The method-name chosen for this bean creation is the actual bean-id. by this bean-id spring container invokes this class.
  - e.g.
           ``` 
           @Bean
            public OperatingSystem MyOS() {
              return new AndroidPhone();
            }
           ```
   - @return the objects of bean class to spring container.

- **_@Configuration_**
  - Available in **org.springframework.context.annotation.Configuration**.
  - this annotation tells spring container that this is a configuration class.
  
- **_@ComponentScan("package-name")_**
  - Avaiable in **org.springframework.context.annotation.ComponentScan**.
  - this annotation used to tell spring container that loads the bean classes from the specified package.
  - we can specify more than one package name using comma separeted.

- **_@PropertySource("classpath:fileName.properties")_**
  - Available in **org.springframework.context.annotation.PropertySource**.
  - this annotation is used when we are reffering any properties file.
  
