        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig());
import org.apache.lucene.util.automaton.RegExp;
            true,  // hasDocValues
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        );
        // Test prefixQuery with non-searchable field
        );
        assertThat(fieldDataException.getMessage(), containsString("does not have doc_values enabled"));
        for (String version : versions) {
            null
            () -> docValuesOnlyFieldType.wildcardQuery("1.0.*", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, mockContext)
    }
        );
        // Test invalid pre-release format
            return sv1.compareTo(sv2);
            for (IndexableField field : doc.rootDoc().getFields("field")) {
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
        // Create MultiReader with array of readers
 * this file be licensed under the Apache-2.0 license or a
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig());
        assertEquals("1.0.0-alpha", sortedVersions.get(0));
        SearchLookup mockLookup = mock(SearchLookup.class);
            "1.0.*",
    }
            mapper.parse(source(b -> b.field("field", "1.1.0"))),
        Query rangeQuery4 = fieldType.rangeQuery("1.0.0", null, true, true, ShapeRelation.INTERSECTS, null, null, null);
            mapper.parse(source(b -> b.field("field", "1.0.1")))
            IllegalArgumentException.class,
    }
            mockContext
            "1.0.0",
        // Test version with pre-release
        assertThat(rangeException.getMessage(), containsString("Failed to create range query for field"));
    public void testInvalidVersionValues() throws IOException {
import org.apache.lucene.store.Directory;
                || (rangeQuery3 instanceof IndexOrDocValuesQuery
import org.apache.lucene.index.IndexWriter;
        assertEquals("Fuzzy queries require the field to be indexed", fuzzyException.getMessage());
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
            () -> fieldType.termQuery(null, mockContext)
    }
            return sv1.compareTo(sv2);
    }
            false,  // hasDocValues
        doc = mapper.parse(source(b -> b.field("field", "1.0.0+build.123.456.789.abc.def")));
            b.startObject("version2").field("type", "version").field("store", true).endObject();
        // Test rangeQuery with invalid version format - should throw QueryShardException
        }
            "1.0.0-beta",
            false,  // isSearchable
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
                hasStoredField = true;
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(dir));
        Query majorVersionPrefix = fieldType.prefixQuery("1.", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, null);
            "1.0.0"
        for (String malformed : malformedVersions) {
        assertThat(termsException.getMessage(), containsString("is neither indexed nor has doc_values enabled"));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        );
        assertEquals("1.0.0-beta.2", sortedVersions.get(3));
