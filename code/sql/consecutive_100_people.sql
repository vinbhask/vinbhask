/*
Given the below dataset find the records where no_of_people are 100 and more for atleast 3 consecutive days

Input:
+----+------------+--------------+
| id | visit_date | no_of_people |
+----+------------+--------------+
| 1  | 2017-07-01 | 10           |
| 2  | 2017-07-02 | 109          |
| 3  | 2017-07-03 | 150          |
| 4  | 2017-07-04 | 99           |
| 5  | 2017-07-05 | 145          |
| 6  | 2017-07-06 | 1455         |
| 7  | 2017-07-07 | 199          |
| 8  | 2017-07-08 | 188          |
+----+------------+--------------+

Output:
+----+------------+--------------+-----+
| id | visit_date | no_of_people | grp |
+----+------------+--------------+-----+
| 5  | 2017-07-05 | 145          | 2   |
| 6  | 2017-07-06 | 1455         | 2   |
| 7  | 2017-07-07 | 199          | 2   |
| 8  | 2017-07-08 | 188          | 2   |
+----+------------+--------------+-----+


Logic: use rank
*/

WITH cte
     AS (SELECT id,
                visit_date,
                no_of_people,
                id - Row_number() OVER(ORDER BY visit_date) AS grp
         FROM   stadium
         WHERE  no_of_people >= 100)
SELECT *
FROM   cte
WHERE  grp IN (SELECT grp
               FROM   cte
               GROUP  BY grp
               HAVING Count(*) >= 3); 
