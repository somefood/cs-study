# 과제1

1. customers 테이블에서 country가 France인 로우들을 검색하시오.
>select * from customers where country = 'France';

2. customers 테이블에서 customerName이 Mini로 시작하는 로우들을 검색하시오.
>select * from custmoers WHERE customerName LIKE 'mini%';

3. customers 테이블에서 addressLine2가 Null인 로우들을 검색하시오.
>select * from customers where addressLine2 is NULL;

4. custmoers 테이블에서 addressLine2가 NULL이면서 customerName가 'Co'로 끝나는 로우들을 검색하시오.
>select * from customers where addressLine2 IS NULL AND customerName LIKE '%co';

5. employees 테이블에서 officecode의 중복을 제거해서 "내림차순"으로 검색

>select distinct officeCode from employees ORDER BY officeCode desc;

#과제2

1. 상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.

>SELECT FIRST_HALF.FLAVOR from FIRST_HALF f inner join ICECREAM_INFO i on (FIRST_HALF.FLAVOR=ICECREAM_INFO.FLAVOR)
where ICECREAM_INFO.INGREDIENT_TYPE = 'fruit_based' and FIRST_HALF.TOTAL_ORDER>3000 
ORDER BY FIRST_HALF.TOTAL_ORDER DESC;