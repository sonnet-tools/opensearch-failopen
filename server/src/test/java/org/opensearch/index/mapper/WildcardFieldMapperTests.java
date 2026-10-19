        );
        assertFalse(fieldType.storeTermVectorPayloads());
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        return mapper;  
                    new CustomAnalyzer(  
import org.apache.lucene.analysis.Tokenizer;
        assertFalse(fieldType.stored());
        assertEquals(IndexOptions.DOCS, fieldType.indexOptions());  
                WildcardFieldTypeTests.suffixAnchored("ri"),
        WildcardFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), 100, "lowercase", true);  
import org.apache.lucene.index.IndexWriterConfig;
                WildcardFieldTypeTests.prefixAnchored("ur"),
import org.opensearch.index.IndexSettings;  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> fetchSourceValue(mapper, "value", "format"));
                WildcardFieldTypeTests.prefixAnchored("1"),
                WildcardFieldTypeTests.suffixAnchored("i")
        assertEquals(  
            )
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.core.xcontent.XContentBuilder;
    private Document createDocument(WildcardFieldMapper mapper, String value) throws IOException {  
        DocumentMapper mapper = createDocumentMapper(mapping);
    }  
                WildcardFieldTypeTests.prefixAnchored("p"),
            fieldMapping(b -> b.field("type", "wildcard").field("normalizer", "lowercase").field("doc_values", true))
        assertEquals(DocValuesType.SORTED_SET, fields[1].fieldType().docValuesType());
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
        assertEquals(2, fields.length);  
        assertEquals(2, fields.length);
    private static final String FIELD_NAME = "field";
package org.opensearch.index.mapper;
    }
        Field textField = (Field) fields[0];
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
import java.io.StringReader;
import org.apache.lucene.index.IndexWriter;
                WildcardFieldTypeTests.suffixAnchored("bc"),  
        XContentBuilder mapping = fieldMapping(this::minimalMapping);  
        doc.add(new SortedSetDocValuesField(FIELD_NAME, binaryValue));
            singletonMap(
    private Settings pluggableSettings() {  
        return doc;  
        assertEquals(Collections.singletonList("value"), fetchSourceValue(normalizerMapper, "value"));  
        DocumentMapper mapper = createDocumentMapper(
        );
            String value = "keyword_value";  
                            public String name() {  
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
                "abc",
                        new TokenFilterFactory[] { new TokenFilterFactory() {  
        assertEquals(  
 * The OpenSearch Contributors require contributions made to  
                            }
        IndexableField[] fields = doc.rootDoc().getFields("field");
                new NamedAnalyzer("lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer()),  
                WildcardFieldTypeTests.prefixAnchored("a"),  
                WildcardFieldTypeTests.prefixAnchored("pi"),  
                terms.add(charTermAttribute.toString());  
    }
            while (tokenizer.incrementToken()) {
        MapperService mapperService = createMapperService(
            List.of(
                                return "lowercase";
        }
        value = normalizeValue(normalizer, FIELD_NAME, value);  
            .fieldType();  
            while (tokenStream.incrementToken()) {
    }
                WildcardFieldTypeTests.suffixAnchored("le"),
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testNullValue() throws IOException {
                "ckl",  
            }  
        try (Tokenizer tokenizer = new WildcardFieldMapper.WildcardFieldTokenizer()) {
        fields = doc.rootDoc().getFields("field");
        assertEquals(2, fields.length);
        assertTrue(fields[0] instanceof Field);
        terms.clear();
            List.of(  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
                terms.add(charTermAttribute.toString());
        }  
                b -> b.field("type", "wildcard")
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "wildcard").field("doc_values", false)));
    }  
    @Override  
            while (tokenStream.incrementToken()) {  
        }));  
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);  
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
            CharTermAttribute charTermAttribute = tokenizer.getAttribute(CharTermAttribute.class);
        assertEquals(Collections.singletonList("true"), fetchSourceValue(mapper, true));  
            while (tokenStream.incrementToken()) {
    @Override
        assertFalse(fieldType.storeTermVectorPositions());  
            tokenizer.setReader(new StringReader("pickle"));
        assertEquals(Collections.singletonList("42"), fetchSourceValue(normalizerMapper, 42L));
            }
        assertEquals(IndexOptions.NONE, fieldType.indexOptions());  
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.index.analysis.AnalyzerScope;
                terms.add(charTermAttribute.toString());  
                terms.add(charTermAttribute.toString());
                        TokenizerFactory.newFactory("lowercase", WhitespaceTokenizer::new),
        MappedFieldType nullValueMapper = new WildcardFieldMapper.Builder("field").nullValue("NULL").build(context).fieldType();
            ),
        doc = mapper.parse(source(b -> b.field("field", "1234")));  
 * compatible open source license.
        assertFalse(fieldType.storeTermVectorPositions());  
                            public TokenStream create(TokenStream tokenStream) {
            terms  
        assertEquals(Collections.singletonList("true"), fetchSourceValue(ignoreAboveMapper, true));
    }
        assertEquals(
                    .field("ignore_above", ignoreAbove)
                iw.addDocument(createDocument(mapper, value));
    }
    }
        );
        assertEquals("Field [field] of type [wildcard] doesn't support formats.", e.getMessage());  
    public void testDerivedValueFetching_DocValues() throws IOException {  
import org.apache.lucene.analysis.TokenStream;
import org.opensearch.index.analysis.TokenizerFactory;
        assertEquals(Collections.singletonList("42"), fetchSourceValue(mapper, 42L));
    }  
            xcb.field("type", "wildcard");
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
        // doc_values is true by default
        );  
                            @Override
}  
        assertTrue(fieldType.tokenized());
 *
        assertEquals(Collections.singletonList("42"), fetchSourceValue(ignoreAboveMapper, 42L));
        b.field("type", "wildcard");  
                builder.endObject();
        doc = mapper.parse(source(b -> b.nullField("field")));
                new NamedAnalyzer(  
        WildcardFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), 100, "default", true);
                            @Override
                    "lowercase",
                    )  
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        }  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        assertTrue(fieldType.omitNorms());  
                "lowercase",
        IndexableFieldType fieldType = fields[0].fieldType();
