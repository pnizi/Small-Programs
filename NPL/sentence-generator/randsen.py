__author__ = 'Piotr'

import random

def Grammar(**gram):
  for (cat, rhs) in gram.items():
    gram[cat] = [alt.split() for alt in rhs.split('|')]
  return gram
  
gram = Grammar(
  S  = 'NP VP',
  VP = 'Verb NP',
  NP = 'DT Noun | NP PP',
  PP = 'Prep NP',
  Noun = 'Adj Noun | president | sandwich | pickle | chief of staff | floor',
  DT = 'the | a | every',
  Verb  = 'ate | wanted | kissed | understood | pickled',
  Adj = 'fine | delicious | perplexed | pickled',
  Prep = 'with | on | under | in'
  )

def gen(s):
  if s not in gram:
    return s
  else:
    return ' '.join(map(gen, random.choice(gram[s])))


