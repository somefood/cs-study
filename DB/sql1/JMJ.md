1. `customers` 테이블에서 `country`가 `France`인 로우들을 검색하시오.
   SELECT * FROM customers WHERE country = 'France';

2. `customers` 테이블에서 `customerName`이 `Mini`로 시작하는 로우들을 검색하시오.
   SELECT * FROM customers WHERE customerName LIKE 'Mini%';

3. `customers` 테이블에서 `addressLine2`가 `NULL`인 로우들을 검색하시오.
   SELECT * FROM customers WHERE addressLIne2 IS NULL;

4. `customers` 테이블에서 `addressLine2`가 `NULL`이면서 `customerName`가 `Co` 끝나는 로우들을 검색하시오.
   SELECT * FROM customers WHERE addressLine2 IS NULL AND customerName Like '%Co';

5. `employees` 테이블에서 `officeCode`의 **중복을 제거**해서 `내림차순`으로 검색하시오.
   SELECT DISTINCT(officeCode) FROM employees ORDER BY officeCode DESC;