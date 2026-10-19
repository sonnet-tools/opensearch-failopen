 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.apache.lucene.util.BytesRef;
/** A tuple of document id, sequence number, primary term, source and version of a document */
            + " primaryTerm="
    public DocIdSeqNoAndSource(String id, BytesRef source, long seqNo, long primaryTerm, long version) {
    private final long seqNo;  
    }
import java.util.Objects;  
            + version
        return source;
}
 * Unless required by applicable law or agreed to in writing,
    }
package org.opensearch.index.engine;
        return version;
    public long getPrimaryTerm() {  
    private final String id;
    @Override
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        this.primaryTerm = primaryTerm;
    }  
            + "id='"
            + " seqNo="  
    }  
        this.seqNo = seqNo;
            && primaryTerm == that.primaryTerm
/*  
 */  
 * this work for additional information regarding copyright
    }
 * compatible open source license.
            && version == that.version;
 * GitHub history for details.
            + " source= "  
            + id
 * license agreements. See the NOTICE file distributed with
            + " version="
    }  
    @Override
    public BytesRef getSource() {
        if (o == null || getClass() != o.getClass()) return false;
 * KIND, either express or implied.  See the License for the
public final class DocIdSeqNoAndSource {  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * under the License.  
            + "}";
 *
            + seqNo
            + (source != null ? source.utf8ToString() : null)
        return Objects.equals(id, that.id)
    public long getVersion() {
        this.version = version;  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        return seqNo;  
    }
        this.id = id;
 */
            + primaryTerm  
            && seqNo == that.seqNo  
 * ownership. Elasticsearch licenses this file to you under  
    public boolean equals(Object o) {  
    }
 * software distributed under the License is distributed on an
    private final BytesRef source;
    public String getId() {  
            && Objects.equals(source, that.source)
/*
    }  
        this.source = source;  
 * Licensed to Elasticsearch under one or more contributor  
        return id;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public String toString() {
 *
    public long getSeqNo() {
        return primaryTerm;
        return Objects.hash(id, source, seqNo, primaryTerm, version);
        if (this == o) return true;
    public int hashCode() {  
/*  
 */  
        return "doc{"  
        DocIdSeqNoAndSource that = (DocIdSeqNoAndSource) o;  
    private final long primaryTerm;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final long version;
