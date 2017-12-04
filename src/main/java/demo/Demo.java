package demo;


import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class Demo {
    private static int port = 2345;
    private static String serverAddress = "localhost";
    private static WireMockServer wireMockServer = new WireMockServer(options().port(port));

    //curl localhost:2345/api/demo1
    public static void stubForGet() {
        stubFor(get(urlMatching("/api/demo1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withStatusMessage("Everything was just fine!")
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Stub For demo1 (Java)")));
    }

    //curl -X POST localhost:2345/api/demo2
    public static void stubForPost() {
        stubFor(post(urlMatching("/api/demo2"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Stub For Demo2 (Java)")));
    }

    //curl -X POST --data apple localhost:2345/api/demo3
    public static void stubForPostWithReq() {
        stubFor(post(urlMatching("/api/demo3"))
                .withRequestBody(equalTo("apple"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Stub For Demo3 (Java)")));
    }

    public static void main(String[] args){
        configureFor(serverAddress, port);
        wireMockServer.start();
        stubForGet();
        stubForPost();
        stubForPostWithReq();

        System.out.print("===== Mock Service started =====");
    }
}
