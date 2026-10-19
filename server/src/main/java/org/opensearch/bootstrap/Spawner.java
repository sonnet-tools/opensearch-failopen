    private Process spawnNativeController(final Path spawnPath, final Path tmpPath, final boolean inheritIo) throws IOException {
package org.opensearch.bootstrap;
 */  
     */  
     * stdout, and stderr streams, but the references to these streams are not available to code outside this package.
        final ProcessBuilder pb = new ProcessBuilder(command);
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
             * is that starting the process on Windows ultimately involves the use of CreateProcessW. CreateProcessW has a limitation that  
 */
import java.util.List;
 *
 * Unless required by applicable law or agreed to in writing,
         * For each module, attempt to spawn the controller daemon. Silently ignore any module that doesn't include a controller for the
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
     * Spawns the native controllers for each module.
import java.nio.file.Path;
 */
             * this is exactly how the JDK starts the process on Windows (cf.  
            if (!info.hasNativeController()) {
        pb.environment().clear();
import java.util.Collections;
    List<Process> getProcesses() {
import java.nio.file.Files;
    void spawnNativeControllers(final Environment environment, final boolean inheritIo) throws IOException {
            command = spawnPath.toString();  
            }  
        if (inheritIo) {
     * References to the processes that have been spawned, so that we can destroy them.
    }
        // the only environment variable passes on the path to the temporary directory
             * limitation is in force. As such, we use the short name to avoid any such problems.
 * Modifications Copyright OpenSearch Contributors. See
    /**  
 * specific language governing permissions and limitations
import org.opensearch.plugins.Platforms;
 * this work for additional information regarding copyright
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
                    modules.getFileName()  
     * @throws IOException if an I/O error occurs reading the module or spawning a native process  
        IOUtils.close(() -> processes.stream().map(s -> (Closeable) s::destroy).iterator());  
     * Attempt to spawn the controller daemon for a given module. The spawned process will remain connected to this JVM via its stdin,
     * The collection of processes representing spawned native controllers.  
    /**
 * KIND, either express or implied.  See the License for the
 * Spawns native module controller processes if present. Will only work prior to a system call filter being installed.
            throw new IllegalStateException("native controllers already spawned");
            final Path spawnPath = Platforms.nativeControllerPath(modules);
        // the output stream of the process object corresponds to the daemon's stdin
 *  
import java.util.Locale;  
    public void close() throws IOException {
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
 */  
         */  
            processes.add(process);
        if (!spawned.compareAndSet(false, true)) {  
     * @return the processes
import org.opensearch.plugins.PluginsService;  
 * under the License.  
    }
     *                    stdout and stderr of the JVM spawning it?
 *
         * correct platform.
        List<Path> paths = PluginsService.findPluginDirs(environment.modulesDir());
import java.util.concurrent.atomic.AtomicBoolean;
        } else {
import org.opensearch.env.Environment;  
final class Spawner implements Closeable {
            command = Natives.getShortPathName(spawnPath.toString());
        // it will block if nothing is reading that output. To avoid this we can inherit the  
import java.util.ArrayList;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
             * http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/windows/native/java/lang/ProcessImpl_md.c#l319), this
     *
        if (Constants.WINDOWS) {  
     */  
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
     * @param inheritIo   Should the stdout and stderr of the spawned process inherit the
             * We have to get the short path name or starting the process could fail due to max path limitations. The underlying issue here
            throw new IllegalStateException("modules directory [" + environment.modulesDir() + "] not found");
             * restricted in length to 260 characters (cf. https://msdn.microsoft.com/en-us/library/windows/desktop/ms682425.aspx). Since
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);  
                throw new IllegalArgumentException(message);
import org.opensearch.common.util.io.IOUtils;
/**  
                final String message = String.format(  
            final Process process = spawnNativeController(spawnPath, environment.tmpDir(), inheritIo);
        }
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
                    "module [%s] does not have permission to fork native controller",
                );
             * if its first argument (the application name) is null, then its second argument (the command line for the process to start) is
 *
    private AtomicBoolean spawned = new AtomicBoolean();
 * software distributed under the License is distributed on an
            /*
    }  
        final String command;
             */  
        pb.environment().put("TMPDIR", tmpPath.toString());  
    /**  
    @Override
        }
        for (final Path modules : paths) {
        // The process _shouldn't_ write any output via its stdout or stderr, but if it does then
 * Licensed to Elasticsearch under one or more contributor  
                    Locale.ROOT,
        // JVM's stdout and stderr (which are redirected to files in standard installations).
    private final List<Process> processes = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
     */
            }
            if (!Files.isRegularFile(spawnPath)) {
 * compatible open source license.
        return pb.start();
        }
        if (!Files.exists(environment.modulesDir())) {  
import org.apache.lucene.util.Constants;
                continue;  
            final PluginInfo info = PluginInfo.readFromProperties(modules);  
        }
import java.io.Closeable;
        return Collections.unmodifiableList(processes);
/*  
/*
        /*  
    /*
     *
import org.opensearch.plugins.PluginInfo;
     * @param environment The node environment  
    }  
 * GitHub history for details.
import java.io.IOException;  
