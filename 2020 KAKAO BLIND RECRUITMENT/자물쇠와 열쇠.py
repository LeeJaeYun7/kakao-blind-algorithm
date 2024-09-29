import copy

answer = False 
    
def isOpenable(currBoard, currKey, row, col, N, M):
        
    global answer
    
    for i in range(row, row+M):
        for j in range(col, col+M):
            if N<=i and i<(2*N) and N<=j and j<(2*N):
                if currBoard[i][j] == 0 and currKey[i-row][j-col] == 0:
                    return 

            if currBoard[i][j] == 1 and currKey[i-row][j-col] == 1:
                return 
            
            if currBoard[i][j] == 0 and currKey[i-row][j-col] == 1:
                currBoard[i][j] = 1 
    
    allOne = True
    
    for i in range(N, 2*N):
        for j in range(N, 2*N):
            if currBoard[i][j] == 0:
                allOne = False
                return 
                
    
    if allOne == True:
        answer = True 
    
def rotated(array_2d):
    list_of_tuples = zip(*array_2d[::-1])
    return [list(e) for e in list_of_tuples]


def solution(key, lock):
    currKey = []

    N = len(lock)
    M = len(key)

    board = [[0]*(3*N) for _ in range(3*N)]

    for i in range(N,2*N):
        for j in range(N, 2*N):
            board[i][j] = lock[i-N][j-N]

    row = N-M+1
    col = N-M+1

    tmpBoard = copy.deepcopy(board)  
        
    while True:
      
        currKey = []

        for i in range(4):

            if i == 0:
                currKey = copy.deepcopy(key)
            else:
                tmpKey = rotated(currKey) 
                currKey = copy.deepcopy(tmpKey)

            currBoard = copy.deepcopy(tmpBoard)    
            isOpenable(currBoard, currKey, row, col, N, M)
        
        if answer == True:
            return answer 

        col += 1 

        if col == (2*N):
            row += 1 
            col = N-M+1

        if row == 2*N:
            break 
    
    return answer
    
