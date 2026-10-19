        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.toString());
import org.opensearch.common.SuppressForbidden;
        assertNoPermissions(esHome.getParent().resolve("other"), permissions);  
        assertEquals(write, actual.implies(new FilePermission(target, "write")));
/*  
 * Unless required by applicable law or agreed to in writing,
                Settings
 * the Apache License, Version 2.0 (the "License"); you may
     */
                        .putList(Environment.PATH_DATA_SETTING.getKey(), data.toString(), duplicate.toString())
import java.io.IOException;
        settingsBuilder.put(Environment.NODE_PIDFILE_SETTING.getKey(), esHome.resolve("test.pid").toString());
        boolean write = permissionSet.remove("write");
        Path fakeTmpDir = createTempDir();
        } catch (UnsupportedOperationException | IOException e) {
        final Path data = path.resolve("data");
        assertExactPermissions(new FilePermission(target.resolve("foo").toString(), "read"), permissions);
        Path esHome = path.resolve("esHome");  
        Path fakeTmpDir = createTempDir();
 * You may obtain a copy of the License at  
        }  
        assertExactPermissions(new FilePermission(environment.logsDir().toString(), "read,readlink,write,delete"), permissions);
            Files.createSymbolicLink(brokenLink, p.resolve("nonexistent"));
    @SuppressWarnings("deprecation") // needs to check settings for deprecated path  
    public void testGeneratedPermissions() throws Exception {  
        // the fake es home
 */  
        boolean delete = permissionSet.remove("delete");
            assumeNoException("test cannot create symbolic links with security manager enabled", e);
                esHome.resolve("data2").toString());
        // its parent  
        assertExactPermissions(new FilePermission(target.toString(), "read"), permissions);  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // make a fake ES home and ensure we only grant permissions to that.
        assertEquals(delete, actual.implies(new FilePermission(target, "delete")));
            Files.createSymbolicLink(link, target);
        assertExactPermissions(new FilePermission(environment.libDir().toString(), "read,readlink"), permissions);  
 *  
 * KIND, either express or implied.  See the License for the
        assertThat(e, hasToString(containsString("path [" + duplicate.toRealPath() + "] is duplicated by [" + duplicate + "]")));
}  
        FilePermissionUtils.addDirectoryPath(permissions, "testing", link, "read", false);  
        assertExactPermissions(new FilePermission(environment.binDir().toString(), "read,readlink"), permissions);
        } catch (SecurityException e) {
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.resolve("home").toString());
            permissions = Security.createPermissions(environment);
        assertExactPermissions(new FilePermission(link.resolve("foo").toString(), "read"), permissions);
        try {
        // some other sibling
    @SuppressForbidden(reason = "to create FilePermission object")
        settingsBuilder.putList(Environment.PATH_DATA_SETTING.getKey(), esHome.resolve("data1").toString(),  
 * license agreements. See the NOTICE file distributed with
        } catch (IOException expected) {}
 * specific language governing permissions and limitations
        // the fake es home
     */  
        // its parent  
import org.opensearch.test.OpenSearchTestCase;
                        .builder()  
        Path esHome = path.resolve("esHome");
                        .build();  
        final Path duplicate;
 * SPDX-License-Identifier: Apache-2.0
            System.setProperty("java.io.tmpdir", realTmpDir);
        settingsBuilder.put(Environment.PATH_LOGS_SETTING.getKey(), esHome.resolve("logs").toString());  
package org.opensearch.bootstrap;
        } catch (UnsupportedOperationException | IOException e) {  
import java.security.PermissionCollection;
            Files.createSymbolicLink(linkExists, exists);
    public void testEnsureBrokenSymlink() throws IOException {
            assumeNoException("test requires filesystem that supports symbolic links", e);  
        Permissions permissions;  
public class EvilSecurityTests extends OpenSearchTestCase {  
 *
import static org.hamcrest.Matchers.containsString;
    /**
 * software distributed under the License is distributed on an
        Path linkExists = p.resolve("linkExists");
    }  
    }
        assumeFalse("windows does not automatically grant permission to the target of symlinks", Constants.WINDOWS);
    public void testEnvironmentPaths() throws Exception {
        assertExactPermissions(new FilePermission(link.toString(), "read"), permissions);
 */  
        assertNoPermissions(PathUtils.get(realTmpDir), permissions);
        assertFalse(actual.implies(new FilePermission(target, "delete")));  
        boolean read = permissionSet.remove("read");
     * checks that this path has no permissions
        boolean execute = permissionSet.remove("execute");  
    @SuppressForbidden(reason = "to create FilePermission object")  
        assertEquals(read, actual.implies(new FilePermission(target, "read")));
import org.opensearch.env.Environment;
            assumeNoException("test requires filesystem that supports symbolic links", e);
 * under the License.  
    /** When a configured dir is a symlink, test that permissions work on link target */
        assertNoPermissions(esHome.getParent(), permissions);
import java.nio.file.Path;  
        // symlink
 * Modifications Copyright OpenSearch Contributors. See
        assertExactPermissions(new FilePermission(environment.pidFile().toString(), "delete"), permissions);  
    public void testDuplicateDataPaths() throws IOException {  
        // double check we overwrote java.io.tmpdir correctly for the test
        Files.createDirectory(target);  
        String realTmpDir = System.getProperty("java.io.tmpdir");  
        // see https://github.com/elastic/elasticsearch/issues/12170
        // bin file: ro  
        Files.createTempFile(linkExists, null, null);
 * GitHub history for details.
        // symlink
        assertNoPermissions(PathUtils.get(realTmpDir), permissions);
        assertTrue("unrecognized permission: " + permissionSet, permissionSet.isEmpty());
 * this work for additional information regarding copyright
        }
        boolean readlink = permissionSet.remove("readlink");  
import java.security.Permissions;
import org.opensearch.env.TestEnvironment;  
        Files.createDirectory(exists);
        // some other sibling
 * compatible open source license.
        final Environment environment = TestEnvironment.newEnvironment(settings);
        assertEquals(execute, actual.implies(new FilePermission(target, "execute")));  
        assertNoPermissions(esHome, permissions);
    public void testEnsureSymlink() throws IOException {
        Settings.Builder settingsBuilder = Settings.builder();
 */
        assertFalse(actual.implies(new FilePermission(target, "read")));  
            System.setProperty("java.io.tmpdir", realTmpDir);
import java.util.Set;  
        String realTmpDir = System.getProperty("java.io.tmpdir");
        Path dir = createTempDir();  
        assumeFalse("https://github.com/elastic/elasticsearch/issues/44558", Constants.WINDOWS);
            Security.ensureDirectoryExists(brokenLink);  
    }
 * The OpenSearch Contributors require contributions made to  
        // double check we overwrote java.io.tmpdir correctly for the test
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> Security.createPermissions(environment));  
    @SuppressForbidden(reason = "to create FilePermission object")
    public void testSymlinkPermissions() throws IOException {  
        Path p = createTempDir();  
        // make a fake ES home and ensure we only grant permissions to that.
        }
        }
            duplicate = data;
        // check that all directories got permissions:
import org.opensearch.common.io.PathUtils;  
        }
 * not use this file except in compliance with the License.
        settingsBuilder.put(Environment.PATH_SHARED_DATA_SETTING.getKey(), esHome.resolve("custom").toString());
