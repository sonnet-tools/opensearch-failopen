}
        searchShards.add(new SearchShard(null, new ShardId(index0, 1)));
        searchShards.add(new SearchShard("remote0", new ShardId(index0, 1)));  
import java.util.List;
        searchShards.add(new SearchShard("remote1", new ShardId(index1, 0)));  
                String indexName = s.getShardId().getIndexName();
import org.opensearch.core.index.shard.ShardId;
 * ownership. Elasticsearch licenses this file to you under  
        searchShards.add(new SearchShard("remote1", new ShardId(index0, 0)));
import org.opensearch.core.index.Index;
 * Licensed to Elasticsearch under one or more contributor  
        searchShards.add(new SearchShard("remote0", new ShardId(index1, 0)));
        searchShards.add(new SearchShard(null, new ShardId(index1, 0)));  
        searchShards.add(new SearchShard("remote1", new ShardId(index0, 1)));
 * under the License.  
                return new SearchShard(s.getClusterAlias() == null ? randomAlphaOfLengthBetween(3, 10) : null, s.getShardId());
        searchShards.add(new SearchShard("", new ShardId(index1, 0)));  
 * not use this file except in compliance with the License.
            if (randomBoolean()) {
                } else {
            new ShardId(index, index + "-uuid", randomIntBetween(0, 1024))
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        SearchShard searchShard = new SearchShard(
import org.opensearch.test.EqualsHashCodeTestUtils;  
 *
            }  
package org.opensearch.action.search;
                return new SearchShard(s.getClusterAlias(), new ShardId(indexName, indexName + "-uuid", shardId));
        searchShards.add(new SearchShard(null, new ShardId(index1, 2)));
    public void testCompareTo() {
 * software distributed under the License is distributed on an
 *
            randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10),  
                }
        searchShards.add(new SearchShard(null, new ShardId(index0, 0)));
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(searchShard, s -> new SearchShard(s.getClusterAlias(), s.getShardId()), s -> {  
/*
 * Unless required by applicable law or agreed to in writing,
        searchShards.add(new SearchShard(null, new ShardId(index1, 1)));
        });
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testEqualsAndHashcode() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import java.util.ArrayList;  
        searchShards.add(new SearchShard("", new ShardId(index0, 0)));
    }
 *  
        searchShards.add(new SearchShard("", new ShardId(index1, 1)));
        searchShards.add(new SearchShard("remote0", new ShardId(index0, 2)));
 */
 */  
        searchShards.add(new SearchShard(null, new ShardId(index0, 2)));  
        List<SearchShard> sorted = new ArrayList<>(searchShards);
                if (randomBoolean()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Index index0 = new Index("index0", "index0-uuid");  
        searchShards.add(new SearchShard("remote0", new ShardId(index0, 0)));
                int shardId = s.getShardId().getId();
        searchShards.add(new SearchShard("", new ShardId(index0, 1)));
        Index index1 = new Index("index1", "index1-uuid");
 * KIND, either express or implied.  See the License for the
                    indexName += randomAlphaOfLength(5);
/*  
        );
/*  
        Collections.sort(sorted);
        List<SearchShard> searchShards = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
public class SearchShardTests extends OpenSearchTestCase {
    }
                    shardId += randomIntBetween(1, 1024);  
 * specific language governing permissions and limitations
import java.util.Collections;
        searchShards.add(new SearchShard("remote1", new ShardId(index1, 1)));
 * Modifications Copyright OpenSearch Contributors. See
        String index = randomAlphaOfLengthBetween(5, 10);
 * You may obtain a copy of the License at  
            } else {  
        assertEquals(searchShards, sorted);  
import org.opensearch.test.OpenSearchTestCase;
