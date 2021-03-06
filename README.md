# TimeToDecimalConverter
Tiny program with simple GUI built specifically to convert all HH:MM:SS time formats to decimal (in hours) format in .csv files.
It's only dependency is on JUnit 4.8.2.

## To install:
  * Pull down into any IDE with Maven plugin (or just clone the URI and use Maven manually), package, and go.
  
## Use:
  * While this program is designed only for .csv files, other types of files shouldn't break it -- they just won't be processed.
  * Otherwise, the GUI is pretty straightforward; it accepts one or multiple .csv files and will ignore any other file type, informing the user that an invalid file type was detected.
  * This application was meant for use with spreadsheets (Excel, OpenOffice, etc...).  Since there were no convenient ways to re-format this type of data (and it could not be provided to me in decimal form by the software we use), I created this.  That way data of this type would still be kept in place for easy data manipulation/aggregation, but formatted in decimal.  Normally, a simple Python script would be all that is necessary to do this, but I designed a simple GUI to make it more accessible to my colleagues.
  
## Plans for Future Updates:
  * As soon as I'm able, I'd like to adjust the GUI to automatically re-size itself when the Add All menu appears and disappears.
  * Other types of time formats do exist, but for the scope of this program (and my use of it), only the one is used.  Other types
    could be planned for in the future.
  * Other file types may be feasible, but I have yet to consider them.
  
## Current Status:  V1.3 Released, V1.4 On Hold
