 * compatible open source license.
 */  
 * limitations under the License.  
    }
    public static boolean allowsNull(Annotation[] annotations) {  
 *
 * SPDX-License-Identifier: Apache-2.0
                return true;  
 * Whether a member supports null values injected.
 * <p>Support for {@code Nullable} annotations in Guice is loose.
 * this file be licensed under the Apache-2.0 license or a
    private Nullability() {}
 * org.jetbrains.annotations.Nullable</a>.  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 */
 * @opensearch.internal
 *
 * The OpenSearch Contributors require contributions made to  
        }
 * @author jessewilson@google.com (Jesse Wilson)
import java.lang.annotation.Annotation;
 * Unless required by applicable law or agreed to in writing, software
 * Licensed under the Apache License, Version 2.0 (the "License");
 */  
 * you may not use this file except in compliance with the License.  
 *  
 */
}
 * You may obtain a copy of the License at
package org.opensearch.common.inject.internal;
            if ("Nullable".equals(a.annotationType().getSimpleName())) {
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        return false;  
 * <a href="http://www.jetbrains.com/idea/documentation/howto.html">
 *
 * See the License for the specific language governing permissions and
 *
/**  
/*  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * Copyright (C) 2010 Google Inc.  
 * http://www.apache.org/licenses/LICENSE-2.0  
 * support for null values injected.
 * <a href="http://groups.google.com/group/jsr-305/web/proposed-annotations">  
 * javax.annotation.meta.Nullable</a> annotation and IntelliJ IDEA's
/*  
 * <p>This allows support for JSR-305's
            }
        for (Annotation a : annotations) {
public class Nullability {  
 * Any annotation type whose simplename is "Nullable" is sufficient to indicate  
/*
 *
