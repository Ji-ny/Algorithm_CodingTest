import heapq



T = int(input()) # 테케 


for test_case in range(1, T+1):
    N, M = map(int, input().split(' ')) # 학생 수 N, 순서 수 M

    graph = [[] for _ in range(N+1)] # 0번 노드 제외! 인접 리스트 
    indegree = [0] * (N + 1) # 진입차수 배열 

    for _ in range(M):
        start, end = map(int, input().split())
        graph[start].append(end) # a -> b (a 앞, b 뒤)
        indegree[end] += 1 # b 앞에 있어야할 학생이 하나 늘어났다. 

    # 시작점 찾기 (indegree == 0)
    heap = []
    # indegree가 0인 학생들 (앞에 아무도 없는 애들)을 우선순위 큐에 넣는다.
    # heapq는 최소 힙이므로, 번호가 작은 학생이 먼저 나오게 된다.
    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, i)
    
    # *위상 정렬 (줄 세우기)

    result = []
    while heap:
        cur = heapq.heappop(heap) # 현재 줄을 세울 학생
        result.append(cur)
        
        # 그 학생 뒤에 서야 하는 학생들의 indegree를 줄여준다. (간선 제거!)
        for nextPerson in graph[cur]:
            indegree[nextPerson] -= 1
            # indegree가 0이 되면 줄을 설 수 있으니, 다시 힙에 넣어준다.
            if indegree[nextPerson] == 0:
                heapq.heappush(heap, nextPerson)


    print(f'#{test_case} {" ".join(map(str,result))} ')