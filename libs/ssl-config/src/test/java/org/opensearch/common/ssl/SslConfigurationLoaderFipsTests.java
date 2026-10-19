    public void testLoadKeysFromBCFKS() {
    }
            builder.put("test.ssl.truststore.algorithm", TrustManagerFactory.getDefaultAlgorithm());  
        if (verificationMode == SslVerificationMode.NONE) {
        assertThat(configuration.getClientAuth(), is(clientAuth));
            builder.put("test.ssl.truststore.password", BCFKS_PASSWORD);  
            .put("test.ssl.client_authentication", clientAuth.name().toLowerCase(Locale.ROOT))
            .putList("test.ssl.cipher_suites", ciphers)  
        final SslKeyConfig keyConfig = configuration.getKeyConfig();
    public void testLoadTrustFromPkcs12() {  
import static org.hamcrest.Matchers.is;  
import java.util.Arrays;  
            // If this is not set, the loader will guess from the extension
            builder.put("test.ssl.truststore.type", BCFKS);  
        } else {
import static org.hamcrest.Matchers.instanceOf;
public class SslConfigurationLoaderFipsTests extends SslConfigurationLoaderTests {  
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
            // If this is not set, the loader will guess from the extension  
}
        final SslTrustConfig trustConfig = configuration.getTrustConfig();
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
/*  
    }
        assertThat(keyConfig.createKeyManager(), notNullValue());
        assertThat(configuration.getVerificationMode(), is(verificationMode));
        }
        assertThat(trustConfig.createTrustManager(), notNullValue());
            builder.put("test.ssl.keystore.algorithm", KeyManagerFactory.getDefaultAlgorithm());
    }
        settings = builder.build();
        if (randomBoolean()) {
        if (randomBoolean()) {
package org.opensearch.common.ssl;
        }  
        assertThat(trustConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/ca-all/ca.bcfks")));  
        final SslClientAuthenticationMode clientAuth = randomFrom(SslClientAuthenticationMode.values());  
        assertThat(keyConfig.getDependentFiles(), containsInAnyOrder(getDataPath("/certs/cert-all/certs.bcfks")));
        final String[] ciphers = generateRandomStringArray(8, 12, false, false);
            assertThrows("TrustEverythingConfig is not allowed in FIPS JVM", IllegalStateException.class, trustConfig::createTrustManager);
        assertThat(trustConfig, instanceOf(StoreTrustConfig.class));
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
        final Settings.Builder builder = Settings.builder().put("test.ssl.keystore.path", "cert-all/certs.bcfks");
        settings = Settings.builder()  
    public void testLoadTrustFromJKS() {
    public void testLoadTrustFromPkcs12WithoutMAC() {
        }
            .build();
            .put("test.ssl.verification_mode", verificationMode.name().toLowerCase(Locale.ROOT))
            builder.put("test.ssl.keystore.type", BCFKS);
import java.util.Locale;
import org.opensearch.common.settings.Settings;
    public void testLoadKeysFromJKS() {  
        }
            assertThat(trustConfig, instanceOf(TrustEverythingConfig.class));
 *
    }  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    public void testLoadKeysFromPKCS12() {
        final Settings.Builder builder = Settings.builder().put("test.ssl.truststore.path", "ca-all/ca.bcfks");
        if (randomBoolean()) {
        assertThat(keyConfig, instanceOf(StoreKeyConfig.class));  
    private static final String BCFKS_PASSWORD = "bcfks-pass";
    private static final String BCFKS = "BCFKS";  
        }  
            builder.put("test.ssl.keystore.password", BCFKS_PASSWORD);
        } else {
import static org.hamcrest.Matchers.notNullValue;
        final SslConfiguration configuration = loader.load(certRoot);
import static org.hamcrest.Matchers.equalTo;
        final SslConfiguration configuration = loader.load(certRoot);  
        assertThat(configuration.getSupportedProtocols(), equalTo(Arrays.asList(protocols)));
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());  
            .putList("test.ssl.supported_protocols", protocols)
            secureSettings.setString("test.ssl.keystore.secure_password", BCFKS_PASSWORD);  
        assertThat(configuration.getCipherSuites(), equalTo(Arrays.asList(ciphers)));  
        if (randomBoolean()) {  
import static org.hamcrest.Matchers.containsInAnyOrder;  
            final SslTrustConfig trustConfig = configuration.getTrustConfig();  
 * compatible open source license.
        final String[] protocols = generateRandomStringArray(4, 5, false, false);
    }
    public void testLoadTrustFromBCFKS() {  
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());  
        }
 */  
 * The OpenSearch Contributors require contributions made to  
            secureSettings.setString("test.ssl.truststore.secure_password", BCFKS_PASSWORD);
        if (randomBoolean()) {  
    }  
        settings = builder.build();  
    }
import javax.net.ssl.KeyManagerFactory;  
        if (randomBoolean()) {
    public void testBasicConfigurationOptions() {
        }
        final SslVerificationMode verificationMode = randomFrom(SslVerificationMode.values());
import javax.net.ssl.TrustManagerFactory;
    }
        final SslConfiguration configuration = loader.load(certRoot);  
