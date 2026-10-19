import com.carrotsearch.randomizedtesting.generators.RandomStrings;  
        return HTTP_METHODS;
 * compatible open source license.
 * under the License.  
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
 *
    static int randomErrorNoRetryStatusCode(Random random) {
    private static List<Integer> ERROR_NO_RETRY_STATUS_CODES = Arrays.asList(400, 401, 403, 404, 405, 500);
/*
import java.util.Random;
 * KIND, either express or implied.  See the License for the
    static {
    }
    static Header[] randomHeaders(Random random, final String baseName) {
            headers[i] = new BasicHeader(headerName, RandomStrings.randomAsciiLettersOfLengthBetween(random, 3, 10));
    }
 */
import org.apache.hc.core5.http.message.BasicHeader;  
                headerName = headerName + i;  
        return RandomPicks.randomFrom(random, ERROR_RETRY_STATUS_CODES);  
     * we test also support for multiple headers with same key and different values.  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
        final Header[] headers = new Header[numHeaders];
    static List<Integer> getAllStatusCodes() {
        ALL_ERROR_STATUS_CODES = new ArrayList<>(ERROR_RETRY_STATUS_CODES);
import org.apache.hc.core5.http.Header;
    }  
    }
     * Generated header names will either be the {@code baseName} plus its index, or exactly the provided {@code baseName} so that the
        return RandomPicks.randomFrom(random, ERROR_NO_RETRY_STATUS_CODES);
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
    private static final List<Integer> ALL_ERROR_STATUS_CODES;  
            String headerName = baseName;  
    static int randomOkStatusCode(Random random) {  
    static int randomStatusCode(Random random) {
        return headers;
        ALL_STATUS_CODES = new ArrayList<>(ALL_ERROR_STATUS_CODES);
    }
}  
 *
        for (int i = 0; i < numHeaders; i++) {
    /**  
 * this work for additional information regarding copyright
            }
        ALL_STATUS_CODES.addAll(OK_STATUS_CODES);
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/*  
import java.util.Arrays;  
    static String randomHttpMethod(Random random) {
    }  
package org.opensearch.client;
    }  
        int numHeaders = RandomNumbers.randomIntBetween(random, 0, 5);  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
        ALL_ERROR_STATUS_CODES.addAll(ERROR_NO_RETRY_STATUS_CODES);  
            if (random.nextBoolean()) {
        return ALL_ERROR_STATUS_CODES;
    static List<Integer> getOkStatusCodes() {  
final class RestClientTestUtil {
import java.util.ArrayList;
 * You may obtain a copy of the License at  
 */  
    }  
    }
 * GitHub history for details.
    private static List<Integer> ERROR_RETRY_STATUS_CODES = Arrays.asList(502, 503, 504);
    static String[] getHttpMethods() {  
        return OK_STATUS_CODES;
            // randomly exercise the code path that supports multiple headers with same key
        return RandomPicks.randomFrom(random, OK_STATUS_CODES);
    private static final String[] HTTP_METHODS = new String[] { "DELETE", "HEAD", "GET", "OPTIONS", "PATCH", "POST", "PUT", "TRACE" };  
     * Create a random number of {@link Header}s.
    private static final List<Integer> OK_STATUS_CODES = Arrays.asList(200, 201);
    }
 * Unless required by applicable law or agreed to in writing,
        }  
    }
    }
    static List<Integer> getAllErrorStatusCodes() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * this file be licensed under the Apache-2.0 license or a
        return RandomPicks.randomFrom(random, HTTP_METHODS);
        return ALL_STATUS_CODES;  
/*  
 * not use this file except in compliance with the License.
    private RestClientTestUtil() {
 * specific language governing permissions and limitations
    static int randomErrorRetryStatusCode(Random random) {
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * license agreements. See the NOTICE file distributed with
    private static final List<Integer> ALL_STATUS_CODES;
        return RandomPicks.randomFrom(random, ALL_STATUS_CODES);  
 * The OpenSearch Contributors require contributions made to  
