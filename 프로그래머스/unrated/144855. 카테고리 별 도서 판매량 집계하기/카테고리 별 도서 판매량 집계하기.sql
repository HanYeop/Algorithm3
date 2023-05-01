-- 코드를 입력하세요
SELECT category, SUM(bs.sales) AS TOTAL_SALES
FROM book b JOIN book_sales bs ON b.BOOK_ID = bs.BOOK_ID
WHERE bs.sales_date LIKE "2022-01%"
GROUP BY category
ORDER BY CATEGORY