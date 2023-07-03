--hrdkorea.sql

--여행 상품 코드 테이블
create table tbl_tourcode_02(
	tcode char(4) primary key,
	tarea varchar2(30),
	tdate char(8),
	ttime char(4),
	tday number(2),
	thotel varchar2(30),
	tmoney number(7),
	tair  varchar2(30)
);

commit;

insert into tbl_tourcode_02
values('JJ01','제주','20181201','0930',2,'J호텔',360000,'J항공');

insert into tbl_tourcode_02
values('JJ02','부산','20181202','1000',2,'B호텔',280000,'B항공');

insert into tbl_tourcode_02
values('JJ03','제주','20181204','1000',2,'J호텔',360000,'J항공');

insert into tbl_tourcode_02
values('JJ04','제주','20181207','1100',3,'J호텔',420000,'J항공');

insert into tbl_tourcode_02
values('JJ05','부산','20181209','1330',2,'B호텔',260000,'B항공');

insert into tbl_tourcode_02
values('JJ06','제주','20181210','0930',3,'J호텔',460000,'J항공');

select * from tbl_tourcode_02;

drop table tbl_tourcode_02;


create table tbl_reserve_01(
	rno char(8) primary key,
	rjumin varchar2(13),
	rname varchar2(20),
	rphone1 char(3),
	rphone2 char(4),
	rphone3 char(4),
	remail varchar2(30),
	rstat char(1),
	tcode  char(4)
);

drop table tbl_reserve_01;
--FOREIGN KEY (tcode) REFERENCES tbl_tourcode_02 (tcode)

select * from tbl_reserve_01;

set linesize 1000;
col tair for a10;
col thotel for a10;
col tarea for a10;

select tcode, '[' || tcode || ']' || tarea
|| substr(tdate,1,4) || '-' || substr(tdate,5,2) || '-' || substr(tdate,7,2)
|| '출발' as tname
from tbl_tourcode_02;

select tcode,tarea,tdate
from tbl_tourcode_02
order by tcode;


---------예약 내역 조회하기
select tbl_reserve_01.tcode, tarea ,tdate,ttime,tday,thotel,tmoney,tair 
,rno,rjumin,rname,rphone1,rphone2,rphone3,remail,rstat
from tbl_tourcode_02 inner join  tbl_reserve_01 
on tbl_tourcode_02.tcode = tbl_reserve_01.tcode
order by tbl_reserve_01.tcode;