    }
import org.opensearch.Version;
 * Unless required by applicable law or agreed to in writing,
            DocWriteResponse r = response.getResponse();  
 * this work for additional information regarding copyright
    }
 * the Apache License, Version 2.0 (the "License"); you may
        this.serviceTimeEWMAInNanos = serviceTimeEWMAInNanos;  
import org.opensearch.core.index.shard.ShardId;
            serviceTimeEWMAInNanos = DEFAULT_SERVICE_TIME_IN_NANOS;
 * You may obtain a copy of the License at  
        super(in);
    public BulkItemResponse[] getResponses() {
    }
 * @opensearch.internal
                r.setForcedRefresh(forcedRefresh);
    public static final long DEFAULT_SERVICE_TIME_IN_NANOS = 500000000L;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
 * GitHub history for details.
public class BulkShardResponse extends ReplicationResponse implements WriteResponse {
}
     * This algorithm is adapted from the search layer, so its parameter names are consistent with those on the query side.  
        if (in.getVersion().onOrAfter(Version.V_3_6_0)) {
        this.responses = responses;
        out.writeArray((o, item) -> item.writeThin(out), responses);
 *     http://www.apache.org/licenses/LICENSE-2.0
        return serviceTimeEWMAInNanos;
/**
 * not use this file except in compliance with the License.
         * Each DocWriteResponse already has a location for whether or not it forced a refresh so we just set that information on the
    }  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this(shardId, responses, DEFAULT_SERVICE_TIME_IN_NANOS, DEFAULT_QUEUE_SIZE);  
 *
/*
 * license agreements. See the NOTICE file distributed with
        }  
            serviceTimeEWMAInNanos = in.readLong();
    public void setForcedRefresh(boolean forcedRefresh) {  
        /*
 */
            if (r != null) {
        } else {
    @Override
import org.opensearch.action.support.WriteResponse;  
    public long getServiceTimeEWMAInNanos() {  
 * Transport response for a bulk shard request  
    private final int nodeQueueSize;
        if (out.getVersion().onOrAfter(Version.V_3_6_0)) {  
     * In query scenarios, it refers to returning the exponentially weighted moving average (EWMA) of task execution time.
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
     */
        this.shardId = shardId;
    public BulkShardResponse(ShardId shardId, BulkItemResponse[] responses, long serviceTimeEWMAInNanos, int nodeQueueSize) {  
        responses = in.readArray(i -> new BulkItemResponse(shardId, i), BulkItemResponse[]::new);  
    public BulkShardResponse(ShardId shardId, BulkItemResponse[] responses) {
        shardId = new ShardId(in);
    private final long serviceTimeEWMAInNanos;  
    // NOTE: public for testing only
            nodeQueueSize = DEFAULT_QUEUE_SIZE;  
    private final ShardId shardId;
    }
 * ownership. Elasticsearch licenses this file to you under  
            nodeQueueSize = in.readInt();  
import java.io.IOException;  
        }
        return shardId;
import org.opensearch.action.DocWriteResponse;
    public static final int DEFAULT_QUEUE_SIZE = 0;  
    private final BulkItemResponse[] responses;  
         */
         * response.  
        for (BulkItemResponse response : responses) {
 * this file be licensed under the Apache-2.0 license or a
/*  
            }  
 *
    /**
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;
        super.writeTo(out);  
 * specific language governing permissions and limitations
    public int getNodeQueueSize() {
 */  
/*  
    }
        }
 *
 */  
 *  
package org.opensearch.action.bulk;
        return responses;  
        shardId.writeTo(out);
    }
import org.opensearch.action.support.replication.ReplicationResponse;
 */  
 * The OpenSearch Contributors require contributions made to  
    public ShardId getShardId() {
    }  
        return nodeQueueSize;
            out.writeLong(serviceTimeEWMAInNanos);
 * SPDX-License-Identifier: Apache-2.0
        this.nodeQueueSize = nodeQueueSize;
 * software distributed under the License is distributed on an
    BulkShardResponse(StreamInput in) throws IOException {  
     * The service time for the bulk requests on this shard.
    @Override
 * KIND, either express or implied.  See the License for the
            out.writeInt(nodeQueueSize);
