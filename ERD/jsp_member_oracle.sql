
/* Drop Tables */

DROP TABLE jsp_member_board CASCADE CONSTRAINTS;
DROP TABLE jsp_member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE jsp_member
(
	id varchar2(50) NOT NULL,
	password varchar2(50) NOT NULL,
	name varchar2(50),
	gender varchar2(10),
	birth date,
	mail varchar2(100),
	phone varchar2(50),
	address varchar2(200),
	reg date DEFAULT SYSDATE,
	PRIMARY KEY (id)
);


CREATE TABLE jsp_member_board
(
	board_num number NOT NULL,
	board_subject varchar2(100),
	board_content clob,
	board_count number,
	board_date date DEFAULT SYSDATE,
	id varchar2(50) NOT NULL,
	PRIMARY KEY (board_num)
);



/* Create Foreign Keys */

ALTER TABLE jsp_member_board
	ADD FOREIGN KEY (id)
	REFERENCES jsp_member (id)
;

SELECT * FROM USER_SEQUENCES;


SELECT * FROM jsp_member_board_SEQUENCES;

CREATE SEQUENCE jsp_member_board_seq;

				jsp_board_member_seq
				
SELECT * FROM JSP_MEMBER;

SELECT * FROM jsp_member_board;

CREATE SEQUENCE jsp_member_board_seq;

DROP TABLE JSP_MEMBER_BOARD;

DROP TABLE JSP_MEMBER;

COMMIT;

DROP SEQUENCE jsp_member_board_seq;

SELECT jsp_member FROM DUAL;

INSERT INTO JSP_MEMBER_BOARD (BOARD_NUM , BOARD_SUBJECT , BOARD_CONTENT ,ID )
	SELECT jsp_member_board_seq.nextval, BOARD_SUBJECT , BOARD_CONTENT , ID FROM JSP_MEMBER_BOARD;

CREATE USER scott IDENTIFIED BY tiger;

GRANT connect, resource, create view, create procedure TO scott;
