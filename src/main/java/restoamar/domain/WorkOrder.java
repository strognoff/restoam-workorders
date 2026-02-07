package restoamar.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.time.Instant;
import java.util.UUID;

@Entity
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private String assignedTo;
    private UUID locationId;
    private UUID assetId;
    private Instant scheduledStart;
    private Instant scheduledEnd;
    private Instant createdDate;
    private String notes;

    @Enumerated(EnumType.STRING)
    private WorkOrderStatus status;

    @Enumerated(EnumType.STRING)
    private WorkOrderPriority priority;

    public WorkOrder() {}

    public WorkOrder(UUID id, String title, String description, String assignedTo, UUID locationId, UUID assetId,
                     Instant scheduledStart, Instant scheduledEnd, Instant createdDate, String notes,
                     WorkOrderStatus status, WorkOrderPriority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignedTo = assignedTo;
        this.locationId = locationId;
        this.assetId = assetId;
        this.scheduledStart = scheduledStart;
        this.scheduledEnd = scheduledEnd;
        this.createdDate = createdDate;
        this.notes = notes;
        this.status = status;
        this.priority = priority;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
    public UUID getLocationId() { return locationId; }
    public void setLocationId(UUID locationId) { this.locationId = locationId; }
    public UUID getAssetId() { return assetId; }
    public void setAssetId(UUID assetId) { this.assetId = assetId; }
    public Instant getScheduledStart() { return scheduledStart; }
    public void setScheduledStart(Instant scheduledStart) { this.scheduledStart = scheduledStart; }
    public Instant getScheduledEnd() { return scheduledEnd; }
    public void setScheduledEnd(Instant scheduledEnd) { this.scheduledEnd = scheduledEnd; }
    public Instant getCreatedDate() { return createdDate; }
    public void setCreatedDate(Instant createdDate) { this.createdDate = createdDate; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public WorkOrderStatus getStatus() { return status; }
    public void setStatus(WorkOrderStatus status) { this.status = status; }
    public WorkOrderPriority getPriority() { return priority; }
    public void setPriority(WorkOrderPriority priority) { this.priority = priority; }
}
