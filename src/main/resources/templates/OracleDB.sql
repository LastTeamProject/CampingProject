-- 회원 및 관리자 계정 테이블
CREATE SEQUENCE member_idx_seq;
CREATE TABLE MEMBER(
	id varchar2(100) PRIMARY KEY,
	idx NUMBER,
	password varchar2(100) NOT NULL,
	name varchar2(100) NOT NULL,
	phone NUMBER(11) NOT NULL,
	email varchar2(100) NOT NULL,
	gender char(1) check(gender IN('0','1'))NOT NULL,
	col1 varchar2(100),
	col2 NUMBER,
	col3 varchar2(100)
);

-- 회원 및 관리자 계정 권한 나누는 테이블
CREATE SEQUENCE member_role_idx_seq;
CREATE TABLE member_role(
	idx NUMBER PRIMARY KEY,
	id varchar2(100) NOT NULL,			-- 회원 및 관리자 계정 테이블의 id와 연결
	ROLE varchar2(100) NOT NULL,
	col1 varchar2(100),
	col2 NUMBER
);

-- 업체 테이블

CREATE SEQUENCE company_idx_seq;
DROP SEQUENCE company_idx_seq;
DROP TABLE COMPANY;
CREATE table company(
	idx NUMBER PRIMARY KEY,
	name varchar2(100) NOT null,
	add1 varchar2(100) NOT NULL,
	add2 varchar2(100) NOT NULL,
	postcode number(20) NOT NULL,
	eco varchar2(100) NOT NULL,
	roomtype varchar2(100) NOT NULL,
	theme varchar2(100) NOT NULL,
	areacode number(10) NOT NULL,		-- 전국지도 테이블의 areacode와 연결
	Latitude float(30) NOT NULL,
	logitude float(30) NOT NULL,
	col1 varchar2(100),
	col2 number
);

-- 업체 방 테이블
<<<<<<< HEAD
CREATE SEQUENCE company_room_roomidx_seq;
=======

CREATE SEQUENCE company_room_roomidx_seq;
DROP TABLE COMPANY_ROOM;
>>>>>>> hwan91
CREATE TABLE company_room(
	roomidx number PRIMARY KEY,
	idx NUMBER NOT NULL,				-- 업체 테이블의 idx와 연결
	roomname varchar2(100) NOT NULL,
	minpeople number(2) NOT NULL,
	maxpeople number(2) NOT NULL,
	price number(10) NOT NULL,
	r_check char(1) check(r_check IN('0','1'))NOT NULL,
	content varchar2(4000) NOT NULL,
	col1 varchar2(100),
	col2 number
);

-- 방 예약 테이블
DROP TABLE reservation;
CREATE TABLE reservation(
	id varchar2(100),					-- 회원 및 관리자 계정 테이블의 id와 연결
	roomidx number NOT null,			-- 업체방 테이블의 roomidx와 연결
	email varchar2(100) NOT NULL,
	col1 varchar2(100),
	col2 NUMBER
);

-- 광고 테이블
CREATE SEQUENCE AD_idx_seq;
CREATE TABLE AD(
	idx NUMBER PRIMARY KEY,
	id varchar2(100) NOT NULL,			-- 회원 및 관리자 계정 테이블의 id와 연결
	subject varchar2(500) NOT NULL,
	content varchar2(4000) NOT NULL,
	regDate timestamp DEFAULT sysdate,
	col1 varchar2(100),
	col2 NUMBER
);

-- 게시판 테이블
CREATE SEQUENCE fileBoard_idx_seq;
CREATE TABLE fileBoard(
 	idx NUMBER PRIMARY KEY,
	id varchar2(100) NOT NULL, 			-- 회원 및 관리자 계정 테이블의 id와 연결
	subject varchar2(500) NOT NULL,
	content varchar2(4000) NOT NULL,
	regDate timestamp DEFAULT sysdate,
	clickCount NUMBER(20) DEFAULT 0
);

<<<<<<< HEAD
<<<<<<< HEAD
DROP TABLE fileboard;
DROP SEQUENCE fileBoard_idx_seq;

=======
>>>>>>> hoegyeong99
=======
>>>>>>> hwan91
INSERT INTO JSPUSER.FILEBOARD
(IDX, ID, SUBJECT, CONTENT, REGDATE, CLICKCOUNT)
VALUES(fileBoard_idx_seq.nextval, 'admin', 'testsubject', 'testcontent', sysdate, 0
);
INSERT INTO JSPUSER.FILEBOARD
(IDX, ID, SUBJECT, CONTENT, REGDATE, CLICKCOUNT)
VALUES(fileBoard_idx_seq.nextval, 'admin', 'testsubject2', 'testcontent2', sysdate, 0
);
INSERT INTO JSPUSER.FILEBOARD
(IDX, ID, SUBJECT, CONTENT, REGDATE, CLICKCOUNT)
VALUES(fileBoard_idx_seq.nextval, 'admin', 'testsubject3', 'testcontent3', sysdate, 0
);


-- 전국지도 테이블
CREATE SEQUENCE map_idx_seq;
CREATE TABLE map(
	areacode NUMBER PRIMARY KEY,
	coordinate varchar2(1000) NOT NULL,
	mapimage varchar2(100) NOT NULL,
	col1 varchar2(100),
	col2 number
);

-- 상세지도 테이블
CREATE SEQUENCE detailmap_idx_seq;
CREATE TABLE detailmap(
	idx NUMBER PRIMARY KEY,
	areacode NUMBER NOT NULL,			-- 전국지도 테이블의 areacode와 연결
	detailmap varchar2(100) NOT NULL,
	detailmapimage varchar2(100) NOT NULL,
	coordinate varchar2(1000) NOT NULL,
	col1 varchar2(100),
	col2 number
);

COMMIT;

SELECT * FROM TAB;
DROP SEQUENCE member_idx_seq;
DROP TABLE reservation ;
<<<<<<< HEAD
=======
SELECT * FROM COMPANY;

SELECT * FROM DETAILMAP d ;

>>>>>>> hwan91
