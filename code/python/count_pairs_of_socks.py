import os
import sys
from collections import Counter

def get_result():
    socks, pairs = Counter(map(int, input().strip().split())), 0
    for s in socks: pairs += socks[s] // 2
    print(pairs)


# Driver code
if __name__ == "__main__":
    #l = [1,2,1,2,1,3,2]
    l=[10, 20, 20, 10, 10, 30, 50, 10, 20]
    n=9
    l.sort()
    #print(l)
    count = 0
    index=0
    for i in range(len(l)):
        if(index+1)>=n: break
        if l[index] == l[index + 1]:
            #print(str(l[index])+'----'+str(l[index+1]))
            count += 1
            index+=2
            #print(str(index)+'----'+str(count))
        else:
            # print("index without match: "+str(index))
            # print(str(l[index] )+ '----' + str(l[index + 1]))
            # print(str(index) + '----' + str(count))
            index+=1
    print(count)
    get_result()