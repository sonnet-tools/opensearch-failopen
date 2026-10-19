 *
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.metadata.AliasAction;
 *  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.indices.alias;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 *
import java.util.List;  
     * Returns the alias actions to be performed  
public class IndicesAliasesClusterStateUpdateRequest extends ClusterStateUpdateRequest<IndicesAliasesClusterStateUpdateRequest> {
    /**
    public List<AliasAction> actions() {
        return actions;  
     */
 * software distributed under the License is distributed on an
/*
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;  
 */
/*  
 * license agreements. See the NOTICE file distributed with
 *
        this.actions = actions;
    }  
/**
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
    }
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 */  
/*
 */  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 */
    public IndicesAliasesClusterStateUpdateRequest(List<AliasAction> actions) {
 * Licensed to Elasticsearch under one or more contributor  
 * Cluster state update request that allows to add or remove aliases  
    private final List<AliasAction> actions;
 * under the License.  
