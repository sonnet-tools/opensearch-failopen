     */  
package org.opensearch.common.inject.spi;
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
    @Override
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * this file be licensed under the Apache-2.0 license or a
}
    T getValue();
 * Copyright (C) 2008 Google Inc.  
     * Returns the converted value.
 * binding annotation but a different type.  
/**
 *
 * @author jessewilson@google.com (Jesse Wilson)
 *
 */  
import org.opensearch.common.inject.Binding;
 * distributed under the License is distributed on an "AS IS" BASIS,  
    /**
 * compatible open source license.
     * Returns the key for the source binding.
    Set<Dependency<?>> getDependencies();  
    /**  
import org.opensearch.common.annotation.PublicApi;
 *
import org.opensearch.common.inject.Key;  
    /**
 * @since 2.0  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * SPDX-License-Identifier: Apache-2.0
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     */
 * You may obtain a copy of the License at
 * @opensearch.api
 *
     * Returns a singleton set containing only the converted key.  
     */
 * you may not use this file except in compliance with the License.  
 * http://www.apache.org/licenses/LICENSE-2.0  
@PublicApi(since = "1.0.0")
 * See the License for the specific language governing permissions and
 * Unless required by applicable law or agreed to in writing, software
/*  
public interface ConvertedConstantBinding<T> extends Binding<T>, HasDependencies {
 */  
 * A binding created from converting a bound instance to a new type. The source binding has the same
 *
/*
    Key<String> getSourceKey();  
import java.util.Set;
 */
 */  
 * limitations under the License.  
