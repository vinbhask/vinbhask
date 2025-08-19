Create database Test;

Use Test;

create table icc_world_cup
(
Team_1 Varchar(20),
Team_2 Varchar(20),
Winner Varchar(20)
);
INSERT INTO icc_world_cup values('India','SL','India');
INSERT INTO icc_world_cup values('SL','Aus','Aus');
INSERT INTO icc_world_cup values('SA','Eng','Eng');
INSERT INTO icc_world_cup values('Eng','NZ','NZ');
INSERT INTO icc_world_cup values('Aus','India','India');

select * from icc_world_cup;

with icc_world_cup1 as (
select team_1 as Teams from icc_world_cup group by 1
union
select team_2 from icc_world_cup group by 1
)
select A.*,
matches_played-matches_won as matches_lost
from
(
select
a.Teams,
count(a.Teams) as matches_played,
sum(case when b.winner=a.Teams then 1 else 0 end ) as matches_won
from icc_world_cup1 a
inner join icc_world_cup b
on (a.Teams=b.team_1 or a.Teams=b.team_2)
group by 1)A;



#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table customer_orders (
order_id integer,
customer_id integer,
order_date date,
order_amount integer
);

insert into customer_orders values(1,100,cast('2022-01-01' as date),2000),(2,200,cast('2022-01-01' as date),2500),(3,300,cast('2022-01-01' as date),2100)
,(4,100,cast('2022-01-02' as date),2000),(5,400,cast('2022-01-02' as date),2200),(6,500,cast('2022-01-02' as date),2700)
,(7,100,cast('2022-01-03' as date),3000),(8,400,cast('2022-01-03' as date),1000),(9,600,cast('2022-01-03' as date),3000);
select * from customer_orders;

with base as (
select * from customer_orders )
select
-- b.order_date ,count(distinct c.customer_id) as num_of_old_cust,
-- sum(case when c.customer_id is null then 1 else 0 end) as num_of_new_cust
b.*, c.* from base b
left join base c
on b.customer_id=c.customer_id
and b.order_date>c.order_date
group by b.order_date;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table entries (
name varchar(20),
address varchar(20),
email varchar(20),
floor int,
resources varchar(10));

insert into entries
values ('A','Bangalore','A@gmail.com',1,'CPU'),('A','Bangalore','A1@gmail.com',1,'CPU'),('A','Bangalore','A2@gmail.com',2,'DESKTOP')
,('B','Bangalore','B@gmail.com',2,'DESKTOP'),('B','Bangalore','B1@gmail.com',2,'DESKTOP'),('B','Bangalore','B2@gmail.com',1,'MONITOR');
insert into entries
values ('C','Bangalore','C@gmail.com',3,'CPU');
select * from entries;

with count_res as (
select name, count(*) as total_visits,
group_concat(distinct resources order by resources separator ', ') as resources_used
from entries
group by name),
most_visited_floor as (
select name,floor from (
select name,floor,count(*), row_number() over(partition by name order by count(*) desc ) rnk from entries group by name, floor) c where rnk=1)
select a.name,a.total_visits,b.floor as most_visited_floor,a.resources_used
from count_res a
inner join most_visited_floor b
on a.name=b.name;
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

SET @date_value = "2024-06-29";
SELECT
CASE WHEN weekday(@date_value)<>5 THEN 'Its not a Saturday'
WHEN (DAY(@date_value)<8 AND WEEKDAY(@date_value)=5) THEN 'Its First Saturday'
WHEN (DAY(@date_value)=8 OR DAY(@date_value)<15) AND WEEKDAY(@date_value)=5 THEN 'Its Second Saturday'
WHEN (DAY(@date_value)=15 OR DAY(@date_value)<22) AND WEEKDAY(@date_value)=5 THEN 'Its Third Saturday'
WHEN (DAY(@date_value)=22 OR DAY(@date_value)<29) AND WEEKDAY(@date_value)=5 THEN 'Its Fourth Saturday'
WHEN (DAY(@date_value)=29 OR DAY(@date_value)<32) AND WEEKDAY(@date_value)=5 THEN 'Its Fifth Saturday'
END AS DATE_VALUE;

SELECT weekday('2025-06-16') AS DatePartInt;
SELECT day('2024-11-16') AS DatePartInt;

