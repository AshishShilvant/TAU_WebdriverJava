package utils;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockExample {

    WireMockServer wireMockServer = new WireMockServer(8080);

    public void setUpWireMock() {
        wireMockServer.start();

        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/customer/123"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"id\": \"123\", \"name\": \"Ashish\" }")));

    }

    public void stopWireMock() {
        wireMockServer.stop();
    }
}
