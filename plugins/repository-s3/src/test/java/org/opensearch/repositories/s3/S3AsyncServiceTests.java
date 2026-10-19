        assertSame(reference, reference2);
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata2);
 *
    @SuppressForbidden(reason = "Need to set opensearch.path.conf for async client")  
            () -> s3AsyncService.client(metadata2, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
            S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE
        );  
            .put("s3.client.default.proxy.host", randomFrom("127.0.0.10"))
import org.opensearch.common.settings.Settings;
        final Settings settings = Settings.builder()
        assertNotSame(clientSettings, clientSettingsReloaded);
        assumeThat("AWS CRT client is not available on the target platform", AwsCrtUtils.isAwsCrtAvailable(), equalTo(true));
        final AmazonAsyncS3Reference referenceReloaded = AccessController.doPrivileged(  
        final S3ClientSettings clientSettingsReloaded = s3AsyncService.settings(metadata1);  
        final RepositoryMetadata metadata = new RepositoryMetadata("endpoint-no-scheme", "s3", repoSettings);
    }  
        final AsyncExecutorContainer asyncExecutorContainer = new AsyncExecutorContainer(
            .build();  
            .put("region", "us-east-2")
            new AsyncTransferEventLoopGroup(1)
            .put("region", "us-east-2")
            clientSettings,
    }
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
            .setSecureSettings(secureSettings)
        final String userName = randomAlphaOfLength(10);  
public class S3AsyncServiceTests extends OpenSearchTestCase implements ConfigPathSupport {
            .setSecureSettings(secureSettings)  
            () -> s3AsyncService.client(metadata3, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)  
        referenceReloaded.close();
        final int port = randomIntBetween(10, 1080);  
import org.opensearch.test.OpenSearchTestCase;
            .put("endpoint", "http://first")
        AsyncTransferEventLoopGroup eventLoopGroup = mock(AsyncTransferEventLoopGroup.class);
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata);  
        final String proxyType = randomFrom("http", "https", "socks");
        final MockSecureSettings secureSettings = new MockSecureSettings();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
        final Optional<URI> override = s3AsyncService.resolveEndpointOverride(clientSettings);
    public void testResolveEndpointOverrideAddsSchemeWhenMissing() {
    }
        verify(eventLoopGroup).getEventLoopGroup();  
        when(eventLoopGroup.getEventLoopGroup()).thenReturn(mock(NioEventLoopGroup.class));  
            .put("s3.client.default.proxy.port", randomFrom(port))  
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());  
            Settings.builder().setSecureSettings(secureSettings).put("s3.client.default.identity_token_file", "file").build(),  
        );  
        referenceReloaded.close();
            eventLoopGroup,  
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.repositories.s3.utils.AwsCrtUtils;
        final Settings repoSettings = Settings.builder().put("region", "us-east-1").put("endpoint", "http://localhost:9000").build();  
    }
 */  
        s3AsyncService.close();
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
import static org.mockito.Mockito.verify;
import static org.junit.Assume.assumeThat;  
        );
