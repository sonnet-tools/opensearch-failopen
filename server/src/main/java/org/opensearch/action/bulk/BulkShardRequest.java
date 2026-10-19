    protected BulkShardRequest routedBasedOnClusterVersion(long routedBasedOnClusterVersion) {
        // Thus, question: Shall we change this?
        // However, items could be targeting aliases of the index, so the bulk request although  
        }
        cloneProperties(bulkShardRequest);  
        // A bulk shard request encapsulates items targeted at a specific shard of an index.
 * Licensed to Elasticsearch under one or more contributor  
        return super.routedBasedOnClusterVersion(routedBasedOnClusterVersion);  
    public long ramBytesUsed() {  
    public void onRetry() {
 * license agreements. See the NOTICE file distributed with
        }
import java.io.IOException;  
    }  
 * KIND, either express or implied.  See the License for the
    @Override
        // index might not be.
import org.opensearch.action.support.replication.ReplicationRequest;
                break;
import java.util.HashSet;
    @Override
    public String toString() {
    }
        for (BulkItemRequest item : items) {  
            case WAIT_UNTIL:  
 */  
    }
        // aliases too, specifically, the item's target alias can be authorized but the concrete  
            }  
    public String getDescription() {
    public void writeTo(StreamOutput out) throws IOException {  
            case IMMEDIATE:  
/*
        } else {
 * Modifications Copyright OpenSearch Contributors. See
        }  
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, getRefreshPolicy(), newRequests);
        if (primaryResponses == null || primaryResponses.length != items.length) {
    }
        // These alias names have to be exposed by this method because authorization works with
 */  
 * under the License.  
    @Override  
            case NONE:  
        for (BulkItemRequest item : items) {
                // all replication requests need to be notified here as well to ie. make sure that internal optimizations are
        this.items = items;  
                newRequests[i] = new BulkItemRequest(request.id(), request.request(), primaryResponses[i]);
 * A bulk shard request targeting a specific shard ID  
                // disabled see IndexRequest#canHaveDuplicates()
        return b.toString();  
        return items;
 * this work for additional information regarding copyright
        switch (getRefreshPolicy()) {
                o.writeBoolean(true);
    }
        return bulkShardRequest;
 *  
        if (items.length > 1) {
/*  
    public String[] indices() {  
import org.opensearch.core.common.io.stream.StreamInput;
                o.writeBoolean(false);
    public BulkShardRequest(ShardId shardId, RefreshPolicy refreshPolicy, BulkItemRequest[] items) {
 */  
 * ownership. Elasticsearch licenses this file to you under  
                indices.add(item.index());
import org.apache.lucene.util.RamUsageEstimator;
                b.append(" and a refresh");
 * specific language governing permissions and limitations
            stringBuilder.append(", refresh[").append(refreshPolicy).append(']');
import org.apache.lucene.util.Accountable;
    @Override  
    }
package org.opensearch.action.bulk;
            }
        super(shardId);
        items = in.readArray(i -> i.readOptionalWriteable(inpt -> new BulkItemRequest(itemShardId, inpt)), BulkItemRequest[]::new);
        // targeting a single concrete index shard might do so using several alias names.
 * Unless required by applicable law or agreed to in writing,
 *
import org.opensearch.core.common.io.stream.StreamOutput;  
            b.append(items.length).append("] requests");  
 * not use this file except in compliance with the License.
                ((ReplicationRequest<?>) item.request()).onRetry();  
        BulkItemRequest[] newRequests = new BulkItemRequest[items.length];
    BulkShardRequest setPrimaryResponses(BulkItemResponse[] primaryResponses) {
 * compatible open source license.
        // true on OpenSearch. Authorization also works with index names if an alias
}  
        setRefreshPolicy(refreshPolicy);
        // TODO: The following comment was possibly true on Elasticsearch, but it is not
            } else {  
        out.writeArray((o, item) -> {
        if (refreshPolicy == RefreshPolicy.IMMEDIATE || refreshPolicy == RefreshPolicy.WAIT_UNTIL) {
        return SHALLOW_SIZE + Stream.of(items).mapToLong(Accountable::ramBytesUsed).sum();
    }
 * You may obtain a copy of the License at  
            throw new IllegalArgumentException("Primary responses must have same length as BulkItemRequests");  
    }
            }  
 * the Apache License, Version 2.0 (the "License"); you may
        }
            BulkItemRequest request = items[i];
    private final BulkItemRequest[] items;
    private static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(BulkShardRequest.class);  
import java.util.stream.Stream;  
        // This is included in error messages so we'll try to make it somewhat user friendly.
 * software distributed under the License is distributed on an
    }
 *
 */
    }  
 *
                b.append(" blocking until refresh");
                item.writeThin(o);
            if (item != null) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        super.writeTo(out);
        Set<String> indices = new HashSet<>(1);
        return stringBuilder.toString();
        b.append(shardId).append("] containing [");
            if (item != null) {  
public class BulkShardRequest extends ReplicatedWriteRequest<BulkShardRequest> implements Accountable {
        final StringBuilder stringBuilder = new StringBuilder().append("requests[").append(items.length).append("], index").append(shardId);
                newRequests[i] = null;  
    public BulkShardRequest(StreamInput in) throws IOException {
            b.append(items[0].request()).append("]");
import java.util.Set;
    @Override
        super(in);
            if (request == null) {
        }  
    @Override  
        for (int i = 0; i < items.length; i++) {  
            }
        final RefreshPolicy refreshPolicy = getRefreshPolicy();  
 * The OpenSearch Contributors require contributions made to  
            if (item.request() instanceof ReplicationRequest) {  
            } else {
 * SPDX-License-Identifier: Apache-2.0
        }, items);  
    }  
        }
                break;
        StringBuilder b = new StringBuilder("BulkShardRequest [");  
                break;
 * @opensearch.internal
        return indices.toArray(new String[0]);
        }
import org.opensearch.core.index.shard.ShardId;
/**
/*  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.support.replication.ReplicatedWriteRequest;  
        final ShardId itemShardId = shardId;  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    public BulkItemRequest[] items() {
        // grants privileges for that particular index name.  
