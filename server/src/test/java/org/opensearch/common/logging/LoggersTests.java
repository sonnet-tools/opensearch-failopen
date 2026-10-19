import java.io.IOException;
            testLogger.info(() -> new ParameterizedMessage("an info message a=[{}], b=[{}], c=[{}]", 1, 2, 3));
            testLogger.trace(() -> new ParameterizedMessage("a trace message; element = [{}]", new Object[] { null }), ex);
 * under the License.  
        try {
import org.apache.logging.log4j.message.ParameterizedMessage;
        final MockAppender appender = new MockAppender("trace_appender");  
 */
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.equalTo;  
            assertThat(appender.lastParameterizedMessage().getFormattedMessage(), equalTo("an info message a=[1], b=[2], c=[3]"));
            assertThat(appender.lastParameterizedMessage().getParameters(), arrayContaining(Arrays.asList("yes", "no")));
 * Unless required by applicable law or agreed to in writing,
            assertThat(appender.lastEvent.getThrown(), equalTo(ex));  
            testLogger.error(() -> new ParameterizedMessage("an error message"), ex);
 * license agreements. See the NOTICE file distributed with
 *
            appender.stop();
 */  
        );  
            Throwable ex = randomException();
 * this file be licensed under the Apache-2.0 license or a
/*  
            assertThat(appender.lastEvent.getLevel(), equalTo(Level.WARN));  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * specific language governing permissions and limitations
            assertThat(appender.lastParameterizedMessage().getFormattedMessage(), equalTo("a debug message options = [yes, no]"));  
 * the Apache License, Version 2.0 (the "License"); you may
        Loggers.addAppender(testLogger, appender);  
            new UnknownHostException("unknown hostname"),  
            Loggers.removeAppender(testLogger, appender);
            testLogger.warn(() -> new ParameterizedMessage("a warn message: [{}]", "long gc"), ex);
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
            assertThat(appender.lastParameterizedMessage().getParameters(), arrayContaining("long gc"));  
    }
            Loggers.setLevel(testLogger, Level.TRACE);
 * GitHub history for details.
import java.net.UnknownHostException;
    }
        } finally {  
            assertThat(appender.lastEvent.getLevel(), equalTo(Level.ERROR));  
        }  
            new OutOfMemoryError("out of space"),
            ex = randomException();  
package org.opensearch.common.logging;
            assertThat(appender.lastParameterizedMessage().getFormattedMessage(), equalTo("a trace message; element = [null]"));
import org.apache.logging.log4j.LogManager;
            assertThat(appender.lastEvent.getLevel(), equalTo(Level.TRACE));
            assertThat(appender.lastEvent.getThrown(), equalTo(ex));
 * compatible open source license.
 */  
public class LoggersTests extends OpenSearchTestCase {  
            assertThat(appender.lastEvent.getLevel(), equalTo(Level.DEBUG));
import org.apache.logging.log4j.Level;
 * KIND, either express or implied.  See the License for the
    public void testParameterizedMessageLambda() throws Exception {
            assertThat(appender.lastEvent.getLevel(), equalTo(Level.INFO));  
 *
 * SPDX-License-Identifier: Apache-2.0
        return randomFrom(
/*  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.logging.log4j.Logger;  
            assertThat(appender.lastParameterizedMessage().getParameters(), arrayContaining(new Object[] { null }));
            assertThat(appender.lastParameterizedMessage().getParameters(), arrayContaining(1, 2, 3));  
 * software distributed under the License is distributed on an
        appender.start();
            ex = randomException();
            assertThat(appender.lastEvent.getThrown(), equalTo(ex));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(appender.lastEvent.getThrown(), equalTo(ex));
            ex = randomException();
import static org.hamcrest.Matchers.nullValue;
            testLogger.debug(() -> new ParameterizedMessage("a debug message options = {}", Arrays.asList("yes", "no")), ex);  
            new IOException("file not found"),
            assertThat(appender.lastEvent.getThrown(), nullValue());
 * You may obtain a copy of the License at  
            new IllegalArgumentException("index must be between 10 and 100")
    private Throwable randomException() {  
}
        final Logger testLogger = LogManager.getLogger(LoggersTests.class);
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(appender.lastParameterizedMessage().getFormattedMessage(), equalTo("an error message"));
/*
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.arrayContaining;
import org.opensearch.test.OpenSearchTestCase;
            assertThat(appender.lastParameterizedMessage().getFormattedMessage(), equalTo("a warn message: [long gc]"));
import java.util.Arrays;  
