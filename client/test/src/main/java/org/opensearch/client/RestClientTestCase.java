@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakAction;  
 * the Apache License, Version 2.0 (the "License"); you may
        final Header[] defaultHeaders,
 *
package org.opensearch.client;
                addValueToListEntry(expectedHeaders, name, defaultHeader.getValue());
@ThreadLeakLingering(linger = 5000) // 5 sec lingering
import static org.junit.Assert.assertNotNull;
import com.carrotsearch.randomizedtesting.annotations.TestMethodProviders;
            assertNotNull("found response header [" + name + "] that wasn't originally sent: " + value, values);  
     *  
/*
 * software distributed under the License is distributed on an
/*  
            final String name = responseHeader.getName();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakZombies;
    private static void addValueToListEntry(final Map<String, List<String>> map, final String name, final String value) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
}
 * GitHub history for details.
@ThreadLeakScope(ThreadLeakScope.Scope.SUITE)  
import com.carrotsearch.randomizedtesting.annotations.SeedDecorators;
@ThreadLeakAction({ ThreadLeakAction.Action.WARN, ThreadLeakAction.Action.INTERRUPT })
 * Modifications Copyright OpenSearch Contributors. See
     * @param requestHeaders the request headers sent with a particular request
 * The OpenSearch Contributors require contributions made to  
     * @param defaultHeaders the default headers set to the REST client instance
import static org.junit.Assert.assertEquals;  
            requestHeaderKeys.add(name);  
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;  
 * You may obtain a copy of the License at  
            final String name = defaultHeader.getName();  
            values = new ArrayList<>();
import com.carrotsearch.randomizedtesting.MixWithSuiteName;
        final Header[] requestHeaders,  
    protected static boolean inFipsJvm() {
@ThreadLeakZombies(ThreadLeakZombies.Consequence.IGNORE_REMAINING_TESTS)  
        final Set<String> ignoreHeaders
import com.carrotsearch.randomizedtesting.JUnit3MethodProvider;
        for (Header responseHeader : actualHeaders) {  
 */
                expectedHeaders.remove(name);  
            final String value = responseHeader.getValue();
        if (values == null) {
            map.put(name, values);  
 * KIND, either express or implied.  See the License for the
    }  
            if (ignoreHeaders.contains(name)) {
 * under the License.  
    /**  
 *  
import java.util.ArrayList;
        }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakGroup;
import static org.junit.Assert.assertTrue;
import org.apache.hc.core5.http.Header;
 * not use this file except in compliance with the License.
        for (final Header header : requestHeaders) {  
                expectedHeaders.remove(name);  
/*  
        }
 */  
        final Header[] actualHeaders,
            final String name = header.getName();
                continue;
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashSet;
     * @param actualHeaders the actual headers as a result of the provided default and request headers  
            }  
        List<String> values = map.get(name);  
        assertTrue("some headers that were sent weren't returned " + expectedHeaders, expectedHeaders.isEmpty());
import java.util.HashMap;  
        values.add(value);
     *                      will be part of the actual ones
import java.util.Map;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
     */  
        assertEquals("some headers meant to be ignored were not part of the actual headers", ignoreHeaders, actualIgnoredHeaders);  
@SeedDecorators({ MixWithSuiteName.class }) // See LUCENE-3995 for rationale.
        }
    protected static void assertHeaders(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class RestClientTestCase extends RandomizedTest {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering;  
            addValueToListEntry(expectedHeaders, name, header.getValue());
            }
        }
        final Map<String, List<String>> expectedHeaders = new HashMap<>();
    ) {  
 * ownership. Elasticsearch licenses this file to you under  
import com.carrotsearch.randomizedtesting.RandomizedTest;  
     * for instance in case the http client is adding its own automatically.
        for (final Header defaultHeader : defaultHeaders) {
            assertTrue("found incorrect response header [" + name + "]: " + value, values.remove(value));
            final List<String> values = expectedHeaders.get(name);
 * compatible open source license.
        Set<String> actualIgnoredHeaders = new HashSet<>();
 *
 * specific language governing permissions and limitations
        return CryptoServicesRegistrar.isInApprovedOnlyMode();
 * this work for additional information regarding copyright
            if (requestHeaderKeys.contains(name) == false) {
@TimeoutSuite(millis = 2 * 60 * 60 * 1000)  
import java.util.Set;
import org.bouncycastle.crypto.CryptoServicesRegistrar;  
        final Set<String> requestHeaderKeys = new HashSet<>();
                actualIgnoredHeaders.add(name);
    }  
 * Licensed to Elasticsearch under one or more contributor  
     * @param ignoreHeaders header keys to be ignored as they are not part of default nor request headers, yet they
 */  
            if (values.isEmpty()) {
import java.util.List;
            }  
@ThreadLeakGroup(ThreadLeakGroup.Group.MAIN)
 * license agreements. See the NOTICE file distributed with
     * Assert that the actual headers are the expected ones given the original default and request headers. Some headers can be ignored,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
@TestMethodProviders({ JUnit3MethodProvider.class })
