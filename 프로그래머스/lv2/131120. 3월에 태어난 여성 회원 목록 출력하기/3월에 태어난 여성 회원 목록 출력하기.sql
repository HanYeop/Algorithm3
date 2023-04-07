-- 코드를 입력하세요
SELECT member_id, member_name, gender, DATE_FORMAT(date_of_birth, "%Y-%m-%d") AS date_of_birth
FROM member_profile
WHERE MONTH(DATE_OF_BIRTH)=3
      AND TLNO IS NOT NULL
      AND GENDER ='W'
ORDER BY MEMBER_ID;