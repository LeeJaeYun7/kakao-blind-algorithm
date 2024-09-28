def solution(s):
    
    totalLen = len(s)
    minLen = 1e9 

    for i in range(1, totalLen+1):

        length = i 
        curr = ""
        start = 0
        end = i
        stack = []
        cnt = 1 
        result = ""

        while start < totalLen:
            curr = s[start:end]

            if len(stack) == 0:
                stack.append(curr)
            else:
                if stack[-1] == curr:
                    cnt += 1 
                else:
                    if cnt == 1:
                        latest = stack[-1]
                        result += latest
                    else:
                        latest = stack[-1]
                        result += str(cnt)
                        result += latest 

                    cnt = 1  

                stack.append(curr)

            start += length
            end += length 

        if cnt == 1:
            latest = stack[-1]
            result += latest
        else:
            latest = stack[-1]
            result += str(cnt)
            result += latest 

        if minLen > len(result):
            minLen = len(result)

    return minLen
