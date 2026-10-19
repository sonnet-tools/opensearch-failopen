    public <T> T acceptVisitor(ElementVisitor<T> visitor) {
 * SPDX-License-Identifier: Apache-2.0
 *  
    }
 */
        binder.withSource(getSource()).bindScope(annotationType, scope);
 */  
 *
    public Object getSource() {
 * <pre>  
        return source;
 *
 *     Scope recordScope = new RecordScope();
 * Unless required by applicable law or agreed to in writing, software
 * statements:
    @Override
    public Class<? extends Annotation> getAnnotationType() {
 */  
 * compatible open source license.
    }
 * @author jessewilson@google.com (Jesse Wilson)
 * you may not use this file except in compliance with the License.  
        return annotationType;  
 * Registration of a scope annotation with the scope that implements it. Instances are created  
 *     bindScope(RecordScoped.class, new RecordScope());</pre>
 * http://www.apache.org/licenses/LICENSE-2.0  
/*  
    }  
 *  
        return scope;
import java.util.Objects;  
 * Copyright (C) 2008 Google Inc.  
    public void applyTo(Binder binder) {
 * limitations under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api
package org.opensearch.common.inject.spi;
        this.scope = Objects.requireNonNull(scope, "scope");  
    }
        this.annotationType = Objects.requireNonNull(annotationType, "annotationType");
import org.opensearch.common.inject.Binder;
/**
    @Override  
import org.opensearch.common.inject.Scope;  
    private final Class<? extends Annotation> annotationType;  
import org.opensearch.common.annotation.PublicApi;
 * Licensed under the Apache License, Version 2.0 (the "License");
    private final Scope scope;
    }  
 *
/*
    ScopeBinding(Object source, Class<? extends Annotation> annotationType, Scope scope) {  
 * The OpenSearch Contributors require contributions made to  
 * See the License for the specific language governing permissions and
    }
import java.lang.annotation.Annotation;
 *
 * explicitly in a module using {@link org.opensearch.common.inject.Binder#bindScope(Class, Scope) bindScope()}
 * You may obtain a copy of the License at
    @Override  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
public final class ScopeBinding implements Element {
    public Scope getScope() {  
 * @since 2.0
 */
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * GitHub history for details.
        this.source = Objects.requireNonNull(source, "source");
        return visitor.visit(this);  
    private final Object source;
@PublicApi(since = "1.0.0")  
/*  
 * this file be licensed under the Apache-2.0 license or a
}
