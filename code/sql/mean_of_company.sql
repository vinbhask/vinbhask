/*
Given a dataset find the mean of each company

Input:
+--------+---------+--------+
| emp_id | company | salary |
+--------+---------+--------+
| 1      | A       | 2341   |
| 2      | A       | 341    |
| 3      | A       | 15     |
| 4      | A       | 15314  |
| 5      | A       | 451    |
| 6      | A       | 513    |
| 7      | B       | 15     |
| 8      | B       | 13     |
| 9      | B       | 1154   |
| 10     | B       | 1345   |
| 11     | B       | 1221   |
| 12     | B       | 234    |
| 13     | C       | 2345   |
| 14     | C       | 2645   |
| 15     | C       | 2645   |
| 16     | C       | 2652   |
| 17     | C       | 65     |
+--------+---------+--------+

output:
+---------+------------+
| company | avg(salary) |
+---------+------------+
| A       | 482.0000   |
| B       | 694.0000   |
| C       | 2645.0000  |
+---------+------------+
*/

SELECT company,
       Avg(salary)
FROM   (SELECT *,
               Row_number()
                 OVER(
                   partition BY company
                   ORDER BY salary)      AS rn,
               Count(1)
                 OVER(
                   partition BY company) AS total_cnt
        FROM   employee3) a
WHERE  rn BETWEEN total_cnt * 1.0 / 2 AND total_cnt * 1.0 / 2 + 1
GROUP  BY company; 
