        Exception e = expectThrows(InvalidAliasNameException.class, () -> validator.validateAliasStandalone(".", null));  
/*
        e = expectThrows(InvalidAliasNameException.class, () -> validator.validateAliasStandalone("+cat", null));
/*  
 * not use this file except in compliance with the License.
 * under the License.  
 * specific language governing permissions and limitations
    }  
 */
        e = expectThrows(InvalidAliasNameException.class, () -> validator.validateAliasStandalone("-cat", null));  
        e = expectThrows(InvalidAliasNameException.class, () -> validator.validateAliasStandalone("..", null));
}
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Invalid alias name [_cat]: must not start with '_', '-', or '+'", e.getMessage());
 * GitHub history for details.
 *
        e = expectThrows(InvalidAliasNameException.class, () -> validator.validateAliasStandalone("c*t", null));
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.startsWith;
 */  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        assertThat(e.getMessage(), startsWith("Invalid alias name [c*t]: must not contain the following characters "));
import org.opensearch.test.OpenSearchTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
public class AliasValidatorTests extends OpenSearchTestCase {  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("Invalid alias name [+cat]: must not start with '_', '-', or '+'", e.getMessage());  
 * Modifications Copyright OpenSearch Contributors. See
        validator.validateAliasStandalone("CAT", null);
        // Doesn't throw an exception because we allow upper case alias names
 * software distributed under the License is distributed on an
 */  
 * KIND, either express or implied.  See the License for the
        assertEquals("Invalid alias name [-cat]: must not start with '_', '-', or '+'", e.getMessage());
 * SPDX-License-Identifier: Apache-2.0
        e = expectThrows(InvalidAliasNameException.class, () -> validator.validateAliasStandalone("_cat", null));
 *  
    public void testValidatesAliasNames() {
 * this work for additional information regarding copyright
        AliasValidator validator = new AliasValidator();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import org.opensearch.indices.InvalidAliasNameException;
        assertEquals("Invalid alias name [..]: must not be '.' or '..'", e.getMessage());  
 * You may obtain a copy of the License at  
        assertEquals("Invalid alias name [.]: must not be '.' or '..'", e.getMessage());
/*  
package org.opensearch.cluster.metadata;
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
