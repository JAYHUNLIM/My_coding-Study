[오라클 서비스 확인]
-CMD
	->sqlplus 1234 system/1234
	
콘솔창 예쁘게 출력
set linesize 1000;
col uname for a10;
col addr for a10;

--성적 테이블 삭제
drop table sungjuk;
--성적 시퀀스 삭제
drop sequence sungjuk_seq;

--성적 테이블 생성
create table sungjuk(
     sno   int         not null --일련번호
    ,uname varchar(50) not null --이름
    ,kor   int         not null --국어
    ,eng   int         not null --영어
	,mat   int         not null --수학
    ,aver  int         null     --평균
    ,addr  varchar(50)          --주소
    ,wdate date                 --등록일(년월일시분초)
    ,primary key(sno)
);

--성적 시퀀스 생성
create sequence sungjuk_seq;

[게시판 페이지 흐름]

입력-> 목록->상세보기 ->삭제
1.입력
sungjukForm -> sungjukIns

2.목록				list에서 sno값을 받아옴			sno받아옴
sungjukList.jsp -> 상세보기 sungjukRead.jsp -> 삭제 sungjukDel.jsp


3.수정
sungjukupdate -> 수정하고자하는 행을 db에서 가져와서,
작성했던 내용을 그대로 성적 폼에 출력
sungjukRead와 sungjukForm 참조

sungjukUpdateProc -> 사용자가 수정한 내용으로 업데이트 

[행추가]
insert into sungjuk(sno,uname,kor,eng,mat,aver,addr,wdate)
values(sungjuk_seq.nextval,?,?,?,?,?,?,sysdate);

[전체 목록]- 최신글을 기준으로 불러옴
select * from sungjuk order by wdate desc;

[상세보기] 목록 페이지 참조
select * from sungjuk where sno=?;
[행 삭제]
delete from sungjuk where sno=?;

[행 수정]sungjukUpdate.jsp: select문
->sungjukUpdateProc.jsp: update 
update sungjuk
set uname=?,kor=?,eng=?,mat=?,aver=?,addr=?,wdate=sysdate
where sno=?;