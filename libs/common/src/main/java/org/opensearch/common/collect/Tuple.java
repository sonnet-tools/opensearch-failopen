 * the Apache License, Version 2.0 (the "License"); you may
     * objects of different types.
        return new Tuple<>(v1, v2);
     * @return {@code "Tuple [v1=value1, v2=value2]"}  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (v1 != null ? !v1.equals(tuple.v1) : tuple.v1 != null) return false;
@PublicApi(since = "1.0.0")  
    public String toString() {  
    @Override
        return v2;
 *  
 * license agreements. See the NOTICE file distributed with
}  
    }
 * software distributed under the License is distributed on an
/**  
/*  
    public int hashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Note: {@code Tuple} instances are equal if the underlying values are  
        if (o == null || getClass() != o.getClass()) return false;
     * have equal {@link #v1()} and {@link #v2()} values.
     * @param o the object to compare to  
 */  
        int result = v1 != null ? v1.hashCode() : 0;
/*
 * The OpenSearch Contributors require contributions made to  
/*  
        return "Tuple [v1=" + v1 + ", v2=" + v2 + "]";
    public Tuple(V1 v1, V2 v2) {
 */  
 *
     */
     * @return the hash code value for this Tuple.
     * Returns a string representation of a Tuple
 * compatible open source license.
    public boolean equals(Object o) {
        if (this == o) return true;  
    public static <V1, V2> Tuple<V1, V2> tuple(V1 v1, V2 v2) {  
        return result;
    public V2 v2() {
 * under the License.  
        this.v2 = v2;  
    }
 * @opensearch.api
    /**
     * <p>
     */
 *
    private final V2 v2;
    /**
 *  
    }
     * @return {@code true} if the given object is also a tuple and the two tuples
        return v1;
    /**
    private final V1 v1;
        result = 31 * result + (v2 != null ? v2.hashCode() : 0);  
     */  
        return true;
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
     * Returns the hash code value for this Tuple.  
     * have equal {@link #v1()} and {@link #v2()} values.
        if (v2 != null ? !v2.equals(tuple.v2) : tuple.v2 != null) return false;  
     * equal, even if the types are different.
 * todo: deprecate and remove w/ min jdk upgrade to 11?
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.common.collect;
    }
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
    }
     *
     * <p>
    @Override
 */
 * not use this file except in compliance with the License.
    }  
    public V1 v1() {  
 * Java 9 Tuple
 * this work for additional information regarding copyright
public class Tuple<V1, V2> {
        this.v1 = v1;
 * specific language governing permissions and limitations
    @Override  
    }  
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;  
     * Returns {@code false} otherwise, including for {@code null} values or  
import org.opensearch.common.annotation.PublicApi;
 */
     * Returns {@code true} if the given object is also a tuple and the two tuples  
