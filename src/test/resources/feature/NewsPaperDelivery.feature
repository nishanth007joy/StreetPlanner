
Feature: News Paper Delivery Report
  
  Scenario Outline: News paped delivery report
    Given Input file is placed in input folder with "<input content>" content
    When  street file is processed with program input arument as "--action=NEWS_PAPER_DELIVERY_REPORT"
    Then  show file as valid with details of north south delivery as "<Delivery sequence	North South>"
    And  North south roas crossing as  <No of road corssing	North South>
    And   East west delivery sequence as "<Delivery sequence	East West>"
    And   East west road crossing as <No of road corssing	East West>
    
 
  Examples:
    | input content 											|	Delivery sequence	North South				|	No of road corssing	North South	|	Delivery sequence	East West			  	|	No of road corssing	East West	|
    | 1 2 4 3 6 5 7 8 9 10 12 11 13 15 14	| 1 3 5 7 9 11 13 15 14 12 10 8 6 4 2	|									1								|1 2 4 3 6 5 7 8 9 10 12 11 13 15 14	|								9								|
    

