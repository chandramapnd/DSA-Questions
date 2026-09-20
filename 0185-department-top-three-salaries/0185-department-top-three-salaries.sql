SELECT d.name as Department,
       e.name AS Employee,
       e.salary AS Salary
FROM (
    SELECT name,
           salary,
           departmentId,
           DENSE_RANK() OVER (
               PARTITION BY departmentId
               ORDER BY salary DESC
           ) AS rnk
    FROM Employee
) e join Department d on e.departmentId = d.id
WHERE rnk <= 3;