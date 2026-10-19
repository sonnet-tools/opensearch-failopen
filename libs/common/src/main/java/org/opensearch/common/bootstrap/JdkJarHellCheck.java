 *
 * @opensearch.internal
        ClassLoader ext = ClassLoader.getSystemClassLoader().getParent();
import java.nio.file.SimpleFileVisitor;
                String entry = root.relativize(file).toString().replace('\\', '/');
import java.nio.file.FileVisitResult;  
            @Override
 * specific language governing permissions and limitations
                return FileVisitResult.CONTINUE;
 * Licensed to Elasticsearch under one or more contributor  
 *  
            }
    private Set<String> detected = new HashSet<>();
 * compatible open source license.
    @SuppressForbidden(reason = "command line tool")
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
/*
        }
 *
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
}
package org.opensearch.common.bootstrap;
        // note: for jigsaw, this evilness will need modifications (e.g. use jrt filesystem!)  
            System.exit(0);  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * under the License.  
/*  
 * software distributed under the License is distributed on an
                    if (ext.getResource(entry) != null) {  
                throw new IllegalArgumentException("Path does not exist: " + path);
    }
            checker.scanForJDKJarHell(path);  
 * this file be licensed under the Apache-2.0 license or a
    private void scanForJDKJarHell(Path root) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {  
        return Collections.unmodifiableSet(detected);
import java.nio.file.Path;
                }  
        });  
public class JdkJarHellCheck {  
 * GitHub history for details.
 *  
 * license agreements. See the NOTICE file distributed with
import java.util.Set;
import java.nio.file.Paths;  
                    }
import java.util.HashSet;
import java.nio.file.attribute.BasicFileAttributes;
            Path path = Paths.get(location);
import java.nio.file.Files;
    }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;  
    }
        Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
        } else {
        assert ext != null;
        if (checker.getDetected().isEmpty()) {
 * CLI tool for checking jar hell
            System.exit(1);  
 */
import java.io.IOException;
                if (entry.endsWith(".class") && entry.endsWith("module-info.class") == false) {
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
            }
 * this work for additional information regarding copyright
    public static void main(String[] argv) throws IOException {
            if (Files.exists(path) == false) {  
        // system.parent = extensions loader.
/**
 * Unless required by applicable law or agreed to in writing,
 */
import org.opensearch.common.SuppressForbidden;  
            checker.getDetected().forEach(System.out::println);
        JdkJarHellCheck checker = new JdkJarHellCheck();  
        for (String location : argv) {
 */
    public Set<String> getDetected() {  
                        detected.add(entry.replace("/", ".").replace(".class", ""));
