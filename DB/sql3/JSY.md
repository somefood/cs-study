1. order와 customer를 join하여 customerNumber가 103인 결과를 출력해 보시오.

- select * from orders o inner join customers c on o.customerNumber = c.customerNumber
         where o.customerNumber = 103 ;


 2. 103번 customer가 주문한 product를 전부 출력하시오. 출력할 값은 다음과 같다. (customerNumber, orderNumber, orderNumber, productCode, priceEach, quantityOrdered)

 - select customerNumber, o.orderNumber, od.orderNumber, productCode, priceEach, quantityOrdered from orders o inner join orderdetails od on o.orderNumber = od.orderNumber where o.customerNumber=103;

 3. 2번의 쿼리에서 각 로우마다 총 합을 보여주시오.

 - select customerNumber, o.orderNumber, od.orderNumber, productCode, priceEach, quantityOrdered, (priceEach*quantityOrdered) '총금액' from orders o inner join orderdetails od on o.orderNumber = od.orderNumber where o.customerNumber=103;

 4. 2번의 쿼리를 통해 주문별 최종 금액을 출력하시오.

- select o.orderNumber orderNumber, sum(priceEach*quantityOrdered) '총금액' from orders o inner join orderdetails od on o.orderNumber = od.orderNumber
where o.customerNumber=103 group by orderNumber;
