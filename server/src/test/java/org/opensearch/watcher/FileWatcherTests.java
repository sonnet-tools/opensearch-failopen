        );
        changes.notifications().clear();
                equalTo("onFileCreated: test-dir/test1.txt")  
                equalTo("onFileInit: test-dir/test.txt")
        Files.createDirectories(testDir);
    public void testNoFileOnInit() throws IOException {
        assertThat(changes.notifications(), contains(equalTo("onFileCreated: test-dir/sub-dir/test1.txt")));  
        Path tempDir = createTempDir();
        Files.createDirectories(testDir);  
import org.opensearch.common.util.io.IOUtils;
        fileWatcher.addListener(changes);
        Files.delete(testDir.resolve("test1.txt"));
        fileWatcher.checkAndNotify();  
        if (Files.exists(testDir)) {  
                equalTo("onFileDeleted: test-dir/test2.txt"),  
    static void touch(Path path) throws IOException {
        touch(testDir.resolve("test4.txt"));
    }
        FileWatcher fileWatcher = new FileWatcher(testDir);
                equalTo("onDirectoryCreated: test-dir/first-level/second-level/"),
        fileWatcher.checkAndNotify();
        assertThat(changes.notifications(), hasSize(0));
        Path tempDir = createTempDir();  
import java.nio.file.Path;
        assertThat(changes.notifications(), contains(equalTo("onFileChanged: test.txt")));
        for (int i = 0; i < 4; i++) {
        touch(testDir.resolve("test2.txt"));  
            contains(
                equalTo("onFileCreated: test-dir/test4.txt")  
        );  
            )
 * ownership. Elasticsearch licenses this file to you under  
            )
        );
        }
        touch(testFile);
        assertThat(  
        @Override
            return notifications;
            )  
import org.apache.lucene.tests.util.LuceneTestCase;  
                equalTo("onDirectoryCreated: test-dir/"),
            changes.notifications(),
        fileWatcher.checkAndNotify();
                equalTo("onFileInit: test-dir/sub-dir/test0.txt"),
            changes.notifications(),
 * specific language governing permissions and limitations
 * GitHub history for details.
        }  
        fileWatcher.init();
        fileWatcher.checkAndNotify();
        Path tempDir = createTempDir();
import java.io.BufferedWriter;
            )
        Files.delete(testDir.resolve("test3.txt"));  
            contains(equalTo("onFileDeleted: test-dir/test0.txt"), equalTo("onFileDeleted: test-dir/test1.txt"))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            )  
        Files.createDirectories(testDir.resolve("first-level"));
