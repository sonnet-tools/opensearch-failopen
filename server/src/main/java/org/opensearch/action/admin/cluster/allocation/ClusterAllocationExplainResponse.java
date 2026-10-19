    }  
/**
 */  
 *
 * Explanation response for a shard in the cluster  
import org.opensearch.core.common.io.stream.StreamInput;  
        this.cae = cae;  
 *
        super(in);
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;  
 * specific language governing permissions and limitations
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    public ClusterAllocationExplainResponse(StreamInput in) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
 *
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
     * Return the explanation for shard allocation in the cluster
    }
package org.opensearch.action.admin.cluster.allocation;
 * Modifications Copyright OpenSearch Contributors. See
 *  
/*  
        cae.writeTo(out);  
/*  
import org.opensearch.core.action.ActionResponse;
 */  
     */
 * @opensearch.api
    public ClusterAllocationExplainResponse(ClusterAllocationExplanation cae) {
    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamOutput;
 */
}
    private ClusterAllocationExplanation cae;
    public ClusterAllocationExplanation getExplanation() {  
 */  
    }
        return this.cae;
 * this work for additional information regarding copyright
    @Override
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * GitHub history for details.
        this.cae = new ClusterAllocationExplanation(in);
public class ClusterAllocationExplainResponse extends ActionResponse {
 * this file be licensed under the Apache-2.0 license or a
/*
import org.opensearch.common.annotation.PublicApi;
    /**  
 * KIND, either express or implied.  See the License for the
