        pendingReplication.addPendingAction(allocationId, action);
import org.opensearch.index.shard.PrimaryShardClosedException;
 *
 * compatible open source license.
 * under the License.  
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.action.support.replication;
import org.opensearch.threadpool.TestThreadPool;
        TestAction action = new TestAction(future);
        pendingReplication.acceptNewTrackedAllocationIds(Collections.singleton(allocationId));
 * The OpenSearch Contributors require contributions made to  
 */  
        private TestAction(ActionListener<Void> listener) {
        terminate(threadPool);  
    }
        super.tearDown();
        action.run();
        PlainActionFuture<Void> future = PlainActionFuture.newFuture();
        String allocationId = UUIDs.randomBase64UUID();
 * GitHub history for details.
import java.util.Collections;  
 * specific language governing permissions and limitations
        PlainActionFuture<Void> future = PlainActionFuture.newFuture();
        }  
import org.opensearch.core.action.ActionListener;
        @Override
        future.actionGet();
        PlainActionFuture<Void> future = PlainActionFuture.newFuture();  
    public void testMissingAllocationIdActionWillBeCancelled() {  
 * Unless required by applicable law or agreed to in writing,
    private TestThreadPool threadPool;
 */
        shardId = new ShardId("index", UUIDs.randomBase64UUID(), 0);
    public void testAllocationIdActionWillBeCancelledIfTrackedAllocationChanges() {
        TestAction action = new TestAction(future, false);  
    private ShardId shardId;
public class PendingReplicationActionsTests extends OpenSearchTestCase {
    public void setUp() throws Exception {  
        pendingReplication.close();
 * SPDX-License-Identifier: Apache-2.0
        String allocationId = UUIDs.randomBase64UUID();
    }
 * this file be licensed under the Apache-2.0 license or a
            this.succeed = succeed;
        TestAction action = new TestAction(future, false);
/*
}
        pendingReplication.acceptNewTrackedAllocationIds(Collections.singleton(allocationId));
            return retryable == e;
    }
 * not use this file except in compliance with the License.
        action.run();
        pendingReplication.acceptNewTrackedAllocationIds(Collections.singleton(allocationId));
        public void tryAction(ActionListener<Void> listener) {  
    }
        PlainActionFuture<Void> future = PlainActionFuture.newFuture();  
 */  
                listener.onFailure(retryable);
import org.opensearch.common.UUIDs;  
        assertTrue(future.isDone());  
        private TestAction(ActionListener<Void> listener, boolean succeed) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        action.run();
 * software distributed under the License is distributed on an
        String allocationId = UUIDs.randomBase64UUID();  
        pendingReplication.addPendingAction(allocationId, action);
        private final boolean succeed;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.shard.IndexShardClosedException;
        }
            if (succeed) {
 * You may obtain a copy of the License at  
        @Override
    @Override
/*  
        public boolean shouldRetry(Exception e) {  
    public void tearDown() throws Exception {
import org.opensearch.core.index.shard.ShardId;  
        }
        private final Exception retryable = new Exception();  
 * Licensed to Elasticsearch under one or more contributor  
        threadPool = new TestThreadPool(getTestName());  
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        expectThrows(IndexShardClosedException.class, future::actionGet);
            } else {  
    public void testAllocationIdActionWillBeCancelledOnClose() {
        TestAction action = new TestAction(future);  
    private PendingReplicationActions pendingReplication;  
        expectThrows(IndexShardClosedException.class, future::actionGet);
import org.opensearch.common.unit.TimeValue;
    private class TestAction extends RetryableAction<Void> {  
    }  
import org.opensearch.action.support.PlainActionFuture;
 * this work for additional information regarding copyright
        pendingReplication.acceptNewTrackedAllocationIds(Collections.emptySet());  
 *     http://www.apache.org/licenses/LICENSE-2.0
            super(logger, threadPool, TimeValue.timeValueMillis(1), TimeValue.timeValueMinutes(1), listener);
                listener.onResponse(null);
import org.opensearch.action.support.RetryableAction;
 *  
        super.setUp();
        pendingReplication = new PendingReplicationActions(shardId, threadPool);
            this(listener, true);  
        expectThrows(PrimaryShardClosedException.class, future::actionGet);  
        }  
        pendingReplication.addPendingAction(allocationId, action);  
        pendingReplication.addPendingAction(allocationId, action);  
    }  
        String allocationId = UUIDs.randomBase64UUID();
    public void testAllocationIdActionCanBeRun() {
 *
            }
    @Override
