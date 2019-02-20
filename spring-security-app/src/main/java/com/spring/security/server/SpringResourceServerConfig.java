/**
 *
 */
package com.spring.security.server;

import com.spring.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

import com.spring.security.core.authentication.FormAuthenticationConfig;
import com.spring.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.spring.security.core.authorize.AuthorizeConfigManager;
import com.spring.security.core.validate.code.ValidateCodeSecurityConfig;

/**
 * 资源服务器配置
 */
@Configuration
@EnableResourceServer
public class SpringResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

	@Autowired
	private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;

	@Autowired
	private SpringSocialConfigurer springSocialConfigurer;

	@Autowired
	private AuthorizeConfigManager authorizeConfigManager;

	@Autowired
	private FormAuthenticationConfig formAuthenticationConfig;

	@Override
	public void configure(HttpSecurity http) throws Exception {

		formAuthenticationConfig.configure(http);

		http.apply(validateCodeSecurityConfig)
				.and()
			.apply(smsCodeAuthenticationSecurityConfig)
				.and()
			.apply(springSocialConfigurer)
				.and()
			.apply(openIdAuthenticationSecurityConfig)
				.and()
			.csrf().disable();

		authorizeConfigManager.config(http.authorizeRequests());
	}

}
