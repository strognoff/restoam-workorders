package com.cechinel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restoamar.domain.Asset;
import restoamar.repository.AssetRepository;
import restoamar.service.AssetServiceImpl;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class DataRepositoryTest {

    private AssetRepository mockAssetRepository;
    private AssetServiceImpl assetServiceImpl;

    private final UUID RANDOM_ASSET_ID = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        mockAssetRepository = mock(AssetRepository.class);
        assetServiceImpl = new AssetServiceImpl(mockAssetRepository);
    }

    @Test
    @DisplayName("insert data and verify insertion")
    public void testSaveAsset() {
        // Arrange
        Asset asset = assetRecord();
        when(mockAssetRepository.save(asset)).thenReturn(asset);

        // Act
        assetServiceImpl.save(asset);

        // Assert
        verify(mockAssetRepository).save(asset);
    }

    private Asset assetRecord() {
        final String name = "testasset1";
        final String location = "testasset1";
        final String description = "testasset1";
        final Double cost = 100.00;
        return new Asset(RANDOM_ASSET_ID, name, description, location,cost);
    }
}
