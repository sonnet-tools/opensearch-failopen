            "99%",
        assertEquals(0.0, FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(s), 0.0);
    }
    public void testMetadataBlockSizeAcceptsMinimum() {
            () -> FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "").build())
        assertEquals(
/**
    public void testMetadataCacheRatioRejectsFiftyPercent() {
        );
        IllegalArgumentException ex = expectThrows(
        );
            FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(
        );
            )
        assertTrue(ex.getMessage().contains("block_cache.foyer.metadata_cache_ratio"));
        );
            "0.25",
    }
        );
            "49%",
        expectThrows(
    }
    public void testCacheSizeRejectsNegative() {
            () -> FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(
import org.opensearch.test.OpenSearchTestCase;
            FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(
        );
                Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", -0.01).build()
    }
            )
            )
            FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "io_uring").build())
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "10%").build()
            IllegalArgumentException.class,
    }
    }
    }
        );
        assertEquals(new ByteSizeValue(128, ByteSizeUnit.MB), FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.EMPTY));
        );
import org.opensearch.common.settings.Settings;
            () -> FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(
            IllegalArgumentException.class,
        assertTrue(ex.getMessage().contains("psync"));
        );
        );
            "auto",
    }
            )
            )
            () -> FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
            IllegalArgumentException.class,
package org.opensearch.blockcache.foyer;
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "notanumber").build()
    }
        );
        assertTrue(ex.getMessage().contains("block_cache.foyer.size"));
    }
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
            "50%",
    }
        assertEquals(
            FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "auto").build())
    }
            () -> FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
    public void testMetadataBlockSizeRejectsBelowMinimum() {
        expectThrows(
        assertEquals(0.70, FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(Settings.EMPTY), 0.001);
        assertEquals(
            )
        );
    }
        );
    }
            FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "50%").build())
            IllegalArgumentException.class,
        );
        assertTrue(ex.getMessage().contains("io_uring"));
    public void testMetadataCacheRatioDefault() {
        assertEquals(
                Settings.builder().put("block_cache.foyer.metadata_block_size", "128mb").build()
            new ByteSizeValue(1, ByteSizeUnit.MB),
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertEquals(
    // ── BLOCK_SIZE_SETTING ────────────────────────────────────────────────────
        expectThrows(
            "psync",
        );
    }
    // ── KEY_INDEX_SWEEP_THRESHOLD_SETTING ─────────────────────────────────────
    public void testMetadataCacheRatioAcceptsPercentage() {
        expectThrows(
    public void testBlockSizeRejectsBelowMinimum() {
    public void testMetadataCacheRatioAcceptsNearMaximum() {
        assertEquals(
            IllegalArgumentException.class,
    }
 */
                Settings.builder().put("block_cache.foyer.metadata_block_size", "129mb").build()
            )
            IllegalArgumentException.class,
        // 1.0 = only sweep when cache is 100% full; valid boundary
            () -> FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.block_size", "512kb").build())
        assertEquals(
            "io_uring",
        assertEquals(
    }
            FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "0.25").build())
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
    }
    public void testBlockSizeRejectsAboveMaximum() {
        );
        );
    public void testBlockSizeAcceptsMaximum() {
    public void testCacheSizeAcceptsNearMaximum() {
        );
    public void testCacheSizeRejectsRatioOne() {
        expectThrows(
        );
        );
    public void testSweepThresholdDefaultIs0dot70() {
            () -> FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(
            () -> FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "notanumber").build())
    }
            FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "psync").build())
            IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "50%").build()
        assertEquals(
        expectThrows(
    }
 * compatible open source license.
            () -> FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "-1%").build())
    }
        expectThrows(
        Settings s = Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", 0.5).build();
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
        IllegalArgumentException ex = expectThrows(
        );
    public void testIoEngineAcceptsAuto() {
    public void testSweepThresholdZeroCanBeSetExplicitly() {
            IllegalArgumentException.class,
            () -> FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "libaio").build())
            IllegalArgumentException.class,
            IllegalArgumentException.class,
            IllegalArgumentException.class,
    public void testMetadataCacheRatioRejectsNegative() {
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "0.05").build()
            IllegalArgumentException.class,
    public void testBlockSizeAcceptsMinimum() {
            "0.05",
    public void testMetadataBlockSizeRejectsAboveMaximum() {
        expectThrows(
    }
    public void testCacheSizeAcceptsZero() {
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "-1%").build()
    public void testCacheSizeAcceptsRatioForm() {
            )
                Settings.builder().put("block_cache.foyer.metadata_block_size", "1mb").build()
    public void testBlockSizeDefault() {
        IllegalArgumentException ex = expectThrows(
    public void testMetadataCacheRatioRejectsGarbage() {
            )
            )
    public void testIoEngineIsCaseSensitive() {
        // 0.0 = always sweep (no threshold guard)
    public void testCacheSizeAcceptsPercentage() {
    }
            IllegalArgumentException.class,
        assertEquals(
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "0%").build()
    }
    public void testSweepThresholdRejectsNegative() {
        assertEquals(
            IllegalArgumentException.class,
    public void testMetadataBlockSizeDefault() {
        );
    public void testIoEngineAcceptsPsync() {
    }
            IllegalArgumentException.class,
        assertEquals(new ByteSizeValue(8, ByteSizeUnit.MB), FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(Settings.EMPTY));
        );
 * The OpenSearch Contributors require contributions made to
            FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "99%").build())
        );
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException.class,
public class FoyerBlockCacheSettingsTests extends OpenSearchTestCase {
    }
            () -> FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(
        expectThrows(
        assertEquals(0.5, FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(s), 0.001);
    public void testIoEngineAcceptsIoUring() {
 */
            () -> FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.block_size", "513mb").build())
        assertEquals("5%", FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(Settings.EMPTY));
    }
                Settings.builder().put("block_cache.foyer.metadata_block_size", "512kb").build()
    }
        );
            () -> FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "1.0").build())
    }
