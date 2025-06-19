from collections import deque

def solution(begin, target, words):
    answer = 0
    
    # 1. 변환할 수 없는 경우는 0 return
    # -> 즉, words 안에 target이 없다면 0 리턴
    if target not in words:
        return 0    
    # bfs를 이용해서 step을 기록해서 
    # 1개만 다른 단어를 찾으면 queue에 넣고 변환과정을 넣는다
    # 이게참… 신기하단말이지 무한반복될줄 알았는데
    return bfs(begin, target, words)

def bfs(begin, target, words):
    queue = deque()
    queue.append([begin, 0]) # 큐 선언
    
    
    # 큐에 변환 가능한 단어가 있을때까지 무한반복
    while queue:
        # print(queue)
        # 단어와 현재 단계 저장
        now, step = queue.popleft() # 값 저장 (현재 단어, step)
        
        # 만약 현재 찾은 단어가 목표 단어라면, 반복 마무리 후 리턴
        if now == target:
            return step

        
        # words 배열을 순회하면서 단어 바꿔가면서 진행하기 
        for word in words:
            count = 0 # 같지 않은 단어 자리 개수 
            for i in range(len(word)):
                # 단어가 1개만 다르다면 그 단어 추가 
                if now[i] != word[i]:
                    count += 1
            
            # 만약 같지 않은 단어가 한개라면, (즉 나머지가 모두 일치하다면, 한 자리 단어만 바꿀수있음)
            if count == 1:
                # 큐에 바꾸게 될 값 추가
                queue.append([word, step+1]) # 그리고 다음 변환 단계로 진행
            
       
    return 0
    