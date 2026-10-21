import org.opensearch.index.analysis.CustomAnalyzer;
            List.of(
 *
        try (Tokenizer tokenizer = new WildcardFieldMapper.WildcardFieldTokenizer()) {
            CharTermAttribute charTermAttribute = tokenizer.getAttribute(CharTermAttribute.class);
import org.opensearch.index.IndexSettings;
            CharTermAttribute charTermAttribute = tokenizer.getAttribute(CharTermAttribute.class);
                WildcardFieldTypeTests.suffixAnchored("e")
        assertEquals(Collections.singletonList("value"), fetchSourceValue(mapper, "value"));
import org.apache.lucene.store.Directory;
                            }
    /**
    public void testTokenizer() throws IOException {
        List<String> terms = new ArrayList<>();
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
            try (IndexWriter iw = new IndexWriter(directory, new IndexWriterConfig())) {
        assertEquals(Collections.singletonList("true"), fetchSourceValue(mapper, true));
    public void testPossibleToDeriveSource_WhenIgnoreAbovePresent() throws IOException {
                b -> b.field("type", "wildcard")
import org.apache.lucene.index.IndexWriter;
import org.opensearch.index.analysis.CharFilterFactory;
        assertEquals(0, fields.length);
                WildcardFieldTypeTests.prefixAnchored("a"),
        fieldType = fields[1].fieldType();
        return mapper;
import java.io.IOException;
        }
            tokenStream.reset();
                    "lowercase",
                WildcardFieldTypeTests.prefixAnchored("ur"),
            xcb.field("type", "wildcard");
        IndexableFieldType fieldType = fields[0].fieldType();
        Field textField = (Field) fields[0];
                WildcardFieldTypeTests.suffixAnchored("bc"),
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        );
import org.apache.lucene.index.IndexOptions;
    }
    protected void registerParameters(ParameterChecker checker) throws IOException {
import java.util.Map;
                    AnalyzerScope.INDEX,
package org.opensearch.index.mapper;
    }
        assertFalse(fieldType.stored());
                "lowercase",
            tokenizer.reset();
            )
        assertEquals(2, fields.length);
    private static final String FIELD_NAME = "field";
        ParsedDocument doc = mapper.parse(source(b -> b.nullField("field")));
    }
        return doc;
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();
    public void testPossibleToDeriveSource_WhenDocValuesDisabled() throws IOException {
        assertEquals(IndexOptions.NONE, fieldType.indexOptions());
            }
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }
        assertFalse(fieldType.storeTermVectorOffsets());
        }));
                WildcardFieldTypeTests.suffixAnchored((char) 0 + "a"),
            }
        XContentBuilder mapping = fieldMapping(this::minimalMapping);
import static org.opensearch.index.mapper.KeywordFieldMapper.normalizeValue;
        assertEquals(IndexOptions.DOCS, fieldType.indexOptions());
            xcb.field("doc_values", true);
                    )
            terms
                WildcardFieldTypeTests.suffixAnchored("c")
            .build(context)
import java.io.StringReader;
        );
            singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
import org.apache.lucene.document.Field;
        assertEquals(IndexOptions.DOCS, fieldType.indexOptions());
        assertTrue(fields[0] instanceof Field);
}
import org.opensearch.Version;
        assertEquals(Collections.emptyList(), fetchSourceValue(ignoreAboveMapper, "value"));
        assertEquals(Collections.singletonList("true"), fetchSourceValue(ignoreAboveMapper, true));
import org.opensearch.common.settings.Settings;
                )
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    private Settings pluggableSettings() {
        // doc_values is true by default
                builder.endObject();
        assertEquals(new BytesRef("uri"), fields[1].binaryValue());
        MappedFieldType nullValueMapper = new WildcardFieldMapper.Builder("field").nullValue("NULL").build(context).fieldType();
    public void testPossibleToDeriveSource_WhenCopyToPresent() throws IOException {
    private Document createDocument(WildcardFieldMapper mapper, String value) throws IOException {
 */
        assertEquals(
        fields = doc.rootDoc().getFields("field");
 * The OpenSearch Contributors require contributions made to
            terms
        DocumentMapper mapper = createDocumentMapper(mapping);
        List<String> terms = new ArrayList<>();
        assertTrue(fieldType.omitNorms());
                "other_lowercase",
        doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertArrayEquals(new IndexableField[0], doc.rootDoc().getFields("field"));
import org.apache.lucene.analysis.TokenStream;
        assertFalse(fieldType.storeTermVectorOffsets());
    }
                WildcardFieldTypeTests.suffixAnchored("4")
        assertEquals(2, fields.length);
        assertEquals(Collections.singletonList("42"), fetchSourceValue(mapper, 42L));
                            public TokenStream create(TokenStream tokenStream) {
                WildcardFieldTypeTests.prefixAnchored("pi"),
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.document.Document;
        assertEquals(DocValuesType.SORTED_SET, fieldType.docValuesType());
    }
        FieldMapper.CopyTo copyTo = new FieldMapper.CopyTo.Builder().add("copy_to_field").build();
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
        assertFalse(fieldType.stored());
        IndexableField[] fields = doc.rootDoc().getFields("field");
 * compatible open source license.
                            }
                    .field("doc_values", hasDocValues)
        MappedFieldType mapper = new WildcardFieldMapper.Builder("field").build(context).fieldType();
            while (tokenizer.incrementToken()) {
        }
                                return new LowerCaseFilter(tokenStream);
                        new TokenFilterFactory[] { new TokenFilterFactory() {
                "lowercase",
        assertFalse(fieldType.storeTermVectors());
            tokenizer.setReader(new StringReader("pickle"));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
                terms.add(charTermAttribute.toString());
    }
    public void testNormalizer() throws IOException {
                terms.add(charTermAttribute.toString());
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "AbC")));
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
                    .field("normalizer", normalizerName)
                "234",
