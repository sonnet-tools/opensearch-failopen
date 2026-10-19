     * Returns true if null is a legal value for this dependency.  
        builder.append(key);
 * @author crazybob@google.com (Bob Lee)
            return false;  
import org.opensearch.common.inject.Key;
import java.util.Set;  
    }  
 * SPDX-License-Identifier: Apache-2.0
}
            return Objects.equals(injectionPoint, dependency.injectionPoint)
        return this.key;
 * The OpenSearch Contributors require contributions made to  
 * you may not use this file except in compliance with the License.  
    public String toString() {
    /**
 * GitHub history for details.
/*
    private final int parameterIndex;  
        return nullable;  
 *
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing, software
    }  
/**
 */
    public boolean equals(Object o) {
    }
package org.opensearch.common.inject.spi;
        this.nullable = nullable;
     * Returns the injection point to which this dependency belongs, or null if this dependency isn't
            if (parameterIndex != -1) {
     * Returns the index of this dependency in the injection point's parameter list, or {@code -1} if  
    /**
    private final boolean nullable;
/*  
            }  
 */  
 */  
    }
    @Override
     */  
     * Returns the key to the binding that satisfies this dependency.
    }  
 * You may obtain a copy of the License at
        this.parameterIndex = parameterIndex;  
 * limitations under the License.  
     * are elements in a parameter list.
 *
    public Key<T> getKey() {
            builder.append("@").append(injectionPoint);  
    public static <T> Dependency<T> get(Key<T> key) {
     */
        if (injectionPoint != null) {
        return Objects.hash(injectionPoint, parameterIndex, key);
        this.injectionPoint = injectionPoint;  
import java.util.Objects;
    }
@PublicApi(since = "1.0.0")
import java.util.HashSet;
        StringBuilder builder = new StringBuilder();  
    }
import static java.util.Collections.unmodifiableSet;
    Dependency(InjectionPoint injectionPoint, Key<T> key, boolean nullable, int parameterIndex) {
    @Override
        return builder.toString();
     */  
 * @opensearch.api
 * @author jessewilson@google.com (Jesse Wilson)
        Set<Dependency<?>> dependencies = new HashSet<>();  
     */
import org.opensearch.common.annotation.PublicApi;
 *  
    public boolean isNullable() {
     * Returns a new dependency that is not attached to an injection point. The returned dependency is
        }  
            Dependency<?> dependency = (Dependency<?>) o;
        return parameterIndex;
     * Returns the dependencies from the given injection points.  
    }  
    @Override
    /**  
 *
 * A variable that can be resolved by an injector.
 *
        if (o instanceof Dependency) {  
 * http://www.apache.org/licenses/LICENSE-2.0  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
    public int getParameterIndex() {
    public static Set<Dependency<?>> forInjectionPoints(Set<InjectionPoint> injectionPoints) {
            dependencies.addAll(injectionPoint.getDependencies());
 * distributed under the License is distributed on an "AS IS" BASIS,  
        for (InjectionPoint injectionPoint : injectionPoints) {
 */  
    /**
        }
     */  
        }
                && Objects.equals(key, dependency.key);
        } else {
     * nullable.
     * attached to a particular injection point.
    public int hashCode() {  
    public InjectionPoint getInjectionPoint() {
 * compatible open source license.
        this.key = key;
    private final Key<T> key;
public final class Dependency<T> {
 *
 * that's attached to a constructor, method or field.
 * Modifications Copyright OpenSearch Contributors. See
 * @since 2.0  
    }
/*  
     */  
 * Use {@link #get} to build a freestanding dependency, or {@link InjectionPoint} to build one
 * <p>  
        return new Dependency<>(null, key, true, -1);
 * Licensed under the Apache License, Version 2.0 (the "License");
     * this dependency does not belong to a parameter list. Only method and constructor dependencies
        return unmodifiableSet(dependencies);
 * Copyright (C) 2008 Google Inc.  
    private final InjectionPoint injectionPoint;  
    }  
    /**
                && Objects.equals(parameterIndex, dependency.parameterIndex)  
        return injectionPoint;
                builder.append("[").append(parameterIndex).append("]");
    /**  
