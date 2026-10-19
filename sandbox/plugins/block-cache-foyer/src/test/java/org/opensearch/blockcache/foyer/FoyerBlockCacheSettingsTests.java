    // ── CACHE_SIZE_SETTING ────────────────────────────────────────────────────
        );
        assertEquals(
    }  
            )
    }
                Settings.builder().put("block_cache.foyer.metadata_block_size", "1mb").build()
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "10%").build()  
        );
    }
        );
            () -> FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.block_size", "513mb").build())
            new ByteSizeValue(128, ByteSizeUnit.MB),
            () -> FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "1.0").build())  
    }
    }
            IllegalArgumentException.class,
        );  
        assertEquals(  
        assertTrue(ex.getMessage().contains("block_cache.foyer.size"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("0%", FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "0%").build()));
public class FoyerBlockCacheSettingsTests extends OpenSearchTestCase {  
            FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.block_size", "512mb").build())  
            FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "99%").build())
                Settings.builder().put("block_cache.foyer.metadata_block_size", "512kb").build()
    public void testIoEngineDefault() {
            FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.block_size", "1mb").build())
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
        assertEquals(
    }  
            () -> FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "-1%").build())
        );
                Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", -0.01).build()  
            "10%",
        );
        expectThrows(
        assertEquals(  
        );
        expectThrows(
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
            )
            FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(  
    }  
    public void testMetadataCacheRatioAcceptsZero() {
    public void testMetadataCacheRatioRejectsFiftyPercent() {
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
        );  
    }
            )
        expectThrows(
        // 1.0 = only sweep when cache is 100% full; valid boundary  
                Settings.builder().put("block_cache.foyer.metadata_block_size", "129mb").build()
    public void testMetadataBlockSizeAcceptsMaximum() {  
        expectThrows(  
    public void testMetadataBlockSizeDefault() {
        );
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "notanumber").build()
        );  
        assertEquals(
    public void testIoEngineAcceptsPsync() {  
    public void testBlockSizeRejectsBelowMinimum() {
    }  
            )
            "psync",
    }  
            )
            IllegalArgumentException.class,
            FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(  
            IllegalArgumentException.class,
            () -> FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "100%").build())  
        );
            IllegalArgumentException.class,
            "99%",
    // ── BLOCK_SIZE_SETTING ────────────────────────────────────────────────────
    }
        expectThrows(  
    public void testBlockSizeDefault() {
        assertEquals(  
    }
    // ── KEY_INDEX_SWEEP_THRESHOLD_SETTING ─────────────────────────────────────  
            () -> FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
            IllegalArgumentException.class,
            FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "auto").build())
    }
    public void testSweepThresholdAccepts0dot5() {  
    }  
    }
    }  
    }
    public void testIoEngineRejectsEmpty() {
    public void testMetadataCacheRatioAcceptsNearMaximum() {
            )
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "0%").build()  
        expectThrows(
            )
            )
    public void testSweepThresholdZeroCanBeSetExplicitly() {  
    public void testIoEngineAcceptsIoUring() {
            () -> FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(  
            )
            () -> FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(  
 * compatible open source license.
            FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "0.25").build())  
        assertTrue(ex.getMessage().contains("block_cache.foyer.metadata_cache_ratio"));  
            )
        assertEquals(1.0, FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(s), 0.0);
    public void testMetadataBlockSizeRejectsBelowMinimum() {  
        assertEquals(
import org.opensearch.common.settings.Settings;
            )
            () -> FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "libaio").build())
            IllegalArgumentException.class,  
    public void testMetadataBlockSizeAcceptsMinimum() {  
        assertEquals(  
        );  
import org.opensearch.core.common.unit.ByteSizeValue;  
 */  
    public void testIoEngineIsCaseSensitive() {  
        );  
        );  
            "io_uring",  
    }
        );  
    public void testCacheSizeAcceptsZero() {
            IllegalArgumentException.class,
    }
            new ByteSizeValue(1, ByteSizeUnit.MB),
            IllegalArgumentException.class,
        assertEquals(0.70, FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(Settings.EMPTY), 0.001);  
    }  
        assertEquals("5%", FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(Settings.EMPTY));
        IllegalArgumentException ex = expectThrows(
        );  
 * The OpenSearch Contributors require contributions made to  
        IllegalArgumentException ex = expectThrows(  
        Settings s = Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", 0.0).build();
    }  
        );  
            FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "50%").build())
        assertEquals(
        );
                Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", 1.01).build()  
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "-1%").build()
        assertEquals(new ByteSizeValue(128, ByteSizeUnit.MB), FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.EMPTY));
            new ByteSizeValue(1, ByteSizeUnit.MB),
    }
        Settings s = Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", 0.5).build();
    public void testCacheSizeAcceptsNearMaximum() {
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "49%").build()  
    }  
            () -> FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.block_size", "512kb").build())
        );  
            () -> FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(
    }
    public void testBlockSizeRejectsAboveMaximum() {
 * Unit tests for {@link FoyerBlockCacheSettings} validation and defaults.
    public void testMetadataBlockSizeRejectsAboveMaximum() {  
            "0.05",
    // ── IO_ENGINE_SETTING ─────────────────────────────────────────────────────
    // ── METADATA_BLOCK_SIZE_SETTING ──────────────────────────────────────────  
        assertEquals(  
            IllegalArgumentException.class,
        assertEquals(0.5, FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(s), 0.001);
    }
        assertEquals(
    public void testCacheSizeRejectsGarbage() {
            IllegalArgumentException.class,
}  
        expectThrows(  
            () -> FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "").build())
            IllegalArgumentException.class,
            new ByteSizeValue(512, ByteSizeUnit.MB),
    }  
            "49%",
            () -> FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(
    }  
import org.opensearch.core.common.unit.ByteSizeUnit;
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "0.05").build()  
            "0%",
 *
        );  
        Settings s = Settings.builder().put("block_cache.foyer.key_index_sweep_threshold", 1.0).build();
    public void testSweepThresholdRejectsNegative() {
        expectThrows(  
    public void testMetadataCacheRatioAcceptsPercentage() {
        );
            IllegalArgumentException.class,
/*  
            () -> FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(  
    }
        assertEquals("psync", FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.EMPTY));
            )
    }  
    }  
        );
        expectThrows(
        );
        );
        expectThrows(
        );  
    public void testCacheSizeDefault() {
    public void testSweepThresholdAccepts1dot0() {
                Settings.builder().put("block_cache.foyer.metadata_block_size", "128mb").build()
    }
            IllegalArgumentException.class,  
    public void testSweepThresholdDefaultIs0dot70() {
            FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "psync").build())  
        assertTrue(ex.getMessage().contains("io_uring"));
        assertTrue(ex.getMessage().contains("auto"));
package org.opensearch.blockcache.foyer;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(new ByteSizeValue(8, ByteSizeUnit.MB), FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(Settings.EMPTY));  
 */
    }
    public void testMetadataCacheRatioDefault() {
        expectThrows(
    public void testIoEngineAcceptsAuto() {
            IllegalArgumentException.class,  
import org.opensearch.test.OpenSearchTestCase;
        );
        assertEquals(  
    public void testIoEngineRejectsUnknown() {
        assertEquals(0.0, FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(s), 0.0);  
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(
    public void testMetadataCacheRatioRejectsNegative() {  
            IllegalArgumentException.class,
            "0.25",
        );
    public void testCacheSizeRejectsNegative() {
    public void testCacheSizeRejectsHundredPercent() {  
    }
    public void testMetadataCacheRatioAcceptsRatioForm() {
        );
            )
        expectThrows(
        assertTrue(ex.getMessage().contains("psync"));  
    }  
    }
    }
        );  
            () -> FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.builder().put("block_cache.foyer.size", "notanumber").build())
    public void testMetadataCacheRatioRejectsGarbage() {  
            "auto",
                Settings.builder().put("block_cache.foyer.metadata_cache_ratio", "50%").build()  
        assertEquals(  
            "50%",
    public void testCacheSizeRejectsRatioOne() {  
        // 0.0 = always sweep (no threshold guard)
        assertEquals("50%", FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(Settings.EMPTY));
    }  
        assertEquals(  
    public void testBlockSizeAcceptsMinimum() {
    }
            FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "io_uring").build())
        expectThrows(
        IllegalArgumentException ex = expectThrows(  
            IllegalArgumentException.class,
            () -> FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(  
    public void testSweepThresholdRejectsAboveOne() {
    // ── METADATA_CACHE_RATIO_SETTING ─────────────────────────────────────────
    }  
/**  
    }  
        );
    public void testBlockSizeAcceptsMaximum() {  
    public void testCacheSizeAcceptsPercentage() {
            () -> FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(Settings.builder().put("block_cache.foyer.io_engine", "PSYNC").build())  
    public void testCacheSizeAcceptsRatioForm() {  
