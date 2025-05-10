
# 🚖 UberLLD-Java

This project is a Low-Level Design (LLD) implementation of an Uber-like ride-booking platform using Java. It includes Rider and Driver management, Trip creation, Pricing Strategy, and Driver Matching Strategy using key OOP principles and design patterns like Singleton and Strategy.

---

## 📁 Directory Structure

    UberLLD-Java
    ├── Main.java
    ├── Driver.java
    ├── Rider.java
    ├── Trip.java
    ├── TripMgr.java
    ├── TripMetaData.java
    ├── DriverMgr.java
    ├── RiderMgr.java
    ├── Location.java
    ├── RATING.java
    ├── TRIPSTATUS.java
    ├── StrategyMgr.java
    ├── PricingStrategy.java
    ├── DefaultPricingStrategy.java
    ├── RatingBasedPricingStrategy.java
    ├── DriverMatchingStrategy.java
    ├── LeastTimeBasedMatchingStrategy.java
---

## 🧠 Features

- ✅ Rider and Driver Registration
- 🚕 Trip Booking and Management
- 💰 Customizable Pricing Strategies
- 🧩 Dynamic Driver Matching Strategy
- 🔒 Thread-safe Singletons (`Mgr` classes)

---

## 🖼️ Class Diagram

> 📌 **Class Diagram** (Design Overview)  
> ![Class Diagram](uber_lld.png)

---

## 🚀 How to Run

1. **Clone this repository**:
    ```bash
    git clone https://github.com/Suchana4Hazre/UberLLD-Java.git
    ```

2. **Compile all `.java` files**:
    ```bash
    javac *.java
    ```

3. **Run the main class**:
    ```bash
    java Main
    ```

---

## 🛠️ Technologies Used

- Java (Core)
- Object-Oriented Programming
- Design Patterns:
  - Singleton
  - Strategy

---

## 📌 Notes

- You can easily plug in new pricing or driver matching strategies by implementing the respective interfaces.
- The project is modular and extensible for testing or integration into larger systems.

---

## 🤝 Contributing

Contributions, issues and feature requests are welcome!  
Feel free to fork and submit pull requests.

---

