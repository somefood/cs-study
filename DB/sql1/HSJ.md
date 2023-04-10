# 과제1

1. customers 테이블에서 country가 France인 로우들을 검색하시오.
> SELECT * FROM customers where country = 'France';

2. customers 테이블에서 customerName이 Mini로 시작하는 로우들을 검색하시오.
> SELECT * FROM customers WHERE customerName LIKE 'mini%';

3. customers 테이블에서 addressLine2가 NULL인 로우들을 검색하시오.
> SELECT * FROM customers WHERE addressLine2 IS NULL;

4. customers 테이블에서 addressLine2가 NULL이면서 customerName가 'Co' 끝나는 로우들을 검색하시오.
> SELECT * FROM customers WHERE addressLine2 IS NULL AND customerName LIKE '%co';

5. employees 테이블에서 officeo officeCode의 중복을 제거해서 "내림차순"으로 검색하시오.
> SELECT distinct officeCode FROM employees ORDER BY officeCode desc;
