/* Given two tables Succeeded and Failed write a SQL to find the continous dates of success and failure

Create table If Not Exists Failed (fail_date date);
Create table If Not Exists Succeeded (success_date date);

insert into Failed (fail_date) values ('2018-12-28');
insert into Failed (fail_date) values ('2018-12-29');
insert into Failed (fail_date) values ('2019-01-04');
insert into Failed (fail_date) values ('2019-01-05');

insert into Succeeded (success_date) values ('2018-12-30');
insert into Succeeded (success_date) values ('2018-12-31');
insert into Succeeded (success_date) values ('2019-01-01');
insert into Succeeded (success_date) values ('2019-01-02');
insert into Succeeded (success_date) values ('2019-01-03');
insert into Succeeded (success_date) values ('2019-01-06');
select * from Succeeded;

Input table:
+------------+
|success_date|
+------------+
| 2018-12-30 |
| 2018-12-31 |
| 2019-01-01 |
| 2019-01-02 |
| 2019-01-03 |
| 2019-01-06 |
+------------+

Output table:
+------------+------------+------------+
|period_state| start_date | end_date   |
+------------+------------+------------+
| succeeded  | 2019-01-01 | 2019-01-03 |
| failed     | 2019-01-04 | 2019-01-05 |
| succeeded  | 2019-01-06 | 2019-01-06 |
+------------+------------+------------+

Logic: Generate the rank for a given period_state and its respective dates to find the break in the dates now group by to find the answer

*/

WITH period_state
     AS (SELECT A.*,
                Rank()
                  OVER(
                    partition BY A.period_state
                    ORDER BY A.period_date) AS rnk
         FROM   (SELECT 'succeeded'  AS period_state,
                        success_date AS period_date
                 FROM   succeeded
                 WHERE  success_date BETWEEN '2019-01-01' AND '2019-12-31'
                 UNION ALL
                 SELECT 'failed',
                        fail_date
                 FROM   failed
                 WHERE  fail_date BETWEEN '2019-01-01' AND '2019-12-31')A
         ORDER  BY period_date)
SELECT A.period_state,
       Min(period_date),
       Max(period_date)
FROM   period_state A
GROUP  BY period_state,
          Day(period_date) - rnk; 
