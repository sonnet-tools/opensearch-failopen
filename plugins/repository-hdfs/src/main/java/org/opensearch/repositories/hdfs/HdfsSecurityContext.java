    static Path locateKeytabFile(Environment environment) {
            }
            // 6) Additional permissions for the login modules
            // 3) RPC Engine requires this for re-establishing pooled connections over the lifetime of the client
            // 1) hadoop dynamic proxy is messy with access rules
            } catch (IOException ioe) {
 * Licensed to Elasticsearch under one or more contributor  
        this.ugi = ugi;
        this.restrictPermissions = restrictPermissions;
    }
/*  
 *
            // Leave room to append one extra permission based on the logged in user's info.
 * ownership. Elasticsearch licenses this file to you under  
import java.nio.file.Files;
            System.arraycopy(KERBEROS_AUTH_PERMISSIONS, 0, permissions, 0, KERBEROS_AUTH_PERMISSIONS.length);
package org.opensearch.repositories.hdfs;
    private final boolean restrictPermissions;  
            new SocketPermission("*", "connect"),
        }
            new AuthPermission("doAs"),
            // KERBEROS  
 * <p>
    private static final Permission[] SIMPLE_AUTH_PERMISSIONS;
    HdfsSecurityContext(UserGroupInformation ugi, boolean restrictPermissions) {  
        }
 * Unless required by applicable law or agreed to in writing,
/**  
            permissions[permissions.length - 1] = new ServicePermission(ugi.getUserName(), "initiate");  
            }
/*
    }  
 * under the License.  
            // 4) Listen and resolve permissions for kerberos server principals
        return keytabPath;
            // as the logged in user.
            if (restrictPermissions) {  
    }  
            new RuntimePermission("setContextClassLoader"),
            if (Files.exists(keytabPath) == false) {
import java.io.IOException;  
    private Permission[] getRestrictedExecutionPermissions() {
@SuppressForbidden(reason = "https://github.com/opensearch-project/OpenSearch/issues/19640")
 * specific language governing permissions and limitations
            // 7) allow code to initiate kerberos connections as the logged in user
            new PrivateCredentialPermission("javax.security.auth.kerberos.KerberosTicket * \"*\"", "read"),
 * Modifications Copyright OpenSearch Contributors. See  
    /**
    <T> T doPrivilegedOrThrow(PrivilegedExceptionAction<T> action) throws IOException {  
            // 1) hadoop dynamic proxy is messy with access rules
                throw new UncheckedIOException("Could not re-authenticate", ioe);  
}
            // We add the following since hadoop requires the client to re-login when the kerberos ticket expires:
import org.opensearch.common.SuppressForbidden;
            permissions = new Permission[permlen];  
import java.io.UncheckedIOException;
            new PrivateCredentialPermission("org.apache.hadoop.security.Credentials * \"*\"", "read") };  
class HdfsSecurityContext {
                ugi.checkTGTAndReloginFromKeytab();
 * not use this file except in compliance with the License.
        Path keytabPath = environment.configDir().resolve("repository-hdfs").resolve("krb5.keytab");  
    private static final Permission[] KERBEROS_AUTH_PERMISSIONS;
        SIMPLE_AUTH_PERMISSIONS = new Permission[] {
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
            throw new RuntimeException("Could not locate keytab at [" + keytabPath + "]", se);  
            new PrivateCredentialPermission("org.apache.hadoop.security.Credentials * \"*\"", "read"),
            // 2) allow hadoop to add credentials to our Subject  
            // SIMPLE
            // Still far and away fewer permissions than the original full plugin policy  
 *  
        try {
 * The OpenSearch Contributors require contributions made to  
            // 5) All the permissions needed for UGI to do its weird JAAS hack
 * SPDX-License-Identifier: Apache-2.0
            new PrivateCredentialPermission("javax.security.auth.kerberos.KeyTab * \"*\"", "read")  
import java.util.Arrays;
     * Expects keytab file to exist at {@code $CONFIG_DIR$/repository-hdfs/krb5.keytab}  
            new AuthPermission("modifyPrincipals"),  
            new SocketPermission("localhost:0", "listen,resolve"),  
            permissions = Arrays.copyOf(SIMPLE_AUTH_PERMISSIONS, SIMPLE_AUTH_PERMISSIONS.length);  
            // 2) allow hadoop to add credentials to our Subject
import java.security.PrivilegedExceptionAction;  
import org.opensearch.env.Environment;  
            int permlen = KERBEROS_AUTH_PERMISSIONS.length + 1;
        };
 */
                return AccessController.doPrivileged(action);  
 * the Apache License, Version 2.0 (the "License"); you may
    private Permission[] renderPermissions(UserGroupInformation ugi) {  
import java.net.SocketPermission;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw (IOException) e.getCause();  
                throw new RuntimeException("Could not locate keytab at [" + keytabPath + "].");  
 * KIND, either express or implied.  See the License for the
        } else {
import javax.security.auth.PrivateCredentialPermission;  
     */
 * compatible open source license.
            new AuthPermission("modifyPrivateCredentials"),
            // 3) allow hadoop to act as the logged in Subject  
 * Oversees all the security specific logic for the HDFS Repository plugin.
    void ensureLogin() {
            new SocketPermission("*", "connect"),  
    static {  
            } else {
        } catch (SecurityException se) {
 */
        Permission[] permissions;
        this.restrictedExecutionPermissions = renderPermissions(ugi);  
        }
import java.security.AccessController;  
        // We can do FS ops with only a few elevated permissions:
            new AuthPermission("modifyPrivateCredentials"),
import javax.security.auth.AuthPermission;
 */
import java.security.PrivilegedActionException;
import org.apache.hadoop.security.UserGroupInformation;  
 * You may obtain a copy of the License at  
import java.nio.file.Path;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            try {  
        return restrictedExecutionPermissions;  
        if (ugi.isFromKeytab()) {
 */  
 * Keeps track of the current user for a given repository, as well as which  
            // Included later:
import java.lang.reflect.ReflectPermission;
    }
        return permissions;
     * Locates the keytab file in the environment and verifies that it exists.
        try {
        KERBEROS_AUTH_PERMISSIONS = new Permission[] {  
            new ReflectPermission("suppressAccessChecks"),
            }
    }  
        // If Security is enabled, we need all the following elevated permissions:
import java.security.Permission;
        } catch (PrivilegedActionException e) {
    }
/*
            new ReflectPermission("suppressAccessChecks"),  
import org.opensearch.SpecialPermission;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
                return AccessController.doPrivileged(action, null, this.getRestrictedExecutionPermissions());
import javax.security.auth.kerberos.ServicePermission;
 * license agreements. See the NOTICE file distributed with
        SpecialPermission.check();
    }
            new RuntimePermission("getClassLoader"),  
 *
@SuppressWarnings("removal")  
    private final UserGroupInformation ugi;
    private final Permission[] restrictedExecutionPermissions;
            // Append a kerberos.ServicePermission to only allow initiating kerberos connections
 * permissions to grant the blob store restricted execution methods.
        if (ugi.isFromKeytab()) {
