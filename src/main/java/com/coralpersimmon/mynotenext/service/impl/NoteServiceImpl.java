package com.coralpersimmon.mynotenext.service.impl;

import com.coralpersimmon.mynotenext.dao.NoteRepository;
import com.coralpersimmon.mynotenext.dto.NoteRequest;
import com.coralpersimmon.mynotenext.model.Note;
import com.coralpersimmon.mynotenext.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Integer noteId) {
        return noteRepository.findById(noteId).orElse(null);
    }

    @Override
    public Integer createNote(NoteRequest noteRequest) {
        Note note = new Note();

        NoteFields(note, noteRequest);

        Note savedNote = noteRepository.save(note);
        return savedNote.getId();
    }

    @Override
    public void updateNote(Integer noteId, NoteRequest noteRequest) {
        Note note = noteRepository.findById(noteId).orElse(null);

        if (note == null) {
            return;
        }

        NoteFields(note, noteRequest);
        noteRepository.save(note);
    }

    @Override
    public void deleteNoteById(Integer noteId) {
        noteRepository.deleteById(noteId);
    }

    private void NoteFields(Note note, NoteRequest noteRequest) {
        note.setCategory(noteRequest.getCategory());
        note.setTitle(noteRequest.getTitle());
        note.setContent(noteRequest.getContent());
    }
}
