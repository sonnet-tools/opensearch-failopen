    public void testMultiMatchBoolPrefix() throws IOException {  
        assertPrefixFieldType(prefixFieldMapper.fieldType(), 3, "default");
            Query actual = new MatchPhraseQueryBuilder("field", "one two").slop(1).toQuery(queryShardContext);
        int maxShingleSize,  
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").toQuery(queryShardContext);
            assertThat(actual, equalTo(expected));
                    b.startObject("nested_field");
                b.startObject("properties");  
            b.field("search_analyzer", "keyword");
package org.opensearch.index.mapper;
            assertThat(values, equalTo(expectedValues));
        }, b -> {
        assertThat(fieldType.prefixField, equalTo(prefixFieldType));
            assertFalse(prefixFieldMapper.fieldType.storeTermVectorOffsets());  
    protected void registerParameters(ParameterChecker checker) throws IOException {  
                b.field("type", "object");
        for (String termVector : termVectors) {  
    private static void assertPrefixFieldType(PrefixFieldType fieldType, int shingleSize, String analyzerName) {  
            fieldType = mapperService.fieldType(name);  
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
            mpq.setSlop(1);
 *  
            }
        return List.of(new MapperExtrasModulePlugin());
            builder.add(new BooleanClause(new TermQuery(new Term(shingleFieldName, term)), BooleanClause.Occur.SHOULD));  
import org.apache.lucene.search.ConstantScoreQuery;  
        {  
        );
            String name = path + "._" + i + "gram";
import java.util.stream.Collectors;
                .build();  
        }  
            assertThat(analyzer.name(), equalTo(analyzerName));
/*  
        QueryShardContext queryShardContext = createQueryShardContext(
            IndexableField[] indexFields = doc.rootDoc().getFields(field);  
            assertFalse(prefixFieldMapper.fieldType.storeTermVectorPositions());
            );  
import org.opensearch.index.query.QueryShardContext;
            expected.add(new Term("field._3gram", "two three four"));  
                b.array("field", values.toArray(new String[0]));
                b.field("max_shingle_size", "4");  
            b.field("type", "text");
    private void documentParsingTestCase(Collection<String> values) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertPrefixFieldType(prefixFieldMapper.fieldType(), maxShingleSize, analyzerName);
            mpq.add(new Term("field", "two"));
            expected.add(new Term("field._3gram", "one two three"));
            "field._2gram",
                new SpanTermQuery(new Term("field._3gram", "more than three"))
        );
                    .startObject("fields")
            DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
        }), fieldMapping(b -> {
    }
            assertThat(actual, equalTo(expected));
            b.endObject();  
            assertThat(actual, equalTo(expected));
            "with_positions_payloads",  
            assertEquals("new york city", indexFields[0].stringValue());
            assertShingleFieldType(shingleField, shingleSize++, analyzerName, prefixFieldType);
            if (values.size() > 1) {  
        {
        {
            prefixFieldMapper.fieldType()
        {  
        final Mapper mapper = defaultMapper.mappers().getMapper(fieldName);
 * ownership. Elasticsearch licenses this file to you under  
            DocumentMapper mapper = createDocumentMapper(
            equalTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS)  
        checker.registerConflictCheck("term_vector", b -> b.field("term_vector", "yes"));
    }  
            getPrefixFieldMapper(mapper, "field._index_prefix"),  
import org.opensearch.plugins.Plugin;  
            b.field("norms", true);
        );
        final Mapper mapper = defaultMapper.mappers().getMapper(fieldName);
import org.apache.lucene.search.SynonymQuery;  
        final BooleanQuery.Builder builder = new BooleanQuery.Builder();  
                buildBoolPrefixQuery(  
            3,
            analyzerName,  
            "with_positions_offsets",
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.ShingleFieldMapper;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
    }
        checker.registerUpdateCheck(b -> {
                .forEach(m -> assertTrue("for " + m.name(), m.fieldType.storeTermVectors()));
        ShingleFieldType fieldType,  
            Query expected = new TermQuery(new Term("field", "one"));
                    {  
            getShingleFieldMapper(mapper, "field._3gram")  
        assertSearchAsYouTypeFieldType(mapper.fieldType(), maxShingleSize, analyzerName, mapper.prefixField().fieldType());  
                    "field._2gram",
    }
            3,  
                buildBoolPrefixQuery(
                    b.endObject();  
            assertThat(analyzer.name(), equalTo(analyzerName));
        NamedAnalyzer standard = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());  
    }  
            b.endObject();
                    asList("quick brown fox jump", "brown fox jump lazy", "fox jump lazy dog")
        MapperService ms = createMapperService(fieldMapping(b -> {  
        }  
        }
            Map.of(),  
import org.opensearch.index.analysis.NamedAnalyzer;  
            MultiPhrasePrefixQuery expected = new MultiPhrasePrefixQuery("field._3gram");  
        MapperService mapperService = createMapperService(  
        assertTrue(getRootFieldMapper(mapper, "field").fieldType().fieldType.stored());
                + "{\"type\":\"search_as_you_type\",\"doc_values\":false,\"max_shingle_size\":3,\"analyzer\":\"simple\"}}}}"
        );
        {
        {
        NamedAnalyzer keyword = new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer());
        }
        }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "search_as_you_type").field("index", false)));
                b.field("type", "search_as_you_type");
        Stream.of(  
            assertThat(actual, equalTo(expected));
            Query q = new MatchPhrasePrefixQueryBuilder("field._3gram", "two words").toQuery(queryShardContext);
                .add(new FieldExistsQuery("field.nested_field._3gram"), BooleanClause.Occur.SHOULD)
        final int numberOfShingleSubfields = (maxShingleSize - 2) + 1;  
        );  
    }
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchQuoteAnalyzer().name()));  
            assertThat(actual, equalTo(expected));
        }));
        }  
    private static ShingleFieldMapper getShingleFieldMapper(DocumentMapper defaultMapper, String fieldName) {
import org.apache.lucene.index.IndexOptions;
        final ParsedDocument parsedDocument = defaultMapper.parse(source(b -> {
            ShingleFieldType ft = (ShingleFieldType) fieldType;
            getShingleFieldMapper(defaultMapper, "field._4gram").fieldType(),
    @Override
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.PrefixFieldType;
        assertThat(wrappedSearchAnalyzer.indexPrefixes(), equalTo(false));
            assertThat(fieldType, instanceOf(ShingleFieldType.class));
        assertRootFieldMapper(rootMapper, 3, "default");
            createMapperService(fieldMapping(b -> b.field("type", "search_as_you_type").field("max_shingle_size", 4)))
            "default",
    public void testStore() throws IOException {
/*
            .analyzer();
        SearchAsYouTypeFieldType fieldType,
                b.startObject("suggest").field("type", "search_as_you_type").field("max_shingle_size", shingleSize).endObject();
                    .endObject()
            assertThat(actual, equalTo(expected));
    }
            b.field("type", "search_as_you_type");  
                    "field._index_prefix",  
            getShingleFieldMapper(defaultMapper, "field._2gram").fieldType(),
        Stream.of(  
        }
        assertThat(disMaxQuery.getDisjuncts(), hasSize(4));
    }  
import java.util.Map;
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
        checker.registerConflictCheck("index", b -> b.field("index", false));  
    @Override
        assertThat(mapper.shingleFields().length, equalTo(numberOfShingleSubfields));
        DocumentMapper defaultMapper = createDocumentMapper(  
        for (IndexableField[] fields : new IndexableField[][] { rootFields, prefixFields, shingle2Fields, shingle3Fields }) {
    }
        assertShingleFieldType(
    public void testAnalyzerSerialization() throws IOException {
    }  
                .build();
        }));
 * SPDX-License-Identifier: Apache-2.0
        documentParsingTestCase(randomUnique(() -> randomAlphaOfLengthBetween(3, 20), randomIntBetween(2, 10)));
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", "new york city")));
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").slop(1).toQuery(queryShardContext);
            new BooleanQuery.Builder().add(new FieldExistsQuery("field.nested_field"), BooleanClause.Occur.SHOULD)  
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder(
                new SpanTermQuery(new Term("field._3gram", "more than three"))
            b.startObject("b_field").field("type", "text").endObject();  
        }, m -> assertFalse(m.fieldType().getTextSearchInfo().hasNorms()));
            getShingleFieldMapper(defaultMapper, "field._3gram").fieldType(),
        checker.registerUpdateCheck(b -> {
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
        }));
        DocumentMapper mapper = createDocumentMapper(  
        {
            b.field("search_analyzer", "keyword");  
                .build()  
                .add(new Term("field._2gram", "two three"))
            b.field("search_quote_analyzer", "keyword");
import static org.hamcrest.Matchers.equalTo;
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        }
            Query expected = new SpanNearQuery.Builder("field._3gram", true).addClause(  
            "default",
    private static SearchAsYouTypeFieldMapper getRootFieldMapper(DocumentMapper defaultMapper, String fieldName) {
import static org.hamcrest.core.IsInstanceOf.instanceOf;
            getShingleFieldMapper(defaultMapper, "field._3gram").fieldType(),
        {  
                    }
    public void testMatchPhrase() throws IOException {  
            PrefixFieldMapper prefixFieldMapper = getPrefixFieldMapper(mapper, "field._index_prefix");
        String analyzerName,
        }
        assertThat(wrappedIndexAnalyzer.indexPrefixes(), equalTo(true));  
        merge(mapperService, mapping(b -> {  
    protected void metaMapping(XContentBuilder b) throws IOException {
        String analyzerName,
        PrefixFieldType prefixFieldType  
                    new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "than three words")), "field._3gram")
            assertEquals("new york city", fields[0].stringValue());
 * software distributed under the License is distributed on an
            final ShingleFieldMapper shingleFieldMapper = mapper.shingleFields()[shingleSize - 2];
            assertFalse(prefixFieldMapper.fieldType.storeTermVectorPayloads());
            Query actual = new MatchPhraseQueryBuilder("field._2gram", "one two three").toQuery(queryShardContext);
            Query q = new MatchPhrasePrefixQueryBuilder("field._3gram", "more than three words").toQuery(queryShardContext);
            assertEquals(1, indexFields.length);
        checker.registerConflictCheck("index_options", b -> b.field("index_options", "docs"));  
            "with_positions_offsets_payloads" };
                .add(new Term("field._3gram", "two three four"))  
import org.opensearch.index.query.QueryStringQueryBuilder;
            "with_positions",  
        }  
        for (SearchAsYouTypeAnalyzer analyzer : asList(wrappedIndexAnalyzer, wrappedSearchAnalyzer)) {  
            analyzerName,  
            b.field("norms", false);
import static org.hamcrest.Matchers.notNullValue;  
                b -> b.field("type", "search_as_you_type")  
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        }
        )
        int maxShingleSize = 4;
        List<String> fields = new ArrayList<>();
}  
                b -> b.field("type", "search_as_you_type").field("analyzer", analyzerName).field("max_shingle_size", maxShingleSize)
    }
        for (int shingleSize = 2; shingleSize <= maxShingleSize; shingleSize++) {  
 * this work for additional information regarding copyright
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    public void testSimpleMerge() throws IOException {
 *
            disMaxQuery.getDisjuncts(),
        assertShingleFieldType(  
        for (NamedAnalyzer analyzer : asList(fieldType.indexAnalyzer(), fieldType.getTextSearchInfo().getSearchAnalyzer())) {
    public void testSubField() throws IOException {  
    public void testConfiguration() throws IOException {  
            assertThat(actual, equalTo(expected));  
        }  
            if (shingleSize > 1) {
        }
    public void testDocumentParsingMultipleValues() throws IOException {  
            }
        {
            assertThat(actual, equalTo(expected));
            {
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
                    "field._index_prefix",
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
        }));  
            prefixFieldMapper.fieldType()
        b.field("type", "search_as_you_type").field("max_shingle_size", 3).field("doc_values", false);
        }
                {
        );
                .addClause(  
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            assertThat(analyzer.shingleSize(), equalTo(shingleSize));
            fieldMapping(b -> b.field("type", "search_as_you_type").field("index_options", "offsets"))
            Query actual = new MatchPhraseQueryBuilder("field._3gram", "one two three").toQuery(queryShardContext);
import org.apache.lucene.index.Term;  
            Map.of()
            Query actual = new MatchPhraseQueryBuilder("field._3gram", "one two three four").toQuery(queryShardContext);
        // norms can be set from true to false, but not vice versa  
        assertThat(  
            b.startObject("a_field").field("type", "search_as_you_type").field("analyzer", "standard").endObject();
        }));  
            }
        {
        final Mapper mapper = defaultMapper.mappers().getMapper(fieldName);
        return (ShingleFieldMapper) mapper;
    }  
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._3gram", "one two three")).build();
            Query q = new MatchPhrasePrefixQueryBuilder("field", "more than three words").toQuery(queryShardContext);
            getPrefixFieldMapper(mapper, "field._index_prefix"),
/*
        assertThat(mapper.prefixField().fieldType().parentField, equalTo(mapper.name()));  
                assertThat(wrappedAnalyzer.shingleSize(), equalTo(shingleSize));  
 * license agreements. See the NOTICE file distributed with
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchAnalyzer().name()));
import java.util.List;
            assertEquals(i, ft.shingleSize);  
    @Override
import org.opensearch.index.query.MatchPhraseQueryBuilder;
        }
            Set<String> expectedValues = Arrays.stream(fields).map(IndexableField::stringValue).collect(Collectors.toSet());  
            assertEquals(1, fields.length);  
        MapperService mapperService = createMapperService(mapping(b -> {
        for (int i = 0; i < terms.size() - 1; i++) {
        assertThat(fieldType.shingleFields.length, equalTo(maxShingleSize - 1));
                .add(new Term("field._3gram", "two three four"))
        {
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.apache.lucene.queries.spans.SpanNearQuery;
        MappedFieldType fieldType = mapperService.fieldType(path + "._index_prefix");
                getShingleFieldMapper(mapper, "field._2gram"),
            serialized,  
        assertThat(mapper.fieldType(), notNullValue());
            Stream.of(  
        final SearchAsYouTypeAnalyzer wrappedIndexAnalyzer = (SearchAsYouTypeAnalyzer) fieldType.indexAnalyzer().analyzer();
        assertThat(
            b.startObject("b_field").field("type", "text").endObject();
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(q, equalTo(mpq));
    private static BooleanQuery buildBoolPrefixQuery(String shingleFieldName, String prefixFieldName, List<String> terms) {
    @Override
            assertThat(analyzer.name(), equalTo(analyzerName));  
import org.apache.lucene.search.MultiPhraseQuery;
        assertShingleFieldType(  
        }
            assertThat(q, equalTo(expected));
            getShingleFieldMapper(mapper, "field._2gram"),
        // default setting
            Query actual = new MatchPhraseQueryBuilder("field._2gram", "one two").toQuery(queryShardContext);
    }
    public void testDocumentParsingSingleValue() throws IOException {
    public void testNestedExistsQuery() throws IOException {
                IllegalArgumentException.class,
    private static void assertShingleFieldType(
        QueryShardContext queryShardContext = createQueryShardContext(createMapperService(fieldMapping(this::minimalMapping)));
        SearchAsYouTypeFieldMapper rootMapper = getRootFieldMapper(defaultMapper, "field");  
            assertShingleFieldType(shingleFieldMapper.fieldType(), shingleSize, analyzerName, mapper.prefixField().fieldType());  
        );
            assertThat(q, equalTo(expected));  
        checker.registerConflictCheck("max_shingle_size", b -> b.field("max_shingle_size", 4));
        Stream.of(
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "search_as_you_type").field("norms", false)));
 * The OpenSearch Contributors require contributions made to  
        }
            ).forEach(m -> assertTrue("for " + m.name(), m.fieldType.omitNorms()));
    ) {
        assertEquals(path, prefixFieldType.parentField);
            } else {
    }
        );
                    .field("type", "keyword")  
        }
            assertSame(prefixFieldType, ft.prefixFieldType);
 */
        }
                    .endObject()
            Query expected = new TermQuery(new Term("field._3gram", "one two three"));
            fieldMapping(
import java.io.IOException;
            mapping(b -> b.startObject("a_field").field("type", "search_as_you_type").field("analyzer", "standard").endObject())
        assertThat(mapper.prefixField(), notNullValue());
            getShingleFieldMapper(mapper, "field._2gram"),
import org.apache.lucene.search.MatchNoDocsQuery;  
        QueryShardContext queryShardContext = createQueryShardContext(createMapperService(fieldMapping(this::minimalMapping)));
        IndexableField[] shingle3Fields = parsedDocument.rootDoc().getFields("field._3gram");
        NamedAnalyzer simple = new NamedAnalyzer("simple", AnalyzerScope.INDEX, new SimpleAnalyzer());
    }
            );
                ),
        for (int shingleSize = 2; shingleSize < 4; shingleSize++) {  
        {
    public void testIndexOptions() throws IOException {
        int shingleSize = 2;  
    }  
    }
    private void assertMultiField(int shingleSize) throws IOException {
            "field._3gram",  
            b.field("norms", true);  
            "quick brown fox jump lazy dog",  
                .addClause(  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.index.analysis.IndexAnalyzers;
            "field._4gram"
            "default",
        }));
    }
                b.field("analyzer", "standard");
            b.field("type", "text");
            )
        }
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._2gram", "one two")).build();
    }  
