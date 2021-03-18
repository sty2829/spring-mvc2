package com.test.sp1.xml.movie;

import lombok.Data;

@Data
public class Body {

	private Items items;
	private Integer numOfRows;
	private Integer pageNo;
	private Integer totalCount;
}
