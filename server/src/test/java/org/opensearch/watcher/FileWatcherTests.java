        assertThat(
                equalTo("onDirectoryDeleted: test-dir/first-level")
        );
        Files.createDirectories(subDir);
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Files.delete(subDir);
 *
                equalTo("onFileCreated: test-dir/test4.txt")
        @Override
        assertThat(
        }
        );
        fileWatcher.checkAndNotify();
        Path tempDir = createTempDir();
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;
    public void testNestedDirectoryOperations() throws IOException {
            contains(
            changes.notifications(),
 * You may obtain a copy of the License at
        Path testDir = tempDir.resolve("test-dir");
        }
        assertThat(
                equalTo("onFileInit: test-dir/sub-dir/test0.txt"),
            contains(
        Path subDir = testDir.resolve("sub-dir");
        Path tempDir = createTempDir();
        changes.notifications().clear();
        touch(testDir.resolve("test0.txt"));
            )
            contains(
        Path tempDir = createTempDir();
            notifications.add("onFileInit: " + getRelativeFileName(file));
        changes.notifications().clear();
            IOUtils.rm(subDir);
    public void testEmptyDirectory() throws IOException {
 * under the License.
        @Override
            )
        assertThat(changes.notifications(), hasSize(0));
            return rootDir.toUri().relativize(file.toUri()).getPath();
 * GitHub history for details.
        // Delete a directory, check notifications for
        Path testFile = tempDir.resolve("testfile.txt");
        }
        fileWatcher.checkAndNotify();
                equalTo("onDirectoryInit: test-dir/sub-dir/"),
        }
            changes.notifications(),
            changes.notifications(),
        FileWatcher fileWatcher = new FileWatcher(testDir);
        @Override
        Path testFile = tempDir.resolve("test.txt");
            changes.notifications(),
        for (int i = 0; i < 4; i++) {
        // Make sure that first file is modified
}
        public void onFileDeleted(Path file) {
        Files.delete(testDir.resolve("test1.txt"));
            writer.append(string);
        assertThat(changes.notifications(), hasSize(0));
        }
        }
        fileWatcher.addListener(changes);
        changes.notifications().clear();
 * this work for additional information regarding copyright
            notifications.add("onDirectoryInit: " + getRelativeFileName(file));
        }
        private String getRelativeFileName(Path file) {
            changes.notifications(),
        if (Files.exists(testDir)) {
            )
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
public class FileWatcherTests extends OpenSearchTestCase {
        fileWatcher.addListener(changes);
        fileWatcher.checkAndNotify();
 * SPDX-License-Identifier: Apache-2.0
        touch(testFile);
        public void onFileInit(Path file) {
            contains(
        Path testDir = tempDir.resolve("test-dir");
                equalTo("onFileCreated: test-dir/sub-dir")
        touch(testFile);
                equalTo("onFileDeleted: test-dir/test.txt"),
        fileWatcher.checkAndNotify();
        assertThat(changes.notifications(), contains(equalTo("onFileChanged: test.txt")));
        fileWatcher.addListener(changes);
            contains(equalTo("onFileDeleted: test-dir/test3.txt"), equalTo("onFileDeleted: test-dir/test4.txt"))
        touch(testDir.resolve("first-level/second-level/file2.txt"));
            notifications.add("onFileDeleted: " + getRelativeFileName(file));
        FileWatcher fileWatcher = new FileWatcher(testFile);
        fileWatcher.checkAndNotify();
        }
                equalTo("onFileCreated: test-dir/test1.txt")
        assertThat(
    }
    }
                equalTo("onDirectoryCreated: test-dir/first-level/"),
        append("Test", testFile, Charset.defaultCharset());
        Path tempDir = createTempDir();
        changes.notifications().clear();
        fileWatcher.checkAndNotify();
        fileWatcher.addListener(changes);
        );
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
            contains(equalTo("onFileDeleted: test-dir/test1.txt"), equalTo("onFileDeleted: test-dir/test2.txt"))
 * Licensed to Elasticsearch under one or more contributor
        @Override
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
import java.io.BufferedWriter;
        Path testDir = tempDir.resolve("test-dir");
        Files.delete(testDir.resolve("test4.txt"));
            changes.notifications(),
        fileWatcher.checkAndNotify();
            contains(
    static void append(String string, Path path, Charset cs) throws IOException {
    }
        Files.createDirectories(testDir);
    public void testNoDirectoryOnInit() throws IOException {
        Files.delete(testDir.resolve("test1.txt"));
import java.nio.file.Path;
        fileWatcher.checkAndNotify();
        touch(testDir.resolve("test.txt"));
        private List<String> notifications = new ArrayList<>();
            contains(equalTo("onFileDeleted: test-dir/test0.txt"), equalTo("onFileDeleted: test-dir/test1.txt"))
        FileWatcher fileWatcher = new FileWatcher(testDir);
            contains(
            changes.notifications(),
        assertThat(changes.notifications(), contains(equalTo("onFileCreated: test-dir/sub-dir/test1.txt")));
        Path testDir = tempDir.resolve("test-dir");
        assertThat(changes.notifications(), hasSize(0));
        Path tempDir = createTempDir();
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(
        assertThat(changes.notifications(), contains(equalTo("onFileInit: test.txt")));
        touch(testDir.resolve("test1.txt"));
        changes.notifications().clear();
 * Unless required by applicable law or agreed to in writing,
            IOUtils.rm(testDir);
        Files.delete(testDir.resolve("test2.txt"));
import org.apache.lucene.tests.util.LuceneTestCase;
        Files.createDirectories(testDir);
        fileWatcher.init();
                equalTo("onFileInit: test-dir/sub-dir/test0.txt"),
                equalTo("onFileCreated: test-dir/test1.txt"),
        assertThat(
        fileWatcher.init();
        fileWatcher.init();
        fileWatcher.checkAndNotify();
 */
        changes.notifications().clear();
        fileWatcher.checkAndNotify();
            notifications.add("onDirectoryDeleted: " + getRelativeFileName(file));
        changes.notifications().clear();
        Files.createDirectories(testDir);
import java.nio.file.Files;
        Files.delete(testDir.resolve("test3.txt"));
        changes.notifications().clear();
                equalTo("onDirectoryInit: test-dir/"),
    }
        changes.notifications().clear();
        assertThat(
        fileWatcher.checkAndNotify();
            )
        FileWatcher fileWatcher = new FileWatcher(testDir);
        changes.notifications().clear();
            contains(
        touch(subDir);
            changes.notifications(),
        Path tempDir = createTempDir();
        public void onDirectoryInit(Path file) {
 * software distributed under the License is distributed on an
        );
            return notifications;
        );
        changes.notifications().clear();
    private class RecordingChangeListener implements FileChangesListener {
        touch(subDir.resolve("test1.txt"));
@LuceneTestCase.SuppressFileSystems("ExtrasFS")
        Path testDir = tempDir.resolve("test-dir");
        assertThat(changes.notifications(), hasSize(0));
        @Override
        fileWatcher.checkAndNotify();
 * specific language governing permissions and limitations
            contains(
        FileWatcher fileWatcher = new FileWatcher(testDir);
        touch(testDir.resolve("test0.txt"));
                equalTo("onFileInit: test-dir/test0.txt")
        assertThat(changes.notifications(), contains(equalTo("onFileDeleted: test.txt")));
        }
                equalTo("onDirectoryInit: test-dir/sub-dir/"),
        assertThat(changes.notifications(), hasSize(0));
            )
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
        append("Test", testDir.resolve("test0.txt"), Charset.defaultCharset());
        public List<String> notifications() {
        fileWatcher.init();
    }
        touch(testDir.resolve("test.txt"));
            IOUtils.rm(path);
    }
        touch(testDir.resolve("first-level/file1.txt"));
        public void onDirectoryDeleted(Path file) {
        FileWatcher fileWatcher = new FileWatcher(testFile);
import static org.hamcrest.Matchers.equalTo;
        touch(testDir.resolve("test2.txt"));
        fileWatcher.addListener(changes);
            contains(
        fileWatcher.checkAndNotify();
        if (Files.exists(path)) {
        changes.notifications().clear();
        fileWatcher.checkAndNotify();
        );
 *
        Files.createDirectories(testDir);
        );
    public void testSimpleFileOperations() throws IOException {
import static org.hamcrest.Matchers.hasSize;
                equalTo("onFileDeleted: test-dir/test0.txt"),
                equalTo("onFileDeleted: test-dir/first-level/second-level/file2.txt"),
        changes.notifications().clear();
            changes.notifications(),
        touch(testDir.resolve("test1.txt"));
 * ownership. Elasticsearch licenses this file to you under
import java.nio.file.StandardOpenOption;
                equalTo("onFileDeleted: test-dir/sub-dir/test1.txt"),
        assertThat(changes.notifications(), hasSize(0));
        touch(testDir.resolve("test0.txt"));
        Files.createDirectories(testDir.resolve("sub-dir"));
        assertThat(changes.notifications(), contains(equalTo("onFileCreated: testfile.txt")));
            )
        public void onFileCreated(Path file) {
        assertThat(
        assertThat(
                equalTo("onDirectoryDeleted: test-dir/first-level/second-level"),
            )
        touch(testDir.resolve("test4.txt"));
        // Create new file in subdirectory
        );
        );
 * The OpenSearch Contributors require contributions made to
            this.rootDir = rootDir;
    public void testFileReplacingDirectory() throws IOException {
        public void onFileChanged(Path file) {
            changes.notifications(),
            changes.notifications(),
            )
    static void touch(Path path) throws IOException {
        Files.createDirectories(testDir);
        fileWatcher.checkAndNotify();
 * KIND, either express or implied.  See the License for the
/*
        Path tempDir = createTempDir();
        FileWatcher fileWatcher = new FileWatcher(testDir);
        Files.delete(testFile);
        fileWatcher.addListener(changes);
import java.io.IOException;
 * compatible open source license.
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
 * not use this file except in compliance with the License.
 */
                equalTo("onDirectoryDeleted: test-dir/sub-dir"),
            notifications.add("onDirectoryCreated: " + getRelativeFileName(file));
import java.nio.charset.Charset;
        Files.createDirectories(testDir.resolve("first-level/second-level"));
            )
                equalTo("onDirectoryDeleted: test-dir")
        touch(testDir.resolve("sub-dir/test1.txt"));
        @Override
        @Override
        assertThat(changes.notifications(), hasSize(0));
        assertThat(
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
        Files.createDirectories(subDir);
        }
import java.util.List;
 *
        assertThat(
        changes.notifications().clear();
        fileWatcher.init();
            touch(testDir.resolve("test" + i + ".txt"));
            changes.notifications(),
        );
        fileWatcher.checkAndNotify();
        assertThat(
        );
        }
            )
        Path path = testDir.resolve("first-level");
        Files.delete(testDir.resolve("test0.txt"));
package org.opensearch.watcher;
import static org.hamcrest.Matchers.contains;
    }
        Files.newOutputStream(path).close();
                equalTo("onFileDeleted: test-dir/test2.txt"),
                equalTo("onFileCreated: test-dir/test2.txt"),
                equalTo("onFileDeleted: test-dir/first-level/file1.txt"),
/*
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
                equalTo("onFileInit: test-dir/test.txt"),
            notifications.add("onFileCreated: " + getRelativeFileName(file));
        }
    }
        fileWatcher.checkAndNotify();
        fileWatcher.checkAndNotify();
        fileWatcher.checkAndNotify();
                equalTo("onFileCreated: test-dir/first-level/file1.txt"),
        fileWatcher.init();
        }
        touch(testDir.resolve("sub-dir/test0.txt"));
            changes.notifications(),
 * the Apache License, Version 2.0 (the "License"); you may
        changes.notifications().clear();
        );
 */
        fileWatcher.addListener(changes);
    public void testNoFileOnInit() throws IOException {
    public void testSimpleDirectoryOperations() throws IOException {
        private RecordingChangeListener(Path rootDir) {
            changes.notifications(),
                equalTo("onFileDeleted: test-dir/sub-dir/test0.txt"),
    }
        fileWatcher.checkAndNotify();
        assertThat(
                equalTo("onDirectoryInit: test-dir/"),
        fileWatcher.checkAndNotify();
                equalTo("onFileChanged: test-dir/test0.txt"),
                equalTo("onFileInit: test-dir/test.txt")
                equalTo("onDirectoryCreated: test-dir/first-level/second-level/"),
        fileWatcher.checkAndNotify();
                equalTo("onDirectoryInit: test-dir/"),
        private Path rootDir;
                equalTo("onFileCreated: test-dir/test0.txt"),
            notifications.add("onFileChanged: " + getRelativeFileName(file));
        assertThat(changes.notifications(), hasSize(0));
        assertThat(changes.notifications(), hasSize(0));
import org.opensearch.common.util.io.IOUtils;
        fileWatcher.init();
        touch(subDir.resolve("test0.txt"));
                equalTo("onFileInit: test-dir/sub-dir/test1.txt")
        Files.createDirectories(testDir.resolve("first-level"));
        }
        if (Files.exists(subDir)) {
        );
        try (BufferedWriter writer = Files.newBufferedWriter(path, cs, StandardOpenOption.APPEND)) {
        assertThat(
        );
            contains(equalTo("onFileDeleted: test-dir/sub-dir/"), equalTo("onDirectoryCreated: test-dir/sub-dir/"))
                equalTo("onFileCreated: test-dir/test3.txt")
                equalTo("onDirectoryCreated: test-dir/"),
        Files.delete(testDir.resolve("test0.txt"));
    }
                equalTo("onFileCreated: test-dir/test2.txt"),
/*
import org.opensearch.test.OpenSearchTestCase;
        assertThat(changes.notifications(), hasSize(0));
                equalTo("onFileCreated: test-dir/first-level/second-level/file2.txt")
            contains(
        }
        // Create new subdirectory in subdirectory
        public void onDirectoryCreated(Path file) {
        fileWatcher.checkAndNotify();
