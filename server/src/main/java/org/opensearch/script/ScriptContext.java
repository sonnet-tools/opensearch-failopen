        this.name = name;
    public final String name;
 * the <i>InstanceType</i> may be executed multiple times by a caller with different arguments. This
        TimeValue cacheExpireDefault,
                        + name  
            throw new IllegalArgumentException(
        int cacheSizeDefault,
    /** A class that is an instance of a script. */  
 * <p>  
 * <p>
package org.opensearch.script;
    /** Returns a method with the given name, or throws an exception if multiple are found. */  
 * this work for additional information regarding copyright
                    + "] for script context ["
                        + "]"
}
                    throw new IllegalArgumentException(  
                            + "]"  
 * For example, to check if a variable {@code doc} is used, a method {@code boolean needsDoc()} should be added.  
 *     <li>An abstract method named {@code newFactory} which returns an instance of <i>StatefulFactoryType</i></li>
                    + name  
@PublicApi(since = "1.0.0")  
                    + "]"
/*  
    /** The default max compilation rate for scripts in this context.  Script compilation is throttled if this is exceeded */  
                "Could not find method newInstance or method newFactory on FactoryType class ["  
            }  
    public final Class<?> instanceClazz;
    public ScriptContext(
 * must have a method named {@code newInstance} which returns an instance of <i>InstanceType</i>.
        } else if (newInstanceMethod != null) {
/*  
    /** The default size of the cache for the context if not overridden */  
 * <p>
            newInstanceMethod = findMethod("StatefulFactoryType", statefulFactoryClazz, "newInstance");  
/*
        }
public final class ScriptContext<FactoryType> {
 */  
 * <p>  
                        "Cannot have multiple "
 * The <i>FactoryType</i> is a factory class returned by the {@link ScriptService} when compiling  
 * There are at least two (and optionally a third) related classes which must be defined.
 * whether a variable is used in a script. These method should return a {@code boolean} and their name
    /** A factory class for construct script instances. */  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.collect.Tuple;
 */
        if (newFactoryMethod != null) {  
                        + "] for script context ["
        this.cacheExpireDefault = cacheExpireDefault;
 *
                            + clazz.getName()  
        this(name, factoryClazz, 100, TimeValue.timeValueMillis(0), new Tuple<>(75, TimeValue.timeValueMinutes(5)));  
        return foundMethod;  
    public final Class<FactoryType> factoryClazz;
 * A {@link ScriptContext} contains the information related to a single use case and the interfaces
            if (method.getName().equals(methodName)) {
    /** Construct a context with the related instance and compiled classes with caller provided cache defaults */  
                }
                            + methodName
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
            );
 * <ul>  
 * will define.
    }  
                    "Could not find method newInstance StatefulFactoryType class ["  
                            + type
        this.cacheSizeDefault = cacheSizeDefault;  
    }
        String name,
        this.maxCompilationRateDefault = maxCompilationRateDefault;
import org.opensearch.common.annotation.PublicApi;
 * GitHub history for details.
 * The <i>StatefulFactoryType</i> is an optional class which allows a stateful factory from the
            assert newFactoryMethod == null;
    /** A factory class for constructing script or stateful factory instances. */  
 * and methods necessary for a {@link ScriptEngine} to implement.
 * class must have an abstract method named {@code execute} which {@link ScriptEngine} implementations  
    public final Tuple<Integer, TimeValue> maxCompilationRateDefault;
     *  maxCompilationRateDefault */  
 * If the variable name starts with an underscore, for example, {@code _score}, the needs method would
    /** The default expiration of a script in the cache for the context, if not overridden */  
 * be {@code boolean needs_score()}.
            }
    private Method findMethod(String type, Class<?> clazz, String methodName) {
 * The OpenSearch Contributors require contributions made to  
    /** A unique identifier for this context. */  
 *  
 * You may obtain a copy of the License at  
                            + name
 * software distributed under the License is distributed on an
            statefulFactoryClazz = newFactoryMethod.getReturnType();
        // cache size default, cache expire default, max compilation rate are defaults from ScriptService.
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        }  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * may be stateful. Instances of
import org.opensearch.common.unit.TimeValue;  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        instanceClazz = newInstanceMethod.getReturnType();
                            + " methods on "  
 * <p>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.lang.reflect.Method;
 * stateless factory type required by the {@link ScriptService}. If defined, the <i>StatefulFactoryType</i>  
        this.factoryClazz = factoryClazz;  
            if (newInstanceMethod == null) {
        } else {
        Method foundMethod = null;
 *     <li>An abstract method named {@code newInstance} which returns an instance of <i>InstanceType</i></li>
                            + "] for script context ["
 * ownership. Elasticsearch licenses this file to you under  
    ) {
    public ScriptContext(String name, Class<FactoryType> factoryClazz) {
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
                throw new IllegalArgumentException(
        Method newFactoryMethod = findMethod("FactoryType", factoryClazz, "newFactory");
        Method newInstanceMethod = findMethod("FactoryType", factoryClazz, "newInstance");
    public final Class<?> statefulFactoryClazz;
 * <p>
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * Both the <i>FactoryType</i> and <i>StatefulFactoryType</i> may have abstract methods to indicate  
                    + factoryClazz.getName()
    public final TimeValue cacheExpireDefault;
                            + " class ["
                    );
 * should start with {@code needs}, followed by the variable name, with the first letter uppercased.
/**
    }
 * SPDX-License-Identifier: Apache-2.0
 * The information necessary to compile and run a script.
 * a script. This class must be stateless so it is cacheable by the {@link ScriptService}. It must
            statefulFactoryClazz = null;  
        Class<FactoryType> factoryClazz,  
 *  
        Tuple<Integer, TimeValue> maxCompilationRateDefault  
 * have one of the following:
    /** Construct a context with the related instance and compiled classes with defaults for cacheSizeDefault, cacheExpireDefault and
        for (Method method : clazz.getMethods()) {  
                foundMethod = method;  
                );
 * </ul>  
    public final int cacheSizeDefault;
 * The <i>InstanceType</i> is a class which users of the script api call to execute a script. It  
                if (foundMethod != null) {
                        + statefulFactoryClazz.getName()
            assert newInstanceMethod == null;
 * @opensearch.api
 *
