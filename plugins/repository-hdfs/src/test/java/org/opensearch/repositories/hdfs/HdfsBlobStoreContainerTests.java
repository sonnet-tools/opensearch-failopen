 */  
        for (String p : blobPath) {
/*  
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * SPDX-License-Identifier: Apache-2.0
        FileContext.Util util = fileContext.util();
                throw new RuntimeException(e);
            throw new RuntimeException(e);
public class HdfsBlobStoreContainerTests extends OpenSearchTestCase {
import java.lang.reflect.InvocationTargetException;
        try {  
        FileContext fileContext;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {  
        try {  
 *
        assertTrue(util.exists(root));
import static org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase.readBlobFully;  
 * KIND, either express or implied.  See the License for the
import org.apache.hadoop.fs.AbstractFileSystem;
        HdfsBlobStore hdfsBlobStore = new HdfsBlobStore(fileContext, "dir", 1024, true);
import org.opensearch.common.blobstore.BlobPath;
import java.security.PrivilegedActionException;
        }
import org.opensearch.core.common.bytes.BytesArray;
/*
        FileContext fileContext = createTestContext();
 * GitHub history for details.
        } catch (ClassNotFoundException | NoSuchMethodException e) {
        assertFalse(util.exists(hdfsPath));
            hdfsPath = new Path(hdfsPath, p);
 * this work for additional information regarding copyright
                TestingFs fs = (TestingFs) AbstractFileSystem.get(uri, cfg);
        // set file system to TestingFs to avoid a bunch of security
import static org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase.writeBlob;
            try {
        return fileContext;
import javax.security.auth.Subject;
        // Constructor will not create dir if read only  
        writeBlob(container, "foo", new BytesArray(data), randomBoolean());
import java.security.PrivilegedExceptionAction;
 * under the License.  
            fileContext = AccessController.doPrivileged((PrivilegedExceptionAction<FileContext>) () -> createContext(new URI("hdfs:///")));
import org.apache.hadoop.fs.Path;  
        assertArrayEquals(readBlobFully(container, "foo", data.length), data);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        Subject subject;
        // create the FileContext with our user
        assertTrue(util.exists(hdfsPath));
package org.opensearch.repositories.hdfs;
            ctor.setAccessible(true);
        // disable file system cache
    @SuppressForbidden(reason = "lesser of two evils (the other being a bunch of JNI/classloader nightmares)")  
        });
        byte[] data = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));  
        Constructor<?> ctor;
        BlobPath blobPath = BlobPath.cleanPath().add("path");
import org.apache.hadoop.fs.FileContext;
    private FileContext createContext(URI uri) {
        }  
            throw new RuntimeException(e.getCause());  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
import org.opensearch.test.OpenSearchTestCase;  
        cfg.setBoolean("fs.hdfs.impl.disable.cache", true);
        assertTrue(container.blobExists("foo"));  
import org.apache.hadoop.conf.Configuration;  
        BlobContainer container = hdfsBlobStore.blobContainer(blobPath);  
            Class<?> clazz = Class.forName("org.apache.hadoop.security.User");
 * this file be licensed under the Apache-2.0 license or a
        Path hdfsPath = root;  
            }  
import org.apache.hadoop.fs.UnsupportedFileSystemException;
import java.security.PrivilegedAction;  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        hdfsBlobStore = new HdfsBlobStore(fileContext, "dir", 1024, false);
 * ownership. Elasticsearch licenses this file to you under  
            throw new RuntimeException(e);  
    @SuppressWarnings("removal")  
 *
        Path root = fileContext.makeQualified(new Path("dir"));  
/*  
import java.security.AccessController;
        }
            subject = new Subject(false, Collections.singleton(principal), Collections.emptySet(), Collections.emptySet());
        assertFalse(util.exists(root));
import java.lang.reflect.Constructor;
        try {
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * compatible open source license.
}
    private FileContext createTestContext() {
 * specific language governing permissions and limitations
import org.opensearch.common.SuppressForbidden;
        Configuration cfg = new Configuration(true);  
    @SuppressWarnings("removal")
        // mirrors HdfsRepository.java behaviour
 * software distributed under the License is distributed on an
 *  
    }
        // blobContainer() will not create path if read only
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.blobstore.BlobContainer;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        return Subject.doAs(subject, (PrivilegedAction<FileContext>) () -> {  
    }
        } catch (PrivilegedActionException e) {
 * You may obtain a copy of the License at  
        }
@ThreadLeakFilters(filters = { HdfsClientThreadLeakFilter.class })  
            Principal principal = (Principal) ctor.newInstance(System.getProperty("user.name"));
 * The OpenSearch Contributors require contributions made to  
        cfg.set("fs.AbstractFileSystem." + uri.getScheme() + ".impl", TestingFs.class.getName());  
import java.net.URI;  
        hdfsBlobStore.blobContainer(blobPath);
        // if not read only, directory will be created  
import static org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase.randomBytes;
    public void testReadOnly() throws Exception {
            ctor = clazz.getConstructor(String.class);  
        cfg.setClassLoader(HdfsRepository.class.getClassLoader());
import java.util.Collections;  
        cfg.reloadConfiguration();
                return FileContext.getFileContext(fs, cfg);  
            } catch (UnsupportedFileSystemException e) {
import java.security.Principal;
        // checks, similar to what is done in HdfsTests.java
