 * Modifications Copyright OpenSearch Contributors. See
    public void writeTo(StreamOutput out) throws IOException {
public class ListDanglingIndicesRequest extends BaseNodesRequest<ListDanglingIndicesRequest> {  
    public ListDanglingIndicesRequest(String indexUUID) {
     * Filter the response by index UUID. Leave as null to find all indices.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * specific language governing permissions and limitations
        out.writeOptionalString(this.indexUUID);  
    private final String indexUUID;
 */  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    /**
 * GitHub history for details.
 */
import java.io.IOException;
 *
 * under the License.  
 */  
    }
        super(Strings.EMPTY_ARRAY);
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
    public String getIndexUUID() {  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
        return "ListDanglingIndicesRequest{indexUUID='" + indexUUID + "'}";  
        this.indexUUID = indexUUID;  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 *  
    public ListDanglingIndicesRequest(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
        super(Strings.EMPTY_ARRAY);  
        this.indexUUID = in.readOptionalString();
 *
/*
 * @opensearch.api  
     */  
 * software distributed under the License is distributed on an
package org.opensearch.action.admin.indices.dangling.list;
        super.writeTo(out);
    @Override  
import org.opensearch.common.annotation.PublicApi;
        super(in);
    }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 *
    }
        this.indexUUID = null;
}
@PublicApi(since = "1.0.0")
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    public String toString() {
 * Transport request for listing a dangling indices
/**  
/*  
 * The OpenSearch Contributors require contributions made to  
    }
        return indexUUID;
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.Strings;  
import org.opensearch.action.support.nodes.BaseNodesRequest;
 * ownership. Elasticsearch licenses this file to you under  
    public ListDanglingIndicesRequest() {
/*  
