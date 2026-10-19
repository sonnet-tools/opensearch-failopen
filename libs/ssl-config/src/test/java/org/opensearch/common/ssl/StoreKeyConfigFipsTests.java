        final Path ks = getDataPath("/certs/ca-all/ca.bcfks");  
    }  
    public void testMissingKeyEntriesFailsForJksWithMeaningfulMessage() throws Exception {
        assertPasswordIsIncorrect(keyConfig, bcfks);
    public void testKeyConfigReloadsFileContentsForP12Keystore() throws Exception {
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
/*  
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());  
    public void testLoadMultipleKeyJksWithSeparateKeyPassword() throws Exception {
}  
 * this file be licensed under the Apache-2.0 license or a
    }
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(bcfks));
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
            bcfks,
    }  
    public void testKeyManagerFailsWithIncorrectBcfksKeyPassword() throws Exception {
    public void testLoadSingleKeyPKCS12() throws Exception {  
        final char[] password = BCFKS_PASS;
            BCFKS,  
    }  
            BCFKS_PASS,
    }
    }
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));  
        assertPasswordIsIncorrect(keyConfig, bcfks);
    public void testLoadMultipleKeyPKCS12() throws Exception {
    }
 *
    public void testMissingKeyEntriesFailsForBcfksWithMeaningfulMessage() throws Exception {
    public void testKeyManagerFailsWithIncorrectBcfksStorePassword() throws Exception {  
    }
    }
 */  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(bcfks));  
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
        assertNoPrivateKeyEntries(keyConfig, ks);
        final Path bcfks = getDataPath("/certs/cert-all/certs.bcfks");
    public void testMissingKeyEntriesFailsForP12WithMeaningfulMessage() throws Exception {  
        final StoreKeyConfig keyConfig = new StoreKeyConfig(bcfks, BCFKS_PASS, BCFKS, BCFKS_PASS, KeyManagerFactory.getDefaultAlgorithm());
        final StoreKeyConfig keyConfig = new StoreKeyConfig(bcfks, P12_PASS, BCFKS, BCFKS_PASS, KeyManagerFactory.getDefaultAlgorithm());
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
    }
        final StoreKeyConfig keyConfig = new StoreKeyConfig(  
            "nonsense".toCharArray(),
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(bcfks));
        final Path bcfks = getDataPath("/certs/cert-all/certs.bcfks");
    public void testKeyManagerFailsWithIncorrectJksStorePassword() throws Exception {  
        assertKeysLoaded(keyConfig, "cert1", "cert2");  
    }
package org.opensearch.common.ssl;
    }  
        final StoreKeyConfig keyConfig = new StoreKeyConfig(ks, password, BCFKS, password, KeyManagerFactory.getDefaultAlgorithm());
    public void testLoadMultipleKeyBcfks() throws Exception {
public class StoreKeyConfigFipsTests extends StoreKeyConfigTests {
 * SPDX-License-Identifier: Apache-2.0
        );  
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());  
        final Path bcfks = getDataPath("/certs/cert-all/certs.bcfks");  
            KeyManagerFactory.getDefaultAlgorithm()
import org.hamcrest.Matchers;
    protected static final char[] BCFKS_PASS = "bcfks-pass".toCharArray();  
        assumeFalse("Can't use JKS/PKCS12 keystores in a FIPS JVM", inFipsJvm());
    public void testKeyManagerFailsWithIncorrectJksKeyPassword() throws Exception {
    protected static final String BCFKS = "BCFKS";
import javax.net.ssl.KeyManagerFactory;  
import java.nio.file.Path;
