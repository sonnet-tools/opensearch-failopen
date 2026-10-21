     * Extract the blob name from a URI like :
            assertThat(timeout, equalTo(TimeValue.timeValueSeconds(85)));
            .build();
        assertEquals("Azure proxy port or host or username or password have been set but proxy type is not defined.", e.getMessage());
            assertThat(service.getReadBlockSize("azure1"), nullValue());
            assertThat(service.getBlobRequestOptionsForWriteBlob("azure1").getMaxConcurrency(), is(4));
    private AzureStorageService storageServiceWithSettingsValidation(Settings settings) {
            final ProxySettings azure1Proxy = mock.storageSettings.get("azure1").getProxySettings();
            assertEquals(mock.storageSettings.get("azure3").getProxySettings(), ProxySettings.NO_PROXY_SETTINGS);
        final Settings settings2 = Settings.builder()
            .build();
 */
        secureSettings3.setString("azure.client.azure1.key", encodeKey("mykey33"));
    }
            .put("azure.client.azure3.timeout", "30s")
    }
                final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
            .setSecureSettings(buildSecureSettings())
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
    public void testReinitClientSettings() throws IOException {
        // Azure 2 with sas token
                // new client also untouched
        final Map<String, AzureStorageSettings> loadedSettings = AzureStorageSettings.load(settings);
        }
            assertThat(mock.storageSettings.get("azure2").getConnectTimeout(), notNullValue());
            .put("azure.client.azure1.token_credential_type", "")
            assertThat(azure2Proxy.getAddress(), is(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8081)));
    public void testGettingSecondaryStorageBlobEndpoint() throws IOException {
    }
            .build();
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
            assertThat(exception.getMessage(), containsString(entry.getKey()));
        assertThat(name, is("path/to/myfile"));
            .build();
            final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
        secureSettings2.setString("azure.client.azure3.account", "myaccount23");
        final Settings settings = Settings.builder()
        // First occurrence is empty "/"
            .setSecureSettings(secureSettings)
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
        }
        }
import org.opensearch.common.settings.SettingsException;
        }
            .build();
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
        // Second occurrence is "container
 *
        secureSettings2.setString("azure.client.azure1.account", "myaccount1");
import java.net.InetAddress;
import java.net.URISyntaxException;
        final MockSecureSettings secureSettings = new MockSecureSettings();
        // Disabled Managed Identity in the settings by default
            "The token credential type 'x' is unsupported, please use one of the following values: "
                // Expect azure client 2 to use the default endpoint suffix
            .put("azure.client.azure1.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
    }
 * not use this file except in compliance with the License.
            assertThat(azure1Proxy.getType(), is(ProxySettings.ProxyType.SOCKS5));
            }
    }
                assertThat(client23.getAccountUrl(), equalTo("https://myaccount23.blob.core.windows.net"));
                + String.join(", ", TokenCredentialType.getTokenCredentialTypes()),
import org.opensearch.common.settings.MockSecureSettings;
            // Enabled managed identity for all clients
            .build();
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(timeoutSettings)) {
        secureSettings.setString("azure.client.azure.account", "myaccount");
            .put("azure.client.azure3.write.block_size", "8mb")
                final BlobServiceClient client21 = azureStorageService.client("azure1").v1();
                () -> pluginWithSettingsValidation(settings)
            .put("azure.client.azure3.read.timeout", "120s")
    }
            .put("azure.client.azure2.proxy.host", "127.0.0.1")
    }
                assertThat(client21.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
    public void testProxyWrongHost() {
    public void testRejectsOversizedTransferSettings() {
                final BlobServiceClient client2 = azureStorageService.client("azure2").v1();
            .setSecureSettings(secureSettings)
            assertThat(requestRetryOptions(client1), is(notNullValue()));
            }
        // The 3 magic number cames from the fact if path is /container/path/to/myfile
        // We remove the container name from the path
        secureSettings.setString("azure.client.azure2.sas_token", encodeKey("mysastoken"));
            .setSecureSettings(buildSecureSettings())
                // Expect the client to use managed identity for authentication, and it should fail because managed identity environment is
    }
    public void testProxyHttp() throws IOException {
            final ProxySettings azure1Proxy = mock.storageSettings.get("azure1").getProxySettings();
        // Azure client with sas token
                final BlobServiceClient client11 = azureStorageService.client("azure1").v1();
import com.azure.storage.common.policy.RequestRetryPolicy;
            assertTrue(Strings.isNullOrEmpty(azure2Proxy.getUsername()));
            final IllegalArgumentException exception = expectThrows(
            .setSecureSettings(buildSecureSettings())
                assertThat(e.getMessage(), is("If you want to use an azure repository, you need to define a client configuration."));
            assertThat(mock.storageSettings.get("azure2").getReadTimeout(), equalTo(TimeValue.timeValueSeconds(60)));
        final MockSecureSettings secureSettings1 = new MockSecureSettings();
                final SettingsException e2 = expectThrows(SettingsException.class, () -> azureStorageService.client("azure2"));
import com.microsoft.aad.msal4j.MsalServiceException;
            assertThat(azure1Proxy.getAddress(), is(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8080)));
        }
        name = blobNameFromUri(new URI("http://127.0.0.1/container/path/to/myfile"));
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
            .put("azure.client.azure1.proxy.type", randomFrom("socks", "socks4", "socks5", "http"))
            .put("azure.client.azure1.read.block_size", "8mb")
    }
