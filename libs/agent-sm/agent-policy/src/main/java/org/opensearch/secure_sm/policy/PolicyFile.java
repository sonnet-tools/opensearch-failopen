        } catch (Exception e) {
            startIndex = e + 2;
import java.util.Optional;  
        } catch (PolicyInitializationException e) {
    }
            policyInfo = init(url);
            sb.append("}\n");
            throw new PolicyInitializationException("Failed to canonicalize CodeSource", e);  
        try {
    }
        String path = System.getProperty(property);  
        } else if (claz.equals(NetPermission.class)) {
        Permission answer = getKnownPermission(pc, name, actions);
            return sb.toString();
            return path + value.substring(index + property.length() + 4 /* replace the path separator */);  
import java.security.AllPermission;  
        }
     */  
        "javax.security.auth.kerberos.ServicePermission",  
            return new SecurityPermission(name, actions);  
        }  
            sb.append("{").append(codeSource).append("\n");  
            return pdMapping.computeIfAbsent(pd, k -> computeFn.apply(k));
                // replacement not found
    }
        } catch (PolicyInitializationException e) {
        } else {
    private static URL newURL(String spec) throws MalformedURLException, URISyntaxException {
        "org.opensearch.secure_sm.ThreadContextPermission",  
        } catch (IOException e) {
        if (pe.name().startsWith("${java.home}")) {
import java.net.NetPermission;
        PermissionCollection pc = policyInfo.getOrCompute(pd, this::getPermissions);  
                sb.append("${{").append(value).append("}}");  
    private CodeSource getCodeSource(GrantEntry grantEntry) throws PolicyInitializationException {
}
        int b, e;
     * Expands known system properties like ${java.home} and ${user.home} to their absolute
    private PolicyInfo init(URL policy) throws PolicyInitializationException {
            for (GrantEntry grantEntry : grantEntries) {
        if ("file".equals(url.getProtocol())) {
        }
            for (Permission p : permissions) {
        if (path.endsWith("*")) {  
            }  
import java.util.concurrent.ConcurrentHashMap;  
    private static class PolicyInfo {  
        }  
 * The OpenSearch Contributors require contributions made to  
        CodeSource codesource = getCodeSource(grantEntry);  
        }
        "org.opensearch.script.ClassPermission",
            return pe;
        entries.add(new PolicyEntry(codesource, permissions));
import java.io.File;
            return new FileInputStream(path);
import java.io.IOException;
    }
        try {  
import java.security.Permission;
            return new RuntimePermission(name, actions);
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
                throw new PolicyInitializationException("Permission class not found: " + pe.permission(), e);  
        if ("jar".equals(protocol)) {
                sb.append("  ").append(p).append("\n");
        final int index = value.indexOf("${" + property + "}/");  
        }
            return new NetPermission(name, actions);
        }
        }
            throw new RuntimeException("Failed to get permissions for domain", e);  
        try {
import java.security.Permissions;
            }
                    throw new IOException("Malformed nested jar URL", e);  
            init(url);  
        "org.bouncycastle.crypto.CryptoServicesPermission",  
            this.policyEntries = List.copyOf(entries);  // an immutable copy for thread safety.
                path = separator + path;  
            return new FilePermission(name, actions);  
        private final List<PolicyEntry> policyEntries;
public class PolicyFile extends java.security.Policy {
        }  
            throw new RuntimeException("Failed to refresh policy", e);
            String path = url.getFile().replace('/', File.separatorChar);
                Enumeration<Permission> e = pc.elements();  
            throw new PolicyInitializationException("Failed to load policy from: " + policy, e);  
import java.net.URISyntaxException;
    private final PolicyInfo policyInfo;
        final CodeSource cs = pd.getCodeSource();
        } else {
    }  
import java.util.List;
            String path = url.getPath();  
import java.io.InputStream;
                for (Permission permission : entry.permissions) {  
        } catch (Exception e) {  
        if ("file".equals(url.getProtocol())) {
        private final Map<ProtectionDomain, PermissionCollection> pdMapping;
import java.security.CodeSource;
            return new PermissionEntry(pe.permission(), expandKnownSystemProperty("user.home", pe.name()), pe.action());
            return false;  
    }
import java.net.MalformedURLException;
        public String toString() {
        return new PermissionEntry(pe.permission(), sb.toString(), pe.action());  
            if (path.startsWith(separator) == false) {
    private static Permission getKnownPermission(Class<?> claz, String name, String actions) {
            if (path.endsWith(separator) == false) {
                while (e.hasMoreElements()) {
    }
        }  
                for (Permission permission : entry.permissions) {
            return null;
            this.pdMapping = new ConcurrentHashMap<>();  
        } else {  
            path = canonicalizePath(path);
    public boolean implies(ProtectionDomain pd, Permission p) {
        if (codesource == null) return new Permissions();  
        }  
                perm.ifPresent(permissions::add);
                addGrantEntry(grantEntry, entries);  
            canonicalCodeSource = canonicalizeCodebase(codesource);  
        while ((b = pe.name().indexOf("${{", startIndex)) != -1 && (e = pe.name().indexOf("}}", b)) != -1) {
            String propertyValue = System.getProperty(value);
    private CodeSource canonicalizeCodebase(CodeSource cs) throws PolicyInitializationException {
    }
import java.util.ArrayList;
            }  
        return pc != null && pc.implies(p);
        try {
                    continue;
        }
        if (!pe.name().contains("${{")) {
            return path + value.substring(index + property.length() + 3 /* keep the path separator */);
    public static InputStream getInputStream(URL url) throws IOException {  
        try {
        } else {
        List<PolicyEntry> entries = new ArrayList<>();
    private static String expandKnownSystemProperty(final String property, final String value) {
            String value = pe.name().substring(b + 3, e);  
        PolicyInfo(List<PolicyEntry> entries) {
            }
        return Optional.ofNullable(answer);
        return perms;
import java.io.InputStreamReader;  
 * compatible open source license.
        } catch (PolicyInitializationException e) {
        Permissions perms = new Permissions();  
        int startIndex = 0;  
    private URL canonicalizeUrl(URL url) throws IOException {
        }  
            sb.append(pe.name(), startIndex, b);
        if (path.endsWith(File.separator)) {
/*  
        Permissions perms = new Permissions();
        this.url = url;
import java.io.FileInputStream;
        }  
            Certificate[] certs = null;  
                }  
import java.net.SocketPermission;  
import java.net.URLDecoder;
        final String path = System.getProperty(property);
    private void getPermissionsForProtectionDomain(Permissions perms, ProtectionDomain pd) throws PolicyInitializationException {
            }
    private String canonicalizePath(String path) throws IOException {
 */  
        }  
     * Expands additional system property placeholders with arbitrary position and value semantics (like
        if (location == null) return cs;  
            String spec = url.getFile();  
            if (separator != -1) {
            List<GrantEntry> grantEntries = PolicyParser.read(reader);
            return new CodeSource(canonicalUrl, cs.getCertificates());
     * cgroup fe)
        }
        try (InputStreamReader reader = new InputStreamReader(getInputStream(policy), StandardCharsets.UTF_8)) {  
                    perms.add(e.nextElement());
    @Override
    public void refresh() {
    }  
    private static final Optional<Permission> getInstance(String type, String name, String actions) throws ClassNotFoundException {  
    @SuppressWarnings("deprecation")
    }
                path += separator;  
        if (pd == null || p == null) {
        } else if (claz.equals(PropertyPermission.class)) {
        }
            return new PermissionEntry(pe.permission(), expandKnownSystemProperty("java.home", pe.name()), pe.action());  
            return new AllPermission();
    private final URL url;
        return perms;
     * path equivalents.  
import java.util.PropertyPermission;
                }
    private record PolicyEntry(CodeSource codeSource, List<Permission> permissions) {
            path = URLDecoder.decode(path, StandardCharsets.UTF_8);  
        }
    }  
import java.security.PermissionCollection;  
                try {  
        sb.append(pe.name().substring(startIndex));
        return new PolicyInfo(entries);  
            try {
        } else {
            path = path.substring(0, path.length() - 1);
    @Override
        } else if (claz.equals(AllPermission.class)) {  
    }
    private static String expandKnownSystemProperty(final String property, String separator, final String value) {
    public PermissionCollection getPermissions(ProtectionDomain domain) {
            URL location = (grantEntry.codeBase() != null) ? newURL(grantEntry.codeBase()) : null;
    public static final Set<String> PERM_CLASSES_TO_SKIP = Set.of(
            return new SocketPermission(name, actions);
        CodeSource canonicalCodeSource;  
        Class<?> pc = Class.forName(type, false, null);
                    perms.add(permission);
                sb.append(propertyValue);  
            getPermissionsForProtectionDomain(perms, domain);
    @Override  
            return new File(path).toURI().toURL();
            }
                pe.permission(),
    }
                    url = new URL(spec.substring(0, separator));
            return pe;  
        return url;
        }
            synchronized (pc) {
            URL canonicalUrl = canonicalizeUrl(location);  
        }
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
        "org.opensearch.SpecialPermission",
import java.util.Enumeration;  
        }  
     */
            }
            return canonicalizeCodebase(new CodeSource(location, certs));
    }
        }
    );
        if (domain == null) return perms;
            throw new RuntimeException("Failed to initialize policy file", e);  
        } else if (claz.equals(RuntimePermission.class)) {  
        for (PermissionEntry pe : grantEntry.permissionEntries()) {  
        URL location = cs.getLocation();
        } else if (pe.name().startsWith("${user.home}")) {
        if (cs == null) return;  
            index + property.length() + 3 + 2 * separator.length() /* replace the path separators */
            StringBuilder sb = new StringBuilder();
        if (pe.name() == null) {
                }  
            throw new RuntimeException("Failed to canonicalize CodeSource", e);
            }
import java.security.cert.Certificate;
        } catch (PolicyInitializationException e) {
        final int index = value.indexOf(separator + "${" + property + "}" + separator);
        "javax.security.auth.AuthPermission",
            throw new PolicyInitializationException("Failed to get CodeSource", e);
        return new URI(spec).toURL();  
        "org.opensearch.secure_sm.ThreadPermission",
    public PermissionCollection getPermissions(CodeSource codesource) {
        if (pc != null) {
        return value.substring(0, index) + path + value.substring(
        String protocol = url.getProtocol();  
    private void addGrantEntry(GrantEntry grantEntry, List<PolicyEntry> entries) throws PolicyInitializationException {
        CodeSource canonicalCodeSource = canonicalizeCodebase(cs);
            } catch (ClassNotFoundException e) {
        "com.sun.tools.attach.AttachPermission"
        } else if (pe.name().contains("${opensearch.cgroups.hierarchy.override}")) {  
            return new File(path).getCanonicalPath();
            if (entry.codeSource().implies(canonicalCodeSource)) {
            return new PermissionEntry(
    /**  
 *
        }
                Optional<Permission> perm = getInstance(expandedEntry.permission(), expandedEntry.name(), expandedEntry.action());  
        for (PolicyEntry entry : policyInfo.policyEntries) {
                // manager. Since security manager is deprecated, we can skip these
import java.nio.charset.StandardCharsets;
    }
        if (path == null || path.isBlank()) {
        } else if (claz.equals(SocketPermission.class)) {
                } catch (MalformedURLException e) {
        }
            if (entry.codeSource().implies(canonicalCodeSource)) {  
@SuppressWarnings("removal")  
            throw new PolicyInitializationException("Null CodeSource for: " + grantEntry.codeBase());
        public PermissionCollection getOrCompute(ProtectionDomain pd, Function<ProtectionDomain, PermissionCollection> computeFn) {  
                // permissions classes.
        }
    /**
    private static PermissionEntry expandPermissionName(PermissionEntry pe) {  
    public PolicyFile(URL url) {
                }
    }
                }
        StringBuilder sb = new StringBuilder();
    }
import java.net.URI;
            path = separator;  
        );  
                pe.action()
    }
            final PermissionEntry expandedEntry = expandPermissionName(pe);
            return url.openStream();  
                // these were mostly custom permission classes added for security  
            return new File(path).getCanonicalPath() + "*";
            return new PropertyPermission(name, actions);  
        if (codesource == null) {
        }  
import java.security.ProtectionDomain;
            }
            int separator = spec.indexOf("!/");
                if (PERM_CLASSES_TO_SKIP.contains(pe.permission())) {  
        for (PolicyEntry entry : policyInfo.policyEntries) {
import java.net.URL;  
            }
import java.io.FilePermission;  
        if (claz.equals(FilePermission.class)) {
        PermissionCollection pc = domain.getPermissions();  
import java.security.SecurityPermission;  
        @Override  
    }  
        }  
        } else if (claz.equals(SecurityPermission.class)) {
                    perms.add(permission);
            if (propertyValue != null) {
package org.opensearch.secure_sm.policy;
        List<Permission> permissions = new ArrayList<>();
    }
                expandKnownSystemProperty("opensearch.cgroups.hierarchy.override", "/", pe.name()),  
        try {  
            } else {
import java.util.function.Function;
            );
    @Override  
