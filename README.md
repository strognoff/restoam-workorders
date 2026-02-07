# RestoAM Workorders
Workorders module for RestoAM.

## Story / fields
A workorder represents a unit of work to be executed at a Location and optionally on an Asset.

Fields:
- title
- description
- status (OPEN, IN_PROGRESS, DONE, CANCELLED)
- priority (LOW, MEDIUM, HIGH, URGENT)
- assignedTo
- locationId (UUID)
- assetId (UUID)
- scheduledStart (ISO-8601)
- scheduledEnd (ISO-8601)
- createdDate (ISO-8601)
- notes

## Endpoints
- GET /restoam/workorders/{id}
- GET /restoam/workorders?page=0&size=10&sortBy=createdDate&sortDir=desc&title=&status=&priority=&locationId=&assetId=
- POST /restoam/workorders
- PUT /restoam/workorders/{id}
- DELETE /restoam/workorders/{id}

### OpenAPI
- /v3/api-docs
- /swagger-ui.html

## Running the Application with Docker

```bash
docker build -t restoam-workorders:latest .
# redirect the port
docker run -d -p 8082:8080 --name restoam-workorders-container restoam-workorders:latest
```
