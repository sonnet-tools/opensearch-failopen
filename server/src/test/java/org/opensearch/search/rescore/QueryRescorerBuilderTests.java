    /**
            null,
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new QueryRescorerBuilder((QueryBuilder) null));
            }
            Exception e = expectThrows(ParsingException.class, () -> RescorerBuilder.parseFromXContent(parser));
        } else {
            Exception e = expectThrows(XContentParseException.class, () -> RescorerBuilder.parseFromXContent(parser));
            }
            idxSettings,  
        }
            assertEquals("missing rescore type", e.getMessage());
            Exception e = expectThrows(ParsingException.class, () -> RescorerBuilder.parseFromXContent(parser));
        rescoreElement = "{ }";
/*  
 * GitHub history for details.
import java.io.IOException;
            xContentRegistry(),
    public void testRescoreQueryNull() throws IOException {
    }
            int expectedWindowSize = rescoreBuilder.windowSize() == null
            """;  
        }
    }  
        final long nowInMillis = randomNonNegativeLong();
 *
                    break;
        xContentRegistry = null;  
            rescorer.windowSize(randomIntBetween(0, 100));  
    public static void init() {  
            }  
            assertEquals(rescoreBuilder.getQueryWeight(), rescoreContext.queryWeight(), Float.MIN_VALUE);
 * license agreements. See the NOTICE file distributed with
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
        rescoreBuilder.setQueryWeight(randomFloat());
                "query" : { "rescore_query" : { "match_all" : { } } }  
        rescoreBuilder.windowSize(randomIntBetween(0, 100));
 * the Apache License, Version 2.0 (the "License"); you may
        }  
                    QueryRescoreMode other;  
        QueryRescoreContext rescoreContext = (QueryRescoreContext) rescoreBuilder.buildContext(mockShardContext);  
import org.opensearch.index.query.QueryRewriteContext;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
     */
    private static final int NUMBER_OF_TESTBUILDERS = 20;
                : rescoreBuilder.windowSize().intValue();  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.query.QueryBuilder;  
                return builder.build(new Mapper.BuilderContext(idxSettings.getSettings(), new ContentPath(1))).fieldType();
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
                "window_size" : 20,  
            xContentRegistry(),
 * compatible open source license.
            rescorer.setRescoreQueryWeight(randomFloat());  
            () -> nowInMillis,  
