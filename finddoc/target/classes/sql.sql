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
select h.hadminid from hadmin h,myhospital m where
		h.ykiho=m.ykiho and m.userid=#{userid}
		
SELECT *
		FROM(
		SELECT ROWNUM AS rn, a.*
		FROM(
		SELECT * FROM
		notice_board where hadminid in(select h.hadminid from hadmin
            h,myhospital m where
            h.ykiho=m.ykiho and m.userid='java' and del='o')and title like '%1%'
		ORDER BY txupdate desc
		) a
		)
		WHERE rn BETWEEN 1 AND 10		

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
	ykiho varchar2(100),
	hname varchar2(50),
	major varchar2(50),
	bookdate date,
	hour varchar2(30),
	mint varchar2(30),
	name varchar2(30),
	birthday date,
	cp varchar2(30),
	text varchar2(200),
	ing varchar2(30)
);

drop table book;

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
add (ykiho varchar2(100));

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
delete from admin_app;

update myhospital set ox='o' 
where ykiho='JDQ4MTAxMiM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQxIyQzIyQ3OSQzNjEyMjIjNTEjJDEjJDYjJDgz' 
and userid='java';

create table test(
	test varchar2(10)
	)
alter table admin_app

select count(*) from book where ykiho='JDQ4MTg4MSM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQxIyQzIyQ3OSQ0NjEwMDIjNjEjJDEjJDQjJDgz' and major='피부과' and bookdate=2019-09-11 00:00:00.0 and hour='오후 12시' and mint='20'

drop column ykiho;
insert into admin_app values('hos9','o');
insert into admin_app values('hos2','o',(select ykiho from hadmin where hadminid='hos2'));
insert into admin_app values('hos4','o',(select ykiho from hadmin where hadminid='hos4'));
insert into admin_app values('hos5','o',(select ykiho from hadmin where hadminid='hos5'));
insert into admin_app values('hos3','x');
delete from admin_app where hadminid='hos7'
delete from book where booknum=2
delete hadmin where hadminid='hos3'
select * from hadmin where hadminid='hos3';
select * from admin_app; 
select * from hadmin;
delete from hadmin where hadminid='hos6';
select * from myhospital where userid='java' and ox='x';
select * from myhospital where userid='java';
delete myhospital where userid='java';
delete from myhospital where userid='java' and ykiho='JDQ4MTAxMiM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQxIyQzIyQ3OSQzNjEyMjIjNTEjJDEjJDYjJDgz';
select count(a.hadminid) from admin_app a, hadmin h where h.ykiho='JDQ4MTAxMiM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQxIyQzIyQ3OSQzNjEyMjIjNTEjJDEjJDYjJDgz' and h.hadminid=a.hadminid and a.approval='o'
update admin_app set approval='x'
where hadminid='hos9';
select h.* from HADMIN h, ADMIN_APP a where a.APPROVAL='o' and a.HADMINID=h.HADMINID
alter table myhospital drop column ox;