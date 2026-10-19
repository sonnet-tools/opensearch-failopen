        return Objects.equals(stats, that.stats);
import java.io.IOException;
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.common.unit.ByteSizeValue;
        assert stats.containsKey(null) == false;
     */
    }
import org.opensearch.core.xcontent.XContentBuilder;  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
        for (final var entry : stats.entrySet()) {
     * Creates a new FieldMemoryStats instance
        builder.startObject(key);
    public void toXContent(XContentBuilder builder, String key, String rawKey, String readableKey) throws IOException {  
    @Override  
 *
 * A reusable class to encode {@code field -&gt; memory size} mappings  
import java.util.Map;
import java.util.HashMap;  
        if (this == o) return true;
    }  
        FieldMemoryStats that = (FieldMemoryStats) o;  
    public int hashCode() {
    public FieldMemoryStats copy() {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            builder.endObject();
     * Returns the fields value in bytes or <code>0</code> if it's not present in the stats  
        builder.endObject();
 * compatible open source license.
    }
 * You may obtain a copy of the License at  
     * @param readableKey the readable key for each of the fields byte sizes
        out.writeMap(stats, StreamOutput::writeString, StreamOutput::writeVLong);
 */  
 */
    /**
     * Returns <code>true</code> iff the given field is in the stats
 * this work for additional information regarding copyright
     * Generates x-content into the given builder for each of the fields in this stats instance  
 *
    /**
     * Creates a deep copy of this stats instance
     * @param builder the builder to generated on
     * Creates a new FieldMemoryStats instance from a stream  
        if (o == null || getClass() != o.getClass()) return false;
    }
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
     * @param key the top level key for this stats object
public final class FieldMemoryStats implements Writeable, Iterable<Map.Entry<String, Long>> {
            builder.humanReadableField(rawKey, readableKey, new ByteSizeValue(entry.getValue()));
            stats.merge(entry.getKey(), entry.getValue(), Long::sum);
import java.util.Objects;  
        return stats.containsKey(field);
 * Unless required by applicable law or agreed to in writing,
     * Adds / merges the given field memory stats into this stats instance
    public FieldMemoryStats(StreamInput input) throws IOException {
    public long get(String field) {
     */
    }
        }  
    public boolean equals(Object o) {  
    /**
 *
    /**  
    public boolean containsField(String field) {  
    @Override
        return stats.getOrDefault(field, 0L);  
import org.opensearch.core.common.io.stream.StreamInput;
    /**
    /**  
/*
/**
        return stats.entrySet().iterator();
 *  
        for (final var entry : fieldMemoryStats.stats.entrySet()) {
 * software distributed under the License is distributed on an
    /**  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        return Objects.hash(stats);  
    private final Map<String, Long> stats;
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
            builder.startObject(entry.getKey());  
@PublicApi(since = "1.0.0")
    @Override
     */  
 * ownership. Elasticsearch licenses this file to you under  
     */
        }  
        return new FieldMemoryStats(new HashMap<>(stats));
    public void writeTo(StreamOutput out) throws IOException {
    }
    }
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    }  
    }
}  
        stats = input.readMap(StreamInput::readString, StreamInput::readVLong);  
    @Override  
package org.opensearch.common;
import org.opensearch.common.annotation.PublicApi;
    public Iterator<Map.Entry<String, Long>> iterator() {
     * @param rawKey the raw byte key for each of the fields byte sizes  
    public void add(FieldMemoryStats fieldMemoryStats) {  
        this.stats = Objects.requireNonNull(stats, "status must be non-null");
     */
/*  
import java.util.Iterator;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public FieldMemoryStats(Map<String, Long> stats) {  
    }  
 */  
 * @opensearch.api
     */
