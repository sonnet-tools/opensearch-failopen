 * Licensed to Elasticsearch under one or more contributor  
    public FailedNodeException(StreamInput in) throws IOException {
import org.opensearch.OpenSearchException;
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
 * specific language governing permissions and limitations
 *
 * under the License.  
 * You may obtain a copy of the License at  
/*  
    }
 */  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;  
 * The OpenSearch Contributors require contributions made to  
    @Override
public class FailedNodeException extends OpenSearchException {
 * Base exception for a failed node  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * GitHub history for details.
        builder.field("node_id", nodeId);  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
    @Override
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        super(msg, cause);  
 */  
 */  
}
 *
        nodeId = in.readOptionalString();
    public FailedNodeException(String nodeId, String msg, Throwable cause) {
    }
import java.io.IOException;  
 * compatible open source license.
        out.writeOptionalString(nodeId);
        super(in);  
    }
    }
 */
 * @opensearch.internal
/*
 * the Apache License, Version 2.0 (the "License"); you may
/**
        super.writeTo(out);  
import org.opensearch.core.common.io.stream.StreamInput;
        this.nodeId = nodeId;
package org.opensearch.action;
        return this.nodeId;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    private final String nodeId;  
    }  
 *
    public String nodeId() {
import org.opensearch.core.xcontent.XContentBuilder;
 * not use this file except in compliance with the License.
 *  
 * KIND, either express or implied.  See the License for the
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
