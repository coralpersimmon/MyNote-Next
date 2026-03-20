package com.coralpersimmon.mynotenext.service.impl;

import com.coralpersimmon.mynotenext.dao.NoteRepository;
import com.coralpersimmon.mynotenext.dto.NoteRequest;
import com.coralpersimmon.mynotenext.model.Note;
import com.coralpersimmon.mynotenext.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note getNoteById(Integer noteId) {
        return noteRepository.findById(noteId).get();
    }

    @Override
    public Integer createNote(NoteRequest noteRequest) {
        Note note = new Note();
        note.setUserId(noteRequest.getUserId());
        note.setCategory(noteRequest.getCategory());
        note.setTitle(noteRequest.getTitle());
        note.setContent(noteRequest.getContent());

        Note savedNote = noteRepository.save(note);
        return savedNote.getId();
    }
}
