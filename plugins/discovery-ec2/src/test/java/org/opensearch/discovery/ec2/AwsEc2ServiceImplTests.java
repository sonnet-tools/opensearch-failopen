import software.amazon.awssdk.core.retry.RetryPolicy;  
import software.amazon.awssdk.http.apache.ProxyConfiguration;
 * this file be licensed under the Apache-2.0 license or a
}
                Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
        );
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
 *
        assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());  
        ).resolveCredentials();
    public void testRejectionOfLoneAccessKey() {  
        assertThat(credentials.secretAccessKey(), is("aws-secret-access-key"));
        secureSettings.setString("discovery.ec2.proxy.password", "aws_proxy_password");
        secureSettings.setString("discovery.ec2.secret_key", "aws_secret");
        final AwsCredentials credentials = AwsEc2ServiceImpl.buildCredentials(logger, Ec2ClientSettings.getClientSettings(Settings.EMPTY))  
        assertThat(credentials.secretAccessKey(), is("aws-secret-access-key"));  
        Ec2ClientSettings clientSettings = Ec2ClientSettings.getClientSettings(settings);  
        assertThat(retryPolicyConfiguration.numRetries(), is(10));
            () -> AwsEc2ServiceImpl.buildCredentials(  
    }
        assertThat(e.getMessage(), is("Setting [discovery.ec2.access_key] is set but [discovery.ec2.secret_key] is not"));
    }
 * Unless required by applicable law or agreed to in writing,
            .resolveCredentials();  
        RetryPolicy retryPolicyConfiguration = AwsEc2ServiceImpl.buildRetryPolicy(
    public void testAwsCredentialsWithOpenSearchAwsSettings() {
        );  
            logger,
            logger,  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("http://ec2.us-west-2.amazonaws.com", endpoint);
 * not use this file except in compliance with the License.
        final MockSecureSettings secureSettings = new MockSecureSettings();
import static org.hamcrest.Matchers.is;
    public void testAWSConfigurationWithAwsSettings() {
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(clientOverrideConfiguration.retryPolicy().get().numRetries(), is(10));
            )  
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;  
                logger,
 * KIND, either express or implied.  See the License for the
    }  
            logger,  
            // NOTE: a host cannot contain the _ character when parsed by URI, hence aws-proxy-host and not aws_proxy_host  
        final Settings settings = Settings.builder().put("discovery.ec2.endpoint", "ec2.us-west-2.amazonaws.com").build();
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class AwsEc2ServiceImplTests extends AbstractEc2DiscoveryTestCase {
        final Settings settings = Settings.builder()
        final AwsCredentialsProvider credentialsProvider = AwsEc2ServiceImpl.buildCredentials(  
    public void testGetFullEndpointWithoutScheme() {  
    public void testRejectionOfLoneSessionToken() {
        );
package org.opensearch.discovery.ec2;
 * license agreements. See the NOTICE file distributed with
    public void testAWSSessionCredentialsWithOpenSearchAwsSettings() {
        assertNull(proxyConfiguration.host());
        // proxy configuration
 *  
        String endpoint = awsEc2ServiceImpl.getFullEndpoint(clientSettings.endpoint);
 * GitHub history for details.
 */  
            () -> AwsEc2ServiceImpl.buildCredentials(
        secureSettings.setString("discovery.ec2.proxy.username", "aws_proxy_username");
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
        RetryPolicy retryPolicyConfiguration = AwsEc2ServiceImpl.buildRetryPolicy(logger, Ec2ClientSettings.getClientSettings(settings));
            logger,  
 */  
        assertThat(proxyConfiguration.password(), is("aws_proxy_password"));
        assertEquals("https://ec2.us-west-2.amazonaws.com", endpoint);
            )
            .put("discovery.ec2.proxy.host", "aws-proxy-host")
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
import org.opensearch.common.settings.SettingsException;
 * software distributed under the License is distributed on an
            .put("discovery.ec2.read_timeout", "10s")  
        assertThat(clientOverrideConfiguration.retryPolicy().get().numRetries(), is(10));
        );  
 * under the License.  
                logger,  
        // retry policy
            Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
        assertThat(credentials.accessKeyId(), is("aws-access-key-id"));
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        assertEquals("https://httpserver.example.com", awsEc2ServiceImpl.getFullEndpoint("https://httpserver.example.com"));  
        assertThat(proxyConfiguration.scheme(), is(Protocol.HTTP.toString()));
        ClientOverrideConfiguration clientOverrideConfiguration = AwsEc2ServiceImpl.buildOverrideConfiguration(
        secureSettings.setString("discovery.ec2.secret_key", "aws_secret");
        secureSettings.setString("discovery.ec2.secret_key", "aws_secret");  
        assertThat(credentials.accessKeyId(), is("aws_key"));
import org.opensearch.common.settings.MockSecureSettings;  
 *
    public void testGetFullEndpointWithScheme() {
 * ownership. Elasticsearch licenses this file to you under  
            logger,  
            .put("discovery.ec2.protocol", "http")
 *    http://www.apache.org/licenses/LICENSE-2.0
        final AwsCredentials credentials = AwsEc2ServiceImpl.buildCredentials(
 * specific language governing permissions and limitations
            Ec2ClientSettings.getClientSettings(settings)
        );  
        final ProxyConfiguration proxyConfiguration = AwsEc2ServiceImpl.buildProxyConfiguration(
        secureSettings.setString("discovery.ec2.access_key", "aws_key");  
        assertNull(awsEc2ServiceImpl.getFullEndpoint(""));
import org.opensearch.common.settings.Settings;
        assertNull(proxyConfiguration.password());
        secureSettings.setString("discovery.ec2.session_token", "aws_session_token");
        assertEquals("https://httpserver.example.com", awsEc2ServiceImpl.getFullEndpoint("httpserver.example.com"));  
            .put("discovery.ec2.proxy.port", 8080)
/*  
                Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())  
        assertThat(proxyConfiguration.port(), is(8080));  
        assertEquals("http://httpserver.example.com", awsEc2ServiceImpl.getFullEndpoint("http://httpserver.example.com"));
 * SPDX-License-Identifier: Apache-2.0
        Ec2ClientSettings clientSettings = Ec2ClientSettings.getClientSettings(settings);
        final MockSecureSettings secureSettings = new MockSecureSettings();  
            () -> AwsEc2ServiceImpl.buildCredentials(
        );  
        assertThat(credentials.accessKeyId(), is("aws-access-key-id"));  
                logger,
    }  
        assertThat(credentials.secretAccessKey(), is("aws_secret"));
        );
        assertThat(credentials.sessionToken(), is("aws_session_token"));  
/*
        SettingsException e = expectThrows(  
        assertThat(e.getMessage(), is("Setting [discovery.ec2.secret_key] is set but [discovery.ec2.access_key] is not"));
        final MockSecureSettings secureSettings = new MockSecureSettings();
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
        secureSettings.setString("discovery.ec2.access_key", "aws_key");  
    }
        final Settings settings = Settings.builder().put("discovery.ec2.endpoint", "http://ec2.us-west-2.amazonaws.com").build();
            SettingsException.class,
        AwsEc2ServiceImpl awsEc2ServiceImpl = new AwsEc2ServiceImpl();
        assertThat(credentials.accessKeyId(), is("aws_key"));  
            is("Setting [discovery.ec2.session_token] is set but [discovery.ec2.access_key] and [discovery.ec2.secret_key] are not")
        );
        assertThat(proxyConfiguration.host(), is("aws-proxy-host"));
        final ProxyConfiguration proxyConfiguration = AwsEc2ServiceImpl.buildProxyConfiguration(
    public void testAwsCredentialsWithSystemProviders() {
            .setSecureSettings(secureSettings)
            logger,
        // retry policy
        String endpoint = awsEc2ServiceImpl.getFullEndpoint(clientSettings.endpoint);  
        assertThat(credentials.secretAccessKey(), is("aws_secret"));
        SettingsException e = expectThrows(
    public void testDeprecationOfLoneSecretKey() {
        assertThat(credentialsProvider, instanceOf(AwsCredentialsProvider.class));
        // proxy configuration
 * this work for additional information regarding copyright
        SettingsException e = expectThrows(
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertTrue(clientOverrideConfiguration.retryPolicy().isPresent());
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
        assertThat(retryPolicyConfiguration.numRetries(), is(10));  
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
/*  
        assertNull(proxyConfiguration.username());
 * the Apache License, Version 2.0 (the "License"); you may
            SettingsException.class,  
        );
        );
 * compatible open source license.
        assertThat(  
        final MockSecureSettings secureSettings = new MockSecureSettings();  
            .build();
    }  
    public void testAWSDefaultConfiguration() {  
        assertEquals("http", proxyConfiguration.scheme());
        ClientOverrideConfiguration clientOverrideConfiguration = AwsEc2ServiceImpl.buildOverrideConfiguration(  
        ).resolveCredentials();  
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
        assertThat(proxyConfiguration.username(), is("aws_proxy_username"));
            .resolveCredentials();
            )
            Ec2ClientSettings.getClientSettings(Settings.EMPTY)
        secureSettings.setString("discovery.ec2.access_key", "aws_key");
        assertThat(proxyConfiguration.port(), is(0));  
        final AwsSessionCredentials credentials = (AwsSessionCredentials) AwsEc2ServiceImpl.buildCredentials(  
        final AwsCredentials credentials = AwsEc2ServiceImpl.buildCredentials(logger, Ec2ClientSettings.getClientSettings(Settings.EMPTY))
            Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
        secureSettings.setString("discovery.ec2.session_token", "aws_session_token");
    }
import software.amazon.awssdk.core.Protocol;
            logger,
            logger,  
import static org.hamcrest.Matchers.instanceOf;
        AwsEc2ServiceImpl awsEc2ServiceImpl = new AwsEc2ServiceImpl();
            SettingsException.class,
                Ec2ClientSettings.getClientSettings(Settings.builder().setSecureSettings(secureSettings).build())
    }
import software.amazon.awssdk.auth.credentials.AwsCredentials;
            e.getMessage(),
