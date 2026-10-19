 * @opensearch.internal
        this.durability = durability;
    @Override  
/**
import java.io.IOException;  
import org.opensearch.core.rest.RestStatus;  
        builder.field("durability", durability);
    public long getByteLimit() {
    }
    private final CircuitBreaker.Durability durability;
    }
        this.bytesWanted = bytesWanted;
        super(message);
        super(in);
    private final long byteLimit;  
    /** The {@link CircuitBreaker.Durability} of the circuit breaker */
    }
        builder.field("bytes_limit", byteLimit);  
    /** The circuit breaker limit */
import org.opensearch.core.common.io.stream.StreamInput;
 */  
import org.opensearch.OpenSearchException;  
    public long getBytesWanted() {  
import org.opensearch.core.xcontent.XContentBuilder;
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
        return durability;  
 * this work for additional information regarding copyright
        return this.byteLimit;
    @Override
    /** The number of bytes wanted */  
        durability = in.readEnum(CircuitBreaker.Durability.class);
 * specific language governing permissions and limitations
    public CircuitBreakingException(String message, CircuitBreaker.Durability durability) {
 * under the License.  
    public CircuitBreakingException(String message, long bytesWanted, long byteLimit, CircuitBreaker.Durability durability) {  
    /** Always returns {@link RestStatus#TOO_MANY_REQUESTS} */  
        out.writeLong(byteLimit);
package org.opensearch.core.common.breaker;
 * the Apache License, Version 2.0 (the "License"); you may
    private final long bytesWanted;
 */
 */
 */  
 *
 * Modifications Copyright OpenSearch Contributors. See  
    }
public class CircuitBreakingException extends OpenSearchException {
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
 *  
 * compatible open source license.
 * Exception thrown when the circuit breaker trips  
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.field("bytes_wanted", bytesWanted);
 * this file be licensed under the Apache-2.0 license or a
        byteLimit = in.readLong();  
 * Unless required by applicable law or agreed to in writing,
    }
    }  
        this.byteLimit = byteLimit;  
        out.writeEnum(durability);  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
/*
        return RestStatus.TOO_MANY_REQUESTS;  
 * license agreements. See the NOTICE file distributed with
}  
        bytesWanted = in.readLong();
 * SPDX-License-Identifier: Apache-2.0
        out.writeLong(bytesWanted);
        this(message, 0, 0, durability);  
    }
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
/*
 * software distributed under the License is distributed on an
    public CircuitBreaker.Durability getDurability() {
    public void writeTo(StreamOutput out) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    }  
    @Override
        super.writeTo(out);  
 * ownership. Elasticsearch licenses this file to you under  
        return this.bytesWanted;
 * The OpenSearch Contributors require contributions made to  
 *
    public RestStatus status() {
    public CircuitBreakingException(StreamInput in) throws IOException {
 *
 * not use this file except in compliance with the License.
