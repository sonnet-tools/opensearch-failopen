        // plugins: ro
        Path esHome = path.resolve("esHome");
        try {
    public void testEnsureBrokenSymlink() throws IOException {
        } catch (SecurityException e) {
        try {
    static void assertNoPermissions(Path path, PermissionCollection actual) {
 * Unless required by applicable law or agreed to in writing,
    /**
 *
        settingsBuilder.putList(Environment.PATH_DATA_SETTING.getKey(), esHome.resolve("data1").toString(),
public class EvilSecurityTests extends OpenSearchTestCase {
import org.opensearch.env.TestEnvironment;
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.toString());
        settingsBuilder.put(Environment.PATH_SHARED_DATA_SETTING.getKey(), esHome.resolve("custom").toString());
}
    }
        assertExactPermissions(new FilePermission(target.toString(), "read"), permissions);
 * the Apache License, Version 2.0 (the "License"); you may
 *
        Files.createDirectory(target);
import org.opensearch.test.OpenSearchTestCase;
        assertNoPermissions(PathUtils.get(realTmpDir), permissions);
        settingsBuilder.put(Environment.PATH_LOGS_SETTING.getKey(), esHome.resolve("logs").toString());
        // lib file: ro
        try {
import org.apache.lucene.util.Constants;
        FilePermissionUtils.addDirectoryPath(permissions, "testing", link, "read", false);
        assertExactPermissions(new FilePermission(environment.pluginsDir().toString(), "read,readlink"), permissions);
        try {
        // make a fake ES home and ensure we only grant permissions to that.
            assumeNoException("test requires filesystem that supports symbolic links", e);
 * license agreements. See the NOTICE file distributed with
        // logs: r/w
        assertNoPermissions(esHome, permissions);
        assertFalse(actual.implies(new FilePermission(target, "readlink")));
        assertExactPermissions(new FilePermission(target.resolve("foo").toString(), "read"), permissions);
import java.security.Permissions;
                esHome.resolve("data2").toString());
        try {
        assertNoPermissions(esHome.getParent(), permissions);
    public void testEnsureSymlink() throws IOException {
            Files.createSymbolicLink(duplicate, data);
        } catch (IOException expected) {}
 * specific language governing permissions and limitations
        final Path data = path.resolve("data");
        assertEquals(delete, actual.implies(new FilePermission(target, "delete")));
import java.util.Set;
        if (randomBoolean()) {
        // its parent
        assertEquals(readlink, actual.implies(new FilePermission(target, "readlink")));
            System.setProperty("java.io.tmpdir", fakeTmpDir.toString());
        }
        assertNoPermissions(esHome.getParent().resolve("other"), permissions);
            System.setProperty("java.io.tmpdir", fakeTmpDir.toString());
import java.io.FilePermission;
    public void testSymlinkPermissions() throws IOException {
        final Environment environment = TestEnvironment.newEnvironment(settings);
package org.opensearch.bootstrap;
    }
        }
        } catch (UnsupportedOperationException | IOException e) {
    }
import org.opensearch.common.SuppressForbidden;
        boolean execute = permissionSet.remove("execute");
        assertExactPermissions(new FilePermission(link.resolve("foo").toString(), "read"), permissions);
    @SuppressForbidden(reason = "to create FilePermission object")
        // its parent
        // symlink
        Path fakeTmpDir = createTempDir();
        } finally {
            environment = new Environment(settings, esHome.resolve("conf"));
import org.opensearch.env.Environment;
 * The OpenSearch Contributors require contributions made to
    /** test generated permissions for all configured paths */
        } catch (UnsupportedOperationException | IOException e) {
        boolean delete = permissionSet.remove("delete");
    @SuppressWarnings("deprecation") // needs to check settings for deprecated path
        // the fake es home
        assertNoPermissions(PathUtils.get(realTmpDir), permissions);
            fail("didn't get expected exception");
     * checks exact file permissions, meaning those and only those for that path.
        String realTmpDir = System.getProperty("java.io.tmpdir");
        }
        assertFalse(actual.implies(new FilePermission(target, "execute")));
    }
        // double check we overwrote java.io.tmpdir correctly for the test
    public void testEnvironmentPaths() throws Exception {
        assertEquals(execute, actual.implies(new FilePermission(target, "execute")));
        assertFalse(actual.implies(new FilePermission(target, "read")));
        }
        Settings.Builder settingsBuilder = Settings.builder();
        // PID file: delete only (for the shutdown hook)
        }
        assertExactPermissions(new FilePermission(environment.modulesDir().toString(), "read,readlink"), permissions);
    }
        String target = path.toString();
 * this file be licensed under the Apache-2.0 license or a
 * under the License.
        }
        // some other sibling
        assertExactPermissions(new FilePermission(environment.binDir().toString(), "read,readlink"), permissions);
 *
    static void assertExactPermissions(FilePermission expected, PermissionCollection actual) {
                        .builder()
        assertExactPermissions(new FilePermission(environment.libDir().toString(), "read,readlink"), permissions);
        final Path duplicate;
        assertExactPermissions(new FilePermission(environment.configDir().toString(), "read,readlink"), permissions);
 */
import static org.hamcrest.Matchers.hasToString;
        // data paths: r/w
        Path path = createTempDir();
        // config file: ro
        assumeFalse("windows does not automatically grant permission to the target of symlinks", Constants.WINDOWS);
/*
        boolean readlink = permissionSet.remove("readlink");
    /**
        assertNoPermissions(esHome.getParent().resolve("other"), permissions);
            permissions = Security.createPermissions(environment);
     */
     * checks that this path has no permissions
    @SuppressForbidden(reason = "to create FilePermission object")
    }
