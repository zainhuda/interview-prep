def sockMerchant(n, ar):
    if (n == 1):
        return 0
    dict = {}
    for value in ar:
        if value in dict:
            dict[value] += 1
        else:
            dict[value] = 1
    k = 0
    for sock in dict:
        if dict[sock]//2 > 0:
            k = k + dict[sock]//2
    return k