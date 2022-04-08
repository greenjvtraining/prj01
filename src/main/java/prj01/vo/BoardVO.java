package prj01.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private Date updateDate;
}
