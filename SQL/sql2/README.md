## 공통 DB 과제

1. offices 테이블에 맞는 로우 하나를 생성해 보시오. officeCode는 8로 설정
2. employess 테이블에 맞는 로우 세 개를 생성해 보시오. 단, officeCode는 1번에서 생성한 로우ID를 지정
  - jobTitle Programmar (Manager) 한 명
  - jobTilte이 Programmar 두 명, reportsTo를 위에서 만든 매니저로 설정
3. emploayes 테이블을 join하여서 officeCode가 8이고 첫 번째 테이블의 employeeNumber와 두 번째 테이블의 reportsTo가 동일한 컬럼을 조회하고, 아래와 같은 필드로 출력하시오.
<img width="661" alt="image" src="https://user-images.githubusercontent.com/24751937/202596761-8c581e25-e664-4580-be3a-25b251428cc4.png">

4. employees 테이블에서 첫 번째 Programmar 중 한명의 extension 값을 바꾸시오.
5. employees 테이블에서 두 명의 Programmar의 extension을 `한 번에` 바꾸시오.
6. employees 테이블에서 Programmar 중 한 명을 삭제해보시오.

---

## 프로그래머스

[단순 SELECT, IFNULL 함수 ](https://school.programmers.co.kr/learn/courses/30/lessons/132201)
[JOIN, 2단계](https://school.programmers.co.kr/learn/courses/30/lessons/131533)
