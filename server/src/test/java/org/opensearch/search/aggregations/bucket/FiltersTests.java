        } else {
    }
            KeyedFilter[] filters = new KeyedFilter[size];
                );
            builder.startObject();
        AggregationBuilder subAgg = rewritten.getSubAggregations().iterator().next();
        assertTrue(((FiltersAggregationBuilder) rewritten).isKeyed());
            }
/*
        assertThat(subAgg, instanceOf(FiltersAggregationBuilder.class));
import static org.hamcrest.Matchers.equalTo;
        if (randomBoolean()) {
            builder.endObject();
        KeyedFilter[] original = new KeyedFilter[] {
        original.setMetadata(Collections.singletonMap(randomAlphaOfLengthBetween(1, 20), randomAlphaOfLengthBetween(1, 20)));
        builder = new FiltersAggregationBuilder("my-agg", original);
        assertEquals(1, ((FiltersAggregationBuilder) rewritten).filters().size());
        // test keyed filter that doesn't rewrite
                () -> FiltersAggregationBuilder.parse("agg_name", parser)
        original = new FiltersAggregationBuilder("my-agg", new KeyedFilter("my-filter", new BoolQueryBuilder()));
 *
                IllegalArgumentException.class,
 * GitHub history for details.
            parser.nextToken();
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        originalFilters.otherBucket(randomBoolean());
        }
 * SPDX-License-Identifier: Apache-2.0
 *
    public void testOtherBucket() throws IOException {
        assertThat(rewritten, instanceOf(FiltersAggregationBuilder.class));
            builder.startArray("filters").startObject().startObject("term").field("field", "foo").endObject().endObject().endArray();
 */
        rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
        original = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.BOOLEAN)
        // original should be unchanged
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
        }
        assertThat(((FiltersAggregationBuilder) rewritten).filters().get(0).filter(), instanceOf(MatchAllQueryBuilder.class));
            assertFalse(filters.otherBucket());
 * compatible open source license.
        builder.startObject();
            parser.nextToken();
            FiltersAggregationBuilder filters = FiltersAggregationBuilder.parse("agg_name", parser);
 * this file be licensed under the Apache-2.0 license or a
            new KeyedFilter("aaa", new MatchNoneQueryBuilder()) };
        original = new FiltersAggregationBuilder("my-agg", new BoolQueryBuilder());
        }
        assertEquals("my-agg", subAgg.getName());
    public void testFiltersSortedByKey() {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
        assertThat(((FiltersAggregationBuilder) rewritten).filters().get(0).filter(), instanceOf(MatchAllQueryBuilder.class));
        }
            builder.startArray("filters").endArray();  // unkeyed array
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
        assertEquals("my-agg", ((FiltersAggregationBuilder) rewritten).getName());
                    key,
            QueryBuilder[] filters = new QueryBuilder[size];
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            XContentParser parser = createParser(shuffleXContent(builder));
        {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.query.BaseQueryRewriteContext;
            factory.otherBucketKey(randomAlphaOfLengthBetween(1, 20));
            // The other bucket is disabled by default
            // unless the other bucket is explicitly disabled
import org.opensearch.index.query.QueryBuilder;
            builder.startObject();
        AggregationBuilder original = new FiltersAggregationBuilder("my-agg", new MatchAllQueryBuilder());
    public void testRewritePreservesOtherBucket() throws IOException {
        assertSame(original, rewritten);
            builder.startObject("filters").endObject(); // keyed object
        assertNotSame(original, rewritten);
            assertFalse(filters.otherBucket());
     * Test that when passing in keyed filters as list or array, the list stored internally is sorted by key
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                () -> FiltersAggregationBuilder.parse("agg_name", parser)
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.core.xcontent.XContentBuilder;
            );
                    QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20))
    public void testEmptyFilters() throws IOException {
        assertEquals("0", ((FiltersAggregationBuilder) rewritten).filters().get(0).key());
        AggregationBuilder rewritten = originalFilters.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
import org.opensearch.search.aggregations.support.ValueType;
    }
        assertEquals("my-agg", ((FiltersAggregationBuilder) rewritten).getName());
