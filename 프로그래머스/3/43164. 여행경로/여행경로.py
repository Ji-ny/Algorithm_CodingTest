# 항상 ICN 공항에서 출발한다
# tickets 배열을 순회하며, 공항 경로를 DFS로 탐색한다
# ticket 은 [출발-> 도착] 이므로, 현재 위치와 티켓의 출발지가 같다면 dfs로 다음 경로로 다시 탐색하게 한다
# dfs(start, end)

def solution(tickets):
    answer = []
    # 티켓의 방문 여부 배열 저장
    visited = [False] * len(tickets)
    
    # dfs 탐색 로직 작성
    def dfs(start, path):
        # 현재 모두 방문했다면? 
        if len(path) == len(tickets)+1:
            answer.append(path) # 경로 저장
            return # 현재 DFS 마무리
        
        # 티켓을 순회하며 갈 수 있는 항공편 탐색 
        for index, ticket in enumerate(tickets): 
            # 현재 목표 출발지와 티켓의 출발지가 같다면? && 아직 사용 안한 티켓이라면?
            if (start == ticket[0] and not visited[index]):
                # 현재 위치 방문 처리
                visited[index] = True
                
                # 현재 항공편으로 간뒤 다음 경로 탐색
                dfs(ticket[1], path + [ticket[1]])
                
                # dfs 끝나면 다시 다른 경로로 탐색해야하므로 방문처리 해제
                visited[index] = False
        
        
    dfs("ICN", ["ICN"]) ## 출발지, 현재 저장된 경로
    answer.sort()
    # print(answer)
    return answer[0]