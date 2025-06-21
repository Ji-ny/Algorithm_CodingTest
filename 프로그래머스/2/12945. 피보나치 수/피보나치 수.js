function solution(n) {
    var answer = 0;
    // console.log(fibo(5))
    let array = [0, 1];
    // 0~n까지 계산해서 더해보자
    for (let i = 2; i <= n; i++){
        let num = array[i-1] + array[i-2]
        array.push(num%1234567); // n번째 수 
        // 나머지 연산의 성질 (a + b) % m = ((a % m) + (b % m)) % m
    }
    
    // console.log(array)
    
    return array[n]%1234567
}

const fibo = (n) => {
    if (n <= 0) {
        return 0
    }
    
    
    if (n == 1 || n == 2){
        return 1;
    }
    
    return fibo(n-1) + fibo (n-2)
    
    // 0 1, 1, 2, 3, 5, 8
}