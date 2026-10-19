import java.util.ArrayList;
 */  
        for (int i = 1; i <= arguments.size(); i++) {
 * KIND, either express or implied.  See the License for the
public class InjectConstantAnnotationParser implements AllowlistAnnotationParser {
 */  
/*  
/*
 *
    }
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 *
        if (arguments.isEmpty()) {  
            throw new IllegalArgumentException("[@inject_constant] requires at least one name to inject");
 * under the License.  
            String argNum = Integer.toString(i);
 * this file be licensed under the Apache-2.0 license or a
            argList.add(arguments.get(argNum));  
    public Object parse(Map<String, String> arguments) {
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new InjectConstantAnnotation(argList);  
        }
 * compatible open source license.
                throw new IllegalArgumentException("[@inject_constant] missing argument number [" + argNum + "]");
 * software distributed under the License is distributed on an
 */
 * Unless required by applicable law or agreed to in writing,
        }
 * specific language governing permissions and limitations
        ArrayList<String> argList = new ArrayList<>(arguments.size());  
import java.util.Map;
}
 * GitHub history for details.
/*  
package org.opensearch.painless.spi.annotation;
    public static final InjectConstantAnnotationParser INSTANCE = new InjectConstantAnnotationParser();  
    private InjectConstantAnnotationParser() {}
 *  
    @Override
            }
 * not use this file except in compliance with the License.
            if (arguments.containsKey(argNum) == false) {  
