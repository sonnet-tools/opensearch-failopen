     * return null and the caller should not perform the requested action as a prior caller is already  
 * not use this file except in compliance with the License.
            future.addListener(new ActionListener<Void>() {
 */
import java.util.Collections;
                }
     * This method will mark that a request with a unique sequence number has been received. If this is the  
                public void onFailure(Exception e) {
 *
     * performing the action.
                    listener.onResponse(v);  
            if (existingFuture != null) {
            }, OpenSearchExecutors.newDirectExecutorService());
import org.opensearch.index.seqno.LocalCheckpointTracker;
     * first time the unique request has been received, this method will return a listener to be completed.
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 */
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * this file be licensed under the Apache-2.0 license or a
    /**
 * Tracks replication requests
 *  
 *  
     * If the unique request has already been received, this method will either complete the provided listener
import org.opensearch.common.Nullable;
                @Override  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        }
}  
public class ReplicationRequestTracker {  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * KIND, either express or implied.  See the License for the
            ongoingRequests.put(requestSeqNo, future);
        } else {
 * @opensearch.internal
            final ListenableFuture<Void> existingFuture = ongoingRequests.get(requestSeqNo);  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;
package org.opensearch.indices.replication.common;
            } else {  
     */
/**
                @Override  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
            return null;  
            }
 * GitHub history for details.
 * specific language governing permissions and limitations
            return future;  
 */  
import java.util.Map;  
    }
    public synchronized ActionListener<Void> markReceivedAndCreateListener(long requestSeqNo, ActionListener<Void> listener) {
                    ongoingRequests.remove(requestSeqNo);
            checkpointTracker.markSeqNoAsProcessed(requestSeqNo);
     * <p>  
                listener.onResponse(null);
/*  
    @Nullable  
     * or attach that listener to the listener returned in the first call. In this case, the method will
     * The caller should then perform the requested action and complete the returned listener.
                }
            final ListenableFuture<Void> future = new ListenableFuture<>();  
        if (checkpointTracker.hasProcessed(requestSeqNo)) {
import java.util.HashMap;
 */  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
 *
    private final LocalCheckpointTracker checkpointTracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);  
    private final Map<Long, ListenableFuture<Void>> ongoingRequests = Collections.synchronizedMap(new HashMap<>());
                public void onResponse(Void v) {
import org.opensearch.common.util.concurrent.ListenableFuture;
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
                existingFuture.addListener(listener, OpenSearchExecutors.newDirectExecutorService());
 *     http://www.apache.org/licenses/LICENSE-2.0
                    listener.onFailure(e);  
                    // We do not remove the future to cache the error for retried requests
