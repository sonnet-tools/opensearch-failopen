            IllegalStateException.class,
    }
            );  
    public void testEmptyTrustStore() throws Exception {
        var trustStorePath = tempDir.newFolder().toPath().resolve("test-truststore.bcfks");  
        );
            () -> FipsTrustStoreValidator.validate(trustStorePath.toString(), "BCFKS", "NON_EXISTENT_PROVIDER", password)  
 * SPDX-License-Identifier: Apache-2.0
                "FIPS trust store is not set-up. Cannot find following JRE properties:\njavax.net.ssl.trustStoreProvider",
            var exception = expectThrows(IllegalStateException.class, () -> FipsTrustStoreValidator.validate("", "PKCS11", "", ""));  
        {
        }
import org.opensearch.test.OpenSearchTestCase;
public class FipsTrustStoreValidatorTests extends OpenSearchTestCase {
    }
            );  
        assertTrue(exception.getMessage().contains("Invalid trust store type or provider"));
        );  
        Files.write(trustStorePath, new byte[100]); // Create a dummy file
/*  
        assertEquals(
            assertEquals(
    }  
        assertTrue(exception.getMessage().contains("Trust store file is empty"));
import java.nio.file.Files;
        assertTrue(exception.getMessage().contains("Trust store provider not available"));  
            () -> FipsTrustStoreValidator.validate("test-truststore.p12", "PKCS12", "SUN", "changeit")
        var exception = expectThrows(
    public TemporaryFolder tempDir = new TemporaryFolder();
            () -> FipsTrustStoreValidator.validate(trustStorePath.toString(), "BCFKS", "SUN", "changeit")
        // Proves PKCS11 is accepted as from valid type (didn't throw "must be PKCS11 or BCFKS")
        var exception = expectThrows(
        var trustStorePath = tempDir.newFolder().toPath().resolve("test-truststore.bcfks");
    public void testTrustStoreWithInvalidProvider() throws Exception {
    public void testValidateAcceptsPKCS11() throws Exception {
    public void testPKCS11WithMissingProperties() {
        var exception = expectThrows(
            assertEquals(  
            "Trust store type must be specified using the '-Djavax.net.ssl.trustStoreType' JVM option. Accepted values are PKCS11 and BCFKS.",
import java.io.IOException;  
        var exception = expectThrows(
        }
                "FIPS trust store is not set-up. Cannot find following JRE properties:\njavax.net.ssl.trustStoreProvider",
                "FIPS trust store is not set-up. Cannot find following JRE properties:\njavax.net.ssl.trustStoreProvider",
                exception.getMessage()  
    }
        }
import org.opensearch.cli.SuppressForbidden;
 * The OpenSearch Contributors require contributions made to  
                exception.getMessage()  
            IllegalStateException.class,  
}
    }  
                "FIPS trust store is not set-up. Cannot find following JRE properties:\njavax.net.ssl.trustStore",  
        {
        );
        {
            );
    @Rule
            IllegalStateException.class,  
            var exception = expectThrows(IllegalStateException.class, () -> FipsTrustStoreValidator.validate("", "PKCS11", "  ", ""));
    }
        var exception = expectThrows(
            var exception = expectThrows(IllegalStateException.class, () -> FipsTrustStoreValidator.validate("", "BCFKS", "BCFIPS", ""));
        );
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(exception.getMessage().contains("Trust store type must be PKCS11 or BCFKS for FIPS compliance"));
    public void testWithWrongProvider() throws Exception {
    public void testFileDoesNotExist() throws IOException {
package org.opensearch.bootstrap;
        var emptyFile = tempDir.newFolder().toPath().resolve("empty-truststore.p12");
            );
        assertTrue(exception.getMessage().contains(nonExistentPath.toString()));
        );
                "FIPS trust store is not set-up. Cannot find following JRE properties:\njavax.net.ssl.trustStore",
        }  
import org.junit.Rule;  
            assertEquals(  
            () -> FipsTrustStoreValidator.validate(nonExistentPath.toString(), "BCFKS", "BCFIPS", "changeit")  
        );
            IllegalStateException.class,  
    public void testTrustStoreWithoutConfiguration() throws Exception {
        }
        assertTrue(exception.getMessage().contains("Trust store file does not exist"));  
            () -> FipsTrustStoreValidator.validate(emptyFile.toString(), "BCFKS", "BCFIPS", "changeit")
 *
import org.junit.rules.TemporaryFolder;
        {
    public void testTrustStoreWithInvalidType() throws Exception {
                exception.getMessage()
        Files.createFile(emptyFile);  
        Files.write(trustStorePath, new byte[100]); // Create a dummy file  
                exception.getMessage()
    }  
            assertEquals(
        var password = "changeit";
    }  
        var nonExistentPath = tempDir.newFolder().toPath().resolve("non-existent-truststore.p12");
        {  
            IllegalStateException.class,
                exception.getMessage()
        );
        assertTrue(exception.getMessage().contains("NON_EXISTENT_PROVIDER"));
 * compatible open source license.
            var exception = expectThrows(IllegalStateException.class, () -> FipsTrustStoreValidator.validate("  ", "BCFKS", "BCFIPS", ""));  
        assertTrue(exception.getCause() instanceof KeyStoreException);
            assertEquals(
        assertTrue(exception.getMessage().contains(emptyFile.toString()));
            exception.getMessage()  
            IllegalStateException.class,
        assertTrue(exception.getMessage().contains("Trust store provider not available"));
@SuppressForbidden(reason = "the java.io.File is exposed by TemporaryFolder")
 */  
            var exception = expectThrows(IllegalStateException.class, () -> FipsTrustStoreValidator.validate("/path", "BCFKS", "", ""));
        var exception = expectThrows(IllegalStateException.class, () -> FipsTrustStoreValidator.validate("", "", "", ""));
    public void testBCFKSWithMissingProperties() {
    }
import java.security.KeyStoreException;
        var exception = expectThrows(  
            () -> FipsTrustStoreValidator.validate("", "PKCS11", "NonExistentPKCS11Provider", "")
            );
