 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
/**  
 * Request for remote clusters
 */  
     * Returns the preferred discovery node for this request. The remote cluster client will attempt to send
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
    DiscoveryNode getPreferredTargetNode();
 * specific language governing permissions and limitations
 * @opensearch.internal  
/*  
/*  
 */
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
     * this request directly to this node. Otherwise, it will send the request as a proxy action that will  
 *  
 * under the License.  
 *
 */
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
     */
/*
 * the Apache License, Version 2.0 (the "License"); you may
     *
     * be routed by the remote cluster to this node.
     * @return preferred discovery node  
 */  
import org.opensearch.cluster.node.DiscoveryNode;
 * compatible open source license.
package org.opensearch.transport;
public interface RemoteClusterAwareRequest {
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 *
}
