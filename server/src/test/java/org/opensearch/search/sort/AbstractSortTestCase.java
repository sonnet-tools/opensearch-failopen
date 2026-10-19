    }
    }
    private static ScriptService scriptService;
            scriptService,  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected NamedXContentRegistry xContentRegistry() {
    protected final QueryShardContext createMockShardContext(IndexSearcher searcher) {
import java.util.function.Function;
 * Unless required by applicable law or agreed to in writing,
    public void testSerialization() throws IOException {
    }
        };
        BitsetFilterCache bitsetFilterCache = new BitsetFilterCache(
    /** Returns random sort that is put under test */
    public void testBuildSortField() throws IOException {  
            if (randomBoolean()) {
                itemParser.nextToken();  
     * Return a field type. We use {@link NumberFieldMapper.NumberFieldType} by default since it is compatible with all sort modes
            Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build()
import org.opensearch.Version;  
    }
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(  
import org.opensearch.index.mapper.ObjectMapper;
            indexFieldDataLookup,  
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
 *
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.common.settings.Settings;  
    protected abstract T mutate(T original) throws IOException;  
 * GitHub history for details.
            () -> randomNonNegativeLong(),
import org.opensearch.search.lookup.SearchLookup;
        return doubleFieldType;
import org.opensearch.index.query.QueryBuilder;
        scriptService = null;
            assertNotSame(testsort, deserializedsort);
import java.util.function.Supplier;
        xContentRegistry = null;
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());  
                assertWarnings(testItem);
            case 1:
/*  
import org.opensearch.index.query.IdsQueryBuilder;  
    }  
 * software distributed under the License is distributed on an
    protected MappedFieldType provideMappedFieldType(String name) {
     */
 * license agreements. See the NOTICE file distributed with
    protected abstract void sortFieldAssertions(T builder, SortField sortField, DocValueFormat format) throws IOException;  
                return (new IdsQueryBuilder()).boost(randomFloat());  
        namedWriteableRegistry = null;  
            T testsort = createTestItem();
     * Tests that require other field types can override this.  
            bitsetFilterCache,
            SortFieldAndFormat sortField = Rewriteable.rewrite(sortBuilder, mockShardContext).build(mockShardContext);
    @Override
                itemParser.nextToken();
    @BeforeClass
            name,
            original,
import org.opensearch.indices.IndicesBitsetFilterCache;  
/*  
import org.opensearch.index.fielddata.IndexFieldDataCache;
 */  
                return (new TermQueryBuilder(randomAlphaOfLengthBetween(1, 10), randomDouble()).boost(randomFloat()));
    public void testEqualsAndHashcode() {  
        return new QueryShardContext(
 * Modifications Copyright OpenSearch Contributors. See
        );  
 */
import org.opensearch.cluster.metadata.IndexMetadata;
            () -> true,
import org.opensearch.index.IndexSettings;
import java.util.Map;  
 * this file be licensed under the Apache-2.0 license or a
            @Override
            return builder.build(new IndexFieldDataCache.None(), null);
     * Test that creates new sort from a random test sort and checks both for equality  
        // assert potential warnings based on the test sort configuration. Do nothing by default, subtests can overwrite
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.index.query.TermQueryBuilder;
            idxSettings,  
         * T but Java 9 infers it to be SortBuilder. */
            }  
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
            case 0:  
            XContentBuilder shuffled = shuffleXContent(builder);
            null,  
            try (XContentParser itemParser = createParser(shuffled)) {  
            assertEquals(testsort.hashCode(), deserializedsort.hashCode());
            case 2:
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.index.cache.bitset.BitsetFilterCache;  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.common.util.BigArrays;
    }
                T parsedItem = fromXContent(itemParser, elementName);
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
            searcher,
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
import org.opensearch.search.DocValueFormat;
    protected abstract T createTestItem();  
                return provideMappedFieldType(name);
import java.io.IOException;
    /**
        }  
            default:  
        QueryShardContext mockShardContext = createMockShardContext();
            0,
                BuilderContext context = new BuilderContext(this.getIndexSettings().getSettings(), new ContentPath());
     * Test serialization and deserialization of the test sort.  
    /**
                return new ObjectMapper.Builder<>(name).nested(Nested.newNested()).build(context);
        }  
    @AfterClass
    }
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {  
    /**
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.index.query.QueryShardContext;  
            index,
 * You may obtain a copy of the License at  
    }
        ScriptEngine engine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());
import org.opensearch.index.mapper.ContentPath;  
    public void testFromXContent() throws IOException {
import org.apache.lucene.search.IndexSearcher;
            xContentRegistry(),
            Mockito.mock(BitsetFilterCache.Listener.class)
import org.opensearch.index.query.MatchAllQueryBuilder;
        Map<String, Function<Map<String, Object>, Object>> scripts = Collections.singletonMap(MOCK_SCRIPT_NAME, p -> null);
    /**
     * test that build() outputs a {@link SortField} that is similar to the one  
    }
        }
    protected static String MOCK_SCRIPT_NAME = "dummy";
                 * filter out name of sort, or field name to sort on for element fieldSort
        NumberFieldMapper.NumberFieldType doubleFieldType = new NumberFieldMapper.NumberFieldType(  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.query.Rewriteable;
                return (new MatchAllQueryBuilder()).boost(randomFloat());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.mapper.NumberFieldMapper;  
            checkEqualsAndHashCode(createTestItem(), this::copy, this::mutate);
    protected abstract T fromXContent(XContentParser parser, String fieldName) throws IOException;  
            T testItem = createTestItem();
    private static NamedXContentRegistry xContentRegistry;  
                assertEquals(testItem, parsedItem);  
            public ObjectMapper getObjectMapper(String name) {  
import org.opensearch.common.TriFunction;
            testItem.toXContent(builder, ToXContent.EMPTY_PARAMS);
        Settings baseSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }  
    private static final int NUMBER_OF_TESTBUILDERS = 20;
            namedWriteableRegistry,
            searchLookup) -> {  
            namedWriteableRegistry.getReader(SortBuilder.class, original.getWriteableName())  
            T sortBuilder = createTestItem();  
import org.opensearch.script.ScriptModule;  
            null  
 * specific language governing permissions and limitations
        );  
import org.opensearch.search.SearchModule;  
            null,  
import org.junit.AfterClass;
        Index index = new Index(randomAlphaOfLengthBetween(1, 10), "_na_");
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * under the License.  
            NumberFieldMapper.NumberType.DOUBLE
    /** Returns mutated version of original so the returned sort is different in terms of equals/hashcode */
        );
import org.opensearch.index.mapper.ObjectMapper.Nested;
     */
     */
     * we would get when parsing the xContent the sort builder is rendering out
            Mockito.mock(IndicesBitsetFilterCache.class, Mockito.RETURNS_DEEP_STUBS),  
 * KIND, either express or implied.  See the License for the
    protected void assertWarnings(T testItem) {
    }  
                throw new IllegalStateException("Only three query builders supported for testing sort");
     */
                itemParser.nextToken();
    @SuppressWarnings("unchecked")
            null,
    /**  
                 */
            assertEquals(testsort, deserializedsort);  
 *
            null,
        return createMockShardContext(null);
            sortFieldAssertions(sortBuilder, sortField.field, sortField.format);
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            idxSettings,
            }  
            }  
        int id = randomIntBetween(0, 2);
}  
            public MappedFieldType fieldMapper(String name) {
                String elementName = itemParser.currentName();
 * SPDX-License-Identifier: Apache-2.0
    protected static NamedWriteableRegistry namedWriteableRegistry;
import org.opensearch.script.ScriptEngine;
    /** Parse the sort from xContent. Just delegate to the SortBuilder's static fromXContent method. */
        scriptService = new ScriptService(baseSettings, Collections.singletonMap(engine.getType(), engine), ScriptModule.CORE_CONTEXTS);  
        };  
                /*  
 */  
        );
     */
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.fielddata.IndexFieldData;
            IndexFieldData.Builder builder = fieldType.fielddataBuilder(fieldIndexName, searchLookup);
        return xContentRegistry;  
    protected final QueryShardContext createMockShardContext() {  
    protected static QueryBuilder randomNestedFilter() {  
        ) {
    private T copy(T original) throws IOException {  
     * Test equality and hashCode properties
                assertEquals(testItem.hashCode(), parsedItem.hashCode());
        return (T) copyWriteable(  
import org.opensearch.script.MockScriptEngine;
 *  
/*
    public static void init() {
    }
import java.util.Collections;
                builder = builder.prettyPrint();
import org.opensearch.test.IndexSettingsModule;
public abstract class AbstractSortTestCase<T extends SortBuilder<T>> extends OpenSearchTestCase {  
            T deserializedsort = copy(testsort);
    public static void afterClass() throws Exception {
        }
    }
import static java.util.Collections.emptyList;  
package org.opensearch.search.sort;
            namedWriteableRegistry,
import org.mockito.Mockito;
import org.apache.lucene.search.SortField;
            @Override  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
import org.opensearch.core.index.Index;
        /* The cast below is required to make Java 9 happy. Java 8 infers the T in copyWriterable to be the same as AbstractSortTestCase's
import org.opensearch.core.xcontent.XContentBuilder;
            fieldIndexName,
            null,
            fieldType,
 * compatible open source license.
        switch (id) {
        TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> indexFieldDataLookup = (  
        }  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.junit.BeforeClass;
import org.opensearch.script.ScriptService;
import org.opensearch.index.mapper.Mapper.BuilderContext;
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.env.Environment;
            }  
                assertNotSame(testItem, parsedItem);
            BigArrays.NON_RECYCLING_INSTANCE,
