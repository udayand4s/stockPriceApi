package org.example;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class App{
    public static void main(String[] args) {
        
        Queue<String> priceLog= new LinkedList<>();
        
        Timer timer= new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run(){
                try {
                    Stock dowJones = YahooFinance.get("^DJI");
                    BigDecimal price = dowJones.getQuote().getPrice();
    
                    String log=new Date()+ " - Dow Jones: "+ price;
                    priceLog.add(log);
                    System.out.println(log);
                } catch (IOException e) {
                    System.out.println("Error fetching stock price: " + e.getMessage());
                }
            }
        }, 0, 25000);
    }
}