-- 코드를 입력하세요
-- 1. 음식 종류별로 즐겨찾기 수가 -> 가장 많은 식당의
-- 2. 음식 종류, id, 식당 이름, 즐겨찾기 수 조회
-- 3. 결과는 음식 종류를 기준으로 내림차순 정렬 

select food_type, rest_id, rest_name, favorites
from rest_info
where (food_type, favorites) 
    in (
        SELECT food_type, max(favorites) as favorites
        from rest_info
        group by food_type
    )
order by food_type desc 
