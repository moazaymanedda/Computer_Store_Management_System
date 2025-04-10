# 💻 Computer Store Management System

## 📘 Project Description
The **Computer Store Management System** is a database-driven Java application designed to manage the operations of a computer store efficiently. It includes a complete set of functionalities for managing products, customers, orders, invoices, feedback, suppliers, and warehouses. The system is built using **Oracle SQL** for database management and **Java (JDBC)** for application logic and connectivity.

---

## 🚀 Features
- **Product Management**: Administer various product types such as desktop computers, components, and peripherals.
- **Customer Management**: Store customer profiles and track their purchase history.
- **Order Management**: Manage shopping carts, order statuses, and invoices.
- **Feedback System**: Collect customer reviews and ratings for products.
- **Supplier and Warehouse Management**: Monitor suppliers, warehouse stock levels, and deliveries.

---


### 🔁 Triggers
Custom triggers are implemented to ensure data integrity and enforce business rules, such as:
- Validating product types in associated tables (`Desktop_racunar`, `Komponenta`, `Periferija`).

### 📜 Scripts
- **DDL Script**: SQL script for creating the database schema.
- **DML Script**: Contains sample data for testing purposes.
- **Oracle Data Modeler File**: A `.dmd` file providing a visual data model created using Oracle SQL Developer Data Modeler.

---

## 🧰 Technologies Used
| Technology | Description |
|------------|-------------|
| **Database** | Oracle Database 11g |
| **Backend Language** | Java |
| **Database Connectivity** | JDBC |
| **Tools** | Oracle SQL Developer, Oracle SQL Developer Data Modeler, Eclipse IDE |

---

## 📁 Folder Structure

```
project-root/
│
├── docs/                             # Documentation and model diagrams
│   ├── ER_Model.png
│   ├── Data_Model_Description.docx
│
├── sql/                              # SQL scripts
│   ├── DDL_Script.ddl
│   └── DML_Script.sql                # Rename to .sql for consistency
│
├── Database data modeler/           # Relational model / metadata
│   ├── Data Model Description.docx   # Detailed documentation of the data model and its components 
│   ├── Database relational model/    # Additional metadata for the model
│
├── JDBC/                             # Java application
│   ├── src/                          # Java source code
│   └── bin/                          # Compiled classes
│
└── README.md                         # Project documentation
```

---

## ▶️ How to Run

1. Start Oracle Database and execute the `DDL_Script.ddl` to create the schema.
2. Run `DML_Script.txt` to populate the database with sample data.
3. Configure JDBC connection parameters in the Java project.
4. Compile and run the Java application.
5. *(Optional)* Open `Database relational model.dmd` in Oracle SQL Developer Data Modeler to visualize or modify the schema.

---

## 📊 Sample Outputs (Translated from Serbian for clarity)

> 🔽 The following outputs were originally in Serbian and have been translated into English to improve understanding.

---

### 1️⃣ View Customer Purchase Statistics
```
Customer Purchase Statistics:
NAME                    INVOICE COUNT     TOTAL SPENT
Petar Petrović          1                 85,000.00
Marko Marković          1                 65,000.00
Jovana Jovanović        1                 3,000.00
```

---

### 2️⃣ View Average Product Ratings by Type
```
Average Ratings by Product Type:
PRODUCT TYPE           AVERAGE RATING     NUMBER OF REVIEWS
Desktop Computer       4.75               2
Component              4.75               2
Peripheral             3.00               1
```

---

### 3️⃣ Detailed Purchase Analysis
```
Detailed Purchase Analysis:
NAME                    CART STATUS    QUANTITY    CREATED DATE    REVIEWS    SATISFACTION
Ana Anić                Active         1           2025-01-20       0          0.00
Petar Petrović          Closed         2           2025-01-17       1          5.00
Marko Marković          Closed         2           2025-01-15       1          4.50
Jovana Jovanović        Closed         1           2025-01-10       1          3.00
```

---

### 4️⃣ Product Analysis
```
Product Analysis:
PRODUCT NAME            TYPE             STOCK         ACTIVE CARTS    CLOSED CARTS    POPULARITY
SSD 1TB                 Component        30            0               1               20%
Mechanical Keyboard     Peripheral       75            1               0               20%
Business PC             Desktop          5             0               1               20%
RAM 16GB DDR4           Component        50            0               1               20%
Gaming PC               Desktop          10            0               1               20%
```

---

