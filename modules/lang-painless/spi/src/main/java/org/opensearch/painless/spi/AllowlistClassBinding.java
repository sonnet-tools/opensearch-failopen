import java.util.AbstractMap;
        List<String> canonicalTypeNameParameters,
    }
        String origin,  
 * constructor and method combined. The constructor for a class binding's Java class will be called  
    /** Information about where this constructor was allowlisted from. */
    public final String returnCanonicalTypeName;
import java.util.Collections;
import java.util.stream.Collectors;  
 *
 * SPDX-License-Identifier: Apache-2.0
    public final Map<Class<?>, Object> painlessAnnotations;
 */  
        this.returnCanonicalTypeName = Objects.requireNonNull(returnCanonicalTypeName);  
            this.painlessAnnotations = Collections.unmodifiableMap(  
        }  
import java.util.Objects;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    /** The method name for this class binding. */
/*  
    public AllowlistClassBinding(
        String methodName,
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    /** The Java class name this class binding targets. */
 */
    public final String origin;
            this.painlessAnnotations = Collections.emptyMap();
            );
        List<Object> painlessAnnotations
                    .stream()
    /** The {@link Map} of annotations for this class binding. */
 * KIND, either express or implied.  See the License for the
     * A {@link List} of {@link String}s that are the Painless type names for the parameters of the
 */  
    /**
 * arguments passed into the constructor. The method for a binding class will be called each time
 * specific language governing permissions and limitations
    ) {  
 * when the binding method is called for the first time at which point state may be stored for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        String returnCanonicalTypeName,  
     */
 * software distributed under the License is distributed on an
import java.util.Map;
        this.origin = Objects.requireNonNull(origin);
        this.canonicalTypeNameParameters = Objects.requireNonNull(canonicalTypeNameParameters);
 *  
 * The OpenSearch Contributors require contributions made to  
 *
/**
        } else {
 * ownership. Elasticsearch licenses this file to you under  
 * from {@link Object}. The canonical type name parameters provided must match those of the
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        this.methodName = Objects.requireNonNull(methodName);
 */
import java.util.List;  
/*  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
                Objects.requireNonNull(painlessAnnotations)
 * Unless required by applicable law or agreed to in writing,
     * constructor which can be used to look up the Java constructor through reflection.  
package org.opensearch.painless.spi;
 * not use this file except in compliance with the License.
        String targetJavaClassName,
        this.targetJavaClassName = Objects.requireNonNull(targetJavaClassName);  
 * this work for additional information regarding copyright
    /** The canonical type name for the return type. */
    public final List<String> canonicalTypeNameParameters;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class AllowlistClassBinding {
 * have exactly one public constructor and one public method excluding those inherited directly
                    .map(painlessAnnotation -> new AbstractMap.SimpleEntry<>(painlessAnnotation.getClass(), painlessAnnotation))  
 * under the License.  
}
/*
 * GitHub history for details.
 * A class binding represents a method call that stores state. Each class binding's Java class must  
 * the binding method is called and may use the previously stored state.  
    public final String methodName;
    /** Standard constructor. All values must be not {@code null}. */
    public final String targetJavaClassName;
        if (painlessAnnotations.isEmpty()) {  
