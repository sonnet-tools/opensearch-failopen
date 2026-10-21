                getValue(settings, clientName, ENDPOINT_SUFFIX_SETTING),
                getValue(settings, clientName, RESPONSE_TIMEOUT_SETTING),
import org.opensearch.common.collect.MapBuilder;
    /** Upload block size. The Azure SDK default is used when unset. */
        () -> KEY_SETTING
        return readTimeout;
        key -> Setting.simpleString(key, value -> {
                getValue(settings, clientName, TIMEOUT_SETTING),
            storageSettings.put("default", defaultSettings);
        assert storageSettings.containsKey("default") || storageSettings.isEmpty() : "always have 'default' if any";
        } else {
                    entry.getValue().maxRetries,
        BlockBlobAsyncClient.MAX_UPLOAD_BLOB_BYTES_LONG,
        // Validate proxy settings
 * compatible open source license.
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.common.settings.Setting.AffixSetting;
    public ByteSizeValue getMaxSingleUploadSize() {
            return new AzureStorageSettings(
        (key) -> Setting.intSetting(key, 3, Setting.Property.NodeScope),
        () -> KEY_SETTING
    ) {
    }
    }
        AZURE_CLIENT_PREFIX_KEY,
        }
    }
    public int getWriteConcurrency() {
    private final String tokenCredentialType;
        key -> SecureSetting.secureString(key, null),
        "connect.timeout",
    // See please NettyAsyncHttpClientBuilder#DEFAULT_CONNECT_TIMEOUT
            throw new SettingsException("Both a secret as well as a shared access token were set.");
        () -> PROXY_USERNAME_SETTING
    // pkg private for tests
        () -> PROXY_TYPE_SETTING
    }
    static final AffixSetting<SecureString> PROXY_USERNAME_SETTING = Setting.affixKeySetting(
        Map<String, AzureStorageSettings> clientsSettings,
    private final TimeValue connectTimeout;
    public static final AffixSetting<SecureString> ACCOUNT_SETTING = Setting.affixKeySetting(
        final boolean hasKey = Strings.hasText(key);
    static Map<String, AzureStorageSettings> overrideLocationMode(
        TimeValue readTimeout,
    }
        () -> KEY_SETTING,
import com.azure.core.util.logging.ClientLogger;
            );
        final String proxyHost = getConfigValue(settings, clientName, PROXY_HOST_SETTING);
        () -> ACCOUNT_SETTING
    }
        "proxy.type",
        AZURE_CLIENT_PREFIX_KEY,
        return timeout;
        () -> ACCOUNT_SETTING
        "proxy.password",
    public static final AffixSetting<ProxySettings.ProxyType> PROXY_TYPE_SETTING = Setting.affixKeySetting(
        final ProxySettings.ProxyType proxyType = getConfigValue(settings, clientName, PROXY_TYPE_SETTING);
        AZURE_CLIENT_PREFIX_KEY,
        AZURE_CLIENT_PREFIX_KEY,
        () -> ACCOUNT_SETTING
    }
        ByteSizeUnit.BYTES
        AZURE_CLIENT_PREFIX_KEY,
        this.readTimeout = readTimeout;
    }
        String account,
    // See please NettyAsyncHttpClientBuilder#DEFAULT_READ_TIMEOUT
    /** Azure account name */
     * Azure endpoint suffix. Default to core.windows.net (CloudStorageAccount.DEFAULT_DNS).
            value -> {
    }
            connectionStringBuilder.append(";AccountKey=").append(key);
        "response.timeout",
        String account,
    public String getEndpointSuffix() {
                getValue(settings, clientName, WRITE_BLOCK_SIZE_SETTING),
                    entry.getValue().writeConcurrency,
                return new StorageEndpoint(primaryBlobEndpoint, secondaryBlobEndpoint);
        this.tokenCredentialType = tokenCredentialType;
        if (hasSasToken == false && hasKey == false) {
        sb.append(", writeBlockSize='").append(writeBlockSize).append('\'');
        sb.append(", writeConcurrency='").append(writeConcurrency).append('\'');
            };
            final AzureStorageSettings defaultSettings = storageSettings.values().iterator().next();
        return setting.getConcreteSetting(fullKey).get(settings);
        (key) -> new Setting<>(key, "direct", s -> ProxySettings.ProxyType.valueOf(s.toUpperCase(Locale.ROOT)), Property.NodeScope),
    /** The username of a proxy to connect */
        String sasToken,
    // See please NettyAsyncHttpClientBuilder#DEFAULT_RESPONSE_TIMEOUT
import org.opensearch.common.unit.TimeValue;
        (key) -> Setting.timeSetting(key, TimeValue.timeValueMinutes(-1), Property.NodeScope),
        () -> ACCOUNT_SETTING
/*
    private static String buildConnectString(String account, @Nullable String key, @Nullable String sasToken, String endpointSuffix) {
    );
 * this work for additional information regarding copyright
        () -> ACCOUNT_SETTING,
            SecureString key = getConfigValue(settings, clientName, KEY_SETTING);
        this.proxySettings = proxySettings;
    private AzureStorageSettings(
        "account",
                String tokenCredentialEndpointSuffix = endpointSuffix;
        TimeValue responseTimeout,
                    entry.getValue().getProxySettings()
            if (Strings.hasText(value) == true) {
 * Modifications Copyright OpenSearch Contributors. See
        return sb.toString();
        final Setting<T> concreteSetting = clientSetting.getConcreteSettingForNamespace(clientName);
import org.opensearch.common.settings.Settings;
    private final TimeValue writeTimeout;
    }
        this.endpointSuffix = endpointSuffix;
    /**
        this.responseTimeout = responseTimeout;
        AZURE_CLIENT_PREFIX_KEY,
        AZURE_CLIENT_PREFIX_KEY,
            final String connectString = buildConnectString(account, key, sasToken, endpointSuffix);
    private final TimeValue responseTimeout;
 *
        if (proxyType == ProxySettings.ProxyType.DIRECT
                    throw new IllegalArgumentException("setting [" + key + "] must be -1 or at least 1b");
 * KIND, either express or implied.  See the License for the
            SecureString sasToken = getConfigValue(settings, clientName, SAS_TOKEN_SETTING)
        sb.append(", readTimeout='").append(readTimeout).append('\'');
            throw new SettingsException("Azure proxy type has been set but proxy host or port is not defined.");
                    entry.getValue().timeout,
import org.opensearch.common.settings.Setting.Property;
import java.util.Map;
        String key,
 * under the License.
        sb.append(", maxSingleUploadSize='").append(maxSingleUploadSize).append('\'');
            // in case no setting named "default" has been set, let's define our "default"
                entry.getKey(),
    /** Azure key */
                sasToken.toString(),
        key -> Setting.intSetting(key, -1, -1, value -> {
        this.account = account;
        sb.append(", endpointSuffix='").append(endpointSuffix).append('\'');
        TimeValue timeout,
        this.locationMode = LocationMode.PRIMARY_ONLY;
            && (proxyPort != 0 || Strings.hasText(proxyHost) || Strings.hasText(proxyUserName) || Strings.hasText(proxyPassword))) {
        }
import com.azure.storage.common.implementation.connectionstring.StorageEndpoint;
    // See please NettyAsyncHttpClientBuilder#DEFAULT_WRITE_TIMEOUT
    public int getMaxRetries() {
     * Parse and read all settings available under the azure.client.* namespace
    public static final AffixSetting<TimeValue> RESPONSE_TIMEOUT_SETTING = Setting.affixKeySetting(
        "proxy.username",
        connectionStringBuilder.append("DefaultEndpointsProtocol=https").append(";AccountName=").append(account);
        sb.append(", tokenCredentialType=").append(tokenCredentialType).append('\'');
        final String fullKey = k.toConcreteKey(groupName).toString();
    private final String account;
        this.timeout = timeout;
import org.opensearch.common.TriFunction;
        "max_retries",
        this.responseTimeout = responseTimeout;
    );
        sb.append(", readBlockSize='").append(readBlockSize).append('\'');
import org.opensearch.common.settings.Setting;
                    locationMode,
        LocationMode locationMode
    );
        () -> KEY_SETTING
    public ByteSizeValue getReadBlockSize() {
    private static Setting<ByteSizeValue> optionalTransferSizeSetting(String key, ByteSizeValue maxValue) {
        return writeConcurrency;
            return new ProxySettings(proxyType, proxyHostAddress, proxyPort, proxyUserName.toString(), proxyPassword.toString());
        this.endpointBuilder = endpointBuilder;
        AZURE_CLIENT_PREFIX_KEY,
 * GitHub history for details.
        key -> Setting.simpleString(key, Property.NodeScope),
    public static final AffixSetting<String> TOKEN_CREDENTIAL_TYPE_SETTING = Setting.affixKeySetting(
 * license agreements. See the NOTICE file distributed with
     * @param settings settings to parse
        }
    }
import org.opensearch.common.settings.SettingsException;
    public StorageEndpoint getStorageEndpoint(ClientLogger logger) {
    );
        return maxSingleUploadSize;
                account.toString(),
        () -> ACCOUNT_SETTING,
        sb.append(", connectTimeout='").append(connectTimeout).append('\'');
            }.build()).endpoint(endpointBuilder.apply(logger).getPrimaryUri());
        sb.append(", responseTimeout='").append(responseTimeout).append('\'');
        (key) -> Setting.intSetting(key, 0, 0, 65535, Setting.Property.NodeScope),
                new AzureStorageSettings(
    private AzureStorageSettings(
        ProxySettings proxySettings
        (key) -> Setting.timeSetting(key, TimeValue.timeValueSeconds(60), Property.NodeScope),
    /** Azure token credentials such as Managed Identity */
import com.azure.identity.ManagedIdentityCredential;
        AZURE_CLIENT_PREFIX_KEY,
        }, Property.NodeScope),
        () -> ACCOUNT_SETTING,
            throw new SettingsException("Azure proxy port or host or username or password have been set but proxy type is not defined.");
    public static final AffixSetting<ByteSizeValue> READ_BLOCK_SIZE_SETTING = Setting.affixKeySetting(
    private final int maxRetries;
        AZURE_CLIENT_PREFIX_KEY,
        ByteSizeValue readBlockSize,
        );
    private final TimeValue timeout;
        return maxRetries;
        LocationMode locationMode,
    public static Map<String, AzureStorageSettings> load(Settings settings) {
        String endpointSuffix,
        return tokenCredentialType;
    @Override
        "read.block_size",
                )
        this.timeout = timeout;
                public ManagedIdentityCredential build() {
        if (hasKey) {
        return readBlockSize;
import com.azure.storage.common.implementation.Constants;
                TokenCredentialType.valueOfType(value);
                    entry.getValue().writeTimeout,
        () -> KEY_SETTING,
                    entry.getValue().writeBlockSize,
    private static AzureStorageSettings getClientSettings(Settings settings, String clientName) {
            throw new SettingsException("Azure proxy host is unknown.", e);
                return storageConnectionString.getBlobEndpoint();
        for (final Map.Entry<String, AzureStorageSettings> entry : clientsSettings.entrySet()) {
        () -> PROXY_HOST_SETTING,
        return Collections.unmodifiableMap(storageSettings);
                key.toString(),
        () -> ACCOUNT_SETTING,
            }
        TimeValue writeTimeout,
    ) {
        }
    }
                    entry.getValue().responseTimeout,
        "read.timeout",
        "key",
    }
    public TimeValue getTimeout() {
        return connectionStringBuilder.toString();
final class AzureStorageSettings {
        this.writeTimeout = writeTimeout;
            return ProxySettings.NO_PROXY_SETTINGS;
    public String toString() {
    );
        final StringBuilder connectionStringBuilder = new StringBuilder();
    public static final AffixSetting<String> ENDPOINT_SUFFIX_SETTING = Setting.affixKeySetting(
    public TimeValue getWriteTimeout() {
    );
        (key) -> Setting.timeSetting(key, TimeValue.timeValueSeconds(60), Property.NodeScope),
    /** The password of a proxy to connect */
    );
    public TimeValue getReadTimeout() {
        }
    private final ByteSizeValue maxSingleUploadSize;
    private final ProxySettings proxySettings;
                    entry.getValue().endpointSuffix,
    private static final ByteSizeValue MAX_SINGLE_UPLOAD_SIZE = new ByteSizeValue(
    }
    );
        this.readBlockSize = readBlockSize;
            this.endpointBuilder = (logger) -> {
        }
        "timeout",
        this.maxRetries = maxRetries;
    }
    );
                    entry.getValue().clientBuilder,
        () -> ACCOUNT_SETTING,
        return writeBlockSize;