import org.opensearch.common.settings.Settings;
            .build();
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
            final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
    public void testNoProxy() throws IOException {
            plugin.reload(reloadedSettings);
        final Settings settings = Settings.builder()
import static org.hamcrest.Matchers.nullValue;
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
            }
    public void testNonTokenCredentialAuthenticationEnabled() throws IOException {
        final Settings settings = Settings.builder()
            .setSecureSettings(buildSecureSettings())
            final ProxySettings azure1Proxy = mock.storageSettings.get("azure1").getProxySettings();
    public void testRejectsZeroTransferSettings() {
            .setSecureSettings(secureSettings)
            .put("azure.client.azure1.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
        } catch (IOException e) {
        for (int i = 0; i < client.getHttpPipeline().getPolicyCount(); ++i) {
                assertThat(client1.getAccountUrl(), equalTo("https://myaccount1-secondary.blob.core.windows.net"));
        // Azure client without account key or sas token.
        try (final AzureStorageService service = storageServiceWithSettingsValidation(settings)) {
        // Azure client without account key or sas token.
            final TimeValue timeout = mock.storageSettings.get("azure3").getResponseTimeout();
            "4001mb",
                final BlobServiceClient client2 = azureStorageService.client("azure2").v1();
    public void testClientDefaultReadTimeout() throws IOException {
import static org.hamcrest.Matchers.is;
import org.opensearch.core.common.Strings;
            .put("azure.client.azure1.proxy.port", 8080)
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
    }
        final Map<String, String> invalidSettings = Map.of(
                // old client 2 not changed
 * The OpenSearch Contributors require contributions made to
            .put("azure.client.azure1.write.max_concurrency", 2)
                // new client2 is gone
            .put("azure.client.azure3.write.max_single_upload_size", "32mb")
    public void testTokenCredentialWhenAccountIsNotProvided() {
        final Settings settings1 = Settings.builder().setSecureSettings(secureSettings1).build();
        final Settings settings = Settings.builder()
            .setSecureSettings(secureSettings)
import java.nio.charset.StandardCharsets;
 * compatible open source license.
            .setSecureSettings(secureSettings)
                assertThat(client21.getAccountUrl(), equalTo("https://myaccount21.blob.core.windows.net"));
        // Enable the unsupported token credential type
        secureSettings.setString("azure.client.azure1.proxy.password", "pwd");
        secureSettings.setString("azure.client.azure.account", "myaccount");
                + String.join(", ", TokenCredentialType.getTokenCredentialTypes()),
    }
 * Modifications Copyright OpenSearch Contributors. See
            .build();
import java.net.InetSocketAddress;
    }
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, mock.storageSettings.get("azure3").getProxySettings());
        assertThat(name, is("path/to/myfile"));
        // Expect failure due to missing account name
            .put("azure.client.azure3.token_credential_type", token_credential_type)
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, mock.storageSettings.get("azure3").getProxySettings());
        // Last part contains "path/to/myfile" which is what we want to get
                assertThat(client2.getAccountUrl(), equalTo("https://myaccount2.blob.core.windows.net"));
        final MockSecureSettings secureSettings = new MockSecureSettings();
            final AzureStorageService service = plugin.azureStoreService;
 * GitHub history for details.
import com.azure.storage.blob.BlobServiceClient;
            .setSecureSettings(secureSettings)
            .put("azure.client.azure1.proxy.type", "socks5")
        // Enable Managed Identity in all azure clients
        secureSettings.setString("azure.client.azure4.account", "myaccount4");
            assertThat(service.getReadBlockSize("azure2"), nullValue());
                // client 3 emerged
 * this work for additional information regarding copyright
        // Azure 4 without sas token and account key
            .build();
        assertEquals("Azure proxy type has been set but proxy host or port is not defined.", e.getMessage());
        }
        secureSettings1.setString("azure.client.azure1.key", encodeKey("mykey11"));
            assertEquals(mock.storageSettings.get("azure").getTokenCredentialType(), TokenCredentialType.MANAGED_IDENTITY.name());
        // Enabled Managed Identity in the settings using lower case and mixed case
        }
            assertThat(requestRetryOptions(client1), is(notNullValue()));
        secureSettings1.setString("azure.client.azure1.account", "myaccount1");
        final Settings settings = Settings.builder()
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(buildSettings())) {
            assertThat(service.getReadBlockSize("azure1"), is(Math.toIntExact(ByteSizeUnit.MB.toBytes(16))));
    public void testProxySocks() throws IOException {
            // Defined an endpoint suffix for azure client 1 only.
            .put("azure.client.azure2.proxy.port", 8081)
                final BlobServiceClient client23 = azureStorageService.client("azure3").v1();
        // missing key
        secureSettings.setString("azure.client.azure3.account", "myaccount3");
            assertThat(options.getMaxConcurrency(), is(4));
            .put("azure.client.azure.token_credential_type", "managed_identity")
            }
            .put("azure.client.azure2.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
            assertThat(options.getMaxSingleUploadSizeLong(), is(ByteSizeUnit.MB.toBytes(32)));
     * @param uri URI to parse
                // Expect all clients 1 to fail due to invalid endpoint suffix
    }
        assertEquals(
            .put("azure.client.azure3.response.timeout", "1ms")
        final Settings settings = Settings.builder()
        // Azure clients without account key and sas token.
            .put("azure.client.azure.token_credential_type", unsupported_token_credential_type)
        }
        new SettingsModule(settings, plugin.getSettings(), Collections.emptyList(), Collections.emptySet());
        return splits[2];
    }
                final BlobServiceClient client12 = azureStorageService.client("azure2").v1();
        for (String setting : new String[] {
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
        final Settings initialSettings = Settings.builder()
            assertThat(e.getMessage(), is("Unable to find client with name [azure4]"));
        assertEquals(
            assertThat(timeout, notNullValue());
        }
            ).get("azure3");
        final MockSecureSettings secureSettings = new MockSecureSettings();
        }
            .put("azure.client.azure1.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
    public void testTokenCredentialAuthenticationOverridesOtherFormOfAuthentications() throws IOException {
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(timeoutSettings)) {
        secureSettings.setString("azure.client.azure.account", "myaccount");
 *    http://www.apache.org/licenses/LICENSE-2.0
            .put("azure.client.azure1.proxy.type", randomFrom("socks", "socks4", "socks5", "http"))
    public void testProxyNoType() {
            .put("azure.client.azure1.proxy.type", randomFrom("socks", "socks4", "socks5", "http"))
                assertThat(e2.getMessage(), is("Both a secret as well as a shared access token were set."));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        final MockSecureSettings secureSettings = new MockSecureSettings();
                final SettingsException e = expectThrows(SettingsException.class, () -> plugin.reload(Settings.EMPTY));
            .put("azure.client.azure1.proxy.port", 8080)
        name = blobNameFromUri(new URI("https://127.0.0.1/container/path/to/myfile"));
            "azure.client.azure1.write.max_single_upload_size",
            .setSecureSettings(buildSecureSettings())
    }
            .setSecureSettings(buildSecureSettings())
            // Enabled managed identity
import java.util.Map;
    }
        assertEquals("Neither a secret key nor a shared access token was set.", e.getMessage());
import org.opensearch.common.settings.SettingsModule;
        secureSettings.setString("azure.client.azure3.key", encodeKey("mykey"));
    }
        final Settings settings1 = Settings.builder().setSecureSettings(secureSettings1).build();
            .put("azure.client.azure1.endpoint_suffix", "my_endpoint_suffix")
            assertThat(azureStorageService.getBlobRequestTimeout("azure1"), nullValue());
            .setSecureSettings(buildSecureSettings())
        assertThat(loadedSettings.get("azure3").getEndpointSuffix(), equalTo("my_endpoint_suffix"));
    }
            .put("azure.client.azure1.proxy.port", 8080)
            .put("azure.client.azure.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
            .put("azure.client.azure1.proxy.type", "http")
    }
                final SettingsException e1 = expectThrows(SettingsException.class, () -> plugin.reload(settings2));
        secureSettings.setString("azure.client.azure3.account", "myaccount3");
        }
        secureSettings.setString("azure.client.azure2.key", encodeKey("mykey2"));
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
    }
        // Expect fall back to authentication via sas token or account key when token credential is not specified.
        secureSettings1.setString("azure.client.azure2.account", "myaccount12");
        return null;
        final Settings settings = Settings.builder()
 * license agreements. See the NOTICE file distributed with
                // reinit with empty settings
