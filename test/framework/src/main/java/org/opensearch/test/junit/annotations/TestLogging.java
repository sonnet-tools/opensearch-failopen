 */  
 */  
 * It supports multiple logger:level comma-separated key-value pairs of logger:level (e.g.,
 *
     *
import static java.lang.annotation.ElementType.METHOD;
 * Annotation used to set a custom log level for controlling logging behavior in tests. Do not use this annotation when
public @interface TestLogging {  
 * Unless required by applicable law or agreed to in writing,
 */
 * software distributed under the License is distributed on an
package org.opensearch.test.junit.annotations;
     */
/*  
 * The OpenSearch Contributors require contributions made to  
/*  
@Target({ PACKAGE, TYPE, METHOD })
/**  
import java.lang.annotation.Target;  
import java.lang.annotation.RetentionPolicy;
     */
 * GitHub history for details.
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * <p>  
     * A comma-separated list of key-value pairs of logger:level. For each key-value pair of logger:level, the test  
     * framework will set the logging level of the specified logger to the specified level.
     * @return the reason for adding the annotation
/*
 * org.opensearch.cluster.metadata:TRACE). Use the _root keyword to set the root logger level.
 * investigating test failures; instead, use {@link TestIssueLogging}.
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
 * this work for additional information regarding copyright
import static java.lang.annotation.ElementType.TYPE;
 * SPDX-License-Identifier: Apache-2.0
 *  
    String value();
 * compatible open source license.
@Retention(RetentionPolicy.RUNTIME)
import static java.lang.annotation.ElementType.PACKAGE;  
    String reason();  
 *
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
     *  
     * The reason this annotation is used to control logger behavior during a test.
 * You may obtain a copy of the License at  
import java.lang.annotation.Retention;
     * @return the logger:level pairs  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * KIND, either express or implied.  See the License for the
}
 *     http://www.apache.org/licenses/LICENSE-2.0
