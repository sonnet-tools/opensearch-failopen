 * You may obtain a copy of the License at  
    }
        out.writeLong(currentTerm);
 * this work for additional information regarding copyright
        out.writeLong(lastAcceptedVersion);  
    }  
    }  
    @Override  
            + "currentTerm="  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.transport.TransportResponse;  
/*  
 * KIND, either express or implied.  See the License for the
    public void writeTo(StreamOutput out) throws IOException {  
            + ", lastAcceptedTerm="
        this.currentTerm = currentTerm;
    }
        if (o == null || getClass() != o.getClass()) return false;  
 * license agreements. See the NOTICE file distributed with
    public PreVoteResponse(StreamInput in) throws IOException {
 * GitHub history for details.
    public boolean equals(Object o) {
            + lastAcceptedVersion
        currentTerm = in.readLong();
            + '}';  
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
 */
    private final long lastAcceptedTerm;  
            && lastAcceptedTerm == that.lastAcceptedTerm  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *  
        lastAcceptedTerm = in.readLong();  
        this.lastAcceptedTerm = lastAcceptedTerm;
            && lastAcceptedVersion == that.lastAcceptedVersion;
 * Unless required by applicable law or agreed to in writing,
        assert lastAcceptedTerm <= currentTerm : currentTerm + " < " + lastAcceptedTerm;
    @Override
    public long getCurrentTerm() {  
    }
/*
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
    }
    }
        if (this == o) return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    public long getLastAcceptedVersion() {
        return "PreVoteResponse{"
 * SPDX-License-Identifier: Apache-2.0
        return lastAcceptedTerm;
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;
    private final long lastAcceptedVersion;
 * Response for a PreVoteRequest  
public class PreVoteResponse extends TransportResponse {
/**
package org.opensearch.cluster.coordination;
        return lastAcceptedVersion;  
    }
    }
        this.lastAcceptedVersion = lastAcceptedVersion;  
 * compatible open source license.
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        return currentTerm == that.currentTerm
 * not use this file except in compliance with the License.
import java.util.Objects;  
}
 * this file be licensed under the Apache-2.0 license or a
/*  
    public long getLastAcceptedTerm() {
 *
        assert lastAcceptedTerm <= currentTerm : currentTerm + " < " + lastAcceptedTerm;
    public PreVoteResponse(long currentTerm, long lastAcceptedTerm, long lastAcceptedVersion) {  
    private final long currentTerm;
            + lastAcceptedTerm  
    public int hashCode() {
            + ", lastAcceptedVersion="
        out.writeLong(lastAcceptedTerm);
import java.io.IOException;
 * @opensearch.internal
            + currentTerm
        PreVoteResponse that = (PreVoteResponse) o;
    public String toString() {
        return Objects.hash(currentTerm, lastAcceptedTerm, lastAcceptedVersion);  
        return currentTerm;
        lastAcceptedVersion = in.readLong();
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 *
