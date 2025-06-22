function solution(A,B){
    var answer = 0;
    // A는 작은순 
    // B는 큰순으로 aswer
    A.sort((a,b) => a-b);
    B.sort((a,b) => b-a);
    
    // console.log(A,B)
    
    A.forEach((item, index) => {
        answer += (item * B[index]);
    })

    return answer;
}