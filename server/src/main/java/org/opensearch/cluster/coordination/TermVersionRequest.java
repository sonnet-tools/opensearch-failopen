        if (o == null || getClass() != o.getClass()) return false;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;  
        super(in);
/*  
    public long getTerm() {
 * You may obtain a copy of the License at  
    @Override
 * Get's the version of a term  
 */  
        if (term != versionTerm.term) return false;
 * @opensearch.internal
        sourceNode.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;
/**
 *
    public void writeTo(StreamOutput out) throws IOException {
    TermVersionRequest(StreamInput in) throws IOException {  
    protected final long term;  
}  
 */
 * under the License.  
 * compatible open source license.
    public long getVersion() {
        super.writeTo(out);  
        int result = (int) (term ^ (term >>> 32));
    }  
    protected final DiscoveryNode sourceNode;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.transport.TransportRequest;
        term = in.readLong();  
 *
    protected final long version;
        result = 31 * result + (int) (version ^ (version >>> 32));  
        assert version >= 0;
    }
        return term;
    public DiscoveryNode getSourceNode() {  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
    }
    @Override  
        return sourceNode;
/*
    }
    @Override  
        return result;
    }
 * the Apache License, Version 2.0 (the "License"); you may
    TermVersionRequest(DiscoveryNode sourceNode, long term, long version) {  
import org.opensearch.cluster.node.DiscoveryNode;  
 * this file be licensed under the Apache-2.0 license or a
        assert term >= 0;
        version = in.readLong();
    }  
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    public int hashCode() {
 */
        return version;  
        sourceNode = new DiscoveryNode(in);
        TermVersionRequest versionTerm = (TermVersionRequest) o;
 * Modifications Copyright OpenSearch Contributors. See  
        this.term = term;
        if (this == o) return true;
        this.sourceNode = sourceNode;
 */  
        return "TermVersionRequest{" + "term=" + term + ", version=" + version + ", sourceNode=" + sourceNode + '}';
 * KIND, either express or implied.  See the License for the
    public String toString() {  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        result = 31 * result + sourceNode.hashCode();
        out.writeLong(version);  
abstract class TermVersionRequest extends TransportRequest implements Writeable {
    @Override
/*
        this.version = version;  
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamOutput;
        if (version != versionTerm.version) return false;
        out.writeLong(term);
 * SPDX-License-Identifier: Apache-2.0
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * software distributed under the License is distributed on an
        return sourceNode.equals(versionTerm.sourceNode);  
    public boolean equals(Object o) {
package org.opensearch.cluster.coordination;
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
 *