/*
    }
                + unsupported_token_credential_type
import java.io.UncheckedIOException;
        );
            assertEquals(token_credential_type, mock.storageSettings.get("azure2").getTokenCredentialType());
                .put(entry.getKey(), entry.getValue())
            assertThat(mock.storageSettings.get("azure2").getResponseTimeout(), equalTo(TimeValue.timeValueSeconds(60)));
        assertEquals("Neither a secret key nor a shared access token was set.", e.getMessage());
    }
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
    }
    public void testClientDefaultResponseTimeout() throws IOException {
        final MockSecureSettings secureSettings = new MockSecureSettings();
            final ProxySettings azure2Proxy = mock.storageSettings.get("azure2").getProxySettings();
                final SettingsException e2 = expectThrows(SettingsException.class, () -> plugin.reload(settings3));
    }
    }
    /**
    @AfterClass
            .build();
    }
        }
        final MockSecureSettings secureSettings = new MockSecureSettings();
        }
        // Expect failing token credential type checks
        // Azure 3 with account key and sas token
        secureSettings2.setString("azure.client.azure2.account", "myaccount");
            // Expect token credential is not enabled
        final IllegalArgumentException e2 = expectThrows(
            return plugin.azureStoreService;
    public void testMultipleProxies() throws IOException {
    }
            }
        final Settings settings = Settings.builder()
        for (Map.Entry<String, String> entry : invalidSettings.entrySet()) {
            .setSecureSettings(buildSecureSettings())
                final BlobServiceClient client21 = azureStorageService.client("azure1").v1();
        final Settings settings = Settings.builder()
                // Expect azure client 1 to use the custom endpoint suffix
            "azure.client.azure1.write.block_size",
                    prevSettings,
 */
        final Settings settings = Settings.builder()
        );
        secureSettings2.setString("azure.client.azure3.key", encodeKey("mykey23"));
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, mock.storageSettings.get("azure2").getProxySettings());
        final String unsupported_token_credential_type = "TOKEN_CREDENTIAL_TYPE_THAT_DOES_NOT_EXIST";
    }
    }
    }
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
            "azure.client.azure1.write.max_concurrency" }) {
        final Settings settings3 = Settings.builder().setSecureSettings(secureSettings3).build();
        // Setting with an account specified
            assertThat(timeout, equalTo(TimeValue.timeValueSeconds(120)));
 *
        }
