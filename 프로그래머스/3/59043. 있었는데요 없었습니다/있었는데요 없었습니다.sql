-- 코드를 입력하세요
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I
INNER JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE (I.DATETIME + 0) > (O.DATETIME + 0) 
ORDER BY I.DATETIME

-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회
-- 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.