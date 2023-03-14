# 프로그래머스 문제

이번엔 문제 좀 많아요. 일단 SELECT 다 풀어보고자 했고, 한 문제는 UNION ALL 이라는 구문을 써야 해결할 수 있을겁니다!?

- [JOIN, 오랜 기간 보호한 동물(1)](https://school.programmers.co.kr/learn/courses/30/lessons/59044)
```mysql
SELECT i.name, i.datetime
FROM animal_ins i left join animal_outs o
ON i.animal_id = o.animal_id
WHERE o.animal_id IS NULL
ORDER BY i.datetime
LIMIT 3;
```

- [SELCET, 강원도에 위치한 생산공장 목록 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131112)
```mysql
SELECT factory_id, factory_name, address
FROM food_factory
WHERE address LIKE '강원도%'
ORDER BY factory_id;
```

- [SELCET, 상위n개 레코드](https://school.programmers.co.kr/learn/courses/30/lessons/59405)
```mysql
SELECT name
FROM animal_ins
ORDER BY datetime
LIMIT 1
```

- [SELCET, 여러 기준으로 정렬하기](https://school.programmers.co.kr/learn/courses/30/lessons/59404)
```mysql
SELECT animal_id, name, datetime
FROM animal_ins
ORDER BY name, datetime DESC
```

- [SELECT, 동물의 아이디와 이름](https://school.programmers.co.kr/learn/courses/30/lessons/59403)
```mysql
SELECT animal_id, name
FROM animal_ins
```

- [SELECT, 어린 동물 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/59037#fn1)
```mysql
SELECT animal_id, name
FROM animal_ins
WHERE intake_condition <> 'aged'
ORDER BY animal_id;
```

- [SELECT, 아픈 동물 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/59036)
```mysql
SELECT animal_id, name
FROM animal_ins
WHERE intake_condition = 'Sick'
```

- [SELECT, 역순 정렬하기](https://school.programmers.co.kr/learn/courses/30/lessons/59035)
```mysql
SELECT name, datetime
FROM animal_ins
ORDER BY animal_id DESC
```

- [SELECT, 재구매가 일어난 상품과 회원 리스트 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/131536)
```mysql
SELECT user_id, product_id
FROM online_sale
GROUP BY user_id, product_id
HAVING COUNT(*) >= 2
ORDER BY user_id, product_id DESC;
```

- [SELECT, 오프라인/온라인 판매 데이터 통합하기](https://school.programmers.co.kr/learn/courses/30/lessons/131537)
```mysql
SELECT date_format(sales_date, '%Y-%m-%d') sales_date, product_id, user_id, sales_amount
FROM online_sale
WHERE month(sales_date) =3
UNION ALL
SELECT date_format(sales_date, '%Y-%m-%d') sales_data, product_id, null user_id, sales_amount
FROM offline_sale
WHERE month(sales_date) =3
ORDER BY sales_date, product_id, user_id
```

WITH tableName as (
UNION 정의
)

- [SELECT, 서울에 위치한 식당 목록 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131118)
```mysql
SELECT i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, round(avg(r.review_score),2) score
FROM rest_info i JOIN rest_review r
ON i.rest_id = r.rest_id
WHERE i.address LIKE '서울%'
GROUP BY i.rest_id
ORDER BY score DESC, i.favorites DESC
```

- [SELECT, 조건에 맞는 도서 리스트 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/144853)
```mysql
SELECT book_id, date_format(published_date, '%Y-%m-%d') published_date
FROM book
WHERE category = '인문' AND year(published_date) = 2021
ORDER BY published_date;
```