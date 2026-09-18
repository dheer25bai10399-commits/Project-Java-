# UML Notes

## Use Case Diagram

```text
             +---------------------------+
             | Student Grade Management  |
             +---------------------------+
 Teacher --->| Add Student               |
 Teacher --->| View Students             |
 Teacher --->| Update Student            |
 Teacher --->| Delete Student            |
 Teacher --->| Enter Marks               |
 Teacher --->| Calculate Result          |
 Teacher --->| Search Student            |
 Teacher --->| Generate Class Report     |
 Teacher --->| Save / Load Records       |
             +---------------------------+
```

## Class Relationship

```text
Student <|-- GraduateStudent

GradeCalculator <|.. GradeService

Main --> GradeService
Main --> FileManager
Main --> ReportThread
GradeService --> Student
ReportThread --> GradeService
```

## Sequence for calculating a result

```text
User -> Main: Select Calculate Result
Main -> GradeService: findStudent(id)
GradeService -> Main: Student object
Main -> GradeService: showResult(student)
GradeService -> Student: getMarks()
Student -> GradeService: marks
GradeService -> GradeService: total / average / grade
GradeService -> Main: result
Main -> User: Display result
```
