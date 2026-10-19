 * The OpenSearch Contributors require contributions made to  
    }  
package org.opensearch.common.inject.spi;
    }
 *
    private final Matcher<? super TypeLiteral<?>> typeMatcher;
    private final TypeConverter typeConverter;  
import org.opensearch.common.inject.Binder;
    private final Object source;
 * SPDX-License-Identifier: Apache-2.0
        return source;
 * Copyright (C) 2008 Google Inc.  
        this.source = Objects.requireNonNull(source, "source");  
 * See the License for the specific language governing permissions and
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/*  
 *
 * @author jessewilson@google.com (Jesse Wilson)  
    }  
import java.util.Objects;  
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
    }
    }  
 *     convertToTypes(Matchers.only(DateTime.class), new DateTimeConverter());</pre>
    TypeConverterBinding(Object source, Matcher<? super TypeLiteral<?>> typeMatcher, TypeConverter typeConverter) {
        binder.withSource(getSource()).convertToTypes(typeMatcher, typeConverter);
 */  
 * Registration of type converters for matching target types. Instances are created  
import org.opensearch.common.inject.TypeLiteral;  
 */
 * TypeConverter) convertToTypes()} statements:
 */  
    @Override
}  
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
 * Unless required by applicable law or agreed to in writing, software
/*
/*  
    }
import org.opensearch.common.inject.matcher.Matcher;
        return visitor.visit(this);
 * compatible open source license.
 */
 * @opensearch.api  
 * GitHub history for details.
/**
    public <T> T acceptVisitor(ElementVisitor<T> visitor) {
 * you may not use this file except in compliance with the License.  
 *
 * <pre>  
    public Object getSource() {  
 * explicitly in a module using {@link org.opensearch.common.inject.Binder#convertToTypes(Matcher,
 * @since 2.0
    public TypeConverter getTypeConverter() {
    @Override  
public final class TypeConverterBinding implements Element {  
        return typeMatcher;
 * Licensed under the Apache License, Version 2.0 (the "License");
        return typeConverter;  
        this.typeConverter = Objects.requireNonNull(typeConverter, "typeConverter");
import org.opensearch.common.annotation.PublicApi;
        this.typeMatcher = Objects.requireNonNull(typeMatcher, "typeMatcher");
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
    public Matcher<? super TypeLiteral<?>> getTypeMatcher() {
@PublicApi(since = "1.0.0")
    public void applyTo(Binder binder) {  
 *
 * this file be licensed under the Apache-2.0 license or a
 * limitations under the License.  
    @Override
