function solution(tickets) {
    var answer = [];
    
    // 1. 공항별로 방문표시를 해야함. 그러기 위해서는 index로 만들어줘야함 
    // false로 이루어진 tickets length만큼 
    let visited = new Array(tickets.length).fill(false);
    console.log(visited)
    
    // DFS 알고리즘을 구현한다. [현재 시작할 위치, 현재까지 이동한 경로]
    const dfs = (start, path) => {
        //만약 현재까지 이동한 경로가 모든 티켓을 사용한 경로라면
        if (path.length === tickets.length+1) {
            answer.push(path); // 결과 배열에 추가
            return;  // 해당 경로는 찾았으므로 dfs 종료
        }
        
        // 아직 티켓 다 안쓰고 경로를 모두 탐색 못했다면
        // 티켓을 1번부터 하나씩 불러온다.
        tickets.forEach( (ticket, index) => {
            // 아직 방문 안했고, 현재 출발지와 같은 티켓이라면
            if (!visited[index] && start === ticket[0]) {
                // 현재 경로 방문 처리
                visited[index] = true;
                // 이 경로로 dfs 추가 진행
                dfs(ticket[1], [...path, ticket[1]]) // 해당 티켓으로 도착한 뒤 dfs 진행하도록 
                // 이동 다찍었으면 방문처리 해제
                visited[index] = false;
            } 
            
        })
        
        
    }
    
    // 처음 출발지, 경로 시작 (첫 위치는 무조근 ICN시작)
    dfs("ICN", ["ICN"]);
    
    // 결과 경로들을 정렬해서, 제일 앞에 있는 친구를 반환
    answer.sort();
    
    
//     1. 첫 경로는 무조건 ["ICN"] 으로 시작한다
//     2. 하나 경로를 정해서 뒤로 쭉쭉 dfs한다
//     2.1. 다시 경로 다돌았으면 방문 해제
    
    return answer[0];
}