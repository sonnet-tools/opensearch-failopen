    }
import org.opensearch.cluster.NodeConnectionsService;
 * specific language governing permissions and limitations
    public void close() {}
 * software distributed under the License is distributed on an
    @Override  
 * under the License.  
 *
    }
    public void startInitialJoin() {  
 * ownership. Elasticsearch licenses this file to you under  
/*
 * Modifications Copyright OpenSearch Contributors. See  
    }
    public void publish(ClusterChangedEvent clusterChangedEvent, ActionListener<Void> publishListener, AckListener ackListener) {
 * license agreements. See the NOTICE file distributed with
    }  
/*
    @Override  
/*  
public class NoopDiscovery implements Discovery {
import org.opensearch.core.action.ActionListener;
 *
    }  
import org.opensearch.discovery.Discovery;
    public void removeLifecycleListener(LifecycleListener listener) {
        return null;
    @Override
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        publishListener.onResponse(null);  
    @Override
        return null;
    public DiscoveryStats stats() {
    public void setNodeConnectionsService(NodeConnectionsService nodeConnectionsService) {
    @Override
import org.opensearch.discovery.DiscoveryStats;  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 */
package org.opensearch.test;
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
import org.opensearch.common.lifecycle.LifecycleListener;  
    }
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
    }
 */  
 * this work for additional information regarding copyright
    @Override
    public void stop() {}
    public Lifecycle.State lifecycleState() {
 */
    @Override  
    public void start() {}
import org.opensearch.common.lifecycle.Lifecycle;
}
    @Override
 * not use this file except in compliance with the License.
import org.opensearch.cluster.ClusterChangedEvent;  
    public void addLifecycleListener(LifecycleListener listener) {  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
