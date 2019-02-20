/**
 *
 */
package com.spring.security.rbac.repository.support;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;


public class SpringImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

	/**
	 *
	 */
	private static final long serialVersionUID = 769122522217805485L;

	@Override
	protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
		return super.toIdentifier("spring_rabc_"+stringForm.toLowerCase(), buildingContext);
	}

}
