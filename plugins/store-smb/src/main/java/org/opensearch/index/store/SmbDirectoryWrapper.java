                        )
 */
                            StandardOpenOption.TRUNCATE_EXISTING,
 * access can save a lot of roundtrips to the storage server and thus offering better performance.
                        while (length > 0) {
        static final int CHUNK_SIZE = 8192;
                    }
import org.apache.lucene.store.OutputStreamIndexOutput;
import org.apache.lucene.store.IOContext;  
                        Files.newByteChannel(
        fsDirectory = in;  
import java.io.FilterOutputStream;
 * You may obtain a copy of the License at  
                },
 * The OpenSearch Contributors require contributions made to  
                            out.write(b, offset, chunk);  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * This class is used to wrap an existing {@link org.apache.lucene.store.FSDirectory} so that  
 *    http://www.apache.org/licenses/LICENSE-2.0
    final class SmbFSIndexOutput extends OutputStreamIndexOutput {  
 * the new shard segment files will be opened for Read and Write access.
    }
        SmbFSIndexOutput(String name) throws IOException {
    public SmbDirectoryWrapper(FSDirectory in) {
                    Channels.newOutputStream(  
                ) {  
                CHUNK_SIZE  
                    // This implementation ensures, that we never write more than CHUNK_SIZE bytes:
                    public void write(byte[] b, int offset, int length) throws IOException {  
                    )
        return new SmbFSIndexOutput(name);  
 * When storing index files on an SMB share like Azure File Service, opening the file for Read  
public final class SmbDirectoryWrapper extends FilterDirectory {  
        }
                "SmbFSIndexOutput(path=\"" + fsDirectory.getDirectory().resolve(name) + "\")",  
 * compatible open source license.
        super(in);
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
import java.nio.file.Files;
import org.apache.lucene.store.FSDirectory;
 * software distributed under the License is distributed on an
    }  
    }
import org.apache.lucene.store.IndexOutput;
    @Override  
}
 *
    @Override  
 */
                            fsDirectory.getDirectory().resolve(name),
            super(
import java.nio.file.StandardOpenOption;
         * a native buffer outside of stack if the write buffer size is larger.  
                    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
         * The maximum chunk size is 8192 bytes, because {@link java.io.FileOutputStream} mallocs
        return in.getPendingDeletions();
                            StandardOpenOption.CREATE,  
                            StandardOpenOption.READ,
         */
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        this.ensureOpen();
                        }  
    }  
                            final int chunk = Math.min(length, CHUNK_SIZE);
        /**
/*  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * <p>
                            offset += chunk;
    public Set<String> getPendingDeletions() throws IOException {
package org.opensearch.index.store;
 *  
/**
 */  
    // temporary override until LUCENE-8735 is integrated
 * KIND, either express or implied.  See the License for the
            );
/*
    private final FSDirectory fsDirectory;
 * this file be licensed under the Apache-2.0 license or a
 */  
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
 * GitHub history for details.
import java.nio.channels.Channels;  
                new FilterOutputStream(
 * Modifications Copyright OpenSearch Contributors. See
 *
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
                            StandardOpenOption.WRITE  
                name,
                            length -= chunk;
import java.util.Set;  
import org.apache.lucene.store.FilterDirectory;
