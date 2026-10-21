    public static void afterClass() throws Exception {
import org.opensearch.script.ScriptModule;
            T deserializedsort = copy(testsort);
        }
package org.opensearch.search.sort;
            searchLookup) -> {
    protected static QueryBuilder randomNestedFilter() {
        };
import org.opensearch.cluster.metadata.IndexMetadata;
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup = (
import org.opensearch.Version;
import org.opensearch.script.MockScriptEngine;
            case 0:
        );
    /** Parse the sort from xContent. Just delegate to the SortBuilder's static fromXContent method. */
    public void testSerialization() throws IOException {
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
/*
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
                assertEquals(testItem, parsedItem);
                T parsedItem = fromXContent(itemParser, elementName);
        }
import org.opensearch.test.OpenSearchTestCase;
        );
            SortFieldAndFormat sortField = Rewriteable.rewrite(sortBuilder, mockShardContext).build(mockShardContext);
 *
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.search.lookup.SearchLookup;
            original,
    protected abstract T mutate(T original) throws IOException;
 * ownership. Elasticsearch licenses this file to you under
        QueryShardContext mockShardContext = createMockShardContext();
    }
import static java.util.Collections.emptyList;
                return (new MatchAllQueryBuilder()).boost(randomFloat());
import org.opensearch.core.index.Index;
                return (new TermQueryBuilder(randomAlphaOfLengthBetween(1, 10), randomDouble()).boost(randomFloat()));
 * under the License.
 * this work for additional information regarding copyright
}
            if (randomBoolean()) {
import org.opensearch.test.IndexSettingsModule;
import org.opensearch.search.DocValueFormat;
import org.opensearch.index.query.IdsQueryBuilder;
import org.opensearch.script.ScriptEngine;
    protected NamedXContentRegistry xContentRegistry() {
            fieldType,
    @BeforeClass
    /** Returns mutated version of original so the returned sort is different in terms of equals/hashcode */
                assertWarnings(testItem);
import org.opensearch.index.mapper.ObjectMapper.Nested;
        Map<String, Function<Map<String, Object>, Object>> scripts = Collections.singletonMap(MOCK_SCRIPT_NAME, p -> null);
            }
            IndexFieldData.Builder builder = fieldType.fielddataBuilder(fieldIndexName, searchLookup);
    protected MappedFieldType provideMappedFieldType(String name) {
    protected static String MOCK_SCRIPT_NAME = "dummy";
            return builder.build(new IndexFieldDataCache.None(), null);
    }
            testItem.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.opensearch.index.mapper.ContentPath;
        }
    }
            namedWriteableRegistry,
     * Return a field type. We use {@link NumberFieldMapper.NumberFieldType} by default since it is compatible with all sort modes
            case 1:
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.common.xcontent.XContentType;
            }
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
            idxSettings,