### 5️⃣ New Purchase with Feedback (Transaction)
```
New Purchase with Feedback:
Enter Customer ID: 1
Enter Product IDs (comma-separated): 1,2
Enter Payment Method: Card
Enter Rating (1-5): 4
Enter Comment: Excellent product

Successfully created purchase with invoice and feedback.
Cart ID: 5
Purchase completed successfully.
```

---

## 📌 Notes
- All outputs are **translated from Serbian** for international users or collaborators.
- The system supports **transactional operations**, such as creating a new purchase with a review, ensuring **ACID compliance**.

## 🗃️ Database Design

The system is based on a **relational database model**, consisting of the following primary entities and their attributes. This structure ensures data consistency, integrity, and supports all core functionalities of the application.

---

### 🏬 Store
Represents a physical or online location where products are sold.

| Attribute         | Description                      |
|------------------|----------------------------------|
| `id_prodavnice`  | Unique identifier of the store   |
| `naziv`          | Store name                       |
| `adresa`         | Store address                    |

---

### 👨‍💼 Employee
Stores employee information and their role within the store.

| Attribute         | Description                          |
|------------------|--------------------------------------|
| `id_zaposlenog`  | Unique identifier of the employee    |
| `ime`            | First name of the employee           |
| `prezime`        | Last name of the employee            |
| `pozicija`       | Job position                         |
| `plata`          | Salary                               |

---

### 🏢 Warehouse
Represents a storage facility for products.

| Attribute           | Description                          |
|--------------------|--------------------------------------|
| `id_magacina`      | Unique identifier of the warehouse   |
| `naziv_magacina`   | Warehouse name                       |
| `kapacitet`        | Maximum storage capacity             |

---

### 📦 Product
Contains information about the products available for sale.

| Attribute         | Description                                             |
|------------------|---------------------------------------------------------|
| `id_artikla`     | Unique identifier of the product                        |
| `naziv_artikla`  | Product name                                            |
| `cena`           | Product price                                           |
| `tip_artikla`    | Product type (`Desktop Computer`, `Component`, `Peripheral`) |
| `kol_na_st`      | Quantity currently in stock                             |

---

### 🛒 Shopping Cart
Tracks products added by customers for potential purchase.

| Attribute          | Description                           |
|-------------------|---------------------------------------|
| `id_korpe`        | Unique identifier of the shopping cart|
| `datum_kreiranja` | Date the cart was created             |
| `status_korpe`    | Cart status (`active`, `empty`, etc.) |

---

### 🧾 Invoice
Stores billing information after a purchase is completed.

| Attribute         | Description                          |
|------------------|--------------------------------------|
| `id_racuna`      | Unique identifier of the invoice     |
| `datum_izdavanja`| Date of invoice creation             |
| `ukupan_iznos`   | Total amount billed                  |
| `nacin_placanja` | Payment method (`cash`, `card`, etc.)|

---

### 👤 Customer
Stores personal information about customers.

| Attribute         | Description                          |
|------------------|--------------------------------------|
| `id_kupca`       | Unique identifier of the customer    |
| `ime_kupca`      | Customer's first name                |
| `prezime_kupca`  | Customer's last name                 |

---

### ⭐ Feedback
Collects product reviews and ratings submitted by customers.

| Attribute         | Description                          |
|------------------|--------------------------------------|
| `id_utiska`      | Unique identifier of the feedback    |
| `ocena`          | Rating value (1–5)                   |
| `komentar`       | Textual comment                      |
| `datum_utiska`   | Date the feedback was submitted      |

---

### 🚚 Supplier
Contains information about product vendors or suppliers.

| Attribute           | Description                          |
|--------------------|--------------------------------------|
| `id_dobavljaca`    | Unique identifier of the supplier    |
| `naziv_dobavljaca` | Supplier name                        |
| `kontakt`          | Contact information                  |

---

### 🛠️ Services
Represents additional services offered by the store (e.g., technical support).

| Attribute         | Description                                   |
|------------------|-----------------------------------------------|
| `id_usluge`      | Unique identifier of the service              |
| `tip_usluge`     | Type of service (`repair`, `installation`, etc.) |
| `cena_usluge`    | Price of the service                          |
| `opis_usluge`    | Description of the service                    |

---

### 📌 Notes
- All tables use appropriate **primary keys** and **foreign keys** to maintain relational integrity.
- Entity relationships are visualized in the `Database relational model.dmd` file included in the project.
- Triggers are used for **data validation** and **business rule enforcement**, particularly for product type integrity.


---
