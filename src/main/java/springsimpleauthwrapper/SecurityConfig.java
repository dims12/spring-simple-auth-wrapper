package springsimpleauthwrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created on 26.12.2015.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   AuthenticationProviderEx authenticationProviderEx;

   @Autowired
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
         .authenticationProvider(authenticationProviderEx)
         ;
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.httpBasic();
   }
}
