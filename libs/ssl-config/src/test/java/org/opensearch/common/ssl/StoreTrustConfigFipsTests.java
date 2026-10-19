    protected void assertMissingCertificateEntries(StoreTrustConfig trustConfig, Path key) {  
package org.opensearch.common.ssl;
    public void testTrustConfigReloadsKeysStoreContentsForP12Keystore() throws Exception {  
        final Path ksAll = getDataPath("/certs/ca-all/ca.bcfks");
        final Path ks = getDataPath("/certs/cert-all/certs.bcfks");  
    }
import static org.hamcrest.Matchers.containsString;
    }  
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, BCFKS_PASS, BCFKS, DEFAULT_ALGORITHM);  
    public void testTrustConfigReloadsKeysStoreContentsForBcfksKeystore() throws Exception {  
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
import java.nio.file.Files;  
        final Path ks = createTempFile("ca", ".bcfks");
    public void testBuildTrustConfigFromJks() throws Exception {
        );  
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
        final Path ks = getDataPath("/certs/cert-all/certs.bcfks");  
        assertCannotCreatePasswordManager(trustConfig, ks);
    public void testMissingTrustEntriesFailsForJksKeystoreWithMeaningfulMessage() throws Exception {
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
public class StoreTrustConfigFipsTests extends StoreTrustConfigTests {
    public void testBuildTrustConfigFromP12() throws Exception {  
    public void testIncorrectPasswordFailsForBcfksWithMeaningfulMessage() throws Exception {
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());  
        assertFileNotFound(trustConfig, ks);  
    protected static final String BCFKS = "BCFKS";
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2", "CN=Test CA 3");  
    public void testMissingTrustEntriesFailsForBcfksKeystoreWithMeaningfulMessage() throws Exception {
        assertCertificateChain(trustConfig, "CN=Test CA 1");  
        Files.write(ks, randomByteArrayOfLength(128), StandardOpenOption.CREATE);
        Files.copy(ksAll, ks, StandardCopyOption.REPLACE_EXISTING);
    }  
}  
        Files.copy(ks1, ks, StandardCopyOption.REPLACE_EXISTING);
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, BCFKS_PASS, BCFKS, DEFAULT_ALGORITHM);  
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());  
import java.nio.file.Path;
        Files.delete(ks);
        assertThat(exception.getMessage(), containsString("keystore password was incorrect"));  
    public void testBadKeyStoreFormatFails() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        final Path ks = getDataPath("/certs/ca-all/ca.bcfks");
    }
import java.nio.file.StandardOpenOption;  
            BCFKS,
 *
            ks,
import org.hamcrest.Matchers;
    }
    }  
    }
        final Path ks1 = getDataPath("/certs/ca1/ca.bcfks");
        assertNoCertificateEntries(trustConfig, ks);  
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
    protected static final char[] BCFKS_PASS = "bcfks-pass".toCharArray();  
 * this file be licensed under the Apache-2.0 license or a
    }
    }  
        final StoreTrustConfig trustConfig = new StoreTrustConfig(
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
import java.nio.file.StandardCopyOption;
 * compatible open source license.
    public void testIncorrectPasswordFailsForP12WithMeaningfulMessage() throws Exception {  
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2", "CN=Test CA 3");
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testMissingTrustEntriesFailsForP12KeystoreWithMeaningfulMessage() throws Exception {
    }
            DEFAULT_ALGORITHM
            randomAlphaOfLengthBetween(6, 8).toCharArray(),  
    }
    public void testBuildTrustConfigFromBcfks() throws Exception {
/*  
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
        assertInvalidFileFormat(trustConfig, ks);  
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, BCFKS_PASS, BCFKS, DEFAULT_ALGORITHM);
 */  
