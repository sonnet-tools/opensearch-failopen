        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);  
                assertThat(listener.actionGet(), nullValue());
import java.io.IOException;
/*  
 *
    }
    }  
                "127.0.0.1:9302",  
            new MockLogAppender.SeenEventExpectation(
        assertEquals("::1", addresses[0].getAddress());  
                "[::1]:9304",  
        assertEquals("127.0.0.1", addresses[0].getAddress());
    }
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6  
 * KIND, either express or implied.  See the License for the
        boolean expectClosed,  
            final FakeTcpChannel channel = new FakeTcpChannel();  
    public void testInvalidLength() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } catch (Exception ex) {
    public void testDefaultSeedAddressesWithSmallGlobalPortRange() {
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6  
        );
 * GitHub history for details.
        streamOutput.write(byte1);  
                "127.0.0.1:9502",
        expectThrows(NumberFormatException.class, () -> TcpTransport.parse("[::1]:100-200", 1000));
    }
 * Modifications Copyright OpenSearch Contributors. See
                "[::1]:9503",  
        assertEquals(2345, addresses[0].getPort());  
        } catch (Exception ex) {  
    public void testReadMessageLengthWithIncompleteHeader() throws IOException {
            Settings.builder()
            new OpenSearchException("simulated"),  
            : containsInAnyOrder(  
            fail("Expected exception");
                "[::1]:9301",  
            );
                "received HTTP response on transport port, ensure that transport port "
            assertEquals("invalid data length: -2", ex.getMessage());
        try {  
                "org.opensearch.transport.TcpTransport",  
            assertEquals(
        );  
            : containsInAnyOrder("127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302");
        try {  
                "127.0.0.1:9300",
                "message",
        byte byte2 = randomByte();  
                .put(TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(TransportSettings.DEFAULT_PROFILE).getKey(), "9300-9302")
        streamOutput.write(randomByte());
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6
                + Integer.toHexString(byte2 & 0xFF)
        streamOutput.write('E');
import java.nio.channels.CancelledKeyException;  
                + Integer.toHexString(byte2 & 0xFF)
 */  
                "message",
    }
        testDefaultSeedAddresses(Settings.builder().put(TransportSettings.PORT.getKey(), "9300-9302").build(), seedAddressMatcher);  
        );
        byte byte1 = randomByte();
                "127.0.0.1:9500",
        }
                "127.0.0.1:9502",
            TcpTransport.readMessageLength(streamOutput.bytes());
                "[::1]:9302",
                lifecycle.moveToStarted();  
                .put(TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(TransportSettings.DEFAULT_PROFILE).getKey(), "9300-9302")
            )
    public void testHTTPResponse() throws IOException {
                assertTrue(listener.isDone());
            assertEquals(expected, ex.getMessage());
        streamOutput.write('M');  
            assertEquals(expected, ex.getMessage());
        testExceptionHandling(
 * Unless required by applicable law or agreed to in writing,
        streamOutput.write(randomByte());
    public void testDefaultSeedAddressesWithNonstandardProfilePortRange() {  
    }  
import org.apache.logging.log4j.LogManager;
        streamOutput.write(0x16);
                "127.0.0.1:9304",
            new BindException(),  
        assertEquals(1, addresses.length);
            final PlainActionFuture<Void> listener = new PlainActionFuture<>();
            channel.addCloseListener(listener);
        testExceptionHandling(
    public void testRejectsPortRanges() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testInvalidHeader() throws IOException {  
                "[::1]:9300",
            new StreamCorruptedException("simulated"),  
        streamOutput.write('A');
            assertThat(ex, instanceOf(StreamCorruptedException.class));  
            appender.assertAllExpectationsMatched();
                "127.0.0.1:9303",
            TcpTransport.handleException(channel, exception, lifecycle, new OutboundHandler(new StatsTracker(), testThreadPool));
                "127.0.0.1:9503",  
        );
                Level.WARN,
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.transport.TransportAddress;
        byte byte1 = randomByte();
import java.io.StreamCorruptedException;  
    public void testDefaultSeedAddressesWithNonstandardGlobalPortRange() {
        streamOutput.write(randomByte());
        );
                "org.opensearch.transport.TcpTransport",  
import org.opensearch.common.lifecycle.Lifecycle;
    @TestLogging(reason = "testing logging", value = "org.opensearch.transport.TcpTransport:DEBUG")  
            NetworkUtils.SUPPORTS_V6 ? containsInAnyOrder("[::1]:9500", "127.0.0.1:9500") : containsInAnyOrder("127.0.0.1:9500")  
            true,  
 * The OpenSearch Contributors require contributions made to  
        streamOutput.write(1);  
import org.opensearch.common.network.NetworkUtils;
            )  
                protected TcpServerChannel bind(String name, InetSocketAddress address) {
    }
            );
                "127.0.0.1:9505"
            }
        testExceptionHandling(true, exception, true, expectations);  
    public void testParseV6DefaultPort() throws Exception {
        streamOutput.write('S');
            new OpenSearchException("simulated"),
    }  
                "127.0.0.1:9500",
            Settings.builder()
                "org.opensearch.transport.TcpTransport",  
        assertEquals(2345, addresses[0].getPort());
 * software distributed under the License is distributed on an
    private void testExceptionHandling(  
            for (char c : httpHeader.toCharArray()) {
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.ERROR, "*"),  
/*
            )  
                "message",
            final Lifecycle lifecycle = new Lifecycle();  
        streamOutput.write(randomByte());
                "127.0.0.1:9305"
                testThreadPool,
            fail("Expected exception");
            true,
    /** Test ipv4 host with a default port works */  
                "127.0.0.1:9504",  
    }
        streamOutput.write('S');
                Version.CURRENT,  
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
                "127.0.0.1:9503",
    public void testParseV4WithPort() throws Exception {
        testDefaultSeedAddresses(Settings.builder().put(TransportSettings.PORT.getKey(), "9500-9600").build(), seedAddressMatcher);
            new TcpTransport.HttpRequestOnTransportException("test"),
        MockLogAppender.LoggingExpectation... expectations
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
                }  
            ? containsInAnyOrder(
import org.opensearch.test.junit.annotations.TestLogging;  
                "close connection exception caught on transport layer [*], disconnecting from relevant node"
        assertEquals(0, TcpTransport.readMessageLength(streamOutput.bytes()));
                "[::1]:9503",
        try {  
                @Override  
    }  
            streamOutput.write(new byte[6]);
        streamOutput.write(byte1);
                + ")";  
    public void testReadPingMessageLength() throws IOException {
        streamOutput.write('M');  
import org.opensearch.common.util.MockPageCacheRecycler;  
    }  
 * specific language governing permissions and limitations
            )  
            ) {
        TransportAddress[] addresses = TcpTransport.parse("[::1]:2345", 1234);  
    public void testTLSHeader() throws IOException {
                "127.0.0.1:9503",
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
    /** Test ipv4 host with port works */  
import org.opensearch.OpenSearchException;  
package org.opensearch.transport;
                "simulated, [*], closing connection"
            String expected = "invalid internal transport message format, got (45,43,"
            ? containsInAnyOrder(
                "127.0.0.1:9302",
        Exception exception,
        streamOutput.writeInt(-2);
        byte byte2 = randomByte();
            new ClosedChannelException(),  
        }
                "cancelled key exception caught on transport layer [*], disconnecting from relevant node"
            fail("Expected exception");
        }
 * this file be licensed under the Apache-2.0 license or a
            assertThat(tcpTransport.getDefaultSeedAddresses(), seedAddressesMatcher);
    private void testDefaultSeedAddresses(final Settings settings, Matcher<Iterable<? extends String>> seedAddressesMatcher) {
    public void testHTTPRequest() throws IOException {
                "127.0.0.1:9503",
        try {  
    public void testReadPingMessageLengthWithStartOfSecondMessage() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
import java.net.BindException;
        } catch (Exception ex) {  
    }
            TcpTransport.readMessageLength(streamOutput.bytes());
        streamOutput.write('E');
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.INFO, "*"),
                "127.0.0.1:9500",  
                @Override
                    throw new UnsupportedOperationException();  
                "[::1]:9303",
import java.util.Collections;
            new MockLogAppender.SeenEventExpectation(
        );
    /** Test ipv6 host with port works */
                "127.0.0.1:9505"
                ex.getMessage()
            Settings.builder().put(TransportSettings.PORT.getKey(), "9500").build(),
                .build(),
                "127.0.0.1:9300",
        assertEquals(1234, addresses[0].getPort());  
                "127.0.0.1:9305"  
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
                "org.opensearch.transport.TcpTransport",  
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6  
        } finally {  
 *  
            } else {  
                Level.WARN,
import java.util.concurrent.TimeUnit;  
        streamOutput.writeInt(-1);  
    }
import java.net.InetSocketAddress;
}
        }
                }
    }  
            fail("Expected exception");
    }  
        final TestThreadPool testThreadPool = new TestThreadPool("test");
                Level.DEBUG,
                Level.DEBUG,
                + Integer.toHexString(byte1 & 0xFF)  
 *
                "message",
        for (String httpHeader : httpHeaders) {
    public void testParseV4DefaultPort() throws Exception {
        } finally {
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(TcpTransport.class))) {
            new CancelledKeyException(),  
            )  
            ? containsInAnyOrder("[::1]:9300", "[::1]:9301", "[::1]:9302", "127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302")
        }
                assertFalse(listener.isDone());
