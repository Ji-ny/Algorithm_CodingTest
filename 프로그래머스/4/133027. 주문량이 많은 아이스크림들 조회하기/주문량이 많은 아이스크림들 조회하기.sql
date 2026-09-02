-- 코드를 입력하세요

-- FIRST_HALF :  SHIPMENT_ID, *FLAVOR, TOTAL_ORDER | 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량
-- JULY : SHIPMENT_ID, FLAVOR, TOTAL_ORDER | 출하 번호, 아이스크림 맛, 7월 아이스크림 총주문량

-- SELECT * FROM FIRST_HALF
-- SELECT * FROM JULY

-- 7월은 FALAVOR이 같아도 다른 SHIPMENT_ID 를 가진 경우가 있다.
-- 7월 아이스크림 총 주문량과 + 상반기의 아이스크림 총 주문량을 더한 값이
-- 큰 순서대로
-- 상위 3개의 맛을 조회
 
 
SELECT *
FROM (
    SELECT FLAVOR
    FROM FIRST_HALF F
    INNER JOIN 
        ( SELECT 
            FLAVOR, 
            SUM(TOTAL_ORDER) AS TOTAL_ORDER 
         FROM JULY J
         GROUP BY FLAVOR
        ) J
    USING (FLAVOR)
    ORDER BY (F.TOTAL_ORDER + J.TOTAL_ORDER) DESC
) WHERE ROWNUM <= 3
