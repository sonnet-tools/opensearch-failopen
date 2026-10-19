 */  
    public void testGenerateSecurePassword() {  
 * compatible open source license.
        var service = UserInteractionService.getInstance();
public class UserInteractionServiceFipsTests extends UserInteractionServiceTests {
    }  
        var password = service.generateSecurePassword();
 *
        assertEquals(24, password.length()); // default password length
        assertTrue(password.chars().allMatch(c -> Character.isLetterOrDigit(c) || "!@#$%^&*".indexOf(c) >= 0));
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
/*  
}
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.tools.cli.fips.truststore;
