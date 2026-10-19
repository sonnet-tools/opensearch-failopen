 * Unless required by applicable law or agreed to in writing,
public class DiscoveryStats implements Writeable, ToXContentFragment {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
 */  
 * SPDX-License-Identifier: Apache-2.0
        if (clusterStateStats != null) {
            clusterStateStats.toXContent(builder, params);
/**
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.discovery;
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {  
    private final ClusterStateStats clusterStateStats;
    }
        if (queueStats != null) {
        return queueStats;
 * license agreements. See the NOTICE file distributed with
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        static final String DISCOVERY = "discovery";  
 * this work for additional information regarding copyright
        } else {
        }  
    }  
        builder.endObject();
        }  
/*  
            out.writeOptionalWriteable(clusterStateStats);  
    }
 * KIND, either express or implied.  See the License for the
    public PendingClusterStateStats getQueueStats() {  
 * compatible open source license.
 * under the License.  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 */
    public ClusterStateStats getClusterStateStats() {
 *
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
            clusterStateStats = in.readOptionalWriteable(ClusterStateStats::new);
 *
        queueStats = in.readOptionalWriteable(PendingClusterStateStats::new);
        out.writeOptionalWriteable(publishStats);
    static final class Fields {
        return builder;
    public PublishClusterStateStats getPublishStats() {
        return publishStats;
import org.opensearch.cluster.coordination.PublishClusterStateStats;  
import org.opensearch.core.xcontent.ToXContentFragment;
        return clusterStateStats;  
        publishStats = in.readOptionalWriteable(PublishClusterStateStats::new);
            clusterStateStats = null;  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentBuilder;  
}
 * GitHub history for details.
 */
    }  
        builder.startObject(Fields.DISCOVERY);  
import org.opensearch.core.common.io.stream.StreamInput;
        }
import org.opensearch.Version;
    }
        }  
            publishStats.toXContent(builder, params);
import org.opensearch.cluster.coordination.PendingClusterStateStats;
    }
    public DiscoveryStats(StreamInput in) throws IOException {  
 * Stores discovery stats
        if (publishStats != null) {
        this.clusterStateStats = clusterStateStats;  
    }
 * Modifications Copyright OpenSearch Contributors. See
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
            queueStats.toXContent(builder, params);
    @Override
import java.io.IOException;
    private final PublishClusterStateStats publishStats;  
import org.opensearch.cluster.service.ClusterStateStats;
import org.opensearch.core.common.io.stream.Writeable;
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
        this.publishStats = publishStats;
    private final PendingClusterStateStats queueStats;
        out.writeOptionalWriteable(queueStats);  
    }
 */  
 * @opensearch.internal
 *  
    @Override
        this.queueStats = queueStats;
    public DiscoveryStats(PendingClusterStateStats queueStats, PublishClusterStateStats publishStats, ClusterStateStats clusterStateStats) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
/*
        }
