select c.name as Customers
from  Customers c
 left join orders o
on o.customerid=c.id
where o.id is null;