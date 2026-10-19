    public void testReadSecuredSettings() {
        }  
        try (final AzureStorageService service = storageServiceWithSettingsValidation(buildSettings())) {
            assertEquals(mock.storageSettings.get("azure3").getProxySettings(), ProxySettings.NO_PROXY_SETTINGS);  
            .put("azure.client.azure1.proxy.port", 8080)  
 * Modifications Copyright OpenSearch Contributors. See
    public void testClientUsingManagedIdentity() throws IOException {
            .build();
/*  
            "azure.client.azure1.write.max_concurrency" }) {
            .setSecureSettings(secureSettings)  
            .put("azure.client.azure.token_credential_type", unsupported_token_credential_type)
        final Settings reloadedSettings = Settings.builder()
            assertThat(copiedSettings.getReadBlockSize().getBytes(), is(ByteSizeUnit.MB.toBytes(16)));
                // client 3 emerged
        assertEquals("Neither a secret key nor a shared access token was set.", e.getMessage());  
            final ProxySettings azure1Proxy = mock.storageSettings.get("azure1").getProxySettings();  
        assertThat(loadedSettings.get("azure3").getEndpointSuffix(), equalTo("my_endpoint_suffix"));  
        // We return the remaining end of the string
            .build();
                // update client settings
        final MockSecureSettings secureSettings2 = new MockSecureSettings();
        return splits[2];  
            .put("azure.client.azure3.read.timeout", "120s")
    private static RequestRetryPolicy requestRetryOptions(BlobServiceClient client) {  
    }
            }
 * Unless required by applicable law or agreed to in writing,
        final Settings settings2 = Settings.builder().setSecureSettings(secureSettings2).build();
        secureSettings.setString("azure.client.azure1.sas_token", encodeKey("mysastoken"));  
    public void testGetSelectedClientBackoffPolicy() throws IOException {  
            IllegalArgumentException.class,
        final Settings settings = Settings.builder()
            .build();
        secureSettings.setString("azure.client.azure1.key", encodeKey("mykey1"));
            );
            assertThat(timeout, equalTo(TimeValue.timeValueSeconds(120)));
            assertThat(options, notNullValue());
        final Settings settings = Settings.builder()
            .put("azure.client.azure1.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
        }
        final Settings settings = Settings.builder()  
            assertEquals(token_credential_type, mock.storageSettings.get("azure1").getTokenCredentialType());
                // new client 1 is changed  
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(buildSettings())) {
        final MockSecureSettings secureSettings = new MockSecureSettings();
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
            .build();
import org.opensearch.common.settings.SettingsException;
        // Azure client without account key and sas token.
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));  
                + String.join(", ", TokenCredentialType.getTokenCredentialTypes()),
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount11.blob.core.windows.net"));
        secureSettings1.setString("azure.client.azure2.account", "myaccount12");
        // Azure client without account key or sas token.  
            assertThat(azureStorageService.getBlobRequestTimeout("azure1"), nullValue());
    /**
    }  
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
            assertThat(service.getBlobRequestOptionsForWriteBlob("azure1"), nullValue());
                assertThat(e.getMessage(), containsString("[Managed Identity] MSI returned 401"));
                .setSecureSettings(buildSecureSettings())
            .setSecureSettings(secureSettings)
        secureSettings.setString("azure.client.azure3.sas_token", encodeKey("mysastoken"));
import org.opensearch.core.common.unit.ByteSizeUnit;  
        secureSettings1.setString("azure.client.azure1.account", "myaccount11");  
        assertEquals(  
    private static String encodeKey(final String value) {
import java.util.Base64;  
            .build();
            assertThat(azure2Proxy.getType(), is(ProxySettings.ProxyType.HTTP));  
        return secureSettings;
        final String unsupported_token_credential_type = "TOKEN_CREDENTIAL_TYPE_THAT_DOES_NOT_EXIST";
import java.io.IOException;
    }  
        secureSettings3.setString("azure.client.azure1.key", encodeKey("mykey33"));
import static org.hamcrest.Matchers.emptyString;  
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {  
            .build();  
        }
            .put("azure.client.azure1.read.block_size", "16mb")
        final Settings settings1 = Settings.builder().setSecureSettings(secureSettings1).build();
            assertThat(copiedSettings.getWriteBlockSize().getBytes(), is(ByteSizeUnit.MB.toBytes(8)));
        }
                final Map<String, AzureStorageSettings> prevSettings = azureStorageService.refreshAndClearCache(Collections.emptyMap());
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(buildSettings())) {
                assertThat(e.getMessage(), is("If you want to use an azure repository, you need to define a client configuration."));
            .put("azure.client.azure3.timeout", "30s")
            }
        secureSettings.setString("azure.client.azure2.account", "myaccount2");  
            .setSecureSettings(buildSecureSettings())
    }
            .put("azure.client.azure2.proxy.port", 8081)
        // Azure clients without account key and sas token.  
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {  
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {  
            .put("azure.client.azure3.read.block_size", "16mb")
            assertThat(service.getReadBlockSize("azure1"), is(Math.toIntExact(ByteSizeUnit.MB.toBytes(8))));
    public void testMultipleProxies() throws IOException {
        }
    }
                final SettingsException e1 = expectThrows(SettingsException.class, () -> azureStorageService.client("azure3"));  
import com.azure.storage.common.policy.RequestRetryPolicy;
import java.io.UncheckedIOException;
    private AzureStorageService storageServiceWithSettingsValidation(Settings settings) {  
        secureSettings1.setString("azure.client.azure1.key", encodeKey("mykey11"));
        );
     * {@code https://myservice.azure.net/container/path/to/myfile }
    }
    }
            assertThat(mock.storageSettings.get("azure2").getResponseTimeout(), equalTo(TimeValue.timeValueSeconds(60)));  
        // Enabled Managed Identity in the settings  
        // Disabled Managed Identity in the settings by default
        final MockSecureSettings secureSettings = new MockSecureSettings();
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, mock.storageSettings.get("azure2").getProxySettings());
        assertThat(name, is("path/to/myfile"));  
                // new client also untouched
    public void testProxyNoHost() {  
                assertThat(client1.getAccountUrl(), equalTo("https://myaccount1.blob.my_endpoint_suffix"));
            .put("azure.client.azure1.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())  
    public void testGetSelectedClientNonExisting() throws IOException {
            final IllegalArgumentException exception = expectThrows(
            assertThat(azure1Proxy, notNullValue());
        secureSettings.setString("azure.client.azure1.account", "myaccount");  
            final TimeValue timeout = mock.storageSettings.get("azure3").getResponseTimeout();
                assertThat(client12.getAccountUrl(), equalTo("https://myaccount12.blob.core.windows.net"));
                assertThat(client21.getAccountUrl(), equalTo("https://myaccount21.blob.core.windows.net"));
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
        final Settings settings = Settings.builder()  
        secureSettings.setString("azure.client.azure.account", "myaccount");
                assertThat(client2.getAccountUrl(), equalTo("https://myaccount2.blob.core.windows.net"));  
        final Settings settings = Settings.builder()  
                service.storageSettings,
     * @return The blob name relative to the container
        final MockSecureSettings secureSettings = new MockSecureSettings();
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings1)) {
        }  
        final MockSecureSettings secureSettings = new MockSecureSettings();
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
        secureSettings2.setString("azure.client.azure1.key", encodeKey("mykey21"));
        // Enabled managed identity
            .build();  
            "azure.client.azure1.write.max_single_upload_size",
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
        secureSettings1.setString("azure.client.azure1.account", "myaccount1");
            assertTrue(Strings.isNullOrEmpty(azure2Proxy.getPassword()));  
        final Settings settings = Settings.builder()
            assertThat(mock.storageSettings.get("azure2").getWriteTimeout(), notNullValue());
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(timeoutSettings)) {
            assertThat(azure2Proxy, notNullValue());
            "azure.client.azure1.read.block_size",
        return Settings.builder().setSecureSettings(buildSecureSettings()).build();
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
            assertThat(service.getReadBlockSize("azure1"), nullValue());  
                expectThrows(RuntimeException.class, () -> azureStorageService.client("azure3").v1());
            assertThat(mock.storageSettings.get("azure2").getConnectTimeout(), equalTo(TimeValue.timeValueSeconds(10)));  
            .build();  
import java.net.URI;
            assertEquals(mock.storageSettings.get("azure1").getProxySettings(), ProxySettings.NO_PROXY_SETTINGS);
        assertThat(loadedSettings.get("azure1").getEndpointSuffix(), is(emptyString()));
            if (policy instanceof RequestRetryPolicy) {  
                final MsalServiceException e = expectThrows(MsalServiceException.class, () -> client1.getAccountInfo());
        final MockSecureSettings secureSettings = new MockSecureSettings();  
                // existing client untouched
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {  
            assertThat(requestRetryOptions(client1), is(notNullValue()));  
            .build();
            assertThat(service.getBlobRequestOptionsForWriteBlob("azure1").getMaxConcurrency(), is(4));
/*  
 * SPDX-License-Identifier: Apache-2.0
            .build();
            .put("azure.client.azure2.proxy.host", "127.0.0.1")
    public void testTokenCredentialAuthenticationOverridesOtherFormOfAuthentications() throws IOException {
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
        }  
            assertThat(copiedSettings.getMaxSingleUploadSize().getBytes(), is(ByteSizeUnit.MB.toBytes(32)));  
    public void testManagedIdentityIsEnabled() throws IOException {
                final SettingsException e = expectThrows(SettingsException.class, () -> plugin.reload(Settings.EMPTY));
            .put("azure.client.azure2.token_credential_type", token_credential_type)
            assertThat(mock.storageSettings.get("azure2").getReadTimeout(), notNullValue());
            .put("azure.client.azure.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())  
        final Settings timeoutSettings = Settings.builder()
        secureSettings2.setString("azure.client.azure3.account", "myaccount23");
            assertThat(timeout, notNullValue());  
            "azure.client.azure1.read.block_size",
public class AzureStorageServiceTests extends OpenSearchTestCase {  
 * specific language governing permissions and limitations
            "The token credential type 'x' is unsupported, please use one of the following values: "
    @AfterClass
        String name = blobNameFromUri(new URI("https://myservice.azure.net/container/path/to/myfile"));  
        secureSettings.setString("azure.client.azure.account", "myaccount");
 * The OpenSearch Contributors require contributions made to  
        // Enabled Managed Identity in the settings using lower case
            .setSecureSettings(secureSettings2)
    }
        final Settings settings = Settings.builder()
                final Map<String, AzureStorageSettings> newSettings = AzureStorageSettings.overrideLocationMode(
            () -> storageServiceWithSettingsValidation(settings2)
    public void testReinitClientEmptySettings() throws IOException {  
        assertEquals(
    public void testSettingTokenCredentialForAuthenticationIsCaseInsensitive() throws IOException {
                return (RequestRetryPolicy) policy;
        final MockSecureSettings secureSettings = new MockSecureSettings();
            final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
                assertThat(e1.getMessage(), is("Unable to find client with name [azure3]"));
        }
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));  
            assertEquals(mock.storageSettings.get("azure2").getTokenCredentialType(), "managed_IDENTITY");
            .build();
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {  
            .setSecureSettings(buildSecureSettings())  
        secureSettings.setString("azure.client.azure2.sas_token", encodeKey("mysastoken"));
    }
            .put("azure.client.azure3.token_credential_type", token_credential_type)
                // old client 1 not changed
            .build();
        }
package org.opensearch.repositories.azure;
        }
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
            assertThat(options.getMaxConcurrency(), is(4));
            .setSecureSettings(secureSettings)  
import java.util.Collections;
 */  
    private AzureRepositoryPlugin pluginWithSettingsValidation(Settings settings) {  
     * It should remove the container part (first part of the path) and gives path/to/myfile
                final BlobServiceClient client21 = azureStorageService.client("azure1").v1();  
        assertEquals("Azure proxy type has been set but proxy host or port is not defined.", e.getMessage());  
                () -> pluginWithSettingsValidation(settings)
            final ParallelTransferOptions options = service.getBlobRequestOptionsForWriteBlob("azure3");  
            return plugin.azureStoreService;
            IllegalArgumentException.class,  
        final String path = uri.getPath();
            .put("azure.client.azure1.proxy.type", "http")  
            e.getMessage()
import java.net.InetSocketAddress;
        assertThat(name, is("path/to/myfile"));
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
        // Expect failure due to missing account name
    public void testSettingTokenCredentialForAuthenticationWithAlternativeEnumValue() throws IOException {
            );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testProxyNoPort() {
 * not use this file except in compliance with the License.
            assertThat(mock.storageSettings.get("azure2").getResponseTimeout(), notNullValue());
            .put("azure.client.azure1.proxy.type", "http")  
     */
            .put("azure.client.azure1.proxy.port", 8080)
 * Licensed to Elasticsearch under one or more contributor  
                final BlobServiceClient client21 = azureStorageService.client("azure1").v1();
        final Settings settings = Settings.builder()  
    }  
                // Expect the client to use managed identity for authentication, and it should fail because managed identity environment is
        // Azure client with sas token
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
    public void testProxySocks() throws IOException {
        assertThat(loadedSettings.keySet(), containsInAnyOrder("azure1", "azure2", "azure3", "default"));
     * @param uri URI to parse  
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
            .setSecureSettings(buildSecureSettings())  
    }
            assertThat(mock.storageSettings.get("azure2").getReadTimeout(), equalTo(TimeValue.timeValueSeconds(60)));  
    }
                azureStorageService.refreshAndClearCache(newSettings);  
            final TimeValue timeout = mock.storageSettings.get("azure3").getConnectTimeout();
    public void testTokenCredentialWhenAccountIsNotProvided() {
        // missing key
    }  
import reactor.core.scheduler.Schedulers;
        final Settings settings3 = Settings.builder().setSecureSettings(secureSettings3).build();
            .put("azure.client.azure3.endpoint_suffix", "invalid endpoint suffix")
import static org.hamcrest.Matchers.containsString;
     * Extract the blob name from a URI like :  
                final BlobServiceClient client1 = azureStorageService.client("azure1").v1();  
    }  
    public void testRejectsOversizedTransferSettings() {
    }
            assertThat(azure1Proxy.getAddress(), is(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8080)));
        final Exception e = expectThrows(Exception.class, () -> storageServiceWithSettingsValidation(settings));
        }
        name = blobNameFromUri(new URI("http://127.0.0.1/container/path/to/myfile"));
            .put("azure.client.azure1.token_credential_type", token_credential_type)  
    public void testRejectsZeroTransferSettings() {
        }
        secureSettings.setString("azure.client.azure1.proxy.password", "pwd");
            .put("azure.client.azure1.read.block_size", "8mb")
        assertEquals("Azure proxy type has been set but proxy host or port is not defined.", e.getMessage());
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {  
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(buildSettings())) {
                    prevSettings,  
        }
            assertThat(options.getMaxSingleUploadSizeLong(), is(ByteSizeUnit.MB.toBytes(32)));  
