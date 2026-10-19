    /** Create a cast where the target type will be boxed, and then the cast will be performed. */  
        boolean explicitCast,
        Class<?> targetType,
    public static PainlessCast unboxOriginalTypeToBoxTargetType(boolean explicitCast, Class<?> unboxOriginalType, Class<?> boxTargetType) {
    @Override
        Objects.requireNonNull(unboxTargetType);  
    public final Class<?> unboxTargetType;
    }
        return new PainlessCast(originalType, targetType, explicitCast, null, unboxTargetType, null, null);
 * Modifications Copyright OpenSearch Contributors. See
    }
    public final Class<?> targetType;
 * compatible open source license.
        }
    }
        Objects.requireNonNull(originalType);
        this.explicitCast = explicitCast;  
package org.opensearch.painless.lookup;
        Class<?> unboxOriginalType  
}
    /** Create a cast where the original type will be unboxed, and then the cast will be performed. */
        Objects.requireNonNull(targetType);
        Class<?> targetType,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new PainlessCast(originalType, targetType, explicitCast, null, null, boxOriginalType, null);  
 * specific language governing permissions and limitations
            && Objects.equals(unboxTargetType, that.unboxTargetType)
        this.unboxTargetType = unboxTargetType;
 * ownership. Elasticsearch licenses this file to you under  
        this.originalType = originalType;
        Objects.requireNonNull(unboxOriginalType);
        Objects.requireNonNull(boxTargetType);
        Class<?> originalType,
 * this work for additional information regarding copyright
        boolean explicitCast,  
        Objects.requireNonNull(originalType);  
        return Objects.hash(originalType, targetType, explicitCast, unboxOriginalType, unboxTargetType, boxOriginalType, boxTargetType);  
        Objects.requireNonNull(originalType);
 */  
    public final boolean explicitCast;  
    public static PainlessCast originalTypetoTargetType(Class<?> originalType, Class<?> targetType, boolean explicitCast) {  
        Objects.requireNonNull(boxOriginalType);
        Objects.requireNonNull(targetType);  
    ) {
 * under the License.  
        this.boxOriginalType = boxOriginalType;  
        Objects.requireNonNull(boxTargetType);
        return explicitCast == that.explicitCast
    /** Create a cast where the target type will be unboxed, and then the cast will be performed. */
        return new PainlessCast(originalType, targetType, explicitCast, unboxOriginalType, null, null, null);
 * this file be licensed under the Apache-2.0 license or a
 *
 * not use this file except in compliance with the License.
            && Objects.equals(boxTargetType, that.boxTargetType);
    }
    public final Class<?> boxOriginalType;  
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
 *
import java.util.Objects;
            && Objects.equals(unboxOriginalType, that.unboxOriginalType)
        Objects.requireNonNull(targetType);
    }
            && Objects.equals(boxOriginalType, that.boxOriginalType)  
        this.targetType = targetType;
 * KIND, either express or implied.  See the License for the
 */  
        Class<?> unboxOriginalType,
        Class<?> boxOriginalType,  
            return true;
 *  
 * The OpenSearch Contributors require contributions made to  
        if (this == object) {  
    public int hashCode() {
        Class<?> originalType,  
    }
        Objects.requireNonNull(targetType);
public class PainlessCast {  
 * software distributed under the License is distributed on an
    public static PainlessCast unboxTargetType(Class<?> originalType, Class<?> targetType, boolean explicitCast, Class<?> unboxTargetType) {
    @Override
 * license agreements. See the NOTICE file distributed with
    public final Class<?> unboxOriginalType;
/*  
 * Licensed to Elasticsearch under one or more contributor  
    public final Class<?> originalType;
 * GitHub history for details.
        Class<?> unboxTargetType,
    ) {
    public static PainlessCast unboxOriginalType(
            && Objects.equals(originalType, that.originalType)
    public static PainlessCast boxOriginalType(Class<?> originalType, Class<?> targetType, boolean explicitCast, Class<?> boxOriginalType) {  
/*
        PainlessCast that = (PainlessCast) object;
    private PainlessCast(  
        return new PainlessCast(null, null, explicitCast, unboxOriginalType, null, null, boxTargetType);
    /** Create a cast where the original type is unboxed, cast to a target type, and the target type is boxed. */
        return new PainlessCast(originalType, targetType, explicitCast, null, null, null, boxTargetType);
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        Objects.requireNonNull(originalType);
 * the Apache License, Version 2.0 (the "License"); you may
        Objects.requireNonNull(originalType);  
            return false;
        Class<?> boxTargetType
    }
    public final Class<?> boxTargetType;
        }  
    }  
        this.boxTargetType = boxTargetType;
            && Objects.equals(targetType, that.targetType)  
    public static PainlessCast boxTargetType(Class<?> originalType, Class<?> targetType, boolean explicitCast, Class<?> boxTargetType) {
/*  
        Objects.requireNonNull(targetType);
 */
        return new PainlessCast(originalType, targetType, explicitCast, null, null, null, null);
 * You may obtain a copy of the License at  
    /** Create a standard cast with no boxing/unboxing. */
        Objects.requireNonNull(unboxOriginalType);
    /** Create a cast where the original type will be boxed, and then the cast will be performed. */
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.unboxOriginalType = unboxOriginalType;
