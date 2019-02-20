/**
 *
 */
package com.spring.security.rbac.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

public interface RbacService {

	boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
