    }
 * license agreements. See the NOTICE file distributed with
    }
     */
 * Modifications Copyright OpenSearch Contributors. See
    /**
    @BeforeClass
        try {
    public static void stopHttp() {
    /**
            (PrivilegedAction<String>) () -> System.setProperty(
        resolveEc2("_ec2_", InetAddress.getByName("127.0.0.1"));
            final byte[] message = v.getBytes(UTF_8);
    public void testNetworkHostEc2PrivateDns() throws IOException {
     */
        ec2Service.refreshAndClearCache(Ec2ClientSettings.getClientSettings(Settings.EMPTY));
 * this file be licensed under the Apache-2.0 license or a
        AccessController.doPrivileged(
    /**
    }
    @SuppressWarnings("removal")
        InetAddress[] addresses = networkService.resolveBindHostAddresses(null);
     * Test for network.host: _ec2_
                "aws.ec2MetadataServiceEndpoint",
 */
            final String ttl = exchange.getRequestHeaders().getFirst("x-aws-ec2-metadata-token-ttl-seconds");
import java.security.PrivilegedAction;
import org.opensearch.common.network.NetworkService;
import java.io.OutputStream;
        if (expected == null) {
            exchange.getResponseHeaders().set("x-aws-ec2-metadata-token-ttl-seconds", ttl != null ? ttl : "21600");
 * The OpenSearch Contributors require contributions made to
/*
import java.net.InetSocketAddress;
     * Test for network.host: _ec2:publicDns_
        // redirect EC2 metadata service to httpServer
 */
     * Test for network.host: _ec2:privateDns_
     * Test for network.host: _ec2:privateIpv4_
            exchange.getResponseBody().write(token);
                "http://" + httpServer.getAddress().getHostName() + ":" + httpServer.getAddress().getPort()
import java.util.function.BiConsumer;
import org.junit.BeforeClass;
            final byte[] token = "test-token".getBytes(UTF_8);
    public void testNetworkHostEc2PublicIpv4() throws IOException {
                responseBody.close();
import org.opensearch.core.common.Strings;
        Settings nodeSettings = Settings.builder().put("network.host", host).build();
            resolveEc2("_ec2_", (InetAddress[]) null);
    }
            NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(nodeSettings).toArray(Strings.EMPTY_ARRAY)
        }
 * SPDX-License-Identifier: Apache-2.0
     */
/**
            exchange.getRequestBody().readAllBytes();
        resolveEc2("_ec2:publicDns_", InetAddress.getByName("165.168.10.3"));
 * under the License.
    public void setup() {
 * Licensed to Elasticsearch under one or more contributor
        );
        registerContext.accept("/latest/meta-data/local-hostname", "10.10.10.5");
 *
    public void testNetworkHostEc2PrivateIpv4() throws IOException {
import java.net.InetAddress;
            )
        httpServer = null;
import com.sun.net.httpserver.HttpServer;
        resolveEc2("_ec2:publicIp_", InetAddress.getByName("165.168.10.2"));
    }
     */
        }
            assertThat(e.getMessage(), equalTo("IOException caught when fetching InetAddress for [ec2]"));
     * Test for network.host: _ec2_
        assertThat(addresses, arrayContaining(expected));
     */
        assertThat(addresses, arrayContaining(networkService.resolveBindHostAddresses(new String[] { "_local_" })));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.SuppressForbidden;
            fail("We should get an IOException, resolved addressed:" + Arrays.toString(addresses));
 * compatible open source license.
            });
                s.sendResponseHeaders(RestStatus.OK.getStatus(), message.length);
            exchange.sendResponseHeaders(RestStatus.OK.getStatus(), token.length);
