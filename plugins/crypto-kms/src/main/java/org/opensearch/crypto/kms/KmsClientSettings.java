                        ACCESS_KEY_SETTING.getKey(),
    static final Setting<SecureString> PROXY_PASSWORD_SETTING = SecureSetting.secureString("kms.proxy.password", null);  
    }  
            newCredentials,  
                PROXY_HOST_SETTING.get(settings),
import org.opensearch.common.settings.SettingsException;
            (int) newReadTimeout.millis()
        this.proxyPort = proxyPort;  
import org.apache.logging.log4j.Logger;  
}
import org.apache.logging.log4j.LogManager;
    /**
    /** The secret key (ie password) for connecting to kms. */
            );
    /** An optional password for the proxy host, for basic authentication. */
                proxyPassword.toString(),
    static final Setting<TimeValue> READ_TIMEOUT_SETTING = Setting.timeSetting(  
 * The OpenSearch Contributors require contributions made to  
    /** The access key (ie login id) for connecting to kms. */
            return new KmsClientSettings(
import org.opensearch.core.common.settings.SecureString;
            TimeValue.timeValueMillis(this.readTimeoutMillis)
import org.opensearch.common.settings.Setting.Property;  
            && Objects.equals(region, that.region)  
        this.proxyPassword = proxyPassword;
            && Objects.equals(endpoint, that.endpoint)
            && Objects.equals(proxyPassword, that.proxyPassword);
            }
    static final Setting<SecureString> SECRET_KEY_SETTING = SecureSetting.secureString("kms.secret_key", null);  
    // these should be "secure" yet the api for the kms client only takes String, so
    /** The read timeout for the kms client. */
    }
    @Override
                        ACCESS_KEY_SETTING.getKey(),  
    // as SecureString here won't really help with anything  
        int proxyPort,  
                        SESSION_TOKEN_SETTING.getKey(),
                if (key.length() == 0) {
    /** The socket timeout for connecting to kms. */
        ) {  
                    logger.debug("Using basic session credentials");
                    );
        String region,
    /** The session token for connecting to kms. */
    final int proxyPort;
        }
            return setting.get(normalizedSettings);
    final String proxyPassword;
        return readTimeoutMillis == that.readTimeoutMillis  
        return Objects.hash(readTimeoutMillis, credentials, endpoint, region, proxyHost, proxyPort, proxyUsername, proxyPassword);  
            }
                    );
            && Objects.equals(proxyUsername, that.proxyUsername)  
                    throw new SettingsException(
                }  
            && Objects.equals(proxyHost, that.proxyHost)
    final String region;
    final int readTimeoutMillis;
        Property.NodeScope  
                    throw new SettingsException(
    /** Credentials to authenticate with kms. */
    /** The password of a proxy to connect to kms through. */
        }  
            if (key.length() == 0 && secret.length() == 0) {  
    static AwsCredentials loadCredentials(Settings settings) {  
        this.proxyHost = proxyHost;
            SecureString sessionToken = SESSION_TOKEN_SETTING.get(settings)
        TimeValue newReadTimeout = getCryptoMetadataSettingOrExisting(
        if (setting.exists(normalizedSettings)) {  
                        "Setting [{}] is set but [{}] and [{}] are not",  
import org.opensearch.common.settings.Settings;
    /**
        return defaultValue;  
                REGION_SETTING.get(settings),
    final String proxyUsername;
            return true;  
            try (SecureString proxyPassword = PROXY_PASSWORD_SETTING.get(settings)) {
        final AwsCredentials credentials = loadCredentials(settings);
        int readTimeoutMillis  
            }
 * A container for settings used to create an kms client.
            SecureString proxyPassword = PROXY_PASSWORD_SETTING.get(settings)
    }
        }
            SecureString proxyUsername = PROXY_USERNAME_SETTING.get(settings);
        int newProxyPort = getCryptoMetadataSettingOrExisting(PROXY_PORT_SETTING, normalizedSettings, this.proxyPort);
    }
        );
                final AwsCredentials credentials;
import org.opensearch.common.settings.SecureSetting;
        if (this == o) {
    static final Setting<SecureString> ACCESS_KEY_SETTING = SecureSetting.secureString("kms.access_key", null);  
                        SECRET_KEY_SETTING.getKey()  
    final String endpoint;  
        }
        }
        String endpoint,  
    ) {
        this.endpoint = endpoint;  
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;  
    /** An override for the kms endpoint to connect to. */
import org.opensearch.common.unit.TimeValue;  
            && Objects.equals(credentials, that.credentials)
                        SECRET_KEY_SETTING.getKey()  
        try (  
        String proxyHost,
                    throw new SettingsException(
        AwsCredentials credentials,
    }
    /** The host name of a proxy to connect to kms through. */
    }
                    );
 * compatible open source license.
    static final Setting<Integer> PROXY_PORT_SETTING = Setting.intSetting("kms.proxy.port", 80, 0, 1 << 16, Property.NodeScope);  
        this.readTimeoutMillis = readTimeoutMillis;  
                }  
                newProxyPassword = proxyPassword.toString();  
        if (PROXY_USERNAME_SETTING.exists(normalizedSettings)) {
        this.region = region;
     * default.
    KmsClientSettings getMetadataSettings(Settings settings) {
package org.opensearch.crypto.kms;
                        "Setting [{}] is set but [{}] is not",
public class KmsClientSettings {  
            newRegion,
            SecureString secret = SECRET_KEY_SETTING.get(settings);  
 */
    static final Setting<String> ENDPOINT_SETTING = new Setting<>("kms.endpoint", "", s -> s.toLowerCase(Locale.ROOT), Property.NodeScope);  
                newProxyUsername = proxyUsername.toString();
    static final Setting<String> REGION_SETTING = new Setting<>("kms.region", "", s -> s.toLowerCase(Locale.ROOT), Property.NodeScope);  
    static final Setting<SecureString> PROXY_USERNAME_SETTING = SecureSetting.secureString("kms.proxy.username", null);  
    /** Parse settings for a single client. */  
        this.credentials = credentials;
        String proxyUsername,
        String newProxyUsername = this.proxyUsername, newProxyPassword = this.proxyPassword;
     * The kms endpoint the client should talk to, or empty string to use the  
        this.proxyUsername = proxyUsername;
                        "Setting [{}] is set but [{}] is not",  
                }
        if (o == null || getClass() != o.getClass()) {
    /** An optional proxy host that requests to kms should be made through. */
                if (secret.length() == 0) {  
    final String proxyHost;
        String newProxyHost = getCryptoMetadataSettingOrExisting(PROXY_HOST_SETTING, normalizedSettings, this.proxyHost);  
                        SECRET_KEY_SETTING.getKey()
    static KmsClientSettings getClientSettings(Settings settings) {
import java.util.Objects;
                return null;
            return false;  
    private static <T> T getCryptoMetadataSettingOrExisting(Setting<T> setting, Settings normalizedSettings, T defaultValue) {
            newProxyUsername,
     */
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
                if (sessionToken.length() > 0) {
                    credentials = AwsSessionCredentials.create(key.toString(), secret.toString(), sessionToken.toString());
            newProxyPort,
                logger.debug("Using either environment variables, system properties or instance profile credentials");
        );  
        return new KmsClientSettings(
            try (SecureString proxyUsername = PROXY_USERNAME_SETTING.get(settings)) {  
    private static final Logger logger = LogManager.getLogger(KmsClientSettings.class);  
                    credentials = AwsBasicCredentials.create(key.toString(), secret.toString());
 */  
                credentials,
            newProxyPassword,  
        final Settings normalizedSettings = Settings.builder().put(settings).normalizePrefix("kms.").build();
        AwsCredentials newCredentials = loadCredentials(settings);  
    final AwsCredentials credentials;  
            READ_TIMEOUT_SETTING,  
                (int) READ_TIMEOUT_SETTING.get(settings).millis()  
            newProxyHost,  
    static final Setting<SecureString> SESSION_TOKEN_SETTING = SecureSetting.secureString("kms.session_token", null);  
import org.opensearch.common.settings.Setting;
        "kms.read_timeout",
    );
            normalizedSettings,
                    logger.debug("Using basic key/secret credentials");
            newEndpoint,
        if (PROXY_PASSWORD_SETTING.exists(normalizedSettings)) {
            && Objects.equals(proxyPort, that.proxyPort)
        TimeValue.timeValueMillis(50_000),
    static final Setting<String> PROXY_HOST_SETTING = Setting.simpleString("kms.proxy.host", Property.NodeScope);  
    @Override  
        String proxyPassword,
        try (
    }  
    public int hashCode() {
/**  
        final KmsClientSettings that = (KmsClientSettings) o;
                return credentials;
                PROXY_PORT_SETTING.get(settings),  
            } else {  
                }
        }  
import java.util.Locale;  
    // storing them
                proxyUsername.toString(),
        ) {
        newCredentials = newCredentials == null ? this.credentials : newCredentials;
    /** The port of a proxy to connect to kms through. */
        String newEndpoint = getCryptoMetadataSettingOrExisting(ENDPOINT_SETTING, normalizedSettings, this.endpoint);
                if (sessionToken.length() == 0) {  
    protected KmsClientSettings(
/*  
 * SPDX-License-Identifier: Apache-2.0
        String newRegion = getCryptoMetadataSettingOrExisting(REGION_SETTING, normalizedSettings, this.region);
                } else {  
    /** The port number the proxy host should be connected on. */
    /** An optional username for the proxy host, for basic authentication. */
                        SECRET_KEY_SETTING.getKey(),
    public boolean equals(final Object o) {
    /** An override for the scoping region for authentication. */
 *
import software.amazon.awssdk.auth.credentials.AwsCredentials;
     */
        }
                        ACCESS_KEY_SETTING.getKey(),
     * The kms signing region.  
            SecureString key = ACCESS_KEY_SETTING.get(settings);
                ENDPOINT_SETTING.get(settings),  
    /** The username of a proxy to connect to kms through. */
 * this file be licensed under the Apache-2.0 license or a
