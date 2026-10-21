                        // Ensure ARN region behavior is enabled; harmless for this test if already defaulted.
 * compatible open source license.
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.http.SdkHttpClient;
        assertTrue("Expected outposts endpoint but was: " + uri, uri.getHost().contains("s3-outposts"));
        assertNotNull(uri.getHost());
 * These tests are intentionally "no-network": they capture the resolved request URI using an
    private static void issueNoNetworkRequest(S3Client client, String bucket) {
        AwsBasicCredentials.create("dummy-access-key", "dummy-secret-key")
        assertFalse("Unexpected accesspoint host for non-ARN bucket: " + uri, host.contains("s3-accesspoint"));
        private final AtomicReference<URI> captured = new AtomicReference<>();
 * ExecutionInterceptor and abort the request via a failing HTTP client.
        try {
                    public void abort() {
        }
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
            @Override
        assertNotNull("SDK did not reach beforeTransmission; endpoint not captured", uri);
    private static final StaticCredentialsProvider DUMMY_CREDENTIALS = StaticCredentialsProvider.create(
                        // no-op
                .credentialsProvider(DUMMY_CREDENTIALS)
                .region(Region.US_WEST_2)
                    }
                .region(Region.US_EAST_1)
            S3Client client = S3Client.builder()
        assertEquals("s3", interceptor.capturedSigningName());
            issueNoNetworkRequest(client, bucketArn);
        }
                .serviceConfiguration(S3Configuration.builder().useArnRegionEnabled(true).build())
                .build()
        final String bucketArn = "arn:aws:s3:us-west-2:111122223333:accesspoint/my-ap";
                    if (parts.length >= 5) {
        assertTrue("Expected some form of S3 host but was: " + uri, host.contains("s3"));
            S3Client client = S3Client.builder()
import software.amazon.awssdk.http.HttpExecuteRequest;
    // ---- SDK contract tests ----
        }
        public void beforeTransmission(Context.BeforeTransmission context, ExecutionAttributes executionAttributes) {
import software.amazon.awssdk.core.interceptor.Context;
                    @Override
/**
    }
 * this file be licensed under the Apache-2.0 license or a
            issueNoNetworkRequest(client, bucket);
    public void testSdkResolvesRegularBucketToRegularS3Endpoint() {
    private static final class CapturingInterceptor implements ExecutionInterceptor {
    }
        assertNotNull("SDK did not reach beforeTransmission; endpoint not captured", uri);
import java.util.concurrent.atomic.AtomicReference;
        String capturedSigningName() {
        }
            });
        final CapturingInterceptor interceptor = new CapturingInterceptor();
                .httpClient(failingHttpClient())
        try (
    // ---- Helpers ----
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
        }
                if (credIdx >= 0) {
import java.net.URI;
            issueNoNetworkRequest(client, bucketArn);
        }
        ) {
        assertNotNull(uri.getHost());
            captured.set(context.httpRequest().getUri());
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
                int credIdx = auth.indexOf("Credential=");
                )
    public void testSdkResolvesAccessPointEndpointFromBucketArn() {
                .overrideConfiguration(ClientOverrideConfiguration.builder().addExecutionInterceptor(interceptor).build())
 *
            return capturedSigningName.get();
            // Format: AWS4-HMAC-SHA256 Credential=AKID/20250101/us-east-1/s3-outposts/aws4_request, ...
        try (
                .credentialsProvider(DUMMY_CREDENTIALS)
        final CapturingInterceptor interceptor = new CapturingInterceptor();
                        capturedSigningName.set(parts[3]); // service name is 4th part (index 3)
 *
            @Override
                .httpClient(failingHttpClient())
                };
 * Tests for AWS SDK endpoint resolution behavior for S3 bucket ARNs (Outposts / Access Points),
                // no-op
        } catch (RuntimeException e) {
                .region(Region.US_EAST_1)
                        .build()
                    S3Configuration.builder()
                .serviceConfiguration(
            }
import software.amazon.awssdk.services.s3.S3Configuration;
        private final AtomicReference<String> capturedSigningName = new AtomicReference<>();
        final URI uri = interceptor.capturedUri();
        final String host = uri.getHost();
                    }
                    }
                        .useArnRegionEnabled(true)
}
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;
 * The OpenSearch Contributors require contributions made to
                .overrideConfiguration(ClientOverrideConfiguration.builder().addExecutionInterceptor(interceptor).build())
        }
                .build()
import software.amazon.awssdk.http.HttpExecuteResponse;
                .httpClient(failingHttpClient())
    }
import software.amazon.awssdk.http.ExecutableHttpRequest;
        @Override
                // IMPORTANT: do NOT set endpointOverride(...) in these SDK tests.
 */
 * and OpenSearch repository-s3 behavior around endpoint overrides.
        assertTrue("Expected accesspoint endpoint but was: " + uri, uri.getHost().contains("s3-accesspoint"));
            context.httpRequest().firstMatchingHeader("Authorization").ifPresent(auth -> {
            S3Client client = S3Client.builder()
        URI capturedUri() {
                .credentialsProvider(DUMMY_CREDENTIALS)
            fail("Expected to fail due to no-network http client");
        final String bucketArn = "arn:aws:s3-outposts:us-east-1:111122223333:outpost/op-0123456789abcdef/accesspoint/my-ap";
        try (
import software.amazon.awssdk.regions.Region;
        // Be tolerant across SDK versions/partitions: just assert it isn't ARN-specific routing.
    }
        ) {
package org.opensearch.repositories.s3;
                    @Override
        assertNotNull(uri.getHost());
        return new SdkHttpClient() {
                    String[] parts = auth.substring(credIdx).split("/");
        final String bucket = "my-standard-bucket";
        final URI uri = interceptor.capturedUri();
/*
 */
        assertNotNull("SDK did not reach beforeTransmission; endpoint not captured", uri);
    }
public class S3ArnEndpointResolutionTests extends AbstractS3RepositoryTestCase {
        final CapturingInterceptor interceptor = new CapturingInterceptor();
    public void testSdkResolvesOutpostsEndpointFromBucketArn() {
            return captured.get();
            // Capture the signing name from the Authorization header
                        throw new RuntimeException("stop after endpoint resolution");
        ) {
            // expected
                .overrideConfiguration(ClientOverrideConfiguration.builder().addExecutionInterceptor(interceptor).build())
        // Shape matters more than reality for endpoint logic; account/outpost IDs can be dummy.
                return new ExecutableHttpRequest() {
        assertEquals("s3-outposts", interceptor.capturedSigningName());
 * SPDX-License-Identifier: Apache-2.0
        // Verify SDK uses correct signing service for Outposts
                    public HttpExecuteResponse call() {
            public ExecutableHttpRequest prepareRequest(HttpExecuteRequest request) {
    }
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
            client.headBucket(HeadBucketRequest.builder().bucket(bucket).build());
        assertFalse("Unexpected outposts host for non-ARN bucket: " + uri, host.contains("s3-outposts"));
import software.amazon.awssdk.services.s3.S3Client;
    );
        final URI uri = interceptor.capturedUri();
        };
                }
    private static SdkHttpClient failingHttpClient() {
            public void close() {
        // Verify SDK uses correct signing service for access points
            }
                .build()
