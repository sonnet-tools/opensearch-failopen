        final int proxyPort = getConfigValue(settings, clientName, PROXY_PORT_SETTING);  
    static final Setting.AffixSetting<SecureString> SESSION_TOKEN_SETTING = Setting.affixKeySetting(
            return Objects.hash(identityTokenFile, roleArn, roleSessionName);
            throw new SettingsException("S3 proxy type has been set but proxy host or port is not defined.");
        this.connectionTimeoutMillis = connectionTimeoutMillis;
     */
        return false;  
        PREFIX,
        PREFIX,
        "read_timeout",  
        key -> Setting.intSetting(key, 10_000, Property.NodeScope)
            && newThrottleRetries == throttleRetries  
        key -> Setting.timeSetting(key, TimeValue.timeValueMillis(50_000), Property.NodeScope)
        PREFIX,
        key -> new Setting<>(key, "https", s -> Protocol.valueOf(s.toUpperCase(Locale.ROOT)), Property.NodeScope)
        if (awsProtocol != Protocol.HTTPS && proxyType == ProxySettings.ProxyType.DIRECT && Strings.hasText(proxyHost)) {  
        IrsaCredentials(String identityTokenFile, String roleArn, String roleSessionName) {  
        key -> Setting.intSetting(key, 500, Property.NodeScope)  
        );
        }
    private static IrsaCredentials loadIrsaCredentials(Settings settings, String clientName, Path configPath) {
        int maxConnections,
        int readTimeoutMillis,
        final Settings normalizedSettings = Settings.builder()
            && Objects.equals(irsaCredentials, that.irsaCredentials);
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
            SecureString secretKey = getConfigValue(settings, clientName, SECRET_KEY_SETTING);
        key -> Setting.timeSetting(key, TimeValue.ZERO, TimeValue.ZERO, Property.NodeScope)  
            DISABLE_CHUNKED_ENCODING,
        "signer_override",
    );
     * <p>
    );
    static final Setting.AffixSetting<TimeValue> CONNECTION_TIMEOUT_SETTING = Setting.affixKeySetting(
        PREFIX,  
    static final Setting.AffixSetting<SecureString> SECRET_KEY_SETTING = Setting.affixKeySetting(
import java.net.UnknownHostException;
            && newMaxConnections == maxConnections  
        PREFIX,  
    );
    /** The maximum pending connections to S3. */
        return Collections.unmodifiableMap(clients);  
 *
            return null;
    static final Setting.AffixSetting<TimeValue> CONNECTION_ACQUISITION_TIMEOUT = Setting.affixKeySetting(
            md5ChecksumCalculation
import org.opensearch.repositories.s3.utils.Protocol;
        }
        PREFIX,  
            // which is a separate setting for AWS SDK.
                    throw new IllegalArgumentException("Missing secret key for s3 client [" + clientName + "]");
        String identityTokenFile = getConfigValue(settings, clientName, IDENTITY_TOKEN_FILE_SETTING);
        try {  
    );
                    + PROTOCOL_SETTING.getConcreteSettingForNamespace(clientName).getKey()
        final int newConnectionAcquisitionTimeoutMillis = Math.toIntExact(
import software.amazon.awssdk.auth.credentials.AwsCredentials;
        "role_arn",  
        "identity_token_file",
            newConnectionAcquisitionTimeoutMillis,
            throw new SettingsException("SOCKS proxy is not supported for HTTP protocol");
        );  
        PREFIX,
    // prefix for s3 client settings  
        );  
    final String region;
    /**
        try (  
    /**  
        "path_style_access",
    /**
        final boolean md5ChecksumCalculation = getRepoSettingOrDefault(
        this.connectionAcquisitionTimeoutMillis = connectionAcquisitionTimeoutMillis;  
    final int apiCallTimeoutMillis;
 * ownership. Elasticsearch licenses this file to you under  
            return identityTokenFile;
    /** The protocol to use to connect to s3. */  
        boolean legacyMd5ChecksumCalculation
            newCredentials = credentials;  
    /** The socket timeout for connecting to s3. */  
 *
        );
            credentials,
            maxConnections,
        this.requestTimeoutMillis = requestTimeoutMillis;  
            );  
        key -> Setting.timeSetting(key, TimeValue.timeValueMinutes(15), Property.NodeScope)
    }  
            // If the path is not absolute, resolve it relatively to config path
            getRepoSettingOrDefault(CONNECTION_TTL_SETTING, normalizedSettings, TimeValue.timeValueMillis(connectionTTLMillis)).millis()
            getConfigValue(settings, clientName, MAX_RETRIES_SETTING),
     * Note this will always at least return a client named "default".
        }
        IrsaCredentials irsaCredentials,
        key -> Setting.timeSetting(key, TimeValue.timeValueMillis(5000), Property.NodeScope)
            getConfigValue(settings, clientName, DISABLE_CHUNKED_ENCODING),
            .build();
                        + S3Repository.SECRET_KEY_SETTING.getKey()
    /** Parse settings for a single client. */  
    }  
                PROTOCOL_SETTING.getConcreteSettingForNamespace(clientName).getKey(),  
                    + PROXY_TYPE_SETTING.getConcreteSettingForNamespace(clientName).getKey()
        key -> SecureSetting.secureString(key, null)  
        key -> Setting.boolSetting(key, false, Property.NodeScope)  
            getRepoSettingOrDefault(API_CALL_TIMEOUT_SETTING, normalizedSettings, TimeValue.timeValueMillis(apiCallTimeoutMillis)).millis()
            // In this case, proxy type should be the same as a protocol,
