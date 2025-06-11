## * 비트마스킹을 구현해보자 
## * 비트마스킹을 구현해보자 
from sys import stdin

M = int(stdin.readline()) # 수행해야하는 연산 수 
# S = set() 
bit = 0
  # 원소 S 에 num을 추가한다. S의 num번 bit만 1을 만들주면 된다.
  # (1 << num)은 num번째를 1로 세팅해주는 거
for _ in range(M):
  arr = list(stdin.readline().split())
  option = arr[0].rstrip()

  if option == 'all': # * 1부터 20까지의 자리에 1을 넣어준다.
    bit = 0b111111111111111111111
  elif option == 'empty': # * S를 공집합으로 바꾼다.
    bit = 0b0
  elif option == 'add': # *s에 x를 추가한다. (이미 있다면 무시 )
    bit = bit | (1 << int(arr[1])) # 100번째로 이동시켜서 해당 번째 or 연산으로 추가
  elif option == 'remove' : #S에서 x를 제거한다.
    remove = ~(1<< int(arr[1])) # not연산으로 11011 삭제할것만 이럿게 만듬 그리고 and로 삭제할부분은 확실히 0으로 만들어준다
    bit = bit & remove # X번째를 000 이렇게 만들어줘서 삭제하면 되지 않을까?
  elif option == 'toggle': # * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20) xor 연산 (1->0 0->1)
    bit = bit ^ (1 << int(arr[1])) #  0 1-> 1 , 1 1-> 0
  elif option == 'check': # * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
    check = (1 << int(arr[1])) # 10000 이렇게해서 값이 1이면 1, 0이면 9 출력
    if bit & check: # '1'만 남아있으면 1이 맞으므로 print(1)
      print(1)
    else: # '0'만 남아있으면 0이므로 0
      print(0)

# 2
# all
# check 20

# 결과 : 1 