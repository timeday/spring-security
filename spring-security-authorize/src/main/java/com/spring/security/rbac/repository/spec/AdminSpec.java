/**
 *
 */
package com.spring.security.rbac.repository.spec;

import com.spring.security.rbac.domain.Admin;
import com.spring.security.rbac.dto.AdminCondition;
import com.spring.security.rbac.repository.support.QueryWraper;
import com.spring.security.rbac.repository.support.SpringSpecification;


public class AdminSpec extends SpringSpecification<Admin, AdminCondition> {

	public AdminSpec(AdminCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<Admin> queryWraper) {
		addLikeCondition(queryWraper, "username");
	}

}