import org.apache.lucene.index.DocValuesType;
        List<String> terms = new ArrayList<>();
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
        assertEquals(DocValuesType.SORTED_SET, fields[1].fieldType().docValuesType());
/*
            ),
                WildcardFieldTypeTests.suffixAnchored("ri"),
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
    public void testDefaults() throws Exception {
            ),
        WildcardFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", false);
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
                WildcardFieldTypeTests.prefixAnchored("1"),
    @Override
import java.util.ArrayList;
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
            terms
import org.opensearch.core.xcontent.XContentBuilder;
                            @Override
import org.apache.lucene.index.IndexableField;
            List.of(
        final BytesRef binaryValue = new BytesRef(value);
import static java.util.Collections.singletonMap;
import org.apache.lucene.analysis.Tokenizer;
        Field textField = (Field) fields[0];
import org.opensearch.common.xcontent.XContentFactory;
            tokenStream.reset();
    }
            tokenizer.reset();
        );
import org.opensearch.index.analysis.IndexAnalyzers;
    }
        assertTrue(fieldType.tokenized());
        }
                WildcardFieldTypeTests.suffixAnchored("a")
            )
                        TokenizerFactory.newFactory("lowercase", WhitespaceTokenizer::new),
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "wildcard").field("doc_values", true)));
                WildcardFieldTypeTests.suffixAnchored("i")
import org.opensearch.index.analysis.AnalyzerScope;
                        new CharFilterFactory[0],
            List.of(
        assertFalse(fieldType.storeTermVectorPayloads());
            while (tokenStream.incrementToken()) {
        Document doc = new Document();
                WildcardFieldTypeTests.suffixAnchored("le"),
                "123",
        assertEquals("Field [field] of type [wildcard] doesn't support formats.", e.getMessage());
        );
public class WildcardFieldMapperTests extends MapperTestCase {
    public void testFetchSourceValue() throws IOException {
        assertEquals(
        assertFalse(fieldType.storeTermVectorPositions());
                new NamedAnalyzer("other_lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer())
            tokenizer.setReader(new StringReader("a"));
                WildcardFieldTypeTests.prefixAnchored("ab"),
                                return "lowercase";
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
        assertFalse(fieldType.storeTermVectors());
        }
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.apache.lucene.analysis.core.LowerCaseFilter;
                    .field("ignore_above", ignoreAbove)
                WildcardFieldTypeTests.prefixAnchored("a"),
        WildcardFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), 100, "lowercase", true);
    @Override
        assertEquals(Collections.singletonList("42"), fetchSourceValue(ignoreAboveMapper, 42L));
        mapper.copyTo = copyTo;
        );
            fieldMapping(
     */
                "pic",
                WildcardFieldTypeTests.prefixAnchored("p"),
