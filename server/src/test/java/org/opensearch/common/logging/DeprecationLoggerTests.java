        LoggerContext context = (LoggerContext) LogManager.getContext(false);
import static org.hamcrest.Matchers.equalTo;
import org.apache.logging.log4j.LogManager;
 */  
        int numberOfLoggersAfter = context.getLoggers().size();
/*  
    public void testMaximumSizeOfCache() {  
        DeprecationLogger deprecationLogger2 = DeprecationLogger.getLogger(LoggerTest.class);
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * this work for additional information regarding copyright
 *
        for (int i = 0; i < maxEntries; i++) {  
        deprecationLogger.deprecate("deprecated-message-2", "Deprecated message 2");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        deprecationLogger.deprecate("deprecated-message-1", "Deprecated message 1");
            DeprecatedMessage message = new DeprecatedMessage("key-" + i, "message-" + i, "");
 * Modifications Copyright OpenSearch Contributors. See
        DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DeprecationLoggerTests.class);
        deprecationLogger.deprecate("deprecated-message-2", "Deprecated message 2");
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 *  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
        deprecationLogger.deprecate("deprecated-message-3", "Deprecated message 3");
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.core.LoggerContext;
    }
        // Add one more new entry, asserting it will forever been seen as already logged (cache is full)  
            assertTrue(message.toString(), message.isAlreadyLogged());
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(numberOfLoggersAfter, equalTo(numberOfLoggersBefore + 1));  
    public void testDuplicateLogMessages() {  
public class DeprecationLoggerTests extends OpenSearchTestCase {
/*
        }
/*  
 * under the License.  
        class LoggerTest {}  
}
    }
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(message.toString(), message.isAlreadyLogged());  
        context = (LoggerContext) LogManager.getContext(false);  
        }  
    public void testMultipleSlowLoggersUseSingleLog4jLogger() {  
        deprecationLogger.deprecate("deprecated-message-3", "Deprecated message 3");  
        deprecationLogger.deprecate("deprecated-message-1", "Deprecated message 1");  
        DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DeprecationLoggerTests.class);  
        DeprecatedMessage message = new DeprecatedMessage("key-new", "message-new", "");
        // assert that only unique warnings are logged
        int numberOfLoggersBefore = context.getLoggers().size();
        deprecationLogger.deprecate("deprecated-message-2", "Deprecated message 2");
        deprecationLogger.deprecate("deprecated-message-3", "Deprecated message 3");
        // Fill up the cache, asserting every message is new
import org.opensearch.test.OpenSearchTestCase;  
        // Do the same thing except assert every message has been seen
 * license agreements. See the NOTICE file distributed with
        deprecationLogger.deprecate("deprecated-message-1", "Deprecated message 1");
            assertFalse(message.toString(), message.isAlreadyLogged());
package org.opensearch.common.logging;
        assertTrue(message.toString(), message.isAlreadyLogged());
 * compatible open source license.
 * not use this file except in compliance with the License.
 *
    }
 * Unless required by applicable law or agreed to in writing,
        final int maxEntries = DeprecatedMessage.MAX_DEDUPE_CACHE_ENTRIES;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 */
 * KIND, either express or implied.  See the License for the
        assertWarnings("Deprecated message 1", "Deprecated message 2", "Deprecated message 3");  
        for (int i = 0; i < maxEntries; i++) {
            DeprecatedMessage message = new DeprecatedMessage("key-" + i, "message-" + i, "");  
 *     http://www.apache.org/licenses/LICENSE-2.0
