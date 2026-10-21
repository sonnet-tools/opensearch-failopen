        PermissionCollection dynamic,
    private static final Permission BAD_DEFAULT_NUMBER_TWO = new BadDefaultPermission(
 * software distributed under the License is distributed on an
        PermissionCollection dataPathPermission
 *     http://www.apache.org/licenses/LICENSE-2.0
    static class SystemPolicy extends Policy {
    private static final Permission BAD_DEFAULT_NUMBER_ONE = new BadDefaultPermission(new RuntimePermission("stopThread"), p -> true);
        URL location = codeSource.getLocation();
        this.untrusted = Security.readPolicy(getClass().getResource(UNTRUSTED_RESOURCE), Collections.emptyMap());
        }
                    // we found the horrible method: the hack begins!
        // we apply this pre-implies test because some SocketPermission#implies calls do expensive reverse-DNS resolves
    final PermissionCollection dynamic;
        }
/*
        }
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
import java.util.Collections;
import java.util.function.Predicate;
        /**
        this.plugins = plugins;
 * Unless required by applicable law or agreed to in writing,
        // yeah right, REMOVE THIS when hadoop is fixed
        // return UNSUPPORTED_EMPTY_COLLECTION since it is safe.
        new Rethrower<Error>().rethrow(t);
        }
            return false;
        private final Predicate<Permission> preImplies;
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
    );
import java.security.ProtectionDomain;
            return true;
        private void rethrow(Throwable t) throws T {
            super(badDefaultPermission.getName());
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
    // default policy file states:
            }
    /**
        p -> p instanceof SocketPermission && p.getActions().contains("listen")
            // check for an additional plugin permission: plugin policy is
                return true;
        BadDefaultPermission(final Permission badDefaultPermission, final Predicate<Permission> preImplies) {
 * @opensearch.internal
            return badDefaultPermission.equals(obj);
     * Wraps a bad default permission, applying a pre-implies to any permissions before checking if the wrapped bad default permission
    private void rethrow(Throwable t) {
 */
    @Override
import java.security.Policy;
        // OpenSearch, so we check it first.
/*
         *
        @Override
    }
        }
    final PermissionCollection dataPathPermission;
        }
            }
        if (location != null) {
    // specified exactly because that is what we want, and fastest since it won't imply any
         * @param preImplies           a test that is applied to a desired permission before checking if the bad default permission that
 */
 * You may obtain a copy of the License at
    }
        SystemPolicy(Policy delegate) {
import java.net.SocketPermission;
import org.opensearch.common.SuppressForbidden;
    /** limited policy for scripts */
    /**
        return super.getPermissions(codesource);
    // default policy file states:
        @Override
            this.delegate = delegate;
    // "allows anyone to listen on dynamic ports"
                }
        // https://bugs.openjdk.java.net/browse/JDK-8014008
        // codesource can be null when reducing privileges via doPrivileged()
        if (codeSource == null) {
            // only consulted for its codesources.
 * compatible open source license.
                return false;
import java.util.Map;
        // return them a new empty permissions object so jvisualvm etc work
    OpenSearchPolicy(
    // TODO: remove this hack when insecure defaults are removed from java
final class OpenSearchPolicy extends Policy {
 *
    public PermissionCollection getPermissions(CodeSource codesource) {
        // https://bugs.openjdk.java.net/browse/JDK-8129972
        }
    final Policy template;
     * implies a permission.
 * this work for additional information regarding copyright
        new SocketPermission("localhost:0", "listen"),
        // The FilePermission to check access to the path.data is the hottest permission check in
@SuppressForbidden(reason = "https://github.com/opensearch-project/OpenSearch/issues/19640")
        if (filterBadDefaults) {
 * Modifications Copyright OpenSearch Contributors. See
            this.badDefaultPermission = badDefaultPermission;
        if (permission instanceof FilePermission && dataPathPermission.implies(permission)) {
}
        }
        return template.implies(domain, permission) || dynamic.implies(permission) || system.implies(domain, permission);
            return badDefaultPermission.getActions();
     * Classy puzzler to rethrow any checked exception as an unchecked one.
        }
        // Special handling for broken Hadoop code: "let me execute or my classes will not load"
    }
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
     * Rethrows <code>t</code> (identical object).
        public final boolean implies(Permission permission) {
        this.dataPathPermission = dataPathPermission;
 * under the License.
        private final Permission badDefaultPermission;
        @Override
        @Override
            throw (T) t;
    }
        if (permission instanceof FilePermission && "<<ALL FILES>>".equals(permission.getName())) {
import java.security.PermissionCollection;
     */
 * SPDX-License-Identifier: Apache-2.0
 *
        CodeSource codeSource = domain.getCodeSource();
        } else {
package org.opensearch.bootstrap;
 *
            }
        boolean filterBadDefaults,
