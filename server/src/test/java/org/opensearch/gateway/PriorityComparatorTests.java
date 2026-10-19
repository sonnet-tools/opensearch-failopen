            );
                "oldest",  
                    }  
        assertFalse(iterator.hasNext());
 * this work for additional information regarding copyright
            shards.add(routing);
        assertEquals("oldest", next.getIndexName());
                ShardRoutingState.UNASSIGNED,
        assertEquals("oldest", next.getIndexName());
        for (ShardRouting routing : shards) {
        for (ShardRouting routing : shardRoutings) {
                priority = randomIntBetween(1, 1000);
            if (rarely()) {
    }
                }  
        });
        ShardRouting next = iterator.next();
            TestShardRouting.newShardRouting(  
                    settings = buildSettings(10, 100);  
import org.opensearch.cluster.routing.UnassignedInfo;  
import org.opensearch.cluster.routing.RoutingNodes;
                return IndexMetadata.builder(index.getName()).settings(settings).build();
                } else if ("newest".equals(index.getName())) {
            }
        ShardRouting next = iterator.next();  
 * the Apache License, Version 2.0 (the "License"); you may
            @Override  
                0,  
        }  
 * license agreements. See the NOTICE file distributed with
                                greaterThan(currentCreationDate)  
        RoutingNodes.UnassignedShards shards = new RoutingNodes.UnassignedShards(mock(RoutingNodes.class));  
                    randomIntBetween(1, 5),
