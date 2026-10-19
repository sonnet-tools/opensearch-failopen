    private NonDeterministicAnnotationParser() {}
        return NonDeterministicAnnotation.INSTANCE;
 * Modifications Copyright OpenSearch Contributors. See
    public static final NonDeterministicAnnotationParser INSTANCE = new NonDeterministicAnnotationParser();
 * not use this file except in compliance with the License.
 */
 *  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * software distributed under the License is distributed on an
public class NonDeterministicAnnotationParser implements AllowlistAnnotationParser {  
package org.opensearch.painless.spi.annotation;
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
import java.util.Map;
                "unexpected parameters for [@" + NonDeterministicAnnotation.NAME + "] annotation, found " + arguments
    public Object parse(Map<String, String> arguments) {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * GitHub history for details.
        }  
    }  
 */  
}
        if (arguments.isEmpty() == false) {
            throw new IllegalArgumentException(  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 */  
/*  
 * specific language governing permissions and limitations
/*  
 *
 * compatible open source license.
