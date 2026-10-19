     * Updates only once the clusterID and nodeId.  
    }
/*
 * specific language governing permissions and limitations
    /**
    public void format(LogEvent event, StringBuilder toAppendTo) {
 * Pattern converter to format the node_and_cluster_id variable into JSON fields <code>node.id</code> and <code>cluster.uuid</code>.
 * license agreements. See the NOTICE file distributed with
        if (nodeAndClusterId.get() != null) {
        return new NodeAndClusterIdConverter();
}
    private static String formatIds(String clusterUUID, String nodeId) {
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 *
 */  
     * @param event - a log event is ignored in this method as it uses the nodeId and clusterId to format
    }  
    public static NodeAndClusterIdConverter newInstance(@SuppressWarnings("unused") final String[] options) {  
 * @opensearch.internal
    /**  
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
    /**
 * You may obtain a copy of the License at  
    public static void setNodeIdAndClusterId(String nodeId, String clusterUUID) {  
    private static final SetOnce<String> nodeAndClusterId = new SetOnce<>();
    }
     *
package org.opensearch.common.logging;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import java.util.Locale;
 *  
 * Keeping those two fields together assures that they will be atomically set and become visible in logs at the same time.  
/*  
public final class NodeAndClusterIdConverter extends LogEventPatternConverter {  
    @Override  
import org.apache.logging.log4j.core.pattern.PatternConverter;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 *
        return String.format(Locale.ROOT, "\"cluster.uuid\": \"%s\", \"node.id\": \"%s\"", clusterUUID, nodeId);  
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.core.LogEvent;
 */  
     */
     * @param nodeId      a nodeId received from cluster state update  
@ConverterKeys({ "node_and_cluster_id" })
     * Formats the node.id and cluster.uuid into json fields.
    }  
import org.apache.logging.log4j.core.pattern.ConverterKeys;  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
     * Subsequent executions will throw {@link org.apache.lucene.util.SetOnce.AlreadySetException}.
     * Called by log4j2 to initialize this converter.
 * not use this file except in compliance with the License.
        nodeAndClusterId.set(formatIds(clusterUUID, nodeId));
     *  
 *
import org.opensearch.common.SetOnce;  
 */  
/*  
 * this work for additional information regarding copyright
            toAppendTo.append(nodeAndClusterId.get());  
    }
     * @param clusterUUID a clusterId received from cluster state update
 * Unless required by applicable law or agreed to in writing,
        // nodeId/clusterUuid not received yet, not appending
import org.apache.logging.log4j.core.config.plugins.Plugin;
     */
 * GitHub history for details.
    public NodeAndClusterIdConverter() {
        }
/**
 */
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
        super("NodeAndClusterId", "node_and_cluster_id");
     */
@Plugin(category = PatternConverter.CATEGORY, name = "NodeAndClusterIdConverter")
 *     http://www.apache.org/licenses/LICENSE-2.0
