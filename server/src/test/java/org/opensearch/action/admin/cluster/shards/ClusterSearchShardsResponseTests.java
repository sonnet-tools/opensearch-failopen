        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
            indicesAndFilters
 * GitHub history for details.
 * this work for additional information regarding copyright
        entries.addAll(searchModule.getNamedWriteables());  
                    ClusterSearchShardsGroup clusterSearchShardsGroup = clusterSearchShardsResponse.getGroups()[i];  
        }
 * the Apache License, Version 2.0 (the "License"); you may
            try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), namedWriteableRegistry)) {  
import java.util.List;  
import java.util.Collections;  
 * You may obtain a copy of the License at  
 *
 * The OpenSearch Contributors require contributions made to  
                for (int i = 0; i < clusterSearchShardsResponse.getGroups().length; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        );
                    assertEquals(clusterSearchShardsGroup.getShardId(), deserializedGroup.getShardId());
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;
        ClusterSearchShardsResponse clusterSearchShardsResponse = new ClusterSearchShardsResponse(
        }  
import java.util.ArrayList;
                shardRouting.currentNodeId(),  
import org.opensearch.cluster.node.DiscoveryNode;
                aliasFilter = new AliasFilter(RandomQueryBuilder.createQuery(random()), "alias-" + index);
 *
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
            String nodeId = randomAlphaOfLength(10);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
/*  
            nodes.toArray(new DiscoveryNode[0]),  
                assertEquals(clusterSearchShardsResponse.getIndicesAndFilters(), deserialized.getIndicesAndFilters());
 * ownership. Elasticsearch licenses this file to you under  
            indicesAndFilters.put(index, aliasFilter);
 * compatible open source license.
            } else {
            }  
package org.opensearch.action.admin.cluster.shards;
import org.opensearch.test.OpenSearchTestCase;
        int numShards = randomIntBetween(1, 10);  
 * Unless required by applicable law or agreed to in writing,
            nodes.add(node);
            ShardId shardId = new ShardId(index, randomAlphaOfLength(12), i);
import org.opensearch.core.common.Strings;
            String index = randomAlphaOfLengthBetween(3, 10);  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        Map<String, AliasFilter> indicesAndFilters = new HashMap<>();
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
 * SPDX-License-Identifier: Apache-2.0
            clusterSearchShardsGroups,
    public void testSerialization() throws Exception {  
                in.setVersion(version);
            ShardRouting shardRouting = TestShardRouting.newShardRouting(shardId, nodeId, randomBoolean(), ShardRoutingState.STARTED);  
            }
import java.util.HashMap;
import org.opensearch.cluster.routing.ShardRoutingState;
            );  
public class ClusterSearchShardsResponseTests extends OpenSearchTestCase {
/*  
                assertEquals(clusterSearchShardsResponse.getGroups().length, deserialized.getGroups().length);
 * not use this file except in compliance with the License.
import java.util.Map;
        for (int i = 0; i < numShards; i++) {
                VersionUtils.randomVersion(random())
                aliasFilter = new AliasFilter(null, Strings.EMPTY_ARRAY);  
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(entries);
 * license agreements. See the NOTICE file distributed with
            if (randomBoolean()) {  
 * under the License.  
}  
            AliasFilter aliasFilter;
import org.opensearch.test.VersionUtils;  
import org.opensearch.core.common.transport.TransportAddress;  
import org.opensearch.index.query.RandomQueryBuilder;
        ClusterSearchShardsGroup[] clusterSearchShardsGroups = new ClusterSearchShardsGroup[numShards];
                    ClusterSearchShardsGroup deserializedGroup = deserialized.getGroups()[i];
import java.util.Set;
import org.opensearch.cluster.routing.ShardRouting;  
                }
                ClusterSearchShardsResponse deserialized = new ClusterSearchShardsResponse(in);
        Set<DiscoveryNode> nodes = new HashSet<>();
                    assertArrayEquals(clusterSearchShardsGroup.getShards(), deserializedGroup.getShards());  
import org.opensearch.Version;
 */
 * Modifications Copyright OpenSearch Contributors. See
 */  
import org.opensearch.core.index.shard.ShardId;
    }
import java.util.HashSet;
            clusterSearchShardsResponse.writeTo(out);
import org.opensearch.cluster.routing.TestShardRouting;
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
            out.setVersion(version);
import org.opensearch.search.SearchModule;  
            clusterSearchShardsGroups[i] = new ClusterSearchShardsGroup(shardId, new ShardRouting[] { shardRouting });
/*
import org.opensearch.common.settings.Settings;
            DiscoveryNode node = new DiscoveryNode(
                new TransportAddress(TransportAddress.META_ADDRESS, randomInt(0xFFFF)),
                assertArrayEquals(clusterSearchShardsResponse.getNodes(), deserialized.getNodes());  
import org.opensearch.search.internal.AliasFilter;
 */  
