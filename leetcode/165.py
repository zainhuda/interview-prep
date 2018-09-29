class Solution:
    def compareVersion(self, version1, version2):
        a = [int(x) for x in version1.split(".")]
        
        b = [int(x) for x in version2.split(".")]
        
        for i in range(max(len(a),len(b))):
            v1Val = a[i] if i < len(a) else 0
            v2Val = b[i] if i < len(b) else 0
            if v1Val > v2Val:
                return 1
            elif v2Val > v1Val:
                return -1
        return 0
        
