def solution(n):
    answer = 0
    # 현재 수를 2진수로 변환
    
    nCount = str(bin(n)).count('1')
    print(nCount)
    
    next = n+1
    while True:
        if str(bin(next)).count('1') == nCount:
            return next
        next += 1
    # strBinaryN = str(binaryN)
    

    
    return answer