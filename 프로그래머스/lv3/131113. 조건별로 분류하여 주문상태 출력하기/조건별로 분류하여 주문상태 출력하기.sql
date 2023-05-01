-- 코드를 입력하세요
SELECT order_id, product_id, DATE_FORMAT(out_date,"%Y-%m-%d") AS 'OUT_DATE',   
if(out_date <= '2022-05-01', '출고완료',if(out_date is null, '출고미정','출고대기')) as 출고여부
FROM food_order
ORDER BY order_id