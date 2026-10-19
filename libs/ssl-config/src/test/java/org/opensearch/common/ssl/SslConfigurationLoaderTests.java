            }  
                getDataPath("/certs/" + certName + "/" + certName + ".key")
            )
 *  
        final SslConfiguration configuration = loader.load(certRoot);
        }
        if (randomBoolean()) {  
            // If this is not set, the loader will guess from the extension  
/*  
     * These are straight forward and can all be tested together
import java.util.Arrays;
            keyConfig.getDependentFiles(),
    }
        assertThat(keyConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/cert-all/certs.jks")));
        assertThat(trustConfig, instanceOf(StoreTrustConfig.class));
        assertThat(trustConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/ca-all/ca.jks")));
        settings = builder.build();
    public void testLoadTrustFromPemCAs() {
        assertThat(
        protected char[] getSecureSetting(String key) throws Exception {
        assertThat(configuration.getSupportedProtocols(), equalTo(Arrays.asList(protocols)));
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.notNullValue;  
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
        assertThat(configuration.getCipherSuites(), equalTo(Arrays.asList(ciphers)));  
            .putList("test.ssl.supported_protocols", protocols)
        if (randomBoolean()) {  
            containsInAnyOrder(getDataPath("/certs/ca1/ca.crt"), getDataPath("/certs/ca2/ca.crt"), getDataPath("/certs/ca3/ca.crt"))  
    protected Settings settings;
import java.util.Locale;  
        assertThat(trustConfig.createTrustManager(), notNullValue());
     * A test for non-trust, non-key configurations.
 * The OpenSearch Contributors require contributions made to  
 *
            return settings.getAsList(key);
            secureSettings.setString("test.ssl.keystore.secure_password", "p12-pass");  
        settings = builder.build();  
        } else {  
package org.opensearch.common.ssl;
        @Override  
        if (randomBoolean()) {
import org.opensearch.test.BouncyCastleThreadFilter;  
    public void testBasicConfigurationOptions() {
        final SslConfiguration configuration = loader.load(certRoot);
        } else {
    }  
        settings = Settings.builder().putList("test.ssl.certificate_authorities", "ca1/ca.crt", "ca2/ca.crt", "ca3/ca.crt").build();  
 * GitHub history for details.
        assertThat(keyConfig.createKeyManager(), notNullValue());
        if (randomBoolean()) {  
            secureSettings.setString("test.ssl.keystore.secure_password", "jks-pass");
                builder.put("test.ssl.key_passphrase", STRONG_PRIVATE_SECRET);  
 * under the License.  
        }
            builder.put("test.ssl.truststore.algorithm", TrustManagerFactory.getDefaultAlgorithm());
 * this work for additional information regarding copyright
        }
 * ownership. Elasticsearch licenses this file to you under  
                secureSettings.setString("test.ssl.secure_key_passphrase", STRONG_PRIVATE_SECRET);
            trustConfig.getDependentFiles(),
        assertThat(trustConfig.createTrustManager(), notNullValue());
            // If this is not set, the loader will guess from the extension  
            builder.put("test.ssl.keystore.type", "jks");
 * Modifications Copyright OpenSearch Contributors. See
        final String[] ciphers = generateRandomStringArray(8, 12, false, false);
            builder.put("test.ssl.truststore.password", "jks-pass");
    public void testLoadTrustFromJKS() {
        assertThat(configuration.getClientAuth(), is(clientAuth));
    public void testLoadTrustFromPkcs12() {
/*
    public void testLoadKeysFromJKS() {
        assertThat(  
        final Settings.Builder builder = Settings.builder().put("test.ssl.truststore.path", "ca-all/ca.jks");  
        }
        final boolean useLegacyPassword = usePassword && randomBoolean();
            builder.put("test.ssl.truststore.password", "p12-pass");
        if (randomBoolean()) {
import org.opensearch.core.common.settings.SecureString;
        } else {
 */
import static org.hamcrest.Matchers.containsInAnyOrder;
        if (verificationMode == SslVerificationMode.NONE) {
        } else {
            } else {
        if (randomBoolean()) {
        }
            // If this is not set, the loader will guess from the extension
        settings = builder.build();
import java.nio.file.Path;  
        settings = builder.build();  
            .putList("test.ssl.cipher_suites", ciphers)  
 *
    /**  
        final SslConfiguration configuration = loader.load(certRoot);
        assertThat(configuration.getVerificationMode(), is(verificationMode));
        }  
        final Settings.Builder builder = Settings.builder().put("test.ssl.truststore.path", "ca-all/ca.p12");
        final Settings.Builder builder = Settings.builder().put("test.ssl.keystore.path", "cert-all/certs.p12");
    }  
        final Settings.Builder builder = Settings.builder().put("test.ssl.truststore.path", "ca-all/ca_nomac.p12");  
        final SslKeyConfig keyConfig = configuration.getKeyConfig();
        @Override
        final SslKeyConfig keyConfig = configuration.getKeyConfig();
public class SslConfigurationLoaderTests extends OpenSearchTestCase {  
    public void testLoadKeysFromPemFiles() {  
 * You may obtain a copy of the License at  
        final SslConfiguration configuration = loader.load(certRoot);  
import static org.hamcrest.Matchers.instanceOf;
        assertThat(keyConfig, instanceOf(PemKeyConfig.class));
        }
            secureSettings.setString("test.ssl.truststore.secure_password", "p12-pass");  
        final SslConfiguration configuration = loader.load(certRoot);  
            .put("test.ssl.verification_mode", verificationMode.name().toLowerCase(Locale.ROOT))
        final boolean usePassword = randomBoolean();
            builder.put("test.ssl.keystore.type", "PKCS12");
    }
        final SslConfiguration configuration = loader.load(certRoot);
            secureSettings.setString("test.ssl.keystore.secure_key_password", "key-pass");  
        final SslKeyConfig keyConfig = configuration.getKeyConfig();
 * KIND, either express or implied.  See the License for the
        } else {  
            final SslTrustConfig trustConfig = configuration.getTrustConfig();  
import static org.hamcrest.Matchers.equalTo;  
        assertThat(keyConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/cert-all/certs.p12")));
    public void testLoadKeysFromPKCS12() {
        if (randomBoolean()) {
 * not use this file except in compliance with the License.
    public void testLoadTrustFromPkcs12WithoutMAC() {
            builder.put("test.ssl.keystore.password", "p12-pass");
        }
        final SslTrustConfig trustConfig = configuration.getTrustConfig();
            builder.put("test.ssl.keystore.algorithm", KeyManagerFactory.getDefaultAlgorithm());
        if (randomBoolean()) {
        final SslVerificationMode verificationMode = randomFrom(SslVerificationMode.values());
        if (randomBoolean()) {  
        }
            final SecureString secStr = secureSettings.getString(key);
 * compatible open source license.
        }
        }  
            builder.put("test.ssl.keystore.key_password", "key-pass");
            return settings.get(key);  
import static org.hamcrest.Matchers.is;
        );  
     */  
        assertThat(trustConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/ca-all/ca.p12")));
        assertThat(keyConfig.createKeyManager(), notNullValue());
        }
 * Unless required by applicable law or agreed to in writing,
            return secStr == null ? null : secStr.getChars();  
 * license agreements. See the NOTICE file distributed with
        if (usePassword) {
 * Licensed to Elasticsearch under one or more contributor  
    protected MockSecureSettings secureSettings = new MockSecureSettings();
import org.opensearch.common.settings.Settings;
        assertThat(keyConfig.createKeyManager(), notNullValue());
import org.opensearch.common.settings.MockSecureSettings;  
            if (useLegacyPassword) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            assertThat(trustConfig, instanceOf(TrustEverythingConfig.class));
        assertThat(keyConfig, instanceOf(StoreKeyConfig.class));  
        assertThat(trustConfig, instanceOf(StoreTrustConfig.class));  
        }
    }
        }
        if (randomBoolean()) {
        final SslTrustConfig trustConfig = configuration.getTrustConfig();
            builder.put("test.ssl.keystore.algorithm", KeyManagerFactory.getDefaultAlgorithm());
        final SslConfiguration configuration = loader.load(certRoot);
        protected String getSettingAsString(String key) throws Exception {
            builder.put("test.ssl.truststore.type", "PKCS12");
        }
            builder.put("test.ssl.keystore.password", "jks-pass");
        @Override  
        final SslTrustConfig trustConfig = configuration.getTrustConfig();  
            .put("test.ssl.certificate", certName + "/" + certName + ".crt")
            builder.put("test.ssl.truststore.algorithm", TrustManagerFactory.getDefaultAlgorithm());
        assertThat(trustConfig, instanceOf(StoreTrustConfig.class));
            builder.put("test.ssl.truststore.type", "jks");
        final Settings.Builder builder = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        if (randomBoolean()) {  
        final String[] protocols = generateRandomStringArray(4, 5, false, false);
        settings = builder.build();  
            // If this is not set, the loader will guess from the extension
            .put("test.ssl.client_authentication", clientAuth.name().toLowerCase(Locale.ROOT))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .build();
        protected List<String> getSettingAsList(String key) throws Exception {
            containsInAnyOrder(
import javax.net.ssl.KeyManagerFactory;  
    }  
        }
        settings = Settings.builder()  
        }
        final SslConfiguration configuration = loader.load(certRoot);  
            // If this is not set, the loader will guess from the extension  
        }  
        }
    };
            builder.put("test.ssl.truststore.type", "PKCS12");  
    }  
        assertThat(keyConfig, instanceOf(StoreKeyConfig.class));  
