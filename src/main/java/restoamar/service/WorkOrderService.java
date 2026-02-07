package restoamar.service;

import restoamar.domain.WorkOrder;
import restoamar.domain.WorkOrderStatus;
import restoamar.domain.WorkOrderPriority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface WorkOrderService {
    WorkOrder save(WorkOrder workOrder);
    WorkOrder update(WorkOrder workOrder);
    WorkOrder findOne(UUID id);
    List<WorkOrder> findAll();
    Page<WorkOrder> findAll(Pageable pageable, String title, WorkOrderStatus status, WorkOrderPriority priority, UUID locationId, UUID assetId);
    boolean delete(UUID id);
}
