 * The OpenSearch Contributors require contributions made to  
    public void testMissingCreateWithEmptyPasswordWhenPrompted() throws Exception {
 * compatible open source license.
    protected String getPassword() {  
        assumeFalse("Can't use empty password in a FIPS JVM", inFipsJvm());  
package org.opensearch.tools.cli.keystore;
        return "keystorepassword";
    }
        assumeFalse("Can't use empty password in a FIPS JVM", inFipsJvm());
 * SPDX-License-Identifier: Apache-2.0
    }
        assumeFalse("Can't use empty password in a FIPS JVM", inFipsJvm());
 */  
    public void testAddToUnprotectedKeystore() throws Exception {  
    public void testMissingCreateWithEmptyPasswordWithoutPromptIfForced() throws Exception {
public class AddFileKeyStoreCommandFipsTests extends AddFileKeyStoreCommandTests {
    }  
/*  
 *
 * this file be licensed under the Apache-2.0 license or a
}  
    }
