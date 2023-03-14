## 과제 2

- 1번 : `offices` 테이블에 맞는 로우 하나를 생성해 보시오. `officeCode`는 `8`로 설정

  ![db_study2_1](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_1.png?raw=True)

  ```mariadb
  insert into offices(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory)
  values (8, 'Seoul', '+82 10 1234 5678', 'my home', 'my parents home', null, 'Korea', '12345', 'Korea');
  ```

  

- 2번 : `employess` 테이블에 맞는 로우 세 개를 생성해 보시오. 단, `officeCode`는 **1번에서 생성한 로우ID**를 지정

  ![db_study2_2](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_2.png?raw=True)

  ```mariadb
  insert into employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)
  values (2000, 'Kim', 'JaeJun', 'x1234', 'rlawowns97@gmail.com', '8', 1002, 'Programmar');
  
  insert into employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)
  values (2001, 'Park', 'JaeJun', 'x1234', 'rlawowns98@gmail.com', '8', 1002, 'Developer');
  
  insert into employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)
  values (2002, 'Lee', 'JaeJun', 'x1234', 'rlawowns99@gmail.com', '8', 1002, 'Developer');
  ```

  

- 3번 : `employees` 테이블을 join하여서 `officeCode`가 `8`이고 첫 번째 테이블의 `employeeNumber`와 두 번째 테이블의 `reportsTo`가 동일한 컬럼을 조회하고, 아래와 같은 필드로 출력하시오.

  - 기존의 테이블 상태

    ![db_study2_4](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_4.png?raw=True)

    2번문제를 잘못이해했기에... 일단 위와 같이 데이터를 더 만들어줘서 해결했습니다.

  - result

    ![db_study2_3](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_3.png?raw=True)

  ```mariadb
  select concat(concat(manager.lastName, ' '), manager.firstName)   as '매니저',
         manager.email                                              as '매니저 이메일',
         concat(concat(employee.lastName, ' '), employee.firstName) as '사원',
         employee.email                                             as '사원 이메일'
  from employees as manager
           inner join employees as employee
                      on manager.officeCode = '8' AND manager.employeeNumber = employee.reportsTo;
  ```

- 4번 : `employees` 테이블에서 첫 번째 `Programmar` 중 한명의 `extension` 값을 바꾸시오.

  - 기존의 `Programmar` 라는 `jobTitle`을 가진 row들~~(programmar는 오타입니다. 문제 낸 사람 저 아니에요!)~~

    ![db_study2_5](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_5.png?raw=True)

  - 1번째 `Programmar`를 바꾼 후의 데이터

    ![db_study2_6](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_6.png?raw=True)

  ```mariadb
  update employees
  set extension='x4321'
  where employeeNumber = (select employeeNumber
                          from employees
                          where jobTitle = 'Programmar'
                          limit 1);
  ```

  

- 5번 : `employees` 테이블에서 두 명의 `Programmar`의 `extension`을 한 번에 바꾸시오.

  - 기존에 존재하는 `Programmar`라는 `jobTitle`을 가진 row들

    ![db_study2_7](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_7.png?raw=True)

  - 2명의 `Programmar`의 `extension`값을 `x9999`로 일괄 수정

    ![db_study2_8](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_8.png?raw=True)

  ```mariadb
  update employees
  set extension='x9999'
  where employeeNumber in (select employeeNumber
                           from employees
                           where jobTitle = 'Programmar')
  limit 2;
  ```

- 6번 : `employees` 테이블에서 `Programmar` 중 한 명을 삭제해보시오.

  - 기존에 존재하는 `Programmar`라는 `jobTitle`을 가진 row들

    ![db_study2_8](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_8.png?raw=True)

  - 여기서 그냥 제 마음대로 **마지막** `Programmar`를 삭제했습니다.

    ![db_study2_9](https://github.com/xi-jjun/xi-jjun.github.io/blob/master/_posts/database/img/db_study2_9.png?raw=True)

  ```mariadb
  delete
  from employees
  where jobTitle = 'Programmar'
    AND employeeNumber = 2006;
  ```

  