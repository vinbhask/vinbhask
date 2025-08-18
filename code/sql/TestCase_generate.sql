/*
From a given dataset create testcases without the current row testcases

Input:
+----------+
| TestCase |
+----------+
| A        |
| B        |
| C        |
| D        |
+----------+

Output:
+----+-----+
| t1 | t2  |
+----+-----+
| A  | BCD |
| B  | ACD |
| C  | ABD |
| D  | ABC |
+----+-----+

Logic: Use group_concat or Listagg
*/

WITH cte AS
(
       SELECT testcase
       FROM   testcases)
SELECT t1.testcase AS t1,
       (
              SELECT group_concat(t2.testcase separator '')
              FROM   cte t2
              WHERE  t1.testcase<>t2.testcase ) AS t2
FROM   cte t1;
