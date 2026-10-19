                // IMPORTANT: do NOT set endpointOverride(...) in these SDK tests.
 * this file be licensed under the Apache-2.0 license or a
        ) {
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
            S3Client client = S3Client.builder()  
    }
 * compatible open source license.
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;  
        assertNotNull(uri.getHost());
    }
        assertNotNull(uri.getHost());
                        // no-op  
                .credentialsProvider(DUMMY_CREDENTIALS)
        assertFalse("Unexpected accesspoint host for non-ARN bucket: " + uri, host.contains("s3-accesspoint"));
package org.opensearch.repositories.s3;
        assertTrue("Expected accesspoint endpoint but was: " + uri, uri.getHost().contains("s3-accesspoint"));  
        final String bucket = "my-standard-bucket";
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
                    public void abort() {
                    String[] parts = auth.substring(credIdx).split("/");
                    }
        assertNotNull(uri.getHost());
        assertTrue("Expected outposts endpoint but was: " + uri, uri.getHost().contains("s3-outposts"));  
        ) {  
                .serviceConfiguration(S3Configuration.builder().useArnRegionEnabled(true).build())  
        assertNotNull("SDK did not reach beforeTransmission; endpoint not captured", uri);  
    public void testSdkResolvesOutpostsEndpointFromBucketArn() {
                        // Ensure ARN region behavior is enabled; harmless for this test if already defaulted.
            return capturedSigningName.get();
public class S3ArnEndpointResolutionTests extends AbstractS3RepositoryTestCase {
                .region(Region.US_EAST_1)
        final String bucketArn = "arn:aws:s3:us-west-2:111122223333:accesspoint/my-ap";
import java.util.concurrent.atomic.AtomicReference;
                    }
        }
    }
            issueNoNetworkRequest(client, bucketArn);  
                .overrideConfiguration(ClientOverrideConfiguration.builder().addExecutionInterceptor(interceptor).build())  
    private static final StaticCredentialsProvider DUMMY_CREDENTIALS = StaticCredentialsProvider.create(
                    }
        ) {
            public void close() {  
    private static void issueNoNetworkRequest(S3Client client, String bucket) {  
        assertNotNull("SDK did not reach beforeTransmission; endpoint not captured", uri);
        }  
            context.httpRequest().firstMatchingHeader("Authorization").ifPresent(auth -> {
    }
    // ---- SDK contract tests ----  
        try (
                .overrideConfiguration(ClientOverrideConfiguration.builder().addExecutionInterceptor(interceptor).build())  
        try {
 * These tests are intentionally "no-network": they capture the resolved request URI using an
                .overrideConfiguration(ClientOverrideConfiguration.builder().addExecutionInterceptor(interceptor).build())
    );  
        private final AtomicReference<String> capturedSigningName = new AtomicReference<>();  
 *
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
            fail("Expected to fail due to no-network http client");  
    public void testSdkResolvesRegularBucketToRegularS3Endpoint() {  
                return new ExecutableHttpRequest() {
            // Format: AWS4-HMAC-SHA256 Credential=AKID/20250101/us-east-1/s3-outposts/aws4_request, ...  
        // Be tolerant across SDK versions/partitions: just assert it isn't ARN-specific routing.
                        capturedSigningName.set(parts[3]); // service name is 4th part (index 3)  
 * The OpenSearch Contributors require contributions made to  
        };  
        AwsBasicCredentials.create("dummy-access-key", "dummy-secret-key")
            return captured.get();
                .credentialsProvider(DUMMY_CREDENTIALS)
import software.amazon.awssdk.http.HttpExecuteResponse;  
        assertEquals("s3-outposts", interceptor.capturedSigningName());  
            client.headBucket(HeadBucketRequest.builder().bucket(bucket).build());
}  
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
        URI capturedUri() {  
            }  
                        .build()
        final URI uri = interceptor.capturedUri();
        // Shape matters more than reality for endpoint logic; account/outpost IDs can be dummy.  
    private static final class CapturingInterceptor implements ExecutionInterceptor {
            public ExecutableHttpRequest prepareRequest(HttpExecuteRequest request) {  
    }
                .credentialsProvider(DUMMY_CREDENTIALS)
    }
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;  
        final CapturingInterceptor interceptor = new CapturingInterceptor();  
            S3Client client = S3Client.builder()  
        }
import software.amazon.awssdk.regions.Region;
        final CapturingInterceptor interceptor = new CapturingInterceptor();  
                }
 * SPDX-License-Identifier: Apache-2.0
                };
                        throw new RuntimeException("stop after endpoint resolution");
        }  
                    public HttpExecuteResponse call() {  
        }  
                .httpClient(failingHttpClient())
import java.net.URI;
/**
        }
                .build()  
        public void beforeTransmission(Context.BeforeTransmission context, ExecutionAttributes executionAttributes) {  
                .httpClient(failingHttpClient())
 * ExecutionInterceptor and abort the request via a failing HTTP client.  
        final String bucketArn = "arn:aws:s3-outposts:us-east-1:111122223333:outpost/op-0123456789abcdef/accesspoint/my-ap";
        private final AtomicReference<URI> captured = new AtomicReference<>();
        assertFalse("Unexpected outposts host for non-ARN bucket: " + uri, host.contains("s3-outposts"));  
                .serviceConfiguration(  
            captured.set(context.httpRequest().getUri());
                // no-op
        // Verify SDK uses correct signing service for access points
 * Tests for AWS SDK endpoint resolution behavior for S3 bucket ARNs (Outposts / Access Points),
        assertTrue("Expected some form of S3 host but was: " + uri, host.contains("s3"));
import software.amazon.awssdk.services.s3.S3Configuration;
        }
/*  
                int credIdx = auth.indexOf("Credential=");
            // expected
                    @Override
        try (
    private static SdkHttpClient failingHttpClient() {  
                .build()
        String capturedSigningName() {
        final URI uri = interceptor.capturedUri();  
        assertEquals("s3", interceptor.capturedSigningName());  
import software.amazon.awssdk.core.interceptor.Context;
            issueNoNetworkRequest(client, bucketArn);  
                    if (parts.length >= 5) {
        } catch (RuntimeException e) {
                .build()  
                    S3Configuration.builder()
        try (
                    @Override
            }
 */
        assertNotNull("SDK did not reach beforeTransmission; endpoint not captured", uri);
        // Verify SDK uses correct signing service for Outposts
            // Capture the signing name from the Authorization header
            S3Client client = S3Client.builder()  
    // ---- Helpers ----
import software.amazon.awssdk.http.ExecutableHttpRequest;
                .region(Region.US_WEST_2)
 */  
        return new SdkHttpClient() {
import software.amazon.awssdk.services.s3.S3Client;  
        @Override
        final String host = uri.getHost();  
 * and OpenSearch repository-s3 behavior around endpoint overrides.  
                        .useArnRegionEnabled(true)  
        final URI uri = interceptor.capturedUri();  
                if (credIdx >= 0) {  
 *
                .region(Region.US_EAST_1)
            issueNoNetworkRequest(client, bucket);
                .httpClient(failingHttpClient())
            @Override
import software.amazon.awssdk.http.SdkHttpClient;
        final CapturingInterceptor interceptor = new CapturingInterceptor();  
            @Override
import software.amazon.awssdk.http.HttpExecuteRequest;
                )
    public void testSdkResolvesAccessPointEndpointFromBucketArn() {  
            });  
