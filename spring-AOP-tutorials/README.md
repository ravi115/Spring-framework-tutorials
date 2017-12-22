## Spring AOP complete tutorials
  -------------------------------------------------------------------------------------------------------------------------

**Spring-AOP : _Aspect Oriented Programming_**

- This is a string feature of spring framework.
- This is similar to callback methods in java.
- The aspects will be called each time by spring container for each request.
- The aspects can be applied on any classes.
- Aspect is used to log the data.

**Here are the list of annotation used in spring aspects _basically known as Advice_: -**
  1. @Aspect 
  2. @Before
  3. @Pointcut
  4. @Order
  5. @AfterReturning
  6. @AfterThrowing
  7. @After
  8. @Around
  
**The most important thing is the syntax used with all the annotation mentioned above excepts 1 and 4**
  ```
    execution(access_modifiers return-type mypackage.myclass.method())
    
    if we don't want to specify access_modifier then we can use *.
    if we don't want to specify return-type then we can use *.
    if we don't want to specify package-name then we can use *.
    if we don't want to specify class-name then we can use *.
    if we don't want to specify method-name then we can use *.
    
    so finally the above expression looks like: - 
    execution(* * *.*())
    
  ```
  

**Explanation**

- **_@Aspect_**
  - Avaiable in **org.aspectj.lang.annotation.Aspect**.
  - this annotation is used on the classes only. by using this annotation we are actually making _Aspect class_.

- **_@Order(integer-value)_**
  - Available in **org.springframework.core.annotation.Order**.
  - we use to define the order of execution of different aspects.
  - -ve values has lowest priority and +ve value has heighest priority.

- **_@Before_**
  - Available in **org.aspectj.lang.annotation.Before**.
  - this aspects will be executed at the earliest whenever an application accepts any request.
  - syntax : _@Before(execution(access_modifiers return-type mypackage.myclass.method()))_.

- **_@Pointcut_**
  - Available in **org.aspectj.lang.annotation.Pointcut**.
  - re-use the point cut expression to define our new advice.
  - we can also combine the point cut expression using logical expression. Like this [add (&&)] [or (||)] [Not (!)]
  -it exactly works like `if` statement.
  - syntax :- _ @Pointcut(execution(access_modifiers return-type mypackage.myclass.method()))_.
  - e.g. 
    ```
     
        @Pointcut("execution(* com.spring.aop.dao.*.*(..))")
        private void forDaoPackage() {}

        //create point cut for getter method
        @Pointcut("execution(* com.spring.aop.dao.*.get(..))")
        private void gettter() {}

        //create point cut for setter method
        @Pointcut("execution(* com.spring.aop.dao.*.*set(..))")
        private void setter() {}

        //create point cut : include package... exclude getter & setter
        @Pointcut("forDaoPackage() && !(gettter() || setter())")
        private void noGetterAndSetterforDAO() {}
    ```
  
- **_@Order_**
  - Available in **org.aspectj.lang.annotation.Order**.
  - use to define the order of advice to be executed.
  
- **_@AfterReturning_**
  - Available in **org.aspectj.lang.annotation.AfterReturning**
  
- **_@AfterThrowing_**
  - Available in **org.aspectj.lang.annotation.AfterThrowing**.
  - if any expection is thrown then this advice will get invoked.
  
- **_@After_**
  - Available in **org.aspectj.lang.annotation.After**.
  - this advice works similar to the finally block of try-catch.
  - this will be executed atleast once.

- **_Around_**
  - Available in **org.aspectj.lang.annotation.Around**.
 
