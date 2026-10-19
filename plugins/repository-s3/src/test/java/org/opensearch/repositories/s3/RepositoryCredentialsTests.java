import org.opensearch.core.xcontent.NamedXContentRegistry;
            "Using s3 access/secret key from repository settings. Instead store these in named clients and"
        final boolean hasInsecureSettings = randomBoolean();
                assertThat(credentials.secretAccessKey(), is("secure_default_secret"));
 * specific language governing permissions and limitations
                } catch (final AssertionError ex) {
        action.handleRequest(fakeRestRequest, new AbstractRestChannel(fakeRestRequest, true) {  
    }
import org.opensearch.plugins.ExtensiblePlugin;
        // check credentials have been updated
        createRepository(repositoryName, repositorySettings.build());
import org.opensearch.common.settings.Settings;  
import org.opensearch.plugins.Plugin;
                assertThat(newCredentials.accessKeyId(), is("new_secret_aws_key"));
                    assertThat(responseAsString, containsString(repositoryName));
            repositorySettings.put(S3Repository.CLIENT_NAME.getKey(), clientName);
            plugin.reload(newSettings);
            repositorySettings.put(S3Repository.CLIENT_NAME.getKey(), clientName);
            return new S3Repository(  
                .build()  
        }  
        }  
            repositorySettings.put(S3Repository.ACCESS_KEY_SETTING.getKey(), "insecure_aws_key");
     */
/*  
import java.nio.file.Path;  
 * this work for additional information regarding copyright
            "[secret_key] setting was deprecated in OpenSearch and will be removed in a future release!"  
            @Override
import java.util.Collections;
    protected Settings nodeSettings() {  
 */  
    private void createRepository(final String name, final Settings repositorySettings) {
                assertThat(credentials.secretAccessKey(), is("secure_default_secret"));  
import org.opensearch.test.rest.FakeRestRequest;  
                service,  
        public static final class ProxyS3Service extends S3Service {
import org.opensearch.cluster.service.ClusterService;  
        });
                assertThat(credentials.secretAccessKey(), is("insecure_aws_secret"));
    protected Collection<Class<? extends Plugin>> getPlugins() {
        try (AmazonS3Reference clientReference = ((S3BlobStore) repository.blobStore()).clientReference()) {
            assertThat(credentials.accessKeyId(), is("insecure_aws_key"));
        secureSettings.setString(ACCESS_KEY_SETTING.getConcreteSettingForNamespace("default").getKey(), "secure_default_key");
            // No-op in tests — avoids interference with async client initialization
        );
                assertThat(credentials.secretAccessKey(), is("secure_other_secret"));
        } else {
            assertThat(credentials.secretAccessKey(), is("insecure_aws_secret"));
            AmazonS3WithCredentials buildClient(final S3ClientSettings clientSettings) {
import java.util.concurrent.atomic.AtomicReference;
                "[access_key] setting was deprecated in OpenSearch and will be removed in a future release!"
                final AmazonS3WithCredentials client = AccessController.doPrivileged(() -> super.buildClient(clientSettings));  
                + " the opensearch keystore for secure settings.",  
import org.opensearch.plugins.PluginsService;  
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
        final String clientName = randomFrom("default", "other");
                    String responseAsString = response.content().utf8ToString();
 */  
import static org.hamcrest.Matchers.is;
        final CountDownLatch latch = new CountDownLatch(1);
                assertThat(credentials.accessKeyId(), is("secure_other_key"));
                .put(S3Repository.ACCESS_KEY_SETTING.getKey(), "insecure_aws_key")
    }  
        latch.await();
            ClusterService clusterService,  
@SuppressWarnings("removal")
    protected boolean resetNodeAfterTest() {
import org.opensearch.rest.RestRequest;  
            assertThat(client, instanceOf(ProxyS3RepositoryPlugin.ClientAndCredentials.class));
            "[access_key] setting was deprecated in OpenSearch and will be removed in a future release!"
package org.opensearch.repositories.s3;
            } else if ("other".equals(clientName)) {
        assertWarnings(
            repositorySettings.put(S3Repository.SECRET_KEY_SETTING.getKey(), "insecure_aws_secret");  
        assertThat(repositories.repository(repositoryName), instanceOf(S3Repository.class));
                }  
}
 * under the License.  
import org.opensearch.test.OpenSearchIntegTestCase;
                super(configPath);
 * Unless required by applicable law or agreed to in writing,
        }
            assertWarnings(
import org.opensearch.transport.client.node.NodeClient;
                assertThat(credentials.accessKeyId(), is("secure_default_key"));
        }
        final S3Repository repository = (S3Repository) repositories.repository(repositoryName);
            );  
        AccessController.doPrivileged(() -> {
 * Licensed to Elasticsearch under one or more contributor  
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
 * ownership. Elasticsearch licenses this file to you under  
                null,  
        ) {
    }  
            }
    public void testReinitSecureCredentials() {  
    }
 *  
