import org.apache.lucene.index.IndexReader;
        ParsedDocument doc1 = mapper.parse(source(b -> b.field("field", "2.0.0")));
    public void testVersionSorting() throws Exception {  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        // Test missing field
    public void testWildcardQuery() throws Exception {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
    public void testStoredValues() throws Exception {  
import org.opensearch.common.geo.ShapeRelation;  
            false,  // isSearchable  
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", version)));
                hasDocValues = true;
        assertEquals("1.0.0-beta.11", sortedVersions.get(4));
            SemanticVersion sv2 = SemanticVersion.parse(v2);
        List<ParsedDocument> docs = Arrays.asList(
import org.apache.lucene.search.TermRangeQuery;  
            for (IndexableField field : doc.rootDoc().getFields("field")) {  
        assertTrue("Major version comparison failed", v1.compareTo(v2) > 0);
            mapper.parse(source(b -> b.field("field", "1.0.1")))  
            0,  
            "Fuzzy match should find similar versions",  
                hasDocValues = true;
        assertNotEquals(doc.rootDoc().getField("version1").stringValue(), doc.rootDoc().getField("version2").stringValue());
        Query majorVersionPrefix = fieldType.prefixQuery("1.", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, null);  
        IndexWriter writer1 = new IndexWriter(dir1, new IndexWriterConfig());
            "1.0.0-alpha.beta.2",  
        assertEquals("1.0.0", sortedVersions.get(6));  
            "1",
            null  
            new HashMap<>(),
    }
/**
            if (field.fieldType().docValuesType() == DocValuesType.SORTED_SET) {  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
import org.apache.lucene.index.IndexWriterConfig;  
        );
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
import org.apache.lucene.search.Query;
        // Test invalid pre-release format
        assertNotNull(docValuesTermsQuery);
        assertTrue("Field should have doc values", hasDocValues);
                return doc.rootDoc().getField("field").stringValue();
        List<String> terms = Arrays.asList("1.0.0", "2.0.0", "3.0.0");
        IndexableField[] fields = doc.rootDoc().getFields("field");
            "1.0.0-alpha.1",
            if (field.fieldType().docValuesType() == DocValuesType.SORTED_SET) {
        // Test various range scenarios
     */
        // Test version with many pre-release parts
        }
        }
            writer.addDocument(doc.rootDoc());  
        Query wildcardQuery = fieldType.wildcardQuery("1.*.0", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, null);
            Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
}  
    public void testRangeQueries() throws Exception {  
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
            IllegalArgumentException.class,  
        assertThat("Should match all version 1.x.x", searcher.count(majorVersionPrefix), equalTo(6));
import org.opensearch.common.unit.Fuzziness;
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        }  
        b.field("store", true);
        assertNotNull(fieldType.valueFetcher(mockContext, mockLookup, null));
    public void testComplexQuery() throws IOException {
        );
    private Settings pluggableSettings() {  
        // Test leading zeros
            }
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
            "1.0.0-alpha.beta",  
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
        assertEquals("1.0.0-beta.2", sortedVersions.get(3));  
        IllegalArgumentException termsException = expectThrows(
    public void testMultipleFieldsInDocument() throws Exception {  
            RegExp.ALL,
    }
        assertTrue(  
            rangeQuery3 instanceof TermRangeQuery
                || (rangeQuery3 instanceof IndexOrDocValuesQuery
    }
        for (IndexableField field : fields) {
            "1.0.0-alpha",
            IllegalArgumentException.class,
        // Create a field type that is neither searchable nor has doc values
            SemanticVersion sv2 = SemanticVersion.parse(v2);
        IndexableField[] fields = doc.rootDoc().getFields("field");
        // Test rangeQuery with invalid version format - should throw QueryShardException  
        IllegalArgumentException invalidFieldException = expectThrows(  
import static org.hamcrest.Matchers.arrayWithSize;
        ParsedDocument doc2 = mapper.parse(source(b -> b.field("field", "1.0.0+build.2")));
            true,  // isSearchable
    }
                MapperParsingException.class,  
        assertTrue(e.getCause().getMessage().contains("Invalid semantic version format"));
            "1.0.0-alpha.1",
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
            )  
    public void testDocValuesSorting() throws Exception {  
    }  
            "1.0.0-alpha.1",  
            }
     * Test to cover error cases in SemanticVersionFieldType
        }).map(v -> {
    }  
        assertThat(field.stringValue(), equalTo("1.2.3"));  
        );
            IllegalArgumentException.class,
 *
        assertThat("Should match 1.0.0 and 1.1.0", searcher.count(wildcardQuery), equalTo(2));
    }  
            mapper.parse(source(b -> b.field("field", "1.0.0+build.123")))
        );
        );
                    && ((IndexOrDocValuesQuery) rangeQuery1).getIndexQuery() instanceof TermRangeQuery)  
        assertNotNull(docValuesQuery);
            if (field instanceof KeywordField) {
    @Override
        XContentBuilder mapping = mapping(b -> {
            true,  
        assertTrue("Field should have keyword term field", hasTermField);  
            try {
            "1.0.0",  
        mapper.mapping().toXContent(builder, ToXContent.EMPTY_PARAMS);
    protected void registerParameters(ParameterChecker checker) {  
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
import java.io.IOException;
    public void testToXContent() throws IOException {
        QueryShardContext mockContext = mock(QueryShardContext.class);
            "1.0.0+build.123",
            }
import org.apache.lucene.search.IndexSearcher;  
                break;  
        IndexableField[] fields = doc.rootDoc().getFields("field");  
    @Override
 * The OpenSearch Contributors require contributions made to  
        }).filter(Objects::nonNull).sorted((v1, v2) -> {  
            "1.0.0@invalid"
        }  
    public void testNullValue() throws Exception {  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            IllegalArgumentException.class,
        SemanticVersionFieldMapper.SemanticVersionFieldType fieldType = new SemanticVersionFieldMapper.SemanticVersionFieldType(
    }
    }
import org.apache.lucene.util.automaton.Operations;
        );
            mapper.parse(source(b -> b.field("field", "1.1.0"))),
            rangeQuery4 instanceof TermRangeQuery
        Directory dir = new ByteBuffersDirectory();
    public void testExtremeVersionNumbers() throws Exception {
        List<ParsedDocument> docs = Arrays.asList(
        writer.close();
        assertEquals("1.0.0-alpha.1", sortedVersions.get(1));
                fieldType.regexpQuery(  
    public void testFieldTypeErrorCases() {  
        assertEquals("1.10.0", sortedVersions.get(9));  
            "1.0.0-alpha.12",
        Directory dir1 = new ByteBuffersDirectory();  
            () -> fieldType.rangeQuery("invalid-version", "2.0.0", true, true, null, null, null, mockContext)  
        assertEquals("Prefix queries require the field to be indexed", prefixException.getMessage());
        // Test version with build metadata
            }
        IndexableField field = doc.rootDoc().getField("field");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        SemanticVersion v2 = SemanticVersion.parse(doc2.rootDoc().getField("field").stringValue());  
            "1.10.0",  
            }
            QueryShardException.class,
    public void testMultipleVersionFields() throws Exception {  
        assertTrue(
            rangeQuery1 instanceof TermRangeQuery
            mapper.parse(source(b -> b.field("field", "1.0.1"))),  
        // Create test documents with specific versions  
        assertThat(field.stringValue(), equalTo("1.2.3+build.123"));
        List<String> expected = Arrays.asList(
        // Create MultiReader with array of readers
            equalTo(2)  // Should match 1.0.0 and 1.0.1
            writer.addDocument(doc.rootDoc());
            Fuzziness.ONE,
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                false   // isStored  
            b.startObject("version1").field("type", "version").field("store", true).endObject();
            true,   // isSearchable
        Query indexQuery = searchOnlyFieldType.termQuery("1.0.0", mockContext);
            assertTrue(e.getCause().getMessage().contains("Invalid semantic version format"));  
        );
    protected void minimalMapping(XContentBuilder b) throws IOException {
                || (rangeQuery1 instanceof IndexOrDocValuesQuery
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        assertTrue(  
        assertTrue(mappingString.contains("\"type\":\"version\""));  
import org.opensearch.core.xcontent.ToXContent;
            () -> docValuesOnlyFieldType.fuzzyQuery("1.0.0", Fuzziness.ONE, 0, 50, true, MultiTermQuery.CONSTANT_SCORE_REWRITE, mockContext)
        );  
        // Test only dots
            "v1.0.0",
        // Store documents with versions  
        }
            null
import org.apache.lucene.search.IndexOrDocValuesQuery;
        );
        // Test fuzzyQuery with non-searchable field
import org.opensearch.core.xcontent.XContentBuilder;
        dir1.close();
            "1.0.*",
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    @Override
        dir2.close();  
    }
import org.opensearch.common.settings.Settings;
            "1.0.0-beta",
        );
    }
        // Create a field type with various configurations to test error paths
        assertNotNull(doc.rootDoc().getField("version2"));
        // Index second document
        // Test termQuery - should throw exception
        IndexReader reader1 = DirectoryReader.open(dir1);
        assertThat(invalidFieldException.getMessage(), containsString("is neither indexed nor has doc_values enabled"));
        ParsedDocument doc1 = mapper.parse(source(b -> b.field("field", "1.5.0")));
        assertEquals("1.0.0-beta", sortedVersions.get(2));
            IllegalArgumentException.class,
import org.opensearch.index.query.QueryShardContext;  
        IllegalArgumentException regexpException = expectThrows(
        assertNotEquals(doc.rootDoc().getField("version1").stringValue(), doc.rootDoc().getField("version2").stringValue());
import org.apache.lucene.store.ByteBuffersDirectory;
        // Test with searchable field
        assertEquals("Wrong number of versions", 10, sortedVersions.size());
        doc = mapper.parse(source(b -> {}));
import org.apache.lucene.search.BooleanQuery;
            "1.0.0.0",
            .add(
        IllegalArgumentException prefixException = expectThrows(
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertThat(fields.length, greaterThanOrEqualTo(2));
        // Index first document  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                hasDocValues = true;
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(dir));
    public void testDocValues() throws Exception {  
    }  
        // Test actual document matching
            if (field.fieldType().docValuesType() == DocValuesType.SORTED_SET) {  
import org.apache.lucene.search.BooleanClause;  
            50,
        List<String> versions = Arrays.asList(
        // Test valueFetcher with format parameter
    public void testInvalidVersionValues() throws IOException {
    }
    }
                    return field.stringValue();
        // Test wildcardQuery with case insensitivity
            false,  // hasDocValues
            "1.0.0-beta.11",  
            MultiTermQuery.CONSTANT_SCORE_REWRITE,  // Specify rewrite method
        // Test null value  
            "999999999.999999999.999999999"
            MultiTermQuery.CONSTANT_SCORE_REWRITE,
        IndexSearcher searcher = setupSearcher(mapper);  
        }  
    public void testValidVersionValues() throws Exception {  
            "1.0.0-beta",
            true,
        for (IndexableField field : fields) {  
import static org.hamcrest.Matchers.containsString;  
            docs.add(doc);
            "1.0.0-alpha.beta.2",  
import org.opensearch.search.lookup.SearchLookup;
    protected void metaMapping(XContentBuilder b) throws IOException {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig());  
        IndexableField[] fields = doc.rootDoc().getFields("field");
        // Create simple test documents  
            () -> invalidFieldType.termQuery("1.0.0", mockContext)
        // Test version with pre-release
            b.startObject("version1").field("type", "version").field("store", true).endObject();
            "1.0.0"
        assertEquals("1.0.0-alpha", sortedVersions.get(0));  
        doc = mapper.parse(source(b -> b.field("field", "1.0.0+build.123.456.789.abc.def")));
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(0));
            0,  // No prefix requirement
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            () -> fieldType.termQuery(null, mockContext)
        assertTrue("Field should have sorted doc values", hasDocValues);  
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        IndexWriter writer2 = new IndexWriter(dir2, new IndexWriterConfig());  
    private void testVersionSorting(DocumentMapper mapper, List<String> input, List<String> expected) throws Exception {  
    }
        multiReader.close();
            () -> fieldType.valueFetcher(mockContext, mockLookup, "some_format")  
                    && ((IndexOrDocValuesQuery) rangeQuery3).getIndexQuery() instanceof TermRangeQuery)  
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.document.KeywordField;
            false,
            "1.0",  
        );
        assertThat("Should match 1.0.0-alpha and 1.0.0-beta", searcher.count(regexpQuery), equalTo(2));
            "search_only",  
            "1.0.0-",
        assertThat(field.stringValue(), equalTo("1.2.3-alpha+build.123"));  
            () -> searchOnlyFieldType.fielddataBuilder("test_index", null)
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                }  
            mapper.parse(source(b -> b.field("field", "1.0.0-beta"))),
        // Test various malformed versions  
        DocumentMapper mapper = createDocumentMapper(mapping);
    public void testComplexPreReleaseComparison() throws Exception {
        writer2.close();
        // Test fuzzyQuery with null rewrite method (should use default)
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
            SemanticVersion sv1 = SemanticVersion.parse(v1);
        Query docValuesQuery = docValuesOnlyFieldType.termQuery("1.0.0", mockContext);
            false,  // hasDocValues  
        Query rangeQuery4 = fieldType.rangeQuery("1.0.0", null, true, true, ShapeRelation.INTERSECTS, null, null, null);  
        e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "1.2.3-"))));
        Query rangeQuery1 = fieldType.rangeQuery("1.0.0", "2.0.0", true, true, ShapeRelation.INTERSECTS, null, null, null);
        assertNotNull(doc.rootDoc().getField("version1"));
        assertTrue(e.getCause().getMessage().contains("Invalid semantic version format"));  
            return new SemanticVersion(sv.getMajor(), sv.getMinor(), sv.getPatch(), sv.getPreRelease(), null).toString();
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.2.3")));
            () -> docValuesOnlyFieldType.regexpQuery("1\\.0\\..*", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_REWRITE, mockContext)
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(0));  
        SemanticVersionFieldMapper.SemanticVersionFieldType searchOnlyFieldType = new SemanticVersionFieldMapper.SemanticVersionFieldType(
        assertEquals("1.2.0", sortedVersions.get(8));
        SemanticVersion v1 = SemanticVersion.parse(doc1.rootDoc().getField("field").stringValue());  
            "1.0.0",
        String mappingString = builder.toString();
                break;
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();  
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", ""))));  
            "1.0.0-alpha",  
        ParsedDocument doc1 = mapper.parse(source(b -> b.field("field", "1.0.0+build.1")));  
 * this file be licensed under the Apache-2.0 license or a
        builder.endObject();  
        }
                    && ((IndexOrDocValuesQuery) rangeQuery2).getIndexQuery() instanceof TermRangeQuery)
        assertThat(formatException.getMessage(), containsString("doesn't support formats"));
            mockContext  
            new HashMap<>(),
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "01.2.3"))));  
        assertEquals("Wildcard queries require the field to be indexed", wildcardException.getMessage());
        field = doc.rootDoc().getField("field");
                    null  
        // Extract and sort versions
        field = doc.rootDoc().getField("field");  
                BooleanClause.Occur.MUST_NOT
            "1.0.0-beta.2",  
        assertEquals("Cannot search for null value", nullValueException.getMessage());  
    }  
        // Test fielddataBuilder with doc_values disabled
        assertNotNull(doc.rootDoc().getField("version1"));  
        }
        Query rangeQuery = fieldType.rangeQuery("1.0.0", "2.0.0", true, true, ShapeRelation.INTERSECTS, null, null, null);  
    private IndexSearcher setupSearcher(DocumentMapper mapper) throws IOException {  
        List<ParsedDocument> docs = new ArrayList<>();
        }));
        for (String version : versions) {
        assertThat(actual, contains(expected.toArray()));
                assertEquals(DocValuesType.SORTED_SET, field.fieldType().docValuesType());  
            new HashMap<>(),
            mapper.parse(source(b -> b.field("field", "2.0.0"))),
import org.apache.lucene.index.DocValuesType;  
    public void testMajorVersionComparison() throws Exception {
            b.field("version1", "1.0.0");
        assertTrue(
            null,  // null rewrite method
        // Test storing different version formats  
            b.field("version1", "1.0.0");
            new SemanticVersionFieldMapper.SemanticVersionFieldType(
    }  
                    0,  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "1.2"))));  
    }
            BooleanClause.Occur.MUST  
