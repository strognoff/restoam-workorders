package restoamar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import restoamar.domain.WorkOrder;
import restoamar.domain.WorkOrderStatus;
import restoamar.domain.WorkOrderPriority;
import restoamar.service.WorkOrderService;

import java.util.UUID;

@RestController
@RequestMapping("/restoam/workorders")
public class ApplicationRoutes {

    private final WorkOrderService workOrderService;

    @Autowired
    public ApplicationRoutes(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrder> get(@PathVariable UUID id) {
        WorkOrder workOrder = workOrderService.findOne(id);
        if (workOrder == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workOrder);
    }

    @PostMapping("")
    public ResponseEntity<WorkOrder> save(@RequestBody WorkOrder workOrder) {
        WorkOrder saved = workOrderService.save(workOrder);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrder> update(@PathVariable UUID id, @RequestBody WorkOrder workOrder) {
        workOrder.setId(id);
        WorkOrder updated = workOrderService.update(workOrder);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boolean deleted = workOrderService.delete(id);
        if (deleted) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<Page<WorkOrder>> getAllWorkOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdDate") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) WorkOrderStatus status,
            @RequestParam(required = false) WorkOrderPriority priority,
            @RequestParam(required = false) UUID locationId,
            @RequestParam(required = false) UUID assetId
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<WorkOrder> workOrders = workOrderService.findAll(pageable, title, status, priority, locationId, assetId);
        return ResponseEntity.ok(workOrders);
    }
}
