        OriginalIndices originalIndices = new OriginalIndices(  
                assertThat(greaterIterator, Matchers.greaterThan(currentIterator));
                    );  
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomIntBetween(0, Integer.MAX_VALUE));  
    public void testCompareTo() {  
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
                        s.getSearchContextKeepAlive()
            new String[] { randomAlphaOfLengthBetween(3, 10) },
    }
package org.opensearch.action.search;
            originalIndices,
                        s.getSearchContextKeepAlive()  
            shardIterator1.getTargetNodeIds(),  
                    } else {  
                        new SearchShardIterator(
        );
        for (int i = 0; i < numShards; i++) {  
        SearchShardIterator searchShardIterator = new SearchShardIterator(  
        Arrays.sort(indices);
            for (String index : indices) {
        assertEquals(clusterAlias, searchShardTarget.getClusterAlias());
                    return new SearchShardIterator(
import org.opensearch.search.SearchShardTarget;  
                        s.getOriginalIndices(),
                        clusterAlias = randomAlphaOfLengthBetween(5, 10);
 *
 * this work for additional information regarding copyright
                if (randomBoolean()) {
        final SearchShardTarget searchShardTarget = searchShardIterator.nextOrNull();
    public void testCompareToEqualItems() {
    }  
        assertNotNull(searchShardTarget);  
                            OriginalIndicesTests.randomOriginalIndices()  
 * Licensed to Elasticsearch under one or more contributor  
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), originalIndices);
            OriginalIndices.NONE
        );
                        randomAlphaOfLength(10),
            shardId,  
        List<SearchShardIterator> shardIterators = new ArrayList<>();
                    String clusterAlias;  
 */  
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
 * specific language governing permissions and limitations
            }  
                s.getOriginalIndices(),  
                    if (s.getClusterAlias() == null) {
            ),  
                }
                        s.getClusterAlias(),  
            for (int j = i - 1; j >= 0; j--) {
public class SearchShardIteratorTests extends OpenSearchTestCase {  
        assertThat(searchShardTarget.getNodeId(), equalTo(nodeId));
                        );
        String nodeId = randomAlphaOfLengthBetween(3, 10);
                    );
            SearchShardIterator currentIterator = shardIterators.get(i);  
 * The OpenSearch Contributors require contributions made to  
                s.getClusterAlias(),  
import org.opensearch.core.index.shard.ShardId;
                    return new SearchShardIterator(  
                            new SearchShardIterator(
 *  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
                s.getSearchContextKeepAlive()
    public void testGetClusterAlias() {  
            null,
        assertEquals(0, shardIterator1.compareTo(shardIterator2));  
                s.shardId(),
                assertNotEquals(currentIterator, smallerIterator);
import org.opensearch.cluster.routing.GroupShardsIteratorTests;
            }  
        );  
    }
            randomSearchShardIterator(),
            shardId,
}
/*  
/*  
 */  
import java.util.List;
    private static SearchShardIterator randomSearchShardIterator() {
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
 * Modifications Copyright OpenSearch Contributors. See
                    }  