import java.util.List;
        List<String> terms = new ArrayList<>();
        }  
        assertTrue(fieldType.tokenized());
        }
            )
        fields = doc.rootDoc().getFields("field");
 */  
    public void testDefaults() throws Exception {
import org.opensearch.index.analysis.LowercaseNormalizer;
    @Override  
        }
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
                WildcardFieldTypeTests.prefixAnchored("a"),  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();  
import java.util.Map;  
        assertEquals(1, fields.length);
                "ick",
                WildcardFieldTypeTests.suffixAnchored("c")
        return new IndexAnalyzers(
                    AnalyzerScope.INDEX,
        checker.registerConflictCheck("doc_values", fieldMapping(this::minimalMapping), fieldMapping(xcb -> {  
        WildcardFieldMapper mapper = getMapper(copyTo, Integer.MAX_VALUE, "default", true);
                        } }
        assertTrue(fields[0] instanceof Field);  
import org.apache.lucene.document.SortedSetDocValuesField;  
    }
        );
                    .field("normalizer", normalizerName)  
                )
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + value + "\"" + "}", source);
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));  
            ),
import java.io.IOException;
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
            CharTermAttribute charTermAttribute = tokenizer.getAttribute(CharTermAttribute.class);
        Field textField = (Field) fields[0];
        WildcardFieldMapper mapper = (WildcardFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
        doc = mapper.parse(source(b -> b.field("field", "1234")));  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "AbC")));
        );  
        IndexableField[] fields = doc.rootDoc().getFields("field");
                "pic",
        fieldType = fields[1].fieldType();
