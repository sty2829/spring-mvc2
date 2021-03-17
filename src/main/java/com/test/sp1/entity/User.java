package com.test.sp1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.test.sp1.util.DateUtill;

import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
public class User {

	@Id
	@SequenceGenerator(name = "seqUiNum", sequenceName = "seq_ui_num", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUiNum")
	@Column(name="ui_num")
	private Long uiNum;
	@Column(name="ui_name")
	private String uiName;
	@Column(name="ui_id")
	private String uiId;
	@Column(name="ui_pwd")
	private String uiPwd;
	@Column(name="ui_genre")
	private String uiGenre;
	@Column(name="ui_email")
	private String uiEmail;
	@Column(name="ui_phone1")
	private String uiPhone1;
	@Column(name="ui_phone2")
	private String uiPhone2;
	@Column(name="ui_address")
	private String uiAddress;
	@Column(name="ui_hint")
	private String uiHint;
	@Column(name="ui_answer")
	private String uiAnswer;
	private String credat = DateUtill.getDate();
	private String cretim = DateUtill.getTime();
	private String moddat = DateUtill.getDate();
	private String modtim = DateUtill.getTime();
	@Column(name="ui_img")
	private String uiImg;
}
