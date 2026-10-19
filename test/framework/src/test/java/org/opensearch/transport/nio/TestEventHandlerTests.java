import java.util.concurrent.TimeUnit;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
            tests.put("registrationException", () -> eventHandler.registrationException(socketChannelContext, exception));  
                    return start;
import org.opensearch.nio.ServerChannelContext;
                entry.getValue().run();
            }  
    public void testLogOnElapsedTime() throws Exception {
/*  
import org.apache.logging.log4j.Level;
            for (Map.Entry<String, CheckedRunnable<Exception>> entry : tests.entrySet()) {
package org.opensearch.transport.nio;
            long start = System.nanoTime();  
import org.opensearch.threadpool.ThreadPool;  
            doAnswer(i -> timeSupplier.getAsLong()).when(threadPool).relativeTimeInNanos();  
import org.opensearch.common.CheckedRunnable;  
            tests.put("handleClose", () -> eventHandler.handleClose(socketChannelContext));  
 * You may obtain a copy of the License at  
            tests.put("acceptChannel", () -> eventHandler.acceptChannel(serverChannelContext));
                    return end;
 * Licensed to Elasticsearch under one or more contributor  
public class TestEventHandlerTests extends OpenSearchTestCase {
            final ThreadPool threadPool = mock(ThreadPool.class);
            Map<String, CheckedRunnable<Exception>> tests = new HashMap<>();
import static org.mockito.Mockito.mock;  
                    MockNioTransport.class.getCanonicalName(),
            AtomicBoolean isStart = new AtomicBoolean(true);
                () -> null,  
 * this work for additional information regarding copyright
                }
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.LongSupplier;  
 * not use this file except in compliance with the License.
            RuntimeException exception = new RuntimeException("boom");  
 *  
import org.opensearch.common.settings.Settings;
/*
import java.util.Map;  
 */  
            tests.put("handleRead", () -> eventHandler.handleRead(socketChannelContext));  
import org.opensearch.test.OpenSearchTestCase;
 */
            LongSupplier timeSupplier = () -> {  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(MockNioTransport.class))) {
import org.apache.logging.log4j.LogManager;
        }
                    Level.WARN,  
            tests.put("handleWrite", () -> eventHandler.handleWrite(socketChannelContext));
            TestEventHandler eventHandler = new TestEventHandler(
                String message = "*Slow execution on network thread*";
                throw new IllegalStateException("Cannot update isStart");  
 *
                e -> {},
            tests.put("connectException", () -> eventHandler.connectException(socketChannelContext, exception));
 * software distributed under the License is distributed on an
            long end = start + TimeUnit.MILLISECONDS.toNanos(400);
 * The OpenSearch Contributors require contributions made to  
            tests.put("handleConnect", () -> eventHandler.handleConnect(socketChannelContext));
 * GitHub history for details.
 * specific language governing permissions and limitations
 */  
            tests.put("acceptException", () -> eventHandler.acceptException(serverChannelContext, exception));
import java.util.HashMap;
import static org.mockito.Mockito.doAnswer;
                    entry.getKey(),
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    }
            tests.put("readException", () -> eventHandler.readException(socketChannelContext, exception));
import org.opensearch.nio.SocketChannelContext;  
 * KIND, either express or implied.  See the License for the
}  
                    message
            tests.put("genericChannelException", () -> eventHandler.genericChannelException(socketChannelContext, exception));
            SocketChannelContext socketChannelContext = mock(SocketChannelContext.class);
                new MockNioTransport.TransportThreadWatchdog(threadPool, Settings.EMPTY)
 * compatible open source license.
                );
                appender.assertAllExpectationsMatched();
 * SPDX-License-Identifier: Apache-2.0
            tests.put("closeException", () -> eventHandler.closeException(socketChannelContext, exception));
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
            tests.put("writeException", () -> eventHandler.writeException(socketChannelContext, exception));  
                if (isStart.compareAndSet(true, false)) {
            tests.put("handleTask", () -> eventHandler.handleTask(mock(Runnable.class)));
 *
            );
                } else if (isStart.compareAndSet(false, true)) {  
            tests.put("taskException", () -> eventHandler.taskException(exception));
            ServerChannelContext serverChannelContext = mock(ServerChannelContext.class);
                MockLogAppender.LoggingExpectation slowExpectation = new MockLogAppender.SeenEventExpectation(  
                appender.addExpectation(slowExpectation);  
import org.opensearch.test.MockLogAppender;
            };
 * under the License.  
