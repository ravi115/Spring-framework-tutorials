# Spring-mvc tutorials

here is the important points to setup and successfully run the MVC project.

step -1 :
	**setup the web.xml file**
	
	a. the default location for [web.xml] and [spring-context-configuration.xml] is {WEB-INF} folder.
	
	b. these files should be default present at this location.
	
	c. in the web.xml file we have to configure dispatcher <servlet>.
	
	d. dispatcher <servlet-class> is available in this [org.springframework.web.servlet.DispatcherServlet]
		package.
		  
	e. we can give any name to dispatcher servlet but this should be same in <servlet-mapping> element.
	
	f. as we know <servlet> supports for <init-param> where we can define our configuration related stuff.
	
	g. provide path to spring-context.xml file in the <init-param> of <servlet> element.
	  
	 e.g ; -
	 <!-- Step 1: Configure Spring MVC Dispatcher Servlet -->
	<servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<!-- Step 2: Set up URL mapping for Spring MVC Dispatcher Servlet -->
	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
	
step -2: 
	**setup spring-context.xml file.**
	
- in the bean property of .xml file if we want to achieve some extra functionality then we have to list out all the tag info like this.
		    
        xmlns:features
		    like:- xmlns:mvc, xmlns:context, xmlns:util
		    after that we have to also mention the url for this tag and .xsd.
		
- we add all the component for scan where spring container will look for the controller class.
		 
      context:component-scan - in this tag will list out all the packages by comma separated where controller class is available.
		
- we provide view resolver. means we will have one folder any where in our project directory which contains
		- all the front-end related code. e.g: HTML, JSP, JSTL, GROOVY, etc.
        
      <bean
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/view/" />
        <property name="suffix" value=".jsp" />
      </bean>

		  this is how we define the view resolver. spring container resolve view using below formula.
		
      prefix + return string from controller + suffix
    
		  e.g: /WEB-INF/view/ + helloWorld + .jsp --> helloworld.jsp and should be available in WEB-INF/view
		  folder.
		
- Reading of properties file in spring-mvc is little different than spring-core.
		- we use ( util:properties ) to list out the properties file.
		
      <util:properties id="colourOptions" location="classpath:../colour.properties"></util:properties>
		  
      here the id is used to read the values from this properties file loaded by spring container. 
		  since we all know the classpath for web dynamic project is WEB-INF/class, where all the .class file are present to run the 
      program.
		  in this case the properties file is available in WEB-INF folder.

step -3: 
	**important annotation is used to create controller class.**
	
	  1. @Controller - defines that this class is the controller class for spring.
	
	  2. @RequestMapping("/path") - defines resource available  @ this path.
	
	  3. @RequestParam("form-param-name") - reads the parameter name used in the input tag of a form.
	
	  4. Model is the important class in spring-mvc {basically it is m-model of mvc}.
	
	  5. we use Model class to carry data from [view to controller] or [controller to view]. 
	
	  6. we use model.addAttrinute("name-to identify-attribute" , value) 
	
	  7. @ModelAttribute("user-defined-data-type" or "inbuilt-data-type") - used to fetch all the fields 
		specified at this bean.
    
    8. we can use shortuct annotation provided by spring community to fullfill our HTTP request.
        
          a. GetMapping()
          b. PostMapping()
          c. PutMapping()
          d. deleteMapping()

### <----- important point for HTML tags ----- >
  
 **spring-mvc has strong support for HTML form tag.**
 
- so to get support for mvc form tag we must have this taglib in our front-end technologies.
 		    
      uri="http://www.springframework.org/tags/form
 	
- in the form usually we use post or get to carry the data but in spring-mvc we use
 		  
      ( modelAttribute ) to carry out data.
      e.g:- modelAttribute = "student" means the form tag data will be exactly map to the object of student class.
      so we should have all the variable available in the student class to handle form data.

- spring-mvc works with getter and setter method for security reason.
 	
- spring-HTML-form basically maps form data to any class object by calling the setter method of the specified class in the   
  modelAttribute.
 	
- path attribute is to specify the field of that class to set the data for this variable.
 	
- items is used to hold collections of data of class specified in the modelAttribute.
 	 
	
