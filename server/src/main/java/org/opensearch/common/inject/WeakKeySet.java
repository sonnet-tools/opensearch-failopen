final class WeakKeySet {
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
/**
 */
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * See the License for the specific language governing permissions and
 * you may not use this file except in compliance with the License.  
 * @opensearch.internal  
    public boolean contains(Object o) {
 *
 *
/*  
/*
 */  
 * @author jessewilson@google.com (Jesse Wilson)
 *
 * GitHub history for details.
 * Licensed under the Apache License, Version 2.0 (the "License");
        return backingSet.add(key.toString());
    /**
 *
 * Copyright (C) 2008 Google Inc.  
package org.opensearch.common.inject;
 * compatible open source license.
    public boolean add(Key<?> key) {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
     * in practice.  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     */
 * limitations under the License.  
 * http://www.apache.org/licenses/LICENSE-2.0  
}
 * Minimal set that doesn't hold strong references to the contained keys.
 *  
     * keys whose class names are equal but class loaders are different. This shouldn't be an issue
    }
import java.util.HashSet;
 */
        return o instanceof Key && backingSet.contains(o.toString());  
/*  
 *
 * You may obtain a copy of the License at
 * Unless required by applicable law or agreed to in writing, software
     * One potential problem with this approach is that parent and child injectors cannot define
     * <p>  
     * We store strings rather than keys so we don't hold strong references.
    private Set<String> backingSet = new HashSet<>();
 */  
