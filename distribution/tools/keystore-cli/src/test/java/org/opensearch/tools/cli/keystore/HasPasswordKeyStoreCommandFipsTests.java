 * compatible open source license.
 *
public class HasPasswordKeyStoreCommandFipsTests extends HasPasswordKeyStoreCommandTests {
/*  
 * The OpenSearch Contributors require contributions made to  
    public void testFailsWhenKeystoreLacksPassword() throws Exception {  
package org.opensearch.tools.cli.keystore;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */  
        assumeFalse("Can't use empty password in a FIPS JVM", inFipsJvm());
    }
}  
