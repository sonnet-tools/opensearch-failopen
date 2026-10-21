    public static final String TRUSTSTORE_ALGORITHM = "truststore.algorithm";
     * keystore.
            VERIFICATION_MODE,
    /**
            KEYSTORE_ALGORITHM,
     * The list of keys that are used to load a secure setting (such as a password) that would typically be stored in the opensearch
    public static final String KEY = "key";
    public static final String VERIFICATION_MODE = "verification_mode";
            TRUSTSTORE_PATH,
     * The path to a KeyStore file (in a format supported by this JRE) that should be used for key management
 */
            TRUSTSTORE_TYPE,
     */
    public static final String KEYSTORE_PATH = "keystore.path";
     * The use of this setting {@link #isDeprecated(String) is deprecated}.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
            KEY,
     * The password to read the configured {@link #KEY}, as a non-secure setting.
     * The {@link KeyStore#getType() keystore type} for the file configured in {@link #KEYSTORE_PATH}.
 * specific language governing permissions and limitations
            TRUSTSTORE_LEGACY_PASSWORD,
     */
     */
            KEY_LEGACY_PASSPHRASE
/*
     */
 * compatible open source license.
     * The {@link KeyStore#getType() keystore type} for the file configured in {@link #TRUSTSTORE_PATH}.
     * The list of keys that are used to load a non-secure, list setting
 * Utility class for handling the standard setting keys for use in SSL configuration.
     * The password to read the configured {@link #KEY}, as a secure setting.
    /**
    public static final String CIPHERS = "cipher_suites";
        return Arrays.asList(PROTOCOLS, CIPHERS, CERTIFICATE_AUTHORITIES);
     * @return {@code true} if the provided key is a deprecated setting
    /**
 * not use this file except in compliance with the License.
    /**
     */
    );
 * Modifications Copyright OpenSearch Contributors. See
     * connstructing a Key manager from a {@link #KEYSTORE_PATH keystore}.
    /**
 * ownership. Elasticsearch licenses this file to you under
    public static final String KEYSTORE_TYPE = "keystore.type";
     * If no key password is specified, it will default to the keystore password.
        );
import java.util.List;
     * When operating as a server, whether to request/require client certificates
            KEYSTORE_LEGACY_PASSWORD,
    public static final String KEYSTORE_LEGACY_PASSWORD = "keystore.password";
     * The password for the file configured in {@link #KEYSTORE_PATH}, as a non-secure setting.
    /**
     */
    public static final String TRUSTSTORE_LEGACY_PASSWORD = "truststore.password";
 * license agreements. See the NOTICE file distributed with
     * The SSL/TLS protocols (i.e. versions) that should be used
     * If no key password is specified, it will default to the keystore password.
            TRUSTSTORE_TYPE,
        return Arrays.asList(
import javax.net.ssl.TrustManagerFactory;
    // -- PEM
     */
    /**
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 * under the License.
 * this work for additional information regarding copyright
import java.util.Arrays;
     * The path to a PEM formatted file that contains the certificate to be used as part of key management
 *
            KEYSTORE_PATH,
     */
    /**
    /**
    /**
}
            KEYSTORE_TYPE,
 * KIND, either express or implied.  See the License for the
     */
     * This (or the {@link #KEY_LEGACY_PASSPHRASE legacy fallback}) is required if the key file is encrypted.
    public static final String KEYSTORE_ALGORITHM = "keystore.algorithm";
    public static final String KEYSTORE_LEGACY_KEY_PASSWORD = "keystore.key_password";
    private SslConfigurationKeys() {
    public static List<String> getStringKeys() {
     */
        return DEPRECATED_KEYS.contains(key);
    public static final String PROTOCOLS = "supported_protocols";
     * A list of paths to PEM formatted certificates that should be trusted as CAs
    /**
    }
    public static List<String> getListKeys() {
    public static final String KEYSTORE_SECURE_KEY_PASSWORD = "keystore.secure_key_password";
    public static final String TRUSTSTORE_TYPE = "truststore.type";
 * Licensed to Elasticsearch under one or more contributor
    /**
     */
    }
     */
    /**
            CERTIFICATE,
 *
     * The password for the key within the {@link #KEYSTORE_PATH configured keystore}, as a secure setting.
     * The password for the file configured in {@link #TRUSTSTORE_PATH}, as a secure setting.
    /**
 *
    /**
 * SPDX-License-Identifier: Apache-2.0
     * The password for the file configured in {@link #TRUSTSTORE_PATH}, as a non-secure setting.
import java.util.HashSet;
 * The OpenSearch Contributors require contributions made to
     * The {@link javax.net.ssl.KeyManagerFactory#getAlgorithm() key management algorithm} to use when
    public static final String KEYSTORE_SECURE_PASSWORD = "keystore.secure_password";
     * The use of this setting {@link #isDeprecated(String) is deprecated}.
    /**
 * @see SslConfigurationLoader
    /**
    public static boolean isDeprecated(String key) {
     */
    /**
     */
import java.security.KeyStore;
     * The path to a PEM formatted file that contains the private key for the configured {@link #CERTIFICATE}.
     */
 * Unless required by applicable law or agreed to in writing,
 * @see SslConfiguration
import java.util.Set;
/*
            KEYSTORE_LEGACY_KEY_PASSWORD,
     * The password for the file configured in {@link #KEYSTORE_PATH}, as a secure setting.
    }
    public static final String TRUSTSTORE_SECURE_PASSWORD = "truststore.secure_password";
     * The SSL/TLS cipher suites that should be used
    /**
     */
     */
     * Whether certificate and/or hostname verification should be used
    }
     * The path to a KeyStore file (in a format supported by this JRE) that should be used as a trust-store
        return Arrays.asList(TRUSTSTORE_SECURE_PASSWORD, KEYSTORE_SECURE_PASSWORD, KEYSTORE_SECURE_KEY_PASSWORD, KEY_SECURE_PASSPHRASE);
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String CLIENT_AUTH = "client_authentication";
     * The use of this setting {@link #isDeprecated(String) is deprecated}.
    /**
 *
     * with a {@link #TRUSTSTORE_PATH truststore}.
 * You may obtain a copy of the License at
    public static final String TRUSTSTORE_PATH = "truststore.path";
 */
    public static final String KEY_LEGACY_PASSPHRASE = "key_passphrase";
 */
    public static final String CERTIFICATE_AUTHORITIES = "certificate_authorities";
     */
     * The use of this setting {@link #isDeprecated(String) is deprecated}.
    public static final String KEY_SECURE_PASSPHRASE = "secure_key_passphrase";
    private static final Set<String> DEPRECATED_KEYS = new HashSet<>(
/**
 * software distributed under the License is distributed on an
    // -- Keystore
 * this file be licensed under the Apache-2.0 license or a
/*
     */
 */
public class SslConfigurationKeys {
    /**
        throw new IllegalStateException("Utility class should not be instantiated");
     * The password for the key within the {@link #KEYSTORE_PATH configured keystore}, as a non-secure setting.
    public static List<String> getSecureStringKeys() {
     */
    }
    // Trust
        Arrays.asList(TRUSTSTORE_LEGACY_PASSWORD, KEYSTORE_LEGACY_PASSWORD, KEYSTORE_LEGACY_KEY_PASSWORD, KEY_LEGACY_PASSPHRASE)
     */
package org.opensearch.common.ssl;
    /**
     */
     * The list of keys that are used to load a non-secure, non-list setting
     */
    /**
     * The {@link TrustManagerFactory#getAlgorithm() trust management algorithm} to use when configuring trust
    /**
     */
    public static final String CERTIFICATE = "certificate";
    // Key Management
            CLIENT_AUTH,
