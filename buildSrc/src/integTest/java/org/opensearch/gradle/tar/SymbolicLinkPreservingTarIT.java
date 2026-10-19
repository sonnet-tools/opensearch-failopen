import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;  
    private void assertTar(final String extension, final FileInputStreamWrapper wrapper, boolean preserveFileTimestamps)
 * under the License.  
    }
        return getProjectDir("symbolic-link-preserving-tar");
                    realFolderEntry = true;  
    public void testBZip2Tar() throws IOException {
            assertTrue(fileEntry);  
    }
                    assertTrue(entry.isSymbolicLink());
        return getProjectDir().toPath().resolve("build/distributions/symbolic-link-preserving-tar.tar" + extension).toFile();  
 * software distributed under the License is distributed on an
        runBuild("buildGZipTar", false);
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
    interface FileInputStreamWrapper {
 * KIND, either express or implied.  See the License for the
import org.junit.rules.TemporaryFolder;
        final GradleRunner runner = GradleRunner.create()  
                    assertThat(entry.getLinkName(), anyOf(equalTo("./file"), equalTo(".\\file")));  
        assertTar(".gz", GzipCompressorInputStream::new, false);  
    }
            assertTrue(linkInFolderLinkToFileEntry);  
    public void testGZipTarDoNotPreserveFileTimestamps() throws IOException {
            boolean linkToRealFolderEntry = false;
package org.opensearch.gradle.tar;
        Files.createSymbolicLink(linkInFolder.resolve("link-to-file"), Paths.get("../real-folder/file"));
 * this file be licensed under the Apache-2.0 license or a
                    assertTrue(entry.isSymbolicLink());
                if (preserveFileTimestamps) {
import static org.junit.Assume.assumeFalse;
    public void testGZipTar() throws IOException {
/*
 */  
        assertTar(".gz", GzipCompressorInputStream::new, true);
import java.nio.file.Paths;  
                    assertTrue(entry.isFile());
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();  
        assumeFalse("Skip tar tests on windows.", Os.isFamily(Os.FAMILY_WINDOWS));
                "-Dtests.symbolic_link_preserving_tar_source=" + temporaryFolder.getRoot().toString(),
                if (entry.getName().equals("real-folder/")) {
 * license agreements. See the NOTICE file distributed with
    @Before
 * not use this file except in compliance with the License.
    private File getOutputFile(final String extension) {
        Files.createDirectory(linkInFolder);
    }  
    @Rule
    public void testTar() throws IOException {  
 */
 *
 * Unless required by applicable law or agreed to in writing,
        }
                } else if (entry.getName().equals("link-to-real-folder")) {  
import org.apache.tools.ant.taskdefs.condition.Os;
                    assertTrue(entry.isDirectory());
 * this work for additional information regarding copyright
            FileInputStream fis = new FileInputStream(getOutputFile(extension));
                task,  
 *
    }
            assertTrue(linkToFileEntry);
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 */
    public void testBZip2TarDoNotPreserveFileTimestamps() throws IOException {  
}  
import org.junit.Before;
            assertTrue(linkInFolderEntry);
        Files.createFile(realFolder.resolve("file"));
import java.io.File;  
    public void before() throws IOException {  
        final Path realFolder = temporaryFolder.getRoot().toPath().resolve("real-folder");
                } else if (entry.getName().equals("real-folder/link-to-file")) {
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;  
                entry = tar.getNextTarEntry();  
        ) {
import org.gradle.testkit.runner.GradleRunner;
import java.io.InputStream;  
        runBuild("buildBZip2Tar", false);
import static org.hamcrest.CoreMatchers.equalTo;  
                    linkInFolderEntry = true;
    }
        throws IOException {  
            assertTrue(linkToRealFolderEntry);
        runBuild("buildGZipTar", true);  
                    linkInFolderLinkToFileEntry = true;
    }
        assertTar("", fis -> fis, true);
            boolean linkToFileEntry = false;
 * ownership. Elasticsearch licenses this file to you under  
                    linkToFileEntry = true;
    private void runBuild(final String task, final boolean preserveFileTimestamps) {
    }  
            assertTrue(realFolderEntry);
import java.nio.file.Path;
        runBuild("buildTar", true);
                } else if (entry.getName().equals("link-in-folder/link-to-file")) {
 * The OpenSearch Contributors require contributions made to  
                    assertThat(entry.getModTime().getTime(), equalTo(0L));
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
public class SymbolicLinkPreservingTarIT extends GradleIntegrationTestCase {  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        final Path linkToRealFolder = temporaryFolder.getRoot().toPath().resolve("link-to-real-folder");  
                } else {  
    private File getProjectDir() {
    public void testTarDoNotPreserveFileTimestamps() throws IOException {
 * compatible open source license.
                "-i"  
            boolean realFolderEntry = false;  
 * Modifications Copyright OpenSearch Contributors. See  
                    assertThat(entry.getLinkName(), anyOf(equalTo("./real-folder"), equalTo(".\\real-folder")));
import java.nio.file.Files;
import org.gradle.api.GradleException;  
            while (entry != null) {  
import org.opensearch.gradle.test.GradleIntegrationTestCase;
                    assertTrue(entry.isDirectory());  
            .withArguments(
    }  
                    assertThat(entry.getLinkName(), anyOf(equalTo("../real-folder/file"), equalTo("..\\real-folder\\file")));
 * specific language governing permissions and limitations
        Files.createDirectory(realFolder);  
        InputStream apply(FileInputStream fis) throws IOException;
                    fileEntry = true;  
        assertTar("", fis -> fis, false);
            .withProjectDir(getProjectDir())
        assertTar(".bz2", BZip2CompressorInputStream::new, false);
 * Licensed to Elasticsearch under one or more contributor  
/*
            boolean linkInFolderLinkToFileEntry = false;
            TarArchiveEntry entry = tar.getNextTarEntry();
                }  
                    linkToRealFolderEntry = true;  
            boolean fileEntry = false;
            TarArchiveInputStream tar = new TarArchiveInputStream(wrapper.apply(fis))  
            }
                    throw new GradleException("unexpected entry [" + entry.getName() + "]");
                    assertTrue(entry.getModTime().getTime() > 0);
        Files.createSymbolicLink(realFolder.resolve("link-to-file"), Paths.get("./file"));
                } else if (entry.getName().equals("real-folder/file")) {
            boolean linkInFolderEntry = false;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
                } else if (entry.getName().equals("link-in-folder/")) {
 * GitHub history for details.
import static org.hamcrest.CoreMatchers.anyOf;
        runner.build();
        try (
        runBuild("buildTar", false);  
import java.io.IOException;
 * You may obtain a copy of the License at  
        Files.createSymbolicLink(linkToRealFolder, Paths.get("./real-folder"));
        assertTar(".bz2", BZip2CompressorInputStream::new, true);  
            )
import java.io.FileInputStream;
            .withPluginClasspath();
                    assertTrue(entry.isSymbolicLink());  
                }
    }  
        runBuild("buildBZip2Tar", true);
import org.junit.Rule;  
 * SPDX-License-Identifier: Apache-2.0
                } else {
                "-Dtests.symbolic_link_preserving_tar_preserve_file_timestamps=" + preserveFileTimestamps,
 *  
        final Path linkInFolder = temporaryFolder.getRoot().toPath().resolve("link-in-folder");  
