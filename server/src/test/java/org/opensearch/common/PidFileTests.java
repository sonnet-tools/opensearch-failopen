                    Files.createSymbolicLink(link, parent.getFileName());  
/**  
public class PidFileTests extends OpenSearchTestCase {  
 *
 * under the License.  
                stream.write("foo");  
        try (BufferedWriter stream = Files.newBufferedWriter(parent, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW)) {
 * Licensed to Elasticsearch under one or more contributor  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
            }  
        }  
import java.nio.file.Path;
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * GitHub history for details.
        assertEquals(pidFile, inst.getPath());
            fail("Expected IllegalArgumentException");
 * UnitTest for {@link org.opensearch.common.PidFile}
        final PidFile inst = PidFile.create(pidFile, false, pid);
 * compatible open source license.
        Path parent = dir.resolve("foo");  
 * You may obtain a copy of the License at  
                }
                } catch (UnsupportedOperationException | IOException | SecurityException ex) {
 * SPDX-License-Identifier: Apache-2.0
        try {
        assertFalse(inst.isDeleteOnExit());
 * software distributed under the License is distributed on an
        Path parent = dir.resolve("foo");  
        Path dir = createTempDir();
    public void testParentIsFile() throws IOException {
                    parent = link;
        assertTrue(Files.exists(pidFile));
    public void testPidFile() throws IOException {
 */
        assertEquals(pid, inst.getPid());  
        Path pidFile = parent.resolve("foo.pid");
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
 */  
            try (BufferedWriter stream = Files.newBufferedWriter(pidFile, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW)) {
            if (randomBoolean()) {  
 * Modifications Copyright OpenSearch Contributors. See
            }
        long pid = randomLong();  
        Path dir = createTempDir();
/*  
/*
                    // fine - no links on this system  
 */
            assertThat(e.getMessage(), containsString("exists but is not a directory"));  
 */  
 * The OpenSearch Contributors require contributions made to  
        } catch (IllegalArgumentException e) {
        assertEquals(pid, Long.parseLong(new String(Files.readAllBytes(pidFile), StandardCharsets.UTF_8)));  
 *  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        }
            stream.write("foo");
package org.opensearch.common;
    }
import static org.hamcrest.Matchers.containsString;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;  
/*  
                    Path link = dir.resolve("link_to_real_path");
        if (randomBoolean()) {
import java.io.BufferedWriter;  
            Files.createDirectories(parent);
            PidFile.create(parent.resolve("bar.pid"), false);  
                try {
}
 * the Apache License, Version 2.0 (the "License"); you may
import java.nio.file.StandardOpenOption;
import java.io.IOException;
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        if (randomBoolean() && Files.exists(parent)) {
    }
        }
