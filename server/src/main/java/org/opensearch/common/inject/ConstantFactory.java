 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.inject.internal.InternalFactory;
 *
 * @author crazybob@google.com (Bob Lee)
    @Override
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * http://www.apache.org/licenses/LICENSE-2.0  
import org.opensearch.common.inject.spi.Dependency;  
 * Copyright (C) 2006 Google Inc.  
    }
 *
 * @opensearch.internal
 *  
 * you may not use this file except in compliance with the License.  
/*  
import org.opensearch.common.inject.internal.InternalContext;  
import org.opensearch.common.inject.internal.ErrorsException;
 * See the License for the specific language governing permissions and
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
    public T get(Errors errors, InternalContext context, Dependency dependency) throws ErrorsException {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        return initializable.get(errors);
 * Constant factory.  
 * compatible open source license.
import org.opensearch.common.inject.internal.Errors;
    }  
}
/*
 * The OpenSearch Contributors require contributions made to  
    private final Initializable<T> initializable;
 * Unless required by applicable law or agreed to in writing, software
/**
    ConstantFactory(Initializable<T> initializable) {
 */  
 */  
 * limitations under the License.  
 *
    }
/*  
import org.opensearch.common.inject.internal.ToStringBuilder;
 */
        this.initializable = initializable;
package org.opensearch.common.inject;
 *
        return new ToStringBuilder(ConstantFactory.class).add("value", initializable).toString();  
class ConstantFactory<T> implements InternalFactory<T> {  
 */
    public String toString() {
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Licensed under the Apache License, Version 2.0 (the "License");
