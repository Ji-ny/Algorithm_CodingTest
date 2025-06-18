function solution(n) {
    var answer = 0;
    
    for (let i = 1 ; i<=n; i++) {
        let sum = 0;
        for (let j = i; j<= (n+j)/2 ; j++) {
            sum += j;
            
            if (sum > n) {
                break;
            } else if (sum == n) {
                answer++;
                // break;
            }
            // n보다 크면 break
            // n과 같으면 answer +=1
        }
    }
    return answer;
}