import org.opensearch.index.analysis.TokenFilterFactory;
        assertTrue(fields[0] instanceof Field);
                    new CustomAnalyzer(
import org.opensearch.index.analysis.TokenizerFactory;
                iw.addDocument(createDocument(mapper, value));
        WildcardFieldMapper mapper = (WildcardFieldMapper) mapperService.documentMapper().mappers().getMapper(FIELD_NAME);
                "kle",
        b.field("type", "wildcard");
        fields = doc.rootDoc().getFields("field");
        try (TokenStream tokenStream = textField.tokenStreamValue()) {
        );
        assertEquals(new BytesRef("abc"), fields[1].binaryValue());
                terms.add(charTermAttribute.toString());
            while (tokenStream.incrementToken()) {
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        terms.clear();
        assertEquals(2, fields.length);
        assertEquals(DocValuesType.NONE, fields[0].fieldType().docValuesType());
    }
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        try (TokenStream tokenStream = textField.tokenStreamValue()) {
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "wildcard").field("null_value", "uri").field("doc_values", true)));
    public void testPossibleToDeriveSource_WhenNormalizerPresent() throws IOException {
        checker.registerConflictCheck("normalizer", b -> b.field("normalizer", "lowercase"));
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        try (TokenStream tokenStream = textField.tokenStreamValue()) {
        checker.registerConflictCheck("doc_values", fieldMapping(this::minimalMapping), fieldMapping(xcb -> {
        assertEquals(IndexOptions.NONE, fields[1].fieldType().indexOptions());
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        List<String> terms = new ArrayList<>();
            List.of(
            ),
                terms.add(charTermAttribute.toString());
            fieldMapping(b -> b.field("type", "wildcard").field("normalizer", "lowercase").field("doc_values", true))
                String source = builder.toString();
        IndexableFieldType fieldType = fields[0].fieldType();
        MappedFieldType ignoreAboveMapper = new WildcardFieldMapper.Builder("field").ignoreAbove(4).build(context).fieldType();
        assertTrue(fieldType.tokenized());
            .fieldType();
        throws IOException {
        doc = mapper.parse(source(b -> b.field("field", "1234")));
import org.apache.lucene.document.SortedSetDocValuesField;
        DocumentMapper mapper = createDocumentMapper(
            Map.of(
            }
        );
    public void testEnableDocValues() throws IOException {
                        } }
                "ckl",
                WildcardFieldTypeTests.suffixAnchored("34"),
        checker.registerConflictCheck("null_value", b -> b.field("null_value", "foo"));
import java.util.List;
import org.apache.lucene.index.IndexWriterConfig;
                            @Override
        assertEquals(2, fields.length);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        }
        );
        assertEquals(Collections.singletonList("value"), fetchSourceValue(normalizerMapper, "value"));
        assertEquals(Collections.singletonList("value"), fetchSourceValue(normalizerMapper, "VALUE"));
            WildcardFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), Integer.MAX_VALUE, "default", true);
            ),
        assertEquals(Collections.singletonList("NULL"), fetchSourceValue(nullValueMapper, null));
    }
        MapperService mapperService = createMapperService(
            ),
