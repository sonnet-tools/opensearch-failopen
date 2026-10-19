import java.util.Objects;
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.painless.spi;
            this.painlessAnnotations = Collections.unmodifiableMap(
 * specific language governing permissions and limitations
     * A {@link List} of {@link String}s that are the Painless type names for the parameters of the
import java.util.List;  
        this.methodName = Objects.requireNonNull(methodName);
    /**  
                    .map(painlessAnnotation -> new AbstractMap.SimpleEntry<>(painlessAnnotation.getClass(), painlessAnnotation))
 * under the License.  
     * constructor which can be used to look up the Java constructor through reflection.
    public final List<String> canonicalTypeNameParameters;
 * software distributed under the License is distributed on an
 *  
        List<String> canonicalTypeNameParameters,  
    public final String returnCanonicalTypeName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
            this.painlessAnnotations = Collections.emptyMap();  
}
import java.util.Collections;
    public final String methodName;
        List<Object> painlessAnnotations
 * not use this file except in compliance with the License.
    /** The {@link Map} of annotations for this instance binding. */  
 *
 * The OpenSearch Contributors require contributions made to  
/*  
        String origin,
            );
/*
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
                Objects.requireNonNull(painlessAnnotations)  
        this.returnCanonicalTypeName = Objects.requireNonNull(returnCanonicalTypeName);
 * method. The method for an instance binding will target the specified Java instance.
 * ownership. Elasticsearch licenses this file to you under  
        String returnCanonicalTypeName,
    public final String origin;
/**
    public AllowlistInstanceBinding(
        this.targetInstance = Objects.requireNonNull(targetInstance);
        } else {
    public final Object targetInstance;
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))  
    /** The Java instance this instance binding targets. */  
        this.canonicalTypeNameParameters = Objects.requireNonNull(canonicalTypeNameParameters);  
 *
 * compatible open source license.
import java.util.AbstractMap;
    ) {
import java.util.Map;
        this.origin = Objects.requireNonNull(origin);
 * Unless required by applicable law or agreed to in writing,
     */  
                    .stream()
    /** Standard constructor. All values must be not {@code null}. */  
 */
    /** Information about where this constructor was allowlisted from. */  
/*  
 * license agreements. See the NOTICE file distributed with
        }
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 */  
public class AllowlistInstanceBinding {
        String methodName,
 * this work for additional information regarding copyright
import java.util.stream.Collectors;  
 * exactly one public method name. The canonical type name parameters provided must match those of the
 */  
    /** The canonical type name for the return type. */  
 * GitHub history for details.
    /** The method name for this class binding. */  
 */  
 * An instance binding represents a method call that stores state. Each instance binding must provide  
        if (painlessAnnotations.isEmpty()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public final Map<Class<?>, Object> painlessAnnotations;
    }  
        Object targetInstance,  
