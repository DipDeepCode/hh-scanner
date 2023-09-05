package ru.ddc.headhunter.telegrambot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ACTIVE_CHAT")
public class ActiveChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;

    public ActiveChat() {
    }

    public ActiveChat(Long chatId) {
        this.chatId = chatId;
    }
}
