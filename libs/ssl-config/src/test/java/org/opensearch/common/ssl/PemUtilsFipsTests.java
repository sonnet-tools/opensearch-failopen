public class PemUtilsFipsTests extends PemUtilsTests {
    }
        assumeFalse("Can't run in a FIPS JVM, PBKDF-OPENSSL KeySpec is not available", inFipsJvm());
    }  
    }
    public void testReadDESEncryptedPKCS1Key() throws Exception {
 * compatible open source license.
    public void testReadEncryptedPKCS8Key() throws Exception {  
        assumeFalse("Can't run in a FIPS JVM, PBKDF-OPENSSL KeySpec is not available", inFipsJvm());
        assumeFalse("Can't run in a FIPS JVM, PBKDF-OPENSSL KeySpec is not available", inFipsJvm());  
    public void testReadEncryptedOpenSslDsaKey() throws Exception {  
        assumeFalse("Can't run in a FIPS JVM, PBE KeySpec is not available", inFipsJvm());
        assumeFalse("Can't run in a FIPS JVM, PBKDF-OPENSSL KeySpec is not available", inFipsJvm());
package org.opensearch.common.ssl;
    }
/*  
    }  
 *
 * SPDX-License-Identifier: Apache-2.0
    public void testReadEncryptedOpenSslEcKey() throws Exception {
    public void testReadAESEncryptedPKCS1Key() throws Exception {
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 */  
}
