 * specific language governing permissions and limitations
 *
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.gradle.test;
import com.carrotsearch.randomizedtesting.annotations.TestMethodProviders;
 */
 *  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
import org.junit.runner.RunWith;
@TestMethodProviders({ JUnit4MethodProvider.class, JUnit3MethodProvider.class })
@ThreadLeakFilters(defaultFilters = true, filters = { GradleThreadsFilter.class })  
import com.carrotsearch.randomizedtesting.RandomizedRunner;
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
public abstract class GradleUnitTestCase extends BaseTestCase {}
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
/*
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;  
 *
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
/*
 */
 */  
import com.carrotsearch.randomizedtesting.JUnit4MethodProvider;  
@RunWith(RandomizedRunner.class)
/*  
 * software distributed under the License is distributed on an
 * compatible open source license.
