# 💼 Inditex Ecommerce - Core Platform (Spring Boot)

Este proyecto es una API REST desarrollada con Spring Boot, que forma parte del sistema core de ecommerce de Inditex. El servicio expone precios aplicables a productos según fecha, marca y prioridad de tarifa.

---

## 📆 Características principales

- ✅ Arquitectura hexagonal limpia
- ✅ Spring Boot 3.4.4 + Java 17
- ✅ Base de datos en memoria H2 con datos precargados
- ✅ Validaciones y control de excepciones
- ✅ Documentación Swagger (OpenAPI)
- ✅ Tests unitarios + RestAssured
- ✅ Docker + Docker Compose
- ✅ Análisis de calidad con SonarQube

---

## 🚀 ¿Cómo ejecutar la aplicación?

### Opcion 1: Local (sin Docker)

```bash
./mvnw spring-boot:run
```

> Luego accede a: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Opcion 2: Con Docker Compose

```bash
docker-compose up --build
```

Esto levantará:
- La API en `localhost:8080`
- SonarQube en `localhost:9000`

---

## 🥪 Pruebas

### 🔮 Unitarias (PriceService)

```bash
./mvnw test
```

### 🤖 E2E (RestAssured + MockMvc)

Se testean 5 casos definidos por la consigna usando fechas específicas y prioridad de tarifas.

---

## 🛠️ Endpoints

### `GET /api/prices`

| Parámetro   | Tipo   | Formato              | Obligatorio |
|-------------|--------|----------------------|-------------|
| `date`      | String | yyyy-MM-dd-HH.mm.ss  | ✅          |
| `productId` | Long   |                      | ✅          |
| `brandId`   | Long   |                      | ✅          |

📌 Ejemplo:

```
GET /api/prices?date=2020-06-14-10.00.00&productId=35455&brandId=1
```

---

## 📊 Análisis de código con SonarQube

1. Levanta Sonar:

```bash
docker-compose up -d sonarqube
```

2. Ejecuta análisis desde PowerShell:

```powershell
.\run-sonar.ps1
```

> Asegúrate de editar el archivo con tu token de Sonar.

Accede al panel en:  
[http://localhost:9000](http://localhost:9000) (admin/admin)

---

## 📃 Base de datos H2

- Acceso: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- URL JDBC: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: *(vacío)*

---

## 📂 Estructura hexagonal

```
└── coreplatform
    ├── application      → Servicios de aplicación
    ├── domain           → Modelos y puertos
    ├── infrastructure   → Controladores, repositorios y configuración
    └── resources         → Configs y scripts SQL
```

---

## 🗃️ Requisitos

- Java 17
- Maven 3.9.x
- Docker + Docker Compose (opcional)

---

## 🤝 Autor

Este ejercicio fue realizado como prueba técnica para el equipo de plataforma core de Inditex.  
Cualquier mejora o sugerencia es bienvenida 🙌