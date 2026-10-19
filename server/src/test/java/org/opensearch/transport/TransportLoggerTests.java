@TestLogging(value = "org.opensearch.transport.TransportLogger:trace", reason = "to ensure we log network events on TRACE level")
                Level.TRACE,
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
/*
                "hot threads request",
        }
 * SPDX-License-Identifier: Apache-2.0
                + ", version: .*"  
            final MockLogAppender.LoggingExpectation writeExpectation = new MockLogAppender.PatternSeenEventExpectation(
                TransportLogger.class.getCanonicalName(),  
package org.opensearch.transport;
 */
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
                + ", action: cluster:monitor/stats]"
 *  
 * KIND, either express or implied.  See the License for the
            final String readPattern = ".*\\[length: \\d+"
import org.opensearch.test.MockLogAppender;  
                readPattern
 * license agreements. See the NOTICE file distributed with
}  
import java.io.IOException;
    public abstract BytesReference buildRequest() throws IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.mockito.Mockito.mock;  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(TransportLogger.class))) {
 * specific language governing permissions and limitations
                + ", header size: \\d+B"
import org.opensearch.test.OpenSearchTestCase;
                + ", header size: \\d+B"  
            );  
            );  
                + ", type: request"
public abstract class TransportLoggerTests extends OpenSearchTestCase {  
            appender.assertAllExpectationsMatched();
            appender.addExpectation(readExpectation);  
 */  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
                + ", version: .*"
            final String writePattern = ".*\\[length: \\d+"  
import org.opensearch.test.junit.annotations.TestLogging;
import org.apache.logging.log4j.LogManager;
                "cluster monitor request",
 * GitHub history for details.
                writePattern
            TransportLogger.logInboundMessage(mock(TcpChannel.class), bytesReference.slice(6, bytesReference.length() - 6));
    }  
                Level.TRACE,
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
 */
 * You may obtain a copy of the License at  
                + " WRITE: \\d+B";  
            appender.addExpectation(writeExpectation);
import org.apache.logging.log4j.Level;  
 * this work for additional information regarding copyright
                + " READ: \\d+B";
                + ", request id: \\d+"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + ", type: request"
            BytesReference bytesReference = buildRequest();
    public void testLoggingHandler() throws Exception {
            TransportLogger.logOutboundMessage(mock(TcpChannel.class), bytesReference);  
/*
                + ", action: cluster:monitor/stats]"
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.bytes.BytesReference;
                + ", request id: \\d+"  
 * under the License.  
                TransportLogger.class.getCanonicalName(),  
 * compatible open source license.
 *
            final MockLogAppender.LoggingExpectation readExpectation = new MockLogAppender.PatternSeenEventExpectation(
