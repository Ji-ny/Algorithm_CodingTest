# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제 
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''




'''
아래의 구문은 input.txt 를 read only 형식으로 연 후,
앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
아래 구문을 이용하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 구문을 사용하셔도 좋습니다.
아래 구문을 사용하기 위해서는 import sys가 필요합니다.
단, 채점을 위해 코드를 제출하실 때에는 반드시 아래 구문을 지우거나 주석 처리 하셔야 합니다.
'''
#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    
    N = int(input())
    array = []
    for _ in range(N):
        array.append(list(map(int, input(). split(' '))))

    array90 = []
    array180 = []
    array270 = []
    # 90, 180, 270
    # col만큼 반복
    # * 90도 
    for col in range(N):
        str90 = "" 
        for row in range(N): # row만큼 반복하게 된다.
            str90 += str(array[(N-1)-row][col])
        array90.append(str90)
    # print(array90)

    # * 180도
    for row in range(N): # 행 
        str180 = "" 
        for col in range(N): # col 만큼 반복 ()
            str180 += str(array[(N-1)-row][(N-1)-col])
        array180.append(str180)
    # print(array180)
    
    # * 270도
    for col in range(N): # 열
        str270 = "" 
        for row in range(N): # col 만큼 반복 ()
            str270 += str(array[row][(N-1)-col])
        array270.append(str270)
    # print(array270)
        
    print(f'#{test_case}')
    for i in range(N):
        print(f'{array90[i]} {array180[i]} {array270[i]}')

# 7
# 9 3 1 8 5 0 5
# 1 1 1 7 9 1 8
# 3 6 1 4 7 7 4
# 3 1 8 5 3 0 7
# 2 5 2 5 7 6 8
# 2 8 5 2 6 7 0
# 0 5 5 9 3 6 0
#3
# // 정답
# 0223319 0639550 5847800 
# 5851613 0762582 0170676 
# 5528111 8675252 5973763 
# 9255478 7035813 8745529 
# 3673795 4774163 1118255 
# 6760710 8197111 3161585 
# 0087485 5058139 9133220 

# // 틀림
# 223319 639550 5847800
# 5851613 762582 170676
# 5528111 8675252 5973763
# 9255478 7035813 8745529
# 3673795 4774163 1118255
# 6760710 8197111 3161585
# 87485 5058139 9133220