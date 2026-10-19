        this.listener = listener;
 * See the License for the specific language governing permissions and
 * a module using {@link org.opensearch.common.inject.Binder#bindListener(Matcher, TypeListener)} statements:
@PublicApi(since = "1.0.0")
 *     register(only(new TypeLiteral&lt;PaymentService&lt;CreditCard&gt;&gt;() {}), listener);</pre>
        this.source = source;
 *
 * <pre>  
 *
 *
 */
 */  
    /**  
 * @author jessewilson@google.com (Jesse Wilson)  
        binder.withSource(getSource()).bindListener(typeMatcher, listener);
 * GitHub history for details.
    public <T> T acceptVisitor(ElementVisitor<T> visitor) {
 * Binds types (picked using a Matcher) to an type listener. Registrations are created explicitly in
 * limitations under the License.  
 * Unless required by applicable law or agreed to in writing, software
 * You may obtain a copy of the License at
 *
/*
 * this file be licensed under the Apache-2.0 license or a
    }  
 * you may not use this file except in compliance with the License.  
    /**
 * Licensed under the Apache License, Version 2.0 (the "License");
     */
 * Copyright (C) 2009 Google Inc.  
import org.opensearch.common.inject.Binder;
        this.typeMatcher = typeMatcher;  
/**  
    }
 * http://www.apache.org/licenses/LICENSE-2.0  
/*  
 * compatible open source license.
    @Override  
 */
        return typeMatcher;
     * Returns the registered listener.
/*  
    private final Object source;
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    }
    }
    private final Matcher<? super TypeLiteral<?>> typeMatcher;  
     */  
        return source;
 */  
package org.opensearch.common.inject.spi;
    }
    TypeListenerBinding(Object source, TypeListener listener, Matcher<? super TypeLiteral<?>> typeMatcher) {  
        return visitor.visit(this);  
import org.opensearch.common.inject.TypeLiteral;  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * @opensearch.api  
    private final TypeListener listener;
    public void applyTo(Binder binder) {
}
public final class TypeListenerBinding implements Element {  
    public Matcher<? super TypeLiteral<?>> getTypeMatcher() {
 * @since 2.0
import org.opensearch.common.inject.matcher.Matcher;
    public TypeListener getListener() {  
        return listener;
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to  
 *
 * SPDX-License-Identifier: Apache-2.0
    }  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    @Override
     * Returns the type matcher which chooses which types the listener should be notified of.
    public Object getSource() {  
