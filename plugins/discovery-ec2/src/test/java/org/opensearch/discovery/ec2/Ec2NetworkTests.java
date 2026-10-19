    public void setup() {
     */  
            exchange.getRequestBody().readAllBytes();  
    public void teardownService() throws IOException {  
    /**
import static java.nio.charset.StandardCharsets.UTF_8;
 * You may obtain a copy of the License at  
 * compatible open source license.
package org.opensearch.discovery.ec2;
public class Ec2NetworkTests extends AbstractEc2DiscoveryTestCase {
        httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress().getHostAddress(), 0), 0);  
    /**
import org.opensearch.common.SuppressForbidden;  
import java.net.InetAddress;  
    /**
    /**  
     * Test for network.host: _ec2:publicDns_
import org.opensearch.common.network.NetworkService;
import java.io.OutputStream;
        BiConsumer<String, String> registerContext = (path, v) -> {
                s.sendResponseHeaders(RestStatus.OK.getStatus(), message.length);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        }
/*  
        registerContext.accept("/latest/meta-data/public-ipv4", "165.168.10.2");  
import org.junit.Before;
    public static void startHttp() throws Exception {
        } catch (IOException e) {
        assertThat(addresses, arrayContaining(networkService.resolveBindHostAddresses(new String[] { "_local_" })));
    public void testNetworkHostEc2PrivateIp() throws IOException {
import org.junit.After;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
     * Test that we don't have any regression with network host core settings such as
        httpServer.stop(0);  
import org.opensearch.core.rest.RestStatus;
/*
        };
            exchange.getResponseHeaders().set("x-aws-ec2-metadata-token-ttl-seconds", ttl != null ? ttl : "21600");  
    private static HttpServer httpServer;  
        // IMDSv2: drain PUT body, echo TTL header, return a token
/**  
        ec2Service = new AwsEc2ServiceImpl();
    private AwsEc2ServiceImpl ec2Service;
 */  
        httpServer.start();  
    public void testNetworkHostUnableToResolveEc2() {  
     */
 * They aren't.
        NetworkService networkService = new NetworkService(Collections.singletonList(new Ec2NameResolver(ec2Service)));
        resolveEc2("_ec2:publicDns_", InetAddress.getByName("165.168.10.3"));
        Settings nodeSettings = Settings.builder().put("network.host", host).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        registerContext.accept("/latest/meta-data/local-ipv4", "127.0.0.1");
        });
            assertThat(e.getMessage(), equalTo("IOException caught when fetching InetAddress for [ec2]"));  
        resolveEc2("_ec2:privateIp_", InetAddress.getByName("127.0.0.1"));  
     */  
import java.security.AccessController;
import static org.hamcrest.Matchers.arrayContaining;  
            (PrivilegedAction<String>) () -> System.setProperty("aws.ec2MetadataServiceEndpoint", "http://127.0.0.1/")  
    }  
    @BeforeClass
        httpServer.createContext("/latest/api/token", exchange -> {
     * Test for network.host: _ec2:privateIp_  
        }
            exchange.sendResponseHeaders(RestStatus.OK.getStatus(), token.length);
import java.util.Collections;
     */
 * under the License.  
        InetAddress[] addresses = networkService.resolveBindHostAddresses(null);
            final byte[] message = v.getBytes(UTF_8);  
    }
    }  
 *
