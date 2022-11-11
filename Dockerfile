FROM mariadb

ENV MYSQL_ROOT_PASSWORD starters12

WORKDIR /etc/mysql
RUN mkdir setDB
WORKDIR /etc/mysql/setDB

# 초기 세팅 SQL 파일 Docker로 Copy
COPY sample.sql /etc/mysql/setDB/sample.sql
COPY sample.dump /etc/mysql/setDB/sample.dump

# MariaDB Config Setting (table 소문자, 한국 시간, 한글 깨짐 수정 등)
#RUN echo lower_case_table_names=1 >> /etc/mysql/conf.d/docker.cnf
#RUN echo default-time-zone='+9:00' >> /etc/mysql/conf.d/docker.cnf
#RUN echo collation-server = utf8mb4_unicode_ci >> /etc/mysql/conf.d/docker.cnf
#RUN echo collation-server = utf8mb4_0900_ai_ci >> /etc/mysql/conf.d/docker.cnf
#RUN echo character-set-server = utf8mb4 >> /etc/mysql/conf.d/docker.cnf
#RUN echo skip-character-set-client-handshake >> /etc/mysql/conf.d/docker.cnf


# 참고: https://nasn.tistory.com/116
