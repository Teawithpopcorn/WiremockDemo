package hello;


import com.github.tomakehurst.wiremock.WireMockServer;

public class MyDemo {
    private static WireMockServer wireMockService = new WireMockServer(2345);   //port is 8080 by default

    public static void Demo1(){

    }


    public static void main(String[] args){
        wireMockService.start();
        Demo1();

        System.out.print("===== Mock Service started =====");
    }
}