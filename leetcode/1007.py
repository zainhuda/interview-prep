class Solution(object):
    def minDominoRotations(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        swapA = 0 
        swapB = 0
        flagA = True
        flagB = True
        
        if len(A) != len(B):
            return -1
        
        for i in range(len(A)):
            if A[i] == A[0] or B[i] == A[0]:
                if B[i] != A[0]:
                    swapB += 1
                if A[i] != A[0]:
                    swapA += 1
            else:
                flagA = False
                break
          
        
        if flagA:
            print(swapA, swapB)
            return min(swapA, swapB)
        swapA = 0
        swapB = 0
        for i in range(len(A)):
            if A[i] == B[0] or B[i] == B[0]:
                if B[i] != B[0]:
                    swapB += 1
                if A[i] != B[0]:
                    swapA += 1
            else:
                flagB = False
                break
        
        if flagB:
            print(swapA, swapB)
            return min(swapA, swapB)
     
        return -1