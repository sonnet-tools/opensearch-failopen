            .setPointerInitReset(pointerInitReset)
    public void testWarmupConfigurationConstructorAndGetters() {
            .setMaxPollSize(500)
            .build();
        assertEquals(TimeValue.timeValueMinutes(10), source.getWarmupConfig().timeout());
            .setPointerInitReset(pointerInitReset)
        assertTrue("All-active ingestion should be enabled", sourceEnabled.isAllActiveIngestionEnabled());
        assertEquals(StreamPoller.ResetState.RESET_BY_OFFSET, source.getPointerInitReset().getType());
        assertEquals(IngestionSource.SourcePartitionStrategy.SIMPLE, IngestionSource.SourcePartitionStrategy.fromString("simple"));
        assertEquals(original.getWarmupConfig().timeout(), copy.getWarmupConfig().timeout());
package org.opensearch.cluster.metadata;
            IllegalArgumentException.class,
        assertTrue(e.getMessage().contains("Unknown partition strategy"));
        assertEquals(1000, source.getBlockingQueueSize());
        assertEquals(source1, source2);
        assertEquals(100, source.getWarmupConfig().lagThreshold());
            .build();
    public void testConstructorAndGetters() {
        assertEquals(IngestionSource.SourcePartitionStrategy.MODULO, IngestionSource.SourcePartitionStrategy.fromString("MODULO"));
            .setPointerInitReset(pointerInitReset)
        mapperSettings.put("version_field", "timestamp");
        assertEquals(config1.hashCode(), config2.hashCode());
        IngestionSource.WarmupConfig config1 = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(10), 100);
        assertEquals(warmupConfig, source.getWarmupConfig());
        assertNotEquals(source1, source3);
    }
            .setBlockingQueueSize(1000)
 * The OpenSearch Contributors require contributions made to
            .setErrorStrategy(DROP)
            .setWarmupTimeout(TimeValue.timeValueMillis(-1))
            .setPollTimeout(500)
        mapperSettings.put("op_type_field", "is_deleted");
            .build();
    }
    public void testWarmupConfigurationCopiedByBuilder() {
        );
    public void testMapperSettings() {
        // Test with warmup configuration (timeout >= 0 means enabled)
        assertEquals(mapperSettings, copy.getMapperSettings());
    public void testToString() {
        assertEquals(source.hashCode(), source2.hashCode());
        assertFalse("All-active ingestion should be disabled", sourceDisabled.isAllActiveIngestionEnabled());
}
    public void testWarmupConfigClass() {
        assertEquals(100, source.getWarmupConfig().lagThreshold());
    public void testEquals() {
            .setMaxPollSize(500)
        assertEquals("user_id", source.getMapperSettings().get("id_field"));
    }
import org.opensearch.common.unit.TimeValue;
            .build();
        params.put("key", "value");
        ).build();
        assertEquals(TimeValue.timeValueMillis(-1), source.getWarmupConfig().timeout());
    }
        IngestionSource source = new IngestionSource.Builder("type").build();
            .build();
            () -> IngestionSource.SourcePartitionStrategy.fromString("unknown_strategy")
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> params1 = new HashMap<>();
            "IngestionSource{type='type',pointer_init_reset='PointerInitReset{type='RESET_BY_OFFSET', value=1000}',error_strategy='DROP', params={key=value}, maxPollSize=1000, pollTimeout=1000, numProcessorThreads=1, blockingQueueSize=100, allActiveIngestion=false, pointerBasedLagUpdateInterval=10s, mapperType='DEFAULT', mapperSettings={}, decoderType='xcontent', decoderSettings={}, warmupConfig=WarmupConfig[timeout=-1, lagThreshold=100], sourcePartitionStrategy='simple'}";
            .setErrorStrategy(DROP)
    public void testSourcePartitionStrategySetAndGet() {
        IngestionSource copy = new IngestionSource.Builder(original).build();
        assertEquals(IngestionSource.SourcePartitionStrategy.SIMPLE, IngestionSource.SourcePartitionStrategy.fromString("Simple"));
        IngestionSource sourceEnabled = new IngestionSource.Builder("type").setParams(params)
        assertEquals(1000, source.getPollTimeout());
 */
            .setPointerInitReset(pointerInitReset)
        Map<String, Object> params = new HashMap<>();
    }
            .setPointerInitReset(pointerInitReset)
            .setPointerInitReset(pointerInitReset)
        IngestionSource source = new IngestionSource.Builder("type").setParams(params)
        IngestionSource.WarmupConfig config3 = new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100);
        assertEquals(moduloSource, moduloSource2);
        ).build();
        assertEquals(IngestionSource.SourcePartitionStrategy.SIMPLE, IngestionSource.SourcePartitionStrategy.fromString("SIMPLE"));
        assertEquals(IngestionSource.SourcePartitionStrategy.MODULO, IngestionSource.SourcePartitionStrategy.fromString("Modulo"));
        params1.put("key", "value");
    }
        assertEquals("modulo", IngestionSource.SourcePartitionStrategy.MODULO.getName());
        params1.put("key", "value");
            .setWarmupTimeout(TimeValue.timeValueMinutes(10))
        assertTrue(source2.equals(source1));
        assertEquals(IngestionSource.SourcePartitionStrategy.MODULO, IngestionSource.SourcePartitionStrategy.fromString("modulo"));
        assertEquals(1, source.getPointerBasedLagUpdateInterval().getSeconds());
            .build();
    public void testWarmupConfigurationDefaults() {
        // Test inequality with different warmup settings (disabled vs enabled)
        assertEquals(source1.hashCode(), source2.hashCode());
        IngestionSource source3 = new IngestionSource.Builder("differentType").setParams(params1)
        params.put("key", "value");
            .setWarmupLagThreshold(100)
        // Test default warmup values (timeout=-1 means disabled)
        assertFalse("Warmup should be disabled by default", source.getWarmupConfig().isEnabled());
        StreamPoller.ResetState.RESET_BY_OFFSET,
        IngestionSource source = new IngestionSource.Builder("type").setParams(params)
        IngestionSource source = new IngestionSource.Builder("type").setSourcePartitionStrategy(
        // Test with all-active ingestion disabled
    }
            .setErrorStrategy(DROP)
    public void testSourcePartitionStrategyDefault() {
            .setMaxPollSize(500)
        assertEquals(100, config1.lagThreshold());
        ).build();
        assertTrue("Warmup should be enabled", source.getWarmupConfig().isEnabled());
        assertEquals(IngestionSource.SourcePartitionStrategy.SIMPLE, source.getSourcePartitionStrategy());
        String expectedToString = "WarmupConfig[timeout=10m, lagThreshold=100]";
    }
    // ---- SourcePartitionStrategy enum tests ----
            .setWarmupLagThreshold(500)
            .setWarmupTimeout(TimeValue.timeValueMinutes(10))
            .build();
            .setErrorStrategy(DROP)
            .setErrorStrategy(DROP)
            .setPointerInitReset(pointerInitReset)
            IngestionSource.SourcePartitionStrategy.MODULO
            .setErrorStrategy(DROP)
        IngestionSource sourceDisabled = new IngestionSource.Builder("type").setParams(params)
 * this file be licensed under the Apache-2.0 license or a
            .setWarmupLagThreshold(100)
            .build();
            .setPointerBasedLagUpdateInterval(TimeValue.timeValueSeconds(1))
        assertFalse(config3.isEnabled());
        IngestionSource source3 = new IngestionSource.Builder("differentType").setParams(params1)
        assertNotEquals(config1, config3);
    }
    }
        // Test toString
        // Create a copy using the copy constructor
    public void testWarmupConfigurationEquality() {
    public void testSourcePartitionStrategyFromStringInvalid() {
        // Test copy constructor preserves mapper settings
        assertEquals("simple", IngestionSource.SourcePartitionStrategy.SIMPLE.toString());
        assertEquals(200, source.getWarmupConfig().lagThreshold());
        assertEquals("type", source.getType());
            .setPollTimeout(500)
        IngestionSource moduloSource = new IngestionSource.Builder("type").setSourcePartitionStrategy(
        Map<String, Object> params1 = new HashMap<>();
        IngestionSource source = new IngestionSource.Builder("type").setWarmupConfig(warmupConfig).build();
        assertFalse(source1.equals(source3));
        IngestionSource copy = new IngestionSource.Builder(source).build();
    }
        assertTrue(sourceNoMapperSettings.getMapperSettings().isEmpty());
        Map<String, Object> params = new HashMap<>();
        assertEquals("is_deleted", source.getMapperSettings().get("op_type_field"));
        assertEquals(IngestionSource.SourcePartitionStrategy.MODULO, source.getSourcePartitionStrategy());
            IngestionSource.SourcePartitionStrategy.SIMPLE
    );
        assertEquals(1000, source.getMaxPollSize());
        IngestionSource source1 = new IngestionSource.Builder("type").setParams(params1)
        IngestionSource original = new IngestionSource.Builder("type").setWarmupTimeout(TimeValue.timeValueMinutes(10))
        IngestionSource.WarmupConfig config2 = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(10), 100);
    }
    public void testAllActiveIngestionConstructorAndGetter() {
        assertEquals(source1.hashCode(), source2.hashCode());
            .setPointerInitReset(pointerInitReset)
    }
        params2.put("key", "value");
