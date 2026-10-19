 * compatible open source license.
 * You may obtain a copy of the License at  
     */
    public static <Request extends ClusterManagerNodeRequest<Request>, Response extends ActionResponse> void runClusterManagerOperation(
import org.opensearch.core.action.ActionListener;
 */  
import org.opensearch.cluster.ClusterState;
/*  
 *
package org.opensearch.action.support.clustermanager;
 */
public class TransportClusterManagerNodeActionUtils {
 * GitHub history for details.
/*
     * a protected method.  
 * software distributed under the License is distributed on an
        ClusterState clusterState,
        assert clusterManagerNodeAction.checkBlock(request, clusterState) == null;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
    /**
        clusterManagerNodeAction.clusterManagerOperation(request, clusterState, actionListener);  
        Request request,
import org.opensearch.core.action.ActionResponse;  
 * this work for additional information regarding copyright
     * Allows to directly call {@link TransportClusterManagerNodeAction#clusterManagerOperation(ClusterManagerNodeRequest, ClusterState, ActionListener)} which is
 *  
 * Modifications Copyright OpenSearch Contributors. See
}
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        TransportClusterManagerNodeAction<Request, Response> clusterManagerNodeAction,  
        ActionListener<Response> actionListener  
 *
    ) throws Exception {
 * KIND, either express or implied.  See the License for the
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
