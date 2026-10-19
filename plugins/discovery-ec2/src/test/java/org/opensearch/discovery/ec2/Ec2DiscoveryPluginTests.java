import software.amazon.awssdk.regions.Region;
            if (!"test-token".equals(token)) {
/*  
        mockSecure2.setString(Ec2ClientSettings.ACCESS_KEY_SETTING.getKey(), "ec2_access_2");  
 *
            this.endpoint = endpoint;
    private static class Ec2DiscoveryPluginMock extends Ec2DiscoveryPlugin {
    private static Ec2MetadataClient buildTestClient(URI endpoint) {
            try (AmazonEc2ClientReference clientReference = plugin.ec2Service.client()) {
                exchange.getResponseBody().close();  
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings)) {
                    AwsCredentialsProvider credentials,
                    } else {  
        } finally {  
    private void assertNodeAttributes(Settings settings, Ec2MetadataClient client, String expected) {
        final Settings settings = Settings.builder().build();
                    assertEquals(mockEc2Client.endpoint, "ec2_endpoint_1");  
        } else {
                assertNodeAttributes(Settings.EMPTY, client, "us-east-1c");
        final Settings realSettings = Settings.builder().put(AwsEc2Service.AUTO_ATTRIBUTE_SETTING.getKey(), true).put(settings).build();  
        final Settings settings = Settings.builder().put(AwsEc2Service.AUTO_ATTRIBUTE_SETTING.getKey(), false).build();
        final Settings settings = Settings.builder().put(Ec2ClientSettings.ENDPOINT_SETTING.getKey(), "ec2.endpoint").build();
            exchange.sendResponseHeaders(200, response.length);
        ) {  
            .setSecureSettings(mockSecure2)
 * SPDX-License-Identifier: Apache-2.0
                    assertEquals(mockEc2Client.proxyConfiguration.host(), "proxy-host-1");
            final String region = ((MockEc2Client) plugin.ec2Service.client().get()).region;  
        mockSecure2.setString(Ec2ClientSettings.PROXY_PASSWORD_SETTING.getKey(), "proxy_password_2");
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
            mockSecure1.setString(Ec2ClientSettings.SESSION_TOKEN_SETTING.getKey(), "ec2_session_token_1");  
            .put(Ec2ClientSettings.REGION_SETTING.getKey(), "ec2_region")
    public void testNodeAttributesErrorLenient() throws Exception {
        String endpoint;
/*  
 *
@SuppressForbidden(reason = "use a http server")
                @Override
        return Ec2MetadataClient.builder().endpoint(endpoint).httpClient(ApacheHttpClient.builder().useIdleConnectionReaper(false)).build();
            final Settings result = plugin.getAvailabilityZoneNodeAttributes(settings);  
            exchange.sendResponseHeaders(200, token.length);
 * GitHub history for details.
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings)) {
        if (mockSecure1HasSessionToken) {
        final HttpServer server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
                        assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "ec2_session_token_1");
            .put(Ec2ClientSettings.PROXY_HOST_SETTING.getKey(), "proxy-host-1")
            assertEquals(expected, additional.get(Node.NODE_ATTRIBUTES.getKey() + "aws_availability_zone"));
            }
        });
        MockEc2Client(
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings)) {  
            assertEquals(region, Region.US_WEST_2.toString());  
        final Settings settings1 = Settings.builder()
            try (AmazonEc2ClientReference clientReference = plugin.ec2Service.client()) {
                }  
 * Licensed to Elasticsearch under one or more contributor  
        mockSecure1.setString(Ec2ClientSettings.SECRET_KEY_SETTING.getKey(), "ec2_secret_1");  
    }  
            final InetSocketAddress address = server.getAddress();
            .put(Ec2ClientSettings.PROXY_PORT_SETTING.getKey(), 881)  
                final MockEc2Client mockEc2Client = (MockEc2Client) clientReference.get();  
                {
import java.io.IOException;
                }  
 * compatible open source license.
                    assertEquals(mockEc2Client.proxyConfiguration.host(), "proxy-host-1");
            exchange.getRequestBody().readAllBytes();  
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings)) {
 */  
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
                    final MockEc2Client mockEc2Client = (MockEc2Client) clientReference.get();  
                assertEquals(credentials.secretAccessKey(), "ec2_secret_2");
        final MockSecureSettings mockSecure1 = new MockSecureSettings();
import java.net.InetAddress;  
                plugin.reload(settings2);
                if (mockSecure2HasSessionToken) {  
        }
        }
            exchange.getResponseHeaders().set("x-aws-ec2-metadata-token-ttl-seconds", ttl != null ? ttl : "21600");  
            assertTrue(additional.isEmpty());  
                    assertEquals(mockEc2Client.proxyConfiguration.username(), "proxy_username_1");  
                    final AwsCredentials credentials = mockEc2Client.credentials.resolveCredentials();  
        final boolean mockSecure1HasSessionToken = randomBoolean();
                    long readTimeoutMillis  
    public void testSpecificRegion() throws IOException {
        final long readTimeoutMillis;  
    }  
 * specific language governing permissions and limitations
            final byte[] token = "test-token".getBytes(UTF_8);
        @Override  
                    assertEquals(mockEc2Client.proxyConfiguration.username(), "proxy_username_1");  
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;  
                    assertFalse(mockEc2Client.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
    }  
 * ownership. Elasticsearch licenses this file to you under  
                    if (mockSecure1HasSessionToken) {  
        final ProxyConfiguration proxyConfiguration;
    }  
            long readTimeoutMillis
        if (mockSecure2HasSessionToken) {  
                } else {  
            .build();
                    assertFalse(mockEc2Client.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
/*
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(Settings.EMPTY)) {  
            this.proxyConfiguration = proxyConfiguration;
                    } else {  
        mockSecure1.setString(Ec2ClientSettings.PROXY_USERNAME_SETTING.getKey(), "proxy_username_1");
                    assertEquals(mockEc2Client.endpoint, "ec2_endpoint_1");
 * software distributed under the License is distributed on an
import java.net.InetSocketAddress;
import static java.nio.charset.StandardCharsets.UTF_8;
 * not use this file except in compliance with the License.
                assertEquals(mockEc2Client.endpoint, "ec2_endpoint_2");
                    assertEquals(mockEc2Client.proxyConfiguration.password(), "proxy_password_1");
            .put(Ec2ClientSettings.PROXY_HOST_SETTING.getKey(), "proxy-host-2")  
import software.amazon.awssdk.auth.credentials.AwsCredentials;
    }  
                assertEquals(mockEc2Client.proxyConfiguration.password(), "proxy_password_2");
        mockSecure1.setString(Ec2ClientSettings.ACCESS_KEY_SETTING.getKey(), "ec2_access_1");
                        assertThat(credentials, instanceOf(AwsSessionCredentials.class));
public class Ec2DiscoveryPluginTests extends AbstractEc2DiscoveryTestCase {
                protected Ec2Client buildClient(  
        final ClientOverrideConfiguration clientOverrideConfiguration;
            this.clientOverrideConfiguration = clientOverrideConfiguration;  
                assertEquals(mockEc2Client.proxyConfiguration.port(), 882);
        mockSecure2.setString(Ec2ClientSettings.PROXY_USERNAME_SETTING.getKey(), "proxy_username_2");  
import java.net.URI;
        final Settings settings = Settings.builder().put(Ec2ClientSettings.REGION_SETTING.getKey(), "us-west-2").build();  
 * You may obtain a copy of the License at  
                    ProxyConfiguration proxyConfiguration,
            String endpoint,  
    }
                {
        server.createContext("/latest/meta-data/placement/availability-zone", exchange -> {
                    if (mockSecure1HasSessionToken) {  
        final String region;
            exchange.getResponseBody().write(response);
            .put(Ec2ClientSettings.ENDPOINT_SETTING.getKey(), "ec2_endpoint_1")
        server.start();
    }
        }
import software.amazon.awssdk.http.apache.ApacheHttpClient;
            final String token = exchange.getRequestHeaders().getFirst("x-aws-ec2-metadata-token");  
            .build();
            assertEquals(endpoint, "");
                return;
            assertTrue(result.isEmpty());
    private static class MockEc2Client implements Ec2Client {
            final URI endpoint = URI.create("http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort());
        }  
                assertEquals(mockEc2Client.proxyConfiguration.host(), "proxy-host-2");
                    assertThat(credentials, instanceOf(AwsSessionCredentials.class));
                    return new MockEc2Client(credentials, proxyConfiguration, overrideConfiguration, endpoint, region, readTimeoutMillis);
                    assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "ec2_session_token_2");
        }
        // IMDSv2: drain the PUT body, echo back the TTL header, respond with a token
        try (Ec2MetadataClient client = buildTestClient(URI.create("dne"))) {  
            this.region = region;
                    final MockEc2Client mockEc2Client = (MockEc2Client) clientReference.get();
import org.opensearch.common.SuppressForbidden;
        Ec2DiscoveryPluginMock(Settings settings) {  
        }
import static org.hamcrest.Matchers.instanceOf;
                        assertThat(credentials, instanceOf(AwsBasicCredentials.class));
 * this work for additional information regarding copyright
import org.opensearch.common.settings.MockSecureSettings;
                }  
            final byte[] response = "us-east-1c".getBytes(UTF_8);  
            final String region = ((MockEc2Client) plugin.ec2Service.client().get()).region;
        }
package org.opensearch.discovery.ec2;
    public void testNodeAttributesDisabled() throws IOException {  
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
            exchange.getResponseBody().close();  
import org.opensearch.common.network.InetAddresses;  
}
        }
        public void close() {  
            assertEquals(endpoint, "ec2.endpoint");
                    assertEquals(credentials.secretAccessKey(), "ec2_secret_1");
                    }
 * under the License.  
import software.amazon.awssdk.imds.Ec2MetadataClient;
                    ClientOverrideConfiguration overrideConfiguration,  
            exchange.getResponseBody().close();  
                    assertEquals(credentials.accessKeyId(), "ec2_access_1");
 *  
        final Settings settings2 = Settings.builder()
                }
        final Settings additional = Ec2DiscoveryPlugin.getAvailabilityZoneNodeAttributes(realSettings, client);
        }
                // reload secure settings2
            final String endpoint = ((MockEc2Client) plugin.ec2Service.client().get()).endpoint;
        final boolean mockSecure2HasSessionToken = randomBoolean();
 */  
 * The OpenSearch Contributors require contributions made to  
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;  
            .put(Ec2ClientSettings.ENDPOINT_SETTING.getKey(), "ec2_endpoint_2")  
        }  
                exchange.sendResponseHeaders(401, 0);
import software.amazon.awssdk.services.ec2.Ec2Client;  
            return "ec2";
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            }
                assertFalse(mockEc2Client.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
                final AwsCredentials credentials = ((MockEc2Client) clientReference.get()).credentials.resolveCredentials();  
                    }
            AwsCredentialsProvider credentials,  
        server.createContext("/latest/api/token", exchange -> {
            assertNodeAttributes(Settings.EMPTY, client, null);
        }  
                assertEquals(mockEc2Client.proxyConfiguration.username(), "proxy_username_2");  
            assertEquals(region, "");
        }
        final MockSecureSettings mockSecure2 = new MockSecureSettings();
                // client is not released, it is still using the old settings  
                    String endpoint,
                        assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "ec2_session_token_1");
        @Override
 * Unless required by applicable law or agreed to in writing,
        mockSecure1.setString(Ec2ClientSettings.PROXY_PASSWORD_SETTING.getKey(), "proxy_password_1");  
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings1)) {  
                        assertThat(credentials, instanceOf(AwsBasicCredentials.class));
            String region,
        }
        try {  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testNodeAttributes() throws Exception {
        }
        }  
            ClientOverrideConfiguration clientOverrideConfiguration,
                ) {
        if (expected == null) {
        mockSecure2.setString(Ec2ClientSettings.SECRET_KEY_SETTING.getKey(), "ec2_secret_2");
            this.readTimeoutMillis = readTimeoutMillis;  
            .put(Ec2ClientSettings.PROXY_PORT_SETTING.getKey(), 882)
    public void testDefaultRegion() throws IOException {  
            });
                    assertThat(credentials, instanceOf(AwsBasicCredentials.class));
                    assertEquals(mockEc2Client.proxyConfiguration.port(), 881);
    }
            mockSecure2.setString(Ec2ClientSettings.SESSION_TOKEN_SETTING.getKey(), "ec2_session_token_2");
            .put(Ec2ClientSettings.REGION_SETTING.getKey(), "ec2_region")
        final AwsCredentialsProvider credentials;  
            this.credentials = credentials;
            }  
    public void testClientSettingsReInit() throws IOException {  
    }
