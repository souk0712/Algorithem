WITH RECURSIVE HOURS AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1 
    FROM HOURS
    WHERE HOUR < 23
)

SELECT h.HOUR as HOUR, COUNT(ANIMAL_ID) as COUNT
FROM ANIMAL_OUTS
RIGHT JOIN HOURS h ON HOUR(DATETIME) = h.HOUR
GROUP BY HOUR
ORDER BY HOUR