package net.sajtoskifli.chaosstack.blockchain.client;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.sajtoskifli.chaosstack.blockchain.request.SubmitRequest;
import net.sajtoskifli.chaosstack.blockchain.response.BlockChainResponse;

/**
 * BlockChainClient
 */
@Component
public class BlockChainClient {

    private static final Logger LOG = LoggerFactory.getLogger(BlockChainClient.class);

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${teamName}")
    private String teamName;

    private HttpClient client;

    private Gson gson;

    @PostConstruct
    public void _init() {
        client = HttpClientBuilder.create().build();
        gson = new Gson();
    }

    public String getFirstOffender() {
        return null;
    }

    public BlockChainResponse getSetOfBlocks() {
        HttpGet request = new HttpGet(baseUrl + "/entry_challenge/" + teamName);
        try {
            HttpResponse response = client.execute(request);
            String responseString = EntityUtils.toString(response.getEntity());
            BlockChainResponse blocks = gson.fromJson(responseString, BlockChainResponse.class);
            LOG.debug("Blocks collected: {}...{}", responseString.substring(0, 50),
                    responseString.substring(responseString.length() - 20, responseString.length()));
            return blocks;
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    public String submitSolution(String correctedHash) {
        HttpPost request = new HttpPost(baseUrl + "/entry_challenge/" + teamName);
        request.setHeader("Content-Type", "application/json");
        SubmitRequest submitRequest = new SubmitRequest();
        submitRequest.setCorrectedHash(correctedHash);
        try {
            String requestBodyJson = gson.toJson(submitRequest);
            request.setEntity(new StringEntity(requestBodyJson));
            LOG.debug("Call(POST) url: {}, body: {}", request.getURI(), requestBodyJson);
            HttpResponse response = client.execute(request);
            String responseStr = EntityUtils.toString(response.getEntity());
            LOG.debug("Response code:{}, message: {}", response.getStatusLine().getStatusCode(), responseStr);
            return responseStr;
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

}