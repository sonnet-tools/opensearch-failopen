            getShingleFieldMapper(mapper, "field._2gram"),
                getShingleFieldMapper(mapper, "field._2gram"),
            b.endObject();
            expectThrows(
 * this file be licensed under the Apache-2.0 license or a
            .forEach(
            b.field("type", "search_as_you_type");
    private static void assertSearchAsYouTypeFieldType(
import org.opensearch.index.analysis.NamedAnalyzer;
                .add(new Term("field._3gram", "two three four"))
        }));
                .build();
        );
        QueryShardContext queryShardContext = createQueryShardContext(createMapperService(fieldMapping(this::minimalMapping)));
            mapping(b -> b.startObject("a_field").field("type", "search_as_you_type").field("analyzer", "standard").endObject())
        PrefixFieldType prefixFieldType
            assertTrue(getRootFieldMapper(mapper, "field").fieldType().fieldType.storeTermVectors());
            Stream.of(getShingleFieldMapper(mapper, "field._2gram"), getShingleFieldMapper(mapper, "field._3gram"))
    public void testMatchPhrasePrefix() throws IOException {
        }), fieldMapping(b -> {
    }
        }, m -> assertFalse(m.fieldType().getTextSearchInfo().hasNorms()));
import org.opensearch.index.query.MatchPhraseQueryBuilder;
import org.apache.lucene.search.TermQuery;
                .add(new FieldExistsQuery("field.nested_field._3gram"), BooleanClause.Occur.SHOULD)
            Query expected = new TermQuery(new Term("field._3gram", "one two three"));
            MultiPhrasePrefixQuery expected = new MultiPhrasePrefixQuery("field._3gram");
                b.array("field", values.toArray(new String[0]));
    }
    }
            assertFalse(prefixFieldMapper.fieldType.storeTermVectorPositions());
            assertTrue(prefixFieldMapper.fieldType.omitNorms());
            assertEquals(1, indexFields.length);
                .build();
            assertFalse(prefixFieldMapper.fieldType.storeTermVectorPayloads());
import org.apache.lucene.queries.spans.SpanNearQuery;
        DocumentMapper mapper = createDocumentMapper(
            "yes",
    }
        checker.registerUpdateCheck(b -> {
 * You may obtain a copy of the License at
        assertThat(mapper, instanceOf(ShingleFieldMapper.class));
import org.opensearch.index.query.QueryShardContext;
    }
            getShingleFieldMapper(defaultMapper, "field._2gram").fieldType(),
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder(
import org.opensearch.index.IndexSettings;
        }
import org.apache.lucene.search.ConstantScoreQuery;
        IndexableField[] shingle3Fields = parsedDocument.rootDoc().getFields("field._3gram");
            Query actual = new MatchPhraseQueryBuilder("field._2gram", "one two").toQuery(queryShardContext);
        }));
    private void assertMultiField(int shingleSize) throws IOException {
        }
    }
        {
            "field._4gram"
            fieldMapping(b -> b.field("type", "search_as_you_type").field("index_options", "offsets"))
    public void testDefaultConfiguration() throws IOException {
            assertShingleFieldType(shingleField, shingleSize++, analyzerName, prefixFieldType);
import org.apache.lucene.search.BooleanClause;
            assertThat(actual, equalTo(expected));
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        );
    public void testSubField() throws IOException {
            assertEquals(i, ft.shingleSize);
                getShingleFieldMapper(mapper, "field._2gram"),
        );
import java.util.stream.Stream;
            b.field("analyzer", "default");
        }
        assertThat(mapper.maxShingleSize(), equalTo(maxShingleSize));
        assertThat(e.getMessage(), containsString("Cannot update parameter [max_shingle_size]"));
    }
import static org.hamcrest.Matchers.containsInAnyOrder;
        return (SearchAsYouTypeFieldMapper) mapper;