SELECT @date_value,DAY(@date_value),WEEKDAY(@date_value) ;
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Create table  Trips (id int, client_id int, driver_id int, city_id int, status varchar(50), request_at varchar(50));
Create table Users (users_id int, banned varchar(50), role varchar(50));
#--Truncate table Trips;
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('1', '1', '10', '1', 'completed', '2013-10-01');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('2', '2', '11', '1', 'cancelled_by_driver', '2013-10-01');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('3', '3', '12', '6', 'completed', '2013-10-01');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('4', '4', '13', '6', 'cancelled_by_client', '2013-10-01');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('5', '1', '10', '1', 'completed', '2013-10-02');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('6', '2', '11', '6', 'completed', '2013-10-02');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('7', '3', '12', '6', 'completed', '2013-10-02');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('8', '2', '12', '12', 'completed', '2013-10-03');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('9', '3', '10', '12', 'completed', '2013-10-03');
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('10', '4', '13', '12', 'cancelled_by_driver', '2013-10-03');
#--Truncate table Users;
insert into Users (users_id, banned, role) values ('1', 'No', 'client');
insert into Users (users_id, banned, role) values ('2', 'Yes', 'client');
insert into Users (users_id, banned, role) values ('3', 'No', 'client');
insert into Users (users_id, banned, role) values ('4', 'No', 'client');
insert into Users (users_id, banned, role) values ('10', 'No', 'driver');
insert into Users (users_id, banned, role) values ('11', 'No', 'driver');
insert into Users (users_id, banned, role) values ('12', 'No', 'driver');
insert into Users (users_id, banned, role) values ('13', 'No', 'driver');

select * from Trips;
select * from Users;

with users as (
select * from users )
select A.request_at,Sum(case when status like 'cancelled%' then 1 else 0 end)/count(*) as perc_cancell from
(select t.request_at,t.status, case when (u1.banned='Yes' or u2.banned='Yes') then 'Banned' else 'Not Banned' end as banned_status
from Trips t
inner join users u1
on t.client_id=u1.users_id
inner join users u2
on t.driver_id=u2.users_id) A
where banned_status='Not Banned'
group by 1
order by 1;
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table players
(player_id int,
group_id int);

insert into players values (15,1);
insert into players values (25,1);
insert into players values (30,1);
insert into players values (45,1);
insert into players values (10,2);
insert into players values (35,2);
insert into players values (50,2);
insert into players values (20,3);
insert into players values (40,3);

create table matches
(
match_id int,
first_player int,
second_player int,
first_score int,
second_score int);

insert into matches values (1,15,45,3,0);
insert into matches values (2,30,25,1,2);
insert into matches values (3,30,15,2,0);
insert into matches values (4,40,20,5,2);
insert into matches values (5,35,50,1,1);

select * from players;
select * from matches;

with m as (
select first_player as player_id,first_score as player_score from matches
union all
select second_player,second_score from matches)
select A.player_id,
row_number()over(partition by group_id order by score desc, player_id) as rnk from
(
select
p.player_id,p.group_id,
sum(m.player_score) over(partition by group_id,player_id order by player_id) as score
from players p
left join m
on p.player_id=m.player_id)A
where rnk=1;



 #----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 create table users1 (
user_id         int     ,
 join_date       date    ,
 favorite_brand  varchar(50));

 create table orders (
 order_id       int     ,
 order_date     date    ,
 item_id        int     ,
 buyer_id       int     ,
 seller_id      int
 );

 create table items
 (
 item_id        int     ,
 item_brand     varchar(50)
 );


 insert into users1 values (1,'2019-01-01','Lenovo'),(2,'2019-02-09','Samsung'),(3,'2019-01-19','LG'),(4,'2019-05-21','HP');

 insert into items values (1,'Samsung'),(2,'Lenovo'),(3,'LG'),(4,'HP');

 insert into orders values (1,'2019-08-01',4,1,2),(2,'2019-08-02',2,1,3),(3,'2019-08-03',3,2,3),(4,'2019-08-04',1,4,2)
 ,(5,'2019-08-04',1,3,4),(6,'2019-08-05',2,2,4);

 select * from users1;

 select * from items;

 select * from orders;

 with users as (
 select user_id from users1),
 order_details as (
 select * from (
 select o.order_id,o.order_date,o.item_id,o.buyer_id,o.seller_id,i.item_brand,u.favorite_brand,
 row_number() over(partition by seller_id order by order_date) as rnk
 from orders o
 left join items i
 on o.item_id=i.item_id
 left join users1 u
 on o.seller_id=u.user_id )A
 #where rnk=2
 )
 select u.user_id,
 case when o.item_brand=favorite_brand then 'yes' else 'no' end as 2nd_item_fav_brand
 from users u
 left join order_details o
 on u.user_id=o.seller_id
 and o.rnk=2;



