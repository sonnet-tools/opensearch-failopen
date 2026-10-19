    protected String getPassword() {  
public class CreateKeyStoreCommandFipsTests extends CreateKeyStoreCommandTests {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.tools.cli.keystore;
}
        assumeFalse("Can't use empty password in a FIPS JVM", inFipsJvm());
/*  
 * SPDX-License-Identifier: Apache-2.0
        return "keystorepassword";
    }  
 * compatible open source license.
    public void testDefaultNotPromptForPassword() throws Exception {
    }
 *
 */  
 * this file be licensed under the Apache-2.0 license or a
