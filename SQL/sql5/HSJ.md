- [JOIN, 오랜 기간 보호한 동물(1)](https://school.programmers.co.kr/learn/courses/30/lessons/59044)

```sql
SELECT AI.NAME, AI.DATETIME
FROM ANIMAL_INS AS AI
LEFT OUTER JOIN ANIMAL_OUTS AS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AO.ANIMAL_ID IS NULL
ORDER BY AI.DATETIME ASC
LIMIT 3;
```

- [SELCET, 강원도에 위치한 생산공장 목록 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131112)

```sql
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID;
```

- [SELCET, 상위n개 레코드](https://school.programmers.co.kr/learn/courses/30/lessons/59405)

```sql
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME ASC
LIMIT 1;
```

- [SELCET, 여러 기준으로 정렬하기](https://school.programmers.co.kr/learn/courses/30/lessons/59404)

```sql
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC;
```

- [SELECT, 동물의 아이디와 이름](https://school.programmers.co.kr/learn/courses/30/lessons/59403)

```sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
```

- [SELECT, 어린 동물 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/59037#fn1)

```sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION <> 'Aged'
ORDER BY ANIMAL_ID;
```

- [SELECT, 아픈 동물 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/59036)

```sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID;
```

- [SELECT, 역순 정렬하기](https://school.programmers.co.kr/learn/courses/30/lessons/59035)

```sql
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;
```

- [SELECT, 재구매가 일어난 상품과 회원 리스트 구하기]()

```sql
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(PRODUCT_ID) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC;
```

- [SELECT, 오프라인/온라인 판매 데이터 통합하기](https://school.programmers.co.kr/learn/courses/30/lessons/131537)

```sql
SELECT date_format(sales_date, '%Y-%m-%d') AS sales_date, product_id, user_id, sales_amount
FROM online_sale
WHERE sales_date BETWEEN '2022-03-01' AND '2022-03-31'
UNION ALL
SELECT date_format(sales_date, '%Y-%m-%d') AS sales_date, product_id, NULL as user_id, sales_amount
FROM offline_sale
WHERE sales_date BETWEEN '2022-03-01' AND '2022-03-31'
ORDER BY sales_date, product_id, user_id
```

- [SELECT, 서울에 위치한 식당 목록 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131118)

```sql
SELECT RI.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(RR.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO RI
JOIN REST_REVIEW RR
ON RI.REST_ID = RR.REST_ID
WHERE RI.ADDRESS LIKE '서울%'
GROUP BY RI.REST_ID
ORDER BY SCORE DESC, FAVORITES DESC;
```

- [SELECT, 조건에 맞는 도서 리스트 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/144853)

```sql
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK
# WHERE PUBLISHED_DATE BETWEEN '2021-01-01' AND '2021-12-31' AND CATEGORY = '인문'
WHERE PUBLISHED_DATE LIKE '2021%' AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE ASC;
```