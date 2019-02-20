/**
 *
 */
package com.spring.dto;

import lombok.Data;

@Data
public class FileInfo {

	public FileInfo(String path){
		this.path = path;
	}

	private String path;


}
