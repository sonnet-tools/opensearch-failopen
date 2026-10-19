        InOrder inOrder = inOrder(lifecycle, logger, runCallable, afterCallable);
            }  
            }
import org.opensearch.test.OpenSearchTestCase;  
    }
        runnable.run();  
            @Override
            @Override
            protected void doRunInLifecycle() throws Exception {  
/*
}
        Callable<?> runCallable = mock(Callable.class);
 * this work for additional information regarding copyright
                fail("Should not run with lifecycle stopped or closed.");
        AbstractLifecycleRunnable runnable = new AbstractLifecycleRunnable(lifecycle, logger) {  
            public void onFailure(Exception e) {  
                fail("Should not run with lifecycle stopped or closed.");
                fail("It should not fail");
                runCallable.call();  
/*  
                }
import org.mockito.InOrder;
    public void testDoRunDoesNotRunWhenStoppedOrClosed() throws Exception {  
        // it's stopped or closed  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * You may obtain a copy of the License at  
            }  
 * compatible open source license.
            @Override
 * Licensed to Elasticsearch under one or more contributor  
    public void testDoRunOnlyRunsWhenNotStoppedOrClosed() throws Exception {
        AbstractLifecycleRunnable runnable = new AbstractLifecycleRunnable(lifecycle, logger) {
        runnable.run();
        inOrder.verifyNoMoreInteractions();
            }
            protected void onAfterInLifecycle() {
    public void testOnAfterDoesNotHappenWhenStoppedOrClosed() throws Exception {
            }
        };
 * not use this file except in compliance with the License.
import static org.mockito.Mockito.when;
        inOrder.verify(lifecycle).stoppedOrClosed();
/*
 * ownership. Elasticsearch licenses this file to you under  
                fail("Should not run with lifecycle stopped or closed.");  
        AbstractLifecycleRunnable runnable = new AbstractLifecycleRunnable(lifecycle, logger) {
        inOrder.verify(runCallable).call();
        inOrder.verifyNoMoreInteractions();
                    afterCallable.call();
        // it's stopped or closed
 *
import static org.mockito.Mockito.inOrder;
 * software distributed under the License is distributed on an
            @Override
        Callable<?> runCallable = mock(Callable.class);
 * KIND, either express or implied.  See the License for the
            @Override
package org.opensearch.common.util.concurrent;
            public void onFailure(Exception e) {
        Callable<?> runCallable = mock(Callable.class);
                fail("It should not fail");
 */
            @Override  
        runnable.run();
                fail("It should not fail");
import static org.mockito.Mockito.mock;
        inOrder.verify(lifecycle).stoppedOrClosed();
            @Override
        // it's "not stopped or closed"
            @Override  
import static org.mockito.Mockito.anyString;  
import org.apache.logging.log4j.Logger;  
    }
        runnable.run();  
 */
            @Override  
 * this file be licensed under the Apache-2.0 license or a
        when(lifecycle.stoppedOrClosed()).thenReturn(true);
        when(lifecycle.stoppedOrClosed()).thenReturn(true);
        };
 * Tests {@link AbstractLifecycleRunnable}.
 * specific language governing permissions and limitations
        // it's "not stopped or closed"
        inOrder.verify(lifecycle, times(2)).stoppedOrClosed();
        inOrder.verify(afterCallable).call();  
        AbstractLifecycleRunnable runnable = new AbstractLifecycleRunnable(lifecycle, logger) {
            }
 *
        inOrder.verifyNoMoreInteractions();
import org.opensearch.common.lifecycle.Lifecycle;
                    fail("Unexpected for mock.");  
public class AbstractLifecycleRunnableTests extends OpenSearchTestCase {  
        Callable<?> afterCallable = mock(Callable.class);  
                runCallable.call();
 * under the License.  
    private final Logger logger = mock(Logger.class);
    private final Lifecycle lifecycle = mock(Lifecycle.class);
import static org.mockito.Mockito.times;  
    public void testOnAfterOnlyWhenNotStoppedOrClosed() throws Exception {
            protected void onAfterInLifecycle() {
        Callable<?> runCallable = mock(Callable.class);
            protected void doRunInLifecycle() throws Exception {
        inOrder.verify(runCallable).call();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        inOrder.verify(lifecycle).stoppedOrClosed(); // onAfter uses it too, but we're not testing it here  
 */
        when(lifecycle.stoppedOrClosed()).thenReturn(false);
        InOrder inOrder = inOrder(lifecycle, logger, runCallable);
 * SPDX-License-Identifier: Apache-2.0
            protected void doRunInLifecycle() throws Exception {
        inOrder.verifyNoMoreInteractions();
    }  
        inOrder.verify(logger).trace(anyString());
import java.util.concurrent.Callable;
        };
 * The OpenSearch Contributors require contributions made to  
            }
            }
 * Modifications Copyright OpenSearch Contributors. See  
        };  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            protected void doRunInLifecycle() throws Exception {
        inOrder.verify(lifecycle).stoppedOrClosed();  
                fail("It should not fail");  
 * Unless required by applicable law or agreed to in writing,
            public void onFailure(Exception e) {  
            public void onFailure(Exception e) {
            }
        inOrder.verify(lifecycle).stoppedOrClosed();
                try {  
 */  
 * GitHub history for details.
        InOrder inOrder = inOrder(lifecycle, logger, runCallable);  
        when(lifecycle.stoppedOrClosed()).thenReturn(false);  
        InOrder inOrder = inOrder(lifecycle, runCallable);
            }  
        inOrder.verify(lifecycle).stoppedOrClosed(); // onAfter uses it too, but we're not testing it here
            @Override
    }  
/**  
import org.opensearch.common.SuppressLoggerChecks;
 * license agreements. See the NOTICE file distributed with
                } catch (Exception e) {
    @SuppressLoggerChecks(reason = "mock usage")
