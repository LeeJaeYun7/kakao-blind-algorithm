import math

def isPrime(string):
    
    num = int(string)
    
    if num == 1:
        return False
    
    for i in range(2, int(math.sqrt(num))+1):
        if num % i ==0:
            return False
            
    return True 


def solution(n, k):
    
    res = ""

    while n != 0:

        remain = n % k 
        res += str(remain)

        n = n // k 
        
    res = res[::-1]

    answer = 0 

    tmp = ""

    for c in res:
        if c == '0':
            if tmp == '':
                continue
            res = isPrime(tmp)
            if res == True:
                answer += 1 
            tmp = ''
        else:
            tmp += c
        

    if tmp != '':
        res = isPrime(tmp)
        if res == True:
            answer += 1 
            
    return answer
