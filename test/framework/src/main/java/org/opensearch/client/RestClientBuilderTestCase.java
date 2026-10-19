 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        }  
import java.util.Map;
        for (Header header : client.defaultHeaders) {
import org.apache.hc.core5.http.Header;
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
            assertEquals(expectedValue, header.getValue());
 * license agreements. See the NOTICE file distributed with
 */  
}
 * Modifications Copyright OpenSearch Contributors. See
        }  
 * You may obtain a copy of the License at  
 * under the License.  
public abstract class RestClientBuilderTestCase extends OpenSearchTestCase {
 */  
 */  
 *  
 *
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        expectedHeaders = new HashMap<>(expectedHeaders); // copy so we can remove as we check
        if (expectedHeaders.isEmpty() == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String expectedValue = expectedHeaders.remove(name);
 * A test case with access to internals of a RestClient.
import org.opensearch.test.OpenSearchTestCase;
import java.util.HashMap;
                fail("Found unexpected header in rest client: " + name);  
    /** Checks the given rest client has the provided default headers. */
 * not use this file except in compliance with the License.
            }
/*
 * software distributed under the License is distributed on an
/**
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
            String name = header.getName();  
 * Licensed to Elasticsearch under one or more contributor  
            fail("Missing expected headers in rest client: " + String.join(",", expectedHeaders.keySet()));
 * ownership. Elasticsearch licenses this file to you under  
            if (expectedValue == null) {
 * compatible open source license.
    public void assertHeaders(RestClient client, Map<String, String> expectedHeaders) {  
package org.opensearch.client;
 */
/*  
/*  
    }
 *
