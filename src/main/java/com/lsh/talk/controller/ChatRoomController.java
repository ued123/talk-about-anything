package com.lsh.talk.controller;

import com.lsh.talk.domain.ChatRoom;
import com.lsh.talk.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/chatRoom")
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("/{roomId}")
    public String getChatRoom(@PathVariable("roomId") UUID roomId, Model model) {
        ChatRoom chatRoom = chatRoomService.getChatRoomById(roomId);
        model.addAttribute("chatRoom", chatRoom);
        return "chatRoom/chatRoom";
    }
}
