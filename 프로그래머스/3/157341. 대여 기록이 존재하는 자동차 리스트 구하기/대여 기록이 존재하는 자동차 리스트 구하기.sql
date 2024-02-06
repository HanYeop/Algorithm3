-- 코드를 입력하세요
SELECT DISTINCT A.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR A, CAR_RENTAL_COMPANY_RENTAL_HISTORY B
WHERE 1=1
AND A.CAR_ID = B.CAR_ID
AND A.CAR_TYPE = '세단'
AND TO_CHAR(B.START_DATE, 'YYYYMMDD') >= '20221001' 
ORDER BY A.CAR_ID DESC
