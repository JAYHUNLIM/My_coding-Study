--sungjuk테이블 행추가
insert into sungjuk(sno, uname, kor, eng, mat, addr, wdate)
values(sungjuk_seq.nextval,'손흥민',99,98,97,'Seoul',sysdate);

select * from sungjuk order by sno desc;

--sqlplus 사용자 추천
--오라클 콘솔창 예쁘게 출력
set linesize 1000;
col uname for a10;
col addr for a10;


update sungjuk
set tot=kor+eng+mat, aver=(kor+eng+mat)/3
where sno=133

delete from sungjuk
where sno=133;

--sungjuk 테이블의 전체 행 갯수
select count(*) from sungjuk;

select sno, uname, kor, eng, mat, addr, tot, aver,wdate from sungjuk where sno=132;


--문제. 주소가 서울인 행들의 국영수 평균값을 구하시오
-- 소수점은 반올림해서 둘째자리까지 표현
select round(avg(kor),2), round(avg(eng),2),round(avg(mat),2)
from sungjuk
where addr='Seoul';

--컬럼명 변경하기
select round(avg(kor),2) as avg_kor, round(avg(eng),2)avg_eng,round(avg(mat),2) avg_mat
from sungjuk
where addr='Seoul';


--문제 이름에 '나'문자가 있는 행을 조회
SELECT * FROM SUNGJUK
WHERE uname like '%나%';

--sungjuk테이블에서 sno 내림차순 정렬후
--행번호4~6조회

select sno, uname, kor, eng, mat,aver,addr,rownum
from sungjuk
order by uname;

--self 조인을 하고난 뒤에 rownum 추가
select sno, uname,aver,addr, rownum
from (
select sno, uname,aver,addr
from sungjuk
order by uname)
where rownum>=4 and rownum <=6;
--한번더 조인후 rownum 추가
select *
from(
	select sno, uname,aver,addr, rownum as rnum 
	from (
		select sno, uname,aver,addr
		from sungjuk
		order by uname
		)
	)
where rnum>=4 and rnum <=6;


-- 학번 g1001이 수강신청한 과목을 과목코드 별로 조회하시오
SELECT *
FROM(
select TB.HAKNO, GW.GCODE, GW.GNAME
from tb_sugang TB join tb_gwamok GW
on TB.gcode= GW.GCODE
WHERE  HAKNO ='g1001'
ORDER BY GCODE;