public class PriorityComparatorTests extends OpenSearchTestCase {  
                                    "indexName mismatch, expected:" + currentName + " after " + prevName,  
                .system(isSystem)
            .put(IndexMetadata.SETTING_PRIORITY, priority)
            shards.add(
                            greaterThan(currentPriority)
                isSystem = true;
                    settings = buildSettings(10, 1);  
                null,
                TestShardRouting.newShardRouting(
            if (previous != null) {  
                randomBoolean(),
        int numIndices = randomIntBetween(3, 99);  
                null,
                    final int prevPriority = prevMeta.getSettings().getAsInt(IndexMetadata.SETTING_PRIORITY, -1);
import org.opensearch.common.settings.Settings;
                    null,
                    settings = Settings.EMPTY;
            .put(IndexMetadata.SETTING_CREATION_DATE, creationDate)  
 * not use this file except in compliance with the License.
                            final String currentName = currentMeta.getIndex().getName();
 * KIND, either express or implied.  See the License for the
                    if (prevPriority == currentPriority) {
        }  
import java.util.Map;
                }
        assertEquals("newest", next.getIndexName());  
                                prevCreationDate,
                IndexMetadata prevMeta = map.get(previous.getIndexName());
import static org.hamcrest.Matchers.greaterThan;  
                .build();  
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
                ShardRoutingState.UNASSIGNED,  
            TestShardRouting.newShardRouting(
                                );  
 * specific language governing permissions and limitations
        }  
        for (ShardRouting routing : shardRoutings) {
    }
        next = iterator.next();
import org.opensearch.cluster.metadata.IndexMetadata;
            TestShardRouting.newShardRouting(  
                } else if ("newest".equals(index.getName())) {
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = shards.iterator();
                                assertThat(
    public void testPreferNewIndices() {
            }
import org.opensearch.cluster.routing.ShardRouting;  
                        final int prevCreationDate = prevMeta.getSettings().getAsInt(IndexMetadata.SETTING_CREATION_DATE, -1);  
            )
 * Modifications Copyright OpenSearch Contributors. See  
                null,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * You may obtain a copy of the License at  
        }
        });  
                    ShardRoutingState.UNASSIGNED,
        shards.sort(new PriorityComparator() {
                                    prevName,
                randomBoolean(),  
            }
        List<ShardRouting> shardRoutings = Arrays.asList(
                "oldest",
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")  
                    } else {  
        }
import org.opensearch.test.OpenSearchTestCase;  
                null,
                        prevMeta.isSystem(),
                null,  
        assertFalse(iterator.hasNext());  
                null,  
                )
                            final String prevName = prevMeta.getIndex().getName();
        Collections.shuffle(shardRoutings, random());
        final Map<String, IndexMetadata> map = new HashMap<>();
            boolean isSystem = false;
                Settings settings;
        List<ShardRouting> shardRoutings = Arrays.asList(  
            map.put(indices[i].getIndex().getName(), indices[i]);
        );  
            ),
                boolean isSystem = false;
            TestShardRouting.newShardRouting(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            int creationDate = 0;  
                    isSystem = true;
                IndexMetadata currentMeta = map.get(routing.getIndexName());
                ShardRoutingState.UNASSIGNED,  
                            }
                if ("oldest".equals(index.getName())) {  
import java.util.Collections;  
        shards.sort(new PriorityComparator() {  
                } else {  
            protected IndexMetadata getMetadata(Index index) {
            // else sometimes just use the defaults
import java.util.Locale;  
 * this file be licensed under the Apache-2.0 license or a
            if (frequently()) {  
                        assertThat(
 */
 * The OpenSearch Contributors require contributions made to  
                "newest",
        ShardRouting previous = null;
        }
                ShardRoutingState.UNASSIGNED,
            shards.add(routing);  
                    settings = buildSettings(100, 1);
            protected IndexMetadata getMetadata(Index index) {
            indices[i] = IndexMetadata.builder(String.format(Locale.ROOT, "idx_%04d", i))  
        RoutingNodes.UnassignedShards shards = new RoutingNodes.UnassignedShards(mock(RoutingNodes.class));
import java.util.HashMap;
                } else {
                    new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")  
                    settings = buildSettings(10, 100);
                        final int currentCreationDate = currentMeta.getSettings().getAsInt(IndexMetadata.SETTING_CREATION_DATE, -1);
    private static Settings buildSettings(int creationDate, int priority) {
        int numShards = randomIntBetween(10, 100);
                        greaterThan(currentMeta.isSystem())
            protected IndexMetadata getMetadata(Index index) {  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    settings = Settings.EMPTY;
 * Licensed to Elasticsearch under one or more contributor  
/*
                return IndexMetadata.builder(index.getName()).settings(settings).build();
            protected IndexMetadata getMetadata(Index index) {  
        return Settings.builder()
            TestShardRouting.newShardRouting(
                        }
        );
                creationDate = randomIntBetween(1, 10000);
        next = iterator.next();
    public void testPreferSystemIndices() {
                    assertThat(
        for (int i = 0; i < indices.length; i++) {
            .build();
        Collections.shuffle(shardRoutings, random());  
/*  
                return IndexMetadata.builder(index.getName()).system(isSystem).settings(settings).build();
        ShardRouting next = iterator.next();  
            )  
 * SPDX-License-Identifier: Apache-2.0
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = shards.iterator();
            @Override
 * Unless required by applicable law or agreed to in writing,
                0,
                Settings settings;
 *
                randomBoolean(),
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
            int priority = 0;
            shards.add(routing);
                randomBoolean(),  
                } else {
                    settings = buildSettings(100, 1);  
            previous = routing;  
        RoutingNodes.UnassignedShards.UnassignedIterator iterator = shards.iterator();
                        "system mismatch, expected:" + currentMeta.isSystem() + " after " + prevMeta.isSystem(),  
    public void testPriorityComparatorSort() {
                            "priority mismatch, expected:" + currentPriority + " after " + prevPriority,
 * GitHub history for details.
                    );  
            @Override
                }
import org.opensearch.Version;  
                    randomBoolean(),
                ShardRoutingState.UNASSIGNED,
        assertEquals("newest", next.getIndexName());  
                                "creationDate mismatch, expected:" + currentCreationDate + " after " + prevCreationDate,
                "newest",  
            }  
            IndexMetadata indexMeta = randomFrom(indices);  
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
import org.opensearch.cluster.routing.TestShardRouting;
        Collections.shuffle(shardRoutings, random());
                0,
                null,
        );
        });  
                            assertThat(  
 *
                ShardRoutingState.UNASSIGNED,
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")
        IndexMetadata[] indices = new IndexMetadata[numIndices];
                Settings settings;  
import static org.mockito.Mockito.mock;
                if ("oldest".equals(index.getName())) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.index.Index;
        assertEquals("oldest", next.getIndexName());
            @Override
                            prevPriority,  
            }  
                "oldest",
        for (ShardRouting routing : shardRoutings) {  
                return map.get(index.getName());
        assertFalse(iterator.hasNext());
                0,
                        );
                null,
                "newest",
 * under the License.  
 */
                            );
    public void testPreferPriorityIndices() {  
                if ("oldest".equals(index.getName())) {
                null,  
                new UnassignedInfo(randomFrom(UnassignedInfo.Reason.values()), "foobar")  
        shards.sort(new PriorityComparator() {
    }
 * ownership. Elasticsearch licenses this file to you under  
                null,
                randomBoolean(),
import org.opensearch.cluster.routing.ShardRoutingState;
package org.opensearch.gateway;
        RoutingNodes.UnassignedShards shards = new RoutingNodes.UnassignedShards(mock(RoutingNodes.class));
 * software distributed under the License is distributed on an
                }  
                    settings = buildSettings(100, 1);  
                } else {
            }  
        RoutingNodes.UnassignedShards shards = new RoutingNodes.UnassignedShards(mock(RoutingNodes.class));
        next = iterator.next();
                null,  
                } else if ("newest".equals(index.getName())) {
 */  
        });
}
            TestShardRouting.newShardRouting(
            }  
import java.util.Arrays;
                null,
                if (prevMeta.isSystem() == currentMeta.isSystem()) {
                    indexMeta.getIndex().getName(),  
                randomBoolean(),
                        if (prevCreationDate == currentCreationDate) {  
                    null,  
        List<ShardRouting> shardRoutings = Arrays.asList(
        assertEquals("newest", next.getIndexName());  
        for (int i = 0; i < numShards; i++) {
                        } else {
                0,
    }
        shards.sort(new PriorityComparator() {
                    final int currentPriority = currentMeta.getSettings().getAsInt(IndexMetadata.SETTING_PRIORITY, -1);  
                            if (prevName.equals(currentName) == false) {
            )
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import java.util.List;
                    settings = Settings.EMPTY;
                0,  
                .settings(buildSettings(creationDate, priority))
 *  
/*
                                    greaterThan(currentName)
            ),  
    }  
            ),
