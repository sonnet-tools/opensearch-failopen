/*  
 * compatible open source license.
import software.amazon.awssdk.crt.CRT.UnknownPlatformException;
 * The OpenSearch Contributors require contributions made to  
     * Check if AWS CRT client is available on the current platform and architecture.  
 * SPDX-License-Identifier: Apache-2.0
 * An utility class to check if AWS CRT client is available on the current platform and architecture.
     */  
        }
        isAwsCrtAvailable = crtAvailable;
        boolean crtAvailable;
    private AwsCrtUtils() {
    static final boolean isAwsCrtAvailable;
            final String archIdentifier = CRT.getArchIdentifier();
            crtAvailable = false;
import software.amazon.awssdk.crt.CRT;
            crtAvailable = (archIdentifier != null && archIdentifier.isBlank() == false);
    }  
 */  
    }  
     * @return true if AWS CRT client is available
    public static boolean isAwsCrtAvailable() {
     *
    static {
 */  
/**
 *
public final class AwsCrtUtils {
package org.opensearch.repositories.s3.utils;
        try {  
        return isAwsCrtAvailable;
        // CRT native libraries are not available on some platforms  
    }
    /**
}
        } catch (ExceptionInInitializerError | UnknownPlatformException ex) {  
 * this file be licensed under the Apache-2.0 license or a
