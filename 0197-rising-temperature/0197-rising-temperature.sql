/* Write your PL/SQL query statement below */
select w2.id as id 
from Weather w1 
join Weather w2 on w2.recordDate = w1.recordDate +1 
    where w2.temperature > w1.temperature;