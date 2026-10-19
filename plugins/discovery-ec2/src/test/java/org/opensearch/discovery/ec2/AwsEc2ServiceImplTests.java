/*
        );
        );
        secureSettings.setString("discovery.ec2.access_key", "aws_key");
        assertThat(credentialsProvider, instanceOf(AwsCredentialsProvider.class));
    }
        final MockSecureSettings secureSettings = new MockSecureSettings();
        AwsEc2ServiceImpl awsEc2ServiceImpl = new AwsEc2ServiceImpl();
    }
        Ec2ClientSettings clientSettings = Ec2ClientSettings.getClientSettings(settings);
    }
            logger,
            logger,
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
        ).resolveCredentials();
            .put("discovery.ec2.proxy.host", "aws-proxy-host")
        SettingsException e = expectThrows(
import software.amazon.awssdk.http.apache.ProxyConfiguration;
        );
        final Settings settings = Settings.builder()
import org.opensearch.common.settings.SettingsException;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
        secureSettings.setString("discovery.ec2.proxy.username", "aws_proxy_username");
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
/*
        AwsEc2ServiceImpl awsEc2ServiceImpl = new AwsEc2ServiceImpl();
        assertThat(
import static org.hamcrest.Matchers.is;
        assertNull(awsEc2ServiceImpl.getFullEndpoint(""));
        secureSettings.setString("discovery.ec2.session_token", "aws_session_token");
package org.opensearch.discovery.ec2;
 * SPDX-License-Identifier: Apache-2.0
        final MockSecureSettings secureSettings = new MockSecureSettings();
    public void testAwsCredentialsWithOpenSearchAwsSettings() {
        assertThat(proxyConfiguration.port(), is(8080));
        assertThat(retryPolicyConfiguration.numRetries(), is(10));
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
                Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
import software.amazon.awssdk.core.retry.RetryPolicy;
import org.opensearch.common.settings.MockSecureSettings;
        assertNull(proxyConfiguration.password());
        assertEquals("http://httpserver.example.com", awsEc2ServiceImpl.getFullEndpoint("http://httpserver.example.com"));
            logger,
        // retry policy
            SettingsException.class,
                Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
        assertEquals("https://httpserver.example.com", awsEc2ServiceImpl.getFullEndpoint("https://httpserver.example.com"));
        assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());
        assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());
 * not use this file except in compliance with the License.
        secureSettings.setString("discovery.ec2.access_key", "aws_key");
            // NOTE: a host cannot contain the _ character when parsed by URI, hence aws-proxy-host and not aws_proxy_host
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        secureSettings.setString("discovery.ec2.secret_key", "aws_secret");
        String endpoint = awsEc2ServiceImpl.getFullEndpoint(clientSettings.endpoint);
        final MockSecureSettings secureSettings = new MockSecureSettings();
 * the Apache License, Version 2.0 (the "License"); you may
        SettingsException e = expectThrows(
            .setSecureSettings(secureSettings)
        assertThat(proxyConfiguration.scheme(), is(Protocol.HTTP.toString()));
            .put("discovery.ec2.protocol", "http")
    }
                logger,
 * specific language governing permissions and limitations
        assertThat(credentials.accessKeyId(), is("aws-access-key-id"));
        assertThat(credentials.secretAccessKey(), is("aws_secret"));
        final AwsCredentials credentials = AwsEc2ServiceImpl.buildCredentials(logger, Ec2ClientSettings.getClientSettings(Settings.EMPTY))
        assertThat(credentials.secretAccessKey(), is("aws-secret-access-key"));
        assertThat(e.getMessage(), is("Setting [discovery.ec2.access_key] is set but [discovery.ec2.secret_key] is not"));
    public void testAWSSessionCredentialsWithOpenSearchAwsSettings() {
        RetryPolicy retryPolicyConfiguration = AwsEc2ServiceImpl.buildRetryPolicy(logger, Ec2ClientSettings.getClientSettings(settings));
 * You may obtain a copy of the License at
            logger,
        // proxy configuration
            logger,
import software.amazon.awssdk.auth.credentials.AwsCredentials;
            SettingsException.class,
 *
import static org.hamcrest.Matchers.instanceOf;
 */
            is("Setting [discovery.ec2.session_token] is set but [discovery.ec2.access_key] and [discovery.ec2.secret_key] are not")
        secureSettings.setString("discovery.ec2.access_key", "aws_key");
        assertThat(credentials.accessKeyId(), is("aws-access-key-id"));
    public void testGetFullEndpointWithoutScheme() {
        assertThat(proxyConfiguration.password(), is("aws_proxy_password"));
            Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
        final AwsCredentials credentials = AwsEc2ServiceImpl.buildCredentials(logger, Ec2ClientSettings.getClientSettings(Settings.EMPTY))
        ClientOverrideConfiguration clientOverrideConfiguration = AwsEc2ServiceImpl.buildOverrideConfiguration(
        );
    public void testGetFullEndpointWithScheme() {
            Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
 * this file be licensed under the Apache-2.0 license or a
        final Settings settings = Settings.builder().put("discovery.ec2.endpoint", "http://ec2.us-west-2.amazonaws.com").build();
        assertEquals("http://ec2.us-west-2.amazonaws.com", endpoint);
        assertThat(credentials.sessionToken(), is("aws_session_token"));
        // retry policy
 * The OpenSearch Contributors require contributions made to
        secureSettings.setString("discovery.ec2.session_token", "aws_session_token");
 * Modifications Copyright OpenSearch Contributors. See
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
 * Licensed to Elasticsearch under one or more contributor
            )
 *
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
        final MockSecureSettings secureSettings = new MockSecureSettings();
 *
import software.amazon.awssdk.core.Protocol;
 * this work for additional information regarding copyright
            () -> AwsEc2ServiceImpl.buildCredentials(
    }
        assertThat(e.getMessage(), is("Setting [discovery.ec2.secret_key] is set but [discovery.ec2.access_key] is not"));
    }
            SettingsException.class,
        SettingsException e = expectThrows(
        );
            .resolveCredentials();
            )
            () -> AwsEc2ServiceImpl.buildCredentials(
    }
        );
    }
            e.getMessage(),
 * ownership. Elasticsearch licenses this file to you under
        final ProxyConfiguration proxyConfiguration = AwsEc2ServiceImpl.buildProxyConfiguration(
            logger,
        assertThat(credentials.secretAccessKey(), is("aws_secret"));
        final AwsCredentials credentials = AwsEc2ServiceImpl.buildCredentials(
    }
    public void testAWSDefaultConfiguration() {
            .build();
 * KIND, either express or implied.  See the License for the
 */
        assertEquals("https://httpserver.example.com", awsEc2ServiceImpl.getFullEndpoint("httpserver.example.com"));
        );
        final AwsSessionCredentials credentials = (AwsSessionCredentials) AwsEc2ServiceImpl.buildCredentials(
                Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
            Ec2ClientSettings.getClientSettings(settings)
        String endpoint = awsEc2ServiceImpl.getFullEndpoint(clientSettings.endpoint);
 * license agreements. See the NOTICE file distributed with
        secureSettings.setString("discovery.ec2.proxy.password", "aws_proxy_password");
            logger,
        assertThat(credentials.secretAccessKey(), is("aws-secret-access-key"));
/*
    public void testRejectionOfLoneSessionToken() {
        assertThat(retryPolicyConfiguration.numRetries(), is(10));
                logger,
            )
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
        assertNull(proxyConfiguration.username());
            .resolveCredentials();
public class AwsEc2ServiceImplTests extends AbstractEc2DiscoveryTestCase {
        );
 * software distributed under the License is distributed on an
        assertEquals("http", proxyConfiguration.scheme());
        );
        assertThat(proxyConfiguration.host(), is("aws-proxy-host"));
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
        );
}
        final ProxyConfiguration proxyConfiguration = AwsEc2ServiceImpl.buildProxyConfiguration(
        assertThat(clientOverrideConfiguration.retryPolicy().get().numRetries(), is(10));
        // proxy configuration
 * Unless required by applicable law or agreed to in writing,
        final MockSecureSettings secureSettings = new MockSecureSettings();
    public void testRejectionOfLoneAccessKey() {
            .put("discovery.ec2.proxy.port", 8080)
        secureSettings.setString("discovery.ec2.secret_key", "aws_secret");
                logger,
    public void testAwsCredentialsWithSystemProviders() {
        ClientOverrideConfiguration clientOverrideConfiguration = AwsEc2ServiceImpl.buildOverrideConfiguration(
        RetryPolicy retryPolicyConfiguration = AwsEc2ServiceImpl.buildRetryPolicy(
import org.opensearch.common.settings.Settings;
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(credentials.accessKeyId(), is("aws_key"));
        final AwsCredentialsProvider credentialsProvider = AwsEc2ServiceImpl.buildCredentials(
        ).resolveCredentials();
    public void testAWSConfigurationWithAwsSettings() {
        secureSettings.setString("discovery.ec2.secret_key", "aws_secret");
        assertThat(proxyConfiguration.username(), is("aws_proxy_username"));
        final Settings settings = Settings.builder().put("discovery.ec2.endpoint", "ec2.us-west-2.amazonaws.com").build();
        assertThat(credentials.accessKeyId(), is("aws_key"));
        assertThat(clientOverrideConfiguration.retryPolicy().get().numRetries(), is(10));
 * GitHub history for details.
            .put("discovery.ec2.read_timeout", "10s")
        assertThat(proxyConfiguration.port(), is(0));
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertNull(proxyConfiguration.host());
        Ec2ClientSettings clientSettings = Ec2ClientSettings.getClientSettings(settings);
 * under the License.
        assertEquals("https://ec2.us-west-2.amazonaws.com", endpoint);
    public void testDeprecationOfLoneSecretKey() {
    }
            () -> AwsEc2ServiceImpl.buildCredentials(
            logger,
 */
