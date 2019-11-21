package tetra3.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.mvcMatchers("/","info", "/account/**").permitAll()
			.mvcMatchers("/admin").hasRole("ADMIN")
			.anyRequest().authenticated();
		http.formLogin();
		http.httpBasic();
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// noop이란 암호화를 하지 않았다는 뜻이다
//		// {암호화된방식} 암호화한 값 (패스워드 인코더 사용할시)
//		// 계정을 추가할때마다 코딩을 해야 하는가?
//		
//		auth.inMemoryAuthentication()
//			.withUser("jaehyun").password("{noop}1234").roles("USER").and()
//			.withUser("admin").password("{noop}!@#").roles("ADMIN");
//	}
	
	

	

}
