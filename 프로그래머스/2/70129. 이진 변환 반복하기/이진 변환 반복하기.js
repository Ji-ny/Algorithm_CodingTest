function solution(s) {
    var answer = [];
    let zero = 0; // 제거된 0의 수
    let count = 0; // 변환 횟수
    
    while (s != "1") {
        // 1. 0을 제거하고, 다시 문자로 합친다.
        s = s.split('').filter((item) => {
            if (item == "0") {
                zero++; // 제거할 0 추가
            } else { // 1이면 추가 
                return item;    
            }
            }).join(""); // "1111"
        // s의 길이를 2진법으로 표현한다.
        s = s.length.toString(2);
        // 3. 변환횟수 추가
        count++;
     }
    return [count, zero];
}