import org.opensearch.common.unit.TimeValue;
    private static <T> T getConfigValue(Settings settings, String clientName, Setting.AffixSetting<T> clientSetting) {  
        int connectionTimeoutMillis,
    /** The s3 endpoint the client should talk to, or empty string to use the default. */  
        this.apiCallTimeoutMillis = apiCallTimeoutMillis;
            && newApiCallTimeoutMillis == apiCallTimeoutMillis  
import org.opensearch.common.settings.Settings;
            newRequestTimeoutMillis,
        final boolean newDisableChunkedEncoding = getRepoSettingOrDefault(  
                "Using of "
    static final Setting.AffixSetting<Integer> MAX_CONNECTIONS_SETTING = Setting.affixKeySetting(  
        // Validate proxy settings
    static final Setting.AffixSetting<TimeValue> CONNECTION_TTL_SETTING = Setting.affixKeySetting(
 * A container for settings used to create an S3 client.  
    final IrsaCredentials irsaCredentials;
    final int connectionAcquisitionTimeoutMillis;
    }
        this.connectionTTLMillis = connectionTTLMillis;  
                throw new IllegalArgumentException(  
            connectionTimeoutMillis,  
        "disable_chunked_encoding",
        PREFIX,
            SecureString key = S3Repository.ACCESS_KEY_SETTING.get(repositorySettings);
    );
            Math.toIntExact(getConfigValue(settings, clientName, CONNECTION_TIMEOUT_SETTING).millis()),
    @Override
        public String getRoleArn() {
        PREFIX,  
            newThrottleRetries,
        boolean throttleRetries,
    );  
            newApiCallTimeoutMillis,  
            newConnectionTimeoutMillis,
            newProtocol,  
            maxRetries,
    }  
            && proxySettings.getPort() == newProxyPort  
            && newRequestTimeoutMillis == requestTimeoutMillis
        key -> Setting.boolSetting(key, true, Property.NodeScope)
        key -> SecureSetting.secureString(key, null)
    static ProxySettings validateAndCreateProxySettings(final Settings settings, final String clientName, final Protocol awsProtocol) {  
     *
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
    ) {  
            this.roleSessionName = Strings.isNullOrEmpty(roleSessionName) ? "s3-sdk-java-" + System.currentTimeMillis() : roleSessionName;  
        return readTimeoutMillis == that.readTimeoutMillis
        final String newRegion = getRepoSettingOrDefault(REGION, normalizedSettings, region);
 * KIND, either express or implied.  See the License for the
        final Map<String, S3ClientSettings> clients = new HashMap<>();  
            requestTimeoutMillis,
    /** Credentials to authenticate with s3. */  
            return AwsBasicCredentials.create(key.toString(), secret.toString());
            return Objects.equals(identityTokenFile, that.identityTokenFile)  
        AwsCredentials credentials,
            getConfigValue(settings, clientName, LEGACY_MD5_CHECKSUM_CALCULATION)
    final ProxySettings proxySettings;
                return false;  
    /** The request timeout for connecting to s3. */
            && newConnectionAcquisitionTimeoutMillis == connectionAcquisitionTimeoutMillis
            Math.toIntExact(getConfigValue(settings, clientName, READ_TIMEOUT_SETTING).millis()),
    /** The port of a proxy to connect to s3 through. */  
            && connectionAcquisitionTimeoutMillis == that.connectionAcquisitionTimeoutMillis
import java.nio.file.Path;
        final Protocol awsProtocol = getConfigValue(settings, clientName, PROTOCOL_SETTING);
    }
    /** The request timeout for the s3 client */  
            SecureString sessionToken = getConfigValue(settings, clientName, SESSION_TOKEN_SETTING)  
            irsaCredentials,
        String endpoint,  
        this.credentials = credentials;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;  
                return true;  
        "access_key",
     */  
    /** The secret key (ie password) for connecting to s3. */  
        ) {
                        + " must be accompanied by setting ["  
        final String newEndpoint = getRepoSettingOrDefault(ENDPOINT_SETTING, normalizedSettings, endpoint);
    /** The maximum connections to s3. */
        try (  
            Math.toIntExact(getConfigValue(settings, clientName, REQUEST_TIMEOUT_SETTING).millis()),  
            newMaxSyncConnections,
        final int newMaxRetries = getRepoSettingOrDefault(MAX_RETRIES_SETTING, normalizedSettings, maxRetries);  
    /** The max number of connections for the s3 sync client */  
        key -> SecureSetting.simpleString(key, Property.NodeScope)  
        int requestTimeoutMillis,  
    static S3ClientSettings getClientSettings(final Settings settings, final String clientName, final Path configPath) {
        public boolean equals(final Object o) {
        }
    static class IrsaCredentials {
    }  
        if (proxyType == ProxySettings.ProxyType.DIRECT) {
     * @return S3ClientSettings  
            && Objects.equals(disableChunkedEncoding, that.disableChunkedEncoding)
                } else {  
        ) {  
    );  
            newRegion,
        PREFIX,  
    /** Signer override to use or empty string to use default. */  
    static final Setting.AffixSetting<TimeValue> READ_TIMEOUT_SETTING = Setting.affixKeySetting(
        "api_call_timeout",
        key -> Setting.boolSetting(key, false, Property.NodeScope)
import java.util.Objects;
    /** Whether chunked encoding should be disabled or not. */  
    );
                    + " must be accompanied by setting ["
            && newConnectionTimeoutMillis == connectionTimeoutMillis
        this.endpoint = endpoint;  
            } else {  
import java.util.Set;
            newMaxConnections,  
    /** An override for the s3 endpoint to connect to. */
        }
        int apiCallTimeoutMillis,
        this.proxySettings = proxySettings;
    static void validateInetAddressFor(final String proxyHost) {
    final int maxConnections;
            }
    static final Setting.AffixSetting<SecureString> PROXY_USERNAME_SETTING = Setting.affixKeySetting(
    /** The role ARN (Amazon Resource Name) for connecting to s3. */  
    static final Setting.AffixSetting<Protocol> PROTOCOL_SETTING = Setting.affixKeySetting(
        public int hashCode() {  
    );
        final int newConnectionTimeoutMillis = Math.toIntExact(  
            newEndpoint,
            if (o == null || getClass() != o.getClass()) {
        int maxRetries,
        key -> Setting.simpleString(key, Property.NodeScope)  
        ProxySettings.ProxyType proxyType = getConfigValue(settings, clientName, PROXY_TYPE_SETTING);
        try (
            return true;
import org.opensearch.common.settings.SettingsException;  
                "Repository setting ["
    );  
        String signerOverride,  
    static final Setting.AffixSetting<Integer> PROXY_PORT_SETTING = Setting.affixKeySetting(
            getRepoSettingOrDefault(MAX_SYNC_CONNECTIONS_SETTING, normalizedSettings, maxConnections)
        PREFIX,
    @Override
        PREFIX,
    /** Whether chunked encoding should be disabled or not (Default is false). */
/**
    private static final String PREFIX = "s3.client.";
    final int connectionTTLMillis;
        );
 * under the License.  
    static final Setting.AffixSetting<String> PROXY_HOST_SETTING = Setting.affixKeySetting(  
import org.opensearch.common.settings.Setting;  
            && requestTimeoutMillis == that.requestTimeoutMillis
        this.maxConnections = maxConnections;
    final int connectionTimeoutMillis;
    }
            && protocol == that.protocol  
                .millis()
     * Overrides the settings in this instance with settings found in repository metadata.  
            .put(repositorySettings)
            endpoint,  
import org.opensearch.common.io.PathUtils;  
}
import org.opensearch.common.settings.Setting.Property;
        PREFIX,
    static final Setting.AffixSetting<Boolean> USE_THROTTLE_RETRIES_SETTING = Setting.affixKeySetting(
    static final Setting.AffixSetting<Boolean> LEGACY_MD5_CHECKSUM_CALCULATION = Setting.affixKeySetting(  
        final boolean newPathStyleAccess = getRepoSettingOrDefault(USE_PATH_STYLE_ACCESS, normalizedSettings, pathStyleAccess);
     * Load all client settings from the given settings.  
 * not use this file except in compliance with the License.
/*
    // backcompat for reading keys out of repository settings (clusterState)  
            && throttleRetries == that.throttleRetries  
    );
        PREFIX,
            }
    );
        this.maxSyncConnections = maxSyncConnections;
    );
            disableChunkedEncoding,  
            && connectionTimeoutMillis == that.connectionTimeoutMillis
            && Objects.equals(credentials, that.credentials)
                        + "]"
import java.util.function.Function;  
            Math.toIntExact(getConfigValue(settings, clientName, API_CALL_TIMEOUT_SETTING).millis()),
    }
        if (S3Repository.ACCESS_KEY_SETTING.exists(repositorySettings)) {
        validateInetAddressFor(newProxyHost);
    /** Region to use for signing requests or empty string to use default. */  
            newMaxRetries,  
            S3ClientSettings.loadCredentials(settings, clientName),
    private static final String PLACEHOLDER_CLIENT = "placeholder";
            protocol,
    private static AwsCredentials loadCredentials(Settings settings, String clientName) {
                    + "]"  
        @Override  
            && newReadTimeoutMillis == readTimeoutMillis
    );  
package org.opensearch.repositories.s3;
        this.signerOverride = signerOverride;  
     * See please: https://docs.aws.amazon.com/eks/latest/userguide/iam-roles-for-service-accounts.html
import org.opensearch.common.settings.SecureSetting;
        if (proxyType != ProxySettings.ProxyType.DIRECT && Strings.isEmpty(proxyHost)) {
        final AwsCredentials newCredentials;
        if (proxyType == ProxySettings.ProxyType.DIRECT  
    /** The connection TTL for the s3 client */  
import org.opensearch.core.common.Strings;
        if (setting.getConcreteSettingForNamespace(PLACEHOLDER_CLIENT).exists(normalizedSettings)) {  
        final int newMaxConnections = Math.toIntExact(getRepoSettingOrDefault(MAX_CONNECTIONS_SETTING, normalizedSettings, maxConnections));
    static boolean checkDeprecatedCredentials(Settings repositorySettings) {  
        assert checkDeprecatedCredentials(repositorySettings);
        String region,
    }  
        final int newApiCallTimeoutMillis = Math.toIntExact(  
    static Map<String, S3ClientSettings> load(final Settings settings, final Path configPath) {
            newCredentials = loadDeprecatedCredentials(repositorySettings);
    final int maxSyncConnections;
        "use_throttle_retries",  
                && Objects.equals(roleArn, that.roleArn)
 * Modifications Copyright OpenSearch Contributors. See
    );  
            normalizedSettings,  
    /** The timeout for an entire S3 API call, including retries, or zero if unset. */  
            Math.toIntExact(getConfigValue(settings, clientName, MAX_SYNC_CONNECTIONS_SETTING)),
        if (o == null || getClass() != o.getClass()) {  
        }  
        "proxy.password",
        "request_timeout",
        if (checkDeprecatedCredentials(repositorySettings)) {  
        this.readTimeoutMillis = readTimeoutMillis;
        return new S3ClientSettings(  
            region,
    /** Whether retries should be throttled (ie use backoff). */  
                    throw new IllegalArgumentException("Missing access key and secret key for s3 client [" + clientName + "]");
                return new IrsaCredentials(identityTokenFile.toString(), roleArn.toString(), roleSessionName.toString());
        final boolean newThrottleRetries = getRepoSettingOrDefault(USE_THROTTLE_RETRIES_SETTING, normalizedSettings, throttleRetries);
            if (this == o) {
            && protocol == newProtocol
        final int newRequestTimeoutMillis = Math.toIntExact(  
            clients.put(clientName, getClientSettings(settings, clientName, configPath));
        PREFIX,
    /** An override for the signer to use. */
        private final String identityTokenFile;
     * @param repositorySettings found in repository metadata
                CONNECTION_ACQUISITION_TIMEOUT,  
    final boolean pathStyleAccess;
/*  
    /** The identity token file for connecting to s3. */
            connectionAcquisitionTimeoutMillis,  
    static final Setting.AffixSetting<Boolean> DISABLE_CHUNKED_ENCODING = Setting.affixKeySetting(  
public final class S3ClientSettings {
        int connectionAcquisitionTimeoutMillis,  
        this.protocol = protocol;
            proxyType = ProxySettings.ProxyType.valueOf(awsProtocol.name());
        }  
        );
import java.net.InetAddress;  
        this.region = region;
    );
        validateInetAddressFor(proxyHost);
        "proxy.port",  
        final String proxyHost = getConfigValue(settings, clientName, PROXY_HOST_SETTING);
    // pkg private for tests
    );
        PREFIX,  
    /** Whether the s3 client should use an exponential backoff retry policy. */  
        "max_retries",
                }  
            signerOverride
            throw new SettingsException("S3 proxy port or host or username or password have been set but proxy type is not defined.");
        this.irsaCredentials = irsaCredentials;
            && Objects.equals(region, newRegion)
        int connectionTTLMillis,  
    static final Setting.AffixSetting<String> ENDPOINT_SETTING = Setting.affixKeySetting(  
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
        PREFIX,  
            && newConnectionTTLMillis == connectionTTLMillis
        this.maxRetries = maxRetries;
        key -> SecureSetting.secureString(key, null)
            apiCallTimeoutMillis,
            disableChunkedEncoding  
        final int newConnectionTTLMillis = Math.toIntExact(
        // Normalize settings to placeholder client settings prefix so that we can use the affix settings directly  
            readTimeoutMillis,  
    final boolean disableChunkedEncoding;
        PREFIX,
        this.legacyMd5ChecksumCalculation = legacyMd5ChecksumCalculation;
        final int newMaxSyncConnections = Math.toIntExact(  
            // this won't find any settings under the default client,
    private static AwsCredentials loadDeprecatedCredentials(Settings repositorySettings) {
    );
            return ProxySettings.NO_PROXY_SETTINGS;
    }  
            return false;
    /** The role session name for connecting to s3. */
    private S3ClientSettings(  
 * Licensed to Elasticsearch under one or more contributor  
        return defaultValue;  
        if (identityTokenFile.length() != 0) {  
    );
    /** The host name of a proxy to connect to s3 through. */
    );
        PREFIX,
        return new S3ClientSettings(
            && Objects.equals(proxySettings.getHostName(), newProxyHost)
        final Protocol newProtocol = getRepoSettingOrDefault(PROTOCOL_SETTING, normalizedSettings, protocol);
        key -> Setting.intSetting(key, 3, 0, Property.NodeScope)  
    }  
    final boolean throttleRetries;
        "max_connections",
            newPathStyleAccess,
        PREFIX,
        key -> SecureSetting.secureString(key, null)
            getRepoSettingOrDefault(
                    + " as proxy type is deprecated and will be removed in future releases. Please use "  
 * license agreements. See the NOTICE file distributed with
    static final Setting.AffixSetting<Boolean> USE_PATH_STYLE_ACCESS = Setting.affixKeySetting(
                if (secretKey.length() != 0) {  
        key -> Setting.timeSetting(key, TimeValue.timeValueMinutes(5), Property.NodeScope)
            throw new IllegalArgumentException(
            connectionTTLMillis,
            && newPathStyleAccess == pathStyleAccess
    /** Whether to use the legacy MD5 checksum calculation when uploading files to S3. */  
        Protocol protocol,
    }  
                    + " instead to specify proxy type."
        this.disableChunkedEncoding = disableChunkedEncoding;
import java.util.Map;  
            getRepoSettingOrDefault(REQUEST_TIMEOUT_SETTING, normalizedSettings, TimeValue.timeValueMillis(requestTimeoutMillis)).millis()
        }
            legacyMd5ChecksumCalculation
        PREFIX,  
        "protocol",  
        PREFIX,
            newDisableChunkedEncoding,  
            clients.put("default", getClientSettings(settings, "default", configPath));
        }  
    /** The protocol to use to talk to s3. Defaults to https. */  
        }
            if (accessKey.length() != 0) {
            return getConfigValue(normalizedSettings, PLACEHOLDER_CLIENT, setting);
 * compatible open source license.
    final String endpoint;
    final Protocol protocol;
    static final Setting.AffixSetting<SecureString> ROLE_ARN_SETTING = Setting.affixKeySetting(
    );
            getConfigValue(settings, clientName, REGION),
            if (S3Repository.SECRET_KEY_SETTING.exists(repositorySettings) == false) {
    static final Setting.AffixSetting<SecureString> ROLE_SESSION_NAME_SETTING = Setting.affixKeySetting(
                        return AwsBasicCredentials.create(accessKey.toString(), secretKey.toString());
    static final Setting.AffixSetting<String> IDENTITY_TOKEN_FILE_SETTING = Setting.affixKeySetting(  
            newReadTimeoutMillis,
                        return AwsSessionCredentials.create(accessKey.toString(), secretKey.toString(), sessionToken.toString());
            final IrsaCredentials that = (IrsaCredentials) o;
    /** An optional proxy settings that requests to s3 should be made through. */  
            Math.toIntExact(getConfigValue(settings, clientName, MAX_CONNECTIONS_SETTING)),
 */  
            this.roleArn = Strings.isNullOrEmpty(roleArn) ? null : roleArn;
        "region",  
        @Override
            getConfigValue(settings, clientName, USE_PATH_STYLE_ACCESS),  
        ) {
    final boolean legacyMd5ChecksumCalculation;
            && Objects.equals(signerOverride, newSignerOverride)
        boolean pathStyleAccess,  
        if (Objects.equals(endpoint, newEndpoint)  
 */  
        key -> new Setting<>(key, "", Function.identity(), Property.NodeScope)
    );  
        "session_token",
 * this work for additional information regarding copyright
        final SecureString proxyUserName = getConfigValue(settings, clientName, PROXY_USERNAME_SETTING);
        }  
                if (secretKey.length() != 0) {
            Math.toIntExact(getConfigValue(settings, clientName, CONNECTION_ACQUISITION_TIMEOUT).millis()),  
        "proxy.username",
        }
    /** The username of a proxy to connect to s3 through. */
        public String getRoleSessionName() {
                    "Repository setting ["
    /** The connection TTL for connecting to s3. */
    public int hashCode() {  
        key -> Setting.intSetting(key, 500, Property.NodeScope)  
            return true;
        "max_pending_connection_acquires",
    static final Setting.AffixSetting<SecureString> PROXY_PASSWORD_SETTING = Setting.affixKeySetting(  
        this.pathStyleAccess = pathStyleAccess;  
        boolean disableChunkedEncoding,
                    + S3Repository.SECRET_KEY_SETTING.getKey()  
            Math.toIntExact(getConfigValue(settings, clientName, CONNECTION_TTL_SETTING).millis()),  
            newCredentials,  
 * SPDX-License-Identifier: Apache-2.0
                identityTokenFile = PathUtils.get(new Path[] { configPath }, identityTokenFile).toString();
            }
 * Unless required by applicable law or agreed to in writing,
    /** Placeholder client name for normalizing client settings in the repository settings. */  
            this.identityTokenFile = Strings.isNullOrEmpty(identityTokenFile) ? null : identityTokenFile;
        final String newProxyHost = getRepoSettingOrDefault(PROXY_HOST_SETTING, normalizedSettings, proxySettings.getHostName());  
    }
    /** The protocol to use to connect to s3. */
            S3ClientSettings.loadIrsaCredentials(settings, clientName, configPath),
        key -> SecureSetting.secureString(key, null)
        }  
    );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** An override for the s3 region to use for signing requests. */  
    final int requestTimeoutMillis;
        int maxSyncConnections,
    S3ClientSettings refine(Settings repositorySettings) {
            throw new SettingsException("S3 proxy host is unknown.", e);  
        );  
    final int readTimeoutMillis;
        key -> new Setting<>(key, "", Function.identity(), Property.NodeScope)
                && Objects.equals(roleSessionName, that.roleSessionName);
 * the Apache License, Version 2.0 (the "License"); you may
    /** The connnection acquisition timeout for the s3 sync and async client */  
        final Setting<T> concreteSetting = clientSetting.getConcreteSettingForNamespace(clientName);
        final S3ClientSettings that = (S3ClientSettings) o;  
                    }
    /** An override for the s3 region to use for signing requests. */
            return this;
        }
            getConfigValue(settings, clientName, ENDPOINT_SETTING),  
        final Set<String> clientNames = settings.getGroups(PREFIX).keySet();
        if (clients.containsKey("default") == false) {
            getRepoSettingOrDefault(CONNECTION_TIMEOUT_SETTING, normalizedSettings, TimeValue.timeValueMillis(connectionTimeoutMillis))
    /** The connection timeout for the s3 client */  
            // This is backward compatibility for the current behaviour.
    final AwsCredentials credentials;
        for (final String clientName : clientNames) {
        return new ProxySettings(proxyType, proxyHost, proxyPort, proxyUserName.toString(), proxyPassword.toString());
        final int newReadTimeoutMillis = Math.toIntExact(  
        }
        }
    /** The read timeout for the s3 client. */  
        } catch (final UnknownHostException e) {
        key -> Setting.boolSetting(key, false, Property.NodeScope)  
        "proxy.type",
        if (awsProtocol == Protocol.HTTP && proxyType == ProxySettings.ProxyType.SOCKS) {
            newSignerOverride,
import org.opensearch.core.common.settings.SecureString;  
    /** The number of retries to use when an s3 request fails. */
            && Objects.equals(md5ChecksumCalculation, this.legacyMd5ChecksumCalculation)) {  
    static final Setting.AffixSetting<SecureString> ACCESS_KEY_SETTING = Setting.affixKeySetting(  
    /** Credentials to authenticate with s3 using IAM Roles for Service Accounts (IRSA). */  
    final String signerOverride;
        "connection_acquisition_timeout",  
    static final Setting.AffixSetting<TimeValue> REQUEST_TIMEOUT_SETTING = Setting.affixKeySetting(
            && Objects.equals(endpoint, that.endpoint)
        }
    /** The timeout for an entire S3 API call, including retries. Zero leaves the SDK timeout unset. */
            getRepoSettingOrDefault(READ_TIMEOUT_SETTING, normalizedSettings, TimeValue.timeValueMillis(readTimeoutMillis)).millis()
            LEGACY_MD5_CHECKSUM_CALCULATION,
            }
        this.throttleRetries = throttleRetries;
        );
        key -> SecureSetting.secureString(key, null)  
                    if (sessionToken.length() != 0) {
            && connectionTTLMillis == that.connectionTTLMillis
                    + S3Repository.ACCESS_KEY_SETTING.getKey()
        );
    );  
    );
            && proxySettings.equals(that.proxySettings)
 * specific language governing permissions and limitations
                    throw new IllegalArgumentException("Missing access key for s3 client [" + clientName + "]");
    public boolean equals(final Object o) {
import java.util.Collections;  
     */  
    final int maxRetries;
        return concreteSetting.get(settings);
            final Path identityTokenFilePath = PathUtils.get(identityTokenFile);
        "connection_ttl",
                normalizedSettings,
    );
        private final String roleSessionName;
            }
            SecureString roleArn = getConfigValue(settings, clientName, ROLE_ARN_SETTING);  
    static final Setting.AffixSetting<Integer> MAX_SYNC_CONNECTIONS_SETTING = Setting.affixKeySetting(  
        key -> Setting.intSetting(key, 80, 0, (1 << 16) - 1, Property.NodeScope)
    static final Setting.AffixSetting<ProxySettings.ProxyType> PROXY_TYPE_SETTING = Setting.affixKeySetting(
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(S3ClientSettings.class);
        key -> new Setting<>(key, "", s -> s.toLowerCase(Locale.ROOT), Property.NodeScope)  
        "legacy_md5_checksum_calculation",
                return null;
        "secret_key",  
                }  
        PREFIX,
 * this file be licensed under the Apache-2.0 license or a
    static final Setting.AffixSetting<String> SIGNER_OVERRIDE = Setting.affixKeySetting(
        PREFIX,  
            SecureString roleSessionName = getConfigValue(settings, clientName, ROLE_SESSION_NAME_SETTING)
    /** Connection acquisition timeout for new connections to S3. */  
    );
    /** The access key (ie login id) for connecting to s3. */
            && maxConnections == that.maxConnections  
            if (identityTokenFile.length() != 0 || roleArn.length() != 0 || roleSessionName.length() != 0) {  
                        + S3Repository.ACCESS_KEY_SETTING.getKey()
            && Objects.equals(region, that.region)  
        PREFIX,
    private static <T> T getRepoSettingOrDefault(Setting.AffixSetting<T> setting, Settings normalizedSettings, T defaultValue) {
    static final Setting.AffixSetting<TimeValue> API_CALL_TIMEOUT_SETTING = Setting.affixKeySetting(  
        );  
        if (this == o) {  
    @SuppressForbidden(reason = "PathUtils#get")  
        }  
        PREFIX,
    /** Whether the s3 client should use path style access. */  
        "role_session_name",
     * Class to store IAM Roles for Service Accounts (IRSA) credentials
            getConfigValue(settings, clientName, USE_THROTTLE_RETRIES_SETTING),
                    } else {  
    static final Setting.AffixSetting<String> REGION = Setting.affixKeySetting(
    );
import org.opensearch.common.SuppressForbidden;
        PREFIX,
            normalizedSettings,
            // The default value for Protocol settings is HTTPS,
        public String getIdentityTokenFile() {  
    // Properties to support using IAM Roles for Service Accounts (IRSA)  
    /** The password of a proxy to connect to s3 through. */
            }
            proxySettings,
            && apiCallTimeoutMillis == that.apiCallTimeoutMillis  
        key -> Setting.timeSetting(key, TimeValue.timeValueSeconds(10), Property.NodeScope)
        final int newProxyPort = getRepoSettingOrDefault(PROXY_PORT_SETTING, normalizedSettings, proxySettings.getPort());
            && newDisableChunkedEncoding == disableChunkedEncoding  
    /** The secret key (ie password) for connecting to s3. */
 * You may obtain a copy of the License at  
import org.opensearch.common.logging.DeprecationLogger;
    );  
        return Objects.hash(
                TimeValue.timeValueMillis(connectionAcquisitionTimeoutMillis)
 *  
        "endpoint",
        }  
import java.util.Locale;
        } else if (S3Repository.SECRET_KEY_SETTING.exists(repositorySettings)) {  
    }
        private final String roleArn;  
        }
                }
            .normalizePrefix(PREFIX + PLACEHOLDER_CLIENT + '.')  
                );  
            SecureString secret = S3Repository.SECRET_KEY_SETTING.get(repositorySettings)
            getConfigValue(settings, clientName, SIGNER_OVERRIDE),  
            InetAddress.getByName(proxyHost);
        } else {
            deprecationLogger.deprecate(
            validateAndCreateProxySettings(settings, clientName, awsProtocol),
            newConnectionTTLMillis,
    static final Setting.AffixSetting<Integer> MAX_RETRIES_SETTING = Setting.affixKeySetting(  
        "max_sync_connections",
            return roleArn;
            ).millis()  
        "connection_timeout",  
 * GitHub history for details.
            && Objects.equals(signerOverride, that.signerOverride)
            // when proxy host and port have been set  
    static final Setting.AffixSetting<Integer> MAX_PENDING_CONNECTION_ACQUIRES = Setting.affixKeySetting(
        final String newSignerOverride = getRepoSettingOrDefault(SIGNER_OVERRIDE, normalizedSettings, signerOverride);  
        );
/*  
            SecureString accessKey = getConfigValue(settings, clientName, ACCESS_KEY_SETTING);
            && Objects.equals(credentials, newCredentials)
            && maxRetries == newMaxRetries
        }  
        }
            return roleSessionName;  
    /** Whether the s3 client should use path style access. */
    }
        );
        key -> new Setting<>(key, "direct", s -> ProxySettings.ProxyType.valueOf(s.toUpperCase(Locale.ROOT)), Property.NodeScope)
    /** The max number of connections for the s3 async client */  
        key -> SecureSetting.secureString(key, null)
 */
            && (proxyPort != 80 || Strings.hasText(proxyHost) || Strings.hasText(proxyUserName) || Strings.hasText(proxyPassword))) {
            if (!identityTokenFilePath.isAbsolute()) {  
        PREFIX,
            // but it will pull all the fallback static settings  
    /** The number of retries to use for the s3 client. */  
            // The expectation of ex-developers that protocol is the same as the proxy protocol  
            );
        "proxy.host",
        PREFIX,
import java.util.HashMap;
            proxySettings.recreateWithNewHostAndPort(newProxyHost, newProxyPort),  
        ProxySettings proxySettings,
    /** The connection timeout for connecting to s3. */  
            && maxRetries == that.maxRetries
 */
                if (sessionToken.length() != 0) {
            awsProtocol,
            throttleRetries,
        final SecureString proxyPassword = getConfigValue(settings, clientName, PROXY_PASSWORD_SETTING);
