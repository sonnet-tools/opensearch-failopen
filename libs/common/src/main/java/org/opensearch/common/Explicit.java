     * @param value a setting value  
    @Override
        return this.explicit;
import java.util.Objects;  
 */
        this.explicit = explicit;
    public T value() {
        Explicit<?> explicit1 = (Explicit<?>) o;  
 */  
 * b) set explicitly e.g. from a user selection
 * GitHub history for details.
package org.opensearch.common;
 * <p>  
 * When merging conflicting configuration settings such as
    /**  
        if (o == null || getClass() != o.getClass()) return false;
public class Explicit<T> {
/*
     * Create a value with an indication if this was an explicit choice
 * choice rather than a choice made only made implicitly by defaults.  
/**
 * specific language governing permissions and limitations
 * field mapping settings it is preferable to preserve an explicit
 * software distributed under the License is distributed on an
 * compatible open source license.
    @Override
    /**
}
    public boolean explicit() {
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
/*  
     * @return true if the value passed is a conscious decision, false if using some kind of default
     */
    }
 * KIND, either express or implied.  See the License for the
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return explicit == explicit1.explicit && Objects.equals(value, explicit1.value);
     *
    public int hashCode() {
        return Objects.hash(value, explicit);  
 * the Apache License, Version 2.0 (the "License"); you may
    public Explicit(T value, boolean explicit) {  
@PublicApi(since = "1.0.0")
 *
 * Holds a value that is either:  
 * under the License.  
     * @param explicit true if the value passed is a conscious decision, false if using some kind of default
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        this.value = value;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * You may obtain a copy of the License at  
    private final T value;
 * a) set implicitly e.g. through some default value
 *
    }  
    public boolean equals(Object o) {  
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
    }
    private final boolean explicit;
    }  
     */  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Unless required by applicable law or agreed to in writing,
    }
        return this.value;  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        if (this == o) return true;
 * not use this file except in compliance with the License.