/*
     */
        assertNotSame(original.getSubAggregations().iterator().next(), subAgg);
            // but setting a key enables it automatically
            );
            builder.startObject();
            new KeyedFilter("bbb", new MatchNoneQueryBuilder()),
    }
            builder.endObject();
                filters[i++] = new KeyedFilter(
        assertThat(rewritten, instanceOf(TermsAggregationBuilder.class));
import java.util.Collections;
        assertSame(original, rewritten);
        assertEquals(1, ((FiltersAggregationBuilder) rewritten).filters().size());
            .subAggregation(new FiltersAggregationBuilder("my-agg", new KeyedFilter("my-filter", new BoolQueryBuilder())));
import org.opensearch.search.aggregations.AggregationBuilder;
            factory = new FiltersAggregationBuilder(randomAlphaOfLengthBetween(1, 20), filters);
}
        rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        AggregationBuilder rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
            assertTrue(filters.otherBucket());
                filters[i] = QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20));
        rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
        assertSame(rewritten, rewritten.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L)));
        assertNotSame(original, rewritten);
            parser.nextToken();
        FiltersAggregationBuilder originalFilters = new FiltersAggregationBuilder("my-agg", new BoolQueryBuilder());
        // test sub-agg filter that does rewrite
        // test non-keyed filter that does rewrite
import org.opensearch.index.query.MatchNoneQueryBuilder;
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        assertThat(rewritten, instanceOf(FiltersAggregationBuilder.class));
        if (randomBoolean()) {
            FiltersAggregationBuilder filters = FiltersAggregationBuilder.parse("agg_name", parser);
     * Also check the list passed in is not modified by this but rather copied
        assertEquals(originalFilters.otherBucketKey(), rewrittenFilters.otherBucketKey());
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
            factory.otherBucket(randomBoolean());
    protected FiltersAggregationBuilder createTestAggregatorBuilder() {
        // test non-keyed filter that does rewrite
package org.opensearch.search.aggregations.bucket;
        {
    /**
            for (int i = 0; i < size; i++) {
        assertThat(rewritten.getSubAggregations().size(), equalTo(1));
    }
            IllegalArgumentException e = expectThrows(
        FiltersAggregationBuilder rewrittenFilters = (FiltersAggregationBuilder) rewritten;
import org.opensearch.search.aggregations.BaseAggregationTestCase;
        assertFalse(((FiltersAggregationBuilder) rewritten).isKeyed());
        originalFilters.otherBucketKey(randomAlphaOfLength(10));
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("my-filter", ((FiltersAggregationBuilder) rewritten).filters().get(0).key());
        FiltersAggregationBuilder builder;
            builder.field("other_bucket_key", "some_key");
 */
        assertEquals("bbb", builder.filters().get(1).key());
        assertEquals(originalFilters.otherBucket(), rewrittenFilters.otherBucket());
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.common.xcontent.XContentType;
            IllegalArgumentException e = expectThrows(
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
                IllegalArgumentException.class,
        FiltersAggregationBuilder factory;
            builder.field("other_bucket", false);
 * Licensed to Elasticsearch under one or more contributor
 *
            for (String key : randomUnique(() -> randomAlphaOfLengthBetween(1, 20), size)) {
        if (randomBoolean()) {
        builder.endObject();
 * this work for additional information regarding copyright
            }
        }
            builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
 * not use this file except in compliance with the License.
            builder.startObject();
        assertNotEquals(original, rewritten);
 */
        assertNotSame(original, rewritten);
            int i = 0;
        assertEquals("bbb", original[0].key());
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;
            FiltersAggregationBuilder filters = FiltersAggregationBuilder.parse("agg_name", parser);
    }
            factory = new FiltersAggregationBuilder(randomAlphaOfLengthBetween(1, 20), filters);
import org.opensearch.index.query.QueryBuilders;
public class FiltersTests extends BaseAggregationTestCase<FiltersAggregationBuilder> {
    @Override
import org.opensearch.index.query.BoolQueryBuilder;
 * You may obtain a copy of the License at
            builder.endObject();
import org.opensearch.index.query.MatchAllQueryBuilder;
        int size = randomIntBetween(1, 20);
 * under the License.
        builder.startArray("filters").startObject().startObject("term").field("field", "foo").endObject().endObject().endArray();
/*
        }
 * software distributed under the License is distributed on an
            assertThat(e.getMessage(), equalTo("[filters] cannot be empty."));
        assertThat(rewritten, instanceOf(FiltersAggregationBuilder.class));
            builder.endObject();
    public void testRewrite() throws IOException {
            assertThat(e.getMessage(), equalTo("[filters] cannot be empty."));
        assertEquals("aaa", original[1].key());
            XContentParser parser = createParser(shuffleXContent(builder));
            builder.startArray("filters").startObject().startObject("term").field("field", "foo").endObject().endObject().endArray();
        // test non-keyed filter that doesn't rewrite
            parser.nextToken();
 * specific language governing permissions and limitations
            parser.nextToken();
        original = new FiltersAggregationBuilder("my-agg", new KeyedFilter("my-filter", new MatchAllQueryBuilder()));
import org.opensearch.core.xcontent.XContentParser;
        assertEquals("aaa", builder.filters().get(0).key());
            builder.field("other_bucket_key", "some_key");
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
        return factory;
