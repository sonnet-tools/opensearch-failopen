    protected FiltersAggregationBuilder createTestAggregatorBuilder() {  
                () -> FiltersAggregationBuilder.parse("agg_name", parser)  
            builder.field("other_bucket", false);
import org.opensearch.index.query.BaseQueryRewriteContext;
                    QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20))
    public void testRewrite() throws IOException {
                );
import static org.hamcrest.Matchers.instanceOf;
        FiltersAggregationBuilder rewrittenFilters = (FiltersAggregationBuilder) rewritten;
            builder.endObject();  
        rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
 * Licensed to Elasticsearch under one or more contributor  
        // test sub-agg filter that does rewrite
        }
 * software distributed under the License is distributed on an
        assertEquals("aaa", original[1].key());
import org.opensearch.index.query.MatchAllQueryBuilder;
        rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));  
        KeyedFilter[] original = new KeyedFilter[] {
            for (int i = 0; i < size; i++) {
            );
        builder.endObject();  
        assertThat(rewritten, instanceOf(FiltersAggregationBuilder.class));  
        assertThat(rewritten, instanceOf(TermsAggregationBuilder.class));
            builder.field("other_bucket_key", "some_key");
        assertSame(original, rewritten);  
            for (String key : randomUnique(() -> randomAlphaOfLengthBetween(1, 20), size)) {
        assertThat(((FiltersAggregationBuilder) rewritten).filters().get(0).filter(), instanceOf(MatchAllQueryBuilder.class));
        original = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.BOOLEAN)  
        assertEquals("my-filter", ((FiltersAggregationBuilder) rewritten).filters().get(0).key());
        // test non-keyed filter that does rewrite
            new KeyedFilter("bbb", new MatchNoneQueryBuilder()),  
        {
        rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
            builder.startArray("filters").startObject().startObject("term").field("field", "foo").endObject().endObject().endArray();  
        }
            builder.startObject();  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.QueryBuilder;  
        return factory;  
import org.opensearch.index.query.MatchNoneQueryBuilder;
        AggregationBuilder rewritten = originalFilters.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
        original = new FiltersAggregationBuilder("my-agg", new KeyedFilter("my-filter", new BoolQueryBuilder()));
    public void testOtherBucket() throws IOException {
        }
 * compatible open source license.
        AggregationBuilder subAgg = rewritten.getSubAggregations().iterator().next();
     * Test that when passing in keyed filters as list or array, the list stored internally is sorted by key
            builder.field("other_bucket_key", "some_key");
 */
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.XContentType;
        rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
            FiltersAggregationBuilder filters = FiltersAggregationBuilder.parse("agg_name", parser);
        }
        }  
        FiltersAggregationBuilder originalFilters = new FiltersAggregationBuilder("my-agg", new BoolQueryBuilder());  
        assertNotSame(original, rewritten);  
        assertSame(rewritten, rewritten.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L)));
                () -> FiltersAggregationBuilder.parse("agg_name", parser)
            new KeyedFilter("aaa", new MatchNoneQueryBuilder()) };
        original = new FiltersAggregationBuilder("my-agg", new KeyedFilter("my-filter", new MatchAllQueryBuilder()));
        // test non-keyed filter that does rewrite  
            factory = new FiltersAggregationBuilder(randomAlphaOfLengthBetween(1, 20), filters);
 * Modifications Copyright OpenSearch Contributors. See
        }
            factory = new FiltersAggregationBuilder(randomAlphaOfLengthBetween(1, 20), filters);
                filters[i++] = new KeyedFilter(
        assertNotSame(original, rewritten);  
 * KIND, either express or implied.  See the License for the
                    key,  
            builder.startObject();
        // original should be unchanged  
            builder.startArray("filters").startObject().startObject("term").field("field", "foo").endObject().endObject().endArray();  
            factory.otherBucketKey(randomAlphaOfLengthBetween(1, 20));
                IllegalArgumentException.class,  
            QueryBuilder[] filters = new QueryBuilder[size];  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(e.getMessage(), equalTo("[filters] cannot be empty."));  
            int i = 0;  
        }
        assertEquals(originalFilters.otherBucketKey(), rewrittenFilters.otherBucketKey());  
    }
    public void testEmptyFilters() throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.aggregations.bucket;
        assertEquals("bbb", builder.filters().get(1).key());
        assertEquals(1, ((FiltersAggregationBuilder) rewritten).filters().size());
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            IllegalArgumentException e = expectThrows(
            FiltersAggregationBuilder filters = FiltersAggregationBuilder.parse("agg_name", parser);  
        originalFilters.otherBucket(randomBoolean());
 * specific language governing permissions and limitations
    @Override
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*  
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        if (randomBoolean()) {  
 * GitHub history for details.
                IllegalArgumentException.class,
import org.opensearch.index.query.QueryBuilders;
        assertEquals("my-agg", subAgg.getName());
        assertThat(rewritten, instanceOf(FiltersAggregationBuilder.class));
        assertSame(original, rewritten);
            parser.nextToken();
import org.opensearch.search.aggregations.AggregationBuilder;
        } else {
 *
public class FiltersTests extends BaseAggregationTestCase<FiltersAggregationBuilder> {  
            builder.startObject("filters").endObject(); // keyed object  
        assertThat(subAgg, instanceOf(FiltersAggregationBuilder.class));
            );
            FiltersAggregationBuilder filters = FiltersAggregationBuilder.parse("agg_name", parser);  
 * under the License.  
            parser.nextToken();
            builder.startArray("filters").endArray();  // unkeyed array
        assertEquals("my-agg", ((FiltersAggregationBuilder) rewritten).getName());
            builder.endObject();
        builder.startObject();
        assertNotSame(original, rewritten);
        if (randomBoolean()) {
import static org.hamcrest.Matchers.equalTo;  
    public void testFiltersSortedByKey() {
                filters[i] = QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20));
            // The other bucket is disabled by default
        if (randomBoolean()) {  
            KeyedFilter[] filters = new KeyedFilter[size];
        int size = randomIntBetween(1, 20);
    }
        assertEquals(originalFilters.otherBucket(), rewrittenFilters.otherBucket());
 * license agreements. See the NOTICE file distributed with
        AggregationBuilder original = new FiltersAggregationBuilder("my-agg", new MatchAllQueryBuilder());  
    }  
        AggregationBuilder rewritten = original.rewrite(new BaseQueryRewriteContext(xContentRegistry(), null, null, () -> 0L));
            IllegalArgumentException e = expectThrows(
/*
        assertEquals(1, ((FiltersAggregationBuilder) rewritten).filters().size());  
 *  
            factory.otherBucket(randomBoolean());
    }
import org.opensearch.search.aggregations.support.ValueType;
        FiltersAggregationBuilder factory;  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        assertThat(rewritten, instanceOf(FiltersAggregationBuilder.class));
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
            assertFalse(filters.otherBucket());
        // test non-keyed filter that doesn't rewrite
        assertFalse(((FiltersAggregationBuilder) rewritten).isKeyed());
        // test keyed filter that doesn't rewrite
    public void testRewritePreservesOtherBucket() throws IOException {
            builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
import org.opensearch.core.xcontent.XContentParser;
    }
            builder.endObject();
            builder.endObject();
 */  
        assertThat(((FiltersAggregationBuilder) rewritten).filters().get(0).filter(), instanceOf(MatchAllQueryBuilder.class));
        assertThat(rewritten.getSubAggregations().size(), equalTo(1));  
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
        assertEquals("my-agg", ((FiltersAggregationBuilder) rewritten).getName());
        originalFilters.otherBucketKey(randomAlphaOfLength(10));
import java.io.IOException;  
            // unless the other bucket is explicitly disabled
import org.opensearch.index.query.BoolQueryBuilder;  
            assertThat(e.getMessage(), equalTo("[filters] cannot be empty."));
        assertTrue(((FiltersAggregationBuilder) rewritten).isKeyed());  
        assertNotEquals(original, rewritten);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
 *
            assertTrue(filters.otherBucket());
     * Also check the list passed in is not modified by this but rather copied
        assertNotSame(original.getSubAggregations().iterator().next(), subAgg);  
            XContentParser parser = createParser(shuffleXContent(builder));
    /**  
 * You may obtain a copy of the License at  
        {  
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
        assertEquals("aaa", builder.filters().get(0).key());
            .subAggregation(new FiltersAggregationBuilder("my-agg", new KeyedFilter("my-filter", new BoolQueryBuilder())));
            // but setting a key enables it automatically
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
            parser.nextToken();  
            assertFalse(filters.otherBucket());  
}
 * not use this file except in compliance with the License.
/*  
        original = new FiltersAggregationBuilder("my-agg", new BoolQueryBuilder());  
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
        original.setMetadata(Collections.singletonMap(randomAlphaOfLengthBetween(1, 20), randomAlphaOfLengthBetween(1, 20)));
        FiltersAggregationBuilder builder;
import org.opensearch.core.xcontent.XContentBuilder;  
        }  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
            builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        builder = new FiltersAggregationBuilder("my-agg", original);  
        assertEquals("0", ((FiltersAggregationBuilder) rewritten).filters().get(0).key());  
    }  
        builder.startArray("filters").startObject().startObject("term").field("field", "foo").endObject().endObject().endArray();
 * The OpenSearch Contributors require contributions made to  
     */  
            builder.startObject();
            parser.nextToken();  
        assertEquals("bbb", original[0].key());
            XContentParser parser = createParser(shuffleXContent(builder));  
 * this work for additional information regarding copyright
            builder.startObject();
 * ownership. Elasticsearch licenses this file to you under  
            }  
            parser.nextToken();
