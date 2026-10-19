        createIndex(
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(flushResponse.getFailedShards(), is(0));
        assertThat(flushResponse.getSuccessfulShards(), is(2));
package org.opensearch.action.admin.indices.forcemerge;
/*  
    private static String getForceMergeUUID(IndexShard indexShard) throws IOException {  
        final IndexRoutingTable indexShardRoutingTables = state.routingTable().getIndicesRouting().get(index);
/*  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
 * Unless required by applicable law or agreed to in writing,
        );
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
import org.opensearch.common.concurrent.GatedCloseable;
    public void testForceMergeOnlyOnPrimaryShards() throws IOException {  
 * software distributed under the License is distributed on an
            .setMaxNumSegments(1)
        internalCluster().ensureAtLeastNumDataNodes(2);  
    }
        ensureGreen(index);  
 * this file be licensed under the Apache-2.0 license or a
 *  
        final Index idx = shardRouting.primaryShard().index();  
        assertThat(primaryForceMergeUUID, is(replicaForceMergeUUID));  
        final String replicaForceMergeUUID = getForceMergeUUID(replica);
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(getForceMergeUUID(replica), nullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
/*
        ensureGreen(index);
 * this work for additional information regarding copyright
        final ForceMergeResponse forceMergeResponse = client().admin()
import org.opensearch.test.OpenSearchIntegTestCase;
            .get();
        final String primaryForceMergeUUID = getForceMergeUUID(primary);
        final FlushResponse flushResponse = client().admin().indices().prepareFlush(index).setForce(true).get();  
 */  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
        }  
        );
        assertThat(forceMergeResponse.getSuccessfulShards(), is(2));  
        final String index = "test-index";
 * license agreements. See the NOTICE file distributed with
        assertThat(forceMergeResponse.getFailedShards(), is(0));
 * not use this file except in compliance with the License.
            state.nodes().get(replicaNodeId).getName()
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.shard.IndexShard;
    }
    }
        final IndicesService replicaIndicesService = internalCluster().getInstance(
        assertThat(forceMergeResponse.getFailedShards(), is(0));
            state.nodes().get(primaryNodeId).getName()  
import org.opensearch.cluster.ClusterState;  
        // Force flush to force a new commit that contains the force flush UUID
import java.io.IOException;  
import org.apache.lucene.index.IndexCommit;
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 *
        assertThat(forceMergeResponse.getSuccessfulShards(), is(1));  
public class ForceMergeIT extends OpenSearchIntegTestCase {  
 * specific language governing permissions and limitations
        final IndexShard replica = replicaIndicesService.indexService(idx).getShard(0);
import org.opensearch.common.settings.Settings;
        assertThat(primaryForceMergeUUID, notNullValue());
        final String index = "test-index";
            IndicesService.class,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.engine.Engine;
            .indices()  
        final ClusterState state = clusterService().state();
        final IndexShard primary = primaryIndicesService.indexService(idx).getShard(0);  
            index,  
 * compatible open source license.
            IndicesService.class,
}
import static org.hamcrest.Matchers.is;
        final String replicaNodeId = shardRouting.replicaShards().get(0).currentNodeId();
 */  
 *
        assertThat(getForceMergeUUID(primary), nullValue());  
        final IndicesService primaryIndicesService = internalCluster().getInstance(
        internalCluster().ensureAtLeastNumDataNodes(2);
import org.opensearch.cluster.routing.IndexRoutingTable;
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.action.admin.indices.flush.FlushResponse;
        try (GatedCloseable<IndexCommit> wrappedIndexCommit = indexShard.acquireLastIndexCommit(true)) {
        );  
import org.opensearch.indices.IndicesService;  
            .prepareForceMerge(index)
 */
        final ForceMergeResponse forceMergeResponse = client().admin().indices().prepareForceMerge(index).setMaxNumSegments(1).get();  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        createIndex(  
import static org.hamcrest.Matchers.notNullValue;  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
        final IndexShardRoutingTable shardRouting = indexShardRoutingTables.getShards().get(0);  
    public void testForceMergeUUIDConsistent() throws IOException {
        final String primaryNodeId = shardRouting.primaryShard().currentNodeId();
        assertThat(replicaForceMergeUUID, notNullValue());
            .setPrimaryOnly(true)  
            index,
import org.opensearch.core.index.Index;  
            return wrappedIndexCommit.get().getUserData().get(Engine.FORCE_MERGE_UUID_KEY);
 * SPDX-License-Identifier: Apache-2.0