#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Create table If Not Exists Failed (fail_date date);
Create table If Not Exists Succeeded (success_date date);
Truncate table Failed;
insert into Failed (fail_date) values ('2018-12-28');
insert into Failed (fail_date) values ('2018-12-29');
insert into Failed (fail_date) values ('2019-01-04');
insert into Failed (fail_date) values ('2019-01-05');
Truncate table Succeeded;
insert into Succeeded (success_date) values ('2018-12-30');
insert into Succeeded (success_date) values ('2018-12-31');
insert into Succeeded (success_date) values ('2019-01-01');
insert into Succeeded (success_date) values ('2019-01-02');
insert into Succeeded (success_date) values ('2019-01-03');
insert into Succeeded (success_date) values ('2019-01-06');
select * from Succeeded;
with period_state as (
select A.*,
rank() over(partition by A.period_state order by A.period_date) as rnk
 from (
select 'succeeded' as period_state, success_date as period_date from Succeeded where success_date between '2019-01-01' and '2019-12-31'
union all
select 'failed', fail_date from Failed where fail_date between '2019-01-01' and '2019-12-31')A
order by period_date)
select period_state,min(period_date) as start_date, max(period_date) as end_date from (
select
period_state,period_date,date_sub(period_date, interval rnk day) as period_grp
from period_state
) grp
group by period_grp,period_state;


with period_state as (
select A.*,
rank() over(partition by A.period_state order by A.period_date) as rnk
 from (
select 'succeeded' as period_state, success_date as period_date from Succeeded where success_date between '2019-01-01' and '2019-12-31'
union all
select 'failed', fail_date from Failed where fail_date between '2019-01-01' and '2019-12-31')A
order by period_date)
select A.period_state,min(period_date),max(period_date)
from period_state A
group by period_state,day(period_date)-rnk;

WITH RECURSIVE 
fib AS
(
SELECT 1 as sn,0 as curr_val,1 as next_val
union all
SELECT sn+1,curr_val+next_val, curr_val from fib where sn < 10 
)
SELECT * FROM fib; 

WITH RECURSIVE current_f (sn,current_val, previous_val) AS
    (
    SELECT 1,0, 1
    UNION ALL 
    SELECT sn+1,current_val + previous_val, current_val FROM current_f
    where sn<=9
    )
  SELECT * FROM current_f ORDER BY current_val;

Use Test;
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#--Create table syntax
CREATE TABLE Flights (cust_id INT, flight_id VARCHAR(10), origin VARCHAR(50), destination VARCHAR(50));

-- Insert data into the table
INSERT INTO Flights (cust_id, flight_id, origin, destination)
VALUES (1, 'SG1255', 'Mangalore', 'Trichy'),
(1, 'SG1234', 'Delhi', 'Hyderabad'), (1, 'SG3476', 'Kochi', 'Mangalore'), (1, '69876', 'Hyderabad', 'Kochi'), (2, '68749', 'Mumbai', 'Varanasi'), (2, 'SG5723', 'Varanasi', 'Delhi');
select * from flights;

select c as cust_id , max(origin) as origin, max(final_destination) as final_destination from (
select cust_id as c,
case
when origin not in (select destination from flights where cust_id = c) then origin
end origin,
case
when destination not in (select origin from flights where cust_id = c) then destination
end final_destination
from flights) t
group by cust_id;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
drop table if EXISTS employee;
create table employee(id int ,name varchar(15),department varchar(15));

insert into employee values(1,'John','Sales');
insert into employee values(2,'Tom','IT');
insert into employee values(3,'Rohit','IT');
insert into employee values(4,'shubham','Marketing');
insert into employee values(5,'kavya','Management');
insert into employee values(6,'Rohan','Sales');
insert into employee values(7,'Shivani','IT');
select * from employee;
with cte as (
select e.*
,LEAD(department,1,department) over(order by e.id) as next_row
,LAG(department,1,department) over(order by e.id) as prev_row
,CASE WHEN e.id mod 2=0 then 'even' else 'odd' end as row_val
from employee e)
select
id
,name
,case when row_val='odd' then next_row else prev_row end as department
from cte;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
drop table if exists brands;
create table brands
(
    category varchar(50),
    brand_name varchar(50)
);

