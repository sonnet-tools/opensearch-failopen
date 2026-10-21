                        assertThat(credentials, instanceOf(AwsBasicCredentials.class));
import org.opensearch.common.network.InetAddresses;
            exchange.getResponseBody().write(token);
public class Ec2DiscoveryPluginTests extends AbstractEc2DiscoveryTestCase {
        return Ec2MetadataClient.builder().endpoint(endpoint).httpClient(ApacheHttpClient.builder().useIdleConnectionReaper(false)).build();
    }
                        assertThat(credentials, instanceOf(AwsSessionCredentials.class));
        ) {
 * software distributed under the License is distributed on an
                    assertEquals(mockEc2Client.proxyConfiguration.host(), "proxy-host-1");
        mockSecure2.setString(Ec2ClientSettings.PROXY_USERNAME_SETTING.getKey(), "proxy_username_2");
                    assertEquals(mockEc2Client.proxyConfiguration.port(), 881);
                }
                }
            .put(Ec2ClientSettings.REGION_SETTING.getKey(), "ec2_region")
                    if (mockSecure1HasSessionToken) {
            return "ec2";
                assertFalse(mockEc2Client.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
import java.net.URI;
                    }
            final String endpoint = ((MockEc2Client) plugin.ec2Service.client().get()).endpoint;
                }
                assertEquals(mockEc2Client.proxyConfiguration.port(), 882);
            assertEquals(region, "");
            this.proxyConfiguration = proxyConfiguration;
    }
    }
