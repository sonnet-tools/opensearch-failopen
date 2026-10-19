        assertFalse("Expected no binary field to be captured for null value", found);
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
        assertExistsQuery(mapperService);
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
    }
        }
    public void testPluggableDataFormatBinaryValue() throws Exception {
import org.opensearch.common.util.FeatureFlags;  
        boolean expectField
        byte[] testValue = new byte[] { 1, 2, 3 };  
 * SPDX-License-Identifier: Apache-2.0
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
            MappedFieldType fieldType = mapperService.fieldType("field");
    }
        }
    protected void registerParameters(ParameterChecker checker) throws IOException {
        );
        String base64Value = java.util.Base64.getEncoder().encodeToString(testValue);
            minimalMapping(b);
 * ownership. Elasticsearch licenses this file to you under  
        assertExistsQuery(mapperService);
        }));
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {
        CapturingDocumentInput docInput = new CapturingDocumentInput();
import static org.hamcrest.Matchers.equalTo;
 */  
        boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
        // case 1: a simple binary value
 */  
        mapper.parse(source(b -> b.field("field", base64Value)), docInput);
    }  
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
 */
    public void testExistsQueryStoreAndDocValuesDiabled() throws IOException {
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            "field",  
        assertThat(mapper.fieldType.stored(), equalTo(false));
    public void testExistsQueryDocValuesEnabled() throws IOException {  
import java.io.OutputStream;
            assertEquals(new BytesRef(value), indexedValue);
 *
        assertBinaryLuceneAndPluggablePathsEquivalent(
    @Override  
            true
        // Pluggable path
        Settings pluggableSettings,  
    @Override
        pluggableMapper.parse(source(sourceBuilder), docInput);
        checker.registerConflictCheck("store", b -> b.field("store", true));  
            mapping(b -> b.startObject("field").field("type", "binary").field("store", true).endObject())  
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
        String base64Value = java.util.Base64.getEncoder().encodeToString(testValue);
            }  
 * KIND, either express or implied.  See the License for the
        }));
package org.opensearch.index.mapper;
        }  
        // Scenario 1: binary value — both paths produce a field
            b.field("doc_values", true);  
            false
        );
            minimalMapping(b);
 *  
}
        binaryValue[56] = 1;  
        assertThat(mapper, instanceOf(BinaryFieldMapper.class));  
        assertExistsQuery(mapperService);
        String fieldName,  
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
            minimalMapping(b);
        }));  
            if (randomBoolean()) {
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);  
            new BytesArray(binaryValue1).writeTo(compressed);  
        // Scenario 2: null value — no field produced
import org.opensearch.core.xcontent.XContentBuilder;
    }
            BytesRef indexedValue = doc.rootDoc().getBinaryValue("field");
import java.io.IOException;  
/*  
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
        byte[] testValue = new byte[] { 1, 2, 3 };  
 * not use this file except in compliance with the License.
        binaryValue1[56] = 1;
 * GitHub history for details.
        MapperService mapperService = createMapperService(fieldMapping(b -> {
                b.field("doc_values", false);
            "field",  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            minimalMapping(b);
 * You may obtain a copy of the License at  
        mapper.parse(source(b -> b.nullField("field")), docInput);
    @Override  
            b.field("doc_values", false);  
import org.opensearch.core.common.bytes.BytesReference;
 * under the License.  
            b.field("store", "true");
    public void testExistsQueryStoreEnabled() throws IOException {  
            b -> b.field("field", base64Value),
            }  
    }  
public class BinaryFieldMapperTests extends MapperTestCase {
    ) throws IOException {
            assertTrue("Pluggable path should capture field '" + fieldName + "'", pluggableHasField);
        );
/*  
import org.apache.lucene.util.BytesRef;
import org.opensearch.common.io.stream.BytesStreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
        }));
 *
        // case 2: a value that looks compressed: this used to fail in 1.x  
        );
            b.field("store", true);  
        final byte[] binaryValue = new byte[100];
        DocumentMapper mapper = createDocumentMapper(
import org.opensearch.common.CheckedConsumer;  
    }
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        b.field("type", "binary");  
 * compatible open source license.
        } else {  
 * Modifications Copyright OpenSearch Contributors. See
            pluggableSettings,  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
    }
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", true));
import org.apache.lucene.index.IndexableField;
        final byte[] binaryValue2 = BytesReference.toBytes(out.bytes());
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
            b.field("store", false);
import java.util.Arrays;
 * specific language governing permissions and limitations
        XContentBuilder mappingBuilder,
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
    public void testPluggableDataFormatBinaryNullSkipped() throws Exception {  
import static org.hamcrest.Matchers.instanceOf;
            pluggableSettings,  
        final byte[] binaryValue1 = new byte[100];  
 * The OpenSearch Contributors require contributions made to  
                b.field("store", randomBoolean());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }  
    private void assertBinaryLuceneAndPluggablePathsEquivalent(
        builder.value(binaryValue);
 * license agreements. See the NOTICE file distributed with
            mapping(b -> b.startObject("field").field("type", "binary").field("store", true).endObject()),
            ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", value)));  
    public void testDefaultMapping() throws Exception {
/*
            pluggableSettings,
        assertTrue("Expected binary field to be captured", found);
            if (randomBoolean()) {
        if (!expectField) {  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            Object originalValue = fieldType.valueForDisplay(indexedValue);
        assertBinaryLuceneAndPluggablePathsEquivalent(
        assertTrue(CompressorRegistry.isCompressed(new BytesArray(binaryValue2)));  
        BytesStreamOutput out = new BytesStreamOutput();
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
            mapping(b -> b.startObject("field").field("type", "binary").field("store", true).endObject()),
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);  
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));  
            mapping(b -> b.startObject("field").field("type", "binary").field("store", true).endObject())
    public void testStoredValue() throws IOException {
import org.opensearch.core.compress.CompressorRegistry;  
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        for (byte[] value : Arrays.asList(binaryValue1, binaryValue2)) {
    }
            assertEquals(new BytesArray(value), originalValue);  
        // Lucene path  
    }  
            b -> b.nullField("field"),
    protected void minimalMapping(XContentBuilder b) throws IOException {
            pluggableSettings,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;
        DocumentMapper mapper = createDocumentMapper(
        try (OutputStream compressed = CompressorRegistry.defaultCompressor().threadLocalOutputStream(out)) {
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
import org.opensearch.core.common.bytes.BytesArray;
        assertParseMinimalWarnings();  
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
