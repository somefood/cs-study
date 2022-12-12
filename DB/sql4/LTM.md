#1번 SELECT https://school.programmers.co.kr/learn/courses/30/lessons/133024

```mysql
 SELECT flavor from first_half order by total_order desc, shipment_id
```

#2번 SELECT https://school.programmers.co.kr/learn/courses/30/lessons/132203

```mysql
select DR_NAME, DR_ID, MCDP_CD, date_format(hire_ymd, "%Y-%m-%d") as HIRE_YMD from doctor where mcdp_cd = "CS" or mcdp_cd = "GS" order by hire_YMD desc, dr_name
```


#3번 IS NULL https://school.programmers.co.kr/learn/courses/30/lessons/131114

```mysql
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS , IFNULL(FREEZER_YN, "N") AS FREEEZER_YN FROM FOOD_WAREHOUSE WHERE ADDRESS LIKE '경기%'
```


#4번 String, Date https://school.programmers.co.kr/learn/courses/30/lessons/59047

```mysql
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE NAME LIKE '%EL%' AND ANIMAL_TYPE = 'Dog' ORDER BY NAME
```


#5번 GROUP BY https://school.programmers.co.kr/learn/courses/30/lessons/59041

```mysql
SELECT NAME, COUNT(NAME) FROM ANIMAL_INS GROUP BY NAME HAVING COUNT(NAME) > 1 ORDER BY NAME
```
