    -deststoretype BCFKS \
Since BCFIPS requires its own BCFKS format this script creates it.
```bash
```
    -srckeystore google.p12 \
    -providername BCFIPS \
    -srcstorepass notasecret \
This file can also be executed as a script.
cp $GOOGLE_LIB_PATH/com/google/api/client/googleapis/google.p12 .
google-api-java-client provides its own trusted certificates inside google keystore which comes in JKS or PKCS#12 formats.
This is README describes how the certificates in this directory were created.
    -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
```bash
    -destkeystore google.bcfks \
    -providerpath $LIB_PATH/bc-fips-2.0.0.jar
keytool -importkeystore -noprompt \
```
# Take exiting PKCS12 trust store from the official library 
    -srcstoretype PKCS12 \
    -deststorepass notasecret \
# Import the certificate into BCFKS keystore
