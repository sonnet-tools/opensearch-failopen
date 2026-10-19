 * You may obtain a copy of the License at  
 * GitHub history for details.
        result.from(randomInt());
import org.opensearch.action.OriginalIndices;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
/*
import org.opensearch.common.UUIDs;
 * software distributed under the License is distributed on an
        result.size(randomInt());  
import org.opensearch.common.settings.Settings;
            Aggregations deserializedAggs = deserialized.consumeAggs().expand();
        );  
import org.opensearch.search.SearchModule;  
            null,
 */
        assertEquals(querySearchResult.size(), deserialized.size());
import org.opensearch.core.common.Strings;
            1.0f,  
import org.opensearch.search.DocValueFormat;
import org.opensearch.search.SearchShardTarget;
package org.opensearch.search.query;
 *
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
            new ShardSearchContextId(UUIDs.base64UUID(), randomLong()),  
    }  
 * SPDX-License-Identifier: Apache-2.0
    private static QuerySearchResult createTestInstance() throws Exception {  
import org.opensearch.search.suggest.SuggestTests;
        assertNull(deserialized.getSearchShardTarget());  
import org.opensearch.search.internal.AliasFilter;
 * Unless required by applicable law or agreed to in writing,
        if (randomBoolean()) {
    }  
    public void testSerialization() throws Exception {
        QuerySearchResult querySearchResult = createTestInstance();  
        ShardId shardId = new ShardId("index", "uuid", randomInt());
 * this work for additional information regarding copyright
import org.opensearch.action.search.SearchRequest;
        return result;
            shardId,  
import org.opensearch.search.internal.ShardSearchRequest;  
import org.opensearch.test.OpenSearchTestCase;
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        assertEquals(querySearchResult.topDocs().maxScore, deserialized.topDocs().maxScore, 0f);
import org.opensearch.core.index.shard.ShardId;
        if (randomBoolean()) {
    }  
import org.opensearch.search.internal.ShardSearchContextId;
        assertEquals(querySearchResult.hasAggs(), deserialized.hasAggs());
        if (deserialized.hasAggs()) {  
            1,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.Aggregations;
            OriginalIndicesTests.randomOriginalIndices(),
    public void testNullResponse() throws Exception {
import static java.util.Collections.emptyList;
 * Modifications Copyright OpenSearch Contributors. See
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(randomBoolean());
            shardSearchRequest
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        TopDocs topDocs = new TopDocs(new TotalHits(randomLongBetween(0, Long.MAX_VALUE), TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]);
        }
    }
/*  
        );
        QuerySearchResult querySearchResult = QuerySearchResult.nullInstance();  
        if (randomBoolean()) {
}
public class QuerySearchResultTests extends OpenSearchTestCase {  
        assertEquals(querySearchResult.isNull(), deserialized.isNull());
        }  
        result.topDocs(new TopDocsAndMaxScore(topDocs, randomBoolean() ? Float.NaN : randomFloat()), new DocValueFormat[0]);
        QuerySearchResult result = new QuerySearchResult(
        assertEquals(querySearchResult.terminatedEarly(), deserialized.terminatedEarly());
 *
 * under the License.  
import org.opensearch.action.OriginalIndicesTests;  
import org.opensearch.search.aggregations.InternalAggregationsTests;  
            result.terminatedEarly(randomBoolean());
            searchRequest,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            new String[0]  
            new SearchShardTarget("node", shardId, null, OriginalIndices.NONE),
            result.aggregations(InternalAggregationsTests.createTestInstance());  
import org.apache.lucene.search.ScoreDoc;
 */  
    private final NamedWriteableRegistry namedWriteableRegistry;
        assertEquals(querySearchResult.topDocs().topDocs.totalHits, deserialized.topDocs().topDocs.totalHits);
    public QuerySearchResultTests() {
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 *  
        QuerySearchResult deserialized = copyWriteable(querySearchResult, namedWriteableRegistry, QuerySearchResult::new);
import org.opensearch.Version;
            assertEquals(aggs.asList(), deserializedAggs.asList());  
            result.suggest(SuggestTests.createTestItem());  
        ShardSearchRequest shardSearchRequest = new ShardSearchRequest(  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TotalHits;  
 * this file be licensed under the Apache-2.0 license or a
            Aggregations aggs = querySearchResult.consumeAggs().expand();
            new AliasFilter(null, Strings.EMPTY_ARRAY),
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
        QuerySearchResult deserialized = copyWriteable(querySearchResult, namedWriteableRegistry, QuerySearchResult::new, Version.CURRENT);
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(querySearchResult.from(), deserialized.from());  
        this.namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());  
            randomNonNegativeLong(),
        }
 * The OpenSearch Contributors require contributions made to  
        assertEquals(querySearchResult.getContextId().getId(), deserialized.getContextId().getId());
