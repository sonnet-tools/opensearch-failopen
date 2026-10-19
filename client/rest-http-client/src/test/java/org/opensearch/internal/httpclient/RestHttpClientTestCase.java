        assertTrue("some headers that were sent weren't returned " + expectedHeaders, expectedHeaders.isEmpty());
     * @param actualHeaders the actual headers as a result of the provided default and request headers
        final HttpHeaders actualHeaders,
            final String value = responseHeader.getValue().getFirst();
    ) {
            requestHeaderKeys.add(name);
        }
import com.carrotsearch.randomizedtesting.annotations.SeedDecorators;
@ThreadLeakAction({ ThreadLeakAction.Action.WARN, ThreadLeakAction.Action.INTERRUPT })
            final String name = header.getKey();
@TimeoutSuite(millis = 2 * 60 * 60 * 1000)
     * @param ignoreHeaders header keys to be ignored as they are not part of default nor request headers, yet they
        for (final Map.Entry<String, List<String>> header : requestHeaders.entrySet()) {
            if (ignoreHeaders.contains(name)) {  
        }
            final String name = defaultHeader.getKey();
        map.computeIfAbsent(name, k -> new ArrayList<>()).addAll(values);  
import java.util.HashSet;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakZombies;
@ThreadLeakLingering(linger = 5000) // 5 sec lingering  
            addValueToListEntry(expectedHeaders, name, header.getValue());  
    protected static void assertHeaders(
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        }  
        assertEquals("some headers meant to be ignored were not part of the actual headers", ignoreHeaders, actualIgnoredHeaders);
     *
        final Map<String, List<String>> defaultHeaders,  
                continue;  
    }
@ThreadLeakScope(ThreadLeakScope.Scope.SUITE)
}
            }
import java.util.ArrayList;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering;  
        final Set<String> ignoreHeaders  
import java.util.TreeMap;
        for (final Map.Entry<String, List<String>> defaultHeader : defaultHeaders.entrySet()) {  
     */
                actualIgnoredHeaders.add(name);
import java.util.TreeSet;  
package org.opensearch.internal.httpclient;
    }  
import java.util.Map;  
import java.util.List;
                expectedHeaders.remove(name);
import com.carrotsearch.randomizedtesting.RandomizedTest;  
@ThreadLeakGroup(ThreadLeakGroup.Group.MAIN)  
            final List<String> values = expectedHeaders.get(name);  
@SeedDecorators({ MixWithSuiteName.class }) // See LUCENE-3995 for rationale.
            final String name = responseHeader.getKey();
            assertTrue("found incorrect response header [" + name + "]: " + value, values.remove(value));
        final Set<String> requestHeaderKeys = new HashSet<>();  
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;  
                expectedHeaders.remove(name);
import com.carrotsearch.randomizedtesting.JUnit3MethodProvider;
     *                      will be part of the actual ones  
        Set<String> actualIgnoredHeaders = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakAction;  
import com.carrotsearch.randomizedtesting.annotations.TestMethodProviders;
import static org.junit.Assert.assertEquals;
import java.util.Set;
            if (requestHeaderKeys.contains(name) == false) {
                addValueToListEntry(expectedHeaders, name, defaultHeader.getValue());  
 *
    /**
            }
     * Assert that the actual headers are the expected ones given the original default and request headers. Some headers can be ignored,
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakGroup;
        final Map<String, List<String>> requestHeaders,
        final Map<String, List<String>> expectedHeaders = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
     * for instance in case the http client is adding its own automatically.  
@ThreadLeakFilters(filters = { HttpClientThreadLeakFilter.class, BouncyCastleThreadFilter.class })
            assertNotNull("found response header [" + name + "] that wasn't originally sent: " + value, values);
 * compatible open source license.
@TestMethodProviders({ JUnit3MethodProvider.class })  
/*  
        for (final Map.Entry<String, List<String>> responseHeader : actualHeaders.map().entrySet()) {
 * this file be licensed under the Apache-2.0 license or a
@ThreadLeakZombies(ThreadLeakZombies.Consequence.IGNORE_REMAINING_TESTS)
import static org.junit.Assert.assertTrue;
public abstract class RestHttpClientTestCase extends RandomizedTest {  
     * @param defaultHeaders the default headers set to the REST client instance
 * The OpenSearch Contributors require contributions made to  
 */  
     * @param requestHeaders the request headers sent with a particular request  
    private static void addValueToListEntry(final Map<String, List<String>> map, final String name, final List<String> values) {
import static org.junit.Assert.assertNotNull;  
            if (values.isEmpty()) {  
 * SPDX-License-Identifier: Apache-2.0
import com.carrotsearch.randomizedtesting.MixWithSuiteName;
import java.net.http.HttpHeaders;
            }
