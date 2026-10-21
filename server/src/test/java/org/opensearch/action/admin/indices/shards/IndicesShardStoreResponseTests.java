                    assertThat(stores.size(), equalTo(storeStatusList.size()));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, bytes)) {
 * compatible open source license.
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA,
        assertThat(storeStatuses, equalTo(orderedStoreStatuses));
/*
        orderedStoreStatuses.add(
                        assertThat(storeInfo.containsKey(storeStatus.getNode().getId()), equalTo(true));
                Map<String, Object> shards = ((Map<String, Object>) ((Map<String, Object>) indices.get(index)).get("shards"));
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED,
                UUIDs.randomBase64UUID(),
 * KIND, either express or implied.  See the License for the
            Map<String, ?> failureMap = (Map<String, ?>) failureList.get(0);
            )
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
            )
        List<IndicesShardStoresResponse.StoreStatus> storeStatuses = new ArrayList<>(orderedStoreStatuses);
        storeStatusList.add(
        BytesReference bytes = BytesReference.bytes(contentBuilder);
                node1,
                assertThat(shards.size(), equalTo(2));
                        }
        orderedStoreStatuses.add(
 *
                new IOException("corrupted")
                node2,
 *
            Map<String, Object> map = parser.map();
import java.util.List;
                UUIDs.randomBase64UUID(),
        );
            Map<String, Object> indices = (Map<String, Object>) map.get("indices");
        storesResponse.toXContent(contentBuilder, ToXContent.EMPTY_PARAMS);
        }
        indexStoreStatuses.put("test2", storesMap);
        indexStoreStatuses.put("test", storesMap);
 *
        List<IndicesShardStoresResponse.StoreStatus> storeStatusList = new ArrayList<>();
        );
            assertThat(failureMap.containsKey("node"), equalTo(true));
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA,
import static java.util.Collections.emptySet;
 * ownership. Elasticsearch licenses this file to you under
        );
        contentBuilder.startObject();
        orderedStoreStatuses.add(
        storeStatusList.add(
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
import static org.hamcrest.Matchers.equalTo;
/*
                null
        contentBuilder.endObject();
 */
                        if (storeStatus.getStoreException() != null) {
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY,
 * the Apache License, Version 2.0 (the "License"); you may
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> storeStatuses = new HashMap<>();
 */
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        orderedStoreStatuses.add(
            assertThat(failureMap.containsKey("shard"), equalTo(true));
        );
        );
import org.opensearch.common.UUIDs;
                null
            assertThat(failureMap.containsKey("index"), equalTo(true));
        Collections.shuffle(storeStatuses, random());
 * this work for additional information regarding copyright
            new IndicesShardStoresResponse.StoreStatus(
        );
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
import java.util.HashMap;
        );
        List<IndicesShardStoresResponse.StoreStatus> orderedStoreStatuses = new ArrayList<>();
import org.opensearch.Version;
 * GitHub history for details.
    public void testStoreStatusOrdering() throws Exception {
package org.opensearch.action.admin.indices.shards;
            new IndicesShardStoresResponse.StoreStatus(
                    Map<String, ?> shardStoresStatus = (Map<String, ?>) shards.get(shardId);
            new IndicesShardStoresResponse.StoreStatus(node1, null, IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY, null)
                @SuppressWarnings("unchecked")
 */
                for (String shardId : shards.keySet()) {
                    @SuppressWarnings("unchecked")
 * Licensed to Elasticsearch under one or more contributor
            )
import static java.util.Collections.emptyMap;
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
    }
        storeStatuses.put(0, storeStatusList);
            )
            assertThat(((int) failureMap.get("shard")), equalTo(3));
import org.opensearch.test.OpenSearchTestCase;
            )
        );
 * under the License.
            List<?> failureList = (List<?>) map.get("failures");