import org.hamcrest.Matcher;  
                "bind exception caught on transport layer [*]"
import org.opensearch.cluster.node.DiscoveryNode;  
                "[::1]:9504",
            }
                "[::1]:9305",
                appender.addExpectation(expectation);  
        streamOutput.write('S');
        assertEquals(1, addresses.length);  
            )  
            )
                TcpTransport.readMessageLength(streamOutput.bytes());
            );
        streamOutput.write('E');  
    public void testReadMessageLength() throws IOException {
                assertThat(ex, instanceOf(TcpTransport.HttpRequestOnTransportException.class));
public class TcpTransportTests extends OpenSearchTestCase {
    public void testDefaultSeedAddressesWithDefaultPort() {
        }
    }
            : containsInAnyOrder("127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302");
        streamOutput.write('S');
 * under the License.  
                @Override
import org.opensearch.common.network.NetworkService;  
        streamOutput.write(0x03);  
        streamOutput.write(byte2);
        streamOutput.write(byte2);
                "[::1]:9501",  
        TransportAddress[] addresses = TcpTransport.parse("127.0.0.1", 1234);
import org.opensearch.threadpool.ThreadPool;
                new MockPageCacheRecycler(settings),
                "127.0.0.1:9303",
                streamOutput.write((byte) c);  
        assertEquals(-1, TcpTransport.readMessageLength(streamOutput.bytes()));
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);  
            for (MockLogAppender.LoggingExpectation expectation : expectations) {
 * license agreements. See the NOTICE file distributed with
        );
            )  
            fail("should have gotten exception");
                settings,
        testExceptionHandling(
        );
                "[::1]:9500",
            : containsInAnyOrder(  
                "[::1]:9504",  
            if (expectClosed) {  
            TcpTransport.readMessageLength(streamOutput.bytes());  
import org.opensearch.Version;
        assertEquals(1234, addresses[0].getPort());
        }  
            seedAddressMatcher
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.Matchers.containsInAnyOrder;
        } catch (Exception ex) {  
    public void testDefaultSeedAddressesWithSmallProfilePortRange() {
        TransportAddress[] addresses = TcpTransport.parse("127.0.0.1:2345", 1234);
        );
                "[::1]:9502",
        streamOutput.write(randomByte());  
                "org.opensearch.transport.TcpTransport",  
                    throw new UnsupportedOperationException();
        boolean startTransport,
                "[::1]:9505",
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);  
        assertEquals(1, addresses.length);  
                    + "(not HTTP port) of a remote node is specified in the configuration",  
        assertEquals("127.0.0.1", addresses[0].getAddress());
        streamOutput.write('T');
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.INFO, "*"),
                "127.0.0.1:9500",
 * this work for additional information regarding copyright
                "127.0.0.1:9301",
