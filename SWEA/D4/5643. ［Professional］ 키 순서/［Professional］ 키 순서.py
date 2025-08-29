# 
## *
# ! 키순서 

T = int(input())

# DFS를 위해서 함수 구현하기
def dfs(node, visited, graph):
    count = 0
    visited[node] = True # 방문처리 
    stack = [node]

    while stack:
        nowNode = stack.pop()    
        # 나와 연결된 노드 방문처리 
        for nextNode in graph[nowNode]:
            # 방문하지 않은 곳이라면 이곳 추가 
            if not visited[nextNode]:
                visited[nextNode] = True # 새로운곳 방문 처리 우선 
                count +=1 
                # 현재 노드 추가
                stack.append(nextNode)

    return count # 현재 자기와 연결된 친구들 


for test_case in range(1, T+1):
    answer = 0
    N = int(input()) # 학생들의 수
    M = int(input())# 두 학생의 키를 비교한 횟수 M
    bigToSmallList = [[] for _ in range(N+1)] # 큰 -> 작 리스트 (0번은 제외)
    smallToBigList = [[] for _ in range(N+1)] # 작 -> 큰 리스트

    # M개의 줄에 걸쳐 두 학생의 키를 비교한 결과 a-> b 작->큰

    for i in range(M):
        start, end = map(int, input().split(" "))
        # 작 -> 큰 리스트에 추가 
        smallToBigList[start].append(end)
        # 큰 -> 작 리스트에 추가 
        bigToSmallList[end].append(start)

    # 이제 완전탐색을 한다.
    # (각 노드별로 자기보다 큰친구, 작은 친구가 몇명인지 구할 것 )

    for i in range(1, N+1):
        person = 0        
        
        # 노드 DFS 
        big =  dfs (i, [False] * (N+1), smallToBigList )
        small =  dfs (i, [False] * (N+1), bigToSmallList )
        person = big + small
        # 만약 찾은 사람 수가 앞뒤로 N-1명이라면?
        if person == (N-1):
            answer+=1
        
    print(f'#{test_case} {answer}')

