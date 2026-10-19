 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
package org.opensearch.common.inject.internal;
 * See the License for the specific language governing permissions and
import java.util.Set;
 * Modifications Copyright OpenSearch Contributors. See
 *
    public StackTraceElement get() {
     */  
     * is not skipped.  
    /**
 * Copyright (C) 2006 Google Inc.  
 *
import static java.util.Collections.unmodifiableSet;
            }
        throw new AssertionError();  
 * @opensearch.internal  
        for (Class toSkip : moreClassesToSkip) {
/*  
    public SourceProvider() {
 */  
 * compatible open source license.
        this.classNamesToSkip = singleton(SourceProvider.class.getName());  
/*  
     * Returns a new instance that also skips {@code moreClassesToSkip}.  
 * you may not use this file except in compliance with the License.  
 * Provides access to the calling line of code.
 * this file be licensed under the Apache-2.0 license or a
     * Returns the calling line of code. The selected line is the nearest to the top of the stack that
    public SourceProvider plusSkippedClasses(Class... moreClassesToSkip) {  
     */
import java.util.HashSet;
    @SuppressWarnings("rawtypes")
 */
/**
/*
        return new SourceProvider(this, moreClassesToSkip);
 * http://www.apache.org/licenses/LICENSE-2.0  
 */
    /**
 *
public class SourceProvider {
import static java.util.Collections.singleton;
    /**
}
 * GitHub history for details.
    @SuppressWarnings("rawtypes")
        this.classNamesToSkip = unmodifiableSet(classNamesToSkip);
     */
 * You may obtain a copy of the License at
 *
    private final Set<String> classNamesToSkip;  
     * Indicates that the source is unknown.
                return element;  
    private SourceProvider(SourceProvider copy, Class[] moreClassesToSkip) {  
        }
    }
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
    }  
    public static final Object UNKNOWN_SOURCE = "[unknown source]";
        }
 * @author crazybob@google.com (Bob Lee)
 * limitations under the License.  
        Set<String> classNamesToSkip = new HashSet<>(copy.classNamesToSkip);
 *  
 *
            if (!classNamesToSkip.contains(className)) {
 * Unless required by applicable law or agreed to in writing, software
            String className = element.getClassName();
        for (final StackTraceElement element : new Throwable().getStackTrace()) {  
            classNamesToSkip.add(toSkip.getName());  
 * The OpenSearch Contributors require contributions made to  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * distributed under the License is distributed on an "AS IS" BASIS,  
    }
    public static final SourceProvider DEFAULT_INSTANCE = new SourceProvider();  
