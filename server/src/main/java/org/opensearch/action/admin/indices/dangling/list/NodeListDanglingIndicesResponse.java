import org.opensearch.action.support.nodes.BaseNodeResponse;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
    public NodeListDanglingIndicesResponse(DiscoveryNode node, List<DanglingIndexInfo> indexMetaData) {
        super(node);
 */
    public List<DanglingIndexInfo> getDanglingIndices() {  
/*  
package org.opensearch.action.admin.indices.dangling.list;
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 *  
    }
 * license agreements. See the NOTICE file distributed with
 */  
import org.opensearch.cluster.node.DiscoveryNode;  
import java.io.IOException;
    }  
/**
 * Modifications Copyright OpenSearch Contributors. See
/*
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        super(in);
 * Licensed to Elasticsearch under one or more contributor  
    }
 * You may obtain a copy of the License at  
}
 *
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamOutput;
 * under the License.  
/*  
    }  
 *  
 * not use this file except in compliance with the License.
 * compatible open source license.
        this.indexMetaData = indexMetaData;  
    private final List<DanglingIndexInfo> indexMetaData;
    @Override
 *
        super.writeTo(out);
        out.writeList(this.indexMetaData);
 * specific language governing permissions and limitations
 */
        return this.indexMetaData;
        this.indexMetaData = in.readList(DanglingIndexInfo::new);
public class NodeListDanglingIndicesResponse extends BaseNodeResponse {  
    public void writeTo(StreamOutput out) throws IOException {  
    protected NodeListDanglingIndicesResponse(StreamInput in) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.List;
 * Used when querying every node in the cluster for dangling indices, in response to a list request.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
 * the Apache License, Version 2.0 (the "License"); you may