import org.opensearch.index.analysis.CharFilterFactory;
    public void testNormalizer() throws IOException {  
    /**  
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        assertEquals(Collections.emptyList(), fetchSourceValue(ignoreAboveMapper, "value"));  
            terms  
                            }
                WildcardFieldTypeTests.suffixAnchored("e")  
import static org.opensearch.index.mapper.FieldTypeTestCase.fetchSourceValue;  
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "wildcard")));
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        assertEquals(DocValuesType.SORTED_SET, fields[1].fieldType().docValuesType());
    }
import org.apache.lucene.document.Document;
            tokenizer.reset();
        assertEquals(Collections.singletonList("value"), fetchSourceValue(normalizerMapper, "VALUE"));
        try (TokenStream tokenStream = textField.tokenStreamValue()) {  
public class WildcardFieldMapperTests extends MapperTestCase {  
        assertFalse(fieldType.storeTermVectors());
        IndexableFieldType fieldType = fields[0].fieldType();
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
    public void testPossibleToDeriveSource_WhenDocValuesDisabled() throws IOException {
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
            }  
    @Override
    }
                WildcardFieldTypeTests.prefixAnchored("ab"),
        checker.registerConflictCheck("null_value", b -> b.field("null_value", "foo"));
                String source = builder.toString();  
        MappedFieldType mapper = new WildcardFieldMapper.Builder("field").build(context).fieldType();  
        try (TokenStream tokenStream = textField.tokenStreamValue()) {
            }
            List.of(
        b.field("doc_values", false);
        );  
        assertFalse(fieldType.storeTermVectors());
        assertEquals(1, fields.length);  
import org.opensearch.index.analysis.CustomAnalyzer;  
import org.opensearch.Version;
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "wildcard").field("doc_values", true)));  
    protected void minimalMapping(XContentBuilder b) throws IOException {
        assertFalse(fieldType.stored());
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());  
            tokenizer.reset();  
import static org.opensearch.index.mapper.KeywordFieldMapper.normalizeValue;
import java.util.ArrayList;  
        assertEquals(IndexOptions.DOCS, fieldType.indexOptions());  
            xcb.field("doc_values", true);
import org.apache.lucene.index.DocValuesType;
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
        List<String> terms = new ArrayList<>();
import org.opensearch.index.analysis.TokenFilterFactory;
            tokenStream.reset();
    public void testPossibleToDeriveSource_WhenIgnoreAbovePresent() throws IOException {  
     * Helper method to create a document with both doc values and stored fields
            ),  
                    .field("doc_values", hasDocValues)
    }
    private WildcardFieldMapper getMapper(FieldMapper.CopyTo copyTo, int ignoreAbove, String normalizerName, boolean hasDocValues)  
            while (tokenizer.incrementToken()) {  
            singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),  
        assertEquals(Collections.singletonList("value"), fetchSourceValue(mapper, "value"));
        try (Directory directory = newDirectory()) {
            List.of(
        assertEquals(Collections.singletonList("NULL"), fetchSourceValue(nullValueMapper, null));  
    protected void registerParameters(ParameterChecker checker) throws IOException {
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
        assertEquals(
        fields = doc.rootDoc().getFields("field");
        assertEquals(0, fields.length);  
        assertTrue(fields[0] instanceof Field);
            terms
 * SPDX-License-Identifier: Apache-2.0
                WildcardFieldTypeTests.prefixAnchored("u"),
            .build(context)
                "lowercase",
            }
import org.apache.lucene.util.BytesRef;  
import org.apache.lucene.store.Directory;
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {  
                "uri",  
        checker.registerConflictCheck("normalizer", b -> b.field("normalizer", "lowercase"));
        NamedAnalyzer normalizer = mapper.fieldType().normalizer();
            ),  
import org.apache.lucene.index.IndexableField;  
    }  
        assertFalse(fieldType.storeTermVectorOffsets());
                WildcardFieldTypeTests.prefixAnchored("12"),  
            }
            Map.of(
        assertEquals(IndexOptions.NONE, fields[1].fieldType().indexOptions());
    }
            ),
            ),  
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.opensearch.common.xcontent.XContentFactory;
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        Document doc = new Document();
        MappedFieldType normalizerMapper = new WildcardFieldMapper.Builder("field", createIndexAnalyzers(null)).normalizer("lowercase")
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());  
import org.apache.lucene.analysis.core.LowerCaseFilter;  
                "234",
import org.apache.lucene.index.IndexOptions;  
        doc = mapper.parse(source(b -> {}));
import org.opensearch.index.analysis.NamedAnalyzer;  
            WildcardFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", true);
        try (TokenStream tokenStream = textField.tokenStreamValue()) {
                "123",
            terms
import org.apache.lucene.index.IndexableFieldType;
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.analysis.IndexAnalyzers;
     */
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
    }
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
        assertFalse(fieldType.storeTermVectorPayloads());
    public void testTokenizer() throws IOException {
            tokenStream.reset();  
        Field textField = (Field) fields[0];  
                        new CharFilterFactory[0],
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
                new NamedAnalyzer("other_lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer())
import java.util.Collections;
                WildcardFieldTypeTests.suffixAnchored((char) 0 + "a"),
    public void testPossibleToDeriveSource_WhenNormalizerPresent() throws IOException {
        assertEquals(new BytesRef("abc"), fields[1].binaryValue());
        List<String> terms = new ArrayList<>();  
                "other_lowercase",
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);  
        );  
        WildcardFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", false);
            }
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
        try (Tokenizer tokenizer = new WildcardFieldMapper.WildcardFieldTokenizer()) {
            List.of(
        List<String> terms = new ArrayList<>();  
        builder.value("value");  
            tokenizer.setReader(new StringReader("a"));  
        assertEquals(
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "wildcard").field("null_value", "uri").field("doc_values", true)));  
import static java.util.Collections.singletonMap;
            tokenStream.reset();
                                return new LowerCaseFilter(tokenStream);  
        assertFalse(fieldType.storeTermVectorOffsets());
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);  
        MappedFieldType ignoreAboveMapper = new WildcardFieldMapper.Builder("field").ignoreAbove(4).build(context).fieldType();
        assertEquals(new BytesRef("uri"), fields[1].binaryValue());  
                terms.add(charTermAttribute.toString());
    public void testEnableDocValues() throws IOException {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    }  
        assertTrue(fieldType.omitNorms());  
        checker.registerUpdateCheck(b -> b.field("ignore_above", 256), m -> assertEquals(256, ((WildcardFieldMapper) m).ignoreAbove()));
        mapper.copyTo = copyTo;
            fieldMapping(  
    public void testFetchSourceValue() throws IOException {
                WildcardFieldTypeTests.suffixAnchored("34"),  
        assertEquals(2, fields.length);  
        final BytesRef binaryValue = new BytesRef(value);
import org.apache.lucene.document.Field;
                WildcardFieldTypeTests.suffixAnchored("4")
                "kle",
        throws IOException {
                WildcardFieldTypeTests.suffixAnchored("a")
    }
            terms
