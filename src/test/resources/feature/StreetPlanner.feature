
Feature: Street File Processor
  
  Scenario Outline: AC1. that the file is valid.
    Given Input file is placed in input folder with "<input content>" content
    When street file is processed with program input arument as "--action=VALIDATE_AND_PROCESS" 
    Then show output file valid as "<file valid>"
    And  House number as <house number>
    And  North house number as <North house  number>
    And  South house number as <South house number>
    
      Examples:
    | input content 											|	file valid	| house number	|	North house  number	|	South house number	|
    | 1 2 4 3 6 5 7 8 9 10 12 11 13 15		| House number cannot be missing bwteen start and end house number			|			0					|				0							|					0						|
    | 1 2 4 3 6 5 7 8 9 10 12 11 13 15 14	|  						|			15				|				8							|					7						|
    		

