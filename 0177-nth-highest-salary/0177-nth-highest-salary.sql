CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    select max(salary) into result from (
        select salary, DENSE_RANK() over(
            order by salary desc
        ) as rnk from employee
        where salary is not null 
    ) where rnk = n;
    
    RETURN result;
END;