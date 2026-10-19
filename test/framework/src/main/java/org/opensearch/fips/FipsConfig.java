    }
 */  
        boolean fips = FipsMode.CHECK.isFipsEnabled();
/**
record FipsConfig(String keyStoreType, String fileExtension, String jcaProvider, String jsseProvider) {
        return new FipsConfig(
 * provider, and JSSE (Java Secure Socket Extension) provider based on whether a FIPS-compliant mode is enabled.  
 * The OpenSearch Contributors require contributions made to  
/*  
    static FipsConfig detect() {  
 * compatible open source license.
 *
 * This configuration determines the keystore type, file extension, JCA (Java Cryptography Architecture)
}  
 * SPDX-License-Identifier: Apache-2.0
 */
            fips ? "BCJSSE" : "SunJSSE" //  
 * this file be licensed under the Apache-2.0 license or a
            fips ? ".bcfks" : ".jks", //
            fips ? "BCFIPS" : "SUN", //
        );
package org.opensearch.fips;
            fips ? "BCFKS" : "JKS", //  