/*
                        shardIterators.add(
            clusterAlias,
        assertSame(shardId, searchShardIterator.shardId());
                    ShardId shardId = new ShardId(index, uuid, i);  
import java.util.ArrayList;
import org.opensearch.action.support.IndicesOptions;  
        String[] uuids = generateRandomStringArray(3, 10, false, false);
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
            IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
            s -> {
        );  
    public void testEqualsAndHashcode() {
                                GroupShardsIteratorTests.randomShardRoutings(shardId),
        OriginalIndices originalIndices = new OriginalIndices(
        return new SearchShardIterator(
            shardIterator1.getSearchContextId(),
        }
            Collections.singletonList(nodeId),  
                assertNotEquals(currentIterator, greaterIterator);
        );  
                s.getTargetNodeIds(),
        assertEquals(clusterAlias, searchShardIterator.getClusterAlias());  
                    ShardId shardId = new ShardId(  
            }  
import org.opensearch.action.OriginalIndices;
        SearchShardIterator searchShardIterator = new SearchShardIterator(  
                SearchShardIterator smallerIterator = shardIterators.get(j);
import static org.hamcrest.Matchers.equalTo;
 * KIND, either express or implied.  See the License for the
                        randomAlphaOfLengthBetween(5, 10),
 * under the License.  
            for (int j = i + 1; j < shardIterators.size(); j++) {
import java.util.Collections;
            shardIterator1.shardId(),
                assertThat(smallerIterator, Matchers.lessThan(currentIterator));  
            clusterAlias,
 */
                        s.getSearchContextId(),
                    shardIterators.add(
import org.hamcrest.Matchers;  
 * GitHub history for details.
    public void testGetOriginalIndices() {
 * Unless required by applicable law or agreed to in writing,
                assertThat(currentIterator, Matchers.lessThan(greaterIterator));  
 * license agreements. See the NOTICE file distributed with
            null  
    }
            }
        Arrays.sort(uuids);  
        assertEquals(shardIterator1, shardIterator2);
        String[] clusters = generateRandomStringArray(2, 10, false, false);
        Arrays.sort(clusters);
            shardIterator1.getSearchContextKeepAlive()  
                    }
                        clusterAlias = randomBoolean() ? null : s.getClusterAlias() + randomAlphaOfLength(3);
                        randomIntBetween(0, Integer.MAX_VALUE)  
 * not use this file except in compliance with the License.
                        clusterAlias,
        SearchShardIterator shardIterator1 = randomSearchShardIterator();
            GroupShardsIteratorTests.randomShardRoutings(shardId),
                        s.shardId(),
                            shardId,
                        s.getTargetNodeIds(),  
                    for (String cluster : clusters) {  
 * software distributed under the License is distributed on an
        String[] indices = generateRandomStringArray(3, 10, false, false);  
        }
            s -> new SearchShardIterator(
 * You may obtain a copy of the License at  
            shardIterator1.getOriginalIndices(),
                SearchShardIterator greaterIterator = shardIterators.get(j);
 * ownership. Elasticsearch licenses this file to you under  
        assertSame(originalIndices, searchShardIterator.getOriginalIndices());  
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), OriginalIndices.NONE);
                            null,  
                }
    }
    public void testShardId() {
        int numShards = randomIntBetween(1, 5);
        );
    public void testNewSearchShardTarget() {  
import org.opensearch.action.OriginalIndicesTests;
            shardIterator1.getClusterAlias(),
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
                                cluster,  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        )
                            )
 * compatible open source license.
                        s.getOriginalIndices(),  
                assertThat(currentIterator, Matchers.greaterThan(smallerIterator));
            IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())  
                        shardId,
 *
                    );
                s.getSearchContextId(),
    }
            shardId,
        assertSame(shardId, searchShardTarget.getShardId());  
        SearchShardIterator shardIterator2 = new SearchShardIterator(  
        assertEquals(0, shardIterator2.compareTo(shardIterator1));
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());  
import org.opensearch.test.EqualsHashCodeTestUtils;
                                shardId,
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());  
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
                    );
                                OriginalIndicesTests.randomOriginalIndices()  
            new String[] { randomAlphaOfLengthBetween(3, 10) },
                        s.getSearchContextId(),
                            GroupShardsIteratorTests.randomShardRoutings(shardId),
        assertSame(originalIndices, searchShardTarget.getOriginalIndices());
        );
        assertEquals(nodeId, searchShardTarget.getNodeId());
            clusterAlias,
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
            Collections.emptyList(),  
import java.util.Arrays;  
            OriginalIndicesTests.randomOriginalIndices()
                for (String uuid : uuids) {
    }
        for (int i = 0; i < shardIterators.size(); i++) {
                        s.getTargetNodeIds(),
