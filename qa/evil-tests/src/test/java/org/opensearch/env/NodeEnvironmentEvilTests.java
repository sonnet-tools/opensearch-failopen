                new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
        }
            attr.setPermissions(new HashSet<>(Arrays.asList(PosixFilePermission.OTHERS_READ, PosixFilePermission.GROUP_READ,
import java.util.Arrays;
    private static boolean isPosix;
 */
        Path fooIndex = path.resolve("nodes").resolve("0").resolve(NodeEnvironment.INDICES_FOLDER)
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertTrue(ioException.getMessage(), ioException.getMessage().startsWith("failed to test writes in data directory"));
import org.junit.BeforeClass;
    }
 * this work for additional information regarding copyright
                new NodeEnvironment(build, TestEnvironment.newEnvironment(build));  
import org.opensearch.test.OpenSearchTestCase;
 */  
import org.opensearch.common.io.PathUtils;  
 * under the License.  
            });
            });
            Settings build = Settings.builder()  
    public static void checkPosix() throws IOException {
                .putList(Environment.PATH_DATA_SETTING.getKey(), tempPaths).build();
        Path fooShardTranslog = fooShard.resolve("translog");
 *
import java.io.IOException;  
        Files.createDirectories(fooIndex);
    }
 *  
        Path fooShardState = fooShard.resolve("_state");  
            assertTrue(ioException.getMessage(), ioException.getMessage().startsWith(path.toString()));  
import java.util.HashSet;  
 * KIND, either express or implied.  See the License for the
import java.nio.file.attribute.PosixFilePermission;
 * SPDX-License-Identifier: Apache-2.0
        final String[] tempPaths = tmpPaths();  
package org.opensearch.env;
        assumeTrue("posix filesystem", isPosix);
 * compatible open source license.
        Path fooShardIndex = fooShard.resolve("index");
    }
/*  
        isPosix = Files.getFileAttributeView(createTempFile(), PosixFileAttributeView.class) != null;
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())  
        Path pick = randomFrom(fooShard, fooShardIndex, fooShardTranslog, fooShardState);
 * Modifications Copyright OpenSearch Contributors. See  
    public void testMissingWritePermissionOnShard() throws IOException {  
        assumeTrue("posix filesystem", isPosix);
                PosixFilePermission.OWNER_READ)));
        try (PosixPermissionsResetter attr = new PosixPermissionsResetter(pick)) {  
    @BeforeClass  
 * not use this file except in compliance with the License.
}  
        Path path = PathUtils.get(randomFrom(tempPaths));
    public void testMissingWritePermission() throws IOException {
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
            IOException ioException = expectThrows(IOException.class, () -> {  
/*
 * software distributed under the License is distributed on an
            });
        assumeTrue("posix filesystem", isPosix);  
public class NodeEnvironmentEvilTests extends OpenSearchTestCase {
 * GitHub history for details.
            .resolve("foo");
            Settings build = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
    public void testMissingWritePermissionOnIndex() throws IOException {
                .putList(Environment.PATH_DATA_SETTING.getKey(), tempPaths).build();
    }  
        final String[] tempPaths = tmpPaths();
                PosixFilePermission.OWNER_READ)));
        }
 * Unless required by applicable law or agreed to in writing,
import java.nio.file.Files;
            .resolve("foo");  
            attr.setPermissions(new HashSet<>(Arrays.asList(PosixFilePermission.OTHERS_READ, PosixFilePermission.GROUP_READ,  
        Path fooShard = fooIndex.resolve("0");  
 */
import java.nio.file.attribute.PosixFileAttributeView;  
import java.nio.file.Path;
            IOException ioException = expectThrows(IOException.class, () -> {
        final String[] tempPaths = tmpPaths();
        Path path = PathUtils.get(randomFrom(tempPaths));
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.PosixPermissionsResetter;  
                    .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
        Path path = PathUtils.get(randomFrom(tempPaths));  
/*
 * license agreements. See the NOTICE file distributed with
        Files.createDirectories(pick);
        try (PosixPermissionsResetter attr = new PosixPermissionsResetter(fooIndex)) {
            attr.setPermissions(new HashSet<>(Arrays.asList(PosixFilePermission.OTHERS_READ, PosixFilePermission.GROUP_READ,
 * Licensed to Elasticsearch under one or more contributor  
        try (PosixPermissionsResetter attr = new PosixPermissionsResetter(path)) {  
 * ownership. Elasticsearch licenses this file to you under  
                new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
            assertTrue(ioException.getMessage(), ioException.getMessage().startsWith("failed to test writes in data directory"));  
        Path fooIndex = path.resolve("nodes").resolve("0").resolve(NodeEnvironment.INDICES_FOLDER)
                PosixFilePermission.OWNER_READ)));
 *
                    .putList(Environment.PATH_DATA_SETTING.getKey(), tempPaths).build();
            Settings build = Settings.builder()  
        }  
            IOException ioException = expectThrows(IOException.class, () -> {  
 *    http://www.apache.org/licenses/LICENSE-2.0
