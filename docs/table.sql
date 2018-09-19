SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE mail_send1
(
	send_id    VARCHAR(40)     not null,
	send_to    VARCHAR(40)     not null,
	send_mail    VARCHAR(40)     not null,
	send_content    VARCHAR(400)     not null,
	send_priority    NUMERIC(10)     not null,
	send_count    NUMERIC(10)     not null,
	send_status    VARCHAR(10)     not null,
	remark    VARCHAR(200),
	version    NUMERIC(10)     not null,
	update_by    VARCHAR(40)     not null,
	update_time    TIMESTAMP    not null,
	CONSTRAINT PK_MAIL_SEND1 PRIMARY KEY (send_id)
);

CREATE TABLE mail_send2
(
	send_id    VARCHAR(40)     not null,
	send_to    VARCHAR(40)     not null,
	send_mail    VARCHAR(40)     not null,
	send_content    VARCHAR(400)     not null,
	send_priority    NUMERIC(10)     not null,
	send_count    NUMERIC(10)     not null,
	send_status    VARCHAR(10)     not null,
	remark    VARCHAR(200),
	version    NUMERIC(10)     not null,
	update_by    VARCHAR(40)     not null,
	update_time    TIMESTAMP    not null,
	CONSTRAINT PK_MAIL_SEND2 PRIMARY KEY (send_id)
);

CREATE TABLE MST_DICT
(
  id     VARCHAR(40)     not null,
	code     VARCHAR(40)     not null,
	name    VARCHAR(40)     not null,
	status     VARCHAR(10)     not null,
	CONSTRAINT PK_MST_DICT PRIMARY KEY(id)
);

CREATE TABLE sys_user
(
  user_id    VARCHAR(40)     not null,
	password     VARCHAR(40)     not null,
	real_name    VARCHAR(40)     not null,
	mail    VARCHAR(40)     not null,
	phone_number    VARCHAR(40),
	create_by    VARCHAR(40)     not null,
	create_time TIMESTAMP     not null,
	update_by    VARCHAR(40)     not null,
	update_time    TIMESTAMP     not null,
	CONSTRAINT PK_SYS_USER PRIMARY KEY (user_id)
);

INSERT INTO mst_dict VALUES ('1', 'goodCategory', '物品分类', '1');
INSERT INTO mst_dict VALUES('2','express','快递','1');
INSERT INTO mst_dict VALUES('3','water','水','0');
INSERT INTO mst_dict VALUES('4','tea','茶','0');
INSERT INTO mst_dict VALUES('5','orange','橘子','1');
INSERT INTO mst_dict VALUES('6','apple','苹果','1');