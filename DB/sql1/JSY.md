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


#과제3 

1.동물 보호소에 들어온 모든 동물의 정보를 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요
> SELECT * from ANIMAL_INS ORDER BY 'ANIMAL_INS' DESC;

#과제4

1. USER_INFO 테이블에서 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출력하는 SQL문을 작성해주세요.

>SELECT count(USER_ID) USERS from USER_INFO where (JOINED between '2021-01-01' and '2021-12-31') 
and AGE between '20' and '29';