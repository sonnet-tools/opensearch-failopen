    }
     */  
        try (Directory directory = newDirectory()) {  
    @Override
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> merge(mapperService, mapping(b -> {
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
        try (Directory directory = newDirectory()) {  
        assertFalse("Expected no ip field to be captured for null value", found);
        // Scenario 1: ip value
        }));
        assertFalse(pointFieldAndDVField.fieldType().stored());
import org.apache.lucene.search.Query;
        DocumentMapper mapper = createDocumentMapper(
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "::1")));
        assertThat(e.getCause().getMessage(), containsString("':1' is not an IP string literal"));
        );  
            FIELD_NAME,
            pluggableSettings,
        assertEquals(1, pointFieldAndDVField.fieldType().pointIndexDimensionCount());  
        }
        assertFalse(mapperService.fieldType("field").isSearchable());
        );
import org.apache.lucene.index.Term;
            b.field("type", "ip");  
import static org.hamcrest.Matchers.containsString;  
            }
        IndexableField pointField = fields[0];  
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
     * value of the already-mapped field unchanged.
            () -> createMapperService(pluggableSettings(), fieldMapping(b -> {
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "::1")));
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));  
        assertEquals(1, pointFieldAndDVField.fieldType().pointIndexDimensionCount());  
    }
    }  
    }
public class IpFieldMapperTests extends MapperTestCase {
    public void testPluggableDataFormatIpValue() throws Exception {
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(FIELD_NAME));
            }
        }));
    public void testPluggablePathEquivalenceWithLucenePath() throws Exception {
                iw.addDocument(createDocument(ip, true));
        }));
        merge(mapperService, mapping(b -> {  
 * Unless required by applicable law or agreed to in writing,
     * queries match nothing.
                String source = builder.toString();
 * specific language governing permissions and limitations
            }))
        IndexableField pointFieldAndDVField = fields[0];
    }
        String fieldName,
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                x.startObject("field");  
                b.field("index", true);  
