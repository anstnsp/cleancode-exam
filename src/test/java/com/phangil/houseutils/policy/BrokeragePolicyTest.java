package com.phangil.houseutils.policy;

import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.asm.TypeReference;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phangil.houseutils.constants.Role;
import com.phangil.houseutils.exception.Child;
import com.phangil.houseutils.exception.Parent;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class BrokeragePolicyTest {
    PurchaseBrokeragePolicy purchaseBrokeragePolicy;
    RentBrokeragePolicy rentBrokeragePolicy;

    @BeforeEach
    public void setup() {
        purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
        rentBrokeragePolicy = new RentBrokeragePolicy();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


    @org.junit.Test
    public void sdfw() {
        System.out.println(test());
    }
    public int test() {

        int a = 0;

        try {
            a = 5;
            throw new RuntimeException();

        } catch(Exception e) {
            e.printStackTrace();
            a = 7;
            // return a;
        } finally {
            a = 10;
            return a;
        }

        // return 10000;
    }
    @Test
    public void nulltest() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("dk", new ArrayList<>());
        map.put("dk2", null);
        List<String> test = (List<String>)map.get("dk");
        List<String> test2 = (List<String>)map.get("dk2");
        System.out.println(test2 == null);
        System.out.println(test2);
        System.out.println();
        Collections.singletonList("Ff");
    }
    @Test
    public void fasdf() {
        Date d1 = new Date();
        Date d2 = new Date(System.currentTimeMillis()+60000);
        System.out.println(d1);
        System.out.println(d2);
    }
    public int bbb(int q) {
        int a =q;
        try {
            a = 0;
            return a;
        } catch(Exception e) {
            a = 1;
            return a;
        } finally {
            a = 2;
            return a;
        }
    }

    public String aaa(String q) {
        String a = "";
        try {
            a = "aa";
            return a;
        } catch(Exception e) {
            a = "bb";
            return a;
        } finally {
            a = "cc";
            return a;
        }
    }
    @Test
    public void asfd() {
        Set<String> set =new HashSet<>();
        set.add("aa_!");
        set.add("bb_@");
        set.add("cc_3");
        set.add("dd_4");
        set.add("aee");
        set.add("ff");
        for (String obj : set) {
            System.out.println(obj);
        }
        Set<Integer> set2 = new TreeSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(2);
        set2.add(11);
        set2.add(423);
        for (int obj : set2) {
            System.out.println(obj);
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String key = "ID_" + i;
            Integer value = i;
            map.put(key, value);
        }

        map.forEach((key, value) -> {
            System.out.println("key: " + key + ", value: " + value);
        });

        String[] arr = new String[5];
    }


    @Test
    void nullEqulasSomething() {
        try {
            Gov gov = new Gov("C");
            if(gov.getC().equals(null)) {
                System.out.println("Gg");
            }
            if(gov.c.equals(null)) {
                System.out.println("null");
            } else {
                System.out.println("not null");
            }
            if("ff".equals(null)) {
                System.out.println("not null");
            }
        } catch (Exception e) {
            System.out.println("에러발생");
        }

    }

    @Test
    public void testPurchaseBrokeragePolicy() {
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(100_000_000L), 500_000L);
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(800_000_000L), 4_000_000L);
        Assertions.assertEquals(
                purchaseBrokeragePolicy.calculate(1_000_000_000L), 9_000_000L);
    }

    @Test
    public void testRentBrokeragePolicy() {
        Assertions.assertEquals(
                rentBrokeragePolicy.calculate(30_000_000L), 150_000L);
        Assertions.assertEquals(
                rentBrokeragePolicy.calculate(100_000_000L), 300_000L);
        Assertions.assertEquals(
                rentBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        Assertions.assertEquals(
                rentBrokeragePolicy.calculate(800_000_000L), 6_400_000L);
        Assertions.assertEquals(
                rentBrokeragePolicy.calculate(1_000_000_000L), 8_000_000L);
    }


    @Test
    public void stringJoinerTest() {
        List<String> 장군들 = Arrays.asList("a", "b", "c", "d", "e");

        String 오호대장군 = 장군들.stream().collect(Collectors.joining("-", "[", "]"));

        System.out.println(오호대장군);
    }

    @Test
    public void asdfsadf() {
        Gov aa = new Gov(1,3);
        if (aa.getA() == 1 || aa.getB() == 3) {
            System.out.println("성고오오오옹");
        }
    }

    @Test
    public void fsfef2f() {
        System.out.println(600/60 + " 분");
        System.out.println(1800/60 + " 분");
        System.out.println(3600/60 + "분");
        System.out.println(10800/60 + "분");
    }

    @Test
    public void uri() {
        String uriString = "https://gaga-kim.tistory.com:9908/entry/Spring-Boot-Swagger%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-API-%EB%AC%B8%EC%84%9C-%EC%9E%90%EB%8F%99%ED%99%94";
            URI uri = URI.create(uriString);
            try {
                uri = new URI(uri.getScheme(), uri.getHost(), uri.getPath(), uri.getFragment());
            } catch (Exception e) {

                System.out.println(uriString);
            }
        System.out.println(uri.toString());
    }

    @Test
    public void asdfasdfwef() {
        Long defaultMbrNo = null;
        String defaultMbrNoString = (defaultMbrNo == 0L | defaultMbrNo == null) ? "" : String.valueOf(defaultMbrNo);
        System.out.println(defaultMbrNo);
    }

    @Test
    public void betaAuthorize22() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap();

        ResponseEntity<String> res =restTemplate.getForEntity("https://beta-auth.ncloud.com/loginForm", String.class);
        System.out.println(res);
    }


    @Test
    public void betaAuthorize2233() {
       try {
           throw new RuntimeException("catch");
       } catch (Exception e) {
           System.out.println(e.getMessage());
           System.out.println("@@@@@");
       }
        System.out.println("end");
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void urltest() {
        System.out.println(isUrl("http://aadadad"));
        System.out.println(isUrl("https://google.com"));
        System.out.println(isUrl("https://www.google.com"));
        System.out.println(isUrl("http://localhost:8080"));
        System.out.println(isUrl("https://localhost:8080?param1=val"));
        System.out.println(isUrl("http://localhost:8080?param1=val?param2=val"));
        System.out.println(isUrl("https://naver.com"));
        System.out.println(isUrl("https://naver.com?DynamicParam1=val"));
    }

    @Test
    void asefesaf() {
        Parent parent = Child.builder().parent("parent").child("child").build();

        System.out.println("parent:"+parent );
        Child child = null;
        if (parent instanceof Child) {
            child = (Child)parent;
        }
        System.out.println(child.getChild());
        System.out.println(child.getParent());
        System.out.println("child:"+child);
    }
    //"(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:'\".,<>?«»“”‘’]))";
    //"^((http[s]?):\\/\\/)?(www\\.)?[a-zA-Z0-9]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?$";
    public static boolean isUrl(String text) {
//        Pattern p = Pattern.compile("^((http|https)://)?([a-z0-9]+[.])?[a-z0-9]+[.][a-z]{2,3}([.][a-z]{2})?(/.*)?$");
        Pattern p = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$");
        Matcher m = p.matcher(text);
        if  (m.matches()) return true;
        URL u = null;
        try {
            u = new URL(text);
        } catch (MalformedURLException e) {
            return false;
        }
        try {
            u.toURI();
        } catch (URISyntaxException e) {
            return false;
        }
        return true;
    }

    @Test
    void fsefsf() {
        List<String> aa = new ArrayList<>();
        aa.add("aa");
            aa.add("bb");
        System.out.println(aa);
        String str = null;
        apapaaa(str);
        System.out.println("Str:"+str);
    }

    @Test
    void enumEqual() {
        if (Status.ACTIVE.equals(Status.ACTIVE)) {
            System.out.println("같다");
        }
        if (Status.ACTIVE == Status.ACTIVE) {
            System.out.println("같다22");
        }

    }

    private void apapaaa(String str) {
        str = "test";
    }

    public class Gov {
        public Gov(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public Gov(String c) {
            this.c = c;
        }
        private int a;
        private int b;
        private String c;

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
        public String getC() { return c; }
    }

    public enum Status {
        ACTIVE,
        DELETED
    }
}



