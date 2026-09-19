-- 코드를 입력하세요

-- user_info : 의류 쇼핑몰에 가입한 회원정보
-- online_sale : 온라인 상품 판매 정보 

-- 회원 id, 성별, 나이, 가입일 
-- SELECT * from user_info

-- 온라인 상품판매 id, 회원 id, 상품 id, 판매량, 판매일 
-- 동일한 날짜, 회원 id, 상품 id 조합에 대해서는 하나의 판매 데이터만 존재한다. 
-- select * from online_sale 

-- 1. user_info 테이블과 online_sale 테이블에서
--    년, 월, 성별 별로 
--    상품을 rn매한 회원수 집계
-- 2. 결과는 년, 월, 성별을 기준으로 오름차순 year, month, gender 
-- 3. 성별 정보가 없는 경우 결과에서 제외 gender is not null 


select  year, month, gender, count(distinct user_id ) as users
from (
    select *
    from user_info u 
    inner join online_sale s 
    using (user_id)
    inner join (
        select 
            user_id,
            to_number(to_char(sales_date, 'YYYY')) as year,
            to_number(to_char(sales_date, 'MM')) as month
        from online_sale
    ) d
    using (user_id)
)
where gender is not null
group by (year, month, gender) 
order by year, month, gender