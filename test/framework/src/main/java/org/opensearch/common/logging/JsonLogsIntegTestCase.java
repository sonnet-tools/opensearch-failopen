        try (Stream<JsonLogLine> stream = JsonLogsStream.from(openReader(getLogFile()))) {
 * should not change across all log lines  
                assertThat(jsonLogLine.timestamp(), is(not(emptyOrNullString())));
import java.nio.file.Path;  
 * Note that this won't pass for nodes in clusters that don't have the node name defined in opensearch.yml <strong>and</strong> start
/*
 * Whereas <code>node.id</code> and <code>cluster.uuid</code> are available later once the first clusterState has been received.
        if (logFileString == null) {
    private Path getLogFile() {
        assertNotNull(firstLine);
/**
 * this work for additional information regarding copyright
 */
                // all lines should have the same nodeName and clusterName  
 * license agreements. See the NOTICE file distributed with
    public void testNodeIdAndClusterIdConsistentOnceAvailable() throws IOException {
                if (jsonLogLine.nodeId() != null) {
 * Licensed to Elasticsearch under one or more contributor  
        }
            });  
 */  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
    protected abstract BufferedReader openReader(Path logFile);
        try (Stream<JsonLogLine> stream = JsonLogsStream.from(openReader(getLogFile()))) {
 * <code>message</code>, <code>node.name</code>, <code>cluster.name</code>.
 * You may obtain a copy of the License at  
            assertNotNull(firstLine);  
    private JsonLogLine findFirstLine() throws IOException {
                assertThat(jsonLogLine.type(), is(not(emptyOrNullString())));  
 * ownership. Elasticsearch licenses this file to you under  
 * <code>node.name</code>, <code>cluster.name</code>, <code>node.id</code>, <code>cluster.uuid</code>
/*  
    }
 *
                assertThat(jsonLogLine.level(), is(not(emptyOrNullString())));
            return stream.findFirst().orElseThrow(() -> new AssertionError("no logs at all?!"));  
 * specific language governing permissions and limitations
 *
                assertThat(jsonLogLine.clusterName(), equalTo(firstLine.clusterName()));
                assertThat(jsonLogLine.component(), is(not(emptyOrNullString())));  
            // once the nodeId and clusterId are received, they should be the same on remaining lines
 *
            while (iterator.hasNext() && i++ < LINES_TO_CHECK) {
    public void testElementsPresentOnAllLinesOfLog() throws IOException {  
}
import org.opensearch.test.rest.OpenSearchRestTestCase;
import static org.hamcrest.Matchers.emptyOrNullString;
            }
 * this file be licensed under the Apache-2.0 license or a
 * with DEBUG or TRACE level logging. Those nodes log a few lines before the node.name is set by <code>LogConfigurator.setNodeName</code>.  
            JsonLogLine firstLine = null;
        }
                JsonLogLine jsonLogLine = iterator.next();
import static org.hamcrest.Matchers.is;
            );  
import java.util.Iterator;
/*  
                assertThat(jsonLogLine.nodeName(), nodeNameMatcher());
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.not;
    }
     * The node name to expect in the log file.
            while (iterator.hasNext()) {  
 * Fields available upon process startup: <code>type</code>, <code>timestamp</code>, <code>level</code>, <code>component</code>,  
        JsonLogLine firstLine = findFirstLine();
import java.nio.file.Paths;
 * the Apache License, Version 2.0 (the "License"); you may
                "tests.logfile must be set to run this test. It is automatically "  
     * subclasses can grant themselves that permission.
 * software distributed under the License is distributed on an
     * framework doesn't have permission to read from the log file but
            stream.limit(LINES_TO_CHECK).forEach(jsonLogLine -> {
            int i = 0;
                assertThat(jsonLogLine.nodeId(), equalTo(firstLine.nodeId()));
import java.util.stream.Stream;  
 * SPDX-License-Identifier: Apache-2.0
                    firstLine = jsonLogLine;  
        }
            fail(
                    + "set by gradle. If you must set it yourself then it should be the absolute path to the "
 * Modifications Copyright OpenSearch Contributors. See
    /**  
import java.io.IOException;
 */  
        }
 * KIND, either express or implied.  See the License for the
    }
        try (Stream<JsonLogLine> stream = JsonLogsStream.from(openReader(getLogFile()))) {
    protected abstract org.hamcrest.Matcher<String> nodeNameMatcher();  
    private static final int LINES_TO_CHECK = 10;
    }  
        return Paths.get(logFileString);
import org.opensearch.common.SuppressForbidden;
package org.opensearch.common.logging;
 * Tests that extend this class verify that all json layout fields appear in the first few log lines after startup
            }  
public abstract class JsonLogsIntegTestCase extends OpenSearchRestTestCase {
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
     */
     * Number of lines in the log file to check for the <code>node.name</code>, <code>node.id</code> or <code>cluster.uuid</code>. We don't
     */  
 * <p>  
 */
            Iterator<JsonLogLine> iterator = stream.iterator();  
                    + "log file."
 * under the License.  
 * compatible open source license.
     * Open the log file. This is delegated to subclasses because the test  
        String logFileString = System.getProperty("tests.logfile");  
                }
 * <p>
     */  
    @SuppressForbidden(reason = "PathUtils doesn't have permission to read this file")
                assertThat(jsonLogLine.message(), is(not(emptyOrNullString())));
                JsonLogLine jsonLogLine = iterator.next();  
                assertThat(jsonLogLine.clusterUuid(), equalTo(firstLine.clusterUuid()));
     * just check the entire log file because it could be quite long
    /**  
import java.io.BufferedReader;
import static org.hamcrest.Matchers.equalTo;  
    /**
