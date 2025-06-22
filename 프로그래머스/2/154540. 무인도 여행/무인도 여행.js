
function solution(maps) {
    var answer = [];
    // * 지도 배열 형태로 매핑, 문자열숫자 -> 숫자, X는 그대로 문자 
    maps = maps.map((item) => item.split('').map((item) => {
        return isNaN(item) ? item : +item
    }));

    let food = 0;
    // 중첩함수 (maps는 바깥(상위) 스코프에 있으므로 그대로 접근할 수 있습니다.)
    const dfs = (row, col) => {
        // 현재 위치가 벽이면 return 0
        if (row < 0 || row >= maps.length || col < 0 || col >= maps[0].length) {
            return false;
        }

        // 현재 위치가 벽이면 return 0
        if (maps[row][col] === 'X') {
            return false;
        }
        
        // food 값 추가
        food += maps[row][col];
        maps[row][col] = 'X'; // 방문 처리
        
        // 상, 하, 좌, 우 dfs 순회 
        const dRow = [-1, 1, 0, 0]; // 상, 하 , 좌, 우 선언
        const dCol = [0, 0, -1, 1];
        
        for (let i = 0; i < 4; i++) {
            dfs(row + dRow[i], col + dCol[i], food + maps[row][col]);
        }
    }
    
    food = 0;
    for (let i = 0; i < maps.length; i++) {
        for (let j = 0; j < maps[i].length; j++) {
            dfs(i,j);
            if (food > 0) {
                answer.push(food);
            }
            food = 0; // 한번 순회 다 돌았으니 다시 식량 초기화
        }
    }

    if (answer.length > 0) {
        return answer.sort((a,b) => a-b);
    } else {
        return [-1];
    }
    return answer;
}



