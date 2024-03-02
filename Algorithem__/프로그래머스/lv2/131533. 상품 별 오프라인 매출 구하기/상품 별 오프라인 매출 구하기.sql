SELECT PRODUCT_CODE, SUM(PRICE * SALES_AMOUNT) as SALES
FROM PRODUCT p
JOIN OFFLINE_SALE os ON p.PRODUCT_ID = os.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE