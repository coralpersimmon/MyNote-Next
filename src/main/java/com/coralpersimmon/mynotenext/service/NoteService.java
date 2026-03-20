package com.coralpersimmon.mynotenext.service;

import com.coralpersimmon.mynotenext.dto.NoteRequest;
import com.coralpersimmon.mynotenext.model.Note;

public interface NoteService
{
    Note getNoteById(Integer noteId);
    Integer createNote(NoteRequest noteRequest);
}
