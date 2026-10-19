public class TransportGetActionTests extends OpenSearchTestCase {
                            .put("index.version.created", Version.CURRENT)
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.core.index.Index;
 *  
import org.opensearch.test.OpenSearchTestCase;
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.Version;
        return ClusterState.builder(new ClusterName(TransportGetActionTests.class.getSimpleName()))  
 * license agreements. See the NOTICE file distributed with
        Metadata metadata = clusterState(ReplicationType.SEGMENT).getMetadata();  
        assertFalse(TransportGetAction.shouldForcePrimaryRouting(metadata, true, null, "index3"));  
                new Metadata.Builder().put(
            )  
import org.opensearch.cluster.ClusterName;
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        assertTrue(TransportGetAction.shouldForcePrimaryRouting(metadata, true, null, "index1"));  
        // should return false since preference is set for request
 * under the License.  
            .metadata(
        assertFalse(TransportGetAction.shouldForcePrimaryRouting(metadata, true, Preference.REPLICA.type(), "index1"));  
                        Settings.builder()
        assertFalse(TransportGetAction.shouldForcePrimaryRouting(metadata, true, null, "index1"));
    }
    public void testShouldForcePrimaryRouting() {
                )
                    )
 * KIND, either express or implied.  See the License for the
        final Index index1 = new Index("index1", randomBase64UUID());
        metadata = clusterState(ReplicationType.DOCUMENT).getMetadata();
import org.opensearch.cluster.ClusterState;  
        // should return true since segment replication is enabled
import static org.opensearch.common.UUIDs.randomBase64UUID;  
        // should return false since request is not realtime
 * not use this file except in compliance with the License.
 *
import org.opensearch.common.settings.Settings;
package org.opensearch.action.get;
 * specific language governing permissions and limitations
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 */  
                            .put("index.number_of_replicas", 1)
 * Licensed to Elasticsearch under one or more contributor  
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.indices.replication.common.ReplicationType;  
                    new IndexMetadata.Builder(index1.getName()).settings(  
        assertFalse(TransportGetAction.shouldForcePrimaryRouting(metadata, false, null, "index1"));  
    private static ClusterState clusterState(ReplicationType replicationType) {
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;
                            .put(IndexMetadata.SETTING_REPLICATION_TYPE, replicationType)  
                            .put(IndexMetadata.SETTING_INDEX_UUID, index1.getUUID())
/*  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        // should fail since document replication enabled
            .build();
                            .put("index.number_of_shards", 1)  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 */
        // should return false since index doesn't exist
import org.opensearch.cluster.routing.Preference;  