import java.util.ArrayList;  
import org.apache.lucene.search.Query;
            new StandardAnalyzer(),  
            }
import org.apache.lucene.analysis.core.KeywordAnalyzer;  
                .build();  
        assertThat(fieldType.shingleSize, equalTo(shingleSize));  
        assertThat(fieldType.prefixFieldType, equalTo(prefixFieldType));
        }  
            b.startObject("field");  
            containsInAnyOrder(
        String[] termVectors = {
                m -> assertThat(  
            Stream.of(
import org.opensearch.index.IndexSettings;  
        assertThat(mapper, instanceOf(PrefixFieldMapper.class));  
        );
                )
        Query actual = new QueryStringQueryBuilder("field:*").toQuery(queryShardContext);
        );
            fieldMapping(
    public void testIndex() throws IOException {
        ).forEach(m -> assertThat("for " + m.name(), m.fieldType.indexOptions(), equalTo(IndexOptions.NONE)));  
    }
            Stream.of(getShingleFieldMapper(mapper, "field._2gram"), getShingleFieldMapper(mapper, "field._3gram"))
        assertShingleFieldType(
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field", "one")).add(new Term("field", "two")).setSlop(1).build();  
        }  
 * compatible open source license.
                    equalTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS)  
            "{\"_doc\":{\"properties\":{\"field\":"
    }  
                .add(new FieldExistsQuery("field.nested_field._2gram"), BooleanClause.Occur.SHOULD)
    protected void minimalMapping(XContentBuilder b) throws IOException {  
            new BooleanClause(new ConstantScoreQuery(new TermQuery(new Term(prefixFieldName, finalTerm))), BooleanClause.Occur.SHOULD)
import org.apache.lucene.index.IndexableField;
            IndexableField[] fields = doc.rootDoc().getFields(field);
import static org.hamcrest.Matchers.containsString;  
            getShingleFieldMapper(mapper, "field._3gram")
            getShingleFieldMapper(mapper, "field._2gram"),
        return builder.build();  
        documentParsingTestCase(Collections.singleton(randomAlphaOfLengthBetween(5, 20)));  
        PrefixFieldType prefixFieldType = (PrefixFieldType) fieldType;
    }
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.SearchAsYouTypeFieldType;
                    "field._4gram",  
            prefixFieldMapper.fieldType()
        final SearchAsYouTypeAnalyzer wrappedSearchAnalyzer = (SearchAsYouTypeAnalyzer) fieldType.getTextSearchInfo()  
            )  
        {
            }  
            expectThrows(  
            MultiPhrasePrefixQuery mpq = new MultiPhrasePrefixQuery("field");  
        checker.registerConflictCheck("analyzer", b -> b.field("analyzer", "keyword"));
                )
            getShingleFieldMapper(mapper, "field._3gram")  
            );  
        }
        final String finalTerm = terms.get(terms.size() - 1);
            assertMultiField(shingleSize);
            getShingleFieldMapper(defaultMapper, "field._2gram").fieldType(),
        checker.registerConflictCheck("similarity", b -> b.field("similarity", "boolean"));
        assertPrefixFieldType(mapper.prefixField().fieldType(), maxShingleSize, analyzerName);
                    "field._index_prefix",
                }
