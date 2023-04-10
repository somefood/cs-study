# 프로그래머스 문제

- [SELECT](https://school.programmers.co.kr/learn/courses/30/lessons/133024)
```mysql
SELECT FLAVOR FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID
```

- [SELECT](https://school.programmers.co.kr/learn/courses/30/lessons/132203)
```mysql
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = "CS" OR MCDP_CD = "GS"
ORDER BY HIRE_YMD DESC, DR_NAME;
```

- [IS NULL](https://school.programmers.co.kr/learn/courses/30/lessons/131114)
 ```mysql
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN,"N") FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE "경기도%"
ORDER BY WAREHOUSE_ID;
```

- [String, Date](https://school.programmers.co.kr/learn/courses/30/lessons/59047)
```mysql
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS
WHERE NAME LIKE "%EL%" AND ANIMAL_TYPE ="DOG"
ORDER BY NAME;
```

- [GROUP BY](https://school.programmers.co.kr/learn/courses/30/lessons/59041)
```mysql
SELECT name, count(name) COUNT FROM ANIMAL_INS
GROUP BY name
HAVING count(name) > 1
ORDER BY name;
```

## 12월 11일 추가 문제

- [GROUP BY, 진료과별 총 예약 횟수 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/132202)
```mysql
SELECT mcdp_cd "진료과코드", count(*) "5월예약건수" FROM APPOINTMENT
WHERE apnt_ymd between "2022-05-01" and "2022-05-31"
GROUP BY mcdp_cd
ORDER BY count(*), pt_no;
```

- [JOIN, 없어진 기록 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/59042)
```mysql
SELECT o.animal_id, o.name
FROM ANIMAL_OUTS o left join ANIMAL_INS i
ON o.animal_id = i.animal_id
where i.animal_id IS NULL
ORDER BY o.animal_id;
```
 
- [JOIN, 있었는데요 없었습니다](https://school.programmers.co.kr/learn/courses/30/lessons/59043)
```mysql
SELECT o.animal_id, o.name 
FROM animal_outs o left join animal_ins i
ON o.animal_id = i.animal_id
WHERE o.datetime < i.datetime
ORDER BY i.datetime;
```

- [SUM, MAX, MIN,최댓값 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/59415)
```mysql
SELECT max(datetime) '시간'
FROM animal_ins;
```

- [SELECT, 3월에 태어난 여성 회원 목록 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131120)
```mysql
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(date_of_birth, "%Y-%m-%d") DATE_OF_BIRTH
FROM member_profile
WHERE MONTH(date_of_birth)=3
AND tlno is not null
AND gender = "W"
ORDER BY member_id;
```
