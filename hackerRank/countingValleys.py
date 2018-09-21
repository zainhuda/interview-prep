def countingValleys(n, s):
    n = 0
    valleyCounter = 0
    for step in s:
        if step == 'U':
            k = n
            n += 1
            if (k == -1 and n == 0):
                valleyCounter += 1
        else:
            n -= 1
    return valleyCounter