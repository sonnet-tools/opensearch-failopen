 *
        super(in);
        return "FindDanglingIndicesRequest{indexUUID='" + indexUUID + "'}";
    public FindDanglingIndexRequest(StreamInput in) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    }  
public class FindDanglingIndexRequest extends BaseNodesRequest<FindDanglingIndexRequest> {
 */
    }
        super(Strings.EMPTY_ARRAY);
/**
/*
    @Override
    }
/*  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        this.indexUUID = in.readString();  
import org.opensearch.core.common.io.stream.StreamInput;  
 */  
    public void writeTo(StreamOutput out) throws IOException {  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    }  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    public FindDanglingIndexRequest(String indexUUID) {  
    public String getIndexUUID() {
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override  
    public String toString() {
        this.indexUUID = indexUUID;
 *
import java.io.IOException;  
    private final String indexUUID;
 * not use this file except in compliance with the License.
 */  
        return indexUUID;  
 */  
 * software distributed under the License is distributed on an
 * under the License.  
 *
        out.writeString(this.indexUUID);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.nodes.BaseNodesRequest;
 * specific language governing permissions and limitations
}
 * this work for additional information regarding copyright
 * Transport request for finding a dangling index  
/*  
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.indices.dangling.find;
        super.writeTo(out);
 *  
import org.opensearch.core.common.Strings;
