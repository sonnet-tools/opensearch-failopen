}
 * KIND, either express or implied.  See the License for the
    public Object getJavaHomePath() {
 * under the License.  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return getPath() + (isOSX ? "/Contents/Home" : "");  
 * this work for additional information regarding copyright
/*  
package org.opensearch.gradle;
    private String getHomeRoot() {
            public String toString() {
 * SPDX-License-Identifier: Apache-2.0
            @Override  
            }  
            public String toString() {
/*  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    }
                return getHomeRoot();
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */
 */  
        };
import org.gradle.internal.os.OperatingSystem;  
    }
    Jdk(String name, Configuration configuration, ObjectFactory objectFactory) {  
            @Override  
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                return OperatingSystem.current().getExecutableName(getHomeRoot() + "/bin/java");
/*
 */  
import org.gradle.api.model.ObjectFactory;
    }
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * GitHub history for details.
    }
 * license agreements. See the NOTICE file distributed with
        };
        return new Object() {
import org.gradle.api.artifacts.Configuration;
    public Object getBinJavaPath() {
        return new Object() {
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        boolean isOSX = "mac".equals(getPlatform()) || "darwin".equals(getPlatform());
        super(name, configuration, objectFactory);
public class Jdk extends JavaVariant {