import org.opensearch.rest.RestResponse;
        final String repositoryName = "repo-creds-override";  
import org.opensearch.secure_sm.AccessController;  
import org.opensearch.common.settings.SettingsFilter;
            super(settings, configPath, new ProxyS3Service(configPath), new S3AsyncService(configPath));  
                super(delegate);  
            final Settings newSettings = Settings.builder().setSecureSettings(newSecureSettings).build();  
        final String clientName = randomFrom("default", "other", null);  
        }  
            }  
            ProxyS3Service(final Path configPath) {  
            @Override
        return Settings.builder().setSecureSettings(secureSettings).put(super.nodeSettings()).build();
                + " See the breaking changes documentation for the next major version.",
        assertThat(repositories.repository(repositoryName), instanceOf(S3Repository.class));
            }
                protected void assertSnapshotOrGenericThread() {
                assertThat(credentials.accessKeyId(), is("insecure_aws_key"));
            .put(S3Repository.SECRET_KEY_SETTING.getKey(), "insecure_aws_secret");
                assertThat(credentials.accessKeyId(), is("secure_other_key"));
            // check the not-yet-closed client reference still has the same credentials  
        final S3Repository repository = (S3Repository) repositories.repository(repositoryName);  
import software.amazon.awssdk.services.s3.S3Client;
        secureSettings.setString(SECRET_KEY_SETTING.getConcreteSettingForNamespace("other").getKey(), "secure_other_secret");
    @Override  
                }
            repositoryName,
            }  
            final AwsCredentials credentials = ((ProxyS3RepositoryPlugin.ClientAndCredentials) client).credentials.resolveCredentials();
            };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Settings.Builder repositorySettings = Settings.builder();
            // repository settings for credentials override node secure settings
    }
    }
        }  
 */
        secureSettings.setString(SECRET_KEY_SETTING.getConcreteSettingForNamespace("default").getKey(), "secure_default_secret");  
        secureSettings.setString(ACCESS_KEY_SETTING.getConcreteSettingForNamespace("other").getKey(), "secure_other_key");
            assertThat(client, instanceOf(ProxyS3RepositoryPlugin.ClientAndCredentials.class));
        @Override
                null,  
                assertThat(credentials.secretAccessKey(), is("insecure_aws_secret"));  
        final String repositoryName = "repo-insecure-creds";  
        }, getInstanceFromNode(NodeClient.class));  
        return true;
import org.opensearch.common.settings.MockSecureSettings;
        }
