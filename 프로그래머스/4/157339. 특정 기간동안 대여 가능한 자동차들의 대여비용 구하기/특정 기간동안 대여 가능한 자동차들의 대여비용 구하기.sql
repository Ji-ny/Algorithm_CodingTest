-- CAR_RENTAL_COMPANY_CAR -- 대여중 자동차 정보
-- CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS | 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트 

-- CAR_RENTAL_COMPANY_RENTAL_HISTORY -- 자동차 대여 기록 정보를
-- HISTORY_ID, CAR_ID, START_DATE, END_DATE | 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일 

-- CAR_RENTAL_COMPANY_DISCOUNT_PLAN -- 자동차 종류 별 대여 기간 종류 별 할인 정책 정보
-- PLAN_ID, CAR_TYPE, DURATION_TYPE, DISCOUNT_RATE | 요금 할인 정책 ID, 자동차 종류, 대여 기간 종류, 할인율(%)
 -- [할인 적용]
 -- '7일 이상' (대여 기간이 7일 이상 30일 미만인 경우), '
 -- 30일 이상' (대여 기간이 30일 이상 90일 미만인 경우),
 -- '90일 이상' (대여 기간이 90일 이상인 경우)
 --  대여 기간이 7일 미만인 경우 할인정책이 없습니다.
 
 -- SELECT * FROM CAR_RENTAL_COMPANY_CAR
 -- SELECT * FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
 -- WHERE CAR_ID IN (3, 23)
 -- SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
 
 
--  자동차 종류가 '세단' 또는 'SUV' 인 자동차 중
--  2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고
--  30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 
--  자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문을 작성해주세요.
--  결과는 대여 금액을 기준으로 내림차순 정렬하고, 
--  대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬,
--  자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬해주세요.
-- SELECT CAR_ID, CAR_TYPE, (END_DATE - START_DATE + 1) * DAILY_FEE * (100 - DISCOUNT_RATE)/100 AS FEE
-- SELECT 
--     DISTINCT CAR_ID,	
--     C.CAR_TYPE, 
--     DAILY_FEE, 
--     DAILY_FEE*30, 
--     (DAILY_FEE * 30 * (100- DISCOUNT_RATE)/100) AS	FEE,
--     DISCOUNT_RATE

SELECT 
    DISTINCT CAR_ID,	
    C.CAR_TYPE, 
    (DAILY_FEE * 30 * (100- DISCOUNT_RATE)/100) AS	FEE
FROM (
    SELECT * FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_TYPE IN ('세단', 'SUV')
) C
INNER JOIN (
    SELECT 
        HISTORY_ID,
        CAR_ID,
        START_DATE,
        END_DATE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
) H
USING (CAR_ID)
LEFT JOIN (
    SELECT
        PLAN_ID,
        CAR_TYPE, 
        DURATION_TYPE, 
        DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    WHERE DURATION_TYPE = '30일 이상'
) P
ON C.CAR_TYPE = P.CAR_TYPE
WHERE (DAILY_FEE * 30 * (100- DISCOUNT_RATE)/100) >= 500000 
    AND (DAILY_FEE * 30 * (100- DISCOUNT_RATE)/100) < 2000000
    AND CAR_ID NOT IN  (
        SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        WHERE START_DATE <= TO_DATE('2022-11-30', 'YYYY-MM-DD')   
        AND END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD') 
    )
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC

         
         
-- CAR_ID	CAR_TYPE	FEE
-- 3	세단	1518000
-- 23	세단	1380000