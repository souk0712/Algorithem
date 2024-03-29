SELECT P.CATEGORY, MAX(P.PRICE) as MAX_PRICE, (
            SELECT PRODUCT_NAME
            FROM FOOD_PRODUCT
            WHERE CATEGORY = P.CATEGORY
            ORDER BY PRICE DESC LIMIT 1
        ) as PRODUCT_NAME
FROM FOOD_PRODUCT P
WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
GROUP BY CATEGORY
ORDER BY MAX_PRICE DESC