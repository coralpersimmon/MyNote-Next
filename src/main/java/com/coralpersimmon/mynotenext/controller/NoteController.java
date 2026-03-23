package com.coralpersimmon.mynotenext.controller;

import com.coralpersimmon.mynotenext.constant.NoteCategory;
import com.coralpersimmon.mynotenext.dto.NoteQueryParams;
import com.coralpersimmon.mynotenext.dto.NoteRequest;
import com.coralpersimmon.mynotenext.model.Note;
import com.coralpersimmon.mynotenext.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getNotes(@RequestParam(required = false)NoteCategory category,
                                               @RequestParam(required = false)String search) {
        NoteQueryParams noteQueryParams = new NoteQueryParams();
        noteQueryParams.setCategory(category);
        noteQueryParams.setSearch(search);

        List<Note> noteList = noteService.getNotes(noteQueryParams);
        return ResponseEntity.status(HttpStatus.OK).body(noteList);
    }

    @GetMapping("/notes/{noteId}")
    public ResponseEntity<Note> getNoteById(@PathVariable Integer noteId) {
        Note note = noteService.getNoteById(noteId);

        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> createNote(@RequestBody @Valid NoteRequest noteRequest) {
        Integer noteId = noteService.createNote(noteRequest);

        Note note = noteService.getNoteById(noteId);
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }

    @PutMapping("/notes/{noteId}")
    public ResponseEntity<Note> updateNote(@PathVariable Integer noteId, @RequestBody @Valid NoteRequest noteRequest) {
        Note note = noteService.getNoteById(noteId);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }

        noteService.updateNote(noteId, noteRequest);
        return ResponseEntity.ok(noteService.getNoteById(noteId));
    }

    @DeleteMapping("/notes/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable Integer noteId) {
        noteService.deleteNoteById(noteId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
