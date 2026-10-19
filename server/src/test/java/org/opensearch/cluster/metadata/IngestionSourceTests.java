    // ---- IngestionSource sourcePartitionStrategy field tests ----
        Map<String, Object> params = new HashMap<>();
            .build();
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(1000, source.getPollTimeout());  
        IngestionSource source3 = new IngestionSource.Builder("type").setParams(params)
            .build();
    }
        ).build();
        IngestionSource source = new IngestionSource.Builder("type").build();
        // Test inequality with different warmup settings (disabled vs enabled)
            .setAllActiveIngestion(true)
            .setMaxPollSize(500)
        assertEquals(warmupConfig, source.getWarmupConfig());
            .build();  
        // Test equals with mapper settings
    }
        assertEquals(IngestionSource.SourcePartitionStrategy.SIMPLE, IngestionSource.SourcePartitionStrategy.fromString("simple"));  
            .setMapperSettings(new HashMap<>(mapperSettings))
            .setPointerInitReset(pointerInitReset)  
        IngestionSource source = new IngestionSource.Builder("type").setParams(params)  
        assertTrue(source.getWarmupConfig().isEnabled());
        assertEquals(IngestionSource.SourcePartitionStrategy.SIMPLE, IngestionSource.SourcePartitionStrategy.fromString("SIMPLE"));
            .setWarmupTimeout(TimeValue.timeValueMinutes(10))  
            IngestionSource.SourcePartitionStrategy.MODULO  
        assertEquals(source, source2);
        IngestionSource source1 = new IngestionSource.Builder("type").setParams(params1)  
            IngestionSource.SourcePartitionStrategy.MODULO
        "1000"
        Map<String, Object> params = new HashMap<>();
        IngestionSource source3 = new IngestionSource.Builder("differentType").setParams(params1)
        ).build();
    public void testSourcePartitionStrategyToString() {
            .setPointerInitReset(pointerInitReset)
            .setWarmupTimeout(TimeValue.timeValueMillis(-1))  
/*  
        params2.put("key", "value");
            .setErrorStrategy(DROP)
        assertEquals(original.getWarmupConfig().lagThreshold(), copy.getWarmupConfig().lagThreshold());
        params.put("key", "value");
        assertTrue(source1.equals(source2));
import java.util.HashMap;
            () -> IngestionSource.SourcePartitionStrategy.fromString("unknown_strategy")
        params.put("key", "value");
        assertEquals(IngestionSource.SourcePartitionStrategy.MODULO, source.getSourcePartitionStrategy());
        Map<String, Object> params1 = new HashMap<>();
    public void testToString() {  
        assertEquals(source1.hashCode(), source2.hashCode());
        mapperSettings.put("id_field", "user_id");  
        Map<String, Object> params2 = new HashMap<>();
        ).build();
        assertEquals("simple", IngestionSource.SourcePartitionStrategy.SIMPLE.toString());
        IngestionSource source = new IngestionSource.Builder("type").setSourcePartitionStrategy(
    public void testSetWarmupConfig() {
    }  
    }
        ).build();  
        assertEquals(StreamPoller.ResetState.RESET_BY_OFFSET, source.getPointerInitReset().getType());
        assertEquals(original.getWarmupConfig().timeout(), copy.getWarmupConfig().timeout());  
            .setWarmupLagThreshold(100)
        IngestionSource source2 = new IngestionSource.Builder("type").setParams(params)
        assertTrue(e.getMessage().contains("Unknown partition strategy"));
            .setPointerInitReset(pointerInitReset)  
        IngestionSource original = new IngestionSource.Builder("type").setWarmupTimeout(TimeValue.timeValueMinutes(10))
        params.put("key", "value");
        assertFalse(source1.equals(source3));  
            .setPointerInitReset(pointerInitReset)  
        assertEquals(expected, source.toString());  
        assertTrue(ingestionSourceClone.isAllActiveIngestionEnabled());
        assertEquals(moduloSource.hashCode(), moduloSource2.hashCode());  
            .setPointerInitReset(pointerInitReset)
        IngestionSource simpleSource = new IngestionSource.Builder("type").setSourcePartitionStrategy(
            .setPointerInitReset(pointerInitReset)
        Map<String, Object> params2 = new HashMap<>();  
 *
            .setPointerInitReset(pointerInitReset)  
}
        IngestionSource sourceEnabled = new IngestionSource.Builder("type").setParams(params)
            .setErrorStrategy(DROP)
            .setPointerInitReset(pointerInitReset)  
        assertNotEquals(source1, source3);
        assertNotEquals(config1, config3);  
        Map<String, Object> params = new HashMap<>();  
import org.opensearch.indices.pollingingest.StreamPoller;
        assertEquals(source.hashCode(), source2.hashCode());
        assertTrue("All-active ingestion should be enabled", sourceEnabled.isAllActiveIngestionEnabled());
        params.put("key", "value");
    }  
        Map<String, Object> params = new HashMap<>();  
            .setPollTimeout(500)
        assertEquals(mapperSettings, copy.getMapperSettings());
        assertTrue(source2.equals(source1));  
        // Create a copy using the copy constructor  
            .setErrorStrategy(DROP)
            .setErrorStrategy(DROP)
        IllegalArgumentException e = expectThrows(  
            .build();
    }  
        assertEquals(expectedToString, config1.toString());
        assertTrue(sourceNoMapperSettings.getMapperSettings().isEmpty());  
    }
            .build();  
        assertTrue("Warmup should be enabled", source.getWarmupConfig().isEnabled());  
    public void testWarmupConfigurationEquality() {
    }
        assertEquals(source1, source2);
    }
    }
        assertEquals(config1, config2);
    private final IngestionSource.PointerInitReset pointerInitReset = new IngestionSource.PointerInitReset(  
        assertEquals("simple", IngestionSource.SourcePartitionStrategy.SIMPLE.getName());
        // toString() should match getName()  
        );  
    public void testHashCode() {  
        IngestionSource source1 = new IngestionSource.Builder("type").setParams(params1)
        assertNotEquals(source1.hashCode(), source3.hashCode());  
        IngestionSource moduloSource2 = new IngestionSource.Builder("type").setSourcePartitionStrategy(
        assertFalse(config3.isEnabled());
        assertEquals(moduloSource, moduloSource2);
        // Test equals and hashCode
            .setPointerInitReset(pointerInitReset)  
            .setBlockingQueueSize(1000)
        IngestionSource source = new IngestionSource.Builder("type").setParams(params)
        assertNotEquals(simpleSource.hashCode(), moduloSource.hashCode());  
            .build();
            IngestionSource.SourcePartitionStrategy.SIMPLE  
    }
        IngestionSource.WarmupConfig config3 = new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100);
            .setWarmupLagThreshold(100)
    public void testWarmupConfigurationDefaults() {
            .setPollTimeout(500)
    }  
            .setErrorStrategy(DROP)
    }  
            .build();
            .setWarmupLagThreshold(100)  
    public void testEquals() {
        IngestionSource.WarmupConfig warmupConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(15), 200);  
    }
            .build();
import java.util.Map;  
        assertEquals(TimeValue.timeValueMillis(-1), source.getWarmupConfig().timeout());
        assertEquals(100, config1.lagThreshold());  
        // Test default warmup values (timeout=-1 means disabled)  
        IngestionSource source = new IngestionSource.Builder("type").build();
        assertEquals(1, source.getPointerBasedLagUpdateInterval().getSeconds());
            .setErrorStrategy(DROP)
import static org.opensearch.indices.pollingingest.IngestionErrorStrategy.ErrorStrategy.DROP;
    public void testWarmupConfigurationConstructorAndGetters() {  
    public void testSourcePartitionStrategyFromStringInvalid() {
        String expectedToString = "WarmupConfig[timeout=10m, lagThreshold=100]";
            .setAllActiveIngestion(false)
            .setPointerBasedLagUpdateInterval(TimeValue.timeValueSeconds(1))  
        // Test with all-active ingestion enabled
            .setPointerInitReset(pointerInitReset)  
        assertEquals(TimeValue.timeValueMinutes(15), source.getWarmupConfig().timeout());  
        IngestionSource moduloSource = new IngestionSource.Builder("type").setSourcePartitionStrategy(
        IngestionSource source = new IngestionSource.Builder("type").setParams(params)
        assertEquals("modulo", IngestionSource.SourcePartitionStrategy.MODULO.toString());
        assertEquals(TimeValue.timeValueMinutes(10), config1.timeout());
        Map<String, Object> params1 = new HashMap<>();  
 * this file be licensed under the Apache-2.0 license or a
        IngestionSource ingestionSourceClone = new IngestionSource.Builder(sourceEnabled).build();
        assertTrue(config1.isEnabled());
        // Test copy constructor preserves mapper settings  
            .setWarmupTimeout(TimeValue.timeValueMinutes(10))
    }
        assertEquals(DROP, source.getErrorStrategy());  
    public void testConstructorAndGetters() {
        // Test empty mapper settings by default
        assertEquals(IngestionSource.SourcePartitionStrategy.SIMPLE, IngestionSource.SourcePartitionStrategy.fromString("Simple"));  
        assertEquals(200, source.getWarmupConfig().lagThreshold());
            .build();  
    }
            "IngestionSource{type='type',pointer_init_reset='PointerInitReset{type='RESET_BY_OFFSET', value=1000}',error_strategy='DROP', params={key=value}, maxPollSize=1000, pollTimeout=1000, numProcessorThreads=1, blockingQueueSize=100, allActiveIngestion=false, pointerBasedLagUpdateInterval=10s, mapperType='DEFAULT', mapperSettings={}, decoderType='xcontent', decoderSettings={}, warmupConfig=WarmupConfig[timeout=-1, lagThreshold=100], sourcePartitionStrategy='simple'}";
        assertEquals(IngestionSource.SourcePartitionStrategy.MODULO, IngestionSource.SourcePartitionStrategy.fromString("MODULO"));
        assertEquals(100, source.getWarmupConfig().lagThreshold());
        assertFalse("Warmup should be disabled by default", source.getWarmupConfig().isEnabled());  
            .setErrorStrategy(DROP)
        IngestionSource sourceNoMapperSettings = new IngestionSource.Builder("type").setParams(params)
public class IngestionSourceTests extends OpenSearchTestCase {
        IngestionSource copy = new IngestionSource.Builder(original).build();
            .build();
        assertEquals(mapperSettings, source.getMapperSettings());
    public void testSourcePartitionStrategyAffectsEquals() {
        // Test with warmup configuration (timeout >= 0 means enabled)
    }
            .build();  
    }  
    public void testAllActiveIngestionConstructorAndGetter() {  
        mapperSettings.put("op_type_field", "is_deleted");
            .setErrorStrategy(DROP)
        assertEquals(source1.hashCode(), source2.hashCode());  
            .setPointerInitReset(pointerInitReset)  
        // Default builder should produce SIMPLE strategy
 */  
        IngestionSource copy = new IngestionSource.Builder(source).build();
            .setErrorStrategy(DROP)
    public void testSourcePartitionStrategyDefault() {  
        assertNotEquals(simpleSource, moduloSource);
        IngestionSource source = new IngestionSource.Builder("type").setWarmupConfig(warmupConfig).build();
            .setErrorStrategy(DROP)  
            .build();
            .build();
    public void testWarmupConfigurationCopiedByBuilder() {
        IngestionSource source3 = new IngestionSource.Builder("differentType").setParams(params1)
        assertEquals("is_deleted", source.getMapperSettings().get("op_type_field"));
        IngestionSource source1 = new IngestionSource.Builder("type").setParams(params)  
        Map<String, Object> params = new HashMap<>();  
            .build();  
        StreamPoller.ResetState.RESET_BY_OFFSET,
            .setPollTimeout(500)  
    public void testSourcePartitionStrategySetAndGet() {  
    public void testSourcePartitionStrategyFromString() {
        assertEquals("type", source.getType());  
        IngestionSource.WarmupConfig config2 = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(10), 100);  
        assertEquals("timestamp", source.getMapperSettings().get("version_field"));  
            .setPollTimeout(500)  
        IngestionSource source2 = new IngestionSource.Builder("type").setParams(params)
        assertEquals(100, source.getWarmupConfig().lagThreshold());
        // Test inequality
            IngestionSource.SourcePartitionStrategy.MODULO  
        // Test toString  
        params1.put("key", "value");
    );  
            .setMapperSettings(mapperSettings)
        IngestionSource.WarmupConfig config1 = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(10), 100);
        params2.put("key", "value");
        assertEquals(1000, source.getBlockingQueueSize());
        String expected =
            .setWarmupTimeout(TimeValue.timeValueMinutes(10))
        params.put("key", "value");
        assertEquals(params, source.params());
        // Test with all-active ingestion disabled
            .setWarmupLagThreshold(500)  
import org.opensearch.common.unit.TimeValue;
            .setErrorStrategy(DROP)
 * The OpenSearch Contributors require contributions made to  
    // ---- SourcePartitionStrategy enum tests ----
            .setMaxPollSize(500)  
            .setWarmupLagThreshold(100)
        assertEquals(TimeValue.timeValueMinutes(10), source.getWarmupConfig().timeout());
        mapperSettings.put("version_field", "timestamp");
        params.put("key", "value");
        IngestionSource sourceDisabled = new IngestionSource.Builder("type").setParams(params)
    public void testWarmupConfigClass() {
            IllegalArgumentException.class,
        assertEquals(IngestionSource.SourcePartitionStrategy.SIMPLE, source.getSourcePartitionStrategy());  
        assertEquals(config1.hashCode(), config2.hashCode());
            .build();
            .setErrorStrategy(DROP)
        IngestionSource source2 = new IngestionSource.Builder("type").setParams(params2)  
    public void testMapperSettings() {
            .setPointerInitReset(pointerInitReset)
            .setPointerInitReset(pointerInitReset)  
        IngestionSource source2 = new IngestionSource.Builder("type").setParams(params2)
            .setMaxPollSize(500)
            .setPointerInitReset(pointerInitReset)  
        Map<String, Object> mapperSettings = new HashMap<>();
        IngestionSource source = new IngestionSource.Builder("type").setParams(params)
    public void testSourcePartitionStrategyGetName() {  
            .setErrorStrategy(DROP)
            .build();
        params1.put("key", "value");
            .setErrorStrategy(DROP)
        assertFalse("All-active ingestion should be disabled", sourceDisabled.isAllActiveIngestionEnabled());
            .build();
 * compatible open source license.
package org.opensearch.cluster.metadata;
    }  
        assertEquals(1000, source.getMaxPollSize());
            .build();
            .setMaxPollSize(500)  
        Map<String, Object> params = new HashMap<>();
    }  
        assertEquals(IngestionSource.SourcePartitionStrategy.MODULO, IngestionSource.SourcePartitionStrategy.fromString("Modulo"));
        assertEquals("1000", source.getPointerInitReset().getValue());
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("user_id", source.getMapperSettings().get("id_field"));
        assertEquals("modulo", IngestionSource.SourcePartitionStrategy.MODULO.getName());
    public void testSourcePartitionStrategyFromStringIsCaseInsensitive() {
        assertEquals(IngestionSource.SourcePartitionStrategy.MODULO, IngestionSource.SourcePartitionStrategy.fromString("modulo"));
