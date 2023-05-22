# Library System Automation

 # | General Status and Appearance

**This project is of medium difficulty and is a library management system project that is built with basic operations along with a relational database.**

----

 <h3>| The technologies I used in this project are:</h3>

<br>

<p align="left">
    &emsp; 
      <img alt="Java" width = 70; src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/java/java-plain-wordmark.svg">
    </a>
    &emsp; 
      <img alt="MySQL" width = 80;  src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/mysql/mysql-original-wordmark.svg">
    </a>
    &emsp;
      <img alt="VCS" width= 50; src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/git/git-original.svg">
    &emsp;
    </a>
          <img alt="VCS" width= 80; src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/microsoftsqlserver/microsoftsqlserver-plain-wordmark.svg">
    </a>
    &emsp;
</p>

----

| **Clone this project this:**

```shell

git clone https://github.com/ahmetpyrzklnc/library_system.git

```
----

| ***Authentication Screen Design and Function Contents***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/login.png"></a>

> - The user is prompted to enter their username and password in _JTextField_ fields. The information is then used to send a 'WHERE' query to the database for authentication.
<br>

- For security purposes, a _JCheckBox_ can be used to provide the option of either hiding or displaying the password in the password _JTextField._
<br>

- If the authentication fails, the user will be notified by opening a _JOptionPane_ to provide them with information about the failure.
<br>

- If the user enters the username or password incorrectly and clicks on the _JTextField_, the text within the _JTextField_ will be cleared, allowing the user to enter new data.
<br>

- If the user is not registered in the system, they can be directed to a registration screen by clicking on the "_Register_" button, where they can enter their registration information.

----
| ***Registration Screen Design and Functions***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/register.png"></a>

> - The registration screen is designed to facilitate the user's registration into the system by capturing their name, surname, and password. 
<br>

- To enhance security, a captcha function can be implemented to verify the user using randomly generated characters displayed on a JLabel.
<br>

- To further enhance security, a JCheckBox can be added to allow the user to toggle password visibility, enabling them to show or hide the entered password.
<br>

- When the user clicks the "Register" button, the entered registration details are sent to the database as new records, and a JOptionPane is opened to notify the user about the successful registration.
<br> 

-  When the user clicks the "Login" button, they are redirected back to the login screen.

----

 | ***Main Page Screen Design and Functions***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/home.png"></a>

> - The main page screen serves as a navigation hub, containing multiple functions and features.
<br>

- The main page screen presents the user with 7 different buttons, allowing them to perform various actions, including one for logging out of the automation system.
<br>

- If the user wants to see who is authorized in the automation system, including themselves, they can click on the "User Operations" button to open the necessary page.
<br>

- The user is directed to the necessary page where they can view the list of registered students in the automation system and perform the required operations such as adding, deleting, and updating student records.
<br>

- If the user wants to view the history of records created in the automation system, they can be redirected to the appropriate page to access that information.
<br>

- The user can be redirected to a page where they can view the book records defined within the library automation system.
<br>

- The user can be directed to a page where they can view the list of genres of books available in the library and perform related operations.
<br>

- The user can be directed to a page where they can view the list of authors of books available in the library and perform related operations.
<br>

- Finally, an option can be provided for the user to log out from the automation system, allowing them to exit the application.

----

 | ***User Operations Screen Design and Functions***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/kullanici_islemler.png"></a>

> - The User Operations screen is designed to be user-friendly and visually appealing, providing information about authorized users in the system.



- ***Listing:*** This page is solely for the purpose of listing operations.
<br>

- ***Home Page*** It redirects to the homepage.
<br>

- ***Logout:*** It closes the system and allows for logging out.
<br>

These are the functions in brief.

----

| ***Book Transactions Screen Capture and Functions***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/books.png"></a>

> - It is a page that brings together a set of functions that allow for operations related to books available in the library.



- ***Listing:*** All the books registered in the system within the library are listed in a table format.
<br>

- ***Add Record:***  By entering the information of a new book to be included in the library system, a new record is sent to the database. The result of the record is displayed to the user through a _JOptionPane_ window for information..
<br>

