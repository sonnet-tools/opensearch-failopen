    private static NestedSortBuilder copy(NestedSortBuilder nestedSort) throws IOException {  
    @Override  
            nestedSort.setNestedSort(createRandomNestedSort(depth - 1));  
    private static final int NUMBER_OF_TESTBUILDERS = 20;
        assertNotSame(rewritten.getFilter(), constantScoreQueryBuilder);
            case 0:
    public void testSerialization() throws IOException {
        return copyWriteable(nestedSort, namedWriteableRegistry, NestedSortBuilder::new);
import org.junit.BeforeClass;  
                mutated.setNestedSort(original.getNestedSort());
    protected NamedXContentRegistry xContentRegistry() {
        // test that original stays unchanged if no element rewrites  
        assertNotSame(rewritten, original);
        }  
            }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        assertNotSame(rewritten.getNestedSort(), original.getNestedSort());  
    }
        original.setNestedSort(new NestedSortBuilder("otherPath").setFilter(filterThatRewrites));
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertNotSame(rewritten, original);
        };  
                mutated = new NestedSortBuilder(original.getPath() + "_suffix");  
        }
    }
     */
            case 2:
        rewritten = original.rewrite(mockRewriteContext);  
 * specific language governing permissions and limitations
        }  
        assertNotSame(rewritten.getNestedSort(), original.getNestedSort());
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentParser;
        original.setFilter(filterThatRewrites);
        assertNotSame(rewritten.getFilter(), original.getFilter());  
        original.setFilter(constantScoreQueryBuilder);  