insert into brands
values
    ('chocolates', '5-star'),
    (NULL, 'dairy milk'),
    (NULL, 'perk'),
    (NULL, 'eclair'),
    ('Biscuits', 'Britania'),
    (NULL, 'good day'),
    (NULL, 'boost');
select b.* from brands b;


with cte as (
select
category,
brand_name,
row_number() over() as rnk
from brands),
cte2 as (select
category,
brand_name,
count(category) over(order by rnk) as grp
from cte)
select
max(category) over(partition by grp) as new_category,
t.brand_name
from cte2 t;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS Orders ;

CREATE TABLE Orders (
customer_name VARCHAR(255),
order_date DATETIME
);
Use test;
INSERT INTO Orders (customer_name, order_date) VALUES ('Alice', '2024-04-01');
INSERT INTO Orders (customer_name, order_date) VALUES ('Bob', '2024-04-01');
INSERT INTO Orders (customer_name, order_date) VALUES ('Alice', '2024-04-02');
INSERT INTO Orders (customer_name, order_date) VALUES ('Bob', '2024-04-02');
INSERT INTO Orders (customer_name, order_date) VALUES ('Charlie', '2024-04-03');
INSERT INTO Orders (customer_name, order_date) VALUES ('Alice', '2024-04-03');
INSERT INTO Orders (customer_name, order_date) VALUES ('Alice', '2024-04-04');
INSERT INTO Orders (customer_name, order_date) VALUES ('Bob', '2024-04-04');
INSERT INTO Orders (customer_name, order_date) VALUES ('Charlie', '2024-04-05');
INSERT INTO Orders (customer_name, order_date) VALUES ('Alice', '2024-04-05');
INSERT INTO Orders (customer_name, order_date) VALUES ('Bob', '2024-04-06');
INSERT INTO Orders (customer_name, order_date) VALUES ('Charlie', '2024-04-06');

with cte as (
SELECT
o.customer_name,
cast(o.order_date as date) as order_date ,
lead(cast(order_date as date),1,date_add(cast(order_date as date),interval 1 day)) over(partition by customer_name order by cast(order_date as date)) as next_date
FROM Orders o order by customer_name)
select
t.*
,next_date-order_date
,count(*) over(partition by customer_name order by next_date-order_date)
from cte t;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#Step 1: Create the Status table
CREATE TABLE Status (
    status BIT
    -- Using BIT type for 0 and 1 values
);

-- Step 2: Insert the data into the Status table
INSERT INTO Status (status) VALUES
(1),
(1),
(0),
(1),
(1),
(1),
(0),
(1),
(0),
(1),
(1),
(1),
(1),
(0),
(0),
(1),
(1);
select * from status;
with cte as (
Select s.status
,row_number()over() as rnk
 from Status s),
cte2 as (
select
t.*
,rnk-sum(t.status=1) over(order by rnk) as grp
from cte t
)
select count(*) as count_of_1s from cte2 where status=1 group by grp;



Use Test;
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table users2 (
user_id         int     ,
 join_date       date    ,
 favorite_brand  varchar(50));

 create table orders2 (
 order_id       int     ,
 order_date     date    ,
 item_id        int     ,
 buyer_id       int     ,
 seller_id      int
 );

 create table items2
 (
 item_id        int     ,
 item_brand     varchar(50)
 );


 insert into users2 values (1,'2019-01-01','Lenovo'),(2,'2019-02-09','Samsung'),(3,'2019-01-19','LG'),(4,'2019-05-21','HP');

 insert into items2 values (1,'Samsung'),(2,'Lenovo'),(3,'LG'),(4,'HP');

 insert into orders2 values (1,'2019-08-01',4,1,2),(2,'2019-08-02',2,1,3),(3,'2019-08-03',3,2,3),(4,'2019-08-04',1,4,2)
 ,(5,'2019-08-04',1,3,4),(6,'2019-08-05',2,2,4);


 with order_data as (
 select * from (
 select seller_id,order_date,item_brand,u.favorite_brand,
 row_number()over(partition by seller_id order by order_date ) as rnk
 from orders2 o
 left join items2 i
 on o.item_id=i.item_id
 left join users2 u
 on o.seller_id=u.user_id)A
 where rnk=2),
 seller_data as (
 select user_id
 from users2 o
 group by 1
 )
 select
 s.user_id,
 case when o.seller_id is null then 'no'
 when o.seller_id is not null and o.favorite_brand =o.item_brand then 'yes' else 'no' end as 2nd_item_fav_brand
 from seller_data s
 left join order_data o
 on s.user_id=o.seller_id
