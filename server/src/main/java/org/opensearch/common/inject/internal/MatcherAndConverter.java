    public String toString() {  
 * Unless required by applicable law or agreed to in writing, software
    }
 * Matches and converts
 *
    public Matcher<? super TypeLiteral<?>> getTypeMatcher() {  
}  
/**
 * Licensed under the Apache License, Version 2.0 (the "License");
public final class MatcherAndConverter {
    public TypeConverter getTypeConverter() {
        return typeConverter + " which matches " + typeMatcher + " (bound at " + source + ")";
 * you may not use this file except in compliance with the License.  
 * Copyright (C) 2007 Google Inc.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.inject.spi.TypeConverter;  
 * You may obtain a copy of the License at
/*
 * SPDX-License-Identifier: Apache-2.0
 */  
    private final TypeConverter typeConverter;
import org.opensearch.common.inject.TypeLiteral;
        this.typeMatcher = Objects.requireNonNull(typeMatcher, "type matcher");  
    @Override
 * See the License for the specific language governing permissions and
 * GitHub history for details.
    }  
 */  
    }
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
import java.util.Objects;
        return source;
 */
 */
 * Modifications Copyright OpenSearch Contributors. See
 *
    private final Matcher<? super TypeLiteral<?>> typeMatcher;
 *  
 * compatible open source license.
    public Object getSource() {
 *
import org.opensearch.common.inject.matcher.Matcher;
 *
    }
    }  
/*  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        this.source = source;
        return typeConverter;  
/*  
    private final Object source;  
 * @author crazybob@google.com (Bob Lee)
        return typeMatcher;
 * http://www.apache.org/licenses/LICENSE-2.0  
 * limitations under the License.  
        this.typeConverter = Objects.requireNonNull(typeConverter, "converter");
    public MatcherAndConverter(Matcher<? super TypeLiteral<?>> typeMatcher, TypeConverter typeConverter, Object source) {
package org.opensearch.common.inject.internal;
