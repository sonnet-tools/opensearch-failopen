        List<IndicesShardStoresResponse.StoreStatus> orderedStoreStatuses = new ArrayList<>();  
import org.opensearch.core.xcontent.XContentParser;
 */  
        orderedStoreStatuses.add(
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                new IOException("corrupted")
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
        );
        contentBuilder.endObject();  
        storesResponse.toXContent(contentBuilder, ToXContent.EMPTY_PARAMS);
            assertThat(((String) failureMap.get("index")), equalTo("test"));
            assertThat(((int) failureMap.get("shard")), equalTo(3));  
 * not use this file except in compliance with the License.
            new IndicesShardStoresResponse.StoreStatus(
 * compatible open source license.
            )
                Map<String, Object> shards = ((Map<String, Object>) ((Map<String, Object>) indices.get(index)).get("shards"));  
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA,
                        @SuppressWarnings("unchecked")  
 * this file be licensed under the Apache-2.0 license or a
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED,  
import java.util.Map;
                node1,
        DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
                        assertThat(((String) storeInfo.get("allocation")), equalTo(storeStatus.getAllocationStatus().value()));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, bytes)) {  
        orderedStoreStatuses.add(
import static org.hamcrest.Matchers.equalTo;
        );  
                node1,
public class IndicesShardStoreResponseTests extends OpenSearchTestCase {
import org.opensearch.Version;
        DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                node1,  
        );
 * You may obtain a copy of the License at  
                        assertThat(((String) storeInfo.get("allocation_id")), equalTo((storeStatus.getAllocationId())));  
import java.util.List;  
            assertThat(failureMap.containsKey("node"), equalTo(true));
                null
 * Licensed to Elasticsearch under one or more contributor  
        );  
        storeStatusList.add(
                    @SuppressWarnings("unchecked")  
            }  
 * software distributed under the License is distributed on an
            new IndicesShardStoresResponse.StoreStatus(node1, null, IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA, null)
import org.apache.lucene.util.CollectionUtil;
/*  
 * Modifications Copyright OpenSearch Contributors. See
            new IndicesShardStoresResponse.StoreStatus(  
    public void testBasicSerialization() throws Exception {
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> storeStatuses = new HashMap<>();  
            for (String index : new String[] { "test", "test2" }) {  
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY,
        final Map<String, Map<Integer, List<IndicesShardStoresResponse.StoreStatus>>> indexStoreStatuses = new HashMap<>();  
                    for (int i = 0; i < stores.size(); i++) {
                UUIDs.randomBase64UUID(),
                null,  
 */  
 */
                UUIDs.randomBase64UUID(),  