import org.opensearch.core.xcontent.XContentBuilder;
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
    public void testDerivedValueFetching_StoredField() throws IOException {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {  
            b -> b.field(FIELD_NAME, "192.168.1.1"),  
    }
        assertEquals("/127.0.0.1", doc.docs().getFirst().getGroupingCriteria());
    /** Indices that do not use a pluggable dataformat keep the standard {@code index: true} default. */  
import org.apache.lucene.document.SortedSetDocValuesField;  
    }
            .put("index.pluggable.dataformat", MockDocValuesDataFormatPlugin.FORMAT_NAME)  
            m -> assertFalse(((IpFieldMapper) m).ignoreMalformed().value())  
        checker.registerUpdateCheck(
            b.field("type", "ip");
    public void testNotIndexed() throws Exception {
    }  
    public void testPluggableDataFormatDefaultsIndexToFalse() throws IOException {
        }
    ) throws IOException {  
        IndexableField[] fields = doc.rootDoc().getFields("field");
            b.field("type", "ip");
            b.endObject();  
                b.endObject();
 */  
        doc = mapper.parse(source(b -> b.nullField("field")));
import org.apache.lucene.index.DocValuesType;  
package org.opensearch.index.mapper;
        assertTrue(explicit.fieldType("field").isSearchable());  
        }
        })));
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
     * Helper method to create a document with both doc values and stored fields
        assertEquals(DocValuesType.SORTED_SET, pointFieldAndDVField.fieldType().docValuesType());
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));
    /**
        assertEquals(1, fields.length);
            mapping(b -> b.startObject(FIELD_NAME).field("type", "ip").endObject())
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("::1"))), pointFieldAndDVField.binaryValue());  
     * An explicit {@code index: true} cannot be honoured on a pluggable-dataformat index — no point
 * The OpenSearch Contributors require contributions made to  
        assertEquals(DocValuesType.SORTED_SET, dvField.fieldType().docValuesType());
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {  
    }
import org.apache.lucene.util.BytesRef;
        assertWarnings("Error parsing [:1] as IP in [null_value] on field [field]); [null_value] will be ignored");  
/*  
        IndexableField pointFieldAndDVField = fields[0];  
        assertEquals(1, fields.length);
    }  
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
        pluggableMapper.parse(source(sourceBuilder), docInput);  
            assertEquals("Lucene path should produce no field for '" + fieldName + "'", 0, luceneFields.length);
            FIELD_NAME,
            assertTrue("Lucene path should produce field '" + fieldName + "'", luceneFields.length > 0);
            minimalMapping(b);  
 * this file be licensed under the Apache-2.0 license or a
            b.field("null_value", ":1");
    public void testDefaults() throws Exception {
    public void testStore() throws Exception {
            b.field("store", true);
import java.util.Collection;  
            mapping(b -> b.startObject(FIELD_NAME).field("type", "ip").endObject())
        mapper.copyTo = copyTo;  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            b.field("type", "ip");
        IndexableField dvField = fields[0];  
        MapperService mapperService = createMapperService(
            MapperParsingException.class,  
    }
                minimalMapping(b);
        if (hasDocValues) {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
    private void assertIpLuceneAndPluggablePathsEquivalent(  
        assertEquals(1, fields.length);
        IndexableField pointFieldAndDVField = fields[0];
        assertArrayEquals(new String[] { "field" }, TermVectorsService.getValues(doc.rootDoc().getFields("_ignored")));
    }  
    protected void registerParameters(ParameterChecker checker) throws IOException {
        mapper = createDocumentMapper(fieldMapping(b -> {  
        boolean expectField
 * Licensed to Elasticsearch under one or more contributor  
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
            true
import org.apache.lucene.index.IndexableField;  
            properties(x -> {
        // Pluggable path  
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("127.0.0.1"))), pointFieldAndDVField.binaryValue());  
            b.field("doc_values", false);
    /** An explicit {@code index: false} is accepted on a pluggable-dataformat index. */  
        DocumentMapper luceneMapper = createDocumentMapper(mappingBuilder);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertEquals(16, pointFieldAndDVField.fieldType().pointNumBytes());
            b.startObject("field2");
    public void testPluggableDataFormatIpNullSkipped() throws Exception {  
    @Override  
    }
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
    }
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        b.field("type", "ip");
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {  
            b.field("ignore_malformed", true);  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "::1")));
 * Modifications Copyright OpenSearch Contributors. See
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(b -> {  
            mapping(b -> b.startObject(FIELD_NAME).field("type", "ip").endObject()),
        assertEquals(1, pointFieldAndDVField.fieldType().pointIndexDimensionCount());  
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
import org.opensearch.common.CheckedConsumer;  
import org.apache.lucene.index.IndexWriterConfig;
        assertEquals(1, fields.length);
 * ownership. Elasticsearch licenses this file to you under  
            b -> b.field("ignore_malformed", false),
 * software distributed under the License is distributed on an
        assertFalse(pointFieldAndDVField.fieldType().stored());
        MapperParsingException e = expectThrows(
            b.nullField("null_value");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        IndexableField pointFieldAndDVField = fields[0];
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(FIELD_NAME));  
        return List.of(new MockDocValuesDataFormatPlugin());  
        }));
    private static Settings pluggableSettings() {  
 * GitHub history for details.
    public void testPluggableDataFormatMappingUpdateRejectsIndexTrue() throws IOException {  
        assertParseMinimalWarnings();
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();  
                iw.addDocument(createDocument(ip, false));
    }  
        DocumentMapper mapper = createDocumentMapper(  
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        return Settings.builder()
        assertFalse(pointFieldAndDVField.fieldType().stored());
        assertFalse("newly added field should default to not-indexed", mapperService.fieldType("field2").isSearchable());  
import org.apache.lucene.index.DirectoryReader;
        MapperService mapperService = createMapperService(pluggableSettings(), fieldMapping(this::minimalMapping));  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        fields = doc.rootDoc().getFields(FieldNamesFieldMapper.NAME);
        DocumentMapper mapper2 = createDocumentMapper(fieldMapping(b -> {
        MapperService explicit = createMapperService(fieldMapping(b -> {
    protected Collection<? extends Plugin> getPlugins() {
 *
            pluggableSettings,
        assertEquals(DocValuesType.SORTED_SET, pointFieldAndDVField.fieldType().docValuesType());
    public void testDerivedValueFetching_DocValues() throws IOException {
    }
     * On a pluggable-dataformat index no BKD points are written for ip fields, so {@code index}
        assertEquals(1, fields.length);
        IndexableField[] fields = doc.rootDoc().getFields("field");
        Query existsQuery = m.fieldType().existsQuery(null);  
    }
import org.apache.lucene.document.Document;
    /**  
            b.field("index", false);
 * You may obtain a copy of the License at  
        assertTrue(storedField.fieldType().stored());
import org.opensearch.common.xcontent.XContentFactory;
            minimalMapping(b);
            contextAwareGrouping("field").accept(b);
                String source = builder.toString();
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
            pluggableSettings,  
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("::1"))), pointField.binaryValue());
    /** A mapping update that sets index:true on a new field is rejected on a pluggable data format index. */
            b.startObject("field2");  
     * A field added by a later mapping update also defaults to not-indexed, and the update leaves the
     */
    }
        mapper.parse(source(b -> b.nullField(FIELD_NAME)), docInput);
        if (!expectField) {
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + ip + "\"" + "}", source);  
            }
 *
    }  
            String ip = "1.2.3.4";
            minimalMapping(b);
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
 * under the License.  
        assertEquals(0, fields.length);  
            b.endObject();  
}
        mapper.parse(source(b -> b.field(FIELD_NAME, "192.168.1.1")), docInput);
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + ip + "\"" + "}", source);  
 * KIND, either express or implied.  See the License for the
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        );
            minimalMapping(b);  
        return mapper;
            IpFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, true);
        Document doc = new Document();  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {  
        checker.registerConflictCheck("index", b -> b.field("index", false));
        IndexableField[] fields = doc.rootDoc().getFields("field");  
import org.opensearch.plugins.Plugin;
            b -> b.nullField(FIELD_NAME),  
    }
        );  
        mapper = createDocumentMapper(fieldMapping(b -> {
import org.opensearch.common.util.FeatureFlags;  
     * doc-values column instead of an empty point index.
 * SPDX-License-Identifier: Apache-2.0
        IndexableField[] luceneFields = luceneDoc.rootDoc().getFields(fieldName);
    /**
 * license agreements. See the NOTICE file distributed with
        CapturingDocumentInput docInput = new CapturingDocumentInput();
        assertFalse("existing field's value should be preserved across the update", mapperService.fieldType("field").isSearchable());
 * not use this file except in compliance with the License.
        }));  
        } else {
        assertEquals(new TermQuery(new Term(FieldNamesFieldMapper.NAME, "field")), existsQuery);
    public void testWithContextAwareGroupingMapper() throws IOException {
            doc.add(new StoredField(FIELD_NAME, new BytesRef(InetAddressPoint.encode(address))));
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);  
            IpFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), true, false);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        );  
    }
        IndexableField storedField = fields[1];  
    }  
        doc = mapper.parse(source(b -> b.nullField("field")));
import org.apache.lucene.document.InetAddressPoint;
        MapperParsingException e = expectThrows(MapperParsingException.class, runnable);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    /**
        boolean pluggableHasField = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals(fieldName));
        }));
        assertTrue(mapperService.fieldType("field").isSearchable());  
import org.apache.lucene.search.TermQuery;  
        XContentBuilder mappingBuilder,
            b.field("index", true);
            fieldMapping(b -> b.field("type", "ip").field("store", isStored).field("doc_values", hasDocValues))  
        // Assert date field
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
 */
    public void testPluggableDataFormatRejectsExplicitIndexTrue() {
            false
import org.apache.lucene.store.Directory;
     * index is written — so the mapping is rejected rather than silently producing a field whose  
import org.apache.lucene.document.StoredField;
            minimalMapping(b);
                builder.endObject();
            b.field("null_value", "::1");
    public void testPluggableDataFormatMappingUpdateDefaultsNewFieldToNotIndexed() throws IOException {
 * compatible open source license.
        }));  
    public void testNullValue() throws IOException {
        }));  
