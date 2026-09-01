-- 코드를 입력하세요

-- 동물 보호소에 들어온 동물의 정보 
-- SELECT * FROM ANIMAL_INS 
-- INTAKE_CONDITION <- 보호 시작시 상태 

-- 입양보낸 동물 
-- SELECT * FROM ANIMAL_OUTS 

-- 1. 입양 간 기록은 있는데
-- 2. 보호소에 들어온 기록이 없는 동물 ID 
--     이름을 ID 순으로 조회 

SELECT O.ANIMAL_ID	, O.NAME
FROM ANIMAL_INS I
RIGHT JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.ANIMAL_ID IS NULL
ORDER BY O.ANIMAL_ID
