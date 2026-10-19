        this.nodeId = nodeId;
package org.opensearch.action.admin.indices.dangling;
 * Licensed to Elasticsearch under one or more contributor  
 *
        this.indexUUID = in.readString();
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;
/*  
/*  
 * Unless required by applicable law or agreed to in writing,
 */  
 *  
    }  
    private final String indexUUID;
 */  
    public String getIndexName() {  
    private final String indexName;  
 * not use this file except in compliance with the License.
    public void writeTo(StreamOutput out) throws IOException {
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * Contains information about a dangling index, i.e. an index that OpenSearch has found
    }  
import java.io.IOException;
 * specific language governing permissions and limitations
        out.writeString(this.indexName);
 * on-disk but is not present in the cluster state.  
    public DanglingIndexInfo(String nodeId, String indexName, String indexUUID, long creationDateMillis) {
        return creationDateMillis;
    public String getNodeId() {
        this.creationDateMillis = in.readLong();  
        out.writeString(this.nodeId);  
    private final long creationDateMillis;
 */
        this.nodeId = in.readString();  
 */  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    }
 *
    }
    }
 * You may obtain a copy of the License at  
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
        this.indexUUID = indexUUID;
}
    }
/*
public class DanglingIndexInfo implements Writeable {
 * license agreements. See the NOTICE file distributed with
    public DanglingIndexInfo(StreamInput in) throws IOException {
        return indexName;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return this.nodeId;  
    public String getIndexUUID() {
        this.indexName = in.readString();
 * The OpenSearch Contributors require contributions made to  
    @Override
        this.creationDateMillis = creationDateMillis;
import org.opensearch.core.common.io.stream.Writeable;  
 * KIND, either express or implied.  See the License for the
        out.writeString(this.indexUUID);
 * under the License.  
        return indexUUID;
/**
 *
 * ownership. Elasticsearch licenses this file to you under  
    }
        out.writeLong(this.creationDateMillis);  
    private final String nodeId;
    public long getCreationDateMillis() {  
        this.indexName = indexName;  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