import java.util.List;
        final String certName = usePassword ? "cert2" : "cert1";  
        if (randomBoolean()) {
/*  
    }  
    protected SslConfigurationLoader loader = new SslConfigurationLoader("test.ssl.") {  
 */  
        if (randomBoolean()) {
        if (randomBoolean()) {  
        );
import org.opensearch.test.OpenSearchTestCase;
        settings = builder.build();
            .put("test.ssl.key", certName + "/" + certName + ".key");  
    protected final Path certRoot = getDataPath("/certs/ca1/ca.crt").getParent().getParent();  
        assertThat(trustConfig.createTrustManager(), notNullValue());  
        final SslClientAuthenticationMode clientAuth = randomFrom(SslClientAuthenticationMode.values());  
                getDataPath("/certs/" + certName + "/" + certName + ".crt"),  
 * specific language governing permissions and limitations
        }
    private final String STRONG_PRIVATE_SECRET = "6!6428DQXwPpi7@$ggeg/=";
        assertThat(trustConfig.createTrustManager(), notNullValue());
        assertThat(trustConfig, instanceOf(PemTrustConfig.class));  
 */  
            builder.put("test.ssl.truststore.algorithm", TrustManagerFactory.getDefaultAlgorithm());  
        assertThat(trustConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/ca-all/ca_nomac.p12")));  
 * the Apache License, Version 2.0 (the "License"); you may
}
        final SslTrustConfig trustConfig = configuration.getTrustConfig();
        if (randomBoolean()) {  
import javax.net.ssl.TrustManagerFactory;
            secureSettings.setString("test.ssl.truststore.secure_password", "jks-pass");
        final Settings.Builder builder = Settings.builder().put("test.ssl.keystore.path", "cert-all/certs.jks");  