import org.apache.lucene.util.CollectionUtil;
            new IndicesShardStoresResponse.StoreStatus(node1, null, IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED, null)
            new IndicesShardStoresResponse.StoreStatus(
import org.opensearch.core.common.bytes.BytesReference;
        );
/*
                node1,
        orderedStoreStatuses.add(
        storeStatusList.add(
                UUIDs.randomBase64UUID(),
            new IndicesShardStoresResponse.StoreStatus(node1, null, IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA, null)
            indexStoreStatuses,
            new IndicesShardStoresResponse.StoreStatus(
        orderedStoreStatuses.add(
            Collections.unmodifiableList(failures)
import org.opensearch.transport.NodeDisconnectedException;
        );
            assertThat(((String) failureMap.get("index")), equalTo("test"));
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED,
        List<IndicesShardStoresResponse.Failure> failures = new ArrayList<>();
                    List<?> stores = (List<?>) shardStoresStatus.get("stores");
        final Map<String, Map<Integer, List<IndicesShardStoresResponse.StoreStatus>>> indexStoreStatuses = new HashMap<>();
import org.opensearch.core.xcontent.ToXContent;
            new IndicesShardStoresResponse.StoreStatus(
        orderedStoreStatuses.add(
            new IndicesShardStoresResponse.StoreStatus(
            new IndicesShardStoresResponse.StoreStatus(
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        storeStatuses.put(1, storeStatusList);
            for (String index : new String[] { "test", "test2" }) {
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA,
            )
        );
                UUIDs.randomBase64UUID(),
public class IndicesShardStoreResponseTests extends OpenSearchTestCase {
                node1,
    public void testBasicSerialization() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        failures.add(new IndicesShardStoresResponse.Failure("node1", "test", 3, new NodeDisconnectedException(node1, "")));
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.core.xcontent.XContentBuilder;
                null
        orderedStoreStatuses.add(
import java.util.ArrayList;
                node1,
                node1,
            @SuppressWarnings("unchecked")
                null
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA,
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.xcontent.json.JsonXContent;
 * Modifications Copyright OpenSearch Contributors. See
        );
                    for (int i = 0; i < stores.size(); i++) {
            new IndicesShardStoresResponse.StoreStatus(node1, null, IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY, null)
import java.util.Collections;
 * You may obtain a copy of the License at
            @SuppressWarnings("unchecked")
                            assertThat(storeInfo.containsKey("store_exception"), equalTo(true));
            assertThat(failureList.size(), equalTo(1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                node1,
            )
                UUIDs.randomBase64UUID(),
                }
import java.io.IOException;
        CollectionUtil.timSort(storeStatuses);
                assertThat(indices.containsKey(index), equalTo(true));
                null,
                new IOException("corrupted")
                        @SuppressWarnings("unchecked")
                    assertThat(shardStoresStatus.containsKey("stores"), equalTo(true));
 * license agreements. See the NOTICE file distributed with
                        assertThat(((String) storeInfo.get("allocation_id")), equalTo((storeStatus.getAllocationId())));
}
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> storesMap = Collections.unmodifiableMap(storeStatuses);
                UUIDs.randomBase64UUID(),
                    }
        IndicesShardStoresResponse storesResponse = new IndicesShardStoresResponse(
        XContentBuilder contentBuilder = XContentFactory.jsonBuilder();
                new IOException("corrupted")
 *    http://www.apache.org/licenses/LICENSE-2.0
                        IndicesShardStoresResponse.StoreStatus storeStatus = storeStatusList.get(i);
                        assertThat(storeInfo.containsKey("allocation"), equalTo(true));
            }
    }
import org.opensearch.cluster.node.DiscoveryNode;
                        Map<String, ?> storeInfo = ((Map<String, ?>) stores.get(i));
 * specific language governing permissions and limitations
                        assertThat(((String) storeInfo.get("allocation")), equalTo(storeStatus.getAllocationStatus().value()));
            assertThat(((String) failureMap.get("node")), equalTo("node1"));
