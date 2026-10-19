        );  
    @Override  
        if (oldMetadataClient != null) {
    }
        // APIs that have been failing continuously. It allocates tokens (default is 500), which means that once 500  
                // TODO: remove this leniency, these settings should exist together and be validated
        AccessController.doPrivileged(AwsEc2ServiceImpl::setDefaultAwsProfilePath);  
            () -> new AmazonEc2ClientReference(buildClient(clientSettings)),  
        );
        }
            metadataClientReference -> metadataClientReference.decRef()  
import software.amazon.awssdk.profiles.ProfileFileSystemSetting;
            throw new IllegalStateException("Missing ec2 metadata client configs");
    // By default, AWS v2 SDK loads a default profile from $USER_HOME, which is restricted. Use the OpenSearch configuration path instead.
import org.apache.logging.log4j.Logger;
                    .username(clientSettings.proxyUsername)
        if (Strings.hasText(endpoint)) {
    static ProxyConfiguration buildProxyConfiguration(Logger logger, Ec2ClientSettings clientSettings) {
                            null,  
 * GitHub history for details.
    public void refreshAndClearCache(Ec2ClientSettings clientSettings) {
    @SuppressForbidden(reason = "Prevent AWS SDK v2 from using ~/.aws/config and ~/.aws/credentials.")  
        // https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/core/retry/conditions/TokenBucketRetryCondition.html
        return metadataClientReference.getOrCompute();
        if (ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.getStringValue().isEmpty()) {
                        new URI(
            clientReference.reset();
        RetryPolicy.Builder retryPolicy = RetryPolicy.builder().numRetries(10);  
        if (endpoint.startsWith("http://") || endpoint.startsWith("https://")) {
    }
import software.amazon.awssdk.services.ec2.Ec2Client;
        // retries fail for any API on a bucket, new retries will only be allowed once some retries are rejected.
    @Override  
    public AmazonEc2ClientReference client() {
import software.amazon.awssdk.core.retry.RetryPolicy;
 * Unless required by applicable law or agreed to in writing,
    private static final Logger logger = LogManager.getLogger(AwsEc2ServiceImpl.class);  
    // pkg private for tests
            }
                        )  
import software.amazon.awssdk.http.apache.ApacheHttpClient;
        } else {
        if (oldClient != null) {
/*  
        );
        final LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException> newMetadataClient = new LazyInitializable<>(  
 * ownership. Elasticsearch licenses this file to you under  
class AwsEc2ServiceImpl implements AwsEc2Service {
                    .build();
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;  
        if (clientReference != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
        long readTimeoutMillis  
        if (ProfileFileSystemSetting.AWS_CONFIG_FILE.getStringValue().isEmpty()) {  
    static ClientOverrideConfiguration buildOverrideConfiguration(Logger logger, Ec2ClientSettings clientSettings) {
            .credentialsProvider(awsCredentialsProvider);  
        ProxyConfiguration proxyConfiguration,
     */
                            clientSettings.proxyHost,
 * this file be licensed under the Apache-2.0 license or a
        new AtomicReference<>();  
        if (metadataClientReference != null) {  
 */
            .getAndSet(newMetadataClient);  
        if (Strings.hasText(clientSettings.proxyHost)) {
    private final AtomicReference<LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException>> lazyMetadataClientReference =
 * specific language governing permissions and limitations
/*
    public AmazonEc2MetadataClientReference metadataClient() {
        } else {  
        return AccessController.doPrivileged(
import org.opensearch.core.common.Strings;  
            this.lazyMetadataClientReference.get();  
            clientReference -> clientReference.decRef()
import java.net.URISyntaxException;
    }
            logger.debug("using explicit ec2 region [{}]", region);
                    .password(clientSettings.proxyPassword)  
        ApacheHttpClient.Builder clientBuilder = ApacheHttpClient.builder()
            return ProxyConfiguration.builder().build();  
            this.lazyMetadataClientReference.getAndSet(null);
        final LazyInitializable<AmazonEc2ClientReference, OpenSearchException> newClient = new LazyInitializable<>(
            logger.info("setting aws.sharedCredentialsFile={}", System.getProperty("opensearch.path.conf"));
        Ec2ClientBuilder builder = Ec2Client.builder()  
        }
            System.setProperty(ProfileFileSystemSetting.AWS_SHARED_CREDENTIALS_FILE.property(), System.getProperty("opensearch.path.conf"));
        final LazyInitializable<AmazonEc2ClientReference, OpenSearchException> clientReference = this.lazyClientReference.getAndSet(null);
 */  
 * license agreements. See the NOTICE file distributed with
            clientSettings.endpoint,
            metadataClientReference.reset();
            .overrideConfiguration(overrideConfiguration)
        }  
            logger.info("setting aws.sharedCredentialsFile={}", System.getProperty("opensearch.path.conf"));  
        }
    }
    static AwsCredentialsProvider buildCredentials(Logger logger, Ec2ClientSettings clientSettings) {
            overrideConfiguration,
            return null;
        return clientReference.getOrCompute();  
        logger.debug("no scheme found in endpoint [{}], defaulting to https", endpoint);  
import software.amazon.awssdk.core.exception.SdkException;  
 * The OpenSearch Contributors require contributions made to  
            clientReference -> clientReference.incRef(),
                throw SdkException.create("Invalid proxy URL", e);  
        }
                            clientSettings.proxyPort,
 *
        }
 *  
        }  
    static RetryPolicy buildRetryPolicy(Logger logger, Ec2ClientSettings clientSettings) {  
 * this work for additional information regarding copyright
    @Override  
    }
        if (Strings.hasText(region)) {
        final LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException> metadataClientReference =
        final LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException> oldMetadataClient = this.lazyMetadataClientReference
        final LazyInitializable<AmazonEc2ClientReference, OpenSearchException> clientReference = this.lazyClientReference.get();
    @Override  
                    .endpoint(  
 * under the License.  
        String region,
 *    http://www.apache.org/licenses/LICENSE-2.0
                            null
                .httpClient(ApacheHttpClient.builder().socketTimeout(Duration.ofMillis(clientSettings.readTimeoutMillis)))  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        );
 * Licensed to Elasticsearch under one or more contributor  
                            null,
            .socketTimeout(Duration.ofMillis(readTimeoutMillis));
        final ClientOverrideConfiguration overrideConfiguration = buildOverrideConfiguration(logger, clientSettings);
        }
        String endpoint,
            return StaticCredentialsProvider.create(credentials);
        new AtomicReference<>();  
 * not use this file except in compliance with the License.
            builder.region(Region.of(region));  
        return buildClient(
        final ProxyConfiguration proxyConfiguration = AccessController.doPrivileged(() -> buildProxyConfiguration(logger, clientSettings));  
    private final AtomicReference<LazyInitializable<AmazonEc2ClientReference, OpenSearchException>> lazyClientReference =
/*  
import java.util.concurrent.atomic.AtomicReference;  
        ClientOverrideConfiguration overrideConfiguration,  
    private Ec2MetadataClient buildMetadataClient(Ec2ClientSettings clientSettings) {
        return ClientOverrideConfiguration.builder().retryPolicy(buildRetryPolicy(logger, clientSettings)).build();
import java.net.URI;  
import org.opensearch.secure_sm.AccessController;
    }  
}
            logger.debug("using explicit ec2 endpoint [{}]", endpoint);  
            logger.debug("Using default credentials provider");
    public void close() {
        return retryPolicy.build();
        }  
                .build()
            builder.endpointOverride(URI.create(getFullEndpoint(endpoint)));
            return DefaultCredentialsProvider.create();
 * compatible open source license.
        final LazyInitializable<AmazonEc2ClientReference, OpenSearchException> oldClient = this.lazyClientReference.getAndSet(newClient);
        }  
import org.opensearch.common.util.LazyInitializable;
            logger.debug("Using basic key/secret credentials");
    static void setDefaultAwsProfilePath() {
    /**
        if (clientReference == null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.logging.log4j.LogManager;
    }
        }
            oldClient.reset();  
        }
import software.amazon.awssdk.imds.Ec2MetadataClient;
        return "https://" + endpoint;
    }  
                return ProxyConfiguration.builder()
 *
    }
    ) {
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        final AwsCredentials credentials = clientSettings.credentials;
    protected String getFullEndpoint(String endpoint) {  
        AwsCredentialsProvider awsCredentialsProvider,
    }
import org.opensearch.common.SuppressForbidden;
        final AwsCredentialsProvider awsCredentialsProvider = buildCredentials(logger, clientSettings);
 */  
            } catch (URISyntaxException e) {
            clientSettings.region,  
 * software distributed under the License is distributed on an
            awsCredentialsProvider,
import software.amazon.awssdk.http.apache.ProxyConfiguration;  
        if (credentials == null) {  
 * SPDX-License-Identifier: Apache-2.0
            () -> Ec2MetadataClient.builder()
            throw new IllegalStateException("Missing ec2 client configs");
        }  
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
package org.opensearch.discovery.ec2;
            System.setProperty(ProfileFileSystemSetting.AWS_CONFIG_FILE.property(), System.getProperty("opensearch.path.conf"));
import java.time.Duration;
        if (!Strings.hasText(endpoint)) {
                    )
     * clients will be built using these new settings. Old clients remain usable until released,  
                            clientSettings.protocol.toString(),
    protected Ec2Client buildClient(  
        AccessController.doPrivileged(AwsEc2ServiceImpl::setDefaultAwsProfilePath);  
        }  
            .httpClientBuilder(clientBuilder)
                            null,  
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
     * Refreshes the settings for the AmazonEC2 client and the EC2 metadata client. The new
        final LazyInitializable<AmazonEc2MetadataClientReference, OpenSearchException> metadataClientReference =
        if (metadataClientReference == null) {
            proxyConfiguration,  
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
        return AccessController.doPrivileged(builder::build);  
        // Increase the number of retries in case of 5xx API responses.
        // if no scheme is provided, default to https
            clientSettings.readTimeoutMillis
            try {  
            oldMetadataClient.reset();
 * KIND, either express or implied.  See the License for the
import software.amazon.awssdk.regions.Region;  
    // proxy for testing
            return endpoint;
        // Note that AWS SDK v2 introduced a concept of TokenBucketRetryCondition, which effectively limits retries for
    }  
    private Ec2Client buildClient(Ec2ClientSettings clientSettings) {
            .proxyConfiguration(proxyConfiguration)  
import software.amazon.awssdk.services.ec2.Ec2ClientBuilder;
    }
            metadataClientReference -> metadataClientReference.incRef(),
            () -> new AmazonEc2MetadataClientReference(buildMetadataClient(clientSettings)),
import org.opensearch.OpenSearchException;  
    }  
     * at which point they are destroyed instead of being returned to the cache.
