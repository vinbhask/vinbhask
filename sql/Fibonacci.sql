/*
Generate Fibonacci sequence upto the given number
*/


WITH recursive fib AS
(
       SELECT 1 AS sn,
              0 AS curr_val,
              1 AS next_val
       UNION ALL
       SELECT sn+1,
              curr_val+next_val,
              curr_val
       FROM   fib
       WHERE  sn < 10 
)
SELECT curr_val
FROM fib;
