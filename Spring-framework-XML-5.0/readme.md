
## Spring Framework configuration using XML (**_version : 5.0.1_**)
In this tutorials we will see how to setup configuration using XML.

First see the XML Configuration structure:  -
    
      <beans>
          <bean>
          </bean>
      </beans>

**beans element holds the XML schema** and **XSD which validates the elemenet used in XML configurations.**
so the basic XML confguration must contain the following XSD: - 
       
       <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">
        </beans>

Let's say if we want to add spring MVC support then we must include the below schema and XSD into our beans attribute: - 

          xmlns:mvc=http://www.springframework.org/schema/mvc
          http://www.springframework.org/schema/mvc
          http://www.springframework.org/schema/mvc/spring-mvc.xsd



**what is bean?**
- bean is nothing but an object of java class.
- spring container creates the object of specified class which is known as a bean.

### what are the minimum attribute used in the bean element?
- Here's the list of attribute used in the bean element: 
  1. **id** = "myBeanId"
    - this is the id of bean.
    - spring contianer uses this id to create the bean.
  
  2. **class** = "fully qualified name of class"
    - we provide fully qualified name of class for which spring container will create the bean ( nothing but object of that class).
  
  3. **init-method** = "initBeanMethod"
    - this provides the life cycle method for the bean.
    - works similar to the servlet's life cycle method.
    - this method will be invoked as the very first method by spring container as soon as the bean gets crreated.
    - this method will be invoked only once and at least once during the life cycle of bean.
  
  4. **destroy-method** = "destroyBeanMethod"
    - this is last method will be invoked by spring container at the time of bean distruction.
    - [click here to see complete example of life-cycle xml configuration](https://github.com/ravi115/Spring-framework-tutorials/blob/master/Spring-framework-XML-5.0/spring-bean-life-cycle/bean-life-cycle.xml)
  5. **scope** = "default/singleton | prototype  | request | session | global-session"
    - this provides the scope of bean.
    - if won't define any scope then spring container uses default means singleton scope. i.e. only one bean (object) will be created.
    - if we specify prototype then every time a new bean (object) will be created by spring container.
    - [click here to see the complete example of scope xml configuration](https://github.com/ravi115/Spring-framework-tutorials/blob/master/Spring-framework-XML-5.0/spring-bean-scope/bean-scope.xml)
    
 
 **_Let's see the complete structure of bean_**
 
    <bean id="myBeanId" class="mypackage.Myclass" init-method="myInitMethod" destroy-method="myDestroyMethod" scope="prototype">       </bean>
    
### what is property and constructor-args element and when it is used?
- so property and constructor-args is the child element of bean.
- it is used with bean in some special cases.
- when we are defining the **dependecies_injection** using **_constructor_** then we use **<constuctor-args ref=""></constructor-args>**   element with bean.
- when we are defining the **dependecies_injection** using **_setter_** || injecting some **_field of bean_**  || injecting some **_properties_file values_** then we use <Property></property> element with bean.
- **Here's the syntax**
    
        <bean>
            <constructor-agrs ref = "anotherBeanId" ></constructor-agrs>
         </bean>
         ----------------------------------------------------------------------
         <bean>
            <property name="field-name-of bean class" ref="anotherBeanId"></property>
            <property name="field-name-of bean class" value="some_values"></property>
            <property name="field-name-of bean class" value="${key_from_properties_file}"></property>
         </bean>

**Important point**
- when we are refering to any properties file we must include below tags which defines the location of properties file.
```diff
    - <context:property-placeholder location="classpath:car.properties" />
 ```   
[click here to see the complete the configuration of xml file](https://github.com/ravi115/Spring-framework-tutorials/blob/master/Spring-framework-XML-5.0/spring-dependency-injection/dependency-injection.xml)

### A Demo XML configuration file ; -

        <?xml version = "1.0" encoding = "UTF-8"?>

        <beans 
            xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
            xmlns:context="http://www.springframework.org/schema/context"
            xsi:schemaLocation="http://www.springframework.org/schema/beans
            xmlns:mvc=http://www.springframework.org/schema/mvc
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd"
            http://www.springframework.org/schema/mvc
            http://www.springframework.org/schema/mvc/spring-mvc.xsd>

            <!-- Load properties file | This location tells from where to properties 
                file -->
            <context:property-placeholder location="classpath:car.properties" />

            <!-- provide helper class. Any Engine implementing classes are helper class 
                for car factory class. -->
            <bean id="MyBMWEngine" 		class="com.springdemo.di.engine.BMWEngine"></bean>
            <bean id="MyAudiEngine" 	class="com.springdemo.di.engine.AudiEngine"></bean>
            <bean id="MyMarutiEngine" 	class="com.springdemo.di.engine.MarutiEngine"></bean>
            <bean id="MyHondaEngine" 	class="com.springdemo.di.engine.HondaEngine"></bean>

            <!-- ====================================================================== -->
            <!-- constructor injection -->

            <!-- create bean 1. id is to refer this bean. 2. class attribute determine 
                which bean object needs to be created. -->
            <bean id="MyBMW" class="com.springdemo.di.car.BMWCar">

                <!-- inject dependency using constructor -->
                <constructor-arg ref="MyBMWEngine"></constructor-arg>
            </bean>

            <!-- ================================================================ -->
            <!-- setter injection -->

            <bean id="MyAudi" class="com.springdemo.di.car.AudiCar">

                <!-- inject dependency using setter method of Audi class -->
                <property name="engine" ref="MyAudiEngine"></property>
            </bean>
            <!-- ================================================================ -->
            <!-- Field injection -->

            <bean id="MyMaruti" class="com.springdemo.di.car.MarutiCar">
                <property name="engine" ref="MyMarutiEngine"></property>

                <!-- inject dependency using field of the class maruti -->
                <property name="email" value="ravi.1rn12cs078@gmail.com"></property>
                <property name="name" value="Ravi Ranjan"></property>

            </bean>

            <!-- ================================================================ -->
            <!-- properties file injection -->

            <bean id="MyHonda" class="com.springdemo.di.car.HondaCar">

                <!-- inject dependency using setter method of Honda class -->
                <property name="engine" ref="MyHondaEngine"></property>

                <!-- inject dependency using properties file -->
                <property name="ownerName" value="${owner.name}"></property>
                <property name="ownerMobile" value="${owner.mobile}"></property>

            </bean>

        </beans>