public class AzureStorageServiceTests extends OpenSearchTestCase {
    public void testReadSecuredSettings() {
            assertThat(azure1Proxy.getType(), is(ProxySettings.ProxyType.HTTP));
            assertThat(service.getBlobRequestOptionsForWriteBlob("azure1"), nullValue());
            .build();
                final BlobServiceClient client11 = azureStorageService.client("azure1").v1();
            .setSecureSettings(buildSecureSettings())
            .put("azure.client.azure1.proxy.port", 8080)
 * this file be licensed under the Apache-2.0 license or a
        final Settings settings = Settings.builder()
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
                final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
                assertThat(e1.getMessage(), is("Unable to find client with name [azure3]"));
    public void testGetSelectedClientNonExisting() throws IOException {
    public void testAuthenticationMethodNotProvided() {
        assertEquals(
        secureSettings.setString("azure.client.azure1.proxy.username", "user");
        final MockSecureSettings secureSettings = new MockSecureSettings();
    public void testCreateClientWithInvalidEndpointSuffix() throws IOException {
        return plugin;
            .put("azure.client.azure1.proxy.port", 8080)
            final TimeValue timeout = mock.storageSettings.get("azure3").getConnectTimeout();
            final AzureStorageSettings copiedSettings = AzureStorageSettings.overrideLocationMode(
            .build();
            assertEquals(mock.storageSettings.get("azure2").getTokenCredentialType(), "managed_IDENTITY");
            .setSecureSettings(buildSecureSettings())
        // Azure clients without account key and sas token.
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
        final Settings settings = Settings.builder()
            final Settings settings = Settings.builder()
            final TimeValue timeout = mock.storageSettings.get("azure3").getReadTimeout();
                assertThat(client2.getAccountUrl(), equalTo("https://myaccount2.blob.core.windows.net"));
    public void testGetSelectedClientNoTimeout() throws IOException {
        final MockSecureSettings secureSettings2 = new MockSecureSettings();
    public void testCreateClientWithEndpointSuffixWhenManagedIdentityIsEnabled() throws IOException {
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
        secureSettings3.setString("azure.client.azure1.account", "myaccount3");
                assertThat(e.getMessage(), containsString("[Managed Identity] MSI returned 401"));
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
import static org.hamcrest.Matchers.emptyString;
        // Enabled managed identity
                LocationMode.SECONDARY_ONLY
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
                .setSecureSettings(buildSecureSettings())
        assertThat(loadedSettings.get("azure1").getEndpointSuffix(), is(emptyString()));
            assertThat(mock.storageSettings.get("azure2").getResponseTimeout(), notNullValue());
        final MockSecureSettings secureSettings = new MockSecureSettings();
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
    public void testReinitClientEmptySettings() throws IOException {
            assertThat(service.getReadBlockSize("azure1"), is(Math.toIntExact(ByteSizeUnit.MB.toBytes(8))));
                // not setup in the test
            .put("azure.client.azure1.proxy.host", "thisisnotavalidhostorwehavebeensuperunlucky")
            assertThat(timeout, notNullValue());
    public void testTransferSettings() throws IOException {
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
            .put("azure.client.azure4.token_credential_type", token_credential_type)
        final Settings settings = Settings.builder()
            assertThat(copiedSettings.getMaxSingleUploadSize().getBytes(), is(ByteSizeUnit.MB.toBytes(32)));
            assertEquals(token_credential_type, mock.storageSettings.get("azure3").getTokenCredentialType());
            assertThat(mock.storageSettings.get("azure2").getReadTimeout(), notNullValue());
            IllegalArgumentException.class,
            .put("azure.client.azure1.token_credential_type", token_credential_type)
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount11.blob.core.windows.net"));
            "The token credential type '"
 * under the License.
import java.net.URI;
            assertThat(mock.storageSettings.get("azure2").getWriteTimeout(), equalTo(TimeValue.timeValueSeconds(60)));
            assertThat(azure1Proxy, notNullValue());
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(initialSettings)) {
        secureSettings.setString("azure.client.azure1.key", encodeKey("mykey"));
            assertThat(mock.storageSettings.get("azure2").getWriteTimeout(), notNullValue());
        try (final AzureStorageService service = storageServiceWithSettingsValidation(buildSettings())) {
        final Settings settings = Settings.builder()
                // old client 1 not changed
            assertThat(azure2Proxy, notNullValue());
            .setSecureSettings(secureSettings)
 * KIND, either express or implied.  See the License for the
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
        final Settings settings = Settings.builder()
        );
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
    public void testCreateClientWithEndpointSuffix() throws IOException {
                assertThat(client1.getAccountUrl(), equalTo("https://myaccount1.blob.my_endpoint_suffix"));
        secureSettings.setString("azure.client.azure2.account", "myaccount2");
        assertThat(name, is("path/to/myfile"));
            throw new UncheckedIOException(e);
     * {@code https://myservice.azure.net/container/path/to/myfile }
            .setSecureSettings(buildSecureSettings())
            .build();
                assertThat(e2.getMessage(), is("Unable to find client with name [azure2]"));
            );
            e.getMessage()
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
        secureSettings.setString("azure.client.azure2.account", "myaccount2");
            .setSecureSettings(secureSettings)
            final TimeValue timeout = mock.storageSettings.get("azure3").getWriteTimeout();
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
import com.azure.storage.blob.models.ParallelTransferOptions;
            .setSecureSettings(buildSecureSettings())
            .setSecureSettings(buildSecureSettings())
            .put("azure.client.azure3.connect.timeout", "25s")
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
    }
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
            .put("azure.client.azure2.token_credential_type", "managed_IDENTITY")
    }
            .build();
            final HttpPipelinePolicy policy = client.getHttpPipeline().getPolicy(i);
        secureSettings2.setString("azure.client.azure1.key", encodeKey("mykey21"));
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
            .put("azure.client.azure1.proxy.port", 8080)
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
            }
     */
        secureSettings.setString("azure.client.azure1.key", encodeKey("mykey11"));
            assertThat(copiedSettings.getWriteConcurrency(), is(4));
                expectThrows(RuntimeException.class, () -> azureStorageService.client("azure3").v1());
            .put("azure.client.azure1.read.block_size", "16mb")
                final Map<String, AzureStorageSettings> prevSettings = azureStorageService.refreshAndClearCache(Collections.emptyMap());
    public void testReloadTransferSettings() throws IOException {
    private AzureRepositoryPlugin pluginWithSettingsValidation(Settings settings) {
        );
    public void testBlobNameFromUri() throws URISyntaxException {
    }
        }
            assertThat(copiedSettings.getWriteBlockSize().getBytes(), is(ByteSizeUnit.MB.toBytes(8)));
import org.opensearch.core.common.unit.ByteSizeUnit;
    public void testSettingUnsupportedTokenCredentialForAuthentication() {
            assertThat(azureStorageService.getBlobRequestTimeout("azure3"), is(Duration.ofSeconds(30)));
            .put("azure.client.azure2.proxy.type", "http")
        secureSettings1.setString("azure.client.azure2.key", encodeKey("mykey12"));
            assertThat(azure1Proxy.getType(), is(ProxySettings.ProxyType.HTTP));
 * specific language governing permissions and limitations
            .build();
            assertEquals(mock.storageSettings.get("azure2").getProxySettings(), ProxySettings.NO_PROXY_SETTINGS);
            .setSecureSettings(secureSettings)
            .setSecureSettings(buildSecureSettings())
    }
    public void testClientDefaultConnectTimeout() throws IOException {
        // We return the remaining end of the string
            () -> storageServiceWithSettingsValidation(settings)
import reactor.netty.http.HttpResources;
            final SettingsException e = expectThrows(SettingsException.class, () -> azureStorageService.client("azure4"));
        secureSettings.setString("azure.client.azure2.account", "myaccount2");
        final Settings settings = Settings.builder()
    }
            assertThat(azure1Proxy.getAddress(), is(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8080)));
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
        }
            assertThat(azure1Proxy, notNullValue());
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
            assertThat(copiedSettings.getReadBlockSize().getBytes(), is(ByteSizeUnit.MB.toBytes(16)));
            .build();
import reactor.core.scheduler.Schedulers;
    }
            assertThat(timeout, notNullValue());
        final MockSecureSettings secureSettings3 = new MockSecureSettings();
            "azure.client.azure1.write.block_size",
        // Azure client without account key or sas token.
            .build();
    }
                assertThat(client12.getAccountUrl(), equalTo("https://myaccount12.blob.core.windows.net"));
                expectThrows(RuntimeException.class, () -> azureStorageService.client("azure2").v1());
    }
    }
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
            .put("azure.client.azure2.endpoint_suffix", "invalid endpoint suffix")
import static org.hamcrest.Matchers.equalTo;
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertEquals("Azure proxy host is unknown.", e.getMessage());
                final SettingsException e1 = expectThrows(SettingsException.class, () -> azureStorageService.client("azure3"));
import java.io.IOException;
        // Azure clients without account key and sas token.
}
 * the Apache License, Version 2.0 (the "License"); you may
        final String[] splits = path.split("/", 3);
    public void testReinitClientWrongSettings() throws IOException {
        assertThat(loadedSettings.get("azure2").getEndpointSuffix(), is(emptyString()));
        }
                assertThat(client1.getAccountUrl(), equalTo("https://myaccount1.blob.my_endpoint_suffix"));
            "azure.client.azure1.write.max_single_upload_size",
            .build();
        String name = blobNameFromUri(new URI("https://myservice.azure.net/container/path/to/myfile"));
        }
            .setSecureSettings(buildSecureSettings())
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings1)) {
            "missing required setting [azure.client.azure.account] for setting [azure.client.azure.token_credential_type]",
            .put("azure.client.azure3.endpoint_suffix", "invalid endpoint suffix")
            assertTrue(Strings.isNullOrEmpty(azure2Proxy.getPassword()));
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(buildSettings())) {
    }
        final String token_credential_type = TokenCredentialType.MANAGED_IDENTITY.name();
        return secureSettings;
            assertThat(azure1Proxy, notNullValue());
    public void testClientUsingManagedIdentity() throws IOException {
            "2gb",
        secureSettings.setString("azure.client.azure3.sas_token", encodeKey("mysastoken"));
    }
            assertThat(options, notNullValue());
 * SPDX-License-Identifier: Apache-2.0
        // Enabled Managed Identity in the settings.
