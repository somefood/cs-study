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
