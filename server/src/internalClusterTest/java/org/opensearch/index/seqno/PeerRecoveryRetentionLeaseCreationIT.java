 *
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.index.IndexSettings;  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
import org.opensearch.test.InternalTestCluster;
 * ownership. Elasticsearch licenses this file to you under  
        final String dataNode = internalCluster().startDataOnlyNode();  
    }  
        internalCluster().startClusterManagerOnlyNode();
/*
        final RetentionLeases retentionLeases = client().admin().indices().prepareStats("index").get().getShards()[0]
                return Settings.EMPTY;
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0)
        final String oldNodeId = client().admin().cluster().prepareNodesInfo(dataNode).clear().get().getNodes().get(0).getNode().getId();  
    @Override
                Settings.builder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected boolean forbidPrivateIndexSettings() {
            )
                final NodeMetadata nodeMetadata = new NodeMetadata(newNodeId, Version.CURRENT);  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;  
                        IndexMetadata.SETTING_VERSION_CREATED,  
                    .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            retentionLeases.contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(newNodeId))
            "expected lease for [" + newNodeId + "] in " + retentionLeases,  
                    )  
        );
                    .put(
 *  
        ensureGreen("index");  
            prepareCreate("index").setSettings(
        return false;  
import org.opensearch.test.VersionUtils;  
        ensureGreen("index");  
 * specific language governing permissions and limitations
public class PeerRecoveryRetentionLeaseCreationIT extends OpenSearchIntegTestCase {
 * The OpenSearch Contributors require contributions made to  
            .retentionLeases();
import org.opensearch.Version;  
        final Path[] nodeDataPaths = internalCluster().getInstance(NodeEnvironment.class, dataNode).nodeDataPaths();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
/*  
        assertThat(
 * software distributed under the License is distributed on an
            @Override
        );
        });
                NodeMetadata.FORMAT.writeAndCleanup(nodeMetadata, nodeDataPaths);
            .getRetentionLeaseStats()  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchIntegTestCase;
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/48701")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
         * the local node. The same sort of thing can happen in weird situations involving dangling indices. This test ensures that a
            }  
import org.opensearch.env.NodeEnvironment;
import java.nio.file.Path;
                        VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), Version.CURRENT)
         * primary that is recovering from store creates a lease for itself.
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.seqno;
 */
import org.opensearch.env.NodeMetadata;
            public Settings onNodeStopped(String nodeName) throws Exception {
            client().admin().cluster().prepareNodesInfo(dataNode).clear().get().getNodes().get(0).getNode().getId(),
        final String newNodeId = randomValueOtherThan(oldNodeId, () -> UUIDs.randomBase64UUID(random()));
 * under the License.  
         */  
import static org.hamcrest.Matchers.equalTo;
 * You may obtain a copy of the License at  
 */
 * compatible open source license.
         * In a full cluster restart from a version without peer-recovery retention leases, the leases on disk will not include a lease for  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertAcked(  
            equalTo(newNodeId)  
        assertTrue(
 * GitHub history for details.
 * this work for additional information regarding copyright
 *
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
        // Change the node ID so that the persisted retention lease no longer applies.
/*
        internalCluster().restartNode(dataNode, new InternalTestCluster.RestartCallback() {  
 * Unless required by applicable law or agreed to in writing,
        /*
import org.opensearch.common.UUIDs;
    public void testCanRecoverFromStoreWithoutPeerRecoveryRetentionLease() throws Exception {
                        // simulate a version which supports soft deletes with which this node is compatible
