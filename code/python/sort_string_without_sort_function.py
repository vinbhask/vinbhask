import os
import sys



def quicksort(lst):
    if not lst:
        return []
    return (quicksort([x for x in lst[1:] if x <  lst[0]])
            + [lst[0]] +
            quicksort([x for x in lst[1:] if x >= lst[0]]))

if __name__=="__main__":
    unsort_list = ['B', 'D', 'A', 'E', 'C']
    print([x for x in unsort_list[1:] if x <  unsort_list[0]]+ [unsort_list[0]]+[x for x in unsort_list[1:] if x >= unsort_list[0]])
    sort_list   = quicksort(unsort_list)
    #print(sort_list)