    }
    @Override
     * Represents a principal which has not been authenticated  
    public String toString() {  
 *  
        return name;
        this.name = name;
    public int hashCode() {
        return Objects.hash(name);
    public NamedPrincipal(final String name) {
    }  
     */
    }  
     */  
    private final String name;
    @Override  
    public boolean equals(final Object obj) {
 */
import java.security.Principal;
        final Principal that = (Principal) obj;
    @Override
 * SPDX-License-Identifier: Apache-2.0
     * Creates a principal for an identity specified as a string
    public static final NamedPrincipal UNAUTHENTICATED = new NamedPrincipal("Unauthenticated");
    /**
public class NamedPrincipal implements Principal {  
}  
package org.opensearch.identity;
    /**  
 * Create a principal from a string
        return "NamedPrincipal(" + "name=" + name + ")";
 * @opensearch.experimental
    }
import java.util.Objects;
        if (this == obj) return true;  
    @Override
    public String getName() {  
        return Objects.equals(name, that.getName());  
        if (obj == null || getClass() != obj.getClass()) return false;
    }
/*  
 * Copyright OpenSearch Contributors
     * @param name A persistent string that represent an identity
 */  
/**
