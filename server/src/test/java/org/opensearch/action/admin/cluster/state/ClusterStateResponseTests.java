 * this work for additional information regarding copyright
 */  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.node.DiscoveryNodes;
    }  
 * specific language governing permissions and limitations
            if (randomBoolean()) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * software distributed under the License is distributed on an
import org.opensearch.test.AbstractWireSerializingTestCase;
 * this file be licensed under the Apache-2.0 license or a
 *  
}
 *
 * the Apache License, Version 2.0 (the "License"); you may
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
 * under the License.  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new ClusterStateResponse(clusterName, clusterState, randomBoolean());
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
    }
            ClusterState.Builder clusterStateBuilder = ClusterState.builder(clusterName).version(randomNonNegativeLong());
import org.opensearch.cluster.ClusterState;  
 * Modifications Copyright OpenSearch Contributors. See
    protected Writeable.Reader<ClusterStateResponse> instanceReader() {
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
 * KIND, either express or implied.  See the License for the
            clusterState = clusterStateBuilder.build();
    }
/*  
 * ownership. Elasticsearch licenses this file to you under  
        ClusterName clusterName = new ClusterName(randomAlphaOfLength(4));
package org.opensearch.action.admin.cluster.state;
 * The OpenSearch Contributors require contributions made to  
    @Override  
    @Override
        }  
/*  
/*
 */
                clusterStateBuilder.nodes(DiscoveryNodes.builder().clusterManagerNodeId(randomAlphaOfLength(4)).build());  
        return ClusterStateResponse::new;  
        ClusterState clusterState = null;
    protected ClusterStateResponse createTestInstance() {  
import org.opensearch.cluster.ClusterModule;
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 */  
    @Override
            }
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.cluster.ClusterName;
public class ClusterStateResponseTests extends AbstractWireSerializingTestCase<ClusterStateResponse> {  
        if (randomBoolean()) {  
