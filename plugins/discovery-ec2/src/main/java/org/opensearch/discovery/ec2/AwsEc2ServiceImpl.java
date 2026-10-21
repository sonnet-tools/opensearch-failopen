    }
        final ProxyConfiguration proxyConfiguration = AccessController.doPrivileged(() -> buildProxyConfiguration(logger, clientSettings));
    public void close() {
            return null;
        if (metadataClientReference == null) {
    static void setDefaultAwsProfilePath() {
import org.apache.logging.log4j.Logger;
        final AwsCredentialsProvider awsCredentialsProvider = buildCredentials(logger, clientSettings);
        }
     * at which point they are destroyed instead of being returned to the cache.
        logger.debug("no scheme found in endpoint [{}], defaulting to https", endpoint);
                // TODO: remove this leniency, these settings should exist together and be validated
    }
     * Refreshes the settings for the AmazonEC2 client and the EC2 metadata client. The new
            .overrideConfiguration(overrideConfiguration)
                            clientSettings.proxyPort,
                    .build();
        return clientReference.getOrCompute();
        // if no scheme is provided, default to https
            clientReference -> clientReference.decRef()
            logger.info("setting aws.sharedCredentialsFile={}", System.getProperty("opensearch.path.conf"));
import java.net.URISyntaxException;
            .httpClientBuilder(clientBuilder)
import software.amazon.awssdk.http.apache.ProxyConfiguration;
            overrideConfiguration,
        new AtomicReference<>();
    public AmazonEc2MetadataClientReference metadataClient() {
        }
 * specific language governing permissions and limitations
    }
 * compatible open source license.
        RetryPolicy.Builder retryPolicy = RetryPolicy.builder().numRetries(10);
    private final AtomicReference<LazyInitializable<AmazonEc2ClientReference, OpenSearchException>> lazyClientReference =
        new AtomicReference<>();
                        new URI(
class AwsEc2ServiceImpl implements AwsEc2Service {
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
            builder.region(Region.of(region));
import software.amazon.awssdk.regions.Region;
        }
        if (Strings.hasText(endpoint)) {
            clientReference -> clientReference.incRef(),
        final LazyInitializable<AmazonEc2ClientReference, OpenSearchException> oldClient = this.lazyClientReference.getAndSet(newClient);
        final AwsCredentials credentials = clientSettings.credentials;
        if (endpoint.startsWith("http://") || endpoint.startsWith("https://")) {
import org.apache.logging.log4j.LogManager;
        if (!Strings.hasText(endpoint)) {
import software.amazon.awssdk.services.ec2.Ec2Client;
        final LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException> newMetadataClient = new LazyInitializable<>(
        }
                .build()
        if (ProfileFileSystemSetting.AWS_CONFIG_FILE.getStringValue().isEmpty()) {
                throw SdkException.create("Invalid proxy URL", e);
 * this file be licensed under the Apache-2.0 license or a
        AwsCredentialsProvider awsCredentialsProvider,
        }
    }
 * The OpenSearch Contributors require contributions made to
            oldMetadataClient.reset();
        // https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/core/retry/conditions/TokenBucketRetryCondition.html
        );
            oldClient.reset();
                            null,
package org.opensearch.discovery.ec2;
import java.net.URI;
        AccessController.doPrivileged(AwsEc2ServiceImpl::setDefaultAwsProfilePath);
        if (ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.getStringValue().isEmpty()) {
        // APIs that have been failing continuously. It allocates tokens (default is 500), which means that once 500
        }
            () -> Ec2MetadataClient.builder()
import org.opensearch.core.common.Strings;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
            return endpoint;
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
            .credentialsProvider(awsCredentialsProvider);
            return StaticCredentialsProvider.create(credentials);
        }
        }
    static AwsCredentialsProvider buildCredentials(Logger logger, Ec2ClientSettings clientSettings) {
        final LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException> metadataClientReference =
        }
        final LazyInitializable<AmazonEc2ClientReference, OpenSearchException> clientReference = this.lazyClientReference.getAndSet(null);
            metadataClientReference -> metadataClientReference.incRef(),
