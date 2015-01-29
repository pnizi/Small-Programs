__author__ = 'Piotr'

#To run: call the create(num) method in the python shell
#Tried using the post on piazza to make it runnable from cmd line but had
#no success.
import random
import re

file = open('grammer.txt', 'r')
list = []
for line in file:
    m = re.findall("ROOT|S|NP|VP|PP|Noun|DT|Verb|Adj|Prep][^ \t\n\r\f\v].*", line)
    m = re.sub('1|\\n|\\t', ' ', line)
    if m:
        list.append(m)
            
d = {}
for k, v in (s.lstrip().split(' ', 1) for s in list if ' ' in s.lstrip()):
    if k in d:
        d[k] += '|' + v
    else:
        d[k] = v

for (cat, rhs) in d.items():
    d[cat] = [alt.split() for alt in rhs.split('|')]



def gen(s):
    if s not in d:
        return s
    else:
        return ' '.join(map(gen, random.choice(d[s])))


def create(num):
    sent = ''
    for num in range(0, num):
        x = gen('ROOT')
        sent = sent+'\n\n'+x
    return print(sent)
