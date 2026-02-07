package restoamar.service;

import org.springframework.stereotype.Service;
import restoamar.domain.WorkOrder;
import restoamar.domain.WorkOrderStatus;
import restoamar.domain.WorkOrderPriority;
import restoamar.repository.WorkOrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrderServiceImpl(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    @Override
    public WorkOrder save(WorkOrder workOrder) {
        if (workOrder.getId() == null) {
            workOrder.setId(UUID.randomUUID());
        }
        if (workOrder.getCreatedDate() == null) {
            workOrder.setCreatedDate(Instant.now());
        }
        if (workOrder.getStatus() == null) {
            workOrder.setStatus(WorkOrderStatus.OPEN);
        }
        if (workOrder.getPriority() == null) {
            workOrder.setPriority(WorkOrderPriority.MEDIUM);
        }
        return workOrderRepository.save(workOrder);
    }

    @Override
    public WorkOrder update(WorkOrder workOrder) {
        if (workOrder.getCreatedDate() == null && workOrder.getId() != null) {
            WorkOrder existing = workOrderRepository.findById(workOrder.getId()).orElse(null);
            if (existing != null) {
                workOrder.setCreatedDate(existing.getCreatedDate());
            }
        }
        if (workOrder.getStatus() == null) {
            workOrder.setStatus(WorkOrderStatus.OPEN);
        }
        if (workOrder.getPriority() == null) {
            workOrder.setPriority(WorkOrderPriority.MEDIUM);
        }
        return workOrderRepository.save(workOrder);
    }

    @Override
    public WorkOrder findOne(UUID id) {
        return workOrderRepository.findById(id).orElse(null);
    }

    @Override
    public List<WorkOrder> findAll() {
        return workOrderRepository.findAll();
    }

    @Override
    public Page<WorkOrder> findAll(Pageable pageable, String title, WorkOrderStatus status, WorkOrderPriority priority, UUID locationId, UUID assetId) {
        String titleFilter = title == null ? "" : title;
        if (locationId != null) {
            return workOrderRepository.findByLocationId(locationId, pageable);
        }
        if (assetId != null) {
            return workOrderRepository.findByAssetId(assetId, pageable);
        }
        if (status != null && priority != null) {
            return workOrderRepository.findByTitleContainingIgnoreCaseAndStatusAndPriority(titleFilter, status, priority, pageable);
        }
        return workOrderRepository.findByTitleContainingIgnoreCase(titleFilter, pageable);
    }

    @Override
    public boolean delete(UUID id) {
        WorkOrder workOrder = workOrderRepository.findById(id).orElse(null);
        if (workOrder != null) {
            workOrderRepository.delete(workOrder);
            return true;
        }
        return false;
    }
}
