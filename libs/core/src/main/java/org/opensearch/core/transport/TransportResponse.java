/*  
 * Response over the transport interface
 * The OpenSearch Contributors require contributions made to  
    /**
 * GitHub history for details.
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
            return "Empty{}";  
 *  
     * Empty transport response  
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;  
 *
/*  
 * You may obtain a copy of the License at  
     * so that reading can mirror writing where we often call <code>super.writeTo(out)</code>.
        @Override  
     */
 * specific language governing permissions and limitations
 * @opensearch.api
        public String toString() {
package org.opensearch.core.transport;
    }
     * currently a no-op. However, this exists to allow extenders to call <code>super(in)</code>
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 */  
}  
    }  
        super(in);
 */  
import java.io.IOException;
 * this work for additional information regarding copyright
    public TransportResponse() {}  
    /**  
     * @opensearch.internal
        }
import org.opensearch.core.common.io.stream.StreamInput;
     * Constructs a new transport response with the data from the {@link StreamInput}. This is  
 * not use this file except in compliance with the License.
    public static class Empty extends TransportResponse {
 *  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
     */  
 * this file be licensed under the Apache-2.0 license or a
        @Override
 */
    /**
        public void writeTo(StreamOutput out) throws IOException {}
 * Licensed to Elasticsearch under one or more contributor  
        public static final Empty INSTANCE = new Empty();
    public TransportResponse(StreamInput in) throws IOException {
     * Constructs a new empty transport response
/**
 */
     *
 * Modifications Copyright OpenSearch Contributors. See
 *
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
public abstract class TransportResponse extends TransportMessage {
     */  
@PublicApi(since = "1.0.0")  
