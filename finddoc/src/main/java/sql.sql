#공지사항 게시판
create table notice_board(
	noticeboardnum number(30) primary key,
	noticecount number(30),
	hadminid varchar2(30),
	title varchar2(100),
	text varchar2(2000),
	del char(2),
	txupdate date,
	moddate date
);

#문의 게시판
create table oneboard(
	oneboardnum number(30) primary key,
	onecount number(30),
	hadminid varchar2(30),
	title varchar2(100),
	text varchar2(2000),
	del char(2),
	txupdate date,
	moddate date
);

#문의 게시판 댓글
create table oneboard_reply(
	id varchar2(30),
	reply varchar2(2000),
	del char(2),
	replydate date,
	oneboardnum number(30),
	onereply number(30) primary key
);

#관리자 승인
create table admin_app(
	hadminid varchar2(30),
	approval char(2),
	approvalnum number(30) primary key
);

#자주가는 병원목록
create table myhospital(
	userid varchar2(30),
	approvalnum number(30),
	ox char(2)
);

#병원예약
create table book(
	userid varchar2(30),
	booknum number(30) primary key,
	approvalnum number(30),
	major varchar2(50),
	bookdate varchar2(20),
	name varchar2(30),
	birthday varchar2(30),
	cp varchar2(30),
	text varchar2(200),
	ing varchar2(30)
);

#병원접수
create table receipt(
	userid varchar2(30),
	receiptnum number(30) primary key,
	approvalnum number(30),
	major varchar2(50),
	receiptdate varchar2(20),
	name varchar2(30),
	birthday varchar2(30),
	cp varchar2(30),
	text varchar2(200),
	ing varchar2(30)
);
	
#공지사항게시판의 글번호
create sequence noticeboardnum_seq;

#공지사항게시판 조회수
create sequence noticecount_seq;

#문의게시판의 글번호
create sequence oneboardnum_seq;

#문의게시판 조회수
create sequence onecount_seq;

#문의게시판 댓글번호
create sequence onereply_seq;

#병원회원의 번호
create sequence approvalnum_seq;

#예약번호
create sequence booknum_seq;

#접수번호
create sequence receiptnum_seq;

#제약조건
alter table oneboard_reply
add constraint onboard_reply_fk foreign key(oneboardnum) references oneboard(oneboardnum);

alter table admin_app
add constraint hadminid_fk foreign key(hadminid) references hadmin(hadminid);

alter table myhospital
add constraint myhosptal_userid_fk foreign key(userid) references member(userid);

alter table myhospital
add constraint myhospital_approvalnum_fk foreign key(approvalnum) references admin_app(approvalnum);

alter table book
add constraint book_userid_fk foreign key(userid) references member(userid);

alter table book
add constraint book_approvalnum_fk foreign key(approvalnum) references admin_app(approvalnum);

alter table receipt
add constraint receipt_userid_fk foreign key(userid) references member(userid);

alter table receipt
add constraint receipt_approvalnum_fk foreign key(approvalnum) references admin_app(approvalnum);

alter table myhospital
rename column APPROVALNUM to ykiho;

alter table book
rename column APPROVALNUM to ykiho;

alter table receipt
rename column APPROVALNUM to ykiho;

alter table receipt
drop constraint receipt_APPROVALNUM_fk;

alter table myhospital
modify (ykiho varchar2(100));

alter table book
modify (ykiho varchar2(100));

alter table receipt
modify (ykiho varchar2(100));

select * from admin_app;
delete from hadmin where hadminid='hos3';

update myhospital set ox='o' 
where ykiho='JDQ4MTAxMiM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQxIyQzIyQ3OSQzNjEyMjIjNTEjJDEjJDYjJDgz' 
and userid='java';

create table test(
	test varchar2(10)
	)

select * from myhospital where userid='java' and ox='x';
select * from myhospital where userid='java';
delete myhospital where userid='java';
delete from myhospital where userid='java' and ykiho='JDQ4MTAxMiM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQxIyQzIyQ3OSQzNjEyMjIjNTEjJDEjJDYjJDgz';

update myhospital set ox='x' 
where userid='java';

alter table myhospital drop column ox;