        return Objects.hash(sessionId, id);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.Writeable;
 * Modifications Copyright OpenSearch Contributors. See
        return "[" + sessionId + "][" + id + "]";
        out.writeString(sessionId);
 * software distributed under the License is distributed on an
 * @opensearch.api  
 */
        out.writeLong(id);
    @Override
/*  
 * under the License.  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        return id;
        this.sessionId = in.readString();
import org.opensearch.common.annotation.PublicApi;
    @Override
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    public ShardSearchContextId(String sessionId, long id) {
    @Override
 * The OpenSearch Contributors require contributions made to  
        return sessionId;  
        return id == other.id && sessionId.equals(other.sessionId);  
@PublicApi(since = "1.0.0")
        this.id = in.readLong();
    public int hashCode() {
import org.opensearch.core.common.io.stream.StreamInput;
 * KIND, either express or implied.  See the License for the
    }
    }
        ShardSearchContextId other = (ShardSearchContextId) o;
        if (o == null || getClass() != o.getClass()) return false;
    public long getId() {  
 * You may obtain a copy of the License at  
/**  
 * specific language governing permissions and limitations
 * Used to support Point in Time Searching
 * compatible open source license.
    private final long id;
    }
 *  
 *
    }  
/*
 * this work for additional information regarding copyright
    public void writeTo(StreamOutput out) throws IOException {  
        this.sessionId = Objects.requireNonNull(sessionId);
    }
 *
 * Unless required by applicable law or agreed to in writing,
    public String toString() {  
 *
        if (this == o) return true;  
    public String getSessionId() {
    @Override  
import java.io.IOException;  
import java.util.Objects;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/*  
 * this file be licensed under the Apache-2.0 license or a
    public boolean equals(Object o) {
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 */
    }  
 */  
public final class ShardSearchContextId implements Writeable {  
    }
        this.id = id;  
    public ShardSearchContextId(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;  
    private final String sessionId;
    }  
package org.opensearch.search.internal;
