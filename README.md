Library Management System

Overview:

The Library Management System is designed to manage books, authors, students, library cards, and transactions. 
The system provides endpoints for CRUD operations and allows for the issuance and return of books, managing library cards, 
and retrieving information about students, authors, and books.

Technologies Used: Spring Boot, JPA, Hibernate, MySQL, RESTful APIs, Java, Maven, Email Integration, Security

Controllers and Endpoints

Transaction Controller

PUT /transaction/returnBook
Handles the return of a book.
Request parameters: transactionId, bookId, returnDate

PUT /transaction/issueBook
Issues a book to a student.
Request parameters: transactionId, bookId, issueDate, studentId
Student Controller

PUT /student/update-student-details
Updates student details.
Request body: UpdateStudentRequest

POST /student/add
Adds a new student.
Request body: Student

GET /student/get-student-info
Retrieves information about a student.
Request parameters: studentId

GET /student/findAllStudents
Retrieves a list of all students.

Card Controller

PUT /card/associateCardWithStudent
Associates a library card with a student.
Request parameters: cardId, studentId

POST /card/add
Adds a new library card.
Request body: LibraryCard

Book Controller

PUT /book/associate-book-author
Associates a book with an author.
Request parameters: bookId, authorId

POST /book/add
Adds a new book.
Request body: Book

GET /book/recommend-highest-rated-type-genre
Recommends the highest-rated book of a specific genre.
Request parameters: genre

GET /book/find-all-books-of-author
Retrieves all books written by a specific author.
Request parameters: authorId

Author Controller

POST /author/add
Adds a new author.
Request body: Author

GET /author/find-author-by-Id
Retrieves an author by their ID.
Request parameters: authorId

GET /author/find-all-authors
Retrieves a list of all authors.

GET /author/author-written-maxNoOfBooks
Finds the author who has written the maximum number of books.
