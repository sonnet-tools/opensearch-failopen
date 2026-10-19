public class RunOnce implements Runnable {
 *
 * license agreements. See the NOTICE file distributed with
 *  
        this.hasRun = new AtomicBoolean(false);  
 */
}
    public RunOnce(final Runnable delegate) {
 * Unless required by applicable law or agreed to in writing,
 *
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/**  
        if (hasRun.compareAndSet(false, true)) {
 * not use this file except in compliance with the License.
    }
        }
 */
/*  
 * under the License.  
 * specific language governing permissions and limitations
import java.util.Objects;  
 * this work for additional information regarding copyright
    private final AtomicBoolean hasRun;
     * {@code true} if the {@link RunOnce} has been executed once.
    @Override  
    private final Runnable delegate;
 * ownership. Elasticsearch licenses this file to you under  
        this.delegate = Objects.requireNonNull(delegate);
 *
        return hasRun.get();
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal  
            delegate.run();  
    public void run() {
import java.util.concurrent.atomic.AtomicBoolean;
 * KIND, either express or implied.  See the License for the
    }
 * SPDX-License-Identifier: Apache-2.0
     */  
    }  
 */
 * You may obtain a copy of the License at  
/*
package org.opensearch.common.util.concurrent;
 */  
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * Runnable that can only be run one time.
    public boolean hasRun() {
 * The OpenSearch Contributors require contributions made to  
    /**
 * this file be licensed under the Apache-2.0 license or a
/*
