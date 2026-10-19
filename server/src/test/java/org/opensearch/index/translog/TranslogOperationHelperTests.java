            TranslogOperationHelper.compareSourcesWithOrder(jsonSource, yamlSource)
        BytesReference source2 = new BytesArray("{\"field\":\"value2\"}".getBytes(StandardCharsets.UTF_8));
        Settings derivedSourceSettings = Settings.builder()
import org.opensearch.index.mapper.MapperService;  
        );
        );  
        Translog.Index op2 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
        assertTrue(  
        Translog.Index op2 = new Translog.Index("1", 0, 1, source2.toBytesRef().bytes);
    }
                .startObject()  
        );
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        when(documentMapperForType.getDocumentMapper()).thenReturn(mapperService.documentMapper());
            "{\"null\":null,\"bool\":true,\"number\":42,\"string\":\"value\"}".getBytes(StandardCharsets.UTF_8)
            XContentFactory.smileBuilder().startObject().field("field", "value").field("number", 1).endObject()  
            .build();  
        BytesReference yamlSource = BytesReference.bytes(  
            "JSON and SMILE with same content should be equal",  
    public void testDifferentSourcesNormalCase() {  
    }  
    }
import org.opensearch.index.IndexSettings;
        assertTrue(
    }
    }  
    }
        IndexMetadata derivedMetadata = IndexMetadata.builder("test").settings(derivedSourceSettings).build();  
                .endObject()
        );  
    public void testDifferentSeqNoNormalCase() {  
            TranslogOperationHelper.compareSourcesWithOrder(jsonSource, cborSource)  
        ShardId shardId = new ShardId(indexSettings.getIndex(), 0);
    public void testDifferentRoutingNormalCase() {
        // JSON format
                .endObject()
    }
import java.util.List;
        );  
    public void testSourceComparisonWithArrays() {  
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));  
            .numberOfReplicas(1)  
        IndexSettings defaultIndexSettings = IndexSettingsModule.newIndexSettings("test", defaultIndexMetadata.getSettings());
        assertFalse("Null and non-null sources should not be equal", TranslogOperationHelper.compareSourcesWithOrder(null, source));
        assertFalse("Different arrays should not be equal", TranslogOperationHelper.compareSourcesWithOrder(source1, source3));  
        Translog.Index op2 = new Translog.Index("1", 0, 2, source.toBytesRef().bytes);
    }
    }  
                .endObject()  
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
            "JSON and CBOR with same content should be equal",
    }
        );
            "{\"string\":\"value\",\"number\":42,\"bool\":true,\"null\":null}".getBytes(StandardCharsets.UTF_8)
