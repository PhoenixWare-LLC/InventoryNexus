InventoryNexus is a robust, enterprise-grade backend engine designed to serve as a central "Nexus" for multi-channel commerce. It acts as the single source of truth for orders and inventory, bridging the gap between major marketplaces (Amazon, Shopify, etc.) and modern frontend applications (React, Angular).

Built with a "Security-First" philosophy, InventoryNexus is designed to be compliant with **NIST 800-53** standards when deployed in a qualified environment.

##  Core Mission
To provide a stateless, high-performance API that synchronizes products and orders across disparate platforms, ensuring operational efficiency and data integrity.

##  Tech Stack
- **Framework:** Jakarta EE & Spring Boot 4 (Java 25)
- **Database:** PostgreSQL (Optimized for relational integrity and performance)
- **Security & IAM:** Keycloak (OIDC/OAuth2)
- **Secrets Management:** HashiCorp Vault
- **API Style:** RESTful (Stateless)
- **DevOps:** Docker-ready for database and security infrastructure
- **Jenkins:** Automated packaging of the application
- **Terraform:** Automated Deployment and provisioning of Virtual machines
- **Kubernetes:** Full support for horizontal and vertical scaling

##  Security Features
- **Centralized Identity:** Full integration with Keycloak for user management.
- **Secrets Protection:** Zero hardcoded keys; all sensitive credentials (API keys, DB passwords) are fetched from HashiCorp Vault.
- **Audit Logging:** Built-in tracking of all entity changes and user actions.
- **Multi-Factor Authentication (MFA):** Enforced at the identity provider level.
- **NIST 800-53 Ready:** Architecture supports Access Control, Audit & Accountability, and System & Communications Protection controls.

##  Roadmap
- [ ] **Phase 1:** Basic Schema with Authentication including MFA, OAuth2.0, IdP integration (KeyCloak), Session Management, RBAC, ABAC
- [ ] **Phase 2:** Complete Schema mapping with API calls and Business Logic
- [ ] **Phase 3:** Order/Product Pulling (Amazon/Shopify Read-only)
- [ ] **Phase 4:** Inventory Synchronization & Nexus Dashboard
- [ ] **Phase 5:** Fulfillment & Marketplace Listing (Push updates)
- [ ] **Phase 6:** Stripe Integration & PCI Compliance assessment

---
*Developed by PhoenixWare*