import static org.hamcrest.Matchers.equalTo;
                equalTo("onFileDeleted: test-dir/test.txt"),
        @Override
        FileWatcher fileWatcher = new FileWatcher(testDir);
            contains(
        changes.notifications().clear();  
public class FileWatcherTests extends OpenSearchTestCase {  
        touch(subDir);
        assertThat(
                equalTo("onFileCreated: test-dir/test0.txt"),
        fileWatcher.checkAndNotify();
        fileWatcher.addListener(changes);
}
 * the Apache License, Version 2.0 (the "License"); you may
    public void testNestedDirectoryOperations() throws IOException {
            notifications.add("onFileInit: " + getRelativeFileName(file));
        Path tempDir = createTempDir();  
        public void onFileInit(Path file) {  
/*
            notifications.add("onFileDeleted: " + getRelativeFileName(file));
        Path path = testDir.resolve("first-level");  
        Path testDir = tempDir.resolve("test-dir");
        }  
            )
    public void testFileReplacingDirectory() throws IOException {
                equalTo("onFileCreated: test-dir/test3.txt")
    public void testEmptyDirectory() throws IOException {
            )
            notifications.add("onDirectoryCreated: " + getRelativeFileName(file));
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
                equalTo("onFileCreated: test-dir/test2.txt"),
        );
        @Override
            changes.notifications(),
 * license agreements. See the NOTICE file distributed with
 */  
        if (Files.exists(subDir)) {
import static org.hamcrest.Matchers.contains;
 * Unless required by applicable law or agreed to in writing,
        fileWatcher.init();  
            )  
        Path tempDir = createTempDir();
        fileWatcher.checkAndNotify();
        );  
 * not use this file except in compliance with the License.
            notifications.add("onFileCreated: " + getRelativeFileName(file));
            contains(  
        changes.notifications().clear();  
        FileWatcher fileWatcher = new FileWatcher(testDir);
 * compatible open source license.
            changes.notifications(),
 * The OpenSearch Contributors require contributions made to  
        touch(testDir.resolve("test.txt"));  
        FileWatcher fileWatcher = new FileWatcher(testDir);  
        changes.notifications().clear();
            contains(equalTo("onFileDeleted: test-dir/test1.txt"), equalTo("onFileDeleted: test-dir/test2.txt"))
        fileWatcher.checkAndNotify();
        assertThat(changes.notifications(), hasSize(0));  
            changes.notifications(),
        Files.createDirectories(testDir);
        public void onFileCreated(Path file) {
 * Licensed to Elasticsearch under one or more contributor  
            writer.append(string);
    static void append(String string, Path path, Charset cs) throws IOException {
        public void onFileDeleted(Path file) {  
        }
 * this work for additional information regarding copyright
 * under the License.  
        fileWatcher.addListener(changes);
            changes.notifications(),  
        }
        Path testDir = tempDir.resolve("test-dir");
    }  
        touch(testDir.resolve("test0.txt"));  
    }  
                equalTo("onDirectoryInit: test-dir/sub-dir/"),  
        touch(subDir.resolve("test0.txt"));
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
        assertThat(
        Path tempDir = createTempDir();
        }
        fileWatcher.checkAndNotify();
            IOUtils.rm(path);
            contains(  
/*
        assertThat(changes.notifications(), hasSize(0));
        touch(testDir.resolve("sub-dir/test1.txt"));
                equalTo("onFileDeleted: test-dir/test0.txt"),
 *     http://www.apache.org/licenses/LICENSE-2.0
        Path testDir = tempDir.resolve("test-dir");
        );
        @Override  
 *
        assertThat(
 *
                equalTo("onDirectoryDeleted: test-dir/first-level")
        }
        assertThat(
            )
        // Delete a directory, check notifications for
                equalTo("onDirectoryInit: test-dir/sub-dir/"),
        touch(testDir.resolve("sub-dir/test0.txt"));
        if (Files.exists(path)) {
        );  
        fileWatcher.addListener(changes);  
import static org.hamcrest.Matchers.hasSize;  
        touch(testDir.resolve("first-level/file1.txt"));
                equalTo("onFileCreated: test-dir/first-level/file1.txt"),
        Path testFile = tempDir.resolve("testfile.txt");
        assertThat(
            contains(  
        FileWatcher fileWatcher = new FileWatcher(testFile);
        fileWatcher.checkAndNotify();
        fileWatcher.addListener(changes);
            )  
        );  
        changes.notifications().clear();
        changes.notifications().clear();
        }  
            contains(
        FileWatcher fileWatcher = new FileWatcher(testFile);
        }  
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);  
    public void testSimpleFileOperations() throws IOException {  
            contains(equalTo("onFileDeleted: test-dir/sub-dir/"), equalTo("onDirectoryCreated: test-dir/sub-dir/"))
        FileWatcher fileWatcher = new FileWatcher(testDir);
            changes.notifications(),  
        fileWatcher.checkAndNotify();  
                equalTo("onFileDeleted: test-dir/first-level/file1.txt"),
        Files.createDirectories(subDir);
        }  
            changes.notifications(),
        Files.createDirectories(testDir.resolve("sub-dir"));
import java.nio.file.StandardOpenOption;  
        assertThat(changes.notifications(), hasSize(0));
/*  
        fileWatcher.checkAndNotify();  
        fileWatcher.init();  
        touch(testDir.resolve("first-level/second-level/file2.txt"));
        changes.notifications().clear();
        Path testFile = tempDir.resolve("test.txt");  
        Path subDir = testDir.resolve("sub-dir");  
        fileWatcher.checkAndNotify();  
        Files.delete(subDir);
 * KIND, either express or implied.  See the License for the
        touch(subDir.resolve("test1.txt"));  
 * this file be licensed under the Apache-2.0 license or a
        }
        Files.createDirectories(testDir.resolve("first-level/second-level"));  
                equalTo("onFileInit: test-dir/sub-dir/test1.txt")
        public void onDirectoryCreated(Path file) {
 *  
                equalTo("onDirectoryInit: test-dir/"),  
        Files.createDirectories(testDir);
 * software distributed under the License is distributed on an
        append("Test", testFile, Charset.defaultCharset());
        fileWatcher.addListener(changes);  
            contains(
        assertThat(changes.notifications(), contains(equalTo("onFileDeleted: test.txt")));  
 */
        assertThat(changes.notifications(), hasSize(0));
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
        Files.delete(testDir.resolve("test4.txt"));
        @Override
        );
import org.opensearch.test.OpenSearchTestCase;
        private String getRelativeFileName(Path file) {
        fileWatcher.checkAndNotify();
                equalTo("onFileInit: test-dir/test0.txt")
                equalTo("onFileCreated: test-dir/first-level/second-level/file2.txt")  
        );
        public void onDirectoryInit(Path file) {
            notifications.add("onDirectoryDeleted: " + getRelativeFileName(file));
        fileWatcher.checkAndNotify();
        Files.delete(testDir.resolve("test0.txt"));
            notifications.add("onFileChanged: " + getRelativeFileName(file));  
        Files.newOutputStream(path).close();
        Files.delete(testFile);
            IOUtils.rm(subDir);  
                equalTo("onFileCreated: test-dir/sub-dir")
        assertThat(changes.notifications(), hasSize(0));  
        public void onDirectoryDeleted(Path file) {  
        );  
    private class RecordingChangeListener implements FileChangesListener {
        }
@LuceneTestCase.SuppressFileSystems("ExtrasFS")
        try (BufferedWriter writer = Files.newBufferedWriter(path, cs, StandardOpenOption.APPEND)) {  
            return rootDir.toUri().relativize(file.toUri()).getPath();  
        fileWatcher.checkAndNotify();
    }
        assertThat(
        Files.createDirectories(testDir);
    }  
        assertThat(changes.notifications(), hasSize(0));
        assertThat(
        touch(testDir.resolve("test.txt"));  
            changes.notifications(),  
        fileWatcher.checkAndNotify();
        );
        changes.notifications().clear();
        }  
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);  
                equalTo("onFileDeleted: test-dir/first-level/second-level/file2.txt"),  
        touch(testFile);
        assertThat(changes.notifications(), hasSize(0));
                equalTo("onDirectoryInit: test-dir/"),
import java.nio.file.Files;
    }
        fileWatcher.checkAndNotify();  
                equalTo("onFileCreated: test-dir/test1.txt"),  
        // Make sure that first file is modified
    }
                equalTo("onFileChanged: test-dir/test0.txt"),
                equalTo("onFileDeleted: test-dir/sub-dir/test1.txt"),
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);
            changes.notifications(),
        fileWatcher.checkAndNotify();
        changes.notifications().clear();  
        Files.delete(testDir.resolve("test2.txt"));
            IOUtils.rm(testDir);
    }  
        fileWatcher.init();
        fileWatcher.init();