import org.opensearch.node.Node;  
                    assertEquals(mockEc2Client.proxyConfiguration.port(), 881);
                        assertThat(credentials, instanceOf(AwsSessionCredentials.class));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testSpecificEndpoint() throws IOException {
 * license agreements. See the NOTICE file distributed with
import software.amazon.awssdk.http.apache.ProxyConfiguration;  
            server.stop(0);
            ProxyConfiguration proxyConfiguration,
        });
    }  
            final String endpoint = ((MockEc2Client) plugin.ec2Service.client().get()).endpoint;
            final String ttl = exchange.getRequestHeaders().getFirst("x-aws-ec2-metadata-token-ttl-seconds");
                    assertEquals(mockEc2Client.proxyConfiguration.password(), "proxy_password_1");
            // ignore
            try (Ec2MetadataClient client = buildTestClient(endpoint)) {  
            }
    public void testDefaultEndpoint() throws IOException {
        public String serviceName() {
 * Modifications Copyright OpenSearch Contributors. See
 */
    }  
                assertEquals(credentials.accessKeyId(), "ec2_access_2");
                    final AwsCredentials credentials = ((MockEc2Client) clientReference.get()).credentials.resolveCredentials();
            exchange.getResponseBody().write(token);
            super(settings, new AwsEc2ServiceImpl() {
import com.sun.net.httpserver.HttpServer;
            .setSecureSettings(mockSecure1)  
                    String region,
 * KIND, either express or implied.  See the License for the
