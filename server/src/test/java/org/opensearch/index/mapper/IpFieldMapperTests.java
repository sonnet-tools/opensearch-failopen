        if (hasDocValues) {
        // Assert date field
        return List.of(new MockDocValuesDataFormatPlugin());
    public void testDefaults() throws Exception {
    }
import org.opensearch.common.util.FeatureFlags;
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {
        Settings pluggableSettings,
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;
 *
    }
            .put("index.pluggable.dataformat.enabled", true)
            FIELD_NAME,
        checker.registerUpdateCheck(
        assertEquals(1, fields.length);
        MapperService mapperService = createMapperService(fieldMapping(b -> {
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
                minimalMapping(x);
    protected void minimalMapping(XContentBuilder b) throws IOException {
 * software distributed under the License is distributed on an
    public void testNotIndexed() throws Exception {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        doc = mapper.parse(source(b -> b.nullField("field")));
import java.io.IOException;
            minimalMapping(b);
        assertEquals(DocValuesType.SORTED_SET, pointFieldAndDVField.fieldType().docValuesType());
    }
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
    }
            false
                b.field("index", true);
            b.endObject();
        mapper.copyTo = copyTo;
        }));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)
        IndexableField[] fields = doc.rootDoc().getFields("field");
 * Unless required by applicable law or agreed to in writing,
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(FIELD_NAME));
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {
        }));
        );
            }
            FIELD_NAME,
        }));
        assertEquals(1, fields.length);
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
            b.endObject();
 */
    }
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertTrue(explicit.fieldType("field").isSearchable());
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
            pluggableSettings,
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("127.0.0.1"))), pointFieldAndDVField.binaryValue());
                b.endObject();
import java.util.Collection;
        assertEquals(DocValuesType.SORTED_SET, pointFieldAndDVField.fieldType().docValuesType());
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */
        MapperParsingException e = expectThrows(
    }
            b.startObject("field2");
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {
import org.apache.lucene.util.BytesRef;
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
 * not use this file except in compliance with the License.
    private static final String FIELD_NAME = "field";
    @Override
                builder.endObject();
package org.opensearch.index.mapper;
        assertEquals(16, pointFieldAndDVField.fieldType().pointNumBytes());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        try (Directory directory = newDirectory()) {
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + ip + "\"" + "}", source);
        } else {
        assertThat(e.getCause().getMessage(), containsString("':1' is not an IP string literal"));
import org.opensearch.common.xcontent.XContentFactory;
        assertEquals(1, pointFieldAndDVField.fieldType().pointIndexDimensionCount());
            mapping(b -> b.startObject(FIELD_NAME).field("type", "ip").endObject()),
            b -> b.field(FIELD_NAME, "192.168.1.1"),
public class IpFieldMapperTests extends MapperTestCase {
import org.apache.lucene.document.SortedSetDocValuesField;
 * Licensed to Elasticsearch under one or more contributor
    /**
import org.apache.lucene.index.Term;
        if (!expectField) {
import org.apache.lucene.index.DirectoryReader;
        IndexableField pointFieldAndDVField = fields[0];
    /**
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            }).accept(b);
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("::1"))), pointField.binaryValue());
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "::1")));
        // Lucene path
    @Override
        }));
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
import org.apache.lucene.document.Document;
        assertEquals(1, fields.length);
    }
    /**
        b.field("type", "ip");
            b.field("type", "ip");
        );
            }
     * On a pluggable-dataformat index no BKD points are written for ip fields, so {@code index}
        mapper.parse(source(b -> b.nullField(FIELD_NAME)), docInput);
import static org.hamcrest.Matchers.containsString;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        IndexableField pointFieldAndDVField = fields[0];
            properties(x -> {
    }
        IndexableField dvField = fields[0];
        // Assert grouping criteria is correct
        assertEquals(2, fields.length);
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));
     * Helper method to create a document with both doc values and stored fields
    @Override
    private static Settings pluggableSettings() {
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
 * license agreements. See the NOTICE file distributed with
        assertEquals(new TermQuery(new Term(FieldNamesFieldMapper.NAME, "field")), existsQuery);
    public void testPluggableDataFormatIpValue() throws Exception {
        XContentBuilder mappingBuilder,
import org.apache.lucene.document.StoredField;
     * queries match nothing.
        }));
        })));
        Query existsQuery = m.fieldType().existsQuery(null);
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {
            minimalMapping(b);
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
    private void assertIpLuceneAndPluggablePathsEquivalent(
import org.apache.lucene.document.InetAddressPoint;
        return mapper;
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("::1"))), pointFieldAndDVField.binaryValue());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertEquals("/127.0.0.1", doc.docs().getFirst().getGroupingCriteria());
        assertIpLuceneAndPluggablePathsEquivalent(
import org.apache.lucene.index.IndexWriterConfig;
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
        // Scenario 2: null value — no field produced
import org.opensearch.common.settings.Settings;
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        }));
    public void testPluggableDataFormatIpNullSkipped() throws Exception {
        assertFalse(mapperService.fieldType("field").isSearchable());
            }
        }));
    public void testWithContextAwareGroupingMapper() throws IOException {
            b.field("store", true);
 * SPDX-License-Identifier: Apache-2.0
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                minimalMapping(b);
/*
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
        IndexableField pointField = fields[0];
        assertEquals(1, pointFieldAndDVField.fieldType().pointIndexDimensionCount());
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddress.getByName("::1"))), storedField.binaryValue());
    }
                iw.addDocument(createDocument(ip, false));
        DocumentMapper mapper2 = createDocumentMapper(fieldMapping(b -> {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
     * index is written — so the mapping is rejected rather than silently producing a field whose
        IndexableField[] fields = doc.rootDoc().getFields("field");
     */
        assertFalse(pointFieldAndDVField.fieldType().stored());
        String fieldName,
            b -> b.field("ignore_malformed", false),
            pluggableSettings,
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef(InetAddressPoint.encode(address))));
        ParsedDocument doc = mapper2.parse(source(b -> b.field("field", ":1")));
