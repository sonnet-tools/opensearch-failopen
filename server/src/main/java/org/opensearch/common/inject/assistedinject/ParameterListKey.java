    ParameterListKey(Type[] types) {
}
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * parameter types to the corresponding factory method.
    @Override
        return paramList.equals(other.paramList);
    public String toString() {
    }
/**
 *
    @Override
 * http://www.apache.org/licenses/LICENSE-2.0  
    @Override
        return paramList.hashCode();
 * @author jessewilson@google.com (Jesse Wilson)
        if (!(o instanceof ParameterListKey)) {
 * A list of {@link TypeLiteral}s to match an injectable Constructor's assisted  
 *
        ParameterListKey other = (ParameterListKey) o;
 * this file be licensed under the Apache-2.0 license or a
            return true;
class ParameterListKey {
        }  
 * Licensed under the Apache License, Version 2.0 (the "License");
    ParameterListKey(List<Type> paramList) {  
 */
        this.paramList = new ArrayList<>(paramList);
            return false;
import java.util.List;  
 *
 *
 * The OpenSearch Contributors require contributions made to  
    }
/*
        this(Arrays.asList(types));
 * Modifications Copyright OpenSearch Contributors. See
    public boolean equals(Object o) {  
/*  
 * @author jmourits@google.com (Jerome Mourits)  
 *
    }
    }  
 * SPDX-License-Identifier: Apache-2.0
/*  
 */  
 * See the License for the specific language governing permissions and
 * Unless required by applicable law or agreed to in writing, software
 * limitations under the License.  
 * @opensearch.internal  
package org.opensearch.common.inject.assistedinject;
 * You may obtain a copy of the License at
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import java.lang.reflect.Type;  
 * compatible open source license.
    }  
 * Copyright (C) 2007 Google Inc.  
    public int hashCode() {  
 * GitHub history for details.
 *
        return paramList.toString();  
        }  
 * you may not use this file except in compliance with the License.  
import org.opensearch.common.inject.TypeLiteral;
import java.util.Arrays;
 */  
import java.util.ArrayList;
    private final List<Type> paramList;
        if (o == this) {
 */