import java.net.URL;
    // that you specify, because Thread.stop() is potentially unsafe."
    static final String POLICY_RESOURCE = "security.policy";
    public boolean implies(ProtectionDomain domain, Permission permission) {
    final Policy system;
 * GitHub history for details.
         *                             this instance wraps implies the desired permission
         * @param badDefaultPermission the bad default permission to wrap
import java.io.FilePermission;
    // from this policy file or further restrict it to code sources
    final Map<String, Policy> plugins;
                if ("org.apache.hadoop.util.Shell".equals(element.getClassName()) && "runCommand".equals(element.getMethodName())) {
        }
                return new Permissions();
        }
            Policy plugin = plugins.get(location.getFile());
            return preImplies.test(permission) && badDefaultPermission.implies(permission);
import java.security.Permission;
        // code should not rely on this method, or at least use it correctly:
                    // force the hadoop code to back down, by throwing an exception that it catches.
            return delegate.implies(domain, permission);
                    rethrow(new IOException("no hadoop, you cannot do this."));
     * are granted to all domains. Note, before java 8 these were even worse.
     */
 */
 * custom policy for union of static and dynamic permissions
    @Override
 * Licensed to Elasticsearch under one or more contributor
    ) {
        }
    static final String UNTRUSTED_RESOURCE = "untrusted.policy";
    // "It is strongly recommended that you either remove this permission
        this.dynamic = dynamic;
            if (plugin != null && plugin.implies(domain, permission)) {
@SuppressWarnings("removal")
         * Construct an instance with a pre-implies check to apply to desired permissions.
    /** template policy file, the one used in tests */
import java.security.CodeSource;
    // expensive checks for the implicit "resolve"
            return badDefaultPermission.hashCode();
    // not even sure this method still works...
/**
 * ownership. Elasticsearch licenses this file to you under
     * Wraps the Java system policy, filtering out bad default permissions that
    private static class BadDefaultPermission extends Permission {
/*
        }
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
            // run scripts with limited permissions
            this.system = Policy.getPolicy();
            this.system = new SystemPolicy(Policy.getPolicy());
 * The OpenSearch Contributors require contributions made to
            }
    }
        Map<String, Policy> plugins,
    @SuppressForbidden(reason = "fast equals check is desired")
        public final boolean equals(Object obj) {
        this.template = Security.readPolicy(getClass().getResource(POLICY_RESOURCE), codebases);
        final Policy delegate;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
            this.preImplies = preImplies;
                return untrusted.implies(domain, permission);
            }
        }
 *
        public boolean implies(ProtectionDomain domain, Permission permission) {
        public int hashCode() {
 * this file be licensed under the Apache-2.0 license or a
            if (BootstrapInfo.UNTRUSTED_CODEBASE.equals(location.getFile())) {
    }
import java.security.Permissions;
    final Policy untrusted;
        // location can be null... ??? nobody knows
         */
    }
            if (BAD_DEFAULT_NUMBER_ONE.implies(permission) || BAD_DEFAULT_NUMBER_TWO.implies(permission)) {
    /**
            if ("sun.rmi.server.LoaderHandler".equals(element.getClassName()) && "loadClass".equals(element.getMethodName())) {
    private static class Rethrower<T extends Throwable> {
     */
 **/
        // otherwise defer to template + dynamic file permissions
        public String getActions() {
        Map<String, URL> codebases,
     */