/**
            "1.0.0",
        );
                return doc.rootDoc().getField("field").stringValue();
        // Test valueFetcher with format parameter
        IllegalArgumentException invalidFieldException = expectThrows(
    }
        }
        );
            "invalid_field",
            false,
        );
            "01.0.0",
            b.startObject("version2").field("type", "version").field("store", true).endObject();
        List<ParsedDocument> docs = Arrays.asList(
        Query docValuesQuery = docValuesOnlyFieldType.termQuery("1.0.0", mockContext);
        writer.close();
        assertNotEquals(doc.rootDoc().getField("version1").stringValue(), doc.rootDoc().getField("version2").stringValue());
    }
        }));
import org.apache.lucene.search.BooleanQuery;
        Query rangeQuery2 = fieldType.rangeQuery("1.0.0-alpha", "1.0.0", true, true, ShapeRelation.INTERSECTS, null, null, null);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        for (ParsedDocument doc : docs) {
            0,
    }
        assertTrue(
            assertEquals("Stored value should match input for " + version, version, storedField.stringValue());
        List<String> versions = Arrays.asList(
            }
            "1.0",
    @Override
        // Test with doc values only field
        // Test termQuery - should throw exception
            50,
        // Test empty string
        // Create test documents with specific versions
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            null,  // null rewrite method
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        // Test wildcardQuery with case insensitivity
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        // Test fuzzyQuery with non-searchable field
        // Verify each version individually
            equalTo(2)  // Should match 1.0.0 and 1.0.1
    }
        // Index first document
        Directory dir = new ByteBuffersDirectory();
    }
import org.apache.lucene.store.ByteBuffersDirectory;
            mapper.parse(source(b -> b.field("field", "1.0.1"))),
    public void testWildcardQuery() throws Exception {
            IndexableField storedField = doc.rootDoc().getField("field");
                    MultiTermQuery.CONSTANT_SCORE_REWRITE,
    }
            false   // isStored
        assertEquals("Cannot search for null value", nullValueException.getMessage());
    }
        boolean hasStoredField = false;
        // Test version with many pre-release parts
        SemanticVersionFieldMapper.SemanticVersionFieldType docValuesOnlyFieldType =
        doc = mapper.parse(source(b -> {}));
    }
        assertEquals("Build metadata should not affect equality", 0, v1.compareTo(v2));
 *
        IndexSearcher searcher = setupSearcher(mapper);
        }));
        // Create simple test documents
            MultiTermQuery.CONSTANT_SCORE_REWRITE,
package org.opensearch.index.mapper;
        Query fuzzyQuery = fieldType.fuzzyQuery(
        }
import static org.mockito.Mockito.mock;
        }).sorted((v1, v2) -> {
        assertEquals("Wildcard queries require the field to be indexed", wildcardException.getMessage());
            true,   // isSearchable
        SemanticVersionFieldMapper.SemanticVersionFieldType invalidFieldType = new SemanticVersionFieldMapper.SemanticVersionFieldType(
            "1.0.0-beta.2",
        doc = mapper.parse(source(b -> b.field("field", "1.2.3-alpha+build.123")));
        IndexReader[] readers = new IndexReader[] { reader1, reader2 };
            "1.0.0+",
        writer.close();
            "1.0.0-alpha",
        // Test different prefix patterns
                    && ((IndexOrDocValuesQuery) rangeQuery3).getIndexQuery() instanceof TermRangeQuery)
        writer2.close();
        writer2.addDocument(doc2.rootDoc());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        for (IndexableField field : fields) {
        assertNotEquals(doc.rootDoc().getField("version1").stringValue(), doc.rootDoc().getField("version2").stringValue());
 * Field mapper for OpenSearch semantic version field type
        assertEquals("1.2.0", sortedVersions.get(8));
        QueryShardContext mockContext = mock(QueryShardContext.class);
import org.apache.lucene.index.IndexReader;
        );
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            mapper.parse(source(b -> b.field("field", "1.0.0"))),
        assertThat("Should match 1.0.0, 1.0.1, 1.0.0-alpha, 1.0.0-beta, 1.0.0+build.123", searcher.count(prefixQuery), equalTo(5));
        b.field("type", "version");
import org.opensearch.common.unit.Fuzziness;
            "1.0.0"
            return new SemanticVersion(sv.getMajor(), sv.getMinor(), sv.getPatch(), sv.getPreRelease(), null).toString();
            if (field.fieldType().docValuesType() == DocValuesType.SORTED_SET) {
                fieldType.regexpQuery(
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        field = doc.rootDoc().getField("field");
        IllegalArgumentException regexpException = expectThrows(
        );
            true,
    public void testDocValuesSorting() throws Exception {
                BooleanClause.Occur.MUST_NOT
            .add(
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
        Directory dir1 = new ByteBuffersDirectory();
    public void testFieldTypeErrorCases() {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
            } catch (IOException e) {
        ParsedDocument doc = mapper.parse(source(b -> {
        ParsedDocument doc2 = mapper.parse(source(b -> b.field("field", "2.5.0")));
        SemanticVersionFieldMapper.SemanticVersionFieldType searchOnlyFieldType = new SemanticVersionFieldMapper.SemanticVersionFieldType(
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.2.3")));
    }
            IllegalArgumentException.class,
        builder.value("1.0.0");
        for (String version : versions) {
    public void testMultipleVersionFields() throws Exception {
            "1.0.0-alpha.1",
import java.util.Arrays;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
            MapperParsingException e = expectThrows(
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    public void testPrefixQuery() throws Exception {
            "1.0.0-alpha.1",
        assertThat(
            searcher.count(fuzzyQuery),
        assertNotNull(doc.rootDoc().getField("version2"));
        );
            "1.0.0-alpha.beta.2",
    public void testNullValue() throws Exception {
    public void testMetadataFields() throws Exception {
        assertNotNull(wildcardQuery);
        for (IndexableField field : fields) {
        assertTrue("Field should be stored", hasStoredField);
 * The OpenSearch Contributors require contributions made to
        // Test leading zeros
        Directory dir = new ByteBuffersDirectory();
import org.opensearch.common.xcontent.XContentFactory;
                assertEquals(DocValuesType.SORTED_SET, field.fieldType().docValuesType());
        for (IndexableField field : fields) {
import static org.hamcrest.Matchers.containsString;
            mockContext
        SemanticVersionFieldMapper.SemanticVersionFieldType fieldType = new SemanticVersionFieldMapper.SemanticVersionFieldType(
            new SemanticVersionFieldMapper.SemanticVersionFieldType(
        // Create readers and searcher
            null
        e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "1.2.3-"))));
            rangeQuery3 instanceof TermRangeQuery
                || (rangeQuery4 instanceof IndexOrDocValuesQuery
     * Test to cover error cases in SemanticVersionFieldType
        assertNotNull(doc.rootDoc().getField("field"));
            }
        assertEquals("1.0.0", sortedVersions.get(7)); // build.123 is stripped
                () -> mapper.parse(source(b -> b.field("field", malformed)))
        writer.close();
        );
    }
        // Create readers
        List<ParsedDocument> docs = new ArrayList<>();
    }
    }
            new HashMap<>(),
        // Test actual document matching
        Collections.shuffle(versions, random());
        // Test null value
import org.opensearch.search.lookup.SearchLookup;
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
        for (IndexableField field : fields) {
            "1.0.0-",
        SemanticVersion v1 = SemanticVersion.parse(doc1.rootDoc().getField("field").stringValue());
        IndexSearcher searcher = setupSearcher(mapper);
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(0));
            50,
        assertThat(field.stringValue(), equalTo("1.2.3"));
        Directory dir2 = new ByteBuffersDirectory();
        // Test very large version numbers
        );
        assertThat("Should match 1.0.0-alpha and 1.0.0-beta", searcher.count(regexpQuery), equalTo(2));
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "..."))));
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        }).filter(Objects::nonNull).sorted((v1, v2) -> {
import org.apache.lucene.index.DirectoryReader;
        ParsedDocument doc1 = mapper.parse(source(b -> b.field("field", "2.0.0")));
        QueryShardException rangeException = expectThrows(
            false,  // hasDocValues
        doc = mapper.parse(source(b -> b.field("field", "1.2.3+build.123")));
        assertTrue("Field should have doc values", hasDocValues);
        assertThat(field.stringValue(), equalTo("1.2.3-alpha+build.123"));
        // Test fielddataBuilder with doc_values disabled
            IllegalArgumentException.class,
        Query rangeQuery = fieldType.rangeQuery("1.0.0", "2.0.0", true, true, ShapeRelation.INTERSECTS, null, null, null);
        ParsedDocument doc2 = mapper.parse(source(b -> b.field("field", "1.9.9")));
        // Test termQuery with null value (should throw exception)
        assertEquals("Wrong number of versions", 10, sortedVersions.size());
            "1.0.0-alpha",
        // Test negative version numbers
            () -> invalidFieldType.termsQuery(terms, mockContext)
            MultiTermQuery.CONSTANT_SCORE_REWRITE,
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "1.0.0@"))));
            "1.2.0",
            SemanticVersion sv1 = SemanticVersion.parse(v1);
        }
            "1.0.0.0",
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", version)));
        boolean hasDocValues = false;
        for (ParsedDocument doc : docs) {
            BooleanClause.Occur.MUST
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(0));
        assertTrue(e.getCause().getMessage().contains("Invalid semantic version format"));
import org.opensearch.index.query.QueryShardContext;
        IndexReader reader1 = DirectoryReader.open(dir1);
        }).collect(Collectors.toList());
        boolean hasTermField = false;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "999999999.999999999.999999999")));
import org.apache.lucene.search.BooleanClause;
            IllegalArgumentException.class,
            "1.0.0@invalid"
import org.apache.lucene.search.Query;
            rangeQuery1 instanceof TermRangeQuery
        );
            "1.0.0-alpha.beta",
    protected void registerParameters(ParameterChecker checker) {
import static org.hamcrest.Matchers.arrayWithSize;
        }
        // Test regexpQuery with non-searchable field
        );
            IllegalArgumentException.class,
        boolean hasDocValues = false;
import org.opensearch.core.xcontent.XContentBuilder;
            "1.0.0-alpha.1",
    public void testRangeQueries() throws Exception {
        List<String> malformedVersions = Arrays.asList(
 * SPDX-License-Identifier: Apache-2.0
    @Override
        );
            () -> fieldType.rangeQuery("invalid-version", "2.0.0", true, true, null, null, null, mockContext)
        mapper.mapping().toXContent(builder, ToXContent.EMPTY_PARAMS);
        );
            0,  // No prefix requirement
    public void testFuzzyQuery() throws Exception {
import org.apache.lucene.search.IndexOrDocValuesQuery;
    @Override
    }
                hasDocValues = true;
        assertTrue("Field should have keyword term field", hasTermField);
        assertTrue("Field should have doc values", hasDocValues);
    public void testMoreInvalidVersions() throws Exception {
                }
                break;
                hasDocValues = true;
            mapper.parse(source(b -> b.field("field", "1.0.0"))),
                "docvalues_only",
        }));
        // Test various malformed versions
        assertNotNull(doc.rootDoc().getField("version1"));
    }
    }
        )
            b.field("version2", "2.0.0");
        Query wildcardQuery = fieldType.wildcardQuery(
                    0,
import org.apache.lucene.search.IndexSearcher;
        dir.close();
        }
        assertEquals("1.0.0", sortedVersions.get(6));
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", ""))));
        );
            false  // isStored
        dir1.close();
    }
            "1.0.0-beta+build.123",
    }
        // Test invalid characters
        // Test only dots
            b.startObject("version1").field("type", "version").field("store", true).endObject();
import java.util.Objects;
        List<String> expected = Arrays.asList(
            new HashMap<>(),
            b.field("version1", "1.0.0");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertTrue(mappingString.contains("\"type\":\"version\""));
        assertThat("Should match 1.0.0 and 1.1.0", searcher.count(wildcardQuery), equalTo(2));
import java.io.IOException;
            RegExp.ALL,
        assertNotNull(doc.rootDoc().getField("field"));
        IndexableField[] fields = doc.rootDoc().getFields("field");
    public void testDocValues() throws Exception {
            IllegalArgumentException.class,
            SemanticVersion sv2 = SemanticVersion.parse(v2);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        testVersionSorting(mapper, versions, expected);
        // Test missing field
        assertThat(formatException.getMessage(), containsString("doesn't support formats"));
        writer1.addDocument(doc1.rootDoc());
                true,   // hasDocValues
        assertTrue(e.getCause().getMessage().contains("Invalid semantic version format"));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            writer.addDocument(doc.rootDoc());
        // Test termsQuery with different field configurations
        assertTrue("Field should have doc values", hasDocValues);
    public void testStoredValues() throws Exception {
        // Extract and sort versions
            "search_only",
            true,
        // Test regular version
            () -> docValuesOnlyFieldType.prefixQuery("1.0", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, mockContext)
        Query caseInsensitivePrefix = fieldType.prefixQuery("1.0", MultiTermQuery.CONSTANT_SCORE_REWRITE, true, null);
            "1.0.0-alpha.beta",
        assertThat("Should match same as case sensitive", searcher.count(caseInsensitivePrefix), equalTo(5));
        XContentBuilder mapping = mapping(b -> {
        // Test invalid version format
    public void testTermQuery() throws Exception {
        IndexSearcher searcher = new IndexSearcher(multiReader);
        assertEquals("1.0.0-beta.11", sortedVersions.get(4));
            () -> docValuesOnlyFieldType.fuzzyQuery("1.0.0", Fuzziness.ONE, 0, 50, true, MultiTermQuery.CONSTANT_SCORE_REWRITE, mockContext)
/*
    }
            rangeQuery4 instanceof TermRangeQuery
            "1.0.0-alpha",
                hasTermField = true;
        List<ParsedDocument> docs = Arrays.asList(
                    && ((IndexOrDocValuesQuery) rangeQuery4).getIndexQuery() instanceof TermRangeQuery)
        List<String> actual = input.stream().map(v -> {
    protected void metaMapping(XContentBuilder b) throws IOException {
            );
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
        // Create a field type with various configurations to test error paths
        // Test termQuery - should use index query only
                break;
        assertEquals("1.0.0-beta", sortedVersions.get(2));
            }
            SemanticVersion sv2 = SemanticVersion.parse(v2);
            QueryShardException.class,
            0,
        assertThat(invalidFieldException.getMessage(), containsString("is neither indexed nor has doc_values enabled"));
        for (ParsedDocument doc : docs) {
            try {
        }
        b.field("store", true);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        Query fuzzyQuery = fieldType.fuzzyQuery(
        );
                    RegExp.ALL,
            assertTrue(e.getCause().getMessage().contains("Invalid semantic version format"));
        assertTrue("Field should have sorted doc values", hasDocValues);
        );
    }
            }
            "1.0.0-alpha.beta.2",
        Query rangeQuery3 = fieldType.rangeQuery(null, "2.0.0", true, true, ShapeRelation.INTERSECTS, null, null, null);
        }).map(v -> {
        List<String> versions = Arrays.asList(
            "-1.0.0",
        assertNotNull(termsQuery);
            if (field instanceof KeywordField) {
        );
    }
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(dir));
        dir.close();
            "1.0.0-alpha.12",
        // Store documents with versions
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
            "1.0.0-alpha.1",
        String mappingString = builder.toString();
import org.apache.lucene.search.TermRangeQuery;
            Fuzziness.ONE,
        minimalMapping(b);
        // Clean up
     */
        field = doc.rootDoc().getField("field");
        // Test null bounds
        );
