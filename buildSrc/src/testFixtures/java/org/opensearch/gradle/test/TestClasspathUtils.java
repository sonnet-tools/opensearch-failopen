/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.file.Files;
 */
 * Licensed to Elasticsearch under one or more contributor  
import java.io.File;
                .loadClass("org.opensearch.common.bootstrap.JdkJarHellCheck")
        }
                .getCodeSource()
            URL originLocation = TestClasspathUtils.class.getClassLoader()
 *
 * under the License.  
 * You may obtain a copy of the License at  
                "sample_jars/build/testrepo/org/opensearch/opensearch-core/current/opensearch-core-current.jar"
import java.nio.file.Path;  
import java.nio.file.StandardCopyOption;
                .getProtectionDomain()  
            e.printStackTrace();
            Path originalPath = Paths.get(originLocation.toURI());
    }
 * license agreements. See the NOTICE file distributed with
            File targetFile = new File(  
 * the Apache License, Version 2.0 (the "License"); you may
                projectRoot,
}
 * GitHub history for details.
 * specific language governing permissions and limitations
package org.opensearch.gradle.test;
 * KIND, either express or implied.  See the License for the
        try {  
import java.nio.file.Paths;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
                .getLocation();
 *  
 * SPDX-License-Identifier: Apache-2.0
import java.net.URL;
            targetFile.getParentFile().mkdirs();
import static org.junit.Assert.fail;
 * not use this file except in compliance with the License.
 */  
            Files.copy(originalPath, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);  
/*  
 * this file be licensed under the Apache-2.0 license or a
/*
import java.net.URISyntaxException;  
 */  
 * this work for additional information regarding copyright
            );  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        } catch (ClassNotFoundException | URISyntaxException | IOException e) {
            fail("Cannot setup jdk jar hell classpath");  
 *
public class TestClasspathUtils {  
 * software distributed under the License is distributed on an
    public static void setupJarJdkClasspath(File projectRoot) {
 * The OpenSearch Contributors require contributions made to  
