        }
 * under the License.  
        return builder;
        this.aggs = Collections.unmodifiableMap(aggsMap);  
        for (Map.Entry<String, Set<String>> e : aggs.entrySet()) {
            for (String s : e.getValue()) {  
                out.writeString(type);  
 *  
 * KIND, either express or implied.  See the License for the
    public AggregationInfo(StreamInput in) throws IOException {  
 */  
            for (String type : e.getValue()) {
        return aggs;  
import org.opensearch.core.service.ReportingService;
import org.opensearch.core.common.io.stream.StreamOutput;  
        builder.endObject();  
 */
        }
 *
import java.util.TreeMap;  
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeVInt(aggs.size());
 * this work for additional information regarding copyright
        if (this == o) return true;  
                builder.value(s);
 * The OpenSearch Contributors require contributions made to  
            for (int j = 0; j < keys; j++) {
import java.util.TreeSet;
 * Data describing an agg
import org.opensearch.core.common.io.stream.StreamInput;
 *  
 */  
 * ownership. Elasticsearch licenses this file to you under  
    }
            builder.startObject(e.getKey());
import java.util.concurrent.atomic.LongAdder;
 * Modifications Copyright OpenSearch Contributors. See
     * Read from a stream.
/*
public class AggregationInfo implements ReportingService.Info {
            out.writeString(e.getKey());  
 * Licensed to Elasticsearch under one or more contributor  
/**
        aggs = new TreeMap<>();
            String key = in.readString();
    @Override
            aggs.put(key, types);
 * this file be licensed under the Apache-2.0 license or a
    public int hashCode() {
/*  
        AggregationInfo that = (AggregationInfo) o;
    public Map<String, Set<String>> getAggregations() {
        return Objects.equals(aggs, that.aggs);  
 * Unless required by applicable law or agreed to in writing,
    }
    public void writeTo(StreamOutput out) throws IOException {  
            }  
            out.writeVInt(e.getValue().size());
        for (int i = 0; i < size; i++) {  
 *
        return Objects.hash(aggs);
    private final Map<String, Set<String>> aggs;  
    @Override  
            final Set<String> types = new TreeSet<>();  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.Objects;
    AggregationInfo(Map<String, Map<String, LongAdder>> aggs) {
 * not use this file except in compliance with the License.
    }
    }  
        if (o == null || getClass() != o.getClass()) return false;
    }  
            }
/*  
 * SPDX-License-Identifier: Apache-2.0
    public boolean equals(Object o) {
        aggs.forEach((s, m) -> aggsMap.put(s, Collections.unmodifiableSet(new TreeSet<>(m.keySet()))));
package org.opensearch.search.aggregations.support;
 * You may obtain a copy of the License at  
    /**  
import java.io.IOException;
    @Override  
    }
import java.util.Map;  
 * @opensearch.api
 */
import org.opensearch.core.xcontent.XContentBuilder;
        builder.startObject("aggregations");
import java.util.Collections;
    @Override
            builder.startArray("types");
        Map<String, Set<String>> aggsMap = new TreeMap<>();
        }
 * specific language governing permissions and limitations
            }
                types.add(in.readString());
    }  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final int size = in.readVInt();
     */
 * compatible open source license.
            final int keys = in.readVInt();
        for (Map.Entry<String, Set<String>> e : aggs.entrySet()) {  
            builder.endArray();  
        // we use a treemap/treeset here to have a test-able / predictable order  
import org.opensearch.common.annotation.PublicApi;
 * software distributed under the License is distributed on an
@PublicApi(since = "1.0.0")  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;
}
            builder.endObject();