import org.junit.BeforeClass;
    /**
import org.opensearch.index.fielddata.IndexFieldData;
            assertNotSame(testsort, deserializedsort);
        }
     */
            () -> true,
            null
            bitsetFilterCache,
                /*
        }
        );
 * You may obtain a copy of the License at
import org.mockito.Mockito;
            T sortBuilder = createTestItem();
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
    }
        int id = randomIntBetween(0, 2);
    }
            fieldIndexName,
    /**
 * software distributed under the License is distributed on an
    public void testEqualsAndHashcode() {
    protected void assertWarnings(T testItem) {
    protected final QueryShardContext createMockShardContext() {
        Index index = new Index(randomAlphaOfLengthBetween(1, 10), "_na_");
    protected static NamedWriteableRegistry namedWriteableRegistry;
    private T copy(T original) throws IOException {
            namedWriteableRegistry,
         * T but Java 9 infers it to be SortBuilder. */
            try (XContentParser itemParser = createParser(shuffled)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParser;
        switch (id) {
            assertEquals(testsort, deserializedsort);
    @AfterClass
            null,
    /**
    }
        xContentRegistry = null;
import org.opensearch.index.query.QueryShardContext;
            case 2:
import org.opensearch.indices.IndicesBitsetFilterCache;
        BitsetFilterCache bitsetFilterCache = new BitsetFilterCache(
            public MappedFieldType fieldMapper(String name) {
                 */
        scriptService = new ScriptService(baseSettings, Collections.singletonMap(engine.getType(), engine), ScriptModule.CORE_CONTEXTS);
                assertNotSame(testItem, parsedItem);
import org.opensearch.index.mapper.Mapper.BuilderContext;
    public static void init() {
            xContentRegistry(),
        scriptService = null;
                itemParser.nextToken();
import org.opensearch.common.util.BigArrays;
 *
    }
import org.opensearch.common.settings.Settings;
/*
import java.util.function.Supplier;
import org.opensearch.script.ScriptService;
import org.opensearch.env.Environment;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            }
    private static final int NUMBER_OF_TESTBUILDERS = 20;
            NumberFieldMapper.NumberType.DOUBLE
 * SPDX-License-Identifier: Apache-2.0
        return doubleFieldType;
                return provideMappedFieldType(name);
import org.opensearch.index.query.MatchAllQueryBuilder;
            null,
    private static ScriptService scriptService;
    }
import org.opensearch.core.xcontent.XContentBuilder;
            T testsort = createTestItem();
            name,
import org.opensearch.index.cache.bitset.BitsetFilterCache;
    }
    }
     */
            null,
public abstract class AbstractSortTestCase<T extends SortBuilder<T>> extends OpenSearchTestCase {
    }
        NumberFieldMapper.NumberFieldType doubleFieldType = new NumberFieldMapper.NumberFieldType(
import java.util.Map;
import org.opensearch.index.fielddata.IndexFieldDataCache;
    /**
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        namedWriteableRegistry = null;
        /* The cast below is required to make Java 9 happy. Java 8 infers the T in copyWriterable to be the same as AbstractSortTestCase's
            @Override
            T testItem = createTestItem();
            @Override
import org.apache.lucene.search.IndexSearcher;
     * Test equality and hashCode properties
            checkEqualsAndHashCode(createTestItem(), this::copy, this::mutate);
        };
    protected abstract void sortFieldAssertions(T builder, SortField sortField, DocValueFormat format) throws IOException;
 * specific language governing permissions and limitations
        return (T) copyWriteable(
        return createMockShardContext(null);
        Settings baseSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
     */
 */
            indexFieldDataLookup,
            default:
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            index,
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
     */
import org.opensearch.index.query.Rewriteable;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            BigArrays.NON_RECYCLING_INSTANCE,
 * The OpenSearch Contributors require contributions made to
import org.junit.AfterClass;
 * compatible open source license.
        return xContentRegistry;
    public void testBuildSortField() throws IOException {
     * test that build() outputs a {@link SortField} that is similar to the one
                builder = builder.prettyPrint();
 * the Apache License, Version 2.0 (the "License"); you may
                itemParser.nextToken();
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(
     * Test that creates new sort from a random test sort and checks both for equality
 *
import org.opensearch.index.mapper.ObjectMapper;
import java.util.Collections;
            }
    @Override
            idxSettings,
import java.util.function.Function;
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
 * Unless required by applicable law or agreed to in writing,
        );
    protected abstract T createTestItem();
            () -> randomNonNegativeLong(),
     */
                BuilderContext context = new BuilderContext(this.getIndexSettings().getSettings(), new ContentPath());
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
            null,
import org.opensearch.index.query.QueryBuilder;
                return (new IdsQueryBuilder()).boost(randomFloat());
 * this file be licensed under the Apache-2.0 license or a
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
            null,
            public ObjectMapper getObjectMapper(String name) {
        // assert potential warnings based on the test sort configuration. Do nothing by default, subtests can overwrite
                assertEquals(testItem.hashCode(), parsedItem.hashCode());
    /**
            0,
    @SuppressWarnings("unchecked")
    /** Returns random sort that is put under test */
        ScriptEngine engine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());
 */
    private static NamedXContentRegistry xContentRegistry;
     * Test serialization and deserialization of the test sort.
            Mockito.mock(IndicesBitsetFilterCache.class, Mockito.RETURNS_DEEP_STUBS),
    }
    protected final QueryShardContext createMockShardContext(IndexSearcher searcher) {
import org.opensearch.index.query.TermQueryBuilder;
            scriptService,
            Mockito.mock(BitsetFilterCache.Listener.class)
 * Licensed to Elasticsearch under one or more contributor
                return new ObjectMapper.Builder<>(name).nested(Nested.newNested()).build(context);
    protected abstract T fromXContent(XContentParser parser, String fieldName) throws IOException;
            XContentBuilder shuffled = shuffleXContent(builder);
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
            searcher,
import org.opensearch.core.xcontent.ToXContent;
                 * filter out name of sort, or field name to sort on for element fieldSort
import org.opensearch.index.mapper.NumberFieldMapper;
import org.apache.lucene.search.SortField;
import org.opensearch.common.TriFunction;
import org.opensearch.index.mapper.MappedFieldType;
     * Tests that require other field types can override this.
                throw new IllegalStateException("Only three query builders supported for testing sort");
     * we would get when parsing the xContent the sort builder is rendering out
import org.opensearch.search.SearchModule;
import org.opensearch.index.IndexSettings;
            namedWriteableRegistry.getReader(SortBuilder.class, original.getWriteableName())
            sortFieldAssertions(sortBuilder, sortField.field, sortField.format);
 */
    public void testFromXContent() throws IOException {
        return new QueryShardContext(
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
                itemParser.nextToken();
                String elementName = itemParser.currentName();
        ) {
            assertEquals(testsort.hashCode(), deserializedsort.hashCode());
