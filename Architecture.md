# Architecture

The project uses a simple package-based structure.

```text
Main
 |
 +-- model
 |    +-- Student
 |    +-- GraduateStudent
 |    +-- Grade
 |
 +-- service
 |    +-- GradeCalculator
 |    +-- GradeService
 |
 +-- exception
 |    +-- InvalidMarksException
 |
 +-- util
 |    +-- FileManager
 |
 +-- thread
      +-- ReportThread
```

## Data flow

User input -> Main -> GradeService / FileManager -> Student objects -> Output

The program keeps the student objects in an `ArrayList`. FileManager handles permanent storage in a plain text file.