public class SearchAsYouTypeFieldMapperTests extends MapperTestCase {  
        assertRootFieldMapper(rootMapper, maxShingleSize, analyzerName);
            b.field("type", "search_as_you_type");
                final SearchAsYouTypeAnalyzer wrappedAnalyzer = (SearchAsYouTypeAnalyzer) analyzer.analyzer();
        merge(ms, mapping(b -> {}));
        PrefixFieldMapper prefixFieldMapper = getPrefixFieldMapper(defaultMapper, "field._index_prefix");  
        final DisjunctionMaxQuery disMaxQuery = (DisjunctionMaxQuery) actual;
                    .startObject("subField")
    }
        }  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, mapping(b -> {
                    new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "than three words")), "field._3gram")
    }
        assertEquals(expected, actual);
 * not use this file except in compliance with the License.
        {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "search_as_you_type").field("store", true)));  
            .getSearchAnalyzer()
 * Modifications Copyright OpenSearch Contributors. See  
            Query q = new MatchPhrasePrefixQueryBuilder("field", "three words here").toQuery(queryShardContext);
 * KIND, either express or implied.  See the License for the
                buildBoolPrefixQuery(
            b.field("type", "text");
    }
                b.endObject();
        checker.registerConflictCheck("norms", fieldMapping(b -> {
                assertThat(wrappedAnalyzer.indexPrefixes(), equalTo(false));
            b.field("analyzer", "simple");
            assertFalse(prefixFieldMapper.fieldType.storeTermVectors());
        for (String field : fields) {
import org.apache.lucene.analysis.core.SimpleAnalyzer;
            )
            "yes",
            prefixFieldMapper.fieldType()
            getRootFieldMapper(mapper, "field").fieldType().fieldType.indexOptions(),
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._3gram", "one two three"))
            PrefixFieldMapper prefixFieldMapper = getPrefixFieldMapper(mapper, "field._index_prefix");
            )  
            b.field("analyzer", "default");  
        assertThat(mapper, instanceOf(ShingleFieldMapper.class));  
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.SearchAsYouTypeAnalyzer;  
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
        // We serialize these fields regardless of whether or not they are changed  
            assertThat(q, equalTo(expected));
            assertThat(actual, equalTo(expected));  
            b.field("analyzer", "default");
            assertThat(shingleFieldMapper, notNullValue());
        for (String field : new String[] { "field", "field._index_prefix", "field._2gram", "field._3gram" }) {
                    m.fieldType.indexOptions(),
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "new york city")));  
                fieldMapping(b -> b.field("type", "search_as_you_type").field("term_vector", termVector))
            Query expected = new SpanNearQuery.Builder("field._3gram", true).addClause(  
        String serialized = Strings.toString(MediaTypeRegistry.JSON, ms.documentMapper());
        );
        {  
        assertThat(mapper, instanceOf(SearchAsYouTypeFieldMapper.class));  
import org.opensearch.core.common.Strings;  
            prefixFieldMapper.fieldType()
        {
    @Override
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
            getRootFieldMapper(mapper, "field"),
        );
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._3gram", "one two three"))
            {  
            Query actual = new MatchPhraseQueryBuilder("field", "one two three").toQuery(queryShardContext);  
        );  
            .forEach(
        }
            {  
import org.opensearch.index.analysis.AnalyzerScope;
        assertShingleFieldType(  
import org.apache.lucene.queries.spans.SpanTermQuery;  
 */
        );
        builder.type(MultiMatchQueryBuilder.Type.BOOL_PREFIX);  
            assertThat(q, equalTo(expected));
                )
                b.field("field", values.iterator().next());  
    private static void assertSearchAsYouTypeFieldType(
        }
    public void testMatchPhrasePrefix() throws IOException {
        Query expected = new ConstantScoreQuery(
            fields.add(name);
        assertEquals(serialized, Strings.toString(MediaTypeRegistry.JSON, ms.documentMapper()));  
 * Unless required by applicable law or agreed to in writing,
 *
        );
            analyzerName,  
            assertThat(actual, equalTo(expected));
import org.apache.lucene.search.BooleanQuery;
    public void testTermVectors() throws IOException {  
                .build();  
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.ShingleFieldType;  
    }
        assertEquals(
        assertThat(mapper.maxShingleSize(), equalTo(maxShingleSize));
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.PrefixFieldMapper;
        final Query actual = builder.toQuery(queryShardContext);
            Query actual = new MatchPhrasePrefixQueryBuilder("field._3gram", "one two three four").slop(1).toQuery(queryShardContext);
import org.apache.lucene.search.BooleanClause;
    public void testMultiFields() throws IOException {
        // can disable norms on search_as_you_type fields  
        }
    }  
                .build();  
        SearchAsYouTypeFieldMapper rootMapper = getRootFieldMapper(defaultMapper, "field");
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
        {
        IndexableField[] shingle2Fields = parsedDocument.rootDoc().getFields("field._2gram");  
        for (int i = 2; i < shingleSize; i++) {  
        })));
            getPrefixFieldMapper(mapper, "field._index_prefix"),
            mpq.add(new Term("field", "words"));  
            Query expected = new TermQuery(new Term("field._2gram", "one two"));  
        NamedAnalyzer dflt = new NamedAnalyzer(  
        b.field("type", "search_as_you_type");
import java.util.stream.Stream;
        checker.registerConflictCheck("store", b -> b.field("store", true));
        fields.add(path);
 * GitHub history for details.
    }  
        );  
            Query actual = new MatchPhraseQueryBuilder("field", "one").toQuery(queryShardContext);  
            b.startObject("a_field");
        }
            AnalyzerScope.INDEX,
            Query expected = new MatchNoDocsQuery();  
            assertTrue(getRootFieldMapper(mapper, "field").fieldType().fieldType.storeTermVectors());
                    asList("quick brown fox", "brown fox jump", "fox jump lazy", "jump lazy dog")  
