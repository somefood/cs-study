# 프로그래머스 문제

- [SELECT](https://school.programmers.co.kr/learn/courses/30/lessons/133024)
  
```mysql
SELECT FLAVOR FROM FIRST_HALF ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC;
```

- [SELECT](https://school.programmers.co.kr/learn/courses/30/lessons/132203)

```mysql
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')
FROM DOCTOR
WHERE MCDP_CD IN ('CS', 'GS')
ORDER BY HIRE_YMD DESC, DR_NAME ASC;
```

- [IS NULL](https://school.programmers.co.kr/learn/courses/30/lessons/131114)

```mysql
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID ASC;
```

- [String, Date](https://school.programmers.co.kr/learn/courses/30/lessons/59047)

```mysql
SELECT ANIMAL_ID, NAME 
FROM ANIMAL_INS
WHERE NAME LIKE '%el%' AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;
```

- [GROUP BY](https://school.programmers.co.kr/learn/courses/30/lessons/59041)

> COUNT(*)은 내용이 null이여도 집계될 수 있다. 
> COUNT(NAME)으로 하면 null인 것은 집계되지 않음

```mysql
SELECT NAME, COUNT(NAME) AS 'COUNT'
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME) >= 2
ORDER BY NAME;
```

## 12월 11일 추가 문제

- [GROUP BY, 진료과별 총 예약 횟수 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/132202)

> WHERE이 GROUP BY 보다 먼저 처리된다.

```mysql
SELECT MCDP_CD AS '진료과 코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT
WHERE APNT_YMD BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY MCDP_CD
ORDER BY COUNT(*) ASC, MCDP_CD ASC;
```

- [JOIN, 없어진 기록 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/59042)

```mysql
SELECT AO.ANIMAL_ID, AO.NAME
FROM ANIMAL_INS AS AI
RIGHT JOIN ANIMAL_OUTS AS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.ANIMAL_ID IS NULL
ORDER BY AO.ANIMAL_ID ASC;
```

- [JOIN, 있었는데요 없었습니다](https://school.programmers.co.kr/learn/courses/30/lessons/59043)

```mysql
SELECT AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS AS AI
JOIN ANIMAL_OUTS AS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AO.DATETIME < AI.DATETIME
ORDER BY AI.DATETIME;
```

- [SUM, MAX, MIN,최댓값 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/59415)

> DATE도 대소 구분할 수 있다.

```mysql
SELECT MAX(DATETIME) FROM ANIMAL_INS;
```

- [SELECT, 3월에 태어난 여성 회원 목록 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131120)

> DATE_FORMAT(필드, 포맷) 형태를 활용하면 원하는 날짜 형태를 가질 수 있다.
> MONTH(필드)를 활용해서 월만 출력할 수 있다.

```mysql
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE TLNO IS NOT NULL
AND MONTH(DATE_OF_BIRTH) = 3
AND GENDER = 'W'
ORDER BY MEMBER_ID DESC;
```