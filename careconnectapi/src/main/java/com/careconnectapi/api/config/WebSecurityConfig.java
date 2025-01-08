package com.careconnectapi.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		//auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests()
				.antMatchers( "/deletePractitioner", "/listAllPractitioners","/createPractitioner","/updatePractitioner","/Practitionerscount","/createUser", 
						"/deleteUser","/usersCount","/updateUser","/listAllUsers","/makeAppointment","/updateAppointment","/listAllAppointments",
						"/deleteAppointment","/Appointmentscount","/makeStatus","/updateStatus","/listAllStatus","/deleteStatus", "/statusByAppointmentId",
						"/countStatus","/createFeedback","/listAllFeedback","/deleteFeedback","/countFeedback","/feedbackByAppointmentId",
						"/getAppointment","/getAppointmentByDocId","/getAppointmentByPatientId"
						
						,"/deleteByPractitionerId/{doctorId}","/getUser","/deleteByUserId/{userId}","/deleteByAppointmentId/{appointmentId}"
						,"/getAppointmentWithId/{appointmentId}"
						,"/getWithUserId/{userId}","/getPractitionerById/{doctorId}"
						,"/deleteByStatusId/{statusId}","/getStatusWithId/{statusId}"
						,"/deleteByFeedbackId/{feedbackId}"
						,"/getAuthentication/{username}/{password}","/getAppointmentByPatientId/{patientId}","/feedbackByAppointmentId/{ids}"
						,"/getFeedbackWithId/{feedbackId}", "/statusByAppointmentId/{ids}","/getAppointmentID"
						
					 )
				.permitAll().
				// .authorizeRequests().antMatchers("/authenticate").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated() ;

		httpSecurity.cors();
		// make sure we use stateless session; session won't be used to
		// store user's state.
		// exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		// .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		// httpSecurity.addFilterBefore(jwtRequestFilter,
		// UsernamePasswordAuthenticationFilter.class);
	}

}