import org.opensearch.test.OpenSearchTestCase;
            .build();
        final Settings timeoutSettings = Settings.builder()
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
        secureSettings3.setString("azure.client.azure1.sas_token", encodeKey("mysasToken33"));
        }
        // Azure client without account key or sas token.
                () -> pluginWithSettingsValidation(settings)
                // update client settings
        final Settings settings2 = Settings.builder().setSecureSettings(secureSettings2).build();
            .put("azure.client.azure1.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
        final MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(loadedSettings.keySet(), containsInAnyOrder("azure1", "azure2", "azure3", "default"));
    }
        secureSettings.setString("azure.client.azure3.account", "myaccount1");
import com.azure.core.http.policy.HttpPipelinePolicy;
            .put("azure.client.azure.token_credential_type", TokenCredentialType.MANAGED_IDENTITY.name())
        }
                // existing client untouched
        assertThat(name, is("path/to/myfile"));
import static org.hamcrest.Matchers.notNullValue;
        HttpResources.disposeLoopsAndConnections();
        final MockSecureSettings secureSettings = new MockSecureSettings();
        secureSettings.setString("azure.client.azure2.account", "myaccount2");
            assertThat(timeout, equalTo(TimeValue.timeValueSeconds(25)));
        secureSettings.setString("azure.client.azure2.account", "myaccount2");
                final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
        final Exception e = expectThrows(Exception.class, () -> storageServiceWithSettingsValidation(settings));
        secureSettings.setString("azure.client.azure2.account", "myaccount");
    private static RequestRetryPolicy requestRetryOptions(BlobServiceClient client) {
        final MockSecureSettings secureSettings = new MockSecureSettings();
 * You may obtain a copy of the License at
        final MockSecureSettings secureSettings = new MockSecureSettings();
    }
        final Settings settings = Settings.builder()
                IllegalArgumentException.class,
    public static void shutdownSchedulers() {
        }
    }
            .setSecureSettings(buildSecureSettings())
            assertEquals(token_credential_type, mock.storageSettings.get("azure1").getTokenCredentialType());
    private static String encodeKey(final String value) {
            assertThat(mock.storageSettings.get("azure2").getConnectTimeout(), equalTo(TimeValue.timeValueSeconds(10)));
        final MockSecureSettings secureSettings2 = new MockSecureSettings();
                    LocationMode.SECONDARY_ONLY
                assertThat(client12.getAccountUrl(), equalTo("https://myaccount12.blob.core.windows.net"));
            .setSecureSettings(buildSecureSettings())
            "5001mb"
            final Settings settings = Settings.builder().setSecureSettings(buildSecureSettings()).put(setting, 0).build();
            assertThat(service.getReadBlockSize("azure3"), is(Math.toIntExact(ByteSizeUnit.MB.toBytes(16))));
    }
        name = blobNameFromUri(new URI("http://myservice.azure.net/container/path/to/myfile"));
        return Settings.builder().setSecureSettings(buildSecureSettings()).build();
        secureSettings.setString("azure.client.azure3.key", encodeKey("mykey3"));
