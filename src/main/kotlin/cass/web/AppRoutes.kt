package cass.web

import org.springframework.web.bind.annotation.*
import restoamar.domain.Asset
import restoamar.service.AssetService
import java.util.*

@RestController
@RequestMapping("/restoar")
class AppRoutes(private val assetService: AssetService) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): Asset? {
        return assetService.findOne(id)
    }

    @PostMapping("/")
    fun save(@RequestBody asset: Asset): Asset {
        return assetService.save(asset)
    }

    @PutMapping("/")
    fun update(@RequestBody asset: Asset): Asset {
        return assetService.update(asset)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): Boolean {
        return assetService.delete(id)
    }

    @GetMapping("/assets/all")
    fun getAllAssets(): List<Asset> {
        return assetService.findAll()
    }
}