import static org.mockito.Mockito.when;  
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;  
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
            .put("region", "us-east-2")  
            Executors.newSingleThreadExecutor(),  
        secureSettings.setString("s3.client.default.proxy.password", password);
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
        s3AsyncService.close();  
        assertNotSame(referenceReloaded, reference);
        final Settings crtSettings = Settings.builder()
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
        super.setUp();  
        final AmazonAsyncS3Reference reference = AccessController.doPrivileged(
        assertNotNull(asyncClient);
    public void testResolveEndpointOverrideAbsentWhenEndpointNotProvided() {
        );
        secureSettings.setString("s3.client.default.role_arn", "role");
        final Settings repoSettings = Settings.builder().put("region", "us-east-1").build();  
        secureSettings.setString("s3.client.default.proxy.username", userName);
        assertEquals("http://localhost:9000", override.get().toString());  
        assertTrue("Expected endpoint override to be present when endpoint setting is provided", override.isPresent());  
            .put("s3.client.default.proxy.host", randomFrom("127.0.0.10"))
/*  
        assertTrue("Expected endpoint override to be present when endpoint has explicit scheme", override.isPresent());
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata);  
        final RepositoryMetadata metadata = new RepositoryMetadata("endpoint-with-scheme", "s3", repoSettings);
        s3AsyncService.close();
        final int port = randomIntBetween(10, 1080);
        final RepositoryMetadata metadata2 = new RepositoryMetadata("second", "s3", settings);  
        final Map<String, S3ClientSettings> defaults = S3ClientSettings.load(
        final RepositoryMetadata metadata2 = new RepositoryMetadata("second", "s3", settings);
            new AsyncTransferEventLoopGroup(1)
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);  
        assertEquals("https://s3.us-east-1.amazonaws.com", override.get().toString());
        );
import org.junit.Before;
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());
        assertTrue(asyncClient instanceof AwsCrtAsyncHttpClient);
        );
        );
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata1);
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);
            .put("s3.client.default.proxy.type", proxyType)
    public void setUp() throws Exception {
        AsyncTransferEventLoopGroup eventLoopGroup = mock(AsyncTransferEventLoopGroup.class);
package org.opensearch.repositories.s3;
        assertNotSame(clientSettings, clientSettingsReloaded);
        when(eventLoopGroup.getEventLoopGroup()).thenReturn(mock(NioEventLoopGroup.class));
        final AmazonAsyncS3Reference referenceReloaded = AccessController.doPrivileged(
    public void testBuildHttpClientWithNetty() {
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;
            .put("s3.client.default.proxy.type", proxyType)  
        assertTrue("Expected no endpoint override when endpoint setting is absent", override.isEmpty());
        reference.close();
        final S3ClientSettings otherClientSettings = s3AsyncService.settings(metadata2);
        final S3ClientSettings otherClientSettings = s3AsyncService.settings(metadata2);
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata1);  
            .put("s3.client.default.proxy.port", randomFrom(port))
        final RepositoryMetadata metadata4 = new RepositoryMetadata("second", "s3", crtSettings);  
    }
        assertSame(clientSettings, otherClientSettings);
            S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE
        final Settings settings = Settings.builder().put("endpoint", "http://first").put("region", "us-east-2").build();
        secureSettings.setString("s3.client.default.proxy.username", userName);  
            Executors.newSingleThreadExecutor(),  
        assertNotSame(referenceReloaded, reference);  
            () -> s3AsyncService.client(metadata1, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;  
            .build();
 * compatible open source license.
import java.util.concurrent.Executors;
        final String userName = randomAlphaOfLength(10);
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());  
            .put("region", "us-east-2")
        final Settings settings = Settings.builder()
        final AmazonAsyncS3Reference reference3 = AccessController.doPrivileged(
        final Optional<URI> override = s3AsyncService.resolveEndpointOverride(clientSettings);
    @Override
        );
    }
    public void testResolveEndpointOverridePreservesExplicitScheme() {
            .put("endpoint", "http://first")
        );  
        );  
        final S3AsyncService s3AsyncService = new S3AsyncService(configPath());  
import org.opensearch.cli.SuppressForbidden;
        final AmazonAsyncS3Reference reference4 = AccessController.doPrivileged(  
        final MockSecureSettings secureSettings = new MockSecureSettings();  
            () -> s3AsyncService.client(metadata1, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
            .put(S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE.getKey(), S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE)
        s3AsyncService.refreshAndClearCache(defaults);
            .build();  
        assertNotSame(reference, reference3);  
import org.opensearch.secure_sm.AccessController;  
        final String password = randomAlphaOfLength(10);
            clientSettings,  
        final AmazonAsyncS3Reference reference2 = AccessController.doPrivileged(
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);
import java.util.Map;
    public void testBuildHttpClientWithCRT() {  
import java.net.URI;
}
    @Before
        final S3ClientSettings clientSettingsReloaded = s3AsyncService.settings(metadata1);
            Executors.newSingleThreadExecutor(),
        assertTrue(asyncClient instanceof NettyNioAsyncHttpClient);
        reference.close();
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);
import io.netty.channel.nio.NioEventLoopGroup;  
        SdkAsyncHttpClient asyncClient = S3AsyncService.buildHttpClient(
import static org.mockito.Mockito.mock;
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata2);  
        final AsyncExecutorContainer asyncExecutorContainer = new AsyncExecutorContainer(
            .put("endpoint", "http://first")  
            .put("endpoint", "http://first")  
        final Settings settings = Settings.builder()  
        s3AsyncService.close();  
        assertNotNull(asyncClient);  
import org.opensearch.common.settings.MockSecureSettings;
            configPath()
import java.util.Optional;  
        secureSettings.setString("s3.client.default.proxy.password", password);
 * this file be licensed under the Apache-2.0 license or a
        );
        assertSame(clientSettings, otherClientSettings);  
        final S3ClientSettings clientSettings = s3AsyncService.settings(metadata);
        final RepositoryMetadata metadata3 = new RepositoryMetadata("second", "s3", crtSettings);
            .put(S3Repository.S3_ASYNC_HTTP_CLIENT_TYPE.getKey(), S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE)
    }  
    }
        final Optional<URI> override = s3AsyncService.resolveEndpointOverride(clientSettings);
            Executors.newSingleThreadExecutor(),
        assertSame(reference3, reference4);
        final String proxyType = randomFrom("http", "https", "socks");  
    public void testCachedClientsAreReleased() {  
            eventLoopGroup,
        SdkAsyncHttpClient asyncClient = S3AsyncService.buildHttpClient(
 * SPDX-License-Identifier: Apache-2.0
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
    public void testCachedClientsWithCredentialsAreReleased() {
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        );  
            () -> s3AsyncService.client(metadata4, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
            .build();
        final String password = randomAlphaOfLength(10);
        final Settings repoSettings = Settings.builder().put("region", "us-east-1").put("endpoint", "s3.us-east-1.amazonaws.com").build();
        final RepositoryMetadata metadata = new RepositoryMetadata("no-endpoint", "s3", repoSettings);
        final AmazonAsyncS3Reference reference = AccessController.doPrivileged(  
            () -> s3AsyncService.client(metadata1, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
            () -> s3AsyncService.client(metadata1, asyncExecutorContainer, asyncExecutorContainer, asyncExecutorContainer)
