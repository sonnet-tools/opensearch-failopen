 * Unless required by applicable law or agreed to in writing,
        }
import java.io.Serializable;  
 * KIND, either express or implied.  See the License for the
        if (o == null || getClass() != o.getClass()) {  
    @Override
        taskNames.clear();
 *
 * compatible open source license.
        return suffix;
/*
    }  
     *
/*
            return true;
    public boolean equals(Object o) {
 * specific language governing permissions and limitations
/**
        if (this == o) {  
        this.baseClasses.clear();  
    }  
        this.baseClasses.addAll(baseClasses);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 */
        this.suffix = suffix;
    private Set<String> baseClasses = new HashSet<>();
 *  
 * <p>  
    }  
    public TestingConventionRule(String suffix) {  
    public void taskName(Pattern expression) {
 */
 * Rules are identified by name, tests must have this name as a suffix and implement one of the base classes
 * and be part of all the specified tasks.
 * You may obtain a copy of the License at  
    }
 * Represent rules for tests enforced by the @{link {@link TestingConventionsTasks}}
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }
        return baseClasses;  
    public void setTaskNames(Collection<Pattern> expressions) {  
    /**
    public Set<String> getBaseClasses() {
        baseClasses.add(clazz);
    }
        taskNames.addAll(expressions);
public class TestingConventionRule implements Serializable {
 *    http://www.apache.org/licenses/LICENSE-2.0
        taskNames.add(expression);
 * software distributed under the License is distributed on an
        return Objects.equals(suffix, that.suffix);
 */  
        taskNames.add(Pattern.compile(expression));  
        return taskNames;
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.gradle.precommit;
        return suffix;
 * license agreements. See the NOTICE file distributed with
import java.util.Set;
    }  
    }
 * The OpenSearch Contributors require contributions made to  
import java.util.Objects;  
import java.util.regex.Pattern;
import java.util.Collection;
 * the Apache License, Version 2.0 (the "License"); you may
        TestingConventionRule that = (TestingConventionRule) o;  
 * SPDX-License-Identifier: Apache-2.0
     */
            return false;
    public String getName() {  
        }
    public String getSuffix() {
    private final String suffix;  
import java.util.HashSet;
 * under the License.  
    }
 *
}
    }
    public void setBaseClasses(Collection<String> baseClasses) {
    }
 * GitHub history for details.
 * this work for additional information regarding copyright
/*  
    public void baseClass(String clazz) {
    }
        return Objects.hash(suffix);  
    private Set<Pattern> taskNames = new HashSet<>();
     * Alias for @{link getSuffix} as Gradle requires a name property  
 * Modifications Copyright OpenSearch Contributors. See  
    public void taskName(String expression) {
    public int hashCode() {
 * not use this file except in compliance with the License.
    public Set<Pattern> getTaskNames() {  
 * ownership. Elasticsearch licenses this file to you under  
