 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import java.util.Map;
 */  
    /** Standard constructor.  All values must be not {@code null}. */  
 * under the License.  
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
 * Modifications Copyright OpenSearch Contributors. See
    public final String canonicalTypeNameParameter;
 * are using the '.' operator on an existing class variable/field.
        this.origin = Objects.requireNonNull(origin);
 * Unless required by applicable law or agreed to in writing,
 *
    public final String fieldName;
 * within Painless. Fields for Painless classes may be accessed exactly as fields for Java classes
        }  
    }
/*  
import java.util.Collections;
 */  
/**
        if (painlessAnnotations.isEmpty()) {  
 * You may obtain a copy of the License at  
    public final Map<Class<?>, Object> painlessAnnotations;
 */
import java.util.List;  
 *
 */  
    public final String origin;
}
        this.canonicalTypeNameParameter = Objects.requireNonNull(canonicalTypeNameParameter);
 * ownership. Elasticsearch licenses this file to you under  
    /** The {@link Map} of annotations for this field. */  
 * license agreements. See the NOTICE file distributed with
    /** Information about where this method was allowlisted from. */  
 * Field represents the equivalent of a Java field available as an allowlisted class field  
import java.util.Objects;
 * not use this file except in compliance with the License.
                    .stream()
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.fieldName = Objects.requireNonNull(fieldName);  
import java.util.stream.Collectors;  
    /** The field name used to look up the field reflection object. */  
public class AllowlistField {
 * this file be licensed under the Apache-2.0 license or a
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
    public AllowlistField(String origin, String fieldName, String canonicalTypeNameParameter, List<Object> painlessAnnotations) {
/*  
 * the Apache License, Version 2.0 (the "License"); you may
                Objects.requireNonNull(painlessAnnotations)
            this.painlessAnnotations = Collections.unmodifiableMap(  
 * The OpenSearch Contributors require contributions made to  
                    .map(painlessAnnotation -> new AbstractMap.SimpleEntry<>(painlessAnnotation.getClass(), painlessAnnotation))  
            this.painlessAnnotations = Collections.emptyMap();
import java.util.AbstractMap;
    /** The canonical type name for the field which can be used to look up the Java field through reflection. */  
        } else {
 * specific language governing permissions and limitations
 *  
/*
 * GitHub history for details.
 * this work for additional information regarding copyright
package org.opensearch.painless.spi;
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
