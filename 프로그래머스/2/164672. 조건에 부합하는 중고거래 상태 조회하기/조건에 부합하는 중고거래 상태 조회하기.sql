-- USED_GOODS_BOARD 테이블
-- BOARD_ID    게시글 ID
-- WRITER_ID   작성자 ID
-- TITLE       게시글 제목
-- CONTENTS    게시글 내용
-- PRICE       가격
-- CREATED_DATE 작성일, 
-- STATUS      거래상태,
-- VIEWS       조회수
-- 코드를 입력하세요

-- 2022년 10월 5일에 등록된 중고거래 게시물의 
-- 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회
-- 거래상태가 
--     SALE 이면 판매중,
--     RESERVED이면 예약중,
--     DONE이면 거래완료 분류하여 출력해주시고,
-- 결과는 게시글 ID를 기준으로 내림차순 정렬
SELECT  BOARD_ID, WRITER_ID, TITLE, PRICE, 
    CASE 
        WHEN STATUS = 'SALE'        THEN '판매중'
        WHEN STATUS = 'RESERVED'    THEN '예약중'
        WHEN STATUS = 'DONE'        THEN '거래완료'
    END AS STATUS 
FROM USED_GOODS_BOARD 
WHERE TO_CHAR(CREATED_DATE, 'YYYYMMDD') = '20221005'
ORDER BY BOARD_ID DESC