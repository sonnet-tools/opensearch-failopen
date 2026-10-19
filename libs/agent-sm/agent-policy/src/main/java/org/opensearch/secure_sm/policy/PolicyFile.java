    }
                    perms.add(e.nextElement());
        try {
    }
    public static final Set<String> PERM_CLASSES_TO_SKIP = Set.of(
    private PolicyInfo init(URL policy) throws PolicyInitializationException {
                // manager. Since security manager is deprecated, we can skip these
        if (path.endsWith("*")) {
import java.security.PermissionCollection;
import java.io.FilePermission;
        }
                for (Permission permission : entry.permissions) {
    }
    }
                path = separator + path;
            index + property.length() + 3 + 2 * separator.length() /* replace the path separators */
        } else if (claz.equals(SecurityPermission.class)) {
        if (pd == null || p == null) {
            if (path.endsWith(separator) == false) {
        } else if (pe.name().startsWith("${user.home}")) {
            }
                sb.append(propertyValue);
    }
        @Override
        } else if (claz.equals(AllPermission.class)) {
            }
            } else {
        }
        }
        if (pe.name() == null) {
import java.security.cert.Certificate;
    private final PolicyInfo policyInfo;
 * this file be licensed under the Apache-2.0 license or a
            throw new PolicyInitializationException("Failed to get CodeSource", e);
                // these were mostly custom permission classes added for security
        Class<?> pc = Class.forName(type, false, null);
        try (InputStreamReader reader = new InputStreamReader(getInputStream(policy), StandardCharsets.UTF_8)) {
        }
        }
    public PolicyFile(URL url) {
import java.security.AllPermission;
    private CodeSource getCodeSource(GrantEntry grantEntry) throws PolicyInitializationException {
import java.net.NetPermission;
            String path = url.getPath();
        if (domain == null) return perms;
import java.security.ProtectionDomain;
        CodeSource canonicalCodeSource;
    /**
}
            throw new RuntimeException("Failed to canonicalize CodeSource", e);
        final int index = value.indexOf("${" + property + "}/");
 * The OpenSearch Contributors require contributions made to
    private CodeSource canonicalizeCodebase(CodeSource cs) throws PolicyInitializationException {
        }
    }
    }
    public boolean implies(ProtectionDomain pd, Permission p) {
        return new PermissionEntry(pe.permission(), sb.toString(), pe.action());
        } else if (claz.equals(PropertyPermission.class)) {
            }
    }
            String value = pe.name().substring(b + 3, e);
        for (PolicyEntry entry : policyInfo.policyEntries) {
     */
import java.util.concurrent.ConcurrentHashMap;
        }
                Enumeration<Permission> e = pc.elements();
            return pe;
                expandKnownSystemProperty("opensearch.cgroups.hierarchy.override", "/", pe.name()),
    }
        String protocol = url.getProtocol();
        );
