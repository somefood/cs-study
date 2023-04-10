## 과제1

- 1번 : `customers` 테이블에서 `country`가 `France`인 로우들을 검색하시오.

  ```mariadb
  select *
  from customers
  where country='France';
  ```

- 2번 : `customers` 테이블에서 `customerName`이 `Mini`로 시작하는 로우들을 검색하시오.

  ```mariadb
  select *
  from customers
  where customerName like 'Mini%';
  ```

- 3번 : `customers` 테이블에서 `addressLine2`가 `NULL`인 로우들을 검색하시오.

  ```mariadb
  select *
  from customers
  where addressLine2 is NULL;
  ```

- 4번 : `customers` 테이블에서 `addressLine2`가 `NULL`이면서 customerName가 `Co` 끝나는 로우들을 검색하시오.

  ```mariadb
  select *
  from customers
  where addressLine2 is NULL and customerName like '%Co';
  ```

- 5번 : `employees` 테이블에서 `officeCode`의 **중복을 제거**해서 `내림차순`으로 검색하시오.

  ```mariadb
  select *
  from employees
  group by officeCode desc;
  ```

  
