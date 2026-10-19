    }  
            IndexShardTestUtils.getFakeDiscoNode("source"),
        StartRecoveryRequest startRecoveryRequest = new StartRecoveryRequest(
import static org.mockito.Mockito.when;
 * this work for additional information regarding copyright
            randomAlphaOfLength(10),
import org.opensearch.test.NodeRoles;
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
            IndexShardTestUtils.getFakeDiscoNode("target"),  
            randomBoolean(),
        assertThat(delayRecoveryException.getMessage(), containsString("recovery with same target already registered"));  
    public void testDuplicateRecoveries() throws IOException {  
 *
        closeShards(primary);
import org.opensearch.common.settings.ClusterSettings;
        );
 * Unless required by applicable law or agreed to in writing,
/*  
        when(indicesService.clusterService()).thenReturn(clusterService);
 * this file be licensed under the Apache-2.0 license or a
            Store.MetadataSnapshot.EMPTY,
        final ClusterService clusterService = mock(ClusterService.class);  
        // re-adding after removing previous attempt works
import org.opensearch.transport.TransportService;
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        peerRecoverySourceService.ongoingRecoveries.remove(primary, handler);
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
            primary.shardId(),  
        handler = peerRecoverySourceService.ongoingRecoveries.addNewRecovery(startRecoveryRequest, primary);  
            SequenceNumbers.UNASSIGNED_SEQ_NO
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        peerRecoverySourceService.start();  
 *  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * The OpenSearch Contributors require contributions made to  
            indicesService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * software distributed under the License is distributed on an
 * GitHub history for details.
import static org.hamcrest.Matchers.containsString;  
        DelayRecoveryException delayRecoveryException = expectThrows(
 */
        PeerRecoverySourceService peerRecoverySourceService = new PeerRecoverySourceService(  
 * license agreements. See the NOTICE file distributed with
        RecoverySourceHandler handler = peerRecoverySourceService.ongoingRecoveries.addNewRecovery(startRecoveryRequest, primary);
        );
 */  
import org.opensearch.index.shard.IndexShardTestUtils;
            DelayRecoveryException.class,  
public class PeerRecoverySourceServiceTests extends IndexShardTestCase {
 */  
        );
import org.opensearch.index.seqno.SequenceNumbers;
import java.io.IOException;
            randomLong(),  
}
import org.opensearch.common.settings.Settings;  
import static org.mockito.Mockito.mock;
import org.opensearch.index.store.Store;
        when(clusterService.getSettings()).thenReturn(NodeRoles.dataNode());
package org.opensearch.indices.recovery;
            () -> peerRecoverySourceService.ongoingRecoveries.addNewRecovery(startRecoveryRequest, primary)
import org.opensearch.cluster.service.ClusterService;
 * specific language governing permissions and limitations
        final IndicesService indicesService = mock(IndicesService.class);
        peerRecoverySourceService.ongoingRecoveries.remove(primary, handler);
import org.opensearch.index.shard.IndexShard;
import org.opensearch.indices.IndicesService;  
import org.opensearch.index.shard.IndexShardTestCase;  
/*
            mock(TransportService.class),
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))  
        IndexShard primary = newStartedShard(true);
