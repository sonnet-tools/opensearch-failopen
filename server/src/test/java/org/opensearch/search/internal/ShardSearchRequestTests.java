        assertEquals(orig.cacheKey(), copy.cacheKey());  
        ShardSearchRequest deserializedRequest = copyWriteable(
        assertEquals(orig.indicesOptions(), copy.indicesOptions());
    }
import org.opensearch.index.query.QueryBuilder;
    public static CompressedXContent filter(QueryBuilder filterBuilder) throws IOException {  
 * specific language governing permissions and limitations
        indexMetadata = add(indexMetadata, "cats", filter(termQuery("animal", "cat")));  
        IndexMetadata indexMetadata = BASE_METADATA;
    public void testFilteringAliases() throws Exception {  
        IndexMetadata indexMetadata = BASE_METADATA;
        IndexMetadata finalIndexMetadata = indexMetadata;
            shardId,
        }  
                .should(QueryBuilders.termQuery("animal", "feline"))  
            shardSearchTransportRequest,  
        );
        req.canReturnNullResponseIfMatchNoDocs(randomBoolean());
        assertEquals(orig.scroll(), copy.scroll());
                XContentParser parser = MediaTypeRegistry.xContentType(inputStream)
import org.opensearch.cluster.metadata.AliasMetadata;
    private static void assertEquals(ShardSearchRequest orig, ShardSearchRequest copy) throws IOException {  
import java.io.InputStream;  
            }  
import org.opensearch.index.query.RandomQueryBuilder;  
        ShardSearchContextId shardSearchContextId = null;
import org.opensearch.Version;
 * compatible open source license.
    }
                InputStream inputStream = bytes.streamInput();  
    }
import org.opensearch.core.index.shard.ShardId;
        final String[] routings = generateRandomStringArray(5, 10, false, true);
        }
    private static final IndexMetadata BASE_METADATA = IndexMetadata.builder("test")  
        filterBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
            assertThat(e.getMessage(), containsString("Invalid alias name [cats]"));  
            ) {
 */  
 *
 * You may obtain a copy of the License at  
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        try {
            filteringAliases,  
            shardSearchContextId,
import static org.hamcrest.Matchers.containsString;
import org.opensearch.action.search.SearchRequest;  
        indexMetadata = add(indexMetadata, "dogs", filter(termQuery("animal", "dog")));
package org.opensearch.search.internal;
import org.opensearch.core.xcontent.XContentBuilder;
    }
            Math.abs(randomLong()),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ShardSearchRequest shardSearchTransportRequest = createShardSearchRequest();  
        .numberOfReplicas(1)  
                    .createParser(xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, inputStream)  
import org.opensearch.core.common.Strings;  
        assertThat(aliasFilter(indexMetadata, "all"), nullValue());
            keepAlive  
                keepAlive = TimeValue.timeValueSeconds(randomIntBetween(0, 120));
import static org.opensearch.index.query.QueryBuilders.termQuery;  
            aliasFilter(indexMetadata, "dogs", "cats"),  
            aliasFilter(indexMetadata, "cats", "dogs"),  
        return new CompressedXContent(builder.toString());
            randomBoolean() ? 1.0f : randomFloat(),
        for (int i = 0; i < 10; i++) {
        assertEquals(orig.preference(), copy.preference());
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
/*  
    }
                    .xContent()
            try (
 * this work for additional information regarding copyright
        assertThat(indexMetadata.getAliases().containsKey("turtles"), equalTo(false));
        assertThat(indexMetadata.getAliases().containsKey("dogs"), equalTo(true));
        indexMetadata = add(indexMetadata, "cats", filter(termQuery("animal", "cat")));
            if (randomBoolean()) {  
import org.opensearch.core.xcontent.XContentParser;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;  
        indexMetadata = add(indexMetadata, "all", null);
                return parseInnerQueryBuilder(parser);
        IndexMetadata indexMetadata = BASE_METADATA;
    public void testClone() throws Exception {
import org.opensearch.common.Nullable;  
        }  
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(shardSearchTransportRequest, clone);
 */  
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;  
        assertNotSame(orig, copy);
    public void testUnknownAliasFilter() throws Exception {
        assertEquals(orig.getAliasFilter(), copy.getAliasFilter());
        );
        .build();
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    private ShardSearchRequest createShardSearchRequest() throws IOException {  
        final AliasFilter filteringAliases;  
        } else {
    }
            QueryBuilders.boolQuery().should(QueryBuilders.termQuery("animal", "cat")).should(QueryBuilders.termQuery("animal", "dog"))
        assertThat(indexMetadata.getAliases().containsKey("cats"), equalTo(true));  
    }
 * under the License.  
        return IndexMetadata.builder(indexMetadata).putAlias(AliasMetadata.builder(alias).filter(filter).build()).build();  
 *
 * GitHub history for details.
            ShardSearchRequest clone = new ShardSearchRequest(shardSearchTransportRequest);
    }
        ShardSearchRequest shardSearchTransportRequest = createShardSearchRequest();
