            try (
 * compatible open source license.
        ShardSearchRequest deserializedRequest = copyWriteable(
import org.opensearch.cluster.metadata.IndexMetadata;
        .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build())
import org.opensearch.common.UUIDs;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(indexMetadata.getAliases().containsKey("dogs"), equalTo(true));
 * ownership. Elasticsearch licenses this file to you under
        indexMetadata = add(indexMetadata, "all", null);
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(orig.scroll(), copy.scroll());
    private ShardSearchRequest createShardSearchRequest() throws IOException {
    public void testSerialization() throws Exception {
        IndexMetadata indexMetadata = BASE_METADATA;
            QueryBuilders.boolQuery().should(QueryBuilders.termQuery("animal", "cat")).should(QueryBuilders.termQuery("animal", "dog"))
                XContentParser parser = MediaTypeRegistry.xContentType(inputStream)
        assertNotSame(orig, copy);
 * Licensed to Elasticsearch under one or more contributor
        }
        assertArrayEquals(orig.indexRoutings(), copy.indexRoutings());
    public void testRemovedAliasFilter() throws Exception {
import org.opensearch.common.compress.CompressedXContent;
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
 * Unless required by applicable law or agreed to in writing,
            ) {
import org.opensearch.core.xcontent.XContentBuilder;
        ShardSearchContextId shardSearchContextId = null;
        indexMetadata = remove(indexMetadata, "cats");
            if (randomBoolean()) {
            shardSearchTransportRequest,
        return req;
    private IndexMetadata add(IndexMetadata indexMetadata, String alias, @Nullable CompressedXContent filter) {
 * GitHub history for details.
        IndexMetadata indexMetadata = BASE_METADATA;
            randomBoolean() ? 1.0f : randomFloat(),
    }
    }
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(orig.getAliasFilter(), copy.getAliasFilter());
 * license agreements. See the NOTICE file distributed with
        return ShardSearchRequest.parseAliasFilter(bytes -> {
import org.opensearch.action.OriginalIndices;
        indexMetadata = add(indexMetadata, "dogs", filter(termQuery("animal", "dog")));
        for (int i = 0; i < 10; i++) {
        assertEquals(orig.nowInMillis(), copy.nowInMillis());
            randomIntBetween(1, 100),
                .should(QueryBuilders.termQuery("animal", "canine"))
/*
    public void testFilteringAliases() throws Exception {
        assertEquals(orig.preference(), copy.preference());
import org.opensearch.index.query.QueryBuilders;
                    .xContent()
        indexMetadata = add(indexMetadata, "cats", filter(termQuery("animal", "cat")));
        );
        assertEquals(shardSearchTransportRequest, deserializedRequest);
            aliasFilter(indexMetadata, "cats");
import org.opensearch.search.AbstractSearchTestCase;
        assertEquals(orig.indexBoost(), copy.indexBoost(), 0.0f);
                InputStream inputStream = bytes.streamInput();
            filteringAliases = new AliasFilter(RandomQueryBuilder.createQuery(random()), strings);
import org.opensearch.common.settings.Settings;
        assertEquals(orig.canReturnNullResponseIfMatchNoDocs(), orig.canReturnNullResponseIfMatchNoDocs());
 * not use this file except in compliance with the License.
            }
    public QueryBuilder aliasFilter(IndexMetadata indexMetadata, String... aliasNames) {
import org.opensearch.common.unit.TimeValue;
        assertEquals(orig.getClusterAlias(), copy.getClusterAlias());
        assertEquals(
public class ShardSearchRequestTests extends AbstractSearchTestCase {
import org.opensearch.common.xcontent.XContentFactory;
            Math.abs(randomLong()),
            shardSearchContextId = new ShardSearchContextId(UUIDs.randomBase64UUID(), randomNonNegativeLong());
        if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(indexMetadata.getAliases().containsKey("turtles"), equalTo(false));
        SearchRequest searchRequest = createSearchRequest();
    }
import org.opensearch.core.xcontent.ToXContent;
import java.io.InputStream;
        assertEquals(orig.shardId(), copy.shardId());
    }
        return IndexMetadata.builder(indexMetadata).removeAlias(alias).build();
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(2, 10), randomAlphaOfLengthBetween(2, 10), randomInt());
            }
import org.opensearch.search.SearchSortValuesAndFormatsTests;
            filteringAliases = new AliasFilter(null, Strings.EMPTY_ARRAY);
        }
        assertEquals(orig.source(), copy.source());
        assertEquals(orig.cacheKey(), copy.cacheKey());
    public static CompressedXContent filter(QueryBuilder filterBuilder) throws IOException {
        indexMetadata = add(indexMetadata, "cats", filter(termQuery("animal", "cat")));
            assertThat(e.getMessage(), containsString("Invalid alias name [cats]"));
import org.opensearch.index.query.RandomQueryBuilder;
        if (randomBoolean()) {
        } catch (InvalidAliasNameException e) {
            req.setBottomSortValues(SearchSortValuesAndFormatsTests.randomInstance());
import org.opensearch.core.xcontent.DeprecationHandler;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(indexMetadata.getAliases().containsKey("cats"), equalTo(true));
 */
import org.opensearch.core.common.Strings;
 *
        TimeValue keepAlive = null;
import org.opensearch.Version;
import java.io.IOException;
                keepAlive = TimeValue.timeValueSeconds(randomIntBetween(0, 120));
        filterBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(orig.indicesOptions(), copy.indicesOptions());
import org.opensearch.cluster.metadata.AliasMetadata;
}
 */
            ShardSearchRequest clone = new ShardSearchRequest(shardSearchTransportRequest);
 * You may obtain a copy of the License at
        try {
            ShardSearchRequest shardSearchTransportRequest = createShardSearchRequest();
        XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.indices.InvalidAliasNameException;
 * this work for additional information regarding copyright
 */
        indexMetadata = add(indexMetadata, "dogs", filter(termQuery("animal", "canine")));
        .numberOfShards(1)
    }
        assertEquals(
        }
        req.canReturnNullResponseIfMatchNoDocs(randomBoolean());
            aliasFilter(indexMetadata, "dogs", "cats"),
        assertThat(aliasFilter(indexMetadata, "cats", "all"), nullValue());
            keepAlive
    private IndexMetadata remove(IndexMetadata indexMetadata, String alias) {
 * under the License.
            searchRequest,
        .build();
        ShardSearchRequest req = new ShardSearchRequest(
import org.opensearch.index.query.QueryBuilder;
        assertEquals(aliasFilter(indexMetadata, "cats"), QueryBuilders.termQuery("animal", "cat"));
        return IndexMetadata.builder(indexMetadata).putAlias(AliasMetadata.builder(alias).filter(filter).build()).build();
    public void testClone() throws Exception {
            aliasFilter(indexMetadata, "cats", "dogs"),
                .should(QueryBuilders.termQuery("animal", "feline"))
/*
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        indexMetadata = add(indexMetadata, "cats", filter(termQuery("animal", "cat")));
    }
        // Non-filtering alias should turn off all filters because filters are ORed
        expectThrows(InvalidAliasNameException.class, () -> aliasFilter(finalIndexMetadata, "unknown"));
            namedWriteableRegistry,
            new OriginalIndices(searchRequest),
    }
    }
        ShardSearchRequest shardSearchTransportRequest = createShardSearchRequest();
        assertEquals(orig.numberOfShards(), copy.numberOfShards());
        );
import static org.opensearch.index.query.QueryBuilders.termQuery;
        final AliasFilter filteringAliases;
            randomAlphaOfLengthBetween(3, 10),
        return new CompressedXContent(builder.toString());
        if (randomBoolean()) {
 *
        assertEquals(orig.getAliasFilter(), copy.getAliasFilter());
        IndexMetadata finalIndexMetadata = indexMetadata;
 * software distributed under the License is distributed on an
    public void testUnknownAliasFilter() throws Exception {
    private static final IndexMetadata BASE_METADATA = IndexMetadata.builder("test")
            assertEquals(shardSearchTransportRequest, clone);
        );
            shardId,
        builder.close();
import org.opensearch.common.Nullable;
            String[] strings = generateRandomStringArray(10, 10, false, false);
                    .createParser(xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, inputStream)
            shardSearchContextId,
        }, indexMetadata, aliasNames);
                return parseInnerQueryBuilder(parser);
        indexMetadata = add(indexMetadata, "dogs", filter(termQuery("animal", "dog")));
            ShardSearchRequest::new
/*
    }
            filteringAliases,
import org.opensearch.core.index.shard.ShardId;
            routings,
import org.opensearch.core.xcontent.MediaTypeRegistry;
package org.opensearch.search.internal;
        assertArrayEquals(orig.indices(), copy.indices());
        assertEquals(orig.searchType(), copy.searchType());
 *
    }
        final String[] routings = generateRandomStringArray(5, 10, false, true);
    }
import org.opensearch.action.search.SearchRequest;
    private static void assertEquals(ShardSearchRequest orig, ShardSearchRequest copy) throws IOException {
            fail("Expected InvalidAliasNameException");
        IndexMetadata indexMetadata = BASE_METADATA;
        .numberOfReplicas(1)
        } else {
import static org.hamcrest.Matchers.containsString;
        assertThat(aliasFilter(indexMetadata, "all"), nullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
        assertEquals(orig.allowPartialSearchResults(), copy.allowPartialSearchResults());
            QueryBuilders.boolQuery()
        );
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }
        assertThat(aliasFilter(indexMetadata, "all", "cats"), nullValue());
        indexMetadata = add(indexMetadata, "cats", filter(termQuery("animal", "feline")));