import org.opensearch.index.analysis.LowercaseNormalizer;
            }
                "ick",
                WildcardFieldTypeTests.prefixAnchored("12"),
                new NamedAnalyzer(
    }
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "wildcard").field("doc_values", false)));
        assertTrue(fieldType.omitNorms());
        try (Tokenizer tokenizer = new WildcardFieldMapper.WildcardFieldTokenizer()) {
        WildcardFieldMapper mapper = getMapper(copyTo, Integer.MAX_VALUE, "default", true);
            singletonMap(
    }
            tokenStream.reset();
            }
        assertFalse(fieldType.storeTermVectorPositions());
        value = normalizeValue(normalizer, FIELD_NAME, value);
                "abc",
        assertEquals(
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, fields.length);
    }
    }
            terms
        Mapper.BuilderContext context = new Mapper.BuilderContext(settings, new ContentPath());
        NamedAnalyzer normalizer = mapper.fieldType().normalizer();
    public void testNullValue() throws IOException {
    protected void minimalMapping(XContentBuilder b) throws IOException {
                assertEquals("{\"" + FIELD_NAME + "\":" + "\"" + value + "\"" + "}", source);
import org.opensearch.index.analysis.NamedAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        checker.registerUpdateCheck(b -> b.field("ignore_above", 256), m -> assertEquals(256, ((WildcardFieldMapper) m).ignoreAbove()));
            }
    public void testDerivedValueFetching_DocValues() throws IOException {
                new NamedAnalyzer("lowercase", AnalyzerScope.INDEX, new LowercaseNormalizer()),
        }
        assertEquals(Collections.singletonList("42"), fetchSourceValue(normalizerMapper, 42L));
    }
            String value = "keyword_value";
            terms
                "uri",
    }
        assertFalse(fieldType.storeTermVectorPayloads());
                            public String name() {
import org.apache.lucene.index.IndexableFieldType;
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        b.field("doc_values", false);
    @Override
     * Helper method to create a document with both doc values and stored fields
 * this file be licensed under the Apache-2.0 license or a
            List.of(
        Field textField = (Field) fields[0];
import static org.opensearch.index.mapper.FieldTypeTestCase.fetchSourceValue;
        doc = mapper.parse(source(b -> b.nullField("field")));
                XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
                mapper.deriveSource(builder, reader.leaves().get(0).reader(), 0);
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
    @Override
        doc = mapper.parse(source(b -> {}));
            while (tokenStream.incrementToken()) {
        doc.add(new SortedSetDocValuesField(FIELD_NAME, binaryValue));
        mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "wildcard")));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        WildcardFieldMapper mapper = getMapper(FieldMapper.CopyTo.empty(), 100, "default", true);
        assertEquals(DocValuesType.SORTED_SET, fields[1].fieldType().docValuesType());
            while (tokenizer.incrementToken()) {
import java.util.Collections;
        assertTrue(fields[0] instanceof Field);
        assertEquals(
        builder.value("value");
    }
        try (Directory directory = newDirectory()) {
import org.opensearch.cluster.metadata.IndexMetadata;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> fetchSourceValue(mapper, "value", "format"));
        assertEquals(
            }
        assertEquals(1, fields.length);
        MappedFieldType normalizerMapper = new WildcardFieldMapper.Builder("field", createIndexAnalyzers(null)).normalizer("lowercase")
        assertThrows(UnsupportedOperationException.class, mapper::canDeriveSource);
        fields = doc.rootDoc().getFields("field");
                terms.add(charTermAttribute.toString());
                WildcardFieldTypeTests.prefixAnchored("u"),
            ),
    private WildcardFieldMapper getMapper(FieldMapper.CopyTo copyTo, int ignoreAbove, String normalizerName, boolean hasDocValues)
import org.apache.lucene.util.BytesRef;
        return new IndexAnalyzers(