;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Drop the table if it exists
DROP TABLE IF EXISTS TestCases;
-- Create the TestCases table
CREATE TABLE TestCases
(
    TestCase VARCHAR(1)
);
select * from TestCases;
-- Insert test data
INSERT INTO TestCases (TestCase) VALUES
('A'), ('B'), ('C') ,('D');

with cte as (
Select TestCase from TestCases)
select
t1.TestCase as t1,(select group_concat(t2.TestCase SEPARATOR '') from cte t2 where t1.TestCase<>t2.TestCase ) as t2
from cte t1;


select group_concat(TestCase SEPARATOR '') from TestCases;
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;
SET @start_date_value='2024-02-01';
SET @end_date_value='2024-03-02';
set @first_monday=CAST(7-weekday(@start_date_value) AS SIGNED);
with recursive dates as (
select date_add(@start_date_value, interval @first_monday day) as dt
union all
select date_add(dt,interval 7 day)
from dates
where dt<@end_date_value)
select dt from dates where weekday(dt)=0;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;
DROP TABLE IF EXISTS TestCases;
CREATE TABLE TestCases
(
    TestCase VARCHAR(1)
);

INSERT INTO TestCases (TestCase) VALUES
('A'), ('B'), ('C') ;

Select * from TestCases;

WITH RECURSIVE
cte AS
(
    -- Anchor Member: Starts with individual test cases
    SELECT
        CAST(TESTCASE AS CHAR(255)) AS A, -- Using CHAR for fixed length, or VARCHAR if variable
        1 AS N                            -- Current length/level
    FROM
        TESTCASES

    UNION ALL

    -- Recursive Member: Appends new test cases
    SELECT
        CONCAT(cte.A, B.TESTCASE), -- Concatenate the previous combination with a new test case
        cte.N + 1           -- Increment the length/level
    FROM
        TESTCASES B
    JOIN
        cte ON 1=1 -- CROSS JOIN with the CTE
    WHERE
        LOCATE(B.TESTCASE, cte.A) = 0 -- Check if the new test case is NOT already in the combination
        AND cte.N < 3 -- Add a limit to N if you want to stop at a certain length (e.g., max 4 characters)
)
SELECT A as letter_combinations
FROM cte
WHERE N=3
ORDER BY N, A;

SET @n = 5;
with recursive factorial(fac,next_val) as (
select 1,1
union all
select fac*(next_val+1),next_val+1 from factorial where next_val<@n
)
select * from factorial where next_val=@n ;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;
DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
 ID int,
 Name varchar(100),
 Manager_ID int
);

INSERT INTO employee
VALUES
(1,'Rohit',10),
(2,'Rahul',10),
(3,'Ravi',10),
(4,'Shiva',20),
(5,'Sai',20),
(6,'Sumit',20),
(10,'Priya',100),
(11,'Riyaz',100),
(12,'Nitin',100),
(20,'Yash',100),
(22,'Arjun',100),
(100,'Naveen',NULL),
(50,'Nikhil',1),
(60,'Akhil',1);

SELECT * FROM employee;

WITH RECURSIVE CTE AS (
SELECT ID,NAME, NAME AS MANAGER_NAME FROM EMPLOYEE WHERE MANAGER_ID IS NULL
UNION ALL
SELECT E.ID,E.NAME,C.NAME FROM EMPLOYEE E
INNER JOIN CTE C
ON E.MANAGER_ID=C.ID
)
SELECT * FROM CTE;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY,
    customer_id INT,
    amount INT,
    tran_Date datetime
);

