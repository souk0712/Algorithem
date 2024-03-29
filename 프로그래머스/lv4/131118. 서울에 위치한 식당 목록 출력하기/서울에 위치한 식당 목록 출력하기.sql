SELECT i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, ROUND(AVG(REVIEW_SCORE),2) as SCORE
FROM REST_INFO i
JOIN REST_REVIEW r ON i.REST_ID = r.REST_ID
GROUP BY REST_ID HAVING ADDRESS LIKE "서울%"
ORDER BY SCORE DESC,FAVORITES DESC