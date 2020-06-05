
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
	board_id varchar2(50),
	board_subject varchar2(100),
	board_content clob,
	board_file varchar2(100),
	board_count number,
	board_date date,
	board_likey number,
	id varchar2(50) NOT NULL,
	PRIMARY KEY (board_num)
);



/* Create Foreign Keys */

ALTER TABLE jsp_member_board
	ADD FOREIGN KEY (id)
	REFERENCES jsp_member (id)
;


SELECT * FROM JSP_MEMBER;

SELECT * FROM jsp_member_board;

CREATE SEQUENCE jsp_member_board;

DROP TABLE JSP_MEMBER_BOARD;

COMMIT;

DROP SEQUENCE jsp_member_board;

SELECT jsp_member FROM DUAL;

SELECT
    OBJECT_NAME
    ,OBJECT_TYPE
FROM
    USER_OBJECTS
WHERE OBJECT_NAME LIKE 'JSP_MEMBER_BOARD';

desc jsp_member_board_objects;

SELECT *
FROM user_objects
WHERE object_name = 'JSP_MEMBER_BOARD';



