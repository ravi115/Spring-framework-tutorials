## Spring configuration using Annotation.


**In this tutorials we will be configuring our spring setup using annotation as well as XML.**
- As we have seen all the setup  requirement for [XML in the spring-XML-configuration](https://github.com/ravi115/Spring-framework-tutorials/blob/master/Spring-framework-XML-5.0/readme.md).

- so if we are using annotation to specifying **_bean classes_**, **_dependency injection_** then we need to add only ```<component-scanning>``` element in our XML configuration.
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
              
 
 ### we require some basic annotation defined below: -**
 
 - **_@Component_** || **_@Component("beanId")_**
  - Available in the **org.springframework.stereotype.Component**
  - class level annotation used to define this is a bean class.
 
