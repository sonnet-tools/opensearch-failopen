                TRUSTSTORE_TYPE,  
                return EMPTY_PASSWORD;
import java.util.Objects;
    }
                inferStoreType(keyStorePath.toString().toLowerCase(Locale.ROOT))  
        }  
    /**
        }
    private SslKeyConfig defaultKeyConfig;
            ciphers.add("TLS_RSA_WITH_AES_128_GCM_SHA256");
        }
        } else {
import java.util.Arrays;
    private List<String> defaultCiphers;
     *                      {@code "reindex.ssl.verification_mode"}, and those same keys will be reported in error messages (via
    static final List<String> DEFAULT_PROTOCOLS = KeyStoreUtil.IN_FIPS_MODE
     *                   {@link SslConfigException} before being rethrown.  
                "cannot specify both [" + settingPrefix + CERTIFICATE_AUTHORITIES + "] and [" + settingPrefix + TRUSTSTORE_PATH + "]"  
        }  
        if (has256BitAES) {
     */
        this.defaultVerificationMode = defaultVerificationMode;  
    protected abstract String getSettingAsString(String key) throws Exception;
     * @throws SslConfigException For any problems with the configuration, or with loading the required SSL classes.  
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
 * GitHub history for details.
     * The initial key config is {@link EmptyKeyConfig}, which does not provide any keys
                    "TLS_RSA_WITH_AES_128_CBC_SHA"  
            throw new SslConfigException(
    /**  
            }
        final char[] securePassword = resolveSecureSetting(secureSettingKey, null);
            if (setting == null || setting.isEmpty()) {
 * ownership. Elasticsearch licenses this file to you under  
        }
     * Clients of this class should implement this method to load a fully-qualified key from the preferred secure settings source.
     */
     * @throws Exception If a {@link RuntimeException} is thrown, it will be rethrown unwrapped. All checked exceptions are wrapped in
import static org.opensearch.common.ssl.SslConfigurationKeys.VERIFICATION_MODE;  
    /**
        }
        final Path trustStorePath = resolveSetting(TRUSTSTORE_PATH, basePath::resolve, null);
import static org.opensearch.common.ssl.KeyStoreUtil.inferStoreType;  
                return securePassword;  
            ciphers.add("TLS_AES_256_GCM_SHA384");
        }
    static final List<String> DEFAULT_CIPHERS = loadDefaultCiphers();
    }
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
                KEYSTORE_TYPE,
     * The setting should be returned as a string, and this class will convert it to the relevant type.  
     * The initial protocol list is defined by {@link #DEFAULT_PROTOCOLS}
        } catch (RuntimeException e) {  
 * @see SslConfigurationKeys  
            throw new SslConfigException("cannot retrieve secure setting [" + settingPrefix + key + "]", e);
    private SslTrustConfig defaultTrustConfig;
            }
                return legacyPassword.toCharArray();
 * @see SslConfiguration
     */
     * This method will be called for basic string settings (see {@link SslConfigurationKeys#getStringKeys()}).
        }  
                Arrays.asList(
     */
    private <V> List<V> resolveListSetting(String key, Function<String, V> parser, List<V> defaultValue) {
        this.defaultVerificationMode = SslVerificationMode.FULL;  
 * this file be licensed under the Apache-2.0 license or a
        this.defaultClientAuth = defaultClientAuth;
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"
        // use GCM: PFS, AEAD, hardware support
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void setDefaultCiphers(List<String> defaultCiphers) {
     * <p>
import static org.opensearch.common.ssl.SslConfigurationKeys.CIPHERS;  
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_PATH;  
     *                   {@link SslConfigException} before being rethrown.
     *
        try {
     */
/*  
            throw new SslConfigException("no cipher suites configured in [" + settingPrefix + CIPHERS + "]");
     * Resolve all necessary configuration settings, and load a {@link SslConfiguration}.
                throw new SslConfigException(
import static org.opensearch.common.ssl.SslConfigurationKeys.KEY_LEGACY_PASSPHRASE;
 *
     */  
        } else {  
     * This method will be called for any setting keys that are marked as being  
import java.util.stream.Collectors;
    }
     * The initial verification mode is {@link SslVerificationMode#FULL}.  
    private SslTrustConfig buildTrustConfig(Path basePath, SslVerificationMode verificationMode) {  
     * Change the default key config.  
            return new StoreKeyConfig(keyStorePath, storePassword, storeType, keyPassword, algorithm);  
     *                 configuration directory.
    public void setDefaultKeyConfig(SslKeyConfig defaultKeyConfig) {  
            // No AES? Things are going to be very weird, but technically that means we don't have 256 bit AES, so ...
                throw new SslConfigException(
            char[] setting = getSecureSetting(settingPrefix + key);  
 * and these defaults can be overridden through the various {@code setDefaultXyz} methods.
        if (has256BitAES) {
            throw new IllegalArgumentException("Setting prefix [" + settingPrefix + "] must be blank or end in '.'");
 * not use this file except in compliance with the License.
        final String legacyPassword = resolveSetting(legacySettingKey, Function.identity(), null);
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_PATH;  
    }
                return defaultValue;  
    private SslKeyConfig buildKeyConfig(Path basePath) {
            if (list == null || list.isEmpty()) {
            final char[] password = resolvePasswordSetting(KEY_SECURE_PASSPHRASE, KEY_LEGACY_PASSPHRASE);
            }
    private SslVerificationMode defaultVerificationMode;  
import static org.opensearch.common.ssl.SslConfigurationKeys.PROTOCOLS;  
    /**
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
            return Cipher.getMaxAllowedKeyLength("AES") > 128;
    private static boolean has256BitAES() {  
        ciphers.add("TLS_AES_128_GCM_SHA256");  
import java.util.List;  
                )
        this.settingPrefix = settingPrefix == null ? "" : settingPrefix;  
            final String storeType = resolveSetting(  
        this.defaultKeyConfig = EmptyKeyConfig.INSTANCE;
            );
 * specific language governing permissions and limitations
                throw new SslConfigException(
            } else {  
            throw new SslConfigException("cannot retrieve setting [" + settingPrefix + key + "]", e);
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_TYPE;
     * Construct a new loader with the "standard" default values.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.function.Function;  
        try {
        }  
            );
                )  
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"
        this.defaultClientAuth = SslClientAuthenticationMode.OPTIONAL;
        }  
            final String algorithm = resolveSetting(TRUSTSTORE_ALGORITHM, Function.identity(), TrustManagerFactory.getDefaultAlgorithm());
                "cannot specify both [" + settingPrefix + CERTIFICATE + "] and [" + settingPrefix + KEYSTORE_PATH + "]"
        }
        if (certificateAuthorities != null && trustStorePath != null) {
    /**
     *                      {@link SslConfigException}).  
            throw e;  
        if (certificatePath != null && keyStorePath != null) {  
        return defaultTrustConfig;
        }
     * Change the default SSL/TLS protocol list.
            if (keyPassword.length == 0) {  
    }  
            final String algorithm = resolveSetting(KEYSTORE_ALGORITHM, Function.identity(), KeyManagerFactory.getDefaultAlgorithm());
        }
        } catch (RuntimeException e) {
 * Licensed to Elasticsearch under one or more contributor  
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",  
                    "TLS_RSA_WITH_AES_256_CBC_SHA",
     * @throws Exception If a {@link RuntimeException} is thrown, it will be rethrown unwrapped. All checked exceptions are wrapped in  
/**
import javax.crypto.Cipher;
     * {@link SslConfigurationKeys#getSecureStringKeys() secure} settings.
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        this.defaultCiphers = DEFAULT_CIPHERS;  
            throw new SslConfigException(
                Arrays.asList(
        // use GCM: AEAD, hardware support
 * the underlying setting source must be handled by the code that makes use of this class.  
            return TrustEverythingConfig.TRUST_EVERYTHING;
    /**
import java.security.NoSuchAlgorithmException;  
            );  
    /**
    }
    private char[] resolvePasswordSetting(String secureSettingKey, String legacySettingKey) {  
            throw e;
    }
    }  
            ciphers.addAll(
                Function.identity(),
        }
            return new StoreTrustConfig(trustStorePath, password, storeType, algorithm);
            }
 * Unless required by applicable law or agreed to in writing,
     * The initial client auth mode is {@link SslClientAuthenticationMode#OPTIONAL}.
                return defaultValue;
        }
        // PFS, hardware support  
     * The initial trust config is {@link DefaultJdkTrustConfig}, which trusts the JDK's default CA certs
    private List<String> defaultProtocols;  
        if (keyStorePath != null) {  
            );
        } catch (Exception e) {
            final List<String> list = getSettingAsList(settingPrefix + key);  
    private SslClientAuthenticationMode defaultClientAuth;
            if (setting == null || setting.length == 0) {
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"
     *
        } catch (RuntimeException e) {
import static org.opensearch.common.ssl.SslConfigurationKeys.KEY_SECURE_PASSPHRASE;
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        this.defaultKeyConfig = defaultKeyConfig;
     * Clients of this class should implement this method to load a fully-qualified key from the preferred settings source.  
            ciphers.addAll(  
        final List<String> ciphers = resolveListSetting(CIPHERS, Function.identity(), defaultCiphers);
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_SECURE_KEY_PASSWORD;
            if (certificatePath == null) {  
            }
import static org.opensearch.common.ssl.SslConfigurationKeys.CERTIFICATE_AUTHORITIES;
        final Path keyStorePath = resolveSetting(KEYSTORE_PATH, basePath::resolve, null);
    }  
            }  
            ciphers.addAll(  
            }  
     * The setting should be returned as a list of strings, and this class will convert the values to the relevant type.  
    /**
        final SslTrustConfig trustConfig = buildTrustConfig(basePath, verificationMode);  
 * (as well as being aware of dependencies and conflicts between different settings).
        } catch (Exception e) {
    public void setDefaultClientAuth(SslClientAuthenticationMode defaultClientAuth) {
            );
     * Change the default verification mode.
                return defaultValue;
        if (verificationMode.isCertificateVerificationEnabled() == false) {  
        }
    private final String settingPrefix;
}
        this.defaultCiphers = defaultCiphers;  
                );  
        final List<String> protocols = resolveListSetting(PROTOCOLS, Function.identity(), defaultProtocols);
                    "cannot specify both [" + settingPrefix + secureSettingKey + "] and [" + settingPrefix + legacySettingKey + "]"  
        if (this.settingPrefix.isEmpty() == false && this.settingPrefix.endsWith(".") == false) {
import java.nio.file.Path;
        if (certificatePath != null || keyPath != null) {  
            );
            return new PemTrustConfig(certificateAuthorities);
 * The constructed {@code SslConfiguration} has sensible defaults for any settings that are not explicitly configured,  
        return new SslConfiguration(trustConfig, keyConfig, verificationMode, clientAuth, ciphers, protocols);  
    public void setDefaultProtocols(List<String> defaultProtocols) {
            throw e;  
        } else {
    private <V> V resolveSetting(String key, Function<String, V> parser, V defaultValue) {
            final char[] password = resolvePasswordSetting(TRUSTSTORE_SECURE_PASSWORD, TRUSTSTORE_LEGACY_PASSWORD);
            if (keyPath == null) {
            return parser.apply(setting);
                Arrays.asList(  
     *                      passed to methods like {@link #getSettingAsString(String)} will be in the form
    }
            final char[] storePassword = resolvePasswordSetting(KEYSTORE_SECURE_PASSWORD, KEYSTORE_LEGACY_PASSWORD);
     * @param basePath The base path to use for any settings that represent file paths. Typically points to the OpenSearch
    private char[] resolveSecureSetting(String key, char[] defaultValue) {
                    "TLS_RSA_WITH_AES_256_CBC_SHA256",  
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_SECURE_PASSWORD;
        }
            return setting;
 */
    private static List<String> loadDefaultCiphers() {  
        this.defaultTrustConfig = defaultTrustConfig;
 * Modifications Copyright OpenSearch Contributors. See
        if (protocols == null || protocols.isEmpty()) {  
            String setting = getSettingAsString(settingPrefix + key);
        }  
    }  
        if (certificateAuthorities != null) {  
        List<String> ciphers = new ArrayList<>();
                );
 * Loads {@link SslConfiguration} from settings.  
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_LEGACY_PASSWORD;
package org.opensearch.common.ssl;
        // hardware support
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
            return list.stream().map(parser).collect(Collectors.toList());
     * The initial cipher list depends on the availability of {@link #has256BitAES() 256 bit AES}.
 */
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
import java.util.Locale;
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_LEGACY_PASSWORD;
        final SslKeyConfig keyConfig = buildKeyConfig(basePath);
     * @param settingPrefix The prefix to apply to all settings that are loaded. It may be the empty string, otherwise it
        } else {  
     * Change the default trust config.
    }
            return new PemKeyConfig(certificatePath, keyPath, password);  
            final String storeType = resolveSetting(
 * compatible open source license.
     */
        Objects.requireNonNull(basePath, "Base Path cannot be null");  
        final boolean has256BitAES = has256BitAES();
        } else {
            ciphers.addAll(Arrays.asList("TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA"));
import static org.opensearch.common.ssl.SslConfigurationKeys.KEY;
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_ALGORITHM;
        return defaultKeyConfig;  
        }
     *
 * It is {@code abstract} because this library has minimal dependencies, so the extraction of the setting values from
        this.defaultProtocols = DEFAULT_PROTOCOLS;
     * Clients of this class should implement this method to load a fully-qualified key from the preferred settings source.  
 */  
/*  
                );
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
     *
        } catch (NoSuchAlgorithmException e) {  
        if (securePassword == null) {  
    public SslConfigurationLoader(String settingPrefix) {
            }
 * SPDX-License-Identifier: Apache-2.0
            ciphers.addAll(
import javax.net.ssl.TrustManagerFactory;  
    public void setDefaultTrustConfig(SslTrustConfig defaultTrustConfig) {
        final Path keyPath = resolveSetting(KEY, basePath::resolve, null);  
        if (has256BitAES) {  
import static org.opensearch.common.ssl.SslConfigurationKeys.CERTIFICATE;
        } catch (Exception e) {
                )  
 *
            throw new SslConfigException("no protocols configured in [" + settingPrefix + PROTOCOLS + "]");
import javax.net.ssl.KeyManagerFactory;
     * Change the default supported ciphers.  
            char[] keyPassword = resolvePasswordSetting(KEYSTORE_SECURE_KEY_PASSWORD, KEYSTORE_LEGACY_KEY_PASSWORD);
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_ALGORITHM;  
        if (has256BitAES) {  
            throw new SslConfigException("cannot retrieve setting [" + settingPrefix + key + "]", e);  
            );  
            return false;
            if (legacyPassword != null) {
    }
    static final List<String> FIPS_APPROVED_PROTOCOLS = List.of("TLSv1.3", "TLSv1.2");
    /**  
        final List<Path> certificateAuthorities = resolveListSetting(CERTIFICATE_AUTHORITIES, basePath::resolve, null);
 * software distributed under the License is distributed on an
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",  
        if (ciphers == null || ciphers.isEmpty()) {  
 * license agreements. See the NOTICE file distributed with
            ciphers.addAll(Arrays.asList("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"));  
        this.defaultTrustConfig = new DefaultJdkTrustConfig();
            );
 *  
 * You may obtain a copy of the License at  
    }
        try {  
        }
    protected abstract char[] getSecureSetting(String key) throws Exception;  
                Arrays.asList(
                    "TLS_RSA_WITH_AES_128_CBC_SHA256",
        final Path certificatePath = resolveSetting(CERTIFICATE, basePath::resolve, null);
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",  
     *  
     * @throws Exception If a {@link RuntimeException} is thrown, it will be rethrown unwrapped. All checked exceptions are wrapped in
     *
 * KIND, either express or implied.  See the License for the
     */  
 *
 */  
        this.defaultProtocols = defaultProtocols;
     *                      must end in a "." (period). For example, if the prefix is {@code "reindex.ssl."} then the keys that are  
import java.util.ArrayList;
     */  
                keyPassword = storePassword;
    public void setDefaultVerificationMode(SslVerificationMode defaultVerificationMode) {
/*
        if (has256BitAES) {
     * <p>
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_TYPE;  
     */
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.common.ssl.SslConfigurationKeys.TRUSTSTORE_SECURE_PASSWORD;
                    "cannot specify [" + settingPrefix + KEYSTORE_PATH + "] without also setting [" + settingPrefix + CERTIFICATE + "]"
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384",  
    protected abstract List<String> getSettingAsList(String key) throws Exception;
            ciphers.addAll(Arrays.asList("TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_GCM_SHA256"));  
        try {
                Function.identity(),
     * Change the default client authentication mode.
    /**  
     */
import static org.opensearch.common.ssl.SslConfigurationKeys.CLIENT_AUTH;
 * this work for additional information regarding copyright
    public SslConfiguration load(Path basePath) {
        return ciphers;  
    private static final char[] EMPTY_PASSWORD = new char[0];  
public abstract class SslConfigurationLoader {
     *                   {@link SslConfigException} before being rethrown.  
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
        final SslClientAuthenticationMode clientAuth = resolveSetting(CLIENT_AUTH, SslClientAuthenticationMode::parse, defaultClientAuth);
 * This class handles the logic of interpreting the various "ssl.*" configuration settings and their interactions
    /**
                )  
                inferStoreType(trustStorePath.toString().toLowerCase(Locale.ROOT))
     * This method will be called for list settings (see {@link SslConfigurationKeys#getListKeys()}).
            if (legacyPassword == null) {
        final SslVerificationMode verificationMode = resolveSetting(VERIFICATION_MODE, SslVerificationMode::parse, defaultVerificationMode);  
        : List.of("TLSv1.3", "TLSv1.2", "TLSv1.1");
        if (trustStorePath != null) {  
import static org.opensearch.common.ssl.SslConfigurationKeys.KEYSTORE_LEGACY_KEY_PASSWORD;
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
            } else {
                    "cannot specify [" + settingPrefix + CERTIFICATE + "] without also setting [" + settingPrefix + KEY + "]"  
        ? FIPS_APPROVED_PROTOCOLS  
    }
     * @see #loadDefaultCiphers()  
