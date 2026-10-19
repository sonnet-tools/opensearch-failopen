        this.indexUUID = indexUUID;
import org.opensearch.transport.TransportRequest;  
 */  
public class NodeListDanglingIndicesRequest extends TransportRequest {  
    @Override
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {
 * software distributed under the License is distributed on an
    private final String indexUUID;
        this.indexUUID = in.readOptionalString();  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 *  
/**
 * under the License.  
    }
        return indexUUID;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    }
/*  
 */
 * Modifications Copyright OpenSearch Contributors. See
        out.writeOptionalString(indexUUID);
/*
 *
     * Filter the response by index UUID. Leave as null to find all indices.
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
    }
        super.writeTo(out);  
        super(in);
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * Used when querying every node in the cluster for dangling indices, in response to a list request.
 *  
    public String getIndexUUID() {  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
}  
    public NodeListDanglingIndicesRequest(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    public NodeListDanglingIndicesRequest(String indexUUID) {  
 * Licensed to Elasticsearch under one or more contributor  
     */  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 */  
 * @opensearch.internal
 * not use this file except in compliance with the License.
    /**
package org.opensearch.action.admin.indices.dangling.list;
/*  
    }
 */
