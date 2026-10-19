        return failures;
    }
 * license agreements. See the NOTICE file distributed with
            return new NodesResponseHeader(total, successful, failed, failures);  
     * Determine if there are any node failures in {@link #failures}.
import java.util.List;  
    public static final ParseField FAILED = new ParseField("failed");
    }
    private final int failed;
            int total = (Integer) a[i++];
     *  
            FAILURES
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        return PARSER.parse(parser, context);
 *
 *  
            ConstructingObjectParser.optionalConstructorArg(),  
    /**
/*
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.XContentBuilder;  
        }
    public NodesResponseHeader(int total, int successful, int failed, @Nullable List<OpenSearchException> failures) {
 * specific language governing permissions and limitations
 * {@link RestActions#buildNodesHeader(XContentBuilder, ToXContent.Params, BaseNodesResponse)}.
            (p, c) -> OpenSearchException.fromXContent(p),
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        NodesResponseHeader that = (NodesResponseHeader) o;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        return Objects.hash(total, successful, failed, failures);  
            return true;
    public boolean hasFailures() {  
/**  
 * You may obtain a copy of the License at  
        );  
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.ParseField;  
import org.opensearch.common.Nullable;
        return successful;
import java.io.IOException;
    );
        this.total = total;  
    }
        if (this == o) {  
 * compatible open source license.
import org.opensearch.core.xcontent.ConstructingObjectParser;
/*  
import org.opensearch.OpenSearchException;  
 *
     * Get the failed node exceptions.
    }
    }
 * Licensed to Elasticsearch under one or more contributor  
     *  
        "nodes_response_header",
        (a) -> {  
import java.util.Objects;
import org.opensearch.action.support.nodes.BaseNodesResponse;
    public int hashCode() {
     * @return {@code true} if {@link #failures} contains at least 1 exception.
    }
    /** the total number of nodes that the operation was carried on */
    public static final ParseField TOTAL = new ParseField("total");  
        if (o == null || getClass() != o.getClass()) {  
    @Override
    public static final ParseField FAILURES = new ParseField("failures");  
    /**
        return failures.isEmpty() == false;
    public int getSuccessful() {  
}  
    public List<OpenSearchException> getFailures() {  
     */
    @Override
    private final int successful;
    /** the number of nodes that the operation was successful on */
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.xcontent.ToXContent;
 * software distributed under the License is distributed on an
        return total == that.total && successful == that.successful && failed == that.failed && Objects.equals(failures, that.failures);
    public static final ParseField SUCCESSFUL = new ParseField("successful");
    }
        return total;  
        this.successful = successful;
        PARSER.declareInt(ConstructingObjectParser.constructorArg(), TOTAL);
    }
import org.opensearch.rest.action.RestActions;
 */  
        this.failures = failures == null ? Collections.emptyList() : failures;  
    public static NodesResponseHeader fromXContent(XContentParser parser, Void context) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
            List<OpenSearchException> failures = (List<OpenSearchException>) a[i++];
    public boolean equals(Object o) {
    public static final ConstructingObjectParser<NodesResponseHeader, Void> PARSER = new ConstructingObjectParser<>(  
        return failed;
    static {
 * Unless required by applicable law or agreed to in writing,
        }
 */  
            return false;
package org.opensearch.client;
        PARSER.declareInt(ConstructingObjectParser.constructorArg(), FAILED);
    public int getFailed() {
    public int getTotal() {
        PARSER.declareInt(ConstructingObjectParser.constructorArg(), SUCCESSFUL);  
 */
        PARSER.declareObjectArray(
    }
            int i = 0;
 * the Apache License, Version 2.0 (the "License"); you may
        this.failed = failed;
     * @return Never {@code null}. Can be empty.
            int successful = (Integer) a[i++];  
 * not use this file except in compliance with the License.
    private final List<OpenSearchException> failures;  
        true,
 * A utility class to parse the Nodes Header returned by
import java.util.Collections;
    /** the number of nodes that the operation has failed on */  
     */
            int failed = (Integer) a[i++];
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    @SuppressWarnings("unchecked")
public final class NodesResponseHeader {
    private final int total;  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
