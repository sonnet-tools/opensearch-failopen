            }
        }
    }
        } catch (Exception ex) {
    }
 *
            TcpTransport.readMessageLength(streamOutput.bytes());
                "127.0.0.1:9505"
        testDefaultSeedAddresses(
            seedAddressMatcher
        );
        String[] httpHeaders = { "GET", "POST", "PUT", "HEAD", "DELETE", "OPTIONS", "PATCH", "TRACE" };
                "127.0.0.1:9304",
            )
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                "[::1]:9302",
            new ClosedChannelException(),
        testExceptionHandling(
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
            false,
import org.opensearch.common.network.NetworkUtils;
    public void testDefaultSeedAddressesWithDefaultPort() {
            fail("Expected exception");
        );
        assertEquals(2, TcpTransport.readMessageLength(streamOutput.bytes()));
                + Integer.toHexString(byte1 & 0xFF)
        try {
            : containsInAnyOrder("127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302");
                "127.0.0.1:9301",
                + ","
                "127.0.0.1:9504",
            final TcpTransport tcpTransport = new TcpTransport(
 */
        );
        }
import org.opensearch.threadpool.ThreadPool;
                "message",
import org.opensearch.Version;
        testExceptionHandling(
                new NetworkService(Collections.emptyList()),
            ? containsInAnyOrder(
/*
        try {
                .put(TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(TransportSettings.DEFAULT_PROFILE).getKey(), "9500-9600")
        streamOutput.write(0x16);
        streamOutput.write('S');
            : containsInAnyOrder(
 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
            ? containsInAnyOrder("[::1]:9300", "[::1]:9301", "[::1]:9302", "127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302")
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Settings.builder()
        streamOutput.writeInt(-1);
                    throw new UnsupportedOperationException();
            : containsInAnyOrder(
import org.opensearch.test.OpenSearchTestCase;
            String expected = "SSL/TLS request received but SSL/TLS is not enabled on this node, got (16,3,"
                settings,
        assertEquals(1234, addresses[0].getPort());
        assertEquals("::1", addresses[0].getAddress());
            NetworkUtils.SUPPORTS_V6 ? containsInAnyOrder("[::1]:9500", "127.0.0.1:9500") : containsInAnyOrder("127.0.0.1:9500")
            new MockLogAppender.SeenEventExpectation(
                @Override
public class TcpTransportTests extends OpenSearchTestCase {
    public void testInvalidLength() throws IOException {
    public void testRejectsPortRanges() {
            } else {
        streamOutput.write(1);
                "[::1]:9504",
            streamOutput.write(new byte[6]);
                Level.WARN,
                "127.0.0.1:9501",
        }
            assertThat(ex, instanceOf(StreamCorruptedException.class));
            ? containsInAnyOrder("[::1]:9300", "[::1]:9301", "[::1]:9302", "127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302")
                "message",
                }
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
            )
    }
        testDefaultSeedAddresses(
        streamOutput.write('E');
 * under the License.
            seedAddressMatcher
            if (startTransport) {
        streamOutput.write('M');
                "127.0.0.1:9502",
            ) {
                "127.0.0.1:9501",
    }
    public void testInvalidHeader() throws IOException {
                "127.0.0.1:9505"
        }
            try {
    public void testReadPingMessageLength() throws IOException {
                "127.0.0.1:9303",
                NoopTracer.INSTANCE
                "[::1]:9505",
                "127.0.0.1:9300",
        assertEquals(1, addresses.length);
                "received HTTP response on transport port, ensure that transport port "
        streamOutput.write('C');
                new NoneCircuitBreakerService(),
    }
        testExceptionHandling(
                "message",
        }
        streamOutput.write('A');
        testExceptionHandling(true, exception, true, expectations);
                "message",
            true,
    }
import org.apache.logging.log4j.LogManager;
        streamOutput.write('T');
                "127.0.0.1:9500",
/*
import org.opensearch.cluster.node.DiscoveryNode;
    public void testDefaultSeedAddressesWithNonstandardGlobalPortRange() {
    }
            assertEquals(expected, ex.getMessage());
import java.util.Collections;
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.DEBUG, "*")
            assertThat(ex, instanceOf(StreamCorruptedException.class));
            TcpTransport.parse("::1", 1234);
            true,
        streamOutput.write(randomByte());
    public void testParseV4WithPort() throws Exception {
                "127.0.0.1:9501",
            )
            TcpTransport.readMessageLength(streamOutput.bytes());
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.WARN, "*"),
            new OpenSearchException("simulated"),
        streamOutput.write(byte2);
        );
            ? containsInAnyOrder(
        );
                + ","
            BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
        boolean expectClosed,
                + Integer.toHexString(byte2 & 0xFF)
        assertEquals(-1, TcpTransport.readMessageLength(streamOutput.bytes()));
            final Lifecycle lifecycle = new Lifecycle();
        testDefaultSeedAddresses(Settings.EMPTY, seedAddressMatcher);
 * software distributed under the License is distributed on an
        streamOutput.write('S');
        streamOutput.write(randomByte());
                "127.0.0.1:9502",
    }
                "127.0.0.1:9504",
                }
    public void testDefaultSeedAddressesWithSmallProfilePortRange() {
import org.hamcrest.Matcher;
            channel.addCloseListener(listener);
    public void testReadPingMessageLengthWithStartOfSecondMessage() throws IOException {
        assertEquals(2345, addresses[0].getPort());
        streamOutput.write('S');
            false,
                "127.0.0.1:9503",
        streamOutput.write('M');
            }
        final TestThreadPool testThreadPool = new TestThreadPool("test");
        expectThrows(NumberFormatException.class, () -> TcpTransport.parse("[::1]:100-200", 1000));
 *
    ) throws IllegalAccessException {
        streamOutput.write('T');
import static org.hamcrest.Matchers.nullValue;
            appender.assertAllExpectationsMatched();
        TransportAddress[] addresses = TcpTransport.parse("[::1]:2345", 1234);
            : containsInAnyOrder("127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302");
        for (String httpHeader : httpHeaders) {
import java.io.StreamCorruptedException;
            TcpTransport.readMessageLength(streamOutput.bytes());
            assertTrue(expected.getMessage().contains("must be bracketed"));
        MockLogAppender.LoggingExpectation... expectations
    }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            assertThat(tcpTransport.getDefaultSeedAddresses(), seedAddressesMatcher);
            fail("Expected exception");
                Level.DEBUG,
            }
            )
        assertEquals(0, TcpTransport.readMessageLength(streamOutput.bytes()));
                "org.opensearch.transport.TcpTransport",
            new TcpTransport.HttpRequestOnTransportException("test"),
                "[::1]:9502",
 * Unless required by applicable law or agreed to in writing,
        );
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.INFO, "*"),
            }
        testExceptionHandling(
            )
        );
                + ")";
        assertEquals(0, TcpTransport.readMessageLength(streamOutput.bytes()));
            new MockLogAppender.SeenEventExpectation(
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6
        testExceptionHandling(
            new MockLogAppender.SeenEventExpectation(
        streamOutput.write(randomByte());
            ? containsInAnyOrder("[::1]:9300", "[::1]:9301", "[::1]:9302", "127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302")
            new BindException(),
                "org.opensearch.transport.TcpTransport",
 * compatible open source license.
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6
    public void testParseV6DefaultPort() throws Exception {
            ThreadPool.terminate(testThreadPool, 30, TimeUnit.SECONDS);
        assertEquals("127.0.0.1", addresses[0].getAddress());
    public void testParseV6UnBracketed() throws Exception {
                protected TcpServerChannel bind(String name, InetSocketAddress address) {
    /** Test unbracketed ipv6 hosts in configuration fail. Leave no ambiguity */
/** Unit tests for {@link TcpTransport} */
        streamOutput.write('E');
import static org.hamcrest.Matchers.containsInAnyOrder;
        streamOutput.write('S');
            if (expectClosed) {
        streamOutput.write(byte1);
import org.opensearch.common.util.MockPageCacheRecycler;
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6
import java.net.InetSocketAddress;
        } finally {
                    + "(not HTTP port) of a remote node is specified in the configuration",
        byte byte2 = randomByte();
    public void testHTTPResponse() throws IOException {
        );
                new MockPageCacheRecycler(settings),
            );
        streamOutput.write(0x03);
            : containsInAnyOrder("127.0.0.1:9300", "127.0.0.1:9301", "127.0.0.1:9302");
                "[::1]:9501",
                TcpTransport.readMessageLength(streamOutput.bytes());
 * Modifications Copyright OpenSearch Contributors. See
    }
        final TestThreadPool testThreadPool = new TestThreadPool("test");
        streamOutput.write('H');
        streamOutput.write('E');
        Exception exception,
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6
    public void testDefaultSeedAddressesWithSmallGlobalPortRange() {
    }
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
        testDefaultSeedAddresses(
                "127.0.0.1:9305"
                fail("Expected exception");
        byte byte1 = randomByte();
                .build(),
        try {
    public void testParseV6WithPort() throws Exception {
import org.opensearch.OpenSearchException;
    /** Test ipv6 host with port works */
                "org.opensearch.transport.TcpTransport",
        );
    }
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.DEBUG, "*")
    private void testDefaultSeedAddresses(final Settings settings, Matcher<Iterable<? extends String>> seedAddressesMatcher) {
        } finally {
            String expected = "invalid internal transport message format, got (45,43,"
                "org.opensearch.transport.TcpTransport",
                .build(),
            Settings.builder()
            fail("Expected exception");
    }
            )
                @Override
            )
                "127.0.0.1:9504",
                "org.opensearch.transport.TcpTransport",
        assertEquals("::1", addresses[0].getAddress());
 * specific language governing permissions and limitations
        assertEquals(1, addresses.length);
            for (MockLogAppender.LoggingExpectation expectation : expectations) {
import org.opensearch.common.io.stream.BytesStreamOutput;
            final FakeTcpChannel channel = new FakeTcpChannel();
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.ERROR, "*"),
                "[::1]:9501",
            fail("Expected exception");
            assertEquals("invalid data length: -2", ex.getMessage());
 */
        streamOutput.write('E');
            assertEquals(
            new MockLogAppender.SeenEventExpectation(
    public void testReadMessageLength() throws IOException {
            )
                "127.0.0.1:9502",
            Settings.builder()
                "127.0.0.1:9500",
                "127.0.0.1:9300",
        streamOutput.writeInt(2);
 * ownership. Elasticsearch licenses this file to you under
    private void testExceptionHandling(Exception exception, MockLogAppender.LoggingExpectation... expectations)
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.ERROR, "*"),
                "127.0.0.1:9305"
    }
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(TcpTransport.class))) {
                assertTrue(listener.isDone());
            } catch (Exception ex) {
                + Integer.toHexString(byte2 & 0xFF)
                assertThat(ex, instanceOf(TcpTransport.HttpRequestOnTransportException.class));
        streamOutput.write(randomByte());
        }
                "[::1]:9301",
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
        streamOutput.write(byte2);
        streamOutput.write(randomByte());
                ex.getMessage()
        boolean startTransport,
                + Integer.toHexString(byte1 & 0xFF)
        streamOutput.write(randomByte());
            )
            assertThat(ex, instanceOf(StreamCorruptedException.class));
                Level.WARN,
        } catch (Exception ex) {
                "close connection exception caught on transport layer [*], disconnecting from relevant node"
        assertEquals(1, addresses.length);
        TransportAddress[] addresses = TcpTransport.parse("[::1]", 1234);
import java.nio.channels.ClosedChannelException;
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
        streamOutput.write('P');
import java.nio.channels.CancelledKeyException;
                "127.0.0.1:9302",
package org.opensearch.transport;
                "[::1]:9502",
                + ")";
        testDefaultSeedAddresses(Settings.builder().put(TransportSettings.PORT.getKey(), "9300-9302").build(), seedAddressMatcher);
                "[::1]:9304",
        TransportAddress[] addresses = TcpTransport.parse("127.0.0.1", 1234);
                "[::1]:9505",
                "127.0.0.1:9501",
            testThreadPool.shutdown();
 * license agreements. See the NOTICE file distributed with
                .put(TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(TransportSettings.DEFAULT_PROFILE).getKey(), "9300-9302")
                "exception caught on transport layer [*], closing connection"
                Level.DEBUG,
                testThreadPool,
 */
            new OpenSearchException("simulated"),
            assertEquals(expected, ex.getMessage());
        try {
                Version.CURRENT,
            fail("should have gotten exception");
    public void testDefaultSeedAddressesPrefersProfileSettingToGlobalSetting() {
    public void testHTTPRequest() throws IOException {
            TcpTransport.handleException(channel, exception, lifecycle, new OutboundHandler(new StatsTracker(), testThreadPool));
/*
import org.apache.logging.log4j.Level;
        testDefaultSeedAddresses(
            );
 * this file be licensed under the Apache-2.0 license or a
                streamOutput.write((byte) c);
        streamOutput.writeInt(-1);
    }
    }
                "127.0.0.1:9304",
                "[::1]:9503",
                "bind exception caught on transport layer [*]"
import org.opensearch.common.network.NetworkService;
import java.util.concurrent.TimeUnit;
                .put(TransportSettings.PORT.getKey(), "9500-9600")
                @Override
    }
        streamOutput.write('S');
 * GitHub history for details.
    }
                assertEquals("This is not an HTTP port", ex.getMessage());
                "127.0.0.1:9503",
            new StreamCorruptedException("simulated"),
                "org.opensearch.transport.TcpTransport",
                "close connection exception caught on transport layer [*], disconnecting from relevant node"
                "[::1]:9500",
 * You may obtain a copy of the License at
                protected TcpChannel initiateChannel(DiscoveryNode node) {
        assertEquals(2345, addresses[0].getPort());
        streamOutput.write(randomByte());
                "127.0.0.1:9503",
    }
import org.opensearch.action.support.PlainActionFuture;
        }
                assertThat(listener.actionGet(), nullValue());
                "127.0.0.1:9303",
    public void testReadMessageLengthWithIncompleteHeader() throws IOException {
        testExceptionHandling(
    }
                writableRegistry(),
 * not use this file except in compliance with the License.
import org.opensearch.threadpool.TestThreadPool;
            new MockLogAppender.SeenEventExpectation(
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
            final PlainActionFuture<Void> listener = new PlainActionFuture<>();
 * this work for additional information regarding copyright
import static org.hamcrest.core.IsInstanceOf.instanceOf;
                lifecycle.moveToStarted();
    public void testTLSHeader() throws IOException {
                Level.DEBUG,
            seedAddressMatcher
        assertEquals("127.0.0.1", addresses[0].getAddress());
                appender.addExpectation(expectation);
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
        try {
            assertThat(ex, instanceOf(StreamCorruptedException.class));
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.INFO, "*"),
        testExceptionHandling(
import org.opensearch.test.junit.annotations.TestLogging;
                "simulated, [*], closing connection"
            );
}
                "message",
        byte byte2 = randomByte();
                "[::1]:9303",
import org.opensearch.common.lifecycle.Lifecycle;
        streamOutput.write('S');
        streamOutput.write(1);
                "cancelled key exception caught on transport layer [*], disconnecting from relevant node"
                assertFalse(listener.isDone());
                    throw new UnsupportedOperationException();
        streamOutput.write('E');
            new MockLogAppender.UnseenEventExpectation("message", "org.opensearch.transport.TcpTransport", Level.WARN, "*"),
    /** Test ipv4 host with a default port works */
        );
    }
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
                    throw new UnsupportedOperationException();
                "127.0.0.1:9302",
    private void testExceptionHandling(
        assertEquals(1234, addresses[0].getPort());
    public void testDefaultSeedAddressesWithNonstandardSinglePort() {
        BytesStreamOutput streamOutput = new BytesStreamOutput(1 << 14);
    }
                protected void stopInternal() {
            TcpTransport.readMessageLength(streamOutput.bytes());
    }
                "[::1]:9503",
        );
    }
        throws IllegalAccessException {
            new CancelledKeyException(),
        } catch (Exception ex) {
                .build(),
    /** Test ipv4 host with port works */
import org.opensearch.core.common.transport.TransportAddress;
                "[::1]:9500",
                "message",
import java.net.BindException;
            for (char c : httpHeader.toCharArray()) {
        streamOutput.write(byte1);
            );
                "127.0.0.1:9500",
        TransportAddress[] addresses = TcpTransport.parse("127.0.0.1:2345", 1234);
 *
                "127.0.0.1:9505"
                "127.0.0.1:9504",
            };
        streamOutput.write('E');
                "127.0.0.1:9503",
        testExceptionHandling(
        streamOutput.write('A');
        streamOutput.write(randomByte());
                .put(TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(TransportSettings.DEFAULT_PROFILE).getKey(), "9300-9302")
                "127.0.0.1:9505"
    public void testExceptionHandling() throws IllegalAccessException {
                Level.DEBUG,
        streamOutput.writeInt(-2);
                "127.0.0.1:9500",
                }
                "[::1]:9305",
            new OpenSearchException("Connection reset"),
        } catch (Exception ex) {
import java.io.IOException;
        } catch (IllegalArgumentException expected) {
        testDefaultSeedAddresses(Settings.builder().put(TransportSettings.PORT.getKey(), "9500-9600").build(), seedAddressMatcher);
        final Matcher<Iterable<? extends String>> seedAddressMatcher = NetworkUtils.SUPPORTS_V6
        try {
    @TestLogging(reason = "testing logging", value = "org.opensearch.transport.TcpTransport:DEBUG")
                "[::1]:9504",
            ? containsInAnyOrder(
import org.opensearch.test.MockLogAppender;
        streamOutput.write('E');
                "[::1]:9300",
    /** Test ipv6 host with a default port works */
            new MockLogAppender.SeenEventExpectation(
        assertEquals(1, addresses.length);
        }
    }
        byte byte1 = randomByte();
 * the Apache License, Version 2.0 (the "License"); you may
    }
            Settings.builder().put(TransportSettings.PORT.getKey(), "9500").build(),
                "127.0.0.1:9502",
            : containsInAnyOrder(
    public void testDefaultSeedAddressesWithNonstandardProfilePortRange() {
    public void testParseV4DefaultPort() throws Exception {
            }
 * KIND, either express or implied.  See the License for the
                "127.0.0.1:9301",
