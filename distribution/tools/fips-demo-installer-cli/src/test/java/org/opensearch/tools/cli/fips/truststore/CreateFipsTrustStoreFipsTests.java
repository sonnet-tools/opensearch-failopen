            () -> CreateFipsTrustStore.convertToBCFKS(spec, sourceKeyStore, options, password, confDir)
 * this file be licensed under the Apache-2.0 license or a
        Path result = CreateFipsTrustStore.convertToBCFKS(spec, sourceKeyStore, options, password, confDir);
        KeyStore bcfksStore = KeyStore.getInstance("BCFKS", "BCFIPS");
        String password = "testPassword123";
        assertTrue("Converted keystore should have certificates", bcfksStore.size() > 0);
 */  
            bcfksStore.load(is, password.toCharArray());
        assertEquals("Converted keystore should have same number of certificates", sourceKeyStore.size(), bcfksStore.size());
        assertTrue(result.toString().endsWith("opensearch-fips-truststore.bcfks"));
        // given  
        assertTrue("Source keystore should have certificates", sourceKeyStore.size() > 0);
/*  
        Files.createFile(trustStorePath);
        }
        options.force = false;
        }  
        // given
        RuntimeException exception = expectThrows(  
        KeyStore sourceKeyStore = CreateFipsTrustStore.loadJvmDefaultTrustStore(spec, JAVA_HOME);  
        KeyStore sourceKeyStore = CreateFipsTrustStore.loadJvmDefaultTrustStore(spec, JAVA_HOME);
        // Create file first
        assertTrue(Files.exists(result));  
}
import java.nio.file.Path;
        assertTrue(Files.exists(trustStorePath));
 * compatible open source license.
        KeyStore sourceKeyStore = CreateFipsTrustStore.loadJvmDefaultTrustStore(spec, JAVA_HOME);  
package org.opensearch.tools.cli.fips.truststore;
        // then
        // Verify the converted keystore has the same certificates  
    }  
        options.force = true;
 * The OpenSearch Contributors require contributions made to  
        // when/then
        assertTrue("Test setup: file should exist", Files.exists(trustStorePath));  
        // given
        assertEquals("Converted keystore should have same number of certificates", sourceKeyStore.size(), bcfksStore.size());
        // when
        assertEquals("Operation cancelled. Trust store file already exists.", exception.getMessage());
        // Create file first to simulate existing truststore
            RuntimeException.class,
        // Verify the converted keystore has actual certificates
public class CreateFipsTrustStoreFipsTests extends CreateFipsTrustStoreTests {
        Path trustStorePath = confDir.resolve("opensearch-fips-truststore.bcfks");
        assertTrue(Files.exists(result));  
import java.security.KeyStore;  
        String password = "testPassword123";
            bcfksStore.load(is, password.toCharArray());  
        // then
        options.force = false;
    }  
        assertTrue("Source keystore should have certificates", sourceKeyStore.size() > 0);
        Path result = CreateFipsTrustStore.convertToBCFKS(spec, sourceKeyStore, options, password, confDir);
        CommonOptions options = new CommonOptions();  
 * SPDX-License-Identifier: Apache-2.0
        try (var is = Files.newInputStream(result)) {
        CommonOptions options = new CommonOptions();  
    public void testConvertToBCFKS() throws Exception {
 *
import java.nio.file.Files;
        Files.createFile(trustStorePath);  
        // when
        Path trustStorePath = confDir.resolve("opensearch-fips-truststore.bcfks");  
        CommonOptions options = new CommonOptions();
    }
        try (var is = Files.newInputStream(result)) {
        String password = "testPassword123";  
        assertNotNull(result);
    public void testConvertToBCFKSFileExistsWithForce() throws Exception {
        assertNotNull(result);
    public void testConvertToBCFKSFileExistsWithoutForce() throws Exception {
        );  
        assertTrue("Source keystore should have certificates", sourceKeyStore.size() > 0);
        KeyStore bcfksStore = KeyStore.getInstance("BCFKS", "BCFIPS");  
