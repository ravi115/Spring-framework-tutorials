# Spring Security tutorials

- We will use all java based configuration for spring security. No XML will be used.
- To enable spring security we have to create configuration class and that class has to be annotated with **@EnableWebSecurity**.
- **_@EnableWebSecurity_** available in **org.springframework.security.config.annotation.web.configuration.EnableWebSecurity** package.
- we must have to tell in java configuration class that which packages contains the below class.
     
          import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

           public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

           }
        
- we need to add that package using **@componentScan("mypackage.AbstractSecurityWebApplicationInitializer")** class.

- Then that configuration class must _extends the below class_ and _overrides all the required basics methods_.

- **WebSecurityConfigurerAdapter**
    - Avaiable in **_org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter_** package.
    - we need to override the below methods: -
      1. protected void configure(AuthenticationManagerBuilder auth) throws Exception
        - in this method we will be defining our roles based on authentication. see below code fragment.
              
              auth.inMemoryAuthentication().withUser("user-name").password("password").roles("roles");
      2. we don't have default Encoder from spring 5, we need to provide our own encoder else we need to use the below one.  
                                  
                  @SuppressWarnings("deprecation")
                  @Bean
                  public static NoOpPasswordEncoder passwordEncoder() {
                    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
                  }

      3. To provide authorization to any user we must use below code: -
 
                  @Override
                  protected void configure(HttpSecurity http) throws Exception {
                    http.authorizeRequests()
                      .anyRequest().authenticated()
                      .and()
                      .formLogin()
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                      .and()
                      .logout().permitAll();
                  }
        - [click here to see complete code](https://github.com/ravi115/Spring-framework-tutorials/blob/master/spring-security-tutorials/spring-security-demo-bootstrap-login-form/src/main/java/com/spring/security/demo/config/WebSecurityConfig.java) 