import org.opensearch.common.UUIDs;
import java.util.Collections;
                @SuppressWarnings("unchecked")
        orderedStoreStatuses.add(
                    }
                            assertThat(storeInfo.containsKey("store_exception"), equalTo(true));
            )
        );  
            assertThat(failureMap.containsKey("index"), equalTo(true));  
        );
            @SuppressWarnings("unchecked")
        XContentBuilder contentBuilder = XContentFactory.jsonBuilder();  
    public void testStoreStatusOrdering() throws Exception {
        BytesReference bytes = BytesReference.bytes(contentBuilder);
            Map<String, ?> failureMap = (Map<String, ?>) failureList.get(0);
            indexStoreStatuses,  
import java.util.HashMap;
package org.opensearch.action.admin.indices.shards;
                        if (storeStatus.getStoreException() != null) {
            new IndicesShardStoresResponse.StoreStatus(node1, null, IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY, null)
                UUIDs.randomBase64UUID(),
            new IndicesShardStoresResponse.StoreStatus(node1, null, IndicesShardStoresResponse.StoreStatus.AllocationStatus.PRIMARY, null)  
        orderedStoreStatuses.add(
        List<IndicesShardStoresResponse.StoreStatus> storeStatusList = new ArrayList<>();
/*
                node1,
                UUIDs.randomBase64UUID(),
        );
            Collections.unmodifiableList(failures)
                    assertThat(stores.size(), equalTo(storeStatusList.size()));
        }
        );
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED,
import org.opensearch.core.xcontent.ToXContent;
        assertThat(storeStatuses, equalTo(orderedStoreStatuses));  
        contentBuilder.startObject();
import org.opensearch.core.xcontent.XContentBuilder;  
            assertThat(failureMap.containsKey("shard"), equalTo(true));
            new IndicesShardStoresResponse.StoreStatus(
        List<IndicesShardStoresResponse.StoreStatus> storeStatuses = new ArrayList<>(orderedStoreStatuses);  
                    List<?> stores = (List<?>) shardStoresStatus.get("stores");  
                    assertThat(shardStoresStatus.containsKey("stores"), equalTo(true));
        failures.add(new IndicesShardStoresResponse.Failure("node1", "test", 3, new NodeDisconnectedException(node1, "")));  
            @SuppressWarnings("unchecked")
            List<?> failureList = (List<?>) map.get("failures");
        );
            )
                UUIDs.randomBase64UUID(),
        );
import static java.util.Collections.emptyMap;  
 *
        IndicesShardStoresResponse storesResponse = new IndicesShardStoresResponse(
                node2,
    }
 * the Apache License, Version 2.0 (the "License"); you may
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA,  
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.emptySet;
                node1,  
 * this work for additional information regarding copyright
            new IndicesShardStoresResponse.StoreStatus(node1, null, IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED, null)
                null  
    }
            )
                        assertThat(storeInfo.containsKey(storeStatus.getNode().getId()), equalTo(true));  
                        }  
            )  
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA,
        Collections.shuffle(storeStatuses, random());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentFactory;
                        Map<String, ?> storeInfo = ((Map<String, ?>) stores.get(i));
        );  
                null
 *  
        storeStatuses.put(0, storeStatusList);  
            assertThat(failureList.size(), equalTo(1));  
            new IndicesShardStoresResponse.StoreStatus(  
                for (String shardId : shards.keySet()) {
        orderedStoreStatuses.add(
                        IndicesShardStoresResponse.StoreStatus storeStatus = storeStatusList.get(i);
        storeStatusList.add(
            )  
 * ownership. Elasticsearch licenses this file to you under  
        orderedStoreStatuses.add(  
            Map<String, Object> map = parser.map();
/*  
                node1,  
 * Unless required by applicable law or agreed to in writing,
        List<IndicesShardStoresResponse.Failure> failures = new ArrayList<>();
import org.opensearch.transport.NodeDisconnectedException;  
import org.opensearch.core.common.bytes.BytesReference;
            )
            assertThat(((String) failureMap.get("node")), equalTo("node1"));
        storeStatusList.add(
        );  
                null
            new IndicesShardStoresResponse.StoreStatus(
import java.util.ArrayList;  
                    Map<String, ?> shardStoresStatus = (Map<String, ?>) shards.get(shardId);
        orderedStoreStatuses.add(
        indexStoreStatuses.put("test2", storesMap);
                assertThat(shards.size(), equalTo(2));
 * specific language governing permissions and limitations
        orderedStoreStatuses.add(  
import org.opensearch.common.xcontent.json.JsonXContent;  
            Map<String, Object> indices = (Map<String, Object>) map.get("indices");
import org.opensearch.cluster.node.DiscoveryNode;  
        CollectionUtil.timSort(storeStatuses);
                        assertThat(storeInfo.containsKey("allocation"), equalTo(true));
import org.opensearch.test.OpenSearchTestCase;
            new IndicesShardStoresResponse.StoreStatus(
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> storesMap = Collections.unmodifiableMap(storeStatuses);
                new IOException("corrupted")  
                }
 * GitHub history for details.
                IndicesShardStoresResponse.StoreStatus.AllocationStatus.REPLICA,
                UUIDs.randomBase64UUID(),
                assertThat(indices.containsKey(index), equalTo(true));
 *    http://www.apache.org/licenses/LICENSE-2.0
            new IndicesShardStoresResponse.StoreStatus(
                new IOException("corrupted")  
        storeStatuses.put(1, storeStatusList);
        indexStoreStatuses.put("test", storesMap);  
 *
