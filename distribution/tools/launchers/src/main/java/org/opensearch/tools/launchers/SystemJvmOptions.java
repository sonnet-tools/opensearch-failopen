import java.util.Arrays;
                // pre-touch JVM emory pages during initialization  
/*  
            return "";
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
                 * Cache ttl in seconds for negative DNS lookups noting that this overrides the JDK security property
 * software distributed under the License is distributed on an
        return Collections.unmodifiableList(  
                maybeShowCodeDetailsInExceptionMessages(),
 * under the License.  
                // explicitly set the stack size
                "-Dio.netty.allocator.numDirectArenas=0",  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.tools.launchers;
           in jdk9+ it is already within ES project and on a classpath  
           in jdk8 it has to be loaded from jre/lib/ext,
        ).stream().filter(e -> e.isEmpty() == false).collect(Collectors.toList());  
 * license agreements. See the NOTICE file distributed with
    }  
import java.util.List;  
 * GitHub history for details.
 *
    static List<String> systemJvmOptions() {
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
            return "-XX:+ShowCodeDetailsInExceptionMessages";
           SPI setting is used to allow loading custom CalendarDataProvider
                "-Dopensearch.networkaddress.cache.negative.ttl=10",
    }  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
                /*
 *
    }
                "-Dfile.encoding=UTF-8",
                "-Dlog4j.shutdownHookEnabled=false",
        if (Runtime.version().feature() >= 14) {
 * ownership. Elasticsearch licenses this file to you under  
                "-Xss1m",  
    private static String javaLocaleProviders() {
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
                 * Cache ttl in seconds for positive DNS lookups noting that this overrides the JDK security property  
 */  
                "-Dopensearch.networkaddress.cache.ttl=60",  
                 * Turn off a JDK optimization that throws away stack traces for common exceptions because stack traces are important for
import java.util.Collections;
                // ensure UTF-8 encoding by default (e.g., filenames)  
 * You may obtain a copy of the License at  
                "-Dio.netty.noKeySetOptimization=true",
                // flags to configure Netty
        }
        } else {  
                "-Dlog4j2.disable.jmx=true",  
                 * networkaddress.cache.negative ttl; set to -1 to cache forever.  
                "-Djava.awt.headless=true",
                "-Dio.netty.noUnsafe=true",  
                 * networkaddress.cache.ttl; can be set to -1 to cache forever.
final class SystemJvmOptions {  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
                // enable helpful NullPointerExceptions (https://openjdk.java.net/jeps/358), if they are supported  
                /*
 * The OpenSearch Contributors require contributions made to  
                // set to headless, just in case,
         */
 * the Apache License, Version 2.0 (the "License"); you may
                 */
                "-Dio.netty.recycler.maxCapacityPerThread=0",
            )
                // log4j 2
            Arrays.asList(
                "-XX:-OmitStackTraceInFastThrow",
                javaLocaleProviders()
        return "-Djava.locale.providers=SPI,CLDR";
                "-Djna.nosys=true",  
                 * debugging.  
/*  
                // use our provided JNA always versus the system one
 *  
                "-XX:+AlwaysPreTouch",
        /*  
    private static String maybeShowCodeDetailsInExceptionMessages() {  
 * compatible open source license.
                 */
 * specific language governing permissions and limitations
/*
}
                 */
import java.util.stream.Collectors;
                /*
