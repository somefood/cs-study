# 과제1 이태민임미다

1. customers 테이블에서 country가 France인 로우들을 검색하시오.
# select * from customers where country = 'france';

2. customers 테이블에서 customerName이 Mini로 시작하는 로우들을 검색하시오.
# select * from customers where customername like 'Mini%'

3. customers 테이블에서 addressLine2가 Null인 로우들을 검색하시오.
# select * from customers where addressLine2 is NULL

4. custmoers 테이블에서 addressLine2가 NULL이면서 customerName가 'Co'로 끝나는 로우들을 검색하시오.
# select * from customers where addressLine2 is NULL and customerName like '%Co'

5. employees 테이블에서 officecode의 중복을 제거해서 "내림차순"으로 검색
# select distinct officeCode from employees order by officeCode desc

#과제2 이태민임미다

select icecream_info.flavor from icecream_info left join first_half on first_half.flavor = icecream_info.flavor where total_order > 3000 and ingredient_type = 'fruit_based'

#과제3

select * from animal_ins order by animal_id


#과제4

select count(*) from user_info where (age >= 20 and age <= 29) and (joined between '2021-1-1' and '2021-12-31')


#과제 5
# 1번
insert into offices(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory) VALUES ('8','seoul','01012341234','eij','fewij','SE','Korea','323223','NA')

# 2번
insert into employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES ('1103','cristiano','ronaldo','x3222','qwer@naver.com','8',1002,'Programmar (Manager)')
insert into employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES ('1104','lionel','messi','x3222','qwer@naver.com','8',1002,'Programmar (Manager)')
insert into employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES ('1105','the','undertaker','x3222','qwer@naver.com','8',1002,'Programmar (Manager)')

# 3번
select concat(x1.lastName,' ',x1.firstName) as '매니저', x1.email as '매니저 이메일', concat(x2.lastName, ' ',x2.firstName) as '사원', x2.email as '사원 이메일'
from employees x1, employees x2
where x1.employeeNumber = x2.reportsTo and x1.officeCode = 8;

#4번
update employees set extension = 'x9273' where firstname = 'ronaldo';
select * from employees;

#5번
update employees set extension = 'x5800' where jobTitle = 'Programmar';
select * from employees;

#6번
delete from employees where jobTitle = 'Programmar' and firstName = 'undertaker'
select * from employees;
