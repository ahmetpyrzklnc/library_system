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

| ***Kitap İşlemleri Ekranı Görüntüsü ve İşlevleri***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/books.png"></a>

> - Kütüphane içerisinde bulunan kitaplarla ilgili işlemler yapmaya olanak sağlayan bir takım fonksiyonların bir arada bulunduğu bir sayfadır.

*İşlevleri:*


- ***Listeleme:*** Kütüphane içerisinde bulunan sisteme kayıtlı bütün kitaplar bir tablo halinde listelenir.
<br>

- ***Kayıt Ekle:***  Kütüphane sistemine dahil olacak yeni kitabın bilgileri girilerek veritabanına yeni bir kayıt gönderir. Kayıt sonucunu _JOptionPane_ penceresi açılarak kullanıcı bilgilendirilmiş olur.
<br>

- ***Güncelleme:*** Sistemde kayıtlı kitaplar arasında tablodan seçim yapılarak yanlış veya eski bir bilgi silinerek yenisiyle değiştirilebilir. Güncelleme sonucunu _JOptionPane_ penceresi açılarak kullanıcı bilgilendirilmiş olur.
<br>

- ***Silme:*** Sistemde kayıtlı kitaplar arasından birinin tablodan seçilerek silinmesini sağlar. Silme sonucunu _JOptionPane_ penceresi açılarak kullanıcı bilgilendirilmiş olur.
<br>

- ***Arama:*** Tablo içerisinden aranan kitabı bulmayı kolaylaştıran bir araçtır.

Kısaca bu şekilde özetleyebiliriz.

----

| ***Öğrenci İşleri Ekran Görüntüsü ve İşlevleri***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/students.png"></a>

> - Sistemde kayıtlı öğrencilerin bilgilerini değiştirmek, silmek veya yeni öğrenci kaydı oluşturmak için yapılmış bir arayüzdür.

*İşlevleri:*


- ***Listeleme:*** Sistemde kayıtlı öğrencilerin bilgilerini listeleyebilir.
<br>

- ***Kayıt Ekleme:***  Sisteme yeni öğrencilerin eklemesini kolaylaştırabilir.
<br>

- ***Güncelleme:*** Sistemde kayıtlı öğrenci verileri arasında değişiklik yapmaya olanak sağlar
<br>

- ***Silme:*** Sistemde kayıtlı öğrencilerin verilerini tamamen sistemden silebilir.
<br>

- ***Arama:*** Veya öğrencileri liste içerisinden aramasını kolaylaştırır.

Kısaca bu şekilde özetleyebiliriz.

----

| ***Kitap Türleri Ekran Görüntüsü ve İşlevleri***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/bookType.png"></a>

> - Sistemde kayıtlı olan kitap türlerini listelemeye veya işlemler yapmaya olanak sağlayan bir arayüzdür.

*İşlevleri:*


- ***Listeleme:*** Sistemde kayıtlı olan kitaplar arasından bu kitapların türlerini bir tablo halinde listelemeye olanak sağlar.
<br>

- ***Kayıt Ekleme:***  Veya yeni bir kitap türü girişini sisteme kaydeder.
<br>

- ***Güncelleme:*** Sistemde var olan kitap türleri kayıtları arasından güncelleme yapabilir.
<br>

- ***Silme:*** Veya sistemde var olan kitap türleri arasından tabloda seçim yaparak silmeye olanak sağlar.
<br>

- ***Arama:***  Sistemde kayıtlı olan kitap verileri arasından arama yapabilir.

Kısaca bu şekilde özetleyebiliriz.

---

| ***Yazar İşlemleri Ekran Görüntüsü ve İşlevleri***

<img src="https://raw.githubusercontent.com/ahmetpyrzklnc/library_system/main/images/writer.png"></a>

> - Sistemde kayıtlı olan kitap yazarlarını listeleme ve daha farklı işlemleri yapmaya olanak sağlayan bir arayüzdür.

*İşlevleri:*


- ***Listeleme:*** Sistemde kayıtlı olan yazarlar arasından bu yazarların tamamını listeleyebilir.
<br>

- ***Kayıt Ekleme:***  Veya yeni bir yazar girişini sisteme kaydeder.
<br>

- ***Güncelleme:*** Sistemde var olan yazarlar arasından güncelleme yapabilir.
<br>

- ***Silme:*** Veya sistemde var olan yazarlar arasından tabloda seçim yaparak silmeye olanak sağlar.
<br>

- ***Arama:***  Sistemde kayıtlı olan yazar verileri arasından arama yapabilir.

Kısaca bu şekilde özetleyebiliriz.

---

| ***Kayıt Geçmişi Ekran Görüntüsü ve İşlevleri***

<img src="https://github.com/ahmetpyrzklnc/library_system/blob/main/images/process.png"></a>

> - Sistemde kayıtlı olan verilerin tamamını listelemeye veya işlemler yapabilecek ekrana yönlendirme yapmaya olanak sağlayan bir arayüzdür.

*İşlevleri:*


- ***Listeleme:*** Sisteme bu zamana kadar girilmiş bütün verilerin tamamını listeleyebilir
<br>

- ***Arama:***  Sistemde yapılmış işlemler arasından arama yapılabilir.
<br>

- ***Kütüphane Analiz Ekranı:***  Yeni bir kayıt geçmişi eklemek için diğer fonksiyonel sayfaya yönlendirme yapabilir.


Kısaca bu şekilde özetleyebiliriz.

---

| ***Kayıt Geçmişi V2 Ekran Görüntüsü ve İşlevleri***

<img src="https://github.com/ahmetpyrzklnc/library_system/blob/main/images/kutuphane_analizi_v2.png"></a>

> - Sistemde kayıtlı olan tüm verilerin hepsini tablolar halinde listeleyebilen bir arayüzdür.

*İşlevleri:*


- ***Listeleme:*** Sisteme bu zamana kadar girilmiş bütün verilerin tamamını listeleyebilir
<br>

- ***Arama:***  Sistemde yapılmış işlemler arasından arama yapılabilir.
<br>

- ***Kayıt Ekleme:***  Sisteme yeni bir kayıt girişi ekleyebilir.
<br>

- ***Kayıt Güncelleme:***  Sistemde yapılmış işlemler arasından tabloda seçim yapılarak güncelleme yapılabilir.
<br>

- ***Kayıt Silme:***  Sistemde yapılmış işlemler arasından tabloda seçim yapılarak kayıt silinebilir.


Kısaca bu şekilde özetleyebiliriz.

---
# SQL SERVER Veritabanı

**Veritabanı Bilgileri:**

|  ***İlişkisel Veritabanı Tablosu Ekran Görüntüsü***

<img src="https://github.com/ahmetpyrzklnc/library_system/blob/main/images/diagram_01.jpg"></a>
<br>
 >***Tablo Hakkında: Tablo öncelikle SQL Server üzerinden hazırlanmış veriler girilmiştir. Sonrasında MYSQL veritabanı yönetim sisteminin içerisinde bulunan _Migration Wizard_ kullanarak bütün veriler MySQL içerisine taşınıp JAVA Swing Arayüzüyle buluşmuştur.***

----


<br>

- **İncelediğiniz için Teşekkür Ederim!**

<br>

- **Projeyle İlgili Sorularınız İçin:**

<br>

 > :mailbox: <a href="mailto:ahmtklnc.software@gmail.com">Bana buradan ulaşabilirsiniz!</a> :blush:


