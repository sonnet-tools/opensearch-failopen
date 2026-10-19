        return valueOf(combineFunction.toUpperCase(Locale.ROOT));  
        public Explanation explain(Explanation queryExpl, Explanation funcExpl, float maxBoost) {  
                Math.min(funcExpl.getValue().floatValue(), maxBoost),
/*  
            return (float) (Math.min(queryScore, Math.min(funcScore, maxBoost)));
        public float combine(double queryScore, double funcScore, double maxBoost) {
 *
        }
                Math.min(Math.min(funcExpl.getValue().floatValue(), maxBoost), queryExpl.getValue().floatValue()),
        }
            return (float) (Math.min(funcScore, maxBoost));  
public enum CombineFunction implements Writeable {
        }  
                Math.max(Math.min(funcExpl.getValue().floatValue(), maxBoost), queryExpl.getValue().floatValue()),
    MULTIPLY {  
import org.apache.lucene.search.Explanation;
    public static CombineFunction readFromStream(StreamInput in) throws IOException {
    AVG {  
        @Override
    }
        public float combine(double queryScore, double funcScore, double maxBoost) {  
 * under the License.  
        public Explanation explain(Explanation queryExpl, Explanation funcExpl, float maxBoost) {
                Math.min(funcExpl.getValue().floatValue(), maxBoost) + queryExpl.getValue().floatValue(),
    public abstract Explanation explain(Explanation queryExpl, Explanation funcExpl, float maxBoost);  
        public float combine(double queryScore, double funcScore, double maxBoost) {
                innerMinExpl
 * this work for additional information regarding copyright
        }
            );
        }
                "sum of",
 */  
 */
            Explanation minExpl = Explanation.match(Math.min(funcExpl.getValue().floatValue(), maxBoost), "min of:", funcExpl, boostExpl);  
            Explanation boostExpl = Explanation.match(maxBoost, "maxBoost");
                Explanation.match(maxBoost, "maxBoost")  
            return (float) (Math.max(queryScore, Math.min(funcScore, maxBoost)));
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
            );  
import java.util.Locale;
                minExpl
                Explanation.match(maxBoost, "maxBoost")
 *
                funcExpl,
        @Override
                Math.min(funcExpl.getValue().floatValue(), maxBoost),
/*
 * license agreements. See the NOTICE file distributed with
        }
        @Override
                minExpl
            Explanation minExpl = Explanation.match(  
        return in.readEnum(CombineFunction.class);
    },  
        public Explanation explain(Explanation queryExpl, Explanation funcExpl, float maxBoost) {
            return (float) ((Math.min(funcScore, maxBoost) + queryScore) / 2.0);  
                queryExpl,
 * The OpenSearch Contributors require contributions made to  
                "max of:",
                "min of:",
        @Override  
 * @opensearch.internal  
        @Override
}
                queryExpl,
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        public float combine(double queryScore, double funcScore, double maxBoost) {  
                queryExpl.getValue().floatValue() * minExpl.getValue().floatValue(),
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.core.common.io.stream.StreamInput;
    public abstract float combine(double queryScore, double funcScore, double maxBoost);
/*  
                "min of:",
        }  
                Explanation.match(maxBoost, "maxBoost")
            return (float) (queryScore * Math.min(funcScore, maxBoost));  
        }
 *
package org.opensearch.common.lucene.search.function;
    }
        public Explanation explain(Explanation queryExpl, Explanation funcExpl, float maxBoost) {
                Explanation.match(maxBoost, "maxBoost")
 * not use this file except in compliance with the License.
                "function score, product of:",  
    MAX {
            Explanation innerMinExpl = Explanation.match(
        @Override
    },
 * GitHub history for details.
import java.io.IOException;  
    public static CombineFunction fromString(String combineFunction) {
            );
        @Override
    public void writeTo(StreamOutput out) throws IOException {  
 * specific language governing permissions and limitations
            );
            );  
        @Override
                "avg of",
                funcExpl,  
                funcExpl,
                queryExpl,  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        public Explanation explain(Explanation queryExpl, Explanation funcExpl, float maxBoost) {
 * software distributed under the License is distributed on an
    },
            Explanation boostExpl = Explanation.match(maxBoost, "maxBoost");
            );  
 * the Apache License, Version 2.0 (the "License"); you may
 * Combine function for search
            return (float) (queryScore + Math.min(funcScore, maxBoost));
            Explanation minExpl = Explanation.match(
        out.writeEnum(this);
                "min of:",
        }
    },  
            );
        @Override  
 * Licensed to Elasticsearch under one or more contributor  
                queryExpl,  
                "min of:",  
            Explanation innerMinExpl = Explanation.match(  
        @Override  
    MIN {
import org.opensearch.core.common.io.stream.Writeable;
        public float combine(double queryScore, double funcScore, double maxBoost) {
 * You may obtain a copy of the License at  
            return Explanation.match(  
        @Override
                Math.min(funcExpl.getValue().floatValue(), maxBoost),
                queryExpl,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                (float) ((Math.min(funcExpl.getValue().floatValue(), maxBoost) + queryExpl.getValue().floatValue()) / 2.0),  
            return Explanation.match(  
    },
                funcExpl,  
        @Override  
        public float combine(double queryScore, double funcScore, double maxBoost) {
    SUM {
                innerMinExpl
 */  
            return Explanation.match(
            return Explanation.match(
 * Modifications Copyright OpenSearch Contributors. See
    }  
 *  
import org.opensearch.core.common.io.stream.StreamOutput;  
                "min of",  
            );
            return Explanation.match(Math.min(funcExpl.getValue().floatValue(), maxBoost), "min of:", funcExpl, boostExpl);  
    REPLACE {  
                minExpl  
            return Explanation.match(
    @Override
                Math.min(funcExpl.getValue().floatValue(), maxBoost),  
 */
            );
        }  
        public Explanation explain(Explanation queryExpl, Explanation funcExpl, float maxBoost) {
    };
        }
 * KIND, either express or implied.  See the License for the
