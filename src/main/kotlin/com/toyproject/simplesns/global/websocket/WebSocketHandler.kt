package com.toyproject.simplesns.global.websocket

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class WebSocketHandler : TextWebSocketHandler() {

    private val log = LoggerFactory.getLogger(this::class.simpleName)
    private val list = ArrayList<WebSocketSession>()

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val payload = message.payload
        log.info(payload)
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        list.add(session)
        log.info("$session 클라이언트 접속")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        log.info("$session 클라이언트 접속 해제")
        list.remove(session)
    }
}