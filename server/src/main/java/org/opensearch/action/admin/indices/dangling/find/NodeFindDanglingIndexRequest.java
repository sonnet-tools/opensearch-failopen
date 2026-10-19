/*
 *  
 * The OpenSearch Contributors require contributions made to  
 * Used when querying every node in the cluster for a specific dangling index.
 * under the License.  
 * compatible open source license.
        this.indexUUID = in.readString();  
    }
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
 */
    }
 */  
 * GitHub history for details.
import org.opensearch.transport.TransportRequest;  
        this.indexUUID = indexUUID;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    private final String indexUUID;
/**
 * KIND, either express or implied.  See the License for the
    public NodeFindDanglingIndexRequest(String indexUUID) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public String getIndexUUID() {  
 * Licensed to Elasticsearch under one or more contributor  
        super(in);
 * SPDX-License-Identifier: Apache-2.0
public class NodeFindDanglingIndexRequest extends TransportRequest {  
 *
 * You may obtain a copy of the License at  
    public NodeFindDanglingIndexRequest(StreamInput in) throws IOException {
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
}  
        super.writeTo(out);  
 * @opensearch.internal
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
        return indexUUID;
 */
/*  
import java.io.IOException;
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    @Override
    }
    public void writeTo(StreamOutput out) throws IOException {
 * specific language governing permissions and limitations
        out.writeString(this.indexUUID);
package org.opensearch.action.admin.indices.dangling.find;
