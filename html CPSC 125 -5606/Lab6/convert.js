function InchesToCentimeters(inches)
//Assumes: inches is a distance, measured in inches
//Returns: the corresponding distance in centimeters 
{
	var cm;
	
	cm = inches * 2.54;
	return cm;
}

function CentimetersToInches(cm)
//Assumes: cm is a distance, measured in centimeters
//Returns: the corresponding distance in inches 
{
	var inches;
	
	inches = cm / 2.54;
	return inches;
}

function PoundsToKilograms(lb)
//Assumes: lb is a weight, measured in pounds
//Returns: the corresponding weight in kilograms
{
	var kilograms;
	
	kilograms = lb * 2.205;
	return kilograms;
}

function KilogramsToPounds(kg)
//Assumes: kg is a weight, measured in kilograms
//Returns: the corresponding weight in pounds
{
	var pounds;
	
	pounds = kg/ 2.205;
	return pounds;
}

function SquareMetersToSquareFeet(msq)
//Assumes: msq is an area, measured in square meters
//Returns: the corresponding area in square feet 
{
	var squarefeet;
	
	squarefeet = msq / 10.764;
	return squarefeet;
}

function SquareFeetToSquareMeters(fsq)
//Assumes: fsq is an area, measured in square feet
//Returns: the corresponding area in square meters 
{
	var squaremeter;
	
	squaremeter = fsq * 10.764;
	return squaremeter;
}