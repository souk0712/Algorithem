SELECT cc.CAR_ID, cc.CAR_TYPE, FLOOR(cc.DAILY_FEE * (1 - cp.DISCOUNT_RATE * 0.01) * 30) as FEE
FROM CAR_RENTAL_COMPANY_CAR cc
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN cp ON cc.CAR_TYPE = cp.CAR_TYPE AND cp.DURATION_TYPE = '30일 이상'
LEFT OUTER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY ch ON cc.CAR_ID = ch.CAR_ID
    AND ('2022-11-01' BETWEEN ch.START_DATE AND ch.END_DATE OR '2022-11-30' BETWEEN ch.START_DATE AND ch.END_DATE)
WHERE cc.CAR_TYPE IN ('세단', 'SUV') AND ch.CAR_ID IS NULL
    AND FLOOR(cc.DAILY_FEE * (1 - cp.DISCOUNT_RATE * 0.01) * 30) BETWEEN 500000 AND 1999999
ORDER BY FEE DESC, cc.CAR_TYPE, cc.CAR_ID DESC