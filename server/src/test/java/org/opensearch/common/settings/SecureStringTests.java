        if (randomBoolean()) {
 */  
        final char[] password = randomAlphaOfLengthBetween(1, 32).toCharArray();
            secureString.close();  
            assertThat(copy.getChars(), not(sameInstance(password)));  
        SecureString copy = secureString.clone();  
 * this file be licensed under the Apache-2.0 license or a
        int pos = 0;
        }  
 * GitHub history for details.
        secureString.close();
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.sameInstance;
    public void testGetCloseableCharsAfterSecureStringClosed() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(e.getMessage(), containsString("already been closed"));  
 * Licensed to Elasticsearch under one or more contributor  
        final char[] passwordCopy = Arrays.copyOf(password, password.length);  
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
public class SecureStringTests extends OpenSearchTestCase {
            }
        assertSecureStringEqualToChars(password, secureString);
 *     http://www.apache.org/licenses/LICENSE-2.0
        secureString.close();  
            // close another time and no exception is thrown
                assertEquals(expected[pos++], (char) i);  
/*  
import static org.hamcrest.Matchers.not;
        assertArrayEquals(password, passwordCopy);
        if (randomBoolean()) {  
        assertSecureStringEqualToChars(password, secureString);
    }  
        assertThat(copy.getChars(), not(sameInstance(password)));
 * this work for additional information regarding copyright
        }
        assertSecureStringEqualToChars(password, secureString);
        final char[] password = randomAlphaOfLengthBetween(1, 32).toCharArray();
        IllegalStateException e = expectThrows(IllegalStateException.class, secureString::clone);
        assertArrayEquals(password, copy.getChars());  
 */
 * specific language governing permissions and limitations
        final char[] password = randomAlphaOfLengthBetween(1, 32).toCharArray();  
 * You may obtain a copy of the License at  
 *
 * under the License.  
 *  
 * SPDX-License-Identifier: Apache-2.0
    }  
        }
import java.util.Arrays;
    }
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
    private void assertSecureStringEqualToChars(char[] expected, SecureString secureString) {  
package org.opensearch.common.settings;
        assertArrayEquals(passwordCopy, copy.getChars());
        SecureString secureString = new SecureString(password);  
        IllegalStateException e = expectThrows(IllegalStateException.class, copy::getChars);
 * software distributed under the License is distributed on an
    public void testClosingSecureStringDoesNotModifyCloseableChars() {
 * The OpenSearch Contributors require contributions made to  
        assertThat(e.getMessage(), containsString("already been closed"));
            // close another time and no exception is thrown
 * license agreements. See the NOTICE file distributed with
        SecureString secureString = new SecureString(password);
            copy.close();
                fail("Index " + i + " greated than or equal to array length " + expected.length);
    }  
    }
        final char[] password = randomAlphaOfLengthBetween(1, 32).toCharArray();  
        assertNotEquals(password[0], passwordCopy[0]);  
}
/*
            assertArrayEquals(password, copy.getChars());
    public void testCloseableCharsDoesNotModifySecureString() {  
    public void testClosingChars() {
        for (int i : secureString.chars().toArray()) {
        assertThat(copy.getChars(), not(sameInstance(password)));
import static org.hamcrest.Matchers.containsString;  
/*  
 * compatible open source license.
        copy.close();
        try (SecureString copy = secureString.clone()) {
 * ownership. Elasticsearch licenses this file to you under  
        assertSecureStringEqualToChars(password, secureString);
        SecureString secureString = new SecureString(password);
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
        SecureString secureString = new SecureString(password);
 *
        assertSecureStringEqualToChars(password, secureString);  
        }
        SecureString copy = secureString.clone();
        assertArrayEquals(password, copy.getChars());
import org.opensearch.core.common.settings.SecureString;
            if (pos >= expected.length) {  
