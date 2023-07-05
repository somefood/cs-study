- [JOIN, 조건에 맞는 도서와 저자 리스트 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/144854)

```sql
SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK b
JOIN AUTHOR a
ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE b.CATEGORY = '경제'
ORDER BY b.PUBLISHED_DATE ASC;
```

- [JOIN, 5월 식품들의 총매출 조회하기](https://school.programmers.co.kr/learn/courses/30/lessons/131117)

```sql
SELECT fr.PRODUCT_ID, fr.PRODUCT_NAME, SUM(fo.AMOUNT) * fr.PRICE AS TOTAL_SALES
FROM FOOD_PRODUCT fr
JOIN FOOD_ORDER fo
ON fr.PRODUCT_ID = fo.PRODUCT_ID
WHERE fo.PRODUCE_DATE LIKE '2022-05%'
GROUP BY fr.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, fr.PRODUCT_ID
```

- [JOIN, 그룹별 조건에 맞는 식당 목록 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131124)

```sql
SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE mp
JOIN REST_REVIEW rr
ON mp.MEMBER_ID = rr.MEMBER_ID
WHERE rr.MEMBER_ID = (SELECT MEMBER_ID FROM REST_REVIEW
                        GROUP BY MEMBER_ID
                        ORDER BY count(*) DESC
                        LIMIT 1)
ORDER BY REVIEW_DATE, REVIEW_TEXT
```

- [JOIN, 주문량이 많은 아이스크림들 조회하기](https://school.programmers.co.kr/learn/courses/30/lessons/133027)

```sql
SELECT fh.FLAVOR
FROM FIRST_HALF fh
JOIN JULY j
ON fh.FLAVOR = j.FLAVOR
GROUP BY j.FLAVOR
ORDER BY fh.TOTAL_ORDER + SUM(j.TOTAL_ORDER) DESC
LIMIT 3;
```

- [JOIN, 보호소에서 중성화한 동물](https://school.programmers.co.kr/learn/courses/30/lessons/59045)

```sql
SELECT ao.ANIMAL_ID, ao.ANIMAL_TYPE, ao.NAME
FROM ANIMAL_INS ai
JOIN ANIMAL_OUTS ao
ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ai.SEX_UPON_INTAKE LIKE 'Intact%'
AND (ao.SEX_UPON_OUTCOME LIKE 'Spayed%' OR ao.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY ao.ANIMAL_ID;
```

- [JOIN, 상품을 구매한 회원 비율 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/131534)

```
```