package com.neuedu.bean;

import lombok.Data;
@Data
public class Student {

	
	private Integer id;
	private String name;
	@Column(value="b_id")
	private Integer bId;
	private Integer gerden;
}
