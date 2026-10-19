 */  
    private final Map<String, Object> aggregationUsage;  
/*  
    }
        sinceTime = in.readLong();  
     *            a map containing the counts of the number of times each REST
 * not use this file except in compliance with the License.
    public Map<String, Object> getAggregationUsage() {  
    private final long timestamp;  
     * @param restUsage
    @Override  
    public long getTimestamp() {
 * Concrete class for collecting OpenSearch telemetry  
        }
            builder.field("rest_actions");
    public long getSinceTime() {
import org.opensearch.core.xcontent.XContentBuilder;  
    public NodeUsage(StreamInput in) throws IOException {  
}  
        this.aggregationUsage = aggregationUsage;
import org.opensearch.cluster.node.DiscoveryNode;
    }
            builder.map(aggregationUsage);
     */
        if (restUsage != null) {
 * GitHub history for details.
 * software distributed under the License is distributed on an
import java.util.Map;  
     */  
 * Unless required by applicable law or agreed to in writing,
        out.writeLong(sinceTime);
/*  
        if (aggregationUsage != null) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action.admin.cluster.node.usage;
        Map<String, Object> aggregationUsage
    public Map<String, Long> getRestUsage() {
     *            the node these statistics were collected from
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     *            the timestamp for when these statistics were collected  
    ) {
    }
        super.writeTo(out);
    }
        DiscoveryNode node,  
 * the Apache License, Version 2.0 (the "License"); you may
        this.restUsage = restUsage;  
            builder.field("aggregations");  
        aggregationUsage = (Map<String, Object>) in.readGenericValue();
import org.opensearch.action.support.nodes.BaseNodeResponse;
 * ownership. Elasticsearch licenses this file to you under  
    /**
 * license agreements. See the NOTICE file distributed with
    }
    private final Map<String, Long> restUsage;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        long timestamp,
     *            the timestamp for when the collection of these statistics
     * @param node  
        timestamp = in.readLong();
 * You may obtain a copy of the License at  
public class NodeUsage extends BaseNodeResponse implements ToXContentFragment {
     * @return a map containing the counts of the number of times each REST  
    /**
        builder.field("since", sinceTime);  
    public NodeUsage(
    }  
     *            started  
     */
    public void writeTo(StreamOutput out) throws IOException {
    }  
    /**  
    }  
 */
        return sinceTime;  
import java.io.IOException;
/**
/*
    @Override
     */  
     *         endpoint has been called
        }
    /**
        return builder;  
 *
        restUsage = (Map<String, Long>) in.readGenericValue();
     *         endpoint has been called
    @SuppressWarnings("unchecked")
 */  
        out.writeLong(timestamp);  
    /**
        this.timestamp = timestamp;
        Map<String, Long> restUsage,  
        this.sinceTime = sinceTime;
     * @return a map containing the counts of the number of times each REST
 * specific language governing permissions and limitations
        return aggregationUsage;
import org.opensearch.core.common.io.stream.StreamInput;  
 * compatible open source license.
 *
 */  
        long sinceTime,
import org.opensearch.core.xcontent.ToXContentFragment;
 * this work for additional information regarding copyright
     * @param timestamp
        out.writeGenericValue(aggregationUsage);  
     * @return the timestamp for when these statistics were collected
     * @return the timestamp for when the collection of these statistics started  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
     *            endpoint has been called  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return timestamp;
        out.writeGenericValue(restUsage);
        super(in);
            builder.map(restUsage);  
import org.opensearch.core.common.io.stream.StreamOutput;
     * @param sinceTime
 * under the License.  
 *  
 *
        super(node);  
        return restUsage;
     */
    private final long sinceTime;
