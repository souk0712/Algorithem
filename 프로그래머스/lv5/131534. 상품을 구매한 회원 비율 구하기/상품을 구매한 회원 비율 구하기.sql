SELECT YEAR(os.sales_date) as YEAR, 
    MONTH(os.sales_date) as MONTH, 
    COUNT(DISTINCT os.user_id) as PUCHASED_USERS, 
    ROUND( COUNT (DISTINCT os.user_id) / (
              SELECT COUNT (DISTINCT USER_ID) 
              FROM USER_INFO 
              WHERE YEAR(JOINED) = 2021
          ), 1) as PUCHASED_RATIO
FROM USER_INFO ui, ONLINE_SALE os
WHERE os.USER_ID = ui.USER_ID AND YEAR(ui.JOINED) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH