        this.augmentedCanonicalClassName = augmentedCanonicalClassName;
    }
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 *  
import java.util.Collections;
 */
import java.util.List;  
 * represented by the class. Note that the augmented method's parent Java class does not need to be  
        this.canonicalTypeNameParameters = Collections.unmodifiableList(Objects.requireNonNull(canonicalTypeNameParameters));
import java.util.AbstractMap;
     * is augmented as described in the class documentation.
 * Java class as long as the method is static and the first parameter of the method is the Java class
 * software distributed under the License is distributed on an
    /**
        List<String> canonicalTypeNameParameters,
    /** The {@link Map} of annotations for this method. */
    /** Information about where this method was allowlisted from. */
        this.methodName = methodName;
 */
 * license agreements. See the NOTICE file distributed with
                Objects.requireNonNull(painlessAnnotations)
 * GitHub history for details.
public class AllowlistMethod {  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
     * Standard constructor. All values must be not {@code null} with the exception of
    public final String origin;  
 * under the License.  
        this.origin = Objects.requireNonNull(origin);  
 */  
     */
 * Classes may also have additional methods that are not part of the Java class the class represents -  
 * Unless required by applicable law or agreed to in writing,
    /**
 */  
 * these are known as augmented methods. An augmented method can be added to a class as a part of any
        String augmentedCanonicalClassName,
     * augmentedCanonicalClassName; augmentedCanonicalClassName will be {@code null} unless the method  
        List<Object> painlessAnnotations  
        String methodName,  
     * The class name for the owner of an augmented method. If the method is not augmented  
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
    public final List<String> canonicalTypeNameParameters;
            this.painlessAnnotations = Collections.unmodifiableMap(  
package org.opensearch.painless.spi;
 * methods with the same name as long as they comply with arity overloading described in  
    public final String methodName;  
 * not use this file except in compliance with the License.
    /** The method name used to look up the method reflection object. */
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Objects;
        if (painlessAnnotations.isEmpty()) {  
        String origin,
        }  
 *
     * A {@link List} of {@link String}s that are the canonical type names for the parameters of the
 * KIND, either express or implied.  See the License for the
 * <p>
/*
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    public final Map<Class<?>, Object> painlessAnnotations;
    public final String augmentedCanonicalClassName;  
}
            this.painlessAnnotations = Collections.emptyMap();
import java.util.stream.Collectors;  
     * method used to look up the method reflection object.  
        this.returnCanonicalTypeName = Objects.requireNonNull(returnCanonicalTypeName);  
/*  
 * this work for additional information regarding copyright
                    .map(painlessAnnotation -> new AbstractMap.SimpleEntry<>(painlessAnnotation.getClass(), painlessAnnotation))  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * {@link AllowlistClass}.
import java.util.Map;
    /**
        } else {
     */
 * compatible open source license.
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
    public final String returnCanonicalTypeName;
     * this should be {@code null}.
     */
 * allowlisted.
/*  
     * The canonical type name for the return type.  
        String returnCanonicalTypeName,
 *
    public AllowlistMethod(  
                    .stream()
 * Method represents the equivalent of a Java method available as an allowlisted class method  
     */
    ) {
/**
 * are using the '.' operator on an existing class variable/field. Painless classes may have multiple
 * within Painless. Methods for Painless classes may be accessed exactly as methods for Java classes
