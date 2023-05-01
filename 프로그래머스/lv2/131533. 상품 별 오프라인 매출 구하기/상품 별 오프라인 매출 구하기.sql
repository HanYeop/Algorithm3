-- 코드를 입력하세요
SELECT p.product_code AS 'PRODUCT_CODE', SUM(p.price * o.sales_amount) AS 'SALES'
FROM product p JOIN offline_sale o
WHERE p.product_id = o.product_id
GROUP BY p.product_id
ORDER BY SALES DESC, p.product_code