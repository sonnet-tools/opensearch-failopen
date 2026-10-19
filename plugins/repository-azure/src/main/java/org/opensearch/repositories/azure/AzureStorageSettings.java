        // Get the list of existing named configurations  
    public TimeValue getConnectTimeout() {
        BlockBlobAsyncClient.MAX_UPLOAD_BLOB_BYTES_LONG,  
    // See please NettyAsyncHttpClientBuilder#DEFAULT_READ_TIMEOUT
        if (proxyType == ProxySettings.ProxyType.DIRECT) {
    );
            final String connectString = buildConnectString(account, key, sasToken, endpointSuffix);
package org.opensearch.repositories.azure;
    public static Map<String, AzureStorageSettings> load(Settings settings) {
        key -> SecureSetting.secureString(key, null)
            storageSettings.put("default", defaultSettings);  
        this.responseTimeout = responseTimeout;
                public ManagedIdentityCredential build() {
    );
    }  
    static ProxySettings validateAndCreateProxySettings(final Settings settings, final String clientName) {
        if (proxyType == ProxySettings.ProxyType.DIRECT  
    }
        (key) -> new Setting<>(key, "direct", s -> ProxySettings.ProxyType.valueOf(s.toUpperCase(Locale.ROOT)), Property.NodeScope),
    /** The type of the proxy to connect to azure through. Can be direct (no proxy, default), http or socks */
        TimeValue timeout,
        this.locationMode = LocationMode.PRIMARY_ONLY;
    }
 * The OpenSearch Contributors require contributions made to  
    }
 * SPDX-License-Identifier: Apache-2.0
        this.account = account;  
        return endpointSuffix;
import com.azure.core.util.logging.ClientLogger;
                )  
            }
        TimeValue connectTimeout,
                new AzureStorageSettings(  
        "write.max_concurrency",
        key -> Setting.intSetting(key, -1, -1, value -> {
import com.azure.identity.ManagedIdentityCredential;
        TimeValue writeTimeout,
        int writeConcurrency,  
/*  
    private final TimeValue readTimeout;
            return new AzureStorageSettings(
        () -> ACCOUNT_SETTING,  
        TriFunction<BlobServiceClientBuilder, ExecutorService, ClientLogger, BlobServiceClientBuilder> clientBuilder,
    // copy-constructor  
            storageSettings.put(clientName, getClientSettings(settings, clientName));  
        LocationMode locationMode,  
            value -> {  
                    entry.getValue().account,
                    entry.getValue().readBlockSize,
    );  
        () -> ACCOUNT_SETTING,  
        "read.timeout",
    public static final AffixSetting<Integer> MAX_RETRIES_SETTING = Setting.affixKeySetting(
            return new ProxySettings(proxyType, proxyHostAddress, proxyPort, proxyUserName.toString(), proxyPassword.toString());
    // pkg private for tests  
        final int proxyPort = getConfigValue(settings, clientName, PROXY_PORT_SETTING);
        (key) -> Setting.intSetting(key, 3, Setting.Property.NodeScope),
    private final ByteSizeValue writeBlockSize;
    public static final AffixSetting<ProxySettings.ProxyType> PROXY_TYPE_SETTING = Setting.affixKeySetting(
    }  
        "write.max_single_upload_size",
import org.opensearch.core.common.Strings;
        this.maxRetries = maxRetries;
     * @param settings settings to parse
        return proxySettings;
        ByteSizeValue maxSingleUploadSize,
    private final String endpointSuffix;
    /** Azure account name */
 *
                getValue(settings, clientName, READ_TIMEOUT_SETTING),  
        key -> optionalTransferSizeSetting(key, MAX_READ_BLOCK_SIZE),
            final InetAddress proxyHostAddress = InetAddress.getByName(proxyHost);
        () -> PROXY_TYPE_SETTING
        () -> ACCOUNT_SETTING,  
        AZURE_CLIENT_PREFIX_KEY,  
            }.build()).endpoint(endpointBuilder.apply(logger).getPrimaryUri());  
        LocationMode locationMode  
    public static final AffixSetting<TimeValue> WRITE_TIMEOUT_SETTING = Setting.affixKeySetting(
    private final LocationMode locationMode;
    public static final AffixSetting<TimeValue> RESPONSE_TIMEOUT_SETTING = Setting.affixKeySetting(
    public static final AffixSetting<String> TOKEN_CREDENTIAL_TYPE_SETTING = Setting.affixKeySetting(
    );
 * GitHub history for details.
    }
    }
        int maxRetries,
        this.timeout = timeout;
            };  