import java.util.List;
            String ip = "1.2.3.4";
        builder.value("::1");
    }
    }
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
    }
            minimalMapping(b);
import org.apache.lucene.index.IndexableField;
    private Document createDocument(String value, boolean hasDocValues) {
        MapperService mapperService = createMapperService(
            doc.add(new StoredField(FIELD_NAME, new BytesRef(InetAddressPoint.encode(address))));
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "::1")));
    protected Collection<? extends Plugin> getPlugins() {
        IndexableField pointFieldAndDVField = fields[0];
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        merge(mapperService, mapping(b -> {
    @Override
    }
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
import org.opensearch.core.xcontent.XContentBuilder;
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {
                x.startObject("field");
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertTrue(storedField.fieldType().stored());
 *
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "::1")));
    protected void registerParameters(ParameterChecker checker) throws IOException {
            mapping(b -> b.startObject(FIELD_NAME).field("type", "ip").endObject())
            b.field("index", false);
    }
        assertEquals(1, fields.length);
    }
        Document doc = new Document();
     */
 * this file be licensed under the Apache-2.0 license or a
    }
    public void testIgnoreMalformed() throws Exception {
            pluggableSettings,
    }
        InetAddress address = InetAddresses.forString(value);
        doc = mapper.parse(source(b -> b.nullField("field")));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertWarnings("Error parsing [:1] as IP in [null_value] on field [field]); [null_value] will be ignored");
            b.field("doc_values", false);
 */
            b.field("type", "ip");
        mapper.parse(source(b -> b.field(FIELD_NAME, "192.168.1.1")), docInput);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "::1")));
import org.opensearch.plugins.Plugin;
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + ip + "\"" + "}", source);
                String source = builder.toString();
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        DocumentMapper mapper = createDocumentMapper(
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
import org.apache.lucene.search.TermQuery;
        }));
            pluggableSettings,
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the
 *
}
        pluggableMapper.parse(source(sourceBuilder), docInput);
            b.field("type", "ip");
        assertFalse(mapperService.fieldType("field").isSearchable());
        checker.registerConflictCheck("null_value", b -> b.field("null_value", "::1"));
/*
        IndexableField[] fields = doc.rootDoc().getFields("field");
        );
            b.field("index", false);
        );
 * Modifications Copyright OpenSearch Contributors. See
        }));
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
        IpFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, false);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
        }
        IpFieldMapper mapper = getMapper(copyTo, true, true);
            }))
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
 * under the License.
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {
     */
