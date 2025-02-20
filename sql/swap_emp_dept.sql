#Write a SQL Query to Swap Employee Departments, question from L&T
/*
drop table if EXISTS employee;
create table employee(id int identity,name varchar(15),department varchar(15));

insert into employee values('John','Sales')
insert into employee values('Tom','IT')
insert into employee values('Rohit','IT')
insert into employee values('shubham','Marketing')
insert into employee values('kavya','Management')
insert into employee values('Rohan','Sales')
insert into employee values('Shivani','IT')

Input
| id | name    | department |
|----|---------|------------|
| 1  | John    | Sales      |
| 2  | Tom     | IT         |
| 3  | Rohit   | IT         |
| 4  | Shubham | Marketing  |
| 5  | Kavya   | Management |
| 6  | Rohan   | Sales      |
| 7  | Shivani | IT         |

Output
| id | name    | department  |
|----|---------|-------------|
| 1  | John    | IT          |
| 2  | Tom     | Sales       |
| 3  | Rohit   | Marketing   |
| 4  | Shubham | IT          |
| 5  | Kavya   | Sales       |
| 6  | Rohan   | Management  |
| 7  | Shivani | IT          |
*/

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
