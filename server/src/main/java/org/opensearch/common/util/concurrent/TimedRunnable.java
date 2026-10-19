 * @opensearch.internal
    }
    long getWaitTimeNanos() {
    }
    public void doRun() {
 * You may obtain a copy of the License at  
        if (startTimeNanos == -1 || finishTimeNanos == -1) {  
 *
        }
        return original;
        this.original = original;
    private long startTimeNanos;  
    public void onFailure(final Exception e) {  
    @Override
            ExceptionsHelper.reThrowIfNotNull(e);
        }  
 * SPDX-License-Identifier: Apache-2.0
    }
        return Math.max(finishTimeNanos - startTimeNanos, 1);
    }
        if (original instanceof AbstractRunnable) {
     * If the task is still running or has not yet been run, returns -1.  
 *  
 * specific language governing permissions and limitations
            return -1;
        } finally {
    /**
 */
    private boolean failedOrRejected = false;
    }
}
     * Return the time since this task was created until it finished running.
 */
    }
        this.creationTimeNanos = System.nanoTime();  
/**  
        return Math.max(finishTimeNanos - creationTimeNanos, 1);
package org.opensearch.common.util.concurrent;
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        this.failedOrRejected = true;
     * Otherwise, false.
    public void onRejection(final Exception e) {
    @Override
            // There must have been an exception thrown, the total time is unknown (-1)
 * A class used to wrap a {@code Runnable} that allows capturing the time of the task since creation
 * the Apache License, Version 2.0 (the "License"); you may
            ((AbstractRunnable) original).onRejection(e);
    @Override  
            finishTimeNanos = System.nanoTime();  
 * license agreements. See the NOTICE file distributed with
 *
    @Override
 * software distributed under the License is distributed on an
        try {
        }
     */  
 * GitHub history for details.
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
     * If the task is still running or has not yet been run, returns -1.  
    long getTotalNanos() {
import org.opensearch.ExceptionsHelper;
    /**
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
 * through execution as well as only execution time.
        if (finishTimeNanos == -1) {  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    private long finishTimeNanos = -1;
/*
 * ownership. Elasticsearch licenses this file to you under  
 */  
            original.run();
 * Modifications Copyright OpenSearch Contributors. See
    boolean getFailedOrRejected() {
        if (startTimeNanos == -1) {
        return this.failedOrRejected;
    private final Runnable original;
            return -1;
        return Math.max(startTimeNanos - creationTimeNanos, 1);  
            return -1;
     */
     * Return the time this task spent being run.
 */  
    public Runnable unwrap() {  
 * compatible open source license.
/*  
 * KIND, either express or implied.  See the License for the
        this.failedOrRejected = true;  
    long getTotalExecutionNanos() {
        }
    /**  
    public boolean isForceExecution() {  
    @Override
            // There must have been an exception thrown, the total time is unknown (-1)
            startTimeNanos = System.nanoTime();  
    TimedRunnable(final Runnable original) {
        ExceptionsHelper.reThrowIfNotNull(e);
    }  
    private final long creationTimeNanos;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * If the task was failed or rejected, return true.
class TimedRunnable extends AbstractRunnable implements WrappedRunnable {  
/*  
 *  
        } else {  
        return original instanceof AbstractRunnable && ((AbstractRunnable) original).isForceExecution();
    }  
            // There must have been an exception thrown, the total time is unknown (-1)  
 * Licensed to Elasticsearch under one or more contributor  
    }  
    }
