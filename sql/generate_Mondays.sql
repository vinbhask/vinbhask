/*
From the given start date till the end date generate and display all the Mondays

For example:
start_date=2025-06-06
end_date=2025-06-14

*/

SET @start_date_value='2025-06-06';
SET @end_date_value='2025-06-14';
SET @first_monday=Cast(7-Weekday(@start_date_value) AS SIGNED);

WITH recursive dates AS
(
       SELECT date_add(@start_date_value, interval @first_monday day) AS dt
       UNION ALL
       SELECT date_add(dt,interval 7 day)
       FROM  dates
       WHERE  dt<@end_date_value)
SELECT dt
FROM   dates
WHERE  weekday(dt)=0;
