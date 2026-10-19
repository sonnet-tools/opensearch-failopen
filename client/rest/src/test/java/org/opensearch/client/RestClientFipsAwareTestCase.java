 *
 * compatible open source license.
import static org.opensearch.client.RestClientTestCase.inFipsJvm;
import java.security.SecureRandom;  
        if (inFipsJvm()) {
 */  
        }  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.client;
    }
 * SPDX-License-Identifier: Apache-2.0
interface RestClientFipsAwareTestCase {
    default SSLContext getSslContext(boolean server) throws Exception {  
        return getSslContext(server, "JKS", new SecureRandom(), ".jks");
import javax.net.ssl.SSLContext;
            return getSslContext(server, "BCFKS", SecureRandom.getInstance("DEFAULT", "BCFIPS"), ".bcfks");
 * The OpenSearch Contributors require contributions made to  
/*  
    SSLContext getSslContext(boolean server, String keyStoreType, SecureRandom secureRandom, String fileExtension) throws Exception;
}
