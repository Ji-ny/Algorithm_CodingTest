

from collections import deque

N = int(input()) # 구역의 개수

# 각 구역의 인구 수 // 0번 인덱스 포함 
nodePersonArray = [0] + list(map(int, input().split(" "))) # 인구배열 1-index로 정리

graph = [[]] # 인접 그래프 

# N개의 줄에 각 구역과 인접한 구역의 정보 
for _ in range (N):
  graph.append(list(map(int, input().split(" ")))[1:])

# for item in graph:
#   print(item)


# * 1. 선거구 나누기 (모든 경우의 수, 조합) (조합으로 부분집합 만들기 )
# 부분집합 (선거구 A 후보 ) 만들기
all_mask = ( 1 << N) - 1 # 전체 집합 : N=4이면 0b1111 = 15
# print(all_mask)

subsets = [] # 부분집합 모아두기

for mask in range(1, all_mask): # 1 ~ 14 (공집합, 전체집합 제외) (무조건 1개 이상은 있어야해서)
  if bin(mask).count("1") > N//2: # A 크기가 N//2보다 크면 패스 
    continue
  comp = all_mask ^ mask # B = 전체 ^ A
  subsets.append((mask, comp)) # A, B 저장 ! 

# print("부분집합 개수:", len(subsets))
# for A, B in subsets:
#   print(bin(A), bin(B))

# 비트마스크를 구역 번호로 나타내주기
def mask_to_list(mask):
  result = []
  for i in range(N):
    if mask & (1 << i): # i번째 비트가 켜져있다면,
      result.append(i+1) # 1번부터 시작하기 때문에 +1 
  return result

# for A, B in subsets:
#   print("A: ", mask_to_list(A), "B: ", mask_to_list(B))


# * 2. 나눠진 선거구가 올바른 선거구인가 확인하기 (BFS) (집합 mask가 연결인가?)
# * 집합이 연결인지 확인하는 함수
def is_connected_bfs(group): # 집합 그룹 리스트
  # 공집합 방지
  if not group:
    return False

  # group 예시 : [ 1, 4, 5] 
  startNode = group[0] # 첫 원소로 시작 
  visited = [False] * (N + 1)

  queue = deque([startNode])

  count = 1 # 방문한 group 내부 노드 수 

  while queue:
    nowNode = queue.popleft()
    visited[nowNode] = True # 현재 노드 방문 처리

    # 현재 노드와 이어진 그래프 방문처리 
    for nextNode in graph[nowNode]:
      # 만약 아직 방문하지 않은 노드라면 방문처리 
      # 그리고 현재 집합 그룹에 있어야함
      if nextNode in group and not visited[nextNode]:
        visited[nextNode] = True
        count += 1 # 방문한 노드 수 업그레이드
        queue.append(nextNode)
  

  return count == len(group) # 모든 노드를 방문했다믄 True 반환 ! // 모두 방문 못했다믄 Fasle1 

      


  # group은 집합으로 받는다. 
  # 시작점 하나 잡아서, 그 직합 안에 포함된 이웃만 방문할 것 

# * 3. 두 집합(선거구) 모두 연결이 되면 인구 차이 갱신, 인구수 차이 계산 및 최솟값 갱신 
# subsets을 반복하면서 두개 모두 연결이 됐는지 보고 sum으로 합친값을 구해보자.
totalList = []
for A_set, B_set in subsets:
  A_set_list = mask_to_list(A_set)
  B_set_list = mask_to_list(B_set)
  if (is_connected_bfs(A_set_list) and is_connected_bfs(B_set_list)):
    totalList.append(abs(sum(nodePersonArray[i] for i in A_set_list) - sum(nodePersonArray[i] for i in B_set_list)))

# totalList가 0개이면 연결된게 없다는 뜻 
if len(totalList) == 0:
  print(-1)
else:
  print(min(totalList))