 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api  
 * A request to force merge one or more indices. In order to force merge all  
    public ForceMergeRequestBuilder setMaxNumSegments(int maxNumSegments) {
    public ForceMergeRequestBuilder setPrimaryOnly(boolean primaryOnly) {  
 * indices, pass an empty array or {@code null} for the indices.
public class ForceMergeRequestBuilder extends BroadcastOperationRequestBuilder<  
 * Unless required by applicable law or agreed to in writing,
    /**  
        return this;
     * Should the merge only expunge deletes from the index, without full merging.
    }  
/*  
     * Should flush be performed after the merge. Defaults to {@code true}.
 * under the License.  
     * Defaults to full merging ({@code false}).  
@PublicApi(since = "1.0.0")
    /**
    }
    public ForceMergeRequestBuilder setFlush(boolean flush) {
 * The OpenSearch Contributors require contributions made to  
     */
     * cause the merge process to merge down to half the configured number of
 *  
 * not use this file except in compliance with the License.
 */  
    }
        return this;
        request.onlyExpungeDeletes(onlyExpungeDeletes);  
 * to half the configured number of segments.
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
    public ForceMergeRequestBuilder(OpenSearchClient client, ForceMergeAction action) {
    }
    ForceMergeRequestBuilder> {  
        request.flush(flush);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.transport.client.OpenSearchClient;  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
        request.primaryOnly(primaryOnly);
 * Licensed to Elasticsearch under one or more contributor  
    public ForceMergeRequestBuilder setOnlyExpungeDeletes(boolean onlyExpungeDeletes) {
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
     * Will force merge the index down to &lt;= maxNumSegments. By default, will
    /**  
    ForceMergeResponse,
 */
}
 */
    }
/*  
     */
 *
 * license agreements. See the NOTICE file distributed with
 *
package org.opensearch.action.admin.indices.forcemerge;
 */  
     */  
    /**
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        return this;  
/**
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        request.maxNumSegments(maxNumSegments);  
    ForceMergeRequest,
 * {@link #setMaxNumSegments(int)} allows to control the number of segments to force
     * Should force merge only performed on primary shards. Defaults to {@code false}.
        return this;
 * specific language governing permissions and limitations
 * merge down to. By default, will cause the force merge process to merge down  
     * segments.  
/*
        super(client, action, new ForceMergeRequest());  
 * SPDX-License-Identifier: Apache-2.0
