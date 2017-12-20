
## Spring Framework configuration using XML (**_version : 5.0.1_**)
In this tutorials we will see how to setup configuration using XML.

First see the XML Configuration structure:  -
    
      <beans>
          <bean>
          </bean>
      </bean>

**beans element holds the XML schema** and **XSD which validates the elemenet used in XML configurations.**
so the basic XML confguration must contain the following XSD: - 
       
       <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">
        </beans>

Let's say if want to add spring MVC support then we must include the below schema and XSD into our beans attribute: - 

          xmlns:mvc=http://www.springframework.org/schema/mvc
          http://www.springframework.org/schema/mvc
          http://www.springframework.org/schema/mvc/spring-mvc.xsd



**what is bean?**
- bean is nothing but an object of java class.
- spring container creates the object of specified class which is known as a bean.

### what are minimum attribute used in the bean element?
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
