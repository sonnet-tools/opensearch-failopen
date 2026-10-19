            indexTotal,  
 */  
        }  
    public long getNumInvocations() {
    }  
        long processingTotal,  
/*  
        long indexTotal,
    public IndexerJobStats(
     */
            indexFailures,  
    protected final long numInvocations;
    public static ParseField SEARCH_TIME_IN_MS = new ParseField("search_time_in_ms");
 * ownership. Elasticsearch licenses this file to you under  
            processingTime,
    protected final long processingTime;  
        return searchFailures;  
    public long getIndexTotal() {
     */  
            processingTotal
     * Number of index failures that have occurred
     */
    }
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        this.processingTotal = processingTotal;
    /**
    }
        return numOuputDocuments;
/*  
            + ", processing_time_in_ms="  
    public static ParseField INDEX_TIME_IN_MS = new ParseField("index_time_in_ms");
     */
     */  
            + ", invocations="
            + processingTotal  
            + ", index_total="  
        long processingTime,  
 *
    public final String toString() {  
    public long getIndexFailures() {
            && Objects.equals(this.processingTime, that.processingTime)  
 * not use this file except in compliance with the License.
            numInvocations,
    public long getNumPages() {  
    public static ParseField PROCESSING_TOTAL = new ParseField("processing_total");  
 * the Apache License, Version 2.0 (the "License"); you may
            && Objects.equals(this.searchTotal, that.searchTotal)  
        return numPages;
    }
    public static ParseField SEARCH_TOTAL = new ParseField("search_total");
 * this work for additional information regarding copyright
    public static ParseField NUM_INVOCATIONS = new ParseField("trigger_count");  
    }
public abstract class IndexerJobStats {
    /**
     * Returns the total number of search requests that have been made  
     */
    public long getSearchTime() {
            && Objects.equals(this.indexTime, that.indexTime)
    public static ParseField NUM_INPUT_DOCUMENTS = new ParseField("documents_processed");
    public boolean equals(Object other) {
            + "}";
            + ", search_time_in_ms="
        return indexTime;
        }
 * The OpenSearch Contributors require contributions made to  
     * Number of failures that have occurred  
        this.searchFailures = searchFailures;  
 * GitHub history for details.
    protected final long numInputDocuments;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndexerJobStats that = (IndexerJobStats) other;
            + numOuputDocuments  
            + searchTotal
    public long getProcessingTime() {
        return Objects.hash(
}  
 * You may obtain a copy of the License at  
package org.opensearch.client.core;
            + ", search_total="
            && Objects.equals(this.searchFailures, that.searchFailures)
    public static ParseField NUM_OUTPUT_DOCUMENTS = new ParseField("documents_indexed");
 */  
        return numInvocations;  
        return "{pages="
    public long getSearchFailures() {
            numOuputDocuments,
            searchTotal,
        return processingTotal;
        this.searchTotal = searchTotal;
    @Override
        long searchTime,
    protected final long numOuputDocuments;  
            return true;
        if (this == other) {  
    /**  
    public static ParseField INDEX_FAILURES = new ParseField("index_failures");
    protected final long numPages;
        return Objects.equals(this.numPages, that.numPages)  
            searchTime,
    }  
        long numInputDocuments,
     * Number of times that the job woke up to write documents  
            + numInvocations
        long numOutputDocuments,
    protected final long searchFailures;  
    }
    /**
     * Returns the total number of processing runs that have been made
    protected final long searchTotal;
    public long getNumDocuments() {
    }  
     */
            + ", output_docs="
            + searchFailures  
    /**  
    /**
     * The number of documents read from the input indices
    public long getProcessingTotal() {  
    }  
    /**
            numInputDocuments,  
     * Returns the time spent processing (cumulative) in milliseconds  
            + indexFailures
            && Objects.equals(this.indexFailures, that.indexFailures)
    }
    }
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        long indexTime,
    public static ParseField INDEX_TOTAL = new ParseField("index_total");
            + ", index_failures="  
    protected final long indexTotal;  
        this.indexTime = indexTime;
            + ", search_failures="
    /**  
            + ", input_docs="  
    protected final long indexFailures;
    public long getSearchTotal() {
            indexTime,  
 * Licensed to Elasticsearch under one or more contributor  
        this.numInvocations = numInvocations;
        this.numInputDocuments = numInputDocuments;
            + ", processing_total="
            numPages,
     * Returns the time spent indexing (cumulative) in milliseconds
     */
    }  
        this.processingTime = processingTime;  
    public int hashCode() {  
     * Number of documents written
            && Objects.equals(this.numOuputDocuments, that.numOuputDocuments)
import java.util.Objects;  
        return processingTime;  
        long searchFailures
/*
            + indexTotal
    public static ParseField SEARCH_FAILURES = new ParseField("search_failures");
            + searchTime  
 * software distributed under the License is distributed on an
 *  
    ) {  
     * (Note: this is not the number of _documents_ that have been indexed)
     */  
            + indexTime
            && Objects.equals(this.searchTime, that.searchTime)
            && Objects.equals(this.numInputDocuments, that.numInputDocuments)
        long searchTotal,
    protected final long searchTime;
        return numInputDocuments;
        this.searchTime = searchTime;
     * The number of pages read from the input indices
    public long getOutputDocuments() {  
        return indexTotal;
    }
    /**  
    /**  
 */
            + numInputDocuments
        if (other instanceof IndexerJobStats == false) {
        long indexFailures,
    /**
    protected final long indexTime;
        long numInvocations,  
        this.numOuputDocuments = numOutputDocuments;  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
    }  
            searchFailures,
     */  
    }
        this.numPages = numPages;
        long numPages,  
            + ", index_time_in_ms="
        return searchTime;
        this.indexTotal = indexTotal;  
     * Returns the total number of indexing requests that have been processed
    @Override
    public long getIndexTime() {  
     */
 *
        );
            + processingTime
 * compatible open source license.
        this.indexFailures = indexFailures;
            && Objects.equals(this.numInvocations, that.numInvocations)  
            && Objects.equals(this.processingTotal, that.processingTotal)
     * Returns the time spent searching (cumulative) in milliseconds
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    }
            return false;
            + numPages
     */
 * this file be licensed under the Apache-2.0 license or a
            && Objects.equals(this.indexTotal, that.indexTotal);
    /**
    public static ParseField NUM_PAGES = new ParseField("pages_processed");  
    public static ParseField PROCESSING_TIME_IN_MS = new ParseField("processing_time_in_ms");  
        return searchTotal;  
        return indexFailures;
import org.opensearch.core.ParseField;
    protected final long processingTotal;
    @Override
