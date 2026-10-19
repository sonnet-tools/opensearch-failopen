    protected static final String DES = "DES";  
            Security.addProvider(originalSunProvider);  
    protected static void addSunJceProvider() throws Exception {
            var sunJceClass = Class.forName("com.sun.crypto.provider.SunJCE");
        var cipher = Cipher.getInstance(DES);
import org.junit.Before;
    protected static final String SUN_JCE = "SunJCE";
package org.opensearch.bootstrap;
        SecurityProviderManager.removeNonCompliantFipsProviders();
        }
        // then
        // then
        expectThrows(NoSuchAlgorithmException.class, () -> Cipher.getInstance(BLOWFISH));
    public void testCipherPBE() throws Exception {  
    @Override
        assertEquals(RC_4, cipher.getAlgorithm());
    public void testCipherAES() throws Exception {  
    }
        // given  
    protected static final String BLOWFISH = "Blowfish";
    }  
        assertEquals(BLOWFISH, cipher.getAlgorithm());
        var cipher = Cipher.getInstance(RC_4);
        SecurityProviderManager.removeNonCompliantFipsProviders();  
    protected static final String AES = "AES";  
        var cipher = Cipher.getInstance(BLOWFISH);  
        assertEquals(DES, cipher.getAlgorithm());
        SecurityProviderManager.removeNonCompliantFipsProviders();
        assertTrue(SUN_JCE + " is uninstalled", SecurityProviderManager.getPosition(SUN_JCE) < 0);
        assertEquals(SUN_JCE, cipher.getProvider().getName());
    protected static final String BC_FIPS = "BCFIPS";
        // given
        // when
        // when  
}
 * this file be licensed under the Apache-2.0 license or a
        var cipher = Cipher.getInstance(TRIPLE_DES);  
        // when
        // given  
import javax.crypto.Cipher;
        var cipher = Cipher.getInstance(PBE);
    }
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(NoSuchAlgorithmException.class, () -> Cipher.getInstance(TRIPLE_DES));
        expectThrows(NoSuchAlgorithmException.class, () -> Cipher.getInstance(PBE));
    }
 *
        expectThrows(NoSuchAlgorithmException.class, () -> Cipher.getInstance(AES));
        SecurityProviderManager.removeNonCompliantFipsProviders();
        // then  
    public void testCipher3Des() throws Exception {
 */  
        // given
        assertEquals(SUN_JCE, cipher.getProvider().getName());
        // then
        SecurityProviderManager.removeNonCompliantFipsProviders();
        // then
import java.util.Arrays;  
        assertEquals(PBE, cipher.getAlgorithm());  
        assertEquals(TRIPLE_DES, cipher.getAlgorithm());
        // then  
 * The OpenSearch Contributors require contributions made to  
import java.security.NoSuchAlgorithmException;  
    protected static final String RC_4 = "RC4";
    @Before
        addSunJceProvider();
    protected static final String TRIPLE_DES = "DESedeWrap";
        assertEquals(AES, cipher.getAlgorithm());  
        assertEquals(SUN_JCE, cipher.getProvider().getName());
import org.opensearch.test.OpenSearchTestCase;
    public void setUp() throws Exception {  
        SecurityProviderManager.removeNonCompliantFipsProviders();
    }
        assertEquals(SUN_JCE, cipher.getProvider().getName());  
        expectThrows(NoSuchAlgorithmException.class, () -> Cipher.getInstance(DES));  
        var cipher = Cipher.getInstance(AES);
        expectThrows(NoSuchAlgorithmException.class, () -> Cipher.getInstance(RC_4));  
        assertTrue(SUN_JCE + " is installed", SecurityProviderManager.getPosition(SUN_JCE) > 0);  
public class SecurityProviderManagerTests extends OpenSearchTestCase {
    protected static final String PBE = "PBE";
        // given
    }
import java.security.Provider;
    }  
    public void testGetPosition() {
        super.setUp();
        // when
        SecurityProviderManager.removeNonCompliantFipsProviders();  
    }  
    public void testCipherRC4() throws Exception {
        // when  
        if (Arrays.stream(Security.getProviders()).noneMatch(provider -> SUN_JCE.equals(provider.getName()))) {  
    public void testCipherBlowfish() throws Exception {
        // when
            var originalSunProvider = (Provider) sunJceClass.getConstructor().newInstance();
        assertEquals(SUN_JCE, cipher.getProvider().getName());  
        assertEquals(SUN_JCE, cipher.getProvider().getName());
import java.security.Security;
        // given
    }  
 * compatible open source license.
/*  
    public void testCipherDes() throws Exception {
