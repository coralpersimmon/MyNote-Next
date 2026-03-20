package com.coralpersimmon.mynotenext.controller;

import com.coralpersimmon.mynotenext.dto.NoteRequest;
import com.coralpersimmon.mynotenext.model.Note;
import com.coralpersimmon.mynotenext.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/notes/{noteid}")
    public ResponseEntity<Note> updateNote(@PathVariable Integer noteid,
                                           @RequestBody @Valid NoteRequest noteRequest) {
        Note note = noteService.getNoteById(noteid);
        if(note == null){
            return ResponseEntity.notFound().build();
        }

        noteService.updateNote(noteid,noteRequest);
        return ResponseEntity.ok(noteService.getNoteById(noteid));
    }
}
