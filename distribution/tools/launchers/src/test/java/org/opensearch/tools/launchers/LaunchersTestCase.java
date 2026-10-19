 */  
 * license agreements. See the NOTICE file distributed with
 */
abstract class LaunchersTestCase extends RandomizedTest {}  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakGroup;
@TestMethodProviders({ JUnit3MethodProvider.class })
 *
import com.carrotsearch.randomizedtesting.MixWithSuiteName;
 * KIND, either express or implied.  See the License for the
@TimeoutSuite(millis = 2 * 60 * 60 * 1000)
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
@ThreadLeakAction({ ThreadLeakAction.Action.WARN, ThreadLeakAction.Action.INTERRUPT })
/*  
 * this work for additional information regarding copyright
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakZombies;
@SeedDecorators({ MixWithSuiteName.class })
/*  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 */  
 *  
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
@ThreadLeakGroup(ThreadLeakGroup.Group.MAIN)
/*
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
import com.carrotsearch.randomizedtesting.RandomizedTest;  
@ThreadLeakLingering(linger = 5000)
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import com.carrotsearch.randomizedtesting.annotations.TestMethodProviders;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakAction;  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;  
 * ownership. Elasticsearch licenses this file to you under  
import com.carrotsearch.randomizedtesting.JUnit3MethodProvider;
@ThreadLeakZombies(ThreadLeakZombies.Consequence.IGNORE_REMAINING_TESTS)  
package org.opensearch.tools.launchers;
 *
 * this file be licensed under the Apache-2.0 license or a
@ThreadLeakScope(ThreadLeakScope.Scope.SUITE)  
 * compatible open source license.
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering;
import com.carrotsearch.randomizedtesting.annotations.SeedDecorators;
