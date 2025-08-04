from collections import deque

## ! 4803. 트리 제발 되게 해주세여ㅛ
testCase = 0

while True:
  testCase+=1
  ## 입력 받기 
  m, n = map(int, input().split(" ")) # *정점, 간선 

  

  
  if (m == 0 and n == 0):
    break


  # 정점 수만큼 제작 
  array = [[] for _ in range(m+1)] # 0번 노드는 제외한다. 1번부터 m번까지
  parentsArray = [i for i in range(m+1)] # 0~ M번까지 정점의 부모를 저장할 배열 
  visited = [False] * (m+1) # 0 ~ M번까지 방문 처리 
  treeCount = 0 # 트리 개수 세기 

  # 간선수 (n) 만큼 반복해서 넣어준다.
  for i in range(n):
    startNode, endNode = map(int, input().split(" ")) # a -> b 간선
    array[startNode].append(endNode) # a -> b 연결 
    array[endNode].append(startNode) # b -> a 연결 (양방향)

  # dfs로 방문하면서 부모 노드를 저장한다. 
  # 이때, 완전 탐색을 이용해서 1 ~ n까지 진행.
  ## 방문처리 됐다면 return true
  ## 싸이클에 걸렸다면 return false
  ## 이미 방문한 곳이었다면 return false 

  def dfs(node): # 방문할 노드
    stack = [(node, 0)] # 현재 노드, 부모 노드 
    # 방문하지 않은 곳이라면
    # 1. 방문 처리 
    visited[node] = True

    while stack:
      nowNode, parent = stack.pop()
      # 2. 이어진 노드의 부모 노드 저장 
      for childNode in array[nowNode]:
        if not visited[childNode]:  # 만약 아직 해당 위치 방문하지 않았다면 
          visited[childNode] = True # 방문 처리 
          # 이어진 노드 탐색으로 추가 
          stack.append((childNode, nowNode))
           # * 싸이클이 발생하면, 아얘 이 코드는 False를 반환한다. 
        elif childNode != parent: # 이미 방문한 이웃 노드가 내 부모가 아니면, 그건 싸이클이다
          return False
    return True


  for node in range(1, m+1): #1 ~ M번 노드까지 dfs로 순회하도록 한다. 방문한다. 
    if not visited[node] and dfs(node):
      treeCount += 1 # 처음 방문한 곳이었고, 싸이클이 아니라면 트리 개수 +1 


  ## 출력하기 
  # 트리가 1개 초과라면 
  if treeCount > 1:
    print(f'Case {testCase}: A forest of {treeCount} trees.')
  elif treeCount == 1: # 트리가 1개라면
    print(f'Case {testCase}: There is one tree.')
  else: #트리가 빵개라면
    print(f'Case {testCase}: No trees.')

# 처음 while문의 조건때문에 안되는 거였습니다...ㅠㅠ 간선이 0개일경우를 체크하지 못했습니다!
# while (n != 0 || m != 0)로 바꾸니까 해결되었습니다.
# 6 3
# 6 4
# 6 1
# 6 2
'''
# 정점의 수 n, 간선의 1수 m 
6 3 # * 정점, 간선
1 2 # 간선1
2 3 # 간선2
3 4 # 간선3

6 5 # * 정점, 간선 
1 2 
2 3
3 4
4 5
5 6

6 6 # * 정점, 간선 
1 2
2 3
1 3
4 5
5 6
6 4

0 0 # * end 

'''

