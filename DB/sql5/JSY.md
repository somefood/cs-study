1. 오랜 기간 보호한 동물(1)

```mysql
SELECT ANIMAL_INS.NAME,ANIMAL_INS.DATETIME from ANIMAL_INS left join ANIMAL_OUTS 
on(ANIMAL_INS.ANIMAL_ID=ANIMAL_OUTS.ANIMAL_ID)
where ANIMAL_OUTS.ANIMAL_ID is null
order by ANIMAL_INS.DATETIME limit 3 ;
```

2. SELCET, 강원도에 위치한 생산공장 목록 출력하기

```mysql
SELECT FACTORY_ID,FACTORY_NAME,ADDRESS from FOOD_FACTORY where ADDRESS like '강원도%' order by FACTORY_ID asc;
```

3. SELCET, 상위n개 레코드 

```mysql
SELECT name from ANIMAL_INS order by datetime asc limit 1;
```

4. SELCET, 여러 기준으로 정렬하기

```mysql
SELECT animal_id,name,datetime from animal_ins order by name, datetime desc;
```

5. SELECT, 동물의 아이디와 이름

```mysql
SELECT ANIMAL_ID,NAME from animal_ins order by animal_id;
```

6. SELECT, 어린 동물 찾기

```
SELECT animal_id, name from animal_ins where INTAKE_CONDITION not in ('AGED') order by animal_id;
```

7. 아픈 동물 찾기

```
SELECT ANIMAL_ID, name from animal_ins where intake_condition = 'sick' order by animal_id;
```

8. 역순 정렬하기

```
SELECT name, datetime from ANIMAL_INS order by ANIMAL_ID desc;
```

9. 재구매가 일어난 상품과 회원 리스트 구하기

```
SELECT USER_ID, PRODUCT_ID from ONLINE_SALE GROUP BY USER_ID, PRODUCT_ID HAVING count(USER_ID)>=2 
ORDER BY USER_ID ASC, PRODUCT_ID DESC;
```

10. SELECT, 오프라인/온라인 판매 데이터 통합하기

```
SELECT date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE,PRODUCT_ID,USER_ID,SALES_AMOUNT
from ONLINE_SALE
where SALES_DATE like '2022-03%'
union all
SELECT date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE,PRODUCT_ID,null as USER_ID,SALES_AMOUNT
from OFFLINE_SALE
where SALES_DATE like '2022-03%'
order by SALES_DATE,PRODUCT_ID,USER_ID asc;
```

11. 서울에 위치한 식당 목록 출력하기


```
SELECT REST_INFO.REST_ID,REST_NAME,FOOD_TYPE,FAVORITES,ADDRESS,ROUND(avg(REVIEW_SCORE), 2) SCORE 
from REST_INFO inner join REST_REVIEW on (REST_INFO.REST_ID = REST_REVIEW.REST_ID)
where address like '서울%'
group by REST_REVIEW.REST_ID 
order by SCORE desc, FAVORITES desc;
```

12. 조건에 맞는 도서 리스트 출력하기

```
SELECT BOOK_ID,date_format(PUBLISHED_DATE, '%Y-%m-%d') 
from book where PUBLISHED_DATE LIKE '2021%' and CATEGORY = '인문' 
order by PUBLISHED_DATE asc;
```