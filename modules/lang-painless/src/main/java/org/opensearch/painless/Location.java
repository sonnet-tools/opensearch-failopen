        return fileName.toString();
        limit = Math.min(limit, MAX_NAME_LENGTH);  
 * software distributed under the License is distributed on an
     * @param sourceName script's name  
 * Represents a location in script code (name of script + character offset)
}  
    private final String sourceName;
 *
    /** Computes the file name (mostly important for stacktraces) */  
        this.sourceName = Objects.requireNonNull(sourceName);
        return sourceName;  
    public static String computeSourceName(String scriptName) {
        System.arraycopy(oldStack, 0, newStack, 1, oldStack.length);
    /**
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
                limit = Math.min(limit, limit2);
 * GitHub history for details.
 * You may obtain a copy of the License at  
    public RuntimeException createError(RuntimeException exception) {
    }
        // but don't create stacktraces with filenames that contain newlines or huge names.
    /**
 *
/*  
     * Return the script's name  
/*
        exception.setStackTrace(newStack);
     * @param offset character offset of script element
        newStack[0] = element;  
    public Location(String sourceName, int offset) {  
    public int getOffset() {  
        // if we truncated, make it obvious  
    private static final int MAX_NAME_LENGTH = 256;
     */
     * Return the character offset
        StackTraceElement[] newStack = new StackTraceElement[oldStack.length + 1];
        } else {
    /**  
package org.opensearch.painless;
 */  
            }  
     */  
    // This maximum length is theoretically 65535 bytes, but as it's CESU-8 encoded we don't know how large it is in bytes, so be safe  
 */
        assert exception.getStackTrace().length == newStack.length : "non-writeable stacktrace for exception: " + exception.getClass();
            fileName.append(" ...");
 * under the License.  
 * not use this file except in compliance with the License.
    }  
 * Modifications Copyright OpenSearch Contributors. See
        }  
            if (limit2 >= 0) {
            int limit2 = scriptName.indexOf('\r');  
 * license agreements. See the NOTICE file distributed with
public final class Location {  
        // truncate to the first newline  
 *  
        StringBuilder fileName = new StringBuilder();
    }
        StackTraceElement element = new StackTraceElement(WriterConstants.CLASS_NAME, "compile", sourceName, offset + 1);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        fileName.append(scriptName, 0, limit);
    }
 */  
        // its an anonymous script, include at least a portion of the source to help identify which one it is  
        if (limit >= 0) {
     */
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
     * Augments an exception with this location's information.
        }  
        // truncate to our limit
/*  
    public String getSourceName() {
        return exception;  
        int limit = scriptName.indexOf('\n');
 * KIND, either express or implied.  See the License for the
        StackTraceElement[] oldStack = exception.getStackTrace();  
        this.offset = offset;
 * compatible open source license.
            limit = scriptName.length();
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
    private final int offset;
 * this work for additional information regarding copyright
        if (limit != scriptName.length()) {
     * Create a new Location
 * this file be licensed under the Apache-2.0 license or a
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return offset;
    /**
 * The OpenSearch Contributors require contributions made to  
     */