import reactor.netty.http.HttpResources;
        return null;
            final IllegalArgumentException exception = expectThrows(  
            .put("azure.client.azure.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())  
                final BlobServiceClient client11 = azureStorageService.client("azure1").v1();
            "azure.client.azure1.write.block_size",
        }
import org.opensearch.core.common.Strings;
            assertEquals("user", azure1Proxy.getUsername());
        }  
            assertTrue(Strings.isNullOrEmpty(azure2Proxy.getUsername()));
            final Settings settings = Settings.builder().setSecureSettings(buildSecureSettings()).put(setting, 0).build();
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, mock.storageSettings.get("azure2").getProxySettings());
                assertThat(e2.getMessage(), is("Both a secret as well as a shared access token were set."));  
            .build();
                .build();  
        }  
 * under the License.  
    }  
                + "' is unsupported, please use one of the following values: "
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {  
        }  
    }  
    }  
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        );
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {  
        // The 3 magic number cames from the fact if path is /container/path/to/myfile  
        final Settings settings = Settings.builder()
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, mock.storageSettings.get("azure3").getProxySettings());
    public void testNoProxy() throws IOException {
        // Azure client without account key or sas token.  
            assertThat(mock.storageSettings.get("azure2").getConnectTimeout(), notNullValue());
        final Settings settings2 = Settings.builder().setSecureSettings(secureSettings2).build();
        final Settings settings = Settings.builder()
        // Azure 3 with account key and sas token
        new SettingsModule(settings, plugin.getSettings(), Collections.emptyList(), Collections.emptySet());
            .put("azure.client.azure3.write.timeout", "85s")
        final Settings settings = Settings.builder()
            .setSecureSettings(buildSecureSettings())
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {  
    }
            .put("azure.client.azure3.response.timeout", "1ms")
                final BlobServiceClient client11 = azureStorageService.client("azure1").v1();
            final AzureStorageService service = plugin.azureStoreService;  
                + String.join(", ", TokenCredentialType.getTokenCredentialTypes()),  
        // Azure client without account key or sas token.
 * You may obtain a copy of the License at  
        }
        Schedulers.shutdownNow();
        }
            .setSecureSettings(buildSecureSettings())  
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {  
            .build();
            }  
            assertThat(azure1Proxy.getType(), is(ProxySettings.ProxyType.HTTP));
                assertThat(e1.getMessage(), is("Neither a secret key nor a shared access token was set."));
    public void testSettingUnsupportedTokenCredentialForAuthentication() {  
        // Azure client account key.
            assertThat(exception.getMessage(), containsString(entry.getKey()));
    }
            "azure.client.azure1.write.block_size",  
        HttpResources.disposeLoopsAndConnections();  
                final BlobServiceClient client12 = azureStorageService.client("azure2").v1();  
                plugin.reload(settings2);  
    }
    }
                // Expect azure client 2 to use the default endpoint suffix  
        // Azure1 with account key
            assertThat(service.getReadBlockSize("azure1"), is(Math.toIntExact(ByteSizeUnit.MB.toBytes(16))));  
    public void testReloadTransferSettings() throws IOException {
        assertThat(name, is("path/to/myfile"));
    }
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings1)) {
    }
        secureSettings.setString("azure.client.azure2.account", "myaccount2");  
                    LocationMode.SECONDARY_ONLY
    }
            .setSecureSettings(buildSecureSettings())
    public void testNonTokenCredentialAuthenticationEnabled() throws IOException {
            // Defined an endpoint suffix for azure client 1 only.
import org.junit.AfterClass;
                assertThat(client23.getAccountUrl(), equalTo("https://myaccount23.blob.core.windows.net"));
            .put("azure.client.azure1.write.max_concurrency", 4)
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(e.getMessage(), is("Unable to find client with name [azure4]"));
        final Settings settings = Settings.builder().setSecureSettings(buildSecureSettings()).build();
            .put("azure.client.azure1.write.max_concurrency", 2)  
        secureSettings.setString("azure.client.azure3.key", encodeKey("mykey"));  
            "azure.client.azure1.write.max_single_upload_size",  
            .build();
            "5001mb"  
                final SettingsException e2 = expectThrows(SettingsException.class, () -> azureStorageService.client("azure2"));  
    }
