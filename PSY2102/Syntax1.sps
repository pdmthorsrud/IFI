compute answer = 99.
missing values answer (99).
execute.

if SRMeetingResponse = "Monday" answer = 0.
if SRMeetingResponse = "Friday" answer = 1.
value labels answer 0 "Monday" 1 "Friday".
execute.

compute condition = 99.
missing values condition (99).
execute.

if SRCondition = "A" condition = 1.
if SRCondition = "B" condition = 2.
if SRCondition = "C" condition = 3.
value labels SRCondition 1 "A" 2 "B" 3 "C".
execute.



compute filter = 1.
execute.
if SRCondition = "C" filter = 0.
if SRCondition = "NA" filter = 0.
execute.

use all.
filter by filter.
execute.


if SRCondition = " b" SRCondition = "B".
if SRCondition = "a" SRCondition = "A".
if SRCondition = "b" SRCondition = "B".
if SRCondition = "c" SRCondition = "C".
execute.


FREQUENCIES VARIABLES=SRCondition answer
  /ORDER=ANALYSIS.

CROSSTABS
  /TABLES=SRCondition BY answer
  /FORMAT=AVALUE TABLES
  /STATISTICS=CHISQ 
  /CELLS=COUNT ROW 
  /COUNT ROUND CELL.

GRAPH
  /LINE(SIMPLE)=MEAN(answer) BY SRCondition.

GRAPH
  /PIE=PCT BY answer
  /PANEL COLVAR=SRCondition COLOP=CROSS.

*the following three analysis are strictly speaking not OK, because they assume a normally distributed continuous DV. Our DV is nominal instead.
*so this is just for demonstration, assuming our DV would be continuous and normally distributed.

T-TEST GROUPS=SRCondition('A' 'B')
  /MISSING=ANALYSIS
  /VARIABLES=answer
  /CRITERIA=CI(.95).

*the following uses condition (defined above) instead of SRCondition because SRCondition is a string variable, and here only numeric variables work.

ONEWAY answer BY condition
  /MISSING ANALYSIS.

REGRESSION
  /MISSING LISTWISE
  /STATISTICS COEFF OUTS R ANOVA
  /CRITERIA=PIN(.05) POUT(.10)
  /NOORIGIN 
  /DEPENDENT answer
  /METHOD=ENTER condition.


*now separate for site, in two versions.

use all.
filter by filter.
execute.

CROSSTABS
  /TABLES=condition BY answer BY Site
  /FORMAT=AVALUE TABLES
  /STATISTICS=CHISQ CC
  /CELLS=COUNT
  /COUNT ROUND CELL
  /BARCHART.


SORT CASES  BY Site.
SPLIT FILE LAYERED BY Site.
CROSSTABS
  /TABLES=SRCondition BY answer
  /FORMAT=AVALUE TABLES
  /STATISTICS=CHISQ 
  /CELLS=COUNT ROW 
  /COUNT ROUND CELL.
split file off.