/*
        () -> ACCOUNT_SETTING,
        () -> ACCOUNT_SETTING,
            throw new SettingsException("Neither a secret key nor a shared access token was set.");
    /** Largest upload sent as one Put Blob request. The Azure SDK default is used when unset. */
    /** Azure SAS token */
    }
    }
        key -> SecureSetting.secureString(key, null)
    );
        () -> KEY_SETTING
        sb.append('}');
        () -> ACCOUNT_SETTING,
        () -> KEY_SETTING,
        this.account = account;
                    // Default to "core.windows.net".
        TimeValue connectTimeout,
     * @return All the named configurations
            // as the first named config we get
    /** The host name of a proxy to connect to azure through. */
 *    http://www.apache.org/licenses/LICENSE-2.0
    /** Maximum concurrent requests per upload. The Azure SDK default is used when unset. */
        key -> SecureSetting.secureString(key, null),
        () -> KEY_SETTING
            this.clientBuilder = (builder, executor, logger) -> builder.connectionString(connectString);
        final Map<String, AzureStorageSettings> storageSettings = new HashMap<>();
        return clientBuilder.apply(builder, executor, logger);
    public static final AffixSetting<SecureString> KEY_SETTING = Setting.affixKeySetting(
                    return super.build();
        () -> ACCOUNT_SETTING
            SecureString account = getConfigValue(settings, clientName, ACCOUNT_SETTING);
        }
