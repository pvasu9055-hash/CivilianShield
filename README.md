# 🛡️ CIVILIAN SHIELD

> **Protecting Lives Across India** — A real-time civilian safety platform with AI-powered threat detection, emergency alerts, and community safety features.

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat&logo=java)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-6DB33F?style=flat&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/Frontend-HTML5/CSS3/JS-FF6B6B?style=flat&logo=javascript)](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
[![Status](https://img.shields.io/badge/Status-Active-brightgreen)](https://github.com/pvasu9055-hash/CivilianShield)

---

## 📸 Dashboard Preview

```
┌─────────────────────────────────────────┐
│        🛡️ C.SHIELD — LIVE              │
├─────────────────────────────────────────┤
│                                         │
│   AREA THREAT LEVEL     42% MODERATE   │
│   ████████████░░░░░░░░░░░░░░░░░░░░░░  │
│                                         │
│   QUICK ACTIONS                         │
│   ┌──────────────┬──────────────┐      │
│   │ 🗺️ Safe Route│ 👨‍👩‍👧 Family  │      │
│   ├──────────────┼──────────────┤      │
│   │ 📡 Offline   │ 🏥 Hospitals │      │
│   └──────────────┴──────────────┘      │
│                                         │
│          🚨 SOS [TAP TO SEND]          │
│                                         │
│   RECENT THREATS                        │
│   🔴 Assault at Main St                │
│   🟡 Robbery reported near Park        │
│   🟢 Minor accident cleared             │
│                                         │
└─────────────────────────────────────────┘
```

---

## ✨ Key Features

### 🚨 **Emergency Response System**
- **Instant SOS Alerts** — One-tap emergency alert to NDRF, Red Cross, Police & Family
- **Location Sharing** — Real-time GPS location broadcast
- **Responder Tracking** — Track emergency responder arrival
- **Case ID Generation** — Unique case IDs for every SOS

### 📍 **Threat Intelligence**
- **Real-time Threat Reporting** — Report safety threats instantly
- **Area Threat Level** — AI-calculated danger zones (Low/Medium/High)
- **Community Safety Feed** — Crowdsourced threat data
- **Threat Filtering** — Filter by severity and location

### 🗺️ **Smart Navigation**
- **Live Interactive Map** — Leaflet.js with real-time markers
- **Safe Route Finder** — Get safest path from A to B
- **Hospital Locator** — Find nearest medical facilities
- **Offline Map Mode** — Navigate without internet

### 👥 **Social Safety**
- **Emergency Contacts** — Manage family & trusted contacts
- **Quick Contact Alerts** — Send SOS to specific contacts
- **Community Alerts** — Subscribe to neighborhood safety updates
- **Safety Profile** — Public safety rating & history

### 📱 **User Management**
- **OTP-based Registration** — Secure email verification
- **Password Recovery** — Instant temporary password reset
- **Activity History** — View all your alerts & actions
- **Profile Customization** — Personalize safety preferences

### 🔐 **Security & Privacy**
- **End-to-End Encryption** — Secure data transmission
- **Password Hashing** — BCrypt encryption
- **JWT Authentication** — Stateless token-based auth
- **GDPR Compliant** — Data privacy respected

---

## 🛠️ Tech Stack

### **Backend**
| Technology | Purpose |
|-----------|---------|
| **Java 17** | Core language |
| **Spring Boot 3.2** | Web framework |
| **Spring Data JPA** | Database ORM |
| **Spring Security** | Authentication & encryption |
| **PostgreSQL / H2** | Database |
| **WebSocket** | Real-time updates |
| **JWT** | Token authentication |
| **Brevo SMTP** | Email delivery |

### **Frontend**
| Technology | Purpose |
|-----------|---------|
| **HTML5** | Markup |
| **CSS3** | Dark theme styling |
| **Vanilla JavaScript** | Interactivity |
| **Leaflet.js** | Interactive mapping |
| **LocalStorage API** | Client-side data |

### **Infrastructure**
| Tool | Use |
|------|-----|
| **Docker** | Containerization |
| **Render.com** | Cloud deployment |
| **GitHub** | Version control |
| **Gradle** | Build automation |

---

## 🚀 Quick Start

### Prerequisites
- **Java 17+**
- **Gradle** (or use included wrapper)
- **PostgreSQL** or **H2** Database
- **Git**

### Installation

1. **Clone Repository**
```bash
git clone https://github.com/pvasu9055-hash/CivilianShield.git
cd CivilianShield
```

2. **Configure Database** (`application.properties`)
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/civilianshield
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

3. **Set Environment Variables**
```bash
export PORT=8080
export SMTP_PASSWORD=your_brevo_password
```

4. **Build Project**
```bash
./gradlew clean build
```

5. **Run Application**
```bash
./gradlew bootRun
# OR
java -jar build/libs/CivilianShield-0.0.1-SNAPSHOT.jar
```

6. **Access Application**
```
http://localhost:8080/login.html
```

---

## 📖 API Endpoints

### **User Management**
```bash
POST   /api/user/register         # Register new user
POST   /api/user/login            # Login with email & password
POST   /api/user/forgot-password  # Request password reset
GET    /api/user/all              # Get all users
```

### **Emergency Response**
```bash
POST   /api/sos                   # Send SOS alert
GET    /api/sos/status            # Check SOS system status
```

### **Threat System**
```bash
GET    /api/threats               # Get all threats
POST   /api/threats/add           # Report new threat
GET    /api/threats/level         # Get area threat level
DELETE /api/threats/{id}          # Delete threat report
```

---

## 🏗️ Project Structure

```
CivilianShield/
├── src/main/java/
│   └── com/civilianshield/civilianshield/
│       ├── controller/
│       │   ├── UserController.java         # User auth
│       │   ├── SOSController.java          # Emergency alerts
│       │   ├── ThreatController.java       # Threat management
│       │   └── WebMvcConfig.java           # Web config
│       ├── model/
│       │   ├── User.java                   # User entity
│       │   └── Threat.java                 # Threat entity
│       ├── repository/
│       │   ├── UserRepository.java
│       │   └── ThreatRepository.java
│       └── config/
│           ├── DataInitializer.java        # Seed test data
│           └── SecurityConfig.java         # Security beans
│
├── src/main/resources/
│   ├── static/
│   │   ├── login.html                      # Login page
│   │   ├── index.html                      # Dashboard
│   │   ├── map.html                        # Map page
│   │   ├── alerts.html                     # Alerts page
│   │   ├── profile.html                    # Profile page
│   │   └── contacts.html                   # Contacts page
│   └── application.properties              # Configuration
│
├── Dockerfile                              # Docker image
├── build.gradle                            # Dependencies
└── README.md                               # This file
```

---

## 🔑 Key Components

### **UserController** - Authentication & User Management
```java
// Registration with OTP verification
POST /api/user/register → OTP sent to email

// Secure login
POST /api/user/login → JWT token + user data

// Password recovery
POST /api/user/forgot-password → Temporary password
```

### **SOSController** - Emergency Response
```java
// Send emergency alert
POST /api/sos → SOS_SENT status with Case ID

// Check system status
GET /api/sos/status → Active cases + responders
```

### **ThreatController** - Threat Intelligence
```java
// Get all threats in area
GET /api/threats → List of threat reports

// Report new threat
POST /api/threats/add → Threat saved to database

// Get threat level
GET /api/threats/level → Percentage + status
```

---

## 🌐 Deployment

### **Local Deployment**
```bash
./gradlew bootRun
# App runs on http://localhost:8080
```

### **Docker Deployment**
```bash
# Build Docker image
docker build -t civilianshield .

# Run container
docker run -p 8080:8080 -e PORT=8080 civilianshield
```

### **Cloud Deployment (Render.com)**

1. Push code to GitHub
2. Create new Web Service on Render
3. Connect GitHub repository
4. Set environment variables:
   ```
   PORT=8080
   SMTP_PASSWORD=your_password
   ```
5. Deploy!

---

## 🧪 Testing

### **Test User Credentials**
```
Email: test@example.com
Password: password123
```

### **Manual Testing Flow**
1. Go to http://localhost:8080/login.html
2. Register new account OR login with test credentials
3. Explore dashboard features:
   - Click **SOS button** → Send emergency alert
   - Click **MAP** → View threats & hospitals
   - Click **ALERTS** → See all threat reports
   - Click **PROFILE** → Manage settings & contacts

---

## 🔒 Security Features

✅ **Password Encryption** — BCrypt hashing  
✅ **JWT Authentication** — Stateless token-based auth  
✅ **CORS Protection** — Cross-origin request handling  
✅ **Input Validation** — Server-side validation  
✅ **Email Verification** — OTP-based registration  
✅ **Secure SMTP** — Encrypted email delivery  

---

## 📊 Database Schema

### **Users Table**
```sql
CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  phone VARCHAR(10),
  password VARCHAR(255) NOT NULL (BCrypt),
  location VARCHAR(255),
  status VARCHAR(50) DEFAULT 'SAFE',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### **Threats Table**
```sql
CREATE TABLE threats (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  type VARCHAR(100) NOT NULL,
  description TEXT,
  location VARCHAR(255),
  latitude DECIMAL(10,8),
  longitude DECIMAL(11,8),
  severity VARCHAR(50) (HIGH, MEDIUM, LOW),
  reported_by VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** changes (`git commit -m 'Add AmazingFeature'`)
4. **Push** to branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

---

## 📝 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Vasu Penkey Sri Vasu**  
B.Tech CSE (Graduating 2027) — Parul University, Vadodara  
🔗 [GitHub](https://github.com/pvasu9055-hash) | 📧 [Email](mailto:pvasu9055@gmail.com)

---

## 📞 Support & Contact

- 🐛 **Report Bugs**: [GitHub Issues](https://github.com/pvasu9055-hash/CivilianShield/issues)
- 💬 **Discussions**: [GitHub Discussions](https://github.com/pvasu9055-hash/CivilianShield/discussions)
- 📧 **Email**: pvasu9055@gmail.com

---

## 🎯 Roadmap

- [ ] Mobile app (React Native)
- [ ] AI threat prediction model
- [ ] SMS/WhatsApp integration for alerts
- [ ] Police department integration
- [ ] Real-time video streaming for incidents
- [ ] Blockchain-based threat records
- [ ] Offline mesh networking

---

## ⭐ If You Like This Project

Please give it a **star** ⭐ on GitHub to show support!

```
╔═══════════════════════════════════════════╗
║   🛡️  STAY SAFE, STAY CONNECTED  🛡️      ║
║   Civilian Shield — Protecting Lives      ║
╚═══════════════════════════════════════════╝
```

---

**Last Updated**: April 2026  
**Current Version**: 0.0.1-SNAPSHOT  
**Status**: 🟢 Active Development
