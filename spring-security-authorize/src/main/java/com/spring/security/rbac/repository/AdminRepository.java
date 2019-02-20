/**
 *
 */
package com.spring.security.rbac.repository;

import com.spring.security.rbac.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends SpringRepository<Admin> {

	Admin findByUsername(String username);

}