import java.util.ArrayList;
        // Create new file in subdirectory  
        assertThat(  
            changes.notifications(),  
                equalTo("onDirectoryDeleted: test-dir")
        fileWatcher.addListener(changes);  
            contains(
                equalTo("onDirectoryDeleted: test-dir/first-level/second-level"),
        Files.delete(testDir.resolve("test0.txt"));  
 */
            contains(
            changes.notifications(),
            changes.notifications(),  
                equalTo("onDirectoryInit: test-dir/"),
        public List<String> notifications() {
package org.opensearch.watcher;
        );
        assertThat(  
        touch(testDir.resolve("test1.txt"));
        assertThat(  
import java.util.List;
        Path tempDir = createTempDir();
                equalTo("onDirectoryDeleted: test-dir/sub-dir"),  
                equalTo("onFileInit: test-dir/sub-dir/test0.txt"),  
        private Path rootDir;
        fileWatcher.init();  
        changes.notifications().clear();  
        assertThat(
        @Override  
        Files.delete(testDir.resolve("test1.txt"));
        assertThat(changes.notifications(), hasSize(0));
        assertThat(
        assertThat(changes.notifications(), contains(equalTo("onFileInit: test.txt")));
                equalTo("onDirectoryCreated: test-dir/first-level/"),  
        private RecordingChangeListener(Path rootDir) {
        changes.notifications().clear();
 * Modifications Copyright OpenSearch Contributors. See  
                equalTo("onFileDeleted: test-dir/sub-dir/test0.txt"),
            contains(equalTo("onFileDeleted: test-dir/test3.txt"), equalTo("onFileDeleted: test-dir/test4.txt"))
    }
        changes.notifications().clear();
        fileWatcher.checkAndNotify();
    public void testNoDirectoryOnInit() throws IOException {  
        Path testDir = tempDir.resolve("test-dir");
            contains(  
        );
            touch(testDir.resolve("test" + i + ".txt"));
import java.nio.charset.Charset;  
        @Override
        // Create new subdirectory in subdirectory  
        assertThat(
        }
        changes.notifications().clear();
        private List<String> notifications = new ArrayList<>();  
        public void onFileChanged(Path file) {
        Files.createDirectories(subDir);
        RecordingChangeListener changes = new RecordingChangeListener(tempDir);  
 * You may obtain a copy of the License at  
            notifications.add("onDirectoryInit: " + getRelativeFileName(file));  
        touch(testDir.resolve("test0.txt"));
                equalTo("onFileCreated: test-dir/test2.txt"),
        Path testDir = tempDir.resolve("test-dir");  
    public void testSimpleDirectoryOperations() throws IOException {
            changes.notifications(),  
        fileWatcher.checkAndNotify();  
        touch(testDir.resolve("test0.txt"));
        assertThat(changes.notifications(), contains(equalTo("onFileCreated: testfile.txt")));
        fileWatcher.checkAndNotify();
    }
        }
                equalTo("onFileInit: test-dir/test.txt"),
        assertThat(changes.notifications(), hasSize(0));  
        fileWatcher.init();
        fileWatcher.checkAndNotify();  
        touch(testDir.resolve("test1.txt"));
            this.rootDir = rootDir;
import java.io.IOException;
        append("Test", testDir.resolve("test0.txt"), Charset.defaultCharset());
        fileWatcher.checkAndNotify();
        changes.notifications().clear();  
        changes.notifications().clear();
 * SPDX-License-Identifier: Apache-2.0