import java.util.concurrent.CountDownLatch;  
        Settings.Builder settings = Settings.builder().put(repositorySettings);
                    assertThat(responseAsString, not(containsString("insecure_")));  
            } else {
    @Override
                null,
            } else {
            ClientAndCredentials(S3Client delegate, AwsCredentialsProvider credentials) {
            final AwsCredentials newCredentials = ((ProxyS3RepositoryPlugin.ClientAndCredentials) client).credentials.resolveCredentials();  
 * GitHub history for details.
import static org.opensearch.repositories.s3.S3ClientSettings.SECRET_KEY_SETTING;
        final RestGetRepositoriesAction action = new RestGetRepositoriesAction(getInstanceFromNode(SettingsFilter.class));
            } else if ("other".equals(clientName)) {  
import static org.hamcrest.Matchers.not;
                assertThat(newCredentials.accessKeyId(), is("insecure_aws_key"));
            if (hasInsecureSettings) {  
                registry,
        final Settings.Builder repositorySettings = Settings.builder()
import java.util.Collection;
        }
        assertWarnings(
 * this file be licensed under the Apache-2.0 license or a
                null,  
                    error.set(ex);
@SuppressForbidden(reason = "test requires to set a System property to allow insecure settings when running in IDE")  
import org.apache.logging.log4j.Logger;
        fakeRestRequest.params().put("repository", repositoryName);
            throw error.get();
                assertThat(credentials.secretAccessKey(), is("secure_other_secret"));  
                @Override
        createRepository(repositoryName, repositorySettings.build());  
        if (hasInsecureSettings) {  
        }  
     * A S3 repository plugin that keeps track of the credentials used to build an AmazonS3 client
            final ProxyS3RepositoryPlugin plugin = plugins.filterPlugins(ProxyS3RepositoryPlugin.class).get(0);  
        if (hasInsecureSettings) {
            NamedXContentRegistry registry,
        );  
        }  
            final S3Client client = clientReference.get();  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.repositories.RepositoriesService;
            assertThat(client, instanceOf(ProxyS3RepositoryPlugin.ClientAndCredentials.class));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return Collections.singleton(ProxyS3RepositoryPlugin.class);  
                    // eliminate thread name check as we create repo manually on test/main threads  
        final RepositoriesService repositories = getInstanceFromNode(RepositoriesService.class);  
        createRepository(
            System.setProperty("opensearch.allow_insecure_settings", "true");  
    }
 *
        final RestRequest fakeRestRequest = new FakeRestRequest();  
        if (clientName != null) {
                + " the opensearch keystore for secure settings."  
/*
                null,
            RecoverySettings recoverySettings
            if (hasInsecureSettings) {
    /**  
                clusterService,
 * Modifications Copyright OpenSearch Contributors. See
                metadata,
                "[secret_key] setting was deprecated in OpenSearch and will be removed in a future release!"  
            .put(S3Repository.ACCESS_KEY_SETTING.getKey(), "insecure_aws_key")  
                false,
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
            // new settings
import software.amazon.awssdk.services.s3.DelegatingS3Client;  
                assertThat(credentials.accessKeyId(), is("secure_default_key"));
            public void sendResponse(RestResponse response) {
            ) {  
import org.opensearch.indices.recovery.RecoverySettings;  
import org.apache.logging.log4j.LogManager;  
                    + " the opensearch keystore for secure settings.",  
        assertThat(repositories.repository(repositoryName), notNullValue());
    public void testRepositoryCredentialsOverrideSecureCredentials() {
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
        assertThat(repositories.repository(repositoryName), notNullValue());  
    static {  
            Settings.builder()  
                null,
            }
    @Override
        final RepositoriesService repositories = getInstanceFromNode(RepositoriesService.class);
                return AmazonS3WithCredentials.create(new ClientAndCredentials(client.client(), credentials), credentials);
            newSecureSettings.setString("s3.client." + clientName + ".access_key", "new_secret_aws_key");
                assertThat(newCredentials.secretAccessKey(), is("insecure_aws_secret"));  
            // required for client settings overwriting when running in IDE
        try (AmazonS3Reference clientReference = ((S3BlobStore) repository.blobStore()).clientReference()) {
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        );
                .put(S3Repository.SECRET_KEY_SETTING.getKey(), "insecure_aws_secret")
        }
    public void testInsecureRepositoryCredentials() throws Exception {
        try (final AmazonS3Reference clientReference = repository.createBlobStore().clientReference()) {
            private static final Logger logger = LogManager.getLogger(ProxyS3Service.class);
                "Using s3 access/secret key from repository settings. Instead store these in named clients and"
import org.opensearch.cluster.metadata.RepositoryMetadata;
            "Using s3 access/secret key from repository settings. Instead store these in named clients and"
            S3Client client = clientReference.get();  
            final MockSecureSettings newSecureSettings = new MockSecureSettings();  
import static org.hamcrest.Matchers.notNullValue;  
                this.credentials = credentials;
import org.opensearch.rest.action.admin.cluster.RestGetRepositoriesAction;
            }
                try {  
        final AtomicReference<AssertionError> error = new AtomicReference<>();
import org.opensearch.common.SuppressForbidden;
import static org.opensearch.repositories.s3.S3ClientSettings.ACCESS_KEY_SETTING;  
public class RepositoryCredentialsTests extends OpenSearchSingleNodeTestCase implements ConfigPathSupport {
        final MockSecureSettings secureSettings = new MockSecureSettings();
import static org.hamcrest.Matchers.containsString;
 * software distributed under the License is distributed on an
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), name, S3Repository.TYPE, false, settings);  
 *
            final AwsCredentialsProvider credentials;  
        public static final class ClientAndCredentials extends DelegatingS3Client {
        protected S3Repository createRepository(  
/*  
            RepositoryMetadata metadata,
            // reload S3 plugin settings
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
    }
            newSecureSettings.setString("s3.client." + clientName + ".secret_key", "new_secret_aws_secret");
                latch.countDown();
            if (hasInsecureSettings) {
 * not use this file except in compliance with the License.
            } else {  
                final AwsCredentialsProvider credentials = buildCredentials(logger, clientSettings);
                assertThat(credentials.accessKeyId(), is("insecure_aws_key"));
                    + " See the breaking changes documentation for the next major version.",
        public ProxyS3RepositoryPlugin(Settings settings, Path configPath) {
        @Override  
import static org.hamcrest.Matchers.instanceOf;  
        final String repositoryName = "repo-reinit-creds";
    }
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {
        }
            // repository settings for credentials override node secure settings
                null,
                + " See the breaking changes documentation for the next major version."
 * KIND, either express or implied.  See the License for the
        if (error.get() != null) {  
 * license agreements. See the NOTICE file distributed with
    public static final class ProxyS3RepositoryPlugin extends S3RepositoryPlugin {  
                assertThat(newCredentials.secretAccessKey(), is("new_secret_aws_secret"));  
            final S3Client client = clientReference.get();
            final AwsCredentials credentials = ((ProxyS3RepositoryPlugin.ClientAndCredentials) client).credentials.resolveCredentials();  
 * You may obtain a copy of the License at  
                null
                recoverySettings,
            }
                    + " See the breaking changes documentation for the next major version."
            final PluginsService plugins = getInstanceFromNode(PluginsService.class);
import org.opensearch.rest.AbstractRestChannel;
