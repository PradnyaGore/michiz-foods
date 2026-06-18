# 🍲 Michiz Foods — Weekly Meal Pre-Order System

A full-stack web application for weekly meal pre-ordering inspired by Michiz Foods, an authentic Nigerian cuisine business in Australia.

## 🔗 Frontend Repository
https://github.com/PradnyaGore/michiz-foods-frontend

## 📌 About
Michiz Foods serves working families with authentic Nigerian frozen meals delivered weekly. This system digitizes their ordering process.

## ✨ Features
### Customer Side
- Browse all available Nigerian meals with prices in AUD
- Select meals and quantities
- Place orders (Tuesday-only rule enforced automatically)
- Receive order confirmation with delivery week date

### Admin Dashboard
- View all customer orders
- Update order status (Pending → Confirmed → Delivered → Cancelled)
- Add new meals to the menu
- Enable or disable meal availability

## 🛠️ Tech Stack
- **Backend:** Java 17, Spring Boot 3
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA + Hibernate
- **Frontend:** React (Vite)
- **Build Tool:** Maven
- **API Style:** REST

## 🗄️ Database Schema
- **meal** → id, name, description, price, category, is_available
- **customer** → id, name, email, phone
- **food_order** → id, customer_id, meals_ordered, total_amount, order_date, delivery_week, status

## 🔗 REST API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/meals | Get available meals |
| GET | /api/meals/all | Get all meals (admin) |
| POST | /api/meals | Add new meal |
| PUT | /api/meals/{id}/toggle | Toggle availability |
| POST | /api/orders | Place an order |
| GET | /api/orders | Get all orders (admin) |
| PUT | /api/orders/{id}/status | Update order status |

## ⚙️ How to Run

### Prerequisites
- Java 17
- PostgreSQL
- Maven

### Steps
1. Clone the repository
2. Create PostgreSQL database:
```sql
CREATE DATABASE michizfoods;
```
3. Update application.properties with your PostgreSQL password
4. Run the app: