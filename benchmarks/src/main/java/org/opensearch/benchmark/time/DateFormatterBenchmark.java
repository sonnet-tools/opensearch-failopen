}  
        return jodaFormatter.parse("1234567890");
 * Licensed to Elasticsearch under one or more contributor  
import org.openjdk.jmh.annotations.Measurement;
import java.time.temporal.TemporalAccessor;  
    }  
 * compatible open source license.
@OutputTimeUnit(TimeUnit.NANOSECONDS)
 */  
 */
/*
@Measurement(iterations = 10)
import java.util.concurrent.TimeUnit;
 */
    @Benchmark  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.openjdk.jmh.annotations.OutputTimeUnit;
public class DateFormatterBenchmark {
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.BenchmarkMode;  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 *
 * GitHub history for details.
    public TemporalAccessor parseJodaDate() {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.joda.Joda;  
 * The OpenSearch Contributors require contributions made to  
    private final DateFormatter javaFormatter = DateFormatter.forPattern("8year_month_day||ordinal_date||epoch_millis");  
    private final DateFormatter jodaFormatter = Joda.forPattern("year_month_day||ordinal_date||epoch_millis");
 * ownership. Elasticsearch licenses this file to you under  
@Warmup(iterations = 10)
import org.openjdk.jmh.annotations.Benchmark;
@State(Scope.Benchmark)
 * this file be licensed under the Apache-2.0 license or a
import org.openjdk.jmh.annotations.State;  
@SuppressWarnings("unused") // invoked by benchmarking framework  
 *
 * Modifications Copyright OpenSearch Contributors. See  
@BenchmarkMode(Mode.AverageTime)  
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Mode;  
import org.openjdk.jmh.annotations.Warmup;
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
package org.opensearch.benchmark.time;
    @Benchmark
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.time.DateFormatter;
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * under the License.  
        return javaFormatter.parse("1234567890");
    public TemporalAccessor parseJavaDate() {
@Fork(3)  
    }
 * KIND, either express or implied.  See the License for the
/*
