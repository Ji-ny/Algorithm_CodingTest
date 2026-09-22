-- 코드를 입력하세요
-- rental_history : 자동차 대여기록정보 
    -- select history_id, car_id, to_number(to_char(start_date, 'FMMM')) as month
    -- from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    -- where start_date between to_date('2022-08', 'YYYY-MM') and to_date('2022-10', 'YYYY-MM')


select to_number(to_char(start_date, 'FMMM')) as month, car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between to_date('2022-08-01', 'YYYY-MM-DD') and to_date('2022-10-31', 'YYYY-MM-DD')
and car_id in (
    select car_id
    from (
        select history_id, car_id, to_number(to_char(start_date, 'FMMM')) as month
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where start_date between to_date('2022-08-01', 'YYYY-MM-DD') and to_date('2022-10-31', 'YYYY-MM-DD')
        )
    group by car_id
    having count(*) >= 5
)
    
group by ( to_number(to_char(start_date, 'FMMM')), car_id)
order by month asc, car_id desc


-- 1. 대여 시작일을 기준으로,
--   2022년 8월 부터 2022년 10월까지
--   총 대여횟수가 5회 이상인 자동차들에 대하여

-- 2. 해당 기간동안의 '월별' 
--    자동차 id 별 총 대여횟수 리스트 출력

-- 3. 월 기준 오름차순, 자동차 id 기준 내림차순 

