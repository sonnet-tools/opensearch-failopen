     */
    public enum Metric {  
        public static Set<String> defaultMetrics() {  
     * Get the names of requested metrics
     * Get information from nodes based on the nodes ids specified. If none are passed, information
    public NodesInfoRequest defaultMetrics() {
         * Return all available metrics.
        THREAD_POOL("thread_pool"),
 * Unless required by applicable law or agreed to in writing,
        requestedMetrics.add(metric);
        }  
    public NodesInfoRequest clear() {  
    }
 * Modifications Copyright OpenSearch Contributors. See
    }  
    /**
    public NodesInfoRequest addMetrics(String... metrics) {  
        requestedMetrics.addAll(Arrays.asList(in.readStringArray()));  
        requestedMetrics.addAll(Metric.allMetrics());
    }  
         * size at bay. Metrics that are NOT included in the default set were typically introduced later
        private String metricName;
import org.opensearch.common.annotation.PublicApi;
     * Remove metric  
 * KIND, either express or implied.  See the License for the
            this.metricName = name;
import org.opensearch.core.common.io.stream.StreamInput;  
 * SPDX-License-Identifier: Apache-2.0
    }
    }
package org.opensearch.action.admin.cluster.node.info;
     *
        SETTINGS("settings"),
     * Create a new NodeInfoRequest from a {@link StreamInput} object.
            throw new IllegalStateException("Used an illegal metric: " + metric);
            metricsSet.removeAll(Metric.allMetrics());  
public class NodesInfoRequest extends BaseNodesRequest<NodesInfoRequest> {
            return this.metricName;  
        return this;
        /**
    /**
        boolean containedIn(Set<String> metricNames) {  
 * not use this file except in compliance with the License.
    }
        HTTP("http"),
    /**  
     */  
        return new HashSet<>(requestedMetrics);
        INDICES("indices"),
        OS("os"),
        }
        /**  
 *  
        public String metricName() {
        requestedMetrics.addAll(Metric.defaultMetrics());
        return this;
import java.util.HashSet;
    /**
        super(nodesIds);
/*  
        SortedSet<String> metricsSet = new TreeSet<>(Arrays.asList(metrics));
 * under the License.  
        out.writeStringArray(requestedMetrics.toArray(new String[0]));
     */
 * @opensearch.api
        SEARCH_PIPELINES("search_pipelines");  
 */  
 *
        INGEST("ingest"),  
        PROCESS("process"),  
import java.util.TreeSet;
        if (Metric.allMetrics().contains(metric) == false) {
    /**  
            throw new IllegalStateException("Used illegal metric" + plural + ": " + metricsSet);
         * know that you really need it.
     * Clears all info flags.
     * for all nodes will be returned.
 * software distributed under the License is distributed on an
     * See {@link Metric}
import org.opensearch.action.support.nodes.BaseNodesRequest;
        return this;
        requestedMetrics.clear();
        PLUGINS("plugins"),
        public static Set<String> allMetrics() {
     */
     * @throws IOException if the stream cannot be deserialized.
        }
            return Arrays.stream(values()).map(Metric::metricName).collect(Collectors.toSet());  
        return this;  
 * license agreements. See the NOTICE file distributed with
        defaultMetrics();  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        if (Metric.allMetrics().contains(metric) == false) {  
     * pluggable.
     */  
     * Add metric
        super(in);
    }  
 */
        Metric(String name) {
     */
@PublicApi(since = "1.0.0")
import java.io.IOException;  
            String plural = metricsSet.size() == 1 ? "" : "s";
    public NodesInfoRequest all() {  
        }
/*  
         * The motivation to define the default set of metrics was to keep the default response
/*
import org.opensearch.core.common.io.stream.StreamOutput;
         * See {@link Metric}  
        requestedMetrics.addAll(metricsSet);
     */
    /**  
         */
     * An enumeration of the "core" sections of metrics that may be requested
            return metricNames.contains(this.metricName());
        TRANSPORT("transport"),  
    public NodesInfoRequest(String... nodesIds) {
     * See {@link Metric}
        if (Metric.allMetrics().containsAll(metricsSet) == false) {
     * Add multiple metrics
     * from the nodes information endpoint. Eventually this list will be  
    private Set<String> requestedMetrics = Metric.defaultMetrics();
    @Override
        }  
/**
        requestedMetrics.clear();
 * GitHub history for details.
}
 *
     */  
        return this;
            return allMetrics().stream().filter(metric -> !(metric.equals(SEARCH_PIPELINES.metricName()))).collect(Collectors.toSet());
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    /**  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalStateException("Used an illegal metric: " + metric);  
     * @param in A stream input object.  
        AGGREGATIONS("aggregations"),
     */
    /**  
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * <br>  
        JVM("jvm"),
         * Return "the default" set of metrics.
 * this work for additional information regarding copyright
    }  
 * specific language governing permissions and limitations
        super.writeTo(out);  
import java.util.Set;  
    }
 * Licensed to Elasticsearch under one or more contributor  
import java.util.stream.Collectors;  
 * You may obtain a copy of the License at  
        }
import java.util.SortedSet;
        requestedMetrics.remove(metric);  
 */  
         * Similar to {@link #allMetrics()} except {@link Metric#SEARCH_PIPELINES} metric is not included.
        return this;  
    public Set<String> requestedMetrics() {  
        }
    public void writeTo(StreamOutput out) throws IOException {
    /**
    public NodesInfoRequest addMetric(String metric) {
     * See {@link Metric#defaultMetrics()}.
        }
         */
     * Sets to return data for default metrics only.  
     * Sets to return data for all the metrics.  
 * ownership. Elasticsearch licenses this file to you under  
    }
         * and are considered to contain specific type of information that is not usually useful unless you  
 */  
import java.util.Arrays;
    public NodesInfoRequest(StreamInput in) throws IOException {  
    public NodesInfoRequest removeMetric(String metric) {
 * A request to get node (cluster) level information.  
     */
    }
