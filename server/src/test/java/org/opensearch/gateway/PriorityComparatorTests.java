                creationDate = randomIntBetween(1, 10000);
        }
                null,
            if (rarely()) {
            // else sometimes just use the defaults
                Settings settings;
                                );
                .settings(buildSettings(creationDate, priority))
        assertEquals("oldest", next.getIndexName());
        next = iterator.next();
    }
            shards.add(routing);
            boolean isSystem = false;
            .put(IndexMetadata.SETTING_CREATION_DATE, creationDate)
            )
            .build();
                boolean isSystem = false;
        for (ShardRouting routing : shards) {
/*
        for (int i = 0; i < indices.length; i++) {
                                    greaterThan(currentName)
    public void testPriorityComparatorSort() {
                return map.get(index.getName());
import java.util.Collections;
import java.util.Map;
            ),
                } else {
                IndexMetadata currentMeta = map.get(routing.getIndexName());
            TestShardRouting.newShardRouting(
                "newest",
        for (ShardRouting routing : shardRoutings) {
                    settings = Settings.EMPTY;
                    settings = Settings.EMPTY;
                if ("oldest".equals(index.getName())) {
        next = iterator.next();
 *
package org.opensearch.gateway;
 * The OpenSearch Contributors require contributions made to
                            prevPriority,
                    } else {
                0,
                0,
                        prevMeta.isSystem(),
                null,
                TestShardRouting.newShardRouting(
        shards.sort(new PriorityComparator() {
                    settings = buildSettings(10, 100);
        Collections.shuffle(shardRoutings, random());
        assertEquals("newest", next.getIndexName());
            protected IndexMetadata getMetadata(Index index) {
 * Licensed to Elasticsearch under one or more contributor
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
        List<ShardRouting> shardRoutings = Arrays.asList(
            TestShardRouting.newShardRouting(
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.ShardRoutingState;
                null,
            }
        final Map<String, IndexMetadata> map = new HashMap<>();
                    final int prevPriority = prevMeta.getSettings().getAsInt(IndexMetadata.SETTING_PRIORITY, -1);
        assertFalse(iterator.hasNext());
                }
                randomBoolean(),
            if (previous != null) {
                ShardRoutingState.UNASSIGNED,
            IndexMetadata indexMeta = randomFrom(indices);
                        final int prevCreationDate = prevMeta.getSettings().getAsInt(IndexMetadata.SETTING_CREATION_DATE, -1);
 * SPDX-License-Identifier: Apache-2.0
            TestShardRouting.newShardRouting(
            }
                    new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
                ShardRoutingState.UNASSIGNED,
                        assertThat(
                } else {
            );
            int creationDate = 0;
                                prevCreationDate,
        assertEquals("newest", next.getIndexName());
        });
                ShardRoutingState.UNASSIGNED,
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (prevMeta.isSystem() == currentMeta.isSystem()) {
                            }
                .build();
                ShardRoutingState.UNASSIGNED,
        }
import org.opensearch.cluster.routing.UnassignedInfo;
                null,
                    final int currentPriority = currentMeta.getSettings().getAsInt(IndexMetadata.SETTING_PRIORITY, -1);
                    ShardRoutingState.UNASSIGNED,
 * Modifications Copyright OpenSearch Contributors. See
 *
            ),
                        greaterThan(currentMeta.isSystem())
    }
        }
                    settings = buildSettings(100, 1);
                    settings = buildSettings(100, 1);
import org.opensearch.cluster.metadata.IndexMetadata;
                null,
 * specific language governing permissions and limitations
                null,
    public void testPreferNewIndices() {
        });
    }
                            );
}
                if ("oldest".equals(index.getName())) {
        shards.sort(new PriorityComparator() {
                            greaterThan(currentPriority)
import org.opensearch.cluster.routing.RoutingNodes;
                    null,
/*
        }
        RoutingNodes.UnassignedShards shards = new RoutingNodes.UnassignedShards(mock(RoutingNodes.class));
                            assertThat(
        next = iterator.next();
        shards.sort(new PriorityComparator() {
                } else {
        RoutingNodes.UnassignedShards shards = new RoutingNodes.UnassignedShards(mock(RoutingNodes.class));
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
    public void testPreferPriorityIndices() {
                randomBoolean(),
        });
            ),
        }
 * this work for additional information regarding copyright
        for (int i = 0; i < numShards; i++) {
 * under the License.
                                "creationDate mismatch, expected:" + currentCreationDate + " after " + prevCreationDate,
            TestShardRouting.newShardRouting(
            @Override
                    null,
                ShardRoutingState.UNASSIGNED,
            @Override
                        }
            }
                    settings = buildSettings(10, 1);
                )
                    if (prevPriority == currentPriority) {
            int priority = 0;
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
                }
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = shards.iterator();
                    isSystem = true;
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
                return IndexMetadata.builder(index.getName()).settings(settings).build();
        assertEquals("newest", next.getIndexName());
 * GitHub history for details.
                .system(isSystem)
        ShardRouting next = iterator.next();
 *
    }
                0,
                        } else {
 * this file be licensed under the Apache-2.0 license or a
                "newest",
            }
        return Settings.builder()
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    indexMeta.getIndex().getName(),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        final int currentCreationDate = currentMeta.getSettings().getAsInt(IndexMetadata.SETTING_CREATION_DATE, -1);
        for (ShardRouting routing : shardRoutings) {
                "oldest",
                null,
 * You may obtain a copy of the License at
                    settings = buildSettings(10, 100);
                0,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;
                    }
            map.put(indices[i].getIndex().getName(), indices[i]);
            protected IndexMetadata getMetadata(Index index) {
                null,
import java.util.Locale;
            )
        int numShards = randomIntBetween(10, 100);
    private static Settings buildSettings(int creationDate, int priority) {
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = shards.iterator();
        );
                            final String prevName = prevMeta.getIndex().getName();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        RoutingNodes.UnassignedShards shards = new RoutingNodes.UnassignedShards(mock(RoutingNodes.class));
import org.opensearch.Version;
 * compatible open source license.
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;
            }
                    );
            TestShardRouting.newShardRouting(
public class PriorityComparatorTests extends OpenSearchTestCase {
                null,
            previous = routing;
                }
                IndexMetadata prevMeta = map.get(previous.getIndexName());
            }
        IndexMetadata[] indices = new IndexMetadata[numIndices];
        ShardRouting next = iterator.next();
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
            shards.add(
                0,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        "system mismatch, expected:" + currentMeta.isSystem() + " after " + prevMeta.isSystem(),
                randomBoolean(),
 * the Apache License, Version 2.0 (the "License"); you may
            }
                                    "indexName mismatch, expected:" + currentName + " after " + prevName,
                    settings = Settings.EMPTY;
                ShardRoutingState.UNASSIGNED,
 */
                        );
