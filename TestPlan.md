# Test Plan

| Test | Input / Action | Expected Result |
|---|---|---|
| 1 | Add a new student | Student is added |
| 2 | Add a student with an existing ID | Duplicate ID message is shown |
| 3 | Enter marks from 0 to 100 | Marks are saved |
| 4 | Enter a mark greater than 100 | Invalid marks message is shown |
| 5 | Enter a negative mark | Invalid marks message is shown |
| 6 | Calculate result | Total, average, grade and status are displayed |
| 7 | Search using an existing ID | Student details are displayed |
| 8 | Search using a wrong ID | Student not found message is shown |
| 9 | Update student name | Name is changed |
| 10 | Delete an existing student | Student is removed |
| 11 | Save records | Data is written to students.txt |
| 12 | Load records | Saved students are loaded |
| 13 | Generate class report | Report with class average and highest scorer is shown |
| 14 | Enter letters where a number is required | Program asks for a valid number |
| 15 | Run report with no students | No students message is shown |

## Result

The above cases can be used to check the main functions of the application before demonstration.