import org.opensearch.index.query.QueryShardException;
import static org.hamcrest.Matchers.contains;
        assertEquals("1.0.0", sortedVersions.get(7)); // build.123 is stripped
    }
    }
import org.apache.lucene.index.IndexableField;
            "1.2.0",
            0,
    public void testPrefixQuery() throws Exception {  
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(dir));
        assertNotNull(indexQuery);  
                || (rangeQuery2 instanceof IndexOrDocValuesQuery  
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig());
            mockContext
            true,  // case insensitive  
            "1.0.0-alpha",
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", version)));  
import org.apache.lucene.index.IndexWriter;
            b.field("version2", "2.0.0");  
            }
        doc = mapper.parse(source(b -> b.field("field", "1.2.3-alpha+build.123")));
                if (field.fieldType().stored()) {
        );
        );
            MapperParsingException e = expectThrows(
 */  
            mapper.parse(source(b -> b.field("field", "2.1.0")))
        // Test with invalid field  
    }  
        assertEquals("Regexp queries require the field to be indexed", regexpException.getMessage());  
    }  
        Query rangeQuery2 = fieldType.rangeQuery("1.0.0-alpha", "1.0.0", true, true, ShapeRelation.INTERSECTS, null, null, null);  
                false,  // isSearchable
            "1.0.0-beta",
        for (ParsedDocument doc : docs) {
        assertNotNull(doc.rootDoc().getField("field"));
        for (String malformed : malformedVersions) {
        writer.close();  
    public void testMetadataFields() throws Exception {
        IndexReader[] readers = new IndexReader[] { reader1, reader2 };  
import static org.mockito.Mockito.mock;  
                true,   // hasDocValues
    public void testMalformedVersions() throws Exception {  
            // Normalize version by removing build metadata
        // Clean up  
        IndexWriter writer = new IndexWriter(dir, new IndexWriterConfig());
        Collections.shuffle(versions, random());
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
 * compatible open source license.
        SemanticVersionFieldMapper.SemanticVersionFieldType docValuesOnlyFieldType =  
            }  
        Query caseInsensitivePrefix = fieldType.prefixQuery("1.0", MultiTermQuery.CONSTANT_SCORE_REWRITE, true, null);
        );
    public void testRegexpQuery() throws Exception {
            false   // isStored
            );
        IllegalArgumentException formatException = expectThrows(
        ParsedDocument doc2 = mapper.parse(source(b -> b.field("field", "1.9.9")));  
        assertTrue("Field should be stored", hasStoredField);  
            "1.0.0",
        // Test version with both pre-release and build metadata  
                ParsedDocument doc = mapper.parse(source(b -> b.field("field", v)));  
public class SemanticVersionFieldMapperTests extends MapperTestCase {
            }
        Directory dir2 = new ByteBuffersDirectory();
        );
            "1.0.0-alpha.beta",
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            mapper.parse(source(b -> b.field("field", "1.1.0"))),  
        Query rangeQuery3 = fieldType.rangeQuery(null, "2.0.0", true, true, ShapeRelation.INTERSECTS, null, null, null);
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "..."))));  
            "1.0.0-alpha.12",
        doc = mapper.parse(source(b -> b.field("field", "1.2.3-alpha")));  
            true,  // hasDocValues  
        b.field("type", "version");  
