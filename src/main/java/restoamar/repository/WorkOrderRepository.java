package restoamar.repository;

import restoamar.domain.WorkOrder;
import restoamar.domain.WorkOrderStatus;
import restoamar.domain.WorkOrderPriority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, UUID> {
    Page<WorkOrder> findByTitleContainingIgnoreCaseAndStatusAndPriority(
            String title, WorkOrderStatus status, WorkOrderPriority priority, Pageable pageable);

    Page<WorkOrder> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<WorkOrder> findByLocationId(UUID locationId, Pageable pageable);

    Page<WorkOrder> findByAssetId(UUID assetId, Pageable pageable);
}
