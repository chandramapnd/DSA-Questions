delete from Person 
    where id in (
        select p2.id from Person p1 
        join Person p2 
        on p1.id < p2.id 
        where p1.email = p2.email
    );