INSERT INTO Transactions VALUES (1, 101, 500, '2025-01-01 10:00:01');
INSERT INTO Transactions VALUES (2, 201, 500, '2025-01-01 10:00:01');
INSERT INTO Transactions VALUES (3, 102, 300, '2025-01-02 00:50:01');
INSERT INTO Transactions VALUES (4, 202, 300, '2025-01-02 00:50:01');
INSERT INTO Transactions VALUES (5, 101, 700, '2025-01-03 06:00:01');
INSERT INTO Transactions VALUES (6, 202, 700, '2025-01-03 06:00:01');
INSERT INTO Transactions VALUES (7, 103, 200, '2025-01-04 03:00:01');
INSERT INTO Transactions VALUES (8, 203, 200, '2025-01-04 03:00:01');
INSERT INTO Transactions VALUES (9, 101, 400, '2025-01-05 00:10:01');
INSERT INTO Transactions VALUES (10, 201, 400, '2025-01-05 00:10:01');
INSERT INTO Transactions VALUES (11, 101, 500, '2025-01-07 10:10:01');
INSERT INTO Transactions VALUES (12, 201, 500, '2025-01-07 10:10:01');
INSERT INTO Transactions VALUES (13, 102, 200, '2025-01-03 10:50:01');
INSERT INTO Transactions VALUES (14, 202, 200, '2025-01-03 10:50:01');
INSERT INTO Transactions VALUES (15, 103, 500, '2025-01-01 11:00:01');
INSERT INTO Transactions VALUES (16, 101, 500, '2025-01-01 11:00:01');
INSERT INTO Transactions VALUES (17, 203, 200, '2025-11-01 11:00:01');
INSERT INTO Transactions VALUES (18, 201, 200, '2025-11-01 11:00:01');

SELECT * FROM Transactions;

with seller_buyer as (
select t1.transaction_id,t1.customer_id as seller_id,t2.customer_id as buyer_id 
from Transactions t1
inner join Transactions t2
on t1.transaction_id+1=t2.transaction_id
where t1.transaction_id%2<>0
)
select seller_id,buyer_id,count(*)
from seller_buyer
group by 1,2
order by count(*) desc;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;
CREATE TABLE years_sum (
    Order_ID INT,
    Customer_Name VARCHAR(50),
    Order_Date DATE,
    Amount INT
);

INSERT INTO years_sum VALUES (1001, 'A', '2020-01-16', 200);
INSERT INTO years_sum VALUES (1002, 'B', '2020-02-12', 140);
INSERT INTO years_sum VALUES (1003, 'C', '2020-03-14', 150);
INSERT INTO years_sum VALUES (1004, 'D', '2020-05-20', 200);
INSERT INTO years_sum VALUES (1005, 'A', '2021-06-17', 180);
INSERT INTO years_sum VALUES (1006, 'B', '2021-07-23', 190);
INSERT INTO years_sum VALUES (1007, 'C', '2021-08-26', 210);
INSERT INTO years_sum VALUES (1008, 'D', '2021-09-14', 250);
INSERT INTO years_sum VALUES (1009, 'A', '2022-10-14', 220);
INSERT INTO years_sum VALUES (1010, 'B', '2022-01-15', 230);
INSERT INTO years_sum VALUES (1011, 'C', '2022-02-16', 240);
INSERT INTO years_sum VALUES (1012, 'D', '2022-03-18', 260);
select * from years_sum;

#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;
create table stadium (
id int,
visit_date date,
no_of_people int
);
select * from stadium;
insert into stadium
values (1,'2017-07-01',10)
,(2,'2017-07-02',109)
,(3,'2017-07-03',150)
,(4,'2017-07-04',99)
,(5,'2017-07-05',145)
,(6,'2017-07-06',1455)
,(7,'2017-07-07',199)
,(8,'2017-07-08',188);

with cte as (
select 
id,
visit_date,
no_of_people,
id-row_number()over(order by visit_date) as grp
from stadium
where no_of_people>=100)
select * from cte
where grp in (select grp from cte group by grp having count(*)>=3);
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;
create table employee3 
(
emp_id int,
company varchar(10),
salary int
);

insert into employee3 values (1,'A',2341);
insert into employee3 values (2,'A',341);
insert into employee3 values (3,'A',15);
insert into employee3 values (4,'A',15314);
insert into employee3 values (5,'A',451);
insert into employee3 values (6,'A',513);
insert into employee3 values (7,'B',15);
insert into employee3 values (8,'B',13);
insert into employee3 values (9,'B',1154);
insert into employee3 values (10,'B',1345);
insert into employee3 values (11,'B',1221);
insert into employee3 values (12,'B',234);
insert into employee3 values (13,'C',2345);
insert into employee3 values (14,'C',2645);
insert into employee3 values (15,'C',2645);
insert into employee3 values (16,'C',2652);
insert into employee3 values (17,'C',65);
select * from employee3;
select company,avg(salary)
from (
select *,row_number()over(partition by company order by salary)as rn
,count(1) over(partition by company) as total_cnt
from employee3) a 
where rn between total_cnt*1.0/2 and total_cnt*1.0/2+1
group by company;