import org.opensearch.common.unit.TimeValue;
        try (final AzureStorageService azureStorageService = storageServiceWithSettingsValidation(buildSettings())) {
                final BlobServiceClient client1 = azureStorageService.client("azure1").v1();
        final MockSecureSettings secureSettings2 = new MockSecureSettings();
        // Azure client without account key and sas token.
            .put("azure.client.azure1.endpoint_suffix", "my_endpoint_suffix")
        // Enabled Managed Identity in the settings
        final Settings settings = Settings.builder()
    }
        secureSettings2.setString("azure.client.azure1.account", "myaccount21");
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
                IllegalArgumentException.class,
        secureSettings1.setString("azure.client.azure1.key", encodeKey("mykey11"));
            .build();
                final BlobServiceClient client11 = azureStorageService.client("azure1").v1();
            .setSecureSettings(secureSettings2)
        Schedulers.shutdownNow();
        }
import java.time.Duration;
import static org.hamcrest.Matchers.containsInAnyOrder;
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
        }
            assertThat(azureStorageService.getBlobRequestTimeout("azure1"), nullValue());
 * software distributed under the License is distributed on an
        final MockSecureSettings secureSettings1 = new MockSecureSettings();
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
            );
import java.util.Collections;
            .build();
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
            assertEquals(mock.storageSettings.get("azure").getTokenCredentialType(), "managed");
 * ownership. Elasticsearch licenses this file to you under
    private static MockSecureSettings buildSecureSettings() {
        secureSettings.setString("azure.client.azure2.key", encodeKey("mykey12"));
            .put("azure.client.azure3.write.max_concurrency", 4)
/*
            assertEquals(mock.storageSettings.get("azure3").getProxySettings(), ProxySettings.NO_PROXY_SETTINGS);
            assertThat(exception.getMessage(), containsString(setting));
     * @return The blob name relative to the container
                // new client 1 is changed
        final Settings settings = Settings.builder()
        final String path = uri.getPath();
    public void testClientDefaultWriteTimeout() throws IOException {
    public void testSettingTokenCredentialForAuthenticationWithAlternativeEnumValue() throws IOException {
            }
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount11.blob.core.windows.net"));
            final ParallelTransferOptions options = service.getBlobRequestOptionsForWriteBlob("azure3");
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
            .build();
    public void testProxyNoHost() {
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
import static org.hamcrest.Matchers.containsString;
        final Settings settings = Settings.builder().setSecureSettings(buildSecureSettings()).build();
            .put("azure.client.azure2.token_credential_type", token_credential_type)
            e.getMessage()
            assertThat(options.getBlockSizeLong(), is(ByteSizeUnit.MB.toBytes(8)));
                expectThrows(SettingsException.class, () -> azureStorageService.client("azure1").v1());
            .setSecureSettings(secureSettings)
            .put("azure.client.azure1.write.max_concurrency", 4)
            assertThat(timeout, notNullValue());
            assertThat(service.getBlobRequestOptionsForWriteBlob("azure1").getMaxConcurrency(), is(2));
    public void testSettingTokenCredentialForAuthenticationIsCaseInsensitive() throws IOException {
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
    }
        secureSettings.setString("azure.client.azure2.key", encodeKey("mykey"));
            "azure.client.azure1.read.block_size",
            assertEquals(mock.storageSettings.get("azure1").getTokenCredentialType(), "");
            () -> storageServiceWithSettingsValidation(settings2)
            assertEquals(mock.storageSettings.get("azure").getTokenCredentialType(), "managed_identity");
            .put("azure.client.azure2.token_credential_type", "x")
    public void testManagedIdentityIsEnabled() throws IOException {
            e2.getMessage()
            .build();
                + "' is unsupported, please use one of the following values: "
            .build();
package org.opensearch.repositories.azure;
            .build();
        // Enabled Managed Identity in the settings using lower case
                // existing client untouched
    public void testProxyNoPort() {
            assertEquals(mock.storageSettings.get("azure2").getTokenCredentialType(), "");
                .build();
        }
        final Settings settings = Settings.builder()
     * It should remove the container part (first part of the path) and gives path/to/myfile
            .build();
        final AzureRepositoryPlugin plugin = new AzureRepositoryPlugin(settings);
            IllegalArgumentException.class,
            .put("azure.client.azure1.proxy.host", "127.0.0.1")
        }
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
        secureSettings.setString("azure.client.azure1.account", "myaccount");
            assertEquals("user", azure1Proxy.getUsername());
            .build();
        }
            try (final AzureStorageService azureStorageService = plugin.azureStoreService) {
                plugin.reload(settings2);
        final Settings settings = Settings.builder()
        }
 * Licensed to Elasticsearch under one or more contributor
                );
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
/*
                assertThat(client11.getAccountUrl(), equalTo("https://myaccount1.blob.core.windows.net"));
            .build();
        }
            assertThat(azure2Proxy.getType(), is(ProxySettings.ProxyType.HTTP));
                service.storageSettings,
        final Settings settings2 = Settings.builder().setSecureSettings(secureSettings2).build();
            assertEquals(mock.storageSettings.get("azure1").getProxySettings(), ProxySettings.NO_PROXY_SETTINGS);
    public void testGetSelectedClientDefaultTimeout() throws IOException {
            assertThat(azure1Proxy.getAddress(), is(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8080)));
    private static Settings buildSettings() {
            .put("azure.client.azure3.write.timeout", "85s")
        secureSettings.setString("azure.client.azure3.sas_token", encodeKey("mysastoken"));
            }
            .put("azure.client.azure1.max_retries", 7)
            final IllegalArgumentException exception = expectThrows(
        }
        // Azure client account key.
            }
            "azure.client.azure1.read.block_size",
            .put("azure.client.azure1.proxy.type", "http")
            .build();
            .build();
            .put("azure.client.azure3.endpoint_suffix", "my_endpoint_suffix")
            assertEquals(ProxySettings.NO_PROXY_SETTINGS, mock.storageSettings.get("azure2").getProxySettings());
 * Unless required by applicable law or agreed to in writing,
            .put("azure.client.azure3.read.block_size", "16mb")
        );
    public void testGetSelectedClientBackoffPolicy() throws IOException {
        secureSettings.setString("azure.client.azure1.key", encodeKey("mykey1"));
        secureSettings.setString("azure.client.azure1.sas_token", encodeKey("mysastoken"));
            assertEquals(token_credential_type, mock.storageSettings.get("azure4").getTokenCredentialType());
                azureStorageService.refreshAndClearCache(newSettings);
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
            .put("azure.client.azure1.endpoint_suffix", "invalid endpoint suffix")
            .put("azure.client.azure.token_credential_type", "managed")
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings1)) {
 */
    public void testSettingTokenCredentialTypeToBeEmpty() {
        final Settings timeoutSettings = Settings.builder()
import org.junit.AfterClass;
            .setSecureSettings(secureSettings)
        final SettingsException e = expectThrows(SettingsException.class, () -> storageServiceWithSettingsValidation(settings));
    }
    public void testGetSelectedClientBackoffPolicyNbRetries() throws IOException {
        final Settings reloadedSettings = Settings.builder()
        assertEquals("Azure proxy type has been set but proxy host or port is not defined.", e.getMessage());
            // Expect token credential authentication is selected over account key or sas token.
                final MsalServiceException e = expectThrows(MsalServiceException.class, () -> client1.getAccountInfo());
        try (AzureRepositoryPlugin plugin = pluginWithSettingsValidation(settings)) {
        );
        final Settings settings = Settings.builder()
                // client 3 is missing
        secureSettings.setString("azure.client.azure.account", "myaccount");
        final Settings settings = Settings.builder()
        // Expect fall back to authentication via sas token or account key when token credential is not specified.
        final Settings settings = Settings.builder()
                assertThat(e1.getMessage(), is("Neither a secret key nor a shared access token was set."));
        final IllegalArgumentException e = expectThrows(
        final Settings settings = Settings.builder()
            assertThat(timeout, equalTo(TimeValue.timeValueMillis(1)));
                return (RequestRetryPolicy) policy;
            .setSecureSettings(buildSecureSettings())
            if (policy instanceof RequestRetryPolicy) {
 *
        final MockSecureSettings secureSettings = new MockSecureSettings();
import java.util.Base64;
        try (final AzureStorageService mock = storageServiceWithSettingsValidation(settings)) {
    }
        }
        secureSettings.setString("azure.client.azure.account", "myaccount");
    public void testTransferSettingsUseSdkDefaultsWhenUnset() throws IOException {
    private static String blobNameFromUri(URI uri) {
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
        // Azure1 with account key
        }
            assertEquals("pwd", azure1Proxy.getPassword());
                final Map<String, AzureStorageSettings> newSettings = AzureStorageSettings.overrideLocationMode(
        final MockSecureSettings secureSettings = buildSecureSettings();
        }
        secureSettings1.setString("azure.client.azure1.account", "myaccount11");
        secureSettings.setString("azure.client.azure1.account", "myaccount1");
