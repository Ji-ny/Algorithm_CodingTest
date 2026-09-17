-- 코드를 입력하세요
-- select * from book        -- 판매중인 도서들의 도서 정보 
-- select * from author      -- 도서의 저자 정보 
-- select * from book_sales  -- 각 도서의 날짜 별 판매량 정보 

-- 1. 2022년 1월의 도서 판매 데이터를 기준으로 
-- 2. 저자별, 카테고리별 매출액 (total_sales = 판매량 * 판매가) 을 구하여 출력 
-- 출력 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트
-- 3. 저자 id 오름차순, 카테고리 내림차순 

select s.author_id, author_name, category, total_sales 
from (
    select author_id, category, sum(price * sales) as total_sales
    from book_sales sub_s
    inner join book sub_b
    on sub_b.book_id = sub_s.book_id
    where to_char(sales_date, 'YYYY-MM') = '2022-01' 
    group by author_id, category
) s
inner join author a
on s.author_id = a.author_id
order by s.author_id asc, s.category desc