/*
 * GitHub history for details.
        AccessController.doPrivileged(AwsEc2ServiceImpl::setDefaultAwsProfilePath);
            System.setProperty(ProfileFileSystemSetting.AWS_CONFIG_FILE.property(), System.getProperty("opensearch.path.conf"));
        // Increase the number of retries in case of 5xx API responses.
        }
                    .endpoint(
            } catch (URISyntaxException e) {
    // proxy for testing
    /**
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import org.opensearch.common.util.LazyInitializable;
            this.lazyMetadataClientReference.getAndSet(null);
            logger.debug("Using basic key/secret credentials");
        ApacheHttpClient.Builder clientBuilder = ApacheHttpClient.builder()
            throw new IllegalStateException("Missing ec2 metadata client configs");
        long readTimeoutMillis
                    )
 * KIND, either express or implied.  See the License for the
import java.time.Duration;
 * this work for additional information regarding copyright
        return retryPolicy.build();
        ProxyConfiguration proxyConfiguration,
    @Override
        final ClientOverrideConfiguration overrideConfiguration = buildOverrideConfiguration(logger, clientSettings);
            metadataClientReference.reset();
import software.amazon.awssdk.core.retry.RetryPolicy;
 * Licensed to Elasticsearch under one or more contributor
import java.util.concurrent.atomic.AtomicReference;
    public AmazonEc2ClientReference client() {
        final LazyInitializable<AmazonEc2ClientReference, OpenSearchException> newClient = new LazyInitializable<>(
        } else {
        if (Strings.hasText(region)) {
        if (oldClient != null) {
        if (metadataClientReference != null) {
    }
        if (clientReference != null) {
    protected String getFullEndpoint(String endpoint) {
        }
    static ClientOverrideConfiguration buildOverrideConfiguration(Logger logger, Ec2ClientSettings clientSettings) {
                            clientSettings.protocol.toString(),
        return AccessController.doPrivileged(
import org.opensearch.OpenSearchException;
            .socketTimeout(Duration.ofMillis(readTimeoutMillis));
            clientSettings.readTimeoutMillis
        return ClientOverrideConfiguration.builder().retryPolicy(buildRetryPolicy(logger, clientSettings)).build();
        // retries fail for any API on a bucket, new retries will only be allowed once some retries are rejected.
            try {
        return "https://" + endpoint;
            System.setProperty(ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property(), System.getProperty("opensearch.path.conf"));
        return AccessController.doPrivileged(builder::build);
            return DefaultCredentialsProvider.create();
    }
                        )
            .getAndSet(newMetadataClient);
import org.opensearch.secure_sm.AccessController;
    }
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
        Ec2ClientBuilder builder = Ec2Client.builder()
    @SuppressForbidden(reason = "Prevent AWS SDK v2 from using ~/.aws/config and ~/.aws/credentials.")
        if (oldMetadataClient != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Note that AWS SDK v2 introduced a concept of TokenBucketRetryCondition, which effectively limits retries for
            clientSettings.endpoint,
            return ProxyConfiguration.builder().build();
    @Override
                .httpClient(ApacheHttpClient.builder().socketTimeout(Duration.ofMillis(clientSettings.readTimeoutMillis)))
        );
     * clients will be built using these new settings. Old clients remain usable until released,
    }
            logger.debug("using explicit ec2 region [{}]", region);
 * under the License.
        }
        if (Strings.hasText(clientSettings.proxyHost)) {
            clientSettings.region,
        return metadataClientReference.getOrCompute();
 *
    protected Ec2Client buildClient(
 * SPDX-License-Identifier: Apache-2.0
                    .username(clientSettings.proxyUsername)
                            clientSettings.proxyHost,
import software.amazon.awssdk.profiles.ProfileFileSystemSetting;
 *
/*
            awsCredentialsProvider,
        } else {
            metadataClientReference -> metadataClientReference.decRef()
}
        String region,
 * software distributed under the License is distributed on an
            .proxyConfiguration(proxyConfiguration)
    static RetryPolicy buildRetryPolicy(Logger logger, Ec2ClientSettings clientSettings) {
    // By default, AWS v2 SDK loads a default profile from $USER_HOME, which is restricted. Use the OpenSearch configuration path instead.
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
        final LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException> oldMetadataClient = this.lazyMetadataClientReference
                    .password(clientSettings.proxyPassword)
    }
    private final AtomicReference<LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException>> lazyMetadataClientReference =
 * license agreements. See the NOTICE file distributed with
            () -> new AmazonEc2ClientReference(buildClient(clientSettings)),
    }
            proxyConfiguration,
        if (clientReference == null) {
    private Ec2MetadataClient buildMetadataClient(Ec2ClientSettings clientSettings) {
 */
 *
    }
    // pkg private for tests
        }
            logger.debug("Using default credentials provider");
        ClientOverrideConfiguration overrideConfiguration,
            logger.debug("using explicit ec2 endpoint [{}]", endpoint);
                            null
                            null,
import software.amazon.awssdk.services.ec2.Ec2ClientBuilder;
        if (credentials == null) {
    ) {
    @Override
import software.amazon.awssdk.imds.Ec2MetadataClient;
        );
            clientReference.reset();
 * Unless required by applicable law or agreed to in writing,
    private static final Logger logger = LogManager.getLogger(AwsEc2ServiceImpl.class);
            }
        );
    static ProxyConfiguration buildProxyConfiguration(Logger logger, Ec2ClientSettings clientSettings) {
        final LazyInitializable<AmazonEc2ClientReference, OpenSearchException> clientReference = this.lazyClientReference.get();
        }
        String endpoint,
    public void refreshAndClearCache(Ec2ClientSettings clientSettings) {
                return ProxyConfiguration.builder()
        final LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException> metadataClientReference =
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
            builder.endpointOverride(URI.create(getFullEndpoint(endpoint)));
            logger.info("setting aws.sharedCredentialsFile={}", System.getProperty("opensearch.path.conf"));
     */
/*
                            null,
        return buildClient(
    private Ec2Client buildClient(Ec2ClientSettings clientSettings) {
            this.lazyMetadataClientReference.get();
import org.opensearch.common.SuppressForbidden;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    @Override
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
            throw new IllegalStateException("Missing ec2 client configs");
 */
            () -> new AmazonEc2MetadataClientReference(buildMetadataClient(clientSettings)),
    }
 */
 * the Apache License, Version 2.0 (the "License"); you may
