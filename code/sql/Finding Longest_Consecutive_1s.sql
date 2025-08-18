#The final output displays the maximum length of consecutive 1s before a 0. This approach is useful in real-world scenarios such as detecting system uptime streaks or identifying uninterrupted successful events in a dataset.
  /*
Drop Table If Exists Status;

-- Step 1: Create the Status table
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

Select * from Status;


Status
1
1
0
1
1
1
0
1
0
1
1
1
1
0
0
1
1

output:
# count_of_1s
2
3
1
4
2
*/
with cte as (
    Select
        s.status,
        row_number() over() as rnk
    from
        Status s
),
cte2 as (
    select
        t.*,
        rnk - sum(t.status = 1) over(order by rnk) as grp
    from
        cte t
)
select
    count(*) as count_of_1s
from
    cte2
where
    status = 1
group by
    grp;