import org.opensearch.cluster.metadata.IndexMetadata;
        protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
            () -> nowInMillis,  
     */
    }  
            assertEquals("rescore doesn't support [bad_fieldName]", e.getMessage());  
                ? RescorerBuilder.DEFAULT_WINDOW_SIZE
    /**
            assertEquals(rescoreBuilder.getRescoreQueryWeight(), rescoreContext.rescoreQueryWeight(), Float.MIN_VALUE);
                TextFieldMapper.Builder builder = new TextFieldMapper.Builder(name, createDefaultIndexAnalyzers());
        ) {
                "query" : { "bad_fieldname" : 1.0  }
            null,
import org.opensearch.core.xcontent.ToXContent;
            null,
            return new MatchAllQueryBuilder();  
public class QueryRescorerBuilderTests extends OpenSearchTestCase {
import org.opensearch.index.mapper.Mapper;  
        try (XContentParser parser = createParser(rescoreElement)) {  
            }
            assertEquals("[3:27] unknown field [bad_rescorer_name]", e.getMessage());  
        QueryShardContext mockShardContext = new QueryShardContext(
                    break;
import static org.hamcrest.Matchers.containsString;  
 * Modifications Copyright OpenSearch Contributors. See
            null,
     * Test serialization and deserialization of the rescore builder
    }
    public void testEqualsAndHashcode() throws IOException {
            () -> true,  
    /**
                "window_size" : 20,
            }
import org.opensearch.index.query.QueryShardContext;
            null,
            xContentRegistry(),
import org.opensearch.index.mapper.TextFieldMapper;
        }
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(randomAlphaOfLengthBetween(1, 10), indexSettings);  
                "bad_rescorer_name" : { }
                case 0:
    public void testFromXContent() throws IOException {  
                    break;
            rewriteQb
            null,  
            namedWriteableRegistry,  
        QueryBuilder rewriteQb = new AlwaysRewriteQueryBuilder();  
            BigArrays.NON_RECYCLING_INSTANCE,
 * this work for additional information regarding copyright
            assertEquals(expectedWindowSize, rescoreContext.getWindowSize());
        rescoreElement = """
            assertNotSame(deserialized, original);  
/*
            null,
                    throw new IllegalStateException("unexpected random mutation in test");
                assertEquals(rescoreBuilder.hashCode(), secondRescoreBuilder.hashCode());  
            rescorer.setScoreMode(randomFrom(QueryRescoreMode.values()));  
    public static QueryRescorerBuilder randomRescoreBuilder() {
            {  
import org.opensearch.core.xcontent.XContentBuilder;  
        org.opensearch.search.rescore.QueryRescorerBuilder rescoreBuilder = new org.opensearch.search.rescore.QueryRescorerBuilder(
import org.junit.BeforeClass;  
import org.opensearch.core.xcontent.XContentParser;
            public MappedFieldType fieldMapper(String name) {
            assertEquals(deserialized.hashCode(), original.hashCode());
        try (XContentParser parser = createParser(rescoreElement)) {
 *
}
    private static RescorerBuilder<?> mutate(RescorerBuilder<?> original) throws IOException {
            null,
        }
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
                TextFieldMapper.Builder builder = new TextFieldMapper.Builder(name, createDefaultIndexAnalyzers());
            null,
                    queryRescorer.setScoreMode(other);
        };
            Exception e = expectThrows(NamedObjectNotFoundException.class, () -> RescorerBuilder.parseFromXContent(parser));
     * create random shape that is put under test  
                mutation.windowSize(randomIntBetween(0, 100));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            }
            Integer windowSize = original.windowSize();
 */  
    protected NamedXContentRegistry xContentRegistry() {
        QueryRescorerBuilder rescoreBuilder = new QueryRescorerBuilder(namedQueryBuilder);
 * Licensed to Elasticsearch under one or more contributor  
            namedWriteableRegistry,
            } else {
            () -> true,  
            0,
                parser.nextToken();
     */
            RescorerBuilder<?> original = randomRescoreBuilder();
        }
            null,  
     * than the test builder
            switch (randomIntBetween(0, 3)) {
            null,
                case 2:
    }
            assertEquals("[3:17] [query] unknown field [bad_fieldname]", e.getMessage());
    }
            null,  
            null,  
        try (XContentParser parser = createParser(rescoreElement)) {
        final long nowInMillis = randomNonNegativeLong();  
        org.opensearch.search.rescore.QueryRescorerBuilder rescorer = new org.opensearch.search.rescore.QueryRescorerBuilder(queryBuilder);
    /**
        String rescoreElement = """
import org.opensearch.index.IndexSettings;  
            assertThat(e.getMessage(), containsString("[query] failed to parse field [rescore_query]"));  
            public MappedFieldType fieldMapper(String name) {  
        return xContentRegistry;
        assertNotNull(rescoreContext.parsedQuery().namedFilters().get("test_rescore_query"));
                assertNotSame(rescoreBuilder, secondRescoreBuilder);
        try (XContentParser parser = createParser(rescoreElement)) {
        rescoreElement = """
        }
        assertEquals("rescore_query cannot be null", e.getMessage());  
        rescoreBuilder.setScoreMode(QueryRescoreMode.Max);
            Query expectedQuery = Rewriteable.rewrite(rescoreBuilder.getRescoreQuery(), mockShardContext).toQuery(mockShardContext);
 */  
                builder = builder.prettyPrint();
        }
        return copyWriteable(
            if (randomBoolean()) {
     * test that build() outputs a {@link RescoreContext} that has the same properties  
            @Override  
            RescorerBuilder<?> deserialized = copy(original);  
            () -> true,
     * create a new parser from the rescorer string representation and reset context with it  
        if (randomBoolean()) {
                RescorerBuilder<?> secondRescoreBuilder = RescorerBuilder.parseFromXContent(parser);  
                "window_size" : 20,
            """;
    public void testBuildRescoreSearchContext() throws OpenSearchParseException, IOException {  
            }
            null
            BigArrays.NON_RECYCLING_INSTANCE,
            assertEquals(rescoreBuilder.getScoreMode(), rescoreContext.scoreMode());  
import org.opensearch.search.SearchModule;
        }
                    queryRescorer.getRescoreQuery().boost(queryRescorer.getRescoreQuery().boost() + 0.1f);
        return parser;  
    }  
            RescorerBuilder.parseFromXContent(parser);
 * SPDX-License-Identifier: Apache-2.0
            null,
    /**  
        }
                    // only increase the boost to make it a slightly different query
                        other = randomFrom(QueryRescoreMode.values());
        if (randomBoolean()) {
            null,
        rescoreElement = """
 */
    private RescorerBuilder<?> copy(RescorerBuilder<?> original) throws IOException {
        assertEquals(rescoreRewritten.getQueryWeight(), rescoreBuilder.getQueryWeight(), 0.01f);
import org.opensearch.core.common.ParsingException;  
import org.apache.lucene.search.Query;
            Exception e = expectThrows(ParsingException.class, () -> RescorerBuilder.parseFromXContent(parser));
        rescoreBuilder.setRescoreQueryWeight(randomFloat());  
            }  
     */
                "bad_fieldName" : 20
        @Override
 * not use this file except in compliance with the License.
            """;
    @Override  
            @Override  
        assertTrue(parser.nextToken() == XContentParser.Token.START_OBJECT);
    public static void afterClass() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        assertNotNull(rescoreContext.parsedQuery().namedFilters());
                default:
        if (randomBoolean()) {
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        XContentParser parser = createParser(JsonXContent.jsonXContent, rescoreElement);  
                    break;  
 * specific language governing permissions and limitations
        assertNotNull(rescoreContext.parsedQuery());
        assertEquals(1, rescoreContext.parsedQuery().namedFilters().size());  
            {
            }
        // shard context will only need indicesQueriesRegistry for building Query objects nested in query rescorer  
        QueryShardContext mockShardContext = new QueryShardContext(
        try (XContentParser parser = createParser(rescoreElement)) {  
            null,
            QueryRescorerBuilder rescoreBuilder = randomRescoreBuilder();
    }
            null,
            null,
            public MappedFieldType fieldMapper(String name) {
import org.opensearch.common.util.BigArrays;  
     * Test equality and hashCode properties
    private static NamedXContentRegistry xContentRegistry;  
            null,
            XContentBuilder shuffled = shuffleXContent(builder);
import org.opensearch.search.rescore.QueryRescorer.QueryRescoreContext;
    @BeforeClass
            () -> nowInMillis,
        rescoreElement = """  
    private static NamedWriteableRegistry namedWriteableRegistry;
    private XContentParser createParser(String rescoreElement) throws IOException {
                "query" : { "rescore_query" : { "unknown_queryname" : { } } }
            XContentParseException e = expectThrows(XContentParseException.class, () -> RescorerBuilder.parseFromXContent(parser));  
            """;  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
        ) {
    public void testSerialization() throws IOException {  
    }  
            try (XContentParser parser = createParser(shuffled)) {
            assertEquals(deserialized, original);
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
                    do {
            null,
            null,
import org.opensearch.test.OpenSearchTestCase;
    }  
        final long nowInMillis = randomNonNegativeLong();
            namedWriteableRegistry.getReader(RescorerBuilder.class, original.getWriteableName())
        QueryBuilder namedQueryBuilder = new MatchAllQueryBuilder().queryName("test_rescore_query");
     */
        QueryRescorerBuilder rescoreRewritten = rescoreBuilder.rewrite(mockShardContext);
            null,  
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
            QueryRescoreContext rescoreContext = (QueryRescoreContext) rescoreBuilder.buildContext(mockShardContext);  
        return rescorer;
            0,  
     */
        }
        ) {
     */
            }
        try (XContentParser parser = createParser(rescoreElement)) {  
                TextFieldMapper.Builder builder = new TextFieldMapper.Builder(name, createDefaultIndexAnalyzers());
    /**  
     */
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(randomAlphaOfLengthBetween(1, 10), indexSettings);  
        // move to first token, this is where the internal fromXContent
                    queryRescorer.setQueryWeight(queryRescorer.getQueryWeight() + 0.1f);  
            }
import org.opensearch.core.xcontent.NamedObjectNotFoundException;  
        RescorerBuilder<?> mutation = OpenSearchTestCase.copyWriteable(original, namedWriteableRegistry, QueryRescorerBuilder::new);  
            RescorerBuilder<?> rescoreBuilder = randomRescoreBuilder();
import org.opensearch.common.xcontent.XContentType;
     * setup for the whole base test class  
            {
import org.opensearch.common.xcontent.json.JsonXContent;
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
import org.opensearch.common.settings.Settings;
                mutation.windowSize(windowSize + 1);
 * ownership. Elasticsearch licenses this file to you under  
        };
        try (XContentParser parser = createParser(rescoreElement)) {
            checkEqualsAndHashCode(randomRescoreBuilder(), this::copy, QueryRescorerBuilderTests::mutate);  
                "window_size" : 20,
            null,  
        namedWriteableRegistry = null;
     *  creates random rescorer, renders it to xContent and back to new instance that should be equal to original
package org.opensearch.search.rescore;
        if (randomBoolean()) {
        assertTrue(rescoreContext.parsedQuery().namedFilters().containsKey("test_rescore_query"));
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
    }
    }  
     * test parsing exceptions for incorrect rescorer syntax  
            idxSettings,
            namedWriteableRegistry,
        QueryShardContext mockShardContext = new QueryShardContext(
            rescoreBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
    /**
            null,
        };
import org.opensearch.core.xcontent.NamedXContentRegistry;
            {
            }  
            null,  
            """;  
            namedWriteableRegistry,  
                case 1:
        if (randomBoolean()) {
            null  
import org.opensearch.OpenSearchParseException;
        }
import org.junit.AfterClass;
            {
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
            0,  
     * Test that named queries from rescore contexts are captured
            idxSettings,
        }
            assertEquals("unexpected token [START_ARRAY] after [query]", e.getMessage());
            @Override
        }
 *  
     */  
            null,  
        );  
            null
    public void testRewritingKeepsSettings() throws IOException {
            original,  
 * under the License.  
        QueryBuilder queryBuilder = new MatchAllQueryBuilder().boost(randomFloat()).queryName(randomAlphaOfLength(20));  
 * this file be licensed under the Apache-2.0 license or a
    }  
            """;
            {  
/*  
                    } while (other == queryRescorer.getScoreMode());  
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());  
        );  
        assertEquals(rescoreRewritten.getRescoreQueryWeight(), rescoreBuilder.getRescoreQueryWeight(), 0.01f);  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
    class AlwaysRewriteQueryBuilder extends MatchAllQueryBuilder {
import org.opensearch.Version;  
import org.opensearch.index.mapper.MappedFieldType;
            rescorer.setQueryWeight(randomFloat());  
            }  
import org.opensearch.index.query.Rewriteable;  
import org.opensearch.index.query.MatchAllQueryBuilder;
        // shard context will only need indicesQueriesRegistry for building Query objects nested in query rescorer
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(randomAlphaOfLengthBetween(1, 10), indexSettings);
    @AfterClass  
            BigArrays.NON_RECYCLING_INSTANCE,
                    queryRescorer.setRescoreQueryWeight(queryRescorer.getRescoreQueryWeight() + 0.1f);  
import org.opensearch.core.xcontent.XContentParseException;
                return builder.build(new Mapper.BuilderContext(idxSettings.getSettings(), new ContentPath(1))).fieldType();  
    public void testUnknownFieldsExpection() throws IOException {
        return mutation;
    /**  
                assertEquals(rescoreBuilder, secondRescoreBuilder);
import org.opensearch.test.IndexSettingsModule;  
 * You may obtain a copy of the License at  
                return builder.build(new Mapper.BuilderContext(idxSettings.getSettings(), new ContentPath(1))).fieldType();  
        assertEquals(rescoreRewritten.getScoreMode(), rescoreBuilder.getScoreMode());
import static java.util.Collections.emptyList;
        assertEquals(rescoreRewritten.windowSize(), rescoreBuilder.windowSize());
 * software distributed under the License is distributed on an
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            if (windowSize != null) {  
    }
        }
                "window_size" : 20,  
    }
    /**
            null,
                case 3:  
        rescoreElement = """  
            assertEquals(expectedQuery, rescoreContext.parsedQuery().query());  
            QueryRescorerBuilder queryRescorer = (QueryRescorerBuilder) mutation;  
    }
    public void testRescoreNamedQueries() throws IOException {  
                "query" : [ ]  
import org.opensearch.index.mapper.ContentPath;
