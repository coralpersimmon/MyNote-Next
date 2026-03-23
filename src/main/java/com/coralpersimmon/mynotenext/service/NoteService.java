package com.coralpersimmon.mynotenext.service;

import com.coralpersimmon.mynotenext.constant.NoteCategory;
import com.coralpersimmon.mynotenext.dto.NoteRequest;
import com.coralpersimmon.mynotenext.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getNotes(NoteCategory noteCategory,String search);

    Note getNoteById(Integer noteId);

    Integer createNote(NoteRequest noteRequest);

    void updateNote(Integer noteId, NoteRequest noteRequest);

    void deleteNoteById(Integer noteId);
}
