                .endObject()
            "Sources with nested objects in different order should be equal",
            XContentFactory.cborBuilder().startObject().field("field", "value").field("number", 1).endObject()
            .build();
        assertTrue("Identical operations should be equal", helper.hasSameIndexOperation(op1, op2));
        // CBOR format
                .field("type", "integer")
import org.opensearch.index.IndexSettings;
        documentMapperForType = mock(DocumentMapperForType.class);
    }
            "{\"string\":\"value\",\"number\":42,\"bool\":true,\"null\":null}".getBytes(StandardCharsets.UTF_8)
        BytesReference source2 = new BytesArray("{\"field\":{\"nested2\":true,\"nested1\":1}}".getBytes(StandardCharsets.UTF_8));
        assertTrue("Identical arrays should be equal", TranslogOperationHelper.compareSourcesWithOrder(source1, source2));
 */
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
    private DocumentMapperForType documentMapperForType;
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertTrue(
        BytesReference invalidContent = new BytesArray("invalid content".getBytes(StandardCharsets.UTF_8));
            TranslogOperationHelper.compareSourcesWithOrder(yamlSource, cborSource)
        Translog.Index op2 = new Translog.Index("1", 1, 1, source.toBytesRef().bytes);
        Translog.Index op2 = new Translog.Index("1", 0, 1, 0, source.toBytesRef().bytes, "route2", 1);
        Translog.Index op2 = new Translog.Index("1", 0, 2, source.toBytesRef().bytes);
        assertFalse("Operations with different sources should not be equal", helper.hasSameIndexOperation(op1, op2));
        );
            helperWithDerivedSource.hasSameIndexOperation(op1, op2)
    }
            TranslogOperationHelper.compareSourcesWithOrder(source1, source2)
    public void testIdenticalOperationsDerivedSourceCase() {
    }
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
import org.opensearch.Version;
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        );
        EngineConfig derivedConfig = createEngineConfig(derivedIndexSettings);
        BytesReference source1 = new BytesArray("{\"field\":\"value1\"}".getBytes(StandardCharsets.UTF_8));
        BytesReference source2 = new BytesArray("{\"obj\":{\"nested2\":2,\"nested1\":1}}".getBytes(StandardCharsets.UTF_8));
    }
                .startObject("properties")
        );
            .documentMapperForTypeSupplier(() -> documentMapperForType)
            .indexSettings(indexSettings)
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
            TranslogOperationHelper.compareSourcesWithOrder(jsonSource, cborSource)
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
        mapperService = createMapperService(
/*
    public void testDifferentRoutingNormalCase() {
 * The OpenSearch Contributors require contributions made to
        // JSON format
import org.opensearch.common.xcontent.XContentFactory;
        Translog.Index op2 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
        ShardId shardId = new ShardId(indexSettings.getIndex(), 0);
        BytesReference source1 = new BytesArray("{\"field\":{\"nested1\":1,\"nested2\":true}}".getBytes(StandardCharsets.UTF_8));
    public void testSourceComparisonWithNestedObjects() {
public class TranslogOperationHelperTests extends MapperServiceTestCase {
    private MapperService mapperService;
        assertFalse("Null and non-null sources should not be equal", TranslogOperationHelper.compareSourcesWithOrder(null, source));
            XContentFactory.yamlBuilder().startObject().field("field", "value").field("number", 1).endObject()
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
 * compatible open source license.
        Translog.Index op2 = new Translog.Index("1", 0, 1, 0, source.toBytesRef().bytes, "route", 1);
        IndexMetadata derivedMetadata = IndexMetadata.builder("test").settings(derivedSourceSettings).build();
        BytesReference source2 = new BytesArray("{\"array\":[1,2,3]}".getBytes(StandardCharsets.UTF_8));
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        when(documentMapperForType.getDocumentMapper()).thenReturn(mapperService.documentMapper());
        assertTrue(
        assertTrue(
                .startObject("nested1")
        );
 *
            XContentFactory.jsonBuilder()
        BytesReference source3 = new BytesArray("{\"array\":[3,2,1]}".getBytes(StandardCharsets.UTF_8));
}
            TranslogOperationHelper.compareSourcesWithOrder(jsonSource, yamlSource)
import org.junit.Before;
    @Before
    }
import org.opensearch.index.mapper.DocumentMapperForType;
        assertFalse("Operations with different sequence numbers should not be equal", helper.hasSameIndexOperation(op1, op2));
    }
import org.opensearch.core.index.shard.ShardId;
            TranslogOperationHelper.compareSourcesWithOrder(yamlSource, smileSource)
    }
        engineConfig = createEngineConfig(defaultIndexSettings);
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
    private MapperService createMapperService() throws IOException {
            "JSON and YAML with same content should be equal",
import java.util.List;
        // Setup for normal case
    public void setup() throws Exception {
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
    public void testSourceComparisonWithMixedTypes() {
            XContentFactory.smileBuilder().startObject().field("field", "value").field("number", 1).endObject()
        Settings derivedSourceSettings = Settings.builder()
        assertFalse("Different arrays should not be equal", TranslogOperationHelper.compareSourcesWithOrder(source1, source3));
        BytesReference source2 = new BytesArray(
    public void testEmptyHelper() {
        Translog.Index op2 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
        BytesReference source1 = new BytesArray("{\"array\":[1,2,3]}".getBytes(StandardCharsets.UTF_8));
    private TranslogOperationHelper helperWithDerivedSource;
            .put("index.derived_source.enabled", true)
            "SMILE and CBOR with same content should be equal",
import org.opensearch.index.mapper.MapperService;
            .put(defaultIndexSettings.getSettings())
        assertTrue(
        );
        assertFalse(
        Translog.Index op1 = new Translog.Index("1", 0, 1, source1.toBytesRef().bytes);
        assertTrue("Null sources should be equal", TranslogOperationHelper.compareSourcesWithOrder(null, null));
    public void testSourceComparisonWithNullValues() {
            .settings(settings(Version.CURRENT))
        assertTrue("Empty helper should compare operations normally", TranslogOperationHelper.DEFAULT.hasSameIndexOperation(op1, op2));
        );
                .endObject()
        // Test different combinations
        );
        );
        assertTrue(
import org.opensearch.index.engine.EngineConfig;
        BytesReference yamlSource = BytesReference.bytes(
        final IndexMetadata defaultIndexMetadata = IndexMetadata.builder("test")
            TranslogOperationHelper.compareSourcesWithOrder(validJson, invalidContent)
        assertTrue("Identical operations should be equal for derived source", helperWithDerivedSource.hasSameIndexOperation(op1, op2));
                .startObject("nested2")
        );
    }
        );
 * SPDX-License-Identifier: Apache-2.0
    public void testSourceComparisonWithArrays() {
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
    public void testNullRoutingNormalCase() {
        // YAML format
    }
            TranslogOperationHelper.compareSourcesWithOrder(smileSource, cborSource)
        BytesReference validJson = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        // SMILE format (binary JSON)
        BytesReference source2 = new BytesArray("{\"b\":2,\"a\":1}".getBytes(StandardCharsets.UTF_8));
import org.opensearch.common.settings.Settings;
import org.opensearch.core.common.bytes.BytesArray;
    public void testDifferentSourcesNormalCase() {
 * this file be licensed under the Apache-2.0 license or a
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
            .build();
            "YAML and CBOR with same content should be equal",
        BytesReference smileSource = BytesReference.bytes(
            "YAML and SMILE with same content should be equal",
            .numberOfReplicas(1)
import org.opensearch.index.seqno.RetentionLeases;
        assertFalse("Non-null and null sources should not be equal", TranslogOperationHelper.compareSourcesWithOrder(source, null));
        helperWithDerivedSource = TranslogOperationHelper.create(derivedConfig);
    }
        BytesReference jsonSource = new BytesArray("{\"field\":\"value\", \"number\":1}".getBytes(StandardCharsets.UTF_8));
import static org.mockito.Mockito.when;
    private EngineConfig createEngineConfig(IndexSettings indexSettings) {
                .endObject()
            TranslogOperationHelper.compareSourcesWithOrder(jsonSource, smileSource)
        BytesReference source1 = new BytesArray("{\"obj\":{\"nested1\":1,\"nested2\":2}}".getBytes(StandardCharsets.UTF_8));
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        when(documentMapperForType.getDocumentMapper()).thenReturn(mapperService.documentMapper());
    }
    }
        return createMapperService(fieldMapping(b -> b.field("type", "keyword")));
        assertFalse("Operations with null and non-null routing should not be equal", helper.hasSameIndexOperation(op1, op2));
                .endObject()
        );
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
        assertFalse("Operations with different routing should not be equal", helper.hasSameIndexOperation(op1, op2));
        BytesReference source1 = new BytesArray(
import java.io.IOException;
        helper = TranslogOperationHelper.create(engineConfig);
                .endObject()
    public void testSourceComparisonWithNestedObjectsForDerivedSource() throws IOException {
        );
        );
        Translog.Index op1 = new Translog.Index("1", 0, 1, source1.toBytesRef().bytes);
        );
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
        );
    }
        assertTrue(
            "JSON and CBOR with same content should be equal",
                .field("type", "boolean")
            .numberOfShards(1)
                .startObject("field")
    }
import static org.mockito.Mockito.mock;
        IndexSettings derivedIndexSettings = new IndexSettings(derivedMetadata, Settings.EMPTY);
            "Sources with mixed types in different order should be equal",
    public void testSourceComparisonWithDifferentContentTypes() throws IOException {
            .build();
        documentMapperForType = mock(DocumentMapperForType.class);
import org.opensearch.core.common.bytes.BytesReference;
        Translog.Index op2 = new Translog.Index("2", 0, 1, source.toBytesRef().bytes);
import org.opensearch.index.codec.CodecService;
        Translog.Index op2 = new Translog.Index("1", 0, 1, source2.toBytesRef().bytes);
        assertFalse("Operations with different primary terms should not be equal", helper.hasSameIndexOperation(op1, op2));
    public void testSourceComparisonWithDifferentOrder() {
            "JSON and SMILE with same content should be equal",
        assertTrue(
package org.opensearch.index.translog;
        Translog.Index op2 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
                .startObject("properties")
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        assertTrue(
        assertTrue("Sources with different field order should be equal", TranslogOperationHelper.compareSourcesWithOrder(source1, source2));
import org.opensearch.test.IndexSettingsModule;
            "Valid and invalid content should not be equal",
        mapperService = createMapperService();
        BytesReference source1 = new BytesArray("{\"a\":1,\"b\":2}".getBytes(StandardCharsets.UTF_8));
    public void testDifferentIdsNormalCase() {
    public void testSourceComparisonWithInvalidContent() {
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
                .endObject()
    }
        );
    public void testDifferentPrimaryTermNormalCase() {
        BytesReference source2 = new BytesArray("{\"field\":\"value2\"}".getBytes(StandardCharsets.UTF_8));
        Translog.Index op2 = new Translog.Index("1", 0, 1, source2.toBytesRef().bytes);
    private TranslogOperationHelper helper;
            TranslogOperationHelper.compareSourcesWithOrder(source1, source2)
import org.opensearch.index.mapper.MapperServiceTestCase;
        // Setup for derived source case
        return new EngineConfig.Builder().shardId(shardId)
    }
    private EngineConfig engineConfig;
        IndexSettings defaultIndexSettings = IndexSettingsModule.newIndexSettings("test", defaultIndexMetadata.getSettings());
        BytesReference cborSource = BytesReference.bytes(
    }
        Translog.Index op1 = new Translog.Index("1", 0, 1, 0, source.toBytesRef().bytes, null, 1);
    public void testIdenticalOperationsNormalCase() {
    public void testDifferentSeqNoNormalCase() {
    }
            "{\"null\":null,\"bool\":true,\"number\":42,\"string\":\"value\"}".getBytes(StandardCharsets.UTF_8)
import java.nio.charset.StandardCharsets;
    }
        assertFalse("Operations with different IDs should not be equal", helper.hasSameIndexOperation(op1, op2));
    }
        Translog.Index op1 = new Translog.Index("1", 0, 1, 0, source.toBytesRef().bytes, "route1", 1);
        assertTrue(
                .startObject()
            "Sources with nested objects in different order should be equal for derived source case",