import java.util.List;
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertThat(actual, contains(expected.toArray()));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertThat("Should match all version 1.x.x", searcher.count(majorVersionPrefix), equalTo(6));
        }).collect(Collectors.toList());
        // Create a field type that is not searchable but has doc values
        );
import org.opensearch.index.query.QueryShardException;
        DocumentMapper mapper = createDocumentMapper(mapping);
import org.apache.lucene.search.MultiTermQuery;
            if (field.fieldType().docValuesType() == DocValuesType.SORTED_SET) {
    /**
            false   // isStored
        assertNotNull(fieldType.valueFetcher(mockContext, mockLookup, null));
    public void testMajorVersionComparison() throws Exception {
        assertEquals("Prefix queries require the field to be indexed", prefixException.getMessage());
            }
            }
import static org.hamcrest.Matchers.equalTo;
                ),
        );
        builder.startObject();
        ParsedDocument doc2 = mapper.parse(source(b -> b.field("field", "1.0.0+build.2")));
        assertNotNull(doc.rootDoc().getField("version2"));
        Query regexpQuery = fieldType.regexpQuery(
            "1.0.0-alpha",
            if (field.fieldType().docValuesType() == DocValuesType.SORTED_SET) {
            IllegalArgumentException.class,
        );
        assertNotNull(doc.rootDoc().getField("version1"));
        assertNotNull(docValuesQuery);
        }
            true,  // case insensitive
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            "1.0.0-beta",
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        });
            "1.0",
        for (IndexableField field : fields) {
    protected void minimalMapping(XContentBuilder b) throws IOException {
        );
            docs.add(doc);
        MultiReader multiReader = new MultiReader(readers, true);
            b.field("version1", "1.0.0");
    public void testBuildMetadataEquality() throws Exception {
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "01.2.3"))));
        // Test version with both pre-release and build metadata
            );
            () -> fieldType.valueFetcher(mockContext, mockLookup, "some_format")
    private Settings pluggableSettings() {
        // Test fuzzyQuery with null rewrite method (should use default)
        // Test valueFetcher without format parameter
        // Create a field type that is searchable but has no doc values
            IllegalArgumentException.class,
            "Fuzzy match should find similar versions",
            "1.0.0",
import org.apache.lucene.util.automaton.Operations;
            if (field.fieldType().docValuesType() == DocValuesType.SORTED_SET) {
public class SemanticVersionFieldMapperTests extends MapperTestCase {
        );
        List<String> versions = Arrays.asList(
import org.opensearch.common.geo.ShapeRelation;
                throw new RuntimeException(e);
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
        assertNotNull(docValuesTermsQuery);
    private IndexSearcher setupSearcher(DocumentMapper mapper) throws IOException {
            MultiTermQuery.CONSTANT_SCORE_REWRITE,
        SemanticVersion v1 = SemanticVersion.parse(doc1.rootDoc().getField("field").stringValue());
        IndexableField field = doc.rootDoc().getField("field");
        IndexWriter writer2 = new IndexWriter(dir2, new IndexWriterConfig());
        assertTrue(
            if (field.fieldType().stored()) {
        b.field("index", true);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    }
    public void testToXContent() throws IOException {
import java.util.Collections;
        IllegalArgumentException prefixException = expectThrows(
            Fuzziness.ONE,
        Query docValuesTermsQuery = docValuesOnlyFieldType.termsQuery(terms, mockContext);
        IllegalArgumentException formatException = expectThrows(
            "1",
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
                    && ((IndexOrDocValuesQuery) rangeQuery2).getIndexQuery() instanceof TermRangeQuery)
        assertThat(field.stringValue(), equalTo("1.2.3+build.123"));
            "1.0.0-alpha.12",
            true,  // isSearchable
        List<String> terms = Arrays.asList("1.0.0", "2.0.0", "3.0.0");
        }
            "1.0.0-beta.2",
            // Normalize version by removing build metadata
        builder.endObject();
        assertThat(field.stringValue(), equalTo("1.2.3-alpha"));
        SemanticVersion v2 = SemanticVersion.parse(doc2.rootDoc().getField("field").stringValue());
        Query indexQuery = searchOnlyFieldType.termQuery("1.0.0", mockContext);
            "1.0.0-beta",
            MultiTermQuery.CONSTANT_SCORE_REWRITE,  // Specify rewrite method
        boolean hasDocValues = false;
        // Create a field type that is neither searchable nor has doc values
        DocumentMapper mapper = createDocumentMapper(mapping);
                if (field.fieldType().stored()) {
            "1.0.0-beta.2",
        IllegalArgumentException nullValueException = expectThrows(
        }
            "999999999.999999999.999999999"
        SemanticVersion v2 = SemanticVersion.parse(doc2.rootDoc().getField("field").stringValue());
        assertTrue(
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig());
        Query rangeQuery1 = fieldType.rangeQuery("1.0.0", "2.0.0", true, true, ShapeRelation.INTERSECTS, null, null, null);
        // Index second document
                break;
    public void testMultipleFieldsInDocument() throws Exception {
        );
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "1.2"))));
    public void testNullHandling() throws Exception {
        e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "-1.2.3"))));
    public void testExtremeVersionNumbers() throws Exception {
                ParsedDocument doc = mapper.parse(source(b -> b.field("field", v)));
        IllegalArgumentException wildcardException = expectThrows(
        assertTrue(e.getCause().getMessage().contains("Invalid semantic version format"));
            "1.0.0",
        // Test wildcardQuery with non-searchable field
    public void testVersionSorting() throws Exception {
                    ".*-.*",
                    return field.stringValue();
            () -> docValuesOnlyFieldType.regexpQuery("1\\.0\\..*", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_REWRITE, mockContext)
        IndexReader reader2 = DirectoryReader.open(dir2);
                || (rangeQuery1 instanceof IndexOrDocValuesQuery
        assertEquals("Regexp queries require the field to be indexed", regexpException.getMessage());
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
        );
            new HashMap<>(),
            () -> invalidFieldType.termQuery("1.0.0", mockContext)
        IllegalArgumentException fuzzyException = expectThrows(
        // Test version with many build metadata parts
                || (rangeQuery2 instanceof IndexOrDocValuesQuery
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
        // Create a list of versions in random order
            .build();
    @Override
            mapper.parse(source(b -> b.field("field", "2.1.0")))
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(0));
    }
        doc = mapper.parse(source(b -> b.field("field", "1.0.0-alpha.beta.gamma.delta.epsilon")));
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        // Should match doc1 but not doc2
        // Test case sensitivity
        IndexSearcher searcher = setupSearcher(mapper);
            "v1.0.0",
        Query wildcardQuery = fieldType.wildcardQuery("1.*.0", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, null);
import org.apache.lucene.document.KeywordField;
        ParsedDocument doc1 = mapper.parse(source(b -> b.field("field", "1.0.0+build.1")));
                false,  // isSearchable
import org.apache.lucene.index.IndexableField;
        // Test version with build metadata
    private void testVersionSorting(DocumentMapper mapper, List<String> input, List<String> expected) throws Exception {
        );
        assertTrue("Major version comparison failed", v1.compareTo(v2) > 0);
    }
            IllegalArgumentException.class,
        Query termsQuery = searchOnlyFieldType.termsQuery(terms, mockContext);
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                hasDocValues = true;
        // Test with invalid field
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
        IllegalArgumentException termsException = expectThrows(
                    && ((IndexOrDocValuesQuery) rangeQuery1).getIndexQuery() instanceof TermRangeQuery)
        Query complexQuery = new BooleanQuery.Builder().add(
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", version)));
        List<ParsedDocument> docs = Arrays.asList(
        assertThat(fields.length, greaterThanOrEqualTo(2));
            fieldType.prefixQuery("1.", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, null),
        // Test with searchable field
            mapper.parse(source(b -> b.field("field", "1.0.0"))),
        assertEquals("1.10.0", sortedVersions.get(9));
        }
import java.util.stream.Collectors;
        assertThat("Should match 1.0.0, 1.0.1, 1.1.0, 1.0.0+build.123", searcher.count(complexQuery), equalTo(4));
        IndexWriter writer1 = new IndexWriter(dir1, new IndexWriterConfig());
            "1.0.0+build.123",
                MapperParsingException.class,
        // Test termQuery - should use doc values query only
                new HashMap<>(),
        );
        // Test storing different version formats
                false   // isStored
        IndexableField[] fields = doc.rootDoc().getFields("field");
            b.field("version2", "2.0.0");
        return new IndexSearcher(DirectoryReader.open(dir));
    public void testComplexPreReleaseComparison() throws Exception {
        Query prefixQuery = fieldType.prefixQuery(
            "1.0.0-beta.11",
        assertEquals("1.0.0-rc.1", sortedVersions.get(5));
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
        DocumentMapper mapper = createDocumentMapper(mapping);
        assertNotNull(indexQuery);
            writer.addDocument(doc.rootDoc());
}
        ParsedDocument doc = mapper.parse(source(b -> {
                hasDocValues = true;
            mapper.parse(source(b -> b.field("field", "1.0.0-beta"))),
                    null
        );
 */
        // Test fuzzy query
            }
            "1.10.0",
