package Enciclopedia.Marver.encilopediaMarvel.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Map;

@RestController
@RequestMapping("/encyclopedia/characters")
@CrossOrigin(origins = "http://localhost:5500")
public class ControllerPersonaje {

    private final String PUBLIC_KEY = "17464ecd5ccd0fc112ce619655d1e4e0";
    private final String PRIVATE_KEY = "7797ca893a10bdde1fd7a1f7b5b6ba0938252538";

    @GetMapping("/{name}")
    public ResponseEntity<?> getCharacter(@PathVariable String name){
        try{
            String ts = String.valueOf(System.currentTimeMillis());
            String hash = generateHash(ts, PRIVATE_KEY, PUBLIC_KEY);
            String url ="https://gateway.marvel.com/v1/public/characters?name=" + name +
                    "&ts=" + ts + "&apikey=" + PUBLIC_KEY + "&hash=" + hash;

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

            return ResponseEntity.ok(response.getBody());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    private String generateHash(String ts, String privateKey, String publicKey) throws Exception{
        String value = ts + privateKey + publicKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(value.getBytes());
        BigInteger no = new BigInteger(1, hash);
        StringBuilder hashText = new StringBuilder(no.toString(16));
        while (hashText.length() < 32) {
            hashText.insert(0, "0");
        }
        return hashText.toString();
    }



}
