#!/bin/env python
import random

cmds = ["front", "back", "at", "print", "printr", "ifront", "iback", "iat", "rfront", "rback", "rat", "size", "empty" ]

opCnt = random.randrange(500000)
opCnt = 1500

with open("input_random.txt", "w") as f:
    for i in range(0, opCnt):
        op = random.randrange(len(cmds))
        cmdStr = cmds[op]
        # different cmds take different sets of parameters
        if cmds[op] == "at" or cmds[op] == "iat" or cmds[op] == "rat" or cmds[op] == "ifront" or cmds[op] == "iback":
            cmdStr += " " + str(random.randrange(10000))
        if cmds[op] == "iat":
            cmdStr += " " + str(random.randrange(50))
        cmdStr += '\n'
        f.write(cmdStr)

