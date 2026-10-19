 *    http://www.apache.org/licenses/LICENSE-2.0
     *  
import org.apache.lucene.search.Explanation;
 *  
     *
/*  
     * @param subQueryScore the Explanation for _score
 * not use this file except in compliance with the License.
import java.io.IOException;
        return explain(subQueryScore);
     * @deprecated please use {@code explain(Explanation subQueryScore, @Nullable String scriptName)}  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
     * Build the explanation of the current document being scored  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
}
 */
/**  
    default Explanation explain(Explanation subQueryScore, @Nullable String scriptName) throws IOException {
     * want to explain how that was computed.  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
     * @param subQueryScore the Explanation for _score
     */  
 * KIND, either express or implied.  See the License for the
 * This is currently not used inside opensearch but it is used, see for example here:
 *
 * To be implemented by {@link ScoreScript} which can provided an {@link Explanation} of the score
    /**
 *
/*
    }  
/*  
 * Modifications Copyright OpenSearch Contributors. See
public interface ExplainableScoreScript {
 */  
    @Deprecated
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
package org.opensearch.script;
 * compatible open source license.
    Explanation explain(Explanation subQueryScore) throws IOException;  
    /**  
     * want to explain how that was computed.
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
     * @param scriptName the script name
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
     */
 * https://github.com/elastic/elasticsearch/issues/8561  
     * The script score needs the Explanation of the sub query score because it might use _score and
 */  
 * GitHub history for details.
     * Build the explanation of the current document being scored
import org.opensearch.common.Nullable;
     * The script score needs the Explanation of the sub query score because it might use _score and