import org.opensearch.index.query.MultiMatchQueryBuilder;
    }
            "field._2gram",
                buildBoolPrefixQuery(
                    "field._3gram",
        checker.registerUpdateCheck(b -> {
        String analyzerName,
        int maxShingleSize = 4;
 * specific language governing permissions and limitations
        }
            assertThat(actual, equalTo(expected));
                assertThat(wrappedAnalyzer.shingleSize(), equalTo(shingleSize));
}
            Query actual = new MatchPhraseQueryBuilder("field", "one two three").toQuery(queryShardContext);
        NamedAnalyzer simple = new NamedAnalyzer("simple", AnalyzerScope.INDEX, new SimpleAnalyzer());
                    {
            String name = path + "._" + i + "gram";
        );
        }
        assertPrefixFieldType(mapper.prefixField().fieldType(), maxShingleSize, analyzerName);
    }
    }
import java.util.Arrays;
        }
            }
            new StandardAnalyzer(),
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
        for (String field : fields) {
        for (SearchAsYouTypeAnalyzer analyzer : asList(wrappedIndexAnalyzer, wrappedSearchAnalyzer)) {
            "default",
import org.apache.lucene.search.FieldExistsQuery;
        {
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        );
        }
            "default",
        assertThat(wrappedSearchAnalyzer.indexPrefixes(), equalTo(false));
            "with_positions_payloads",
            disMaxQuery.getDisjuncts(),
            4,
            }
                    .startObject("subField")
        {
import org.opensearch.core.common.Strings;
            "field",
        MapperService mapperService = createMapperService(mapping(b -> {
            "{\"_doc\":{\"properties\":{\"field\":"
    }
            IndexableField[] fields = doc.rootDoc().getFields(field);
            b.field("search_quote_analyzer", "keyword");
        {
import org.opensearch.core.xcontent.XContentBuilder;
    }
            2,
        builder.add(
        final int numberOfShingleSubfields = (maxShingleSize - 2) + 1;
                b.field("max_shingle_size", "4");
            )
            Query expected = new SpanNearQuery.Builder("field._3gram", true).addClause(
            analyzerName,
                    .endObject()
        }
        ).forEach(m -> assertFalse("for " + m.name(), m.fieldType.stored()));
            b.startObject("b_field").field("type", "text").endObject();
                    asList("quick brown fox", "brown fox jump", "fox jump lazy", "jump lazy dog")
            assertThat(actual, equalTo(expected));
        for (int i = 0; i < terms.size() - 1; i++) {
    }
    }
        );
        return new IndexAnalyzers(
    }
        for (String field : new String[] { "field", "field._index_prefix", "field._2gram", "field._3gram" }) {
        {
    }
            assertThat(q, equalTo(expected));
        );
            .analyzer();
                .add(new FieldExistsQuery("field.nested_field._2gram"), BooleanClause.Occur.SHOULD)
            2,
        assertPrefixFieldType(prefixFieldMapper.fieldType(), maxShingleSize, analyzerName);
            assertThat(q, equalTo(mpq));
        SearchAsYouTypeFieldType fieldType,
            assertFalse(prefixFieldMapper.fieldType.storeTermVectorOffsets());
        final Query actual = builder.toQuery(queryShardContext);
            assertThat(actual, equalTo(expected));
            mpq.setSlop(1);
 * license agreements. See the NOTICE file distributed with
    @Override
                )
            if (shingleSize > 1) {
                b.field("type", "object");
        }
            )
        assertTrue(getRootFieldMapper(mapper, "field").fieldType().fieldType.stored());
            fieldMapping(
            new BooleanQuery.Builder().add(new FieldExistsQuery("field.nested_field"), BooleanClause.Occur.SHOULD)
        }
        documentParsingTestCase(Collections.singleton(randomAlphaOfLengthBetween(5, 20)));
        assertThat(mapper.prefixField().fieldType().parentField, equalTo(mapper.name()));
                    m.fieldType.indexOptions(),
            {
        final SearchAsYouTypeAnalyzer wrappedSearchAnalyzer = (SearchAsYouTypeAnalyzer) fieldType.getTextSearchInfo()
        QueryShardContext queryShardContext = createQueryShardContext(createMapperService(fieldMapping(this::minimalMapping)));
            assertThat(q, equalTo(expected));
        assertEquals(path, prefixFieldType.parentField);
                new SpanTermQuery(new Term("field._3gram", "more than three"))
        final DisjunctionMaxQuery disMaxQuery = (DisjunctionMaxQuery) actual;
            Query expected = new MatchNoDocsQuery();
            prefixFieldMapper.fieldType()
        assertThat(actual, instanceOf(DisjunctionMaxQuery.class));
            b.field("search_analyzer", "keyword");
        }, b -> {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "search_as_you_type").field("store", true)));
            }
                        b.field("type", "search_as_you_type");
                )
