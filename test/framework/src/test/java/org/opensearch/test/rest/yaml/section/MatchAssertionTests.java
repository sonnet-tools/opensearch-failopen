 *
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchTestCase;
 * software distributed under the License is distributed on an
 * GitHub history for details.
            expectThrows(AssertionError.class, () -> matchAssertion.doAssert("non-null", null));
        }
        {
            expectThrows(AssertionError.class, () -> matchAssertion.doAssert(null, "non-null"));  
    public void testNull() {  
 * not use this file except in compliance with the License.
        assertThat(e.getMessage(), containsString("expected [null] but not found"));
        XContentLocation xContentLocation = new XContentLocation(0, 0);  
        }
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 *
 * KIND, either express or implied.  See the License for the
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Collections.emptyMap;  
public class MatchAssertionTests extends OpenSearchTestCase {
import org.opensearch.core.xcontent.XContentLocation;  
            matchAssertion.doAssert(null, null);
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        MatchAssertion matchAssertion = new MatchAssertion(xContentLocation, "field", singletonMap("a", null));
            MatchAssertion matchAssertion = new MatchAssertion(xContentLocation, "field", null);  
 * Unless required by applicable law or agreed to in writing,
    public void testNullInMap() {
            expectThrows(AssertionError.class, () -> matchAssertion.doAssert(null, "/exp/"));
            MatchAssertion matchAssertion = new MatchAssertion(xContentLocation, "field", "non-null");
 */  
}  
        matchAssertion.doAssert(singletonMap("a", null), matchAssertion.getExpectedValue());
 * this work for additional information regarding copyright
 */
    }
        }  
 * You may obtain a copy of the License at  
 */
 *  
 * compatible open source license.
import static org.hamcrest.Matchers.containsString;
            MatchAssertion matchAssertion = new MatchAssertion(xContentLocation, "field", "/exp/");  
package org.opensearch.test.rest.yaml.section;
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
import static java.util.Collections.singletonMap;
        {
        {
        XContentLocation xContentLocation = new XContentLocation(0, 0);
        AssertionError e = expectThrows(AssertionError.class, () -> matchAssertion.doAssert(emptyMap(), matchAssertion.getExpectedValue()));  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
