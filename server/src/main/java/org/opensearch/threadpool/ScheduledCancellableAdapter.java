 * compatible open source license.
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.scheduledFuture = scheduledFuture;
        return -other.compareTo(scheduledFuture);
    ScheduledCancellableAdapter(ScheduledFuture<?> scheduledFuture) {  
/**
    }
 * the Apache License, Version 2.0 (the "License"); you may
 *
import org.opensearch.common.util.concurrent.FutureUtils;
 * Unless required by applicable law or agreed to in writing,
        assert scheduledFuture != null;
/*
 * A cancellable adapter that is scheduled
    public boolean isCancelled() {
/*  
 * this file be licensed under the Apache-2.0 license or a
/*  
        // unwrap other by calling on it.  
 * ownership. Elasticsearch licenses this file to you under  
    }  
    @Override
    private final ScheduledFuture<?> scheduledFuture;
 */  
}
 * specific language governing permissions and limitations
 * GitHub history for details.
    public long getDelay(TimeUnit unit) {  
    public boolean cancel() {
 * license agreements. See the NOTICE file distributed with
    @Override
 */
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 */
 *  
 * @opensearch.internal
import java.util.concurrent.ScheduledFuture;
 * SPDX-License-Identifier: Apache-2.0
        return FutureUtils.cancel(scheduledFuture);  
        return scheduledFuture.getDelay(unit);
    @Override  
 *  
import java.util.concurrent.TimeUnit;
 * You may obtain a copy of the License at  
class ScheduledCancellableAdapter implements Scheduler.ScheduledCancellable {  
 * KIND, either express or implied.  See the License for the
package org.opensearch.threadpool;
    }
import java.util.concurrent.Delayed;  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * The OpenSearch Contributors require contributions made to  
    }
        return scheduledFuture.isCancelled();
    @Override
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    }  
    public int compareTo(Delayed other) {
 * under the License.  
