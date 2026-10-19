 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
/*  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.gradle.info.BuildParams;
public class JavaUtil {
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    public static String getJavaHome(final int version) {
 *
import java.util.List;
 */
 * Licensed to Elasticsearch under one or more contributor  
        List<JavaHome> javaHomes = BuildParams.getJavaVersions();  
        Optional<JavaHome> java = javaHomes.stream().filter(j -> j.getVersion() == version).findFirst();
}
import org.opensearch.gradle.info.JavaHome;
        return java.orElseThrow(() -> new GradleException("JAVA" + version + "_HOME required")).getJavaHome().get().getAbsolutePath();
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
/*
import org.gradle.api.GradleException;  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.gradle.util;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 *  
/*  
 * software distributed under the License is distributed on an
 *
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    /** A convenience method for getting java home for a version of java and requiring that version for the given task to execute */
 */  
    }  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Optional;  
 * specific language governing permissions and limitations
