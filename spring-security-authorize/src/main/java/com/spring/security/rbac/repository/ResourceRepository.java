/**
 *
 */
package com.spring.security.rbac.repository;

import com.spring.security.rbac.domain.Resource;
import org.springframework.stereotype.Repository;


@Repository
public interface ResourceRepository extends SpringRepository<Resource> {

	Resource findByName(String name);

}
