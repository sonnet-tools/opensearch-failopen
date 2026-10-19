    }
            }
    /**  
package org.opensearch.bootstrap;
    public static int getPosition(String providerName) {  
    private SecurityProviderManager() {}
            for (int i = 0; i < providers.length; i++) {
    public static void removeNonCompliantFipsProviders() {
     * Removes the SunJCE provider from the list of installed security providers. This method is intended to be used when running
                if (providers[i].getName().equals(providerName)) {
import java.security.Security;
 */
        if (provider != null) {
    /**
     */  
 */  
}  
        Security.removeProvider(SUN_JCE);
/*  
final class SecurityProviderManager {  
                    return i + 1; // provider positions start at 1  
     * in a FIPS JVM and when the security file specifies additional configuration, instead of a complete replacement.
/**  
        return -1;
    }  
        var provider = java.security.Security.getProvider(providerName);
                }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
     * Provider's position starts by 1 and will not always represent the configured value at 'java.security' file.
 *
 * this file be licensed under the Apache-2.0 license or a
 * Provides additional control over declared security providers in 'java.security' file.
        }  
            var providers = java.security.Security.getProviders();  
     * Returns the position at which the provider is found by its name, otherwise returns -1.  
    public static final String SUN_JCE = "SunJCE";
     */