import org.apache.lucene.search.DisjunctionMaxQuery;
            Query expected = new SynonymQuery.Builder("field._index_prefix").addTerm(new Term("field._index_prefix", "two words")).build();
    public void testIndexing() throws IOException {
        for (NamedAnalyzer analyzer : asList(fieldType.indexAnalyzer(), fieldType.getTextSearchInfo().getSearchAnalyzer())) {
    }  
            "with_offsets",
import org.opensearch.index.query.MultiMatchQueryBuilder;  
            assertTrue(prefixFieldMapper.fieldType.omitNorms());  
        }
            TextFieldMapper.Defaults.POSITION_INCREMENT_GAP
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    asList("quick brown", "brown fox", "fox jump", "jump lazy", "lazy dog")
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._2gram", "one two"))  
                        b.field("type", "search_as_you_type");
        {
                .build();
                    "field._3gram",
        int shingleSize,
import org.apache.lucene.search.TermQuery;
        assertThat(fieldType, instanceOf(PrefixFieldType.class));  
                ),
                () -> new MatchPhraseQueryBuilder("field._index_prefix", "one two three four").toQuery(queryShardContext)
            b.field("type", "search_as_you_type");  
        assertThat(e.getMessage(), containsString("Cannot update parameter [max_shingle_size]"));
        for (NamedAnalyzer analyzer : asList(fieldType.indexAnalyzer(), fieldType.getTextSearchInfo().getSearchAnalyzer())) {  
        NamedAnalyzer whitespace = new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer());  
        checker.registerUpdateCheck(b -> {
        assertThat(mapperService.fieldType("field.subField"), instanceOf(KeywordFieldMapper.KeywordFieldType.class));
    }
            b.field("norms", false);  
        }  
                getShingleFieldMapper(mapper, "field._3gram")
        builder.add(  
            assertThat(q, equalTo(expected));
                    "for " + m.name(),
        IndexableField[] rootFields = parsedDocument.rootDoc().getFields("field");
 */  
            Map.of("default", dflt, "standard", standard, "keyword", keyword, "simple", simple, "whitespace", whitespace),
        PrefixFieldMapper prefixFieldMapper = getPrefixFieldMapper(defaultMapper, "field._index_prefix");
                getShingleFieldMapper(mapper, "field._2gram"),
            Query actual = new MatchPhraseQueryBuilder("field", "one two three four").toQuery(queryShardContext);  
        ).forEach(m -> assertFalse("for " + m.name(), m.fieldType.stored()));
        MapperService mapperService = createMapperService(
    public void testDefaultConfiguration() throws IOException {
 * You may obtain a copy of the License at  
            Query actual = new MatchPhraseQueryBuilder("field", "one two").toQuery(queryShardContext);  
        {
    private static void assertRootFieldMapper(SearchAsYouTypeFieldMapper mapper, int maxShingleSize, String analyzerName) {
import java.util.Collection;
        for (ShingleFieldType shingleField : fieldType.shingleFields) {
        return new IndexAnalyzers(
            2,  
 * this file be licensed under the Apache-2.0 license or a
    }
            b.startObject("fields");
        );
    public void testNorms() throws IOException {  
        IndexableField[] prefixFields = parsedDocument.rootDoc().getFields("field._index_prefix");
        }
    ) {  
        return (PrefixFieldMapper) mapper;
            Query expected = new SynonymQuery.Builder("field._index_prefix").addTerm(new Term("field._index_prefix", "three words here"))
    }
        assertThat(actual, instanceOf(DisjunctionMaxQuery.class));  
            b.endObject();
            2,
        String analyzerName = "simple";
import static org.hamcrest.Matchers.hasSize;
import java.util.Collections;  
                getRootFieldMapper(mapper, "field"),  
        );  
    }  
                )  
        String path = "field.suggest";  
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
            assertTrue(getRootFieldMapper(mapper, "field").fieldType().fieldType.omitNorms());
        return (SearchAsYouTypeFieldMapper) mapper;
        PrefixFieldType prefixFieldType
            final String term = terms.get(i);
import java.util.Set;  
        builder.value("new york city");
import static java.util.Arrays.asList;
            4,
            "field",
import java.util.Arrays;
                getShingleFieldMapper(mapper, "field._3gram")  
import org.apache.lucene.search.FieldExistsQuery;
                getPrefixFieldMapper(mapper, "field._index_prefix"),
                buildBoolPrefixQuery("field", "field._index_prefix", asList("quick", "brown", "fox", "jump", "lazy", "dog")),  
            expected.setSlop(1);
    protected Collection<? extends Plugin> getPlugins() {  
        }
    private static PrefixFieldMapper getPrefixFieldMapper(DocumentMapper defaultMapper, String fieldName) {
 * under the License.  
    }  
            ).forEach(m -> assertFalse("for " + m.name(), m.fieldType.omitNorms()));  
