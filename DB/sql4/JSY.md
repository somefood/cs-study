1. SELECT

```mysql
SELECT flavor from FIRST_HALF order by TOTAL_ORDER desc,SHIPMENT_ID asc;
```

2. SELECT

```mysql
SELECT DR_NAME,DR_ID,MCDP_CD,DATE_FORMAT(HIRE_YMD '%Y-%m-%d') from DOCTOR where MCDP_CD = 'CS' or MCDP_CD = 'GS' order by HIRE_YMD desc, DR_NAME asc;
```

3. IS NULL

```mysql
SELECT WAREHOUSE_ID,WAREHOUSE_NAME,ADDRESS,IFNULL(FREEZER_YN, 'N') as FREEZER_YN 
from FOOD_WAREHOUSE 
where ADDRESS like '경기%'
order by WAREHOUSE_ID asc;
```

4. String, Date

```mysql
SELECT ANIMAL_ID, NAME from ANIMAL_INS 
where NAME like '%el%' and ANIMAL_TYPE = 'Dog'
order by name;
```

5. Group By

```mysql
SELECT NAME, count(NAME) COUNT from ANIMAL_INS group by NAME having(count(NAME)>=2) order by NAME;
```

<br />
<br />
12월 11일 추가 문제


<br />

1. GROUP BY, 진료과별 총 예약 횟수 출력하기

```mysql
SELECT MCDP_CD '진료과코드', count(APNT_YMD) '5월예약건수' from appointment 
where DATE_FORMAT(APNT_YMD,'%m') = '05'
group by MCDP_CD 
order by count(APNT_YMD) asc, MCDP_CD asc;
```

2. JOIN, 없어진 기록 찾기

```mysql
SELECT ANIMAL_OUTS.ANIMAL_ID,ANIMAL_OUTS.NAME from ANIMAL_OUTS left join ANIMAL_INS 
on(ANIMAL_INS.ANIMAL_ID=ANIMAL_OUTS.ANIMAL_ID)
where ANIMAL_INS.ANIMAL_ID is null
order by ANIMAL_OUTS.ANIMAL_ID;
```

3. JOIN, 있었는데요 없었습니다

```mysql
SELECT ANIMAL_INS.ANIMAL_ID,ANIMAL_INS.NAME from ANIMAL_INS inner join ANIMAL_OUTS 
on(ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID)
where (ANIMAL_INS.DATETIME>ANIMAL_OUTS.DATETIME)
order by ANIMAL_INS.DATETIME asc;
```

4. SUM, MAX, MIN,최댓값 구하기

```mysql
SELECT Max(DATETIME) '시간' from animal_ins;
```

5. SELECT, 3월에 태어난 여성 회원 목록 출력하기

```mysql
SELECT MEMBER_ID,MEMBER_NAME,GENDER,DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') DATE_OF_BIRTH from MEMBER_PROFILE 
where DATE_FORMAT(DATE_OF_BIRTH,'%m') ='03' and NOT TLNO is null and GENDER = 'W'
ORDER BY MEMBER_ID asc;
```