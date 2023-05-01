-- 코드를 입력하세요
SELECT mcdp_cd AS '진료과코드', COUNT(*) AS '5월예약건수'
FROM appointment
WHERE MONTH(apnt_ymd) = 5 AND YEAR(apnt_ymd) = 2022
GROUP BY mcdp_cd
ORDER BY COUNT(MCDP_CD) ASC, MCDP_CD ASC