/*
        );
    }
    }
    public void testCacheSizeRejectsHundredPercent() {
    }
            "10%",
    }
    public void testIoEngineDefault() {
            () -> FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
    }
        expectThrows(
    public void testSweepThresholdRejectsAboveOne() {
        expectThrows(
 * Unit tests for {@link FoyerBlockCacheSettings} validation and defaults.
    // ── METADATA_CACHE_RATIO_SETTING ─────────────────────────────────────────
        assertEquals("50%", FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.EMPTY));
    public void testIoEngineRejectsEmpty() {
    }
            )
            new ByteSizeValue(1, ByteSizeUnit.MB),
    public void testCacheSizeRejectsGarbage() {
    // ── IO_ENGINE_SETTING ─────────────────────────────────────────────────────
            FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.block_size", "1mb").build())
            () -> FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "PSYNC").build())
            FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.block_size", "512mb").build())
            () -> FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "100%").build())
            )
            "0%",
    // ── METADATA_BLOCK_SIZE_SETTING ──────────────────────────────────────────
    public void testSweepThresholdAccepts0dot5() {
        expectThrows(
        assertEquals(1.0, FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(s), 0.0);
    public void testMetadataCacheRatioAcceptsZero() {
                Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", 1.01).build()
    // ── CACHE_SIZE_SETTING ────────────────────────────────────────────────────
        expectThrows(
        Settings s = Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", 1.0).build();
    }
            new ByteSizeValue(128, ByteSizeUnit.MB),
        );
        assertTrue(ex.getMessage().contains("auto"));
            )
        assertEquals("psync", FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.EMPTY));
 *
    public void testMetadataBlockSizeAcceptsMaximum() {
    public void testIoEngineRejectsUnknown() {
    public void testCacheSizeDefault() {
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "49%").build()
        assertEquals(
    }
        assertEquals(
    }
    }
            new ByteSizeValue(512, ByteSizeUnit.MB),
        );
        );
    public void testSweepThresholdAccepts1dot0() {
        assertEquals("0%", FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "0%").build()));
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
        );
        Settings s = Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", 0.0).build();
}
    public void testMetadataCacheRatioAcceptsRatioForm() {
    }
import org.opensearch.core.common.unit.ByteSizeValue;
