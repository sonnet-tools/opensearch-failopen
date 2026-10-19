import org.opensearch.common.settings.Settings;
        nioGroup.close();
    @SuppressWarnings("unchecked")
        // will throw an exception is stop fails
 *
 * Unless required by applicable law or agreed to in writing,
    public void testExceptionAtStartIsHandled() throws IOException {  
    public void tearDown() throws Exception {  
            (s) -> new EventHandler(mock(Consumer.class), s)
    public void testStartAndClose() throws IOException {
            1,  
 * The OpenSearch Contributors require contributions made to  
    @Override
import org.opensearch.test.OpenSearchTestCase;  
    private NioSelectorGroup nioGroup;
            r -> { throw ex; },  
        );
/*
 * Licensed to Elasticsearch under one or more contributor  
            IllegalStateException.class,  
 * compatible open source license.
import java.net.InetSocketAddress;  
            daemonThreadFactory(Settings.EMPTY, "selector"),
        assertSame(ex, runtimeException);
 *  
        // ctor starts threads. So we are testing that a failure to construct will stop threads. Our thread
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IllegalStateException ise = expectThrows(  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
public class NioSelectorGroupTests extends OpenSearchTestCase {  
    @SuppressWarnings("unchecked")
/*  
        nioGroup.close();
    }  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
import static org.mockito.Mockito.mock;
    public void setUp() throws Exception {  
 *
            (s) -> new EventHandler(mock(Consumer.class), s)
            daemonThreadFactory(Settings.EMPTY, "selector"),
            1,
        ise = expectThrows(
    }
        );
        RuntimeException ex = new RuntimeException();
        );  
        assertEquals("NioGroup is closed.", ise.getMessage());  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * this work for additional information regarding copyright
        // linger checks will throw an exception is stop fails  
    }
        nioGroup.close();
    public void testCanCloseTwice() throws IOException {  
            () -> nioGroup.bindServerChannel(mock(InetSocketAddress.class), mock(ChannelFactory.class))
 * under the License.  
            daemonThreadFactory(Settings.EMPTY, "acceptor"),  
    }  
    public void testCannotOperateAfterClose() throws IOException {  
    }  
 * license agreements. See the NOTICE file distributed with
        RuntimeException runtimeException = expectThrows(RuntimeException.class, ctor::run);  
package org.opensearch.nio;
 * software distributed under the License is distributed on an
 */
        nioGroup.close();
import java.util.function.Consumer;
        CheckedRunnable<IOException> ctor = () -> new NioSelectorGroup(
        nioGroup.close();
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;  
        assertEquals("NioGroup is closed.", ise.getMessage());
        );
            () -> nioGroup.openChannel(mock(InetSocketAddress.class), mock(ChannelFactory.class))
import org.opensearch.common.CheckedRunnable;
            IllegalStateException.class,
 * GitHub history for details.
        super.setUp();
 */  
    }  
            1,  
/*  
        // ctor starts threads. So we are testing that close() stops the threads. Our thread linger checks  
            1,
 * You may obtain a copy of the License at  
        nioGroup = new NioSelectorGroup(
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    @SuppressWarnings("unchecked")
 */  
}
        super.tearDown();
