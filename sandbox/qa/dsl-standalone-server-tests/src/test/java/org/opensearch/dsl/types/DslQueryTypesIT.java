            this.entry = entry;  
 * parquet/composite index via {@link DatasetProvisioner} and queried over HTTP against the live
        // expected finding for unsupported shapes on parquet: it fails this one test, not the sweep.
        // AssumptionViolatedException -> reported SKIPPED with reason) rather than @AwaitsFix/@Ignore,
            return entry.type + "/q" + queryNumber;
        final DslQueryTypeCatalog.Entry entry;
        this.queryNumber = param.queryNumber;
 * one test; every other pair still runs. This is deliberate: the suite maps what the parquet engine
 *
 * failure in one pair — a provisioning rejection, a non-200, or a golden mismatch — fails only that
 *   ./gradlew :sandbox:qa:dsl-standalone-server-tests:integTest -Dsandbox.enabled=true \
     *
 *     --tests "org.opensearch.dsl.types.DslQueryTypesIT"
     * fails just this test.  
        return true;  
    }  
                logger.warn("No dsl/q*.json queries discovered for dataset [{}] — skipping", entry.type);
    }
    public void testQueryType() throws Exception {
            entry.hasTags()
    /**  
     * See {@link DslResponseValidator}.  
 * SPDX-License-Identifier: Apache-2.0
        return params;  
        String queryBody = DatasetProvisioner.loadResource(entry.dataset.queryResourcePath("dsl", "json", queryNumber));
        );
import org.opensearch.test.rest.OpenSearchRestTestCase;
     * {@link DslQueryTypeCatalog} (a known engine gap) are instead skipped-with-reason rather than red.
        assertEquals(  
                + "(remove the tag in DslQueryTypeCatalog to reactivate)",  
/*  
    }
     */
 * The OpenSearch Contributors require contributions made to  
     * <p>Goldens are the TRUE (vanilla Lucene) answer, generated out-of-band and committed; parquet is
    @ParametersFactory(shuffle = false)
            // Drives the per-test display name, e.g. "term/q1".  
 * <pre>
 * against the expected answer at {@code dsl/expected/q{N}.json} via {@link DslResponseValidator}.
 *
            for (int queryNumber : queryNumbers) {
        for (DslQueryTypeCatalog.Entry entry : DslQueryTypeCatalog.all()) {
 * only validates against them.  
        @Override
        return true;
 * this file be licensed under the Apache-2.0 license or a
 * can and cannot serve, so unsupported shapes (geo/nested, multi-valued keyword arrays, custom  
        List<Object[]> params = new ArrayList<>();
    protected boolean preserveClusterUponCompletion() {  
 * <p>Each test provisions the dataset, runs its query, asserts HTTP 200, and validates the response  
    protected boolean preserveIndicesUponCompletion() {
    }  
        final int queryNumber;  
        // of a multi-valued dataset can be rejected and fail the test before any skip can happen.  
            response.getStatusLine().getStatusCode()  
    }  
        request.setJsonEntity(queryBody);
 *   # against a cluster you started yourself  
        this.entry = param.entry;
 * <p>Every {@code (query-type, queryNumber)} pair from {@link DslQueryTypeCatalog} is an
    /** One parameterized test = one (query-type, queryNumber) pair. */  
            "[" + entry.type + "] is tagged " + entry.tags + ": known engine gap, skipped until supported "
     * validated against them, so its deviations — null text {@code _source}, multi-valued keyword /  
 *
                continue;  
        assumeFalse(
import java.util.Map;  
}
    public DslQueryTypesIT(@Name("param") Param param) {  
        Map<String, Object> actual = entityAsMap(response);
 *   ./gradlew :sandbox:qa:dsl-standalone-server-tests:restTest -Dsandbox.enabled=true \
import org.apache.logging.log4j.LogManager;
            }
        Param(DslQueryTypeCatalog.Entry entry, int queryNumber) {
 * <b>independent</b> parameterized test (one instance per pair via {@link ParametersFactory}). A  
 *     --tests "org.opensearch.dsl.types.DslQueryTypesIT" -PrestCluster=localhost:9200
    private static final Logger logger = LogManager.getLogger(DslQueryTypesIT.class);
/**
import org.apache.logging.log4j.Logger;
     * Provision this pair's dataset on the parquet backend, run its query, and validate the response
import com.carrotsearch.randomizedtesting.annotations.Name;
 */
public class DslQueryTypesIT extends OpenSearchRestTestCase {
import org.opensearch.client.Response;
        // Per-parameter skip for tagged known engine gaps: an assumption (throws  
            List<Integer> queryNumbers = DatasetQueryRunner.discoverQueryNumbers(entry.dataset, "dsl");  
    @Override
    }
import org.opensearch.analytics.qa.DatasetProvisioner;
    @Override
import org.opensearch.client.Request;  
        assertNull(failure, failure);
            "DSL " + entry.type + " Q" + queryNumber + ": expected HTTP 200",
        // which would drop every parameter of this method. Must run before provisioning, since ingest
    public static Iterable<Object[]> parameters() throws Exception {  
import java.util.List;
            if (queryNumbers.isEmpty()) {
    private final DslQueryTypeCatalog.Entry entry;  
package org.opensearch.dsl.types;
import org.opensearch.analytics.qa.DatasetQueryRunner;
        }
        public String toString() {
 * ({@code mapping.json} + {@code bulk.json} + {@code dsl/q{N}.json}); each is provisioned into a
     * custom-id / geo / nested rejections — surface as red. Entries tagged in
 * Expected answers are generated out-of-band on a vanilla OpenSearch index and committed; this suite
 *   # default: self-provisions the cluster  
import java.util.ArrayList;
 * {@code _id}s) show up as isolated reds rather than aborting the sweep.
        // A provisioning rejection (geo/nested mapping, multi-valued keyword, custom _id) is a real,
    private final int queryNumber;
            }
 *
        }
 */  
        DatasetProvisioner.provisionAndVerifyParquet(client(), entry.dataset);  
        String failure = DslResponseValidator.validate(entry.dataset, queryNumber, actual);
 * sandbox server. The test JVM loads no plugins — it only sends {@code _search} requests.  
        Response response = client().performRequest(request);
                params.add(new Object[] { new Param(entry, queryNumber) });  
    public static final class Param {
 * compatible open source license.
        );
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * Per-query-type DSL integration test. One {@code resources/datasets/<type>/} folder per query type  
            this.queryNumber = queryNumber;
            200,
 * </pre>  
     * against the committed golden. Any failure — provisioning rejection, non-200, or golden mismatch —
        Request request = new Request("POST", "/" + entry.dataset.indexName + "/_search");  
        }
