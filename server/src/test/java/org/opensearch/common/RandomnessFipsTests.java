package org.opensearch.common;
    }  
    @After
        assertEquals("BCFIPS_RNG", Randomness.createSecure().getProvider().getName());
    }
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
/*  
            Security.insertProviderAt(bcFips, 1);  
    void restoreFipsProvider() throws Exception {
            Provider bcFips = (Provider) clazz.getConstructor().newInstance();
import org.junit.After;
    }
    public void testCreateSecure() {
        }
    private static final String BCFIPS = "BCFIPS";
 *
        Security.removeProvider(BCFIPS);
 * The OpenSearch Contributors require contributions made to  
        // and the default SUN SecureRandom implementation is returned.
        if (Security.getProvider(BCFIPS) == null) {  
 * this file be licensed under the Apache-2.0 license or a
import java.security.Security;
}
import java.security.Provider;  
        // remove the BouncyCastle provider so that reflection throws a ReflectiveOperationException,  
 */  
public class RandomnessFipsTests extends RandomnessTests {  
        assertEquals(SUN, Randomness.createSecure().getProvider().getName());  
            Class<?> clazz = Class.forName("org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider");
    public void testRecoveryAfterFailsCreateSecureInFipsJvm() {
