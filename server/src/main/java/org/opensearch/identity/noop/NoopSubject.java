import org.opensearch.identity.Subject;
    public void authenticate(AuthToken AuthToken) {  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 *
 * Implementation of subject that is always authenticated
        Subject that = (Subject) obj;  
    }
    }
    @Override
    public Principal getPrincipal() {
package org.opensearch.identity.noop;
public class NoopSubject implements UserSubject {
        return "NoopSubject(principal=" + getPrincipal() + ")";
        if (this == obj) return true;
 */  
 * This class and related classes in this package will not return nulls or fail permissions checks  
    /**
    @Override
}  
 * <p>
    public String toString() {
/**  
     * Logs the user in  
    @Override  
/*  
    }  
 * @opensearch.internal
        if (obj == null || getClass() != obj.getClass()) return false;
        // Do nothing as noop subject is always logged in
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }  
    @Override  
    public int hashCode() {
 *
        return Objects.hash(getPrincipal());  
import org.opensearch.identity.tokens.AuthToken;
import org.opensearch.identity.NamedPrincipal;
        return Objects.equals(getPrincipal(), that.getPrincipal());
import org.opensearch.identity.UserSubject;  
import java.util.Objects;
     */
import java.security.Principal;  
    @Override
    }
    public boolean equals(Object obj) {  
 */  
        return NamedPrincipal.UNAUTHENTICATED;
