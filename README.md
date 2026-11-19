# Taller 7 - Kubernetes (Minikube)

Infraestructuras Paralelas y Distribuidas (750023C). API Spring Boot + PostgreSQL desplegada en Minikube.

- `api/`: API Spring Boot y Dockerfile.
- `k8s/`: manifiestos. Copie `01-secret.yaml.example` a `01-secret.yaml` y cambie la contraseña (en `POSTGRES_PASSWORD` y `SPRING_DATASOURCE_PASSWORD`) antes de aplicar.

Endpoints:

- `GET /api/items`: lista los ítems.
- `POST /api/items`: crea un ítem, cuerpo JSON `{"name": "..."}`.
- `GET /api/info`: información de la instancia.
- `GET /actuator/health`: estado de salud.

Despliegue: `docker build -t taller7-api:1.0 api && minikube image load taller7-api:1.0 && kubectl apply -f k8s/`

Consumo por un compañero vía Tailscale: en la máquina que corre Minikube,

`kubectl port-forward --address 0.0.0.0 svc/api 8085:8085 -n taller7-app`

y el compañero ejecuta `curl http://<IP-tailscale>:8085/api/items`.
