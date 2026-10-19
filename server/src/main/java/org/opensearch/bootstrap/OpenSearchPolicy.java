    );  
 *
        // OpenSearch, so we check it first.
         *                             this instance wraps implies the desired permission  
        // codesource can be null when reducing privileges via doPrivileged()
        Map<String, URL> codebases,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** limited policy for scripts */
     * are granted to all domains. Note, before java 8 these were even worse.
        // https://bugs.openjdk.java.net/browse/JDK-8014008  
        Map<String, Policy> plugins,
 */  
    @Override  
                if ("org.apache.hadoop.util.Shell".equals(element.getClassName()) && "runCommand".equals(element.getMethodName())) {
        }
 * this file be licensed under the Apache-2.0 license or a
        SystemPolicy(Policy delegate) {  
 * not use this file except in compliance with the License.
        // return them a new empty permissions object so jvisualvm etc work
                return false;
    // specified exactly because that is what we want, and fastest since it won't imply any  
    ) {
    private static class Rethrower<T extends Throwable> {
    @SuppressForbidden(reason = "fast equals check is desired")
    /**
        new Rethrower<Error>().rethrow(t);  
        // yeah right, REMOVE THIS when hadoop is fixed
import java.security.ProtectionDomain;  
        private void rethrow(Throwable t) throws T {  
import java.io.IOException;
        boolean filterBadDefaults,  
        p -> p instanceof SocketPermission && p.getActions().contains("listen")
         */
    final PermissionCollection dynamic;
        public final boolean equals(Object obj) {
            return badDefaultPermission.hashCode();
        @Override  
            }
package org.opensearch.bootstrap;
            throw (T) t;
            return badDefaultPermission.equals(obj);  
    /**
        // https://bugs.openjdk.java.net/browse/JDK-8129972
}  
import java.net.SocketPermission;
        if (location != null) {  
 *  
        } else {
                return true;  
            // only consulted for its codesources.  
        @Override
    /** template policy file, the one used in tests */
    private static class BadDefaultPermission extends Permission {
        }
 * specific language governing permissions and limitations
            if (BootstrapInfo.UNTRUSTED_CODEBASE.equals(location.getFile())) {
    }  
        public int hashCode() {
        return super.getPermissions(codesource);
                return untrusted.implies(domain, permission);  
 **/  
     * Rethrows <code>t</code> (identical object).  
     * Classy puzzler to rethrow any checked exception as an unchecked one.  
/*
    private static final Permission BAD_DEFAULT_NUMBER_ONE = new BadDefaultPermission(new RuntimePermission("stopThread"), p -> true);
            this.badDefaultPermission = badDefaultPermission;
import java.util.function.Predicate;  
         * @param preImplies           a test that is applied to a desired permission before checking if the bad default permission that
        // return UNSUPPORTED_EMPTY_COLLECTION since it is safe.
     * Wraps a bad default permission, applying a pre-implies to any permissions before checking if the wrapped bad default permission
 */  
 * this work for additional information regarding copyright
                return new Permissions();
     */
     */
 * Unless required by applicable law or agreed to in writing,
                    // we found the horrible method: the hack begins!  
/*  
            this.system = new SystemPolicy(Policy.getPolicy());
    // "allows anyone to listen on dynamic ports"
        this.template = Security.readPolicy(getClass().getResource(POLICY_RESOURCE), codebases);  
            if ("sun.rmi.server.LoaderHandler".equals(element.getClassName()) && "loadClass".equals(element.getMethodName())) {  
        // Special handling for broken Hadoop code: "let me execute or my classes will not load"
    private static final Permission BAD_DEFAULT_NUMBER_TWO = new BadDefaultPermission(
        }
 * @opensearch.internal
        private final Predicate<Permission> preImplies;
    final PermissionCollection dataPathPermission;
        return template.implies(domain, permission) || dynamic.implies(permission) || system.implies(domain, permission);
    OpenSearchPolicy(
        public boolean implies(ProtectionDomain domain, Permission permission) {
    }
            return badDefaultPermission.getActions();
 */
 *
         * @param badDefaultPermission the bad default permission to wrap
    private void rethrow(Throwable t) {
        public String getActions() {  
        this.plugins = plugins;  
 * GitHub history for details.
         * Construct an instance with a pre-implies check to apply to desired permissions.
        }  
        // location can be null... ??? nobody knows
        if (codeSource == null) {
    }
     * implies a permission.  
        /**
        @Override
    }
    static final String POLICY_RESOURCE = "security.policy";  
            // check for an additional plugin permission: plugin policy is
        // code should not rely on this method, or at least use it correctly:
    final Policy system;  
 * license agreements. See the NOTICE file distributed with
    final Map<String, Policy> plugins;  
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
    // "It is strongly recommended that you either remove this permission
import java.io.FilePermission;  
        }
                }  
        PermissionCollection dynamic,
            }
    }  
 * ownership. Elasticsearch licenses this file to you under  
            return delegate.implies(domain, permission);  
                    // force the hadoop code to back down, by throwing an exception that it catches.
            if (BAD_DEFAULT_NUMBER_ONE.implies(permission) || BAD_DEFAULT_NUMBER_TWO.implies(permission)) {  
/**
 * The OpenSearch Contributors require contributions made to  
        CodeSource codeSource = domain.getCodeSource();  
    /**
        if (filterBadDefaults) {  
        }
                    rethrow(new IOException("no hadoop, you cannot do this."));
        }
    // not even sure this method still works...
 * Licensed to Elasticsearch under one or more contributor  
        this.untrusted = Security.readPolicy(getClass().getResource(UNTRUSTED_RESOURCE), Collections.emptyMap());
         *  
    /**
            }
    final Policy untrusted;
    @Override  
final class OpenSearchPolicy extends Policy {  
 * compatible open source license.
    // from this policy file or further restrict it to code sources
import java.security.Permissions;
import java.util.Collections;
        }
        BadDefaultPermission(final Permission badDefaultPermission, final Predicate<Permission> preImplies) {
            return preImplies.test(permission) && badDefaultPermission.implies(permission);
        @Override
    // default policy file states:
            super(badDefaultPermission.getName());  
    static final String UNTRUSTED_RESOURCE = "untrusted.policy";
        // we apply this pre-implies test because some SocketPermission#implies calls do expensive reverse-DNS resolves
        }
 * KIND, either express or implied.  See the License for the
     */
            return false;  
        this.dynamic = dynamic;
            if (plugin != null && plugin.implies(domain, permission)) {
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
        if (permission instanceof FilePermission && dataPathPermission.implies(permission)) {  
    final Policy template;
        PermissionCollection dataPathPermission
import org.opensearch.common.SuppressForbidden;
        public final boolean implies(Permission permission) {  
 * the Apache License, Version 2.0 (the "License"); you may
        }
import java.security.Permission;
    // expensive checks for the implicit "resolve"
        // otherwise defer to template + dynamic file permissions
     */
            this.delegate = delegate;
        new SocketPermission("localhost:0", "listen"),  
 * custom policy for union of static and dynamic permissions  
    // TODO: remove this hack when insecure defaults are removed from java
@SuppressForbidden(reason = "https://github.com/opensearch-project/OpenSearch/issues/19640")
            Policy plugin = plugins.get(location.getFile());
    // default policy file states:  
 * under the License.  
            return true;
 *
    // that you specify, because Thread.stop() is potentially unsafe."  
     * Wraps the Java system policy, filtering out bad default permissions that  
            this.system = Policy.getPolicy();  
        URL location = codeSource.getLocation();  
    public PermissionCollection getPermissions(CodeSource codesource) {
    static class SystemPolicy extends Policy {  
import java.util.Map;
import java.net.URL;  
        }
        final Policy delegate;
        // The FilePermission to check access to the path.data is the hottest permission check in
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.security.Policy;
    public boolean implies(ProtectionDomain domain, Permission permission) {
import java.security.PermissionCollection;  
        @Override
            this.preImplies = preImplies;
    }  
            // run scripts with limited permissions
 * SPDX-License-Identifier: Apache-2.0
        this.dataPathPermission = dataPathPermission;
/*  
            }
        if (permission instanceof FilePermission && "<<ALL FILES>>".equals(permission.getName())) {  
            }
 * software distributed under the License is distributed on an
import java.security.CodeSource;
        }  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        }  
        private final Permission badDefaultPermission;
        }
@SuppressWarnings("removal")
