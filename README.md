# Student Grade Management System

## About the project

This is a small Java console application for managing student records and marks. I made it to practice the Java topics covered in Programming in Java.

The program stores student details, accepts marks for five subjects, calculates the result, and generates a simple class report.

## Main features

- Add, view, update and delete students
- Regular and Graduate student types
- Enter marks for five subjects
- Calculate total, average, grade and pass/fail status
- Search students using ID
- Generate a class report
- Save records to a text file
- Load saved records
- Handles invalid marks using a custom exception
- Uses a separate thread for the class report

## Java concepts used

- Classes and objects
- Constructors
- Encapsulation
- Inheritance
- Method overriding
- Interface
- Enum
- ArrayList
- Arrays
- Exception handling
- File handling
- Multithreading and synchronization
- Packages

## Project structure

```text
StudentGradeManagement
│
├── src
│   ├── Main.java
│   ├── model
│   │   ├── Student.java
│   │   ├── GraduateStudent.java
│   │   └── Grade.java
│   ├── service
│   │   ├── GradeCalculator.java
│   │   └── GradeService.java
│   ├── exception
│   │   └── InvalidMarksException.java
│   ├── util
│   │   └── FileManager.java
│   └── thread
│       └── ReportThread.java
│
├── data
│   └── students.txt
├── docs
├── report
├── statement.md
├── TestPlan.md
└── README.md
```

## How to run

You need JDK 17 or a later version.

From the project folder:

```bash
javac -d out src/Main.java src/model/*.java src/service/*.java src/exception/*.java src/util/*.java src/thread/*.java
java -cp out Main
```

You can also open the project in VS Code or IntelliJ IDEA and run `Main.java`.

## Grading rule used

The project uses the following simple grading rule:

| Average | Grade |
|---|---|
| 90-100 | A |
| 80-89 | B |
| 70-79 | C |
| 60-69 | D |
| 50-59 | E |
| Below 50 | F |

A student must also score at least 40 in every subject to pass.

## File storage

The Save Records option stores the data in:

`data/students.txt`

The file is plain text, so it is easy to check the saved records.

## Testing

Some basic cases are included in `TestPlan.md`.

## Author

Student project for CSE2006 Programming in Java.
