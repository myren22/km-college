'''
Created on Apr 4, 2016

@author: Kyle
'''
import re;
from ohm import firstType, firstVal, secondType, secondVal, firstUnit
from ctypes.wintypes import BOOLEAN
from compiler.pyassem import DONE
#if __name__ == '__main__':
#    pass

print('hello world')

print('hello people')
print('Problem #%d:%c=%.2f%c' % (2, 'I', 0.452, 'A'))


string2 = "498results should get"
string1 = "Suspendisse E=.009kV potenti."
string3 = "A light-bulb yields P=100W and the voltage is E=220V. Compute the current, please."
#string5 = string3

int(re.search(r'\d+', string1).group())

print(string1)
print(float(re.search(r'\d+', string1).group()))
print(map(float, re.findall(r'\d+', string1)))
#print(('A'|'W'|'V'), string1)))


#first part variables
firstType = ''
firstVal = 0
firstUnit = ''

secondType = ''
secondVal = 0
secondUnit = ''

for g in string3:
    if '=' in g and firstType is '':
        firstType = index(g)
        print(firstType)
        firstVal
        done = False        

        
            
    if('=' in g and firstType != ''):
        secondType = g
        secondVal=g
    if('A' or 'W' or 'V' in g):
        firstUnit = g
        
print("1: % 2: % 3: % 4: % ", firstType, firstVal, firstUnit, secondVal)

#('A'|'W'|'V')



