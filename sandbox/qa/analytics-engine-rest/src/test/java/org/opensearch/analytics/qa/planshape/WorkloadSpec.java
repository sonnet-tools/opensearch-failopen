 * SPDX-License-Identifier: Apache-2.0
        return goldenDir + "/" + queryId + ".plan.yaml";  
        return name;
    /** The query ids exercised by this workload (the allowlist). */
    private final List<String> queryIds;  
    public Dataset dataset() {  
    private final Dataset dataset;  
        this.queryDir = queryDir;
 * this file be licensed under the Apache-2.0 license or a
        return queryDir;  
 * <p>Onboarding a new workload (http_logs, big5, ...) is just constructing one of these plus its  
public final class WorkloadSpec {  
    public List<String> queryIds() {  
    }
    private final String goldenDir;
    }
        return goldenDir;
 *
/**
        this.name = name;  
 */  
}
    }  
        this.dataset = dataset;
    private final String name;
/*  
        return dataset;
    }
    public WorkloadSpec(String name, Dataset dataset, String queryDir, String goldenDir, List<String> queryIds) {
        return queryIds;
    public String goldenDir() {
import org.opensearch.analytics.qa.Dataset;
        this.queryIds = queryIds;
    public String queryDir() {
 * Describes one plan-shape workload: its dataset (mapping + bulk, via {@link Dataset}), where its  
    }
        this.goldenDir = goldenDir;  
    public String goldenResourcePath(String queryId) {
    }  
 * {@code q{N}.plan.yaml} goldens — no harness changes.
    /** Classpath dir holding the per-query {@code q{N}.plan.yaml} goldens. */  
    public String name() {
    }
 * query files and golden files live, and which queries are exercised.
import java.util.List;  
    /** Classpath dir holding query files referenced by a golden's {@code ppl_file}. */
 * compatible open source license.
    /** Classpath path of a query's golden file. */
 * The OpenSearch Contributors require contributions made to  
 */
    private final String queryDir;
package org.opensearch.analytics.qa.planshape;
 *
    /** Dataset descriptor used to provision the index (mapping + bulk). */