set @start_date='2019-12-01';
set @end_date='2020-01-31';
with recursive cte as (
select 
@start_date as dt
union all 
select date_add(@start_date, interval '1' day) from cte
where cte.dt<@end_date)
select * from cte where dt<@end_date;
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;

CREATE TABLE airports (
    port_code VARCHAR(10) PRIMARY KEY,
    city_name VARCHAR(100)
);

CREATE TABLE flights1 (
    flight_id varchar (10),
    start_port VARCHAR(10),
    end_port VARCHAR(10),
    start_time datetime,
    end_time datetime
);

delete from airports;
INSERT INTO airports (port_code, city_name) VALUES
('JFK', 'New York'),
('LGA', 'New York'),
('EWR', 'New York'),
('LAX', 'Los Angeles'),
('ORD', 'Chicago'),
('SFO', 'San Francisco'),
('HND', 'Tokyo'),
('NRT', 'Tokyo'),
('KIX', 'Osaka');

delete from flights1;
INSERT INTO flights1  VALUES
(1, 'JFK', 'HND', '2025-06-15 06:00', '2025-06-15 18:00'),
(2, 'JFK', 'LAX', '2025-06-15 07:00', '2025-06-15 10:00'),
(3, 'LAX', 'NRT', '2025-06-15 10:00', '2025-06-15 22:00'),
(4, 'JFK', 'LAX', '2025-06-15 08:00', '2025-06-15 11:00'),
(5, 'LAX', 'KIX', '2025-06-15 11:30', '2025-06-15 22:00'),
(6, 'LGA', 'ORD', '2025-06-15 09:00', '2025-06-15 12:00'),
(7, 'ORD', 'HND', '2025-06-15 11:30', '2025-06-15 23:30'),
(8, 'EWR', 'SFO', '2025-06-15 09:00', '2025-06-15 12:00'),
(9, 'LAX', 'HND', '2025-06-15 13:00', '2025-06-15 23:00'),
(10, 'KIX', 'NRT', '2025-06-15 08:00', '2025-06-15 10:00');

select * from flights1;

with newyork_start as (
select flight_id,start_port,a.city_name as start_city_name,end_port as middle_port, start_time,end_time
from flights1 f
inner join airports a
on f.start_port=a.port_code
where city_name='New York')
select 
#ns.flight_id,f.flight_id,ns.start_port as start_city,ns.middle_port,f.end_port,ns.start_time as ns_start_time,
#ns.end_time as ns_end_time,f.start_time as f_start_time,f.end_time as f_end_time
ns.start_port,ns.middle_port,f.end_port,concat(ns.flight_id,',',f.flight_id), TIMESTAMPDIFF(MINUTE, ns.start_time,f.end_time) as time_taken
from newyork_start ns
inner join flights1 f
on ns.middle_port=f.start_port
where f.end_port in (select port_code from airports where city_name='Tokyo')
and ns.end_time<=f.start_time
union all
select start_port,null,end_port, flight_id,TIMESTAMPDIFF(MINUTE, start_time,end_time)
from flights1
where start_port in (select port_code from airports where city_name='New York')
and end_port in (select port_code from airports where city_name='Tokyo') ;


#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
use test;
CREATE TABLE Invested (
    pname VARCHAR(10),
    cname VARCHAR(10)
);

CREATE TABLE Subsidiary (
    parent VARCHAR(10),
    child VARCHAR(10)
);

-- Investments
INSERT INTO Invested (pname, cname) VALUES
('Don', 'C1'),
('Don', 'C4'),
('Ron', 'C1'),
('Hil', 'C3');

-- Subsidiary relationships
INSERT INTO Subsidiary (parent, child) VALUES
('C1', 'C2'),
('C2', 'C3'),
('C2', 'C5'),
('C4', 'C6');

SELECT * FROM subsidiary;
select * from invested;

with recursive cte as (
select parent as name,child,parent from subsidiary 
union all 
select s.parent,s.child,c.parent 
from subsidiary s
inner join cte c
on s.parent=c.child
)
select * from cte
inner join invested p on cte.parent=p.cname
inner join invested c on cte.child=c.cname
order by 1;
