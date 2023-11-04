package kg.adapter.blevota.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/systems")
    public String getSystemData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://blue-water.asia/api/systems/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
        headers.set("Accept", "text/plain, */*; q=0.01");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("DNT", "1");
        headers.set("Connection", "keep-alive");
        headers.set("Referer", "https://blue-water.asia/?page=system-page-14");
        List<String> cookies = new ArrayList<>();
        cookies.add("lcid=1049");
        cookies.add("authtoken=17b17e4105b944ac891895dcd89aa55e9152f3b76e9d711d703f31d14875bd9b22c321ec7676e5b8fa97b4b21296dfe9da9da8ca0ea09dcdfaa3f068eaeb78b4");
        headers.put("Cookie", cookies);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

        try {
            byte[] compressedData = response.getBody();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            InputStreamReader reader = new InputStreamReader(gis);
            BufferedReader in = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = content.toString();

            return jsonData;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных";
        }
    }


    @GetMapping("/sensors")
    public String getSensorData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://blue-water.asia/api/sensors/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
        headers.set("Accept", "text/plain, */*; q=0.01");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("DNT", "1");
        headers.set("Connection", "keep-alive");
        List<String> cookies = new ArrayList<>();
        cookies.add("lcid=1049");
        cookies.add("authtoken=17b17e4105b944ac891895dcd89aa55e9152f3b76e9d711d703f31d14875bd9b22c321ec7676e5b8fa97b4b21296dfe9da9da8ca0ea09dcdfaa3f068eaeb78b4");
        headers.put("Cookie", cookies);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
        try {
            byte[] compressedData = response.getBody();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            InputStreamReader reader = new InputStreamReader(gis);
            BufferedReader in = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            String jsonData = content.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            if (jsonNode.isArray()) {
                for (JsonNode sensorNode : jsonNode) {
                    if (sensorNode.isObject()) {
                        ObjectNode sensorObject = (ObjectNode) sensorNode;

                        long unixTimestamp = sensorObject.path("create_date").asLong();

                        LocalDate localDate = Instant.ofEpochSecond(unixTimestamp).atZone(ZoneId.systemDefault()).toLocalDate();
                        sensorObject.put("create_date", localDate.toString());
                    }
                }
            }
            String updatedJsonData = objectMapper.writeValueAsString(jsonNode);
            return updatedJsonData;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных";
        }
    }

    @GetMapping("/hydroposts")
    public String getHydropostData() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://blue-water.asia/api/hydroposts/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
        headers.set("Accept", "text/plain, */*; q=0.01");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("DNT", "1");
        headers.set("Connection", "keep-alive");
        List<String> cookies = new ArrayList<>();
        cookies.add("lcid=1049");
        cookies.add("authtoken=17b17e4105b944ac891895dcd89aa55e9152f3b76e9d711d703f31d14875bd9b22c321ec7676e5b8fa97b4b21296dfe9da9da8ca0ea09dcdfaa3f068eaeb78b4");
        headers.put("Cookie", cookies);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
        try {
            byte[] compressedData = response.getBody();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            InputStreamReader reader = new InputStreamReader(gis);
            BufferedReader in = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = content.toString();

            return jsonData;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных";
        }
    }

    @GetMapping("/updateData")
    public List<Map<String, Object>> updateData(@RequestBody String jsonData, @RequestParam Long id) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> data = new ArrayList<>();

        try {
            List<Map<String, Object>> jsonDataList = objectMapper.readValue(jsonData, List.class);

            for (Map<String, Object> entry : jsonDataList) {
                Long utc = Long.valueOf(entry.get("utc").toString());
                entry.put("utc", convertUnixToDate(utc));
                entry.put("system_id", id);
                data.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }

    private String convertUnixToDate(Long timestamp) {
        Date date = new Date(timestamp * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }


    @GetMapping("/hydroposts/hourly")
    public String getHydropostHourlyData(@RequestParam(name = "sys_id") long sys_id,
                                         @RequestParam(name = "start_date") long start_date,
                                         @RequestParam(name = "end_date") long end_date) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://blue-water.asia/api/hydroposts/hourly?sys_id=" + sys_id + "&start_date=" + start_date + "&end_date=" + end_date;
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
        headers.set("Accept", "text/plain, */*; q=0.01");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("DNT", "1");
        headers.set("Connection", "keep-alive");
        List<String> cookies = new ArrayList<>();
        cookies.add("lcid=1049");
        cookies.add("authtoken=17b17e4105b944ac891895dcd89aa55e9152f3b76e9d711d703f31d14875bd9b22c321ec7676e5b8fa97b4b21296dfe9da9da8ca0ea09dcdfaa3f068eaeb78b4");
        headers.put("Cookie", cookies);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
        try {
            byte[] compressedData = response.getBody();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            InputStreamReader reader = new InputStreamReader(gis);
            BufferedReader in = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = content.toString();

            return jsonData;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных";
        }
    }


    @GetMapping("/system/hourly")
    public String getSystemHourlyData(@RequestParam(name = "id") long id,
                                         @RequestParam(name = "start_date") long start_date,
                                         @RequestParam(name = "end_date") long end_date) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://blue-water.asia/api/system/hourly?id=" + id + "&start_date=" + start_date + "&end_date=" + end_date;
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
        headers.set("Accept", "text/plain, */*; q=0.01");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("DNT", "1");
        headers.set("Connection", "keep-alive");
        List<String> cookies = new ArrayList<>();
        cookies.add("lcid=1049");
        cookies.add("authtoken=17b17e4105b944ac891895dcd89aa55e9152f3b76e9d711d703f31d14875bd9b22c321ec7676e5b8fa97b4b21296dfe9da9da8ca0ea09dcdfaa3f068eaeb78b4");
        headers.put("Cookie", cookies);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
        try {
            byte[] compressedData = response.getBody();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            InputStreamReader reader = new InputStreamReader(gis);
            BufferedReader in = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = content.toString();

            return jsonData;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении данных";
        }
    }

}





