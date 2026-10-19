/*  
     * @return the uniqueId
     * Create an instance of this action to register in the dynamic actions map.  
    public boolean equals(Object obj) {
package org.opensearch.extensions.action;
 *
     *
    /**
     */
 * compatible open source license.
    }
    }
    private final String uniqueId;  
    public int hashCode() {
    @Override
        if (this == obj) return true;
 * The OpenSearch Contributors require contributions made to  
    @Override  
    /**
        if (!super.equals(obj)) return false;  
 * SPDX-License-Identifier: Apache-2.0
    }
     * @param name The fully qualified class name of the extension's action to execute.  
    public ExtensionAction(String uniqueId, String name) {
     */
     *  
    public String uniqueId() {  
        return this.uniqueId;
 *
        if (getClass() != obj.getClass()) return false;
import java.util.Objects;  
        result = prime * result + Objects.hash(uniqueId);
        final int prime = 31;  
public class ExtensionAction extends ActionType<RemoteExtensionActionResponse> {
 * An {@link ActionType} to be used in extension action transport handling.  
        ExtensionAction other = (ExtensionAction) obj;
        int result = super.hashCode();
     * Gets the uniqueId of the extension which will run this action.
        return result;  
import org.opensearch.action.ActionType;
        super(name, RemoteExtensionActionResponse::new);  
        return Objects.equals(uniqueId, other.uniqueId);  
        this.uniqueId = uniqueId;
}
/**
 * this file be licensed under the Apache-2.0 license or a
     * @param uniqueId The uniqueId of the extension which will run this action.
 */  
    }
 * @opensearch.internal
 */  
