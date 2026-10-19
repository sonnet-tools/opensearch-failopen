        printStream.print("world\n");
    public void testFlushOnWindowsNewline() {  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(loggingStream.lines, contains(longStr, extraLongStr));
        assertTrue(loggingStream.lines.isEmpty());
        IOException e = expectThrows(IOException.class, () -> loggingStream.write('a'));  
 * KIND, either express or implied.  See the License for the
    }
        Thread thread2 = new Thread(() -> { printStream.println("from thread 2"); });  
    }
 * under the License.  
        printStream.println(longStr);
        String longStr = randomAlphaOfLength(DEFAULT_BUFFER_LENGTH);
        printStream.flush();  
import static org.hamcrest.Matchers.equalTo;
        printStream.flush();
    public void testThreadIsolation() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
    public void testBufferExtension() {
    PrintStream printStream;
import static org.hamcrest.Matchers.contains;  
 *
 * software distributed under the License is distributed on an
 */
import org.junit.Before;
 * GitHub history for details.
        @Override
        assertTrue(loggingStream.lines.isEmpty());
 * not use this file except in compliance with the License.
    public void testNull() {  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(loggingStream.lines, contains(longStr, longStr, "OVERFLOW"));
    }
    }  
    public void testEmptyLineUnix() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        loggingStream.close();
        assertThat(loggingStream.threadLocal.get().bytes.length, equalTo(DEFAULT_BUFFER_LENGTH));
        printStream.print("hello\n");
    // this test explicitly outputs the newlines instead of relying on println, to always test the windows behavior
/*  
        printStream.print("\n");
/*
 * Unless required by applicable law or agreed to in writing,
        assertThat(loggingStream.threadLocal.get().bytes.length, equalTo(DEFAULT_BUFFER_LENGTH));
        thread2.start();
import org.opensearch.test.OpenSearchTestCase;
import java.util.List;
    }
        printStream.flush();
import static org.opensearch.common.logging.LoggingOutputStream.MAX_BUFFER_LENGTH;
    public void testClosed() {
 * compatible open source license.
package org.opensearch.common.logging;
        }
        printStream.println(extraLongStr);  
 * SPDX-License-Identifier: Apache-2.0
        printStream.print("world\r\n");  
    public void testFlushOnUnixNewline() {
        assertTrue(loggingStream.lines.isEmpty());  
        assertTrue(loggingStream.lines.isEmpty());  
 * this work for additional information regarding copyright
import static org.opensearch.common.logging.LoggingOutputStream.DEFAULT_BUFFER_LENGTH;
        void log(String msg) {
        assertThat(loggingStream.lines, contains("hello", "world"));
        TestLoggingOutputStream() {  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    }
 * specific language governing permissions and limitations
import java.io.PrintStream;
    class TestLoggingOutputStream extends LoggingOutputStream {  
        printStream.println(extraLongStr);  
        String longStr = randomAlphaOfLength(MAX_BUFFER_LENGTH);  
        printStream.flush();
        }
        printStream.print("\r\n"); // newline by itself does not show up
        loggingStream = new TestLoggingOutputStream();  
            lines.add(msg);  
        String extraLongStr = randomAlphaOfLength(DEFAULT_BUFFER_LENGTH + 1);  
}  
import java.io.IOException;
    public void testMaxBuffer() {
 *
        printStream.print("\n"); // newline by itself does not show up  
 */  
        printStream.println(longStr);
import java.nio.charset.StandardCharsets;  
    }
import java.util.ArrayList;
        assertThat(e.getMessage(), containsString("buffer closed"));
    }
        printStream.print("hello\r\n");
    public void testEmptyLineWindows() {
        printStream.write(0);
        assertThat(loggingStream.lines, contains("from thread 2", "from thread 1"));
import static org.hamcrest.Matchers.containsString;
        String extraLongStr = longStr + "OVERFLOW";
 * ownership. Elasticsearch licenses this file to you under  
        printStream.print("\r\n");  
    }
        List<String> lines = new ArrayList<>();
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(loggingStream.lines.isEmpty());  
 * The OpenSearch Contributors require contributions made to  
    public void createStream() throws Exception {
        thread2.join();
 *  
    @Before
 */  
    }  
        printStream = new PrintStream(loggingStream, false, StandardCharsets.UTF_8.name());
            super(null, null);
        printStream.print("from thread 1");
public class LoggingOutputStreamTests extends OpenSearchTestCase {
    // this test explicitly outputs the newlines instead of relying on println, to always test the unix behavior  
        assertThat(loggingStream.lines, contains("hello", "world"));
    TestLoggingOutputStream loggingStream;
