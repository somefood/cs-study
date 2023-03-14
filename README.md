# CS Study

각종 CS 문제들을 찾아 스터디하는 레포지토리입니다 :) 

## 규칙

- 파일은 마크다운으로, 파일명은 본인 이니셜로 설정해주세요.
> ex) HSJ.md

- PR은 `[이름] 내용` 형태로 보내주세요.
> ex) [홍석주] 문제 1번 풀이


## DB - DB관련 문제와 SQL 문제를 만들고 연습하는 레포지토리!

Docker를 통해 모두가 같은 데이터를 가지고 편안하게 연습할 수 있습니다.

### requirements

- Docker
- DataGrip or Workbench... DB 접근해서 쿼리 공부할 수 있는 툴이면 무방

### 사용법 (Docker 실행되어 있어야 합니다!)

1. 레포지토리를 clone 받는다.
2. 본인 OS에 맞는 스크립트를 실행시킨다.
  - MAC or Linux

    ```shell
    ./linux.sh
    ```

  - Windows: ms.bat
3. 툴에서 다음 DB들 열어줌
  - sample: SQL 첫걸음 데이터
  - starters: mysqltutorail.org 데이터 (출처: https://www.mysqltutorial.org/mysql-sample-database.aspx)
4. 폴더에서 제공되는 문제를 보고, sql 작성하여 제출!

#### MariaDB 정보

- ID: `root`

- Password: `starters12`

  ```shell
  # 간단 접속 방법
  mysql -u root -p starters12
  ```

### 기록
- [진행][Real MySQL 8.0 - 백은빈, 이성욱](https://github.com/Java-Bom/ReadingRecord/projects/1) ❓[질문하기](https://github.com/somefood/cs-study/issues/new?assignees=&labels=Real+MySQL&template=real-mysql-question.md&title=%5B%EC%95%84%EC%9D%B4%ED%85%9C+00%5D+%EA%B0%84%EB%8B%A8%ED%95%9C+%EC%A0%9C%EB%AA%A9)
  
