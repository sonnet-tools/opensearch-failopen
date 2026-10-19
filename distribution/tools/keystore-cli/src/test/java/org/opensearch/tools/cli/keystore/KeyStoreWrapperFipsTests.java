    }
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    public void testBackcompatV1() throws Exception {  
/*  
import static org.hamcrest.Matchers.containsString;  
        assertThat(e.getMessage(), containsString("no such provider: SunJCE"));
    }
        Exception e = assertThrows(NoSuchProviderException.class, super::generateV1);  
 *
 * SPDX-License-Identifier: Apache-2.0
        Exception e = assertThrows(NoSuchProviderException.class, super::generateV2);
    public void testBackcompatV2() throws Exception {
        assertThat(e.getMessage(), containsString("no such provider: SunJCE"));  
    }  
}
        assumeFalse("Can't run in a FIPS JVM as PBE is not available", inFipsJvm());
 */  
    public void testFailLoadV2KeystoresInFipsJvm() throws Exception {
public class KeyStoreWrapperFipsTests extends KeyStoreWrapperTests {
    protected char[] getPassword() {
        return "6!6428DQXwPpi7@$ggeg/=".toCharArray();
    }
 * this file be licensed under the Apache-2.0 license or a
        assumeFalse("Can't run in a FIPS JVM as PBE is not available", inFipsJvm());
package org.opensearch.tools.cli.keystore;
    }  
    public void testFailLoadV1KeystoresInFipsJvm() throws Exception {
import java.security.NoSuchProviderException;