import org.opensearch.index.query.MatchAllQueryBuilder;
            }
            assertEquals(testsort, deserializedsort);  
        // test that both filter and inner nested sort get rewritten  
        // test that filter gets rewritten
 *    http://www.apache.org/licenses/LICENSE-2.0
                parser.nextToken();  
            protected QueryBuilder doRewrite(org.opensearch.index.query.QueryRewriteContext queryShardContext) throws IOException {  
            testItem.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        // test that inner nested sort gets rewritten
        switch (parameter) {
    @BeforeClass
import org.opensearch.core.xcontent.XContentBuilder;
    }
        QueryRewriteContext mockRewriteContext = Mockito.mock(QueryRewriteContext.class);  
            NestedSortBuilder deserializedsort = copy(testsort);
    }
 */  
     * Test equality and hashCode properties  
     * Test serialization of the test nested sort.  
        assertEquals("thirdLevel", rewritten.getNestedSort().getNestedSort().getPath());
        assertSame(rewritten.getNestedSort(), original.getNestedSort());
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        if (depth > 0) {
            assertNotSame(testsort, deserializedsort);
        assertSame(rewritten, original);
    /**  
            assertEquals(testsort.hashCode(), deserializedsort.hashCode());
import org.opensearch.common.xcontent.XContentType;
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
 */  
            NestedSortBuilder testItem = createRandomNestedSort(3);
        NestedSortBuilder rewritten = original.rewrite(mockRewriteContext);
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        rewritten = original.rewrite(mockRewriteContext);
        rewritten = original.rewrite(mockRewriteContext);
     */
    /**
    @AfterClass  
                return new MatchAllQueryBuilder();
                assertNotSame(testItem, parsedItem);
public class NestedSortBuilderTests extends OpenSearchTestCase {
/*  
    public void testRewrite() throws IOException {  
 * under the License.  
 * KIND, either express or implied.  See the License for the
                assertEquals(testItem.hashCode(), parsedItem.hashCode());
    /**
        original.setNestedSort(new NestedSortBuilder("otherPath").setFilter(filterThatRewrites));  
        original = new NestedSortBuilder("firstLevel");
                NestedSortBuilderTests::copy,  
import static java.util.Collections.emptyList;  
            nestedSort.setFilter(AbstractSortTestCase.randomNestedFilter());  
    public void testEqualsAndHashcode() {
                break;  
     * Test that filters and inner nested sorts get rewritten
        original = new NestedSortBuilder("path");
import org.opensearch.index.query.MatchNoneQueryBuilder;
/*  
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
     */
        ConstantScoreQueryBuilder constantScoreQueryBuilder = new ConstantScoreQueryBuilder(filterThatRewrites);
        }
        return mutated;
        if (randomBoolean()) {
}
                NestedSortBuilderTests::mutate
        original = new NestedSortBuilder("path");  
    }  
     */
    public static NestedSortBuilder createRandomNestedSort(int depth) {  
    public void testFromXContent() throws IOException {
    }
import org.opensearch.test.EqualsHashCodeTestUtils;  
        original.setNestedSort(new NestedSortBuilder("secondLevel").setNestedSort(nestedSortThatRewrites));
                break;  
        assertNotSame(rewritten.getFilter(), original.getFilter());  
            default:
        // test that rewrite works recursively  
    public static void init() {  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {  
            XContentBuilder shuffled = shuffleXContent(builder);
        rewritten = original.rewrite(mockRewriteContext);
        return xContentRegistry;
        }  
    /**  
                mutated.setFilter(randomValueOtherThan(original.getFilter(), AbstractSortTestCase::randomNestedFilter));
        assertNotSame(rewritten, original);
        original = new NestedSortBuilder("path");
                mutated.setNestedSort(  
 * not use this file except in compliance with the License.
import org.junit.AfterClass;
import org.mockito.Mockito;
        int parameter = randomIntBetween(0, 2);  
    private static NamedXContentRegistry xContentRegistry;  
 * The OpenSearch Contributors require contributions made to  
        assertNotSame(rewritten, original);  
            NestedSortBuilder testsort = createRandomNestedSort(3);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.MediaTypeRegistry;
        namedWriteableRegistry = null;
                mutated.setFilter(original.getFilter());
 * You may obtain a copy of the License at  
                break;  
import java.io.IOException;
    private static NestedSortBuilder mutate(NestedSortBuilder original) throws IOException {
        NestedSortBuilder nestedSort = new NestedSortBuilder(randomAlphaOfLengthBetween(3, 10));
        assertNotSame(((ConstantScoreQueryBuilder) rewritten.getFilter()).innerQuery(), constantScoreQueryBuilder.innerQuery());  
     * Create a {@link NestedSortBuilder} with random path and filter of the given depth.
                NestedSortBuilder parsedItem = NestedSortBuilder.fromXContent(parser);
 *
import org.opensearch.common.settings.Settings;
import org.opensearch.index.query.QueryBuilder;  
    }  
        return nestedSort;
 *  
import org.opensearch.index.query.QueryRewriteContext;
 *
        assertEquals("secondLevel", rewritten.getNestedSort().getPath());
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {  
                createRandomNestedSort(3),
        NestedSortBuilder original = new NestedSortBuilder("path").setFilter(filterThatRewrites);
/*
 * Licensed to Elasticsearch under one or more contributor  
            @Override
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {  
 * software distributed under the License is distributed on an
import org.opensearch.index.query.ConstantScoreQueryBuilder;  
import org.opensearch.search.SearchModule;
    private static NamedWriteableRegistry namedWriteableRegistry;
        assertNotSame(rewritten.getNestedSort(), original.getNestedSort());
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            case 1:
        NestedSortBuilder mutated = original.getNestedSort();
        }
        assertSame(rewritten.getFilter(), original.getFilter());  
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.test.OpenSearchTestCase;
    }
        original.setFilter(new MatchNoneQueryBuilder());
        original.setNestedSort(new NestedSortBuilder("otherPath").setFilter(new MatchNoneQueryBuilder()));  
 * the Apache License, Version 2.0 (the "License"); you may
 */
            );
                assertEquals(testItem, parsedItem);  
 * compatible open source license.
                );
 * this file be licensed under the Apache-2.0 license or a
        NestedSortBuilder nestedSortThatRewrites = new NestedSortBuilder("thirdLevel").setFilter(filterThatRewrites);
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());  
import org.opensearch.core.xcontent.ToXContent;  
        assertNotSame(rewritten.getNestedSort().getNestedSort(), nestedSortThatRewrites);
    }  
        xContentRegistry = null;  
 * license agreements. See the NOTICE file distributed with
        QueryBuilder filterThatRewrites = new MatchNoneQueryBuilder() {
            try (XContentParser parser = createParser(shuffled)) {
package org.opensearch.search.sort;
                    randomValueOtherThan(original.getNestedSort(), () -> NestedSortBuilderTests.createRandomNestedSort(3))
    public static void afterClass() throws Exception {
