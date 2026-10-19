import org.opensearch.index.translog.Translog;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            }
/*
 * not use this file except in compliance with the License.
 * under the License.  
            latch.await();  
 * this work for additional information regarding copyright
    ) {  
 * Unless required by applicable law or agreed to in writing,
 *  
        final CountDownLatch latch = new CountDownLatch(1);
        }  
 */
package org.opensearch.action.support.replication;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 */  
public abstract class TransportWriteActionTestHelper {
 *
            @Override
 * license agreements. See the NOTICE file distributed with
        new TransportWriteAction.AsyncAfterWriteAction(indexShard, request, location, writerResult, logger).run();
 */
    }
 * The OpenSearch Contributors require contributions made to  
        try {
 * this file be licensed under the Apache-2.0 license or a
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new AssertionError(ex);
    public static void performPostWriteActions(
 * specific language governing permissions and limitations
        final Logger logger
        TransportWriteAction.RespondingWriteResult writerResult = new TransportWriteAction.RespondingWriteResult() {
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
            }  
 * software distributed under the License is distributed on an
import java.util.concurrent.CountDownLatch;  
import org.opensearch.action.support.WriteRequest;
}
        };  
        final WriteRequest<?> request,  
import org.opensearch.common.Nullable;
import org.apache.logging.log4j.Logger;  
 * GitHub history for details.
        @Nullable final Translog.Location location,
        final IndexShard indexShard,
/*  
 *
            public void onFailure(Exception ex) {  
            @Override  
            throw new AssertionError(e);
                latch.countDown();
        } catch (InterruptedException e) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.shard.IndexShard;  
 * You may obtain a copy of the License at  
            public void onSuccess(boolean forcedRefresh) {
