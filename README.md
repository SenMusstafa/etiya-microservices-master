# Spring-Cloud Microservices

A Spring Cloud microservices skeleton demonstrating service discovery, centralized configuration, an API gateway, and event-driven communication between services.

## Architecture

```
                        ┌──────────────────┐
                        │  Discovery Server │  (Eureka, :8181)
                        └────────▲─────────┘
                                 │ registers
        ┌────────────────────────┼────────────────────────┐
        │                        │                        │
┌───────▼───────┐        ┌───────▼───────┐        ┌────────▼────────┐
│ product-service│        │ order-service │        │ notification-svc│
└───────▲───────┘        └───────┬───────┘        └────────▲────────┘
        │  lb:// via gateway     │ Kafka: OrderCreatedEvent │
        │                        └───────────────────────────┘
┌───────┴──────────────────────────────┐
│           API Gateway (:8010)        │
└──────────────────────────────────────┘
                 ▲
                 │ pulls config from
        ┌────────┴─────────┐         ┌─────────────────────────────┐
        │  Config Server    │────────▶│ own fork of config repo (Git)│
        │      (:8888)      │         └─────────────────────────────┘
        └───────────────────┘
```

- **Discovery Server** — a standalone Eureka server; every other service registers with it so they can find each other by name instead of hardcoded hosts/ports.
- **Config Server** — serves externalized configuration (e.g. `order-service-dev.properties`) from a Git repository rather than bundling config inside each service's jar. `order-service` pulls its config at startup via `spring.config.import=configserver:...`.
- **API Gateway** — a single entry point (`:8010`) that routes incoming requests to the right service using Eureka-based load balancing (`lb://product-service`, `lb://order-service`), plus a route exposing the Eureka dashboard through the gateway itself.
- **Event-driven order flow** — `order-service` publishes an `OrderCreatedEvent` to Kafka when an order is submitted; `notification-service` consumes it via `@KafkaListener` and reacts independently, decoupling the two services instead of a direct synchronous call.
- **common module** — a shared library (`com.etiya.common`) holding the `OrderCreatedEvent` contract used by both the producer and the consumer, so the event shape stays consistent across services.
- **Inter-service calls** — `order-service` also calls `product-service` directly via `WebClient`/Feign (`ProductClient`) for synchronous lookups (e.g. checking stock), alongside the asynchronous Kafka flow — showing both communication styles in one system.

## Services

| Service | Port | Role |
|---|---|---|
| `discoveryserver` | `8181` | Eureka service registry |
| `configserver` | `8888` | Centralized configuration, backed by a Git repo |
| `gateway` | `8010` | Single entry point, routes to services by path |
| `productservice` | — | Product catalog / stock |
| `orderservice` | — | Order submission, publishes `OrderCreatedEvent` to Kafka |
| `notificationservice` | — | Consumes `OrderCreatedEvent`, handles notifications |
| `common` | — | Shared library with event contracts |

## Tech

- Java, Spring Boot, Spring Cloud (Eureka, Config Server, Gateway)
- Apache Kafka (event-driven messaging)
- PostgreSQL
- Docker & Docker Compose
- Maven (multi-module)

## Running with Docker Compose

```bash
git clone https://github.com/SenMusstafa/etiya-microservices-master.git
cd etiya-microservices-master/etiya-microservices2-master
docker compose up
```

This brings up the config server (pointed at this project's own config repo), Kafka, Zookeeper, and PostgreSQL. Build and run the discovery server, gateway, and individual services separately (`mvn spring-boot:run` in each module) once the infrastructure containers are healthy.

## Notes

This started as a study project for learning the Spring Cloud microservices stack (service discovery, centralized config, API gateway, event-driven communication) and has since been cleaned up to run independently — configuration now points to this project's own repositories rather than external ones.