import org.opensearch.common.settings.Setting;
    public StorageEndpoint getStorageEndpoint(ClientLogger logger) {  
        final String fullKey = k.toConcreteKey(groupName).toString();  
        (key) -> Setting.timeSetting(key, TimeValue.timeValueSeconds(60), Property.NodeScope),
                final StorageConnectionString storageConnectionString = StorageConnectionString.create(connectString, logger);
    /** Upload block size. The Azure SDK default is used when unset. */  
    public int getMaxRetries() {  
        "write.timeout",
        }
    );  
        return connectionStringBuilder.toString();  
        final StringBuilder sb = new StringBuilder("AzureStorageSettings{");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String sasToken,  
        return endpointBuilder.apply(logger);
    private static final ByteSizeValue MAX_READ_BLOCK_SIZE = new ByteSizeValue(Integer.MAX_VALUE, ByteSizeUnit.BYTES);
    }
    }
    /**  
        AZURE_CLIENT_PREFIX_KEY,  
        () -> PROXY_USERNAME_SETTING  
    private final TimeValue connectTimeout;
        "proxy.username",
            key,  
 * Modifications Copyright OpenSearch Contributors. See
    ) {
            throw new SettingsException("Both a secret as well as a shared access token were set.");  
        sb.append(", writeTimeout='").append(writeTimeout).append('\'');
        } else {
                }  
        this.readBlockSize = readBlockSize;
        ByteSizeValue maxSingleUploadSize,
                    entry.getValue().readTimeout,
        key -> optionalTransferSizeSetting(key, AzureStorageService.MAX_CHUNK_SIZE),
     */
