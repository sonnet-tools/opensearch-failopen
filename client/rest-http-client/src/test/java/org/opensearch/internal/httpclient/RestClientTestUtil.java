    }
     */  
    static int randomOkStatusCode(Random random) {
/*  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
/*
    }
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            String headerName = baseName;
    private RestClientTestUtil() {
package org.opensearch.internal.httpclient;
    }
        ALL_STATUS_CODES.addAll(OK_STATUS_CODES);
    static List<Integer> getAllStatusCodes() {
    }  
    static List<Integer> getAllErrorStatusCodes() {  
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
        return HTTP_METHODS;  
    static List<Integer> getOkStatusCodes() {
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * KIND, either express or implied.  See the License for the
    private static List<Integer> ERROR_NO_RETRY_STATUS_CODES = Arrays.asList(400, 401, 403, 404, 405, 500);  
 * ownership. Elasticsearch licenses this file to you under  
     * Generated header names will either be the {@code baseName} plus its index, or exactly the provided {@code baseName} so that the
 * not use this file except in compliance with the License.
                headerName = headerName + i;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
    static String[] getHttpMethods() {
     * Create a random number of HTTP headers.  
    private static final List<Integer> ALL_STATUS_CODES;  
    /**
 * SPDX-License-Identifier: Apache-2.0
    static int randomErrorRetryStatusCode(Random random) {
        return RandomPicks.randomFrom(random, ERROR_RETRY_STATUS_CODES);
    }  
import java.util.Map;  
 * compatible open source license.
/*  
        return headers;  
        }
 * The OpenSearch Contributors require contributions made to  
    static Map<String, List<String>> randomHeaders(Random random, final String baseName) {
    private static final String[] HTTP_METHODS = new String[] { "DELETE", "HEAD", "GET", "OPTIONS", "PATCH", "POST", "PUT", "TRACE" };
    }  
 */  
    }
 * Modifications Copyright OpenSearch Contributors. See
            if (random.nextBoolean()) {
import java.util.Arrays;  
 * Unless required by applicable law or agreed to in writing,
import com.carrotsearch.randomizedtesting.generators.RandomStrings;  
 */
        return OK_STATUS_CODES;  
        ALL_STATUS_CODES = new ArrayList<>(ALL_ERROR_STATUS_CODES);  
        ALL_ERROR_STATUS_CODES.addAll(ERROR_NO_RETRY_STATUS_CODES);
 * You may obtain a copy of the License at  
     * we test also support for multiple headers with same key and different values.
 *  
import java.util.List;
    static int randomErrorNoRetryStatusCode(Random random) {  
import java.util.HashMap;
 *    http://www.apache.org/licenses/LICENSE-2.0
final class RestClientTestUtil {  
    private static final List<Integer> ALL_ERROR_STATUS_CODES;
}
    }  
 * this file be licensed under the Apache-2.0 license or a
        return ALL_ERROR_STATUS_CODES;
    }
        ALL_ERROR_STATUS_CODES = new ArrayList<>(ERROR_RETRY_STATUS_CODES);
        return ALL_STATUS_CODES;
    private static List<Integer> ERROR_RETRY_STATUS_CODES = Arrays.asList(502, 503, 504);
        return RandomPicks.randomFrom(random, HTTP_METHODS);
    }
    }
        int numHeaders = RandomNumbers.randomIntBetween(random, 0, 5);  
 * software distributed under the License is distributed on an
        final Map<String, List<String>> headers = new HashMap<>();
        return RandomPicks.randomFrom(random, ERROR_NO_RETRY_STATUS_CODES);
            headers.put(headerName, List.of(RandomStrings.randomAsciiLettersOfLengthBetween(random, 3, 10)));
 * specific language governing permissions and limitations
 *
            }  
import java.util.ArrayList;
        return RandomPicks.randomFrom(random, OK_STATUS_CODES);  
        return RandomPicks.randomFrom(random, ALL_STATUS_CODES);
 *
    static int randomStatusCode(Random random) {
    private static final List<Integer> OK_STATUS_CODES = Arrays.asList(200, 201);
 */  
 * this work for additional information regarding copyright
    static String randomHttpMethod(Random random) {  
    static {  
        for (int i = 0; i < numHeaders; i++) {
import java.util.Random;
            // randomly exercise the code path that supports multiple headers with same key  
