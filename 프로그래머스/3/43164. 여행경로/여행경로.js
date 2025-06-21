// 1. 항상 ICN 공앙에서 출발 ( 출발지 리스트)
//2. tickest 배열에서 방문하는 공항 경로를 DFS로 탐색하여 리턴
//ticket은 [출발 -> 도착] 임 
// A의 도착지, B의 출발지가 같아야 그 경로로 탐색 가능

function solution(tickets) {
    var answer = [];
    //* 각 티켓당 방문했는지 확인할 수 있어야 한다. 
    let visited = new Array(tickets.length).fill(false); // A,B,C,D 공항 
    
    // * dfs로 현재 출발지, 경로를 저장해야함 
    const dfs = (start, path) => {
        // 모두 나온 경로가 모두 방문했다면, 경로 추가
        if (path.length === tickets.length+1) {
            answer.push(path);
            return; // 해당 분기는 끝.
        }
        
        // 티켓을 순회하면서 방문 안한곳이고, 현재 출발지가 될 곳과 동일한 출발지라면, 그 경로로 dfs
        tickets.forEach((ticket, index) => {
            if (!visited[index] && start === ticket[0]) {
                //현재 위치를 방문 처리!
                visited[index] = true;
                //그 경로로 dfs
                dfs(ticket[1], [...path, ticket[1]]);
                // * dfs가 종료되면, 방문을 끝낸다. ( 다른 경로로도 dfs 해야하므로)
                visited[index] = false;

            }

        });
    }
    
    dfs("ICN", ["ICN"]); //ICN경로!

    
    return answer.sort()[0];
}