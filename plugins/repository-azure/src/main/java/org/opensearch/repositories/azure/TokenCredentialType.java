    TokenCredentialType(String type) {  
        }
public enum TokenCredentialType {
/*  
    public static String[] getTokenCredentialTypes() {
    }  
        );
        throw new IllegalArgumentException(
                return value;
                + String.join(", ", getTokenCredentialTypes())  
    static TokenCredentialType valueOfType(String type) {
// Type of token credentials that the plugin supports  
 * SPDX-License-Identifier: Apache-2.0
                + "' is unsupported, please use one of the following values: "
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
    MANAGED_IDENTITY("managed");
import java.util.Arrays;
            if (value.type.equalsIgnoreCase(type) || value.name().equalsIgnoreCase(type)) {
        for (TokenCredentialType value : values()) {  
}  
package org.opensearch.repositories.azure;
            "The token credential type '"  
    }
    private final String type;
        this.type = type;
            }  
 * The OpenSearch Contributors require contributions made to  
        return Arrays.stream(TokenCredentialType.values()).map(tokenCredentialType -> tokenCredentialType.type).toArray(String[]::new);
                + type
 *
