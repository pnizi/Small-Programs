__author__ = 'Piotr'

import re

file = open('file.txt', 'r')
list = []
for line in file:
    m = re.findall("[S|ROOT|NP|VP|PP|Noun|DT|Verb|Adj|Prep][^ \t\n\r\f\v].*", line)
    m = re.sub('1|\\n|\\t', ' ', line)
    if m:
        list.append(m)

d = {}
for k, v in (s.lstrip().split(' ', 1) for s in list if ' ' in s.lstrip()):
    if k in d:
        d[k] += '|' + v
    else:
        d[k] = v

print(d)