import org.apache.lucene.search.MatchNoDocsQuery;
    protected Collection<? extends Plugin> getPlugins() {
        final String finalTerm = terms.get(terms.size() - 1);
            b.endObject();
            Query expected = new SynonymQuery.Builder("field._index_prefix").addTerm(new Term("field._index_prefix", "three words here"))
            getPrefixFieldMapper(mapper, "field._index_prefix"),
                .addClause(
                    }
        }));
        assertThat(fieldType.shingleFields.length, equalTo(maxShingleSize - 1));
            AnalyzerScope.INDEX,
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.SearchAsYouTypeAnalyzer;
        Query expected = new ConstantScoreQuery(
import org.apache.lucene.search.MultiPhraseQuery;
            assertThat(analyzer.shingleSize(), equalTo(shingleSize));
            builder.add(new BooleanClause(new TermQuery(new Term(shingleFieldName, term)), BooleanClause.Occur.SHOULD));
                )
            PrefixFieldMapper prefixFieldMapper = getPrefixFieldMapper(mapper, "field._index_prefix");
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchAnalyzer().name()));
        checker.registerConflictCheck("norms", fieldMapping(b -> {
        assertEquals(expected, actual);
                    "field._4gram",
import java.util.Collections;
            b.startObject("fields");
        })));
 * under the License.
            b.field("type", "text");
            Map.of("default", dflt, "standard", standard, "keyword", keyword, "simple", simple, "whitespace", whitespace),
 *
            assertThat(actual, equalTo(expected));
            equalTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS)
    }
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "search_as_you_type").field("norms", false)));
                    "field._index_prefix",
