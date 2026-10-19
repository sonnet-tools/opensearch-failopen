            + LINE_SEPARATOR
 * this work for additional information regarding copyright
    private static final String LINE_SEPARATOR = System.lineSeparator();  
 */  
 * ownership. Elasticsearch licenses this file to you under  
            jsonLogLine.stacktrace().size(),  
 * Unless required by applicable law or agreed to in writing,
        StringBuilder builder = new StringBuilder();  
            + "      \"u2\","
            + LINE_SEPARATOR
            + "    \"user\" : ["  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
        // confirms exception is correctly parsed
        String jsonStacktraceElement = builder.toString();
        converter.format(event, builder);
}
            + LINE_SEPARATOR  
            + "}";
        assertThat(jsonLogLine.stacktrace(), Matchers.nullValue());
            "stacktrace should formatted in multiple lines",
            .orElseThrow(() -> new AssertionError("no logs parsed"));  
    private JsonThrowablePatternConverter converter = JsonThrowablePatternConverter.newInstance(null, null);
 * The OpenSearch Contributors require contributions made to  
        int jsonLength = json.split(LINE_SEPARATOR).length;
 * software distributed under the License is distributed on an
 * GitHub history for details.
            + "      \"u1\","
 * this file be licensed under the Apache-2.0 license or a
    }  
 * specific language governing permissions and limitations
        LogEvent event = Log4jLogEvent.newBuilder().build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
        Exception thrown = new Exception(json);  
import org.apache.logging.log4j.message.SimpleMessage;
            + "    ],"
 * under the License.  
            + "      \"u3\""  
            equalTo(jsonLength + stacktraceLength)
 */  
    public void testStacktraceWithJson() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            + LINE_SEPARATOR
/*
 * license agreements. See the NOTICE file distributed with
    public void testNoStacktrace() throws IOException {  
        String result = format(event);
            + "    \"boost\" : 1.0"
public class JsonThrowablePatternConverterTests extends OpenSearchTestCase {
        LogManager.getLogger().info("asdf");  
            + "}";
 *  
        JsonLogLine jsonLogLine = JsonLogsStream.from(new BufferedReader(new StringReader(result)))
            + LINE_SEPARATOR  
            + LINE_SEPARATOR
 * the Apache License, Version 2.0 (the "License"); you may
    }  
            + "  }"  
 *
 * not use this file except in compliance with the License.
package org.opensearch.common.logging;
import java.io.IOException;  
import static org.hamcrest.Matchers.equalTo;  
 */
        LogEvent event = Log4jLogEvent.newBuilder().setMessage(new SimpleMessage("message")).setThrown(thrown).build();
            .findFirst()
            .orElseThrow(() -> new AssertionError("no logs parsed"));  
 * You may obtain a copy of the License at  
import org.opensearch.test.OpenSearchTestCase;
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
/*  
    }  
        String json = "{"
import org.apache.logging.log4j.core.LogEvent;
        JsonLogLine jsonLogLine = JsonLogsStream.from(new BufferedReader(new StringReader(result)))
        String result = format(event);  
import java.io.BufferedReader;
        );
        return "{\"type\": \"console\", \"timestamp\": \"2019-01-03T16:30:53,058+0100\", \"level\": \"DEBUG\", "
            + LINE_SEPARATOR
            + jsonStacktraceElement
            + LINE_SEPARATOR  
            + "  \"terms\" : {"
            + "\"component\": \"o.e.a.s.TransportSearchAction\", \"cluster.name\": \"clustername\", \"node.name\": \"node-0\", "
        assertThat(
import org.apache.logging.log4j.core.impl.Log4jLogEvent;  
import org.hamcrest.Matchers;  
    private String format(LogEvent event) {
import org.apache.logging.log4j.LogManager;
/*  
        int stacktraceLength = thrown.getStackTrace().length;  
            + LINE_SEPARATOR
import java.io.StringReader;
            + "\"cluster.uuid\": \"OG5MkvOrR9azuClJhWvy6Q\", \"node.id\": \"VTShUqmcQG6SzeKY5nn7qA\",  \"message\": \"msg msg\" "  
 *
            .findFirst()
