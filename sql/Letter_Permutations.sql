/*
Find Permutations of all letters in a table.

Input:
+----------+
| TestCase |
+----------+
| A        |
| B        |
| C        |
| D        |
+----------+

Ouput:
+-------------------+
|letter_combinations|
+-------------------+
| ABC               |
| ACB               |
| BAC               |
| BCA               |
| CAB               |
| CBA               |
+-------------------+


Logic: use the recursive CTE 
*/
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