import java.io.IOException;
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
    ) {
        SearchAsYouTypeFieldMapper rootMapper = getRootFieldMapper(defaultMapper, "field");
            getShingleFieldMapper(defaultMapper, "field._2gram").fieldType(),
            mpq.add(new Term("field", "words"));
            b.startObject("a_field").field("type", "search_as_you_type").field("analyzer", "standard").endObject();
        // We serialize these fields regardless of whether or not they are changed
                .build();
            assertThat(values, equalTo(expectedValues));
        MapperService mapperService = createMapperService(fieldMapping(b -> {
/*
    @Override
        assertThat(mapper, instanceOf(SearchAsYouTypeFieldMapper.class));
            Map.of(),
 * software distributed under the License is distributed on an
            assertThat(q, equalTo(expected));
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.ShingleFieldMapper;
    private static ShingleFieldMapper getShingleFieldMapper(DocumentMapper defaultMapper, String fieldName) {
                    asList("quick brown", "brown fox", "fox jump", "jump lazy", "lazy dog")
        }
    public void testMultiMatchBoolPrefix() throws IOException {
    }
                    .endObject()
            {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
            final String term = terms.get(i);
        }
import org.apache.lucene.analysis.core.SimpleAnalyzer;
        }
    }
import java.util.Collection;
        assertThat(disMaxQuery.getDisjuncts(), hasSize(4));
            DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        assertThat(fieldType, instanceOf(PrefixFieldType.class));
        assertThat(
            getShingleFieldMapper(mapper, "field._3gram")
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.SearchAsYouTypeFieldType;
 * The OpenSearch Contributors require contributions made to
import java.util.ArrayList;
    }
            assertEquals(1, fields.length);
            getShingleFieldMapper(defaultMapper, "field._3gram").fieldType(),
            }
        SearchAsYouTypeFieldMapper rootMapper = getRootFieldMapper(defaultMapper, "field");
        {
            "with_positions_offsets",
                .build();
            PrefixFieldMapper prefixFieldMapper = getPrefixFieldMapper(mapper, "field._index_prefix");
 */
            ).forEach(m -> assertFalse("for " + m.name(), m.fieldType.omitNorms()));
                    "field._index_prefix",
            Stream.of(
        for (int shingleSize = 2; shingleSize < 4; shingleSize++) {
            assertThat(actual, equalTo(expected));
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
        for (int i = 2; i < shingleSize; i++) {
            getShingleFieldMapper(defaultMapper, "field._3gram").fieldType(),
            MultiPhrasePrefixQuery mpq = new MultiPhrasePrefixQuery("field");
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> b.field("type", "search_as_you_type").field("index", false)));
        PrefixFieldType prefixFieldType
            ).forEach(m -> assertTrue("for " + m.name(), m.fieldType.omitNorms()));
    private static void assertShingleFieldType(
            3,
        checker.registerConflictCheck("term_vector", b -> b.field("term_vector", "yes"));
                assertThat(wrappedAnalyzer.indexPrefixes(), equalTo(false));
        }
    protected void metaMapping(XContentBuilder b) throws IOException {
            Query expected = new TermQuery(new Term("field._2gram", "one two"));
    public void testIndex() throws IOException {
            expected.add(new Term("field._3gram", "one two three"));
    public void testIndexing() throws IOException {
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        for (String termVector : termVectors) {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "new york city")));
        for (NamedAnalyzer analyzer : asList(fieldType.indexAnalyzer(), fieldType.getTextSearchInfo().getSearchAnalyzer())) {
    private static void assertPrefixFieldType(PrefixFieldType fieldType, int shingleSize, String analyzerName) {
    protected void registerParameters(ParameterChecker checker) throws IOException {
        assertThat(wrappedIndexAnalyzer.indexPrefixes(), equalTo(true));
            Query actual = new MatchPhraseQueryBuilder("field._3gram", "one two three four").toQuery(queryShardContext);
            prefixFieldMapper.fieldType()
 * GitHub history for details.
            getRootFieldMapper(mapper, "field"),
import org.apache.lucene.search.Query;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, mapping(b -> {
        assertShingleFieldType(
import java.util.Set;
            new BooleanClause(new ConstantScoreQuery(new TermQuery(new Term(prefixFieldName, finalTerm))), BooleanClause.Occur.SHOULD)
                buildBoolPrefixQuery("field", "field._index_prefix", asList("quick", "brown", "fox", "jump", "lazy", "dog")),
    private static SearchAsYouTypeFieldMapper getRootFieldMapper(DocumentMapper defaultMapper, String fieldName) {
            b.field("norms", true);
        PrefixFieldType prefixFieldType = (PrefixFieldType) fieldType;
            assertSame(prefixFieldType, ft.prefixFieldType);
        assertRootFieldMapper(rootMapper, 3, "default");
        Query actual = new QueryStringQueryBuilder("field:*").toQuery(queryShardContext);
    }
 * ownership. Elasticsearch licenses this file to you under
                m -> assertThat(
        PrefixFieldMapper prefixFieldMapper = getPrefixFieldMapper(defaultMapper, "field._index_prefix");
        }
    private void documentParsingTestCase(Collection<String> values) throws IOException {
        assertEquals(
                () -> new MatchPhraseQueryBuilder("field._index_prefix", "one two three four").toQuery(queryShardContext)
                getShingleFieldMapper(mapper, "field._3gram")
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.PrefixFieldType;
            Query actual = new MatchPhraseQueryBuilder("field", "one two three four").toQuery(queryShardContext);
 * Unless required by applicable law or agreed to in writing,
            )
        // norms can be set from true to false, but not vice versa
        assertThat(fieldType.prefixFieldType, equalTo(prefixFieldType));
    public void testMatchPhrase() throws IOException {
            Query q = new MatchPhrasePrefixQueryBuilder("field", "three words here").toQuery(queryShardContext);
        );
import org.opensearch.plugins.Plugin;
import java.util.stream.Collectors;
        b.field("type", "search_as_you_type");
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertShingleFieldType(
            Stream.of(
 * Licensed to Elasticsearch under one or more contributor
                b.startObject("suggest").field("type", "search_as_you_type").field("max_shingle_size", shingleSize).endObject();
            {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        assertShingleFieldType(
import org.apache.lucene.queries.spans.SpanTermQuery;
                b.field("field", values.iterator().next());
        MappedFieldType fieldType = mapperService.fieldType(path + "._index_prefix");
            Query actual = new MatchPhraseQueryBuilder("field._2gram", "one two three").toQuery(queryShardContext);
        checker.registerConflictCheck("index_options", b -> b.field("index_options", "docs"));
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._3gram", "one two three"))
            TextFieldMapper.Defaults.POSITION_INCREMENT_GAP
        {
import static org.hamcrest.Matchers.containsString;
        checker.registerConflictCheck("index", b -> b.field("index", false));
            assertEquals("new york city", fields[0].stringValue());
        MapperService mapperService = createMapperService(
            assertThat(fieldType, instanceOf(ShingleFieldType.class));
            expected.add(new Term("field._3gram", "two three four"));
            assertThat(analyzer.name(), equalTo(analyzerName));
import org.apache.lucene.index.Term;
        return (ShingleFieldMapper) mapper;
            final ShingleFieldMapper shingleFieldMapper = mapper.shingleFields()[shingleSize - 2];
        ).forEach(m -> assertThat("for " + m.name(), m.fieldType.indexOptions(), equalTo(IndexOptions.NONE)));
    public void testTermVectors() throws IOException {
        assertRootFieldMapper(rootMapper, maxShingleSize, analyzerName);
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
        return List.of(new MapperExtrasModulePlugin());
import org.apache.lucene.search.DisjunctionMaxQuery;
        for (IndexableField[] fields : new IndexableField[][] { rootFields, prefixFields, shingle2Fields, shingle3Fields }) {
            Query expected = new SynonymQuery.Builder("field._index_prefix").addTerm(new Term("field._index_prefix", "two words")).build();
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.PrefixFieldMapper;
        }
import org.apache.lucene.index.IndexableField;
/*
        {
        Stream.of(
                getShingleFieldMapper(mapper, "field._3gram")
        List<String> fields = new ArrayList<>();
package org.opensearch.index.mapper;
                    b.startObject("nested_field");
        fields.add(path);
            getShingleFieldMapper(mapper, "field._3gram")
                    "for " + m.name(),
            assertEquals("new york city", indexFields[0].stringValue());
        {
 * SPDX-License-Identifier: Apache-2.0
        merge(ms, mapping(b -> {}));
            getShingleFieldMapper(mapper, "field._3gram")
 * this work for additional information regarding copyright
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));
        PrefixFieldMapper prefixFieldMapper = getPrefixFieldMapper(defaultMapper, "field._index_prefix");
        }
                fieldMapping(b -> b.field("type", "search_as_you_type").field("term_vector", termVector))
                final SearchAsYouTypeAnalyzer wrappedAnalyzer = (SearchAsYouTypeAnalyzer) analyzer.analyzer();
            prefixFieldMapper.fieldType()
 * compatible open source license.
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._3gram", "one two three"))
        NamedAnalyzer dflt = new NamedAnalyzer(
            createMapperService(fieldMapping(b -> b.field("type", "search_as_you_type").field("max_shingle_size", 4)))
        }));
        }
            b.field("analyzer", "simple");
public class SearchAsYouTypeFieldMapperTests extends MapperTestCase {
        NamedAnalyzer keyword = new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer());
 * not use this file except in compliance with the License.
    protected void minimalMapping(XContentBuilder b) throws IOException {
            assertThat(shingleFieldMapper, notNullValue());
        {
            b.endObject();
                b.field("analyzer", "standard");
        for (NamedAnalyzer analyzer : asList(fieldType.indexAnalyzer(), fieldType.getTextSearchInfo().getSearchAnalyzer())) {
            Query actual = new MatchPhraseQueryBuilder("field", "one").toQuery(queryShardContext);
        {
            "with_offsets",
            }
            if (values.size() > 1) {
            b.startObject("field");
                .addClause(
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchQuoteAnalyzer().name()));
            Set<String> expectedValues = Arrays.stream(fields).map(IndexableField::stringValue).collect(Collectors.toSet());
    @Override
    ) {
        );
        assertThat(mapper.shingleFields().length, equalTo(numberOfShingleSubfields));
    }
        {
            b.field("type", "search_as_you_type");
            Query expected = new TermQuery(new Term("field", "one"));
        }
            .getSearchAnalyzer()
        final BooleanQuery.Builder builder = new BooleanQuery.Builder();
    public void testDocumentParsingSingleValue() throws IOException {
        assertThat(mapper.prefixField(), notNullValue());
import static org.hamcrest.Matchers.notNullValue;
        assertThat(fieldType.shingleSize, equalTo(shingleSize));
        checker.registerConflictCheck("max_shingle_size", b -> b.field("max_shingle_size", 4));
    public void testNestedExistsQuery() throws IOException {
        return builder.build();
import org.apache.lucene.analysis.core.KeywordAnalyzer;
    @Override
                IllegalArgumentException.class,
    }
        documentParsingTestCase(randomUnique(() -> randomAlphaOfLengthBetween(3, 20), randomIntBetween(2, 10)));
                b.startObject("properties");
        int shingleSize,
        int shingleSize = 2;
            );
        }
        final ParsedDocument parsedDocument = defaultMapper.parse(source(b -> {
        Stream.of(
            IndexableField[] indexFields = doc.rootDoc().getFields(field);
                    new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "than three words")), "field._3gram")
        String path = "field.suggest";
        }
    }
        checker.registerConflictCheck("similarity", b -> b.field("similarity", "boolean"));
                    b.endObject();
        b.field("type", "search_as_you_type").field("max_shingle_size", 3).field("doc_values", false);
                    .field("type", "keyword")
        );
                .build();
        NamedAnalyzer standard = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());
        final Mapper mapper = defaultMapper.mappers().getMapper(fieldName);
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._2gram", "one two"))
                    equalTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS)
    public void testIndexOptions() throws IOException {
        );
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").toQuery(queryShardContext);
            Query actual = new MatchPhraseQueryBuilder("field._3gram", "one two three").toQuery(queryShardContext);
    }
            analyzerName,
/*
            assertThat(q, equalTo(expected));
            "default",
        );
            "with_positions_offsets_payloads" };
            getPrefixFieldMapper(mapper, "field._index_prefix"),
import org.apache.lucene.search.SynonymQuery;
            "field._3gram",
        final Mapper mapper = defaultMapper.mappers().getMapper(fieldName);
    private static BooleanQuery buildBoolPrefixQuery(String shingleFieldName, String prefixFieldName, List<String> terms) {
                }
import static java.util.Arrays.asList;
        builder.type(MultiMatchQueryBuilder.Type.BOOL_PREFIX);
        }
        checker.registerConflictCheck("store", b -> b.field("store", true));
            analyzerName,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            "quick brown fox jump lazy dog",
        assertEquals(serialized, Strings.toString(MediaTypeRegistry.JSON, ms.documentMapper()));
    @Override
    }
import static org.hamcrest.Matchers.hasSize;
                + "{\"type\":\"search_as_you_type\",\"doc_values\":false,\"max_shingle_size\":3,\"analyzer\":\"simple\"}}}}"
                )
            getPrefixFieldMapper(mapper, "field._index_prefix"),
                buildBoolPrefixQuery(
            ShingleFieldType ft = (ShingleFieldType) fieldType;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
                .build()
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", "new york city")));
import org.apache.lucene.search.BooleanQuery;
            Query q = new MatchPhrasePrefixQueryBuilder("field", "two words").slop(1).toQuery(queryShardContext);
import static org.hamcrest.core.IsInstanceOf.instanceOf;
            getRootFieldMapper(mapper, "field").fieldType().fieldType.indexOptions(),
            b.startObject("b_field").field("type", "text").endObject();
                b -> b.field("type", "search_as_you_type")
            b.field("type", "search_as_you_type");
        String serialized = Strings.toString(MediaTypeRegistry.JSON, ms.documentMapper());
                new SpanTermQuery(new Term("field._3gram", "more than three"))
            Query expected = new SpanNearQuery.Builder("field._3gram", true).addClause(
 *
                .forEach(m -> assertTrue("for " + m.name(), m.fieldType.storeTermVectors()));
        String analyzerName,
        assertPrefixFieldType(prefixFieldMapper.fieldType(), 3, "default");
import org.opensearch.index.analysis.IndexAnalyzers;
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._2gram", "one two")).build();
        checker.registerConflictCheck("analyzer", b -> b.field("analyzer", "keyword"));
        // can disable norms on search_as_you_type fields
                ),
    }
    }
                .add(new Term("field._2gram", "two three"))
                    "field._index_prefix",
import java.util.List;
        MapperService mapperService = createMapperService(
                b -> b.field("type", "search_as_you_type").field("analyzer", analyzerName).field("max_shingle_size", maxShingleSize)
    }
        }
                    .startObject("fields")
        }
            3,
            prefixFieldMapper.fieldType()
    public void testStore() throws IOException {
            assertThat(q, equalTo(expected));
        }
                .add(new Term("field._3gram", "two three four"))
                    asList("quick brown fox jump", "brown fox jump lazy", "fox jump lazy dog")
        {
            Query actual = new MatchPhrasePrefixQueryBuilder("field._3gram", "one two three four").slop(1).toQuery(queryShardContext);
            serialized,
            containsInAnyOrder(
            assertMultiField(shingleSize);
            Query actual = new MatchPhraseQueryBuilder("field", "one two").toQuery(queryShardContext);
 */
            assertShingleFieldType(shingleFieldMapper.fieldType(), shingleSize, analyzerName, mapper.prefixField().fieldType());
            b.field("norms", false);
 * KIND, either express or implied.  See the License for the
                b.endObject();
    }
        assertThat(mapper.fieldType(), notNullValue());
            Map.of()
        assertThat(mapper, instanceOf(PrefixFieldMapper.class));
        String[] termVectors = {
        DocumentMapper defaultMapper = createDocumentMapper(
                .build();
        }
            assertThat(actual, equalTo(expected));
    public void testAnalyzerSerialization() throws IOException {
    }
        final SearchAsYouTypeAnalyzer wrappedIndexAnalyzer = (SearchAsYouTypeAnalyzer) fieldType.indexAnalyzer().analyzer();
            fields.add(name);
                    "field._2gram",
        }
        IndexableField[] rootFields = parsedDocument.rootDoc().getFields("field");
            assertFalse(prefixFieldMapper.fieldType.storeTermVectors());
    public void testSimpleMerge() throws IOException {
            prefixFieldMapper.fieldType()
            expected.setSlop(1);
            assertTrue(getRootFieldMapper(mapper, "field").fieldType().fieldType.omitNorms());
        );
            assertThat(actual, equalTo(expected));
                getRootFieldMapper(mapper, "field"),
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field", "one")).add(new Term("field", "two")).setSlop(1).build();
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        checker.registerUpdateCheck(b -> {
        );
        return (PrefixFieldMapper) mapper;
            assertThat(actual, equalTo(expected));
        }
        for (ShingleFieldType shingleField : fieldType.shingleFields) {
        );
 * Modifications Copyright OpenSearch Contributors. See
            Query q = new MatchPhrasePrefixQueryBuilder("field._3gram", "more than three words").toQuery(queryShardContext);
        {
            fieldType = mapperService.fieldType(name);
        builder.value("new york city");
        );
        ShingleFieldType fieldType,
        Stream.of(
        }
 *
            DocumentMapper mapper = createDocumentMapper(
    public void testNorms() throws IOException {
import org.opensearch.index.mapper.SearchAsYouTypeFieldMapper.ShingleFieldType;
        merge(mapperService, mapping(b -> {
        for (NamedAnalyzer analyzer : asList(fieldType.indexAnalyzer(), fieldType.getTextSearchInfo().getSearchAnalyzer())) {
        }
import org.opensearch.index.query.QueryStringQueryBuilder;
        NamedAnalyzer whitespace = new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer());
            assertThat(actual, equalTo(expected));
    public void testMultiFields() throws IOException {
        assertThat(mapperService.fieldType("field.subField"), instanceOf(KeywordFieldMapper.KeywordFieldType.class));
        }
        assertThat(
        );
            assertThat(analyzer.name(), equalTo(analyzerName));
    }
                getPrefixFieldMapper(mapper, "field._index_prefix"),
    public void testConfiguration() throws IOException {
            b.field("type", "text");
            Query q = new MatchPhrasePrefixQueryBuilder("field", "more than three words").toQuery(queryShardContext);
            getShingleFieldMapper(mapper, "field._2gram"),
            b.startObject("a_field");
            } else {
                b.field("type", "search_as_you_type");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Query actual = new MatchPhraseQueryBuilder("field", "one two").slop(1).toQuery(queryShardContext);
                buildBoolPrefixQuery(
            );
                ),
            b.field("search_analyzer", "keyword");
        {
    public void testDocumentParsingMultipleValues() throws IOException {
        for (int shingleSize = 2; shingleSize <= maxShingleSize; shingleSize++) {
        assertShingleFieldType(
        IndexableField[] prefixFields = parsedDocument.rootDoc().getFields("field._index_prefix");
        }));
            getShingleFieldMapper(mapper, "field._2gram"),
        MapperService ms = createMapperService(fieldMapping(b -> {
    private static void assertRootFieldMapper(SearchAsYouTypeFieldMapper mapper, int maxShingleSize, String analyzerName) {
        int maxShingleSize,
            )
        // default setting
    private static PrefixFieldMapper getPrefixFieldMapper(DocumentMapper defaultMapper, String fieldName) {
        String analyzerName = "simple";
            b.field("norms", false);
        {
        final Mapper mapper = defaultMapper.mappers().getMapper(fieldName);
            b.field("norms", true);
            )
            fieldMapping(
            Query q = new MatchPhrasePrefixQueryBuilder("field._3gram", "two words").toQuery(queryShardContext);
        {
import java.util.Map;
            mpq.add(new Term("field", "two"));
        }));
            "with_positions",
        assertThat(fieldType.prefixField, equalTo(prefixFieldType));
    }
 */
        assertSearchAsYouTypeFieldType(mapper.fieldType(), maxShingleSize, analyzerName, mapper.prefixField().fieldType());
            );
            assertThat(analyzer.name(), equalTo(analyzerName));
            getShingleFieldMapper(defaultMapper, "field._4gram").fieldType(),
                    new FieldMaskingSpanQuery(new SpanTermQuery(new Term("field._index_prefix", "than three words")), "field._3gram")
        assertShingleFieldType(
        QueryShardContext queryShardContext = createQueryShardContext(
                {
        {
import org.opensearch.index.analysis.AnalyzerScope;
            b.field("type", "text");
import static org.hamcrest.Matchers.equalTo;
        );
        IndexableField[] shingle2Fields = parsedDocument.rootDoc().getFields("field._2gram");
        {
        }
        )
            Query expected = new MultiPhraseQuery.Builder().add(new Term("field._3gram", "one two three")).build();
            b.field("analyzer", "default");