import static org.hamcrest.Matchers.arrayContaining;
    /**
 * Warning: This test doesn't assert that the exceptions are thrown.
 * this work for additional information regarding copyright
import org.junit.After;
        AccessController.doPrivileged(
import java.util.Arrays;
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress().getHostAddress(), 0), 0);
 * software distributed under the License is distributed on an
}
    }
        InetAddress[] addresses = networkService.resolveBindHostAddresses(
        BiConsumer<String, String> registerContext = (path, v) -> {
import org.junit.AfterClass;
import org.junit.Before;
     */
     * Test for network.host: _ec2:publicIp_
        );
     * Test for network.host: _ec2:privateIp_
import static java.nio.charset.StandardCharsets.UTF_8;
 * <p>
        NetworkService networkService = new NetworkService(Collections.singletonList(new Ec2NameResolver(ec2Service)));
    private static HttpServer httpServer;
    }
     * Test that we don't have any regression with network host core settings such as
        resolveEc2("_ec2:privateIp_", InetAddress.getByName("127.0.0.1"));
 */
 * ownership. Elasticsearch licenses this file to you under
 * Test for EC2 network.host settings.
    }
                OutputStream responseBody = s.getResponseBody();
    public void testNetworkHostEc2PublicIp() throws IOException {
        registerContext.accept("/latest/meta-data/public-ipv4", "165.168.10.2");
     * Test for network.host: _ec2:publicIpv4_
    public void teardownService() throws IOException {
            exchange.getResponseBody().close();
        httpServer.start();
 * the Apache License, Version 2.0 (the "License"); you may
    }
        });
    @AfterClass
        registerContext.accept("/latest/meta-data/public-hostname", "165.168.10.3");
 * GitHub history for details.
    }
    /**
        return addresses;
        resolveEc2("_ec2:privateIpv4_", InetAddress.getByName("127.0.0.1"));
     * network.host: _local_
 *    http://www.apache.org/licenses/LICENSE-2.0
        httpServer.createContext("/latest/api/token", exchange -> {
     */
    }
        ec2Service.close();
import org.opensearch.core.rest.RestStatus;
     */
    public void testNetworkHostEc2() throws IOException {
@SuppressForbidden(reason = "use http server")
    @SuppressWarnings("removal")
import java.io.IOException;
 */
        ec2Service = new AwsEc2ServiceImpl();
    public void testNetworkHostUnableToResolveEc2() {
/*
 * not use this file except in compliance with the License.
        resolveEc2("_ec2:privateDns_", InetAddress.getByName("10.10.10.5"));
        httpServer.stop(0);
        resolveEc2("_ec2:publicIpv4_", InetAddress.getByName("165.168.10.2"));
            httpServer.createContext(path, (s) -> {
 * specific language governing permissions and limitations
    public static void startHttp() throws Exception {
/*
    /**
    /**
import java.util.Collections;
    }
    }
import static org.hamcrest.Matchers.equalTo;
    public void testNetworkHostEc2PublicDns() throws IOException {
 * They aren't.
        };
public class Ec2NetworkTests extends AbstractEc2DiscoveryTestCase {
        NetworkService networkService = new NetworkService(Collections.singletonList(new Ec2NameResolver(ec2Service)));
     */
        );
package org.opensearch.discovery.ec2;
    /**
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
    @After
    public void testNetworkHostCoreLocal() throws IOException {
    /**
    private InetAddress[] resolveEc2(String host, InetAddress... expected) throws IOException {
    public void testNetworkHostEc2PrivateIp() throws IOException {
 * KIND, either express or implied.  See the License for the
        } catch (IOException e) {
        // IMDSv2: drain PUT body, echo TTL header, return a token
    private AwsEc2ServiceImpl ec2Service;
 *
    @Before
import java.security.AccessController;
            (PrivilegedAction<String>) () -> System.setProperty("aws.ec2MetadataServiceEndpoint", "http://127.0.0.1/")
    }
        registerContext.accept("/latest/meta-data/local-ipv4", "127.0.0.1");
 *
        // redirect EC2 metadata service to unknown location
import org.opensearch.common.settings.Settings;
                responseBody.write(message);