import org.opensearch.common.network.InetAddresses;
import org.apache.lucene.store.Directory;
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
        boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
            b.startObject("field2");
     * defaults to false and the field reports itself as not searchable — routing queries to the
            b -> b.nullField(FIELD_NAME),
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
/*
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */
 * KIND, either express or implied.  See the License for the
    public void testDerivedValueFetching_StoredField() throws IOException {
import org.opensearch.common.CheckedConsumer;
            b.nullField("null_value");
            minimalMapping(b);
        assertEquals(0, fields.length);
 * You may obtain a copy of the License at
        assertEquals(1, fields.length);
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,
import org.apache.lucene.index.DocValuesType;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index — no point
 * ownership. Elasticsearch licenses this file to you under
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "127.0.0.1")));
        }));
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
    ) throws IOException {
    public void testNullValue() throws IOException {
        mapper = createDocumentMapper(fieldMapping(b -> {
import org.opensearch.index.termvectors.TermVectorsService;
        );
    }
            b.field("type", "ip");
            IpFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, true);
        }));
        }));
        createDocumentMapper(fieldMapping(b -> {
        assertEquals(DocValuesType.SORTED_SET, dvField.fieldType().docValuesType());
            b.field("type", "ip");
            b.field("index", true);
            minimalMapping(b);
            assertTrue("Pluggable path should capture field '" + fieldName + "'", pluggableHasField);
                String source = builder.toString();
 * this work for additional information regarding copyright
    }
        IpFieldMapper mapper = (IpFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
    }
        );
     */
    }
    public void testDerivedValueFetching_DocValues() throws IOException {
    }
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertFalse("Expected no ip field to be captured for null value", found);
            mapping(b -> b.startObject(FIELD_NAME).field("type", "ip").endObject()),
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("::1"))), pointFieldAndDVField.binaryValue());
            b.field("doc_values", false);
        checker.registerConflictCheck("index", b -> b.field("index", false));
            b.field("ignore_malformed", true);
                iw.addDocument(createDocument(ip, true));
 * The OpenSearch Contributors require contributions made to
        }
        DocumentMapper mapper = createDocumentMapper(
 * the Apache License, Version 2.0 (the "License"); you may
        assertArrayEquals(new String[] { "field" }, TermVectorsService.getValues(doc.rootDoc().getFields("_ignored")));
        assertFalse(mapperService.fieldType("field").isSearchable());
    }
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        assertEquals(16, pointFieldAndDVField.fieldType().pointNumBytes());
    }
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(FIELD_NAME));
        boolean expectField
 * GitHub history for details.
        assertEquals(DocValuesType.SORTED_SET, pointFieldAndDVField.fieldType().docValuesType());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
     * doc-values column instead of an empty point index.
            .build();
        checker.registerConflictCheck("store", b -> b.field("store", true));
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());
        try (Directory directory = newDirectory()) {
        IndexableField pointFieldAndDVField = fields[0];
        return doc;
        assertFalse(pointFieldAndDVField.fieldType().stored());
 */
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
        assertEquals(DocValuesType.SORTED_SET, pointFieldAndDVField.fieldType().docValuesType());
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        CapturingDocumentInput docInput = new CapturingDocumentInput();
import java.net.InetAddress;
        MapperService explicit = createMapperService(fieldMapping(b -> {
            b.field("type", "ip");
    }
            String ip = "1.2.3.4";
        assertEquals(1, pointFieldAndDVField.fieldType().pointIndexDimensionCount());
    }
        assertExistsQuery(mapperService);
        return Settings.builder()
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testNoDocValues() throws Exception {
        IndexableField storedField = fields[1];
            contextAwareGrouping("field").accept(b);
        );
            MapperParsingException.class,
            b.field("index", true);
            IpFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), true, false);
            mapping(b -> b.startObject(FIELD_NAME).field("type", "ip").endObject())
        assertEquals(1, pointFieldAndDVField.fieldType().pointIndexDimensionCount());
    }
        assertTrue(mapperService.fieldType("field").isSearchable());
        ThrowingRunnable runnable = () -> mapper.parse(source(b -> b.field("field", ":1")));
    private IpFieldMapper getMapper(FieldMapper.CopyTo copyTo, boolean hasDocValues, boolean isStored) throws IOException {
        } else {
            m -> assertFalse(((IpFieldMapper) m).ignoreMalformed().value())
        }
            }
        CapturingDocumentInput docInput = new CapturingDocumentInput();
            b.field("null_value", "::1");
    }
        assertParseMinimalWarnings();
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        assertEquals(16, pointFieldAndDVField.fieldType().pointNumBytes());
     * value of the already-mapped field unchanged.
 * compatible open source license.
 * specific language governing permissions and limitations
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);
        // Scenario 1: ip value
    /**
        assertTrue("Expected ip field to be captured", found);
        assertIpLuceneAndPluggablePathsEquivalent(
            b.field("null_value", ":1");
        fields = doc.rootDoc().getFields(FieldNamesFieldMapper.NAME);
import org.apache.lucene.index.IndexWriter;
        assertEquals(1, fields.length);
            fieldMapping(b -> b.field("type", "ip").field("store", isStored).field("doc_values", hasDocValues))
        // Pluggable path
    public void testStore() throws Exception {
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {
                builder.endObject();
        mapper = createDocumentMapper(fieldMapping(b -> {
        MapperParsingException e = expectThrows(MapperParsingException.class, runnable);
        FieldMapper m = (FieldMapper) mapper.mappers().getMapper("field");
    public void testExistsQueryDocValuesDisabled() throws IOException {
        assertEquals("field", fields[0].stringValue());
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        assertFalse(pointFieldAndDVField.fieldType().stored());
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
    }
import org.apache.lucene.search.Query;
            b.field("type", "ip");
            true
        }