/** Unit tests for {@link TcpTransport} */  
                "close connection exception caught on transport layer [*], disconnecting from relevant node"
        assertEquals(1, addresses.length);
    /** Test ipv6 host with a default port works */
        streamOutput.write('S');
    public void testParseV6UnBracketed() throws Exception {
            ThreadPool.terminate(testThreadPool, 30, TimeUnit.SECONDS);
import org.opensearch.threadpool.TestThreadPool;
                "127.0.0.1:9504",  
            false,  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            testThreadPool.shutdown();  
                "127.0.0.1:9504",
import org.opensearch.common.settings.Settings;
            }
    }
                new NetworkService(Collections.emptyList()),
        testExceptionHandling(
                "127.0.0.1:9501",
        streamOutput.write('E');  
        streamOutput.write(randomByte());
    }  
            false,
        streamOutput.write(randomByte());  
        assertEquals(2, TcpTransport.readMessageLength(streamOutput.bytes()));  
import static org.hamcrest.core.IsInstanceOf.instanceOf;
                "127.0.0.1:9502",
    public void testDefaultSeedAddressesWithNonstandardSinglePort() {  
                .build(),  
            new MockLogAppender.SeenEventExpectation(
                "127.0.0.1:9304",  
        testExceptionHandling(
                assertEquals("This is not an HTTP port", ex.getMessage());  
            new MockLogAppender.SeenEventExpectation(
        } catch (IllegalArgumentException expected) {
            String expected = "SSL/TLS request received but SSL/TLS is not enabled on this node, got (16,3,"
                Level.DEBUG,
    }
                "127.0.0.1:9502",  
            : containsInAnyOrder(
 * compatible open source license.
                .put(TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(TransportSettings.DEFAULT_PROFILE).getKey(), "9500-9600")
        testDefaultSeedAddresses(  
        testExceptionHandling(
        streamOutput.write('H');
        streamOutput.write('A');
        );
                "exception caught on transport layer [*], closing connection"
            );
        }  
        assertEquals("::1", addresses[0].getAddress());  
                "127.0.0.1:9505"  
    public void testParseV6WithPort() throws Exception {
            if (startTransport) {
                writableRegistry(),
        streamOutput.write(1);
            seedAddressMatcher
                "[::1]:9501",
                "127.0.0.1:9501",  
import org.opensearch.action.support.PlainActionFuture;
                fail("Expected exception");  
    }
                Level.DEBUG,
        try {
        testDefaultSeedAddresses(
            final TcpTransport tcpTransport = new TcpTransport(
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.ERROR, "*"),  
 * not use this file except in compliance with the License.
        );
                "[::1]:9505",
                "127.0.0.1:9504",
            TcpTransport.readMessageLength(streamOutput.bytes());
                "127.0.0.1:9301",  
                NoopTracer.INSTANCE  
    public void testExceptionHandling() throws IllegalAccessException {
        testDefaultSeedAddresses(Settings.EMPTY, seedAddressMatcher);
import java.nio.channels.ClosedChannelException;
            ? containsInAnyOrder("[::1]:9300", "[::1]:9301", "[::1]:9302", "127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302")
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.WARN, "*"),
        );
                "message",
                protected void stopInternal() {
        streamOutput.write('P');
        String[] httpHeaders = { "GET", "POST", "PUT", "HEAD", "DELETE", "OPTIONS", "PATCH", "TRACE" };  
                + ")";  
        streamOutput.write(randomByte());  
    }
            seedAddressMatcher
        streamOutput.write('E');
                "message",
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6  
            };
            ? containsInAnyOrder("[::1]:9300", "[::1]:9301", "[::1]:9302", "127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302")
        testDefaultSeedAddresses(  
            }
    public void testDefaultSeedAddressesPrefersProfileSettingToGlobalSetting() {
                new NoneCircuitBreakerService(),  
        streamOutput.writeInt(-1);  
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.DEBUG, "*")  
        } catch (Exception ex) {
            new MockLogAppender.SeenEventExpectation(
                "[::1]:9500",  
    }  
            ? containsInAnyOrder(
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertTrue(expected.getMessage().contains("must be bracketed"));  
                "127.0.0.1:9505"
    /** Test unbracketed ipv6 hosts in configuration fail. Leave no ambiguity */  
                    throw new UnsupportedOperationException();
            assertThat(ex, instanceOf(StreamCorruptedException.class));
                .put(TransportSettings.PORT.getKey(), "9500-9600")  
            try {
 */
            Settings.builder()
    }  
import org.opensearch.test.MockLogAppender;
                "org.opensearch.transport.TcpTransport",  
                + Integer.toHexString(byte1 & 0xFF)  
                }
            assertThat(ex, instanceOf(StreamCorruptedException.class));
        TransportAddress[] addresses = TcpTransport.parse("[::1]", 1234);  
                + ","
                .build(),  
            : containsInAnyOrder("127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302");
        testDefaultSeedAddresses(  
    }
        testExceptionHandling(
 * You may obtain a copy of the License at  
            BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);  
        streamOutput.write('T');  
                protected TcpChannel initiateChannel(DiscoveryNode node) {  
                "[::1]:9502",
/*  
    }  
            new OpenSearchException("Connection reset"),  
                + ","
        streamOutput.write('S');
    }
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);  
            }
                "127.0.0.1:9501",  
            assertThat(ex, instanceOf(StreamCorruptedException.class));
        final TestThreadPool testThreadPool = new TestThreadPool("test");  
        testExceptionHandling(
        try {
    ) throws IllegalAccessException {
    private void testExceptionHandling(Exception exception, MockLogAppender.LoggingExpectation... expectations)
        streamOutput.write('E');
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.WARN, "*"),
import static org.hamcrest.Matchers.nullValue;  
        streamOutput.write('C');  
        assertEquals(0, TcpTransport.readMessageLength(streamOutput.bytes()));
 * SPDX-License-Identifier: Apache-2.0
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6  
            TcpTransport.parse("::1", 1234);  
 */  
        streamOutput.writeInt(2);
import org.apache.logging.log4j.Level;
                "127.0.0.1:9501",
            new MockLogAppender.SeenEventExpectation(
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.DEBUG, "*")  
        streamOutput.write('E');  
            )  
 * Licensed to Elasticsearch under one or more contributor  
        throws IllegalAccessException {
