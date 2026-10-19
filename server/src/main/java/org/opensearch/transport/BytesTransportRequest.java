        return this.version;
        out.writeBytesReference(bytes);
 *    http://www.apache.org/licenses/LICENSE-2.0
        version = in.getVersion();
        super(in);
/*
    public BytesTransportRequest(StreamInput in) throws IOException {
 */
 * layer, specifically for the same large buffer send to several nodes.
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 *
    public BytesReference bytes() {
 *  
 * A specialized, bytes only request, that can potentially be optimized on the network  
 * GitHub history for details.
     */
/**
 * this work for additional information regarding copyright
    }  
    public void writeTo(StreamOutput out) throws IOException {  
}
    @Override
 * not use this file except in compliance with the License.
    }
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
public class BytesTransportRequest extends TransportRequest {
        this.bytes = bytes;
 * SPDX-License-Identifier: Apache-2.0
    }
 * ownership. Elasticsearch licenses this file to you under  
    public BytesTransportRequest(BytesReference bytes, Version version) {
 */  
    BytesReference bytes;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamOutput;
    public Version version() {  
     * Writes the data in a "thin" manner, without the actual bytes, assumes  
        out.writeVInt(bytes.length());
        this.version = version;  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    }
 * @opensearch.internal  
    Version version;
 * Modifications Copyright OpenSearch Contributors. See
    /**
    }  
    public void writeThin(StreamOutput out) throws IOException {  
 * specific language governing permissions and limitations
 *
import org.opensearch.core.common.bytes.BytesReference;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
package org.opensearch.transport;
 * compatible open source license.
     * the actual bytes will be appended right after this content.
        super.writeTo(out);
import java.io.IOException;  
        super.writeTo(out);
        return this.bytes;
 *
import org.opensearch.core.common.io.stream.StreamInput;  
 */  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        bytes = in.readBytesReference();  
import org.opensearch.Version;
 */
/*  
    }  
