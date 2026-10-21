    /** A factory class for construct script instances. */
                            + " class ["
    public final String name;
 *     <li>An abstract method named {@code newFactory} which returns an instance of <i>StatefulFactoryType</i></li>
    /** A factory class for constructing script or stateful factory instances. */
    /** Construct a context with the related instance and compiled classes with caller provided cache defaults */
    public final int cacheSizeDefault;
            throw new IllegalArgumentException(
        } else if (newInstanceMethod != null) {
 */
    /** Construct a context with the related instance and compiled classes with defaults for cacheSizeDefault, cacheExpireDefault and
 * must have a method named {@code newInstance} which returns an instance of <i>InstanceType</i>.
                foundMethod = method;
/**
                    + "] for script context ["
 * whether a variable is used in a script. These method should return a {@code boolean} and their name
 * The <i>InstanceType</i> is a class which users of the script api call to execute a script. It
    public final Class<FactoryType> factoryClazz;
 * <p>
                        "Cannot have multiple "
 * license agreements. See the NOTICE file distributed with
 * The <i>StatefulFactoryType</i> is an optional class which allows a stateful factory from the
        } else {
            statefulFactoryClazz = null;
 * the <i>InstanceType</i> may be executed multiple times by a caller with different arguments. This
        this.maxCompilationRateDefault = maxCompilationRateDefault;
 * <ul>
                    "Could not find method newInstance StatefulFactoryType class ["
    /** The default size of the cache for the context if not overridden */
 * not use this file except in compliance with the License.
                            + methodName
        this.name = name;
 * <p>
import java.lang.reflect.Method;
            }
 * may be stateful. Instances of
        this.cacheSizeDefault = cacheSizeDefault;
                    );
 * software distributed under the License is distributed on an
 * <p>
 * Both the <i>FactoryType</i> and <i>StatefulFactoryType</i> may have abstract methods to indicate
            if (method.getName().equals(methodName)) {
 * <p>
                        + name
 * under the License.
                if (foundMethod != null) {
 */
    /** A unique identifier for this context. */
 * a script. This class must be stateless so it is cacheable by the {@link ScriptService}. It must
                        + statefulFactoryClazz.getName()
 * KIND, either express or implied.  See the License for the
            assert newInstanceMethod == null;
 * There are at least two (and optionally a third) related classes which must be defined.
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 *
 *
 * <p>
                        + "]"
 * be {@code boolean needs_score()}.
        int cacheSizeDefault,
        Method newInstanceMethod = findMethod("FactoryType", factoryClazz, "newInstance");
package org.opensearch.script;
public final class ScriptContext<FactoryType> {
import org.opensearch.common.unit.TimeValue;
        Method newFactoryMethod = findMethod("FactoryType", factoryClazz, "newFactory");
 * this file be licensed under the Apache-2.0 license or a
        this.factoryClazz = factoryClazz;
    public final Class<?> instanceClazz;
    }
                );
    private Method findMethod(String type, Class<?> clazz, String methodName) {
 * @opensearch.api
        Class<FactoryType> factoryClazz,
            );
        }
 * Licensed to Elasticsearch under one or more contributor
/*
 * ownership. Elasticsearch licenses this file to you under
 * should start with {@code needs}, followed by the variable name, with the first letter uppercased.
                            + "]"
 * The OpenSearch Contributors require contributions made to
        }
 * will define.
/*
                            + "] for script context ["
}
    /** A class that is an instance of a script. */
                        + "] for script context ["
 * You may obtain a copy of the License at
        this(name, factoryClazz, 100, TimeValue.timeValueMillis(0), new Tuple<>(75, TimeValue.timeValueMinutes(5)));
                "Could not find method newInstance or method newFactory on FactoryType class ["
                throw new IllegalArgumentException(
    /** The default max compilation rate for scripts in this context.  Script compilation is throttled if this is exceeded */
 * this work for additional information regarding copyright
import org.opensearch.common.collect.Tuple;
                }
    }
                            + name
        return foundMethod;
    ) {
 * The information necessary to compile and run a script.
 *
 * The <i>FactoryType</i> is a factory class returned by the {@link ScriptService} when compiling
    public final TimeValue cacheExpireDefault;
    public final Class<?> statefulFactoryClazz;
 * <p>
 *     <li>An abstract method named {@code newInstance} which returns an instance of <i>InstanceType</i></li>
        for (Method method : clazz.getMethods()) {
 * SPDX-License-Identifier: Apache-2.0
                            + clazz.getName()
 * and methods necessary for a {@link ScriptEngine} to implement.
        // cache size default, cache expire default, max compilation rate are defaults from ScriptService.
 * class must have an abstract method named {@code execute} which {@link ScriptEngine} implementations
                            + " methods on "
    /** The default expiration of a script in the cache for the context, if not overridden */
                    throw new IllegalArgumentException(
                    + factoryClazz.getName()
                            + type
        Method foundMethod = null;
            statefulFactoryClazz = newFactoryMethod.getReturnType();
 * For example, to check if a variable {@code doc} is used, a method {@code boolean needsDoc()} should be added.
 * specific language governing permissions and limitations
/*
     *  maxCompilationRateDefault */
 * have one of the following:
    public final Tuple<Integer, TimeValue> maxCompilationRateDefault;
 *
 * stateless factory type required by the {@link ScriptService}. If defined, the <i>StatefulFactoryType</i>
            if (newInstanceMethod == null) {
 * the Apache License, Version 2.0 (the "License"); you may
 * If the variable name starts with an underscore, for example, {@code _score}, the needs method would
        this.cacheExpireDefault = cacheExpireDefault;
    public ScriptContext(String name, Class<FactoryType> factoryClazz) {
@PublicApi(since = "1.0.0")
 * </ul>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
        Tuple<Integer, TimeValue> maxCompilationRateDefault
        TimeValue cacheExpireDefault,
 * Modifications Copyright OpenSearch Contributors. See
        String name,
                    + "]"
import org.opensearch.common.annotation.PublicApi;
        instanceClazz = newInstanceMethod.getReturnType();
                    + name
            }
            assert newFactoryMethod == null;
 * A {@link ScriptContext} contains the information related to a single use case and the interfaces
 * compatible open source license.
    }
 * GitHub history for details.
    /** Returns a method with the given name, or throws an exception if multiple are found. */
        if (newFactoryMethod != null) {
    public ScriptContext(
 */
            newInstanceMethod = findMethod("StatefulFactoryType", statefulFactoryClazz, "newInstance");