import org.opensearch.common.xcontent.XContentFactory;  
            "1.0",  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
        TopDocs hits = searcher.search(rangeQuery, 10);
/*  
    }
        // Should match doc1 but not doc2
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
        assertEquals("1.0.0-rc.1", sortedVersions.get(5));
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        // Test empty string
        // Verify each version individually
            rangeQuery2 instanceof TermRangeQuery
        }));
        }
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "999999999.999999999.999999999")));
            () -> docValuesOnlyFieldType.prefixQuery("1.0", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, mockContext)  
            Fuzziness.ONE,  
            if (field.fieldType().docValuesType() == DocValuesType.SORTED_SET) {
        ParsedDocument doc = mapper.parse(source(b -> {  
    public void testFuzzyQuery() throws Exception {
        boolean hasDocValues = false;
        SemanticVersion v2 = SemanticVersion.parse(doc2.rootDoc().getField("field").stringValue());
        );  
        SemanticVersionFieldMapper.SemanticVersionFieldType invalidFieldType = new SemanticVersionFieldMapper.SemanticVersionFieldType(  
            "1.0.0-alpha.1",  
            searcher.count(fuzzyQuery),
 */
            } catch (IOException e) {
        List<String> actual = input.stream().map(v -> {
    /**  
            IllegalArgumentException.class,  
        writer1.close();  
    }
            return sv1.compareTo(sv2);
        }).collect(Collectors.toList());
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
        boolean hasDocValues = false;  
            SemanticVersion sv1 = SemanticVersion.parse(v1);  
        // Test invalid characters
        SearchLookup mockLookup = mock(SearchLookup.class);  
        assertNotNull(doc.rootDoc().getField("field"));  
        // Create a field type that is not searchable but has doc values
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        });
        );  
            mapper.parse(source(b -> b.field("field", "1.0.0"))),
            return sv1.compareTo(sv2);  
                    ".*-.*",
        // Test very large version numbers
            b.startObject("version2").field("type", "version").field("store", true).endObject();  
        IllegalArgumentException wildcardException = expectThrows(  
            "invalid_field",
        );  
            "test_field",  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        assertThat("Should match 1.0.0, 1.0.1, 1.0.0-alpha, 1.0.0-beta, 1.0.0+build.123", searcher.count(prefixQuery), equalTo(5));  
    }
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
            b.field("version2", "2.0.0");
        field = doc.rootDoc().getField("field");
        assertNotNull(doc.rootDoc().getField("version2"));  
        Directory dir = new ByteBuffersDirectory();
        dir.close();
        // Test regexpQuery with non-searchable field
            "-1.0.0",  
        assertTrue("Field should have doc values", hasDocValues);  
        Query fuzzyQuery = fieldType.fuzzyQuery(
        IndexSearcher searcher = setupSearcher(mapper);
            IllegalArgumentException.class,  
        // Create a field type that is searchable but has no doc values
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
import org.apache.lucene.util.automaton.RegExp;
            mapper.parse(source(b -> b.field("field", "1.0.0-alpha"))),  
        DocumentMapper mapper = createDocumentMapper(mapping);  
            () -> docValuesOnlyFieldType.wildcardQuery("1.0.*", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, mockContext)
        }).sorted((v1, v2) -> {
        // Create readers and searcher
    }  
        assertNotNull(termsQuery);  
        IllegalArgumentException fieldDataException = expectThrows(
            "1\\.0\\.0-.*",
        // Test case sensitivity  
                new HashMap<>(),  
        }).collect(Collectors.toList());  
    public void testMoreInvalidVersions() throws Exception {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
            "1.0.0+",
            IndexableField storedField = doc.rootDoc().getField("field");  
            "1.0.0-beta.2",
        boolean hasDocValues = false;
        }
        // Test regular version  
            "1.0.0+build.123"
        Directory dir = new ByteBuffersDirectory();  
        assertTrue("Field should have doc values", hasDocValues);
        Query regexpQuery = fieldType.regexpQuery(  
    }  
        // Test different prefix patterns
    @Override  
                throw new RuntimeException(e);  
            null  
        b.field("index", true);
 * Field mapper for OpenSearch semantic version field type  
        for (IndexableField field : fields) {  
        // Test termQuery - should use doc values query only  
        for (String version : versions) {
        // Test prefixQuery with non-searchable field  
        Query prefixQuery = fieldType.prefixQuery(
    public void testBuildMetadataEquality() throws Exception {  
                ),
        // Test termsQuery with different field configurations
        IndexReader reader2 = DirectoryReader.open(dir2);  
        for (IndexableField field : fields) {  
            writer.addDocument(doc.rootDoc());
        assertNotNull(wildcardQuery);  
            50,  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1.0.0")));
        // Create readers
        assertNotNull(fuzzyQuery);
import java.util.Collections;
            () -> invalidFieldType.termsQuery(terms, mockContext)  
    public void testDefaults() throws Exception {
        e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "-1.2.3"))));
    }
import static org.hamcrest.Matchers.equalTo;
import java.util.Objects;
        ParsedDocument doc = mapper.parse(source(b -> {
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
            assertEquals("Stored value should match input for " + version, version, storedField.stringValue());
            "1.0.0",
            "1.0.0-rc.1",
        // Test fuzzy query  
        IndexSearcher searcher = new IndexSearcher(multiReader);  
import java.util.List;  
    }
        XContentBuilder mapping = fieldMapping(this::minimalMapping);  
        writer2.addDocument(doc2.rootDoc());
                hasStoredField = true;
        for (IndexableField field : fields) {
        assertThat("Should match 1.0.0, 1.0.1, 1.1.0, 1.0.0+build.123", searcher.count(complexQuery), equalTo(4));  
        assertThat(termsException.getMessage(), containsString("is neither indexed nor has doc_values enabled"));
        MappedFieldType fieldType = ((FieldMapper) mapper.mappers().getMapper("field")).fieldType();
        );  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        // Test termQuery - should use index query only
        assertThat(doc.rootDoc().getFields("field"), arrayWithSize(0));  
            mapper.parse(source(b -> b.field("field", "1.0.0"))),
        boolean hasDocValues = false;
        List<String> malformedVersions = Arrays.asList(
        IllegalArgumentException nullValueException = expectThrows(
            .build();
import java.util.Arrays;  
        for (ParsedDocument doc : docs) {
        boolean hasStoredField = false;
        doc = mapper.parse(source(b -> b.field("field", "1.2.3+build.123")));
        boolean hasTermField = false;
    public void testTermQuery() throws Exception {  
        SemanticVersion v1 = SemanticVersion.parse(doc1.rootDoc().getField("field").stringValue());
        assertEquals("Build metadata should not affect equality", 0, v1.compareTo(v2));  
        }
            false   // isStored
        );
import org.apache.lucene.search.TopDocs;
        Query complexQuery = new BooleanQuery.Builder().add(
            "1.0.0-beta.2",
            fieldType.prefixQuery("1.", MultiTermQuery.CONSTANT_SCORE_REWRITE, false, null),
        );
                () -> mapper.parse(source(b -> b.field("field", malformed)))
            false  // isStored
                || (rangeQuery4 instanceof IndexOrDocValuesQuery  
import java.util.stream.Collectors;
        Query termsQuery = searchOnlyFieldType.termsQuery(terms, mockContext);
        assertTrue(e.getCause().getMessage().contains("Invalid semantic version format"));
            b.startObject("version2").field("type", "version").field("store", true).endObject();  
        IllegalArgumentException fuzzyException = expectThrows(
        List<ParsedDocument> docs = Arrays.asList(
        )
        return new IndexSearcher(DirectoryReader.open(dir));  
        );
    }
import org.apache.lucene.index.MultiReader;
        // No additional parameters to register for version field type
                    MultiTermQuery.CONSTANT_SCORE_REWRITE,
        }));  
        ParsedDocument doc2 = mapper.parse(source(b -> b.field("field", "2.5.0")));  
        assertEquals("Fuzzy queries require the field to be indexed", fuzzyException.getMessage());  
        dir.close();
            IllegalArgumentException.class,
        testVersionSorting(mapper, versions, expected);  
        );
        List<String> versions = Arrays.asList(
            "1.0.0"  
        assertNotNull(doc.rootDoc().getField("field"));
            MultiTermQuery.CONSTANT_SCORE_REWRITE,
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        assertThat(rangeException.getMessage(), containsString("Failed to create range query for field"));
        );
        assertThat(fieldDataException.getMessage(), containsString("does not have doc_values enabled"));  
            "1.0.0-beta+build.123",  
            MultiTermQuery.CONSTANT_SCORE_REWRITE,
import java.util.ArrayList;
        for (ParsedDocument doc : docs) {  
        Query fuzzyQuery = fieldType.fuzzyQuery(
    }
        );
                "docvalues_only",
        // Create a mock QueryShardContext
        // Test null bounds
        Query wildcardQuery = fieldType.wildcardQuery(  
        // Test negative version numbers  
        // Test version with many build metadata parts  
        MultiReader multiReader = new MultiReader(readers, true);
            "1.0.0-alpha",
        // Test invalid version format
                    RegExp.ALL,
import org.apache.lucene.search.MultiTermQuery;
        );  
        List<String> sortedVersions = docs.stream().map(doc -> {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                break;  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        // Test with doc values only field
        );
            return null;
            mapper.parse(source(b -> b.field("field", "1.0.0"))),
                hasDocValues = true;
        minimalMapping(b);  
        assertThat(field.stringValue(), equalTo("1.2.3-alpha"));
        writer1.addDocument(doc1.rootDoc());
        builder.startObject();
            if (field.fieldType().stored()) {  
        );
        // Test valueFetcher without format parameter
        DocumentMapper mapper = createDocumentMapper(mapping);  
                    && ((IndexOrDocValuesQuery) rangeQuery4).getIndexQuery() instanceof TermRangeQuery)
        List<String> versions = Arrays.asList(
            );
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        builder.value("1.0.0");
            SemanticVersion sv = SemanticVersion.parse(v);  
package org.opensearch.index.mapper;
        IndexSearcher searcher = setupSearcher(mapper);
        );
import org.apache.lucene.store.Directory;  
        QueryShardException rangeException = expectThrows(
        );  
            "01.0.0",  
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> b.field("field", "1.0.0@"))));  
        assertThat("Should match same as case sensitive", searcher.count(caseInsensitivePrefix), equalTo(5));
        assertThat(
                hasTermField = true;
        writer.close();
        );
        Query docValuesTermsQuery = docValuesOnlyFieldType.termsQuery(terms, mockContext);  
            IllegalArgumentException.class,  
    }
        // Create a list of versions in random order  
    public void testNullHandling() throws Exception {  
        // Test wildcardQuery with non-searchable field
        // Test termQuery with null value (should throw exception)
        doc = mapper.parse(source(b -> b.field("field", "1.0.0-alpha.beta.gamma.delta.epsilon")));  
            assertNotNull("Stored field should exist for " + version, storedField);
