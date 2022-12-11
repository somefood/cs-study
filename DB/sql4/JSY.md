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
