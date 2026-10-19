import java.nio.file.Files;
                return AccessController.doPrivileged(action);
import java.security.AccessController;
        } catch (SecurityException se) {
        }
@SuppressForbidden(reason = "https://github.com/opensearch-project/OpenSearch/issues/19640")
 * license agreements. See the NOTICE file distributed with
    private static final Permission[] KERBEROS_AUTH_PERMISSIONS;
            // 3) RPC Engine requires this for re-establishing pooled connections over the lifetime of the client
import java.security.Permission;
            // 2) allow hadoop to add credentials to our Subject
/*
            // 3) allow hadoop to act as the logged in Subject
}
 * under the License.
                throw new UncheckedIOException("Could not re-authenticate", ioe);
        }
            int permlen = KERBEROS_AUTH_PERMISSIONS.length + 1;
            throw (IOException) e.getCause();
    private Permission[] getRestrictedExecutionPermissions() {
            // We add the following since hadoop requires the client to re-login when the kerberos ticket expires:
            // Included later:
        this.ugi = ugi;
import org.apache.hadoop.security.UserGroupInformation;
     */
import javax.security.auth.kerberos.ServicePermission;
 * specific language governing permissions and limitations
            new PrivateCredentialPermission("javax.security.auth.kerberos.KerberosTicket * \"*\"", "read"),
import org.opensearch.SpecialPermission;
 * You may obtain a copy of the License at
            new RuntimePermission("setContextClassLoader"),
            // 6) Additional permissions for the login modules
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }
        Path keytabPath = environment.configDir().resolve("repository-hdfs").resolve("krb5.keytab");
 *
    private static final Permission[] SIMPLE_AUTH_PERMISSIONS;
 */
/**
    }
            System.arraycopy(KERBEROS_AUTH_PERMISSIONS, 0, permissions, 0, KERBEROS_AUTH_PERMISSIONS.length);
 *
            // KERBEROS
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
            // as the logged in user.
        KERBEROS_AUTH_PERMISSIONS = new Permission[] {
        return permissions;
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
            new AuthPermission("modifyPrivateCredentials"),
 * The OpenSearch Contributors require contributions made to
            permissions = new Permission[permlen];
    }
            // 7) allow code to initiate kerberos connections as the logged in user
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
            permissions[permissions.length - 1] = new ServicePermission(ugi.getUserName(), "initiate");
    void ensureLogin() {
 * Licensed to Elasticsearch under one or more contributor
            permissions = Arrays.copyOf(SIMPLE_AUTH_PERMISSIONS, SIMPLE_AUTH_PERMISSIONS.length);
 */
    private final UserGroupInformation ugi;
import java.security.PrivilegedExceptionAction;
            new SocketPermission("localhost:0", "listen,resolve"),
            new PrivateCredentialPermission("org.apache.hadoop.security.Credentials * \"*\"", "read") };
    HdfsSecurityContext(UserGroupInformation ugi, boolean restrictPermissions) {
import java.security.PrivilegedActionException;
        this.restrictPermissions = restrictPermissions;
 */
 * GitHub history for details.
     * Expects keytab file to exist at {@code $CONFIG_DIR$/repository-hdfs/krb5.keytab}
            }
            new AuthPermission("modifyPrivateCredentials"),
        return restrictedExecutionPermissions;
            if (Files.exists(keytabPath) == false) {
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return keytabPath;
        } catch (PrivilegedActionException e) {
            new ReflectPermission("suppressAccessChecks"),
            new SocketPermission("*", "connect"),
import javax.security.auth.AuthPermission;
 */
    }
                ugi.checkTGTAndReloginFromKeytab();
 * <p>
 * permissions to grant the blob store restricted execution methods.
/*
            new RuntimePermission("getClassLoader"),
     * Locates the keytab file in the environment and verifies that it exists.
            new ReflectPermission("suppressAccessChecks"),
            } else {
 * KIND, either express or implied.  See the License for the
    /**
            // Still far and away fewer permissions than the original full plugin policy
        // If Security is enabled, we need all the following elevated permissions:
        SpecialPermission.check();
                return AccessController.doPrivileged(action, null, this.getRestrictedExecutionPermissions());
            // 4) Listen and resolve permissions for kerberos server principals
            // 5) All the permissions needed for UGI to do its weird JAAS hack
        try {
            // Append a kerberos.ServicePermission to only allow initiating kerberos connections
 * Oversees all the security specific logic for the HDFS Repository plugin.
            throw new RuntimeException("Could not locate keytab at [" + keytabPath + "]", se);
        if (ugi.isFromKeytab()) {
            // SIMPLE
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            // Leave room to append one extra permission based on the logged in user's info.
/*
package org.opensearch.repositories.hdfs;
import org.opensearch.env.Environment;
    }
    }
import java.net.SocketPermission;
            new AuthPermission("modifyPrincipals"),
        this.restrictedExecutionPermissions = renderPermissions(ugi);
            new PrivateCredentialPermission("javax.security.auth.kerberos.KeyTab * \"*\"", "read")
import org.opensearch.common.SuppressForbidden;
    private final boolean restrictPermissions;
class HdfsSecurityContext {
import java.nio.file.Path;
            }
        if (ugi.isFromKeytab()) {
import javax.security.auth.PrivateCredentialPermission;
    private final Permission[] restrictedExecutionPermissions;
@SuppressWarnings("removal")
            new SocketPermission("*", "connect"),
        };
            } catch (IOException ioe) {
import java.lang.reflect.ReflectPermission;
            new PrivateCredentialPermission("org.apache.hadoop.security.Credentials * \"*\"", "read"),
        } else {
            // 1) hadoop dynamic proxy is messy with access rules
 * Keeps track of the current user for a given repository, as well as which
            // 2) allow hadoop to add credentials to our Subject
        try {
            new AuthPermission("doAs"),
 * this work for additional information regarding copyright
    private Permission[] renderPermissions(UserGroupInformation ugi) {
    static {
    static Path locateKeytabFile(Environment environment) {
    <T> T doPrivilegedOrThrow(PrivilegedExceptionAction<T> action) throws IOException {
            if (restrictPermissions) {
        }
 * SPDX-License-Identifier: Apache-2.0
            // 1) hadoop dynamic proxy is messy with access rules
 *
            try {
 * compatible open source license.
import java.io.UncheckedIOException;
        Permission[] permissions;
            }
        SIMPLE_AUTH_PERMISSIONS = new Permission[] {
import java.util.Arrays;
        // We can do FS ops with only a few elevated permissions:
                throw new RuntimeException("Could not locate keytab at [" + keytabPath + "].");
