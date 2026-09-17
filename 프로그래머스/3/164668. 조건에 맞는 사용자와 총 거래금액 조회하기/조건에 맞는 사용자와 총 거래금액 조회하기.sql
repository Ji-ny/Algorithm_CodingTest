-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람
-- 결과는 총거래금액을 기준으로 오름차순 정렬

-- 코드를 입력하세요
select a.writer_id as user_id, b.nickname,  a.total_sales
from ( select writer_id, sum(price) as total_sales
    from used_goods_board -- 중고거래게시판 
    where status = 'DONE'
    group by writer_id
    having sum(price) >= 700000
    ) a
inner join used_goods_user b
on a.writer_id = b.user_id
order by a.total_sales

-- select *
-- from used_goods_user

