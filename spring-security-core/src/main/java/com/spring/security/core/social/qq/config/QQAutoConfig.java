/**
 *
 */
package com.spring.security.core.social.qq.config;

import com.spring.security.core.properties.QQProperties;
import com.spring.security.core.properties.SecurityProperties;
import com.spring.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactory;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;

import javax.sql.DataSource;


@Configuration
@ConditionalOnProperty(prefix = "spring.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	@Autowired
	private DataSource dataSource;

	//自动跳过手动绑定和注册过程
	@Autowired(required = false)
	private ConnectionSignUp connectionSignUp;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter
	 * #createConnectionFactory()
	 */
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		QQProperties qqConfig = securityProperties.getSocial().getQq();
		return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
	}
	/* (non-Javadoc)
	 * @see org.springframework.social.config.annotation.SocialConfigurerAdapter#getUsersConnectionRepository(org.springframework.social.connect.ConnectionFactoryLocator)
	 */
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator, Encryptors.noOpText());
		repository.setTablePrefix("spring_social_");
		if(connectionSignUp != null) {
			//自动跳过手动绑定和注册过程
			repository.setConnectionSignUp(connectionSignUp);
		}
		return repository;
	}
}
