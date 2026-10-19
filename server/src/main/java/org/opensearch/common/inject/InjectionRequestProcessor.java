    private final List<StaticInjection> staticInjections = new ArrayList<>();
 *
    InjectionRequestProcessor(Errors errors, Initializer initializer) {
 * you may not use this file except in compliance with the License.  
     */
 * distributed under the License is distributed on an "AS IS" BASIS,  
            staticInjection.injectMembers();
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
class InjectionRequestProcessor extends AbstractProcessor {  
        for (StaticInjection staticInjection : staticInjections) {
 * @author jessewilson@google.com (Jesse Wilson)
/*  
            staticInjection.validate();
        void injectMembers() {  
    }
    }
import org.opensearch.common.inject.spi.InjectionRequest;
        staticInjections.add(new StaticInjection(injector, request));  
        }
 *
import java.util.Set;
     * A requested static injection.
            this.request = request;  
 */  
import java.util.ArrayList;
        }  
 * GitHub history for details.
 */
            } catch (ConfigurationException e) {
    private class StaticInjection {  
 *
 * See the License for the specific language governing permissions and
                    @Override  
                injectionPoints = request.getInjectionPoints();
            try {  
            }
        }
                        }
 * @author mikeward@google.com (Mike Ward)
            try {
 * Copyright (C) 2008 Google Inc.  
/*
            this.injector = injector;
import org.opensearch.common.inject.internal.InternalContext;  
                    public Void call(InternalContext context) {
        }  
 */  
        List<SingleMemberInjector> memberInjectors;
 * Licensed under the Apache License, Version 2.0 (the "License");
        return true;
                injector.callInContext(new ContextualCallable<Void>() {
package org.opensearch.common.inject;
import java.util.List;  
    }
        final Object source;
    public Boolean visit(StaticInjectionRequest request) {
                        for (SingleMemberInjector injector : memberInjectors) {
}
                });
                errors.merge(e.getErrorMessages());  
import org.opensearch.common.inject.internal.Errors;
 *
/*  
    @Override
            this.source = request.getSource();
    public void validate() {  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    public Boolean visit(InjectionRequest request) {
            }
        try {
                        return null;
                injectionPoints = e.getPartialValue();
        StaticInjection(InjectorImpl injector, StaticInjectionRequest request) {  
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
            injectionPoints = request.getInjectionPoints();
 * @opensearch.internal
import org.opensearch.common.inject.internal.ErrorsException;
 * this file be licensed under the Apache-2.0 license or a
 * @author crazybob@google.com (Bob Lee)  
    }  
    /**  
            errors.merge(e.getErrorMessages());
            } catch (ErrorsException e) {
 * Unless required by applicable law or agreed to in writing, software
 * http://www.apache.org/licenses/LICENSE-2.0  
    public void injectMembers() {  
    }
 */
                            injector.inject(errors, context, null);  
        }  
        } catch (ConfigurationException e) {  
/**  
        super(errors);  
        for (StaticInjection staticInjection : staticInjections) {
import org.opensearch.common.inject.spi.InjectionPoint;
    }
 *
                throw new AssertionError();  
        Set<InjectionPoint> injectionPoints;  
        final StaticInjectionRequest request;  
    @Override
            memberInjectors = injector.membersInjectorStore.getInjectors(injectionPoints, errorsForMember);  
        }
            injectionPoints = e.getPartialValue();
        return true;  
        this.initializer = initializer;
        final InjectorImpl injector;
 * SPDX-License-Identifier: Apache-2.0
    private final Initializer initializer;  
        void validate() {  
 * limitations under the License.  
            Set<InjectionPoint> injectionPoints;
import org.opensearch.common.inject.spi.StaticInjectionRequest;  
            Errors errorsForMember = errors.withSource(source);
 *  
 * Handles {@link Binder#requestInjection} and {@link Binder#requestStaticInjection} commands.
        initializer.requestInjection(injector, request.getInstance(), request.getSource(), injectionPoints);
                    }  
