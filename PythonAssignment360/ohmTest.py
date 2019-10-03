import unittest
import ohm

class Test(unittest.TestCase):

    def test00(self):
        inList   = []
        
        actual   = ohm.solve( inList )
        expected = []
        self.assertEqual( expected, actual );
    
    def test01(self):
        inList   = [ "E=1.59999kV I=5110mA" ]
        
        actual   = ohm.solve( inList )
        expected = [ "Problem #1:P=8175.95W" ]
        self.assertEqual( expected, actual );
    
    def test02(self):
        inList   = [ "If the voltage is E=200V and the current is I=4.5A, which power is generated?",
                     "A light-bulb yields P=100W and the voltage is E=220V. Compute the current, please.",
                     "blah blah blah I=2A blah blah blah P=2.5MW blah blah" ]
        
        actual   = ohm.solve( inList )
        expected = [ "Problem #1:P=900.00W",
                     "Problem #2:I=0.45A",
                     "Problem #3:E=1250000.00V" ]
        self.assertEqual( expected, actual );
    
    def test03(self):
        inList   = [ "What is the power consumed by a big transistor that has a current of I=1mA and a voltage of E=700V?",
                     "What is the power is required when is voltage E=1MV and current is I=1kA?",
                     "Fractal values for voltage E=1.111kV and current I=1.111kA are leading to what power?",
                     "For current I=7246.12365mA, and power P=23.23MW, the voltage is?",
                     "For voltage E=3284.124V, and I=3294.12362mA, the power is?",
                     "P=2.5MWI=2A" ]

        actual   = ohm.solve( inList )
        expected = [ "Problem #1:P=0.70W"   ,
                     "Problem #2:P=1000000000.00W",
                     "Problem #3:P=1234321.00W",
                     "Problem #4:E=3205852.00V",
                     "Problem #5:P=10818.31W",
                     "Problem #6:E=1250000.00V" ]
        self.assertEqual( expected, actual )

    def test04(self):
        inList   = [ "E=120V and I=5.36A. What is the reason for calculating p as W? I don\'t understand!",
                     "There was a p who has P=560W Which was destroyed by E=291.89V.",
                     "No chance of survival if P=111.11W and I=3.004A.",
                     "I=4.5AE=200V.",
                     "E=220VP=100.00W",
                     "PPPPPP=8484.000000WWWWWWIIIIII=200.000000AAAAAA" ]

        actual   = ohm.solve( inList )
        expected = [ "Problem #1:P=643.20W",
                     "Problem #2:I=1.92A",
                     "Problem #3:E=36.99V",
                     "Problem #4:P=900.00W",
                     "Problem #5:I=0.45A",
                     "Problem #6:E=42.42V" ]
        self.assertEqual( expected, actual )

    def test05(self):
        inList   = [
        '''
        Sed elit nibh, suscipit id pretium non, iaculis a lorem.\n 
        Donec eu elit venenatis, venenatis metus quis, tincidunt dolor. 
        Nunc non dui ipsum P=42W. Morbi blandit mi nec imperdiet finibus. 
        Quisque fringilla consequat nulla, ac dapibus enim mollis eget. 
        Aliquam sed congue tellus. 
        Suspendisse E=.009kV potenti. 
        Sed imperdiet vel nisl ut maximus. 
        Quisque vel dolor mauris.
        ''',
        '''
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
        Quisque eget sollicitudin velit, nec auctor odio. 
        Suspendisse dui mauris, laoreet quis velit nec, vehicula vehicula arcu. 
        Curabitur sed aliquet diam, sed cursus est. 
        Cras euismod, tortor ac congue pulvinar, ante est lacinia nisl, ut varius tortor felis in ligula. 
        Mauris ac est ex. Nullam eget pretium arcu. 
        Nullam laoreet sagittis justo quis luctus. 
        Praesent viverra tellus a nisl molestie, in commodo urna malesuada. 
        Maecenas sagittis sed elit nec tincidunt. 
        Fusce malesuada placerat ipsum eget malesuada. 
        Proin sed lobortis metus...I=2.009A...in tempor mattis dolor, eget imperdiet odio porttitor ac. 
        Curabitur ante leo, sodales non consectetur non, mollis et sem. 
        EEEEEE=8.420kVVVVV Donec non fringilla metus, in vestibulum mi. 
        Mauris venenatis elit eu nibh porta eleifend. 
        Nunc venenatis quam ultricies lacus viverra bibendum.
        ''',
        '''
        Suspendisse nec commodo odio. 
        Phasellus mattis libero sit amet arcu suscipit, tempor cursus elit laoreet. 
        Mauris augue velit, ornare eget blandit quis, sollicitudin et lectus. 
        Praesent condimentum orci eros, et vehicula nunc dictum a. 
        Quisque blandit I=.00432kA vulputate iaculis. 
        Vivamus aliquet interdum eros, quis euismod erat suscipit at. 
        Sed eget ante velit. 
        Nullam vestibulum, mi PP=837WW eget pulvinar lacinia, orci ligula vulputate risus, vel malesuada massa est in ante. 
        Donec fringilla massa a ante tempus, nec eleifend nibh vestibulum. 
        Phasellus mollis tempor neque, vel sagittis velit mollis eget. 
        Phasellus finibus quam non pulvinar malesuada. Nam at pretium erat, in tempus dui. 
        Nulla odio felis, ullamcorper quis ipsum maximus, scelerisque tristique tortor."
        '''
         ]

        actual   = ohm.solve( inList )
        expected = [ "Problem #1:I=4.67A",
                     "Problem #2:P=16915.78W",
                     "Problem #3:E=193.75V" ]
        self.assertEqual( expected, actual )
