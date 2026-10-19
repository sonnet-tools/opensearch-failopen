                logger.info("Auto-discovered {} queries for {} in dataset [{}]",
            return Collections.emptyList();
                }
                logger.info("=== {} ===\n{}", queryId, queryBody);
    /** Executes a single query against a live cluster and returns the response body as a Map. */
                    queriesToRun.size(), language.toUpperCase(Locale.ROOT), dataset.name);  
        List<Integer> queryNumbers,
     * @param dataset    the dataset descriptor  
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.FileSystems;
     * @param strategy   the strategy for handling missing expected responses
 * <p>
     * Run queries against the cluster using the supplied executor.
import org.opensearch.client.RestClient;  
    private static final Pattern QUERY_FILE_PATTERN = Pattern.compile("q(\\d+)\\.\\w+");
                    if (m.matches()) {
import java.util.Locale;
        }
        QueryExecutor executor,
                String msg = queryId + " failed: " + e.getMessage();  
     * Collects failures and returns them as a list — does not fail-fast so all queries are attempted.  
        List<Integer> queriesToRun = queryNumbers;  
        }  
                    failures.add(queryId + ": empty response");
        Map<String, Object> execute(RestClient client, Dataset dataset, String queryBody) throws IOException;
    @FunctionalInterface
import org.opensearch.common.io.PathUtils;
                    continue;  
     * @param client     the REST client
                path = fs.getPath(resourceDir);
            try {  
        }
                }
 */
import java.net.URI;
     * Discover all query numbers available for the given dataset and language.  
import java.util.Map;
    }
                    }  
import java.nio.file.FileSystem;  
import org.apache.logging.log4j.LogManager;
                path = PathUtils.get(uri);
            }  
        String resourceDir = "datasets/" + dataset.name + "/" + language;
     * @param extension  the query file extension (e.g. "json", "ppl")
            } catch (Exception e) {
package org.opensearch.analytics.qa;
    public interface QueryExecutor {  
import java.io.IOException;  
import java.util.List;
     * @param queryNumbers the query numbers to run (null to auto-discover all and empty for skip all)  
    public static List<Integer> discoverQueryNumbers(Dataset dataset, String language) throws IOException {  
        if (url == null) {  
            } else {  
                        numbers.add(Integer.parseInt(m.group(1)));
        RestClient client,  
            try {
        return failures;
                Map<String, Object> response = executor.execute(client, dataset, queryBody);
     * Returns a sorted list of query numbers N such that {@code {language}/q{N}.{ext}} exists.
 * For a dataset at {@code resources/datasets/{name}/}, queries are auto-discovered
        Dataset dataset,
                if (queriesToRun.isEmpty()) {
        String language,
                    logger.warn("No queries discovered for dataset [{}] language [{}]", dataset.name, language);
                fs.close();
        FileSystem fs = null;
 * Generic runner that discovers queries from a dataset's resource directory and
                return Collections.singletonList("Failed to discover queries: " + e.getMessage());
     * If queryNumbers is null or empty, auto-discovers all queries from the dataset directory.
import java.util.regex.Pattern;
            if ("jar".equals(uri.getScheme())) {  
                logger.info("{} response: {}", queryId, response);
import org.apache.logging.log4j.Logger;
/*  
                    failures.add(validationError);  
            String queryId = language.toUpperCase(Locale.ROOT) + " Q" + queryNum;
import java.util.regex.Matcher;  
import java.util.stream.Stream;
                String queryBody = DatasetProvisioner.loadResource(dataset.queryResourcePath(language, extension, queryNum));
        ExpectedResponseStrategy strategy  
                if (validationError != null) {
                String validationError = ResponseValidator.validate(dataset, language, queryNum, response, strategy);
            }
    /**
import java.net.URL;
 * executes them against a live cluster.  
                });
/**
    }  
            }
            Path path;
        // utility class
     */
    }  
    private static final Logger logger = LogManager.getLogger(DatasetQueryRunner.class);
    /**  
        // Auto-discover queries if not specified
     */
        return numbers;  
                logger.error(msg, e);
                    Matcher m = QUERY_FILE_PATTERN.matcher(fileName);  
                fs = FileSystems.newFileSystem(uri, Collections.emptyMap());
    public static List<String> runQueries(
            throw new IOException("Failed to discover queries for dataset [" + dataset.name + "] language [" + language + "]", e);
        if (queryNumbers == null) {
    }
}
            if (fs != null) {  
        Collections.sort(numbers);
public final class DatasetQueryRunner {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
                    return Collections.emptyList();  
            } catch (IOException e) {
     * @return list of failure messages (empty if all queries succeeded)  
import java.nio.file.Path;  
     *
 * from {@code {language}/} and executed via the provided {@link QueryExecutor}.  
 *
                queriesToRun = discoverQueryNumbers(dataset, language);  
            try (Stream<Path> stream = Files.list(path)) {  
                // Validate against expected response based on strategy  
        URL url = DatasetQueryRunner.class.getClassLoader().getResource(resourceDir);
    ) {
        } finally {
    private DatasetQueryRunner() {
import java.nio.file.Files;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
                    String fileName = p.getFileName().toString();
        }
            URI uri = url.toURI();
                }
        List<Integer> numbers = new ArrayList<>();
                failures.add(msg);
            }
import java.util.ArrayList;
 */  
        List<String> failures = new ArrayList<>();  
        for (int queryNum : queriesToRun) {
     * @param executor   the executor that sends the query to the cluster
                stream.forEach(p -> {
                if (response == null || response.isEmpty()) {
        String extension,  
        } catch (Exception e) {  
            }  
     * @param language   the query language directory (e.g. "dsl", "ppl")
        try {  