import static org.hamcrest.Matchers.greaterThan;
        ShardRouting previous = null;
            shards.add(routing);
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.TestShardRouting;
            if (frequently()) {
            protected IndexMetadata getMetadata(Index index) {
                isSystem = true;
                0,
                } else if ("newest".equals(index.getName())) {
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
        );
        ShardRouting next = iterator.next();
/*
            indices[i] = IndexMetadata.builder(String.format(Locale.ROOT, "idx_%04d", i))
                "newest",
                        if (prevCreationDate == currentCreationDate) {
            protected IndexMetadata getMetadata(Index index) {
        assertEquals("oldest", next.getIndexName());
        Collections.shuffle(shardRoutings, random());
        );
                            "priority mismatch, expected:" + currentPriority + " after " + prevPriority,
        }
import java.util.Arrays;
                Settings settings;
        Collections.shuffle(shardRoutings, random());
                                assertThat(
                    assertThat(
                return IndexMetadata.builder(index.getName()).system(isSystem).settings(settings).build();
        assertFalse(iterator.hasNext());
                    randomIntBetween(1, 5),
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = shards.iterator();
    }
            @Override
                                greaterThan(currentCreationDate)
                            final String currentName = currentMeta.getIndex().getName();
import java.util.HashMap;
                "oldest",
                null,
                randomBoolean(),
        shards.sort(new PriorityComparator() {
                if ("oldest".equals(index.getName())) {
            )
                } else if ("newest".equals(index.getName())) {
                            if (prevName.equals(currentName) == false) {
                randomBoolean(),
import org.opensearch.core.index.Index;
 */
        });
        List<ShardRouting> shardRoutings = Arrays.asList(
            TestShardRouting.newShardRouting(
                return IndexMetadata.builder(index.getName()).settings(settings).build();
                priority = randomIntBetween(1, 1000);
        for (ShardRouting routing : shardRoutings) {
    public void testPreferSystemIndices() {
 */
        int numIndices = randomIntBetween(3, 99);
            .put(IndexMetadata.SETTING_PRIORITY, priority)
            shards.add(routing);
            @Override
        List<ShardRouting> shardRoutings = Arrays.asList(
                null,
                                    prevName,
                } else {
        assertFalse(iterator.hasNext());
import static org.mockito.Mockito.mock;
                randomBoolean(),
                    settings = buildSettings(100, 1);
        assertEquals("oldest", next.getIndexName());
                Settings settings;
                "oldest",
                    randomBoolean(),
 * software distributed under the License is distributed on an
                } else if ("newest".equals(index.getName())) {
                null,
                }
import java.util.List;
        RoutingNodes.UnassignedShards shards = new RoutingNodes.UnassignedShards(mock(RoutingNodes.class));
