from collections import deque

def solution(begin, target, words):
    answer = 0
    
    # target이 words 내부에 없는 경우는 0을 리턴
    if target not in words:
        return 0
    
    return bfs(begin, target, words)

# 최소 단계를 찾아야하므로 BFS
def bfs(begin, target, words):
    queue = deque()
    queue.append([begin, 0]) # 시작 단어와 단계 0으로 초기화
    
    while queue:
        
        now, step = queue.popleft()
        # print(now, step)
        if now == target:
            return step
        
        # 단어를 모두 체크하면서, 해당 단어가 변경될 수 있는지 체크
        for word in words:
            # print('word', word)
            count = 0
            for i in range(len(now)): # 단어의 길이만큼 반복하여
                if now[i] != word[i]: # 단어에 알파벳 한개씩 체크
                    count += 1 # 같지 않은 부분만 추가
            
            if count == 1: # 바꿀 수 있는 단어 나오면 큐에 값 추가
                queue.append([word, step+1])
                # print(queue)
    