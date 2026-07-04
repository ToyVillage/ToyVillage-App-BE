package com.example.toyvillageappbe.domain.notice.service;

import com.example.toyvillageappbe.domain.notice.domain.Notice;
import com.example.toyvillageappbe.domain.notice.domain.repository.NoticeRepository;
import com.example.toyvillageappbe.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoticeDeleteService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public void execute(Long noticeId) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new NoticeNotFoundException(noticeId));
        noticeRepository.delete(notice);
    }
}