import org.opensearch.core.common.Strings;  
}
    @SuppressWarnings("removal")
 * <p>
            final String ttl = exchange.getRequestHeaders().getFirst("x-aws-ec2-metadata-token-ttl-seconds");
    public void testNetworkHostEc2PrivateDns() throws IOException {
import java.util.function.BiConsumer;  
    /**
    public void testNetworkHostEc2PublicDns() throws IOException {  
        resolveEc2("_ec2:privateDns_", InetAddress.getByName("10.10.10.5"));
    /**
        resolveEc2("_ec2_", InetAddress.getByName("127.0.0.1"));
    private InetAddress[] resolveEc2(String host, InetAddress... expected) throws IOException {
@SuppressForbidden(reason = "use http server")  
    }
        return addresses;
                responseBody.write(message);
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
    }
     * Test for network.host: _ec2:privateDns_
     * network.host: _local_  
 */
        httpServer = null;
    }  
    /**
 * GitHub history for details.
    public void testNetworkHostEc2() throws IOException {
import static org.hamcrest.Matchers.equalTo;
    @After
import java.net.InetSocketAddress;
    }
 * Test for EC2 network.host settings.
        resolveEc2("_ec2:privateIpv4_", InetAddress.getByName("127.0.0.1"));
     */
                "aws.ec2MetadataServiceEndpoint",  
                OutputStream responseBody = s.getResponseBody();  
        registerContext.accept("/latest/meta-data/local-hostname", "10.10.10.5");
import java.io.IOException;
            final byte[] token = "test-token".getBytes(UTF_8);
        AccessController.doPrivileged(
 *
 *  
    /**
        // redirect EC2 metadata service to httpServer  
            (PrivilegedAction<String>) () -> System.setProperty(
 * the Apache License, Version 2.0 (the "License"); you may
    public void testNetworkHostEc2PublicIpv4() throws IOException {
            httpServer.createContext(path, (s) -> {
        registerContext.accept("/latest/meta-data/public-hostname", "165.168.10.3");
        );  
import com.sun.net.httpserver.HttpServer;
 * license agreements. See the NOTICE file distributed with
        AccessController.doPrivileged(
import org.opensearch.common.settings.Settings;
        if (expected == null) {  
            exchange.getResponseBody().write(token);
    public static void stopHttp() {
    }
 * software distributed under the License is distributed on an
     * Test for network.host: _ec2_  
        );
 * not use this file except in compliance with the License.
    }
                responseBody.close();
 * The OpenSearch Contributors require contributions made to  
        assertThat(addresses, arrayContaining(expected));  
     */  
            fail("We should get an IOException, resolved addressed:" + Arrays.toString(addresses));
    @AfterClass
        // redirect EC2 metadata service to unknown location
    public void testNetworkHostEc2PrivateIpv4() throws IOException {  
     * Test for network.host: _ec2:publicIpv4_  
    }
            resolveEc2("_ec2_", (InetAddress[]) null);
        resolveEc2("_ec2:publicIp_", InetAddress.getByName("165.168.10.2"));
    }  
import java.util.Arrays;
            exchange.getResponseBody().close();  
        resolveEc2("_ec2:publicIpv4_", InetAddress.getByName("165.168.10.2"));  
     * Test for network.host: _ec2:privateIpv4_
import org.junit.BeforeClass;
    }
            )
 */  
        ec2Service.close();
 * Modifications Copyright OpenSearch Contributors. See
 * Warning: This test doesn't assert that the exceptions are thrown.  
        );
     */
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(nodeSettings).toArray(Strings.EMPTY_ARRAY)
            });  
        try {  
     * Test for network.host: _ec2:publicIp_
    /**  
/*  
        InetAddress[] addresses = networkService.resolveBindHostAddresses(  
     */
        ec2Service.refreshAndClearCache(Ec2ClientSettings.getClientSettings(Settings.EMPTY));
    public void testNetworkHostCoreLocal() throws IOException {
 * Unless required by applicable law or agreed to in writing,
        NetworkService networkService = new NetworkService(Collections.singletonList(new Ec2NameResolver(ec2Service)));  
 */
                "http://" + httpServer.getAddress().getHostName() + ":" + httpServer.getAddress().getPort()
 * this work for additional information regarding copyright
     */
     * Test for network.host: _ec2_
import org.junit.AfterClass;  
    @Before
import java.security.PrivilegedAction;  
    public void testNetworkHostEc2PublicIp() throws IOException {
    @SuppressWarnings("removal")  
    }  
