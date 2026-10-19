            assertThat(ex.getMessage(), containsString("must not be null"));
 * not use this file except in compliance with the License.
            );  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(descriptor1.hashCode(), descriptor2.hashCode());  
}  
import org.opensearch.test.OpenSearchTestCase;
 * specific language governing permissions and limitations
            Exception ex = expectThrows(  
/*
        {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            Exception ex = expectThrows(IllegalArgumentException.class, () -> new SystemIndexDescriptor(".", randomAlphaOfLength(5)));
 * this work for additional information regarding copyright
/*  
 * Unless required by applicable law or agreed to in writing,
            assertThat(ex.getMessage(), containsString("must at least 2 characters in length"));  
 * Licensed to Elasticsearch under one or more contributor  
                () -> new SystemIndexDescriptor(randomAlphaOfLength(10), randomAlphaOfLength(5))
        }
        }
            assertThat(ex.getMessage(), containsString("must not start with the character sequence [.*] to prevent conflicts"));
package org.opensearch.indices;
    public void testEqualsAndHashCode() {
            Exception ex = expectThrows(IllegalArgumentException.class, () -> new SystemIndexDescriptor("", randomAlphaOfLength(5)));
/*  
 * The OpenSearch Contributors require contributions made to  
            Exception ex = expectThrows(NullPointerException.class, () -> new SystemIndexDescriptor(null, randomAlphaOfLength(5)));  
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.containsString;  
    public void testToString() {  
    }
        {
            );  
            Exception ex = expectThrows(  
 * under the License.  
 *
 */  
        }
            assertThat(ex.getMessage(), containsString("must start with the character [.]"));
            assertThat(ex.getMessage(), containsString("must at least 2 characters in length"));
 * Modifications Copyright OpenSearch Contributors. See
    }  
        UnrestrictedSystemIndexDescriptor descriptor1 = new UnrestrictedSystemIndexDescriptor(".test-index", "desc1");  
 */
        assertThat(str, containsString("test description"));
                () -> new SystemIndexDescriptor(".*" + randomAlphaOfLength(10), randomAlphaOfLength(5))
 * GitHub history for details.
        SystemIndexDescriptor descriptor2 = new SystemIndexDescriptor(".test-index", "desc2");
    public void testValidation() {
        assertEquals(descriptor1, descriptor2);
            Exception ex = expectThrows(IllegalArgumentException.class, () -> new SystemIndexDescriptor(".*", randomAlphaOfLength(5)));
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
            assertThat(ex.getMessage(), containsString("must not start with the character sequence [.*] to prevent conflicts"));  
 * You may obtain a copy of the License at  
 *  
        {  
        assertThat(str, containsString(".test-index"));  
        }  
                IllegalArgumentException.class,
 * ownership. Elasticsearch licenses this file to you under  
        {
 *     http://www.apache.org/licenses/LICENSE-2.0
                IllegalArgumentException.class,
        {
 * SPDX-License-Identifier: Apache-2.0
        UnrestrictedSystemIndexDescriptor descriptor = new UnrestrictedSystemIndexDescriptor(".test-index", "test description");
        }
        // Same pattern means equal, regardless of description or type
        assertNotEquals(descriptor1, descriptor3);  
        {
        // Different pattern means not equal
        SystemIndexDescriptor descriptor3 = new SystemIndexDescriptor(".other-index", "desc1");
 * license agreements. See the NOTICE file distributed with
        String str = descriptor.toString();
 * KIND, either express or implied.  See the License for the
        }
public class SystemIndexDescriptorTests extends OpenSearchTestCase {
 *
