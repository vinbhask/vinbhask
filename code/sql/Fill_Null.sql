/*
Given table structure is as below:
+------------+-----------+
| category   | brand_name|
+------------+-----------+
| chocolates | 5-star    |
| NULL       | dairy milk|
| NULL       | perk      |
| NULL       | eclair    |
| Biscuits   | Britania  |
| NULL       | good day  |
| NULL       | boost     |
+------------+-----------+


fill the nulls and display as below:
+--------------+-----------+
| new_category | brand_name|
+--------------+-----------+
| chocolates   | 5-star    |
| chocolates   | dairy milk|
| chocolates   | perk      |
| chocolates   | eclair    |
| Biscuits     | Britania  |
| Biscuits     | good day  |
| Biscuits     | boost     |
+--------------+-----------+

DDL:
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

*/

with cte as (
    select
        category,
        brand_name,
        row_number() over() as rnk
    from
        brands
),
cte2 as (
    select
        category,
        brand_name,
        count(category) over(order by rnk) as grp
    from
        cte
)
select
    max(category) over(partition by grp) as new_category,
    t.brand_name
from
    cte2 t;



