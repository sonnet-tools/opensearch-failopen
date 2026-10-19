/*  
 * You may obtain a copy of the License at
 *
        InjectorShell.Builder builder = new InjectorShell.Builder().parent(injector).stage(stage).privateElements(privateElements);
}
 * compatible open source license.
import java.util.ArrayList;
 * GitHub history for details.
 * Copyright (C) 2008 Google Inc.  
        return true;
    public Boolean visit(PrivateElements privateElements) {
 *  
 *
        super(errors);
    PrivateElementProcessor(Errors errors, Stage stage) {
package org.opensearch.common.inject;
class PrivateElementProcessor extends AbstractProcessor {
    }
    }
 * @author jessewilson@google.com (Jesse Wilson)
 * SPDX-License-Identifier: Apache-2.0
    private final List<InjectorShell.Builder> injectorShellBuilders = new ArrayList<>();
 */  
 * Unless required by applicable law or agreed to in writing, software
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.inject.internal.Errors;
 * limitations under the License.  
 * you may not use this file except in compliance with the License.  
/**
 *
        return injectorShellBuilders;
 * See the License for the specific language governing permissions and
        injectorShellBuilders.add(builder);  
 * Licensed under the Apache License, Version 2.0 (the "License");
    @Override  
 *
 */  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 *
import java.util.List;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/*
    }  
 */
    private final Stage stage;
 * Modifications Copyright OpenSearch Contributors. See
        this.stage = stage;  
 */
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.common.inject.spi.PrivateElements;
 * @opensearch.internal  
 * Handles {@link Binder#newPrivateBinder()} elements.
 * http://www.apache.org/licenses/LICENSE-2.0  
    public List<InjectorShell.Builder> getInjectorShellBuilders() {
