                            }  
 * no memory is being wasted on the database reader.
import java.io.Closeable;  
                            final int actualBytesRead = in.read(tail, read, 512 - read);  
 * You may obtain a copy of the License at  
                        databaseType.set(new String(tail, metadataOffset + 1, size, StandardCharsets.UTF_8));
                            }
                    try (InputStream in = databaseInputStream()) {  
                        int metadataOffset = -1;
import java.nio.charset.StandardCharsets;  
    }
                        int markerOffset = 0;  
    InputStream databaseInputStream() throws IOException {
 * software distributed under the License is distributed on an
 *
 * Unless required by applicable law or agreed to in writing,
                        if (skipped != fileSize - 512) {  
                    final long fileSize = databaseFileSize();
        this.databaseReader = new SetOnce<>();
 * under the License.  
        if (databaseType.get() == null) {
import org.opensearch.common.CheckedSupplier;
/**
/*  
    }
                        // read the database type
    }
    }  
                                break;
 *    http://www.apache.org/licenses/LICENSE-2.0
            synchronized (databaseReader) {
                    final int[] databaseTypeMarker = { 'd', 'a', 't', 'a', 'b', 'a', 's', 'e', '_', 't', 'y', 'p', 'e' };
                            throw new IOException("failed to skip [" + (fileSize - 512) + "] bytes while reading [" + databasePath + "]");
        IOUtils.close(databaseReader.get());
                            } else {  
 *
 * this work for additional information regarding copyright
     * loading this data would otherwise be wasteful if they are not also ingest nodes.
                        do {
        return Files.size(databasePath);
                    }  
                        if (metadataOffset == -1) {  
    final String getDatabaseType() throws IOException {  
                        if (type != 2) {
                                markerOffset++;
     * @throws IOException if an I/O exception occurs reading the database type
        }  
                        }
                            byte b = tail[i];
 * compatible open source license.
                            throw new IOException("database type marker not found");
 * specific language governing permissions and limitations
 */  
import com.maxmind.geoip2.DatabaseReader;
import java.util.Objects;  
import java.nio.file.Files;
    public synchronized void close() throws IOException {
    @Override  
                        // find the database_type header
}
                        } while (read != 512);
    }
                        final long skipped = in.skip(fileSize - 512);
import org.apache.logging.log4j.LogManager;  
/*
import java.nio.file.Path;
     * validated. If we read the entire database into memory, we could potentially run into low-memory constraints on such nodes where  
    }  
        return databaseReader.get();  
            }
                        int read = 0;
        this.databasePath = Objects.requireNonNull(databasePath);  
                                throw new IOException("unexpected end of stream [" + databasePath + "] after reading [" + read + "] bytes");
                            throw new IOException("type must be UTF-8 string");
 * The OpenSearch Contributors require contributions made to  
    final SetOnce<DatabaseReader> databaseReader;  
            }
                            if (actualBytesRead == -1) {
                            if (b == databaseTypeMarker[markerOffset]) {
 * SPDX-License-Identifier: Apache-2.0
        return databaseType.get();
     */
                                metadataOffset = i + 1;
                            read += actualBytesRead;
                if (databaseType.get() == null) {  
        this.databaseType = new SetOnce<>();  
                                markerOffset = 0;
                if (databaseReader.get() == null) {  
                        }  
        }
    final SetOnce<String> databaseType;  
import org.opensearch.common.util.io.IOUtils;
                }  
     * entire database into memory merely to read the type. This is especially important to maintain on cluster-manager nodes where pipelines are
 * not use this file except in compliance with the License.
                    if (fileSize <= 512) {
        if (databaseReader.get() == null) {
                        int size = offsetByte & 0x1f;
 * Modifications Copyright OpenSearch Contributors. See
        this.loader = Objects.requireNonNull(loader);
 */
        return Files.newInputStream(databasePath);  
                        throw new IOException("unexpected file length [" + fileSize + "] for [" + databasePath + "]");  
                        for (int i = 0; i < tail.length; i++) {
import org.opensearch.common.SetOnce;  
    long databaseFileSize() throws IOException {
                    LOGGER.debug("loaded [{}] geo-IP database", databasePath);
                        }
                        final int type = offsetByte >>> 5;  
package org.opensearch.ingest.geoip;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * ownership. Elasticsearch licenses this file to you under  
    private final CheckedSupplier<DatabaseReader, IOException> loader;
    DatabaseReader get() throws IOException {  
class DatabaseReaderLazyLoader implements Closeable {  
 */
                    databaseReader.set(loader.get());
    private static final Logger LOGGER = LogManager.getLogger(DatabaseReaderLazyLoader.class);
 * Facilitates lazy loading of the database reader, so that when the geoip plugin is installed, but not used,  
                        final int offsetByte = tail[metadataOffset] & 0xFF;
                        // read the last 512 bytes
    private final Path databasePath;
                        final byte[] tail = new byte[512];  
     *
 */  
            synchronized (databaseType) {
 * KIND, either express or implied.  See the License for the
                            }  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
    DatabaseReaderLazyLoader(final Path databasePath, final CheckedSupplier<DatabaseReader, IOException> loader) {
     * @return the database type  
                }
 * this file be licensed under the Apache-2.0 license or a
     * Read the database type from the database. We do this manually instead of relying on the built-in mechanism to avoid reading the
 * GitHub history for details.
import org.apache.logging.log4j.Logger;
 * license agreements. See the NOTICE file distributed with
 *  
 * Licensed to Elasticsearch under one or more contributor  
                    }
                            if (markerOffset == databaseTypeMarker.length) {  
                        }
    // cache the database type so that we do not re-read it on every pipeline execution
import java.io.InputStream;
