-- 코드를 입력하세요
with base_data as (
    SELECT TO_NUMBER(TO_CHAR(DATETIME, 'FMHH24')) AS hour, COUNT(*) AS COUNT  FROM ANIMAL_OUTS
    GROUP BY TO_NUMBER(TO_CHAR(DATETIME, 'FMHH24'))
    ORDER BY hour
)

-- 0~ 23  까지 시간대를 나타내는 테이블을 하나 만든다,
select a.hour, NVL(B.COUNT, 0) AS count
from (
    select level - 1 as hour
    from dual
    connect by level <= 24
) A
left join base_data B
on A.hour = B.hour
order by a.hour
    


-- 0~23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회 