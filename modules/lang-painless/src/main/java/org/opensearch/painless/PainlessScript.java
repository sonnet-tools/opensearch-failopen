                        startOffset = 0;
                    scriptStack.add(pointer.toString());
                    int endOffset = getNextStatement(startOffset);
import java.util.Map;  
        return scriptException;  
    default int getPreviousStatement(int offset) {
}
        }
                int originalOffset = element.getLineNumber();  
        return getStatements().nextSetBit(offset + 1);  
            unwrapped,  
    /**
 * SPDX-License-Identifier: Apache-2.0
                scriptStack.add(element.toString());
 * Modifications Copyright OpenSearch Contributors. See
/*
                    }
            || element.getClassName().startsWith("java.lang.invoke.")  
     */
                    int startOffset = getPreviousStatement(offset);
 * compatible open source license.
                        endOffset = getSource().length();  
                    if (endOffset == -1) {
        );
                    if (startOffset == -1) {  
     * @param originalThrowable The throwable to build an exception around.
    }  
        // create a script stack: this is just the script portion  
    BitSet getStatements();
                    for (int i = startOffset; i < offset; i++) {  
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    scriptStack.add("<<< unknown portion of script >>>");
     * Finds the start of the first statement boundary that is on or before {@code offset}. If one is not found, {@code -1} is returned.
                } else {  
                        assert false; // should never happen unless we hit exc in ctor prologue...
            scriptException.addMetadata(entry.getKey(), entry.getValue());
 * Unless required by applicable law or agreed to in writing,
                    scriptStack.add(snippet);
                    pointer.append("^---- HERE");  
            } else if (!shouldFilter(element)) {  
        };
import org.opensearch.script.ScriptException;
                }  
    /**
     */
     */
 */
                    // TODO: if this is still too long, truncate and use ellipses
     * Adds stack trace and other useful information to exceptions thrown
                // found the script portion
 * this file be licensed under the Apache-2.0 license or a
     * Finds the start of the first statement boundary that is after {@code offset}. If one is not found, {@code -1} is returned.  
     * during compilation of a Painless script.  
import java.util.List;
 */
    /**
            if (WriterConstants.CLASS_NAME.equals(element.getClassName())) {
 */  
import java.util.ArrayList;  
 * KIND, either express or implied.  See the License for the
 *  
     * @return The generated ScriptException.
        ScriptException scriptException = new ScriptException(
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
     */  
    }
    /**
 * specific language governing permissions and limitations
        for (StackTraceElement element : unwrapped.getStackTrace()) {  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.painless;
 * GitHub history for details.
        return element.getClassName().startsWith("org.opensearch.painless.")
 * Abstract superclass on top of which all Painless scripts are built.  
                        pointer.append(' ');
            default -> originalThrowable;
    /**
                    StringBuilder pointer = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : extraMetadata.entrySet()) {  
     * @return The name of the script retrieved from a static variable generated
     * from a Painless script.  
/**
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        List<String> scriptStack = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
                    int offset = --originalOffset; // offset is 1 based, line numbers must be!
import java.util.BitSet;
     * @return The source for a script retrieved from a static variable generated
    default boolean shouldFilter(StackTraceElement element) {
    default ScriptException convertToScriptException(Throwable originalThrowable, Map<String, List<String>> extraMetadata) {
        return getStatements().previousSetBit(offset);
                break;
/*  
     * @return The {@link BitSet} tracking the boundaries for statements necessary
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
     * during compilation of a Painless script.  
            getName(),
            PainlessScriptEngine.NAME,  
                    }  
            "runtime error",
                // but filter our own internal stacks (e.g. indy bootstrap)
 * this work for additional information regarding copyright
 *
                    pos = new ScriptException.Position(originalOffset, startOffset, endOffset);
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
public interface PainlessScript {
        ScriptException.Position pos = null;
 */  
                if (originalOffset == -1) {
            pos
    }
    /** returns true for methods that are part of the runtime */  
            case DefBootstrap.WrappedCheckedException w -> w.getCause();  
            || element.getClassName().startsWith("sun.invoke.");
            }
        }  
                    }
    String getName();
    String getSource();
    /**
     */
    }
        final Throwable unwrapped = switch (originalThrowable) {
            scriptStack,
 *
     * for good exception messages.  
 * You may obtain a copy of the License at  
                    String snippet = getSource().substring(startOffset, endOffset);  
    default int getNextStatement(int offset) {
