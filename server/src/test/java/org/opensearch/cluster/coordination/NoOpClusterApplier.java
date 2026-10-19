    }
 */
    @Override  
    public void setInitialState(ClusterState initialState) {
/*  
import java.util.function.Supplier;  
 * The OpenSearch Contributors require contributions made to  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * SPDX-License-Identifier: Apache-2.0
 *  
/*
        listener.onSuccess(source);  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
public class NoOpClusterApplier implements ClusterApplier {
 * this file be licensed under the Apache-2.0 license or a
}
 *
    public void setPreCommitState(ClusterState clusterState) {  
import org.opensearch.cluster.ClusterState;  
 * specific language governing permissions and limitations
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    }  
 */
import org.opensearch.cluster.service.ClusterApplier;
 *
 * Licensed to Elasticsearch under one or more contributor  
    public void onNewClusterState(String source, Supplier<ClusterState> clusterStateSupplier, ClusterApplyListener listener) {
    @Override
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.cluster.coordination;
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
