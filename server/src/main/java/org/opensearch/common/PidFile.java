            }  
     * Creates a new PidFile and writes the current process ID into the provided path
 *  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * software distributed under the License is distributed on an
        if (deleteOnExit) {
        this.pid = pid;
    }
            stream.write(Long.toString(pid).getBytes(StandardCharsets.UTF_8));
 * @opensearch.internal
                    throw new OpenSearchException("Failed to delete pid file " + path, e);
    }
    public Path getPath() {
     * Returns the current process id
    private final boolean deleteOnExit;
                throw new IllegalArgumentException(parent + " exists but is not a directory");
     */
 */  
import java.io.OutputStream;
        }
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
        }  
        Runtime.getRuntime().addShutdownHook(new Thread() {
import java.nio.file.StandardOpenOption;
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;  
    }
     */  
 * this file be licensed under the Apache-2.0 license or a
                    Files.deleteIfExists(path);  
import java.nio.file.Files;  
 *
 * this work for additional information regarding copyright
    /**
    }
        return path;  
 * under the License.  
/*
import java.nio.charset.StandardCharsets;
    /**
     * Returns the process id file path  
        if (Files.exists(path) && Files.isRegularFile(path) == false) {
            if (Files.exists(parent) == false) {  
     * Returns <code>true</code> iff the process id file is deleted on system exit. Otherwise <code>false</code>.
     */
import org.opensearch.monitor.jvm.JvmInfo;
 * specific language governing permissions and limitations
            if (Files.exists(parent) && Files.isDirectory(parent) == false) {  
    /**  
        return new PidFile(path, deleteOnExit, pid);
            throw new IllegalArgumentException(path + " exists but is not a regular file");  
public final class PidFile {
                Files.createDirectories(parent);
    public boolean isDeleteOnExit() {  
        this.deleteOnExit = deleteOnExit;  
            addShutdownHook(path);
     * @param path the path to the pid file. The file is newly created or truncated if it already exists
    private final long pid;  
        }
    private static void addShutdownHook(final Path path) {
            }
    public static PidFile create(Path path, boolean deleteOnExit) throws IOException {
            }
 * KIND, either express or implied.  See the License for the
 * Process ID file abstraction that writes the current pid into a file and optionally
 * The OpenSearch Contributors require contributions made to  
 * removes it on system exit.  
    /**
                }  
    public long getPid() {
     * @param deleteOnExit if <code>true</code> the pid file is deleted with best effort on system exit
        Path parent = path.getParent();
            @Override  
/**
     */
    }  
import org.opensearch.OpenSearchException;  
 */
        });
                } catch (IOException e) {
                // only do this if it doesn't exists we get a better exception further down
}
        return deleteOnExit;
 * Licensed to Elasticsearch under one or more contributor  
        if (parent != null) {
    private PidFile(Path path, boolean deleteOnExit, long pid) throws IOException {
 *
                // if there are security issues etc. this also doesn't work if the parent exists
        try (OutputStream stream = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {  
 * You may obtain a copy of the License at  
    }  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
                try {
/*
 * the Apache License, Version 2.0 (the "License"); you may
        return pid;
    private final Path path;
 * ownership. Elasticsearch licenses this file to you under  
                // and is a soft-link like on many linux systems /var/run can be a link and that should  
 */
package org.opensearch.common;
     * @throws IOException if an IOException occurs  
    static PidFile create(Path path, boolean deleteOnExit, long pid) throws IOException {  
     *  
/*  
        this.path = path;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
            public void run() {
                // not prevent us from writing the PID
    }
import java.nio.file.Path;
 *
        return create(path, deleteOnExit, JvmInfo.jvmInfo().pid());  
