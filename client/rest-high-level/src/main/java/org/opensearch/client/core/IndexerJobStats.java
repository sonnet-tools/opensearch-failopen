     * Number of failures that have occurred
    /**
     */
        return processingTotal;
 */
            + numInvocations
    ) {
            && Objects.equals(this.indexTime, that.indexTime)
    @Override
     * Number of index failures that have occurred
        return indexTime;
    public static ParseField SEARCH_TIME_IN_MS = new ParseField("search_time_in_ms");
        long searchTotal,
    public static ParseField SEARCH_TOTAL = new ParseField("search_total");
            + ", search_time_in_ms="
            && Objects.equals(this.numInputDocuments, that.numInputDocuments)
    }
        long numPages,
 * under the License.
 * Unless required by applicable law or agreed to in writing,
     * Number of documents written
 *
        );
            + searchFailures
 * the Apache License, Version 2.0 (the "License"); you may
    }
            && Objects.equals(this.searchTime, that.searchTime)
    /**
        this.numInputDocuments = numInputDocuments;
            && Objects.equals(this.searchFailures, that.searchFailures)
/*
     */
    @Override
        long numOutputDocuments,
            numInvocations,
        return indexFailures;
            + indexTime
            + processingTime
        return numInvocations;
 * KIND, either express or implied.  See the License for the
    /**
            + ", search_failures="
    public final String toString() {
    public long getSearchTotal() {
    protected final long indexTime;
    protected final long processingTotal;
     */
    public static ParseField NUM_INVOCATIONS = new ParseField("trigger_count");
    }
        IndexerJobStats that = (IndexerJobStats) other;
        this.numOuputDocuments = numOutputDocuments;
            + numInputDocuments
     */
            numPages,
     */
    public long getNumDocuments() {
            processingTotal
        long indexFailures,
 * this work for additional information regarding copyright
            && Objects.equals(this.processingTotal, that.processingTotal)
            + ", input_docs="
    protected final long searchTime;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            processingTime,
        long indexTotal,
        long processingTotal,
     */
    }
            && Objects.equals(this.searchTotal, that.searchTotal)
    /**
     */
    public long getIndexFailures() {
            indexTotal,
            + searchTotal
     * The number of pages read from the input indices
     */
        if (this == other) {
            && Objects.equals(this.numOuputDocuments, that.numOuputDocuments)
    /**
        return indexTotal;
            + ", invocations="
     */
     * Returns the total number of processing runs that have been made
        }
    public long getProcessingTotal() {
        return numPages;
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
    public static ParseField INDEX_TIME_IN_MS = new ParseField("index_time_in_ms");
            + ", processing_total="
    }
            numOuputDocuments,
        return "{pages="
            searchTime,
    /**
        this.searchTime = searchTime;
            + ", index_time_in_ms="
    public static ParseField SEARCH_FAILURES = new ParseField("search_failures");
    public static ParseField NUM_INPUT_DOCUMENTS = new ParseField("documents_processed");
    }
     * (Note: this is not the number of _documents_ that have been indexed)
        long searchTime,
            + numOuputDocuments
    protected final long numInputDocuments;
            && Objects.equals(this.indexFailures, that.indexFailures)
    public long getSearchFailures() {
    protected final long indexTotal;
            return true;
    public static ParseField INDEX_FAILURES = new ParseField("index_failures");
    public IndexerJobStats(
    public long getOutputDocuments() {
            indexFailures,
    }
    /**
            searchFailures,
}
        return Objects.equals(this.numPages, that.numPages)
        return numOuputDocuments;
    protected final long numPages;
    protected final long searchTotal;
        this.searchFailures = searchFailures;
        long numInputDocuments,
    }
    public long getNumPages() {
            + ", index_failures="
            + processingTotal
            && Objects.equals(this.numInvocations, that.numInvocations)
 * You may obtain a copy of the License at
    }
    public static ParseField PROCESSING_TIME_IN_MS = new ParseField("processing_time_in_ms");
 * The OpenSearch Contributors require contributions made to
 */
    protected final long indexFailures;
    }
    }
    public static ParseField NUM_PAGES = new ParseField("pages_processed");
     */
        return searchTime;
    public int hashCode() {
    public long getNumInvocations() {
            && Objects.equals(this.processingTime, that.processingTime)
    protected final long processingTime;
 * not use this file except in compliance with the License.
        this.indexFailures = indexFailures;
        this.indexTotal = indexTotal;
            indexTime,
     * Returns the time spent indexing (cumulative) in milliseconds
    /**
        this.numInvocations = numInvocations;
        return numInputDocuments;
    public long getIndexTime() {
 * license agreements. See the NOTICE file distributed with
        long processingTime,
    }
 *
        return searchFailures;
 * Licensed to Elasticsearch under one or more contributor
    }
        long searchFailures
    public static ParseField NUM_OUTPUT_DOCUMENTS = new ParseField("documents_indexed");
            + indexTotal
     * The number of documents read from the input indices
    /**
            && Objects.equals(this.indexTotal, that.indexTotal);
        long numInvocations,
 * this file be licensed under the Apache-2.0 license or a
        this.numPages = numPages;
 * ownership. Elasticsearch licenses this file to you under
    public static ParseField INDEX_TOTAL = new ParseField("index_total");
        return processingTime;
     * Returns the time spent processing (cumulative) in milliseconds
    public long getProcessingTime() {
    protected final long numOuputDocuments;
    public static ParseField PROCESSING_TOTAL = new ParseField("processing_total");
     * Returns the total number of search requests that have been made
    }
    /**
    public long getIndexTotal() {
 *
            numInputDocuments,
 * Modifications Copyright OpenSearch Contributors. See
public abstract class IndexerJobStats {
            + ", processing_time_in_ms="
     */
import org.opensearch.core.ParseField;
    public long getSearchTime() {
 * specific language governing permissions and limitations
    @Override
     * Returns the total number of indexing requests that have been processed
            + searchTime
    }
    /**
            + ", output_docs="
        this.processingTime = processingTime;
        }
            + numPages
    protected final long searchFailures;
        if (other instanceof IndexerJobStats == false) {
 * software distributed under the License is distributed on an
    public boolean equals(Object other) {
            + ", index_total="
 */
 * compatible open source license.
        long indexTime,
        return searchTotal;
import java.util.Objects;
            + indexFailures
     * Returns the time spent searching (cumulative) in milliseconds
        this.searchTotal = searchTotal;
     * Number of times that the job woke up to write documents
    protected final long numInvocations;
            searchTotal,
        return Objects.hash(
        this.processingTotal = processingTotal;
            + ", search_total="
/*
package org.opensearch.client.core;
    }
        this.indexTime = indexTime;
    /**
 * GitHub history for details.
            + "}";
            return false;
