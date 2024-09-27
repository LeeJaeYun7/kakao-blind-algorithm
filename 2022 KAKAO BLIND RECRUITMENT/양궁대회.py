
maxGap = -1e9
answer = [] 

def dfs(curr, pos, info, result):
    
    global maxGap
    global answer
    
    if curr == 0:
        apeachPoint = 0
        ryanPoint = 0
        
        for i in range(0, 11):
            if info[i] == result[i] == 0:
                continue
            if info[i] >= result[i]:
                apeachPoint += (10-i)
            else:
                ryanPoint += (10-i)
                
        if apeachPoint < ryanPoint:
            gap = ryanPoint -apeachPoint
            if maxGap < gap:
                maxGap = gap
                answer = result[:]    
            elif maxGap == gap:
                
                for i in range(10, -1, -1):
                    if answer[i] > result[i]:
                        break
                    elif answer[i] < result[i]:
                        answer = result[:]
        return 
    
    if pos == 11:
        return 
    
    target = info[pos]
    
    for i in range(target+1, -1, -1):
        if curr >= i:
            result[pos] = i
            dfs(curr-i, pos+1, info, result)
            result[pos] = 0

def solution(n, info):
    
    result = [0]*11
    
    dfs(n, 0, info, result)
    
    if len(answer) == 0:
        answer.append(-1)
    return answer
