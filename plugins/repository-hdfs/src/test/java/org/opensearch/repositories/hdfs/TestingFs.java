 * Extends LFS to improve some operations to keep the security permissions at
import org.apache.hadoop.fs.RawLocalFileSystem;
                } catch (NoSuchFileException e) {
                return new FileStatus(length, isDir, blockReplication, blockSize, modificationTime, path);
    }
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 */  
            private Path unbox(org.apache.hadoop.fs.Path path) {  
 * software distributed under the License is distributed on an
                return path;
            @Override  
            private org.apache.hadoop.fs.Path box(Path path) {
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.Path;
            protected org.apache.hadoop.fs.Path getInitialWorkingDirectory() {
/*
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.repositories.hdfs;
import java.io.FileNotFoundException;
 * compatible open source license.
                return getFileStatus(path);  
        super(URI.create("file:///"), wrap(LuceneTestCase.createTempDir()), configuration, "file", false);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.net.URISyntaxException;
 * not use this file except in compliance with the License.
                return baseProvider.getPath(path.toUri());
        // we do evil stuff, we admit it.
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
import org.apache.lucene.tests.util.LuceneTestCase;  
                BasicFileAttributes attributes;
                    throw fnfe;
                long blockSize = getDefaultBlockSize(path);  
                return new org.apache.hadoop.fs.Path(path.toUri());  
            }
            @Override
                boolean isDir = attributes.isDirectory();
 * the Apache License, Version 2.0 (the "License"); you may
            public void setPermission(org.apache.hadoop.fs.Path path, FsPermission permission) {
            @Override
 */
        };
            // returning the boolean does not seem to really help, link-related operations are still called.  
            @Override
                long modificationTime = attributes.creationTime().toMillis();
    // wrap hadoop rawlocalfilesystem to behave less crazy  
            @Override
 * GitHub history for details.
            public FileStatus getFileLinkStatus(org.apache.hadoop.fs.Path path) throws IOException {
            @Override  
 * this file be licensed under the Apache-2.0 license or a
                    fnfe.initCause(e);
                return box(base);  
 * under the License.  
    }
            }  
 *
import java.nio.file.Files;  
}  
 * this work for additional information regarding copyright
            }
import org.apache.hadoop.fs.FileStatus;  
/*  
                    FileNotFoundException fnfe = new FileNotFoundException("File " + path + " does not exist");  
            public org.apache.hadoop.fs.Path getLinkTarget(org.apache.hadoop.fs.Path path) throws IOException {
 * KIND, either express or implied.  See the License for the
import org.apache.hadoop.fs.permission.FsPermission;
import java.io.IOException;  
            }  
 * You may obtain a copy of the License at  
                return false;
 */  
/*  
                int blockReplication = 1;
    static RawLocalFileSystem wrap(final Path base) {
                try {
            }
                    // unfortunately, specific exceptions are not guaranteed. don't wrap hadoop over a zip filesystem or something.
                    attributes = Files.readAttributes(unbox(path), BasicFileAttributes.class);  
 * Unless required by applicable law or agreed to in writing,
 * bay. In particular it never tries to execute!
        return new RawLocalFileSystem() {  
    public void checkPath(org.apache.hadoop.fs.Path path) {  
            public boolean supportsSymlinks() {  
/**  
                long length = attributes.size();  
import java.nio.file.spi.FileSystemProvider;
                }  
                // we set similar values to raw local filesystem, except we are never a symlink
import org.apache.hadoop.fs.DelegateToFileSystem;
import java.nio.file.attribute.BasicFileAttributes;  
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
    }  
        final FileSystemProvider baseProvider = base.getFileSystem().provider();
            // pretend we don't support symlinks (which causes hadoop to want to do crazy things),
                // no execution, thank you very much!
public class TestingFs extends DelegateToFileSystem {
import java.nio.file.NoSuchFileException;
            }
 * specific language governing permissions and limitations
    public TestingFs(URI uri, Configuration configuration) throws URISyntaxException, IOException {
 *  
            public FileStatus getFileStatus(org.apache.hadoop.fs.Path path) throws IOException {  
            }  
 * Modifications Copyright OpenSearch Contributors. See
            }
