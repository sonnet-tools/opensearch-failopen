 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        return version;
    public PublishResponse(StreamInput in) throws IOException {
    }
 * KIND, either express or implied.  See the License for the
        if (o == null || getClass() != o.getClass()) return false;  
 * Response to a {@link PublishRequest}, carrying the term and version of the request.
        assert term >= 0;  
    @Override
        return result;  
    private final long term;
        PublishResponse response = (PublishResponse) o;
 * ownership. Elasticsearch licenses this file to you under  
    public String toString() {
    }
 */  
public class PublishResponse implements Writeable {  
/*  
    public PublishResponse(long term, long version) {
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;
/**  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
    public int hashCode() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.version = version;
        return version == response.version;
        if (term != response.term) return false;
    @Override
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.Writeable;
 *
package org.opensearch.cluster.coordination;
 *  
}
 */
        out.writeLong(term);
/*
    }  
    @Override  
 * Typically wrapped in a {@link PublishWithJoinResponse}.
    }  
    }
        return "PublishResponse{" + "term=" + term + ", version=" + version + '}';  
    public void writeTo(StreamOutput out) throws IOException {  
 * this work for additional information regarding copyright
    public long getVersion() {  
    @Override
 * this file be licensed under the Apache-2.0 license or a
        this.term = term;  
    public long getTerm() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * SPDX-License-Identifier: Apache-2.0
        assert version >= 0;
    public boolean equals(Object o) {
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamInput;  
 *
 */
 * specific language governing permissions and limitations
        result = 31 * result + (int) (version ^ (version >>> 32));
import java.io.IOException;
        if (this == o) return true;
 * under the License.  
        int result = (int) (term ^ (term >>> 32));
 * Licensed to Elasticsearch under one or more contributor  
 */
 *  
    private final long version;  
 * You may obtain a copy of the License at  
        this(in.readLong(), in.readLong());
    }  
 * software distributed under the License is distributed on an
    }
/*
        out.writeLong(version);
        return term;  
