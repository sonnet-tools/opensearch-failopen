 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    public AbstractLifecycleRunnable(Lifecycle lifecycle, Logger logger) {
 * software distributed under the License is distributed on an
     * @param lifecycle The lifecycle to react too
 * compatible open source license.
     * This method is most useful for rescheduling the next iteration of the current runnable.  
 */
    /**
    protected void onAfterInLifecycle() {
     * <p>  
        }
            return;  
 * the Apache License, Version 2.0 (the "License"); you may
    protected final void doRun() throws Exception {
 * KIND, either express or implied.  See the License for the
            logger.trace("lifecycle is stopping. exiting");
 *
 * this work for additional information regarding copyright
    @Override
 * license agreements. See the NOTICE file distributed with
        this.logger = Objects.requireNonNull(logger, "logger must not be null");
 * @opensearch.internal
        doRunInLifecycle();  
     * @throws NullPointerException if any parameter is {@code null}  
     * The service's logger (note: this is passed in!).  
    private final Logger logger;
     * @param logger The logger to use when logging
     * Note: this does not guarantee that it won't be stopped concurrently as it invokes {@link #onAfterInLifecycle()},
 * not use this file except in compliance with the License.
    /**
     * This overrides the default behavior of {@code onAfter} to add the caveat that it only runs if the {@link #lifecycle} is <em>not</em>
     * immediately.
     * This invokes {@link #doRunInLifecycle()} <em>only</em> if the {@link #lifecycle} is not stopped or closed. Otherwise it exits
 *
 *  
/*  
     * {@link AbstractLifecycleRunnable} must be aware of the actual {@code lifecycle} to react properly.
import org.apache.logging.log4j.Logger;  
     */
     */  
    }  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
}
     */
     */
     *  
 * SPDX-License-Identifier: Apache-2.0
    }
     * The monitored lifecycle for the associated service.
    /**
        // nothing by default  
        }
        if (lifecycle.stoppedOrClosed() == false) {  
     * {@inheritDoc}
     * <p>
 * ownership. Elasticsearch licenses this file to you under  
            onAfterInLifecycle();
     * {@inheritDoc}
    @Override
    /**
    /**  
 * Unless required by applicable law or agreed to in writing,
 *  
     * but it's a solid attempt at preventing it. For those that use this for rescheduling purposes, the next invocation would be
 * This simplifies the running and rescheduling of {@link Lifecycle}-based {@code Runnable}s.
 * Licensed to Elasticsearch under one or more contributor  
     * effectively cancelled immediately if that's the case.  
/**
 */
package org.opensearch.common.util.concurrent;
     * stopped or closed.
import java.util.Objects;  
     * This method is invoked in the finally block of the run method, but it is only executed if the {@link #lifecycle} is <em>not</em>  
 */  
     * <p>  
     * Perform runnable logic, but only if the {@link #lifecycle} is <em>not</em> stopped or closed.
    private final Lifecycle lifecycle;
 * specific language governing permissions and limitations
 */
     *
 * GitHub history for details.
     */  
    /**
/*
    }
     */
    /**
        // prevent execution if the service is stopped  
     */  
     * <p>  
 * {@code AbstractLifecycleRunnable} is a service-lifecycle aware {@link AbstractRunnable}.  
/*
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
     * @throws InterruptedException if the run method throws an {@link InterruptedException}  
    public final void onAfter() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class AbstractLifecycleRunnable extends AbstractRunnable {  
     * stopped or closed.
    protected abstract void doRunInLifecycle() throws Exception;
 * <p>
        if (lifecycle.stoppedOrClosed()) {
import org.opensearch.common.lifecycle.Lifecycle;
        this.lifecycle = Objects.requireNonNull(lifecycle, "lifecycle must not be null");  
     * @see #onAfterInLifecycle()
     *
