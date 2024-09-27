def solution(id_list, report, k):
    answer = []
    
    result1 = set(report)
    result2 = list(result1)
    check = dict() 
    banned = [] 
    received = dict() 
    
    for tmp in result2: 
        splits = tmp.split(" ")
        
        if splits[1] in check:
            check[splits[1]] += 1 
        else:
            check[splits[1]] = 1 
    
    for key, value in check.items():
        if value >= k:
            banned.append(key)
            
    for id in id_list: 
        received[id] = 0 
            
    for tmp in result2: 
        splits = tmp.split(" ")
        
        if splits[1] in banned:
             received[splits[0]] += 1
     
     
    for id in id_list: 
        answer.append(received[id])
        
    
    return answer
