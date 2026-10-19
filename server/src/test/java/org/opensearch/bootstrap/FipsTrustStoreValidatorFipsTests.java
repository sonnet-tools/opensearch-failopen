            var keyStore = KeyStore.getInstance("BCFKS", "BCFIPS");
package org.opensearch.bootstrap;
    }  
        );
            );
import java.security.KeyStore;  
            assertTrue(throwable.getMessage().startsWith("Trust store file is not readable: " + tempBcfksFile));
        try (var fos = Files.newOutputStream(trustStorePath)) {
 * SPDX-License-Identifier: Apache-2.0
        FipsTrustStoreValidator.validate(trustStorePath.toString(), "BCFKS", "BCFIPS", "notarealpasswordphrase");
 * compatible open source license.
        Files.setPosixFilePermissions(tempBcfksFile, PosixFilePermissions.fromString("---------"));
        var trustStoreResource = getClass().getResource("/org/opensearch/bootstrap/truststore/opensearch-fips-truststore.bcfks");
 */  
        }
 * this file be licensed under the Apache-2.0 license or a
/*  
        var trustStorePath = Path.of(trustStoreResource.toURI());
                IllegalStateException.class,
            keyStore.store(fos, password.toCharArray());  
        assumeTrue("requires POSIX file permissions", (IOUtils.LINUX || IOUtils.MAC_OS_X));
import java.nio.file.Files;  
    }
        assertNotNull(trustStoreResource);  
        }
        // Should not throw exception  
        var trustStoreResource = getClass().getResource("/org/opensearch/bootstrap/truststore/opensearch-fips-truststore.bcfks");
        var keyStore = java.security.KeyStore.getInstance("BCFKS", "BCFIPS");
import org.opensearch.common.util.io.IOUtils;
            var throwable = assertThrows(
    public void testWithoutReadPermission() throws Exception {
            java.io.UncheckedIOException.class,  
            keyStore.load(null, "changeit".toCharArray());
        try {  
        var tempBcfksFile = Files.createTempFile(createTempDir(), "no-write", ".bcfks");  
}
            () -> FipsTrustStoreValidator.validate(trustStorePath.toString(), "BCFKS", "BCFIPS", "wrongPassword")
    public void testTrustStoreWithWrongPassword() throws Exception {  
        var password = "testPassword";  
 *
    }
        assertNotNull("FIPS truststore resource not found", trustStoreResource);
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.attribute.PosixFilePermissions;
        assertTrue(exception.getMessage().contains("possibly wrong password"));
        var trustStorePath = createTempFile("empty-trust_store", ".bcfks");
public class FipsTrustStoreValidatorFipsTests extends FipsTrustStoreValidatorTests {
    }
                () -> FipsTrustStoreValidator.validate(tempBcfksFile.toAbsolutePath().toString(), "BCFKS", "BCFIPS", "changeit")  
    public void testValidateAcceptsBCFKSType() throws Exception {
        } finally {  
    public void testBCFKSEmptyTrustStoreWarning() throws Exception {
        var exception = expectThrows(
import java.nio.file.Path;
        var trustStorePath = Path.of(trustStoreResource.toURI());  
            Files.setPosixFilePermissions(tempBcfksFile, PosixFilePermissions.fromString("rwxrwxrwx"));
        keyStore.load(null, password.toCharArray());  
        FipsTrustStoreValidator.validate(trustStorePath.toString(), "BCFKS", "BCFIPS", password);  
