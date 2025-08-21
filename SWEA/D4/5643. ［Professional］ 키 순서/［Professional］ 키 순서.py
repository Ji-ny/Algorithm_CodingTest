# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.

def dfs(node, visited, array):
    # 현재 노드 이미 방문했다면? 패스 
    # 현재 노드 방문 처리 
    visited[node] = True

    # 현재 노드와 연결된 노드 탐색
    for nextNode in array[node]:
        # 만약 연결되어 있고 방문한곳이 아니라면? 
        if not visited[nextNode]:
            visited = dfs(nextNode, visited, array) # 연결하기 

    # 모두 끝난 다음에, 해당 dfs가 되는지 확인 
    return visited


for test_case in range(1, T + 1):
    N = int(input()) # 학생 수 
    M = int(input()) # 학생 키 비교 

    #리스트 해당 index에 연결되어 있는 다른 친구들 
    smallToBig = [[] for _ in range(N+1)] # 작 -> 큰 (학생수는 1 ~ N까지라서 ) 
    bigToSmall = [[] for _ in range(N+1)] # 큰 -> 작 

    count = 0 # 모두 연결된 것 찾은 개수 

    # 연결 
    for i in range(M):
        a, b = map(int, input().split(" "))
        smallToBig[a].append(b) # 작 -> 큰 
        bigToSmall[b].append(a) # 큰 -> 작 
    
    # 1 ~ N번 노드까지 탐색 
    for node in range(1, N+1):
        visited = [False] * (N+1) # 0 ~ N번 노드까지 (0번 인덱스는 제외할거!)

        samllToBigVisited = dfs(node, visited, smallToBig)

        visited = [False] * (N+1) # 0 ~ N번 노드까지 (0번 인덱스는 제외할거!)

        bigToSamllVisited = dfs(node, visited, bigToSmall)

        state = True
        for i in range(1, N+1):
            if not (samllToBigVisited[i] or bigToSamllVisited[i]):
                state = False
                break
        
        if state:
            count += 1
    
    print(f'#{test_case} {count}')



