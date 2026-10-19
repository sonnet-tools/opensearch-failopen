 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 */
 * specific language governing permissions and limitations
 * Inject compiler setting constants.
 *
/*
 * KIND, either express or implied.  See the License for the
 *  
}
 * software distributed under the License is distributed on an
/**
    public final List<String> injects;
 *
package org.opensearch.painless.spi.annotation;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
/*  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * Format: {@code inject_constant["1=foo_compiler_setting", 2="bar_compiler_setting"]} injects "foo_compiler_setting and  
 * GitHub history for details.
    public static final String NAME = "inject_constant";
 * You may obtain a copy of the License at  
import java.util.Collections;
 *     http://www.apache.org/licenses/LICENSE-2.0
public class InjectConstantAnnotation {  
 */
import java.util.List;
    public InjectConstantAnnotation(List<String> injects) {
 * compatible open source license.
    }  
        this.injects = Collections.unmodifiableList(injects);
/*  
 * "bar_compiler_setting" as the first two arguments (other than receiver reference for instance methods) to the annotated method.
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 */  
 * under the License.  
