-- 코드를 입력하세요
SELECT COUNT(*)
FROM user_info
WHERE (age BETWEEN 20 AND 29) AND (YEAR(joined) = 2021)