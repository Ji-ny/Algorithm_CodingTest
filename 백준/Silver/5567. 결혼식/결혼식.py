from collections import deque

N = int(input()) # 상근이의 동기 수 (2 ~ 500) 
M = int(input()) # 리스트 길이 (1 ~ 10000)

# 친구 관게 a, b
array = [[] for i in range (N+1)] # 노드 연결 정보 (1 ~ N번까지 ), 0은 제외
# 1 ~ N까지
visited = [False] * (N+1) # 0번째는 제외한다 (1 ~ N번노드까지 방문 여부)

depth = 0 # 처음 깊이는 0, 친구의 친구는 depth 2까지! 

queue = deque([])
for i in range(M):
  a, b = map(int, input().split(" "))# a <->b 친구!
  # 연결시켜주기
  array[a].append(b)
  array[b].append(a)


# 처음 큐 지정 
queue.append((1,0))
depth = -1 # 깊이
count = -1 # 카운팅  

# bfs는 차례대로 하므로 괜찮다. 
while queue:
  
  nowNode, now_depth = queue.popleft() # 현재 노드 

  if visited[nowNode]:
    continue 

  visited[nowNode] = True # 방문처리 
  # print(nowNode)


  if now_depth > 2: # 목표 구간까지 오면 정지 
    break

  count += 1 # 노드 개수 한개 추가 

  # 현재 연결된 노드 순회 
  for node in array[nowNode]:
    # 아직 방문하지 않은 곳이라면 
    if not visited[node]:
      queue.append((node, now_depth + 1))

  

# 만약 상근이와 연결된 노드가 없다면, 종료 
if len(array[1]) == 0:
  print(0)
else:
  print(count)
  

  

