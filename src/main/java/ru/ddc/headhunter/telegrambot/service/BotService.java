package ru.ddc.headhunter.telegrambot.service;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.ddc.headhunter.telegrambot.entity.ActiveChat;
import ru.ddc.headhunter.telegrambot.repository.ActiveChatRepository;

import java.util.Optional;

@Slf4j
@Service
public class BotService extends TelegramLongPollingBot {

    private static final String SUBSCRIBE = "/subscribe";
    private static final String UNSUBSCRIBE = "/unsubscribe";
    private final String botName;
    private final ActiveChatRepository activeChatRepository;

    public BotService(@Value("${telegram.bot-token}") String botToken,
                      @Value("${telegram.bot-name}") String botName,
                      ActiveChatRepository activeChatRepository) {
        super(botToken);
        this.botName = botName;
        this.activeChatRepository = activeChatRepository;
    }

    @Override
    public void onUpdateReceived(@NotNull Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            SendMessage response = new SendMessage();
            response.setChatId(chatId);
            if (SUBSCRIBE.equalsIgnoreCase(message.getText())) {
                if (activeChatRepository.findByChatId(chatId).isPresent()) {
                    response.setText("Вы уже подписаны на рассылку");
                } else {
                    activeChatRepository.save(new ActiveChat(chatId));
                    response.setText("Вы подписались на рассылку");
                }
            } else if (UNSUBSCRIBE.equalsIgnoreCase(message.getText())) {
                Optional<ActiveChat> activeChat = activeChatRepository.findByChatId(chatId);
                if (activeChat.isPresent()) {
                    activeChatRepository.deleteById(activeChat.get().getId());
                    response.setText("Вы отписались от рассылки");
                } else {
                    response.setText("Вы уже отписаны от рассылки");
                }
            } else {
                response.setText("Команда не распознана");
            }
            try {
                execute(response);
            } catch (TelegramApiException ignore) {
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    public void sendHtmlNotification(String notification) {
        activeChatRepository.findAll().forEach(activeChat -> {
            try {
                SendMessage htmlMessage = getHtmlMessage(notification, activeChat);
                execute(htmlMessage);
            } catch (TelegramApiException e) {
                log.info("Не удалось отправить сообщение", e);
            }
        });
    }

    public void sendPlainNotification(String notification) {
        activeChatRepository.findAll().forEach(activeChat -> {
            try {
                SendMessage plainMessage = getPlainMessage(notification, activeChat);
                execute(plainMessage);
            } catch (TelegramApiException e) {
                log.info("Не удалось отправить сообщение", e);
            }
        });
    }

    private @NotNull SendMessage getHtmlMessage(String notification, ActiveChat activeChat) {
        SendMessage sendMessage = getPlainMessage(notification, activeChat);
        sendMessage.setParseMode(ParseMode.HTML);
        return sendMessage;
    }

    private @NotNull SendMessage getPlainMessage(String notification, ActiveChat activeChat) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(activeChat.getChatId());
        sendMessage.setText(notification);
        return sendMessage;
    }
}
