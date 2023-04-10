1.  INSERT INTO offices values (8,'seoul','010 1111 1111','100 Market Street','dddd','SE','KOREA','55555','KOREA');



2. INSERT INTO employees values (1111,'Seokju','Hong','x5555','sdsd98@naver.com',8,NULL ,'Programmar (Manager)');
INSERT INTO employees values (1112,'Sangyun','Jung','x5555','sdsd988@naver.com',8,1111,'Programmar');
INSERT INTO employees values (1113,'Taemin','Lee','x5555','sdsd98@naver.com',8,1111,'Programmar');

3. select concat(manager.firstName,' ',manager.lastName) as '매니저',
       manager.email as '\'매니저 이메일\'',
       concat(employ.firstName,' ',employ.lastName) as '사원',
       employ.email as '\'사원 이메일\''
from employees as manager
inner join employees as employ on(manager.employeeNumber = employ.reportsTo)
where employ.officeCode = 8;

4. update employees set extension = 'x3333' where employeeNumber = 1112 ;

5. update employees set extension = 'x7777' where jobTitle = 'Programmar';


6. DELETE from employees where employeeNumber = 1112;

>프로그래머스 과제

1. 단순 SELECT, IFNULL 함수

SELECT PT_NAME,PT_NO,GEND_CD,AGE, CASE when TLNO is null then 'NONE' ELSE TLNO END 'TLNO' 
from patient where age<=12 and GEND_CD = 'W' 
order by AGE DESC, PT_NAME asc;

2. JOIN, 2단계

SELECT PRODUCT_CODE,SUM(PRICE*SALES_AMOUNT) SALES from product inner join OFFLINE_SALE 
on (PRODUCT.PRODUCT_ID = offline_SALE.PRODUCT_ID) group by PRODUCT_CODE order by SALES desc, PRODUCT_CODE asc;