import org.opensearch.search.SearchSortValuesAndFormatsTests;  
        assertEquals(orig.searchType(), copy.searchType());
 * Modifications Copyright OpenSearch Contributors. See
            req.setBottomSortValues(SearchSortValuesAndFormatsTests.randomInstance());
    public QueryBuilder aliasFilter(IndexMetadata indexMetadata, String... aliasNames) {  
            namedWriteableRegistry,
        indexMetadata = add(indexMetadata, "cats", filter(termQuery("animal", "feline")));  
        return req;  
 * the Apache License, Version 2.0 (the "License"); you may
        );
        assertEquals(orig.shardId(), copy.shardId());
        assertArrayEquals(orig.indices(), copy.indices());  
            new OriginalIndices(searchRequest),
        ShardSearchRequest req = new ShardSearchRequest(
        if (randomBoolean()) {
        .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build())
 * not use this file except in compliance with the License.
                .should(QueryBuilders.termQuery("animal", "canine"))
    public void testSerialization() throws Exception {  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.opensearch.core.xcontent.DeprecationHandler;
import java.io.IOException;
    public void testRemovedAliasFilter() throws Exception {
        if (randomBoolean()) {  
 */
        assertEquals(orig.allowPartialSearchResults(), copy.allowPartialSearchResults());
        assertEquals(orig.source(), copy.source());  
    }
            routings,
import org.opensearch.action.OriginalIndices;
        assertEquals(
        assertEquals(orig.nowInMillis(), copy.nowInMillis());
            }
import org.opensearch.core.xcontent.ToXContent;
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(2, 10), randomAlphaOfLengthBetween(2, 10), randomInt());
            ShardSearchRequest::new
            randomIntBetween(1, 100),
        indexMetadata = remove(indexMetadata, "cats");
        indexMetadata = add(indexMetadata, "dogs", filter(termQuery("animal", "canine")));
        assertThat(aliasFilter(indexMetadata, "cats", "all"), nullValue());  
 *  
        expectThrows(InvalidAliasNameException.class, () -> aliasFilter(finalIndexMetadata, "unknown"));  
        .numberOfShards(1)
        assertEquals(orig.indexBoost(), copy.indexBoost(), 0.0f);  
        SearchRequest searchRequest = createSearchRequest();
}  
            QueryBuilders.boolQuery()
        indexMetadata = add(indexMetadata, "dogs", filter(termQuery("animal", "dog")));  
 * KIND, either express or implied.  See the License for the
    }
        assertThat(aliasFilter(indexMetadata, "all", "cats"), nullValue());
 * ownership. Elasticsearch licenses this file to you under  
        TimeValue keepAlive = null;  
import org.opensearch.common.UUIDs;
        }, indexMetadata, aliasNames);
        assertArrayEquals(orig.indexRoutings(), copy.indexRoutings());
import org.opensearch.index.query.QueryBuilders;
            randomAlphaOfLengthBetween(3, 10),  
        indexMetadata = add(indexMetadata, "cats", filter(termQuery("animal", "cat")));  
    private IndexMetadata add(IndexMetadata indexMetadata, String alias, @Nullable CompressedXContent filter) {
import org.opensearch.common.compress.CompressedXContent;
            filteringAliases = new AliasFilter(null, Strings.EMPTY_ARRAY);
        // Non-filtering alias should turn off all filters because filters are ORed
 * license agreements. See the NOTICE file distributed with
/*
        assertEquals(orig.canReturnNullResponseIfMatchNoDocs(), orig.canReturnNullResponseIfMatchNoDocs());  
            filteringAliases = new AliasFilter(RandomQueryBuilder.createQuery(random()), strings);  
import org.opensearch.common.unit.TimeValue;
        if (randomBoolean()) {
        assertEquals(aliasFilter(indexMetadata, "cats"), QueryBuilders.termQuery("animal", "cat"));
        XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.search.AbstractSearchTestCase;
        }
            searchRequest,  
            aliasFilter(indexMetadata, "cats");  
    private IndexMetadata remove(IndexMetadata indexMetadata, String alias) {
            fail("Expected InvalidAliasNameException");
        assertEquals(shardSearchTransportRequest, deserializedRequest);
        return ShardSearchRequest.parseAliasFilter(bytes -> {
        assertEquals(orig.getAliasFilter(), copy.getAliasFilter());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.indices.InvalidAliasNameException;
        builder.close();  
 * software distributed under the License is distributed on an
        );  
        assertEquals(orig.getClusterAlias(), copy.getClusterAlias());
import org.opensearch.cluster.metadata.IndexMetadata;
        }  
public class ShardSearchRequestTests extends AbstractSearchTestCase {
            String[] strings = generateRandomStringArray(10, 10, false, false);
    }  
        assertEquals(orig.numberOfShards(), copy.numberOfShards());  
        } catch (InvalidAliasNameException e) {
            shardSearchContextId = new ShardSearchContextId(UUIDs.randomBase64UUID(), randomNonNegativeLong());
        return IndexMetadata.builder(indexMetadata).removeAlias(alias).build();
        assertEquals(