import java.util.HashMap;
            .setErrorStrategy(DROP)
        assertNotEquals(simpleSource, moduloSource);
        assertEquals("timestamp", source.getMapperSettings().get("version_field"));
        assertEquals(expected, source.toString());
            .setPointerInitReset(pointerInitReset)
    }
import org.opensearch.indices.pollingingest.StreamPoller;
        params.put("key", "value");
        // Test with all-active ingestion enabled
            .setMaxPollSize(500)
        // Test empty mapper settings by default
        Map<String, Object> params = new HashMap<>();
 *
            .setErrorStrategy(DROP)
        mapperSettings.put("id_field", "user_id");
        Map<String, Object> params = new HashMap<>();
        assertEquals(source, source2);
            .setPointerInitReset(pointerInitReset)
        IngestionSource source = new IngestionSource.Builder("type").setParams(params)
        // Default builder should produce SIMPLE strategy
        assertEquals("1000", source.getPointerInitReset().getValue());
        IngestionSource source1 = new IngestionSource.Builder("type").setParams(params1)
        Map<String, Object> params2 = new HashMap<>();
            .setErrorStrategy(DROP)
        assertTrue(source.getWarmupConfig().isEnabled());
        // Test equals and hashCode
            .setAllActiveIngestion(true)
import java.util.Map;
        IllegalArgumentException e = expectThrows(
        // toString() should match getName()
        IngestionSource source1 = new IngestionSource.Builder("type").setParams(params)
        assertEquals(params, source.params());
        assertEquals(TimeValue.timeValueMinutes(15), source.getWarmupConfig().timeout());
            .build();
            .setPointerInitReset(pointerInitReset)
            .setWarmupTimeout(TimeValue.timeValueMinutes(10))
            .setWarmupLagThreshold(100)
            .setPointerInitReset(pointerInitReset)
            .build();
        "1000"
            .build();
        assertEquals(config1, config2);
    }
            .setErrorStrategy(DROP)
            .setPointerInitReset(pointerInitReset)
    public void testSourcePartitionStrategyFromString() {
    public void testSourcePartitionStrategyGetName() {
            .setPointerInitReset(pointerInitReset)
            .build();
        IngestionSource source3 = new IngestionSource.Builder("type").setParams(params)
        assertNotEquals(simpleSource.hashCode(), moduloSource.hashCode());
        // Test equals with mapper settings
        params.put("key", "value");
        IngestionSource simpleSource = new IngestionSource.Builder("type").setSourcePartitionStrategy(
            .setPollTimeout(500)
import org.opensearch.test.OpenSearchTestCase;
        Map<String, Object> params = new HashMap<>();
            .build();
    // ---- IngestionSource sourcePartitionStrategy field tests ----
            .setWarmupLagThreshold(100)
            .setMapperSettings(mapperSettings)
        assertEquals(mapperSettings, source.getMapperSettings());
        IngestionSource moduloSource2 = new IngestionSource.Builder("type").setSourcePartitionStrategy(
public class IngestionSourceTests extends OpenSearchTestCase {
        assertEquals("modulo", IngestionSource.SourcePartitionStrategy.MODULO.toString());
        IngestionSource source2 = new IngestionSource.Builder("type").setParams(params)
        assertEquals(DROP, source.getErrorStrategy());
    }
        IngestionSource sourceNoMapperSettings = new IngestionSource.Builder("type").setParams(params)
            .build();
            IngestionSource.SourcePartitionStrategy.MODULO
        ).build();
    public void testSourcePartitionStrategyToString() {
import static org.opensearch.indices.pollingingest.IngestionErrorStrategy.ErrorStrategy.DROP;
        Map<String, Object> params2 = new HashMap<>();
        String expected =
    public void testSourcePartitionStrategyAffectsEquals() {
    }
        assertEquals(original.getWarmupConfig().lagThreshold(), copy.getWarmupConfig().lagThreshold());
        assertTrue(config1.isEnabled());
    }
        params2.put("key", "value");
            .build();
        // Test inequality
        params.put("key", "value");
            .setAllActiveIngestion(false)
        Map<String, Object> mapperSettings = new HashMap<>();
            .setMapperSettings(new HashMap<>(mapperSettings))
/*
    }
    public void testHashCode() {
            .setErrorStrategy(DROP)
        IngestionSource source2 = new IngestionSource.Builder("type").setParams(params2)
        assertNotEquals(source1.hashCode(), source3.hashCode());
        assertEquals("simple", IngestionSource.SourcePartitionStrategy.SIMPLE.getName());
        assertEquals(TimeValue.timeValueMinutes(10), config1.timeout());
        IngestionSource ingestionSourceClone = new IngestionSource.Builder(sourceEnabled).build();
            .build();
        IngestionSource source = new IngestionSource.Builder("type").build();
        assertTrue(ingestionSourceClone.isAllActiveIngestionEnabled());
            .setErrorStrategy(DROP)
            .setErrorStrategy(DROP)
        params.put("key", "value");
            .build();
 * compatible open source license.
        assertTrue(source1.equals(source2));
            .build();
            .setPollTimeout(500)
            .setErrorStrategy(DROP)
            IngestionSource.SourcePartitionStrategy.MODULO
        assertEquals(expectedToString, config1.toString());
    public void testSourcePartitionStrategyFromStringIsCaseInsensitive() {
        IngestionSource source = new IngestionSource.Builder("type").setParams(params)
        IngestionSource source2 = new IngestionSource.Builder("type").setParams(params2)
    private final IngestionSource.PointerInitReset pointerInitReset = new IngestionSource.PointerInitReset(
    public void testSetWarmupConfig() {
        assertEquals(moduloSource.hashCode(), moduloSource2.hashCode());
    }
 * SPDX-License-Identifier: Apache-2.0
        IngestionSource.WarmupConfig warmupConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(15), 200);
        IngestionSource source2 = new IngestionSource.Builder("type").setParams(params)
