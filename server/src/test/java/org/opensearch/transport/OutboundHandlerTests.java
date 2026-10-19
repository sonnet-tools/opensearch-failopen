        super.tearDown();  
 *
import java.io.IOException;
        StatsTracker statsTracker = new StatsTracker();
import org.opensearch.threadpool.ThreadPool;  
 * this file be licensed under the Apache-2.0 license or a
        BytesArray bytesArray = new BytesArray("message".getBytes(StandardCharsets.UTF_8));
import org.opensearch.core.common.bytes.BytesReference;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        BytesReference reference = channel.getMessageCaptor().get();
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
/*  
 * under the License.  
 */
        if (randomBoolean()) {
 * software distributed under the License is distributed on an
        channel = new FakeTcpChannel(randomBoolean(), buildNewFakeTransportAddress().address(), buildNewFakeTransportAddress().address());
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
/*  
            assertNull(exception.get());
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        }
        } else {
import java.util.concurrent.atomic.AtomicReference;
        AtomicBoolean isSuccess = new AtomicBoolean(false);  
    public void setUp() throws Exception {
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
    private final TestThreadPool threadPool = new TestThreadPool(getClass().getName());  
import org.opensearch.core.action.ActionListener;
    }
/*
 * SPDX-License-Identifier: Apache-2.0
        ActionListener<Void> listener = ActionListener.wrap((v) -> isSuccess.set(true), exception::set);
    @Before
    }
import org.junit.After;
            IOException e = new IOException("failed");  
        super.setUp();  
 * specific language governing permissions and limitations
 *  
import org.opensearch.threadpool.TestThreadPool;
 * Licensed to Elasticsearch under one or more contributor  
            assertTrue(isSuccess.get());  
            assertFalse(isSuccess.get());
 */  
    private FakeTcpChannel channel;
    public void testSendRawBytes() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private OutboundHandler handler;
import org.junit.Before;
    public void tearDown() throws Exception {
        AtomicReference<Exception> exception = new AtomicReference<>();
 * ownership. Elasticsearch licenses this file to you under  
        handler.sendBytes(channel, bytesArray, listener);  
import org.opensearch.core.common.bytes.BytesArray;
    @After  
            sendListener.onResponse(null);
 * compatible open source license.
import java.nio.charset.StandardCharsets;
public class OutboundHandlerTests extends OpenSearchTestCase {
            sendListener.onFailure(e);
 * GitHub history for details.
}  
package org.opensearch.transport;
            assertSame(e, exception.get());  
 * this work for additional information regarding copyright
        ActionListener<Void> sendListener = channel.getListenerCaptor().get();  
import java.util.concurrent.atomic.AtomicBoolean;
    }
        handler = new OutboundHandler(statsTracker, threadPool);  
 */  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 *
        assertEquals(bytesArray, reference);  
import java.util.concurrent.TimeUnit;  
