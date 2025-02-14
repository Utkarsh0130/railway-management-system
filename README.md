# 🚆 Railway Reservation System – Java Spring Boot & ReactJS

## 📌 Project Description  
The **Railway Reservation System** is a full-stack web application that allows users to **book train tickets, manage reservations, and check booking history**. The system is built using **Java (Spring Boot) for the backend** and **ReactJS for the frontend**, with **MySQL as the database**.  

This application ensures **secure user authentication, train search functionality, seat availability tracking, and reservation management**. The backend follows a **RESTful API architecture**, making it scalable and maintainable.

---

## 🔧 Technologies Used  

### **Backend (Spring Boot)**
- **Java 17** – Programming Language  
- **Spring Boot** – Backend Framework  
- **Spring Data JPA** – Database Management  
- **Spring Security** – Authentication & Authorization  
- **MySQL** – Relational Database  
- **REST APIs** – For data exchange between frontend & backend  

### **Frontend (ReactJS)**
- **ReactJS** – UI Framework  
- **React Router** – Navigation Management  
- **Bootstrap** – UI Styling  
- **Axios** – API Requests Handling  

### **Development & Deployment**
- **Docker** – Containerization  
- **Postman** – API Testing  
- **IntelliJ IDEA / VS Code** – IDEs  

---

## 📜 Features  

### **👤 User Features**
✅ **User Authentication & Role-Based Access** (JWT-based security)  
✅ **Search Available Trains** (Date-wise & Location-based filtering)  
✅ **Book Tickets & Select Seats**  
✅ **View, Modify & Cancel Reservations**  
✅ **Check Booking History & Payment Status**  

### **🛠️ Admin Features**
✅ **Manage Train Schedules**  
✅ **Add/Edit/Remove Train Details**  
✅ **View All Bookings & User Data**  

### **🔗 REST API Endpoints**
| Endpoint  | Method | Description |
|-----------|--------|-------------|
| `/api/auth/register` | `POST` | Register a new user |
| `/api/auth/login` | `POST` | Authenticate user and get JWT token |
| `/api/trains` | `GET` | Get all available trains |
| `/api/trains/{id}` | `GET` | Get train details by ID |
| `/api/bookings` | `POST` | Book a train ticket |
| `/api/bookings/{id}` | `GET` | Get booking details by ID |
| `/api/admin/trains` | `POST` | Add a new train (Admin) |
| `/api/admin/trains/{id}` | `DELETE` | Remove a train (Admin) |

*(More endpoints are available in the API documentation.)*

---

## 🚀 Installation & Setup  

### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/Utkarsh0130/railway-reservation-system.git
cd railway-reservation-system
2️⃣ Backend (Spring Boot) Setup
📦 Prerequisites:
✅ Java 17+ installed
✅ MySQL database running

💻 Steps to Run Backend
cd backend
mvn clean install
mvn spring-boot:run
🔹 The Spring Boot server will start on http://localhost:8080
3️⃣ Frontend (ReactJS) Setup
📦 Prerequisites:
✅ Node.js & npm installed

💻 Steps to Run Frontend
cd frontend
npm install
npm start
🔹 The React app will start on http://localhost:3000

🔗 API Documentation
You can find detailed API documentation using Swagger UI:
📌 http://localhost:8080/swagger-ui/

🏗️ Future Enhancements
📌 Payment Gateway Integration (Stripe/Razorpay)
📌 PNR Status Tracking System
📌 Multi-Language Support
📌 SMS & Email Notifications for Bookings

🤝 Contribution Guidelines
Want to contribute? Follow these steps:

Fork the repository
Create a new branch (feature-branch)
Commit changes (git commit -m "Added new feature")
Push to GitHub (git push origin feature-branch)
Submit a Pull Request (PR)
📝 License
This project is MIT Licensed. You can use, modify, and distribute it freely.

📩 Contact
👤 Utkarsh Bhutada
📧 Email: utkarshbhutada13@gmail.com
🔗 LinkedIn: linkedin.com/in/utkarsh-bhutada
📂 GitHub: github.com/Utkarsh0130

🚀 If you find this project useful, don't forget to ⭐ star the repository! ⭐