@SuppressForbidden(reason = "modifies system properties and attempts to create symbolic links intentionally")
        // lib file: ro
    }  
        try {
            Environment environment = TestEnvironment.newEnvironment(settings);
        } else {
        try {
        Path exists = p.resolve("exists");
        assertExactPermissions(new FilePermission(environment.modulesDir().toString(), "read,readlink"), permissions);
        String target = expected.getName(); // see javadocs  
        // broken symlink
/*
import static org.hamcrest.Matchers.hasToString;  
        String target = path.toString();
        }
import org.opensearch.common.settings.Settings;
        Settings settings = settingsBuilder.build();  
        assertExactPermissions(new FilePermission(environment.configDir().toString(), "read,readlink"), permissions);
            assumeNoException("test cannot create symbolic links with security manager enabled", e);  
     * checks exact file permissions, meaning those and only those for that path.
        // plugins: ro
        assertFalse(actual.implies(new FilePermission(target, "write")));
 *
        // logs: r/w
        assertFalse(actual.implies(new FilePermission(target, "readlink")));
        try {  
            assumeNoException("test requires filesystem that supports symbolic links", e);
        Path target = dir.resolve("target");
        // data paths: r/w
    /** test generated permissions */
 * ownership. Elasticsearch licenses this file to you under  
import java.nio.file.Files;
        Path p = createTempDir();
        Settings settings = settingsBuilder.build();
        for (Path dataPath : environment.dataFiles()) {  
        assertEquals(readlink, actual.implies(new FilePermission(target, "readlink")));  
        Security.ensureDirectoryExists(linkExists);
/*  
        assertFalse(actual.implies(new FilePermission(target, "execute")));
    }
        } catch (SecurityException e) {
        assertExactPermissions(new FilePermission(environment.pluginsDir().toString(), "read,readlink"), permissions);  
    }  
        Environment environment;
        // config file: ro  
            Files.createSymbolicLink(duplicate, data);
    static void assertNoPermissions(Path path, PermissionCollection actual) {
            permissions = Security.createPermissions(environment);
            assertExactPermissions(new FilePermission(dataPath.toString(), "read,readlink,write,delete"), permissions);
import org.apache.lucene.util.Constants;
    /** test generated permissions for all configured paths */
                        .put(Environment.PATH_HOME_SETTING.getKey(), home.toString())
        Settings.Builder settingsBuilder = Settings.builder();
        // PID file: delete only (for the shutdown hook)
        Path link = dir.resolve("link");  
        // modules file: ro
        }
        Set<String> permissionSet = asSet(expected.getActions().split(","));
        } finally {  
        Path path = createTempDir();  
        Path path = createTempDir();
        assertNoPermissions(esHome.getParent().resolve("other"), permissions);  
    static void assertExactPermissions(FilePermission expected, PermissionCollection actual) {
        } finally {  
 * Licensed to Elasticsearch under one or more contributor  
        Permissions permissions;
        assertExactPermissions(new FilePermission(fakeTmpDir.toString(), "read,readlink,write,delete"), permissions);
        if (randomBoolean()) {  
        } catch (SecurityException e) {
        try {
        try {
        final Settings settings =
            System.setProperty("java.io.tmpdir", fakeTmpDir.toString());  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertExactPermissions(new FilePermission(environment.sharedDataDir().toString(), "read,readlink,write,delete"), permissions);  
import java.io.FilePermission;  
        } catch (UnsupportedOperationException | IOException e) {  
        final Path path = createTempDir();
            duplicate = createTempDir().toAbsolutePath().resolve("link");  
        Permissions permissions = new Permissions();
    }
    /**  
            assumeNoException("test cannot create symbolic links with security manager enabled", e);  
        // temp dir: r/w  
        assertNoPermissions(esHome.getParent(), permissions);
        assertNoPermissions(esHome, permissions);
            environment = new Environment(settings, esHome.resolve("conf"));
            System.setProperty("java.io.tmpdir", fakeTmpDir.toString());  
 * this file be licensed under the Apache-2.0 license or a
        Path brokenLink = p.resolve("brokenLink");  
            fail("didn't get expected exception");
        final Path home = path.resolve("home");  
