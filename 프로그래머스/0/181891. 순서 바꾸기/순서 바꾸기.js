function solution(num_list, n) {
     
    let n_prev_list = num_list.slice(0,n);
    let n_curr_list = num_list.slice(n);
    
    return  [...n_curr_list, ...n_prev_list];
    
}