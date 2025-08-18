from collections import deque

def solution(maps):
    answer = 0
    
    array = []
    queue = deque([])
    
    # 1. maps를 2차원 배열로 만든다
    for item in maps:
        print(list(item))
        array.append(list(item))
    
    N = len(maps)
    M = len(array[0])
    
    start = (0,0) # row, col 시작 지점
    exit = (0,0) # row, col 시작지점 
    lever = (0,0) # row, col 시작 지점
    
    # 2. 시작 지점을 찾는다. 
    for row in range(N):
        for col in range(M):
            if array[row][col] == 'S': # 시작 지점 값 저장 
                start = (row, col)
            elif array[row][col] == 'E': # 종료 지점 값 저장
                exit = (row, col)
            elif array[row][col] == 'L': # 레버 지점 값 저장
                lever = (row, col)
    
    # 3. 시작지점부터 시작한다.   
    # print(queue)
    
    StoL = -1 # 시작부터 레버까지 
    LtoE = -1 # 레버부터 종료까지
    
    # 상,하,좌,우 이동
    dRow = [-1, 1, 0, 0]
    dCol = [0, 0, -1, 1]
    
    visited = [[0] * M for i in range(N)] # 방문 처리 배열 
    # print(visited)
    # 시작부터 레버까지 BFS
    queue.append(start) # 시작 지점 추가 
    while queue: # queue에 좌표가 있을때까지
        row, col = queue.popleft() # 현재 기준 위치 저장 
        
        for i in range(4):
            nowRow = row + dRow[i]
            nowCol = col + dCol[i]
            
            # 만약 범위 벗어나면 정지
            if nowRow >= N or nowRow < 0 or nowCol >= M or nowCol < 0:
                continue
            
            # 만약 '벽'이면 정지
            if array[nowRow][nowCol] == 'X':
                continue
            
            # 만약 이미 방문했다면 패스 
            if visited[nowRow][nowCol] != 0:
                continue
            
            # 방문처리 
            visited[nowRow][nowCol] = visited[row][col] + 1
            
            # 현재 위치 queue에 추가 
            queue.append((nowRow, nowCol))
            
            # 만약 현 위치가 레버라면, 정지!
            if array[nowRow][nowCol] == 'L':
                StoL = visited[nowRow][nowCol] # 값 저장 
                break
    # BFS로 레버까지 갔는데도 못찾았다면
    if StoL == -1:
        return -1
    
    # for i in visited:
    #     print(i)
            
        
    # 레버부터 종료까지 BFS
    queue = deque([])
    queue.append(lever) # 시작 지점 추가 
    visited = [[0] * M for i in range(N)] # 방문 처리 배열 
    
    while queue: # queue에 좌표가 있을때까지
        row, col = queue.popleft() # 현재 기준 위치 저장 
        
        for i in range(4):
            nowRow = row + dRow[i]
            nowCol = col + dCol[i]
            
            # 만약 범위 벗어나면 정지
            if nowRow >= N or nowRow < 0 or nowCol >= M or nowCol < 0:
                continue
            
            # 만약 '벽'이면 정지
            if array[nowRow][nowCol] == 'X':
                continue
            
            # 만약 이미 방문했다면 패스 
            if visited[nowRow][nowCol] != 0:
                continue
            
            # 방문처리 
            visited[nowRow][nowCol] = visited[row][col] + 1
            
            # 현재 위치 queue에 추가 
            queue.append((nowRow, nowCol))
            
            # 만약 현 위치가 레버라면, 정지!
            if array[nowRow][nowCol] == 'E':
                LtoE = visited[nowRow][nowCol] # 값 저장 
                break
    if LtoE == -1:
        return -1
    # for i in visited:
    #     print(i)
        
    return StoL + LtoE