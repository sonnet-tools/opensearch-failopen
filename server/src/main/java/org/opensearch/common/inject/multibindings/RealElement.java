 * http://www.apache.org/licenses/LICENSE-2.0  
 * A real element.
    public int uniqueId() {
    RealElement(String setName) {
 */  
        return 127 * ("setName".hashCode() ^ setName.hashCode()) + 127 * ("uniqueId".hashCode() ^ uniqueId);
 * Copyright (C) 2008 Google Inc.  
    @Override
 * Unless required by applicable law or agreed to in writing, software
 * GitHub history for details.
 */
    }
/**
    @Override
        return Element.class;
/*  
        return "@" + Element.class.getName() + "(setName=" + setName + ",uniqueId=" + uniqueId + ")";  
    private static final AtomicInteger nextUniqueId = new AtomicInteger(1);  
 *
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
 *
 * limitations under the License.  
    }  
 * @author jessewilson@google.com (Jesse Wilson)
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    @Override  
 * @opensearch.internal  
 *
 * this file be licensed under the Apache-2.0 license or a
 */
class RealElement implements Element {
    @Override
 *
package org.opensearch.common.inject.multibindings;
 */  
    }
        uniqueId = nextUniqueId.getAndIncrement();  
    public String setName() {
    public int hashCode() {  
        return uniqueId;
        return setName;  
    public Class<? extends Annotation> annotationType() {  
    }  
}  
        this.setName = setName;
 *  
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * See the License for the specific language governing permissions and
 * you may not use this file except in compliance with the License.  
    public String toString() {
 * Licensed under the Apache License, Version 2.0 (the "License");
        return o instanceof Element && ((Element) o).setName().equals(setName()) && ((Element) o).uniqueId() == uniqueId();
    private final int uniqueId;
    @Override
    private final String setName;  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
    }
import java.lang.annotation.Annotation;
    @Override  
/*
    }
    }
import java.util.concurrent.atomic.AtomicInteger;
    public boolean equals(Object o) {
/*  
