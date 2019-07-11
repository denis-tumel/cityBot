package com.javainuse.bot;

import com.javainuse.model.CityGuide;
import com.javainuse.service.CityGuideService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    private final CityGuideService service;

    public Bot(CityGuideService cityGuideService){
        this.service = cityGuideService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage(); // Это нам понадобится
        String txt = msg.getText();
        if (txt.equals("/start")) {
            sendMsg(msg, "Hello, i'm simple bot!");
        }else if(service.existsByCity(txt)){
            CityGuide cityGuide = service.getCityGuideByCity(txt);
            sendMsg(msg, cityGuide.getDescription());
        }else{
            sendMsg(msg, "извините пока информация об этом городе не добавлена...");
        }
    }

    private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(text);
        try {
            execute(s);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "@myTestingCityBot";
    }

    @Override
    public String getBotToken() {
        return "887891313:AAGksyrNp1Zd_3ApFgUejQpeKEd9PKlc8AI";
    }
}