import org.opensearch.core.common.Strings;
        key -> optionalTransferSizeSetting(key, AzureStorageService.MAX_CHUNK_SIZE),
            new Setting.ByteSizeValueParser(UNSET_TRANSFER_SIZE, maxValue, key),
        return locationMode;
/*
            connectionStringBuilder.append(";SharedAccessSignature=").append(sasToken);
        "write.timeout",
        "sas_token",
    }
                    tokenCredentialEndpointSuffix = Constants.ConnectionStringConstants.DEFAULT_DNS;
 * SPDX-License-Identifier: Apache-2.0
        }
    // copy-constructor
    private final ByteSizeValue writeBlockSize;
        sb.append(", maxRetries=").append(maxRetries);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final AffixSetting<TimeValue> WRITE_TIMEOUT_SETTING = Setting.affixKeySetting(
    private static <T> T getConfigValue(Settings settings, String clientName, Setting.AffixSetting<T> clientSetting) {
        this.tokenCredentialType = tokenCredentialType;
package org.opensearch.repositories.azure;
        () -> PROXY_TYPE_SETTING,
            final InetAddress proxyHostAddress = InetAddress.getByName(proxyHost);
        AZURE_CLIENT_PREFIX_KEY,
    static final AffixSetting<SecureString> PROXY_PASSWORD_SETTING = Setting.affixKeySetting(
    private static final ByteSizeValue UNSET_TRANSFER_SIZE = new ByteSizeValue(-1, ByteSizeUnit.BYTES);
        () -> PROXY_HOST_SETTING
        this.readTimeout = readTimeout;
    );
        this.endpointSuffix = endpointSuffix;
    public static final AffixSetting<String> PROXY_HOST_SETTING = Setting.affixKeySetting(
        }
        this.maxSingleUploadSize = maxSingleUploadSize;
                throw new IllegalArgumentException("setting [" + key + "] must be -1 or at least 1");
        sb.append(", writeTimeout='").append(writeTimeout).append('\'');
                getValue(settings, clientName, MAX_SINGLE_UPLOAD_SIZE_SETTING),
        key -> optionalTransferSizeSetting(key, MAX_SINGLE_UPLOAD_SIZE),
        final SecureString proxyUserName = getConfigValue(settings, clientName, PROXY_USERNAME_SETTING);
        final int proxyPort = getConfigValue(settings, clientName, PROXY_PORT_SETTING);
                getValue(settings, clientName, READ_TIMEOUT_SETTING),
        final Setting.AffixKey k = (Setting.AffixKey) setting.getRawKey();
 * specific language governing permissions and limitations
        "endpoint_suffix",
                    CredentialBuilderBaseHelper.getClientOptions(this).setExecutorService(executor);
        () -> KEY_SETTING,
import java.util.Collections;
    );
        }
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
        "write.block_size",
        String endpointSuffix,
        "write.max_concurrency",
 */
        this.maxSingleUploadSize = maxSingleUploadSize;
    }
