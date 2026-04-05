<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Civilian Shield — 3D Interactive README</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/three.js/r128/three.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@700;900&family=Exo+2:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        * { margin:0; padding:0; box-sizing:border-box; }
        body { 
            background:#050a0f; 
            font-family:'Exo 2',sans-serif; 
            color:#fff; 
            overflow-x:hidden;
            scroll-behavior: smooth;
        }
        body::before { 
            content:''; 
            position:fixed; 
            inset:0; 
            background-image:linear-gradient(rgba(0,207,255,0.04) 1px,transparent 1px),linear-gradient(90deg,rgba(0,207,255,0.04) 1px,transparent 1px); 
            background-size:30px 30px; 
            z-index:-1; 
            pointer-events:none; 
        }

        /* 3D Hero Section */
        #heroCanvas {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100vh;
            z-index: 0;
        }

        .hero-content {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
            z-index: 10;
            animation: fadeInUp 1.5s ease-out;
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translate(-50%, -40%);
            }
            to {
                opacity: 1;
                transform: translate(-50%, -50%);
            }
        }

        .hero-content h1 {
            font-family: 'Orbitron', monospace;
            font-size: 72px;
            font-weight: 900;
            background: linear-gradient(135deg, #00cfff, #00ff88);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            margin-bottom: 20px;
            text-shadow: 0 0 20px rgba(0, 207, 255, 0.3);
        }

        .hero-content p {
            font-size: 18px;
            color: rgba(255, 255, 255, 0.7);
            margin-bottom: 30px;
        }

        .cta-button {
            display: inline-block;
            padding: 15px 40px;
            background: linear-gradient(135deg, #00cfff, #00ff88);
            color: #000;
            border: none;
            border-radius: 50px;
            font-family: 'Orbitron', monospace;
            font-size: 14px;
            font-weight: 700;
            cursor: pointer;
            transition: all 0.3s;
            box-shadow: 0 0 30px rgba(0, 207, 255, 0.3);
        }

        .cta-button:hover {
            transform: translateY(-5px);
            box-shadow: 0 0 50px rgba(0, 207, 255, 0.6);
        }

        /* Main Content */
        .container {
            position: relative;
            z-index: 5;
            max-width: 1200px;
            margin: 100vh auto 0;
            padding: 60px 40px;
            background: rgba(5, 10, 15, 0.95);
            backdrop-filter: blur(10px);
        }

        section {
            margin-bottom: 80px;
            animation: slideInUp 0.8s ease-out;
        }

        @keyframes slideInUp {
            from {
                opacity: 0;
                transform: translateY(40px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h2 {
            font-family: 'Orbitron', monospace;
            font-size: 36px;
            background: linear-gradient(135deg, #00cfff, #00ff88);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            margin-bottom: 30px;
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .feature-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 20px;
            margin-bottom: 40px;
        }

        .feature-card {
            background: rgba(0, 20, 40, 0.8);
            border: 1px solid rgba(0, 207, 255, 0.2);
            border-radius: 15px;
            padding: 25px;
            transition: all 0.3s;
            cursor: pointer;
            transform-style: preserve-3d;
            perspective: 1000px;
        }

        .feature-card:hover {
            border-color: #00cfff;
            box-shadow: 0 0 30px rgba(0, 207, 255, 0.2);
            transform: translateY(-10px) rotateX(5deg);
        }

        .feature-card h3 {
            font-family: 'Orbitron', monospace;
            font-size: 18px;
            margin-bottom: 10px;
            color: #00cfff;
        }

        .feature-card p {
            font-size: 14px;
            color: rgba(255, 255, 255, 0.6);
            line-height: 1.6;
        }

        /* Image Gallery */
        .gallery {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            margin-bottom: 40px;
        }

        .gallery-item {
            position: relative;
            border-radius: 15px;
            overflow: hidden;
            border: 1px solid rgba(0, 207, 255, 0.2);
            aspect-ratio: 16/9;
            background: rgba(0, 20, 40, 0.8);
        }

        .gallery-item img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: all 0.3s;
        }

        .gallery-item:hover img {
            transform: scale(1.1);
            filter: brightness(1.2);
        }

        .gallery-item::after {
            content: '';
            position: absolute;
            inset: 0;
            background: linear-gradient(135deg, rgba(0, 207, 255, 0.2), rgba(0, 255, 136, 0.2));
            pointer-events: none;
        }

        /* Tech Stack */
        .tech-stack {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
            gap: 15px;
        }

        .tech-badge {
            background: rgba(0, 207, 255, 0.1);
            border: 1px solid rgba(0, 207, 255, 0.3);
            padding: 15px;
            border-radius: 10px;
            text-align: center;
            font-family: 'Orbitron', monospace;
            font-size: 12px;
            transition: all 0.3s;
        }

        .tech-badge:hover {
            background: rgba(0, 207, 255, 0.2);
            border-color: #00cfff;
            box-shadow: 0 0 20px rgba(0, 207, 255, 0.2);
        }

        /* Stats */
        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin-bottom: 40px;
        }

        .stat-card {
            background: rgba(0, 20, 40, 0.8);
            border: 1px solid rgba(0, 207, 255, 0.2);
            border-radius: 15px;
            padding: 25px;
            text-align: center;
        }

        .stat-value {
            font-family: 'Orbitron', monospace;
            font-size: 36px;
            background: linear-gradient(135deg, #00cfff, #00ff88);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            margin-bottom: 10px;
        }

        .stat-label {
            font-size: 12px;
            color: rgba(255, 255, 255, 0.6);
            letter-spacing: 1px;
        }

        /* Code Block */
        .code-block {
            background: rgba(0, 0, 0, 0.8);
            border: 1px solid rgba(0, 207, 255, 0.3);
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 30px;
            overflow-x: auto;
        }

        .code-block code {
            font-family: 'Courier New', monospace;
            font-size: 13px;
            color: #00ff88;
            line-height: 1.6;
        }

        /* Timeline */
        .timeline {
            position: relative;
            padding: 20px 0;
        }

        .timeline::before {
            content: '';
            position: absolute;
            left: 0;
            top: 0;
            bottom: 0;
            width: 2px;
            background: linear-gradient(180deg, #00cfff, #00ff88);
        }

        .timeline-item {
            margin-left: 30px;
            margin-bottom: 30px;
            position: relative;
        }

        .timeline-item::before {
            content: '';
            position: absolute;
            left: -37px;
            top: 5px;
            width: 12px;
            height: 12px;
            border-radius: 50%;
            background: #00cfff;
            box-shadow: 0 0 10px #00cfff;
        }

        .timeline-item h4 {
            font-family: 'Orbitron', monospace;
            color: #00cfff;
            margin-bottom: 5px;
        }

        .timeline-item p {
            color: rgba(255, 255, 255, 0.6);
            font-size: 14px;
        }

        /* Footer */
        footer {
            background: rgba(0, 20, 40, 0.9);
            border-top: 1px solid rgba(0, 207, 255, 0.2);
            padding: 40px;
            text-align: center;
            margin-top: 80px;
        }

        footer p {
            color: rgba(255, 255, 255, 0.6);
            margin-bottom: 10px;
        }

        /* Scroll Progress */
        .scroll-progress {
            position: fixed;
            top: 0;
            left: 0;
            height: 3px;
            background: linear-gradient(90deg, #00cfff, #00ff88);
            z-index: 100;
            width: 0%;
            transition: width 0.1s;
        }

        /* Responsive */
        @media (max-width: 768px) {
            .hero-content h1 {
                font-size: 40px;
            }
            
            h2 {
                font-size: 24px;
            }
            
            .container {
                padding: 30px 20px;
            }
        }
    </style>
</head>
<body>

<!-- Scroll Progress Bar -->
<div class="scroll-progress" id="scrollProgress"></div>

<!-- 3D Hero Section -->
<canvas id="heroCanvas"></canvas>

<!-- Hero Content -->
<div class="hero-content">
    <h1>🛡️ CIVILIAN SHIELD</h1>
    <p>Protecting Lives Across India</p>
    <button class="cta-button" onclick="document.querySelector('.container').scrollIntoView()">Explore Project ↓</button>
</div>

<!-- Main Content -->
<div class="container">
    <!-- Features Section -->
    <section>
        <h2>✨ Key Features</h2>
        <div class="feature-grid">
            <div class="feature-card">
                <h3>🚨 SOS Alerts</h3>
                <p>One-tap emergency alerts to authorities and family with instant location sharing.</p>
            </div>
            <div class="feature-card">
                <h3>📍 Live Map</h3>
                <p>Real-time interactive map with threat zones, hospitals, and safe routes.</p>
            </div>
            <div class="feature-card">
                <h3>👥 Emergency Contacts</h3>
                <p>Manage trusted contacts and send quick SOS alerts to family members.</p>
            </div>
            <div class="feature-card">
                <h3>📊 Threat Intelligence</h3>
                <p>AI-calculated area threat levels with community crowdsourced data.</p>
            </div>
            <div class="feature-card">
                <h3>🔐 Secure Auth</h3>
                <p>OTP-based registration, BCrypt password encryption, JWT tokens.</p>
            </div>
            <div class="feature-card">
                <h3>📱 Responsive UI</h3>
                <p>Beautiful dark-themed interface optimized for mobile and desktop.</p>
            </div>
        </div>
    </section>

    <!-- Dashboard Preview -->
    <section>
        <h2>📸 Live Dashboard Preview</h2>
        <div class="gallery">
            <div class="gallery-item">
                <svg viewBox="0 0 400 300" style="width:100%; height:100%;">
                    <defs>
                        <linearGradient id="grad1" x1="0%" y1="0%" x2="100%" y2="100%">
                            <stop offset="0%" style="stop-color:#050a0f;stop-opacity:1" />
                            <stop offset="100%" style="stop-color:#0a1420;stop-opacity:1" />
                        </linearGradient>
                    </defs>
                    <rect width="400" height="300" fill="url(#grad1)"/>
                    <text x="200" y="40" font-size="24" fill="#00cfff" text-anchor="middle" font-family="Orbitron">🛡️ C.SHIELD</text>
                    <rect x="20" y="60" width="360" height="80" fill="none" stroke="#00cfff" stroke-width="2" rx="10"/>
                    <text x="30" y="85" font-size="12" fill="#00cfff" font-family="Orbitron">AREA THREAT LEVEL</text>
                    <text x="320" y="85" font-size="16" fill="#ffd000" font-family="Orbitron">42%</text>
                    <rect x="30" y="95" width="300" height="8" fill="none" stroke="#00cfff" stroke-width="1" rx="4"/>
                    <rect x="30" y="95" width="126" height="8" fill="#00ff88" rx="4"/>
                    <text x="200" y="180" font-size="14" fill="#00cfff" text-anchor="middle" font-family="Orbitron">QUICK ACTIONS</text>
                    <rect x="20" y="200" width="85" height="60" fill="none" stroke="#00cfff" stroke-width="1" rx="8"/>
                    <rect x="115" y="200" width="85" height="60" fill="none" stroke="#00cfff" stroke-width="1" rx="8"/>
                    <rect x="210" y="200" width="85" height="60" fill="none" stroke="#00cfff" stroke-width="1" rx="8"/>
                    <rect x="305" y="200" width="75" height="60" fill="none" stroke="#00cfff" stroke-width="1" rx="8"/>
                    <text x="63" y="225" font-size="11" fill="#00cfff" text-anchor="middle">🗺️ Route</text>
                    <text x="158" y="225" font-size="11" fill="#00cfff" text-anchor="middle">👥 Family</text>
                    <text x="253" y="225" font-size="11" fill="#00cfff" text-anchor="middle">📡 Offline</text>
                    <text x="343" y="225" font-size="11" fill="#00cfff" text-anchor="middle">🏥 Hospital</text>
                </svg>
            </div>
            <div class="gallery-item">
                <svg viewBox="0 0 400 300" style="width:100%; height:100%;">
                    <defs>
                        <linearGradient id="grad2" x1="0%" y1="0%" x2="100%" y2="100%">
                            <stop offset="0%" style="stop-color:#050a0f;stop-opacity:1" />
                            <stop offset="100%" style="stop-color:#0a1420;stop-opacity:1" />
                        </linearGradient>
                    </defs>
                    <rect width="400" height="300" fill="url(#grad2)"/>
                    <text x="200" y="30" font-size="20" fill="#00cfff" text-anchor="middle" font-family="Orbitron">🗺️ LIVE MAP</text>
                    <circle cx="200" cy="150" r="80" fill="none" stroke="#00cfff" stroke-width="1" opacity="0.3"/>
                    <circle cx="200" cy="150" r="60" fill="none" stroke="#00cfff" stroke-width="1" opacity="0.2"/>
                    <circle cx="200" cy="150" r="8" fill="#00ff88" stroke="#00ff88" stroke-width="2"/>
                    <circle cx="150" cy="120" r="6" fill="#ff4444"/>
                    <circle cx="230" cy="180" r="6" fill="#ffaa00"/>
                    <circle cx="260" cy="140" r="6" fill="#0088ff"/>
                    <text x="10" y="280" font-size="10" fill="#00cfff" font-family="Orbitron">🟢 You  🔴 High Risk  🟡 Medium  🔵 Hospital</text>
                </svg>
            </div>
            <div class="gallery-item">
                <svg viewBox="0 0 400 300" style="width:100%; height:100%;">
                    <defs>
                        <linearGradient id="grad3" x1="0%" y1="0%" x2="100%" y2="100%">
                            <stop offset="0%" style="stop-color:#050a0f;stop-opacity:1" />
                            <stop offset="100%" style="stop-color:#0a1420;stop-opacity:1" />
                        </linearGradient>
                    </defs>
                    <rect width="400" height="300" fill="url(#grad3)"/>
                    <text x="200" y="30" font-size="20" fill="#00cfff" text-anchor="middle" font-family="Orbitron">🚨 ALERTS</text>
                    <rect x="15" y="50" width="370" height="50" fill="none" stroke="#ff4444" stroke-width="1" rx="5"/>
                    <circle cx="30" cy="75" r="4" fill="#ff4444"/>
                    <text x="45" y="75" font-size="11" fill="#ff4444" font-family="Orbitron">Assault at Main Street</text>
                    <text x="45" y="88" font-size="9" fill="#ff6666">Reported 5 min ago</text>
                    <rect x="15" y="110" width="370" height="50" fill="none" stroke="#ffaa00" stroke-width="1" rx="5"/>
                    <circle cx="30" cy="135" r="4" fill="#ffaa00"/>
                    <text x="45" y="135" font-size="11" fill="#ffaa00" font-family="Orbitron">Robbery reported near Park</text>
                    <text x="45" y="148" font-size="9" fill="#ffcc66">Reported 15 min ago</text>
                    <rect x="15" y="170" width="370" height="50" fill="none" stroke="#00ff88" stroke-width="1" rx="5"/>
                    <circle cx="30" cy="195" r="4" fill="#00ff88"/>
                    <text x="45" y="195" font-size="11" fill="#00ff88" font-family="Orbitron">Minor accident cleared</text>
                    <text x="45" y="208" font-size="9" fill="#66ff99">Reported 30 min ago</text>
                </svg>
            </div>
        </div>
    </section>

    <!-- Tech Stack -->
    <section>
        <h2>🛠️ Tech Stack</h2>
        <div class="tech-stack">
            <div class="tech-badge">☕ Java 17</div>
            <div class="tech-badge">🍃 Spring Boot</div>
            <div class="tech-badge">💾 PostgreSQL</div>
            <div class="tech-badge">🔐 JWT Auth</div>
            <div class="tech-badge">🌐 WebSocket</div>
            <div class="tech-badge">⚛️ JavaScript</div>
            <div class="tech-badge">🗺️ Leaflet.js</div>
            <div class="tech-badge">🐳 Docker</div>
            <div class="tech-badge">☁️ Render.com</div>
            <div class="tech-badge">📧 Brevo SMTP</div>
        </div>
    </section>

    <!-- Statistics -->
    <section>
        <h2>📊 Project Statistics</h2>
        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-value">6</div>
                <div class="stat-label">FRONTEND PAGES</div>
            </div>
            <div class="stat-card">
                <div class="stat-value">7</div>
                <div class="stat-label">REST ENDPOINTS</div>
            </div>
            <div class="stat-card">
                <div class="stat-value">3</div>
                <div class="stat-label">DATABASE TABLES</div>
            </div>
            <div class="stat-card">
                <div class="stat-value">100%</div>
                <div class="stat-label">RESPONSIVE</div>
            </div>
        </div>
    </section>

    <!-- Installation -->
    <section>
        <h2>🚀 Quick Start</h2>
        <div class="code-block">
            <code>
# Clone Repository<br>
git clone https://github.com/pvasu9055-hash/CivilianShield.git<br>
<br>
# Build Project<br>
./gradlew clean build<br>
<br>
# Run Application<br>
./gradlew bootRun<br>
<br>
# Access Application<br>
http://localhost:8080/login.html
            </code>
        </div>
    </section>

    <!-- Development Timeline -->
    <section>
        <h2>📅 Development Timeline</h2>
        <div class="timeline">
            <div class="timeline-item">
                <h4>Phase 1: Core Setup</h4>
                <p>Spring Boot project initialization, database schema, user authentication system</p>
            </div>
            <div class="timeline-item">
                <h4>Phase 2: SOS & Threats</h4>
                <p>Emergency alert system, threat reporting, real-time updates via WebSocket</p>
            </div>
            <div class="timeline-item">
                <h4>Phase 3: Frontend</h4>
                <p>Dashboard, map integration, alerts page, profile management</p>
            </div>
            <div class="timeline-item">
                <h4>Phase 4: Deployment</h4>
                <p>Docker containerization, Render cloud deployment, production testing</p>
            </div>
        </div>
    </section>

    <!-- CTA Section -->
    <section style="text-align: center; padding: 60px 20px;">
        <h2 style="justify-content: center;">Ready to Contribute?</h2>
        <p style="font-size: 18px; color: rgba(255, 255, 255, 0.7); margin-bottom: 30px;">Join the mission to protect lives across India</p>
        <button class="cta-button">⭐ Star on GitHub</button>
        <button class="cta-button" style="margin-left: 20px;">📧 Get in Touch</button>
    </section>
</div>

<!-- Footer -->
<footer>
    <p>🛡️ Civilian Shield — Protecting Lives Across India</p>
    <p>© 2026 Vasu Penkey Sri Vasu. Licensed under MIT License.</p>
    <p style="margin-top: 20px; font-size: 12px;">
        <a href="https://github.com/pvasu9055-hash/CivilianShield" style="color: #00cfff; text-decoration: none;">GitHub</a> | 
        <a href="mailto:pvasu9055@gmail.com" style="color: #00cfff; text-decoration: none;">Email</a>
    </p>
</footer>

<script>
    // 3D Hero Background with Three.js
    const canvas = document.getElementById('heroCanvas');
    const scene = new THREE.Scene();
    const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
    const renderer = new THREE.WebGLRenderer({ canvas, alpha: true });
    
    renderer.setSize(window.innerWidth, window.innerHeight);
    renderer.setClearColor(0x050a0f, 0.1);
    
    camera.position.z = 5;

    // Create rotating 3D shield
    const geometry = new THREE.OctahedronGeometry(2, 0);
    const material = new THREE.MeshStandardMaterial({
        color: 0x00cfff,
        emissive: 0x00cfff,
        emissiveIntensity: 0.2,
        wireframe: true,
        metalness: 0.8,
        roughness: 0.2
    });
    const shield = new THREE.Mesh(geometry, material);
    scene.add(shield);

    // Create particles
    const particlesGeometry = new THREE.BufferGeometry();
    const particleCount = 100;
    const positionArray = new Float32Array(particleCount * 3);
    
    for (let i = 0; i < particleCount * 3; i++) {
        positionArray[i] = (Math.random() - 0.5) * 10;
    }
    
    particlesGeometry.setAttribute('position', new THREE.BufferAttribute(positionArray, 3));
    const particlesMaterial = new THREE.PointsMaterial({
        color: 0x00ff88,
        size: 0.05,
        sizeAttenuation: true
    });
    const particles = new THREE.Points(particlesGeometry, particlesMaterial);
    scene.add(particles);

    // Lighting
    const light = new THREE.PointLight(0x00cfff, 1, 100);
    light.position.set(5, 5, 5);
    scene.add(light);
    
    const ambientLight = new THREE.AmbientLight(0xffffff, 0.5);
    scene.add(ambientLight);

    // Animation loop
    function animate() {
        requestAnimationFrame(animate);
        
        shield.rotation.x += 0.005;
        shield.rotation.y += 0.01;
        shield.rotation.z += 0.005;
        
        particles.rotation.x += 0.0002;
        particles.rotation.y += 0.0003;
        
        renderer.render(scene, camera);
    }
    
    animate();

    // Handle window resize
    window.addEventListener('resize', () => {
        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(window.innerWidth, window.innerHeight);
    });

    // Scroll progress bar
    window.addEventListener('scroll', () => {
        const scrollTop = document.documentElement.scrollTop;
        const docHeight = document.documentElement.scrollHeight - window.innerHeight;
        const scrolled = (scrollTop / docHeight) * 100;
        document.getElementById('scrollProgress').style.width = scrolled + '%';
    });

    // Smooth scroll behavior
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({ behavior: 'smooth' });
            }
        });
    });
</script>

</body>
</html>