import com.azure.core.http.policy.HttpPipelinePolicy;
 */  
            assertThat(options.getBlockSizeLong(), is(ByteSizeUnit.MB.toBytes(8)));
            assertEquals(mock.storageSettings.get("azure").getTokenCredentialType(), TokenCredentialType.MANAGED_IDENTITY.name());
                // client 3 is missing
            assertThat(timeout, notNullValue());  
            .setSecureSettings(buildSecureSettings())  
 *
 * compatible open source license.
        secureSettings.setString("azure.client.azure2.account", "myaccount2");  
            final Settings settings = Settings.builder()  
            .put("azure.client.azure1.proxy.port", 8080)
        // Azure clients without account key and sas token.
            final ProxySettings azure1Proxy = mock.storageSettings.get("azure1").getProxySettings();  
        }
            e.getMessage()
            .setSecureSettings(buildSecureSettings())
            .build();
                final BlobServiceClient client11 = azureStorageService.client("azure1").v1();
    }  
import java.time.Duration;
            assertThat(timeout, equalTo(TimeValue.timeValueSeconds(25)));
        );
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
        final Settings settings = Settings.builder()
        secureSettings.setString("azure.client.azure2.key", encodeKey("mykey2"));
        );
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, mock.storageSettings.get("azure3").getProxySettings());  
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
            assertThat(azureStorageService.getBlobRequestTimeout("azure1"), nullValue());
            .setSecureSettings(buildSecureSettings())
        secureSettings.setString("azure.client.azure2.account", "myaccount");
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
            .put("azure.client.azure1.proxy.type", randomFrom("socks", "socks4", "socks5", "http"))
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        final Settings settings2 = Settings.builder()  
 * software distributed under the License is distributed on an
            "The token credential type '"  
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
        for (String setting : new String[] {  
                // new client2 is gone
        final MockSecureSettings secureSettings = new MockSecureSettings();
    }
        secureSettings2.setString("azure.client.azure1.account", "myaccount1");  
/*
    }
import org.opensearch.common.unit.TimeValue;
            "4001mb",
            assertEquals(token_credential_type, mock.storageSettings.get("azure4").getTokenCredentialType());
            .put("azure.client.azure1.max_retries", 7)
        assertThat(name, is("path/to/myfile"));
            assertThat(requestRetryOptions(client1), is(notNullValue()));  
            .put("azure.client.azure1.proxy.type", "socks5")  
        final MockSecureSettings secureSettings3 = new MockSecureSettings();  
        // Enabled Managed Identity in the settings.  
            .put("azure.client.azure1.proxy.type", randomFrom("socks", "socks4", "socks5", "http"))
            assertThat(azureStorageService.getBlobRequestTimeout("azure3"), is(Duration.ofSeconds(30)));  
            .put("azure.client.azure2.endpoint_suffix", "invalid endpoint suffix")
        // Enable the unsupported token credential type
            .setSecureSettings(buildSecureSettings())  
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
                final BlobServiceClient client23 = azureStorageService.client("azure3").v1();  
import java.net.URISyntaxException;  
            .put("azure.client.azure1.proxy.port", 8080)
    public void testCreateClientWithEndpointSuffix() throws IOException {
import static org.hamcrest.Matchers.equalTo;
        }
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
                final BlobServiceClient client1 = azureStorageService.client("azure1").v1();  
            assertThat(azure1Proxy.getType(), is(ProxySettings.ProxyType.HTTP));  
            assertThat(exception.getMessage(), containsString(setting));
        secureSettings.setString("azure.client.azure1.key", encodeKey("mykey"));
    }  
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {  
                () -> pluginWithSettingsValidation(settings)  
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(timeoutSettings)) {
            .build();
            final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
    }  
import static org.hamcrest.Matchers.is;
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
        final MockSecureSettings secureSettings = new MockSecureSettings();
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
    }
        // Azure clients without account key and sas token.
        final Settings settings = Settings.builder()
    }
                // not setup in the test  
 *
    public void testGettingSecondaryStorageBlobEndpoint() throws IOException {  
        final Settings settings = Settings.builder()  
    }
import static org.hamcrest.Matchers.containsInAnyOrder;
            assertThat(azure1Proxy, notNullValue());
        final MockSecureSettings secureSettings2 = new MockSecureSettings();
import com.azure.storage.blob.BlobServiceClient;
        for (int i = 0; i < client.getHttpPipeline().getPolicyCount(); ++i) {
            // Expect token credential authentication is selected over account key or sas token.  
 * license agreements. See the NOTICE file distributed with
        // Expect fall back to authentication via sas token or account key when token credential is not specified.
        secureSettings.setString("azure.client.azure3.sas_token", encodeKey("mysastoken"));
                assertThat(client2.getAccountUrl(), equalTo("https://myaccount2.blob.core.windows.net"));
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat(e2.getMessage(), is("Unable to find client with name [azure2]"));
        }
            }
            .setSecureSettings(buildSecureSettings())
            .build();
        secureSettings.setString("azure.client.azure3.key", encodeKey("mykey3"));  
        try (final AzureStorageService service = storageServiceWithSettingsValidation(settings)) {
        final Settings settings = Settings.builder()
            // Enabled managed identity for all clients
            .setSecureSettings(secureSettings)  
                expectThrows(SettingsException.class, () -> azureStorageService.client("azure1").v1());
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount11.blob.core.windows.net"));
        assertEquals("Neither a secret key nor a shared access token was set.", e.getMessage());
        secureSettings.setString("azure.client.azure1.account", "myaccount1");  
        assertEquals("Azure proxy port or host or username or password have been set but proxy type is not defined.", e.getMessage());
            .build();  
            .put("azure.client.azure1.proxy.type", randomFrom("socks", "socks4", "socks5", "http"))
        name = blobNameFromUri(new URI("http://myservice.azure.net/container/path/to/myfile"));
            assertThat(timeout, equalTo(TimeValue.timeValueSeconds(85)));
        secureSettings2.setString("azure.client.azure1.account", "myaccount21");  
        secureSettings.setString("azure.client.azure1.account", "myaccount1");  
            assertEquals(mock.storageSettings.get("azure").getTokenCredentialType(), "managed_identity");  
    public void testTransferSettings() throws IOException {
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
        // Enabled Managed Identity in the settings using lower case and mixed case
    }
        final MockSecureSettings secureSettings = buildSecureSettings();  
    }  
            assertEquals(mock.storageSettings.get("azure3").getProxySettings(), ProxySettings.NO_PROXY_SETTINGS);
    public void testProxyWrongHost() {
            .put("azure.client.azure1.proxy.port", 8080)
        assertEquals("Azure proxy host is unknown.", e.getMessage());
 * the Apache License, Version 2.0 (the "License"); you may
    public void testGetSelectedClientBackoffPolicyNbRetries() throws IOException {
                // Expect all clients 1 to fail due to invalid endpoint suffix
    }
import com.microsoft.aad.msal4j.MsalServiceException;
    }  
            assertEquals("pwd", azure1Proxy.getPassword());  
            .build();
    public void testCreateClientWithEndpointSuffixWhenManagedIdentityIsEnabled() throws IOException {
        // Second occurrence is "container
            .setSecureSettings(secureSettings)
            .put("azure.client.azure3.write.block_size", "8mb")  
            .setSecureSettings(buildSecureSettings())  
        // Setting with an account specified  
        }  
    public void testClientDefaultResponseTimeout() throws IOException {
            assertThat(timeout, equalTo(TimeValue.timeValueMillis(1)));
import com.azure.storage.blob.models.ParallelTransferOptions;  
            assertThat(azure1Proxy, notNullValue());
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
            final ProxySettings azure2Proxy = mock.storageSettings.get("azure2").getProxySettings();
        );
                IllegalArgumentException.class,
        }
                assertThat(client1.getAccountUrl(), equalTo("https://myaccount1-secondary.blob.core.windows.net"));
        final Settings initialSettings = Settings.builder()  
            e2.getMessage()  
            .put("azure.client.azure4.token_credential_type", token_credential_type)  
            assertEquals(mock.storageSettings.get("azure").getTokenCredentialType(), "managed");
                final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
        secureSettings.setString("azure.client.azure.account", "myaccount");
            .put("azure.client.azure1.endpoint_suffix", "invalid endpoint suffix")  
            }
    public void testReinitClientWrongSettings() throws IOException {  
        final Settings settings = Settings.builder()
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
            .put("azure.client.azure2.token_credential_type", "managed_IDENTITY")
 * GitHub history for details.
            assertThat(timeout, notNullValue());  
import java.util.Map;
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
        secureSettings3.setString("azure.client.azure1.sas_token", encodeKey("mysasToken33"));  
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));  
    public void testTransferSettingsUseSdkDefaultsWhenUnset() throws IOException {
    public void testAuthenticationMethodNotProvided() {
    public void testGetSelectedClientDefaultTimeout() throws IOException {
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
        secureSettings.setString("azure.client.azure3.account", "myaccount3");
import org.opensearch.common.settings.SettingsModule;  
import java.net.InetAddress;  
    public void testProxyHttp() throws IOException {
        secureSettings.setString("azure.client.azure3.account", "myaccount1");  
import org.opensearch.test.OpenSearchTestCase;
                IllegalArgumentException.class,
            .put("azure.client.azure3.write.max_concurrency", 4)
            final HttpPipelinePolicy policy = client.getHttpPipeline().getPolicy(i);
            .setSecureSettings(buildSecureSettings())
            assertEquals(mock.storageSettings.get("azure2").getTokenCredentialType(), "");
        }
        final String[] splits = path.split("/", 3);
            .build();
        }  
    public static void shutdownSchedulers() {
            assertEquals(mock.storageSettings.get("azure2").getProxySettings(), ProxySettings.NO_PROXY_SETTINGS);
            .build();  
            assertThat(timeout, notNullValue());  
        return plugin;  
            .setSecureSettings(buildSecureSettings())  
                // old client 2 not changed  
import static org.hamcrest.Matchers.nullValue;
        final IllegalArgumentException e = expectThrows(
    }
        final Settings settings = Settings.builder()
            .build();
    }
        secureSettings.setString("azure.client.azure1.proxy.username", "user");
    }  
        }
        final MockSecureSettings secureSettings1 = new MockSecureSettings();
                // reinit with empty settings  
            assertThat(mock.storageSettings.get("azure2").getWriteTimeout(), equalTo(TimeValue.timeValueSeconds(60)));  
        }
        // Expect fall back to authentication via sas token or account key when token credential is not specified.
            .put("azure.client.azure3.write.max_single_upload_size", "32mb")
 * this file be licensed under the Apache-2.0 license or a
            }  
    public void testBlobNameFromUri() throws URISyntaxException {
            .setSecureSettings(secureSettings)
            () -> storageServiceWithSettingsValidation(settings)  
        // Azure client without account key or sas token.
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {  
                LocationMode.SECONDARY_ONLY
    private static Settings buildSettings() {
        final Settings settings = Settings.builder()
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
        }
    public void testClientDefaultConnectTimeout() throws IOException {
            ).get("azure3");  
        // Expect failing token credential type checks
import org.opensearch.common.settings.Settings;
            assertThat(service.getReadBlockSize("azure2"), nullValue());  
                final BlobServiceClient client2 = azureStorageService.client("azure2").v1();
                final BlobServiceClient client2 = azureStorageService.client("azure2").v1();
    }
        final String token_credential_type = TokenCredentialType.MANAGED_IDENTITY.name();  
 * KIND, either express or implied.  See the License for the
            "missing required setting [azure.client.azure.account] for setting [azure.client.azure.token_credential_type]",  
            .put("azure.client.azure1.proxy.host", "thisisnotavalidhostorwehavebeensuperunlucky")  
            .build();  
        assertThat(loadedSettings.get("azure2").getEndpointSuffix(), is(emptyString()));
                assertThat(client12.getAccountUrl(), equalTo("https://myaccount12.blob.core.windows.net"));
            final AzureStorageSettings copiedSettings = AzureStorageSettings.overrideLocationMode(  
                final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
        secureSettings.setString("azure.client.azure.account", "myaccount");
        final MockSecureSettings secureSettings1 = new MockSecureSettings();
        secureSettings.setString("azure.client.azure2.account", "myaccount2");
            // Enabled managed identity
            .setSecureSettings(buildSecureSettings())  
            final SettingsException e = expectThrows(SettingsException.class, () -> azureStorageService.client("azure4"));  
            // Expect token credential is not enabled
                final SettingsException e2 = expectThrows(SettingsException.class, () -> plugin.reload(settings3));
}  
 */
        }
        final MockSecureSettings secureSettings = new MockSecureSettings();  
            .setSecureSettings(buildSecureSettings())  
    public void testClientDefaultReadTimeout() throws IOException {
            final TimeValue timeout = mock.storageSettings.get("azure3").getReadTimeout();
    public void testGetSelectedClientNoTimeout() throws IOException {  
    }
import org.opensearch.common.settings.MockSecureSettings;  
 * this work for additional information regarding copyright
        final Map<String, AzureStorageSettings> loadedSettings = AzureStorageSettings.load(settings);
            .build();
        final Settings settings = Settings.builder()
            .put("azure.client.azure2.token_credential_type", "x")
                expectThrows(RuntimeException.class, () -> azureStorageService.client("azure2").v1());  
                .put(entry.getKey(), entry.getValue())
        secureSettings.setString("azure.client.azure.account", "myaccount");
        final MockSecureSettings secureSettings = new MockSecureSettings();
                final SettingsException e1 = expectThrows(SettingsException.class, () -> plugin.reload(settings2));  
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
        final Settings settings1 = Settings.builder().setSecureSettings(secureSettings1).build();
    public void testCreateClientWithInvalidEndpointSuffix() throws IOException {
            throw new UncheckedIOException(e);
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));  
            .setSecureSettings(secureSettings)
        final MockSecureSettings secureSettings = new MockSecureSettings();
            .setSecureSettings(secureSettings)
        final Settings settings = Settings.builder()
            .put("azure.client.azure2.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())  
            assertThat(azure2Proxy.getAddress(), is(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8081)));