import com.azure.identity.implementation.CredentialBuilderBaseHelper;
            }
        AZURE_CLIENT_PREFIX_KEY,
        return proxySettings;
 */
        "proxy.port",
    }
 * not use this file except in compliance with the License.
        key -> SecureSetting.secureString(key, null)
                    entry.getValue().account,
        (key) -> Setting.timeSetting(key, TimeValue.timeValueSeconds(60), Property.NodeScope),
        return responseTimeout;
        return mapBuilder.immutableMap();
    public ProxySettings getProxySettings() {
            this.endpointBuilder = (logger) -> {
    ) {
    /** The type of the proxy to connect to azure through. Can be direct (no proxy, default), http or socks */
        String tokenCredentialType,
        this.connectTimeout = connectTimeout;
        return connectTimeout;
 *
        return endpointBuilder.apply(logger);
    private final TimeValue readTimeout;
 *
        final boolean hasSasToken = Strings.hasText(sasToken);
        AZURE_CLIENT_PREFIX_KEY,
        sb.append(", proxySettings=").append(proxySettings != ProxySettings.NO_PROXY_SETTINGS ? "PROXY_SET" : "PROXY_NOT_SET");
        (key) -> Setting.simpleString(key, Property.NodeScope),
import org.opensearch.core.common.settings.SecureString;
                getValue(settings, clientName, WRITE_CONCURRENCY_SETTING),
        int writeConcurrency,
    /** Read block size. The Azure SDK default is used when unset. */
import org.opensearch.common.Nullable;
    private final int writeConcurrency;
import java.util.HashMap;
        this.proxySettings = proxySettings;
        "write.max_single_upload_size",
                if (value.getBytes() == 0L) {
            storageSettings.put(clientName, getClientSettings(settings, clientName));
        sb.append(", timeout=").append(timeout);
        (key) -> Setting.timeSetting(key, TimeValue.timeValueSeconds(10), Property.NodeScope),
        int maxRetries,
        }
     */
                    entry.getValue().readBlockSize,
 * The OpenSearch Contributors require contributions made to
        if (false == storageSettings.containsKey("default") && false == storageSettings.isEmpty()) {
                    // Use the privileged executor with IdentityClient instance
            if (value == 0) {
            );
        TimeValue timeout,
                getValue(settings, clientName, READ_BLOCK_SIZE_SETTING),
        this.clientBuilder = clientBuilder;
        () -> PROXY_TYPE_SETTING,
    );
        this.writeBlockSize = writeBlockSize;
        TimeValue connectTimeout,
        try (
import org.opensearch.common.settings.SecureSetting;
        AZURE_CLIENT_PREFIX_KEY,
        if (proxyType == ProxySettings.ProxyType.DIRECT) {
                validateAndCreateProxySettings(settings, clientName)
            this.clientBuilder = (builder, executor, logger) -> builder.credential(new ManagedIdentityCredentialBuilder() {
        key -> optionalTransferSizeSetting(key, MAX_READ_BLOCK_SIZE),
    public static final AffixSetting<TimeValue> READ_TIMEOUT_SETTING = Setting.affixKeySetting(
        AZURE_CLIENT_PREFIX_KEY,
    }
    }
        String tokenCredentialType,
    public static final AffixSetting<SecureString> SAS_TOKEN_SETTING = Setting.affixKeySetting(
        () -> ACCOUNT_SETTING
 * software distributed under the License is distributed on an
                getValue(settings, clientName, CONNECT_TIMEOUT_SETTING),
        }
        return concreteSetting.get(settings);
        ByteSizeValue maxSingleUploadSize,
        final StringBuilder sb = new StringBuilder("AzureStorageSettings{");
                if (Strings.hasText(tokenCredentialEndpointSuffix) == false) {
 * ownership. Elasticsearch licenses this file to you under
    public static final AffixSetting<Integer> MAX_RETRIES_SETTING = Setting.affixKeySetting(
            },
        ByteSizeValue writeBlockSize,
    public TimeValue getResponseTimeout() {
        key -> SecureSetting.secureString(key, null)
        AZURE_CLIENT_PREFIX_KEY,
    public String getTokenCredentialType() {
        return endpointSuffix;
            connectionStringBuilder.append(";EndpointSuffix=").append(endpointSuffix);
}
        if (proxyType != ProxySettings.ProxyType.DIRECT && (proxyPort == 0 || Strings.isEmpty(proxyHost))) {
    );
        TriFunction<BlobServiceClientBuilder, ExecutorService, ClientLogger, BlobServiceClientBuilder> clientBuilder,
        try {
        this.readBlockSize = readBlockSize;
        AZURE_CLIENT_PREFIX_KEY,
        sb.append(", locationMode='").append(locationMode).append('\'');
        () -> ACCOUNT_SETTING,
    private final ByteSizeValue readBlockSize;
import java.util.function.Function;
import java.net.UnknownHostException;
import org.opensearch.core.common.unit.ByteSizeValue;
        ProxySettings proxySettings
    }
import com.azure.storage.common.implementation.connectionstring.StorageConnectionString;
    /** The port of a proxy to connect to azure through. */
                    entry.getValue().maxSingleUploadSize,
        sb.append("account='").append(account).append('\'');
        if (hasSasToken && hasKey) {
import java.net.InetAddress;
        } else {
                getValue(settings, clientName, MAX_RETRIES_SETTING),
                    entry.getValue().connectTimeout,
        return new Setting<>(
        "proxy.host",
import java.net.URI;
        final SecureString proxyPassword = getConfigValue(settings, clientName, PROXY_PASSWORD_SETTING);
        if (Strings.hasText(tokenCredentialType) == true) {
                final URI secondaryBlobEndpoint = URI.create("https://" + account + "-secondary.blob." + tokenCredentialEndpointSuffix);
        ByteSizeValue maxSingleUploadSize,
        () -> KEY_SETTING
import java.util.Locale;
 */
    public BlobServiceClientBuilder configure(BlobServiceClientBuilder builder, ExecutorService executor, ClientLogger logger) {
    /** max_retries: Number of retries in case of Azure errors. Defaults to 3 (RetryPolicy.DEFAULT_CLIENT_RETRY_COUNT). */
    );
    /**
                }
            };
        for (final String clientName : ACCOUNT_SETTING.getNamespaces(settings)) {
                @Override
    // The overall operation timeout
        TimeValue writeTimeout,
                getValue(settings, clientName, TOKEN_CREDENTIAL_TYPE_SETTING),
    );
        this.connectTimeout = connectTimeout;
    );
        ByteSizeValue writeBlockSize,
import com.azure.storage.blob.specialized.BlockBlobAsyncClient;
    );
                    entry.getValue().tokenCredentialType,
    }
     */
 * You may obtain a copy of the License at
        this.maxRetries = maxRetries;
        this.locationMode = locationMode;
    );
    }
        }, Property.NodeScope),
 * the Apache License, Version 2.0 (the "License"); you may
    public LocationMode getLocationMode() {
    public static final AffixSetting<ByteSizeValue> MAX_SINGLE_UPLOAD_SIZE_SETTING = Setting.affixKeySetting(
    /** Parse settings for a single client. */
        return writeTimeout;
        int maxRetries,
 * Unless required by applicable law or agreed to in writing,
                final URI primaryBlobEndpoint = URI.create("https://" + account + ".blob." + tokenCredentialEndpointSuffix);
        AZURE_CLIENT_PREFIX_KEY,
    }
    public static final AffixSetting<TimeValue> TIMEOUT_SETTING = Setting.affixKeySetting(
    private static final String AZURE_CLIENT_PREFIX_KEY = "azure.client.";
        final MapBuilder<String, AzureStorageSettings> mapBuilder = new MapBuilder<>();
import com.azure.identity.ManagedIdentityCredentialBuilder;
        TimeValue readTimeout,
        Function<ClientLogger, StorageEndpoint> endpointBuilder,
                }
        this.writeBlockSize = writeBlockSize;
        () -> ACCOUNT_SETTING,
        () -> PROXY_HOST_SETTING
    );
                final StorageConnectionString storageConnectionString = StorageConnectionString.create(connectString, logger);
    private final String endpointSuffix;
        this.writeTimeout = writeTimeout;
    // prefix for azure client settings
    private static <T> T getValue(Settings settings, String groupName, Setting<T> setting) {
    static ProxySettings validateAndCreateProxySettings(final Settings settings, final String clientName) {
            Property.NodeScope
        AZURE_CLIENT_PREFIX_KEY,
    private final LocationMode locationMode;
            mapBuilder.put(
        ByteSizeValue readBlockSize,
        // Get the list of existing named configurations
    );
        "token_credential_type",
                    entry.getValue().endpointBuilder,
        } catch (final UnknownHostException e) {
    public static final AffixSetting<ByteSizeValue> WRITE_BLOCK_SIZE_SETTING = Setting.affixKeySetting(
    public ByteSizeValue getWriteBlockSize() {
        ) {
        }
        this.writeConcurrency = writeConcurrency;
                getValue(settings, clientName, WRITE_TIMEOUT_SETTING),
    public static final AffixSetting<Integer> PROXY_PORT_SETTING = Setting.affixKeySetting(
    private static final ByteSizeValue MAX_READ_BLOCK_SIZE = new ByteSizeValue(Integer.MAX_VALUE, ByteSizeUnit.BYTES);
    private final TriFunction<BlobServiceClientBuilder, ExecutorService, ClientLogger, BlobServiceClientBuilder> clientBuilder;
            UNSET_TRANSFER_SIZE.getStringRep(),
        if (Strings.hasText(endpointSuffix)) {
        TimeValue responseTimeout,
        () -> PROXY_TYPE_SETTING,
    public static final AffixSetting<TimeValue> CONNECT_TIMEOUT_SETTING = Setting.affixKeySetting(
    }
import java.util.concurrent.ExecutorService;
        this.writeConcurrency = writeConcurrency;
            key,
    private final Function<ClientLogger, StorageEndpoint> endpointBuilder;
        AZURE_CLIENT_PREFIX_KEY,
                    entry.getValue().readTimeout,
        () -> ACCOUNT_SETTING,
    public TimeValue getConnectTimeout() {
    public static final AffixSetting<Integer> WRITE_CONCURRENCY_SETTING = Setting.affixKeySetting(
        () -> KEY_SETTING
import com.azure.storage.blob.BlobServiceClientBuilder;
                }
        int writeConcurrency,