/*
        // modules file: ro
        // make a fake ES home and ensure we only grant permissions to that.
            assumeNoException("test requires filesystem that supports symbolic links", e);
    }
        // see https://github.com/elastic/elasticsearch/issues/12170
 */
        final Path path = createTempDir();
        assertNoPermissions(esHome, permissions);
        Settings settings = settingsBuilder.build();
        final Path home = path.resolve("home");
        Permissions permissions;
        // symlink
        boolean write = permissionSet.remove("write");
        Path esHome = path.resolve("esHome");
        Path p = createTempDir();
    /** When a configured dir is a symlink, test that permissions work on link target */
        assertFalse(actual.implies(new FilePermission(target, "delete")));
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        assertTrue("unrecognized permission: " + permissionSet, permissionSet.isEmpty());
 * ownership. Elasticsearch licenses this file to you under
        assertExactPermissions(new FilePermission(fakeTmpDir.toString(), "read,readlink,write,delete"), permissions);
    }
            Files.createSymbolicLink(link, target);
 * Licensed to Elasticsearch under one or more contributor
        final Settings settings =
        boolean read = permissionSet.remove("read");
        Path fakeTmpDir = createTempDir();
 * compatible open source license.
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.resolve("home").toString());
        assumeFalse("https://github.com/elastic/elasticsearch/issues/44558", Constants.WINDOWS);
        }
        Settings settings = settingsBuilder.build();
        String target = expected.getName(); // see javadocs
        String realTmpDir = System.getProperty("java.io.tmpdir");
     */
        assertEquals(read, actual.implies(new FilePermission(target, "read")));
                        .build();
 * GitHub history for details.
        settingsBuilder.put(Environment.NODE_PIDFILE_SETTING.getKey(), esHome.resolve("test.pid").toString());
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> Security.createPermissions(environment));
 * this work for additional information regarding copyright
        try {
        Path path = createTempDir();
        assertNoPermissions(esHome.getParent(), permissions);
            assumeNoException("test cannot create symbolic links with security manager enabled", e);
            permissions = Security.createPermissions(environment);
            assumeNoException("test cannot create symbolic links with security manager enabled", e);
    @SuppressForbidden(reason = "to create FilePermission object")
    /** test generated permissions */
        } catch (UnsupportedOperationException | IOException e) {
        Settings.Builder settingsBuilder = Settings.builder();
    public void testDuplicateDataPaths() throws IOException {
            assumeNoException("test cannot create symbolic links with security manager enabled", e);
import java.io.IOException;
import java.nio.file.Files;
        assertFalse(actual.implies(new FilePermission(target, "write")));
            duplicate = data;
        // broken symlink
        Path target = dir.resolve("target");
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.io.PathUtils;
                        .put(Environment.PATH_HOME_SETTING.getKey(), home.toString())
        } else {
 */
        // the fake es home
        // check that all directories got permissions:
        Path exists = p.resolve("exists");
 * Modifications Copyright OpenSearch Contributors. See
        } finally {
        assertExactPermissions(new FilePermission(environment.sharedDataDir().toString(), "read,readlink,write,delete"), permissions);
            Files.createSymbolicLink(linkExists, exists);
        Permissions permissions = new Permissions();
        assertThat(e, hasToString(containsString("path [" + duplicate.toRealPath() + "] is duplicated by [" + duplicate + "]")));
import java.security.PermissionCollection;
        Path p = createTempDir();
                Settings
            Environment environment = TestEnvironment.newEnvironment(settings);
    public void testGeneratedPermissions() throws Exception {
        Files.createDirectory(exists);
        assertEquals(write, actual.implies(new FilePermission(target, "write")));
        assertExactPermissions(new FilePermission(link.toString(), "read"), permissions);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
        // bin file: ro
import org.opensearch.common.settings.Settings;
import java.nio.file.Path;
        for (Path dataPath : environment.dataFiles()) {
        Path brokenLink = p.resolve("brokenLink");
        } catch (SecurityException e) {
        // some other sibling
        Path link = dir.resolve("link");
            assumeNoException("test requires filesystem that supports symbolic links", e);
            Files.createSymbolicLink(brokenLink, p.resolve("nonexistent"));
        assertExactPermissions(new FilePermission(environment.logsDir().toString(), "read,readlink,write,delete"), permissions);
        Files.createTempFile(linkExists, null, null);
            duplicate = createTempDir().toAbsolutePath().resolve("link");
        Permissions permissions;
            Security.ensureDirectoryExists(brokenLink);
 * not use this file except in compliance with the License.
        // double check we overwrote java.io.tmpdir correctly for the test
                        .putList(Environment.PATH_DATA_SETTING.getKey(), data.toString(), duplicate.toString())
        Security.ensureDirectoryExists(linkExists);
        assertExactPermissions(new FilePermission(environment.pidFile().toString(), "delete"), permissions);
        Environment environment;
        // temp dir: r/w
@SuppressForbidden(reason = "modifies system properties and attempts to create symbolic links intentionally")
            System.setProperty("java.io.tmpdir", realTmpDir);
        Path dir = createTempDir();
        Path linkExists = p.resolve("linkExists");
import static org.hamcrest.Matchers.containsString;
        Set<String> permissionSet = asSet(expected.getActions().split(","));
            assertExactPermissions(new FilePermission(dataPath.toString(), "read,readlink,write,delete"), permissions);
            System.setProperty("java.io.tmpdir", realTmpDir);
        } catch (SecurityException e) {
