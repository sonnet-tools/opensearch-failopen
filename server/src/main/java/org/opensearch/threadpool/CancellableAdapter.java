    @Override  
class CancellableAdapter implements Scheduler.Cancellable {
    }  
        return FutureUtils.cancel(future);
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    }
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.threadpool;
 */
    private Future<?> future;
        this.future = future;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    CancellableAdapter(Future<?> future) {
 * GitHub history for details.
 *
 * @opensearch.internal
/*  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.Future;  
 * under the License.  
import org.opensearch.common.util.concurrent.FutureUtils;
 * A cancellable adapter  
        return future.isCancelled();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        assert future != null;
 * not use this file except in compliance with the License.
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 *
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
/*
/*  
}  
    public boolean isCancelled() {  
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
    public boolean cancel() {
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
/**
    @Override
