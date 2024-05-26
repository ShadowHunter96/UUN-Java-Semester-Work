package com.example.SubjectApi2.servise;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 10:15
 */



import com.example.SubjectApi2.subject.SubjectDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AresService {

    private static final Logger logger = LoggerFactory.getLogger(AresService.class);

    @Value("${ares.api.url}")
    private String aresApiUrl;

    public SubjectDto searchEconomicSubject(String ico) {
        String url = aresApiUrl;

        String requestJson = String.format("{\"ico\":[\"%s\"],\"start\":0,\"pocet\":10,\"razeni\":[]}", ico);

        try {
            HttpResponse<String> response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "insomnium/0.2.3-a")
                    .body(requestJson)
                    .asString();

            return parseResponse(response.getBody());
        } catch (Exception e) {
            logger.error("Error calling ARES API", e);
            throw new RuntimeException("Failed to retrieve data from ARES API", e);
        }
    }

    private SubjectDto parseResponse(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode ekonomickeSubjektyNode = rootNode.path("ekonomickeSubjekty");

            if (ekonomickeSubjektyNode.isMissingNode() || !ekonomickeSubjektyNode.isArray() || ekonomickeSubjektyNode.size() == 0) {
                throw new RuntimeException("No economic subjects found in the response");
            }

            JsonNode subjectNode = ekonomickeSubjektyNode.get(0);

            SubjectDto subjectDTO = new SubjectDto();
            subjectDTO.setIco(subjectNode.path("ico").asText());
            subjectDTO.setObchodniJmeno(subjectNode.path("obchodniJmeno").asText());

            return subjectDTO;
        } catch (Exception e) {
            logger.error("Error parsing ARES API response", e);
            throw new RuntimeException("Failed to parse data from ARES API", e);
        }
    }
}
