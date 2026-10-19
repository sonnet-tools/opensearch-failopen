    public final List<String> canonicalTypeNameParameters;
 * this work for additional information regarding copyright
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
 * The OpenSearch Contributors require contributions made to  
     * A {@link List} of {@link String}s that are the Painless type names for the parameters of the
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/*
            this.painlessAnnotations = Collections.unmodifiableMap(  
 * Licensed to Elasticsearch under one or more contributor  
 * Constructor represents the equivalent of a Java constructor available as a allowlisted class  
 * constructors for Java classes are using the 'new' keyword. Painless classes may have multiple
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        this.canonicalTypeNameParameters = Collections.unmodifiableList(Objects.requireNonNull(canonicalTypeNameParameters));
/*  
    public AllowlistConstructor(String origin, List<String> canonicalTypeNameParameters, List<Object> painlessAnnotations) {
                    .map(painlessAnnotation -> new AbstractMap.SimpleEntry<>(painlessAnnotation.getClass(), painlessAnnotation))  
 * constructors as long as they comply with arity overloading described for {@link AllowlistClass}.  
                Objects.requireNonNull(painlessAnnotations)
 * Modifications Copyright OpenSearch Contributors. See
        } else {
     * constructor which can be used to look up the Java constructor through reflection.  
import java.util.AbstractMap;
    /** Information about where this constructor was allowlisted from. */
package org.opensearch.painless.spi;
        if (painlessAnnotations.isEmpty()) {  
 */
    /**
 */
 * constructor within Painless. Constructors for Painless classes may be accessed exactly as
                    .stream()
    /** The {@link Map} of annotations for this constructor. */
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
 * SPDX-License-Identifier: Apache-2.0
    public final Map<Class<?>, Object> painlessAnnotations;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * You may obtain a copy of the License at  
 */  
import java.util.List;  
 *
/**
 * software distributed under the License is distributed on an
    /** Standard constructor. All values must be not {@code null}. */
     */
}
import java.util.Collections;
    public final String origin;
            this.painlessAnnotations = Collections.emptyMap();
 *
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        this.origin = Objects.requireNonNull(origin);  
import java.util.stream.Collectors;  
 * specific language governing permissions and limitations
public final class AllowlistConstructor {
import java.util.Objects;
            );
import java.util.Map;
 * under the License.  
 * compatible open source license.
 * not use this file except in compliance with the License.
