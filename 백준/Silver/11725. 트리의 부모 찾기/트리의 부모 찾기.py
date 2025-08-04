from collections import deque

N = int(input())
array = [[] for _ in range (N+1)] # 연결된 배열 저장 (0번 ~ 7번까지) 
parentsNodeArray = [0] * (N+1)
queue = deque([1])



# 입력처리 : 이진트리이다. (루트는 1이다.)
for i in range(N-1):
    parents, child = map(int, input().split(' '))
    array[parents].append(child) # 부모-자식을 연결 
    array[child].append(parents) # 자식에도 부모와 연결되어 있다 


# bfs를 이용하여 1번부터 탐색을 시작한다. 

while len(queue) > 0:
    nowNode = queue.popleft() # 현재 탐색할 기준 노드 꺼내기 
    # 현재 노드와 연결된 노드를 순회하며 큐에 넣는다.
    for childNode in array[nowNode]:
        if parentsNodeArray[childNode] != 0:
            continue
        queue.append(childNode) # 방문한 노드 큐에 넣기
        parentsNodeArray[childNode] = nowNode# 방문한 노드 부모 노드 업데이트
        

for i in range(2, N+1):
    print(parentsNodeArray[i])

# 방문처리 배열 

