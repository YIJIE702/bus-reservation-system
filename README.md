# 🚌 **Bus Reservation System ** 

## 📌 **Project Overview ** 
This project is a **Java-based Bus Reservation and Ticketing System** developed.
The system allows users to:  
- View available bus destinations and fares  
- Book tickets for multiple passengers  
- Handle discounts for students, PWDs, and senior citizens  
- Perform billing and check ticket status  
- Automatically update seat availability after each booking  
The main goal of this project is to simulate a real-world bus reservation workflow using **object-oriented programming (OOP)** concepts such as classes, objects, encapsulation, inheritance, polymorphism, and exception handling.

---

## 🎯 **Objectives  **
1. Design a computer application using **Java** and **OOP principles**.  
2. Implement OOP concepts such as **classes**, **objects**, **encapsulation**, **inheritance**, and **polymorphism**.  
3. Simulate a **real bus ticketing system** with multiple features for booking, billing, and ticket management.  

---

## 🛠️ **Methodology  **
### 1️⃣ **System Design ** 
The system is implemented using **Java** and tested on **NetBeans IDE**.  
- **Class Diagram:**  
  - Main `Bus` class handles seat management, ticket storage, and user interactions.
  - `DestinationTicket` class overrides `toString()` to display bus schedule dynamically.  
- **Flowchart:**  
  - User logs in → Main menu → Selects option → Performs booking/billing/viewing → Option to continue or exit.

### 2️⃣ **Core Features ** 
- **Login System:**  
  - Default credentials: **Username: 1 | Password: 1**  
  - Three failed attempts terminate the program automatically.  

- **Main Menu Options:**  
  1. **View Destination** – Shows all bus routes, fares, and available seats.  
  2. **Booking Ticket** – Allows user to book multiple tickets, apply discounts, and auto-update seat availability.  
  3. **Billing** – Displays passenger details, calculates total fare, accepts payment, and shows change.  
  4. **View Ticket Status** – Displays ticket status (PAID/NOT PAID) for a passenger.  
  5. **Exit** – Terminates the program gracefully.  

- **Input Validation:**  
  - Handles invalid choices, out-of-range destinations, duplicate names, overbooking attempts, and incorrect payment amounts.  

---

## 📦 **Requirements**
- Language: Java
- IDE: NetBeans (or any Java-compatible IDE)
- JDK: 8+

---

## 📌 **Conclusion**
The Bus Reservation System successfully simulates a real-world ticketing environment, allowing users to view routes, book tickets, handle payments, and check ticket status. It demonstrates the practical application of object-oriented programming principles and ensures a smooth user experience with proper error handling and seat management.

---

## ✨ **Future Improvements**
- Database Integration – Store booking data persistently instead of using in-memory arrays.
- GUI Implementation – Build a user-friendly interface using JavaFX or Swing.
- Online Payment Simulation – Support card/QR payment options.
- Reporting Module – Generate daily revenue and booking reports automatically.

---

## 📜 **License**
This project is licensed under the [MIT License](./LICENSE).  
