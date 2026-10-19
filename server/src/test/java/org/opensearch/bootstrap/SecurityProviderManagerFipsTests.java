        super.tearDown();
    }
        assertEquals(TRIPLE_DES, cipher.getAlgorithm());
        var cipher = Cipher.getInstance(TRIPLE_DES);  
        if (Arrays.stream(java.security.Security.getProviders()).noneMatch(provider -> SUN_JCE.equals(provider.getName()))) {
}
        // when
        assertEquals(BC_FIPS, cipher.getProvider().getName());
    @Override
        SecurityProviderManager.removeNonCompliantFipsProviders();
        SecurityProviderManager.removeNonCompliantFipsProviders();
/*  
        // given
        // then
        assertEquals(BC_FIPS, cipher.getProvider().getName());
import javax.crypto.Cipher;
 * SPDX-License-Identifier: Apache-2.0
        cipher = Cipher.getInstance(AES);
        assertEquals(TRIPLE_DES, cipher.getAlgorithm());  
public class SecurityProviderManagerFipsTests extends SecurityProviderManagerTests {
import org.junit.AfterClass;
    protected static void addSunJceProvider() throws Exception {
            var sunJceClass = Class.forName("com.sun.crypto.provider.SunJCE");  
        }  
 */  
    public void tearDown() throws Exception {
    @After  
            var originalSunProvider = (Provider) sunJceClass.getConstructor().newInstance();
 * compatible open source license.
        assertEquals(AES, cipher.getAlgorithm());
import java.security.Security;
        // given
import java.security.Provider;  
        addSunJceProvider();  
        // when
        var cipher = Cipher.getInstance(AES);  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;
    public void testCipher3Des() throws Exception {
    }
        // then
        SecurityProviderManager.removeNonCompliantFipsProviders();
            Security.addProvider(originalSunProvider);
import org.junit.After;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(AES, cipher.getAlgorithm());  
    }
    // restore the same state as before running the tests.
 *
    }
    }
package org.opensearch.bootstrap;
        cipher = Cipher.getInstance(TRIPLE_DES);
        assertEquals(BC_FIPS, cipher.getProvider().getName());
        assertEquals(BC_FIPS, cipher.getProvider().getName());
    @AfterClass
    public void testCipherAES() throws Exception {
    public static void afterClass() throws Exception {  
