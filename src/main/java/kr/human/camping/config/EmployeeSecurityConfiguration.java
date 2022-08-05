package kr.human.camping.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    DataSource dataSource;
	
	// Enable jdbc authentication
	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .jdbcAuthentication()
        .passwordEncoder(new BCryptPasswordEncoder())
        .dataSource(dataSource)
        .authoritiesByUsernameQuery("select idx, id, role role from member_role where id=?")
        .usersByUsernameQuery("select idx, id, password, name, phone, email, gender from member where id=?")
        ;
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/insert").permitAll()
		.antMatchers("/insertOk").permitAll()
		.antMatchers("/IdOverlap").permitAll()
		.antMatchers("/EmailOverlap").permitAll()
		.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
		.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
		.antMatchers("/addNewEmployee").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().permitAll();

		http.csrf().disable();
	}
	
	
	//@Autowired
	//public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
	//	authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_USER").and()
	//			.withUser("javainuse").password("javainuse").authorities("ROLE_USER", "ROLE_ADMIN");
	//}


}