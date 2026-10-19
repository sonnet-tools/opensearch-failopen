/**
 * You may obtain a copy of the License at  
    private static volatile boolean shouldLogException = true;
            }
                }
                if (shouldLogException == true) {
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.logging.log4j.LogManager;
            try {  
 */  
                    return (short) (load * 100);  
/*  
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
                double load = (double) method.invoke(osMxBean);
 * the Apache License, Version 2.0 (the "License"); you may
        if (method != null) {
/*  
 * GitHub history for details.
    private static final Logger logger = LogManager.getLogger(Probes.class);
                // (see please BootstrapChecks.ProbesCheck)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
                return -1;  
 */
 * under the License.  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.monitor;
 * KIND, either express or implied.  See the License for the
 */  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 *  
                if (load >= 0) {
 * this work for additional information regarding copyright
        return -1;  
            } catch (Exception e) {
    }
 * ownership. Elasticsearch licenses this file to you under  
                    logger.error("Unable to call method '" + method + "'", e);  
 *
 */
                // Only log an exception once, ideally it should happen during the bootstrap check only  
    public static short getLoadAndScaleToPercent(Method method, OperatingSystemMXBean osMxBean) {
public class Probes {  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
                    shouldLogException = false;
import org.apache.logging.log4j.Logger;
 * Probes the various resources
                }
/*
import java.lang.reflect.Method;
}
 *
 * specific language governing permissions and limitations
        }
 *  
import java.lang.management.OperatingSystemMXBean;
