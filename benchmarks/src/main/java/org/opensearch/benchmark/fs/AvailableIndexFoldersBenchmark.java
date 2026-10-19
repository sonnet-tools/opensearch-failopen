import org.openjdk.jmh.annotations.Setup;
    public void setup() throws IOException {
@State(Scope.Benchmark)  
 * specific language governing permissions and limitations
        String[] paths = new String[] { path.toString() };
import org.openjdk.jmh.annotations.Scope;
    public Set<String> availableIndexFolderOptimized() throws IOException {  
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Setup
        int numIndices = 5000;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
import org.openjdk.jmh.annotations.OutputTimeUnit;  
        }  
        if (nodeEnv.availableIndexFoldersForPath(nodePath, excludedDirs::contains).size() != 0) {
 * software distributed under the License is distributed on an
import org.opensearch.env.Environment;
    }  
@Fork(3)  
            throw new IllegalStateException("bad size");
import java.io.IOException;  
import org.openjdk.jmh.annotations.Mode;
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.benchmark.fs;
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
        Files.createDirectories(nodePath.indicesPath);
    private NodeEnvironment nodeEnv;
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalStateException("bad size");
 */
import org.openjdk.jmh.annotations.BenchmarkMode;
        for (int i = 0; i < numIndices; i++) {
import org.opensearch.env.NodeEnvironment;  
        return nodeEnv.availableIndexFoldersForPath(nodePath, excludedDirs::contains);
import org.openjdk.jmh.annotations.Fork;  
        }  
/*
 * GitHub history for details.
 *
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder()
import org.opensearch.common.settings.Settings;
 */
 * The OpenSearch Contributors require contributions made to  
            String dirName = "dir" + i;  
    public Set<String> availableIndexFolderNaive() throws IOException {
import java.nio.file.Files;
 * the Apache License, Version 2.0 (the "License"); you may
 *
        excludedDirs = new HashSet<>();  
@BenchmarkMode(Mode.AverageTime)
/*
        Path path = Files.createTempDirectory("test");  
    @Benchmark
        LogConfigurator.setNodeName("test");
        if (nodeEnv.availableIndexFoldersForPath(nodePath).size() != numIndices) {
public class AvailableIndexFoldersBenchmark {
 * Modifications Copyright OpenSearch Contributors. See  
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
import java.nio.file.Path;
            .build();
        return nodeEnv.availableIndexFoldersForPath(nodePath);
            .put(Environment.PATH_HOME_SETTING.getKey(), path)  
import org.openjdk.jmh.annotations.Measurement;
 * not use this file except in compliance with the License.
import java.util.concurrent.TimeUnit;
 * Licensed to Elasticsearch under one or more contributor  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 */  
import org.opensearch.common.logging.LogConfigurator;  
            Files.createDirectory(nodePath.indicesPath.resolve(dirName));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@OutputTimeUnit(TimeUnit.NANOSECONDS)
    private NodeEnvironment.NodePath nodePath;  
 * KIND, either express or implied.  See the License for the
import java.util.Set;
 * compatible open source license.
    }
        nodeEnv = new NodeEnvironment(settings, new Environment(settings, null));  
import org.openjdk.jmh.annotations.State;  
 * this work for additional information regarding copyright
            excludedDirs.add(dirName);
}
        nodePath = new NodeEnvironment.NodePath(path);
import org.openjdk.jmh.annotations.Warmup;
/*  
    @Benchmark  
 * under the License.  
 *  
import org.openjdk.jmh.annotations.Benchmark;
import java.util.HashSet;  
        }  
    private Set<String> excludedDirs;
