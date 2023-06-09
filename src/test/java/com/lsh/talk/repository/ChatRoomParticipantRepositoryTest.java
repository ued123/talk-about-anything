package com.lsh.talk.repository;

import com.lsh.talk.DbIntegrationTest;
import com.lsh.talk.domain.ChatRoomParticipant;
import com.lsh.talk.domain.ChatUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatRoomParticipantRepositoryTest extends DbIntegrationTest {

    @Autowired
    private ChatUserRepository chatUserRepository;

    @Autowired
    private ChatRoomParticipantRepository chatRoomParticipantRepository;

    @Test
    @DisplayName("유저정보를 통하여 유저정보에 해당하는 채팅방 목록 조회")
    void findAllByChatUser() {
        ChatUser user = chatUserRepository.findByName("seongheon").orElseThrow();
        List<ChatRoomParticipant> chatRoomParticipants = chatRoomParticipantRepository.findAllByChatUser(user);

        assertNotNull(chatRoomParticipants);
    }

    @Test
    @DisplayName("채팅방 id에 해당하는 전체목록조회")
    void findAllByChatRoom() {
        ChatUser user = chatUserRepository.findByName("seongheon").orElseThrow();
        List<ChatRoomParticipant> chatRooms = chatRoomParticipantRepository.findAllByChatUser(user);
        List<ChatRoomParticipant> chatRoomParticipants = chatRoomParticipantRepository.findAllByChatRoom(chatRooms.get(0).getChatRoom());

        assertNotNull(chatRoomParticipants);
    }
}