# 1번 : order와 customer를 join하여 customerNumber가 103인 결과를 출력해 보시오.
select * from orders left join customers on orders.customerNumber = customers.customerNumber where orders.customerNumber = 103;

# 2번 : 103번 customer가 주문한 product를 전부 출력하시오. 출력할 값은 다음과 같다. (customerNumber, orderNumber, orderNumber, productCode, priceEach, quantityOrdered)
select customerNumber, orderdetails.orderNumber, productCode , priceEach, quantityOrdered from orderdetails left join orders on orderdetails.orderNumber = orders.orderNumber where customerNumber = 103;

# 3번 : 2번의 쿼리에서 각 로우마다 총 합을 보여주시오. (아래 사진 참고)
select customerNumber, orderdetails.orderNumber, productCode , priceEach, quantityOrdered, priceEach * quantityOrdered as "총금액" from orderdetails left join orders on orderdetails.orderNumber = orders.orderNumber where customerNumber = 103;

#4번 : 2번의 쿼리를 통해 주문별 최종 금액을 출력하시오.
select orders.orderNumber,sum(priceEach * quantityOrdered) as "총금액" from orderdetails left join orders on orderdetails.orderNumber = orders.orderNumber where customerNumber = 103 GROUP BY orders.orderNumber;
