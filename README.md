
# Project 1: Inventory Management System 📦

A desktop-based Inventory Management System built using **Core Java, Java Swing, OOP, and HashMap**. The application allows users to perform complete **CRUD operations** on products through a graphical user interface.

## 🚀 Features
- Add, Search, Update, and Delete Products
- Display Products in a JTable
- Duplicate Product ID Validation
- Negative Quantity and Price Validation
- Empty Product Name Validation
- Popup Error Handling and Real-time Table Refresh

## 🛠️ Tech Stack
- Java
- Java Swing
- HashMap
- OOP Principles

## 💡 Why HashMap?
Products are searched and managed using their **Product ID**, which acts as a unique key.

Using `HashMap<Integer, Product>` provides:
- **O(1)** Search by Product ID
- **O(1)** Update by Product ID
- **O(1)** Delete by Product ID

This is more efficient than using an `ArrayList`, where these operations would take **O(n)** time.

## 📚 Concepts Applied
- Object-Oriented Programming (OOP)
- Encapsulation and Data Hiding
- Java Collections Framework
- Exception Handling
- Event-Driven Programming
- CRUD Operations
- Data Validation
- GUI Development with Swing

## ▶️ Run the Project
```bash
javac *.java
java Main
```

---
**Key Takeaway:** This project helped me understand how to combine **DSA, OOP, and GUI development** to build a real-world Java application with proper validations and efficient data management.
