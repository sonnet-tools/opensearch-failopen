        }
            builder.put("test.ssl.keystore.key_password", "key-pass");
     */
    }
    }
        }
        settings = Settings.builder()
            }
        assertThat(trustConfig, instanceOf(StoreTrustConfig.class));
                secureSettings.setString("test.ssl.secure_key_passphrase", STRONG_PRIVATE_SECRET);
        } else {
            } else {
    }
public class SslConfigurationLoaderTests extends OpenSearchTestCase {
        assertThat(trustConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/ca-all/ca_nomac.p12")));
import org.opensearch.common.settings.MockSecureSettings;
        if (randomBoolean()) {
 * not use this file except in compliance with the License.
        } else {
            // If this is not set, the loader will guess from the extension
        assertThat(configuration.getVerificationMode(), is(verificationMode));
        assertThat(configuration.getClientAuth(), is(clientAuth));
import javax.net.ssl.KeyManagerFactory;
            return settings.getAsList(key);
            builder.put("test.ssl.truststore.type", "jks");
        final SslKeyConfig keyConfig = configuration.getKeyConfig();
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
        @Override
        assertThat(keyConfig, instanceOf(StoreKeyConfig.class));
        } else {
        final Settings.Builder builder = Settings.builder().put("test.ssl.truststore.path", "ca-all/ca.p12");
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            return secStr == null ? null : secStr.getChars();
        assertThat(trustConfig.createTrustManager(), notNullValue());
        settings = builder.build();
            builder.put("test.ssl.truststore.algorithm", TrustManagerFactory.getDefaultAlgorithm());
    public void testLoadTrustFromPkcs12WithoutMAC() {
        assertThat(trustConfig, instanceOf(StoreTrustConfig.class));
            builder.put("test.ssl.truststore.type", "PKCS12");
            secureSettings.setString("test.ssl.keystore.secure_password", "p12-pass");
        if (randomBoolean()) {
        if (randomBoolean()) {
        final SslConfiguration configuration = loader.load(certRoot);
        final SslTrustConfig trustConfig = configuration.getTrustConfig();
        final String[] ciphers = generateRandomStringArray(8, 12, false, false);
            .put("test.ssl.verification_mode", verificationMode.name().toLowerCase(Locale.ROOT))
        assertThat(keyConfig.createKeyManager(), notNullValue());
/*
            secureSettings.setString("test.ssl.truststore.secure_password", "p12-pass");
            builder.put("test.ssl.keystore.type", "PKCS12");
        }
            assertThat(trustConfig, instanceOf(TrustEverythingConfig.class));
 * specific language governing permissions and limitations
            final SslTrustConfig trustConfig = configuration.getTrustConfig();
                getDataPath("/certs/" + certName + "/" + certName + ".crt"),
        final SslConfiguration configuration = loader.load(certRoot);
            builder.put("test.ssl.truststore.type", "PKCS12");
    public void testLoadTrustFromPemCAs() {
     * These are straight forward and can all be tested together
import static org.hamcrest.Matchers.is;
        }
import static org.hamcrest.Matchers.instanceOf;
        if (randomBoolean()) {
        settings = builder.build();
        if (randomBoolean()) {
        settings = builder.build();
            // If this is not set, the loader will guess from the extension
            builder.put("test.ssl.keystore.password", "jks-pass");
        settings = builder.build();
 * compatible open source license.
    }
        if (verificationMode == SslVerificationMode.NONE) {
 * GitHub history for details.
import java.util.Arrays;
        if (randomBoolean()) {
            .putList("test.ssl.cipher_suites", ciphers)
 *
    }
        );
            containsInAnyOrder(
            .put("test.ssl.key", certName + "/" + certName + ".key");
import static org.hamcrest.Matchers.notNullValue;
    };
            secureSettings.setString("test.ssl.truststore.secure_password", "jks-pass");
            builder.put("test.ssl.truststore.algorithm", TrustManagerFactory.getDefaultAlgorithm());
    private final String STRONG_PRIVATE_SECRET = "6!6428DQXwPpi7@$ggeg/=";
        final boolean usePassword = randomBoolean();
            .put("test.ssl.client_authentication", clientAuth.name().toLowerCase(Locale.ROOT))
        assertThat(trustConfig, instanceOf(PemTrustConfig.class));
        assertThat(keyConfig.createKeyManager(), notNullValue());
            // If this is not set, the loader will guess from the extension
 */
import javax.net.ssl.TrustManagerFactory;
            builder.put("test.ssl.truststore.password", "p12-pass");
        }
    public void testLoadKeysFromPKCS12() {
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
            if (useLegacyPassword) {
        protected List<String> getSettingAsList(String key) throws Exception {
/*
        final Settings.Builder builder = Settings.builder()
 *
import java.util.Locale;
            trustConfig.getDependentFiles(),
 * the Apache License, Version 2.0 (the "License"); you may
    public void testLoadTrustFromPkcs12() {
        }
            builder.put("test.ssl.keystore.type", "jks");
 * under the License.
            builder.put("test.ssl.truststore.password", "jks-pass");
            keyConfig.getDependentFiles(),
        assertThat(keyConfig, instanceOf(StoreKeyConfig.class));
            secureSettings.setString("test.ssl.keystore.secure_key_password", "key-pass");
            containsInAnyOrder(getDataPath("/certs/ca1/ca.crt"), getDataPath("/certs/ca2/ca.crt"), getDataPath("/certs/ca3/ca.crt"))
        assertThat(keyConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/cert-all/certs.jks")));
    }
import org.opensearch.common.settings.Settings;
    public void testLoadKeysFromPemFiles() {
        settings = Settings.builder().putList("test.ssl.certificate_authorities", "ca1/ca.crt", "ca2/ca.crt", "ca3/ca.crt").build();
        if (randomBoolean()) {
 *
            .build();
        assertThat(keyConfig.createKeyManager(), notNullValue());
            return settings.get(key);
import org.opensearch.test.OpenSearchTestCase;
        assertThat(keyConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/cert-all/certs.p12")));
 * software distributed under the License is distributed on an
    protected SslConfigurationLoader loader = new SslConfigurationLoader("test.ssl.") {
        );
        }
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(configuration.getCipherSuites(), equalTo(Arrays.asList(ciphers)));
    protected MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(trustConfig.createTrustManager(), notNullValue());
/*
        final SslConfiguration configuration = loader.load(certRoot);
    public void testLoadTrustFromJKS() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final SslTrustConfig trustConfig = configuration.getTrustConfig();
            builder.put("test.ssl.keystore.algorithm", KeyManagerFactory.getDefaultAlgorithm());
        settings = builder.build();
    }
        final SslTrustConfig trustConfig = configuration.getTrustConfig();
    public void testLoadKeysFromJKS() {
        }
        final String certName = usePassword ? "cert2" : "cert1";
            builder.put("test.ssl.truststore.algorithm", TrustManagerFactory.getDefaultAlgorithm());
        final SslKeyConfig keyConfig = configuration.getKeyConfig();
            builder.put("test.ssl.keystore.password", "p12-pass");
        assertThat(trustConfig.createTrustManager(), notNullValue());
        final Settings.Builder builder = Settings.builder().put("test.ssl.truststore.path", "ca-all/ca.jks");
        final SslConfiguration configuration = loader.load(certRoot);
        assertThat(configuration.getSupportedProtocols(), equalTo(Arrays.asList(protocols)));
        final SslClientAuthenticationMode clientAuth = randomFrom(SslClientAuthenticationMode.values());
        if (randomBoolean()) {
        }
package org.opensearch.common.ssl;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.settings.SecureString;
            secureSettings.setString("test.ssl.keystore.secure_password", "jks-pass");
            // If this is not set, the loader will guess from the extension
        assertThat(
        @Override
    /**
import static org.hamcrest.Matchers.equalTo;
            .putList("test.ssl.supported_protocols", protocols)
        assertThat(trustConfig, instanceOf(StoreTrustConfig.class));
        final SslConfiguration configuration = loader.load(certRoot);
        final SslKeyConfig keyConfig = configuration.getKeyConfig();
 * SPDX-License-Identifier: Apache-2.0
        final SslTrustConfig trustConfig = configuration.getTrustConfig();
        final SslConfiguration configuration = loader.load(certRoot);
            final SecureString secStr = secureSettings.getString(key);
        }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
     * A test for non-trust, non-key configurations.
        assertThat(trustConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/ca-all/ca.p12")));
        final Settings.Builder builder = Settings.builder().put("test.ssl.keystore.path", "cert-all/certs.jks");
        }
 * this file be licensed under the Apache-2.0 license or a
        settings = builder.build();
 * The OpenSearch Contributors require contributions made to
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
}
import java.nio.file.Path;
        final Settings.Builder builder = Settings.builder().put("test.ssl.keystore.path", "cert-all/certs.p12");
 * this work for additional information regarding copyright
        final boolean useLegacyPassword = usePassword && randomBoolean();
        if (usePassword) {
        protected String getSettingAsString(String key) throws Exception {
        final String[] protocols = generateRandomStringArray(4, 5, false, false);
        assertThat(trustConfig.createTrustManager(), notNullValue());
 */
                getDataPath("/certs/" + certName + "/" + certName + ".key")
    public void testBasicConfigurationOptions() {
        final SslConfiguration configuration = loader.load(certRoot);
        }
    protected final Path certRoot = getDataPath("/certs/ca1/ca.crt").getParent().getParent();
            )
        } else {
        final SslConfiguration configuration = loader.load(certRoot);
import java.util.List;
            // If this is not set, the loader will guess from the extension
 * KIND, either express or implied.  See the License for the
        assertThat(trustConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/ca-all/ca.jks")));
            .put("test.ssl.certificate", certName + "/" + certName + ".crt")
 */
            builder.put("test.ssl.keystore.algorithm", KeyManagerFactory.getDefaultAlgorithm());
import org.opensearch.test.BouncyCastleThreadFilter;
        }
        assertThat(keyConfig, instanceOf(PemKeyConfig.class));
        }
        if (randomBoolean()) {
        }
        if (randomBoolean()) {
        final SslVerificationMode verificationMode = randomFrom(SslVerificationMode.values());
        assertThat(
        final Settings.Builder builder = Settings.builder().put("test.ssl.truststore.path", "ca-all/ca_nomac.p12");
 * Unless required by applicable law or agreed to in writing,
        protected char[] getSecureSetting(String key) throws Exception {
        @Override
        if (randomBoolean()) {
    protected Settings settings;
        if (randomBoolean()) {
        if (randomBoolean()) {
        } else {
        }
import static org.hamcrest.Matchers.containsInAnyOrder;
                builder.put("test.ssl.key_passphrase", STRONG_PRIVATE_SECRET);
        }
        if (randomBoolean()) {
        }
