            }
        if (randomBoolean()) {
    }
    }
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(
    }
    @BeforeClass
                mutated.setFilter(original.getFilter());
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(testsort, deserializedsort);
                break;
 * KIND, either express or implied.  See the License for the
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
        };
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
                assertEquals(testItem.hashCode(), parsedItem.hashCode());
    }
    private static NamedWriteableRegistry namedWriteableRegistry;
            try (XContentParser parser = createParser(shuffled)) {
 *
        original = new NestedSortBuilder("path");
import org.mockito.Mockito;
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
        assertNotSame(rewritten.getNestedSort(), original.getNestedSort());
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
        namedWriteableRegistry = null;
                mutated = new NestedSortBuilder(original.getPath() + "_suffix");
    }
                assertNotSame(testItem, parsedItem);
        assertNotSame(rewritten, original);
 * this work for additional information regarding copyright
    public static NestedSortBuilder createRandomNestedSort(int depth) {
 * Modifications Copyright OpenSearch Contributors. See
        if (depth > 0) {
import org.opensearch.core.xcontent.XContentBuilder;
            }
        assertNotSame(rewritten, original);
     */
        assertNotSame(rewritten.getFilter(), original.getFilter());
import org.opensearch.index.query.MatchNoneQueryBuilder;
import org.opensearch.search.SearchModule;
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
                mutated.setNestedSort(
        assertNotSame(rewritten.getFilter(), original.getFilter());
    public static void init() {
        original.setFilter(constantScoreQueryBuilder);
        ConstantScoreQueryBuilder constantScoreQueryBuilder = new ConstantScoreQueryBuilder(filterThatRewrites);
 * software distributed under the License is distributed on an
    private static NestedSortBuilder copy(NestedSortBuilder nestedSort) throws IOException {
        }
                break;
    public void testFromXContent() throws IOException {
import org.opensearch.core.xcontent.XContentParser;
     */
            case 2:
 */
        assertEquals("thirdLevel", rewritten.getNestedSort().getNestedSort().getPath());
    private static NamedXContentRegistry xContentRegistry;
        assertSame(rewritten.getNestedSort(), original.getNestedSort());
    public void testSerialization() throws IOException {
     * Test that filters and inner nested sorts get rewritten
            assertNotSame(testsort, deserializedsort);
                parser.nextToken();
    }
                mutated.setFilter(randomValueOtherThan(original.getFilter(), AbstractSortTestCase::randomNestedFilter));
 * not use this file except in compliance with the License.
            testItem.toXContent(builder, ToXContent.EMPTY_PARAMS);
        }
    }
        return copyWriteable(nestedSort, namedWriteableRegistry, NestedSortBuilder::new);
        NestedSortBuilder rewritten = original.rewrite(mockRewriteContext);
 *    http://www.apache.org/licenses/LICENSE-2.0
                NestedSortBuilderTests::mutate
        assertNotSame(rewritten.getNestedSort().getNestedSort(), nestedSortThatRewrites);
     */
        // test that filter gets rewritten
                    randomValueOtherThan(original.getNestedSort(), () -> NestedSortBuilderTests.createRandomNestedSort(3))
    public void testEqualsAndHashcode() {
    }
        }
        xContentRegistry = null;
        return mutated;
import org.opensearch.index.query.MatchAllQueryBuilder;
            assertEquals(testsort.hashCode(), deserializedsort.hashCode());
    private static NestedSortBuilder mutate(NestedSortBuilder original) throws IOException {
 * compatible open source license.
/*
    public void testRewrite() throws IOException {
        NestedSortBuilder original = new NestedSortBuilder("path").setFilter(filterThatRewrites);
 * Unless required by applicable law or agreed to in writing,
        assertNotSame(rewritten.getNestedSort(), original.getNestedSort());
     * Create a {@link NestedSortBuilder} with random path and filter of the given depth.
import org.junit.BeforeClass;
        rewritten = original.rewrite(mockRewriteContext);
        original.setNestedSort(new NestedSortBuilder("otherPath").setFilter(filterThatRewrites));
 */
        }
        assertEquals("secondLevel", rewritten.getNestedSort().getPath());
        // test that both filter and inner nested sort get rewritten
import org.opensearch.index.query.QueryBuilder;
            );
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
     */
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.test.OpenSearchTestCase;
            case 1:
            nestedSort.setNestedSort(createRandomNestedSort(depth - 1));
        NestedSortBuilder nestedSortThatRewrites = new NestedSortBuilder("thirdLevel").setFilter(filterThatRewrites);
            nestedSort.setFilter(AbstractSortTestCase.randomNestedFilter());
     * Test equality and hashCode properties
     * Test serialization of the test nested sort.
        original.setNestedSort(new NestedSortBuilder("otherPath").setFilter(new MatchNoneQueryBuilder()));
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
import org.opensearch.test.EqualsHashCodeTestUtils;
        QueryRewriteContext mockRewriteContext = Mockito.mock(QueryRewriteContext.class);
