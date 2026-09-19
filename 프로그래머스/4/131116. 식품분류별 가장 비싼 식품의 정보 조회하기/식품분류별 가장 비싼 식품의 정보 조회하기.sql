-- 코드를 입력하세요
-- 1. 식품 분류별로, 가격이제일 비싼 시품의
-- 2. 분류, 가격, 이름 조회
-- 3. 식품분류가 과자, 국, 김치, 식용유인 경우면 출력
-- 4. 결과는 식품 가격을 기준 순으로 내림차순 정렬 
-- where 절로 price, category 둔다. 
select category, price as max_price, product_name
from food_product
where (price, category) in (
    SELECT max(price) as price, category  from food_product
    group by category
    having category in ('과자', '국', '김치', '식용유')
)
order by max_price desc
