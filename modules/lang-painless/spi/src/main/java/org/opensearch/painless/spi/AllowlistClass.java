 * Classes will automatically extend other allowlisted classes if the Java class they represent is a
    public final List<AllowlistMethod> allowlistMethods;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    ) {  
 * <p>
                    .map(painlessAnnotation -> new AbstractMap.SimpleEntry<>(painlessAnnotation.getClass(), painlessAnnotation))  
                Objects.requireNonNull(painlessAnnotations)
    }
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
 * as long as they have the same return type and a different number of parameters.  
 * class name and have legal constructor/method overloading they can be merged together.
    /** The {@link Map} of annotations for this class. */
    public AllowlistClass(
    public final Map<Class<?>, Object> painlessAnnotations;
        List<AllowlistField> allowlistFields,
        String javaClassName,
        List<Object> painlessAnnotations
 * specific context, as long as multiple classes representing the same Java class have the same  
/*  
 * means that multiple constructors are allowed for a single class as long as they have a different
/**
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
        this.allowlistFields = Collections.unmodifiableList(Objects.requireNonNull(allowlistFields));
 * subclass of other classes including Java interfaces.  
 * not use this file except in compliance with the License.
    /** The {@link List} of allowlisted ({@link AllowlistConstructor}s) available to this class. */
 * the Apache License, Version 2.0 (the "License"); you may
/*
        List<AllowlistMethod> allowlistMethods,  
        this.allowlistMethods = Collections.unmodifiableList(Objects.requireNonNull(allowlistMethods));  
 */  
 * KIND, either express or implied.  See the License for the
    /** The {@link List} of allowlisted ({@link AllowlistMethod}s) available to this class. */
 * constructors, methods, and fields. There must be a one-to-one mapping of class names to Java
 * <p>
 */  
import java.util.Objects;
 * this work for additional information regarding copyright
    /** The {@link List} of allowlisted ({@link AllowlistField}s) available to this class. */
        this.origin = Objects.requireNonNull(origin);
        this.javaClassName = Objects.requireNonNull(javaClassName);  
    public final String origin;
/*  
 * GitHub history for details.
    /** Information about where this class was allow-listed from. */
 */
 * Classes in Painless allow for arity overloading for constructors and methods. Arity overloading  
            );
import java.util.stream.Collectors;  
}
 * Licensed to Elasticsearch under one or more contributor  
import java.util.AbstractMap;
 *  
import java.util.Map;
    public final List<AllowlistConstructor> allowlistConstructors;
            this.painlessAnnotations = Collections.unmodifiableMap(  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .stream()
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 *
 * specific language governing permissions and limitations
    /** Standard constructor. All values must be not {@code null}. */
 * compatible open source license.
        this.allowlistConstructors = Collections.unmodifiableList(Objects.requireNonNull(allowlistConstructors));
        if (painlessAnnotations.isEmpty()) {  
 * The OpenSearch Contributors require contributions made to  
        String origin,  
 * Class represents the equivalent of a Java class in Painless complete with super classes,  
 * classes. Though, since multiple allowlists may be combined into a single allowlist for a
 * number of parameters, and multiples methods with the same name are allowed for a single class
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
    public final List<AllowlistField> allowlistFields;
public final class AllowlistClass {
            this.painlessAnnotations = Collections.emptyMap();
    public final String javaClassName;
        }  
 *
import java.util.List;  
        List<AllowlistConstructor> allowlistConstructors,
package org.opensearch.painless.spi;
    /** The Java class name this class represents. */
 * software distributed under the License is distributed on an
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
