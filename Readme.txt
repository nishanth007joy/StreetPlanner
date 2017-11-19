This application accepts input file to process in src/main/resources/streetfile/input/street1.txt
This is a spring boot now web application can be executed with main program. Main program neeed one program argument
--action=NEWS_PAPER_DELIVERY_REPORT    for newspaper delivery report
--action=VALIDATE_AND_PROCESS			for street file validation and grouping report

Output report is created in src/main/resources/streetfile/output/output.csv

Output file header is as below for street processing report

Validation error message,House number in street, North House number, South house number

Output file header is as below for news paper delivery report

News paper delivery sequence, Road crossing number

The above report contains two row one with approach one and approach 2