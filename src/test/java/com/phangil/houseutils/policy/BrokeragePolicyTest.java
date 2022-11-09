package com.phangil.houseutils.policy;

import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

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


    @Test
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
}