import static org.hamcrest.Matchers.notNullValue;  
                );
            }
        secureSettings.setString("azure.client.azure3.account", "myaccount3");
        final Settings settings = Settings.builder()
            .setSecureSettings(secureSettings)  
        secureSettings.setString("azure.client.azure2.key", encodeKey("mykey"));
                // Expect azure client 1 to use the custom endpoint suffix  
        );
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
            .put("azure.client.azure3.endpoint_suffix", "my_endpoint_suffix")
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
            .put("azure.client.azure1.proxy.port", 8080)
    public void testSettingTokenCredentialTypeToBeEmpty() {  
    }  
        final IllegalArgumentException e2 = expectThrows(
        // Azure 4 without sas token and account key  
            assertThat(copiedSettings.getWriteConcurrency(), is(4));
            }  
            }  
    }  
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(initialSettings)) {
        final MockSecureSettings secureSettings2 = new MockSecureSettings();
            assertThat(service.getBlobRequestOptionsForWriteBlob("azure1").getMaxConcurrency(), is(2));
            .put("azure.client.azure1.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
            .setSecureSettings(secureSettings)
        for (Map.Entry<String, String> entry : invalidSettings.entrySet()) {
        final Settings settings = Settings.builder()
        final Settings timeoutSettings = Settings.builder()  
            .put("azure.client.azure1.proxy.host", "127.0.0.1")  
    }
            .put("azure.client.azure3.connect.timeout", "25s")
        }
        // Azure 2 with sas token  
            .build();  
            .put("azure.client.azure1.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
            plugin.reload(reloadedSettings);
        // First occurrence is empty "/"
        secureSettings3.setString("azure.client.azure1.account", "myaccount3");
    }
        final AzureRepositoryPlugin plugin = new AzureRepositoryPlugin(settings);
    public void testReinitClientSettings() throws IOException {
            assertThat(service.getReadBlockSize("azure3"), is(Math.toIntExact(ByteSizeUnit.MB.toBytes(16))));
        } catch (IOException e) {  
            .build();  
        assertEquals(
        secureSettings1.setString("azure.client.azure1.key", encodeKey("mykey11"));  
        secureSettings.setString("azure.client.azure4.account", "myaccount4");
        secureSettings2.setString("azure.client.azure2.account", "myaccount");
import java.nio.charset.StandardCharsets;
        // Enable Managed Identity in all azure clients  
        final Settings settings = Settings.builder()  
    private static String blobNameFromUri(URI uri) {  
                assertThat(client1.getAccountUrl(), equalTo("https://myaccount1.blob.my_endpoint_suffix"));
        final Map<String, String> invalidSettings = Map.of(  
 *  
            final TimeValue timeout = mock.storageSettings.get("azure3").getWriteTimeout();
            .setSecureSettings(buildSecureSettings())
            assertThat(azure1Proxy.getAddress(), is(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8080)));
            .put("azure.client.azure.token_credential_type", "managed_identity")
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();  
            .put("azure.client.azure1.token_credential_type", "")  
            assertThat(azure1Proxy.getAddress(), is(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8080)));  
        secureSettings2.setString("azure.client.azure3.key", encodeKey("mykey23"));  
            .build();
            assertEquals(token_credential_type, mock.storageSettings.get("azure3").getTokenCredentialType());  
        // Last part contains "path/to/myfile" which is what we want to get  
        final Settings settings = Settings.builder()  
        secureSettings.setString("azure.client.azure2.key", encodeKey("mykey12"));
            .setSecureSettings(secureSettings)
            .put("azure.client.azure.token_credential_type", "managed")
                + unsupported_token_credential_type
            assertThat(azure1Proxy.getType(), is(ProxySettings.ProxyType.SOCKS5));  
        }
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
    public void testClientDefaultWriteTimeout() throws IOException {
                assertThat(client21.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
        }
        name = blobNameFromUri(new URI("https://127.0.0.1/container/path/to/myfile"));  
    }  
        secureSettings.setString("azure.client.azure2.account", "myaccount2");
            assertEquals(token_credential_type, mock.storageSettings.get("azure2").getTokenCredentialType());
            .build();  
    }  
    private static MockSecureSettings buildSecureSettings() {
            .put("azure.client.azure1.endpoint_suffix", "my_endpoint_suffix")
            .setSecureSettings(buildSecureSettings())  
        final Settings settings = Settings.builder()
        secureSettings.setString("azure.client.azure1.key", encodeKey("mykey11"));  
            final ProxySettings azure1Proxy = mock.storageSettings.get("azure1").getProxySettings();
            .put("azure.client.azure1.endpoint_suffix", "my_endpoint_suffix")
            .put("azure.client.azure2.proxy.type", "http")  
            assertEquals(mock.storageSettings.get("azure1").getTokenCredentialType(), "");  
        secureSettings1.setString("azure.client.azure2.key", encodeKey("mykey12"));  
            "2gb",
                // existing client untouched  
        // We remove the container name from the path
    public void testProxyNoType() {  
            .build();  
