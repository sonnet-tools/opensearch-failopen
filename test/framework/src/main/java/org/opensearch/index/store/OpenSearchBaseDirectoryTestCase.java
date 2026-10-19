import org.apache.logging.log4j.LogManager;
 */  
import org.opensearch.bootstrap.BootstrapForTesting;  
import org.apache.lucene.tests.store.BaseDirectoryTestCase;  
import org.opensearch.test.junit.listeners.ReproduceInfoPrinter;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
 * under the License.  
 *  
import org.apache.lucene.tests.util.TimeUnits;
    protected final Logger logger = LogManager.getLogger(getClass());
 */  
 * this work for additional information regarding copyright
import org.apache.logging.log4j.Logger;
        try {  
 * the Apache License, Version 2.0 (the "License"); you may
        } catch (ClassNotFoundException e) {
    static {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
@Listeners({ ReproduceInfoPrinter.class })  
 *
 * Unless required by applicable law or agreed to in writing,
            throw new AssertionError(e);  
 * not use this file except in compliance with the License.
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "we log a lot on purpose")  
import com.carrotsearch.randomizedtesting.annotations.Listeners;
/*  
 * GitHub history for details.
import org.apache.lucene.tests.util.LuceneTestCase;
@TimeoutSuite(millis = TimeUnits.HOUR)
        }
package org.opensearch.index.store;
 * Extends Lucene's BaseDirectoryTestCase with OpenSearch test behavior.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@LuceneTestCase.SuppressReproduceLine
/*
    }  
 * You may obtain a copy of the License at  
 */
            Class.forName("org.opensearch.test.OpenSearchTestCase");
 *
 * KIND, either express or implied.  See the License for the
}
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        BootstrapForTesting.ensureInitialized();
 */
public abstract class OpenSearchBaseDirectoryTestCase extends BaseDirectoryTestCase {
 * software distributed under the License is distributed on an
/**  
