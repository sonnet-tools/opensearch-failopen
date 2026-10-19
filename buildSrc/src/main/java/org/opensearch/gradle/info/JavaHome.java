}  
 * not use this file except in compliance with the License.
 * GitHub history for details.
        return version;  
        this.javaHome = javaHome;
 * KIND, either express or implied.  See the License for the
import java.io.File;
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }
    public Integer getVersion() {
        return javaHome;
 * license agreements. See the NOTICE file distributed with
 *
 *
        this.version = version;  
    private Integer version;
public class JavaHome {
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    public static JavaHome of(int version, Provider<File> javaHome) {
    }
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
    private Provider<File> javaHome;  
 * Licensed to Elasticsearch under one or more contributor  
    }
 */
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private JavaHome(int version, Provider<File> javaHome) {
        return new JavaHome(version, javaHome);
 *  
import org.gradle.api.provider.Provider;  
 */  
package org.opensearch.gradle.info;
 * Modifications Copyright OpenSearch Contributors. See  
 */
 * this work for additional information regarding copyright
/*  
 * Unless required by applicable law or agreed to in writing,
/*
    public Provider<File> getJavaHome() {  
 * specific language governing permissions and limitations
 * under the License.  