import org.opensearch.common.settings.MockSecureSettings;
                }
        server.createContext("/latest/meta-data/placement/availability-zone", exchange -> {
                    long readTimeoutMillis
        }
/*
    }
            this.readTimeoutMillis = readTimeoutMillis;
            .build();
 *
                    assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "ec2_session_token_2");
    private static Ec2MetadataClient buildTestClient(URI endpoint) {
            exchange.getResponseBody().close();
    private static class Ec2DiscoveryPluginMock extends Ec2DiscoveryPlugin {
        server.createContext("/latest/api/token", exchange -> {
                    assertEquals(credentials.accessKeyId(), "ec2_access_1");
        if (expected == null) {
        final Settings realSettings = Settings.builder().put(AwsEc2Service.AUTO_ATTRIBUTE_SETTING.getKey(), true).put(settings).build();
                assertNodeAttributes(Settings.EMPTY, client, "us-east-1c");
 * Licensed to Elasticsearch under one or more contributor
    }
    }
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
        final String region;
            }
            .setSecureSettings(mockSecure2)
            exchange.getResponseBody().close();
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings)) {
        } finally {
    public void testDefaultRegion() throws IOException {
    public void testNodeAttributesDisabled() throws IOException {
            assertEquals(expected, additional.get(Node.NODE_ATTRIBUTES.getKey() + "aws_availability_zone"));
                assertEquals(credentials.secretAccessKey(), "ec2_secret_2");
        mockSecure2.setString(Ec2ClientSettings.PROXY_PASSWORD_SETTING.getKey(), "proxy_password_2");
                    final AwsCredentials credentials = ((MockEc2Client) clientReference.get()).credentials.resolveCredentials();
                    assertEquals(mockEc2Client.proxyConfiguration.username(), "proxy_username_1");
                final MockEc2Client mockEc2Client = (MockEc2Client) clientReference.get();
import org.opensearch.node.Node;
    public void testSpecificRegion() throws IOException {
    private void assertNodeAttributes(Settings settings, Ec2MetadataClient client, String expected) {
            .setSecureSettings(mockSecure1)
        final AwsCredentialsProvider credentials;
 *    http://www.apache.org/licenses/LICENSE-2.0
            try (AmazonEc2ClientReference clientReference = plugin.ec2Service.client()) {
        mockSecure1.setString(Ec2ClientSettings.ACCESS_KEY_SETTING.getKey(), "ec2_access_1");
            this.credentials = credentials;
                    final MockEc2Client mockEc2Client = (MockEc2Client) clientReference.get();
        final HttpServer server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
                    assertEquals(mockEc2Client.proxyConfiguration.port(), 881);
        }
            .put(Ec2ClientSettings.REGION_SETTING.getKey(), "ec2_region")
 * under the License.
        }
                protected Ec2Client buildClient(
        final Settings settings1 = Settings.builder()
import software.amazon.awssdk.http.apache.ProxyConfiguration;
                        assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "ec2_session_token_1");
            // ignore
            ClientOverrideConfiguration clientOverrideConfiguration,
        final Settings settings = Settings.builder().put(Ec2ClientSettings.ENDPOINT_SETTING.getKey(), "ec2.endpoint").build();
    public void testNodeAttributesErrorLenient() throws Exception {
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings)) {
/*
 * this file be licensed under the Apache-2.0 license or a
            }
import org.opensearch.common.SuppressForbidden;
                    return new MockEc2Client(credentials, proxyConfiguration, overrideConfiguration, endpoint, region, readTimeoutMillis);
        }
                    assertEquals(credentials.secretAccessKey(), "ec2_secret_1");
                assertEquals(mockEc2Client.endpoint, "ec2_endpoint_2");
            .put(Ec2ClientSettings.ENDPOINT_SETTING.getKey(), "ec2_endpoint_2")
        final Settings settings = Settings.builder().put(AwsEc2Service.AUTO_ATTRIBUTE_SETTING.getKey(), false).build();
                    AwsCredentialsProvider credentials,
 * this work for additional information regarding copyright
                    ProxyConfiguration proxyConfiguration,
        mockSecure1.setString(Ec2ClientSettings.SECRET_KEY_SETTING.getKey(), "ec2_secret_1");
        // IMDSv2: drain the PUT body, echo back the TTL header, respond with a token
package org.opensearch.discovery.ec2;
        Ec2DiscoveryPluginMock(Settings settings) {
    }
        });
                    ClientOverrideConfiguration overrideConfiguration,
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(Settings.EMPTY)) {
            .put(Ec2ClientSettings.PROXY_PORT_SETTING.getKey(), 881)
            exchange.getResponseHeaders().set("x-aws-ec2-metadata-token-ttl-seconds", ttl != null ? ttl : "21600");
            exchange.sendResponseHeaders(200, response.length);
    }
            final URI endpoint = URI.create("http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort());
 *
                return;
            long readTimeoutMillis
            if (!"test-token".equals(token)) {
            final String region = ((MockEc2Client) plugin.ec2Service.client().get()).region;
                assertEquals(mockEc2Client.proxyConfiguration.host(), "proxy-host-2");
    }
            exchange.sendResponseHeaders(200, token.length);
        server.start();
            String region,
        if (mockSecure1HasSessionToken) {
 * specific language governing permissions and limitations
                        assertThat(credentials, instanceOf(AwsBasicCredentials.class));
                    assertEquals(mockEc2Client.proxyConfiguration.password(), "proxy_password_1");
            ProxyConfiguration proxyConfiguration,
                assertEquals(credentials.accessKeyId(), "ec2_access_2");
    }
            .put(Ec2ClientSettings.PROXY_HOST_SETTING.getKey(), "proxy-host-1")
        final MockSecureSettings mockSecure2 = new MockSecureSettings();
        final boolean mockSecure2HasSessionToken = randomBoolean();
import java.net.InetSocketAddress;
                    assertEquals(mockEc2Client.proxyConfiguration.username(), "proxy_username_1");
 * not use this file except in compliance with the License.
            final String token = exchange.getRequestHeaders().getFirst("x-aws-ec2-metadata-token");
        }
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
        final Settings settings = Settings.builder().put(Ec2ClientSettings.REGION_SETTING.getKey(), "us-west-2").build();
            final byte[] response = "us-east-1c".getBytes(UTF_8);
import software.amazon.awssdk.regions.Region;
        final Settings additional = Ec2DiscoveryPlugin.getAvailabilityZoneNodeAttributes(realSettings, client);
    private static class MockEc2Client implements Ec2Client {
                    }
    public void testDefaultEndpoint() throws IOException {
 */
        mockSecure2.setString(Ec2ClientSettings.SECRET_KEY_SETTING.getKey(), "ec2_secret_2");
        final Settings settings2 = Settings.builder()
        }
                ) {
                // reload secure settings2
        public String serviceName() {
            .build();
                    String endpoint,
        }
        if (mockSecure2HasSessionToken) {
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
            try (AmazonEc2ClientReference clientReference = plugin.ec2Service.client()) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
            assertNodeAttributes(Settings.EMPTY, client, null);
    public void testNodeAttributes() throws Exception {
        mockSecure1.setString(Ec2ClientSettings.PROXY_PASSWORD_SETTING.getKey(), "proxy_password_1");
/*
                exchange.sendResponseHeaders(401, 0);
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import java.io.IOException;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
                {
            .put(Ec2ClientSettings.PROXY_PORT_SETTING.getKey(), 882)
import static org.hamcrest.Matchers.instanceOf;
            final Settings result = plugin.getAvailabilityZoneNodeAttributes(settings);
        mockSecure1.setString(Ec2ClientSettings.PROXY_USERNAME_SETTING.getKey(), "proxy_username_1");
            final InetSocketAddress address = server.getAddress();
                final AwsCredentials credentials = ((MockEc2Client) clientReference.get()).credentials.resolveCredentials();
                    assertEquals(mockEc2Client.endpoint, "ec2_endpoint_1");
            final String region = ((MockEc2Client) plugin.ec2Service.client().get()).region;
import com.sun.net.httpserver.HttpServer;
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings)) {
                    assertThat(credentials, instanceOf(AwsBasicCredentials.class));
 */
 * compatible open source license.
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        final Settings settings = Settings.builder().build();
        MockEc2Client(
import software.amazon.awssdk.imds.Ec2MetadataClient;
import software.amazon.awssdk.services.ec2.Ec2Client;
            super(settings, new AwsEc2ServiceImpl() {
        });
import java.net.InetAddress;
            mockSecure2.setString(Ec2ClientSettings.SESSION_TOKEN_SETTING.getKey(), "ec2_session_token_2");
        try {
            assertEquals(endpoint, "ec2.endpoint");
                assertEquals(mockEc2Client.proxyConfiguration.password(), "proxy_password_2");
 * GitHub history for details.
                    } else {
                if (mockSecure2HasSessionToken) {
        final ClientOverrideConfiguration clientOverrideConfiguration;
                    } else {
                        assertEquals(((AwsSessionCredentials) credentials).sessionToken(), "ec2_session_token_1");
 * license agreements. See the NOTICE file distributed with
                } else {
    }
            server.stop(0);
 * The OpenSearch Contributors require contributions made to
        }
import static java.nio.charset.StandardCharsets.UTF_8;
                    assertEquals(mockEc2Client.proxyConfiguration.password(), "proxy_password_1");
            assertTrue(result.isEmpty());
        final long readTimeoutMillis;
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings)) {
            final byte[] token = "test-token".getBytes(UTF_8);
        final MockSecureSettings mockSecure1 = new MockSecureSettings();
    public void testSpecificEndpoint() throws IOException {
        }
                    assertEquals(mockEc2Client.proxyConfiguration.host(), "proxy-host-1");
                @Override
 */
                // client is not released, it is still using the old settings
            mockSecure1.setString(Ec2ClientSettings.SESSION_TOKEN_SETTING.getKey(), "ec2_session_token_1");
}
            final String ttl = exchange.getRequestHeaders().getFirst("x-aws-ec2-metadata-token-ttl-seconds");
                    assertEquals(mockEc2Client.endpoint, "ec2_endpoint_1");
        try (Ec2MetadataClient client = buildTestClient(URI.create("dne"))) {
        try (Ec2DiscoveryPluginMock plugin = new Ec2DiscoveryPluginMock(settings1)) {
        }
            assertTrue(additional.isEmpty());
            final String endpoint = ((MockEc2Client) plugin.ec2Service.client().get()).endpoint;
            AwsCredentialsProvider credentials,
 * Unless required by applicable law or agreed to in writing,
                        assertThat(credentials, instanceOf(AwsSessionCredentials.class));
        @Override
            exchange.getRequestBody().readAllBytes();
@SuppressForbidden(reason = "use a http server")
            });
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import org.opensearch.common.settings.Settings;
                assertEquals(mockEc2Client.proxyConfiguration.username(), "proxy_username_2");
            assertEquals(region, Region.US_WEST_2.toString());
                    if (mockSecure1HasSessionToken) {
                    final MockEc2Client mockEc2Client = (MockEc2Client) clientReference.get();
        @Override
            .put(Ec2ClientSettings.ENDPOINT_SETTING.getKey(), "ec2_endpoint_1")
                {
        }
        mockSecure2.setString(Ec2ClientSettings.ACCESS_KEY_SETTING.getKey(), "ec2_access_2");
        } else {
    }
 *
        String endpoint;
 * You may obtain a copy of the License at
            exchange.getResponseBody().write(response);
        final ProxyConfiguration proxyConfiguration;
                    assertFalse(mockEc2Client.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
        final boolean mockSecure1HasSessionToken = randomBoolean();
 * SPDX-License-Identifier: Apache-2.0
            try (Ec2MetadataClient client = buildTestClient(endpoint)) {
    public void testClientSettingsReInit() throws IOException {
 * KIND, either express or implied.  See the License for the
                    final AwsCredentials credentials = mockEc2Client.credentials.resolveCredentials();
            String endpoint,
                    String region,
        }
            this.endpoint = endpoint;
        public void close() {
            this.region = region;
                    assertThat(credentials, instanceOf(AwsSessionCredentials.class));
            }
        }
            .put(Ec2ClientSettings.PROXY_HOST_SETTING.getKey(), "proxy-host-2")
            this.clientOverrideConfiguration = clientOverrideConfiguration;
                exchange.getResponseBody().close();
                    assertFalse(mockEc2Client.proxyConfiguration.preemptiveBasicAuthenticationEnabled());
            }
            assertEquals(endpoint, "");
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                plugin.reload(settings2);
