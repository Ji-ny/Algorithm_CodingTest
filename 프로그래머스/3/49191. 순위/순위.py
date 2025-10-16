'''
1. 이기는 배열, 지는 배열 생성
2. n*n 배열 생성 (각각 true/false 판단) (모두 false로 넣는다. 자기자신은 true)
3. graph를 이긴 경우, 진 경우를 각각 만든다.
4. dfs로 탐색한다.
5. 하나 탐색했을 때, n개만큼 모두 true라면 answer += 1
'''
def dfs(nowNode, visited, graph):
    # 현위치 방문처리 
    visited[nowNode] = True
    
    # 현 노드와 연결된 노드들 방문 
    for nextNode in graph[nowNode]:
        # 만약 방문하지 않았다면
        if not visited[nextNode]:
            visited[nextNode] = True # 방문 처리하고
            dfs(nextNode, visited, graph) # 다음 dfs실행
        

def solution(n, results):
    answer = 0
    winGraph = [[] for _ in range(n+1)] # 0번째 노드 무시 (a->b 이김)
    loseGraph = [[] for _ in range(n+1)] # 0번째 노드 무시 (b->a (짐))
    
    for result in results:
        winGraph[result[0]].append(result[1])
        loseGraph[result[1]].append(result[0])
    
    # 4. dfs로 탐색해서 방문했다면 visited = True
    # 1 ~ n번 노드까지 시작 
    for i in range(1, n+1):
        visited = [False for _ in range(n+1)] #0번째 노드 무시
        loseVisited = [False for _ in range(n+1)] #0번째 노드 무시
        
        dfs(i, visited, winGraph)
        dfs(i, loseVisited, loseGraph)
        
        # 만약 방문한게 n-1이라면(자기자신제외) 모두 들린거니까 가능
        print(i, visited, visited.count(True))
        print(i, loseVisited, loseVisited.count(True))
        # 자기 자신도 포함되므로 -1
        if visited.count(True) + loseVisited.count(True) - 1 == n:
            answer += 1
        
    
    
    return answer