import org.opensearch.core.xcontent.ToXContent;
            mapper.parse(source(b -> b.field("field", "2.0.0"))),
        Directory dir = new ByteBuffersDirectory();
    public void testMalformedVersions() throws Exception {
        assertNotNull(fuzzyQuery);
            mapper.parse(source(b -> b.field("field", "1.1.0"))),
    public void testComplexQuery() throws IOException {
 * compatible open source license.
            }
            "1\\.0\\.0-.*",
        dir2.close();
        TopDocs hits = searcher.search(rangeQuery, 10);
            SemanticVersion sv1 = SemanticVersion.parse(v1);
            return null;
        List<String> sortedVersions = docs.stream().map(doc -> {
        IllegalArgumentException fieldDataException = expectThrows(
    }
    }
    }
        field = doc.rootDoc().getField("field");
            mapper.parse(source(b -> b.field("field", "1.0.0-alpha"))),
import static org.hamcrest.Matchers.contains;
            assertNotNull("Stored field should exist for " + version, storedField);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        IndexableField[] fields = doc.rootDoc().getFields("field");
    public void testRegexpQuery() throws Exception {
            null
        XContentBuilder builder = XContentFactory.jsonBuilder();
        multiReader.close();
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            rangeQuery2 instanceof TermRangeQuery
        // Create a mock QueryShardContext
            "1.0.0-rc.1",
import org.opensearch.common.settings.Settings;
import org.apache.lucene.index.DocValuesType;
        // No additional parameters to register for version field type
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            writer.addDocument(doc.rootDoc());
        assertEquals("1.0.0-alpha.1", sortedVersions.get(1));
            b.startObject("version1").field("type", "version").field("store", true).endObject();
import org.apache.lucene.search.TopDocs;
        assertTrue(
    }
import java.util.HashMap;
    }
            )
            "test_field",
            mapper.parse(source(b -> b.field("field", "1.0.0+build.123")))
            "1.0.0+build.123"
    public void testDefaults() throws Exception {
    public void testValidVersionValues() throws Exception {
        writer1.close();
 */
import org.apache.lucene.index.IndexWriterConfig;
            () -> searchOnlyFieldType.fielddataBuilder("test_index", null)
        ParsedDocument doc1 = mapper.parse(source(b -> b.field("field", "1.5.0")));
        assertNotNull(doc.rootDoc().getField("field"));
import org.apache.lucene.index.MultiReader;
            SemanticVersion sv = SemanticVersion.parse(v);
    }
        boolean hasDocValues = false;
        doc = mapper.parse(source(b -> b.field("field", "1.2.3-alpha")));
import java.util.ArrayList;
        // Test various range scenarios
