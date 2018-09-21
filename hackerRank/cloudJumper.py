def jumpingOnClouds(c):
    jumpCounter = 0
    position = 0
    length = len(c)
    while(True):
        if length > 2:
            if c[position+2] == 0:
                jumpCounter += 1
                position += 2
                if length-1 == position:
                    break
                elif length-2 == position:
                    jumpCounter += 1
                    break
            else:
                jumpCounter += 1
                position += 1
                if length-1 == position:
                    break
                elif length-2 == position:
                    jumpCounter += 1
                    break
        else:
            jumpCounter += 1
            break
    return jumpCounter