import static org.mockito.Mockito.when;
        assertFalse("Operations with null and non-null routing should not be equal", helper.hasSameIndexOperation(op1, op2));
        // YAML format
                .field("type", "boolean")
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
}  
            .put(defaultIndexSettings.getSettings())  
        BytesReference source1 = new BytesArray(
        // SMILE format (binary JSON)
        assertTrue(
        BytesReference source3 = new BytesArray("{\"array\":[3,2,1]}".getBytes(StandardCharsets.UTF_8));  
        assertTrue(
            "JSON and YAML with same content should be equal",
            TranslogOperationHelper.compareSourcesWithOrder(yamlSource, cborSource)
            "Valid and invalid content should not be equal",
        // Setup for normal case
import org.opensearch.test.IndexSettingsModule;  
        BytesReference smileSource = BytesReference.bytes(
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);  
            helperWithDerivedSource.hasSameIndexOperation(op1, op2)
        assertTrue("Null sources should be equal", TranslogOperationHelper.compareSourcesWithOrder(null, null));  
            XContentFactory.cborBuilder().startObject().field("field", "value").field("number", 1).endObject()
    public void testSourceComparisonWithNestedObjectsForDerivedSource() throws IOException {
        Translog.Index op2 = new Translog.Index("1", 0, 1, source2.toBytesRef().bytes);
        assertTrue("Empty helper should compare operations normally", TranslogOperationHelper.DEFAULT.hasSameIndexOperation(op1, op2));
        BytesReference source1 = new BytesArray("{\"field\":\"value1\"}".getBytes(StandardCharsets.UTF_8));
        BytesReference source2 = new BytesArray("{\"obj\":{\"nested2\":2,\"nested1\":1}}".getBytes(StandardCharsets.UTF_8));
        BytesReference invalidContent = new BytesArray("invalid content".getBytes(StandardCharsets.UTF_8));
        assertFalse("Non-null and null sources should not be equal", TranslogOperationHelper.compareSourcesWithOrder(source, null));
 *
        BytesReference source1 = new BytesArray("{\"array\":[1,2,3]}".getBytes(StandardCharsets.UTF_8));
        assertFalse("Operations with different IDs should not be equal", helper.hasSameIndexOperation(op1, op2));  
        assertTrue("Sources with different field order should be equal", TranslogOperationHelper.compareSourcesWithOrder(source1, source2));  
    public void setup() throws Exception {
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        BytesReference source2 = new BytesArray(
import org.junit.Before;
            XContentFactory.jsonBuilder()
                .endObject()  
    public void testNullRoutingNormalCase() {  
            "Sources with nested objects in different order should be equal for derived source case",
        );
    public void testSourceComparisonWithNullValues() {
    private EngineConfig engineConfig;  
        EngineConfig derivedConfig = createEngineConfig(derivedIndexSettings);
        BytesReference validJson = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
    private MapperService createMapperService() throws IOException {
        assertTrue(
package org.opensearch.index.translog;
        Translog.Index op2 = new Translog.Index("2", 0, 1, source.toBytesRef().bytes);
    private TranslogOperationHelper helperWithDerivedSource;
            TranslogOperationHelper.compareSourcesWithOrder(validJson, invalidContent)  
        assertFalse("Operations with different routing should not be equal", helper.hasSameIndexOperation(op1, op2));  
            TranslogOperationHelper.compareSourcesWithOrder(source1, source2)
import org.opensearch.index.mapper.DocumentMapperForType;
    private DocumentMapperForType documentMapperForType;
        assertTrue("Identical operations should be equal", helper.hasSameIndexOperation(op1, op2));
    private TranslogOperationHelper helper;
        assertFalse(
import org.opensearch.core.common.bytes.BytesReference;  
    }  
        helperWithDerivedSource = TranslogOperationHelper.create(derivedConfig);
            TranslogOperationHelper.compareSourcesWithOrder(jsonSource, smileSource)
    public void testIdenticalOperationsNormalCase() {  
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
        assertTrue(  
        assertTrue("Identical operations should be equal for derived source", helperWithDerivedSource.hasSameIndexOperation(op1, op2));
import org.opensearch.index.seqno.RetentionLeases;
                .startObject("properties")  
                .startObject("properties")
            .build();
 * compatible open source license.
import java.nio.charset.StandardCharsets;
    public void testSourceComparisonWithMixedTypes() {  
        assertFalse("Operations with different primary terms should not be equal", helper.hasSameIndexOperation(op1, op2));
import org.opensearch.index.codec.CodecService;  
    public void testIdenticalOperationsDerivedSourceCase() {
            .codecService(new CodecService(null, indexSettings, logger, List.of()))
        final IndexMetadata defaultIndexMetadata = IndexMetadata.builder("test")  
        assertTrue("Identical arrays should be equal", TranslogOperationHelper.compareSourcesWithOrder(source1, source2));
            TranslogOperationHelper.compareSourcesWithOrder(yamlSource, smileSource)
        when(documentMapperForType.getDocumentMapper()).thenReturn(mapperService.documentMapper());
        BytesReference source2 = new BytesArray("{\"array\":[1,2,3]}".getBytes(StandardCharsets.UTF_8));
        );
        BytesReference source2 = new BytesArray("{\"b\":2,\"a\":1}".getBytes(StandardCharsets.UTF_8));
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
                .startObject("field")
        );  
        BytesReference source2 = new BytesArray("{\"field\":{\"nested2\":true,\"nested1\":1}}".getBytes(StandardCharsets.UTF_8));  
            TranslogOperationHelper.compareSourcesWithOrder(source1, source2)  
        Translog.Index op2 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
        return new EngineConfig.Builder().shardId(shardId)
                .field("type", "integer")
        Translog.Index op2 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);  
public class TranslogOperationHelperTests extends MapperServiceTestCase {
            .documentMapperForTypeSupplier(() -> documentMapperForType)
            "SMILE and CBOR with same content should be equal",
            XContentFactory.yamlBuilder().startObject().field("field", "value").field("number", 1).endObject()
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));  
        assertFalse("Operations with different sequence numbers should not be equal", helper.hasSameIndexOperation(op1, op2));
import org.opensearch.common.settings.Settings;  
/*  
        assertTrue(
    }
        documentMapperForType = mock(DocumentMapperForType.class);  
        );
        return createMapperService(fieldMapping(b -> b.field("type", "keyword")));  
        BytesReference jsonSource = new BytesArray("{\"field\":\"value\", \"number\":1}".getBytes(StandardCharsets.UTF_8));  
        );  
import java.io.IOException;  
        // CBOR format  
            .settings(settings(Version.CURRENT))
    private EngineConfig createEngineConfig(IndexSettings indexSettings) {  
    private MapperService mapperService;  
    }
    public void testSourceComparisonWithInvalidContent() {  
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
    }
            .numberOfShards(1)
                .endObject()
        );  
    }
        );
    }  
        Translog.Index op1 = new Translog.Index("1", 0, 1, source1.toBytesRef().bytes);  
        );
import org.opensearch.core.common.bytes.BytesArray;
        BytesReference source1 = new BytesArray("{\"obj\":{\"nested1\":1,\"nested2\":2}}".getBytes(StandardCharsets.UTF_8));
    public void testDifferentIdsNormalCase() {
        // Test different combinations
            "YAML and CBOR with same content should be equal",  
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
                .startObject("nested1")
            TranslogOperationHelper.compareSourcesWithOrder(smileSource, cborSource)  
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
        BytesReference source1 = new BytesArray("{\"a\":1,\"b\":2}".getBytes(StandardCharsets.UTF_8));  
            .build();
        assertFalse("Operations with different sources should not be equal", helper.hasSameIndexOperation(op1, op2));  
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        assertTrue(  
        documentMapperForType = mock(DocumentMapperForType.class);
        Translog.Index op2 = new Translog.Index("1", 0, 1, 0, source.toBytesRef().bytes, "route", 1);  
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        Translog.Index op1 = new Translog.Index("1", 0, 1, 0, source.toBytesRef().bytes, "route1", 1);  
            .put("index.derived_source.enabled", true)
import org.opensearch.common.xcontent.XContentFactory;
        engineConfig = createEngineConfig(defaultIndexSettings);
    public void testSourceComparisonWithDifferentContentTypes() throws IOException {
    public void testSourceComparisonWithNestedObjects() {  
        Translog.Index op2 = new Translog.Index("1", 0, 1, 0, source.toBytesRef().bytes, "route2", 1);
        Translog.Index op1 = new Translog.Index("1", 0, 1, 0, source.toBytesRef().bytes, null, 1);
    public void testDifferentPrimaryTermNormalCase() {
        );
        mapperService = createMapperService(
        BytesReference source1 = new BytesArray("{\"field\":{\"nested1\":1,\"nested2\":true}}".getBytes(StandardCharsets.UTF_8));
        mapperService = createMapperService();  
 * The OpenSearch Contributors require contributions made to  
                .endObject()  
        assertTrue(
    }
        Translog.Index op1 = new Translog.Index("1", 0, 1, source.toBytesRef().bytes);
import static org.mockito.Mockito.mock;
        IndexSettings derivedIndexSettings = new IndexSettings(derivedMetadata, Settings.EMPTY);
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        BytesReference cborSource = BytesReference.bytes(
        Translog.Index op1 = new Translog.Index("1", 0, 1, source1.toBytesRef().bytes);
    public void testSourceComparisonWithDifferentOrder() {
import org.opensearch.index.engine.EngineConfig;
            "YAML and SMILE with same content should be equal",
        Translog.Index op2 = new Translog.Index("1", 1, 1, source.toBytesRef().bytes);  
    @Before  
import org.opensearch.index.mapper.MapperServiceTestCase;
    }
    public void testEmptyHelper() {
            "Sources with mixed types in different order should be equal",  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
    }
 */  
                .startObject("nested2")
        BytesReference source = new BytesArray("{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8));  
        helper = TranslogOperationHelper.create(engineConfig);
import org.opensearch.core.index.shard.ShardId;
        // Setup for derived source case
import org.opensearch.Version;
        );
            .indexSettings(indexSettings)
            "Sources with nested objects in different order should be equal",
