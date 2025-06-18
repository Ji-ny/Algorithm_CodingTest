function solution(begin, target, words) {
    var answer = 0;
    // target이 words 내부에 없는 경우는 0 리턴
    console.log()
    if (!words.includes(target)) {
        return 0
    }
    
    return bfs(begin, target, words);
}

const bfs = (begin, target, words) => {
    // 시작 단어부터 queue에 넣고, step은 0으로 초기화한다.
    queue = [];
    queue.push([begin, 0]) // 시작 단어, 단계
    
    while (queue.length > 0) {
        [now, step] = queue.shift(); // 현재 단어, 단계 꺼내기
        
        if (now === target) { // 타겟과 같다면 마무리
            return step;
        }
        
        // 단어를 모두 체크하면서, 해당 단어가 변경될 수 있는지 확인한다.
        words.forEach((word) => {
            let count = 0; // 같지 않은 부분 개수
            for (let i = 0; i < now.length ; i++) {
                // 단어에 알파벳 한개씩 체크해서, 같지 않은 부분 카운팅
                if (now[i] !== word[i]) {
                    count++;
                }
            }
            
            // 바꿀 수 있는 단어가 나온다면, 큐에 값 추가
            if (count === 1) {
                queue.push([word, step+1])
            }
        })
        
    }
    
}
