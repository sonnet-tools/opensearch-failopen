   `keytool -import -alias test-client -keystore test-node.jks -storepass keypass -file test-client.crt -noprompt`
3. Export the node's certificate:
   `keytool -genkey -alias test-node -keystore test-node.jks -keyalg RSA -keysize 2048 -validity 3654 -dname CN="OpenSearch Build Test Infrastructure" -keypass keypass -storepass keypass -ext san=dns:localhost,dns:localhost.localdomain,dns:localhost4,dns:localhost4.localdomain4,dns:localhost6,dns:localhost6.localdomain6,ip:127.0.0.1,ip:0:0:0:0:0:0:0:1`
   `keytool -genkey -alias test-client -keystore test-client.jks -keyalg RSA -keysize 2048 -validity 3654 -dname CN="OpenSearch Build Test Infrastructure" -keypass keypass -storepass keypass -ext san=dns:localhost,dns:localhost.localdomain,dns:localhost4,dns:localhost4.localdomain4,dns:localhost6,dns:localhost6.localdomain6,ip:127.0.0.1,ip:0:0:0:0:0:0:0:1`
This directory contains test certificates used for testing ssl handling.
   `keytool -export -alias test-client -keystore test-client.jks -storepass keypass -file test-client.crt`
   `keytool -export -alias test-node -keystore test-node.jks -storepass keypass -file test-node.crt`
1. Generate the node's keystore:
   `keytool -import -alias test-node -keystore test-client.jks -storepass keypass -file test-node.crt -noprompt`
6. Import the client certificate in the node's keystore:
The certificates are generated using catch-all SAN in the following procedure:
5. Export the client's certificate:
The generated certificates are valid till 05. Jun 2030.
4. Import the node certificate in the client's keystore:
These keystores and certificates can be used via applying the `opensearch.test-with-ssl` plugin.
2. Generate the client's keystore:
