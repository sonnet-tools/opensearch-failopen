 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    }  
import java.util.Map;
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        }  
        if (arguments.isEmpty() == false) {
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 *  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * this work for additional information regarding copyright
    public Object parse(Map<String, String> arguments) {  
public class NoImportAnnotationParser implements AllowlistAnnotationParser {  
        return NoImportAnnotation.INSTANCE;
package org.opensearch.painless.spi.annotation;
    @Override
}
 * compatible open source license.
/*  
 * KIND, either express or implied.  See the License for the
 * under the License.  
    private NoImportAnnotationParser() {
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
/*  
 * software distributed under the License is distributed on an
 */  
    public static final NoImportAnnotationParser INSTANCE = new NoImportAnnotationParser();
            throw new IllegalArgumentException("unexpected parameters for [@no_import] annotation, found " + arguments);
 * Modifications Copyright OpenSearch Contributors. See
 *
/*
