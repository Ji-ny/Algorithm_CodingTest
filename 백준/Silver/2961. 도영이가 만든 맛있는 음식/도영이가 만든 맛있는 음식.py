from sys import stdin
from itertools import combinations

N = int(stdin.readline()) # 재료의 개수

sinArray = [] # 신맛리스트
sonArray = [] # 쓴맛리스트

sinSum = 0 # 신맛 곱하는
sonSum = 0 # 쓴맛 더하는값

result = 9999999999
foodArray = [] # 음식 배열 저장

for _ in range(N):
  sin, son = map(int,stdin.readline().split())  # 신맛, 쓴맛 저장
  foodArray.append((sin,son)) # 신맛, 쓴맛 추가

#2. 조합 만들기 
for i in range(1,N+1):
  foodCombinationArray = list(combinations(foodArray,i)) # 1개부터 n개까지 
  # print(i,foodCombinationArray)

  for foods in foodCombinationArray:
    sinSum = 1
    sonSum = 0
    for food in foods:
      sinSum *= food[0] # 신맛 곱하기
      sonSum += food[1] # 쓴맛 더하기 

    if abs(sinSum - sonSum) < result:
      result = abs(sinSum - sonSum)

print(result)
  # 짠맛리스트 0번부터 값을 더해가기
  # 신만리스트 
  # cooking 에 짠맛 - 쓴맛 절대값 씌우기 

# 아마 1초라서 시간초과가 나오지 않을까