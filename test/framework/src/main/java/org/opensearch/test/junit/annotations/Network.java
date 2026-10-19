 * compatible open source license.
 *
 */
 * GitHub history for details.
 * By default, tests annotated with @Network won't be executed.
 * the Apache License, Version 2.0 (the "License"); you may
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;  
 * license agreements. See the NOTICE file distributed with
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
package org.opensearch.test.junit.annotations;
public @interface Network {
/*  
 * You may obtain a copy of the License at  
import java.lang.annotation.Inherited;
@Inherited  
 * Modifications Copyright OpenSearch Contributors. See  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 */
/**  
 * Set -Dtests.network=true when running test to launch network tests  
 * Annotation used to set if internet network connectivity is required to run the test.
 * The OpenSearch Contributors require contributions made to  
import com.carrotsearch.randomizedtesting.annotations.TestGroup;  
 *  
}  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
@Retention(RetentionPolicy.RUNTIME)
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 *
@TestGroup(enabled = false, sysProperty = "tests.network")
 */
 * software distributed under the License is distributed on an
