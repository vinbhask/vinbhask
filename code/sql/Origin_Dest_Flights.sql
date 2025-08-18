/* 
Given a dataset of customer with origin and destination write a sql to identify the customers first origin and last destination

CREATE TABLE Flights (cust_id INT, flight_id VARCHAR(10), origin VARCHAR(50), destination VARCHAR(50));

INSERT INTO Flights (cust_id, flight_id, origin, destination)
VALUES (1, 'SG1255', 'Mangalore', 'Trichy'),
(1, 'SG1234', 'Delhi', 'Hyderabad'), (1, 'SG3476', 'Kochi', 'Mangalore'), (1, '69876', 'Hyderabad', 'Kochi'), (2, '68749', 'Mumbai', 'Varanasi'), (2, 'SG5723', 'Varanasi', 'Delhi');
select * from flights;

Input:
+---------+-----------+-----------+-------------+
| cust_id | flight_id | origin    | destination |
+---------+-----------+-----------+-------------+
| 1       | SG1255    | Mangalore | Trichy      |
| 1       | SG1234    | Delhi     | Hyderabad   |
| 1       | SG3476    | Kochi     | Mangalore   |
| 1       | 69876     | Hyderabad | Kochi       |
| 2       | 68749     | Mumbai    | Varanasi    |
| 2       | SG5723    | Varanasi  | Delhi       |
+---------+-----------+-----------+-------------+

Output:
+---------+--------+-------------------+
| cust_id | origin | final_destination |
+---------+--------+-------------------+
| 1       | Delhi  | Trichy            |
| 2       | Mumbai | Delhi             |
+---------+--------+-------------------+


Logic: for a given origin if we dont find it in destination that means that would be the first origin vice versa for destination

*/
SELECT c                      AS cust_id,
       Max(origin)            AS origin,
       Max(final_destination) AS final_destination
FROM   (SELECT cust_id AS c,
               CASE
                 WHEN origin NOT IN (SELECT destination
                                     FROM   flights
                                     WHERE  cust_id = c) THEN origin
               END     origin,
               CASE
                 WHEN destination NOT IN (SELECT origin
                                          FROM   flights
                                          WHERE  cust_id = c) THEN destination
               END     final_destination
        FROM   flights) t
GROUP  BY cust_id; 
