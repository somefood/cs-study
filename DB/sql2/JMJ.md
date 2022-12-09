1. offices 테이블에 맞는 로우 하나를 생성해 보시오. officeCode는 8로 설정

```mariadb
INSERT INTO offices VALUES (8, 'seoul', '+82 10 9999 2222', 'ansan si', 'Level 9', 'KR', 'Korea', '10391','Korea');
```


2. employess 테이블에 맞는 로우 세 개를 생성해 보시오. 단, officeCode는 1번에서 생성한 로우ID를 지정
- jobTitle Programmar (Manager) 한 명
- jobTilte이 Programmar 두 명, reportsTo를 위에서 만든 매니저로 설정


```mariadb
INSERT INTO employees VALUES (2000, 'Jung', 'Minju', 'x2000', 'alswn@als.com',8,null, 'Programmer(Manager)');
INSERT INTO employees VALUES (2001, 'Jung', 'jaehyuk', 'x2001', 'wogur@als.com',8,2000, 'Programmer');
INSERT INTO employees VALUES (2002, 'Jung', 'Minjung', 'x2002', 'alswjd@als.com',8,2000, 'Programmer');

```


3. emploayes 테이블을 join하여서 officeCode가 8이고 첫 번째 테이블의 employeeNumber와 두 번째 테이블의 reportsTo가 동일한 컬럼을 조회하고, 아래와 같은 필드로 출력하시오.
   <img width="661" alt="image" src="https://user-images.githubusercontent.com/24751937/202596761-8c581e25-e664-4580-be3a-25b251428cc4.png">

```mariadb
SELECT CONCAT(a.lastName, a.firstName) AS '매니저', a.email AS '매니저 이메일', CONCAT(b.lastName, b.firstName) AS '사원', b.email AS '사원 이메일'
FROM employees a JOIN employees b
WHERE a.officeCode = 8 AND a.employeeNumber = b.reportsTo;
```


4. employees 테이블에서 첫 번째 Programmar 중 한명의 extension 값을 바꾸시오.

```mariadb
UPDATE employees
SET extension='x2004'
WHERE employeeNumber = (SELECT employeeNumber FROM employees WHERE jobTitle='Programmer' LIMIT 1);
```

5. employees 테이블에서 두 명의 Programmar의 extension을 `한 번에` 바꾸시오.
```mariadb
UPDATE employees
SET extension='x2004'
WHERE jobTitle = 'Programmer'

```
6. employees 테이블에서 Programmar 중 한 명을 삭제해보시오.

```mariadb
DELETE FROM employees WHERE jobTitle = 'Programmer' LIMIT 1;
```