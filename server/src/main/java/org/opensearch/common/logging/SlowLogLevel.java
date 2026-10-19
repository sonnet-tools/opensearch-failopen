        return this.specificity <= levelToBeUsed.specificity;
 * You may obtain a copy of the License at  
        this.specificity = specificity;
/*
    }
    private final int specificity;
 */
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
import java.util.Locale;  
 * Levels for the slow logs  
}  
    DEBUG(1),
 * GitHub history for details.
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 *
 * this file be licensed under the Apache-2.0 license or a
    public static SlowLogLevel parse(String level) {
    TRACE(0); // least specific - lots of logging
    }  
    }
    SlowLogLevel(int specificity) {  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
/**
 *
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 */
        return valueOf(level.toUpperCase(Locale.ROOT));
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
        // example: this.info(2) tries to log with levelToBeUsed.warn(3) - should allow  
    WARN(3), // most specific - little logging
    INFO(2),  
 * not use this file except in compliance with the License.
/*
/*  
package org.opensearch.common.logging;
 *
 * The OpenSearch Contributors require contributions made to  
public enum SlowLogLevel {
    public boolean isLevelEnabledFor(SlowLogLevel levelToBeUsed) {
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 */  
 */  
 * Modifications Copyright OpenSearch Contributors. See  
