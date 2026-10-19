    }
    }  
            Exception e = expectThrows(IllegalArgumentException.class, () -> DeprecationRestHandler.requireValidHeader(value));
/*
    public void testInvalidHeaderValue() {  
        ASCIIHeaderGenerator() {
        DeprecationRestHandler deprecatedHandler = new DeprecationRestHandler(handler, deprecationMessage, deprecationLogger);
    public void testSupportsContentStreamTrue() {  
import static org.mockito.Mockito.inOrder;  
/*
            (char) 31 /* unit separator*/,
            assertEquals("header value must contain only US ASCII text", e.getMessage());
        static char[] asciiFromTo(int from, int to) {  
 *
    public void testSupportsContentStreamFalse() {
    private final String deprecationMessage = randomAlphaOfLengthBetween(1, 30);
        // log, then forward  
    public void testInvalidHeaderValueEmpty() {
         * Create a generator for characters [32, 126].
        expectThrows(
        assertFalse(DeprecationRestHandler.validHeaderValue(blank));
 *
        assertTrue(new DeprecationRestHandler(handler, deprecationMessage, deprecationLogger).supportsContentStream());
    }  
         * Create a character array for characters [{@code from}, {@code to}].  
import org.opensearch.common.logging.DeprecationLogger;
            assertSame(value, DeprecationRestHandler.requireValidHeader(value));
 * Tests {@link DeprecationRestHandler}.
    public void testHandleRequestLogsWarningThenForwards() throws Exception {  
 * not use this file except in compliance with the License.
     */  
        expectThrows(NullPointerException.class, () -> new DeprecationRestHandler(null, deprecationMessage, deprecationLogger));
    public void setup() {
            assertFalse(DeprecationRestHandler.validHeaderValue(value));  
 * The OpenSearch Contributors require contributions made to  
        NodeClient client = mock(NodeClient.class);  
            }
        expectThrows(IllegalArgumentException.class, () -> DeprecationRestHandler.requireValidHeader(null));
        ) + generator.ofCodeUnitsLength(random(), 0, 25);  
            '\0',
    public void testValidHeaderValue() {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Note: Headers should only use US ASCII (and this inevitably becomes one!).
         *
        inOrder.verify(deprecationLogger).deprecate("deprecated_route", deprecationMessage);
        ASCIIHeaderGenerator generator = new ASCIIHeaderGenerator();
        RestChannel channel = mock(RestChannel.class);
        if (value.trim().length() == 0) {
     * {@code ASCIIHeaderGenerator} only uses characters expected to be valid in headers (simplified US-ASCII).
        deprecatedHandler.handleRequest(request, channel, client);
 * compatible open source license.
         * @param to Ending code point (inclusive).  
    }
    public void testNullHandler() {
        RestRequest request = mock(RestRequest.class);
    }  
    private static class ASCIIHeaderGenerator extends CodepointSetGenerator {
            return chars;
 * specific language governing permissions and limitations
    /**
        String value = generator.ofCodeUnitsLength(random(), 1, 50);
public class DeprecationRestHandlerTests extends OpenSearchTestCase {
import static org.mockito.Mockito.when;
    private RestHandler handler;  
        );
            (char) 127 /* DEL */
            char[] chars = new char[to - from + 1];
    @Before
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        } else {  
package org.opensearch.rest;
/**
        handler = mock(RestHandler.class);  
        // test it
            // empty text, not a valid header
        deprecationLogger = mock(DeprecationLogger.class);
    public void testNullDeprecationLogger() {
    private DeprecationLogger deprecationLogger;
        assertFalse(new DeprecationRestHandler(handler, deprecationMessage, deprecationLogger).supportsContentStream());
    }
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    }
         * @return Never {@code null}.
        }  
/*  
        expectThrows(IllegalArgumentException.class, () -> DeprecationRestHandler.requireValidHeader(blank));  
 * under the License.  
        ASCIIHeaderGenerator generator = new ASCIIHeaderGenerator();
     */  
    /**
 */
 */  
        when(handler.supportsContentStream()).thenReturn(false);  
import org.opensearch.transport.client.node.NodeClient;
            super(asciiFromTo(32, 126));
        when(handler.supportsContentStream()).thenReturn(true);
        expectThrows(NullPointerException.class, () -> new DeprecationRestHandler(handler, deprecationMessage, null));  
            assertTrue(DeprecationRestHandler.validHeaderValue(value));
 * Unless required by applicable law or agreed to in writing,
    }
import static org.mockito.Mockito.mock;
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        }  
import org.mockito.InOrder;
                chars[i - from] = (char) i;
 * Licensed to Elasticsearch under one or more contributor  
            '\n',
 */
        InOrder inOrder = inOrder(handler, request, channel, deprecationLogger);
import org.opensearch.test.OpenSearchTestCase;  
import com.carrotsearch.randomizedtesting.generators.CodepointSetGenerator;  
            () -> new DeprecationRestHandler(handler, invalidDeprecationMessage, deprecationLogger)
            '\t',  
        /**
 * GitHub history for details.
            (char) 27 /* ESC */,  
         */  
        expectThrows(IllegalArgumentException.class, () -> DeprecationRestHandler.requireValidHeader(value));
        String blank = randomFrom("", "\t", "    ");
        String value = generator.ofCodeUnitsLength(random(), 0, 25) + randomFrom(
         * @param from Starting code point (inclusive).
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
        assertFalse(DeprecationRestHandler.validHeaderValue(value));
    public void testInvalidDeprecationMessageThrowsException() {
        assertFalse(DeprecationRestHandler.validHeaderValue(null));
 */  
        String invalidDeprecationMessage = randomFrom("", null, "     ");  
            IllegalArgumentException.class,  
    public void testInvalidHeaderValueNull() {
        }
import org.junit.Before;
 * this work for additional information regarding copyright
}  
 *  
        inOrder.verifyNoMoreInteractions();  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
            for (int i = from; i <= to; ++i) {  
    }
        /**
        inOrder.verify(handler).handleRequest(request, channel, client);
         */
