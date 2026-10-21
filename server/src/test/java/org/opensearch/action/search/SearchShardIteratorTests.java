                        s.getSearchContextId(),
    }
 * KIND, either express or implied.  See the License for the
        OriginalIndices originalIndices = new OriginalIndices(
import org.opensearch.action.OriginalIndicesTests;
 * not use this file except in compliance with the License.
        String[] clusters = generateRandomStringArray(2, 10, false, false);
                        clusterAlias,
                assertThat(currentIterator, Matchers.greaterThan(smallerIterator));
import java.util.List;
        int numShards = randomIntBetween(1, 5);
            originalIndices,
            }
    }
    }
    public void testGetClusterAlias() {
                        randomIntBetween(0, Integer.MAX_VALUE)
            shardIterator1.getTargetNodeIds(),
                    return new SearchShardIterator(
            shardId,
            Collections.emptyList(),
                    for (String cluster : clusters) {
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomIntBetween(0, Integer.MAX_VALUE));
import org.opensearch.action.support.IndicesOptions;
                            new SearchShardIterator(
            for (int j = i + 1; j < shardIterators.size(); j++) {
                        s.getSearchContextKeepAlive()
                    ShardId shardId = new ShardId(
                if (randomBoolean()) {
 */
                    );
                        s.getSearchContextKeepAlive()
    public void testShardId() {
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
                        s.getClusterAlias(),
 * under the License.
        List<SearchShardIterator> shardIterators = new ArrayList<>();
            shardIterator1.getOriginalIndices(),
            shardId,
                                shardId,
        Arrays.sort(indices);
        assertEquals(0, shardIterator2.compareTo(shardIterator1));
        }
                for (String uuid : uuids) {
        SearchShardIterator searchShardIterator = new SearchShardIterator(
                        s.getSearchContextId(),
/*
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
            s -> {
            }
        final SearchShardTarget searchShardTarget = searchShardIterator.nextOrNull();
 * compatible open source license.
                        s.shardId(),
            SearchShardIterator currentIterator = shardIterators.get(i);
public class SearchShardIteratorTests extends OpenSearchTestCase {
                    }
                    }
 *
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.test.OpenSearchTestCase;
        return new SearchShardIterator(
                }
 * Modifications Copyright OpenSearch Contributors. See
        assertNotNull(searchShardTarget);
        );
            }
                assertThat(smallerIterator, Matchers.lessThan(currentIterator));
        assertEquals(clusterAlias, searchShardIterator.getClusterAlias());
                } else {
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
                            shardId,
        SearchShardIterator shardIterator1 = randomSearchShardIterator();
 * software distributed under the License is distributed on an
        for (int i = 0; i < shardIterators.size(); i++) {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    );
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
 * this file be licensed under the Apache-2.0 license or a
            for (int j = i - 1; j >= 0; j--) {
        );
                        randomAlphaOfLength(10),
 * Licensed to Elasticsearch under one or more contributor
            shardIterator1.shardId(),
import org.opensearch.search.SearchShardTarget;
                s.getSearchContextId(),
    }
        String nodeId = randomAlphaOfLengthBetween(3, 10);
import java.util.ArrayList;
        );
 * The OpenSearch Contributors require contributions made to
    }
            clusterAlias,
 * specific language governing permissions and limitations
            shardId,
                assertThat(greaterIterator, Matchers.greaterThan(currentIterator));
                }
        );
                assertNotEquals(currentIterator, smallerIterator);
            IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
            new String[] { randomAlphaOfLengthBetween(3, 10) },
                            null,
    public void testNewSearchShardTarget() {
        Arrays.sort(uuids);
                        s.getOriginalIndices(),
    }
        assertSame(originalIndices, searchShardIterator.getOriginalIndices());
            clusterAlias,
        SearchShardIterator searchShardIterator = new SearchShardIterator(
                s.getClusterAlias(),
 * this work for additional information regarding copyright
                    );
}
import org.hamcrest.Matchers;
        Arrays.sort(clusters);
            shardIterator1.getSearchContextId(),
                        s.getTargetNodeIds(),
            null
                s.getSearchContextKeepAlive()
                    String clusterAlias;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
            clusterAlias,
 * You may obtain a copy of the License at
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
                        clusterAlias = randomBoolean() ? null : s.getClusterAlias() + randomAlphaOfLength(3);
            ),
import java.util.Arrays;
    public void testGetOriginalIndices() {
                    shardIterators.add(
                                OriginalIndicesTests.randomOriginalIndices()
import org.opensearch.test.EqualsHashCodeTestUtils;
                    if (s.getClusterAlias() == null) {
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
                    } else {
                    ShardId shardId = new ShardId(index, uuid, i);
 * license agreements. See the NOTICE file distributed with
            shardIterator1.getClusterAlias(),
import org.opensearch.cluster.routing.GroupShardsIteratorTests;
            GroupShardsIteratorTests.randomShardRoutings(shardId),
import org.opensearch.action.OriginalIndices;
        assertEquals(clusterAlias, searchShardTarget.getClusterAlias());
/*
            new String[] { randomAlphaOfLengthBetween(3, 10) },
import org.opensearch.core.index.shard.ShardId;
 * GitHub history for details.
                        s.getTargetNodeIds(),
                                cluster,
            shardIterator1.getSearchContextKeepAlive()
                        s.getOriginalIndices(),
 */
                            GroupShardsIteratorTests.randomShardRoutings(shardId),
        assertThat(searchShardTarget.getNodeId(), equalTo(nodeId));
                assertNotEquals(currentIterator, greaterIterator);
        }
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(0, shardIterator1.compareTo(shardIterator2));
    public void testCompareToEqualItems() {
        );
                            )
        );
        SearchShardIterator shardIterator2 = new SearchShardIterator(
                        shardIterators.add(
    public void testCompareTo() {
            s -> new SearchShardIterator(
        OriginalIndices originalIndices = new OriginalIndices(
                            OriginalIndicesTests.randomOriginalIndices()
                        )
        );
        assertSame(shardId, searchShardIterator.shardId());
                        );
                                GroupShardsIteratorTests.randomShardRoutings(shardId),
            OriginalIndices.NONE
                        clusterAlias = randomAlphaOfLengthBetween(5, 10);
            IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
        assertEquals(nodeId, searchShardTarget.getNodeId());
                        randomAlphaOfLengthBetween(5, 10),
/*
    }
            randomSearchShardIterator(),
 * ownership. Elasticsearch licenses this file to you under
        String[] indices = generateRandomStringArray(3, 10, false, false);
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(shardIterator1, shardIterator2);
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), originalIndices);
                    return new SearchShardIterator(
                s.shardId(),
    public void testEqualsAndHashcode() {
                s.getTargetNodeIds(),
                SearchShardIterator smallerIterator = shardIterators.get(j);
    private static SearchShardIterator randomSearchShardIterator() {
    }
                s.getOriginalIndices(),
            Collections.singletonList(nodeId),
        assertSame(shardId, searchShardTarget.getShardId());
        for (int i = 0; i < numShards; i++) {
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
            for (String index : indices) {
 *
                assertThat(currentIterator, Matchers.lessThan(greaterIterator));
            null,
package org.opensearch.action.search;
                        new SearchShardIterator(
            OriginalIndicesTests.randomOriginalIndices()
                        shardId,
                    );
import java.util.Collections;
                SearchShardIterator greaterIterator = shardIterators.get(j);
 */
        assertSame(originalIndices, searchShardTarget.getOriginalIndices());
 * Unless required by applicable law or agreed to in writing,
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), OriginalIndices.NONE);
        String[] uuids = generateRandomStringArray(3, 10, false, false);