import org.opensearch.common.settings.Settings;
            .put("index.pluggable.dataformat.enabled", true)
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        CapturingDocumentInput docInput = new CapturingDocumentInput();
import org.apache.lucene.index.IndexWriter;
        CheckedConsumer<XContentBuilder, IOException> sourceBuilder,  
        Settings pluggableSettings,
            mapping(b -> b.startObject(FIELD_NAME).field("type", "ip").endObject()),
/*
 */  
        assertEquals(1, pointField.fieldType().pointIndexDimensionCount());
        );
        assertEquals(1, pointFieldAndDVField.fieldType().pointIndexDimensionCount());
        IpFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), false, false);
            }).accept(b);  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
 * this work for additional information regarding copyright
     * defaults to false and the field reports itself as not searchable — routing queries to the  
        // Scenario 2: null value — no field produced
    private Document createDocument(String value, boolean hasDocValues) {
        ParsedDocument doc = mapper2.parse(source(b -> b.field("field", ":1")));  
        createDocumentMapper(fieldMapping(b -> {
        assertIpLuceneAndPluggablePathsEquivalent(  
import java.io.IOException;
        assertEquals(16, pointFieldAndDVField.fieldType().pointNumBytes());
    public void testNonPluggableDataFormatKeepsIndexTrue() throws IOException {
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            b.field("doc_values", false);
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));  
        assertEquals(16, pointFieldAndDVField.fieldType().pointNumBytes());
    public void testExistsQueryDocValuesDisabled() throws IOException {
            assertFalse("Pluggable path should produce no field for '" + fieldName + "'", pluggableHasField);  
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddresses.forString("::1"))), pointFieldAndDVField.binaryValue());  
        DocumentMapper pluggableMapper = createDocumentMapper(pluggableSettings, mappingBuilder);
        // Assert grouping criteria is correct  
    private static final String FIELD_NAME = "field";
        FieldMapper m = (FieldMapper) mapper.mappers().getMapper("field");
    protected void minimalMapping(XContentBuilder b) throws IOException {  
            }
        assertFalse(mapperService.fieldType("field").isSearchable());
 *     http://www.apache.org/licenses/LICENSE-2.0
                minimalMapping(x);
     */
    @Override
        assertEquals(new BytesRef(InetAddressPoint.encode(InetAddress.getByName("::1"))), storedField.binaryValue());
    }
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));  
import org.opensearch.common.network.InetAddresses;
        assertExistsQuery(mapperService);  
        // Lucene path
    }
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(DocValuesType.SORTED_SET, pointFieldAndDVField.fieldType().docValuesType());
        assertEquals(DocValuesType.SORTED_SET, pointFieldAndDVField.fieldType().docValuesType());
        ThrowingRunnable runnable = () -> mapper.parse(source(b -> b.field("field", ":1")));  
     */  
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));  
    }  
        ParsedDocument luceneDoc = luceneMapper.parse(source(sourceBuilder));  
        assertIpLuceneAndPluggablePathsEquivalent(  
            b.field("type", "ip");  
        }));  
        checker.registerConflictCheck("store", b -> b.field("store", true));
            b.field("index", true);
            b.field("type", "ip");
        assertEquals(2, fields.length);
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
    @Override
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        IpFieldMapper mapper = (IpFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
        assertFalse(mapperService.fieldType("field").isSearchable());  
        IndexableField[] fields = doc.rootDoc().getFields("field");
 *  
                builder.endObject();
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
import org.opensearch.index.termvectors.TermVectorsService;
import org.opensearch.index.engine.dataformat.stub.MockDocValuesDataFormatPlugin;  
    }
        assertEquals("field", fields[0].stringValue());  
        builder.value("::1");
    private IpFieldMapper getMapper(FieldMapper.CopyTo copyTo, boolean hasDocValues, boolean isStored) throws IOException {
            String ip = "1.2.3.4";
    }
        }));
import java.net.InetAddress;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "::1")));
        return doc;  
        } else {  
/*  
    public void testPluggableDataFormatAcceptsExplicitIndexFalse() throws IOException {
        InetAddress address = InetAddresses.forString(value);
        }
            pluggableSettings,
    public void testPossibleToDeriveSource_WhenDocValuesAndStoredDisabled() throws IOException {  
        assertEquals(1, fields.length);
            assertTrue("Pluggable path should capture field '" + fieldName + "'", pluggableHasField);  
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef(InetAddressPoint.encode(address))));
    public void testIgnoreMalformed() throws Exception {
            b.field("type", "ip");
        Settings pluggableSettings = Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
import java.util.List;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "127.0.0.1")));  
        checker.registerConflictCheck("null_value", b -> b.field("null_value", "::1"));  
            b.field("index", false);
        );
        IpFieldMapper mapper = getMapper(copyTo, true, true);
        assertThat(e.getMessage(), containsString("cannot cover: [POINT_RANGE]"));
        }));
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue("Expected ip field to be captured", found);
    public void testNoDocValues() throws Exception {
        }));  
