1. order와 customer를 join하여 customerNumber가 103인 결과를 출력해 보시오.
```mariadb
SELECT *
FROM customers a JOIN orders b
WHERE a.customerNumber = 103;
```
2. 103번 customer가 주문한 product를 전부 출력하시오. 출력할 값은 다음과 같다. (customerNumber, orderNumber, orderNumber, productCode, priceEach, quantityOrdered)
```mariadb
select a.customerNumber, a.orderNumber, b.productCode, b.priceEach, b.quantityOrdered
from orders a JOIN orderdetails b JOIN customers c
on a.orderNumber = b.orderNumber AND a.customerNumber = c.customerNumber
where a.customerNumber = 103;
```
3. 2번의 쿼리에서 각 로우마다 총 합을 보여주시오. (아래 사진 참고)
   <img width="1237" alt="image" src="https://user-images.githubusercontent.com/24751937/204940708-58ebdc82-fe53-4b56-bcfc-ac0e3d1869b7.png">
```mariadb
select a.customerNumber, a.orderNumber, b.productCode, b.priceEach, b.quantityOrdered, (b.priceEach * b.quantityOrdered) as '총금액'
from orders a JOIN orderdetails b JOIN customers c
on a.orderNumber = b.orderNumber AND a.customerNumber = c.customerNumber
where a.customerNumber = 103;
```
4. 2번의 쿼리를 통해 주문별 최종 금액을 출력하시오.
   <img width="311" alt="image" src="https://user-images.githubusercontent.com/24751937/204941559-6da61d93-0bc4-44ef-b0c7-102d1908b166.png">
   ]()
```mariadb
select a.customerNumber, a.orderNumber, b.productCode, b.priceEach, b.quantityOrdered, SUM(b.priceEach * b.quantityOrdered) as '총금액'
from orders a JOIN orderdetails b JOIN customers c
on a.orderNumber = b.orderNumber AND a.customerNumber = c.customerNumber
where a.customerNumber = 103
GROUP BY a.orderNumber;
```