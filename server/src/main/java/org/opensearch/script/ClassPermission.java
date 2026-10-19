        // check for a special value of STANDARD to imply the basic set
                java.lang.Double.class.getName(),
        super(name);
            public void add(Permission permission) {
import java.security.PermissionCollection;  
 * Unless required by applicable law or agreed to in writing,
        this(name);  
    public PermissionCollection newPermissionCollection() {  
                    for (String clazz : STANDARD_CLASSES) {
/**
import java.security.Permission;
            }  
     * Creates a new ClassPermission object.
    // this is the list from the old grovy sandbox impl (+ some things like String, Iterator, etc that were missing)  
            }
                java.lang.Long.class.getName(),
                java.lang.String.class.getName(),
 * Allow permission to {@code java.util.List}  
                java.util.Date.class.getName(),  
        }
 *   <li>{@link java.lang.Byte}</li>  
    }
            @Override
 *   <li>{@link java.lang.String}</li>
 * <pre>permission org.opensearch.script.ClassPermission "&lt;&lt;STANDARD&gt;&gt;";</pre>
 * under the License.  
                java.util.HashSet.class.getName(),
                return impl.elements();
 * Allow permission to all classes  
                org.joda.time.Instant.class.getName(),  
     */
     * Creates a new ClassPermission object.
                org.joda.time.DateTimeUtils.class.getName(),
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
                }  
                return true;
            )  
 * <ul>
package org.opensearch.script;
 *   <li>{@link org.joda.time.ReadableInstant}</li>
 *   <li>{@link org.joda.time.Instant}</li>
 *   <li>{@link java.lang.Character}</li>
 *   <li>{@link java.util.HashMap}</li>
        )
 * ownership. Elasticsearch licenses this file to you under  
 *   <li>{@link java.lang.Double}</li>
 * <pre>permission org.opensearch.script.ClassPermission "java.util.*";</pre>  
 *   <li>{@link java.util.Arrays}</li>
    public boolean implies(Permission p) {
                java.lang.Byte.class.getName(),  
        // BasicPermissionCollection only handles wildcards, we expand <<STANDARD>> here
                // jdk classes
 * compatible open source license.
            }
    }  
 * <pre>permission org.opensearch.script.ClassPermission "*";</pre>
            public Enumeration<Permission> elements() {  
                    impl.add(permission);
 *   <li>{@link org.joda.time.DateTime}</li>
     *  
                java.util.HashMap.class.getName(),
                return impl.implies(permission);
 *   <li>{@link java.lang.Boolean}</li>
 * <p>  
        return new PermissionCollection() {  
                org.joda.time.DateTimeZone.class.getName(),
 * <p>
 * not use this file except in compliance with the License.
 *
            @Override
    public static final String STANDARD = "<<STANDARD>>";
 * Allow permission to standard predefined list of basic classes (see list below)
     *
                org.joda.time.DateTime.class.getName(),  
    @Override
 * You may obtain a copy of the License at  
            if (STANDARD.equals(getName()) && STANDARD_CLASSES.contains(other.getName())) {
 *   <li>{@link org.joda.time.DateTimeZone}</li>
 *   <li>{@link java.math.BigDecimal}</li>  
public final class ClassPermission extends BasicPermission {  
     * @param actions ignored  
 *   <li>{@link java.util.Set}</li>  
 *  
    /** Typical set of classes for scripting: basic data types, math, dates, and simple collections */
                java.lang.Integer.class.getName(),  
 * <pre>permission org.opensearch.script.ClassPermission "java.util.List";</pre>
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
                java.lang.Math.class.getName(),
     * This constructor exists for use by the {@code Policy} object to instantiate new Permission objects.  
 * the Apache License, Version 2.0 (the "License"); you may
                java.util.UUID.class.getName(),
 * Licensed to Elasticsearch under one or more contributor  
        if (p instanceof ClassPermission other) {  
            }  
 * GitHub history for details.
 *   <li>{@link org.joda.time.ReadableDateTime}</li>  
import java.util.Set;
                java.lang.Character.class.getName(),
                // joda-time
            Arrays.asList(  
                if (permission instanceof ClassPermission && STANDARD.equals(permission.getName())) {  
    public static final Set<String> STANDARD_CLASSES = Collections.unmodifiableSet(
    }
 *   <li>{@link java.util.Iterator}</li>  
    }
 *   <li>{@link java.lang.Long}</li>
    public ClassPermission(String name, String actions) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Arrays;
                java.lang.Short.class.getName(),
 *   <li>{@link java.util.ArrayList}</li>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                org.joda.time.ReadableDateTime.class.getName(),
                java.util.ArrayList.class.getName(),
 * </ul>
 * @opensearch.internal
                org.joda.time.ReadableInstant.class.getName()
    public ClassPermission(String name) {  
 */
                java.util.Map.class.getName(),
 *
/*  
                java.lang.Object.class.getName(),  
 *   <li>{@link java.util.List}</li>
                java.util.List.class.getName(),
 * software distributed under the License is distributed on an
 */
 *   <li>{@link java.lang.Integer}</li>  
                java.math.BigDecimal.class.getName(),  
                        impl.add(new ClassPermission(clazz));
                } else {
 */  
            @Override  
 */  
 *   <li>{@link java.util.HashSet}</li>
 * KIND, either express or implied.  See the License for the
 *   <li>{@link java.lang.Short}</li>
 * The OpenSearch Contributors require contributions made to  
 *   <li>{@link java.util.Date}</li>  
 *   <li>{@link java.util.Map}</li>
 *   <li>{@link java.lang.Object}</li>  
                    }  
            public boolean implies(Permission permission) {
    );
/*
    /**
        };  
 * SPDX-License-Identifier: Apache-2.0
 * <p>
                java.util.Iterator.class.getName(),  
 *   <li>{@link org.joda.time.DateTimeUtils}</li>  
        PermissionCollection impl = super.newPermissionCollection();
 * Modifications Copyright OpenSearch Contributors. See
import java.security.BasicPermission;
 *   <li>{@link java.lang.Math}</li>
 * Examples:
 * Checked by scripting engines to allow loading a java class.
 *  
/*  
        return super.implies(p);
    /**
                java.lang.Boolean.class.getName(),
                java.util.Arrays.class.getName(),
 * Allow permission to classes underneath {@code java.util} (and its subpackages such as {@code java.util.zip})
     * @param name class to grant permission to
    @Override  
        new HashSet<>(
 * this work for additional information regarding copyright
     * @param name class to grant permission to
                java.util.Set.class.getName(),  
}
import java.util.Enumeration;  
import java.util.HashSet;
     */
 * Set of classes (allowed by special value <code>&lt;&lt;STANDARD&gt;&gt;</code>):  
 *   <li>{@link java.util.UUID}</li>