- ***Update:*** By selecting from the table among the registered books in the system, incorrect or outdated information can be deleted and replaced with new information. The result of the update is displayed to the user through a _JOptionPane_ window for information.
<br>

- ***Delete:*** Allows for the deletion of a selected book from the registered books in the system through the table. The result of the deletion is displayed to the user through a _JOptionPane_ window for information.
<br>

- ***Search:*** It is a tool that facilitates finding the desired book within the table

We can summarize it briefly like this.

----

| ***Student Affairs Screen Capture and Functions***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/students.png"></a>

> - It is an interface designed to modify, delete, or create new student records for the registered students in the system.



- ***Listing:*** It allows listing the information of the registered students in the system.
<br>

- ***Add Record:***  It facilitates the addition of new students to the system.
<br>

- ***Update:*** It allows for making changes to the data of registered students in the system.
<br>

- ***Delete:*** It can completely remove the data of registered students from the system.
<br>

- ***Search:*** It facilitates searching for students within the list.

We can summarize it briefly like this.

----

| ***Book Genres Screen Capture and Functions***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/bookType.png"></a>

> - It is an interface that allows for listing and performing operations on the book genres registered in the system.


- ***Listing:*** It allows for listing the genres of books registered in the system in a table format, selected from among the registered books.
<br>

- ***Add Record:***  It enables adding a new book genre entry to the system.
<br>

- ***Update:*** It allows for updating existing book genre records from the registered entries in the system.
<br>

- ***Delete:*** It provides the ability to delete book genre records by selecting them from the table among the existing genres in the system..
<br>

- ***Search:***  It allows for searching among the registered book genres in the system's data.

We can summarize it briefly like this.

---

| ***Author Operations Screen Capture and Functions***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/writer.png"></a>

> - It is an interface that allows for listing and performing various operations on the book authors registered in the system.


- ***Listing:*** It enables listing all the authors registered in the system, selected from among the registered authors.
<br>

- ***Add Record:***  It allows for adding a new author entry to the system.
<br>

- ***Update:*** It enables updating existing authors from the registered entries in the system.
<br>

- ***Delete:*** It provides the ability to delete authors by selecting them from the table among the existing authors in the system.
<br>

- ***Search:***  It allows for searching among the registered author data in the system.

We can summarize it briefly like this.

---

| ***Record History Screen Capture and Functions***

<img src="https://github.com/ahmetpyrzklnc/library_system/blob/main/images/process.png"></a>

> - It is an interface that allows for listing all the records registered in the system and enables performing operations on them.


- ***Listing:*** It can list all the data entered into the system up to the present time.
<br>

- ***Search:***  It allows for searching among the operations performed in the system.
<br>

- ***Library Analysis Screen:***  It can redirect to other functional pages for adding a new record history.


We can summarize it briefly like this.

---

| ***Record History V2 Screen Capture and Functions***

<img src="https://github.com/ahmetpyrzklnc/library_system/blob/main/images/kutuphane_analizi_v2.png"></a>

> - It is an interface that can list all the registered data in tables format.


- ***Listing:*** It can display a complete list of all the data entered into the system up to the present time.
<br>

- ***Search:***  It allows for performing searches among the operations carried out in the system.
<br>

- ***Add Record:***  It enables adding a new entry to the system.
<br>

- ***Update Record:***  It allows for updating a selected record from the operations performed in the system through the table.
<br>

- ***Delete Record:***  It enables deleting a selected record from the operations performed in the system through the table.


We can summarize it briefly like this.

---
# SQL SERVER DATABASE

**Database Information:**

|  ***Relational Database Table Screen Capture***

<img src="https://github.com/ahmetpyrzklnc/library_system/blob/main/images/diagram_01.jpg"></a>
<br>
 >***About the Table: The table was initially populated with data through SQL Server. Subsequently, using the _Migration Wizard_ within the MYSQL database management system, all the data was migrated to MySQL and integrated with the JAVA Swing Interface.***

----


<br>

- **Thank you for your review!**

<br>

- **For any questions related to the project, feel free to ask!**

<br>

 > :mailbox: <a href="mailto:ahmtklnc.software@gmail.com">You can reach me here!</a> :blush:


