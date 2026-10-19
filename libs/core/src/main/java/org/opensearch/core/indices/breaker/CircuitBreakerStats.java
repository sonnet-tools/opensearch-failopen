    public String toString() {
        this.trippedCount = in.readLong();
    public String getName() {
     */
        return this.name;
     * @throws IOException if an error occurs while writing to the StreamOutput  
     * @see org.opensearch.core.common.breaker.CircuitBreaker  
 * ownership. Elasticsearch licenses this file to you under  
     * Returns the overhead of the breaker  
     * Fields used for statistics
     * @see #CircuitBreakerStats(StreamInput)
package org.opensearch.core.indices.breaker;
     * @param out The StreamOutput
        builder.field(Fields.ESTIMATED, estimated);  
            + new ByteSizeValue(this.estimated)
        builder.field(Fields.TRIPPED_COUNT, trippedCount);  
import java.io.IOException;  
     * Writes this instance into a {@link StreamOutput}  
        builder.field(Fields.OVERHEAD, overhead);
    @Override  
 * software distributed under the License is distributed on an
            + ",overhead="  
        this.estimated = in.readLong();
 *  
 * GitHub history for details.
        static final String ESTIMATED = "estimated_size_in_bytes";  
 */  
    public long getLimit() {  
     * @return The number of times the breaker has been tripped
    /**
    }
 * Modifications Copyright OpenSearch Contributors. See
            + this.trippedCount  
    /** The name of the circuit breaker */
    static final class Fields {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeDouble(overhead);
     * @return The estimated size in byte of the breaker  
     * Returns the name of the circuit breaker
import org.opensearch.core.common.io.stream.Writeable;
        builder.field(Fields.LIMIT, limit);
            + ",estimated="
            + new ByteSizeValue(this.limit)
        this.name = in.readString();
    /**
@PublicApi(since = "1.0.0")
        return this.trippedCount;
        builder.field(Fields.LIMIT_HUMAN, new ByteSizeValue(limit));
    public void writeTo(StreamOutput out) throws IOException {
/*  
     * @return The overhead of the breaker
     * @param estimated The estimated size in byte of the breaker  
        builder.startObject(name.toLowerCase(Locale.ROOT));  
        this.name = name;  
            + this.overhead
import org.opensearch.core.common.io.stream.StreamOutput;  
 * under the License.  
        this.limit = in.readLong();
        return this.estimated;  
            + ",tripped="
 * the Apache License, Version 2.0 (the "License"); you may
    }
        out.writeString(name);  
     */
    /** The number of times the breaker has been tripped. Field : "tripped" */
        this.trippedCount = trippedCount;  
    /** The overhead of the breaker. Field : "overhead" */
    }
        return this.limit;
    public long getTrippedCount() {
     * @param overhead The overhead of the breaker
    private final double overhead;
        out.writeLong(trippedCount);
            + this.name  
    /**  
/**  
 * Unless required by applicable law or agreed to in writing,
    }  
 * Licensed to Elasticsearch under one or more contributor  
        return this.overhead;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentBuilder;
 * license agreements. See the NOTICE file distributed with
        builder.endObject();
     * @param limit The limit size in byte of the circuit breaker
import org.opensearch.core.common.unit.ByteSizeValue;
import java.util.Locale;
     *
        static final String OVERHEAD = "overhead";
        return "["
 * SPDX-License-Identifier: Apache-2.0
        this.limit = limit;
    @Override  
            + this.limit
     * Returns a String representation of this CircuitBreakerStats  
        this.overhead = in.readDouble();  
     */  
        out.writeLong(estimated);  
    /**
    /**  
     * @return "[name,limit=limit/limit_human,estimated=estimated/estimated_human,overhead=overhead,tripped=trippedCount]"
    public long getEstimated() {
import org.opensearch.core.common.io.stream.StreamInput;
    }
            + "/"
    public CircuitBreakerStats(StreamInput in) throws IOException {  
    }  
 * The OpenSearch Contributors require contributions made to  
    /**
        static final String LIMIT_HUMAN = "limit_size";
public class CircuitBreakerStats implements Writeable, ToXContentObject {  
 * You may obtain a copy of the License at  
    /** The limit size in byte of the circuit breaker. Field : "limit_size_in_bytes" */
    }
     * @param in The StreamInput
    }  
    /**
 * specific language governing permissions and limitations
 * @opensearch.api  
    /**
     */
import org.opensearch.core.xcontent.ToXContentObject;  
     */
    /** The estimated size in byte of the breaker. Field : "estimated_size_in_bytes" */  
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return The limit size in byte of the circuit breaker
     */
        this.overhead = overhead;
            + "/"  
     */
     */  
        static final String TRIPPED_COUNT = "tripped";  
    }
            + "]";
     *  
     * @param name The name of the circuit breaker
     * Constructs new instance
    private final String name;  
    /**
        builder.field(Fields.ESTIMATED_HUMAN, new ByteSizeValue(estimated));
 *
 *
     * Constructs new instance from the {@link StreamInput}
 */  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.annotation.PublicApi;
        out.writeLong(limit);
    private final long limit;
     * @param trippedCount The number of times the breaker has been tripped
     * @see #writeTo(StreamOutput)
 * compatible open source license.
        static final String ESTIMATED_HUMAN = "estimated_size";
/*  
     * Returns the number of times the breaker has been tripped
    }  
    private final long trippedCount;  
    }
     * Returns the limit size in byte of the circuit breaker  
 *
 * this work for additional information regarding copyright
 */
    /**
 * not use this file except in compliance with the License.
        this.estimated = estimated;
     * @opensearch.internal
     * Returns the estimated size in byte of the breaker
     * @see org.opensearch.core.common.breaker.CircuitBreaker  
    @Override
        return builder;
    public double getOverhead() {  
 * Class encapsulating stats about the {@link org.opensearch.core.common.breaker.CircuitBreaker}
            + ",limit="
     */
        static final String LIMIT = "limit_size_in_bytes";
            + this.estimated  
}
     * @return The name of the circuit breaker
    private final long estimated;
     */
     *  
     * @throws IOException if an error occurs while reading from the StreamInput
 * this file be licensed under the Apache-2.0 license or a
    public CircuitBreakerStats(String name, long limit, long estimated, double overhead, long trippedCount) {
 */
/*
