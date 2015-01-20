__author__ = 'Piotr'
#
#
#
#
#
#
#
import re

S='NP VP'
VP='Verb NP'
NP='DT Noun'
NP2='NP PP'
PP='Prep NP'
Noun='Adj Noun'

file=open('file.txt')
for line in file:
    if re.search('ROOT',line):
        print(line,end='')