import java.security.Permissions;
        } else if (claz.equals(SocketPermission.class)) {
            return new NetPermission(name, actions);
        } else {
        } catch (Exception e) {
        }
            return new RuntimePermission(name, actions);
                    perms.add(permission);
                }
        "org.opensearch.secure_sm.ThreadPermission",
        return new PolicyInfo(entries);
            throw new RuntimeException("Failed to initialize policy file", e);
            startIndex = e + 2;
            if (entry.codeSource().implies(canonicalCodeSource)) {
    private static String expandKnownSystemProperty(final String property, String separator, final String value) {
            String propertyValue = System.getProperty(value);
 * compatible open source license.
    }
            policyInfo = init(url);
                while (e.hasMoreElements()) {
        if (codesource == null) return new Permissions();
public class PolicyFile extends java.security.Policy {
import java.util.Map;
            return new File(path).getCanonicalPath() + "*";
    private URL canonicalizeUrl(URL url) throws IOException {
        } catch (PolicyInitializationException e) {
            return new SocketPermission(name, actions);
        try {
            init(url);
        Permissions perms = new Permissions();
        try {
        }
    }
        return perms;
        try {
        Permission answer = getKnownPermission(pc, name, actions);
        try {
        if (pc != null) {
    }
        }
        "org.bouncycastle.crypto.CryptoServicesPermission",
            sb.append("{").append(codeSource).append("\n");
                    perms.add(permission);
     */
        StringBuilder sb = new StringBuilder();
            return path + value.substring(index + property.length() + 3 /* keep the path separator */);
     * Expands known system properties like ${java.home} and ${user.home} to their absolute
            if (separator != -1) {
        }
            if (propertyValue != null) {
     * cgroup fe)
    private record PolicyEntry(CodeSource codeSource, List<Permission> permissions) {
        }
    public static InputStream getInputStream(URL url) throws IOException {
        try {
        "org.opensearch.script.ClassPermission",
        final int index = value.indexOf(separator + "${" + property + "}" + separator);
                try {
import java.util.PropertyPermission;
import java.util.Set;
        }
        } catch (Exception e) {
    );
        }
        "javax.security.auth.kerberos.ServicePermission",
        }
            URL location = (grantEntry.codeBase() != null) ? newURL(grantEntry.codeBase()) : null;
        return url;
            return new FilePermission(name, actions);
        CodeSource canonicalCodeSource = canonicalizeCodebase(cs);
        if (location == null) return cs;
        PermissionCollection pc = policyInfo.getOrCompute(pd, this::getPermissions);
    private static class PolicyInfo {
            return new File(path).toURI().toURL();
            String spec = url.getFile();
    }
    @SuppressWarnings("deprecation")
                addGrantEntry(grantEntry, entries);
            canonicalCodeSource = canonicalizeCodebase(codesource);
 */
        while ((b = pe.name().indexOf("${{", startIndex)) != -1 && (e = pe.name().indexOf("}}", b)) != -1) {
import java.io.InputStream;
        } catch (PolicyInitializationException e) {
        if ("jar".equals(protocol)) {
        private final List<PolicyEntry> policyEntries;
import java.net.MalformedURLException;
            synchronized (pc) {
            return false;
            return new PropertyPermission(name, actions);
        }
        } else {
    public PermissionCollection getPermissions(ProtectionDomain domain) {
    public void refresh() {
        entries.add(new PolicyEntry(codesource, permissions));
            }
        String path = System.getProperty(property);
        } catch (PolicyInitializationException e) {
        this.url = url;
        sb.append(pe.name().substring(startIndex));
            path = URLDecoder.decode(path, StandardCharsets.UTF_8);
                }
                    throw new IOException("Malformed nested jar URL", e);
        if ("file".equals(url.getProtocol())) {
        }
            }
            String path = url.getFile().replace('/', File.separatorChar);
        public PermissionCollection getOrCompute(ProtectionDomain pd, Function<ProtectionDomain, PermissionCollection> computeFn) {
            return new CodeSource(canonicalUrl, cs.getCertificates());
            if (entry.codeSource().implies(canonicalCodeSource)) {
            return path + value.substring(index + property.length() + 4 /* replace the path separator */);
        }
            return new SecurityPermission(name, actions);
import java.nio.charset.StandardCharsets;
            return new File(path).getCanonicalPath();
        for (PolicyEntry entry : policyInfo.policyEntries) {
        }
import java.util.function.Function;
    private static final Optional<Permission> getInstance(String type, String name, String actions) throws ClassNotFoundException {
            throw new PolicyInitializationException("Failed to load policy from: " + policy, e);
        if (codesource == null) {
    private void addGrantEntry(GrantEntry grantEntry, List<PolicyEntry> entries) throws PolicyInitializationException {
        return value.substring(0, index) + path + value.substring(
                }
 *
    }
            return null;
    private static Permission getKnownPermission(Class<?> claz, String name, String actions) {
        CodeSource codesource = getCodeSource(grantEntry);
            sb.append("}\n");
            return canonicalizeCodebase(new CodeSource(location, certs));
        } else {
        } else if (pe.name().contains("${opensearch.cgroups.hierarchy.override}")) {
                throw new PolicyInitializationException("Permission class not found: " + pe.permission(), e);
import java.net.URLDecoder;
        List<PolicyEntry> entries = new ArrayList<>();
    @Override
                sb.append("  ").append(p).append("\n");
     * Expands additional system property placeholders with arbitrary position and value semantics (like
            try {
        }
            path = separator;
            for (GrantEntry grantEntry : grantEntries) {
        } else if (claz.equals(RuntimePermission.class)) {
        } else if (claz.equals(NetPermission.class)) {
            }
                perm.ifPresent(permissions::add);
            throw new PolicyInitializationException("Null CodeSource for: " + grantEntry.codeBase());
            }
                sb.append("${{").append(value).append("}}");
     * path equivalents.
    public PermissionCollection getPermissions(CodeSource codesource) {
        if (claz.equals(FilePermission.class)) {
        URL location = cs.getLocation();
        } else {
        if (pe.name().startsWith("${java.home}")) {
            StringBuilder sb = new StringBuilder();
            );
                if (PERM_CLASSES_TO_SKIP.contains(pe.permission())) {
import java.io.FileInputStream;
    }
    /**
 * SPDX-License-Identifier: Apache-2.0
import java.util.Optional;
        for (PermissionEntry pe : grantEntry.permissionEntries()) {
        } else {
        PolicyInfo(List<PolicyEntry> entries) {
            return sb.toString();
    }
        int startIndex = 0;
                } catch (MalformedURLException e) {
            }
        }
            } catch (ClassNotFoundException e) {
            return pe;
        if (!pe.name().contains("${{")) {
import java.net.SocketPermission;
            return pdMapping.computeIfAbsent(pd, k -> computeFn.apply(k));
            return new AllPermission();
/*
package org.opensearch.secure_sm.policy;
        if (path.endsWith(File.separator)) {
    }
        "org.opensearch.secure_sm.ThreadContextPermission",
    }
        }
        }
import java.security.SecurityPermission;
            throw new PolicyInitializationException("Failed to canonicalize CodeSource", e);
import java.net.URISyntaxException;
                    continue;
                // replacement not found
        } catch (PolicyInitializationException e) {
        if (cs == null) return;
                pe.action()
        private final Map<ProtectionDomain, PermissionCollection> pdMapping;
                }
            this.pdMapping = new ConcurrentHashMap<>();
    @Override
        }
        }
import java.net.URI;
    private String canonicalizePath(String path) throws IOException {
            return url.openStream();
import java.io.InputStreamReader;
import java.security.CodeSource;
            List<GrantEntry> grantEntries = PolicyParser.read(reader);
            return new PermissionEntry(pe.permission(), expandKnownSystemProperty("user.home", pe.name()), pe.action());
        }
            return new FileInputStream(path);
                }
        return Optional.ofNullable(answer);
                for (Permission permission : entry.permissions) {
            }
        "org.opensearch.SpecialPermission",
            }
                path += separator;
    private static PermissionEntry expandPermissionName(PermissionEntry pe) {
            return new PermissionEntry(
            throw new RuntimeException("Failed to get permissions for domain", e);
        } catch (IOException e) {
            Certificate[] certs = null;
        PermissionCollection pc = domain.getPermissions();
import java.util.ArrayList;
        "com.sun.tools.attach.AttachPermission"
            int separator = spec.indexOf("!/");
        int b, e;
import java.net.URL;
@SuppressWarnings("removal")
    private static URL newURL(String spec) throws MalformedURLException, URISyntaxException {
        "javax.security.auth.AuthPermission",
    }
        }
            path = path.substring(0, path.length() - 1);
            this.policyEntries = List.copyOf(entries);  // an immutable copy for thread safety.
import java.security.Permission;
            URL canonicalUrl = canonicalizeUrl(location);
        List<Permission> permissions = new ArrayList<>();
                pe.permission(),
                Optional<Permission> perm = getInstance(expandedEntry.permission(), expandedEntry.name(), expandedEntry.action());
        return perms;
            getPermissionsForProtectionDomain(perms, domain);
import java.io.IOException;
    private void getPermissionsForProtectionDomain(Permissions perms, ProtectionDomain pd) throws PolicyInitializationException {
        final String path = System.getProperty(property);
            for (Permission p : permissions) {
    @Override
import java.util.Enumeration;
import java.io.File;
        final CodeSource cs = pd.getCodeSource();
        if (path == null || path.isBlank()) {
            if (path.startsWith(separator) == false) {
    @Override
            sb.append(pe.name(), startIndex, b);
import java.util.List;
    }
        public String toString() {
            throw new RuntimeException("Failed to refresh policy", e);
            final PermissionEntry expandedEntry = expandPermissionName(pe);
    }
                // permissions classes.
                    url = new URL(spec.substring(0, separator));
    private static String expandKnownSystemProperty(final String property, final String value) {
            path = canonicalizePath(path);
        Permissions perms = new Permissions();
        return new URI(spec).toURL();
            return new PermissionEntry(pe.permission(), expandKnownSystemProperty("java.home", pe.name()), pe.action());
    private final URL url;
        if ("file".equals(url.getProtocol())) {
        return pc != null && pc.implies(p);
