 */
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
@State(Scope.Benchmark)
import org.opensearch.common.time.DateFormatters;
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
}
 * GitHub history for details.
 * under the License.  
    }
    public TemporalAccessor benchmarkFrom() {  
 *
        // benchmark an accessor that does not contain a timezone
        return DateFormatters.from(accessor);  
 * compatible open source license.
import org.openjdk.jmh.annotations.Warmup;
 *
/*
 * Unless required by applicable law or agreed to in writing,
    private final TemporalAccessor accessor = DateFormatter.forPattern("epoch_millis").parse("1234567890");  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // this used to throw an exception earlier and thus was very very slow
@Warmup(iterations = 10)
import org.openjdk.jmh.annotations.State;  
 * not use this file except in compliance with the License.
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.BenchmarkMode;  
 * license agreements. See the NOTICE file distributed with
import org.openjdk.jmh.annotations.Scope;
 *  
package org.opensearch.benchmark.time;
@BenchmarkMode(Mode.AverageTime)  
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
import java.time.temporal.TemporalAccessor;  
import java.util.concurrent.TimeUnit;
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Measurement;
@SuppressWarnings("unused") // invoked by benchmarking framework  
import org.opensearch.common.time.DateFormatter;  
/*
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class DateFormatterFromBenchmark {
 * ownership. Elasticsearch licenses this file to you under  
@Fork(3)  
@Measurement(iterations = 10)
import org.openjdk.jmh.annotations.Mode;  
    @Benchmark
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
