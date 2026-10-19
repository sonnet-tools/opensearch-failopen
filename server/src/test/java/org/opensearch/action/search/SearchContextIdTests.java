 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
        } else {
            final AliasFilter aliasFilter;  
        SearchContextIdForNode node1 = context.shards().get(new ShardId("idx", "uuid1", 2));
        assertThat(node3.getClusterAlias(), nullValue());
            } else if (randomBoolean()) {  
 * compatible open source license.
        assertThat(node1.getClusterAlias(), equalTo("cluster_x"));
/*  
        assertThat(node2.getSearchContextId().getSessionId(), equalTo("b"));
        final AtomicArray<SearchPhaseResult> queryResults = TransportSearchHelperTests.generateQueryResults();
    public void testEncode() {  
                aliasFilters.put(result.getSearchShardTarget().getShardId().getIndex().getUUID(), aliasFilter);  
        assertThat(node3.getNode(), equalTo("node_3"));  
import org.opensearch.Version;
                aliasFilter = new AliasFilter(randomQueryBuilder());
        for (SearchPhaseResult result : queryResults.asList()) {
            return new MatchAllQueryBuilder();  
            )  
 * this work for additional information regarding copyright
 */  
 * You may obtain a copy of the License at  
        final String id = SearchContextId.encode(queryResults.asList(), aliasFilters, version);  
 */  
    }
 * GitHub history for details.
        } else if (randomBoolean()) {
                new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),  
 * software distributed under the License is distributed on an
                new NamedWriteableRegistry.Entry(QueryBuilder.class, IdsQueryBuilder.NAME, IdsQueryBuilder::new)
        }
            if (randomBoolean()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(node2.getClusterAlias(), equalTo("cluster_y"));
            } else {
 *
import org.opensearch.index.query.IdsQueryBuilder;
                new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new),
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.SearchPhaseResult;  
                aliasFilter = AliasFilter.EMPTY;  
import java.util.Arrays;
 * Modifications Copyright OpenSearch Contributors. See
/*
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
 * the Apache License, Version 2.0 (the "License"); you may
        SearchContextIdForNode node3 = context.shards().get(new ShardId("idy", "uuid2", 43));
 * under the License.  
                aliasFilter = new AliasFilter(randomQueryBuilder(), "alias-" + between(1, 10));
 * KIND, either express or implied.  See the License for the
        assertThat(node3.getSearchContextId().getSessionId(), equalTo("c"));
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(context.aliasFilter(), equalTo(aliasFilters));  
        if (randomBoolean()) {  
 */
        assertThat(node2.getSearchContextId().getId(), equalTo(12L));
            return new TermQueryBuilder(randomAlphaOfLength(10), randomAlphaOfLength(10));
    QueryBuilder randomQueryBuilder() {
import org.opensearch.index.query.QueryBuilder;
        assertThat(node1.getSearchContextId().getId(), equalTo(1L));
        assertThat(node1.getSearchContextId().getSessionId(), equalTo("a"));
        final SearchContextId context = SearchContextId.decode(namedWriteableRegistry, id);
        final Version version = Version.CURRENT;  
 * license agreements. See the NOTICE file distributed with
        );
import org.opensearch.search.internal.AliasFilter;
        assertThat(node1.getNode(), equalTo("node_1"));  
import static org.hamcrest.Matchers.hasSize;  
/*  
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.nullValue;
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(node3.getSearchContextId().getId(), equalTo(42L));
import org.opensearch.index.query.MatchAllQueryBuilder;  
import org.opensearch.index.query.TermQueryBuilder;
        }  
import org.opensearch.core.index.shard.ShardId;
            Arrays.asList(
        SearchContextIdForNode node2 = context.shards().get(new ShardId("idy", "uuid2", 42));
import org.opensearch.common.util.concurrent.AtomicArray;
 * not use this file except in compliance with the License.
import java.util.Map;  
 *  
        assertThat(node2.getNode(), equalTo("node_2"));  
            if (randomBoolean()) {
    }  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        final Map<String, AliasFilter> aliasFilters = new HashMap<>();
package org.opensearch.action.search;
import org.opensearch.test.OpenSearchTestCase;
public class SearchContextIdTests extends OpenSearchTestCase {  
import static org.hamcrest.Matchers.equalTo;
            }
 *
            }
        final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
}
            return new IdsQueryBuilder().addIds(randomAlphaOfLength(10));
        assertThat(context.shards().keySet(), hasSize(3));
