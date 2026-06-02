# Smart Procurement & Vendor Management System

## Overview

Smart Procurement & Vendor Management System is a full-stack enterprise procurement platform developed during **Infosys Springboard Virtual Internship 6.0**.

The system automates the complete procurement lifecycle including:

* Vendor Management
* Purchase Requisition
* Approval Workflow
* Purchase Order Management
* Inventory Tracking
* Invoice & Payment Processing
* Reporting & Analytics

This project was developed as a collaborative team project where I contributed as the **Frontend Head**.

---

## Internship Details

* **Internship Program:** Infosys Springboard Virtual Internship 6.0
* **Duration:** February 2026 – April 2026
* **Role:** Frontend Head
* **Organization:** Infosys Springboard

---

## Features

### User & Role Management

* Role-based access control
* Department-wise user management
* Authentication & authorization

### Vendor Management

* Vendor registration
* Vendor approval workflow
* Vendor ratings & documents

### Procurement Workflow

* Purchase requisition creation
* Approval/rejection process
* Purchase order generation

### Inventory Management

* Inventory tracking
* Stock availability monitoring
* Reorder management

### Invoice & Payment

* Invoice generation
* Payment tracking
* Delivery management

### Reporting

* Spend analysis reports
* CSV export functionality
* Procurement analytics

---

## Technology Stack

### Frontend

* React.js
* Vite
* Axios
* React Router

### Backend

* Spring Boot
* Spring Security
* REST APIs
* Hibernate / JPA

### Database

* MySQL

### Deployment

* Frontend: Vercel
* Backend: Render
* Database: Railway MySQL

---

## System Architecture

```text
React Frontend
      ↓
Axios API Calls
      ↓
Spring Boot REST API
      ↓
MySQL Database
```

---

## Project Structure

```text
Smart-Procurement-Vendor-Management-System
│
├── Frontend
│   ├── src
│   ├── public
│   ├── package.json
│   └── vite.config.js
│
└── Backend
    ├── src
    ├── pom.xml
    ├── mvnw
    └── application.properties
```

---

## Frontend Highlights

* Reusable React components
* API integration using Axios
* Route-based navigation
* Responsive UI
* Environment variable configuration
* Authentication flow handling

---

## Backend Highlights

* RESTful API development
* Layered architecture:

  * Controller
  * Service
  * Repository
* Spring Security integration
* MySQL database connectivity
* JPA/Hibernate ORM

---

## Database Modules

* Users
* Roles
* Departments
* Vendors
* Items
* Inventory
* Requisitions
* Approvals
* Purchase Orders
* Invoices
* Payments
* Deliveries
* Vendor Ratings
* Report History

---

## API Example

### Login API

```http
POST /users/auth/login
```

### Request Body

```json
{
  "email": "admin@gmail.com",
  "password": "1234"
}
```

---

## Environment Variables

### Frontend (.env)

```env
VITE_API_URL=http://localhost:8097
```

### Backend (application.properties)

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

---

## Deployment Link
https://smart-procurement-vendor-management.vercel.app

---

## Installation & Setup

### Frontend Setup

```bash
cd Frontend
npm install
npm run dev
```

### Backend Setup

```bash
cd Backend
mvn clean install
mvn spring-boot:run
```

---

## Challenges Faced

* CORS configuration during deployment
* Frontend-backend integration
* Cloud database connectivity
* Environment variable management
* Spring Security configuration

---

## Learning Outcomes

* Full-stack web development
* REST API integration
* Cloud deployment
* Authentication & security
* Team collaboration
* Frontend architecture design

---

## Future Enhancements

* JWT Authentication
* Email notifications
* Advanced analytics dashboard
* Mobile responsiveness improvements
* AI-based procurement recommendations

---

## Screenshots

* Login Page
* Dashboard
* Vendor Management
* Inventory Module
* Reports & Analytics

(Add screenshots here)

---

## Author

### Partha Pratim Makhal

Frontend Head
B.Tech – Information Technology
Haldia Institute of Technology

---

## Acknowledgement

We sincerely thank Infosys Springboard for providing the opportunity to work on this project during the Virtual Internship 6.0 program.
