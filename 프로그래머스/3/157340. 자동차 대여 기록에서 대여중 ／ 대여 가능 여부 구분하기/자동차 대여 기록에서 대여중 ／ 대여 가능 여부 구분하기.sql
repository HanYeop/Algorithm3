-- 코드를 입력하세요
select car_id, case when car_id in
(select car_id 
 from CAR_RENTAL_COMPANY_RENTAL_HISTORY
 where '20221016' BETWEEN to_char(START_DATE, 'YYYYMMDD') AND to_char(END_DATE, 'YYYYMMDD') 
)
then '대여중'
else '대여 가능' end "availability"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by CAR_ID desc