import org.opensearch.index.query.ConstantScoreQueryBuilder;
        original = new NestedSortBuilder("firstLevel");
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
            case 0:
        assertSame(rewritten.getFilter(), original.getFilter());
        // test that inner nested sort gets rewritten
    @Override
            NestedSortBuilder testItem = createRandomNestedSort(3);
                break;
        assertNotSame(((ConstantScoreQueryBuilder) rewritten.getFilter()).innerQuery(), constantScoreQueryBuilder.innerQuery());
                createRandomNestedSort(3),
        switch (parameter) {
/*
 *
        return xContentRegistry;
        assertNotSame(rewritten.getNestedSort(), original.getNestedSort());
    /**
    private static final int NUMBER_OF_TESTBUILDERS = 20;
                NestedSortBuilder parsedItem = NestedSortBuilder.fromXContent(parser);
import org.junit.AfterClass;
                mutated.setNestedSort(original.getNestedSort());
        int parameter = randomIntBetween(0, 2);
    /**
        original.setNestedSort(new NestedSortBuilder("secondLevel").setNestedSort(nestedSortThatRewrites));
        }
    @AfterClass
        }
    /**
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.xcontent.XContentType;
package org.opensearch.search.sort;
import org.opensearch.index.query.QueryRewriteContext;
        original.setFilter(new MatchNoneQueryBuilder());
        NestedSortBuilder nestedSort = new NestedSortBuilder(randomAlphaOfLengthBetween(3, 10));
                NestedSortBuilderTests::copy,
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            default:
            XContentBuilder shuffled = shuffleXContent(builder);
 * ownership. Elasticsearch licenses this file to you under
    public static void afterClass() throws Exception {
    /**
        assertSame(rewritten, original);
}
                assertEquals(testItem, parsedItem);
        rewritten = original.rewrite(mockRewriteContext);
 * specific language governing permissions and limitations
        return nestedSort;
                return new MatchAllQueryBuilder();
        original.setNestedSort(new NestedSortBuilder("otherPath").setFilter(filterThatRewrites));
import static java.util.Collections.emptyList;
            protected QueryBuilder doRewrite(org.opensearch.index.query.QueryRewriteContext queryShardContext) throws IOException {
        QueryBuilder filterThatRewrites = new MatchNoneQueryBuilder() {
        assertNotSame(rewritten, original);
 * under the License.
 * You may obtain a copy of the License at
 */
            @Override
        // test that original stays unchanged if no element rewrites
import org.opensearch.common.settings.Settings;
        rewritten = original.rewrite(mockRewriteContext);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        original.setFilter(filterThatRewrites);
        original = new NestedSortBuilder("path");
        NestedSortBuilder mutated = original.getNestedSort();
            NestedSortBuilder testsort = createRandomNestedSort(3);
            NestedSortBuilder deserializedsort = copy(testsort);
public class NestedSortBuilderTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
    protected NamedXContentRegistry xContentRegistry() {
        assertNotSame(rewritten.getFilter(), constantScoreQueryBuilder);
/*
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.io.IOException;
        original = new NestedSortBuilder("path");
    }
        rewritten = original.rewrite(mockRewriteContext);
                );
        // test that rewrite works recursively
        assertNotSame(rewritten, original);
