
def solution(fees, records):
    answer = []
    timeMemory = dict() 
    total = dict() 
    totalFees = dict() 
    
    for record in records: 

        splits = record.split(" ")

        hour = int(splits[0].split(":")[0])
        minute = int(splits[0].split(":")[1])
        time = hour*60+minute

        carNum = int(splits[1])
        direction = splits[2]

        if direction == "IN":
            timeMemory[carNum] = time      
        else:
            if carNum in total:
                total[carNum] += (time-timeMemory[carNum])
            else:
                total[carNum] = time-timeMemory[carNum]

            timeMemory[carNum] = -1

    for key in timeMemory:     
        if timeMemory[key] != -1:
            if key in total:
                total[key] += (1439-timeMemory[key])
            else:
                total[key] = (1439-timeMemory[key])
                            
    for key in total:
        if total[key] <= fees[0]:
            totalFees[key] = fees[1]
        else:
            if (total[key]-fees[0]) % fees[2] == 0:
                totalFees[key] = fees[1] + ((total[key]-fees[0]) // fees[2])*fees[3] 
            else:
                totalFees[key] = fees[1] + (((total[key]-fees[0]) // fees[2])+1)*fees[3]
                
    totalFees = sorted(totalFees.items(), key=lambda x: x[0])    
    for key in totalFees:
        answer.append(key[1])
    

    return answer
