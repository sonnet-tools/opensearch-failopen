     * or on a rejection.
     */
 * under the License.  
/**
            onFailure(t);
     */  
 */
     * @throws InterruptedException if the run method throws an InterruptedException
            onAfter();
 * KIND, either express or implied.  See the License for the
     */
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public boolean isForceExecution() {
 * the Apache License, Version 2.0 (the "License"); you may
     * This should be executed if the thread-pool executing this action rejected the execution.
 *
/*
    @Override  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    }
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 */  
    public abstract void onFailure(Exception e);
    }  
 * An extension to runnable.
public abstract class AbstractRunnable implements Runnable {  
     * This method has the same semantics as {@link Runnable#run()}  
     * This method is called in a finally block after successful execution  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
}
        onFailure(e);
 * Modifications Copyright OpenSearch Contributors. See
/*  
        return false;  
    protected abstract void doRun() throws Exception;  
 */
    public void onAfter() {  
            doRun();  
 *  
    /**
     */  
 * specific language governing permissions and limitations
    /**
        // nothing by default
/*  
    public void onRejection(Exception e) {
     * This method is invoked for all exception thrown by {@link #doRun()}
 * software distributed under the License is distributed on an
    public final void run() {
    }  
     */
        try {
        } finally {  
    /**
 * GitHub history for details.
 * @opensearch.internal
 */  
 * Licensed to Elasticsearch under one or more contributor  
        }
    }
package org.opensearch.common.util.concurrent;
 *     http://www.apache.org/licenses/LICENSE-2.0
     * The default implementation forwards to {@link #onFailure(Exception)}
 *
 * not use this file except in compliance with the License.
    /**  
    /**
     * Should the runnable force its execution in case it gets rejected?  
        } catch (Exception t) {
 *  
