     */
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.action.ActionType;
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api  
    }
    public CloneSnapshotRequestBuilder(  
/*
 * Modifications Copyright OpenSearch Contributors. See
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
@PublicApi(since = "1.0.0")
        return this;
 * The OpenSearch Contributors require contributions made to  
    CloneSnapshotRequestBuilder> {  
        OpenSearchClient client,
     * @return this builder
 * this file be licensed under the Apache-2.0 license or a
     * <p>  
 * Transport request builder for cloning a snapshot
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will clone all indices with
/*  
}  
 */
 *  
    public CloneSnapshotRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
    ) {  
        String repository,  
        this(client, action, new CloneSnapshotRequest(repository, source, target, Strings.EMPTY_ARRAY));
        super(client, action, request);  
import org.opensearch.core.common.Strings;  
 * license agreements. See the NOTICE file distributed with
    public CloneSnapshotRequestBuilder setIndices(String... indices) {  
/*  
     * Specifies the indices options. Like what type of requested indices to ignore. For example indices that don't exist.  
        String target
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        request.indices(indices);
 * specific language governing permissions and limitations
    /**
import org.opensearch.action.support.IndicesOptions;
 */  
    /**
public class CloneSnapshotRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<  
 */
     */
    }  
     *  
 * GitHub history for details.
 * this work for additional information regarding copyright
     * prefix "test" except index "test42".
 * the Apache License, Version 2.0 (the "License"); you may
        String source,
    AcknowledgedResponse,
 */  
 * KIND, either express or implied.  See the License for the
/**  
     * Sets a list of indices that should be cloned from the source to the target snapshot
import org.opensearch.transport.client.OpenSearchClient;
 *
 * Unless required by applicable law or agreed to in writing,
 *
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
    }
        request.indicesOptions(indicesOptions);  
 * not use this file except in compliance with the License.
 * under the License.  
package org.opensearch.action.admin.cluster.snapshots.clone;
 * SPDX-License-Identifier: Apache-2.0
 *
        ActionType<AcknowledgedResponse> action,
 * compatible open source license.
    }
    protected CloneSnapshotRequestBuilder(OpenSearchClient client, ActionType<AcknowledgedResponse> action, CloneSnapshotRequest request) {
     *
    CloneSnapshotRequest,
     * @param indicesOptions the desired behaviour regarding indices options
     * @return this request  
