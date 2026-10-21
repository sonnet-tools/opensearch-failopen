    }
import org.opensearch.core.xcontent.XContentBuilder;
        // Lucene path
import java.io.IOException;
        String fieldName,
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
import static org.hamcrest.Matchers.equalTo;
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
        boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
import java.util.Arrays;
        String base64Value = java.util.Base64.getEncoder().encodeToString(testValue);
 * specific language governing permissions and limitations
    }
 * this work for additional information regarding copyright
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
    public void testPluggableDataFormatBinaryValue() throws Exception {
    }
    }
            mapping(b -> b.startObject("field").field("type", "binary").field("store", true).endObject()),
    private void assertBinaryLuceneAndPluggablePathsEquivalent(
        MapperService mapperService = createMapperService(fieldMapping(b -> {
 * Licensed to Elasticsearch under one or more contributor
 * ownership. Elasticsearch licenses this file to you under
    public void testPluggableDataFormatBinaryNullSkipped() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            minimalMapping(b);
import static org.hamcrest.Matchers.instanceOf;
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
    }
            new BytesArray(binaryValue1).writeTo(compressed);
        );
 */
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
    }
            minimalMapping(b);
            pluggableSettings,
        b.field("type", "binary");
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    public void testExistsQueryDocValuesEnabled() throws IOException {
            if (randomBoolean()) {
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
 * software distributed under the License is distributed on an
        binaryValue1[56] = 1;
            }
            assertTrue("Pluggable path should capture field '" + fieldName + "'", pluggableHasField);
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
/*
            mapping(b -> b.startObject("field").field("type", "binary").field("store", true).endObject()),
        if (!expectField) {
 * You may obtain a copy of the License at
    }
        // Pluggable path
        builder.value(binaryValue);
        );
import java.io.OutputStream;
        assertThat(mapper, instanceOf(BinaryFieldMapper.class));
            "field",
 * Modifications Copyright OpenSearch Contributors. See
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
import org.apache.lucene.index.IndexableField;
    public void testStoredValue() throws IOException {
            mapping(b -> b.startObject("field").field("type", "binary").field("store", true).endObject())
            ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", value)));
    }
    public void testExistsQueryStoreEnabled() throws IOException {
import org.opensearch.core.compress.CompressorRegistry;
        for (byte[] value : Arrays.asList(binaryValue1, binaryValue2)) {
    protected void registerParameters(ParameterChecker checker) throws IOException {
        boolean expectField
/*
            false
        BytesStreamOutput out = new BytesStreamOutput();
    ) throws IOException {
        assertTrue(CompressorRegistry.isCompressed(new BytesArray(binaryValue2)));
        checker.registerConflictCheck("store", b -> b.field("store", true));
 *
            b.field("store", false);
            true
            b.field("store", true);
        // Scenario 2: null value — no field produced
            b.field("doc_values", true);
        XContentBuilder mappingBuilder,
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                b.field("store", randomBoolean());
 * license agreements. See the NOTICE file distributed with
        byte[] testValue = new byte[] { 1, 2, 3 };
 * The OpenSearch Contributors require contributions made to
            pluggableSettings,
        }
            pluggableSettings,
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            assertEquals(new BytesArray(value), originalValue);
    @Override
 * not use this file except in compliance with the License.
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {
            "field",
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    public void testDefaultMapping() throws Exception {
        assertExistsQuery(mapperService);
        assertParseMinimalWarnings();
    }
        );
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
    public void testExistsQueryStoreAndDocValuesDiabled() throws IOException {
        }));
            minimalMapping(b);
import org.apache.lucene.util.BytesRef;
        final byte[] binaryValue = new byte[100];
        byte[] testValue = new byte[] { 1, 2, 3 };
        }));
        binaryValue[56] = 1;
import org.opensearch.core.common.bytes.BytesReference;
            b.field("doc_values", false);
        MapperService mapperService = createMapperService(fieldMapping(b -> {
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.core.common.bytes.BytesArray;
        CapturingDocumentInput docInput = new CapturingDocumentInput();
    }
    protected void minimalMapping(XContentBuilder b) throws IOException {
    }
        }
            pluggableSettings,
        );
        } else {
            Object originalValue = fieldType.valueForDisplay(indexedValue);
        assertBinaryLuceneAndPluggablePathsEquivalent(
        assertExistsQuery(mapperService);
    }
        pluggableMapper.parse(source(sourceBuilder), docInput);
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            mapping(b -> b.startObject("field").field("type", "binary").field("store", true).endObject())
                b.field("doc_values", false);
 * GitHub history for details.
        assertFalse("Expected no binary field to be captured for null value", found);
        assertTrue("Expected binary field to be captured", found);
 * compatible open source license.
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
        DocumentMapper mapper = createDocumentMapper(
            b.field("store", "true");
 *
        // case 1: a simple binary value
        String base64Value = java.util.Base64.getEncoder().encodeToString(testValue);
import org.opensearch.common.settings.Settings;
 * under the License.
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        assertThat(mapper.fieldType.stored(), equalTo(false));
        mapper.parse(source(b -> b.nullField("field")), docInput);
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.io.stream.BytesStreamOutput;
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("field"));
        mapper.parse(source(b -> b.field("field", base64Value)), docInput);
        }));
        final byte[] binaryValue2 = BytesReference.toBytes(out.bytes());
            minimalMapping(b);
/*
        // case 2: a value that looks compressed: this used to fail in 1.x
        assertBinaryLuceneAndPluggablePathsEquivalent(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        Settings pluggableSettings,
 * Unless required by applicable law or agreed to in writing,
 *
}
            if (randomBoolean()) {
import org.opensearch.common.CheckedConsumer;
        }
        }));
package org.opensearch.index.mapper;
 * KIND, either express or implied.  See the License for the
        assertExistsQuery(mapperService);
        DocumentMapper mapper = createDocumentMapper(
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", true));
            b -> b.nullField("field"),
            b -> b.field("field", base64Value),
            }
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        try (OutputStream compressed = CompressorRegistry.defaultCompressor().threadLocalOutputStream(out)) {
public class BinaryFieldMapperTests extends MapperTestCase {
 * this file be licensed under the Apache-2.0 license or a
        // Scenario 1: binary value — both paths produce a field
            assertEquals(new BytesRef(value), indexedValue);
        final byte[] binaryValue1 = new byte[100];
            BytesRef indexedValue = doc.rootDoc().getBinaryValue("field");
            MappedFieldType fieldType = mapperService.fieldType("field");
 */
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