import java.util.Locale;  
        () -> ACCOUNT_SETTING  
        "max_retries",
        sb.append(", proxySettings=").append(proxySettings != ProxySettings.NO_PROXY_SETTINGS ? "PROXY_SET" : "PROXY_NOT_SET");
        }  
    /** Largest upload sent as one Put Blob request. The Azure SDK default is used when unset. */
    public LocationMode getLocationMode() {  
 * license agreements. See the NOTICE file distributed with
    private static <T> T getConfigValue(Settings settings, String clientName, Setting.AffixSetting<T> clientSetting) {
                    locationMode,
        final StringBuilder connectionStringBuilder = new StringBuilder();
                    entry.getValue().writeTimeout,
        TimeValue responseTimeout,
    }
        if (proxyType != ProxySettings.ProxyType.DIRECT && (proxyPort == 0 || Strings.isEmpty(proxyHost))) {
                    return super.build();
                getValue(settings, clientName, READ_BLOCK_SIZE_SETTING),
    private static String buildConnectString(String account, @Nullable String key, @Nullable String sasToken, String endpointSuffix) {
    );
                    tokenCredentialEndpointSuffix = Constants.ConnectionStringConstants.DEFAULT_DNS;
import java.net.UnknownHostException;  
    }
    public TimeValue getWriteTimeout() {
        "timeout",
            && (proxyPort != 0 || Strings.hasText(proxyHost) || Strings.hasText(proxyUserName) || Strings.hasText(proxyPassword))) {
    // prefix for azure client settings
        this.connectTimeout = connectTimeout;
    public String toString() {
    public static final AffixSetting<SecureString> SAS_TOKEN_SETTING = Setting.affixKeySetting(
 * this work for additional information regarding copyright
        this.endpointSuffix = endpointSuffix;  
                getValue(settings, clientName, TIMEOUT_SETTING),
        () -> KEY_SETTING,  
        this.writeTimeout = writeTimeout;
        this.writeConcurrency = writeConcurrency;
        ProxySettings proxySettings
        key -> SecureSetting.secureString(key, null),
            if (value == 0) {  
            // as the first named config we get
        final SecureString proxyUserName = getConfigValue(settings, clientName, PROXY_USERNAME_SETTING);  
        } catch (final UnknownHostException e) {  
        return setting.getConcreteSetting(fullKey).get(settings);
        return writeTimeout;  
        () -> PROXY_HOST_SETTING  
import java.util.Map;
                throw new IllegalArgumentException("setting [" + key + "] must be -1 or at least 1");
                if (value.getBytes() == 0L) {
        return writeBlockSize;
        return new Setting<>(
    @Override  
        () -> ACCOUNT_SETTING,
        Function<ClientLogger, StorageEndpoint> endpointBuilder,
    ) {
    }
        try (  
        key -> SecureSetting.secureString(key, null),
    );
                    // Default to "core.windows.net".  
    private AzureStorageSettings(
        sb.append('}');  
        () -> ACCOUNT_SETTING
        () -> PROXY_HOST_SETTING
        ) {
                }
        (key) -> Setting.timeSetting(key, TimeValue.timeValueSeconds(10), Property.NodeScope),
            connectionStringBuilder.append(";EndpointSuffix=").append(endpointSuffix);
    public static final AffixSetting<ByteSizeValue> READ_BLOCK_SIZE_SETTING = Setting.affixKeySetting(
        key -> Setting.simpleString(key, Property.NodeScope),  
        final boolean hasSasToken = Strings.hasText(sasToken);  
        AZURE_CLIENT_PREFIX_KEY,
        }
        () -> ACCOUNT_SETTING,  
        () -> PROXY_TYPE_SETTING,  
        AZURE_CLIENT_PREFIX_KEY,  
    public TimeValue getReadTimeout() {  
        sb.append(", locationMode='").append(locationMode).append('\'');  
    private static final ByteSizeValue UNSET_TRANSFER_SIZE = new ByteSizeValue(-1, ByteSizeUnit.BYTES);  
    // See please NettyAsyncHttpClientBuilder#DEFAULT_WRITE_TIMEOUT
        () -> KEY_SETTING
        "proxy.type",
        return tokenCredentialType;  
    );
import com.azure.storage.blob.BlobServiceClientBuilder;
            throw new SettingsException("Azure proxy host is unknown.", e);
    );
    public BlobServiceClientBuilder configure(BlobServiceClientBuilder builder, ExecutorService executor, ClientLogger logger) {  
    private final int maxRetries;  
    public static final AffixSetting<String> PROXY_HOST_SETTING = Setting.affixKeySetting(
        return timeout;  
    public static final AffixSetting<Integer> PROXY_PORT_SETTING = Setting.affixKeySetting(  
    public static final AffixSetting<SecureString> ACCOUNT_SETTING = Setting.affixKeySetting(
import com.azure.identity.ManagedIdentityCredentialBuilder;  
import org.opensearch.common.settings.Settings;
        AZURE_CLIENT_PREFIX_KEY,
    /** The port of a proxy to connect to azure through. */
                sasToken.toString(),
import java.util.function.Function;  
        () -> ACCOUNT_SETTING
        ByteSizeValue readBlockSize,
                getValue(settings, clientName, WRITE_BLOCK_SIZE_SETTING),  
        return readBlockSize;  
        this.writeTimeout = writeTimeout;
        sb.append(", readBlockSize='").append(readBlockSize).append('\'');
/*
import java.util.Collections;
    public ByteSizeValue getWriteBlockSize() {  
        AZURE_CLIENT_PREFIX_KEY,  
    public static final AffixSetting<ByteSizeValue> WRITE_BLOCK_SIZE_SETTING = Setting.affixKeySetting(
        if (hasSasToken == false && hasKey == false) {
    public static final AffixSetting<ByteSizeValue> MAX_SINGLE_UPLOAD_SIZE_SETTING = Setting.affixKeySetting(  
        sb.append(", maxRetries=").append(maxRetries);
    }  
        sb.append(", tokenCredentialType=").append(tokenCredentialType).append('\'');
        () -> ACCOUNT_SETTING,  
    ) {
                    entry.getValue().writeConcurrency,
        () -> KEY_SETTING,
    );
    private final TriFunction<BlobServiceClientBuilder, ExecutorService, ClientLogger, BlobServiceClientBuilder> clientBuilder;
import org.opensearch.common.settings.SettingsException;  
        this.writeBlockSize = writeBlockSize;
        () -> ACCOUNT_SETTING,  
            Property.NodeScope
        for (final Map.Entry<String, AzureStorageSettings> entry : clientsSettings.entrySet()) {  
final class AzureStorageSettings {
        this.connectTimeout = connectTimeout;  
    );
                    CredentialBuilderBaseHelper.getClientOptions(this).setExecutorService(executor);  
    static Map<String, AzureStorageSettings> overrideLocationMode(
                return storageConnectionString.getBlobEndpoint();  
        String tokenCredentialType,
 *
        AZURE_CLIENT_PREFIX_KEY,
        () -> ACCOUNT_SETTING,  
            this.endpointBuilder = (logger) -> {  
        sb.append(", responseTimeout='").append(responseTimeout).append('\'');
        return locationMode;
    public String getTokenCredentialType() {
    /** Azure token credentials such as Managed Identity */
        TimeValue writeTimeout,  
        final Setting.AffixKey k = (Setting.AffixKey) setting.getRawKey();
/*  
                    entry.getValue().endpointSuffix,
        () -> ACCOUNT_SETTING,  
        return concreteSetting.get(settings);
        this.clientBuilder = clientBuilder;
            throw new SettingsException("Azure proxy port or host or username or password have been set but proxy type is not defined.");
        ProxySettings proxySettings  
    // See please NettyAsyncHttpClientBuilder#DEFAULT_RESPONSE_TIMEOUT
        sb.append(", writeBlockSize='").append(writeBlockSize).append('\'');  
    private final ProxySettings proxySettings;
        "proxy.port",
 * Licensed to Elasticsearch under one or more contributor  
        "response.timeout",
        AZURE_CLIENT_PREFIX_KEY,  
                getValue(settings, clientName, MAX_SINGLE_UPLOAD_SIZE_SETTING),
        final Map<String, AzureStorageSettings> storageSettings = new HashMap<>();
}  
                    entry.getValue().connectTimeout,  
        final Setting<T> concreteSetting = clientSetting.getConcreteSettingForNamespace(clientName);  
        } else {  
 * KIND, either express or implied.  See the License for the
                }
        if (hasSasToken && hasKey) {
    // See please NettyAsyncHttpClientBuilder#DEFAULT_CONNECT_TIMEOUT
     * Parse and read all settings available under the azure.client.* namespace
        "read.block_size",
    /** Azure SAS token */  
        this.proxySettings = proxySettings;
    static final AffixSetting<SecureString> PROXY_PASSWORD_SETTING = Setting.affixKeySetting(
        this.writeConcurrency = writeConcurrency;
                    // Use the privileged executor with IdentityClient instance
        final SecureString proxyPassword = getConfigValue(settings, clientName, PROXY_PASSWORD_SETTING);
        String account,
 * the Apache License, Version 2.0 (the "License"); you may
    private static final ByteSizeValue MAX_SINGLE_UPLOAD_SIZE = new ByteSizeValue(
        this.account = account;
        () -> KEY_SETTING,  
        }, Property.NodeScope),  
    public ByteSizeValue getMaxSingleUploadSize() {
        for (final String clientName : ACCOUNT_SETTING.getNamespaces(settings)) {
    /**  
        }
    );
import org.opensearch.common.settings.Setting.AffixSetting;  
        (key) -> Setting.timeSetting(key, TimeValue.timeValueSeconds(60), Property.NodeScope),
    private final ByteSizeValue readBlockSize;  
                getValue(settings, clientName, TOKEN_CREDENTIAL_TYPE_SETTING),  
        return maxSingleUploadSize;
import com.azure.identity.implementation.CredentialBuilderBaseHelper;
        TimeValue responseTimeout,
        this.tokenCredentialType = tokenCredentialType;  
            throw new SettingsException("Azure proxy type has been set but proxy host or port is not defined.");
        AZURE_CLIENT_PREFIX_KEY,
                    entry.getValue().clientBuilder,  
        () -> ACCOUNT_SETTING
        () -> PROXY_TYPE_SETTING,
        () -> KEY_SETTING
            this.clientBuilder = (builder, executor, logger) -> builder.connectionString(connectString);  
    private static AzureStorageSettings getClientSettings(Settings settings, String clientName) {
        }  
    /** Read block size. The Azure SDK default is used when unset. */
        this.writeBlockSize = writeBlockSize;  
    public ByteSizeValue getReadBlockSize() {
                getValue(settings, clientName, MAX_RETRIES_SETTING),  
                    entry.getValue().tokenCredentialType,
        () -> PROXY_HOST_SETTING,
        () -> ACCOUNT_SETTING,
    public static final AffixSetting<TimeValue> CONNECT_TIMEOUT_SETTING = Setting.affixKeySetting(
            SecureString key = getConfigValue(settings, clientName, KEY_SETTING);
        return Collections.unmodifiableMap(storageSettings);  
        TimeValue readTimeout,
 */  
        sb.append(", endpointSuffix='").append(endpointSuffix).append('\'');  
    );
    );
        AZURE_CLIENT_PREFIX_KEY,  
    // The overall operation timeout
        TimeValue connectTimeout,
        (key) -> Setting.intSetting(key, 0, 0, 65535, Setting.Property.NodeScope),  
    private final int writeConcurrency;  
    public static final AffixSetting<TimeValue> TIMEOUT_SETTING = Setting.affixKeySetting(
                final URI primaryBlobEndpoint = URI.create("https://" + account + ".blob." + tokenCredentialEndpointSuffix);  
        AZURE_CLIENT_PREFIX_KEY,  
        () -> KEY_SETTING
        () -> KEY_SETTING
        assert storageSettings.containsKey("default") || storageSettings.isEmpty() : "always have 'default' if any";
 * compatible open source license.
                @Override  
import com.azure.storage.common.implementation.connectionstring.StorageConnectionString;
        ByteSizeUnit.BYTES
        ByteSizeValue readBlockSize,  
import java.util.HashMap;
        ByteSizeValue writeBlockSize,  
    private final TimeValue timeout;
 * software distributed under the License is distributed on an
    }
    }  
        }, Property.NodeScope),  
import org.opensearch.core.common.settings.SecureString;  
        AZURE_CLIENT_PREFIX_KEY,  
                if (Strings.hasText(tokenCredentialEndpointSuffix) == false) {
    /** Maximum concurrent requests per upload. The Azure SDK default is used when unset. */
                getValue(settings, clientName, WRITE_CONCURRENCY_SETTING),
 * Unless required by applicable law or agreed to in writing,
    );
        }
    );
                    throw new IllegalArgumentException("setting [" + key + "] must be -1 or at least 1b");
        () -> KEY_SETTING,
import org.opensearch.core.common.unit.ByteSizeValue;
        TimeValue timeout,  
        sb.append("account='").append(account).append('\'');  
        }
    public static final AffixSetting<SecureString> KEY_SETTING = Setting.affixKeySetting(  
        sb.append(", connectTimeout='").append(connectTimeout).append('\'');
        AZURE_CLIENT_PREFIX_KEY,  
        "connect.timeout",
        connectionStringBuilder.append("DefaultEndpointsProtocol=https").append(";AccountName=").append(account);  
    private final TimeValue writeTimeout;  
        return clientBuilder.apply(builder, executor, logger);
                validateAndCreateProxySettings(settings, clientName)  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.readTimeout = readTimeout;  
                    entry.getValue().getProxySettings()
        String account,
    public TimeValue getResponseTimeout() {
     */
        return connectTimeout;
        (key) -> Setting.simpleString(key, Property.NodeScope),
    );
                account.toString(),  
        sb.append(", readTimeout='").append(readTimeout).append('\'');  
            // in case no setting named "default" has been set, let's define our "default"  
        if (Strings.hasText(tokenCredentialType) == true) {
        int writeConcurrency,
        AZURE_CLIENT_PREFIX_KEY,
        () -> ACCOUNT_SETTING
        return writeConcurrency;  
import com.azure.storage.blob.specialized.BlockBlobAsyncClient;  
                    entry.getValue().endpointBuilder,
    }
            SecureString sasToken = getConfigValue(settings, clientName, SAS_TOKEN_SETTING)  
import org.opensearch.common.unit.TimeValue;
        () -> ACCOUNT_SETTING
     * Azure endpoint suffix. Default to core.windows.net (CloudStorageAccount.DEFAULT_DNS).
    }
                entry.getKey(),
        String endpointSuffix,
import java.net.URI;
        if (false == storageSettings.containsKey("default") && false == storageSettings.isEmpty()) {
        "proxy.host",
        AZURE_CLIENT_PREFIX_KEY,
    );
        () -> KEY_SETTING
    public ProxySettings getProxySettings() {
        "token_credential_type",
        () -> PROXY_TYPE_SETTING,
    public static final AffixSetting<TimeValue> READ_TIMEOUT_SETTING = Setting.affixKeySetting(
        this.readBlockSize = readBlockSize;
 * ownership. Elasticsearch licenses this file to you under  
    /** Azure key */
    private AzureStorageSettings(  
        );  
                    entry.getValue().maxRetries,
        final String proxyHost = getConfigValue(settings, clientName, PROXY_HOST_SETTING);
                    entry.getValue().writeBlockSize,
                final URI secondaryBlobEndpoint = URI.create("https://" + account + "-secondary.blob." + tokenCredentialEndpointSuffix);
        }
 * specific language governing permissions and limitations
        this.maxSingleUploadSize = maxSingleUploadSize;  
        "account",
            if (Strings.hasText(value) == true) {  
        this.proxySettings = proxySettings;  
        this.locationMode = locationMode;  
                getValue(settings, clientName, RESPONSE_TIMEOUT_SETTING),
                return new StorageEndpoint(primaryBlobEndpoint, secondaryBlobEndpoint);
    }  
    static final AffixSetting<SecureString> PROXY_USERNAME_SETTING = Setting.affixKeySetting(
    public static final AffixSetting<String> ENDPOINT_SUFFIX_SETTING = Setting.affixKeySetting(  
        if (Strings.hasText(endpointSuffix)) {  
        }
            this.endpointBuilder = (logger) -> {
    private final ByteSizeValue maxSingleUploadSize;
import org.opensearch.common.Nullable;
            }
        key -> SecureSetting.secureString(key, null)
        () -> KEY_SETTING
 * under the License.  
 * You may obtain a copy of the License at  
        (key) -> Setting.timeSetting(key, TimeValue.timeValueSeconds(60), Property.NodeScope),
            SecureString account = getConfigValue(settings, clientName, ACCOUNT_SETTING);
        }
                TokenCredentialType.valueOfType(value);
        sb.append(", maxSingleUploadSize='").append(maxSingleUploadSize).append('\'');
        ByteSizeValue writeBlockSize,
        () -> ACCOUNT_SETTING,
    }
            return ProxySettings.NO_PROXY_SETTINGS;  
        return readTimeout;
import org.opensearch.common.TriFunction;
        () -> KEY_SETTING
 * not use this file except in compliance with the License.
    private final Function<ClientLogger, StorageEndpoint> endpointBuilder;  
import com.azure.storage.common.implementation.connectionstring.StorageEndpoint;  
        (key) -> Setting.timeSetting(key, TimeValue.timeValueMinutes(-1), Property.NodeScope),
        key -> SecureSetting.secureString(key, null)  
    }
    }
    public int getWriteConcurrency() {
    );
            final AzureStorageSettings defaultSettings = storageSettings.values().iterator().next();
    public TimeValue getTimeout() {
    private static final String AZURE_CLIENT_PREFIX_KEY = "azure.client.";
    /** The username of a proxy to connect */
        String key,
        sb.append(", writeConcurrency='").append(writeConcurrency).append('\'');
        this.responseTimeout = responseTimeout;  
        final boolean hasKey = Strings.hasText(key);
        this.timeout = timeout;  
    }  
        "key",
        "sas_token",  
    }  
                key.toString(),
    }
        final MapBuilder<String, AzureStorageSettings> mapBuilder = new MapBuilder<>();
        String tokenCredentialType,  
            );
        try {  
        }
            this.clientBuilder = (builder, executor, logger) -> builder.credential(new ManagedIdentityCredentialBuilder() {
    private final String account;  
        AZURE_CLIENT_PREFIX_KEY,  
        "write.block_size",  
        this.readTimeout = readTimeout;
        return mapBuilder.immutableMap();  
                String tokenCredentialEndpointSuffix = endpointSuffix;
            throw new SettingsException("Neither a secret key nor a shared access token was set.");  
        Map<String, AzureStorageSettings> clientsSettings,
        AZURE_CLIENT_PREFIX_KEY,  
                getValue(settings, clientName, WRITE_TIMEOUT_SETTING),
        this.maxRetries = maxRetries;
        if (hasKey) {
    }
 */
        }
    private final TimeValue responseTimeout;
        this.tokenCredentialType = tokenCredentialType;
    private final String tokenCredentialType;
        AZURE_CLIENT_PREFIX_KEY,  
        this.endpointBuilder = endpointBuilder;
 *  
                    entry.getValue().responseTimeout,  
        key -> optionalTransferSizeSetting(key, MAX_SINGLE_UPLOAD_SIZE),  
        sb.append(", timeout=").append(timeout);
    public static final AffixSetting<Integer> WRITE_CONCURRENCY_SETTING = Setting.affixKeySetting(
        AZURE_CLIENT_PREFIX_KEY,
    /** max_retries: Number of retries in case of Azure errors. Defaults to 3 (RetryPolicy.DEFAULT_CLIENT_RETRY_COUNT). */
    }  
        TimeValue readTimeout,  
 */  
        return maxRetries;
        this.endpointSuffix = endpointSuffix;
import org.opensearch.common.collect.MapBuilder;  
import org.opensearch.core.common.unit.ByteSizeUnit;
    /** Parse settings for a single client. */
        "endpoint_suffix",
import java.util.concurrent.ExecutorService;
            connectionStringBuilder.append(";AccountKey=").append(key);
import org.opensearch.common.settings.Setting.Property;
                getValue(settings, clientName, ENDPOINT_SUFFIX_SETTING),
        this.maxSingleUploadSize = maxSingleUploadSize;
    /** The password of a proxy to connect */  
        // Validate proxy settings
import org.opensearch.common.settings.SecureSetting;
            },
            new Setting.ByteSizeValueParser(UNSET_TRANSFER_SIZE, maxValue, key),
        AZURE_CLIENT_PREFIX_KEY,  
                getValue(settings, clientName, CONNECT_TIMEOUT_SETTING),
        int maxRetries,
        String endpointSuffix,  
        }
        return responseTimeout;
    private static Setting<ByteSizeValue> optionalTransferSizeSetting(String key, ByteSizeValue maxValue) {
                    entry.getValue().maxSingleUploadSize,  
            mapBuilder.put(
 * this file be licensed under the Apache-2.0 license or a
import java.net.InetAddress;
    public String getEndpointSuffix() {
    /** The host name of a proxy to connect to azure through. */
        "proxy.password",  
        key -> Setting.simpleString(key, value -> {
            );
    private static <T> T getValue(Settings settings, String groupName, Setting<T> setting) {
     * @return All the named configurations  
                    entry.getValue().timeout,  
            connectionStringBuilder.append(";SharedAccessSignature=").append(sasToken);
            UNSET_TRANSFER_SIZE.getStringRep(),
        return sb.toString();
            };
    );  
import com.azure.storage.common.implementation.Constants;
    }
        final ProxySettings.ProxyType proxyType = getConfigValue(settings, clientName, PROXY_TYPE_SETTING);  
    );
