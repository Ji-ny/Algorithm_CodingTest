def solution(tickets):
    answer = []
    visited = [False] * len(tickets)
    
    def dfs(start, path):
        if (len(path) == len(tickets) + 1): # 현재까지 이동한 경로가 모든 티켓을 다 사용한 경로라면, 결과에 path 저장 
            answer.append(path)
            return # 마무리 
        
        for idx, ticket in enumerate(tickets):
            if (ticket[0] == start) and (not visited[idx]): # 출발지랑 다음 위치 start 지점이 같다면 , 그리고 아직 방문 안한곳이라면
                visited[idx] = True
                dfs(ticket[1], path + [ticket[1]]) # 도착지로 저장 및 도착지로 이동 
                visited[idx] = False # 현재 위치 다시 안간걸로 저장  (dfs 끝까지 한 다음에 다른 경로 탐색해야함 )
    
    dfs("ICN", ["ICN"]) # 출발지와 경로
    
    answer.sort() # 최종적으로 도출된 정딥라스트 값을 알파벳 순서로 정렬할거
    
    return answer[0] # 제일앞 경로 출력