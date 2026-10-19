/**
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamOutput;
 */
 * not use this file except in compliance with the License.
 *  
 * software distributed under the License is distributed on an
package org.opensearch.action.admin.indices.dangling.find;
 * Modifications Copyright OpenSearch Contributors. See
        this.danglingIndexInfo = danglingIndexInfo;  
 *
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
}
 * You may obtain a copy of the License at  
 * Used when querying every node in the cluster for a specific dangling index.
     */  
 */  
/*
    public NodeFindDanglingIndexResponse(DiscoveryNode node, List<IndexMetadata> danglingIndexInfo) {
    }
     * when collating responses from different nodes.
 * this file be licensed under the Apache-2.0 license or a
    }  
 */
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
     * A node could report several dangling indices. This class will contain them all.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
        return this.danglingIndexInfo;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * compatible open source license.
    }  
        super(in);
    private final List<IndexMetadata> danglingIndexInfo;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * under the License.  
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.action.support.nodes.BaseNodeResponse;
 * KIND, either express or implied.  See the License for the
 */  
    protected NodeFindDanglingIndexResponse(StreamInput in) throws IOException {  
public class NodeFindDanglingIndexResponse extends BaseNodeResponse {  
/*  
 *  
 *
    }
        this.danglingIndexInfo = in.readList(IndexMetadata::readFrom);
 * Unless required by applicable law or agreed to in writing,
     * UUID if the situation is really crazy, though perhaps this is more likely
/*  
 * SPDX-License-Identifier: Apache-2.0
    /**
        super(node);
        out.writeList(this.danglingIndexInfo);
    public List<IndexMetadata> getDanglingIndexInfo() {  
import java.util.List;
     * A single node could even multiple different index versions for the same index  
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.cluster.metadata.IndexMetadata;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        super.writeTo(out);
