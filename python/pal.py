#!/usr/local/bin/python3
forbidden= ( "'", "?", "!", " " , "$", "," )

def isPal(txt):
    rtxt = txt[::-1]
    if txt.lower() == rtxt.lower() :
        print ("It's a palendrome");
    else :
        print ("It's not a palendrome");

def process(txt):
    newStr=""
    for c in txt :
        if c in forbidden :
            continue;
        else :
            newStr+=c;
    isPal(newStr)

inp = input(" Enter Text ")
process(inp);
