package com.coralpersimmon.mynotenext.service;

import com.coralpersimmon.mynotenext.dao.NoteRepository;
import com.coralpersimmon.mynotenext.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note save(Note note) {
        return noteRepository.save(note);
    }
}
