'''
Created on Apr 4, 2016

@author: Kyle
'''
'''
#equation types:
    #Power = I * E

    #I=XA    
    #E=XV
    #P=XW
    
    print("Problem #" probCount ":" resultType "=" resultVal resultUnit)
    print('Problem #%d:%c=%.2f%c' % (2, 'I', 0.452, 'A'))
    print('Problem #%d:%c=%.2f%c' % (probCount, resultType, resultVal, resultUnit))
    
    #X is a floating point Number
    #The prefixes m,k,M may appear before A, V, or W
    #'k' is number of the problem
    #'s' is the solution(either volts, power, or current)
    #no prefix, uses 2 decimals.
#'''
import re

def solve(listString):
    result = []
    if listString == result:
        return result
    
    #run for each string in list
    for z in listString:
        eV = -1;
        iV = -1;
        pV = -1;
        
        for g in z:
            if('=' in z[g]):
                
                if(z[g-1] == 'P'):
                    pV =  2 #getValue(z, g)
                
        
                                
        if(eV == -1):
            eV = calculatePI(pV, iV);
            print("Problem #", z, ":E=", eV, "V");
            continue;
        #elif
        if(iV == -1):
            iV = calculatePE(pV, eV);
            print("Problem #", z, ":I=", iV, "A");
            continue;
        #else
        if(pV == -1):
            pV = calculateEI(eV, iV);
            print("Problem #", z, ":P=", pV, "W");
            continue;
        
    return result

currentString = "A light-bulb yields P=100W and the voltage is E=220V. Compute the current, please."
equalCount = 0
strIncrementer = 0

#first part variables
firstType = ''
firstVal = 0
firstUnit = ''

secondType = ''
secondVal = 0
secondUnit = ''

#                "blah blah blah I=2A blah blah blah P=2.5MW blah blah" ]

#while equalCount < 2:
#    if currentString[strIncrementer] == '=':
#        if equalCount = 0:
#            firstType = currentString[strIncrementer-1]
            #store  everything from strIcrementer+1 to a char.
            #store prefix if found
                #m, M, k,
            #take unit
        



#def getValue(string, location):
    #while string[location+incrementer] == :
     #   if 


#3 types of calculations P=I*E
#given E and I. Energy(Volts) and Current(I, amps)
def calculateEI(eValue, iValue):
    result = eValue * iValue;
    return result;
    
#given P and E. Power(Watts) and Energy(Volts)
def calculatePE(pValue, eValue):
    result = pValue / eValue;
    return result;
    
#given P and I. Power(Watts) and Current(I, amps)
def calculatePI(pValue, iValue):
    result = pValue / iValue;
    return result;













