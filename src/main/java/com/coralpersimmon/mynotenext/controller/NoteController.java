package com.coralpersimmon.mynotenext.controller;

import com.coralpersimmon.mynotenext.dto.NoteRequest;
import com.coralpersimmon.mynotenext.model.Note;
import com.coralpersimmon.mynotenext.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PatchMapping("/notes")
    public ResponseEntity<Note> createNote(@RequestBody @Valid NoteRequest noteRequest) {
        Integer noteId = noteService.createNote(noteRequest);

        Note note = noteService.getNoteById(noteId);
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }
}
